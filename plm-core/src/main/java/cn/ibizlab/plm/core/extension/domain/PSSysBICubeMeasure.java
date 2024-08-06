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
 * 智能报表立方体指标实体类[PSSysBICubeMeasure]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSSYSBICUBEMEASURE", description = "智能报表立方体指标")
public class PSSysBICubeMeasure extends EntityBase implements Serializable
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
     * 智能报表指标标识
     */
    @Id
    @DEField(name = "pssysbicubemeasureid" , isKeyField = true)
    @JSONField(name = "pssysbicubemeasureid")
    @JsonProperty("pssysbicubemeasureid")
    @ApiModelProperty(value = "pssysbicubemeasureid", notes = "智能报表指标标识")
    private String psSysBiCubeMeasureId;

    /**
     * 立方体指标名称
     */
    @DEField(name = "pssysbicubemeasurename")
    @JSONField(name = "pssysbicubemeasurename")
    @JsonProperty("pssysbicubemeasurename")
    @ApiModelProperty(value = "pssysbicubemeasurename", notes = "立方体指标名称")
    private String psSysBiCubeMeasureName;

    /**
     * 代码名称
     */
    @DEField(name = "codename" , defaultValue = "Measure" , defaultValueType = DEFieldDefaultValueType.USER)
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 启用
     */
    @DEField(name = "validflag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 排序值
     */
    @DEField(name = "ordervalue" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    @ApiModelProperty(value = "ordervalue", notes = "排序值")
    private Integer orderValue;

    /**
     * 指标公式
     */
    @DEField(name = "measureformula")
    @JSONField(name = "measureformula")
    @JsonProperty("measureformula")
    @ApiModelProperty(value = "measureformula", notes = "指标公式")
    private String measureFormula;

    /**
     * 指标类型
     */
    @DEField(name = "bimeasuretype" , dict = "BIMeasureType")
    @JSONField(name = "bimeasuretype")
    @JsonProperty("bimeasuretype")
    @ApiModelProperty(value = "bimeasuretype", notes = "指标类型")
    private String biMeasureType;

    /**
     * 智能报表立方体
     */
    @DEField(name = "pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @JsonProperty("pssysbicubename")
    @ApiModelProperty(value = "pssysbicubename", notes = "智能报表立方体")
    private String psSysBiCubeName;

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
    @DEField(name = "pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @JsonProperty("pssysbicubeid")
    @ApiModelProperty(value = "pssysbicubeid", notes = "智能报表立方体")
    private String psSysBiCubeId;

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
    public PSSysBICubeMeasure setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
    * 设置 [立方体指标名称]
    */
    public PSSysBICubeMeasure setPsSysBiCubeMeasureName(String psSysBiCubeMeasureName) {
        this.psSysBiCubeMeasureName = psSysBiCubeMeasureName;
        this.modify("pssysbicubemeasurename", psSysBiCubeMeasureName);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSSysBICubeMeasure setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public PSSysBICubeMeasure setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [指标公式]
    */
    public PSSysBICubeMeasure setMeasureFormula(String measureFormula) {
        this.measureFormula = measureFormula;
        this.modify("measureformula", measureFormula);
        return this;
    }

    /**
    * 设置 [指标类型]
    */
    public PSSysBICubeMeasure setBiMeasureType(String biMeasureType) {
        this.biMeasureType = biMeasureType;
        this.modify("bimeasuretype", biMeasureType);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBICubeMeasure setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
    * 设置 [PSSYSBISCHEMEID]
    */
    public PSSysBICubeMeasure setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBICubeMeasure setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSSysBICubeMeasure setMemo(String memo) {
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
            entity.reset("pssysbicubemeasureid");
        }
        return targetEntity;
    }

}