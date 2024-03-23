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
import cn.ibizlab.plm.core.projmgmt.domain.SprintSection;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSectionSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.SprintSectionService;
import cn.ibizlab.plm.core.projmgmt.mapper.SprintSectionMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.SprintCategory;
import cn.ibizlab.plm.core.projmgmt.service.SprintCategoryService;

/**
 * 实体[迭代分组] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintSectionService extends ServiceImpl<SprintSectionMapper,SprintSection> implements SprintSectionService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected SprintCategoryService sprintCategoryService;

    protected int batchSize = 500;

    public SprintSection get(SprintSection et) {
        SprintSection rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SPRINT_SECTION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<SprintSection> getByEntities(List<SprintSection> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(SprintSection et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
        }
    }

    public SprintSection getDraft(SprintSection et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(SprintSection et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SprintSection>lambdaQuery().eq(SprintSection::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(SprintSection et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<SprintSection> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(SprintSection et) {
        UpdateWrapper<SprintSection> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<SprintSection> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(SprintSection et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<SprintSection> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SprintSection> before = getByEntities(list).stream().collect(Collectors.toMap(SprintSection::getId,e->e));
        List<SprintSection> create = new ArrayList<>();
        List<SprintSection> update = new ArrayList<>();
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
    public boolean remove(SprintSection et) {
        if(!remove(Wrappers.<SprintSection>lambdaQuery().eq(SprintSection::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<SprintSection> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<SprintSection> searchDefault(SprintSectionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SprintSection> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SprintSection> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<SprintSection> listDefault(SprintSectionSearchContext context) {
        List<SprintSection> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<SprintSection> findByProjectId(List<String> projectIds) {
        List<SprintSection> list = baseMapper.findByProjectId(projectIds);
        return list;
    }
    public boolean removeByProjectId(String projectId) {
        return this.remove(Wrappers.<SprintSection>lambdaQuery().eq(SprintSection::getProjectId,projectId));
    }

    public boolean resetByProjectId(String projectId) {
        return this.update(Wrappers.<SprintSection>lambdaUpdate().eq(SprintSection::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<SprintSection> list) {
        if(list==null)
            return true;
        Map<String,SprintSection> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(SprintSection::getId,e->e));
        List<SprintSection> update = new ArrayList<>();
        List<SprintSection> create = new ArrayList<>();

        for(SprintSection sub:list) {
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
        return SprintSectionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SprintSection.class;
    }
}