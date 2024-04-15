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
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 0)
	private String identifierLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty(value = "是否已归档EQ", position = 10)
	private Integer isArchivedEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty(value = "标题LIKE", position = 20)
	private String titleLIKE;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty(value = "是否已删除EQ", position = 30)
	private Integer isDeletedEQ;

    /**
     * 状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "状态EQ", position = 60)
	private String stateEQ;

    /**
     * 状态NOTEQ
     */
    @JsonProperty("n_state_noteq")
    @JSONField(name = "n_state_noteq")
    @ApiModelProperty(value = "状态NOTEQ", position = 61)
	private String stateNOTEQ;

    /**
     * 状态NOTIN
     */
    @JsonProperty("n_state_notin")
    @JSONField(name = "n_state_notin")
    @ApiModelProperty(value = "状态NOTIN", position = 62)
	private String stateNOTIN;

    /**
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty(value = "优先级EQ", position = 70)
	private String priorityEQ;

    /**
     * 需求类型EQ
     */
    @JsonProperty("n_backlog_type_eq")
    @JSONField(name = "n_backlog_type_eq")
    @ApiModelProperty(value = "需求类型EQ", position = 90)
	private String backlogTypeEQ;

    /**
     * 需求来源EQ
     */
    @JsonProperty("n_backlog_from_eq")
    @JSONField(name = "n_backlog_from_eq")
    @ApiModelProperty(value = "需求来源EQ", position = 100)
	private String backlogFromEQ;

    /**
     * 描述LIKE
     */
    @JsonProperty("n_description_like")
    @JSONField(name = "n_description_like")
    @ApiModelProperty(value = "描述LIKE", position = 110)
	private String descriptionLIKE;

    /**
     * 复现概率EQ
     */
    @JsonProperty("n_reappear_probability_eq")
    @JSONField(name = "n_reappear_probability_eq")
    @ApiModelProperty(value = "复现概率EQ", position = 130)
	private String reappearProbabilityEQ;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty(value = "负责人EQ", position = 140)
	private String assigneeIdEQ;

    /**
     * 严重程度EQ
     */
    @JsonProperty("n_severity_eq")
    @JSONField(name = "n_severity_eq")
    @ApiModelProperty(value = "严重程度EQ", position = 160)
	private String severityEQ;

    /**
     * 风险EQ
     */
    @JsonProperty("n_risk_eq")
    @JSONField(name = "n_risk_eq")
    @ApiModelProperty(value = "风险EQ", position = 170)
	private String riskEQ;

    /**
     * 工作项类型分组EQ
     */
    @JsonProperty("n_work_item_type_group_eq")
    @JSONField(name = "n_work_item_type_group_eq")
    @ApiModelProperty(value = "工作项类型分组EQ", position = 190)
	private String workItemTypeGroupEQ;

    /**
     * 任务类别EQ
     */
    @JsonProperty("n_job_type_eq")
    @JSONField(name = "n_job_type_eq")
    @ApiModelProperty(value = "任务类别EQ", position = 280)
	private String jobTypeEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 340)
	private String showIdentifierLIKE;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_owner_id_eq")
    @JSONField(name = "n_attentions_exists__n_owner_id_eq")
    @ApiModelProperty(value = "关注EXISTS所属数据标识EQ", position = 360)
	private String attentionsEXISTSowner_idEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_type_eq")
    @JSONField(name = "n_attentions_exists__n_type_eq")
    @ApiModelProperty(value = "关注EXISTS关注类型EQ", position = 361)
	private String attentionsEXISTStypeEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty(value = "关注EXISTS关注人EQ", position = 362)
	private String attentionsEXISTSuser_idEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_type_eq")
    @JSONField(name = "n_attentions_notexists__n_type_eq")
    @ApiModelProperty(value = "关注NOTEXISTS关注类型EQ", position = 363)
	private String attentionsNOTEXISTStypeEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_user_id_eq")
    @JSONField(name = "n_attentions_notexists__n_user_id_eq")
    @ApiModelProperty(value = "关注NOTEXISTS关注人EQ", position = 364)
	private String attentionsNOTEXISTSuser_idEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 430)
	private String idEQ;

    /**
     * 标识EXISTS
     */
    @JsonProperty("n_id_exists__n_id_eq")
    @JSONField(name = "n_id_exists__n_id_eq")
    @ApiModelProperty(value = "标识EXISTS标识EQ", position = 431)
	private String idEXISTSidEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty(value = "标识IN", position = 432)
	private String idIN;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 433)
	private String idNOTEQ;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间EQ", position = 440)
	private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 441)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 442)
	private Date createTimeLTANDEQ;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 450)
	private String createManEQ;

    /**
     * 项目EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "项目EQ", position = 470)
	private String projectIdEQ;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_id_eq")
    @JSONField(name = "n_work_item_type_id_eq")
    @ApiModelProperty(value = "工作项类型EQ", position = 480)
	private String workItemTypeIdEQ;

    /**
     * 工作项类型IN
     */
    @JsonProperty("n_work_item_type_id_in")
    @JSONField(name = "n_work_item_type_id_in")
    @ApiModelProperty(value = "工作项类型IN", position = 481)
	private String workItemTypeIdIN;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_id_like")
    @JSONField(name = "n_work_item_type_id_like")
    @ApiModelProperty(value = "工作项类型LIKE", position = 482)
	private String workItemTypeIdLIKE;

    /**
     * 所属项目EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty(value = "所属项目EQ", position = 490)
	private String projectNameEQ;

    /**
     * 所属项目LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty(value = "所属项目LIKE", position = 491)
	private String projectNameLIKE;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_name_eq")
    @JSONField(name = "n_work_item_type_name_eq")
    @ApiModelProperty(value = "工作项类型EQ", position = 500)
	private String workItemTypeNameEQ;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_name_like")
    @JSONField(name = "n_work_item_type_name_like")
    @ApiModelProperty(value = "工作项类型LIKE", position = 501)
	private String workItemTypeNameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty(value = "父标识EQ", position = 510)
	private String pidEQ;

    /**
     * 父工作项EQ
     */
    @JsonProperty("n_ptitle_eq")
    @JSONField(name = "n_ptitle_eq")
    @ApiModelProperty(value = "父工作项EQ", position = 520)
	private String ptitleEQ;

    /**
     * 父工作项LIKE
     */
    @JsonProperty("n_ptitle_like")
    @JSONField(name = "n_ptitle_like")
    @ApiModelProperty(value = "父工作项LIKE", position = 521)
	private String ptitleLIKE;

    /**
     * 迭代标识EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty(value = "迭代标识EQ", position = 530)
	private String sprintIdEQ;

    /**
     * 迭代标识ISNULL
     */
    @JsonProperty("n_sprint_id_isnull")
    @JSONField(name = "n_sprint_id_isnull")
    @ApiModelProperty(value = "迭代标识ISNULL", position = 531)
	private String sprintIdISNULL;

    /**
     * 看板标识EQ
     */
    @JsonProperty("n_board_id_eq")
    @JSONField(name = "n_board_id_eq")
    @ApiModelProperty(value = "看板标识EQ", position = 540)
	private String boardIdEQ;

    /**
     * 看板栏标识EQ
     */
    @JsonProperty("n_entry_id_eq")
    @JSONField(name = "n_entry_id_eq")
    @ApiModelProperty(value = "看板栏标识EQ", position = 550)
	private String entryIdEQ;

    /**
     * 泳道标识EQ
     */
    @JsonProperty("n_swimlane_id_eq")
    @JSONField(name = "n_swimlane_id_eq")
    @ApiModelProperty(value = "泳道标识EQ", position = 560)
	private String swimlaneIdEQ;

    /**
     * 看板栏名称EQ
     */
    @JsonProperty("n_entry_name_eq")
    @JSONField(name = "n_entry_name_eq")
    @ApiModelProperty(value = "看板栏名称EQ", position = 570)
	private String entryNameEQ;

    /**
     * 看板栏名称LIKE
     */
    @JsonProperty("n_entry_name_like")
    @JSONField(name = "n_entry_name_like")
    @ApiModelProperty(value = "看板栏名称LIKE", position = 571)
	private String entryNameLIKE;

    /**
     * 看板名称EQ
     */
    @JsonProperty("n_board_name_eq")
    @JSONField(name = "n_board_name_eq")
    @ApiModelProperty(value = "看板名称EQ", position = 580)
	private String boardNameEQ;

    /**
     * 看板名称LIKE
     */
    @JsonProperty("n_board_name_like")
    @JSONField(name = "n_board_name_like")
    @ApiModelProperty(value = "看板名称LIKE", position = 581)
	private String boardNameLIKE;

    /**
     * 顶级工作项标识EQ
     */
    @JsonProperty("n_top_id_eq")
    @JSONField(name = "n_top_id_eq")
    @ApiModelProperty(value = "顶级工作项标识EQ", position = 590)
	private String topIdEQ;

    /**
     * 顶级工作项标识IN
     */
    @JsonProperty("n_top_id_in")
    @JSONField(name = "n_top_id_in")
    @ApiModelProperty(value = "顶级工作项标识IN", position = 591)
	private String topIdIN;

    /**
     * 顶级工作项标题EQ
     */
    @JsonProperty("n_top_title_eq")
    @JSONField(name = "n_top_title_eq")
    @ApiModelProperty(value = "顶级工作项标题EQ", position = 600)
	private String topTitleEQ;

    /**
     * 顶级工作项标题LIKE
     */
    @JsonProperty("n_top_title_like")
    @JSONField(name = "n_top_title_like")
    @ApiModelProperty(value = "顶级工作项标题LIKE", position = 601)
	private String topTitleLIKE;

    /**
     * 迭代名称EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty(value = "迭代名称EQ", position = 610)
	private String sprintNameEQ;

    /**
     * 迭代名称LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty(value = "迭代名称LIKE", position = 611)
	private String sprintNameLIKE;

    /**
     * 项目发布标识EQ
     */
    @JsonProperty("n_release_id_eq")
    @JSONField(name = "n_release_id_eq")
    @ApiModelProperty(value = "项目发布标识EQ", position = 620)
	private String releaseIdEQ;


}