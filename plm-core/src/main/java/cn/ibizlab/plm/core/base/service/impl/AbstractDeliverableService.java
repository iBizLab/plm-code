/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.filter.DeliverableSearchContext;
import cn.ibizlab.plm.core.base.service.DeliverableService;
import cn.ibizlab.plm.core.base.mapper.DeliverableMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[交付物] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDeliverableService extends ServiceImpl<DeliverableMapper,Deliverable> implements DeliverableService {

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Deliverable et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Deliverable> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Deliverable et) {
        UpdateWrapper<Deliverable> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Deliverable> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Deliverable et) {
        if(!remove(Wrappers.<Deliverable>lambdaQuery().eq(Deliverable::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Deliverable> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Deliverable get(Deliverable et) {
        Deliverable rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DELIVERABLE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Deliverable> get(List<Deliverable> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Deliverable getDraft(Deliverable et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Deliverable et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Deliverable>lambdaQuery().eq(Deliverable::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Deliverable et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Deliverable> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Deliverable> before = get(list).stream().collect(Collectors.toMap(Deliverable::getId,e->e));
        List<Deliverable> create = new ArrayList<>();
        List<Deliverable> update = new ArrayList<>();
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
	
   public Page<Deliverable> fetchDefault(DeliverableSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Deliverable> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Deliverable> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Deliverable> listDefault(DeliverableSearchContext context) {
        List<Deliverable> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Deliverable> fetchMyDeliverable(DeliverableSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Deliverable> pages=baseMapper.searchMyDeliverable(context.getPages(),context,context.getSelectCond());
        List<Deliverable> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Deliverable> listMyDeliverable(DeliverableSearchContext context) {
        List<Deliverable> list = baseMapper.listMyDeliverable(context,context.getSelectCond());
        return list;
   }
	
   public Page<Deliverable> fetchProjectDeliverable(DeliverableSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Deliverable> pages=baseMapper.searchProjectDeliverable(context.getPages(),context,context.getSelectCond());
        List<Deliverable> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Deliverable> listProjectDeliverable(DeliverableSearchContext context) {
        List<Deliverable> list = baseMapper.listProjectDeliverable(context,context.getSelectCond());
        return list;
   }
	
	public List<Deliverable> findByOwnerId(List<String> ownerIds){
        List<Deliverable> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Deliverable> findByWorkItem(WorkItem workItem){
        List<Deliverable> list = this.baseMapper.selectList(Wrappers.<Deliverable>lambdaQuery()
                        .eq(Deliverable::getOwnerId, workItem.getId())
                        .eq(Deliverable::getOwnerType,"WORK_ITEM")
                        .eq(Deliverable::getOwnerSubtype,"DELIVERABLE"));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Deliverable>lambdaQuery().eq(Deliverable::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Deliverable>lambdaUpdate().set(Deliverable::getOwnerId, null).eq(Deliverable::getOwnerId,ownerId));
	}
	public boolean saveByWorkItem(WorkItem workItem, List<Deliverable> list){
        if(list==null)
            return true;

        Map<String,Deliverable> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(Deliverable::getId,e->e));
        List<Deliverable> update = new ArrayList<>();
        List<Deliverable> create = new ArrayList<>();

        for(Deliverable sub:list) {
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
   public Page<Deliverable> fetchView(DeliverableSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Deliverable> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Deliverable> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Deliverable> listView(DeliverableSearchContext context) {
        List<Deliverable> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Deliverable et) {
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
        return DeliverableMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Deliverable.class;
    }

}