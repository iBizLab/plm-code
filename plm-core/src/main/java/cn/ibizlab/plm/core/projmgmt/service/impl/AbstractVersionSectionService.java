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
import cn.ibizlab.plm.core.projmgmt.domain.VersionSection;
import cn.ibizlab.plm.core.projmgmt.filter.VersionSectionSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.VersionSectionService;
import cn.ibizlab.plm.core.projmgmt.mapper.VersionSectionMapper;
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

/**
 * 实体[发布分组] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractVersionSectionService extends ServiceImpl<VersionSectionMapper,VersionSection> implements VersionSectionService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected VersionCategoryService versionCategoryService;

    protected int batchSize = 500;

    public VersionSection get(VersionSection et) {
        VersionSection rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.VERSION_SECTION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<VersionSection> getByEntities(List<VersionSection> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(VersionSection et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
        }
    }

    public VersionSection getDraft(VersionSection et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(VersionSection et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<VersionSection>lambdaQuery().eq(VersionSection::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(VersionSection et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<VersionSection> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(VersionSection et) {
        UpdateWrapper<VersionSection> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<VersionSection> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(VersionSection et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<VersionSection> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,VersionSection> before = getByEntities(list).stream().collect(Collectors.toMap(VersionSection::getId,e->e));
        List<VersionSection> create = new ArrayList<>();
        List<VersionSection> update = new ArrayList<>();
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
    public boolean remove(VersionSection et) {
        if(!remove(Wrappers.<VersionSection>lambdaQuery().eq(VersionSection::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<VersionSection> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<VersionSection> searchDefault(VersionSectionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VersionSection> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<VersionSection> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<VersionSection> listDefault(VersionSectionSearchContext context) {
        List<VersionSection> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<VersionSection> findByProjectId(List<String> projectIds) {
        List<VersionSection> list = baseMapper.findByProjectId(projectIds);
        return list;
    }
    public boolean removeByProjectId(String projectId) {
        return this.remove(Wrappers.<VersionSection>lambdaQuery().eq(VersionSection::getProjectId,projectId));
    }

    public boolean resetByProjectId(String projectId) {
        return this.update(Wrappers.<VersionSection>lambdaUpdate().eq(VersionSection::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<VersionSection> list) {
        if(list==null)
            return true;
        Map<String,VersionSection> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(VersionSection::getId,e->e));
        List<VersionSection> update = new ArrayList<>();
        List<VersionSection> create = new ArrayList<>();

        for(VersionSection sub:list) {
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
        return VersionSectionMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return VersionSection.class;
    }
}