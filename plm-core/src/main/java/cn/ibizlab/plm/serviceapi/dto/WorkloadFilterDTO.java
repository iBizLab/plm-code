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
 * 工时过滤[WorkloadFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工时过滤DTO")
public class WorkloadFilterDTO extends FilterBase implements Serializable {

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 0)
	private String identifierLIKE;

    /**
     * 工时主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty(value = "工时主体标识EQ", position = 10)
	private String principalIdEQ;

    /**
     * 工作日期GTANDEQ
     */
    @JsonProperty("n_register_date_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_register_date_gtandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "工作日期GTANDEQ", position = 60)
	private Date registerDateGTANDEQ;

    /**
     * 工作日期IN
     */
    @JsonProperty("n_register_date_in")
    @JSONField(name = "n_register_date_in")
    @ApiModelProperty(value = "工作日期IN", position = 61)
	private String registerDateIN;

    /**
     * 工作日期LTANDEQ
     */
    @JsonProperty("n_register_date_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_register_date_ltandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "工作日期LTANDEQ", position = 62)
	private Date registerDateLTANDEQ;

    /**
     * 访问父类EQ
     */
    @JsonProperty("n_recent_parent_eq")
    @JSONField(name = "n_recent_parent_eq")
    @ApiModelProperty(value = "访问父类EQ", position = 80)
	private String recentParentEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_assignee_id_eq")
    @JSONField(name = "n_work_item_exists__n_assignee_id_eq")
    @ApiModelProperty(value = "工作项EXISTS负责人EQ", position = 110)
	private String workItemEXISTSAssignee_idEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_create_man_eq")
    @JSONField(name = "n_work_item_exists__n_create_man_eq")
    @ApiModelProperty(value = "工作项EXISTS建立人EQ", position = 111)
	private String workItemEXISTSCreate_manEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_description_like")
    @JSONField(name = "n_work_item_exists__n_description_like")
    @ApiModelProperty(value = "工作项EXISTS描述LIKE", position = 112)
	private String workItemEXISTSDescriptionLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_is_archived_eq")
    @JSONField(name = "n_work_item_exists__n_is_archived_eq")
    @ApiModelProperty(value = "工作项EXISTS是否已归档EQ", position = 113)
	private String workItemEXISTSIs_archivedEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_priority_eq")
    @JSONField(name = "n_work_item_exists__n_priority_eq")
    @ApiModelProperty(value = "工作项EXISTS优先级EQ", position = 114)
	private String workItemEXISTSPriorityEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_project_id_eq")
    @JSONField(name = "n_work_item_exists__n_project_id_eq")
    @ApiModelProperty(value = "工作项EXISTS项目EQ", position = 115)
	private String workItemEXISTSProject_idEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_risk_eq")
    @JSONField(name = "n_work_item_exists__n_risk_eq")
    @ApiModelProperty(value = "工作项EXISTS风险EQ", position = 116)
	private String workItemEXISTSRiskEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_state_eq")
    @JSONField(name = "n_work_item_exists__n_state_eq")
    @ApiModelProperty(value = "工作项EXISTS状态EQ", position = 117)
	private String workItemEXISTSStateEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_title_like")
    @JSONField(name = "n_work_item_exists__n_title_like")
    @ApiModelProperty(value = "工作项EXISTS标题LIKE", position = 118)
	private String workItemEXISTSTitleLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_work_item_type_id_eq")
    @JSONField(name = "n_work_item_exists__n_work_item_type_id_eq")
    @ApiModelProperty(value = "工作项EXISTS工作项类型EQ", position = 119)
	private String workItemEXISTSWork_item_type_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_assignee_id_eq")
    @JSONField(name = "n_idea_exists__n_assignee_id_eq")
    @ApiModelProperty(value = "需求EXISTS负责人EQ", position = 120)
	private String ideaEXISTSAssignee_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_create_man_eq")
    @JSONField(name = "n_idea_exists__n_create_man_eq")
    @ApiModelProperty(value = "需求EXISTS建立人EQ", position = 121)
	private String ideaEXISTSCreate_manEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_description_like")
    @JSONField(name = "n_idea_exists__n_description_like")
    @ApiModelProperty(value = "需求EXISTS描述LIKE", position = 122)
	private String ideaEXISTSDescriptionLIKE;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_identifier_like")
    @JSONField(name = "n_idea_exists__n_identifier_like")
    @ApiModelProperty(value = "需求EXISTS编号LIKE", position = 123)
	private String ideaEXISTSIdentifierLIKE;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_is_archived_eq")
    @JSONField(name = "n_idea_exists__n_is_archived_eq")
    @ApiModelProperty(value = "需求EXISTS是否已归档EQ", position = 124)
	private String ideaEXISTSIs_archivedEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_priority_eq")
    @JSONField(name = "n_idea_exists__n_priority_eq")
    @ApiModelProperty(value = "需求EXISTS优先级EQ", position = 125)
	private String ideaEXISTSPriorityEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_product_id_eq")
    @JSONField(name = "n_idea_exists__n_product_id_eq")
    @ApiModelProperty(value = "需求EXISTS产品EQ", position = 126)
	private String ideaEXISTSProduct_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_state_eq")
    @JSONField(name = "n_idea_exists__n_state_eq")
    @ApiModelProperty(value = "需求EXISTS状态EQ", position = 127)
	private String ideaEXISTSStateEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_title_like")
    @JSONField(name = "n_idea_exists__n_title_like")
    @ApiModelProperty(value = "需求EXISTS标题LIKE", position = 128)
	private String ideaEXISTSTitleLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_create_man_eq")
    @JSONField(name = "n_test_case_exists__n_create_man_eq")
    @ApiModelProperty(value = "用例EXISTS建立人EQ", position = 130)
	private String testCaseEXISTSCreate_manEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_description_like")
    @JSONField(name = "n_test_case_exists__n_description_like")
    @ApiModelProperty(value = "用例EXISTS描述LIKE", position = 131)
	private String testCaseEXISTSDescriptionLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_identifier_eq")
    @JSONField(name = "n_test_case_exists__n_identifier_eq")
    @ApiModelProperty(value = "用例EXISTS编号EQ", position = 132)
	private String testCaseEXISTSIdentifierEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_is_archived_eq")
    @JSONField(name = "n_test_case_exists__n_is_archived_eq")
    @ApiModelProperty(value = "用例EXISTS是否已归档EQ", position = 133)
	private String testCaseEXISTSIs_archivedEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_level_eq")
    @JSONField(name = "n_test_case_exists__n_level_eq")
    @ApiModelProperty(value = "用例EXISTS重要程度EQ", position = 134)
	private String testCaseEXISTSLevelEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_maintenance_id_eq")
    @JSONField(name = "n_test_case_exists__n_maintenance_id_eq")
    @ApiModelProperty(value = "用例EXISTS维护人EQ", position = 135)
	private String testCaseEXISTSMaintenance_idEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_state_eq")
    @JSONField(name = "n_test_case_exists__n_state_eq")
    @ApiModelProperty(value = "用例EXISTS评审状态EQ", position = 136)
	private String testCaseEXISTSStateEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_title_like")
    @JSONField(name = "n_test_case_exists__n_title_like")
    @ApiModelProperty(value = "用例EXISTS标题LIKE", position = 137)
	private String testCaseEXISTSTitleLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_type_eq")
    @JSONField(name = "n_test_case_exists__n_type_eq")
    @ApiModelProperty(value = "用例EXISTS用例类型EQ", position = 138)
	private String testCaseEXISTSTypeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 140)
	private String idEQ;

    /**
     * 事项LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "事项LIKE", position = 150)
	private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 170)
	private String createManEQ;

    /**
     * 类别EQ
     */
    @JsonProperty("n_type_id_eq")
    @JSONField(name = "n_type_id_eq")
    @ApiModelProperty(value = "类别EQ", position = 200)
	private String typeIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_type_name_eq")
    @JSONField(name = "n_type_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 210)
	private String typeNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_type_name_like")
    @JSONField(name = "n_type_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 211)
	private String typeNameLIKE;


}