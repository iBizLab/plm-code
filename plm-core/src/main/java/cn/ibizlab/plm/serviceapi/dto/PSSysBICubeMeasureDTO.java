/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 智能报表立方体指标[PSSysBICubeMeasureDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表立方体指标DTO")
public class PSSysBICubeMeasureDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展模型
     */
    @JsonProperty("dynamodelflag")
    @JSONField(name = "dynamodelflag")
    @ApiModelProperty(value = "扩展模型", position = 0)
    private Integer dynaModelFlag;

    /**
     * 指标类型
     */
    @JsonProperty("bimeasuretype")
    @JSONField(name = "bimeasuretype")
    @ApiModelProperty(value = "指标类型", position = 1)
    private String biMeasureType;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 2)
    private String codeName;

    /**
     * 指标公式
     */
    @JsonProperty("measureformula")
    @JSONField(name = "measureformula")
    @ApiModelProperty(value = "指标公式", position = 3)
    private String measureFormula;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 4)
    private String memo;

    /**
     * 排序值
     */
    @JsonProperty("ordervalue")
    @JSONField(name = "ordervalue")
    @ApiModelProperty(value = "排序值", position = 5)
    private Integer orderValue;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @ApiModelProperty(value = "智能报表立方体", position = 6)
    private String psSysBiCubeId;

    /**
     * 智能报表指标标识
     */
    @JsonProperty("pssysbicubemeasureid")
    @JSONField(name = "pssysbicubemeasureid")
    @ApiModelProperty(value = "智能报表指标标识", position = 7)
    private String psSysBiCubeMeasureId;

    /**
     * 立方体指标名称
     */
    @JsonProperty("pssysbicubemeasurename")
    @JSONField(name = "pssysbicubemeasurename")
    @ApiModelProperty(value = "立方体指标名称", position = 8)
    private String psSysBiCubeMeasureName;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @ApiModelProperty(value = "智能报表立方体", position = 9)
    private String psSysBiCubeName;

    /**
     * PSSYSBISCHEMEID
     */
    @JsonProperty("pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @ApiModelProperty(value = "PSSYSBISCHEMEID", position = 10)
    private String psSysBiSchemeId;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 11)
    private Integer validFlag;


    /**
     * 设置 [扩展模型]
     */
    public PSSysBICubeMeasureDTO setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
     * 设置 [指标类型]
     */
    public PSSysBICubeMeasureDTO setBiMeasureType(String biMeasureType) {
        this.biMeasureType = biMeasureType;
        this.modify("bimeasuretype", biMeasureType);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSSysBICubeMeasureDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [指标公式]
     */
    public PSSysBICubeMeasureDTO setMeasureFormula(String measureFormula) {
        this.measureFormula = measureFormula;
        this.modify("measureformula", measureFormula);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSSysBICubeMeasureDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBICubeMeasureDTO setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
     * 设置 [立方体指标名称]
     */
    public PSSysBICubeMeasureDTO setPsSysBiCubeMeasureName(String psSysBiCubeMeasureName) {
        this.psSysBiCubeMeasureName = psSysBiCubeMeasureName;
        this.modify("pssysbicubemeasurename", psSysBiCubeMeasureName);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBICubeMeasureDTO setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
     * 设置 [PSSYSBISCHEMEID]
     */
    public PSSysBICubeMeasureDTO setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public PSSysBICubeMeasureDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }


}
