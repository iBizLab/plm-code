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
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.projmgmt.mapper.SprintMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[迭代] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintService extends ServiceImpl<SprintMapper,Sprint> implements SprintService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected TestPlanService testPlanService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    @Autowired
    @Lazy
    protected SprintService sprintService;

    protected int batchSize = 500;

    public Sprint get(Sprint et) {
        Sprint rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SPRINT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Sprint> getByEntities(List<Sprint> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Sprint et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
            Project project = et.getProject();
            if(project == null) {
                project = projectService.getById(et.getProjectId());
                et.setProject(project);
            }
            if(!ObjectUtils.isEmpty(project)) {
                et.setProjectName(project.getName());
                et.setProjectId(project.getId());
            }
        }
        if(Entities.SPRINT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPid((String)et.getContextParentKey());
            Sprint sprint = et.getSprint();
            if(sprint == null) {
                sprint = sprintService.getById(et.getPid());
                et.setSprint(sprint);
            }
            if(!ObjectUtils.isEmpty(sprint)) {
                et.setPname(sprint.getName());
                et.setPid(sprint.getId());
            }
        }
    }

    public Sprint getDraft(Sprint et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Sprint et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Sprint>lambdaQuery().eq(Sprint::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Sprint et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Sprint> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Sprint et) {
        UpdateWrapper<Sprint> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Sprint> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Sprint et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Sprint> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Sprint> before = getByEntities(list).stream().collect(Collectors.toMap(Sprint::getId,e->e));
        List<Sprint> create = new ArrayList<>();
        List<Sprint> update = new ArrayList<>();
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
    public boolean remove(Sprint et) {
        String key = et.getId();
        workItemService.resetBySprintId(key);
        if(!remove(Wrappers.<Sprint>lambdaQuery().eq(Sprint::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Sprint> entities) {
        for (Sprint et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<Sprint> searchChooseMove(SprintSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Sprint> pages=baseMapper.searchChooseMove(context.getPages(),context,context.getSelectCond());
        List<Sprint> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Sprint> listChooseMove(SprintSearchContext context) {
        List<Sprint> list = baseMapper.listChooseMove(context,context.getSelectCond());
        return list;
    }

    public Page<Sprint> searchDefault(SprintSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Sprint> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Sprint> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Sprint> listDefault(SprintSearchContext context) {
        List<Sprint> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<Sprint> searchNotFinish(SprintSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Sprint> pages=baseMapper.searchNotFinish(context.getPages(),context,context.getSelectCond());
        List<Sprint> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Sprint> listNotFinish(SprintSearchContext context) {
        List<Sprint> list = baseMapper.listNotFinish(context,context.getSelectCond());
        return list;
    }

    public List<Sprint> findByProjectId(List<String> projectIds) {
        List<Sprint> list = baseMapper.findByProjectId(projectIds);
        return list;
    }
    public List<Sprint> findByPid(List<String> pids) {
        List<Sprint> list = baseMapper.findByPid(pids);
        return list;
    }
    public boolean removeByProjectId(String projectId) {
        List<String> ids = baseMapper.findByProjectId(Arrays.asList(projectId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.removeBatch(ids);
        else
            return true;
    }

    public boolean resetByProjectId(String projectId) {
        return this.update(Wrappers.<Sprint>lambdaUpdate().eq(Sprint::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<Sprint> list) {
        if(list==null)
            return true;
        Map<String,Sprint> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(Sprint::getId,e->e));
        List<Sprint> update = new ArrayList<>();
        List<Sprint> create = new ArrayList<>();

        for(Sprint sub:list) {
            sub.setProjectId(project.getId());
            sub.setProject(project);
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

    public boolean removeByPid(String pid) {
        List<String> ids = baseMapper.findByPid(Arrays.asList(pid)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.removeBatch(ids);
        else
            return true;
    }

    public boolean resetByPid(String pid) {
        return this.update(Wrappers.<Sprint>lambdaUpdate().eq(Sprint::getPid,pid));
    }

    public boolean saveBySprint(Sprint sprint,List<Sprint> list) {
        if(list==null)
            return true;
        Map<String,Sprint> before = findByPid(sprint.getId()).stream().collect(Collectors.toMap(Sprint::getId,e->e));
        List<Sprint> update = new ArrayList<>();
        List<Sprint> create = new ArrayList<>();

        for(Sprint sub:list) {
            sub.setPid(sprint.getId());
            sub.setSprint(sprint);
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
        return SprintMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Sprint.class;
    }
}