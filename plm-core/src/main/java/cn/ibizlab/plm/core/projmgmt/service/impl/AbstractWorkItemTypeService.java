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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
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
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected WorkItemStateService workItemStateService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WorkItemType et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<WorkItemType> list) {
        list.forEach(this::fillParentData);
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
    public boolean update(List<WorkItemType> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(WorkItemType et) {
        if(!remove(Wrappers.<WorkItemType>lambdaQuery().eq(WorkItemType::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<WorkItemType> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public WorkItemType get(WorkItemType et) {
        WorkItemType rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORK_ITEM_TYPE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<WorkItemType> get(List<WorkItemType> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public WorkItemType getDraft(WorkItemType et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(WorkItemType et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<WorkItemType>lambdaQuery().eq(WorkItemType::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(WorkItemType et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<WorkItemType> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,WorkItemType> before = get(list).stream().collect(Collectors.toMap(WorkItemType::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else
            return true;
    }
	
   public Page<WorkItemType> fetchDefault(WorkItemTypeSearchContext context) {
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
	
   public Page<WorkItemType> fetchChooseTargetType(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItemType> pages=baseMapper.searchChooseTargetType(context.getPages(),context,context.getSelectCond());
        List<WorkItemType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItemType> listChooseTargetType(WorkItemTypeSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SEQUENCE,ASC");
        List<WorkItemType> list = baseMapper.listChooseTargetType(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItemType> fetchCurProjectType(WorkItemTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItemType> pages=baseMapper.searchCurProjectType(context.getPages(),context,context.getSelectCond());
        List<WorkItemType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItemType> listCurProjectType(WorkItemTypeSearchContext context) {
        List<WorkItemType> list = baseMapper.listCurProjectType(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItemType> fetchGroupByOriginState(WorkItemTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchGroupByOriginState(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItemType>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItemType.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItemType> listGroupByOriginState(WorkItemTypeSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listGroupByOriginState(context,context.getSelectCond()),WorkItemType.class);
   }
	
   public Page<WorkItemType> fetchProjectWorkItemType(WorkItemTypeSearchContext context) {
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
	
   public Page<WorkItemType> fetchProjectWorkItemTypeNotBug(WorkItemTypeSearchContext context) {
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
	
	public List<WorkItemType> findByProjectId(List<String> projectIds){
        List<WorkItemType> list = baseMapper.findByProjectId(projectIds);
        return list;	
	}

	public List<WorkItemType> findByProject(Project project){
        List<WorkItemType> list = findByProjectId(Arrays.asList(project.getId()));
		return list;
	}
	public boolean removeByProjectId(String projectId){
        return this.remove(Wrappers.<WorkItemType>lambdaQuery().eq(WorkItemType::getProjectId,projectId));
	}

	public boolean resetByProjectId(String projectId){
		return this.update(Wrappers.<WorkItemType>lambdaUpdate().set(WorkItemType::getProjectId, null).eq(WorkItemType::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<WorkItemType> list){
        if(list==null)
            return true;

        Map<String,WorkItemType> before = findByProject(project).stream().collect(Collectors.toMap(WorkItemType::getId,e->e));
        List<WorkItemType> update = new ArrayList<>();
        List<WorkItemType> create = new ArrayList<>();

        for(WorkItemType sub:list) {
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
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
   public Page<WorkItemType> fetchView(WorkItemTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItemType> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<WorkItemType> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItemType> listView(WorkItemTypeSearchContext context) {
        List<WorkItemType> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(WorkItemType et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
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
        return WorkItemTypeMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return WorkItemType.class;
    }

}