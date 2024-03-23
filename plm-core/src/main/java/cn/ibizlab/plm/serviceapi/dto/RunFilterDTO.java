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
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty(value = "用例模块标识EQ", position = 140)
	private String suiteIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 230)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 270)
	private String nameLIKE;

    /**
     * 测试计划标识EQ
     */
    @JsonProperty("n_plan_id_eq")
    @JSONField(name = "n_plan_id_eq")
    @ApiModelProperty(value = "测试计划标识EQ", position = 280)
	private String planIdEQ;

    /**
     * 测试用例标识EQ
     */
    @JsonProperty("n_case_id_eq")
    @JSONField(name = "n_case_id_eq")
    @ApiModelProperty(value = "测试用例标识EQ", position = 290)
	private String caseIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_case_name_eq")
    @JSONField(name = "n_case_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 300)
	private String caseNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_case_name_like")
    @JSONField(name = "n_case_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 301)
	private String caseNameLIKE;


}