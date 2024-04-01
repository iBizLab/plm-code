/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.mapper.ProjectMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.service.BoardService;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.service.EntryService;
import cn.ibizlab.plm.core.projmgmt.domain.Progress;
import cn.ibizlab.plm.core.projmgmt.service.ProgressService;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.service.ProjectMemberService;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.service.SwimlaneService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.service.FavoriteService;
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.service.WorkService;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.core.base.service.ReferencesIndexService;

/**
 * 实体[项目] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectService extends ServiceImpl<ProjectMapper,Project> implements ProjectService {

    @Autowired
    @Lazy
    protected BoardService boardService;

    @Autowired
    @Lazy
    protected EntryService entryService;

    @Autowired
    @Lazy
    protected ProgressService progressService;

    @Autowired
    @Lazy
    protected ProjectMemberService projectMemberService;

    @Autowired
    @Lazy
    protected ReleaseService releaseService;

    @Autowired
    @Lazy
    protected SprintService sprintService;

    @Autowired
    @Lazy
    protected SwimlaneService swimlaneService;

    @Autowired
    @Lazy
    protected TestPlanService testPlanService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    @Autowired
    @Lazy
    protected FavoriteService favoriteService;

    @Autowired
    @Lazy
    protected WorkService workService;

    @Autowired
    @Lazy
    protected ReferencesIndexService referencesIndexService;

    @Autowired
    @Lazy
    protected cn.ibizlab.plm.core.projmgmt.mapping.ProjectInheritMapping projectInheritMapping;

    protected int batchSize = 500;

    public Project get(Project et) {
        Project rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PROJECT.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [项目成员]
        getMembers(et);
        return et;
    }

    public List<Project> getByEntities(List<Project> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public Project getDraft(Project et) {
        return et;
    }

    public Integer checkKey(Project et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Project>lambdaQuery().eq(Project::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Project et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        projectMemberService.saveByProject(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Project> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }

    @Transactional
    public boolean update(Project et) {
        UpdateWrapper<Project> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        projectMemberService.saveByProject(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Project> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }

    @Override
    @Transactional
    public boolean save(Project et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Project> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Project> before = getByEntities(list).stream().collect(Collectors.toMap(Project::getId,e->e));
        List<Project> create = new ArrayList<>();
        List<Project> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId()))
                update.add(sub);
            else
                create.add(sub);
        });
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Project et) {
        if(!remove(Wrappers.<Project>lambdaQuery().eq(Project::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Project> entities) {
        for (Project et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<Project> searchAdmin(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listAdmin(ProjectSearchContext context) {
        List<Project> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchArchived(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listArchived(ProjectSearchContext context) {
        List<Project> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchChooseProject(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchChooseProject(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listChooseProject(ProjectSearchContext context) {
        List<Project> list = baseMapper.listChooseProject(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchCurrent(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchCurrent(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listCurrent(ProjectSearchContext context) {
        List<Project> list = baseMapper.listCurrent(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchDefault(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listDefault(ProjectSearchContext context) {
        List<Project> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchDeleted(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listDeleted(ProjectSearchContext context) {
        List<Project> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchFavorite(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listFavorite(ProjectSearchContext context) {
        List<Project> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchNormal(ProjectSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listNormal(ProjectSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        List<Project> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchReader(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listReader(ProjectSearchContext context) {
        List<Project> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchSameType(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchSameType(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listSameType(ProjectSearchContext context) {
        List<Project> list = baseMapper.listSameType(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchUnderProjectPortfolio(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchUnderProjectPortfolio(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listUnderProjectPortfolio(ProjectSearchContext context) {
        List<Project> list = baseMapper.listUnderProjectPortfolio(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchUser(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listUser(ProjectSearchContext context) {
        List<Project> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
    }

    public Page<Project> searchWorkProject(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchWorkProject(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Project> listWorkProject(ProjectSearchContext context) {
        List<Project> list = baseMapper.listWorkProject(context,context.getSelectCond());
        return list;
    }

    @Override
    public List<ProjectMember> getMembers(Project et) {
        List<ProjectMember> list = projectMemberService.findByProjectId(et.getId());
        et.setMembers(list);
        return list;
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.INSERT_ONE.getMethod())) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.UPDATE.getMethod())) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.DELETE.getMethod())) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

    @Override
    protected Class currentMapperClass() {
        return ProjectMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Project.class;
    }
}