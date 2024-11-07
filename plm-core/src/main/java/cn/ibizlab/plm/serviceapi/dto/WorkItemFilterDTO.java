/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFILTER}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.filter.FilterBase;

import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 工作项过滤[WorkItemFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项过滤DTO")
public class WorkItemFilterDTO extends FilterBase implements Serializable {

    /**
     * 编号EQ
     */
    @JsonProperty("n_show_identifier_eq")
    @JSONField(name = "n_show_identifier_eq")
    @ApiModelProperty(value = "编号EQ", position = 0)
	private String showIdentifierEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 1)
	private String showIdentifierLIKE;

    /**
     * 编号EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty(value = "编号EQ", position = 10)
	private String identifierEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 11)
	private String identifierLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty(value = "是否已归档EQ", position = 20)
	private Integer isArchivedEQ;

    /**
     * 是否已归档IN
     */
    @JsonProperty("n_is_archived_in")
    @JSONField(name = "n_is_archived_in")
    @ApiModelProperty(value = "是否已归档IN", position = 21)
	private String isArchivedIN;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty(value = "标题LIKE", position = 30)
	private String titleLIKE;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty(value = "是否已删除EQ", position = 40)
	private Integer isDeletedEQ;

    /**
     * 是否已删除IN
     */
    @JsonProperty("n_is_deleted_in")
    @JSONField(name = "n_is_deleted_in")
    @ApiModelProperty(value = "是否已删除IN", position = 41)
	private String isDeletedIN;

    /**
     * 开始时间GTANDEQ
     */
    @JsonProperty("n_start_at_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_start_at_gtandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间GTANDEQ", position = 50)
	private Date startAtGTANDEQ;

    /**
     * 开始时间LT
     */
    @JsonProperty("n_start_at_lt")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_start_at_lt" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间LT", position = 51)
	private Date startAtLT;

    /**
     * 开始时间LTANDEQ
     */
    @JsonProperty("n_start_at_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_start_at_ltandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间LTANDEQ", position = 52)
	private Date startAtLTANDEQ;

    /**
     * 截止时间GTANDEQ
     */
    @JsonProperty("n_end_at_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_end_at_gtandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "截止时间GTANDEQ", position = 61)
	private Date endAtGTANDEQ;

    /**
     * 截止时间LTANDEQ
     */
    @JsonProperty("n_end_at_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_end_at_ltandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "截止时间LTANDEQ", position = 62)
	private Date endAtLTANDEQ;

    /**
     * 状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "状态EQ", position = 70)
	private String stateEQ;

    /**
     * 状态NOTEQ
     */
    @JsonProperty("n_state_noteq")
    @JSONField(name = "n_state_noteq")
    @ApiModelProperty(value = "状态NOTEQ", position = 71)
	private String stateNOTEQ;

    /**
     * 状态NOTIN
     */
    @JsonProperty("n_state_notin")
    @JSONField(name = "n_state_notin")
    @ApiModelProperty(value = "状态NOTIN", position = 72)
	private String stateNOTIN;

    /**
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty(value = "优先级EQ", position = 80)
	private String priorityEQ;

    /**
     * 需求类型EQ
     */
    @JsonProperty("n_backlog_type_eq")
    @JSONField(name = "n_backlog_type_eq")
    @ApiModelProperty(value = "需求类型EQ", position = 100)
	private String backlogTypeEQ;

    /**
     * 需求来源EQ
     */
    @JsonProperty("n_backlog_from_eq")
    @JSONField(name = "n_backlog_from_eq")
    @ApiModelProperty(value = "需求来源EQ", position = 110)
	private String backlogFromEQ;

    /**
     * 描述LIKE
     */
    @JsonProperty("n_description_like")
    @JSONField(name = "n_description_like")
    @ApiModelProperty(value = "描述LIKE", position = 120)
	private String descriptionLIKE;

    /**
     * 复现概率EQ
     */
    @JsonProperty("n_reappear_probability_eq")
    @JSONField(name = "n_reappear_probability_eq")
    @ApiModelProperty(value = "复现概率EQ", position = 140)
	private String reappearProbabilityEQ;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty(value = "负责人EQ", position = 150)
	private String assigneeIdEQ;

    /**
     * 负责人IN
     */
    @JsonProperty("n_assignee_id_in")
    @JSONField(name = "n_assignee_id_in")
    @ApiModelProperty(value = "负责人IN", position = 151)
	private String assigneeIdIN;

    /**
     * 负责人ISNOTNULL
     */
    @JsonProperty("n_assignee_id_isnotnull")
    @JSONField(name = "n_assignee_id_isnotnull")
    @ApiModelProperty(value = "负责人ISNOTNULL", position = 152)
	private String assigneeIdISNOTNULL;

    /**
     * 负责人ISNULL
     */
    @JsonProperty("n_assignee_id_isnull")
    @JSONField(name = "n_assignee_id_isnull")
    @ApiModelProperty(value = "负责人ISNULL", position = 153)
	private String assigneeIdISNULL;

    /**
     * 负责人NOTEQ
     */
    @JsonProperty("n_assignee_id_noteq")
    @JSONField(name = "n_assignee_id_noteq")
    @ApiModelProperty(value = "负责人NOTEQ", position = 154)
	private String assigneeIdNOTEQ;

    /**
     * 负责人NOTIN
     */
    @JsonProperty("n_assignee_id_notin")
    @JSONField(name = "n_assignee_id_notin")
    @ApiModelProperty(value = "负责人NOTIN", position = 155)
	private String assigneeIdNOTIN;

    /**
     * 严重程度EQ
     */
    @JsonProperty("n_severity_eq")
    @JSONField(name = "n_severity_eq")
    @ApiModelProperty(value = "严重程度EQ", position = 170)
	private String severityEQ;

    /**
     * 风险EQ
     */
    @JsonProperty("n_risk_eq")
    @JSONField(name = "n_risk_eq")
    @ApiModelProperty(value = "风险EQ", position = 180)
	private String riskEQ;

    /**
     * 工作项类型分组EQ
     */
    @JsonProperty("n_work_item_type_group_eq")
    @JSONField(name = "n_work_item_type_group_eq")
    @ApiModelProperty(value = "工作项类型分组EQ", position = 200)
	private String workItemTypeGroupEQ;

    /**
     * 标签LIKE
     */
    @JsonProperty("n_tags_like")
    @JSONField(name = "n_tags_like")
    @ApiModelProperty(value = "标签LIKE", position = 210)
	private String tagsLIKE;

    /**
     * 任务类别EQ
     */
    @JsonProperty("n_job_type_eq")
    @JSONField(name = "n_job_type_eq")
    @ApiModelProperty(value = "任务类别EQ", position = 300)
	private String jobTypeEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_owner_id_eq")
    @JSONField(name = "n_attentions_exists__n_owner_id_eq")
    @ApiModelProperty(value = "关注EXISTS所属数据标识EQ", position = 400)
	private String attentionsEXISTSowner_idEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_type_eq")
    @JSONField(name = "n_attentions_exists__n_type_eq")
    @ApiModelProperty(value = "关注EXISTS关注类型EQ", position = 401)
	private String attentionsEXISTStypeEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty(value = "关注EXISTS关注人EQ", position = 402)
	private String attentionsEXISTSuser_idEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_type_eq")
    @JSONField(name = "n_attentions_notexists__n_type_eq")
    @ApiModelProperty(value = "关注NOTEXISTS关注类型EQ", position = 403)
	private String attentionsNOTEXISTStypeEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_user_id_eq")
    @JSONField(name = "n_attentions_notexists__n_user_id_eq")
    @ApiModelProperty(value = "关注NOTEXISTS关注人EQ", position = 404)
	private String attentionsNOTEXISTSuser_idEQ;

    /**
     * 工作项状态类型EQ
     */
    @JsonProperty("n_state_type_eq")
    @JSONField(name = "n_state_type_eq")
    @ApiModelProperty(value = "工作项状态类型EQ", position = 460)
	private String stateTypeEQ;

    /**
     * 工作项状态类型NOTEQ
     */
    @JsonProperty("n_state_type_noteq")
    @JSONField(name = "n_state_type_noteq")
    @ApiModelProperty(value = "工作项状态类型NOTEQ", position = 461)
	private String stateTypeNOTEQ;

    /**
     * 最近创建日期LTANDEQ
     */
    @JsonProperty("n_recent_create_days_ltandeq")
    @JSONField(name = "n_recent_create_days_ltandeq")
    @ApiModelProperty(value = "最近创建日期LTANDEQ", position = 550)
	private Integer recentCreateDaysLTANDEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 630)
	private String idEQ;

    /**
     * 标识EXISTS
     */
    @JsonProperty("n_id_exists__n_id_eq")
    @JSONField(name = "n_id_exists__n_id_eq")
    @ApiModelProperty(value = "标识EXISTS标识EQ", position = 631)
	private String idEXISTSidEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty(value = "标识IN", position = 632)
	private String idIN;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 633)
	private String idNOTEQ;

    /**
     * 标识NOTIN
     */
    @JsonProperty("n_id_notin")
    @JSONField(name = "n_id_notin")
    @ApiModelProperty(value = "标识NOTIN", position = 634)
	private String idNOTIN;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 640)
	private String createManEQ;

    /**
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty(value = "建立人IN", position = 641)
	private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty(value = "建立人ISNOTNULL", position = 642)
	private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty(value = "建立人ISNULL", position = 643)
	private String createManISNULL;

    /**
     * 建立人NOTEQ
     */
    @JsonProperty("n_create_man_noteq")
    @JSONField(name = "n_create_man_noteq")
    @ApiModelProperty(value = "建立人NOTEQ", position = 644)
	private String createManNOTEQ;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty(value = "建立人NOTIN", position = 645)
	private String createManNOTIN;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间EQ", position = 650)
	private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 651)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 652)
	private Date createTimeLTANDEQ;

    /**
     * 更新时间GTANDEQ
     */
    @JsonProperty("n_update_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间GTANDEQ", position = 670)
	private Date updateTimeGTANDEQ;

    /**
     * 更新时间LTANDEQ
     */
    @JsonProperty("n_update_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间LTANDEQ", position = 671)
	private Date updateTimeLTANDEQ;

    /**
     * 项目EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "项目EQ", position = 680)
	private String projectIdEQ;

    /**
     * 项目IN
     */
    @JsonProperty("n_project_id_in")
    @JSONField(name = "n_project_id_in")
    @ApiModelProperty(value = "项目IN", position = 681)
	private String projectIdIN;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_id_eq")
    @JSONField(name = "n_work_item_type_id_eq")
    @ApiModelProperty(value = "工作项类型EQ", position = 690)
	private String workItemTypeIdEQ;

    /**
     * 工作项类型IN
     */
    @JsonProperty("n_work_item_type_id_in")
    @JSONField(name = "n_work_item_type_id_in")
    @ApiModelProperty(value = "工作项类型IN", position = 691)
	private String workItemTypeIdIN;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_id_like")
    @JSONField(name = "n_work_item_type_id_like")
    @ApiModelProperty(value = "工作项类型LIKE", position = 692)
	private String workItemTypeIdLIKE;

    /**
     * 所属项目EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty(value = "所属项目EQ", position = 700)
	private String projectNameEQ;

    /**
     * 所属项目LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty(value = "所属项目LIKE", position = 701)
	private String projectNameLIKE;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_name_eq")
    @JSONField(name = "n_work_item_type_name_eq")
    @ApiModelProperty(value = "工作项类型EQ", position = 710)
	private String workItemTypeNameEQ;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_name_like")
    @JSONField(name = "n_work_item_type_name_like")
    @ApiModelProperty(value = "工作项类型LIKE", position = 711)
	private String workItemTypeNameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty(value = "父标识EQ", position = 720)
	private String pidEQ;

    /**
     * 父工作项EQ
     */
    @JsonProperty("n_ptitle_eq")
    @JSONField(name = "n_ptitle_eq")
    @ApiModelProperty(value = "父工作项EQ", position = 730)
	private String ptitleEQ;

    /**
     * 父工作项LIKE
     */
    @JsonProperty("n_ptitle_like")
    @JSONField(name = "n_ptitle_like")
    @ApiModelProperty(value = "父工作项LIKE", position = 731)
	private String ptitleLIKE;

    /**
     * 迭代标识EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty(value = "迭代标识EQ", position = 740)
	private String sprintIdEQ;

    /**
     * 迭代标识ISNULL
     */
    @JsonProperty("n_sprint_id_isnull")
    @JSONField(name = "n_sprint_id_isnull")
    @ApiModelProperty(value = "迭代标识ISNULL", position = 741)
	private String sprintIdISNULL;

    /**
     * 看板标识EQ
     */
    @JsonProperty("n_board_id_eq")
    @JSONField(name = "n_board_id_eq")
    @ApiModelProperty(value = "看板标识EQ", position = 750)
	private String boardIdEQ;

    /**
     * 看板栏标识EQ
     */
    @JsonProperty("n_entry_id_eq")
    @JSONField(name = "n_entry_id_eq")
    @ApiModelProperty(value = "看板栏标识EQ", position = 760)
	private String entryIdEQ;

    /**
     * 泳道标识EQ
     */
    @JsonProperty("n_swimlane_id_eq")
    @JSONField(name = "n_swimlane_id_eq")
    @ApiModelProperty(value = "泳道标识EQ", position = 770)
	private String swimlaneIdEQ;

    /**
     * 看板栏名称EQ
     */
    @JsonProperty("n_entry_name_eq")
    @JSONField(name = "n_entry_name_eq")
    @ApiModelProperty(value = "看板栏名称EQ", position = 780)
	private String entryNameEQ;

    /**
     * 看板栏名称LIKE
     */
    @JsonProperty("n_entry_name_like")
    @JSONField(name = "n_entry_name_like")
    @ApiModelProperty(value = "看板栏名称LIKE", position = 781)
	private String entryNameLIKE;

    /**
     * 看板名称EQ
     */
    @JsonProperty("n_board_name_eq")
    @JSONField(name = "n_board_name_eq")
    @ApiModelProperty(value = "看板名称EQ", position = 790)
	private String boardNameEQ;

    /**
     * 看板名称LIKE
     */
    @JsonProperty("n_board_name_like")
    @JSONField(name = "n_board_name_like")
    @ApiModelProperty(value = "看板名称LIKE", position = 791)
	private String boardNameLIKE;

    /**
     * 顶级工作项标识EQ
     */
    @JsonProperty("n_top_id_eq")
    @JSONField(name = "n_top_id_eq")
    @ApiModelProperty(value = "顶级工作项标识EQ", position = 800)
	private String topIdEQ;

    /**
     * 顶级工作项标识IN
     */
    @JsonProperty("n_top_id_in")
    @JSONField(name = "n_top_id_in")
    @ApiModelProperty(value = "顶级工作项标识IN", position = 801)
	private String topIdIN;

    /**
     * 顶级工作项标题EQ
     */
    @JsonProperty("n_top_title_eq")
    @JSONField(name = "n_top_title_eq")
    @ApiModelProperty(value = "顶级工作项标题EQ", position = 810)
	private String topTitleEQ;

    /**
     * 顶级工作项标题LIKE
     */
    @JsonProperty("n_top_title_like")
    @JSONField(name = "n_top_title_like")
    @ApiModelProperty(value = "顶级工作项标题LIKE", position = 811)
	private String topTitleLIKE;

    /**
     * 迭代名称EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty(value = "迭代名称EQ", position = 820)
	private String sprintNameEQ;

    /**
     * 迭代名称LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty(value = "迭代名称LIKE", position = 821)
	private String sprintNameLIKE;

    /**
     * 项目发布标识EQ
     */
    @JsonProperty("n_release_id_eq")
    @JSONField(name = "n_release_id_eq")
    @ApiModelProperty(value = "项目发布标识EQ", position = 830)
	private String releaseIdEQ;

    /**
     * 项目发布名称EQ
     */
    @JsonProperty("n_release_name_eq")
    @JSONField(name = "n_release_name_eq")
    @ApiModelProperty(value = "项目发布名称EQ", position = 840)
	private String releaseNameEQ;

    /**
     * 项目发布名称LIKE
     */
    @JsonProperty("n_release_name_like")
    @JSONField(name = "n_release_name_like")
    @ApiModelProperty(value = "项目发布名称LIKE", position = 841)
	private String releaseNameLIKE;


}