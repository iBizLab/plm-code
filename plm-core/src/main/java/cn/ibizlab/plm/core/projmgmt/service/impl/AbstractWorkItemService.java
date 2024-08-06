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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemSearchContext;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemService;
import cn.ibizlab.plm.core.projmgmt.mapper.WorkItemMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.service.BoardService;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.service.EntryService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.service.ReleaseService;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.service.SprintService;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.projmgmt.service.SwimlaneService;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemStateService;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.service.WorkItemTypeService;
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.core.projmgmt.service.SprintAlterationService;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.service.AttentionService;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.service.CommentService;
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.service.RecentService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;
import cn.ibizlab.plm.core.projmgmt.domain.TransitionHistory;
import cn.ibizlab.plm.core.projmgmt.service.TransitionHistoryService;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.service.VersionService;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.service.AttachmentService;
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.service.DeliverableService;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.service.SearchAttachmentService;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.service.SearchCommentService;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.service.WorkloadService;

/**
 * 实体[工作项] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractWorkItemService extends ServiceImpl<WorkItemMapper,WorkItem> implements WorkItemService {

    @Autowired
    @Lazy
    protected BoardService boardService;

    @Autowired
    @Lazy
    protected EntryService entryService;

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
    protected SwimlaneService swimlaneService;

    @Autowired
    @Lazy
    protected WorkItemStateService workItemStateService;

    @Autowired
    @Lazy
    protected WorkItemTypeService workItemTypeService;

    @Autowired
    @Lazy
    protected SprintAlterationService sprintAlterationService;

    @Autowired
    @Lazy
    protected AttentionService attentionService;

    @Autowired
    @Lazy
    protected CommentService commentService;

    @Autowired
    @Lazy
    protected RecentService recentService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    @Autowired
    @Lazy
    protected TransitionHistoryService transitionHistoryService;

    @Autowired
    @Lazy
    protected VersionService versionService;

    @Autowired
    @Lazy
    protected AttachmentService attachmentService;

    @Autowired
    @Lazy
    protected DeliverableService deliverableService;

    @Autowired
    @Lazy
    protected SearchAttachmentService searchAttachmentService;

    @Autowired
    @Lazy
    protected SearchCommentService searchCommentService;

    @Autowired
    @Lazy
    protected WorkloadService workloadService;

    @Autowired
    @Lazy
    protected WorkItemService workItemService;

        protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WorkItem et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        attentionService.saveByWorkItem(et,et.getAttentions());
        attachmentService.saveByWorkItem(et,et.getAttachments());
        deliverableService.saveByWorkItem(et,et.getDeliverable());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<WorkItem> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(WorkItem et) {
        fillParentData(et);
        UpdateWrapper<WorkItem> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        attentionService.saveByWorkItem(et,et.getAttentions());
        attachmentService.saveByWorkItem(et,et.getAttachments());
        deliverableService.saveByWorkItem(et,et.getDeliverable());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<WorkItem> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(WorkItem et) {
        if(!remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<WorkItem> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public WorkItem get(WorkItem et) {
        WorkItem rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.WORK_ITEM.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [关注]
        getAttentions(et);
        //设置 [附件]
        getAttachments(et);
        //设置 [交付物]
        getDeliverable(et);
        return et;
    }	

    public List<WorkItem> get(List<WorkItem> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public WorkItem getDraft(WorkItem et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(WorkItem et) {
        fillParentData(et);
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(WorkItem et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<WorkItem> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,WorkItem> before = get(list).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> create = new ArrayList<>();
        List<WorkItem> update = new ArrayList<>();
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
	
   public Page<WorkItem> fetchDefault(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listDefault(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchAdvancedSearch(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchAdvancedSearch(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listAdvancedSearch(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listAdvancedSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchArchived(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listArchived(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchBacklogPropertyDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchBacklogPropertyDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listBacklogPropertyDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listBacklogPropertyDistribution(context,context.getSelectCond()),WorkItem.class);
   }
	
   public Page<WorkItem> fetchBacklogStateDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchBacklogStateDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listBacklogStateDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listBacklogStateDistribution(context,context.getSelectCond()),WorkItem.class);
   }
	
   public Page<WorkItem> fetchBaselineChooseWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchBaselineChooseWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listBaselineChooseWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listBaselineChooseWorkItem(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchBiDetail(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchBiDetail(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listBiDetail(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listBiDetail(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchBiSearch(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchBiSearch(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listBiSearch(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listBiSearch(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchBug(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listBug(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchBugStateGroupGrid(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchBugStateGroupGrid(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listBugStateGroupGrid(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listBugStateGroupGrid(context,context.getSelectCond()),WorkItem.class);
   }
	
   public Page<WorkItem> fetchChangeParent(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchChangeParent(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listChangeParent(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listChangeParent(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchChild(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchChild(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listChild(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listChild(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchChooseChild(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchChooseChild(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listChooseChild(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listChooseChild(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchChooseDependency(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchChooseDependency(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listChooseDependency(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listChooseDependency(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchCommentNotifyAssignee(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchCommentNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listCommentNotifyAssignee(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listCommentNotifyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchCommon(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchCommon(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listCommon(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listCommon(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchCommonBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchCommonBug(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listCommonBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listCommonBug(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchDefectPropertyDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchDefectPropertyDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listDefectPropertyDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listDefectPropertyDistribution(context,context.getSelectCond()),WorkItem.class);
   }
	
   public Page<WorkItem> fetchDeleted(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listDeleted(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchKanbanUserStat(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchKanbanUserStat(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listKanbanUserStat(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listKanbanUserStat(context,context.getSelectCond()),WorkItem.class);
   }
	
   public Page<WorkItem> fetchMilestone(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMilestone(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMilestone(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listMilestone(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchMoveWorkItem(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMoveWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMoveWorkItem(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listMoveWorkItem(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchMyAssignee(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyAssignee(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMyAssignee(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<WorkItem> list = baseMapper.listMyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchMyAssigneeCount(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchMyAssigneeCount(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMyAssigneeCount(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listMyAssigneeCount(context,context.getSelectCond()),WorkItem.class);
   }
	
   public Page<WorkItem> fetchMyAttention(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyAttention(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMyAttention(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listMyAttention(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchMyCreated(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyCreated(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMyCreated(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<WorkItem> list = baseMapper.listMyCreated(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchMyFilter(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyFilter(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMyFilter(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<WorkItem> list = baseMapper.listMyFilter(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchMyTodo(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyTodo(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listMyTodo(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listMyTodo(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchNoBugWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNoBugWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listNoBugWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listNoBugWorkItem(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchNormal(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listNormal(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchNotExsistsBugRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotExsistsBugRelation(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listNotExsistsBugRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listNotExsistsBugRelation(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchNotExsistsRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotExsistsRelation(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listNotExsistsRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listNotExsistsRelation(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchNotbugExsistsRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotbugExsistsRelation(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listNotbugExsistsRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listNotbugExsistsRelation(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchNotifyAssignee(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listNotifyAssignee(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listNotifyAssignee(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchOverviewChart(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("WORK_ITEM_TYPE_SEQUENCE,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchOverviewChart(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listOverviewChart(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("WORK_ITEM_TYPE_SEQUENCE,ASC");
        List<WorkItem> list = baseMapper.listOverviewChart(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchPlanSnapshot(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchPlanSnapshot(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listPlanSnapshot(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listPlanSnapshot(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchProjectResource(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchProjectResource(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listProjectResource(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listProjectResource(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchPropertyDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchPropertyDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listPropertyDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listPropertyDistribution(context,context.getSelectCond()),WorkItem.class);
   }
	
   public Page<WorkItem> fetchReader(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listReader(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchRecentWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchRecentWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listRecentWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listRecentWorkItem(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchRelease(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchRelease(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listRelease(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listRelease(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchReleasePlan(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchReleasePlan(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listReleasePlan(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listReleasePlan(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchReleaseWorkItemChart(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchReleaseWorkItemChart(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listReleaseWorkItemChart(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listReleaseWorkItemChart(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchRequirement(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchRequirement(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listRequirement(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listRequirement(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchRequirementTree(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchRequirementTree(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listRequirementTree(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listRequirementTree(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchResource(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchResource(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listResource(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listResource(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchSevenDays(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchSevenDays(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listSevenDays(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listSevenDays(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchSprintCompleted(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("COMPLETED_AT,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchSprintCompleted(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listSprintCompleted(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("COMPLETED_AT,ASC");
        List<WorkItem> list = baseMapper.listSprintCompleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchSprintWorkItemChart(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchSprintWorkItemChart(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listSprintWorkItemChart(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listSprintWorkItemChart(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchTestPlanRelationBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTestPlanRelationBug(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listTestPlanRelationBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listTestPlanRelationBug(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchTop(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTop(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listTop(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listTop(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchTree(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTree(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listTree(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listTree(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchUnderWork(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchUnderWork(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listUnderWork(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,DESC");
        List<WorkItem> list = baseMapper.listUnderWork(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchUnderWorkResource(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchUnderWorkResource(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listUnderWorkResource(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listUnderWorkResource(context,context.getSelectCond());
        return list;
   }
	
   public Page<WorkItem> fetchWorkItemType(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchWorkItemType(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listWorkItemType(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listWorkItemType(context,context.getSelectCond());
        return list;
   }
	
	public List<WorkItem> findByBoardId(List<String> boardIds){
        List<WorkItem> list = baseMapper.findByBoardId(boardIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByBoard(Board board){
        List<WorkItem> list = findByBoardId(Arrays.asList(board.getId()));
		return list;
	}
	public boolean removeByBoardId(String boardId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getBoardId,boardId));
	}

	public boolean resetByBoardId(String boardId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getBoardId, null).eq(WorkItem::getBoardId,boardId));
	}
	public boolean saveByBoard(Board board, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByBoard(board).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setBoardId(board.getId());
            sub.setBoard(board);
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
	public List<WorkItem> findByEntryId(List<String> entryIds){
        List<WorkItem> list = baseMapper.findByEntryId(entryIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByEntry(Entry entry){
        List<WorkItem> list = findByEntryId(Arrays.asList(entry.getId()));
		return list;
	}
	public boolean removeByEntryId(String entryId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getEntryId,entryId));
	}

	public boolean resetByEntryId(String entryId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getEntryId, null).eq(WorkItem::getEntryId,entryId));
	}
	public boolean saveByEntry(Entry entry, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByEntry(entry).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setEntryId(entry.getId());
            sub.setEntry(entry);
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
	public List<WorkItem> findByProjectId(List<String> projectIds){
        List<WorkItem> list = baseMapper.findByProjectId(projectIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByProject(Project project){
        List<WorkItem> list = findByProjectId(Arrays.asList(project.getId()));
		return list;
	}
	public boolean removeByProjectId(String projectId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getProjectId,projectId));
	}

	public boolean resetByProjectId(String projectId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getProjectId, null).eq(WorkItem::getProjectId,projectId));
	}
	public boolean saveByProject(Project project, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByProject(project).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
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
	public List<WorkItem> findByReleaseId(List<String> releaseIds){
        List<WorkItem> list = baseMapper.findByReleaseId(releaseIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByRelease(Release release){
        List<WorkItem> list = findByReleaseId(Arrays.asList(release.getId()));
		return list;
	}
	public boolean removeByReleaseId(String releaseId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getReleaseId,releaseId));
	}

	public boolean resetByReleaseId(String releaseId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getReleaseId, null).eq(WorkItem::getReleaseId,releaseId));
	}
	public boolean saveByRelease(Release release, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByRelease(release).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
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
	public List<WorkItem> findBySprintId(List<String> sprintIds){
        List<WorkItem> list = baseMapper.findBySprintId(sprintIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findBySprint(Sprint sprint){
        List<WorkItem> list = findBySprintId(Arrays.asList(sprint.getId()));
		return list;
	}
	public boolean removeBySprintId(String sprintId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getSprintId,sprintId));
	}

	public boolean resetBySprintId(String sprintId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getSprintId, null).eq(WorkItem::getSprintId,sprintId));
	}
	public boolean saveBySprint(Sprint sprint, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findBySprint(sprint).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
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
	public List<WorkItem> findBySwimlaneId(List<String> swimlaneIds){
        List<WorkItem> list = baseMapper.findBySwimlaneId(swimlaneIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findBySwimlane(Swimlane swimlane){
        List<WorkItem> list = findBySwimlaneId(Arrays.asList(swimlane.getId()));
		return list;
	}
	public boolean removeBySwimlaneId(String swimlaneId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getSwimlaneId,swimlaneId));
	}

	public boolean resetBySwimlaneId(String swimlaneId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getSwimlaneId, null).eq(WorkItem::getSwimlaneId,swimlaneId));
	}
	public boolean saveBySwimlane(Swimlane swimlane, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findBySwimlane(swimlane).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setSwimlaneId(swimlane.getId());
            sub.setSwimlane(swimlane);
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
	public List<WorkItem> findByAssigneeId(List<String> assigneeIds){
        List<WorkItem> list = baseMapper.findByAssigneeId(assigneeIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByUser(User user){
        List<WorkItem> list = findByAssigneeId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByAssigneeId(String assigneeId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getAssigneeId,assigneeId));
	}

	public boolean resetByAssigneeId(String assigneeId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getAssigneeId, null).eq(WorkItem::getAssigneeId,assigneeId));
	}
	public boolean saveByUser(User user, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByUser(user).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setAssigneeId(user.getId());
            sub.setUser(user);
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
	public List<WorkItem> findByPid(List<String> pids){
        List<WorkItem> list = baseMapper.findByPid(pids);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByWorkItem(WorkItem workItem){
        List<WorkItem> list = findByPid(Arrays.asList(workItem.getId()));
		return list;
	}
	public boolean removeByPid(String pid){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getPid,pid));
	}

	public boolean resetByPid(String pid){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getPid, null).eq(WorkItem::getPid,pid));
	}
	public boolean saveByWorkItem(WorkItem workItem, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByWorkItem(workItem).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setPid(workItem.getId());
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
	public List<WorkItem> findByState(List<String> states){
        List<WorkItem> list = baseMapper.findByState(states);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByWorkItemState(WorkItemState workItemState){
        List<WorkItem> list = findByState(Arrays.asList(workItemState.getId()));
		return list;
	}
	public boolean removeByState(String state){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getState,state));
	}

	public boolean resetByState(String state){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getState, null).eq(WorkItem::getState,state));
	}
	public boolean saveByWorkItemState(WorkItemState workItemState, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByWorkItemState(workItemState).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setState(workItemState.getId());
            sub.setWorkItemState(workItemState);
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
	public List<WorkItem> findByTopId(List<String> topIds){
        List<WorkItem> list = baseMapper.findByTopId(topIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByWorkItem2(WorkItem workItem){
        List<WorkItem> list = findByTopId(Arrays.asList(workItem.getId()));
		return list;
	}
	public boolean removeByTopId(String topId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getTopId,topId));
	}

	public boolean resetByTopId(String topId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getTopId, null).eq(WorkItem::getTopId,topId));
	}
	public boolean saveByWorkItem2(WorkItem workItem, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByWorkItem2(workItem).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setTopId(workItem.getId());
            sub.setWorkItem2(workItem);
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
	public List<WorkItem> findByWorkItemTypeId(List<String> workItemTypeIds){
        List<WorkItem> list = baseMapper.findByWorkItemTypeId(workItemTypeIds);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByWorkItemType(WorkItemType workItemType){
        List<WorkItem> list = findByWorkItemTypeId(Arrays.asList(workItemType.getId()));
		return list;
	}
	public boolean removeByWorkItemTypeId(String workItemTypeId){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getWorkItemTypeId,workItemTypeId));
	}

	public boolean resetByWorkItemTypeId(String workItemTypeId){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getWorkItemTypeId, null).eq(WorkItem::getWorkItemTypeId,workItemTypeId));
	}
	public boolean saveByWorkItemType(WorkItemType workItemType, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByWorkItemType(workItemType).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setWorkItemTypeId(workItemType.getId());
            sub.setWorkItemType(workItemType);
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
	public List<WorkItem> findById(List<String> ids){
        List<WorkItem> list = baseMapper.findById(ids);
        if(!ObjectUtils.isEmpty(list))
            attentionService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttentions(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            attachmentService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setAttachments(sub.getValue())));
        if(!ObjectUtils.isEmpty(list))
            deliverableService.findByOwnerId(list.stream().map(e->e.getId()).collect(Collectors.toList()))
                .stream().collect(Collectors.groupingBy(e->e.getOwnerId())).entrySet().forEach(sub->list.stream().filter(item->item.getId().equals(sub.getKey())).findFirst().ifPresent(item->item.setDeliverable(sub.getValue())));
        return list;	
	}

	public List<WorkItem> findByCommonFlow(CommonFlow commonFlow){
        List<WorkItem> list = findById(Arrays.asList(commonFlow.getId()));
		return list;
	}
	public boolean removeById(String id){
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getId,id));
	}

	public boolean resetById(String id){
		return this.update(Wrappers.<WorkItem>lambdaUpdate().set(WorkItem::getId, null).eq(WorkItem::getId,id));
	}
	public boolean saveByCommonFlow(CommonFlow commonFlow, List<WorkItem> list){
        if(list==null)
            return true;

        Map<String,WorkItem> before = findByCommonFlow(commonFlow).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
        List<WorkItem> update = new ArrayList<>();
        List<WorkItem> create = new ArrayList<>();

        for(WorkItem sub:list) {
            sub.setId(commonFlow.getId());
            sub.setCommonFlow(commonFlow);
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
    public List<Attention> getAttentions(WorkItem et) {
        List<Attention> list = attentionService.findByWorkItem(et);
        et.setAttentions(list);
        return list;
    }
	
	@Override
    public List<Attachment> getAttachments(WorkItem et) {
        List<Attachment> list = attachmentService.findByWorkItem(et);
        et.setAttachments(list);
        return list;
    }
	
	@Override
    public List<Deliverable> getDeliverable(WorkItem et) {
        List<Deliverable> list = deliverableService.findByWorkItem(et);
        et.setDeliverable(list);
        return list;
    }
	
   public Page<WorkItem> fetchView(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<WorkItem> listView(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(WorkItem et) {
        if(Entities.BOARD.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setBoardId((String)et.getContextParentKey());
            Board board = et.getBoard();
            if(board == null) {
                board = boardService.getById(et.getBoardId());
                et.setBoard(board);
            }
            if(!ObjectUtils.isEmpty(board)) {
                et.setBoardId(board.getId());
                et.setBoardName(board.getName());
            }
        }
        if(Entities.ENTRY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setEntryId((String)et.getContextParentKey());
            Entry entry = et.getEntry();
            if(entry == null) {
                entry = entryService.getById(et.getEntryId());
                et.setEntry(entry);
            }
            if(!ObjectUtils.isEmpty(entry)) {
                et.setEntryId(entry.getId());
                et.setEntryName(entry.getName());
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
                et.setProjectIdentifier(project.getIdentifier());
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
                et.setReleaseStatus(release.getStatus());
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
                et.setSprintStatus(sprint.getStatus());
                et.setSprintId(sprint.getId());
                et.setSprintName(sprint.getName());
            }
        }
        if(Entities.SWIMLANE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setSwimlaneId((String)et.getContextParentKey());
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setPid((String)et.getContextParentKey());
            WorkItem workItem = et.getWorkItem();
            if(workItem == null) {
                workItem = workItemService.getById(et.getPid());
                et.setWorkItem(workItem);
            }
            if(!ObjectUtils.isEmpty(workItem)) {
                et.setPid(workItem.getId());
                et.setPtitle(workItem.getTitle());
            }
        }
        if(Entities.WORK_ITEM_STATE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setState((String)et.getContextParentKey());
            WorkItemState workItemState = et.getWorkItemState();
            if(workItemState == null) {
                workItemState = workItemStateService.getById(et.getState());
                et.setWorkItemState(workItemState);
            }
            if(!ObjectUtils.isEmpty(workItemState)) {
                et.setState(workItemState.getId());
                et.setStateType(workItemState.getType());
            }
        }
        if(Entities.WORK_ITEM.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setTopId((String)et.getContextParentKey());
            WorkItem workItem = et.getWorkItem2();
            if(workItem == null) {
                workItem = workItemService.getById(et.getTopId());
                et.setWorkItem2(workItem);
            }
            if(!ObjectUtils.isEmpty(workItem)) {
                et.setTopId(workItem.getId());
                et.setTopTitle(workItem.getTitle());
            }
        }
        if(Entities.WORK_ITEM_TYPE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setWorkItemTypeId((String)et.getContextParentKey());
            WorkItemType workItemType = et.getWorkItemType();
            if(workItemType == null) {
                workItemType = workItemTypeService.getById(et.getWorkItemTypeId());
                et.setWorkItemType(workItemType);
            }
            if(!ObjectUtils.isEmpty(workItemType)) {
                et.setWorkItemTypeGroup(workItemType.getGroup());
                et.setWorkItemTypeSequence(workItemType.getSequence());
                et.setWorkItemSubType(workItemType.getSubType());
                et.setWorkItemOriginState(workItemType.getOrginState());
                et.setWorkItemTypeId(workItemType.getId());
                et.setWorkItemTypeName(workItemType.getName());
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
        return WorkItemMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return WorkItem.class;
    }

}