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
 * 智能报表项[PSSysBIReportItemDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表项DTO")
public class PSSysBIReportItemDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 聚合类型
     */
    @JsonProperty("aggtype")
    @JSONField(name = "aggtype")
    @ApiModelProperty(value = "聚合类型", position = 0)
    private String aggType;

    /**
     * 项参数
     */
    @JsonProperty("birepitemparams")
    @JSONField(name = "birepitemparams")
    @ApiModelProperty(value = "项参数", position = 1)
    private String biRepItemParams;

    /**
     * 报表列标记
     */
    @JsonProperty("birepitemtag")
    @JSONField(name = "birepitemtag")
    @ApiModelProperty(value = "报表列标记", position = 2)
    private String biRepItemTag;

    /**
     * 报表列标记2
     */
    @JsonProperty("birepitemtag2")
    @JSONField(name = "birepitemtag2")
    @ApiModelProperty(value = "报表列标记2", position = 3)
    private String biRepItemTag2;

    /**
     * 报表项类型
     */
    @JsonProperty("birepitemtype")
    @JSONField(name = "birepitemtype")
    @ApiModelProperty(value = "报表项类型", position = 4)
    private String biRepItemType;

    /**
     * 项数据
     */
    @JsonProperty("data")
    @JSONField(name = "data")
    @ApiModelProperty(value = "项数据", position = 5)
    private String data;

    /**
     * 智能报表立方体维度
     */
    @JsonProperty("pssysbicubedimensionid")
    @JSONField(name = "pssysbicubedimensionid")
    @ApiModelProperty(value = "智能报表立方体维度", position = 6)
    private String psSysBiCubeDimensionId;

    /**
     * 立方体维度
     */
    @JsonProperty("pssysbicubedimensionname")
    @JSONField(name = "pssysbicubedimensionname")
    @ApiModelProperty(value = "立方体维度", position = 7)
    private String psSysBiCubeDimensionName;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @ApiModelProperty(value = "智能报表立方体", position = 8)
    private String psSysBiCubeId;

    /**
     * 智能报表指标
     */
    @JsonProperty("pssysbicubemeasureid")
    @JSONField(name = "pssysbicubemeasureid")
    @ApiModelProperty(value = "智能报表指标", position = 9)
    private String psSysBiCubeMeasureId;

    /**
     * 立方体指标
     */
    @JsonProperty("pssysbicubemeasurename")
    @JSONField(name = "pssysbicubemeasurename")
    @ApiModelProperty(value = "立方体指标", position = 10)
    private String psSysBiCubeMeasureName;

    /**
     * 智能报表立方体
     */
    @JsonProperty("pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @ApiModelProperty(value = "智能报表立方体", position = 11)
    private String psSysBiCubeName;

    /**
     * 智能报表报表
     */
    @JsonProperty("pssysbireportid")
    @JSONField(name = "pssysbireportid")
    @ApiModelProperty(value = "智能报表报表", position = 12)
    private String psSysBiReportId;

    /**
     * 智能报表项标识
     */
    @JsonProperty("pssysbireportitemid")
    @JSONField(name = "pssysbireportitemid")
    @ApiModelProperty(value = "智能报表项标识", position = 13)
    private String psSysBiReportItemId;

    /**
     * 智能报表项名称
     */
    @JsonProperty("pssysbireportitemname")
    @JSONField(name = "pssysbireportitemname")
    @ApiModelProperty(value = "智能报表项名称", position = 14)
    private String psSysBiReportItemName;

    /**
     * 智能报表报表
     */
    @JsonProperty("pssysbireportname")
    @JSONField(name = "pssysbireportname")
    @ApiModelProperty(value = "智能报表报表", position = 15)
    private String psSysBiReportName;

    /**
     * PSSYSBISCHEMEID
     */
    @JsonProperty("pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @ApiModelProperty(value = "PSSYSBISCHEMEID", position = 16)
    private String psSysBiSchemeId;

    /**
     * 放置类型
     */
    @JsonProperty("placetype")
    @JSONField(name = "placetype")
    @ApiModelProperty(value = "放置类型", position = 17)
    private String placeType;

    /**
     * 放置位置
     */
    @JsonProperty("placement")
    @JSONField(name = "placement")
    @ApiModelProperty(value = "放置位置", position = 18)
    private String placement;

    /**
     * 指标引用类型
     */
    @JsonProperty("reftype")
    @JSONField(name = "reftype")
    @ApiModelProperty(value = "指标引用类型", position = 19)
    private String refType;

    /**
     * 标准数据类型
     */
    @JsonProperty("stddatatype")
    @JSONField(name = "stddatatype")
    @ApiModelProperty(value = "标准数据类型", position = 20)
    private Integer stdDataType;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 21)
    private Integer validFlag;

    /**
     * 值格式化
     */
    @JsonProperty("valueformat")
    @JSONField(name = "valueformat")
    @ApiModelProperty(value = "值格式化", position = 22)
    private String valueFormat;


    /**
     * 设置 [聚合类型]
     */
    public PSSysBIReportItemDTO setAggType(String aggType) {
        this.aggType = aggType;
        this.modify("aggtype", aggType);
        return this;
    }

    /**
     * 设置 [项参数]
     */
    public PSSysBIReportItemDTO setBiRepItemParams(String biRepItemParams) {
        this.biRepItemParams = biRepItemParams;
        this.modify("birepitemparams", biRepItemParams);
        return this;
    }

    /**
     * 设置 [报表列标记]
     */
    public PSSysBIReportItemDTO setBiRepItemTag(String biRepItemTag) {
        this.biRepItemTag = biRepItemTag;
        this.modify("birepitemtag", biRepItemTag);
        return this;
    }

    /**
     * 设置 [报表列标记2]
     */
    public PSSysBIReportItemDTO setBiRepItemTag2(String biRepItemTag2) {
        this.biRepItemTag2 = biRepItemTag2;
        this.modify("birepitemtag2", biRepItemTag2);
        return this;
    }

    /**
     * 设置 [报表项类型]
     */
    public PSSysBIReportItemDTO setBiRepItemType(String biRepItemType) {
        this.biRepItemType = biRepItemType;
        this.modify("birepitemtype", biRepItemType);
        return this;
    }

    /**
     * 设置 [项数据]
     */
    public PSSysBIReportItemDTO setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
     * 设置 [智能报表立方体维度]
     */
    public PSSysBIReportItemDTO setPsSysBiCubeDimensionId(String psSysBiCubeDimensionId) {
        this.psSysBiCubeDimensionId = psSysBiCubeDimensionId;
        this.modify("pssysbicubedimensionid", psSysBiCubeDimensionId);
        return this;
    }

    /**
     * 设置 [立方体维度]
     */
    public PSSysBIReportItemDTO setPsSysBiCubeDimensionName(String psSysBiCubeDimensionName) {
        this.psSysBiCubeDimensionName = psSysBiCubeDimensionName;
        this.modify("pssysbicubedimensionname", psSysBiCubeDimensionName);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBIReportItemDTO setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
     * 设置 [智能报表指标]
     */
    public PSSysBIReportItemDTO setPsSysBiCubeMeasureId(String psSysBiCubeMeasureId) {
        this.psSysBiCubeMeasureId = psSysBiCubeMeasureId;
        this.modify("pssysbicubemeasureid", psSysBiCubeMeasureId);
        return this;
    }

    /**
     * 设置 [立方体指标]
     */
    public PSSysBIReportItemDTO setPsSysBiCubeMeasureName(String psSysBiCubeMeasureName) {
        this.psSysBiCubeMeasureName = psSysBiCubeMeasureName;
        this.modify("pssysbicubemeasurename", psSysBiCubeMeasureName);
        return this;
    }

    /**
     * 设置 [智能报表立方体]
     */
    public PSSysBIReportItemDTO setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
     * 设置 [智能报表报表]
     */
    public PSSysBIReportItemDTO setPsSysBiReportId(String psSysBiReportId) {
        this.psSysBiReportId = psSysBiReportId;
        this.modify("pssysbireportid", psSysBiReportId);
        return this;
    }

    /**
     * 设置 [智能报表项名称]
     */
    public PSSysBIReportItemDTO setPsSysBiReportItemName(String psSysBiReportItemName) {
        this.psSysBiReportItemName = psSysBiReportItemName;
        this.modify("pssysbireportitemname", psSysBiReportItemName);
        return this;
    }

    /**
     * 设置 [智能报表报表]
     */
    public PSSysBIReportItemDTO setPsSysBiReportName(String psSysBiReportName) {
        this.psSysBiReportName = psSysBiReportName;
        this.modify("pssysbireportname", psSysBiReportName);
        return this;
    }

    /**
     * 设置 [PSSYSBISCHEMEID]
     */
    public PSSysBIReportItemDTO setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
     * 设置 [放置类型]
     */
    public PSSysBIReportItemDTO setPlaceType(String placeType) {
        this.placeType = placeType;
        this.modify("placetype", placeType);
        return this;
    }

    /**
     * 设置 [放置位置]
     */
    public PSSysBIReportItemDTO setPlacement(String placement) {
        this.placement = placement;
        this.modify("placement", placement);
        return this;
    }

    /**
     * 设置 [指标引用类型]
     */
    public PSSysBIReportItemDTO setRefType(String refType) {
        this.refType = refType;
        this.modify("reftype", refType);
        return this;
    }

    /**
     * 设置 [标准数据类型]
     */
    public PSSysBIReportItemDTO setStdDataType(Integer stdDataType) {
        this.stdDataType = stdDataType;
        this.modify("stddatatype", stdDataType);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public PSSysBIReportItemDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
     * 设置 [值格式化]
     */
    public PSSysBIReportItemDTO setValueFormat(String valueFormat) {
        this.valueFormat = valueFormat;
        this.modify("valueformat", valueFormat);
        return this;
    }


}
