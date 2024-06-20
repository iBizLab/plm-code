/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import java.math.BigDecimal;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 扩展存储实体类[ExtendStorage]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "EXTEND_STORAGE", resultMap = "ExtendStorageResultMap")
@ApiModel(value = "EXTEND_STORAGE", description = "扩展存储")
public class ExtendStorage extends EntityMP implements Serializable
{

    /**
    * 所属数据标识
    */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id" , preType = DEPredefinedFieldType.PARENTID)
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
    * 所属数据对象
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
    * 文本值
    */
    @TableField(value = "string_value")
    @DEField(name = "string_value")
    @JSONField(name = "string_value")
    @JsonProperty("string_value")
    @ApiModelProperty(value = "string_value", notes = "文本值")
    private String stringValue;

    /**
    * 长文本值
    */
    @TableField(value = "longstring_value")
    @DEField(name = "longstring_value")
    @JSONField(name = "longstring_value")
    @JsonProperty("longstring_value")
    @ApiModelProperty(value = "longstring_value", notes = "长文本值")
    private String longstringValue;

    /**
    * 浮点值
    */
    @TableField(value = "double_value")
    @DEField(name = "double_value")
    @JSONField(name = "double_value")
    @JsonProperty("double_value")
    @ApiModelProperty(value = "double_value", notes = "浮点值")
    private BigDecimal doubleValue;

    /**
    * 时间值
    */
    @TableField(value = "datetime_value")
    @DEField(name = "datetime_value")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "datetime_value" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("datetime_value")
    @ApiModelProperty(value = "datetime_value", notes = "时间值")
    private Date datetimeValue;

    /**
    * 数值值
    */
    @TableField(value = "decimal_value")
    @DEField(name = "decimal_value")
    @JSONField(name = "decimal_value")
    @JsonProperty("decimal_value")
    @ApiModelProperty(value = "decimal_value", notes = "数值值")
    private BigDecimal decimalValue;

    /**
    * 整形值
    */
    @TableField(value = "int_value")
    @DEField(name = "int_value")
    @JSONField(name = "int_value")
    @JsonProperty("int_value")
    @ApiModelProperty(value = "int_value", notes = "整形值")
    private Integer intValue;

    /**
    * 大整形值
    */
    @TableField(value = "bigint_value")
    @DEField(name = "bigint_value")
    @JSONField(name = "bigint_value")
    @JsonProperty("bigint_value")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "bigint_value", notes = "大整形值")
    private Long bigintValue;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 设置 [文本值]
    */
    public ExtendStorage setStringValue(String stringValue) {
        this.stringValue = stringValue;
        this.modify("string_value", stringValue);
        return this;
    }

    /**
    * 设置 [长文本值]
    */
    public ExtendStorage setLongstringValue(String longstringValue) {
        this.longstringValue = longstringValue;
        this.modify("longstring_value", longstringValue);
        return this;
    }

    /**
    * 设置 [浮点值]
    */
    public ExtendStorage setDoubleValue(BigDecimal doubleValue) {
        this.doubleValue = doubleValue;
        this.modify("double_value", doubleValue);
        return this;
    }

    /**
    * 设置 [时间值]
    */
    public ExtendStorage setDatetimeValue(Date datetimeValue) {
        this.datetimeValue = datetimeValue;
        this.modify("datetime_value", datetimeValue);
        return this;
    }

    /**
    * 设置 [数值值]
    */
    public ExtendStorage setDecimalValue(BigDecimal decimalValue) {
        this.decimalValue = decimalValue;
        this.modify("decimal_value", decimalValue);
        return this;
    }

    /**
    * 设置 [整形值]
    */
    public ExtendStorage setIntValue(Integer intValue) {
        this.intValue = intValue;
        this.modify("int_value", intValue);
        return this;
    }

    /**
    * 设置 [大整形值]
    */
    public ExtendStorage setBigintValue(Long bigintValue) {
        this.bigintValue = bigintValue;
        this.modify("bigint_value", bigintValue);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public ExtendStorage setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getOwnerType(),"未设置所属数据对象");
        //Assert.notNull(getOwnerId(),"未设置所属数据标识");
        //Assert.notNull(getName(),"未设置名称");
        String key = String.format("%s||%s||%s"
            ,getOwnerType(),getOwnerId(),getName());
        key = DigestUtils.md5DigestAsHex(key.getBytes());
        return key;
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
            entity.reset("id");
        }
        return targetEntity;
    }

}