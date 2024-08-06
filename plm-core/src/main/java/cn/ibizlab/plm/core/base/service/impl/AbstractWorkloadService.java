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
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import cn.ibizlab.plm.core.base.service.WorkloadService;
import cn.ibizlab.plm.core.base.mapper.WorkloadMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.base.service.WorkloadTypeService;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.service.IdeaService;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.service.TestCaseService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;

/**
 * 实体[工时] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkloadService extends ServiceImpl<WorkloadMapper,Workload> implements WorkloadService {

    @Autowired
    @Lazy
    protected WorkloadTypeService workloadTypeService;

    @Autowired
    @Lazy
    protected IdeaService ideaService;

    @Autowired
    @Lazy
    protected TestCaseService testCaseService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Workload et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Workload> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Workload et) {
        UpdateWrapper<Workload> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Workload> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Workload et) {
        if(!remove(Wrappers.<Workload>lambdaQuery().eq(Workload::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Workload> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Workload get(Workload et) {
        Workload rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORKLOAD.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Workload> get(List<Workload> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Workload getDraft(Workload et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Workload et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Workload>lambdaQuery().eq(Workload::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Workload et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Workload> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Workload> before = get(list).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> create = new ArrayList<>();
        List<Workload> update = new ArrayList<>();
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
	
   public Page<Workload> fetchDefault(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listDefault(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchBiDetail(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchBiDetail(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listBiDetail(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listBiDetail(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchBiSearch(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchBiSearch(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listBiSearch(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listBiSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchCalendar(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        List<Workload> list = baseMapper.listCalendar(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchIdeaWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchIdeaWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listIdeaWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listIdeaWorkload(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchLog(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        List<Workload> list = baseMapper.listLog(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchMemberDimension(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMemberDimension(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listMemberDimension(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMemberDimension(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchMyCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyCalendar(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listMyCalendar(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        List<Workload> list = baseMapper.listMyCalendar(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchMyIdeaWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyIdeaWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listMyIdeaWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyIdeaWorkload(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchMyLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyLog(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listMyLog(WorkloadSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("REGISTER_DATE,DESC");
        List<Workload> list = baseMapper.listMyLog(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchMyTestCaseWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyTestCaseWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listMyTestCaseWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyTestCaseWorkload(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchMyTypeOf(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyTypeOf(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listMyTypeOf(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyTypeOf(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchMyWorkItemWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchMyWorkItemWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listMyWorkItemWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listMyWorkItemWorkload(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchTestCaseWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchTestCaseWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listTestCaseWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listTestCaseWorkload(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchTypeOf(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchTypeOf(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listTypeOf(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listTypeOf(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchUserGroupLink(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchUserGroupLink(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listUserGroupLink(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listUserGroupLink(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchUserGroupWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchUserGroupWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listUserGroupWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listUserGroupWorkload(context,context.getSelectCond());
        return list;
   }
	
   public Page<Workload> fetchWorkItemWorkload(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchWorkItemWorkload(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listWorkItemWorkload(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listWorkItemWorkload(context,context.getSelectCond());
        return list;
   }
	
	public List<Workload> findByTypeId(List<String> typeIds){
        List<Workload> list = baseMapper.findByTypeId(typeIds);
        return list;	
	}

	public List<Workload> findByWorkloadType(WorkloadType workloadType){
        List<Workload> list = findByTypeId(Arrays.asList(workloadType.getId()));
		return list;
	}
	public boolean removeByTypeId(String typeId){
        return this.remove(Wrappers.<Workload>lambdaQuery().eq(Workload::getTypeId,typeId));
	}

	public boolean resetByTypeId(String typeId){
		return this.update(Wrappers.<Workload>lambdaUpdate().eq(Workload::getTypeId,typeId));
	}
	public boolean saveByWorkloadType(WorkloadType workloadType, List<Workload> list){
        if(list==null)
            return true;

        Map<String,Workload> before = findByWorkloadType(workloadType).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setTypeId(workloadType.getId());
            sub.setWorkloadType(workloadType);
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
	public List<Workload> findByPrincipalId(List<String> principalIds){
        List<Workload> list = baseMapper.findByPrincipalId(principalIds);
        return list;	
	}

	public List<Workload> findByRelIdea(Idea idea){
        List<Workload> list = this.baseMapper.selectList(Wrappers.<Workload>lambdaQuery()
                        .eq(Workload::getPrincipalId, idea.getId())
                        .eq(Workload::getOwnerType,"IDEA")
                        .eq(Workload::getPrincipalType,"IDEA"));
		return list;
	}
	public boolean removeByPrincipalId(String principalId){
        return this.remove(Wrappers.<Workload>lambdaQuery().eq(Workload::getPrincipalId,principalId));
	}

	public boolean resetByPrincipalId(String principalId){
		return this.update(Wrappers.<Workload>lambdaUpdate().eq(Workload::getPrincipalId,principalId));
	}
	public boolean saveByRelIdea(Idea idea, List<Workload> list){
        if(list==null)
            return true;

        Map<String,Workload> before = findByRelIdea(idea).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setPrincipalId(idea.getId());
            sub.setRelIdea(idea);
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
	public List<Workload> findByRelTestCase(TestCase testCase){
        List<Workload> list = this.baseMapper.selectList(Wrappers.<Workload>lambdaQuery()
                        .eq(Workload::getPrincipalId, testCase.getId())
                        .eq(Workload::getOwnerType,"TEST_CASE")
                        .eq(Workload::getPrincipalType,"TEST_CASE"));
		return list;
	}
	public boolean saveByRelTestCase(TestCase testCase, List<Workload> list){
        if(list==null)
            return true;

        Map<String,Workload> before = findByRelTestCase(testCase).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setPrincipalId(testCase.getId());
            sub.setRelTestCase(testCase);
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
	public List<Workload> findByRelWorkItem(WorkItem workItem){
        List<Workload> list = this.baseMapper.selectList(Wrappers.<Workload>lambdaQuery()
                        .eq(Workload::getPrincipalId, workItem.getId())
                        .eq(Workload::getOwnerType,"WORK_ITEM")
                        .eq(Workload::getPrincipalType,"WORK_ITEM"));
		return list;
	}
	public boolean saveByRelWorkItem(WorkItem workItem, List<Workload> list){
        if(list==null)
            return true;

        Map<String,Workload> before = findByRelWorkItem(workItem).stream().collect(Collectors.toMap(Workload::getId,e->e));
        List<Workload> update = new ArrayList<>();
        List<Workload> create = new ArrayList<>();

        for(Workload sub:list) {
            sub.setPrincipalId(workItem.getId());
            sub.setRelWorkItem(workItem);
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
   public Page<Workload> fetchView(WorkloadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Workload> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Workload> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Workload> listView(WorkloadSearchContext context) {
        List<Workload> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Workload et) {
        if(Entities.WORKLOAD_TYPE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTypeId((String)et.getContextParentKey());
            WorkloadType workloadType = et.getWorkloadType();
            if(workloadType == null) {
                workloadType = workloadTypeService.getById(et.getTypeId());
                et.setWorkloadType(workloadType);
            }
            if(!ObjectUtils.isEmpty(workloadType)) {
                et.setTypeId(workloadType.getId());
                et.setTypeName(workloadType.getName());
            }
        }
        if(Entities.IDEA.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.TEST_CASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPrincipalId((String)et.getContextParentKey());
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
        return WorkloadMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Workload.class;
    }

}