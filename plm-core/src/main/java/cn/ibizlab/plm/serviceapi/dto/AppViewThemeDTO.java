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
 * 应用视图主题[AppViewThemeDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("应用视图主题DTO")
public class AppViewThemeDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 启用标记
     */
    @JsonProperty("valid_flag")
    @JSONField(name = "valid_flag")
    @ApiModelProperty(value = "启用标记", position = 0)
    private Integer validFlag;

    /**
     * 主题模型
     */
    @JsonProperty("theme_model")
    @JSONField(name = "theme_model")
    @ApiModelProperty(value = "主题模型", position = 1)
    private String themeModel;

    /**
     * 所有者类型
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所有者类型", position = 2)
    private String ownerType;

    /**
     * 标题
     */
    @JsonProperty("caption")
    @JSONField(name = "caption")
    @ApiModelProperty(value = "标题", position = 3)
    private String caption;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 4)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 5)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 6)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 7)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 8)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 9)
    private Date updateTime;

    /**
     * 系统标记
     */
    @JsonProperty("system_tag")
    @JSONField(name = "system_tag")
    @ApiModelProperty(value = "系统标记", position = 10)
    private String systemTag;

    /**
     * 应用标记
     */
    @JsonProperty("app_tag")
    @JSONField(name = "app_tag")
    @ApiModelProperty(value = "应用标记", position = 11)
    private String appTag;

    /**
     * 应用视图标记
     */
    @JsonProperty("app_view_tag")
    @JSONField(name = "app_view_tag")
    @ApiModelProperty(value = "应用视图标记", position = 12)
    private String appViewTag;

    /**
     * 排序值
     */
    @JsonProperty("order_value")
    @JSONField(name = "order_value")
    @ApiModelProperty(value = "排序值", position = 13)
    private Integer orderValue;


    /**
     * 设置 [启用标记]
     */
    public AppViewThemeDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("valid_flag", validFlag);
        return this;
    }

    /**
     * 设置 [主题模型]
     */
    public AppViewThemeDTO setThemeModel(String themeModel) {
        this.themeModel = themeModel;
        this.modify("theme_model", themeModel);
        return this;
    }

    /**
     * 设置 [所有者类型]
     */
    public AppViewThemeDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public AppViewThemeDTO setCaption(String caption) {
        this.caption = caption;
        this.modify("caption", caption);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public AppViewThemeDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [系统标记]
     */
    public AppViewThemeDTO setSystemTag(String systemTag) {
        this.systemTag = systemTag;
        this.modify("system_tag", systemTag);
        return this;
    }

    /**
     * 设置 [应用标记]
     */
    public AppViewThemeDTO setAppTag(String appTag) {
        this.appTag = appTag;
        this.modify("app_tag", appTag);
        return this;
    }

    /**
     * 设置 [应用视图标记]
     */
    public AppViewThemeDTO setAppViewTag(String appViewTag) {
        this.appViewTag = appViewTag;
        this.modify("app_view_tag", appViewTag);
        return this;
    }

    /**
     * 设置 [排序值]
     */
    public AppViewThemeDTO setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
        this.modify("order_value", orderValue);
        return this;
    }


}
