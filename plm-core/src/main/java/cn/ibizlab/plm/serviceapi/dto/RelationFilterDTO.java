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
 * 关联过滤[RelationFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("关联过滤DTO")
public class RelationFilterDTO extends FilterBase implements Serializable {

    /**
     * 重要程度EQ
     */
    @JsonProperty("n_level_eq")
    @JSONField(name = "n_level_eq")
    @ApiModelProperty(value = "重要程度EQ", position = 0)
	private String levelEQ;

    /**
     * 关联主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty(value = "关联主体标识EQ", position = 10)
	private String principalIdEQ;

    /**
     * 关联主体类型EQ
     */
    @JsonProperty("n_principal_type_eq")
    @JSONField(name = "n_principal_type_eq")
    @ApiModelProperty(value = "关联主体类型EQ", position = 20)
	private String principalTypeEQ;

    /**
     * 关联目标类型EQ
     */
    @JsonProperty("n_target_type_eq")
    @JSONField(name = "n_target_type_eq")
    @ApiModelProperty(value = "关联目标类型EQ", position = 40)
	private String targetTypeEQ;

    /**
     * 目标主体标识EQ
     */
    @JsonProperty("n_target_id_eq")
    @JSONField(name = "n_target_id_eq")
    @ApiModelProperty(value = "目标主体标识EQ", position = 50)
	private String targetIdEQ;

    /**
     * 目标对象版本标识EQ
     */
    @JsonProperty("n_target_version_id_eq")
    @JSONField(name = "n_target_version_id_eq")
    @ApiModelProperty(value = "目标对象版本标识EQ", position = 70)
	private String targetVersionIdEQ;

    /**
     * 前后置任务EQ
     */
    @JsonProperty("n_job_type_eq")
    @JSONField(name = "n_job_type_eq")
    @ApiModelProperty(value = "前后置任务EQ", position = 220)
	private String jobTypeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 260)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 270)
	private String nameLIKE;


}