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
 * 实体属性实体类[PSDEField]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDEFIELD", description = "实体属性")
public class PSDEField extends EntityBase implements Serializable
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
     * 实体属性标识
     */
    @Id
    @DEField(name = "psdefieldid" , isKeyField = true)
    @JSONField(name = "psdefieldid")
    @JsonProperty("psdefieldid")
    @ApiModelProperty(value = "psdefieldid", notes = "实体属性标识")
    private String psdeFieldId;

    /**
     * 实体属性名称
     */
    @DEField(name = "psdefieldname")
    @JSONField(name = "psdefieldname")
    @JsonProperty("psdefieldname")
    @ApiModelProperty(value = "psdefieldname", notes = "实体属性名称")
    private String psdeFieldName;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 数据类型
     */
    @DEField(name = "psdatatypeid" , dict = "field_data_type")
    @JSONField(name = "psdatatypeid")
    @JsonProperty("psdatatypeid")
    @ApiModelProperty(value = "psdatatypeid", notes = "数据类型")
    private String psDataTypeId;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JSONField(name = "psdeid")
    @JsonProperty("psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 数据类型
     */
    @DEField(name = "psdatatypename" , dict = "field_data_type")
    @JSONField(name = "psdatatypename")
    @JsonProperty("psdatatypename")
    @ApiModelProperty(value = "psdatatypename", notes = "数据类型")
    private String psDataTypeName;

    /**
     * 属性类型
     */
    @DEField(name = "deftype" , dict = "field_type")
    @JSONField(name = "deftype")
    @JsonProperty("deftype")
    @ApiModelProperty(value = "deftype", notes = "属性类型")
    private Integer defType;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JSONField(name = "psdename")
    @JsonProperty("psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 允许空值
     */
    @DEField(name = "allowempty" , dict = "YesNo")
    @JSONField(name = "allowempty")
    @JsonProperty("allowempty")
    @ApiModelProperty(value = "allowempty", notes = "允许空值")
    private Integer allowEmpty;

    /**
     * 长度
     */
    @DEField(name = "length")
    @JSONField(name = "length")
    @JsonProperty("length")
    @ApiModelProperty(value = "length", notes = "长度")
    private Integer length;

    /**
     * 浮点精度
     */
    @DEField(name = "precision2")
    @JSONField(name = "precision2")
    @JsonProperty("precision2")
    @ApiModelProperty(value = "precision2", notes = "浮点精度")
    private Integer precision2;

    /**
     * 代码名称
     */
    @DEField(name = "codename")
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 中文名称
     */
    @DEField(name = "logicname")
    @JSONField(name = "logicname")
    @JsonProperty("logicname")
    @ApiModelProperty(value = "logicname", notes = "中文名称")
    private String logicName;

    /**
     * 属性标记2
     */
    @DEField(name = "fieldtag2")
    @JSONField(name = "fieldtag2")
    @JsonProperty("fieldtag2")
    @ApiModelProperty(value = "fieldtag2", notes = "属性标记2")
    private String fieldTag2;

    /**
     * 属性标记
     */
    @DEField(name = "fieldtag")
    @JSONField(name = "fieldtag")
    @JsonProperty("fieldtag")
    @ApiModelProperty(value = "fieldtag", notes = "属性标记")
    private String fieldTag;

    /**
     * 用户标记2
     */
    @DEField(name = "usertag2")
    @JSONField(name = "usertag2")
    @JsonProperty("usertag2")
    @ApiModelProperty(value = "usertag2", notes = "用户标记2")
    private String userTag2;

    /**
     * 用户标记3
     */
    @DEField(name = "usertag3")
    @JSONField(name = "usertag3")
    @JsonProperty("usertag3")
    @ApiModelProperty(value = "usertag3", notes = "用户标记3")
    private String userTag3;

    /**
     * 用户标记
     */
    @DEField(name = "usertag")
    @JSONField(name = "usertag")
    @JsonProperty("usertag")
    @ApiModelProperty(value = "usertag", notes = "用户标记")
    private String userTag;

    /**
     * 用户标记4
     */
    @DEField(name = "usertag4")
    @JSONField(name = "usertag4")
    @JsonProperty("usertag4")
    @ApiModelProperty(value = "usertag4", notes = "用户标记4")
    private String userTag4;

    /**
     * 扩展标记
     */
    @DEField(name = "extension_tag")
    @JSONField(name = "extension_tag")
    @JsonProperty("extension_tag")
    @ApiModelProperty(value = "extension_tag", notes = "扩展标记")
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @DEField(name = "extension_tag2")
    @JSONField(name = "extension_tag2")
    @JsonProperty("extension_tag2")
    @ApiModelProperty(value = "extension_tag2", notes = "扩展标记2")
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @DEField(name = "extension_tag3")
    @JSONField(name = "extension_tag3")
    @JsonProperty("extension_tag3")
    @ApiModelProperty(value = "extension_tag3", notes = "扩展标记3")
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @DEField(name = "extension_tag4")
    @JSONField(name = "extension_tag4")
    @JsonProperty("extension_tag4")
    @ApiModelProperty(value = "extension_tag4", notes = "扩展标记4")
    private String extensionTag4;

    /**
    * 设置 [扩展模型]
    */
    public PSDEField setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
    * 设置 [实体属性名称]
    */
    public PSDEField setPsdeFieldName(String psdeFieldName) {
        this.psdeFieldName = psdeFieldName;
        this.modify("psdefieldname", psdeFieldName);
        return this;
    }

    /**
    * 设置 [数据类型]
    */
    public PSDEField setPsDataTypeId(String psDataTypeId) {
        this.psDataTypeId = psDataTypeId;
        this.modify("psdatatypeid", psDataTypeId);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDEField setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
    * 设置 [数据类型]
    */
    public PSDEField setPsDataTypeName(String psDataTypeName) {
        this.psDataTypeName = psDataTypeName;
        this.modify("psdatatypename", psDataTypeName);
        return this;
    }

    /**
    * 设置 [属性类型]
    */
    public PSDEField setDefType(Integer defType) {
        this.defType = defType;
        this.modify("deftype", defType);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDEField setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
    * 设置 [允许空值]
    */
    public PSDEField setAllowEmpty(Integer allowEmpty) {
        this.allowEmpty = allowEmpty;
        this.modify("allowempty", allowEmpty);
        return this;
    }

    /**
    * 设置 [长度]
    */
    public PSDEField setLength(Integer length) {
        this.length = length;
        this.modify("length", length);
        return this;
    }

    /**
    * 设置 [浮点精度]
    */
    public PSDEField setPrecision2(Integer precision2) {
        this.precision2 = precision2;
        this.modify("precision2", precision2);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSDEField setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [中文名称]
    */
    public PSDEField setLogicName(String logicName) {
        this.logicName = logicName;
        this.modify("logicname", logicName);
        return this;
    }

    /**
    * 设置 [属性标记2]
    */
    public PSDEField setFieldTag2(String fieldTag2) {
        this.fieldTag2 = fieldTag2;
        this.modify("fieldtag2", fieldTag2);
        return this;
    }

    /**
    * 设置 [属性标记]
    */
    public PSDEField setFieldTag(String fieldTag) {
        this.fieldTag = fieldTag;
        this.modify("fieldtag", fieldTag);
        return this;
    }

    /**
    * 设置 [用户标记2]
    */
    public PSDEField setUserTag2(String userTag2) {
        this.userTag2 = userTag2;
        this.modify("usertag2", userTag2);
        return this;
    }

    /**
    * 设置 [用户标记3]
    */
    public PSDEField setUserTag3(String userTag3) {
        this.userTag3 = userTag3;
        this.modify("usertag3", userTag3);
        return this;
    }

    /**
    * 设置 [用户标记]
    */
    public PSDEField setUserTag(String userTag) {
        this.userTag = userTag;
        this.modify("usertag", userTag);
        return this;
    }

    /**
    * 设置 [用户标记4]
    */
    public PSDEField setUserTag4(String userTag4) {
        this.userTag4 = userTag4;
        this.modify("usertag4", userTag4);
        return this;
    }

    /**
    * 设置 [扩展标记]
    */
    public PSDEField setExtensionTag(String extensionTag) {
        this.extensionTag = extensionTag;
        this.modify("extension_tag", extensionTag);
        return this;
    }

    /**
    * 设置 [扩展标记2]
    */
    public PSDEField setExtensionTag2(String extensionTag2) {
        this.extensionTag2 = extensionTag2;
        this.modify("extension_tag2", extensionTag2);
        return this;
    }

    /**
    * 设置 [扩展标记3]
    */
    public PSDEField setExtensionTag3(String extensionTag3) {
        this.extensionTag3 = extensionTag3;
        this.modify("extension_tag3", extensionTag3);
        return this;
    }

    /**
    * 设置 [扩展标记4]
    */
    public PSDEField setExtensionTag4(String extensionTag4) {
        this.extensionTag4 = extensionTag4;
        this.modify("extension_tag4", extensionTag4);
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
            entity.reset("psdefieldid");
        }
        return targetEntity;
    }

}