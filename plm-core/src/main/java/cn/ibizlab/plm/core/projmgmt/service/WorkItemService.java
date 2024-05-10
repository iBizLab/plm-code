/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.domain.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.ibizlab.util.security.SpringContextHolder;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemSearchContext;
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.projmgmt.domain.TransitionHistory;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Workload;

/**
 * 工作项服务接口[WorkItemService]
 *
 * @author generator
 */
public interface WorkItemService extends IService<WorkItem> {

    /**
     * 获取当前Service
     *
     * @return
     */
    default WorkItemService getSelf() {
        return SpringContextHolder.getBean(this.getClass());
    }

    /**
     * 获取
     * @param et
     * @return
     */
    WorkItem get(WorkItem et);
    /**
     * 获取
     * @param key
     * @return
     */
    default WorkItem get(String key) {
        return getSelf().get(new WorkItem().setId(key));
    }
    /**
     * id集合获取
     * @param ids
     * @return
     */
    default List<WorkItem> getByIds(Collection<String> ids) {
        List<WorkItem> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new WorkItem().setId(key)));
        return getSelf().getByEntities(entities);
    }
    /**
     * 对象集合获取
     * @param entities
     * @return
     */
    List<WorkItem> getByEntities(List<WorkItem> entities);

    /**
     * 草稿
     * @param et
     * @return
     */
    WorkItem getDraft(WorkItem et);

    /**
     * checkKey
     * @param et
     * @return
     */
    Integer checkKey(WorkItem et);

    /**
     * 创建
     * @param et
     * @return
     */
    boolean create(WorkItem et);
    /**
     * 批量创建
     * @param list
     * @return
     */
    boolean createBatch(List<WorkItem> list);

    /**
     * 更新
     * @param et
     * @return
     */
    boolean update(WorkItem et);
    /**
     * 批量更新
     * @param list
     * @return
     */
    boolean updateBatch(List<WorkItem> list);

    /**
     * 保存
     * @param et
     * @return
     */
    @Override
    boolean save(WorkItem et);
    /**
     * 批量保存
     * @param list
     * @return
     */
    boolean saveBatch(List<WorkItem> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new WorkItem().setId(key));
    }
    /**
     * 根据keys批量删除
     * @param keys
     * @return
     */
    default boolean remove(List<String> keys) {
        return removeBatch(keys);
    }
    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(WorkItem et);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    default boolean removeBatch(Collection<String> ids) {
        List<WorkItem> entities =new ArrayList<>();
        ids.forEach(key -> entities.add(new WorkItem().setId(key)));
        return getSelf().removeByEntities(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean removeByEntities(List<WorkItem> entities);

    default ImportResult importData(String config, Boolean ignoreError, List<WorkItem> list) {
        ImportResult rt = new ImportResult().setTotal(list.size());
        for(int i=0;i<list.size();i++) {
            WorkItem et=list.get(i);
            try {
                this.getSelf().save(et);
                rt.setSuccess(rt.getSuccess()+1);
            }catch (Exception ex){
                rt.addItem(i+1,et.getTitle(),ex.getMessage());
                if(!ignoreError)
                    break;
            }
        }
        return rt;
    }

    /**
     * activate
     * 
     * @param dto
     * @return
     */
    default WorkItem activate(WorkItem dto) {
        return dto;
    }

    /**
     * archive
     * 
     * @param dto
     * @return
     */
    default WorkItem archive(WorkItem dto) {
        return dto;
    }

    /**
     * change_assignee
     * 
     * @param dto
     * @return
     */
    default WorkItem changeAssignee(WorkItem dto) {
        return dto;
    }

    /**
     * change_parent
     * 
     * @param dto
     * @return
     */
    default WorkItem changeParent(WorkItem dto) {
        return dto;
    }

    /**
     * change_state
     * 
     * @param dto
     * @return
     */
    default WorkItem changeState(WorkItem dto) {
        return dto;
    }

    /**
     * change_time
     * 
     * @param dto
     * @return
     */
    default WorkItem changeTime(WorkItem dto) {
        return dto;
    }

    /**
     * child_del_relation
     * 
     * @param dto
     * @return
     */
    default WorkItem childDelRelation(WorkItem dto) {
        return dto;
    }

    /**
     * choose_child
     * 
     * @param dto
     * @return
     */
    default WorkItem chooseChild(WorkItem dto) {
        return dto;
    }

    /**
     * copy
     * 
     * @param dto
     * @return
     */
    default WorkItem copy(WorkItem dto) {
        return dto;
    }

    /**
     * del_relation
     * 
     * @param dto
     * @return
     */
    default WorkItem delRelation(WorkItem dto) {
        return dto;
    }

    /**
     * delete
     * 
     * @param dto
     * @return
     */
    default WorkItem delete(WorkItem dto) {
        return dto;
    }

    /**
     * fill_project_member
     * 
     * @param dto
     * @return
     */
    default WorkItem fillProjectMember(WorkItem dto) {
        return dto;
    }

    /**
     * fix_commit
     * 
     * @param dto
     * @return
     */
    default WorkItem fixCommit(WorkItem dto) {
        return dto;
    }

    /**
     * get_attention
     * 
     * @param key
     * @return
     */
    default WorkItem getAttention(String key) {
        return null;
    }

    /**
     * move_work_item
     * 
     * @param dto
     * @return
     */
    default WorkItem moveWorkItem(WorkItem dto) {
        return dto;
    }

    /**
     * nothing
     * 
     * @param dto
     * @return
     */
    default WorkItem nothing(WorkItem dto) {
        return dto;
    }

    /**
     * others_relation_work_item
     * 
     * @param dto
     * @return
     */
    default WorkItem othersRelationWorkItem(WorkItem dto) {
        return dto;
    }

    /**
     * plan_work_item
     * 
     * @param dto
     * @return
     */
    default WorkItem planWorkItem(WorkItem dto) {
        return dto;
    }

    /**
     * recover
     * 
     * @param dto
     * @return
     */
    default WorkItem recover(WorkItem dto) {
        return dto;
    }

    /**
     * restore_version
     * 
     * @param dto
     * @return
     */
    default WorkItem restoreVersion(WorkItem dto) {
        return dto;
    }

    /**
     * set_default_entry
     * 
     * @param dto
     * @return
     */
    default WorkItem setDefaultEntry(WorkItem dto) {
        return dto;
    }

    /**
     * set_type_bug
     * 
     * @param dto
     * @return
     */
    default WorkItem setTypeBug(WorkItem dto) {
        return dto;
    }

    /**
     * shift_in_baseline
     * 
     * @param dto
     * @return
     */
    default WorkItem shiftInBaseline(WorkItem dto) {
        return dto;
    }

    /**
     * shift_in_kanban
     * 
     * @param dto
     * @return
     */
    default WorkItem shiftInKanban(WorkItem dto) {
        return dto;
    }

    /**
     * shift_in_sprint
     * 
     * @param dto
     * @return
     */
    default WorkItem shiftInSprint(WorkItem dto) {
        return dto;
    }

    /**
     * shift_in_version
     * 
     * @param dto
     * @return
     */
    default WorkItem shiftInVersion(WorkItem dto) {
        return dto;
    }

    /**
     * shift_out_baseline
     * 
     * @param dto
     * @return
     */
    default WorkItem shiftOutBaseline(WorkItem dto) {
        return dto;
    }

    /**
     * work_item_re_counters
     * 
     * @param dto
     * @return
     */
    default WorkItem workItemReCounters(WorkItem dto) {
        return dto;
    }

    /**
     * work_item_test_plan_project
     * 
     * @param dto
     * @return
     */
    default WorkItem workItemTestPlanProject(WorkItem dto) {
        return dto;
    }

    /**
     * searchDefault
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchDefault(WorkItemSearchContext context);
    /**
     * listDefault
     * 
     * @param context
     * @return
     */
    List<WorkItem> listDefault(WorkItemSearchContext context);

    /**
     * searchadvanced_search
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchAdvancedSearch(WorkItemSearchContext context);
    /**
     * listadvanced_search
     * 
     * @param context
     * @return
     */
    List<WorkItem> listAdvancedSearch(WorkItemSearchContext context);

    /**
     * searcharchived
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchArchived(WorkItemSearchContext context);
    /**
     * listarchived
     * 
     * @param context
     * @return
     */
    List<WorkItem> listArchived(WorkItemSearchContext context);

    /**
     * searchbacklog_property_distribution
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchBacklogPropertyDistribution(WorkItemSearchContext context);
    /**
     * listbacklog_property_distribution
     * 
     * @param context
     * @return
     */
    List<WorkItem> listBacklogPropertyDistribution(WorkItemSearchContext context);

    /**
     * searchbacklog_state_distribution
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchBacklogStateDistribution(WorkItemSearchContext context);
    /**
     * listbacklog_state_distribution
     * 
     * @param context
     * @return
     */
    List<WorkItem> listBacklogStateDistribution(WorkItemSearchContext context);

    /**
     * searchbaseline_choose_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchBaselineChooseWorkItem(WorkItemSearchContext context);
    /**
     * listbaseline_choose_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listBaselineChooseWorkItem(WorkItemSearchContext context);

    /**
     * searchbug
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchBug(WorkItemSearchContext context);
    /**
     * listbug
     * 
     * @param context
     * @return
     */
    List<WorkItem> listBug(WorkItemSearchContext context);

    /**
     * searchbug_state_group_grid
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchBugStateGroupGrid(WorkItemSearchContext context);
    /**
     * listbug_state_group_grid
     * 
     * @param context
     * @return
     */
    List<WorkItem> listBugStateGroupGrid(WorkItemSearchContext context);

    /**
     * searchchange_parent
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchChangeParent(WorkItemSearchContext context);
    /**
     * listchange_parent
     * 
     * @param context
     * @return
     */
    List<WorkItem> listChangeParent(WorkItemSearchContext context);

    /**
     * searchchild
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchChild(WorkItemSearchContext context);
    /**
     * listchild
     * 
     * @param context
     * @return
     */
    List<WorkItem> listChild(WorkItemSearchContext context);

    /**
     * searchchoose_child
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchChooseChild(WorkItemSearchContext context);
    /**
     * listchoose_child
     * 
     * @param context
     * @return
     */
    List<WorkItem> listChooseChild(WorkItemSearchContext context);

    /**
     * searchcomment_notify_assignee
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchCommentNotifyAssignee(WorkItemSearchContext context);
    /**
     * listcomment_notify_assignee
     * 
     * @param context
     * @return
     */
    List<WorkItem> listCommentNotifyAssignee(WorkItemSearchContext context);

    /**
     * searchcommon
     * 未删除
     * @param context
     * @return
     */
    Page<WorkItem> searchCommon(WorkItemSearchContext context);
    /**
     * listcommon
     * 未删除
     * @param context
     * @return
     */
    List<WorkItem> listCommon(WorkItemSearchContext context);

    /**
     * searchcommon_bug
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchCommonBug(WorkItemSearchContext context);
    /**
     * listcommon_bug
     * 
     * @param context
     * @return
     */
    List<WorkItem> listCommonBug(WorkItemSearchContext context);

    /**
     * searchdefect_property_distribution
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchDefectPropertyDistribution(WorkItemSearchContext context);
    /**
     * listdefect_property_distribution
     * 
     * @param context
     * @return
     */
    List<WorkItem> listDefectPropertyDistribution(WorkItemSearchContext context);

    /**
     * searchdeleted
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchDeleted(WorkItemSearchContext context);
    /**
     * listdeleted
     * 
     * @param context
     * @return
     */
    List<WorkItem> listDeleted(WorkItemSearchContext context);

    /**
     * searchidea_relation_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchIdeaRelationWorkItem(WorkItemSearchContext context);
    /**
     * listidea_relation_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listIdeaRelationWorkItem(WorkItemSearchContext context);

    /**
     * searchkanban_user_stat
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchKanbanUserStat(WorkItemSearchContext context);
    /**
     * listkanban_user_stat
     * 
     * @param context
     * @return
     */
    List<WorkItem> listKanbanUserStat(WorkItemSearchContext context);

    /**
     * searchmilestone
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchMilestone(WorkItemSearchContext context);
    /**
     * listmilestone
     * 
     * @param context
     * @return
     */
    List<WorkItem> listMilestone(WorkItemSearchContext context);

    /**
     * searchmy_assignee
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchMyAssignee(WorkItemSearchContext context);
    /**
     * listmy_assignee
     * 
     * @param context
     * @return
     */
    List<WorkItem> listMyAssignee(WorkItemSearchContext context);

    /**
     * searchmy_assignee_count
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchMyAssigneeCount(WorkItemSearchContext context);
    /**
     * listmy_assignee_count
     * 
     * @param context
     * @return
     */
    List<WorkItem> listMyAssigneeCount(WorkItemSearchContext context);

    /**
     * searchmy_attention
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchMyAttention(WorkItemSearchContext context);
    /**
     * listmy_attention
     * 
     * @param context
     * @return
     */
    List<WorkItem> listMyAttention(WorkItemSearchContext context);

    /**
     * searchmy_created
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchMyCreated(WorkItemSearchContext context);
    /**
     * listmy_created
     * 
     * @param context
     * @return
     */
    List<WorkItem> listMyCreated(WorkItemSearchContext context);

    /**
     * searchmy_filter
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchMyFilter(WorkItemSearchContext context);
    /**
     * listmy_filter
     * 
     * @param context
     * @return
     */
    List<WorkItem> listMyFilter(WorkItemSearchContext context);

    /**
     * searchmy_todo
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchMyTodo(WorkItemSearchContext context);
    /**
     * listmy_todo
     * 
     * @param context
     * @return
     */
    List<WorkItem> listMyTodo(WorkItemSearchContext context);

    /**
     * searchno_bug_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchNoBugWorkItem(WorkItemSearchContext context);
    /**
     * listno_bug_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listNoBugWorkItem(WorkItemSearchContext context);

    /**
     * searchnormal
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchNormal(WorkItemSearchContext context);
    /**
     * listnormal
     * 
     * @param context
     * @return
     */
    List<WorkItem> listNormal(WorkItemSearchContext context);

    /**
     * searchnot_exsists_bug_relation
     * 仅缺陷
     * @param context
     * @return
     */
    Page<WorkItem> searchNotExsistsBugRelation(WorkItemSearchContext context);
    /**
     * listnot_exsists_bug_relation
     * 仅缺陷
     * @param context
     * @return
     */
    List<WorkItem> listNotExsistsBugRelation(WorkItemSearchContext context);

    /**
     * searchnot_exsists_relation
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchNotExsistsRelation(WorkItemSearchContext context);
    /**
     * listnot_exsists_relation
     * 
     * @param context
     * @return
     */
    List<WorkItem> listNotExsistsRelation(WorkItemSearchContext context);

    /**
     * searchnotbug_exsists_relation
     * 未关联且不为缺陷工作项
     * @param context
     * @return
     */
    Page<WorkItem> searchNotbugExsistsRelation(WorkItemSearchContext context);
    /**
     * listnotbug_exsists_relation
     * 未关联且不为缺陷工作项
     * @param context
     * @return
     */
    List<WorkItem> listNotbugExsistsRelation(WorkItemSearchContext context);

    /**
     * searchnotify_assignee
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchNotifyAssignee(WorkItemSearchContext context);
    /**
     * listnotify_assignee
     * 
     * @param context
     * @return
     */
    List<WorkItem> listNotifyAssignee(WorkItemSearchContext context);

    /**
     * searchoverview_chart
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchOverviewChart(WorkItemSearchContext context);
    /**
     * listoverview_chart
     * 
     * @param context
     * @return
     */
    List<WorkItem> listOverviewChart(WorkItemSearchContext context);

    /**
     * searchproperty_distribution
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchPropertyDistribution(WorkItemSearchContext context);
    /**
     * listproperty_distribution
     * 
     * @param context
     * @return
     */
    List<WorkItem> listPropertyDistribution(WorkItemSearchContext context);

    /**
     * searchrecent_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchRecentWorkItem(WorkItemSearchContext context);
    /**
     * listrecent_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listRecentWorkItem(WorkItemSearchContext context);

    /**
     * searchrelease
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchRelease(WorkItemSearchContext context);
    /**
     * listrelease
     * 
     * @param context
     * @return
     */
    List<WorkItem> listRelease(WorkItemSearchContext context);

    /**
     * searchrelease_plan
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchReleasePlan(WorkItemSearchContext context);
    /**
     * listrelease_plan
     * 
     * @param context
     * @return
     */
    List<WorkItem> listReleasePlan(WorkItemSearchContext context);

    /**
     * searchrequirement
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchRequirement(WorkItemSearchContext context);
    /**
     * listrequirement
     * 
     * @param context
     * @return
     */
    List<WorkItem> listRequirement(WorkItemSearchContext context);

    /**
     * searchrequirement_tree
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchRequirementTree(WorkItemSearchContext context);
    /**
     * listrequirement_tree
     * 
     * @param context
     * @return
     */
    List<WorkItem> listRequirementTree(WorkItemSearchContext context);

    /**
     * searchresource_assignment
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchResourceAssignment(WorkItemSearchContext context);
    /**
     * listresource_assignment
     * 
     * @param context
     * @return
     */
    List<WorkItem> listResourceAssignment(WorkItemSearchContext context);

    /**
     * searchrun_relation_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchRunRelationWorkItem(WorkItemSearchContext context);
    /**
     * listrun_relation_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listRunRelationWorkItem(WorkItemSearchContext context);

    /**
     * searchtest_case_relation_bug
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchTestCaseRelationBug(WorkItemSearchContext context);
    /**
     * listtest_case_relation_bug
     * 
     * @param context
     * @return
     */
    List<WorkItem> listTestCaseRelationBug(WorkItemSearchContext context);

    /**
     * searchtest_case_relation_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchTestCaseRelationWorkItem(WorkItemSearchContext context);
    /**
     * listtest_case_relation_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listTestCaseRelationWorkItem(WorkItemSearchContext context);

    /**
     * searchtest_plan_relation_bug
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchTestPlanRelationBug(WorkItemSearchContext context);
    /**
     * listtest_plan_relation_bug
     * 
     * @param context
     * @return
     */
    List<WorkItem> listTestPlanRelationBug(WorkItemSearchContext context);

    /**
     * searchticket_relation_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchTicketRelationWorkItem(WorkItemSearchContext context);
    /**
     * listticket_relation_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listTicketRelationWorkItem(WorkItemSearchContext context);

    /**
     * searchtop
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchTop(WorkItemSearchContext context);
    /**
     * listtop
     * 
     * @param context
     * @return
     */
    List<WorkItem> listTop(WorkItemSearchContext context);

    /**
     * searchtree_tile_grid_query
     * 未删除
     * @param context
     * @return
     */
    Page<WorkItem> searchTreeTileGridQuery(WorkItemSearchContext context);
    /**
     * listtree_tile_grid_query
     * 未删除
     * @param context
     * @return
     */
    List<WorkItem> listTreeTileGridQuery(WorkItemSearchContext context);

    /**
     * searchunder_work
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchUnderWork(WorkItemSearchContext context);
    /**
     * listunder_work
     * 
     * @param context
     * @return
     */
    List<WorkItem> listUnderWork(WorkItemSearchContext context);

    /**
     * searchwork_item_relation_work_item
     * 
     * @param context
     * @return
     */
    Page<WorkItem> searchWorkItemRelationWorkItem(WorkItemSearchContext context);
    /**
     * listwork_item_relation_work_item
     * 
     * @param context
     * @return
     */
    List<WorkItem> listWorkItemRelationWorkItem(WorkItemSearchContext context);

    /**
     * 创建实体对象
     * @return
     */
    default WorkItem getEntity() {
        return new WorkItem();
    }
    /**
     * 创建搜索对象
     * @return
     */
    default WorkItemSearchContext getSearchContext() {
        return new WorkItemSearchContext();
    }
    /**
     * selectRelByBoardId
     * @param boardIds
     * @return
     */
    List<WorkItem> findByBoardId(List<String> boardIds);
    default List<WorkItem> findByBoardId(String boardId) {
        return findByBoardId(Arrays.asList(boardId));
    }
    /**
     * removeRelByBoardId
     * @param boardId
     * @return
     */
    boolean removeByBoardId(String boardId);
    /**
     * resetRelByBoardId
     * @param boardId
     * @return
     */
    boolean resetByBoardId(String boardId);
    /**
     * saveRelByBoardId
     * @param boardId
     * @param list
     * @return
     */
    default boolean saveByBoardId(String boardId,List<WorkItem> list) {
        return getSelf().saveByBoard(new Board().setId(boardId),list);
    }
    /**
    * saveRelByBoard
    * @param board
    * @param list
    * @return
    */
    boolean saveByBoard(Board board,List<WorkItem> list);

    /**
     * selectRelByEntryId
     * @param entryIds
     * @return
     */
    List<WorkItem> findByEntryId(List<String> entryIds);
    default List<WorkItem> findByEntryId(String entryId) {
        return findByEntryId(Arrays.asList(entryId));
    }
    /**
     * removeRelByEntryId
     * @param entryId
     * @return
     */
    boolean removeByEntryId(String entryId);
    /**
     * resetRelByEntryId
     * @param entryId
     * @return
     */
    boolean resetByEntryId(String entryId);
    /**
     * saveRelByEntryId
     * @param entryId
     * @param list
     * @return
     */
    default boolean saveByEntryId(String entryId,List<WorkItem> list) {
        return getSelf().saveByEntry(new Entry().setId(entryId),list);
    }
    /**
    * saveRelByEntry
    * @param entry
    * @param list
    * @return
    */
    boolean saveByEntry(Entry entry,List<WorkItem> list);

    /**
     * selectRelByProjectId
     * @param projectIds
     * @return
     */
    List<WorkItem> findByProjectId(List<String> projectIds);
    default List<WorkItem> findByProjectId(String projectId) {
        return findByProjectId(Arrays.asList(projectId));
    }
    /**
     * removeRelByProjectId
     * @param projectId
     * @return
     */
    boolean removeByProjectId(String projectId);
    /**
     * resetRelByProjectId
     * @param projectId
     * @return
     */
    boolean resetByProjectId(String projectId);
    /**
     * saveRelByProjectId
     * @param projectId
     * @param list
     * @return
     */
    default boolean saveByProjectId(String projectId,List<WorkItem> list) {
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }
    /**
    * saveRelByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project,List<WorkItem> list);

    /**
     * selectRelByReleaseId
     * @param releaseIds
     * @return
     */
    List<WorkItem> findByReleaseId(List<String> releaseIds);
    default List<WorkItem> findByReleaseId(String releaseId) {
        return findByReleaseId(Arrays.asList(releaseId));
    }
    /**
     * removeRelByReleaseId
     * @param releaseId
     * @return
     */
    boolean removeByReleaseId(String releaseId);
    /**
     * resetRelByReleaseId
     * @param releaseId
     * @return
     */
    boolean resetByReleaseId(String releaseId);
    /**
     * saveRelByReleaseId
     * @param releaseId
     * @param list
     * @return
     */
    default boolean saveByReleaseId(String releaseId,List<WorkItem> list) {
        return getSelf().saveByRelease(new Release().setId(releaseId),list);
    }
    /**
    * saveRelByRelease
    * @param release
    * @param list
    * @return
    */
    boolean saveByRelease(Release release,List<WorkItem> list);

    /**
     * selectRelBySprintId
     * @param sprintIds
     * @return
     */
    List<WorkItem> findBySprintId(List<String> sprintIds);
    default List<WorkItem> findBySprintId(String sprintId) {
        return findBySprintId(Arrays.asList(sprintId));
    }
    /**
     * removeRelBySprintId
     * @param sprintId
     * @return
     */
    boolean removeBySprintId(String sprintId);
    /**
     * resetRelBySprintId
     * @param sprintId
     * @return
     */
    boolean resetBySprintId(String sprintId);
    /**
     * saveRelBySprintId
     * @param sprintId
     * @param list
     * @return
     */
    default boolean saveBySprintId(String sprintId,List<WorkItem> list) {
        return getSelf().saveBySprint(new Sprint().setId(sprintId),list);
    }
    /**
    * saveRelBySprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveBySprint(Sprint sprint,List<WorkItem> list);

    /**
     * selectRelBySwimlaneId
     * @param swimlaneIds
     * @return
     */
    List<WorkItem> findBySwimlaneId(List<String> swimlaneIds);
    default List<WorkItem> findBySwimlaneId(String swimlaneId) {
        return findBySwimlaneId(Arrays.asList(swimlaneId));
    }
    /**
     * removeRelBySwimlaneId
     * @param swimlaneId
     * @return
     */
    boolean removeBySwimlaneId(String swimlaneId);
    /**
     * resetRelBySwimlaneId
     * @param swimlaneId
     * @return
     */
    boolean resetBySwimlaneId(String swimlaneId);
    /**
     * saveRelBySwimlaneId
     * @param swimlaneId
     * @param list
     * @return
     */
    default boolean saveBySwimlaneId(String swimlaneId,List<WorkItem> list) {
        return getSelf().saveBySwimlane(new Swimlane().setId(swimlaneId),list);
    }
    /**
    * saveRelBySwimlane
    * @param swimlane
    * @param list
    * @return
    */
    boolean saveBySwimlane(Swimlane swimlane,List<WorkItem> list);

    /**
     * selectRelByAssigneeId
     * @param assigneeIds
     * @return
     */
    List<WorkItem> findByAssigneeId(List<String> assigneeIds);
    default List<WorkItem> findByAssigneeId(String assigneeId) {
        return findByAssigneeId(Arrays.asList(assigneeId));
    }
    /**
     * removeRelByAssigneeId
     * @param assigneeId
     * @return
     */
    boolean removeByAssigneeId(String assigneeId);
    /**
     * resetRelByAssigneeId
     * @param assigneeId
     * @return
     */
    boolean resetByAssigneeId(String assigneeId);
    /**
     * saveRelByAssigneeId
     * @param assigneeId
     * @param list
     * @return
     */
    default boolean saveByAssigneeId(String assigneeId,List<WorkItem> list) {
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }
    /**
    * saveRelByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user,List<WorkItem> list);

    /**
     * selectRelByPid
     * @param pids
     * @return
     */
    List<WorkItem> findByPid(List<String> pids);
    default List<WorkItem> findByPid(String pid) {
        return findByPid(Arrays.asList(pid));
    }
    /**
     * removeRelByPid
     * @param pid
     * @return
     */
    boolean removeByPid(String pid);
    /**
     * resetRelByPid
     * @param pid
     * @return
     */
    boolean resetByPid(String pid);
    /**
     * saveRelByPid
     * @param pid
     * @param list
     * @return
     */
    default boolean saveByPid(String pid,List<WorkItem> list) {
        return getSelf().saveByWorkItem(new WorkItem().setId(pid),list);
    }
    /**
    * saveRelByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem,List<WorkItem> list);

    /**
     * selectRelByState
     * @param states
     * @return
     */
    List<WorkItem> findByState(List<String> states);
    default List<WorkItem> findByState(String state) {
        return findByState(Arrays.asList(state));
    }
    /**
     * removeRelByState
     * @param state
     * @return
     */
    boolean removeByState(String state);
    /**
     * resetRelByState
     * @param state
     * @return
     */
    boolean resetByState(String state);
    /**
     * saveRelByState
     * @param state
     * @param list
     * @return
     */
    default boolean saveByState(String state,List<WorkItem> list) {
        return getSelf().saveByWorkItemState(new WorkItemState().setId(state),list);
    }
    /**
    * saveRelByWorkItemState
    * @param workItemState
    * @param list
    * @return
    */
    boolean saveByWorkItemState(WorkItemState workItemState,List<WorkItem> list);

    /**
     * selectRelByTopId
     * @param topIds
     * @return
     */
    List<WorkItem> findByTopId(List<String> topIds);
    default List<WorkItem> findByTopId(String topId) {
        return findByTopId(Arrays.asList(topId));
    }
    /**
     * removeRelByTopId
     * @param topId
     * @return
     */
    boolean removeByTopId(String topId);
    /**
     * resetRelByTopId
     * @param topId
     * @return
     */
    boolean resetByTopId(String topId);
    /**
     * saveRelByTopId
     * @param topId
     * @param list
     * @return
     */
    default boolean saveByTopId(String topId,List<WorkItem> list) {
        return getSelf().saveByWorkItem2(new WorkItem().setId(topId),list);
    }
    /**
    * saveRelByWorkItem2
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem2(WorkItem workItem,List<WorkItem> list);

    /**
     * selectRelByWorkItemTypeId
     * @param workItemTypeIds
     * @return
     */
    List<WorkItem> findByWorkItemTypeId(List<String> workItemTypeIds);
    default List<WorkItem> findByWorkItemTypeId(String workItemTypeId) {
        return findByWorkItemTypeId(Arrays.asList(workItemTypeId));
    }
    /**
     * removeRelByWorkItemTypeId
     * @param workItemTypeId
     * @return
     */
    boolean removeByWorkItemTypeId(String workItemTypeId);
    /**
     * resetRelByWorkItemTypeId
     * @param workItemTypeId
     * @return
     */
    boolean resetByWorkItemTypeId(String workItemTypeId);
    /**
     * saveRelByWorkItemTypeId
     * @param workItemTypeId
     * @param list
     * @return
     */
    default boolean saveByWorkItemTypeId(String workItemTypeId,List<WorkItem> list) {
        return getSelf().saveByWorkItemType(new WorkItemType().setId(workItemTypeId),list);
    }
    /**
    * saveRelByWorkItemType
    * @param workItemType
    * @param list
    * @return
    */
    boolean saveByWorkItemType(WorkItemType workItemType,List<WorkItem> list);

    default List<Attention> getAttentions(WorkItem et) {
        return new ArrayList<>();
    }

    default List<Attachment> getAttachments(WorkItem et) {
        return new ArrayList<>();
    }

    default List<Deliverable> getDeliverable(WorkItem et) {
        return new ArrayList<>();
    }


    /**
     * 自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    List<JSONObject> select(String sql, Map<String,Object> param);

    /**
     * 自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return
     */
    boolean execute(String sql, Map<String,Object> param);

}