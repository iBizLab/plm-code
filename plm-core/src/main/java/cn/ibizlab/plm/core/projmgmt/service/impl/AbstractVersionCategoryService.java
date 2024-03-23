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
import cn.ibizlab.plm.core.projmgmt.domain.VersionCategory;
import cn.ibizlab.plm.core.projmgmt.filter.VersionCategorySearchContext;
import cn.ibizlab.plm.core.projmgmt.service.VersionCategoryService;
import cn.ibizlab.plm.core.projmgmt.mapper.VersionCategoryMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.VersionSection;
import cn.ibizlab.plm.core.projmgmt.service.VersionSectionService;
import cn.ibizlab.plm.core.projmgmt.domain.Version;
import cn.ibizlab.plm.core.projmgmt.service.VersionService;

/**
 * 实体[发布类别] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractVersionCategoryService extends ServiceImpl<VersionCategoryMapper,VersionCategory> implements VersionCategoryService {

    @Autowired
    @Lazy
    protected VersionSectionService versionSectionService;

    @Autowired
    @Lazy
    protected VersionService versionService;

    protected int batchSize = 500;

    public VersionCategory get(VersionCategory et) {
        VersionCategory rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.VERSION_CATEGORY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<VersionCategory> getByEntities(List<VersionCategory> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(VersionCategory et) {
        if(Entities.VERSION_SECTION.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setVersionSectionId((String)et.getContextParentKey());
        }
    }

    public VersionCategory getDraft(VersionCategory et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(VersionCategory et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<VersionCategory>lambdaQuery().eq(VersionCategory::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(VersionCategory et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<VersionCategory> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(VersionCategory et) {
        UpdateWrapper<VersionCategory> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<VersionCategory> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(VersionCategory et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<VersionCategory> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,VersionCategory> before = getByEntities(list).stream().collect(Collectors.toMap(VersionCategory::getId,e->e));
        List<VersionCategory> create = new ArrayList<>();
        List<VersionCategory> update = new ArrayList<>();
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
    public boolean remove(VersionCategory et) {
        if(!remove(Wrappers.<VersionCategory>lambdaQuery().eq(VersionCategory::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<VersionCategory> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<VersionCategory> searchDefault(VersionCategorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VersionCategory> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<VersionCategory> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<VersionCategory> listDefault(VersionCategorySearchContext context) {
        List<VersionCategory> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<VersionCategory> findByVersionSectionId(List<String> versionSectionIds) {
        List<VersionCategory> list = baseMapper.findByVersionSectionId(versionSectionIds);
        return list;
    }
    public boolean removeByVersionSectionId(String versionSectionId) {
        return this.remove(Wrappers.<VersionCategory>lambdaQuery().eq(VersionCategory::getVersionSectionId,versionSectionId));
    }

    public boolean resetByVersionSectionId(String versionSectionId) {
        return this.update(Wrappers.<VersionCategory>lambdaUpdate().eq(VersionCategory::getVersionSectionId,versionSectionId));
    }

    public boolean saveByVersionSection(VersionSection versionSection,List<VersionCategory> list) {
        if(list==null)
            return true;
        Map<String,VersionCategory> before = findByVersionSectionId(versionSection.getId()).stream().collect(Collectors.toMap(VersionCategory::getId,e->e));
        List<VersionCategory> update = new ArrayList<>();
        List<VersionCategory> create = new ArrayList<>();

        for(VersionCategory sub:list) {
            sub.setVersionSectionId(versionSection.getId());
            sub.setVersionSection(versionSection);
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
        return VersionCategoryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return VersionCategory.class;
    }
}