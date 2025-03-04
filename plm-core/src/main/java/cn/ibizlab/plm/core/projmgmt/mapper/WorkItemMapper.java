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
     * 数据集合advanced_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchAdvancedSearch(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合advanced_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listAdvancedSearch(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合archived分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchArchived(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合archived查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listArchived(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合backlog_property_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchBacklogPropertyDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合backlog_property_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listBacklogPropertyDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合backlog_state_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchBacklogStateDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合backlog_state_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listBacklogStateDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合baseline_choose_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchBaselineChooseWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合baseline_choose_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listBaselineChooseWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合bi_detail分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchBiDetail(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合bi_detail查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listBiDetail(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合bi_search分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchBiSearch(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合bi_search查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listBiSearch(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合bug_state_group_grid分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchBugStateGroupGrid(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合bug_state_group_grid查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listBugStateGroupGrid(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合change_parent分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChangeParent(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合change_parent查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChangeParent(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合child分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChild(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合child查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChild(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合choose分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChoose(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合choose查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChoose(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合choose_child分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChooseChild(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合choose_child查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChooseChild(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合choose_dependency分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChooseDependency(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合choose_dependency查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChooseDependency(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合choose_parent_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchChooseParentWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合choose_parent_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listChooseParentWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合comment_notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchCommentNotifyAssignee(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合comment_notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listCommentNotifyAssignee(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合common分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchCommon(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合common查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listCommon(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合common_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchCommonBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合common_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listCommonBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合defect_property_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchDefectPropertyDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合defect_property_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listDefectPropertyDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合deleted分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchDeleted(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合deleted查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listDeleted(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合idea_relation_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchIdeaRelationWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合idea_relation_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listIdeaRelationWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合kanban_user_stat分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchKanbanUserStat(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合kanban_user_stat查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listKanbanUserStat(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合milestone分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMilestone(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合milestone查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMilestone(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合move_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMoveWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合move_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMoveWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyAssignee(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyAssignee(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_assignee_count分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchMyAssigneeCount(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_assignee_count查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listMyAssigneeCount(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_attention分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyAttention(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_attention查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyAttention(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_created分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyCreated(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_created查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyCreated(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_filter分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyFilter(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_filter查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyFilter(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_summary_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMySummaryBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_summary_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMySummaryBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_summary_other分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMySummaryOther(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_summary_other查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMySummaryOther(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_summary_task分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMySummaryTask(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_summary_task查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMySummaryTask(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合my_todo分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchMyTodo(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合my_todo查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listMyTodo(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合no_bug_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNoBugWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合no_bug_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNoBugWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合no_completed分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNoCompleted(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合no_completed查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNoCompleted(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合normal分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNormal(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合normal查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNormal(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合not_exsists_bug_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotExsistsBugRelation(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合not_exsists_bug_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotExsistsBugRelation(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合not_exsists_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotExsistsRelation(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合not_exsists_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotExsistsRelation(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合notbug_exsists_relation分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotbugExsistsRelation(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合notbug_exsists_relation查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotbugExsistsRelation(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合notify_assignee分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchNotifyAssignee(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合notify_assignee查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listNotifyAssignee(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合overdue_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchOverdueWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合overdue_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listOverdueWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合overview_chart分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchOverviewChart(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合overview_chart查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listOverviewChart(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合plan_snapshot分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchPlanSnapshot(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合plan_snapshot查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listPlanSnapshot(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合project_resource分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchProjectResource(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合project_resource查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listProjectResource(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合property_distribution分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<Map> searchPropertyDistribution(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合property_distribution查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<Map> listPropertyDistribution(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合reader分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchReader(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合reader查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listReader(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合recent_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRecentWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合recent_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRecentWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合relation_work_item分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRelationWorkItem(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合relation_work_item查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRelationWorkItem(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合release分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRelease(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合release查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRelease(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合release_plan分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchReleasePlan(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合release_plan查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listReleasePlan(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合release_work_item_chart分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchReleaseWorkItemChart(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合release_work_item_chart查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listReleaseWorkItemChart(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合requirement分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRequirement(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合requirement查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRequirement(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合requirement_tree分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchRequirementTree(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合requirement_tree查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listRequirementTree(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合resource分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchResource(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合resource查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listResource(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合seven_days分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchSevenDays(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合seven_days查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listSevenDays(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合sprint_completed分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchSprintCompleted(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合sprint_completed查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listSprintCompleted(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合sprint_work_item_chart分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchSprintWorkItemChart(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合sprint_work_item_chart查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listSprintWorkItemChart(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合test_plan_relation_bug分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTestPlanRelationBug(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合test_plan_relation_bug查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTestPlanRelationBug(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合top分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTop(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合top查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTop(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合tree分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchTree(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合tree查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listTree(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合under_work分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchUnderWork(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合under_work查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listUnderWork(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合under_work_resource分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchUnderWorkResource(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合under_work_resource查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listUnderWorkResource(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

    /**
     * 数据集合work_item_type分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchWorkItemType(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合work_item_type查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listWorkItemType(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

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

    /**
    * 根据id查询
    *
    * @param ids
    * @return
    */
    List<WorkItem> findById(@Param("ids") List<String> ids);

    /**
     * 数据集合View分页查询
     * 
     * @param page
     * @param context
     * @param wrapper
     * @return
     */
    Page<WorkItem> searchView(IPage<WorkItem> page, @Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);
    
    /**
     * 数据集合View查询
     * 
     * @param context
     * @param wrapper
     * @return
     */
    List<WorkItem> listView(@Param("ctx") WorkItemSearchContext context, @Param("ew") Wrapper<WorkItem> wrapper);

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
}