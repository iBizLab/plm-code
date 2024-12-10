/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Executor;
import cn.ibizlab.plm.core.base.filter.ExecutorSearchContext;
import cn.ibizlab.plm.core.base.service.ExecutorService;
import cn.ibizlab.plm.core.base.mapper.ExecutorMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[执行人] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractExecutorService extends ServiceImpl<ExecutorMapper,Executor> implements ExecutorService {

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Executor et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Executor> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Executor et) {
        fillParentData(et);
        UpdateWrapper<Executor> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Executor> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Executor et) {
        if(!remove(Wrappers.<Executor>lambdaQuery().eq(Executor::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Executor> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Executor get(Executor et) {
        Executor rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.EXECUTOR.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Executor> get(List<Executor> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Executor getDraft(Executor et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Executor et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Executor>lambdaQuery().eq(Executor::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Executor et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Executor> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Executor> before = get(list).stream().collect(Collectors.toMap(Executor::getId,e->e));
        List<Executor> create = new ArrayList<>();
        List<Executor> update = new ArrayList<>();
        list.forEach(sub->{
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	
   public Page<Executor> fetchDefault(ExecutorSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Executor> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Executor> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Executor> listDefault(ExecutorSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<Executor> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Executor> fetchCommentWorkItemExecutor(ExecutorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Executor> pages=baseMapper.searchCommentWorkItemExecutor(context.getPages(),context,context.getSelectCond());
        List<Executor> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Executor> listCommentWorkItemExecutor(ExecutorSearchContext context) {
        List<Executor> list = baseMapper.listCommentWorkItemExecutor(context,context.getSelectCond());
        return list;
   }
	
   public Page<Executor> fetchExecutorByOwnerid(ExecutorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Executor> pages=baseMapper.searchExecutorByOwnerid(context.getPages(),context,context.getSelectCond());
        List<Executor> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Executor> listExecutorByOwnerid(ExecutorSearchContext context) {
        List<Executor> list = baseMapper.listExecutorByOwnerid(context,context.getSelectCond());
        return list;
   }
	
	public List<Executor> findByUserId(List<String> userIds){
        List<Executor> list = baseMapper.findByUserId(userIds);
        return list;	
	}

	public List<Executor> findByUser(User user){
        List<Executor> list = findByUserId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByUserId(String userId){
        return this.remove(Wrappers.<Executor>lambdaQuery().eq(Executor::getUserId,userId));
	}

	public boolean resetByUserId(String userId){
		return this.update(Wrappers.<Executor>lambdaUpdate().set(Executor::getUserId, null).eq(Executor::getUserId,userId));
	}
	public boolean saveByUser(User user, List<Executor> list){
        if(list==null)
            return true;

        Map<String,Executor> before = findByUser(user).stream().collect(Collectors.toMap(Executor::getId,e->e));
        List<Executor> update = new ArrayList<>();
        List<Executor> create = new ArrayList<>();

        for(Executor sub:list) {
            sub.setUserId(user.getId());
            sub.setUser(user);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
	public List<Executor> findByOwnerId(List<String> ownerIds){
        List<Executor> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Executor> findByWorkItem(WorkItem workItem){
        List<Executor> list = this.baseMapper.selectList(Wrappers.<Executor>lambdaQuery()
                        .eq(Executor::getOwnerId, workItem.getId())
                        .eq(Executor::getOwnerType,"WORK_ITEM")
                        .eq(Executor::getOwnerSubtype,"WORK_ITEM"));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Executor>lambdaQuery().eq(Executor::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Executor>lambdaUpdate().set(Executor::getOwnerId, null).eq(Executor::getOwnerId,ownerId));
	}
	public boolean saveByWorkItem(WorkItem workItem, List<Executor> list){
        if(list==null)
            return true;

        Map<String,Executor> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(Executor::getId,e->e));
        List<Executor> update = new ArrayList<>();
        List<Executor> create = new ArrayList<>();

        for(Executor sub:list) {
            sub.setOwnerId(workItem.getId());
            sub.setWorkItem(workItem);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
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
   public Page<Executor> fetchView(ExecutorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Executor> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Executor> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Executor> listView(ExecutorSearchContext context) {
        List<Executor> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Executor et) {
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
        return ExecutorMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Executor.class;
    }

}