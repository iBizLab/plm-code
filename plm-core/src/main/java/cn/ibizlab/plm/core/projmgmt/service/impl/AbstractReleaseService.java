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
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;
import cn.ibizlab.plm.core.projmgmt.mapper.ReleaseMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.projmgmt.service.StageService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[项目发布] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractReleaseService extends ServiceImpl<ReleaseMapper,Release> implements ReleaseService {

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected StageService stageService;

    @Autowired
    @Lazy
    protected TestPlanService testPlanService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Release et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        stageService.saveByRelease(et,et.getStageTransitions());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Release> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Release et) {
        UpdateWrapper<Release> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        stageService.saveByRelease(et,et.getStageTransitions());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Release> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Release et) {
        String key = et.getId();
        stageService.removeByReleaseId(key);
        testPlanService.resetByReleaseId(key);
        workItemService.resetByReleaseId(key);
        if(!remove(Wrappers.<Release>lambdaQuery().eq(Release::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Release> entities) {
        for (Release et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Release get(Release et) {
        Release rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.RELEASE.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [发布阶段]
        getStageTransitions(et);
        return et;
    }	

    public List<Release> get(List<Release> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Release getDraft(Release et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Release et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Release>lambdaQuery().eq(Release::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Release et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Release> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Release> before = get(list).stream().collect(Collectors.toMap(Release::getId,e->e));
        List<Release> create = new ArrayList<>();
        List<Release> update = new ArrayList<>();
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
	
   public Page<Release> fetchDefault(ReleaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listDefault(ReleaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<Release> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Release> fetchBiDetail(ReleaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchBiDetail(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listBiDetail(ReleaseSearchContext context) {
        List<Release> list = baseMapper.listBiDetail(context,context.getSelectCond());
        return list;
   }
	
   public Page<Release> fetchBiSearch(ReleaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchBiSearch(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listBiSearch(ReleaseSearchContext context) {
        List<Release> list = baseMapper.listBiSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<Release> fetchChooseReleseRelation(ReleaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("END_AT,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchChooseReleseRelation(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listChooseReleseRelation(ReleaseSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("END_AT,DESC");
        List<Release> list = baseMapper.listChooseReleseRelation(context,context.getSelectCond());
        return list;
   }
	
   public Page<Release> fetchNotPublished(ReleaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchNotPublished(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listNotPublished(ReleaseSearchContext context) {
        List<Release> list = baseMapper.listNotPublished(context,context.getSelectCond());
        return list;
   }
	
   public Page<Release> fetchReader(ReleaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listReader(ReleaseSearchContext context) {
        List<Release> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<Release> fetchSprintRelation(ReleaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchSprintRelation(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listSprintRelation(ReleaseSearchContext context) {
        List<Release> list = baseMapper.listSprintRelation(context,context.getSelectCond());
        return list;
   }
	
	public List<Release> findByProjectId(List<String> projectIds){
        List<Release> list = baseMapper.findByProjectId(projectIds);
        if(!ObjectUtils.isEmpty(list))
            stageService.findByReleaseId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getReleaseId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setStageTransitions(sub.getValue())));
        return list;	
	}

	public List<Release> findByProject(Project project){
        List<Release> list = findByProjectId(Arrays.asList(project.getId()));
		return list;
	}
	public boolean removeByProjectId(String projectId){
        List<String> ids = baseMapper.findByProjectId(Arrays.asList(projectId)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetByProjectId(String projectId){
		return this.update(Wrappers.<Release>lambdaUpdate().eq(Release::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<Release> list){
        if(list==null)
            return true;

        Map<String,Release> before = findByProject(project).stream().collect(Collectors.toMap(Release::getId,e->e));
        List<Release> update = new ArrayList<>();
        List<Release> create = new ArrayList<>();

        for(Release sub:list) {
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
	@Override
    public List<Stage> getStageTransitions(Release et) {
        List<Stage> list = stageService.findByRelease(et);
        et.setStageTransitions(list);
        return list;
    }
	
   public Page<Release> fetchView(ReleaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Release> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Release> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Release> listView(ReleaseSearchContext context) {
        List<Release> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Release et) {
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setProjectId((String)et.getContextParentKey());
            Project project = et.getProject();
            if(project == null) {
                project = projectService.getById(et.getProjectId());
                et.setProject(project);
            }
            if(!ObjectUtils.isEmpty(project)) {
                et.setProjectId(project.getId());
                et.setProjectName(project.getName());
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
        return ReleaseMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Release.class;
    }

}