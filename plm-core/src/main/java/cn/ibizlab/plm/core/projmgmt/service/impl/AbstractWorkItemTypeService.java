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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemTypeService;
import cn.ibizlab.plm.core.projmgmt.mapper.WorkItemTypeMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemStateService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[工作项类型] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkItemTypeService extends ServiceImpl<WorkItemTypeMapper,WorkItemType> implements WorkItemTypeService {

    @Autowired
    @Lazy
    protected WorkItemStateService workItemStateService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    public WorkItemType get(WorkItemType et) {
        WorkItemType rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORK_ITEM_TYPE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<WorkItemType> getByEntities(List<WorkItemType> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public WorkItemType getDraft(WorkItemType et) {
        return et;
    }

    public Integer checkKey(WorkItemType et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<WorkItemType>lambdaQuery().eq(WorkItemType::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(WorkItemType et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<WorkItemType> list) {
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(WorkItemType et) {
        UpdateWrapper<WorkItemType> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<WorkItemType> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(WorkItemType et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<WorkItemType> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,WorkItemType> before = getByEntities(list).stream().collect(Collectors.toMap(WorkItemType::getId,e->e));
        List<WorkItemType> create = new ArrayList<>();
        List<WorkItemType> update = new ArrayList<>();
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
    public boolean remove(WorkItemType et) {
        if(!remove(Wrappers.<WorkItemType>lambdaQuery().eq(WorkItemType::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<WorkItemType> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<WorkItemType> searchDefault(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItemType> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<WorkItemType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItemType> listDefault(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<WorkItemType> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItemType> searchProjectWorkItemType(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItemType> pages=baseMapper.searchProjectWorkItemType(context.getPages(),context,context.getSelectCond());
        List<WorkItemType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItemType> listProjectWorkItemType(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<WorkItemType> list = baseMapper.listProjectWorkItemType(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItemType> searchProjectWorkItemTypeNotBug(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItemType> pages=baseMapper.searchProjectWorkItemTypeNotBug(context.getPages(),context,context.getSelectCond());
        List<WorkItemType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItemType> listProjectWorkItemTypeNotBug(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<WorkItemType> list = baseMapper.listProjectWorkItemTypeNotBug(context,context.getSelectCond());
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
        return WorkItemTypeMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return WorkItemType.class;
    }
}