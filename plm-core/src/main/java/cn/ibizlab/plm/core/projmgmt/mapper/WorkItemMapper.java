/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapper/{{entities@SQL}}Mapper.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemSearchContext;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.alibaba.fastjson.JSONObject;

/**
 * 工作项Mapper[WorkItem]
 *
 * @author generator
 */
public interface WorkItemMapper extends BaseMapper<WorkItem> {

    /**
     * 数据集合Advanced_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchAdvancedSearch(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Advanced_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listAdvancedSearch(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchArchived(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listArchived(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Backlog_property_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchBacklogPropertyDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Backlog_property_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listBacklogPropertyDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Backlog_state_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchBacklogStateDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Backlog_state_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listBacklogStateDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Bug_state_group_grid分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchBugStateGroupGrid(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Bug_state_group_grid查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listBugStateGroupGrid(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Change_parent分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChangeParent(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Change_parent查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChangeParent(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Choose_child分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChooseChild(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Choose_child查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChooseChild(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Comment_notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchCommentNotifyAssignee(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Comment_notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listCommentNotifyAssignee(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Common分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchCommon(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Common查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listCommon(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Common_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchCommonBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Common_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listCommonBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Default分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchDefault(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Default查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listDefault(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Defect_property_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchDefectPropertyDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Defect_property_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listDefectPropertyDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchDeleted(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listDeleted(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Idea_relation_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchIdeaRelationWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Idea_relation_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listIdeaRelationWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Kanban_user_stat分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchKanbanUserStat(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Kanban_user_stat查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listKanbanUserStat(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Milestone分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMilestone(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Milestone查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMilestone(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合My_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyAssignee(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合My_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyAssignee(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合My_assignee_count分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchMyAssigneeCount(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合My_assignee_count查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listMyAssigneeCount(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合My_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyAttention(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合My_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyAttention(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合My_created分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyCreated(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合My_created查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyCreated(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合My_filter分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyFilter(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合My_filter查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyFilter(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合My_todo分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyTodo(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合My_todo查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyTodo(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合No_bug_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNoBugWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合No_bug_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNoBugWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNormal(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNormal(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Not_exsists_bug_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotExsistsBugRelation(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Not_exsists_bug_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotExsistsBugRelation(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Not_exsists_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotExsistsRelation(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Not_exsists_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotExsistsRelation(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Notbug_exsists_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotbugExsistsRelation(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Notbug_exsists_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotbugExsistsRelation(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotifyAssignee(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotifyAssignee(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Overview_chart分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchOverviewChart(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Overview_chart查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listOverviewChart(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Plan分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchPlan(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Plan查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listPlan(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Property_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchPropertyDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Property_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listPropertyDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Recent_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRecentWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Recent_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRecentWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Requirement分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRequirement(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Requirement查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRequirement(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Resource_assignment分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchResourceAssignment(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Resource_assignment查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listResourceAssignment(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Run_relation_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRunRelationBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Run_relation_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRunRelationBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Run_relation_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRunRelationWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Run_relation_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRunRelationWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Sprint_user_stat分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchSprintUserStat(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Sprint_user_stat查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listSprintUserStat(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Temp_speed_report分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchTempSpeedReport(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Temp_speed_report查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listTempSpeedReport(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Test_case_relation_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTestCaseRelationBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Test_case_relation_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTestCaseRelationBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Test_case_relation_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTestCaseRelationWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Test_case_relation_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTestCaseRelationWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Test_plan_relation_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTestPlanRelationBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Test_plan_relation_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTestPlanRelationBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Ticket_relation_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTicketRelationWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Ticket_relation_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTicketRelationWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Top分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTop(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Top查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTop(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Top_tree_grid分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTopTreeGrid(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Top_tree_grid查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTopTreeGrid(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Under_work分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchUnderWork(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Under_work查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listUnderWork(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Work_item_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchWorkItemDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Work_item_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listWorkItemDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合Work_item_relation_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchWorkItemRelationWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合Work_item_relation_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listWorkItemRelationWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 主键查询
     *
     * @param 
     * @return
     */
    @Override
    WorkItem selectById(Serializable id);

    /**
     * 数据对象查询
     *
     * @param entity
     * @return
     */
    WorkItem selectEntity(WorkItem entity);

    /**
     * 数据对象集合查询
     *
     * @param list
     * @return
     */
    List<WorkItem> selectEntities(@Param("list") List<WorkItem> list);

    /**
     * 插入数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int insert(WorkItem entity);

    /**
     * 根据主键更新数据对象
     *
     * @param entity
     * @return
     */
    @Override
    int updateById(@Param(Constants.ENTITY) WorkItem entity);

    /**
     * 更新数据对象
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    @Override
    int update(@Param(Constants.ENTITY) WorkItem entity, @Param("ew") Wrapper<WorkItem> updateWrapper);

    /**
     * 主键删除
     *
     * @param id
     * @return
     */
    @Override
    int deleteById(Serializable id);

    /**
     * 数据对象集合删除
     *
     * @param list
     * @return
     */
    int deleteEntities(@Param("list") List<WorkItem> list);

    /**
     * 自定义查询SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Select("${sql}")
    List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义更新SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义插入SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 自定义删除SQL
     *
     * @param sql
     * @param param
     * @return
     */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map<String,Object> param);

    /**
     * 根据boardId查询
     *
     * @param boardIds
     * @return
     */
    List<WorkItem> findByBoardId(@Param("boardIds") List<String> boardIds);

    /**
     * 根据entryId查询
     *
     * @param entryIds
     * @return
     */
    List<WorkItem> findByEntryId(@Param("entryIds") List<String> entryIds);

    /**
     * 根据projectId查询
     *
     * @param projectIds
     * @return
     */
    List<WorkItem> findByProjectId(@Param("projectIds") List<String> projectIds);

    /**
     * 根据releaseId查询
     *
     * @param releaseIds
     * @return
     */
    List<WorkItem> findByReleaseId(@Param("releaseIds") List<String> releaseIds);

    /**
     * 根据sprintId查询
     *
     * @param sprintIds
     * @return
     */
    List<WorkItem> findBySprintId(@Param("sprintIds") List<String> sprintIds);

    /**
     * 根据swimlaneId查询
     *
     * @param swimlaneIds
     * @return
     */
    List<WorkItem> findBySwimlaneId(@Param("swimlaneIds") List<String> swimlaneIds);

    /**
     * 根据assigneeId查询
     *
     * @param assigneeIds
     * @return
     */
    List<WorkItem> findByAssigneeId(@Param("assigneeIds") List<String> assigneeIds);

    /**
     * 根据pid查询
     *
     * @param pids
     * @return
     */
    List<WorkItem> findByPid(@Param("pids") List<String> pids);

    /**
     * 根据state查询
     *
     * @param states
     * @return
     */
    List<WorkItem> findByState(@Param("states") List<String> states);

    /**
     * 根据topId查询
     *
     * @param topIds
     * @return
     */
    List<WorkItem> findByTopId(@Param("topIds") List<String> topIds);

    /**
     * 根据workItemTypeId查询
     *
     * @param workItemTypeIds
     * @return
     */
    List<WorkItem> findByWorkItemTypeId(@Param("workItemTypeIds") List<String> workItemTypeIds);

}