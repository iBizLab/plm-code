/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.service.impl;

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
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.filter.TestPlanSearchContext;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.testmgmt.mapper.TestPlanMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.service.RunService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[测试计划] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractTestPlanService extends ServiceImpl<TestPlanMapper,TestPlan> implements TestPlanService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected ReleaseService releaseService;

    @Autowired
    @Lazy
    protected SprintService sprintService;

    @Autowired
    @Lazy
    protected RunService runService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TestPlan et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        relationService.saveByPrincipalTestPlan(et,et.getWorkItemRelations());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<TestPlan> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(TestPlan et) {
        UpdateWrapper<TestPlan> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        relationService.saveByPrincipalTestPlan(et,et.getWorkItemRelations());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<TestPlan> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(TestPlan et) {
        if(!remove(Wrappers.<TestPlan>lambdaQuery().eq(TestPlan::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<TestPlan> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public TestPlan get(TestPlan et) {
        TestPlan rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.TEST_PLAN.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关联]
        getWorkItemRelations(et);
        return et;
    }	

    public List<TestPlan> get(List<TestPlan> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public TestPlan getDraft(TestPlan et) {
        fillParentData(et);
        return et;
    }
	
    public Integer checkKey(TestPlan et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<TestPlan>lambdaQuery().eq(TestPlan::getId, et.getId()))>0)?1:0;
    }
	
    @Override
    @Transactional
    public boolean save(TestPlan et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<TestPlan> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,TestPlan> before = get(list).stream().collect(Collectors.toMap(TestPlan::getId,e->e));
        List<TestPlan> create = new ArrayList<>();
        List<TestPlan> update = new ArrayList<>();
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
	
   public Page<TestPlan> fetchDefault(TestPlanSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestPlan> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<TestPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestPlan> listDefault(TestPlanSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<TestPlan> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestPlan> fetchMyAssignee(TestPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestPlan> pages=baseMapper.searchMyAssignee(context.getPages(),context,context.getSelectCond());
        List<TestPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestPlan> listMyAssignee(TestPlanSearchContext context) {
        List<TestPlan> list = baseMapper.listMyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestPlan> fetchMyInProgress(TestPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestPlan> pages=baseMapper.searchMyInProgress(context.getPages(),context,context.getSelectCond());
        List<TestPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestPlan> listMyInProgress(TestPlanSearchContext context) {
        List<TestPlan> list = baseMapper.listMyInProgress(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestPlan> fetchMyParticipate(TestPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestPlan> pages=baseMapper.searchMyParticipate(context.getPages(),context,context.getSelectCond());
        List<TestPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestPlan> listMyParticipate(TestPlanSearchContext context) {
        List<TestPlan> list = baseMapper.listMyParticipate(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestPlan> fetchPendingAndInProgress(TestPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestPlan> pages=baseMapper.searchPendingAndInProgress(context.getPages(),context,context.getSelectCond());
        List<TestPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestPlan> listPendingAndInProgress(TestPlanSearchContext context) {
        List<TestPlan> list = baseMapper.listPendingAndInProgress(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestPlan> fetchQueryNoShiftIn(TestPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestPlan> pages=baseMapper.searchQueryNoShiftIn(context.getPages(),context,context.getSelectCond());
        List<TestPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestPlan> listQueryNoShiftIn(TestPlanSearchContext context) {
        List<TestPlan> list = baseMapper.listQueryNoShiftIn(context,context.getSelectCond());
        return list;
   }
	
   public Page<TestPlan> fetchUnJoinPlan(TestPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestPlan> pages=baseMapper.searchUnJoinPlan(context.getPages(),context,context.getSelectCond());
        List<TestPlan> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<TestPlan> listUnJoinPlan(TestPlanSearchContext context) {
        List<TestPlan> list = baseMapper.listUnJoinPlan(context,context.getSelectCond());
        return list;
   }
	
	public List<TestPlan> findByLibraryId(List<String> libraryIds){
        List<TestPlan> list = baseMapper.findByLibraryId(libraryIds);
        if(!ObjectUtils.isEmpty(list))
            relationService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setWorkItemRelations(sub.getValue())));
        return list;	
	}

	public boolean removeByLibraryId(String libraryId){
        return this.remove(Wrappers.<TestPlan>lambdaQuery().eq(TestPlan::getLibraryId,libraryId));
	}

	public boolean resetByLibraryId(String libraryId){
		return this.update(Wrappers.<TestPlan>lambdaUpdate().eq(TestPlan::getLibraryId,libraryId));
	}
	public boolean saveByLibrary(Library library, List<TestPlan> list){
        if(list==null)
            return true;
        Map<String,TestPlan> before = findByLibraryId(library.getId()).stream().collect(Collectors.toMap(TestPlan::getId,e->e));

        List<TestPlan> update = new ArrayList<>();
        List<TestPlan> create = new ArrayList<>();

        for(TestPlan sub:list) {
            sub.setLibraryId(library.getId());
            sub.setLibrary(library);
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
	public List<TestPlan> findByProjectId(List<String> projectIds){
        List<TestPlan> list = baseMapper.findByProjectId(projectIds);
        if(!ObjectUtils.isEmpty(list))
            relationService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setWorkItemRelations(sub.getValue())));
        return list;	
	}

	public boolean removeByProjectId(String projectId){
        return this.remove(Wrappers.<TestPlan>lambdaQuery().eq(TestPlan::getProjectId,projectId));
	}

	public boolean resetByProjectId(String projectId){
		return this.update(Wrappers.<TestPlan>lambdaUpdate().eq(TestPlan::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<TestPlan> list){
        if(list==null)
            return true;
        Map<String,TestPlan> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(TestPlan::getId,e->e));

        List<TestPlan> update = new ArrayList<>();
        List<TestPlan> create = new ArrayList<>();

        for(TestPlan sub:list) {
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
	public List<TestPlan> findByReleaseId(List<String> releaseIds){
        List<TestPlan> list = baseMapper.findByReleaseId(releaseIds);
        if(!ObjectUtils.isEmpty(list))
            relationService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setWorkItemRelations(sub.getValue())));
        return list;	
	}

	public boolean removeByReleaseId(String releaseId){
        return this.remove(Wrappers.<TestPlan>lambdaQuery().eq(TestPlan::getReleaseId,releaseId));
	}

	public boolean resetByReleaseId(String releaseId){
		return this.update(Wrappers.<TestPlan>lambdaUpdate().eq(TestPlan::getReleaseId,releaseId));
	}
	public boolean saveByRelease(Release release, List<TestPlan> list){
        if(list==null)
            return true;
        Map<String,TestPlan> before = findByReleaseId(release.getId()).stream().collect(Collectors.toMap(TestPlan::getId,e->e));

        List<TestPlan> update = new ArrayList<>();
        List<TestPlan> create = new ArrayList<>();

        for(TestPlan sub:list) {
            sub.setReleaseId(release.getId());
            sub.setRelease(release);
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
	public List<TestPlan> findBySprintId(List<String> sprintIds){
        List<TestPlan> list = baseMapper.findBySprintId(sprintIds);
        if(!ObjectUtils.isEmpty(list))
            relationService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setWorkItemRelations(sub.getValue())));
        return list;	
	}

	public boolean removeBySprintId(String sprintId){
        return this.remove(Wrappers.<TestPlan>lambdaQuery().eq(TestPlan::getSprintId,sprintId));
	}

	public boolean resetBySprintId(String sprintId){
		return this.update(Wrappers.<TestPlan>lambdaUpdate().eq(TestPlan::getSprintId,sprintId));
	}
	public boolean saveBySprint(Sprint sprint, List<TestPlan> list){
        if(list==null)
            return true;
        Map<String,TestPlan> before = findBySprintId(sprint.getId()).stream().collect(Collectors.toMap(TestPlan::getId,e->e));

        List<TestPlan> update = new ArrayList<>();
        List<TestPlan> create = new ArrayList<>();

        for(TestPlan sub:list) {
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
	public List<TestPlan> findById(List<String> ids){
        List<TestPlan> list = baseMapper.findById(ids);
        if(!ObjectUtils.isEmpty(list))
            relationService.findByPrincipalId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getPrincipalId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setWorkItemRelations(sub.getValue())));
        return list;	
	}

	public boolean removeById(String id){
        return this.remove(Wrappers.<TestPlan>lambdaQuery().eq(TestPlan::getId,id));
	}

	public boolean resetById(String id){
		return this.update(Wrappers.<TestPlan>lambdaUpdate().eq(TestPlan::getId,id));
	}
	public boolean saveByTestPlan(CommonFlow commonFlow, List<TestPlan> list){
        if(list==null)
            return true;
        Map<String,TestPlan> before = findById(commonFlow.getId()).stream().collect(Collectors.toMap(TestPlan::getId,e->e));

        List<TestPlan> update = new ArrayList<>();
        List<TestPlan> create = new ArrayList<>();

        for(TestPlan sub:list) {
            sub.setId(commonFlow.getId());
            sub.setTestPlan(commonFlow);
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
	@Override
    public List<Relation> getWorkItemRelations(TestPlan et) {
        List<Relation> list = relationService.findByPrincipalId(et.getId());
        et.setWorkItemRelations(list);
        return list;
    }
	

    public void fillParentData(TestPlan et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setLibraryId((String)et.getContextParentKey());
            Library library = et.getLibrary();
            if(library == null) {
                library = libraryService.getById(et.getLibraryId());
                et.setLibrary(library);
            }
            if(!ObjectUtils.isEmpty(library)) {
                et.setLibraryIdentifier(library.getIdentifier());
                et.setLibraryId(library.getId());
                et.setLibraryName(library.getName());
            }
        }
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
            Project project = et.getProject();
            if(project == null) {
                project = projectService.getById(et.getProjectId());
                et.setProject(project);
            }
            if(!ObjectUtils.isEmpty(project)) {
                et.setProjectType(project.getType());
                et.setProjectId(project.getId());
                et.setProjectName(project.getName());
            }
        }
        if(Entities.RELEASE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setReleaseId((String)et.getContextParentKey());
            Release release = et.getRelease();
            if(release == null) {
                release = releaseService.getById(et.getReleaseId());
                et.setRelease(release);
            }
            if(!ObjectUtils.isEmpty(release)) {
                et.setReleaseId(release.getId());
                et.setReleaseName(release.getName());
            }
        }
        if(Entities.SPRINT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSprintId((String)et.getContextParentKey());
            Sprint sprint = et.getSprint();
            if(sprint == null) {
                sprint = sprintService.getById(et.getSprintId());
                et.setSprint(sprint);
            }
            if(!ObjectUtils.isEmpty(sprint)) {
                et.setSprintId(sprint.getId());
                et.setSprintName(sprint.getName());
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
        return TestPlanMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return TestPlan.class;
    }

}