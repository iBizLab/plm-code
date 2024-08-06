/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.extension.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import cn.ibizlab.plm.core.extension.domain.PSSysBIReport;

/**
 * 智能报表项实体类[PSSysBIReportItem]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSSYSBIREPORTITEM", description = "智能报表项")
public class PSSysBIReportItem extends EntityBase implements Serializable
{
    /**
     * 智能报表项标识
     */
    @Id
    @DEField(name = "pssysbireportitemid" , isKeyField = true)
    @JSONField(name = "pssysbireportitemid")
    @JsonProperty("pssysbireportitemid")
    @ApiModelProperty(value = "pssysbireportitemid", notes = "智能报表项标识")
    private String psSysBiReportItemId;

    /**
     * 智能报表项名称
     */
    @DEField(name = "pssysbireportitemname")
    @JSONField(name = "pssysbireportitemname")
    @JsonProperty("pssysbireportitemname")
    @ApiModelProperty(value = "pssysbireportitemname", notes = "智能报表项名称")
    private String psSysBiReportItemName;

    /**
     * 启用
     */
    @DEField(name = "validflag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 值格式化
     */
    @DEField(name = "valueformat")
    @JSONField(name = "valueformat")
    @JsonProperty("valueformat")
    @ApiModelProperty(value = "valueformat", notes = "值格式化")
    private String valueFormat;

    /**
     * 智能报表立方体维度
     */
    @DEField(name = "pssysbicubedimensionid")
    @JSONField(name = "pssysbicubedimensionid")
    @JsonProperty("pssysbicubedimensionid")
    @ApiModelProperty(value = "pssysbicubedimensionid", notes = "智能报表立方体维度")
    private String psSysBiCubeDimensionId;

    /**
     * 智能报表立方体
     */
    @DEField(name = "pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @JsonProperty("pssysbicubeid")
    @ApiModelProperty(value = "pssysbicubeid", notes = "智能报表立方体")
    private String psSysBiCubeId;

    /**
     * 智能报表指标
     */
    @DEField(name = "pssysbicubemeasureid")
    @JSONField(name = "pssysbicubemeasureid")
    @JsonProperty("pssysbicubemeasureid")
    @ApiModelProperty(value = "pssysbicubemeasureid", notes = "智能报表指标")
    private String psSysBiCubeMeasureId;

    /**
     * 立方体维度
     */
    @DEField(name = "pssysbicubedimensionname")
    @JSONField(name = "pssysbicubedimensionname")
    @JsonProperty("pssysbicubedimensionname")
    @ApiModelProperty(value = "pssysbicubedimensionname", notes = "立方体维度")
    private String psSysBiCubeDimensionName;

    /**
     * 立方体指标
     */
    @DEField(name = "pssysbicubemeasurename")
    @JSONField(name = "pssysbicubemeasurename")
    @JsonProperty("pssysbicubemeasurename")
    @ApiModelProperty(value = "pssysbicubemeasurename", notes = "立方体指标")
    private String psSysBiCubeMeasureName;

    /**
     * 智能报表立方体
     */
    @DEField(name = "pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @JsonProperty("pssysbicubename")
    @ApiModelProperty(value = "pssysbicubename", notes = "智能报表立方体")
    private String psSysBiCubeName;

    /**
     * 智能报表报表
     */
    @DEField(name = "pssysbireportid")
    @JSONField(name = "pssysbireportid")
    @JsonProperty("pssysbireportid")
    @ApiModelProperty(value = "pssysbireportid", notes = "智能报表报表")
    private String psSysBiReportId;

    /**
     * 智能报表报表
     */
    @DEField(name = "pssysbireportname")
    @JSONField(name = "pssysbireportname")
    @JsonProperty("pssysbireportname")
    @ApiModelProperty(value = "pssysbireportname", notes = "智能报表报表")
    private String psSysBiReportName;

    /**
     * PSSYSBISCHEMEID
     */
    @DEField(name = "pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @JsonProperty("pssysbischemeid")
    @ApiModelProperty(value = "pssysbischemeid", notes = "PSSYSBISCHEMEID")
    private String psSysBiSchemeId;

    /**
     * 报表项类型
     */
    @DEField(name = "birepitemtype" , dict = "BIReportItemType")
    @JSONField(name = "birepitemtype")
    @JsonProperty("birepitemtype")
    @ApiModelProperty(value = "birepitemtype", notes = "报表项类型")
    private String biRepItemType;

    /**
     * 放置类型
     */
    @DEField(name = "placetype" , dict = "BIReportItemPlaceType")
    @JSONField(name = "placetype")
    @JsonProperty("placetype")
    @ApiModelProperty(value = "placetype", notes = "放置类型")
    private String placeType;

    /**
     * 放置位置
     */
    @DEField(name = "placement" , dict = "BIReportItemPlacement")
    @JSONField(name = "placement")
    @JsonProperty("placement")
    @ApiModelProperty(value = "placement", notes = "放置位置")
    private String placement;

    /**
     * 项数据
     */
    @DEField(name = "data")
    @JSONField(name = "data")
    @JsonProperty("data")
    @ApiModelProperty(value = "data", notes = "项数据")
    private String data;

    /**
     * 项参数
     */
    @DEField(name = "birepitemparams")
    @JSONField(name = "birepitemparams")
    @JsonProperty("birepitemparams")
    @ApiModelProperty(value = "birepitemparams", notes = "项参数")
    private String biRepItemParams;

    /**
     * 报表列标记2
     */
    @DEField(name = "birepitemtag2")
    @JSONField(name = "birepitemtag2")
    @JsonProperty("birepitemtag2")
    @ApiModelProperty(value = "birepitemtag2", notes = "报表列标记2")
    private String biRepItemTag2;

    /**
     * 报表列标记
     */
    @DEField(name = "birepitemtag")
    @JSONField(name = "birepitemtag")
    @JsonProperty("birepitemtag")
    @ApiModelProperty(value = "birepitemtag", notes = "报表列标记")
    private String biRepItemTag;

    /**
     * 指标引用类型
     */
    @DEField(name = "reftype" , dict = "BIReportItemMSRefType")
    @JSONField(name = "reftype")
    @JsonProperty("reftype")
    @ApiModelProperty(value = "reftype", notes = "指标引用类型")
    private String refType;

    /**
     * 聚合类型
     */
    @DEField(name = "aggtype" , dict = "DERDERMapType")
    @JSONField(name = "aggtype")
    @JsonProperty("aggtype")
    @ApiModelProperty(value = "aggtype", notes = "聚合类型")
    private String aggType;

    /**
     * 标准数据类型
     */
    @DEField(name = "stddatatype")
    @JSONField(name = "stddatatype")
    @JsonProperty("stddatatype")
    @ApiModelProperty(value = "stddatatype", notes = "标准数据类型")
    private Integer stdDataType;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "pssysbireport", notes = "")
    private PSSysBIReport psSysBiReport;

    /**
    * 设置 [智能报表项名称]
    */
    public PSSysBIReportItem setPsSysBiReportItemName(String psSysBiReportItemName) {
        this.psSysBiReportItemName = psSysBiReportItemName;
        this.modify("pssysbireportitemname", psSysBiReportItemName);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public PSSysBIReportItem setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [值格式化]
    */
    public PSSysBIReportItem setValueFormat(String valueFormat) {
        this.valueFormat = valueFormat;
        this.modify("valueformat", valueFormat);
        return this;
    }

    /**
    * 设置 [智能报表立方体维度]
    */
    public PSSysBIReportItem setPsSysBiCubeDimensionId(String psSysBiCubeDimensionId) {
        this.psSysBiCubeDimensionId = psSysBiCubeDimensionId;
        this.modify("pssysbicubedimensionid", psSysBiCubeDimensionId);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBIReportItem setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
    * 设置 [智能报表指标]
    */
    public PSSysBIReportItem setPsSysBiCubeMeasureId(String psSysBiCubeMeasureId) {
        this.psSysBiCubeMeasureId = psSysBiCubeMeasureId;
        this.modify("pssysbicubemeasureid", psSysBiCubeMeasureId);
        return this;
    }

    /**
    * 设置 [立方体维度]
    */
    public PSSysBIReportItem setPsSysBiCubeDimensionName(String psSysBiCubeDimensionName) {
        this.psSysBiCubeDimensionName = psSysBiCubeDimensionName;
        this.modify("pssysbicubedimensionname", psSysBiCubeDimensionName);
        return this;
    }

    /**
    * 设置 [立方体指标]
    */
    public PSSysBIReportItem setPsSysBiCubeMeasureName(String psSysBiCubeMeasureName) {
        this.psSysBiCubeMeasureName = psSysBiCubeMeasureName;
        this.modify("pssysbicubemeasurename", psSysBiCubeMeasureName);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBIReportItem setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
    * 设置 [智能报表报表]
    */
    public PSSysBIReportItem setPsSysBiReportId(String psSysBiReportId) {
        this.psSysBiReportId = psSysBiReportId;
        this.modify("pssysbireportid", psSysBiReportId);
        return this;
    }

    /**
    * 设置 [智能报表报表]
    */
    public PSSysBIReportItem setPsSysBiReportName(String psSysBiReportName) {
        this.psSysBiReportName = psSysBiReportName;
        this.modify("pssysbireportname", psSysBiReportName);
        return this;
    }

    /**
    * 设置 [PSSYSBISCHEMEID]
    */
    public PSSysBIReportItem setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
    * 设置 [报表项类型]
    */
    public PSSysBIReportItem setBiRepItemType(String biRepItemType) {
        this.biRepItemType = biRepItemType;
        this.modify("birepitemtype", biRepItemType);
        return this;
    }

    /**
    * 设置 [放置类型]
    */
    public PSSysBIReportItem setPlaceType(String placeType) {
        this.placeType = placeType;
        this.modify("placetype", placeType);
        return this;
    }

    /**
    * 设置 [放置位置]
    */
    public PSSysBIReportItem setPlacement(String placement) {
        this.placement = placement;
        this.modify("placement", placement);
        return this;
    }

    /**
    * 设置 [项数据]
    */
    public PSSysBIReportItem setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
    * 设置 [项参数]
    */
    public PSSysBIReportItem setBiRepItemParams(String biRepItemParams) {
        this.biRepItemParams = biRepItemParams;
        this.modify("birepitemparams", biRepItemParams);
        return this;
    }

    /**
    * 设置 [报表列标记2]
    */
    public PSSysBIReportItem setBiRepItemTag2(String biRepItemTag2) {
        this.biRepItemTag2 = biRepItemTag2;
        this.modify("birepitemtag2", biRepItemTag2);
        return this;
    }

    /**
    * 设置 [报表列标记]
    */
    public PSSysBIReportItem setBiRepItemTag(String biRepItemTag) {
        this.biRepItemTag = biRepItemTag;
        this.modify("birepitemtag", biRepItemTag);
        return this;
    }

    /**
    * 设置 [指标引用类型]
    */
    public PSSysBIReportItem setRefType(String refType) {
        this.refType = refType;
        this.modify("reftype", refType);
        return this;
    }

    /**
    * 设置 [聚合类型]
    */
    public PSSysBIReportItem setAggType(String aggType) {
        this.aggType = aggType;
        this.modify("aggtype", aggType);
        return this;
    }

    /**
    * 设置 [标准数据类型]
    */
    public PSSysBIReportItem setStdDataType(Integer stdDataType) {
        this.stdDataType = stdDataType;
        this.modify("stddatatype", stdDataType);
        return this;
    }


    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param includeEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T pasteTo(T targetEntity, boolean includeEmpty) {
        super.pasteTo(targetEntity, includeEmpty);
        if(targetEntity instanceof IEntity) {
            IEntity entity = ((IEntity) targetEntity);
            entity.reset("pssysbireportitemid");
        }
        return targetEntity;
    }

}