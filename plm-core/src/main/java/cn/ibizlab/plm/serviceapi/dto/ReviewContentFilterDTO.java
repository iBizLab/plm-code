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
 * 评审内容过滤[ReviewContentFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审内容过滤DTO")
public class ReviewContentFilterDTO extends FilterBase implements Serializable {

    /**
     * 关联主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty(value = "关联主体标识EQ", position = 10)
	private String principalIdEQ;

    /**
     * 关联目标标识EQ
     */
    @JsonProperty("n_target_id_eq")
    @JSONField(name = "n_target_id_eq")
    @ApiModelProperty(value = "关联目标标识EQ", position = 80)
	private String targetIdEQ;

    /**
     * 目标对象版本标识EQ
     */
    @JsonProperty("n_target_version_id_eq")
    @JSONField(name = "n_target_version_id_eq")
    @ApiModelProperty(value = "目标对象版本标识EQ", position = 90)
	private String targetVersionIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 200)
	private String idEQ;


}