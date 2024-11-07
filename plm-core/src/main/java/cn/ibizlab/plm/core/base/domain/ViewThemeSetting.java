/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

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
 * 视图主题设置实体类[ViewThemeSetting]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "VIEW_THEME_SETTING", description = "视图主题设置")
public class ViewThemeSetting extends EntityBase implements Serializable
{
    /**
     * 启用标记
     */
    @DEField(name = "valid_flag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "valid_flag")
    @JsonProperty("valid_flag")
    @ApiModelProperty(value = "valid_flag", notes = "启用标记")
    private Integer validFlag;

    /**
     * 主题模型
     */
    @DEField(name = "theme_model")
    @JSONField(name = "theme_model")
    @JsonProperty("theme_model")
    @ApiModelProperty(value = "theme_model", notes = "主题模型")
    private String themeModel;

    /**
     * 所有者类型
     */
    @DEField(name = "owner_type" , defaultValue = "PERSONAL")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所有者类型")
    private String ownerType;

    /**
     * 标题
     */
    @DEField(name = "caption")
    @JSONField(name = "caption")
    @JsonProperty("caption")
    @ApiModelProperty(value = "caption", notes = "标题")
    private String caption;

    /**
     * 过滤条件
     */
    @DEField(name = "search_conds")
    @JSONField(name = "search_conds")
    @JsonProperty("search_conds")
    @ApiModelProperty(value = "search_conds", notes = "过滤条件")
    private List<Map> searchConds;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 系统标记
     */
    @DEField(name = "system_tag" , defaultValue = "srfdcsystemid" , defaultValueType = DEFieldDefaultValueType.SESSION)
    @JSONField(name = "system_tag")
    @JsonProperty("system_tag")
    @ApiModelProperty(value = "system_tag", notes = "系统标记")
    private String systemTag;

    /**
     * 应用标记
     */
    @DEField(name = "app_tag")
    @JSONField(name = "app_tag")
    @JsonProperty("app_tag")
    @ApiModelProperty(value = "app_tag", notes = "应用标记")
    private String appTag;

    /**
     * 应用视图标记
     */
    @DEField(name = "app_view_tag")
    @JSONField(name = "app_view_tag")
    @JsonProperty("app_view_tag")
    @ApiModelProperty(value = "app_view_tag", notes = "应用视图标记")
    private String appViewTag;

    /**
     * 排序值
     */
    @DEField(name = "order_value")
    @JSONField(name = "order_value")
    @JsonProperty("order_value")
    @ApiModelProperty(value = "order_value", notes = "排序值")
    private Integer orderValue;

    /**
    * 设置 [启用标记]
    */
    public ViewThemeSetting setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("valid_flag", validFlag);
        return this;
    }

    /**
    * 设置 [主题模型]
    */
    public ViewThemeSetting setThemeModel(String themeModel) {
        this.themeModel = themeModel;
        this.modify("theme_model", themeModel);
        return this;
    }

    /**
    * 设置 [所有者类型]
    */
    public ViewThemeSetting setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public ViewThemeSetting setCaption(String caption) {
        this.caption = caption;
        this.modify("caption", caption);
        return this;
    }

    /**
    * 设置 [过滤条件]
    */
    public ViewThemeSetting setSearchConds(List<Map> searchConds) {
        this.searchConds = searchConds;
        this.modify("search_conds", searchConds);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public ViewThemeSetting setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [系统标记]
    */
    public ViewThemeSetting setSystemTag(String systemTag) {
        this.systemTag = systemTag;
        this.modify("system_tag", systemTag);
        return this;
    }

    /**
    * 设置 [应用标记]
    */
    public ViewThemeSetting setAppTag(String appTag) {
        this.appTag = appTag;
        this.modify("app_tag", appTag);
        return this;
    }

    /**
    * 设置 [应用视图标记]
    */
    public ViewThemeSetting setAppViewTag(String appViewTag) {
        this.appViewTag = appViewTag;
        this.modify("app_view_tag", appViewTag);
        return this;
    }

    /**
    * 设置 [排序值]
    */
    public ViewThemeSetting setOrderValue(Integer orderValue) {
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