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
 * 智能报表立方体实体类[PSSysBICube]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSSYSBICUBE", description = "智能报表立方体")
public class PSSysBICube extends EntityBase implements Serializable
{
    /**
     * 智能报表立方体标识
     */
    @Id
    @DEField(name = "pssysbicubeid" , isKeyField = true)
    @JSONField(name = "pssysbicubeid")
    @JsonProperty("pssysbicubeid")
    @ApiModelProperty(value = "pssysbicubeid", notes = "智能报表立方体标识")
    private String psSysBiCubeId;

    /**
     * 立方体名称
     */
    @DEField(name = "pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @JsonProperty("pssysbicubename")
    @ApiModelProperty(value = "pssysbicubename", notes = "立方体名称")
    private String psSysBiCubeName;

    /**
     * 启用
     */
    @DEField(name = "validflag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 代码名称
     */
    @DEField(name = "codename" , defaultValue = "Cube" , defaultValueType = DEFieldDefaultValueType.USER)
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 立方体实体
     */
    @DEField(name = "psdename")
    @JSONField(name = "psdename")
    @JsonProperty("psdename")
    @ApiModelProperty(value = "psdename", notes = "立方体实体")
    private String psdeName;

    /**
     * 立方体实体
     */
    @DEField(name = "psdeid")
    @JSONField(name = "psdeid")
    @JsonProperty("psdeid")
    @ApiModelProperty(value = "psdeid", notes = "立方体实体")
    private String psdeid;

    /**
     * 智能报表体系
     */
    @DEField(name = "pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @JsonProperty("pssysbischemeid")
    @ApiModelProperty(value = "pssysbischemeid", notes = "智能报表体系")
    private String psSysBiSchemeId;

    /**
     * 智能报表体系
     */
    @DEField(name = "pssysbischemename")
    @JSONField(name = "pssysbischemename")
    @JsonProperty("pssysbischemename")
    @ApiModelProperty(value = "pssysbischemename", notes = "智能报表体系")
    private String psSysBiSchemeName;

    /**
     * 立方体标记2
     */
    @DEField(name = "bicubetag2")
    @JSONField(name = "bicubetag2")
    @JsonProperty("bicubetag2")
    @ApiModelProperty(value = "bicubetag2", notes = "立方体标记2")
    private String biCubeTag2;

    /**
     * 立方体标记
     */
    @DEField(name = "bicubetag")
    @JSONField(name = "bicubetag")
    @JsonProperty("bicubetag")
    @ApiModelProperty(value = "bicubetag", notes = "立方体标记")
    private String biCubeTag;

    /**
    * 设置 [立方体名称]
    */
    public PSSysBICube setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public PSSysBICube setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSSysBICube setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSSysBICube setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [立方体实体]
    */
    public PSSysBICube setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
    * 设置 [立方体实体]
    */
    public PSSysBICube setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
    * 设置 [智能报表体系]
    */
    public PSSysBICube setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
    * 设置 [智能报表体系]
    */
    public PSSysBICube setPsSysBiSchemeName(String psSysBiSchemeName) {
        this.psSysBiSchemeName = psSysBiSchemeName;
        this.modify("pssysbischemename", psSysBiSchemeName);
        return this;
    }

    /**
    * 设置 [立方体标记2]
    */
    public PSSysBICube setBiCubeTag2(String biCubeTag2) {
        this.biCubeTag2 = biCubeTag2;
        this.modify("bicubetag2", biCubeTag2);
        return this;
    }

    /**
    * 设置 [立方体标记]
    */
    public PSSysBICube setBiCubeTag(String biCubeTag) {
        this.biCubeTag = biCubeTag;
        this.modify("bicubetag", biCubeTag);
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
            entity.reset("pssysbicubeid");
        }
        return targetEntity;
    }

}