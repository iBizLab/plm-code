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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.mapper.ProjectMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.service.BoardService;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.service.EntryService;
import cn.ibizlab.plm.core.projmgmt.domain.Progress;
import cn.ibizlab.plm.core.projmgmt.service.ProgressService;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.projmgmt.service.ProjectMemberService;
import cn.ibizlab.plm.core.extension.domain.PSDELogicNode;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.service.SwimlaneService;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.service.TestPlanService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemTypeService;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.service.FavoriteService;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.service.AddonService;
import cn.ibizlab.plm.core.base.domain.AddonResource;
import cn.ibizlab.plm.core.base.service.AddonResourceService;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.service.MemberService;
import cn.ibizlab.plm.core.base.domain.Work;
import cn.ibizlab.plm.core.base.service.WorkService;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import cn.ibizlab.plm.core.base.service.ReferencesIndexService;

/**
 * 实体[项目] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractProjectService extends ServiceImpl<ProjectMapper,Project> implements ProjectService {

    @Autowired
    @Lazy
    protected BoardService boardService;

    @Autowired
    @Lazy
    protected EntryService entryService;

    @Autowired
    @Lazy
    protected ProgressService progressService;

    @Autowired
    @Lazy
    protected ProjectMemberService projectMemberService;

    @Autowired
    @Lazy
    protected ReleaseService releaseService;

    @Autowired
    @Lazy
    protected SprintService sprintService;

    @Autowired
    @Lazy
    protected SwimlaneService swimlaneService;

    @Autowired
    @Lazy
    protected TestPlanService testPlanService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

    @Autowired
    @Lazy
    protected WorkItemTypeService workItemTypeService;

    @Autowired
    @Lazy
    protected FavoriteService favoriteService;

    @Autowired
    @Lazy
    protected AddonService addonService;

    @Autowired
    @Lazy
    protected AddonResourceService addonResourceService;

    @Autowired
    @Lazy
    protected BaselineService baselineService;

    @Autowired
    @Lazy
    protected MemberService memberService;

    @Autowired
    @Lazy
    protected WorkService workService;

    @Autowired
    @Lazy
    protected ReferencesIndexService referencesIndexService;

    @Autowired
    @Lazy
    protected cn.ibizlab.plm.core.projmgmt.mapping.ProjectInheritMapping projectInheritMapping;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Project et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        projectMemberService.saveByProject(et,et.getMembers());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Project> list) {
        list.forEach(et->getSelf().create(et));
        return true;
    }
	
    @Transactional
    public boolean update(Project et) {
        UpdateWrapper<Project> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        projectMemberService.saveByProject(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Project> list) {
        list.forEach(et->getSelf().update(et));
        return true;
    }
	
   @Transactional
    public boolean remove(Project et) {
        if(!remove(Wrappers.<Project>lambdaQuery().eq(Project::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Project> entities) {
        for (Project et : entities)
            if(!getSelf().remove(et))
                return false;
        return true;
    }		
    public Project get(Project et) {
        Project rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.PROJECT.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [项目成员]
        getMembers(et);
        return et;
    }	

    public List<Project> get(List<Project> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Project getDraft(Project et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Project et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Project>lambdaQuery().eq(Project::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Project et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Project> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Project> before = get(list).stream().collect(Collectors.toMap(Project::getId,e->e));
        List<Project> create = new ArrayList<>();
        List<Project> update = new ArrayList<>();
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
	
   public Page<Project> fetchDefault(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listDefault(ProjectSearchContext context) {
        List<Project> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchAdmin(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listAdmin(ProjectSearchContext context) {
        List<Project> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchArchived(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listArchived(ProjectSearchContext context) {
        List<Project> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchBiDetail(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchBiDetail(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listBiDetail(ProjectSearchContext context) {
        List<Project> list = baseMapper.listBiDetail(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchBiSearch(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchBiSearch(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listBiSearch(ProjectSearchContext context) {
        List<Project> list = baseMapper.listBiSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchChooseProject(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchChooseProject(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listChooseProject(ProjectSearchContext context) {
        List<Project> list = baseMapper.listChooseProject(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchCurrent(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchCurrent(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listCurrent(ProjectSearchContext context) {
        List<Project> list = baseMapper.listCurrent(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchDeleted(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listDeleted(ProjectSearchContext context) {
        List<Project> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchFavorite(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listFavorite(ProjectSearchContext context) {
        List<Project> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchMain(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchMain(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listMain(ProjectSearchContext context) {
        List<Project> list = baseMapper.listMain(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchNormal(ProjectSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listNormal(ProjectSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("NAME,DESC");
        List<Project> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchQuickUser(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchQuickUser(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listQuickUser(ProjectSearchContext context) {
        List<Project> list = baseMapper.listQuickUser(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchReader(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listReader(ProjectSearchContext context) {
        List<Project> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchSameType(ProjectSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchSameType(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listSameType(ProjectSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Project> list = baseMapper.listSameType(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchUnderProjectPortfolio(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchUnderProjectPortfolio(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listUnderProjectPortfolio(ProjectSearchContext context) {
        List<Project> list = baseMapper.listUnderProjectPortfolio(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchUser(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listUser(ProjectSearchContext context) {
        List<Project> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
   }
	
   public Page<Project> fetchWorkProject(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchWorkProject(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listWorkProject(ProjectSearchContext context) {
        List<Project> list = baseMapper.listWorkProject(context,context.getSelectCond());
        return list;
   }
	
	public List<Project> findById(List<String> ids){
        List<Project> list = baseMapper.findById(ids);
        if(!ObjectUtils.isEmpty(list))
            projectMemberService.findByProjectId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getProjectId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setMembers(sub.getValue())));
        return list;	
	}

	public List<Project> findByProject(CommonFlow commonFlow){
        List<Project> list = findById(Arrays.asList(commonFlow.getId()));
		return list;
	}
	public boolean removeById(String id){
        List<String> ids = baseMapper.findById(Arrays.asList(id)).stream().map(e->e.getId()).collect(Collectors.toList());
        if(!ObjectUtils.isEmpty(ids))
            return this.remove(ids);
        else
            return true;
	}

	public boolean resetById(String id){
		return this.update(Wrappers.<Project>lambdaUpdate().set(Project::getId, null).eq(Project::getId,id));
	}
	public boolean saveByProject(CommonFlow commonFlow, List<Project> list){
        if(list==null)
            return true;

        Map<String,Project> before = findByProject(commonFlow).stream().collect(Collectors.toMap(Project::getId,e->e));
        List<Project> update = new ArrayList<>();
        List<Project> create = new ArrayList<>();

        for(Project sub:list) {
            sub.setId(commonFlow.getId());
            sub.setProject(commonFlow);
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
    public List<ProjectMember> getMembers(Project et) {
        List<ProjectMember> list = projectMemberService.findByProject(et);
        et.setMembers(list);
        return list;
    }
	
   public Page<Project> fetchView(ProjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Project> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Project> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Project> listView(ProjectSearchContext context) {
        List<Project> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Project et) {
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
        return ProjectMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Project.class;
    }

}