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
 * 用例过滤[TestCaseFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例过滤DTO")
public class TestCaseFilterDTO extends FilterBase implements Serializable {

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
     * 重要程度EQ
     */
    @JsonProperty("n_level_eq")
    @JSONField(name = "n_level_eq")
    @ApiModelProperty(value = "重要程度EQ", position = 20)
	private String levelEQ;

    /**
     * 用例类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "用例类型EQ", position = 30)
	private String typeEQ;

    /**
     * 测试类型EQ
     */
    @JsonProperty("n_test_type_eq")
    @JSONField(name = "n_test_type_eq")
    @ApiModelProperty(value = "测试类型EQ", position = 40)
	private String testTypeEQ;

    /**
     * 描述LIKE
     */
    @JsonProperty("n_description_like")
    @JSONField(name = "n_description_like")
    @ApiModelProperty(value = "描述LIKE", position = 50)
	private String descriptionLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty(value = "是否已归档EQ", position = 70)
	private Integer isArchivedEQ;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty(value = "是否已删除EQ", position = 80)
	private Integer isDeletedEQ;

    /**
     * 评审状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "评审状态EQ", position = 90)
	private String stateEQ;

    /**
     * 评审状态NOTIN
     */
    @JsonProperty("n_state_notin")
    @JSONField(name = "n_state_notin")
    @ApiModelProperty(value = "评审状态NOTIN", position = 91)
	private String stateNOTIN;

    /**
     * 维护人EQ
     */
    @JsonProperty("n_maintenance_id_eq")
    @JSONField(name = "n_maintenance_id_eq")
    @ApiModelProperty(value = "维护人EQ", position = 110)
	private String maintenanceIdEQ;

    /**
     * 维护人EQ
     */
    @JsonProperty("n_maintenance_name_eq")
    @JSONField(name = "n_maintenance_name_eq")
    @ApiModelProperty(value = "维护人EQ", position = 120)
	private String maintenanceNameEQ;

    /**
     * 测试计划名称EQ
     */
    @JsonProperty("n_test_plan_name_eq")
    @JSONField(name = "n_test_plan_name_eq")
    @ApiModelProperty(value = "测试计划名称EQ", position = 130)
	private String testPlanNameEQ;

    /**
     * 执行人EQ
     */
    @JsonProperty("n_executor_name_eq")
    @JSONField(name = "n_executor_name_eq")
    @ApiModelProperty(value = "执行人EQ", position = 150)
	private String executorNameEQ;

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_run_status_eq")
    @JSONField(name = "n_run_status_eq")
    @ApiModelProperty(value = "执行结果EQ", position = 160)
	private String runStatusEQ;

    /**
     * 模块路径LIKE
     */
    @JsonProperty("n_suites_like")
    @JSONField(name = "n_suites_like")
    @ApiModelProperty(value = "模块路径LIKE", position = 180)
	private String suitesLIKE;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 200)
	private String showIdentifierLIKE;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 270)
	private String idNOTEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 271)
	private String idEQ;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间EQ", position = 280)
	private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 281)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 282)
	private Date createTimeLTANDEQ;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 290)
	private String createManEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 300)
	private String nameLIKE;

    /**
     * 测试库EQ
     */
    @JsonProperty("n_test_library_id_eq")
    @JSONField(name = "n_test_library_id_eq")
    @ApiModelProperty(value = "测试库EQ", position = 330)
	private String testLibraryIdEQ;

    /**
     * 测试库ISNULL
     */
    @JsonProperty("n_test_library_id_isnull")
    @JSONField(name = "n_test_library_id_isnull")
    @ApiModelProperty(value = "测试库ISNULL", position = 331)
	private String testLibraryIdISNULL;

    /**
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty(value = "用例模块标识EQ", position = 340)
	private String suiteIdEQ;

    /**
     * 用例模块标识ISNULL
     */
    @JsonProperty("n_suite_id_isnull")
    @JSONField(name = "n_suite_id_isnull")
    @ApiModelProperty(value = "用例模块标识ISNULL", position = 341)
	private String suiteIdISNULL;

    /**
     * 所属模块EQ
     */
    @JsonProperty("n_suite_name_eq")
    @JSONField(name = "n_suite_name_eq")
    @ApiModelProperty(value = "所属模块EQ", position = 350)
	private String suiteNameEQ;

    /**
     * 所属模块LIKE
     */
    @JsonProperty("n_suite_name_like")
    @JSONField(name = "n_suite_name_like")
    @ApiModelProperty(value = "所属模块LIKE", position = 351)
	private String suiteNameLIKE;

    /**
     * 所属测试库EQ
     */
    @JsonProperty("n_test_library_name_eq")
    @JSONField(name = "n_test_library_name_eq")
    @ApiModelProperty(value = "所属测试库EQ", position = 360)
	private String testLibraryNameEQ;

    /**
     * 所属测试库LIKE
     */
    @JsonProperty("n_test_library_name_like")
    @JSONField(name = "n_test_library_name_like")
    @ApiModelProperty(value = "所属测试库LIKE", position = 361)
	private String testLibraryNameLIKE;


}