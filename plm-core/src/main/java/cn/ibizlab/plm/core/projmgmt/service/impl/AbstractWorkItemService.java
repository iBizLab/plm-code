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

    public List<WorkItem> getByEntities(List<WorkItem> entities) {
        return this.baseMapper.selectEntities(entities);
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
                et.setWorkItemTypeId(workItemType.getId());
                et.setWorkItemTypeName(workItemType.getName());
            }
        }
    }

    public WorkItem getDraft(WorkItem et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(WorkItem et) {
        fillParentData(et);
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getId, et.getId()))>0)?1:0;
    }

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
    public boolean createBatch(List<WorkItem> list) {
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
    public boolean updateBatch(List<WorkItem> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(WorkItem et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<WorkItem> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,WorkItem> before = getByEntities(list).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(WorkItem et) {
        if(!remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<WorkItem> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<WorkItem> searchDefault(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchAdvancedSearch(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchAdvancedSearch(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listAdvancedSearch(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listAdvancedSearch(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchArchived(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listArchived(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchBacklogPropertyDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchBacklogPropertyDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listBacklogPropertyDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listBacklogPropertyDistribution(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchBacklogStateDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchBacklogStateDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listBacklogStateDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listBacklogStateDistribution(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchBug(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listBug(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchBugStateGroupGrid(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchBugStateGroupGrid(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listBugStateGroupGrid(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listBugStateGroupGrid(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchChangeParent(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchChild(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchChild(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listChild(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listChild(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchChooseChild(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchChooseChild(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listChooseChild(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listChooseChild(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchCommentNotifyAssignee(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchCommentNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listCommentNotifyAssignee(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listCommentNotifyAssignee(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchCommon(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchCommon(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listCommon(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listCommon(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchCommonBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchCommonBug(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listCommonBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listCommonBug(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchDefectPropertyDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchDefectPropertyDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listDefectPropertyDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listDefectPropertyDistribution(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchDeleted(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listDeleted(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchIdeaRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchIdeaRelationWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listIdeaRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listIdeaRelationWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchKanbanUserStat(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchKanbanUserStat(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listKanbanUserStat(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listKanbanUserStat(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchMilestone(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchMyAssignee(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchMyAssigneeCount(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchMyAssigneeCount(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listMyAssigneeCount(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listMyAssigneeCount(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchMyAttention(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyAttention(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listMyAttention(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listMyAttention(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchMyCreated(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchMyFilter(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyFilter(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listMyFilter(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listMyFilter(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchMyTodo(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchMyTodo(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listMyTodo(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("SHOW_IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listMyTodo(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchNoBugWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNoBugWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listNoBugWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listNoBugWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchNormal(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listNormal(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchNotExsistsBugRelation(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotExsistsBugRelation(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listNotExsistsBugRelation(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listNotExsistsBugRelation(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchNotExsistsRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotExsistsRelation(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listNotExsistsRelation(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listNotExsistsRelation(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchNotbugExsistsRelation(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotbugExsistsRelation(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listNotbugExsistsRelation(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listNotbugExsistsRelation(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchNotifyAssignee(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchNotifyAssignee(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listNotifyAssignee(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listNotifyAssignee(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchOverviewChart(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchPlan(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchPlan(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listPlan(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listPlan(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchPropertyDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchPropertyDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listPropertyDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listPropertyDistribution(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchRecentWorkItem(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchRequirement(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchRequirementTree(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchRequirementTree(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listRequirementTree(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listRequirementTree(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchResourceAssignment(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchResourceAssignment(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listResourceAssignment(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listResourceAssignment(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchRunRelationWorkItem(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchRunRelationWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listRunRelationWorkItem(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listRunRelationWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchSprintUserStat(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchSprintUserStat(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listSprintUserStat(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listSprintUserStat(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchTempSpeedReport(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchTempSpeedReport(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listTempSpeedReport(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listTempSpeedReport(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchTestCaseRelationBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTestCaseRelationBug(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listTestCaseRelationBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listTestCaseRelationBug(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchTestCaseRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTestCaseRelationWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listTestCaseRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listTestCaseRelationWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchTestPlanRelationBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTestPlanRelationBug(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listTestPlanRelationBug(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listTestPlanRelationBug(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchTicketRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTicketRelationWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listTicketRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listTicketRelationWorkItem(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchTop(WorkItemSearchContext context) {
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

    public Page<WorkItem> searchTreeTileGridQuery(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchTreeTileGridQuery(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listTreeTileGridQuery(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listTreeTileGridQuery(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchUnderWork(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchUnderWork(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listUnderWork(WorkItemSearchContext context) {
        List<WorkItem> list = baseMapper.listUnderWork(context,context.getSelectCond());
        return list;
    }

    public Page<WorkItem> searchWorkItemDistribution(WorkItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map> pages=baseMapper.searchWorkItemDistribution(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WorkItem>(cn.ibizlab.util.helper.JacksonUtils.toArray(pages.getRecords(),WorkItem.class), context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listWorkItemDistribution(WorkItemSearchContext context) {
        return cn.ibizlab.util.helper.JacksonUtils.toArray(baseMapper.listWorkItemDistribution(context,context.getSelectCond()),WorkItem.class);
    }

    public Page<WorkItem> searchWorkItemRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WorkItem> pages=baseMapper.searchWorkItemRelationWorkItem(context.getPages(),context,context.getSelectCond());
        List<WorkItem> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<WorkItem> listWorkItemRelationWorkItem(WorkItemSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("IDENTIFIER,ASC");
        List<WorkItem> list = baseMapper.listWorkItemRelationWorkItem(context,context.getSelectCond());
        return list;
    }

    public List<WorkItem> findByBoardId(List<String> boardIds) {
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
    public List<WorkItem> findByEntryId(List<String> entryIds) {
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
    public List<WorkItem> findByProjectId(List<String> projectIds) {
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
    public List<WorkItem> findByReleaseId(List<String> releaseIds) {
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
    public List<WorkItem> findBySprintId(List<String> sprintIds) {
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
    public List<WorkItem> findBySwimlaneId(List<String> swimlaneIds) {
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
    public List<WorkItem> findByAssigneeId(List<String> assigneeIds) {
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
    public List<WorkItem> findByPid(List<String> pids) {
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
    public List<WorkItem> findByState(List<String> states) {
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
    public List<WorkItem> findByTopId(List<String> topIds) {
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
    public List<WorkItem> findByWorkItemTypeId(List<String> workItemTypeIds) {
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
    public boolean removeByBoardId(String boardId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getBoardId,boardId));
    }

    public boolean resetByBoardId(String boardId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getBoardId,boardId));
    }

    public boolean saveByBoard(Board board,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByBoardId(board.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByEntryId(String entryId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getEntryId,entryId));
    }

    public boolean resetByEntryId(String entryId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getEntryId,entryId));
    }

    public boolean saveByEntry(Entry entry,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByEntryId(entry.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByProjectId(String projectId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getProjectId,projectId));
    }

    public boolean resetByProjectId(String projectId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getProjectId,projectId));
    }

    public boolean saveByProject(Project project,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByProjectId(project.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByReleaseId(String releaseId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getReleaseId,releaseId));
    }

    public boolean resetByReleaseId(String releaseId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getReleaseId,releaseId));
    }

    public boolean saveByRelease(Release release,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByReleaseId(release.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeBySprintId(String sprintId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getSprintId,sprintId));
    }

    public boolean resetBySprintId(String sprintId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getSprintId,sprintId));
    }

    public boolean saveBySprint(Sprint sprint,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findBySprintId(sprint.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeBySwimlaneId(String swimlaneId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getSwimlaneId,swimlaneId));
    }

    public boolean resetBySwimlaneId(String swimlaneId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getSwimlaneId,swimlaneId));
    }

    public boolean saveBySwimlane(Swimlane swimlane,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findBySwimlaneId(swimlane.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByAssigneeId(String assigneeId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getAssigneeId,assigneeId));
    }

    public boolean resetByAssigneeId(String assigneeId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getAssigneeId,assigneeId));
    }

    public boolean saveByUser(User user,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByAssigneeId(user.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByPid(String pid) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getPid,pid));
    }

    public boolean resetByPid(String pid) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getPid,pid));
    }

    public boolean saveByWorkItem(WorkItem workItem,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByPid(workItem.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByState(String state) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getState,state));
    }

    public boolean resetByState(String state) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getState,state));
    }

    public boolean saveByWorkItemState(WorkItemState workItemState,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByState(workItemState.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByTopId(String topId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getTopId,topId));
    }

    public boolean resetByTopId(String topId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getTopId,topId));
    }

    public boolean saveByWorkItem2(WorkItem workItem,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByTopId(workItem.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean removeByWorkItemTypeId(String workItemTypeId) {
        return this.remove(Wrappers.<WorkItem>lambdaQuery().eq(WorkItem::getWorkItemTypeId,workItemTypeId));
    }

    public boolean resetByWorkItemTypeId(String workItemTypeId) {
        return this.update(Wrappers.<WorkItem>lambdaUpdate().eq(WorkItem::getWorkItemTypeId,workItemTypeId));
    }

    public boolean saveByWorkItemType(WorkItemType workItemType,List<WorkItem> list) {
        if(list==null)
            return true;
        Map<String,WorkItem> before = findByWorkItemTypeId(workItemType.getId()).stream().collect(Collectors.toMap(WorkItem::getId,e->e));
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
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    @Override
    public List<Attention> getAttentions(WorkItem et) {
        List<Attention> list = attentionService.findByOwnerId(et.getId());
        et.setAttentions(list);
        return list;
    }

    @Override
    public List<Attachment> getAttachments(WorkItem et) {
        List<Attachment> list = attachmentService.findByOwnerId(et.getId());
        et.setAttachments(list);
        return list;
    }

    @Override
    public List<Deliverable> getDeliverable(WorkItem et) {
        List<Deliverable> list = deliverableService.findByOwnerId(et.getId());
        et.setDeliverable(list);
        return list;
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
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