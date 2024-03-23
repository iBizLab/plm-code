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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.ProjectMemberService;
import cn.ibizlab.plm.core.projmgmt.mapper.ProjectMemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.DayCapacity;

/**
 * 实体[项目成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectMemberService extends ServiceImpl<ProjectMemberMapper,ProjectMember> implements ProjectMemberService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    protected int batchSize = 500;

    public ProjectMember get(ProjectMember et) {
        ProjectMember rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PROJECT_MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<ProjectMember> getByEntities(List<ProjectMember> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(ProjectMember et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
            Project project = et.getProject();
            if(project == null) {
                project = projectService.getById(et.getProjectId());
                et.setProject(project);
            }
            if(!ObjectUtils.isEmpty(project)) {
                et.setProjectName(project.getName());
                et.setProjectIdentifier(project.getIdentifier());
                et.setProjectType(project.getType());
                et.setProjectId(project.getId());
            }
        }
    }

    public ProjectMember getDraft(ProjectMember et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(ProjectMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(ProjectMember et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<ProjectMember> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(ProjectMember et) {
        fillParentData(et);
        UpdateWrapper<ProjectMember> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<ProjectMember> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(ProjectMember et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<ProjectMember> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,ProjectMember> before = getByEntities(list).stream().collect(Collectors.toMap(ProjectMember::getId,e->e));
        List<ProjectMember> create = new ArrayList<>();
        List<ProjectMember> update = new ArrayList<>();
        list.forEach(sub->{
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
    public boolean remove(ProjectMember et) {
        if(!remove(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<ProjectMember> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<ProjectMember> searchCurProject(ProjectMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectMember> pages=baseMapper.searchCurProject(context.getPages(),context,context.getSelectCond());
        List<ProjectMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ProjectMember> listCurProject(ProjectMemberSearchContext context) {
        List<ProjectMember> list = baseMapper.listCurProject(context,context.getSelectCond());
        return list;
    }

    public Page<ProjectMember> searchDefault(ProjectMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProjectMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<ProjectMember> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<ProjectMember> listDefault(ProjectMemberSearchContext context) {
        List<ProjectMember> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<ProjectMember> findByProjectId(List<String> projectIds) {
        List<ProjectMember> list = baseMapper.findByProjectId(projectIds);
        return list;
    }
    public List<ProjectMember> findByUserId(List<String> userIds) {
        List<ProjectMember> list = baseMapper.findByUserId(userIds);
        return list;
    }
    public boolean removeByProjectId(String projectId) {
        return this.remove(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getProjectId,projectId));
    }

    public boolean resetByProjectId(String projectId) {
        return this.update(Wrappers.<ProjectMember>lambdaUpdate().eq(ProjectMember::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<ProjectMember> list) {
        if(list==null)
            return true;
        Map<String,ProjectMember> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(ProjectMember::getId,e->e));
        List<ProjectMember> update = new ArrayList<>();
        List<ProjectMember> create = new ArrayList<>();

        for(ProjectMember sub:list) {
            sub.setProjectId(project.getId());
            sub.setProject(project);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByUserId(String userId) {
        return this.remove(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getUserId,userId));
    }

    public boolean resetByUserId(String userId) {
        return this.update(Wrappers.<ProjectMember>lambdaUpdate().eq(ProjectMember::getUserId,userId));
    }

    public boolean saveByUser(User user,List<ProjectMember> list) {
        if(list==null)
            return true;
        Map<String,ProjectMember> before = findByUserId(user.getId()).stream().collect(Collectors.toMap(ProjectMember::getId,e->e));
        List<ProjectMember> update = new ArrayList<>();
        List<ProjectMember> create = new ArrayList<>();

        for(ProjectMember sub:list) {
            sub.setUserId(user.getId());
            sub.setUser(user);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
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
        return ProjectMemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return ProjectMember.class;
    }
}