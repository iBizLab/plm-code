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
 * 智能报表立方体[PSSysBICubeDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表立方体DTO")
public class PSSysBICubeDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 立方体标记
     */
    @JsonProperty("bicubetag")
    @JSONField(name = "bicubetag")
    @ApiModelProperty(value = "立方体标记", position = 0)
    private String biCubeTag;

    /**
     * 立方体标记2
     */
    @JsonProperty("bicubetag2")
    @JSONField(name = "bicubetag2")
    @ApiModelProperty(value = "立方体标记2", position = 1)
    private String biCubeTag2;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 2)
    private String codeName;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 3)
    private String memo;

    /**
     * 立方体实体
     */
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "立方体实体", position = 4)
    private String psdeid;

    /**
     * 立方体实体
     */
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "立方体实体", position = 5)
    private String psdeName;

    /**
     * 智能报表立方体标识
     */
    @JsonProperty("pssysbicubeid")
    @JSONField(name = "pssysbicubeid")
    @ApiModelProperty(value = "智能报表立方体标识", position = 6)
    private String psSysBiCubeId;

    /**
     * 立方体名称
     */
    @JsonProperty("pssysbicubename")
    @JSONField(name = "pssysbicubename")
    @ApiModelProperty(value = "立方体名称", position = 7)
    private String psSysBiCubeName;

    /**
     * 智能报表体系
     */
    @JsonProperty("pssysbischemeid")
    @JSONField(name = "pssysbischemeid")
    @ApiModelProperty(value = "智能报表体系", position = 8)
    private String psSysBiSchemeId;

    /**
     * 智能报表体系
     */
    @JsonProperty("pssysbischemename")
    @JSONField(name = "pssysbischemename")
    @ApiModelProperty(value = "智能报表体系", position = 9)
    private String psSysBiSchemeName;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 10)
    private Integer validFlag;


    /**
     * 设置 [立方体标记]
     */
    public PSSysBICubeDTO setBiCubeTag(String biCubeTag) {
        this.biCubeTag = biCubeTag;
        this.modify("bicubetag", biCubeTag);
        return this;
    }

    /**
     * 设置 [立方体标记2]
     */
    public PSSysBICubeDTO setBiCubeTag2(String biCubeTag2) {
        this.biCubeTag2 = biCubeTag2;
        this.modify("bicubetag2", biCubeTag2);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSSysBICubeDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSSysBICubeDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [立方体实体]
     */
    public PSSysBICubeDTO setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
     * 设置 [立方体实体]
     */
    public PSSysBICubeDTO setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
     * 设置 [立方体名称]
     */
    public PSSysBICubeDTO setPsSysBiCubeName(String psSysBiCubeName) {
        this.psSysBiCubeName = psSysBiCubeName;
        this.modify("pssysbicubename", psSysBiCubeName);
        return this;
    }

    /**
     * 设置 [智能报表体系]
     */
    public PSSysBICubeDTO setPsSysBiSchemeId(String psSysBiSchemeId) {
        this.psSysBiSchemeId = psSysBiSchemeId;
        this.modify("pssysbischemeid", psSysBiSchemeId);
        return this;
    }

    /**
     * 设置 [智能报表体系]
     */
    public PSSysBICubeDTO setPsSysBiSchemeName(String psSysBiSchemeName) {
        this.psSysBiSchemeName = psSysBiSchemeName;
        this.modify("pssysbischemename", psSysBiSchemeName);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public PSSysBICubeDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }


}
