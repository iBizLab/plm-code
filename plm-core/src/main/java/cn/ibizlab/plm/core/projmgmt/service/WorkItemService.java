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
import cn.ibizlab.util.enums.CheckKeyStatus;
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
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
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
    boolean create(List<WorkItem> list);

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
    boolean update(List<WorkItem> list);

    /**
     * 主键删除
     * @param key
     * @return
     */
    default boolean remove(String key) {
        return getSelf().remove(new WorkItem().setId(key));
    }

    /**
     * 根据对象删除
     * @param et
     * @return
     */
    boolean remove(WorkItem et);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    default boolean remove(Collection<String> keys) {
        List<WorkItem> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new WorkItem().setId(key)));
        return getSelf().remove(entities);
    }

    /**
     * 批量删除对象
     * @param entities
     * @return
     */
    boolean remove(List<WorkItem> entities);

    /**
    * 获取
    * @param key
    * @return
    */
    default WorkItem get(String key) {
        return getSelf().get(new WorkItem().setId(key));
    }

    /**
     * 获取
     * @param et
     * @return
     */
    WorkItem get(WorkItem et);

    /**
     * id集合获取
     * @param keys
     * @return
     */
    default List<WorkItem> get(Collection<String> keys) {
        List<WorkItem> entities =new ArrayList<>();
        keys.forEach(key -> entities.add(new WorkItem().setId(key)));
        return getSelf().get(entities);
    }

    /**
    * 对象集合获取
    * @param entities
    * @return
    */
    List<WorkItem> get(List<WorkItem> entities);

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
    CheckKeyStatus checkKey(WorkItem et);

    /**
    * 保存
    * @param et
    * @return
    */
    boolean save(WorkItem et);

	/**
     * 批量保存
     * @param list
     * @return
     */
    boolean save(List<WorkItem> list);

    /**
    * activate
    * 
    * @param et
    * @return
    */
    default WorkItem activate(WorkItem et) {
        return et;
    }

    /**
    * archive
    * 
    * @param et
    * @return
    */
    default WorkItem archive(WorkItem et) {
        return et;
    }

    /**
    * boardMovePosition
    * 
    * @param et
    * @return
    */
    default List<WorkItem> boardMovePosition(WorkItem et) {
        return new ArrayList<>();
    }

    /**
    * changeAssignee
    * 
    * @param et
    * @return
    */
    default WorkItem changeAssignee(WorkItem et) {
        return et;
    }

    /**
    * changeParent
    * 
    * @param et
    * @return
    */
    default WorkItem changeParent(WorkItem et) {
        return et;
    }

    /**
    * changeState
    * 
    * @param et
    * @return
    */
    default WorkItem changeState(WorkItem et) {
        return et;
    }

    /**
    * changeTime
    * 
    * @param et
    * @return
    */
    default WorkItem changeTime(WorkItem et) {
        return et;
    }

    /**
    * childDelRelation
    * 
    * @param et
    * @return
    */
    default WorkItem childDelRelation(WorkItem et) {
        return et;
    }

    /**
    * chooseChild
    * 
    * @param et
    * @return
    */
    default WorkItem chooseChild(WorkItem et) {
        return et;
    }

    /**
    * copy
    * 
    * @param et
    * @return
    */
    default WorkItem copy(WorkItem et) {
        return et;
    }

    /**
    * createPlanSnapshot
    * 
    * @param et
    * @return
    */
    default WorkItem createPlanSnapshot(WorkItem et) {
        return et;
    }

    /**
    * delete
    * 
    * @param et
    * @return
    */
    default WorkItem delete(WorkItem et) {
        return et;
    }

    /**
    * fixCommit
    * 
    * @param et
    * @return
    */
    default WorkItem fixCommit(WorkItem et) {
        return et;
    }

    /**
    * getAttention
    * 
    * @param key
    * @return
    */
    default WorkItem getAttention(String key) {
        return null;
    }

    /**
    * getBaselineName
    * 
    * @param key
    * @return
    */
    default WorkItem getBaselineName(String key) {
        return getSelf().getBaselineName(new WorkItem().setId(key));
    }

    /**
    * moveOrder
    * 
    * @param et
    * @return
    */
    default List<WorkItem> moveOrder(WorkItem et) {
        return new ArrayList<>();
    }

    /**
    * moveWorkItem
    * 
    * @param et
    * @return
    */
    default WorkItem moveWorkItem(WorkItem et) {
        return et;
    }

    /**
    * nothing
    * 
    * @param et
    * @return
    */
    default WorkItem nothing(WorkItem et) {
        return et;
    }

    /**
    * othersRelationWorkItem
    * 
    * @param et
    * @return
    */
    default WorkItem othersRelationWorkItem(WorkItem et) {
        return et;
    }

    /**
    * planWorkItem
    * 
    * @param et
    * @return
    */
    default WorkItem planWorkItem(WorkItem et) {
        return et;
    }

    /**
    * projectResourceSetting
    * 
    * @param et
    * @return
    */
    default WorkItem projectResourceSetting(WorkItem et) {
        return et;
    }

    /**
    * recover
    * 
    * @param et
    * @return
    */
    default WorkItem recover(WorkItem et) {
        return et;
    }

    /**
    * resourceMemberSetting
    * 
    * @param et
    * @return
    */
    default WorkItem resourceMemberSetting(WorkItem et) {
        return et;
    }

    /**
    * restoreVersion
    * 
    * @param et
    * @return
    */
    default WorkItem restoreVersion(WorkItem et) {
        return et;
    }

    /**
    * setDefaultEntry
    * 
    * @param et
    * @return
    */
    default WorkItem setDefaultEntry(WorkItem et) {
        return et;
    }

    /**
    * setTypeBug
    * 
    * @param et
    * @return
    */
    default WorkItem setTypeBug(WorkItem et) {
        return et;
    }

    /**
    * shiftInKanban
    * 
    * @param et
    * @return
    */
    default WorkItem shiftInKanban(WorkItem et) {
        return et;
    }

    /**
    * shiftInRelease
    * 
    * @param et
    * @return
    */
    default WorkItem shiftInRelease(WorkItem et) {
        return et;
    }

    /**
    * shiftInSprint
    * 
    * @param et
    * @return
    */
    default WorkItem shiftInSprint(WorkItem et) {
        return et;
    }

    /**
    * shiftOutRelease
    * 
    * @param et
    * @return
    */
    default WorkItem shiftOutRelease(WorkItem et) {
        return et;
    }

    /**
    * shiftOutSprint
    * 
    * @param et
    * @return
    */
    default WorkItem shiftOutSprint(WorkItem et) {
        return et;
    }

    /**
    * workItemReCounters
    * 
    * @param et
    * @return
    */
    default WorkItem workItemReCounters(WorkItem et) {
        return et;
    }

    /**
    * workItemReadonlyRecognize
    * 
    * @param et
    * @return
    */
    default WorkItem workItemReadonlyRecognize(WorkItem et) {
        return et;
    }

    /**
    * workItemTestPlanProject
    * 
    * @param et
    * @return
    */
    default WorkItem workItemTestPlanProject(WorkItem et) {
        return et;
    }

    /**
    * workItemTypeId
    * 
    * @param key
    * @return
    */
    default WorkItem workItemTypeId(String key) {
        return getSelf().workItemTypeId(new WorkItem().setId(key));
    }

    /**
    * fetchDefault
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchDefault(WorkItemSearchContext context);

    /**
    * listDefault
    * 
    * @param context
    * @return
    */
    List<WorkItem> listDefault(WorkItemSearchContext context);

    /**
    * fetchAdvancedSearch
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchAdvancedSearch(WorkItemSearchContext context);

    /**
    * listAdvancedSearch
    * 
    * @param context
    * @return
    */
    List<WorkItem> listAdvancedSearch(WorkItemSearchContext context);

    /**
    * fetchArchived
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchArchived(WorkItemSearchContext context);

    /**
    * listArchived
    * 
    * @param context
    * @return
    */
    List<WorkItem> listArchived(WorkItemSearchContext context);

    /**
    * fetchBacklogPropertyDistribution
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchBacklogPropertyDistribution(WorkItemSearchContext context);

    /**
    * listBacklogPropertyDistribution
    * 
    * @param context
    * @return
    */
    List<WorkItem> listBacklogPropertyDistribution(WorkItemSearchContext context);

    /**
    * fetchBacklogStateDistribution
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchBacklogStateDistribution(WorkItemSearchContext context);

    /**
    * listBacklogStateDistribution
    * 
    * @param context
    * @return
    */
    List<WorkItem> listBacklogStateDistribution(WorkItemSearchContext context);

    /**
    * fetchBaselineChooseWorkItem
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchBaselineChooseWorkItem(WorkItemSearchContext context);

    /**
    * listBaselineChooseWorkItem
    * 
    * @param context
    * @return
    */
    List<WorkItem> listBaselineChooseWorkItem(WorkItemSearchContext context);

    /**
    * fetchBiDetail
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchBiDetail(WorkItemSearchContext context);

    /**
    * listBiDetail
    * 
    * @param context
    * @return
    */
    List<WorkItem> listBiDetail(WorkItemSearchContext context);

    /**
    * fetchBiSearch
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchBiSearch(WorkItemSearchContext context);

    /**
    * listBiSearch
    * 
    * @param context
    * @return
    */
    List<WorkItem> listBiSearch(WorkItemSearchContext context);

    /**
    * fetchBug
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchBug(WorkItemSearchContext context);

    /**
    * listBug
    * 
    * @param context
    * @return
    */
    List<WorkItem> listBug(WorkItemSearchContext context);

    /**
    * fetchBugStateGroupGrid
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchBugStateGroupGrid(WorkItemSearchContext context);

    /**
    * listBugStateGroupGrid
    * 
    * @param context
    * @return
    */
    List<WorkItem> listBugStateGroupGrid(WorkItemSearchContext context);

    /**
    * fetchChangeParent
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchChangeParent(WorkItemSearchContext context);

    /**
    * listChangeParent
    * 
    * @param context
    * @return
    */
    List<WorkItem> listChangeParent(WorkItemSearchContext context);

    /**
    * fetchChild
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchChild(WorkItemSearchContext context);

    /**
    * listChild
    * 
    * @param context
    * @return
    */
    List<WorkItem> listChild(WorkItemSearchContext context);

    /**
    * fetchChooseChild
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchChooseChild(WorkItemSearchContext context);

    /**
    * listChooseChild
    * 
    * @param context
    * @return
    */
    List<WorkItem> listChooseChild(WorkItemSearchContext context);

    /**
    * fetchChooseDependency
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchChooseDependency(WorkItemSearchContext context);

    /**
    * listChooseDependency
    * 
    * @param context
    * @return
    */
    List<WorkItem> listChooseDependency(WorkItemSearchContext context);

    /**
    * fetchCommentNotifyAssignee
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchCommentNotifyAssignee(WorkItemSearchContext context);

    /**
    * listCommentNotifyAssignee
    * 
    * @param context
    * @return
    */
    List<WorkItem> listCommentNotifyAssignee(WorkItemSearchContext context);

    /**
    * fetchCommon
    * 未删除
    * @param context
    * @return
    */
    Page<WorkItem> fetchCommon(WorkItemSearchContext context);

    /**
    * listCommon
    * 未删除
    * @param context
    * @return
    */
    List<WorkItem> listCommon(WorkItemSearchContext context);

    /**
    * fetchCommonBug
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchCommonBug(WorkItemSearchContext context);

    /**
    * listCommonBug
    * 
    * @param context
    * @return
    */
    List<WorkItem> listCommonBug(WorkItemSearchContext context);

    /**
    * fetchDefectPropertyDistribution
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchDefectPropertyDistribution(WorkItemSearchContext context);

    /**
    * listDefectPropertyDistribution
    * 
    * @param context
    * @return
    */
    List<WorkItem> listDefectPropertyDistribution(WorkItemSearchContext context);

    /**
    * fetchDeleted
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchDeleted(WorkItemSearchContext context);

    /**
    * listDeleted
    * 
    * @param context
    * @return
    */
    List<WorkItem> listDeleted(WorkItemSearchContext context);

    /**
    * fetchKanbanUserStat
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchKanbanUserStat(WorkItemSearchContext context);

    /**
    * listKanbanUserStat
    * 
    * @param context
    * @return
    */
    List<WorkItem> listKanbanUserStat(WorkItemSearchContext context);

    /**
    * fetchMilestone
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMilestone(WorkItemSearchContext context);

    /**
    * listMilestone
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMilestone(WorkItemSearchContext context);

    /**
    * fetchMoveWorkItem
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMoveWorkItem(WorkItemSearchContext context);

    /**
    * listMoveWorkItem
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMoveWorkItem(WorkItemSearchContext context);

    /**
    * fetchMyAssignee
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMyAssignee(WorkItemSearchContext context);

    /**
    * listMyAssignee
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMyAssignee(WorkItemSearchContext context);

    /**
    * fetchMyAssigneeCount
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMyAssigneeCount(WorkItemSearchContext context);

    /**
    * listMyAssigneeCount
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMyAssigneeCount(WorkItemSearchContext context);

    /**
    * fetchMyAttention
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMyAttention(WorkItemSearchContext context);

    /**
    * listMyAttention
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMyAttention(WorkItemSearchContext context);

    /**
    * fetchMyCreated
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMyCreated(WorkItemSearchContext context);

    /**
    * listMyCreated
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMyCreated(WorkItemSearchContext context);

    /**
    * fetchMyFilter
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMyFilter(WorkItemSearchContext context);

    /**
    * listMyFilter
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMyFilter(WorkItemSearchContext context);

    /**
    * fetchMyTodo
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchMyTodo(WorkItemSearchContext context);

    /**
    * listMyTodo
    * 
    * @param context
    * @return
    */
    List<WorkItem> listMyTodo(WorkItemSearchContext context);

    /**
    * fetchNoBugWorkItem
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchNoBugWorkItem(WorkItemSearchContext context);

    /**
    * listNoBugWorkItem
    * 
    * @param context
    * @return
    */
    List<WorkItem> listNoBugWorkItem(WorkItemSearchContext context);

    /**
    * fetchNormal
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchNormal(WorkItemSearchContext context);

    /**
    * listNormal
    * 
    * @param context
    * @return
    */
    List<WorkItem> listNormal(WorkItemSearchContext context);

    /**
    * fetchNotExsistsBugRelation
    * 仅缺陷
    * @param context
    * @return
    */
    Page<WorkItem> fetchNotExsistsBugRelation(WorkItemSearchContext context);

    /**
    * listNotExsistsBugRelation
    * 仅缺陷
    * @param context
    * @return
    */
    List<WorkItem> listNotExsistsBugRelation(WorkItemSearchContext context);

    /**
    * fetchNotExsistsRelation
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchNotExsistsRelation(WorkItemSearchContext context);

    /**
    * listNotExsistsRelation
    * 
    * @param context
    * @return
    */
    List<WorkItem> listNotExsistsRelation(WorkItemSearchContext context);

    /**
    * fetchNotbugExsistsRelation
    * 未关联且不为缺陷工作项
    * @param context
    * @return
    */
    Page<WorkItem> fetchNotbugExsistsRelation(WorkItemSearchContext context);

    /**
    * listNotbugExsistsRelation
    * 未关联且不为缺陷工作项
    * @param context
    * @return
    */
    List<WorkItem> listNotbugExsistsRelation(WorkItemSearchContext context);

    /**
    * fetchNotifyAssignee
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchNotifyAssignee(WorkItemSearchContext context);

    /**
    * listNotifyAssignee
    * 
    * @param context
    * @return
    */
    List<WorkItem> listNotifyAssignee(WorkItemSearchContext context);

    /**
    * fetchOverviewChart
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchOverviewChart(WorkItemSearchContext context);

    /**
    * listOverviewChart
    * 
    * @param context
    * @return
    */
    List<WorkItem> listOverviewChart(WorkItemSearchContext context);

    /**
    * fetchPlanSnapshot
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchPlanSnapshot(WorkItemSearchContext context);

    /**
    * listPlanSnapshot
    * 
    * @param context
    * @return
    */
    List<WorkItem> listPlanSnapshot(WorkItemSearchContext context);

    /**
    * fetchProjectResource
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchProjectResource(WorkItemSearchContext context);

    /**
    * listProjectResource
    * 
    * @param context
    * @return
    */
    List<WorkItem> listProjectResource(WorkItemSearchContext context);

    /**
    * fetchPropertyDistribution
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchPropertyDistribution(WorkItemSearchContext context);

    /**
    * listPropertyDistribution
    * 
    * @param context
    * @return
    */
    List<WorkItem> listPropertyDistribution(WorkItemSearchContext context);

    /**
    * fetchReader
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchReader(WorkItemSearchContext context);

    /**
    * listReader
    * 
    * @param context
    * @return
    */
    List<WorkItem> listReader(WorkItemSearchContext context);

    /**
    * fetchRecentWorkItem
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchRecentWorkItem(WorkItemSearchContext context);

    /**
    * listRecentWorkItem
    * 
    * @param context
    * @return
    */
    List<WorkItem> listRecentWorkItem(WorkItemSearchContext context);

    /**
    * fetchRelease
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchRelease(WorkItemSearchContext context);

    /**
    * listRelease
    * 
    * @param context
    * @return
    */
    List<WorkItem> listRelease(WorkItemSearchContext context);

    /**
    * fetchReleasePlan
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchReleasePlan(WorkItemSearchContext context);

    /**
    * listReleasePlan
    * 
    * @param context
    * @return
    */
    List<WorkItem> listReleasePlan(WorkItemSearchContext context);

    /**
    * fetchReleaseWorkItemChart
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchReleaseWorkItemChart(WorkItemSearchContext context);

    /**
    * listReleaseWorkItemChart
    * 
    * @param context
    * @return
    */
    List<WorkItem> listReleaseWorkItemChart(WorkItemSearchContext context);

    /**
    * fetchRequirement
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchRequirement(WorkItemSearchContext context);

    /**
    * listRequirement
    * 
    * @param context
    * @return
    */
    List<WorkItem> listRequirement(WorkItemSearchContext context);

    /**
    * fetchRequirementTree
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchRequirementTree(WorkItemSearchContext context);

    /**
    * listRequirementTree
    * 
    * @param context
    * @return
    */
    List<WorkItem> listRequirementTree(WorkItemSearchContext context);

    /**
    * fetchResource
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchResource(WorkItemSearchContext context);

    /**
    * listResource
    * 
    * @param context
    * @return
    */
    List<WorkItem> listResource(WorkItemSearchContext context);

    /**
    * fetchSevenDays
    * 工作项完成趋势逻辑中使用
    * @param context
    * @return
    */
    Page<WorkItem> fetchSevenDays(WorkItemSearchContext context);

    /**
    * listSevenDays
    * 工作项完成趋势逻辑中使用
    * @param context
    * @return
    */
    List<WorkItem> listSevenDays(WorkItemSearchContext context);

    /**
    * fetchSprintCompleted
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchSprintCompleted(WorkItemSearchContext context);

    /**
    * listSprintCompleted
    * 
    * @param context
    * @return
    */
    List<WorkItem> listSprintCompleted(WorkItemSearchContext context);

    /**
    * fetchSprintWorkItemChart
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchSprintWorkItemChart(WorkItemSearchContext context);

    /**
    * listSprintWorkItemChart
    * 
    * @param context
    * @return
    */
    List<WorkItem> listSprintWorkItemChart(WorkItemSearchContext context);

    /**
    * fetchTestPlanRelationBug
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchTestPlanRelationBug(WorkItemSearchContext context);

    /**
    * listTestPlanRelationBug
    * 
    * @param context
    * @return
    */
    List<WorkItem> listTestPlanRelationBug(WorkItemSearchContext context);

    /**
    * fetchTop
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchTop(WorkItemSearchContext context);

    /**
    * listTop
    * 
    * @param context
    * @return
    */
    List<WorkItem> listTop(WorkItemSearchContext context);

    /**
    * fetchTree
    * 未删除
    * @param context
    * @return
    */
    Page<WorkItem> fetchTree(WorkItemSearchContext context);

    /**
    * listTree
    * 未删除
    * @param context
    * @return
    */
    List<WorkItem> listTree(WorkItemSearchContext context);

    /**
    * fetchUnderWork
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchUnderWork(WorkItemSearchContext context);

    /**
    * listUnderWork
    * 
    * @param context
    * @return
    */
    List<WorkItem> listUnderWork(WorkItemSearchContext context);

    /**
    * fetchUnderWorkResource
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchUnderWorkResource(WorkItemSearchContext context);

    /**
    * listUnderWorkResource
    * 
    * @param context
    * @return
    */
    List<WorkItem> listUnderWorkResource(WorkItemSearchContext context);

    /**
    * fetchWorkItemType
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchWorkItemType(WorkItemSearchContext context);

    /**
    * listWorkItemType
    * 
    * @param context
    * @return
    */
    List<WorkItem> listWorkItemType(WorkItemSearchContext context);

    /**
    * findByBoardId
    * @param boardIds
    * @return
    */
    List<WorkItem> findByBoardId(List<String> boardIds);
    default List<WorkItem> findByBoardId(String boardId){
        return findByBoard(new Board().setId(boardId));
    }

    /**
    * findByBoard
    * @param board
    * @return
    */
    List<WorkItem> findByBoard(Board board);

    /**
    * removeByBoardId
    * @param boardId
    * @return
    */
    boolean removeByBoardId(String boardId);

    /**
    * resetByBoardId
    * @param boardId
    * @return
    */
    boolean resetByBoardId(String boardId);

    /**
    * saveByBoardId
    * @param boardId
    * @param list
    * @return
    */
    default boolean saveByBoardId(String boardId, List<WorkItem> list){
        return getSelf().saveByBoard(new Board().setId(boardId),list);
    }

    /**
    * saveByBoard
    * @param board
    * @param list
    * @return
    */
    boolean saveByBoard(Board board, List<WorkItem> list);

    /**
    * findByEntryId
    * @param entryIds
    * @return
    */
    List<WorkItem> findByEntryId(List<String> entryIds);
    default List<WorkItem> findByEntryId(String entryId){
        return findByEntry(new Entry().setId(entryId));
    }

    /**
    * findByEntry
    * @param entry
    * @return
    */
    List<WorkItem> findByEntry(Entry entry);

    /**
    * removeByEntryId
    * @param entryId
    * @return
    */
    boolean removeByEntryId(String entryId);

    /**
    * resetByEntryId
    * @param entryId
    * @return
    */
    boolean resetByEntryId(String entryId);

    /**
    * saveByEntryId
    * @param entryId
    * @param list
    * @return
    */
    default boolean saveByEntryId(String entryId, List<WorkItem> list){
        return getSelf().saveByEntry(new Entry().setId(entryId),list);
    }

    /**
    * saveByEntry
    * @param entry
    * @param list
    * @return
    */
    boolean saveByEntry(Entry entry, List<WorkItem> list);

    /**
    * findByProjectId
    * @param projectIds
    * @return
    */
    List<WorkItem> findByProjectId(List<String> projectIds);
    default List<WorkItem> findByProjectId(String projectId){
        return findByProject(new Project().setId(projectId));
    }

    /**
    * findByProject
    * @param project
    * @return
    */
    List<WorkItem> findByProject(Project project);

    /**
    * removeByProjectId
    * @param projectId
    * @return
    */
    boolean removeByProjectId(String projectId);

    /**
    * resetByProjectId
    * @param projectId
    * @return
    */
    boolean resetByProjectId(String projectId);

    /**
    * saveByProjectId
    * @param projectId
    * @param list
    * @return
    */
    default boolean saveByProjectId(String projectId, List<WorkItem> list){
        return getSelf().saveByProject(new Project().setId(projectId),list);
    }

    /**
    * saveByProject
    * @param project
    * @param list
    * @return
    */
    boolean saveByProject(Project project, List<WorkItem> list);

    /**
    * findByReleaseId
    * @param releaseIds
    * @return
    */
    List<WorkItem> findByReleaseId(List<String> releaseIds);
    default List<WorkItem> findByReleaseId(String releaseId){
        return findByRelease(new Release().setId(releaseId));
    }

    /**
    * findByRelease
    * @param release
    * @return
    */
    List<WorkItem> findByRelease(Release release);

    /**
    * removeByReleaseId
    * @param releaseId
    * @return
    */
    boolean removeByReleaseId(String releaseId);

    /**
    * resetByReleaseId
    * @param releaseId
    * @return
    */
    boolean resetByReleaseId(String releaseId);

    /**
    * saveByReleaseId
    * @param releaseId
    * @param list
    * @return
    */
    default boolean saveByReleaseId(String releaseId, List<WorkItem> list){
        return getSelf().saveByRelease(new Release().setId(releaseId),list);
    }

    /**
    * saveByRelease
    * @param release
    * @param list
    * @return
    */
    boolean saveByRelease(Release release, List<WorkItem> list);

    /**
    * findBySprintId
    * @param sprintIds
    * @return
    */
    List<WorkItem> findBySprintId(List<String> sprintIds);
    default List<WorkItem> findBySprintId(String sprintId){
        return findBySprint(new Sprint().setId(sprintId));
    }

    /**
    * findBySprint
    * @param sprint
    * @return
    */
    List<WorkItem> findBySprint(Sprint sprint);

    /**
    * removeBySprintId
    * @param sprintId
    * @return
    */
    boolean removeBySprintId(String sprintId);

    /**
    * resetBySprintId
    * @param sprintId
    * @return
    */
    boolean resetBySprintId(String sprintId);

    /**
    * saveBySprintId
    * @param sprintId
    * @param list
    * @return
    */
    default boolean saveBySprintId(String sprintId, List<WorkItem> list){
        return getSelf().saveBySprint(new Sprint().setId(sprintId),list);
    }

    /**
    * saveBySprint
    * @param sprint
    * @param list
    * @return
    */
    boolean saveBySprint(Sprint sprint, List<WorkItem> list);

    /**
    * findBySwimlaneId
    * @param swimlaneIds
    * @return
    */
    List<WorkItem> findBySwimlaneId(List<String> swimlaneIds);
    default List<WorkItem> findBySwimlaneId(String swimlaneId){
        return findBySwimlane(new Swimlane().setId(swimlaneId));
    }

    /**
    * findBySwimlane
    * @param swimlane
    * @return
    */
    List<WorkItem> findBySwimlane(Swimlane swimlane);

    /**
    * removeBySwimlaneId
    * @param swimlaneId
    * @return
    */
    boolean removeBySwimlaneId(String swimlaneId);

    /**
    * resetBySwimlaneId
    * @param swimlaneId
    * @return
    */
    boolean resetBySwimlaneId(String swimlaneId);

    /**
    * saveBySwimlaneId
    * @param swimlaneId
    * @param list
    * @return
    */
    default boolean saveBySwimlaneId(String swimlaneId, List<WorkItem> list){
        return getSelf().saveBySwimlane(new Swimlane().setId(swimlaneId),list);
    }

    /**
    * saveBySwimlane
    * @param swimlane
    * @param list
    * @return
    */
    boolean saveBySwimlane(Swimlane swimlane, List<WorkItem> list);

    /**
    * findByAssigneeId
    * @param assigneeIds
    * @return
    */
    List<WorkItem> findByAssigneeId(List<String> assigneeIds);
    default List<WorkItem> findByAssigneeId(String assigneeId){
        return findByUser(new User().setId(assigneeId));
    }

    /**
    * findByUser
    * @param user
    * @return
    */
    List<WorkItem> findByUser(User user);

    /**
    * removeByAssigneeId
    * @param assigneeId
    * @return
    */
    boolean removeByAssigneeId(String assigneeId);

    /**
    * resetByAssigneeId
    * @param assigneeId
    * @return
    */
    boolean resetByAssigneeId(String assigneeId);

    /**
    * saveByAssigneeId
    * @param assigneeId
    * @param list
    * @return
    */
    default boolean saveByAssigneeId(String assigneeId, List<WorkItem> list){
        return getSelf().saveByUser(new User().setId(assigneeId),list);
    }

    /**
    * saveByUser
    * @param user
    * @param list
    * @return
    */
    boolean saveByUser(User user, List<WorkItem> list);

    /**
    * findByPid
    * @param pids
    * @return
    */
    List<WorkItem> findByPid(List<String> pids);
    default List<WorkItem> findByPid(String pid){
        return findByWorkItem(new WorkItem().setId(pid));
    }

    /**
    * findByWorkItem
    * @param workItem
    * @return
    */
    List<WorkItem> findByWorkItem(WorkItem workItem);

    /**
    * removeByPid
    * @param pid
    * @return
    */
    boolean removeByPid(String pid);

    /**
    * resetByPid
    * @param pid
    * @return
    */
    boolean resetByPid(String pid);

    /**
    * saveByPid
    * @param pid
    * @param list
    * @return
    */
    default boolean saveByPid(String pid, List<WorkItem> list){
        return getSelf().saveByWorkItem(new WorkItem().setId(pid),list);
    }

    /**
    * saveByWorkItem
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem(WorkItem workItem, List<WorkItem> list);

    /**
    * findByState
    * @param states
    * @return
    */
    List<WorkItem> findByState(List<String> states);
    default List<WorkItem> findByState(String state){
        return findByWorkItemState(new WorkItemState().setId(state));
    }

    /**
    * findByWorkItemState
    * @param workItemState
    * @return
    */
    List<WorkItem> findByWorkItemState(WorkItemState workItemState);

    /**
    * removeByState
    * @param state
    * @return
    */
    boolean removeByState(String state);

    /**
    * resetByState
    * @param state
    * @return
    */
    boolean resetByState(String state);

    /**
    * saveByState
    * @param state
    * @param list
    * @return
    */
    default boolean saveByState(String state, List<WorkItem> list){
        return getSelf().saveByWorkItemState(new WorkItemState().setId(state),list);
    }

    /**
    * saveByWorkItemState
    * @param workItemState
    * @param list
    * @return
    */
    boolean saveByWorkItemState(WorkItemState workItemState, List<WorkItem> list);

    /**
    * findByTopId
    * @param topIds
    * @return
    */
    List<WorkItem> findByTopId(List<String> topIds);
    default List<WorkItem> findByTopId(String topId){
        return findByWorkItem2(new WorkItem().setId(topId));
    }

    /**
    * findByWorkItem2
    * @param workItem
    * @return
    */
    List<WorkItem> findByWorkItem2(WorkItem workItem);

    /**
    * removeByTopId
    * @param topId
    * @return
    */
    boolean removeByTopId(String topId);

    /**
    * resetByTopId
    * @param topId
    * @return
    */
    boolean resetByTopId(String topId);

    /**
    * saveByTopId
    * @param topId
    * @param list
    * @return
    */
    default boolean saveByTopId(String topId, List<WorkItem> list){
        return getSelf().saveByWorkItem2(new WorkItem().setId(topId),list);
    }

    /**
    * saveByWorkItem2
    * @param workItem
    * @param list
    * @return
    */
    boolean saveByWorkItem2(WorkItem workItem, List<WorkItem> list);

    /**
    * findByWorkItemTypeId
    * @param workItemTypeIds
    * @return
    */
    List<WorkItem> findByWorkItemTypeId(List<String> workItemTypeIds);
    default List<WorkItem> findByWorkItemTypeId(String workItemTypeId){
        return findByWorkItemType(new WorkItemType().setId(workItemTypeId));
    }

    /**
    * findByWorkItemType
    * @param workItemType
    * @return
    */
    List<WorkItem> findByWorkItemType(WorkItemType workItemType);

    /**
    * removeByWorkItemTypeId
    * @param workItemTypeId
    * @return
    */
    boolean removeByWorkItemTypeId(String workItemTypeId);

    /**
    * resetByWorkItemTypeId
    * @param workItemTypeId
    * @return
    */
    boolean resetByWorkItemTypeId(String workItemTypeId);

    /**
    * saveByWorkItemTypeId
    * @param workItemTypeId
    * @param list
    * @return
    */
    default boolean saveByWorkItemTypeId(String workItemTypeId, List<WorkItem> list){
        return getSelf().saveByWorkItemType(new WorkItemType().setId(workItemTypeId),list);
    }

    /**
    * saveByWorkItemType
    * @param workItemType
    * @param list
    * @return
    */
    boolean saveByWorkItemType(WorkItemType workItemType, List<WorkItem> list);

    /**
    * findById
    * @param ids
    * @return
    */
    List<WorkItem> findById(List<String> ids);
    default List<WorkItem> findById(String id){
        return findByCommonFlow(new CommonFlow().setId(id));
    }

    /**
    * findByCommonFlow
    * @param commonFlow
    * @return
    */
    List<WorkItem> findByCommonFlow(CommonFlow commonFlow);

    /**
    * removeById
    * @param id
    * @return
    */
    boolean removeById(String id);

    /**
    * resetById
    * @param id
    * @return
    */
    boolean resetById(String id);

    /**
    * saveById
    * @param id
    * @param list
    * @return
    */
    default boolean saveById(String id, List<WorkItem> list){
        return getSelf().saveByCommonFlow(new CommonFlow().setId(id),list);
    }

    /**
    * saveByCommonFlow
    * @param commonFlow
    * @param list
    * @return
    */
    boolean saveByCommonFlow(CommonFlow commonFlow, List<WorkItem> list);

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
    * getBaselineName
    * 
    * @param et
    * @return
    */
    default WorkItem getBaselineName(WorkItem et) {
        return et;
    }

    /**
    * workItemTypeId
    * 
    * @param et
    * @return
    */
    default WorkItem workItemTypeId(WorkItem et) {
        return et;
    }

    /**
    * fetchView
    * 
    * @param context
    * @return
    */
    Page<WorkItem> fetchView(WorkItemSearchContext context);

    /**
    * listView
    * 
    * @param context
    * @return
    */
    List<WorkItem> listView(WorkItemSearchContext context);


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
    * 自定义SQL
    * @param sql  update table  set name ='test' where id =#{et.param}
    * @param param 参数列表  param.put("param","1");
    * @return
    */
    boolean execute(String sql, Map<String,Object> param);
}