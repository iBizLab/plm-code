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

/**
 * 智能报表立方体维度实体类[PSSysBICubeDimension]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSSYSBICUBEDIMENSION", description = "智能报表立方体维度")
public class PSSysBICubeDimension extends EntityBase implements Serializable
{
    /**
     * 扩展模型
     */
    @DEField(name = "dynamodelflag" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "dynamodelflag")
    @JsonProperty("dynamodelflag")
    @ApiModelProperty(value = "dynamodelflag", notes = "扩展模型")
    private Integer dynaModelFlag;

    /**
     * 立方体维度标识
     */
    @Id
    @DEField(name = "pssysbicubedimensionid" , isKeyField = true)
    @JSONField(name = "pssysbicubedimensionid")
    @JsonProperty("pssysbicubedimensionid")
    @ApiModelProperty(value = "pssysbicubedimensionid", notes = "立方体维度标识")
    private String psSysBiCubeDimensionId;

    /**
     * 立方体维度名称
     */
    @DEField(name = "pssysbicubedimensionname")
    @JSONField(name = "pssysbicubedimensionname")
    @JsonProperty("pssysbicubedimensionname")
    @ApiModelProperty(value = "pssysbicubedimensionname", notes = "立方体维度名称")
    private String psSysBiCubeDimensionName;

    /**
     * 启用
     */
    @DEField(name = "validflag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 维度公式
     */
    @DEField(name = "dimensionformula")
    @JSONField(name = "dimensionformula")
    @JsonProperty("dimensionformula")
    @ApiModelProperty(value = "dimensionformula", notes = "维度公式")
    private String dimensionFormula;

    /**
     * 维度类型
     */
    @DEField(name = "bidimensiontype" , dict = "BIDimensionType")
    @JSONField(name = "bidimensiontype")
    @JsonProperty("bidimensiontype")
    @ApiModelProperty(value = "bidimensiontype", notes = "维度类型")
    private String biDimensionType;

    /**
     * 智能报表立方体
     */
    @DEField(name = "pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @JsonProperty("pssysbicubeid")
    @ApiModelProperty(value = "pssysbicubeid", notes = "智能报表立方体")
    private String psSysBiCubeId;

    /**
     * PSSYSBISCHEMEID
     */
    @DEField(name = "pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @JsonProperty("pssysbischemeid")
    @ApiModelProperty(value = "pssysbischemeid", notes = "PSSYSBISCHEMEID")
    private String psSysBiSchemeId;

    /**
     * 智能报表立方体
     */
    @DEField(name = "pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @JsonProperty("pssysbicubename")
    @ApiModelProperty(value = "pssysbicubename", notes = "智能报表立方体")
    private String psSysBiCubeName;

    /**
     * 代码名称
     */
    @DEField(name = "codename" , defaultValue = "Dimension" , defaultValueType = DEFieldDefaultValueType.USER)
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 代码表
     */
    @DEField(name = "pscodelistname")
    @JSONField(name = "pscodelistname")
    @JsonProperty("pscodelistname")
    @ApiModelProperty(value = "pscodelistname", notes = "代码表")
    private String psCodeListName;

    /**
     * 代码表
     */
    @DEField(name = "pscodelistid")
    @JSONField(name = "pscodelistid")
    @JsonProperty("pscodelistid")
    @ApiModelProperty(value = "pscodelistid", notes = "代码表")
    private String psCodeListId;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
    * 设置 [扩展模型]
    */
    public PSSysBICubeDimension setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
    * 设置 [立方体维度名称]
    */
    public PSSysBICubeDimension setPsSysBiCubeDimensionName(String psSysBiCubeDimensionName) {
        this.psSysBiCubeDimensionName = psSysBiCubeDimensionName;
        this.modify("pssysbicubedimensionname", psSysBiCubeDimensionName);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public PSSysBICubeDimension setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [维度公式]
    */
    public PSSysBICubeDimension setDimensionFormula(String dimensionFormula) {
        this.dimensionFormula = dimensionFormula;
        this.modify("dimensionformula", dimensionFormula);
        return this;
    }

    /**
    * 设置 [维度类型]
    */
    public PSSysBICubeDimension setBiDimensionType(String biDimensionType) {
        this.biDimensionType = biDimensionType;
        this.modify("bidimensiontype", biDimensionType);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBICubeDimension setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
    * 设置 [PSSYSBISCHEMEID]
    */
    public PSSysBICubeDimension setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBICubeDimension setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSSysBICubeDimension setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [代码表]
    */
    public PSSysBICubeDimension setPsCodeListName(String psCodeListName) {
        this.psCodeListName = psCodeListName;
        this.modify("pscodelistname", psCodeListName);
        return this;
    }

    /**
    * 设置 [代码表]
    */
    public PSSysBICubeDimension setPsCodeListId(String psCodeListId) {
        this.psCodeListId = psCodeListId;
        this.modify("pscodelistid", psCodeListId);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSSysBICubeDimension setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
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
            entity.reset("pssysbicubedimensionid");
        }
        return targetEntity;
    }

}