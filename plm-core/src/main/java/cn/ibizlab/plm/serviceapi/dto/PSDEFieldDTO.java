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
 * 实体属性[PSDEFieldDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体属性DTO")
public class PSDEFieldDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展模型
     */
    @JsonProperty("dynamodelflag")
    @JSONField(name = "dynamodelflag")
    @ApiModelProperty(value = "扩展模型", position = 0)
    private Integer dynaModelFlag;

    /**
     * 允许空值
     */
    @JsonProperty("allowempty")
    @JSONField(name = "allowempty")
    @ApiModelProperty(value = "允许空值", position = 1)
    private Integer allowEmpty;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 2)
    private String codeName;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 3)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 4)
    private String createMan;

    /**
     * 属性类型
     */
    @JsonProperty("deftype")
    @JSONField(name = "deftype")
    @ApiModelProperty(value = "属性类型", position = 5)
    private Integer defType;

    /**
     * 属性标记
     */
    @JsonProperty("fieldtag")
    @JSONField(name = "fieldtag")
    @ApiModelProperty(value = "属性标记", position = 6)
    private String fieldTag;

    /**
     * 属性标记2
     */
    @JsonProperty("fieldtag2")
    @JSONField(name = "fieldtag2")
    @ApiModelProperty(value = "属性标记2", position = 7)
    private String fieldTag2;

    /**
     * 长度
     */
    @JsonProperty("length")
    @JSONField(name = "length")
    @ApiModelProperty(value = "长度", position = 8)
    private Integer length;

    /**
     * 中文名称
     */
    @JsonProperty("logicname")
    @JSONField(name = "logicname")
    @ApiModelProperty(value = "中文名称", position = 9)
    private String logicName;

    /**
     * 实体属性标识
     */
    @JsonProperty("psdefieldid")
    @JSONField(name = "psdefieldid")
    @ApiModelProperty(value = "实体属性标识", position = 10)
    private String psdeFieldId;

    /**
     * 实体属性名称
     */
    @JsonProperty("psdefieldname")
    @JSONField(name = "psdefieldname")
    @ApiModelProperty(value = "实体属性名称", position = 11)
    private String psdeFieldName;

    /**
     * 实体
     */
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "实体", position = 12)
    private String psdeid;

    /**
     * 实体
     */
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "实体", position = 13)
    private String psdeName;

    /**
     * 数据类型
     */
    @JsonProperty("psdatatypeid")
    @JSONField(name = "psdatatypeid")
    @ApiModelProperty(value = "数据类型", position = 14)
    private String psDataTypeId;

    /**
     * 数据类型
     */
    @JsonProperty("psdatatypename")
    @JSONField(name = "psdatatypename")
    @ApiModelProperty(value = "数据类型", position = 15)
    private String psDataTypeName;

    /**
     * 浮点精度
     */
    @JsonProperty("precision2")
    @JSONField(name = "precision2")
    @ApiModelProperty(value = "浮点精度", position = 16)
    private Integer precision2;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 17)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 18)
    private String updateMan;

    /**
     * 用户标记
     */
    @JsonProperty("usertag")
    @JSONField(name = "usertag")
    @ApiModelProperty(value = "用户标记", position = 19)
    private String userTag;

    /**
     * 用户标记2
     */
    @JsonProperty("usertag2")
    @JSONField(name = "usertag2")
    @ApiModelProperty(value = "用户标记2", position = 20)
    private String userTag2;

    /**
     * 用户标记3
     */
    @JsonProperty("usertag3")
    @JSONField(name = "usertag3")
    @ApiModelProperty(value = "用户标记3", position = 21)
    private String userTag3;

    /**
     * 用户标记4
     */
    @JsonProperty("usertag4")
    @JSONField(name = "usertag4")
    @ApiModelProperty(value = "用户标记4", position = 22)
    private String userTag4;

    /**
     * 扩展标记
     */
    @JsonProperty("extension_tag")
    @JSONField(name = "extension_tag")
    @ApiModelProperty(value = "扩展标记", position = 23)
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @JsonProperty("extension_tag2")
    @JSONField(name = "extension_tag2")
    @ApiModelProperty(value = "扩展标记2", position = 24)
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @JsonProperty("extension_tag3")
    @JSONField(name = "extension_tag3")
    @ApiModelProperty(value = "扩展标记3", position = 25)
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @JsonProperty("extension_tag4")
    @JSONField(name = "extension_tag4")
    @ApiModelProperty(value = "扩展标记4", position = 26)
    private String extensionTag4;


    /**
     * 设置 [扩展模型]
     */
    public PSDEFieldDTO setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
     * 设置 [允许空值]
     */
    public PSDEFieldDTO setAllowEmpty(Integer allowEmpty) {
        this.allowEmpty = allowEmpty;
        this.modify("allowempty", allowEmpty);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSDEFieldDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [属性类型]
     */
    public PSDEFieldDTO setDefType(Integer defType) {
        this.defType = defType;
        this.modify("deftype", defType);
        return this;
    }

    /**
     * 设置 [属性标记]
     */
    public PSDEFieldDTO setFieldTag(String fieldTag) {
        this.fieldTag = fieldTag;
        this.modify("fieldtag", fieldTag);
        return this;
    }

    /**
     * 设置 [属性标记2]
     */
    public PSDEFieldDTO setFieldTag2(String fieldTag2) {
        this.fieldTag2 = fieldTag2;
        this.modify("fieldtag2", fieldTag2);
        return this;
    }

    /**
     * 设置 [长度]
     */
    public PSDEFieldDTO setLength(Integer length) {
        this.length = length;
        this.modify("length", length);
        return this;
    }

    /**
     * 设置 [中文名称]
     */
    public PSDEFieldDTO setLogicName(String logicName) {
        this.logicName = logicName;
        this.modify("logicname", logicName);
        return this;
    }

    /**
     * 设置 [实体属性名称]
     */
    public PSDEFieldDTO setPsdeFieldName(String psdeFieldName) {
        this.psdeFieldName = psdeFieldName;
        this.modify("psdefieldname", psdeFieldName);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDEFieldDTO setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDEFieldDTO setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
     * 设置 [数据类型]
     */
    public PSDEFieldDTO setPsDataTypeId(String psDataTypeId) {
        this.psDataTypeId = psDataTypeId;
        this.modify("psdatatypeid", psDataTypeId);
        return this;
    }

    /**
     * 设置 [数据类型]
     */
    public PSDEFieldDTO setPsDataTypeName(String psDataTypeName) {
        this.psDataTypeName = psDataTypeName;
        this.modify("psdatatypename", psDataTypeName);
        return this;
    }

    /**
     * 设置 [浮点精度]
     */
    public PSDEFieldDTO setPrecision2(Integer precision2) {
        this.precision2 = precision2;
        this.modify("precision2", precision2);
        return this;
    }

    /**
     * 设置 [用户标记]
     */
    public PSDEFieldDTO setUserTag(String userTag) {
        this.userTag = userTag;
        this.modify("usertag", userTag);
        return this;
    }

    /**
     * 设置 [用户标记2]
     */
    public PSDEFieldDTO setUserTag2(String userTag2) {
        this.userTag2 = userTag2;
        this.modify("usertag2", userTag2);
        return this;
    }

    /**
     * 设置 [用户标记3]
     */
    public PSDEFieldDTO setUserTag3(String userTag3) {
        this.userTag3 = userTag3;
        this.modify("usertag3", userTag3);
        return this;
    }

    /**
     * 设置 [用户标记4]
     */
    public PSDEFieldDTO setUserTag4(String userTag4) {
        this.userTag4 = userTag4;
        this.modify("usertag4", userTag4);
        return this;
    }

    /**
     * 设置 [扩展标记]
     */
    public PSDEFieldDTO setExtensionTag(String extensionTag) {
        this.extensionTag = extensionTag;
        this.modify("extension_tag", extensionTag);
        return this;
    }

    /**
     * 设置 [扩展标记2]
     */
    public PSDEFieldDTO setExtensionTag2(String extensionTag2) {
        this.extensionTag2 = extensionTag2;
        this.modify("extension_tag2", extensionTag2);
        return this;
    }

    /**
     * 设置 [扩展标记3]
     */
    public PSDEFieldDTO setExtensionTag3(String extensionTag3) {
        this.extensionTag3 = extensionTag3;
        this.modify("extension_tag3", extensionTag3);
        return this;
    }

    /**
     * 设置 [扩展标记4]
     */
    public PSDEFieldDTO setExtensionTag4(String extensionTag4) {
        this.extensionTag4 = extensionTag4;
        this.modify("extension_tag4", extensionTag4);
        return this;
    }


}
