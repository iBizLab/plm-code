/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
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
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 实体属性标识
     */
    @Id
    @DEField(name = "psdefieldid" , isKeyField = true)
    @JsonProperty("psdefieldid")
    @JSONField(name = "psdefieldid")
    @ApiModelProperty(value = "psdefieldid", notes = "实体属性标识")
    private String psdeFieldId;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 实体属性名称
     */
    @DEField(name = "psdefieldname")
    @JsonProperty("psdefieldname")
    @JSONField(name = "psdefieldname")
    @ApiModelProperty(value = "psdefieldname", notes = "实体属性名称")
    private String psdeFieldName;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 数据类型
     */
    @DEField(name = "psdatatypeid" , dict = "field_data_type")
    @JsonProperty("psdatatypeid")
    @JSONField(name = "psdatatypeid")
    @ApiModelProperty(value = "psdatatypeid", notes = "数据类型")
    private String psDataTypeId;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 数据类型
     */
    @DEField(name = "psdatatypename" , dict = "field_data_type")
    @JsonProperty("psdatatypename")
    @JSONField(name = "psdatatypename")
    @ApiModelProperty(value = "psdatatypename", notes = "数据类型")
    private String psDataTypeName;

    /**
     * 属性类型
     */
    @DEField(name = "deftype" , dict = "field_type")
    @JsonProperty("deftype")
    @JSONField(name = "deftype")
    @ApiModelProperty(value = "deftype", notes = "属性类型")
    private Integer defType;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 允许空值
     */
    @DEField(name = "allowempty" , dict = "YesNo")
    @JsonProperty("allowempty")
    @JSONField(name = "allowempty")
    @ApiModelProperty(value = "allowempty", notes = "允许空值")
    private Integer allowEmpty;

    /**
     * 长度
     */
    @DEField(name = "length")
    @JsonProperty("length")
    @JSONField(name = "length")
    @ApiModelProperty(value = "length", notes = "长度")
    private Integer length;

    /**
     * 浮点精度
     */
    @DEField(name = "precision2")
    @JsonProperty("precision2")
    @JSONField(name = "precision2")
    @ApiModelProperty(value = "precision2", notes = "浮点精度")
    private Integer precision2;

    /**
     * 代码名称
     */
    @DEField(name = "codename")
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 中文名称
     */
    @DEField(name = "logicname")
    @JsonProperty("logicname")
    @JSONField(name = "logicname")
    @ApiModelProperty(value = "logicname", notes = "中文名称")
    private String logicName;

    /**
     * 扩展标记
     */
    @DEField(name = "extension_tag")
    @JsonProperty("extension_tag")
    @JSONField(name = "extension_tag")
    @ApiModelProperty(value = "extension_tag", notes = "扩展标记")
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @DEField(name = "extension_tag2")
    @JsonProperty("extension_tag2")
    @JSONField(name = "extension_tag2")
    @ApiModelProperty(value = "extension_tag2", notes = "扩展标记2")
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @DEField(name = "extension_tag3")
    @JsonProperty("extension_tag3")
    @JSONField(name = "extension_tag3")
    @ApiModelProperty(value = "extension_tag3", notes = "扩展标记3")
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @DEField(name = "extension_tag4")
    @JsonProperty("extension_tag4")
    @JSONField(name = "extension_tag4")
    @ApiModelProperty(value = "extension_tag4", notes = "扩展标记4")
    private String extensionTag4;


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