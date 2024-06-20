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
 * 基线需求过滤[BaselineIdeaFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("基线需求过滤DTO")
public class BaselineIdeaFilterDTO extends FilterBase implements Serializable {

    /**
     * 关联主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty(value = "关联主体标识EQ", position = 0)
	private String principalIdEQ;

    /**
     * 关联目标标识EQ
     */
    @JsonProperty("n_target_id_eq")
    @JSONField(name = "n_target_id_eq")
    @ApiModelProperty(value = "关联目标标识EQ", position = 40)
	private String targetIdEQ;

    /**
     * 目标对象版本标识EQ
     */
    @JsonProperty("n_target_version_id_eq")
    @JSONField(name = "n_target_version_id_eq")
    @ApiModelProperty(value = "目标对象版本标识EQ", position = 50)
	private String targetVersionIdEQ;

    /**
     * 需求类型EQ
     */
    @JsonProperty("n_idea_type_eq")
    @JSONField(name = "n_idea_type_eq")
    @ApiModelProperty(value = "需求类型EQ", position = 150)
	private String ideaTypeEQ;

    /**
     * 需求来源EQ
     */
    @JsonProperty("n_idea_from_eq")
    @JSONField(name = "n_idea_from_eq")
    @ApiModelProperty(value = "需求来源EQ", position = 160)
	private String ideaFromEQ;

    /**
     * 计划时间周期单位EQ
     */
    @JsonProperty("n_plan_at_granularity_eq")
    @JSONField(name = "n_plan_at_granularity_eq")
    @ApiModelProperty(value = "计划时间周期单位EQ", position = 190)
	private String planAtGranularityEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 300)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 310)
	private String nameLIKE;


}