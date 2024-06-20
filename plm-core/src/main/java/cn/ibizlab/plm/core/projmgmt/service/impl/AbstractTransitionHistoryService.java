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
import cn.ibizlab.plm.core.projmgmt.domain.TransitionHistory;
import cn.ibizlab.plm.core.projmgmt.filter.TransitionHistorySearchContext;
import cn.ibizlab.plm.core.projmgmt.service.TransitionHistoryService;
import cn.ibizlab.plm.core.projmgmt.mapper.TransitionHistoryMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[流转记录] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTransitionHistoryService extends ServiceImpl<TransitionHistoryMapper,TransitionHistory> implements TransitionHistoryService {

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TransitionHistory et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<TransitionHistory> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(TransitionHistory et) {
        UpdateWrapper<TransitionHistory> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<TransitionHistory> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(TransitionHistory et) {
        if(!remove(Wrappers.<TransitionHistory>lambdaQuery().eq(TransitionHistory::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<TransitionHistory> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public TransitionHistory get(TransitionHistory et) {
        TransitionHistory rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.TRANSITION_HISTORY.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<TransitionHistory> get(List<TransitionHistory> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public TransitionHistory getDraft(TransitionHistory et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(TransitionHistory et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<TransitionHistory>lambdaQuery().eq(TransitionHistory::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(TransitionHistory et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<TransitionHistory> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,TransitionHistory> before = get(list).stream().collect(Collectors.toMap(TransitionHistory::getId,e->e));
        List<TransitionHistory> create = new ArrayList<>();
        List<TransitionHistory> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId()))
                update.add(sub);
            else
                create.add(sub);
        });
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else
            return true;
    }
	
   public Page<TransitionHistory> fetchDefault(TransitionHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TransitionHistory> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<TransitionHistory> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TransitionHistory> listDefault(TransitionHistorySearchContext context) {
        List<TransitionHistory> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
	public List<TransitionHistory> findByOwnerId(List<String> ownerIds){
        List<TransitionHistory> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<TransitionHistory>lambdaQuery().eq(TransitionHistory::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<TransitionHistory>lambdaUpdate().eq(TransitionHistory::getOwnerId,ownerId));
	}
	public boolean saveByWorkItem(WorkItem workItem, List<TransitionHistory> list){
        if(list==null)
            return true;
        Map<String,TransitionHistory> before = this.baseMapper.selectList(Wrappers.<TransitionHistory>lambdaQuery()
                        .eq(TransitionHistory::getOwnerId, workItem.getId())
                        .eq(TransitionHistory::getOwnerType,"WORK_ITEM").isNull(TransitionHistory::getOwnerSubtype))
                        .stream()
                        .collect(Collectors.toMap(TransitionHistory::getId,e->e));

        List<TransitionHistory> update = new ArrayList<>();
        List<TransitionHistory> create = new ArrayList<>();

        for(TransitionHistory sub:list) {
            sub.setOwnerId(workItem.getId());
            sub.setWorkItem(workItem);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}

    public void fillParentData(TransitionHistory et) {
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
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
        return TransitionHistoryMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return TransitionHistory.class;
    }

}