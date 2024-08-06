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
 * 智能报表立方体指标过滤[PSSysBICubeMeasureFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表立方体指标过滤DTO")
public class PSSysBICubeMeasureFilterDTO extends FilterBase implements Serializable {

    /**
     * 扩展模型EQ
     */
    @JsonProperty("n_dynamodelflag_eq")
    @JSONField(name = "n_dynamodelflag_eq")
    @ApiModelProperty(value = "扩展模型EQ", position = 0)
	private Integer dynaModelFlagEQ;

    /**
     * 智能报表指标标识EQ
     */
    @JsonProperty("n_pssysbicubemeasureid_eq")
    @JSONField(name = "n_pssysbicubemeasureid_eq")
    @ApiModelProperty(value = "智能报表指标标识EQ", position = 10)
	private String psSysBiCubeMeasureIdEQ;

    /**
     * 立方体指标名称LIKE
     */
    @JsonProperty("n_pssysbicubemeasurename_like")
    @JSONField(name = "n_pssysbicubemeasurename_like")
    @ApiModelProperty(value = "立方体指标名称LIKE", position = 20)
	private String psSysBiCubeMeasureNameLIKE;

    /**
     * 指标类型EQ
     */
    @JsonProperty("n_bimeasuretype_eq")
    @JSONField(name = "n_bimeasuretype_eq")
    @ApiModelProperty(value = "指标类型EQ", position = 70)
	private String biMeasureTypeEQ;

    /**
     * 智能报表立方体EQ
     */
    @JsonProperty("n_pssysbicubeid_eq")
    @JSONField(name = "n_pssysbicubeid_eq")
    @ApiModelProperty(value = "智能报表立方体EQ", position = 100)
	private String psSysBiCubeIdEQ;


}