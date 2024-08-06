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
 * 智能报表[PSSysBIReportDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表DTO")
public class PSSysBIReportDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 智能报表项
     */
    @JsonProperty("pssysbireportitems")
    @JSONField(name = "pssysbireportitems")
    @ApiModelProperty(value = "智能报表项", position = 0)
    private List<PSSysBIReportItemDTO> psSysBiReportItems;

    /**
     * 报表模型
     */
    @JsonProperty("bireportmodel")
    @JSONField(name = "bireportmodel")
    @ApiModelProperty(value = "报表模型", position = 1)
    private String biReportModel;

    /**
     * 报表标记
     */
    @JsonProperty("bireporttag")
    @JSONField(name = "bireporttag")
    @ApiModelProperty(value = "报表标记", position = 2)
    private String biReportTag;

    /**
     * 报表标记2
     */
    @JsonProperty("bireporttag2")
    @JSONField(name = "bireporttag2")
    @ApiModelProperty(value = "报表标记2", position = 3)
    private String biReportTag2;

    /**
     * 报表界面模型
     */
    @JsonProperty("bireportuimodel")
    @JSONField(name = "bireportuimodel")
    @ApiModelProperty(value = "报表界面模型", position = 4)
    private String biReportUiModel;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 5)
    private String codeName;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 6)
    private String memo;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @ApiModelProperty(value = "智能报表立方体", position = 7)
    private String psSysBiCubeId;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @ApiModelProperty(value = "智能报表立方体", position = 8)
    private String psSysBiCubeName;

    /**
     * 智能报表标识
     */
    @JsonProperty("pssysbireportid")
    @JSONField(name = "pssysbireportid")
    @ApiModelProperty(value = "智能报表标识", position = 9)
    private String psSysBiReportId;

    /**
     * 智能报表名称
     */
    @JsonProperty("pssysbireportname")
    @JSONField(name = "pssysbireportname")
    @ApiModelProperty(value = "智能报表名称", position = 10)
    private String psSysBiReportName;

    /**
     * 智能报表体系
     */
    @JsonProperty("pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @ApiModelProperty(value = "智能报表体系", position = 11)
    private String psSysBiSchemeId;

    /**
     * 智能报表体系
     */
    @JsonProperty("pssysbischemename")
    @JSONField(name = "pssysbischemename")
    @ApiModelProperty(value = "智能报表体系", position = 12)
    private String psSysBiSchemeName;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 13)
    private Integer validFlag;


    /**
     * 设置 [智能报表项]
     */
    public PSSysBIReportDTO setPsSysBiReportItems(List<PSSysBIReportItemDTO> psSysBiReportItems) {
        this.psSysBiReportItems = psSysBiReportItems;
        this.modify("pssysbireportitems", psSysBiReportItems);
        return this;
    }

    /**
     * 设置 [报表模型]
     */
    public PSSysBIReportDTO setBiReportModel(String biReportModel) {
        this.biReportModel = biReportModel;
        this.modify("bireportmodel", biReportModel);
        return this;
    }

    /**
     * 设置 [报表标记]
     */
    public PSSysBIReportDTO setBiReportTag(String biReportTag) {
        this.biReportTag = biReportTag;
        this.modify("bireporttag", biReportTag);
        return this;
    }

    /**
     * 设置 [报表标记2]
     */
    public PSSysBIReportDTO setBiReportTag2(String biReportTag2) {
        this.biReportTag2 = biReportTag2;
        this.modify("bireporttag2", biReportTag2);
        return this;
    }

    /**
     * 设置 [报表界面模型]
     */
    public PSSysBIReportDTO setBiReportUiModel(String biReportUiModel) {
        this.biReportUiModel = biReportUiModel;
        this.modify("bireportuimodel", biReportUiModel);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSSysBIReportDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSSysBIReportDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBIReportDTO setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBIReportDTO setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
     * 设置 [智能报表名称]
     */
    public PSSysBIReportDTO setPsSysBiReportName(String psSysBiReportName) {
        this.psSysBiReportName = psSysBiReportName;
        this.modify("pssysbireportname", psSysBiReportName);
        return this;
    }

    /**
     * 设置 [智能报表体系]
     */
    public PSSysBIReportDTO setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
     * 设置 [智能报表体系]
     */
    public PSSysBIReportDTO setPsSysBiSchemeName(String psSysBiSchemeName) {
        this.psSysBiSchemeName = psSysBiSchemeName;
        this.modify("pssysbischemename", psSysBiSchemeName);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public PSSysBIReportDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }


}
