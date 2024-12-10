/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.annotation.JSONField;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;
import org.springframework.util.ObjectUtils;
import cn.ibizlab.util.filter.QueryWrapperContext;
import cn.ibizlab.util.filter.QueryFilter;
import cn.ibizlab.plm.util.enums.Entities;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 关系型数据实体[WorkItem] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项查询条件对象")
public class WorkItemSearchContext extends QueryWrapperContext<WorkItem> {

    /**
     * 编号EQ
     */
    @JsonProperty("n_show_identifier_eq")
    @JSONField(name = "n_show_identifier_eq")
    @ApiModelProperty("编号EQ")
    private String showIdentifierEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String showIdentifierLIKE;

    /**
     * 编号EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty("编号EQ")
    private String identifierEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String identifierLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty("是否已归档EQ")
    private Integer isArchivedEQ;

    /**
     * 是否已归档IN
     */
    @JsonProperty("n_is_archived_in")
    @JSONField(name = "n_is_archived_in")
    @ApiModelProperty("是否已归档IN")
    private String isArchivedIN;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty("标题LIKE")
    private String titleLIKE;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty("是否已删除EQ")
    private Integer isDeletedEQ;

    /**
     * 是否已删除IN
     */
    @JsonProperty("n_is_deleted_in")
    @JSONField(name = "n_is_deleted_in")
    @ApiModelProperty("是否已删除IN")
    private String isDeletedIN;

