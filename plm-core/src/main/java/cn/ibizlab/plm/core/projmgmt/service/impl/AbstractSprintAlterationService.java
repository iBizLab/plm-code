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
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.core.projmgmt.filter.SprintAlterationSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.SprintAlterationService;
import cn.ibizlab.plm.core.projmgmt.mapper.SprintAlterationMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[迭代变更] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSprintAlterationService extends ServiceImpl<SprintAlterationMapper,SprintAlteration> implements SprintAlterationService {

    @Autowired
    @Lazy
    protected SprintService sprintService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SprintAlteration et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<SprintAlteration> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(SprintAlteration et) {
        fillParentData(et);
        UpdateWrapper<SprintAlteration> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<SprintAlteration> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(SprintAlteration et) {
        if(!remove(Wrappers.<SprintAlteration>lambdaQuery().eq(SprintAlteration::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<SprintAlteration> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public SprintAlteration get(SprintAlteration et) {
        SprintAlteration rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.SPRINT_ALTERATION.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<SprintAlteration> get(List<SprintAlteration> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public SprintAlteration getDraft(SprintAlteration et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(SprintAlteration et) {
        fillParentData(et);
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<SprintAlteration>lambdaQuery().eq(SprintAlteration::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(SprintAlteration et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<SprintAlteration> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SprintAlteration> before = get(list).stream().collect(Collectors.toMap(SprintAlteration::getId,e->e));
        List<SprintAlteration> create = new ArrayList<>();
        List<SprintAlteration> update = new ArrayList<>();
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
	
   public Page<SprintAlteration> fetchDefault(SprintAlterationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SprintAlteration> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<SprintAlteration> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SprintAlteration> listDefault(SprintAlterationSearchContext context) {
        List<SprintAlteration> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<SprintAlteration> fetchChange(SprintAlterationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SprintAlteration> pages=baseMapper.searchChange(context.getPages(),context,context.getSelectCond());
        List<SprintAlteration> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SprintAlteration> listChange(SprintAlterationSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,ASC");
        List<SprintAlteration> list = baseMapper.listChange(context,context.getSelectCond());
        return list;
   }
	
	public List<SprintAlteration> findBySprintId(List<String> sprintIds){
        List<SprintAlteration> list = baseMapper.findBySprintId(sprintIds);
        return list;	
	}

	public List<SprintAlteration> findBySprint(Sprint sprint){
        List<SprintAlteration> list = findBySprintId(Arrays.asList(sprint.getId()));
		return list;
	}
	public boolean removeBySprintId(String sprintId){
        return this.remove(Wrappers.<SprintAlteration>lambdaQuery().eq(SprintAlteration::getSprintId,sprintId));
	}

	public boolean resetBySprintId(String sprintId){
		return this.update(Wrappers.<SprintAlteration>lambdaUpdate().eq(SprintAlteration::getSprintId,sprintId));
	}
	public boolean saveBySprint(Sprint sprint, List<SprintAlteration> list){
        if(list==null)
            return true;

        Map<String,SprintAlteration> before = findBySprint(sprint).stream().collect(Collectors.toMap(SprintAlteration::getId,e->e));
        List<SprintAlteration> update = new ArrayList<>();
        List<SprintAlteration> create = new ArrayList<>();

        for(SprintAlteration sub:list) {
            sub.setSprintId(sprint.getId());
            sub.setSprint(sprint);
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
	public List<SprintAlteration> findByWorkItemId(List<String> workItemIds){
        List<SprintAlteration> list = baseMapper.findByWorkItemId(workItemIds);
        return list;	
	}

	public List<SprintAlteration> findByWorkItem(WorkItem workItem){
        List<SprintAlteration> list = findByWorkItemId(Arrays.asList(workItem.getId()));
		return list;
	}
	public boolean removeByWorkItemId(String workItemId){
        return this.remove(Wrappers.<SprintAlteration>lambdaQuery().eq(SprintAlteration::getWorkItemId,workItemId));
	}

	public boolean resetByWorkItemId(String workItemId){
		return this.update(Wrappers.<SprintAlteration>lambdaUpdate().eq(SprintAlteration::getWorkItemId,workItemId));
	}
	public boolean saveByWorkItem(WorkItem workItem, List<SprintAlteration> list){
        if(list==null)
            return true;

        Map<String,SprintAlteration> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(SprintAlteration::getId,e->e));
        List<SprintAlteration> update = new ArrayList<>();
        List<SprintAlteration> create = new ArrayList<>();

        for(SprintAlteration sub:list) {
            sub.setWorkItemId(workItem.getId());
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
   public Page<SprintAlteration> fetchView(SprintAlterationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SprintAlteration> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<SprintAlteration> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<SprintAlteration> listView(SprintAlterationSearchContext context) {
        List<SprintAlteration> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(SprintAlteration et) {
        if(Entities.SPRINT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSprintId((String)et.getContextParentKey());
        }
        if(!ObjectUtils.isEmpty(et.getSprintId())) {
            Sprint sprint = et.getSprint();
            if(sprint == null) {
                sprint = sprintService.getById(et.getSprintId());
                et.setSprint(sprint);
            }
            if(!ObjectUtils.isEmpty(sprint)) {
                et.setSprintStatus(sprint.getStatus());
                et.setSprintId(sprint.getId());
                et.setSprintName(sprint.getName());
            }
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setWorkItemId((String)et.getContextParentKey());
            WorkItem workItem = et.getWorkItem();
            if(workItem == null) {
                workItem = workItemService.getById(et.getWorkItemId());
                et.setWorkItem(workItem);
            }
            if(!ObjectUtils.isEmpty(workItem)) {
                et.setIsDeleted(workItem.getIsDeleted());
                et.setWorkItemCompletedAt(workItem.getCompletedAt());
                et.setWorkItemPriority(workItem.getPriority());
                et.setWorkItemId(workItem.getId());
                et.setWorkItemTitle(workItem.getTitle());
            }
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
        return SprintAlterationMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return SprintAlteration.class;
    }

}