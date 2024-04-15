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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemStateSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemStateService;
import cn.ibizlab.plm.core.projmgmt.mapper.WorkItemStateMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemTypeService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[工作项状态] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkItemStateService extends ServiceImpl<WorkItemStateMapper,WorkItemState> implements WorkItemStateService {

    @Autowired
    @Lazy
    protected WorkItemTypeService workItemTypeService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    public WorkItemState get(WorkItemState et) {
        WorkItemState rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORK_ITEM_STATE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<WorkItemState> getByEntities(List<WorkItemState> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(WorkItemState et) {
        if(Entities.WORK_ITEM_TYPE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setWorkItemTypeId((String)et.getContextParentKey());
        }
    }

    public WorkItemState getDraft(WorkItemState et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(WorkItemState et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<WorkItemState>lambdaQuery().eq(WorkItemState::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(WorkItemState et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<WorkItemState> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(WorkItemState et) {
        UpdateWrapper<WorkItemState> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<WorkItemState> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(WorkItemState et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<WorkItemState> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,WorkItemState> before = getByEntities(list).stream().collect(Collectors.toMap(WorkItemState::getId,e->e));
        List<WorkItemState> create = new ArrayList<>();
        List<WorkItemState> update = new ArrayList<>();
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
    public boolean remove(WorkItemState et) {
        if(!remove(Wrappers.<WorkItemState>lambdaQuery().eq(WorkItemState::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<WorkItemState> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<WorkItemState> searchDefault(WorkItemStateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItemState> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<WorkItemState> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItemState> listDefault(WorkItemStateSearchContext context) {
        List<WorkItemState> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<WorkItemState> findByWorkItemTypeId(List<String> workItemTypeIds) {
        List<WorkItemState> list = baseMapper.findByWorkItemTypeId(workItemTypeIds);
        return list;
    }
    public boolean removeByWorkItemTypeId(String workItemTypeId) {
        return this.remove(Wrappers.<WorkItemState>lambdaQuery().eq(WorkItemState::getWorkItemTypeId,workItemTypeId));
    }

    public boolean resetByWorkItemTypeId(String workItemTypeId) {
        return this.update(Wrappers.<WorkItemState>lambdaUpdate().eq(WorkItemState::getWorkItemTypeId,workItemTypeId));
    }

    public boolean saveByWorkItemType(WorkItemType workItemType,List<WorkItemState> list) {
        if(list==null)
            return true;
        Map<String,WorkItemState> before = findByWorkItemTypeId(workItemType.getId()).stream().collect(Collectors.toMap(WorkItemState::getId,e->e));
        List<WorkItemState> update = new ArrayList<>();
        List<WorkItemState> create = new ArrayList<>();

        for(WorkItemState sub:list) {
            sub.setWorkItemTypeId(workItemType.getId());
            sub.setWorkItemType(workItemType);
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
        return WorkItemStateMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return WorkItemState.class;
    }
}