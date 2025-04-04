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
 * 需求过滤[IdeaFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("需求过滤DTO")
public class IdeaFilterDTO extends FilterBase implements Serializable {

    /**
     * 编号EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty(value = "编号EQ", position = 0)
	private String identifierEQ;

    /**
     * 编号ISNULL
     */
    @JsonProperty("n_identifier_isnull")
    @JSONField(name = "n_identifier_isnull")
    @ApiModelProperty(value = "编号ISNULL", position = 1)
	private String identifierISNULL;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 2)
	private String identifierLIKE;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty(value = "标题LIKE", position = 10)
	private String titleLIKE;

    /**
     * 状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "状态EQ", position = 20)
	private String stateEQ;

    /**
     * 状态NOTIN
     */
    @JsonProperty("n_state_notin")
    @JSONField(name = "n_state_notin")
    @ApiModelProperty(value = "状态NOTIN", position = 21)
	private String stateNOTIN;

    /**
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty(value = "优先级EQ", position = 30)
	private String priorityEQ;

    /**
     * 模块EQ
     */
    @JsonProperty("n_suite_eq")
    @JSONField(name = "n_suite_eq")
    @ApiModelProperty(value = "模块EQ", position = 40)
	private String suiteEQ;

    /**
     * 计划开始时间GTANDEQ
     */
    @JsonProperty("n_plan_at_from_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_plan_at_from_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划开始时间GTANDEQ", position = 60)
	private Date planAtFromGTANDEQ;

    /**
     * 计划结束时间LT
     */
    @JsonProperty("n_plan_at_to_lt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_plan_at_to_lt" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划结束时间LT", position = 70)
	private Date planAtToLT;

    /**
     * 计划时间周期单位EQ
     */
    @JsonProperty("n_plan_at_granularity_eq")
    @JSONField(name = "n_plan_at_granularity_eq")
    @ApiModelProperty(value = "计划时间周期单位EQ", position = 80)
	private String planAtGranularityEQ;

    /**
     * 计划时间周期单位EQ
     */
    @JsonProperty("n_real_at_granularity_eq")
    @JSONField(name = "n_real_at_granularity_eq")
    @ApiModelProperty(value = "计划时间周期单位EQ", position = 120)
	private String realAtGranularityEQ;

    /**
     * 描述LIKE
     */
    @JsonProperty("n_description_like")
    @JSONField(name = "n_description_like")
    @ApiModelProperty(value = "描述LIKE", position = 140)
	private String descriptionLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty(value = "是否已归档EQ", position = 150)
	private Integer isArchivedEQ;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty(value = "是否已删除EQ", position = 160)
	private Integer isDeletedEQ;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_name_eq")
    @JSONField(name = "n_assignee_name_eq")
    @ApiModelProperty(value = "负责人EQ", position = 180)
	private String assigneeNameEQ;

    /**
     * 负责人LIKE
     */
    @JsonProperty("n_assignee_name_like")
    @JSONField(name = "n_assignee_name_like")
    @ApiModelProperty(value = "负责人LIKE", position = 181)
	private String assigneeNameLIKE;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty(value = "负责人EQ", position = 190)
	private String assigneeIdEQ;

    /**
     * 负责人IN
     */
    @JsonProperty("n_assignee_id_in")
    @JSONField(name = "n_assignee_id_in")
    @ApiModelProperty(value = "负责人IN", position = 191)
	private String assigneeIdIN;

    /**
     * 负责人ISNOTNULL
     */
    @JsonProperty("n_assignee_id_isnotnull")
    @JSONField(name = "n_assignee_id_isnotnull")
    @ApiModelProperty(value = "负责人ISNOTNULL", position = 192)
	private String assigneeIdISNOTNULL;

    /**
     * 负责人ISNULL
     */
    @JsonProperty("n_assignee_id_isnull")
    @JSONField(name = "n_assignee_id_isnull")
    @ApiModelProperty(value = "负责人ISNULL", position = 193)
	private String assigneeIdISNULL;

    /**
     * 负责人NOTEQ
     */
    @JsonProperty("n_assignee_id_noteq")
    @JSONField(name = "n_assignee_id_noteq")
    @ApiModelProperty(value = "负责人NOTEQ", position = 194)
	private String assigneeIdNOTEQ;

    /**
     * 负责人NOTIN
     */
    @JsonProperty("n_assignee_id_notin")
    @JSONField(name = "n_assignee_id_notin")
    @ApiModelProperty(value = "负责人NOTIN", position = 195)
	private String assigneeIdNOTIN;

    /**
     * 子产品标识EQ
     */
    @JsonProperty("n_section_id_eq")
    @JSONField(name = "n_section_id_eq")
    @ApiModelProperty(value = "子产品标识EQ", position = 230)
	private String sectionIdEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty(value = "关注EXISTS关注人EQ", position = 240)
	private String attentionsEXISTSuser_idEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 250)
	private String showIdentifierLIKE;

    /**
     * 类别路径LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty(value = "类别路径LIKE", position = 260)
	private String categoriesLIKE;

    /**
     * 需求来源EQ
     */
    @JsonProperty("n_idea_from_eq")
    @JSONField(name = "n_idea_from_eq")
    @ApiModelProperty(value = "需求来源EQ", position = 270)
	private String ideaFromEQ;

    /**
     * 需求类型EQ
     */
    @JsonProperty("n_idea_type_eq")
    @JSONField(name = "n_idea_type_eq")
    @ApiModelProperty(value = "需求类型EQ", position = 280)
	private String ideaTypeEQ;

    /**
     * 最近创建日期LTANDEQ
     */
    @JsonProperty("n_recent_create_days_ltandeq")
    @JSONField(name = "n_recent_create_days_ltandeq")
    @ApiModelProperty(value = "最近创建日期LTANDEQ", position = 460)
	private Integer recentCreateDaysLTANDEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty(value = "标识IN", position = 480)
	private String idIN;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 481)
	private String idNOTEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 482)
	private String idEQ;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 490)
	private String createManEQ;

    /**
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty(value = "建立人IN", position = 491)
	private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty(value = "建立人ISNOTNULL", position = 492)
	private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty(value = "建立人ISNULL", position = 493)
	private String createManISNULL;

    /**
     * 建立人NOTEQ
     */
    @JsonProperty("n_create_man_noteq")
    @JSONField(name = "n_create_man_noteq")
    @ApiModelProperty(value = "建立人NOTEQ", position = 494)
	private String createManNOTEQ;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty(value = "建立人NOTIN", position = 495)
	private String createManNOTIN;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间EQ", position = 500)
	private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 501)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 502)
	private Date createTimeLTANDEQ;

    /**
     * 更新时间GTANDEQ
     */
    @JsonProperty("n_update_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间GTANDEQ", position = 520)
	private Date updateTimeGTANDEQ;

    /**
     * 更新时间LTANDEQ
     */
    @JsonProperty("n_update_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间LTANDEQ", position = 521)
	private Date updateTimeLTANDEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 530)
	private String nameLIKE;

    /**
     * 产品EQ
     */
    @JsonProperty("n_product_id_eq")
    @JSONField(name = "n_product_id_eq")
    @ApiModelProperty(value = "产品EQ", position = 540)
	private String productIdEQ;

    /**
     * 产品ISNULL
     */
    @JsonProperty("n_product_id_isnull")
    @JSONField(name = "n_product_id_isnull")
    @ApiModelProperty(value = "产品ISNULL", position = 541)
	private String productIdISNULL;

    /**
     * 所属产品EQ
     */
    @JsonProperty("n_product_name_eq")
    @JSONField(name = "n_product_name_eq")
    @ApiModelProperty(value = "所属产品EQ", position = 550)
	private String productNameEQ;

    /**
     * 所属产品LIKE
     */
    @JsonProperty("n_product_name_like")
    @JSONField(name = "n_product_name_like")
    @ApiModelProperty(value = "所属产品LIKE", position = 551)
	private String productNameLIKE;

    /**
     * 类别标识EQ
     */
    @JsonProperty("n_category_id_eq")
    @JSONField(name = "n_category_id_eq")
    @ApiModelProperty(value = "类别标识EQ", position = 560)
	private String categoryIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_category_name_eq")
    @JSONField(name = "n_category_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 570)
	private String categoryNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_category_name_like")
    @JSONField(name = "n_category_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 571)
	private String categoryNameLIKE;


}