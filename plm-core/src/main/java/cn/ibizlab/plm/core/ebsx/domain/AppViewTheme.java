/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.domain;

import java.util.*;
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
 * 应用视图主题实体类[AppViewTheme]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "APP_VIEW_THEME", resultMap = "AppViewThemeResultMap")
@ApiModel(value = "APP_VIEW_THEME", description = "应用视图主题")
public class AppViewTheme extends EntityMP implements Serializable
{

    /**
    * 启用标记
    */
    @TableField(value = "valid_flag")
    @DEField(name = "valid_flag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "valid_flag")
    @JsonProperty("valid_flag")
    @ApiModelProperty(value = "valid_flag", notes = "启用标记")
    private Integer validFlag;

    /**
    * 主题模型
    */
    @TableField(value = "theme_model")
    @DEField(name = "theme_model")
    @JSONField(name = "theme_model")
    @JsonProperty("theme_model")
    @ApiModelProperty(value = "theme_model", notes = "主题模型")
    private String themeModel;

    /**
    * 所有者类型
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , defaultValue = "PERSONAL")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所有者类型")
    private String ownerType;

    /**
    * 标题
    */
    @TableField(value = "caption")
    @DEField(name = "caption")
    @JSONField(name = "caption")
    @JsonProperty("caption")
    @ApiModelProperty(value = "caption", notes = "标题")
    private String caption;

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
    * 系统标记
    */
    @TableField(value = "system_tag")
    @DEField(name = "system_tag" , defaultValue = "srfdcsystemid" , defaultValueType = DEFieldDefaultValueType.SESSION)
    @JSONField(name = "system_tag")
    @JsonProperty("system_tag")
    @ApiModelProperty(value = "system_tag", notes = "系统标记")
    private String systemTag;

    /**
    * 应用视图标记
    */
    @TableField(value = "app_view_tag")
    @DEField(name = "app_view_tag")
    @JSONField(name = "app_view_tag")
    @JsonProperty("app_view_tag")
    @ApiModelProperty(value = "app_view_tag", notes = "应用视图标记")
    private String appViewTag;

    /**
    * 应用标记
    */
    @TableField(value = "app_tag")
    @DEField(name = "app_tag")
    @JSONField(name = "app_tag")
    @JsonProperty("app_tag")
    @ApiModelProperty(value = "app_tag", notes = "应用标记")
    private String appTag;

    /**
    * 排序值
    */
    @TableField(value = "order_value")
    @DEField(name = "order_value")
    @JSONField(name = "order_value")
    @JsonProperty("order_value")
    @ApiModelProperty(value = "order_value", notes = "排序值")
    private Integer orderValue;

    /**
    * 设置 [启用标记]
    */
    public AppViewTheme setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("valid_flag", validFlag);
        return this;
    }

    /**
    * 设置 [主题模型]
    */
    public AppViewTheme setThemeModel(String themeModel) {
        this.themeModel = themeModel;
        this.modify("theme_model", themeModel);
        return this;
    }

    /**
    * 设置 [所有者类型]
    */
    public AppViewTheme setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public AppViewTheme setCaption(String caption) {
        this.caption = caption;
        this.modify("caption", caption);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public AppViewTheme setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [系统标记]
    */
    public AppViewTheme setSystemTag(String systemTag) {
        this.systemTag = systemTag;
        this.modify("system_tag", systemTag);
        return this;
    }

    /**
    * 设置 [应用视图标记]
    */
    public AppViewTheme setAppViewTag(String appViewTag) {
        this.appViewTag = appViewTag;
        this.modify("app_view_tag", appViewTag);
        return this;
    }

    /**
    * 设置 [应用标记]
    */
    public AppViewTheme setAppTag(String appTag) {
        this.appTag = appTag;
        this.modify("app_tag", appTag);
        return this;
    }

    /**
    * 设置 [排序值]
    */
    public AppViewTheme setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
        this.modify("order_value", orderValue);
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
            entity.reset("id");
        }
        return targetEntity;
    }

}