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
 * 执行用例过滤[RunFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行用例过滤DTO")
public class RunFilterDTO extends FilterBase implements Serializable {

    /**
     * 执行时间EQ
     */
    @JsonProperty("n_executed_at_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间EQ", position = 60)
	private Date executedAtEQ;

    /**
     * 执行时间GTANDEQ
     */
    @JsonProperty("n_executed_at_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间GTANDEQ", position = 61)
	private Date executedAtGTANDEQ;

    /**
     * 执行时间LTANDEQ
     */
    @JsonProperty("n_executed_at_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间LTANDEQ", position = 62)
	private Date executedAtLTANDEQ;

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "执行结果EQ", position = 70)
	private String statusEQ;

    /**
     * 执行结果ISNOTNULL
     */
    @JsonProperty("n_status_isnotnull")
    @JSONField(name = "n_status_isnotnull")
    @ApiModelProperty(value = "执行结果ISNOTNULL", position = 71)
	private String statusISNOTNULL;

    /**
     * 测试计划EQ
     */
    @JsonProperty("n_plan_name_eq")
    @JSONField(name = "n_plan_name_eq")
    @ApiModelProperty(value = "测试计划EQ", position = 100)
	private String planNameEQ;

    /**
     * 测试计划LIKE
     */
    @JsonProperty("n_plan_name_like")
    @JSONField(name = "n_plan_name_like")
    @ApiModelProperty(value = "测试计划LIKE", position = 101)
	private String planNameLIKE;

    /**
     * 执行人标识EQ
     */
    @JsonProperty("n_executor_id_eq")
    @JSONField(name = "n_executor_id_eq")
    @ApiModelProperty(value = "执行人标识EQ", position = 140)
	private String executorIdEQ;

    /**
     * 执行人标识IN
     */
    @JsonProperty("n_executor_id_in")
    @JSONField(name = "n_executor_id_in")
    @ApiModelProperty(value = "执行人标识IN", position = 141)
	private String executorIdIN;

    /**
     * 执行人标识ISNOTNULL
     */
    @JsonProperty("n_executor_id_isnotnull")
    @JSONField(name = "n_executor_id_isnotnull")
    @ApiModelProperty(value = "执行人标识ISNOTNULL", position = 142)
	private String executorIdISNOTNULL;

    /**
     * 执行人标识ISNULL
     */
    @JsonProperty("n_executor_id_isnull")
    @JSONField(name = "n_executor_id_isnull")
    @ApiModelProperty(value = "执行人标识ISNULL", position = 143)
	private String executorIdISNULL;

    /**
     * 执行人标识NOTEQ
     */
    @JsonProperty("n_executor_id_noteq")
    @JSONField(name = "n_executor_id_noteq")
    @ApiModelProperty(value = "执行人标识NOTEQ", position = 144)
	private String executorIdNOTEQ;

    /**
     * 执行人标识NOTIN
     */
    @JsonProperty("n_executor_id_notin")
    @JSONField(name = "n_executor_id_notin")
    @ApiModelProperty(value = "执行人标识NOTIN", position = 145)
	private String executorIdNOTIN;

    /**
     * 执行人EQ
     */
    @JsonProperty("n_executor_name_eq")
    @JSONField(name = "n_executor_name_eq")
    @ApiModelProperty(value = "执行人EQ", position = 150)
	private String executorNameEQ;

    /**
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty(value = "用例模块标识EQ", position = 160)
	private String suiteIdEQ;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty(value = "测试库标识EQ", position = 210)
	private String libraryIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 290)
	private String idEQ;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 300)
	private String createManEQ;

    /**
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty(value = "建立人IN", position = 301)
	private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty(value = "建立人ISNOTNULL", position = 302)
	private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty(value = "建立人ISNULL", position = 303)
	private String createManISNULL;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty(value = "建立人NOTIN", position = 304)
	private String createManNOTIN;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 310)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 311)
	private Date createTimeLTANDEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 340)
	private String nameLIKE;

    /**
     * 测试计划标识EQ
     */
    @JsonProperty("n_plan_id_eq")
    @JSONField(name = "n_plan_id_eq")
    @ApiModelProperty(value = "测试计划标识EQ", position = 350)
	private String planIdEQ;

    /**
     * 测试用例标识EQ
     */
    @JsonProperty("n_case_id_eq")
    @JSONField(name = "n_case_id_eq")
    @ApiModelProperty(value = "测试用例标识EQ", position = 360)
	private String caseIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_case_name_eq")
    @JSONField(name = "n_case_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 370)
	private String caseNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_case_name_like")
    @JSONField(name = "n_case_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 371)
	private String caseNameLIKE;


}