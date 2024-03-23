/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service.impl;

import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.projmgmt.domain.Version;
import cn.ibizlab.plm.core.projmgmt.filter.VersionSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.VersionService;
import cn.ibizlab.plm.core.projmgmt.mapper.VersionMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.VersionCategory;
import cn.ibizlab.plm.core.projmgmt.service.VersionCategoryService;
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.projmgmt.service.StageService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[版本（temp）] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractVersionService extends ServiceImpl<VersionMapper,Version> implements VersionService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected VersionCategoryService versionCategoryService;

    @Autowired
    @Lazy
    protected StageService stageService;

    @Autowired
    @Lazy
    protected TestPlanService testPlanService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    public Version get(Version et) {
        Version rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.VERSION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Version> getByEntities(List<Version> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Version et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
            Project project = et.getProject();
            if(project == null) {
                project = projectService.getById(et.getProjectId());
                et.setProject(project);
            }
            if(!ObjectUtils.isEmpty(project)) {
                et.setProjectId(project.getId());
                et.setProjectName(project.getName());
            }
        }
        if(Entities.VERSION_CATEGORY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setVersionCategoryId((String)et.getContextParentKey());
        }
    }

    public Version getDraft(Version et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Version et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Version>lambdaQuery().eq(Version::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Version et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Version> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Version et) {
        UpdateWrapper<Version> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Version> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Version et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Version> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Version> before = getByEntities(list).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> create = new ArrayList<>();
        List<Version> update = new ArrayList<>();
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
    public boolean remove(Version et) {
        String key = et.getId();
        workItemService.resetByVersionId(key);
        if(!remove(Wrappers.<Version>lambdaQuery().eq(Version::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Version> entities) {
        for (Version et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }

    public Page<Version> searchDefault(VersionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Version> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Version> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Version> listDefault(VersionSearchContext context) {
        List<Version> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<Version> findByProjectId(List<String> projectIds) {
        List<Version> list = baseMapper.findByProjectId(projectIds);
        return list;
    }
    public List<Version> findByVersionCategoryId(List<String> versionCategoryIds) {
        List<Version> list = baseMapper.findByVersionCategoryId(versionCategoryIds);
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
        return this.update(Wrappers.<Version>lambdaUpdate().eq(Version::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<Version> list) {
        if(list==null)
            return true;
        Map<String,Version> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> update = new ArrayList<>();
        List<Version> create = new ArrayList<>();

        for(Version sub:list) {
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

    public boolean removeByVersionCategoryId(String versionCategoryId) {
        List<String> ids = baseMapper.findByVersionCategoryId(Arrays.asList(versionCategoryId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.removeBatch(ids);
        else
            return true;
    }

    public boolean resetByVersionCategoryId(String versionCategoryId) {
        return this.update(Wrappers.<Version>lambdaUpdate().eq(Version::getVersionCategoryId,versionCategoryId));
    }

    public boolean saveByVersionCategory(VersionCategory versionCategory,List<Version> list) {
        if(list==null)
            return true;
        Map<String,Version> before = findByVersionCategoryId(versionCategory.getId()).stream().collect(Collectors.toMap(Version::getId,e->e));
        List<Version> update = new ArrayList<>();
        List<Version> create = new ArrayList<>();

        for(Version sub:list) {
            sub.setVersionCategoryId(versionCategory.getId());
            sub.setVersionCategory(versionCategory);
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
        return VersionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Version.class;
    }
}