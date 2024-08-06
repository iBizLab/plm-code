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
import cn.ibizlab.plm.core.extension.domain.PSSysBIReportItem;

/**
 * 智能报表实体类[PSSysBIReport]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSSYSBIREPORT", description = "智能报表")
public class PSSysBIReport extends EntityBase implements Serializable
{
    /**
     * 智能报表项
     */
    @DEField(name = "pssysbireportitems")
    @JSONField(name = "pssysbireportitems")
    @JsonProperty("pssysbireportitems")
    @ApiModelProperty(value = "pssysbireportitems", notes = "智能报表项")
    private List<PSSysBIReportItem> psSysBiReportItems;

    /**
     * 智能报表标识
     */
    @Id
    @DEField(name = "pssysbireportid" , isKeyField = true)
    @JSONField(name = "pssysbireportid")
    @JsonProperty("pssysbireportid")
    @ApiModelProperty(value = "pssysbireportid", notes = "智能报表标识")
    private String psSysBiReportId;

    /**
     * 智能报表名称
     */
    @DEField(name = "pssysbireportname")
    @JSONField(name = "pssysbireportname")
    @JsonProperty("pssysbireportname")
    @ApiModelProperty(value = "pssysbireportname", notes = "智能报表名称")
    private String psSysBiReportName;

    /**
     * 代码名称
     */
    @DEField(name = "codename")
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
     * 报表界面模型
     */
    @DEField(name = "bireportuimodel")
    @JSONField(name = "bireportuimodel")
    @JsonProperty("bireportuimodel")
    @ApiModelProperty(value = "bireportuimodel", notes = "报表界面模型")
    private String biReportUiModel;

    /**
     * 报表模型
     */
    @DEField(name = "bireportmodel")
    @JSONField(name = "bireportmodel")
    @JsonProperty("bireportmodel")
    @ApiModelProperty(value = "bireportmodel", notes = "报表模型")
    private String biReportModel;

    /**
     * 报表标记
     */
    @DEField(name = "bireporttag")
    @JSONField(name = "bireporttag")
    @JsonProperty("bireporttag")
    @ApiModelProperty(value = "bireporttag", notes = "报表标记")
    private String biReportTag;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 报表标记2
     */
    @DEField(name = "bireporttag2")
    @JSONField(name = "bireporttag2")
    @JsonProperty("bireporttag2")
    @ApiModelProperty(value = "bireporttag2", notes = "报表标记2")
    private String biReportTag2;

    /**
     * 智能报表体系
     */
    @DEField(name = "pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @JsonProperty("pssysbischemeid")
    @ApiModelProperty(value = "pssysbischemeid", notes = "智能报表体系")
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
     * 智能报表立方体
     */
    @DEField(name = "pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @JsonProperty("pssysbicubename")
    @ApiModelProperty(value = "pssysbicubename", notes = "智能报表立方体")
    private String psSysBiCubeName;

    /**
     * 智能报表体系
     */
    @DEField(name = "pssysbischemename")
    @JSONField(name = "pssysbischemename")
    @JsonProperty("pssysbischemename")
    @ApiModelProperty(value = "pssysbischemename", notes = "智能报表体系")
    private String psSysBiSchemeName;

    /**
    * 设置 [智能报表项]
    */
    public PSSysBIReport setPsSysBiReportItems(List<PSSysBIReportItem> psSysBiReportItems) {
        this.psSysBiReportItems = psSysBiReportItems;
        this.modify("pssysbireportitems", psSysBiReportItems);
        return this;
    }

    /**
    * 设置 [智能报表名称]
    */
    public PSSysBIReport setPsSysBiReportName(String psSysBiReportName) {
        this.psSysBiReportName = psSysBiReportName;
        this.modify("pssysbireportname", psSysBiReportName);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSSysBIReport setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public PSSysBIReport setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [报表界面模型]
    */
    public PSSysBIReport setBiReportUiModel(String biReportUiModel) {
        this.biReportUiModel = biReportUiModel;
        this.modify("bireportuimodel", biReportUiModel);
        return this;
    }

    /**
    * 设置 [报表模型]
    */
    public PSSysBIReport setBiReportModel(String biReportModel) {
        this.biReportModel = biReportModel;
        this.modify("bireportmodel", biReportModel);
        return this;
    }

    /**
    * 设置 [报表标记]
    */
    public PSSysBIReport setBiReportTag(String biReportTag) {
        this.biReportTag = biReportTag;
        this.modify("bireporttag", biReportTag);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSSysBIReport setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [报表标记2]
    */
    public PSSysBIReport setBiReportTag2(String biReportTag2) {
        this.biReportTag2 = biReportTag2;
        this.modify("bireporttag2", biReportTag2);
        return this;
    }

    /**
    * 设置 [智能报表体系]
    */
    public PSSysBIReport setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBIReport setPsSysBiCubeId(String psSysBiCubeId) {
        this.psSysBiCubeId = psSysBiCubeId;
        this.modify("pssysbicubeid", psSysBiCubeId);
        return this;
    }

    /**
    * 设置 [智能报表立方体]
    */
    public PSSysBIReport setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
    * 设置 [智能报表体系]
    */
    public PSSysBIReport setPsSysBiSchemeName(String psSysBiSchemeName) {
        this.psSysBiSchemeName = psSysBiSchemeName;
        this.modify("pssysbischemename", psSysBiSchemeName);
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
            entity.reset("pssysbireportid");
        }
        return targetEntity;
    }

}