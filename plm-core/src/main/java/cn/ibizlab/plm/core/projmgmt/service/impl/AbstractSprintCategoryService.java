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
import cn.ibizlab.plm.core.projmgmt.domain.SprintCategory;
import cn.ibizlab.plm.core.projmgmt.filter.SprintCategorySearchContext;
import cn.ibizlab.plm.core.projmgmt.service.SprintCategoryService;
import cn.ibizlab.plm.core.projmgmt.mapper.SprintCategoryMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.SprintSection;
import cn.ibizlab.plm.core.projmgmt.service.SprintSectionService;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;

/**
 * 实体[迭代类别] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintCategoryService extends ServiceImpl<SprintCategoryMapper,SprintCategory> implements SprintCategoryService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected SprintSectionService sprintSectionService;

    @Autowired
    @Lazy
    protected SprintService sprintService;

    protected int batchSize = 500;

    public SprintCategory get(SprintCategory et) {
        SprintCategory rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SPRINT_CATEGORY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<SprintCategory> getByEntities(List<SprintCategory> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(SprintCategory et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
        }
        if(Entities.SPRINT_SECTION.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSprintSectionId((String)et.getContextParentKey());
            SprintSection sprintSection = et.getSprintSection();
            if(sprintSection == null) {
                sprintSection = sprintSectionService.getById(et.getSprintSectionId());
                et.setSprintSection(sprintSection);
            }
            if(!ObjectUtils.isEmpty(sprintSection)) {
                et.setSectionName(sprintSection.getName());
                et.setSprintSectionId(sprintSection.getId());
            }
        }
    }

    public SprintCategory getDraft(SprintCategory et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(SprintCategory et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SprintCategory>lambdaQuery().eq(SprintCategory::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(SprintCategory et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<SprintCategory> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(SprintCategory et) {
        UpdateWrapper<SprintCategory> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<SprintCategory> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(SprintCategory et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<SprintCategory> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SprintCategory> before = getByEntities(list).stream().collect(Collectors.toMap(SprintCategory::getId,e->e));
        List<SprintCategory> create = new ArrayList<>();
        List<SprintCategory> update = new ArrayList<>();
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
    public boolean remove(SprintCategory et) {
        if(!remove(Wrappers.<SprintCategory>lambdaQuery().eq(SprintCategory::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<SprintCategory> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<SprintCategory> searchDefault(SprintCategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SprintCategory> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SprintCategory> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<SprintCategory> listDefault(SprintCategorySearchContext context) {
        List<SprintCategory> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<SprintCategory> findByProjectId(List<String> projectIds) {
        List<SprintCategory> list = baseMapper.findByProjectId(projectIds);
        return list;
    }
    public List<SprintCategory> findBySprintSectionId(List<String> sprintSectionIds) {
        List<SprintCategory> list = baseMapper.findBySprintSectionId(sprintSectionIds);
        return list;
    }
    public boolean removeByProjectId(String projectId) {
        return this.remove(Wrappers.<SprintCategory>lambdaQuery().eq(SprintCategory::getProjectId,projectId));
    }

    public boolean resetByProjectId(String projectId) {
        return this.update(Wrappers.<SprintCategory>lambdaUpdate().eq(SprintCategory::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<SprintCategory> list) {
        if(list==null)
            return true;
        Map<String,SprintCategory> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(SprintCategory::getId,e->e));
        List<SprintCategory> update = new ArrayList<>();
        List<SprintCategory> create = new ArrayList<>();

        for(SprintCategory sub:list) {
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

    public boolean removeBySprintSectionId(String sprintSectionId) {
        return this.remove(Wrappers.<SprintCategory>lambdaQuery().eq(SprintCategory::getSprintSectionId,sprintSectionId));
    }

    public boolean resetBySprintSectionId(String sprintSectionId) {
        return this.update(Wrappers.<SprintCategory>lambdaUpdate().eq(SprintCategory::getSprintSectionId,sprintSectionId));
    }

    public boolean saveBySprintSection(SprintSection sprintSection,List<SprintCategory> list) {
        if(list==null)
            return true;
        Map<String,SprintCategory> before = findBySprintSectionId(sprintSection.getId()).stream().collect(Collectors.toMap(SprintCategory::getId,e->e));
        List<SprintCategory> update = new ArrayList<>();
        List<SprintCategory> create = new ArrayList<>();

        for(SprintCategory sub:list) {
            sub.setSprintSectionId(sprintSection.getId());
            sub.setSprintSection(sprintSection);
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
        return SprintCategoryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SprintCategory.class;
    }
}