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
 * 智能报表立方体维度[PSSysBICubeDimensionDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表立方体维度DTO")
public class PSSysBICubeDimensionDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展模型
     */
    @JsonProperty("dynamodelflag")
    @JSONField(name = "dynamodelflag")
    @ApiModelProperty(value = "扩展模型", position = 0)
    private Integer dynaModelFlag;

    /**
     * 维度类型
     */
    @JsonProperty("bidimensiontype")
    @JSONField(name = "bidimensiontype")
    @ApiModelProperty(value = "维度类型", position = 1)
    private String biDimensionType;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 2)
    private String codeName;

    /**
     * 维度公式
     */
    @JsonProperty("dimensionformula")
    @JSONField(name = "dimensionformula")
    @ApiModelProperty(value = "维度公式", position = 3)
    private String dimensionFormula;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 4)
    private String memo;

    /**
     * 代码表
     */
    @JsonProperty("pscodelistid")
    @JSONField(name = "pscodelistid")
    @ApiModelProperty(value = "代码表", position = 5)
    private String psCodeListId;

    /**
     * 代码表
     */
    @JsonProperty("pscodelistname")
    @JSONField(name = "pscodelistname")
    @ApiModelProperty(value = "代码表", position = 6)
    private String psCodeListName;

    /**
     * 立方体维度标识
     */
    @JsonProperty("pssysbicubedimensionid")
    @JSONField(name = "pssysbicubedimensionid")
    @ApiModelProperty(value = "立方体维度标识", position = 7)
    private String psSysBiCubeDimensionId;

    /**
     * 立方体维度名称
     */
    @JsonProperty("pssysbicubedimensionname")
    @JSONField(name = "pssysbicubedimensionname")
    @ApiModelProperty(value = "立方体维度名称", position = 8)
    private String psSysBiCubeDimensionName;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @ApiModelProperty(value = "智能报表立方体", position = 9)
    private String psSysBiCubeId;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @ApiModelProperty(value = "智能报表立方体", position = 10)
    private String psSysBiCubeName;

    /**
     * PSSYSBISCHEMEID
     */
    @JsonProperty("pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @ApiModelProperty(value = "PSSYSBISCHEMEID", position = 11)
    private String psSysBiSchemeId;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 12)
    private Integer validFlag;


    /**
     * 设置 [扩展模型]
     */
    public PSSysBICubeDimensionDTO setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
     * 设置 [维度类型]
     */
    public PSSysBICubeDimensionDTO setBiDimensionType(String biDimensionType) {
        this.biDimensionType = biDimensionType;
        this.modify("bidimensiontype", biDimensionType);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSSysBICubeDimensionDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [维度公式]
     */
    public PSSysBICubeDimensionDTO setDimensionFormula(String dimensionFormula) {
        this.dimensionFormula = dimensionFormula;
        this.modify("dimensionformula", dimensionFormula);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSSysBICubeDimensionDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [代码表]
     */
    public PSSysBICubeDimensionDTO setPsCodeListId(String psCodeListId) {
        this.psCodeListId = psCodeListId;
        this.modify("pscodelistid", psCodeListId);
        return this;
    }

    /**
     * 设置 [代码表]
     */
    public PSSysBICubeDimensionDTO setPsCodeListName(String psCodeListName) {
        this.psCodeListName = psCodeListName;
        this.modify("pscodelistname", psCodeListName);
        return this;
    }

    /**
     * 设置 [立方体维度名称]
     */
    public PSSysBICubeDimensionDTO setPsSysBiCubeDimensionName(String psSysBiCubeDimensionName) {
        this.psSysBiCubeDimensionName = psSysBiCubeDimensionName;
        this.modify("pssysbicubedimensionname", psSysBiCubeDimensionName);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBICubeDimensionDTO setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBICubeDimensionDTO setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
     * 设置 [PSSYSBISCHEMEID]
     */
    public PSSysBICubeDimensionDTO setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public PSSysBICubeDimensionDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }


}
