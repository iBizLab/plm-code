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
    @ApiModelProperty(value = "执行时间EQ", position = 50)
	private Date executedAtEQ;

    /**
     * 执行时间GTANDEQ
     */
    @JsonProperty("n_executed_at_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间GTANDEQ", position = 51)
	private Date executedAtGTANDEQ;

    /**
     * 执行时间LTANDEQ
     */
    @JsonProperty("n_executed_at_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间LTANDEQ", position = 52)
	private Date executedAtLTANDEQ;

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "执行结果EQ", position = 60)
	private String statusEQ;

    /**
     * 执行结果ISNOTNULL
     */
    @JsonProperty("n_status_isnotnull")
    @JSONField(name = "n_status_isnotnull")
    @ApiModelProperty(value = "执行结果ISNOTNULL", position = 61)
	private String statusISNOTNULL;

    /**
     * 测试计划EQ
     */
    @JsonProperty("n_plan_name_eq")
    @JSONField(name = "n_plan_name_eq")
    @ApiModelProperty(value = "测试计划EQ", position = 90)
	private String planNameEQ;

    /**
     * 测试计划LIKE
     */
    @JsonProperty("n_plan_name_like")
    @JSONField(name = "n_plan_name_like")
    @ApiModelProperty(value = "测试计划LIKE", position = 91)
	private String planNameLIKE;

    /**
     * 执行人标识EQ
     */
    @JsonProperty("n_executor_id_eq")
    @JSONField(name = "n_executor_id_eq")
    @ApiModelProperty(value = "执行人标识EQ", position = 120)
	private String executorIdEQ;

    /**
     * 执行人EQ
     */
    @JsonProperty("n_executor_name_eq")
    @JSONField(name = "n_executor_name_eq")
    @ApiModelProperty(value = "执行人EQ", position = 130)
	private String executorNameEQ;

    /**
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty(value = "用例模块标识EQ", position = 140)
	private String suiteIdEQ;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty(value = "测试库标识EQ", position = 190)
	private String libraryIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 280)
	private String idEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 300)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 301)
	private Date createTimeLTANDEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 320)
	private String nameLIKE;

    /**
     * 测试计划标识EQ
     */
    @JsonProperty("n_plan_id_eq")
    @JSONField(name = "n_plan_id_eq")
    @ApiModelProperty(value = "测试计划标识EQ", position = 330)
	private String planIdEQ;

    /**
     * 测试用例标识EQ
     */
    @JsonProperty("n_case_id_eq")
    @JSONField(name = "n_case_id_eq")
    @ApiModelProperty(value = "测试用例标识EQ", position = 340)
	private String caseIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_case_name_eq")
    @JSONField(name = "n_case_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 350)
	private String caseNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_case_name_like")
    @JSONField(name = "n_case_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 351)
	private String caseNameLIKE;


}