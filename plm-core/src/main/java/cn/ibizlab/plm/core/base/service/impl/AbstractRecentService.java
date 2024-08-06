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
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.filter.RecentSearchContext;
import cn.ibizlab.plm.core.base.service.RecentService;
import cn.ibizlab.plm.core.base.mapper.RecentMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[最近访问] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractRecentService extends ServiceImpl<RecentMapper,Recent> implements RecentService {

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Recent et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Recent> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Recent et) {
        UpdateWrapper<Recent> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Recent> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Recent et) {
        if(!remove(Wrappers.<Recent>lambdaQuery().eq(Recent::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Recent> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Recent get(Recent et) {
        Recent rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.RECENT.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Recent> get(List<Recent> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Recent getDraft(Recent et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Recent et) {
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Recent>lambdaQuery().eq(Recent::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Recent et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Recent> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Recent> before = get(list).stream().collect(Collectors.toMap(Recent::getId,e->e));
        List<Recent> create = new ArrayList<>();
        List<Recent> update = new ArrayList<>();
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
	
   public Page<Recent> fetchDefault(RecentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listDefault(RecentSearchContext context) {
        List<Recent> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentAccess(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentAccess(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentAccess(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentAccess(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentCurproductTicket(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentCurproductTicket(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentCurproductTicket(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentCurproductTicket(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentCurprojectChildWorkItem(RecentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentCurprojectChildWorkItem(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentCurprojectChildWorkItem(RecentSearchContext context) {
        List<Recent> list = baseMapper.listRecentCurprojectChildWorkItem(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentCurprojectWorkItem(RecentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentCurprojectWorkItem(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentCurprojectWorkItem(RecentSearchContext context) {
        List<Recent> list = baseMapper.listRecentCurprojectWorkItem(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentIdea(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentIdea(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentIdea(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentIdea(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentPage(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentPage(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentPage(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentPage(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentProject(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentProject(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentProject(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentProject(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentTestCase(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentTestCase(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentTestCase(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentTestCase(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentTestCaseIndex(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentTestCaseIndex(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentTestCaseIndex(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentTestCaseIndex(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentTicket(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentTicket(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentTicket(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentTicket(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentUse(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentUse(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentUse(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentUse(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentWorkItem(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentWorkItem(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentWorkItem(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentWorkItem(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentWorkItemAndNobug(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentWorkItemAndNobug(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentWorkItemAndNobug(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentWorkItemAndNobug(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentWorkItemBug(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentWorkItemBug(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentWorkItemBug(RecentSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Recent> list = baseMapper.listRecentWorkItemBug(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchRecentWorkItemDependency(RecentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchRecentWorkItemDependency(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listRecentWorkItemDependency(RecentSearchContext context) {
        List<Recent> list = baseMapper.listRecentWorkItemDependency(context,context.getSelectCond());
        return list;
   }
	
   public Page<Recent> fetchUser(RecentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listUser(RecentSearchContext context) {
        List<Recent> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
   }
	
	public List<Recent> findByOwnerId(List<String> ownerIds){
        List<Recent> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Recent> findByDercustomRecentWorkItem(WorkItem workItem){
        List<Recent> list = this.baseMapper.selectList(Wrappers.<Recent>lambdaQuery()
                        .eq(Recent::getOwnerId, workItem.getId())
                        .eq(Recent::getOwnerType,"WORK_ITEM").isNull(Recent::getOwnerSubtype));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Recent>lambdaQuery().eq(Recent::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Recent>lambdaUpdate().eq(Recent::getOwnerId,ownerId));
	}
	public boolean saveByDercustomRecentWorkItem(WorkItem workItem, List<Recent> list){
        if(list==null)
            return true;

        Map<String,Recent> before = findByDercustomRecentWorkItem(workItem).stream().collect(Collectors.toMap(Recent::getId,e->e));
        List<Recent> update = new ArrayList<>();
        List<Recent> create = new ArrayList<>();

        for(Recent sub:list) {
            sub.setOwnerId(workItem.getId());
            sub.setDercustomRecentWorkItem(workItem);
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
   public Page<Recent> fetchView(RecentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Recent> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Recent> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Recent> listView(RecentSearchContext context) {
        List<Recent> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Recent et) {
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
        return RecentMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Recent.class;
    }

}