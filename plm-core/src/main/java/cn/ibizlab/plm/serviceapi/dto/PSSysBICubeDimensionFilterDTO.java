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
 * 智能报表立方体维度过滤[PSSysBICubeDimensionFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表立方体维度过滤DTO")
public class PSSysBICubeDimensionFilterDTO extends FilterBase implements Serializable {

    /**
     * 扩展模型EQ
     */
    @JsonProperty("n_dynamodelflag_eq")
    @JSONField(name = "n_dynamodelflag_eq")
    @ApiModelProperty(value = "扩展模型EQ", position = 0)
	private Integer dynaModelFlagEQ;

    /**
     * 立方体维度标识EQ
     */
    @JsonProperty("n_pssysbicubedimensionid_eq")
    @JSONField(name = "n_pssysbicubedimensionid_eq")
    @ApiModelProperty(value = "立方体维度标识EQ", position = 10)
	private String psSysBiCubeDimensionIdEQ;

    /**
     * 立方体维度名称LIKE
     */
    @JsonProperty("n_pssysbicubedimensionname_like")
    @JSONField(name = "n_pssysbicubedimensionname_like")
    @ApiModelProperty(value = "立方体维度名称LIKE", position = 20)
	private String psSysBiCubeDimensionNameLIKE;

    /**
     * 维度类型EQ
     */
    @JsonProperty("n_bidimensiontype_eq")
    @JSONField(name = "n_bidimensiontype_eq")
    @ApiModelProperty(value = "维度类型EQ", position = 50)
	private String biDimensionTypeEQ;

    /**
     * 智能报表立方体EQ
     */
    @JsonProperty("n_pssysbicubeid_eq")
    @JSONField(name = "n_pssysbicubeid_eq")
    @ApiModelProperty(value = "智能报表立方体EQ", position = 60)
	private String psSysBiCubeIdEQ;


}