    /**
     * 开始时间GTANDEQ
     */
    @JsonProperty("n_start_at_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_start_at_gtandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("开始时间GTANDEQ")
    private Date startAtGTANDEQ;

    /**
     * 开始时间LT
     */
    @JsonProperty("n_start_at_lt")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_start_at_lt" , format = "yyyy-MM-dd")
    @ApiModelProperty("开始时间LT")
    private Date startAtLT;

    /**
     * 开始时间LTANDEQ
     */
    @JsonProperty("n_start_at_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_start_at_ltandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("开始时间LTANDEQ")
    private Date startAtLTANDEQ;

    /**
     * 截止时间GTANDEQ
     */
    @JsonProperty("n_end_at_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_end_at_gtandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("截止时间GTANDEQ")
    private Date endAtGTANDEQ;

    /**
     * 截止时间LTANDEQ
     */
    @JsonProperty("n_end_at_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_end_at_ltandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("截止时间LTANDEQ")
    private Date endAtLTANDEQ;

    /**
     * 状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty("状态EQ")
    private String stateEQ;

    /**
     * 状态NOTEQ
     */
    @JsonProperty("n_state_noteq")
    @JSONField(name = "n_state_noteq")
    @ApiModelProperty("状态NOTEQ")
    private String stateNOTEQ;

    /**
     * 状态NOTIN
     */
    @JsonProperty("n_state_notin")
    @JSONField(name = "n_state_notin")
    @ApiModelProperty("状态NOTIN")
    private String stateNOTIN;

    /**
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty("优先级EQ")
    private String priorityEQ;

    /**
     * 需求类型EQ
     */
    @JsonProperty("n_backlog_type_eq")
    @JSONField(name = "n_backlog_type_eq")
    @ApiModelProperty("需求类型EQ")
    private String backlogTypeEQ;

    /**
     * 需求来源EQ
     */
    @JsonProperty("n_backlog_from_eq")
    @JSONField(name = "n_backlog_from_eq")
    @ApiModelProperty("需求来源EQ")
    private String backlogFromEQ;

    /**
     * 描述EQ
     */
    @JsonProperty("n_description_eq")
    @JSONField(name = "n_description_eq")
    @ApiModelProperty("描述EQ")
    private String descriptionEQ;

    /**
     * 描述LIKE
     */
    @JsonProperty("n_description_like")
    @JSONField(name = "n_description_like")
    @ApiModelProperty("描述LIKE")
    private String descriptionLIKE;

    /**
     * 复现概率EQ
     */
    @JsonProperty("n_reappear_probability_eq")
    @JSONField(name = "n_reappear_probability_eq")
    @ApiModelProperty("复现概率EQ")
    private String reappearProbabilityEQ;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty("负责人EQ")
    private String assigneeIdEQ;

    /**
     * 负责人IN
     */
    @JsonProperty("n_assignee_id_in")
    @JSONField(name = "n_assignee_id_in")
    @ApiModelProperty("负责人IN")
    private String assigneeIdIN;

    /**
     * 负责人ISNOTNULL
     */
    @JsonProperty("n_assignee_id_isnotnull")
    @JSONField(name = "n_assignee_id_isnotnull")
    @ApiModelProperty("负责人ISNOTNULL")
    private String assigneeIdISNOTNULL;

    /**
     * 负责人ISNULL
     */
    @JsonProperty("n_assignee_id_isnull")
    @JSONField(name = "n_assignee_id_isnull")
    @ApiModelProperty("负责人ISNULL")
    private String assigneeIdISNULL;

    /**
     * 负责人NOTEQ
     */
    @JsonProperty("n_assignee_id_noteq")
    @JSONField(name = "n_assignee_id_noteq")
    @ApiModelProperty("负责人NOTEQ")
    private String assigneeIdNOTEQ;

    /**
     * 负责人NOTIN
     */
    @JsonProperty("n_assignee_id_notin")
    @JSONField(name = "n_assignee_id_notin")
    @ApiModelProperty("负责人NOTIN")
    private String assigneeIdNOTIN;

    /**
     * 严重程度EQ
     */
    @JsonProperty("n_severity_eq")
    @JSONField(name = "n_severity_eq")
    @ApiModelProperty("严重程度EQ")
    private String severityEQ;

    /**
     * 风险EQ
     */
    @JsonProperty("n_risk_eq")
    @JSONField(name = "n_risk_eq")
    @ApiModelProperty("风险EQ")
    private String riskEQ;

    /**
     * 工作项类型分组EQ
     */
    @JsonProperty("n_work_item_type_group_eq")
    @JSONField(name = "n_work_item_type_group_eq")
    @ApiModelProperty("工作项类型分组EQ")
    private String workItemTypeGroupEQ;

    /**
     * 标签LIKE
     */
    @JsonProperty("n_tags_like")
    @JSONField(name = "n_tags_like")
    @ApiModelProperty("标签LIKE")
    private String tagsLIKE;

    /**
     * 任务类别EQ
     */
    @JsonProperty("n_job_type_eq")
    @JSONField(name = "n_job_type_eq")
    @ApiModelProperty("任务类别EQ")
    private String jobTypeEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_owner_id_eq")
    @JSONField(name = "n_attentions_exists__n_owner_id_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTSowner_idEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_type_eq")
    @JSONField(name = "n_attentions_exists__n_type_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTStypeEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTSuser_idEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_type_eq")
    @JSONField(name = "n_attentions_notexists__n_type_eq")
    @ApiModelProperty("关注NOTEXISTS")
    private String attentionsNOTEXISTStypeEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_user_id_eq")
    @JSONField(name = "n_attentions_notexists__n_user_id_eq")
    @ApiModelProperty("关注NOTEXISTS")
    private String attentionsNOTEXISTSuser_idEQ;

    /**
     * 工作项状态类型EQ
     */
    @JsonProperty("n_state_type_eq")
    @JSONField(name = "n_state_type_eq")
    @ApiModelProperty("工作项状态类型EQ")
    private String stateTypeEQ;

    /**
     * 工作项状态类型NOTEQ
     */
    @JsonProperty("n_state_type_noteq")
    @JSONField(name = "n_state_type_noteq")
    @ApiModelProperty("工作项状态类型NOTEQ")
    private String stateTypeNOTEQ;

    /**
     * 最近创建日期LTANDEQ
     */
    @JsonProperty("n_recent_create_days_ltandeq")
    @JSONField(name = "n_recent_create_days_ltandeq")
    @ApiModelProperty("最近创建日期LTANDEQ")
    private Integer recentCreateDaysLTANDEQ;

    /**
     * 原始状态EQ
     */
    @JsonProperty("n_work_item_origin_state_eq")
    @JSONField(name = "n_work_item_origin_state_eq")
    @ApiModelProperty("原始状态EQ")
    private String workItemOriginStateEQ;

    /**
     * 执行人EXISTS
     */
    @JsonProperty("n_executors_exists__n_user_id_eq")
    @JSONField(name = "n_executors_exists__n_user_id_eq")
    @ApiModelProperty("执行人EXISTS")
    private String executorsEXISTSuser_idEQ;

    /**
     * 逾期天数EQ
     */
    @JsonProperty("n_overdue_time_eq")
    @JSONField(name = "n_overdue_time_eq")
    @ApiModelProperty("逾期天数EQ")
    private String overdueTimeEQ;

    /**
     * 逾期天数GT
     */
    @JsonProperty("n_overdue_time_gt")
    @JSONField(name = "n_overdue_time_gt")
    @ApiModelProperty("逾期天数GT")
    private String overdueTimeGT;

    /**
     * 逾期天数GTANDEQ
     */
    @JsonProperty("n_overdue_time_gtandeq")
    @JSONField(name = "n_overdue_time_gtandeq")
    @ApiModelProperty("逾期天数GTANDEQ")
    private String overdueTimeGTANDEQ;

    /**
     * 逾期天数LT
     */
    @JsonProperty("n_overdue_time_lt")
    @JSONField(name = "n_overdue_time_lt")
    @ApiModelProperty("逾期天数LT")
    private String overdueTimeLT;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 标识EXISTS
     */
    @JsonProperty("n_id_exists__n_id_eq")
    @JSONField(name = "n_id_exists__n_id_eq")
    @ApiModelProperty("标识EXISTS")
    private String idEXISTSidEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty("标识IN")
    private String idIN;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty("标识NOTEQ")
    private String idNOTEQ;

    /**
     * 标识NOTIN
     */
    @JsonProperty("n_id_notin")
    @JSONField(name = "n_id_notin")
    @ApiModelProperty("标识NOTIN")
    private String idNOTIN;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty("建立人IN")
    private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty("建立人ISNOTNULL")
    private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty("建立人ISNULL")
    private String createManISNULL;

    /**
     * 建立人NOTEQ
     */
    @JsonProperty("n_create_man_noteq")
    @JSONField(name = "n_create_man_noteq")
    @ApiModelProperty("建立人NOTEQ")
    private String createManNOTEQ;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty("建立人NOTIN")
    private String createManNOTIN;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间EQ")
    private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间GTANDEQ")
    private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间LTANDEQ")
    private Date createTimeLTANDEQ;

    /**
     * 更新时间GTANDEQ
     */
    @JsonProperty("n_update_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间GTANDEQ")
    private Date updateTimeGTANDEQ;

    /**
     * 更新时间LTANDEQ
     */
    @JsonProperty("n_update_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间LTANDEQ")
    private Date updateTimeLTANDEQ;

    /**
     * 项目EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty("项目EQ")
    private String projectIdEQ;

    /**
     * 项目IN
     */
    @JsonProperty("n_project_id_in")
    @JSONField(name = "n_project_id_in")
    @ApiModelProperty("项目IN")
    private String projectIdIN;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_id_eq")
    @JSONField(name = "n_work_item_type_id_eq")
    @ApiModelProperty("工作项类型EQ")
    private String workItemTypeIdEQ;

    /**
     * 工作项类型IN
     */
    @JsonProperty("n_work_item_type_id_in")
    @JSONField(name = "n_work_item_type_id_in")
    @ApiModelProperty("工作项类型IN")
    private String workItemTypeIdIN;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_id_like")
    @JSONField(name = "n_work_item_type_id_like")
    @ApiModelProperty("工作项类型LIKE")
    private String workItemTypeIdLIKE;

    /**
     * 所属项目EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty("所属项目EQ")
    private String projectNameEQ;

    /**
     * 所属项目LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty("所属项目LIKE")
    private String projectNameLIKE;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_name_eq")
    @JSONField(name = "n_work_item_type_name_eq")
    @ApiModelProperty("工作项类型EQ")
    private String workItemTypeNameEQ;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_name_like")
    @JSONField(name = "n_work_item_type_name_like")
    @ApiModelProperty("工作项类型LIKE")
    private String workItemTypeNameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty("父标识EQ")
    private String pidEQ;

    /**
     * 父工作项EQ
     */
    @JsonProperty("n_ptitle_eq")
    @JSONField(name = "n_ptitle_eq")
    @ApiModelProperty("父工作项EQ")
    private String ptitleEQ;

    /**
     * 父工作项LIKE
     */
    @JsonProperty("n_ptitle_like")
    @JSONField(name = "n_ptitle_like")
    @ApiModelProperty("父工作项LIKE")
    private String ptitleLIKE;

    /**
     * 迭代标识EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty("迭代标识EQ")
    private String sprintIdEQ;

    /**
     * 迭代标识ISNULL
     */
    @JsonProperty("n_sprint_id_isnull")
    @JSONField(name = "n_sprint_id_isnull")
    @ApiModelProperty("迭代标识ISNULL")
    private String sprintIdISNULL;

    /**
     * 看板标识EQ
     */
    @JsonProperty("n_board_id_eq")
    @JSONField(name = "n_board_id_eq")
    @ApiModelProperty("看板标识EQ")
    private String boardIdEQ;

    /**
     * 看板栏标识EQ
     */
    @JsonProperty("n_entry_id_eq")
    @JSONField(name = "n_entry_id_eq")
    @ApiModelProperty("看板栏标识EQ")
    private String entryIdEQ;

    /**
     * 泳道标识EQ
     */
    @JsonProperty("n_swimlane_id_eq")
    @JSONField(name = "n_swimlane_id_eq")
    @ApiModelProperty("泳道标识EQ")
    private String swimlaneIdEQ;

    /**
     * 看板栏名称EQ
     */
    @JsonProperty("n_entry_name_eq")
    @JSONField(name = "n_entry_name_eq")
    @ApiModelProperty("看板栏名称EQ")
    private String entryNameEQ;

    /**
     * 看板栏名称LIKE
     */
    @JsonProperty("n_entry_name_like")
    @JSONField(name = "n_entry_name_like")
    @ApiModelProperty("看板栏名称LIKE")
    private String entryNameLIKE;

    /**
     * 看板名称EQ
     */
    @JsonProperty("n_board_name_eq")
    @JSONField(name = "n_board_name_eq")
    @ApiModelProperty("看板名称EQ")
    private String boardNameEQ;

    /**
     * 看板名称LIKE
     */
    @JsonProperty("n_board_name_like")
    @JSONField(name = "n_board_name_like")
    @ApiModelProperty("看板名称LIKE")
    private String boardNameLIKE;

    /**
     * 顶级工作项标识EQ
     */
    @JsonProperty("n_top_id_eq")
    @JSONField(name = "n_top_id_eq")
    @ApiModelProperty("顶级工作项标识EQ")
    private String topIdEQ;

    /**
     * 顶级工作项标识IN
     */
    @JsonProperty("n_top_id_in")
    @JSONField(name = "n_top_id_in")
    @ApiModelProperty("顶级工作项标识IN")
    private String topIdIN;

    /**
     * 顶级工作项标题EQ
     */
    @JsonProperty("n_top_title_eq")
    @JSONField(name = "n_top_title_eq")
    @ApiModelProperty("顶级工作项标题EQ")
    private String topTitleEQ;

    /**
     * 顶级工作项标题LIKE
     */
    @JsonProperty("n_top_title_like")
    @JSONField(name = "n_top_title_like")
    @ApiModelProperty("顶级工作项标题LIKE")
    private String topTitleLIKE;

    /**
     * 迭代名称EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty("迭代名称EQ")
    private String sprintNameEQ;

    /**
     * 迭代名称LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty("迭代名称LIKE")
    private String sprintNameLIKE;

    /**
     * 项目发布标识EQ
     */
    @JsonProperty("n_release_id_eq")
    @JSONField(name = "n_release_id_eq")
    @ApiModelProperty("项目发布标识EQ")
    private String releaseIdEQ;

    /**
     * 项目发布名称EQ
     */
    @JsonProperty("n_release_name_eq")
    @JSONField(name = "n_release_name_eq")
    @ApiModelProperty("项目发布名称EQ")
    private String releaseNameEQ;

    /**
     * 项目发布名称LIKE
     */
    @JsonProperty("n_release_name_like")
    @JSONField(name = "n_release_name_like")
    @ApiModelProperty("项目发布名称LIKE")
    private String releaseNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.BOARD.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("board_id",contextParentKey);
        if(Entities.ENTRY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("entry_id",contextParentKey);
        if(Entities.PROJECT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("project_id",contextParentKey);
        if(Entities.RELEASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("release_id",contextParentKey);
        if(Entities.SPRINT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("sprint_id",contextParentKey);
        if(Entities.SWIMLANE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("swimlane_id",contextParentKey);
        if(Entities.USER.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("assignee_id",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("pid",contextParentKey);
        if(Entities.WORK_ITEM_STATE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("state",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("top_id",contextParentKey);
        if(Entities.WORK_ITEM_TYPE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("work_item_type_id",contextParentKey);
        if(Entities.COMMON_FLOW.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("identifier",query),QueryFilter.createQuery().like("title",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<WorkItem> getSelectCond() {
        QueryWrapper<WorkItem> queryWrapper = super.getSelectCond();
        if (!ObjectUtils.isEmpty(this.attentionsEXISTSowner_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.OWNER_ID "
                + " = "
                + "'" + this.attentionsEXISTSowner_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsEXISTStypeEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.TYPE "
                + " = "
                + "'" + this.attentionsEXISTStypeEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsEXISTSuser_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.USER_ID "
                + " = "
                + "'" + this.attentionsEXISTSuser_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsNOTEXISTStypeEQ)) {
            queryWrapper.notExists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.TYPE "
                + " = "
                + "'" + this.attentionsNOTEXISTStypeEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsNOTEXISTSuser_idEQ)) {
            queryWrapper.notExists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.USER_ID "
                + " = "
                + "'" + this.attentionsNOTEXISTSuser_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.executorsEXISTSuser_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM EXECUTOR WHERE EXECUTOR. = T1. "
                + " AND EXECUTOR.USER_ID "
                + " = "
                + "'" + this.executorsEXISTSuser_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.idEXISTSidEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .ID "
                + " = "
                + "'" + this.idEXISTSidEQ + "'"
            );
        }
        return queryWrapper;
    }
}