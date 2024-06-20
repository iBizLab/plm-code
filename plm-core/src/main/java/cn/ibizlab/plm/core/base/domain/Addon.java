/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;

/**
 * 组件实体类[Addon]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "ADDON", resultMap = "AddonResultMap")
@ApiModel(value = "ADDON", description = "组件")
public class Addon extends EntityMP implements Serializable
{

    /**
    * 组件类型
    */
    @TableField(value = "addon_type")
    @DEField(name = "addon_type")
    @JSONField(name = "addon_type")
    @JsonProperty("addon_type")
    @ApiModelProperty(value = "addon_type", notes = "组件类型")
    private String addonType;

    /**
    * 所属类型
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属类型")
    private String ownerType;

    /**
    * 所属子类型
    */
    @TableField(value = "owner_subtype")
    @DEField(name = "owner_subtype")
    @JSONField(name = "owner_subtype")
    @JsonProperty("owner_subtype")
    @ApiModelProperty(value = "owner_subtype", notes = "所属子类型")
    private String ownerSubtype;

    /**
    * 所属标识
    */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id" , preType = DEPredefinedFieldType.PARENTID)
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属标识")
    private String ownerId;

    /**
    * 配置模型
    */
    @TableField(value = "setting_model")
    @DEField(name = "setting_model")
    @JSONField(name = "setting_model")
    @JsonProperty("setting_model")
    @ApiModelProperty(value = "setting_model", notes = "配置模型")
    private String settingModel;

    /**
    * 启用
    */
    @TableField(value = "is_enabled")
    @DEField(name = "is_enabled" , dict = "YesNo")
    @JSONField(name = "is_enabled")
    @JsonProperty("is_enabled")
    @ApiModelProperty(value = "is_enabled", notes = "启用")
    private Integer isEnabled;

    /**
    * 描述
    */
    @TableField(value = "description")
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
    * 排序
    */
    @TableField(value = "order_value")
    @DEField(name = "order_value" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "order_value")
    @JsonProperty("order_value")
    @ApiModelProperty(value = "order_value", notes = "排序")
    private Integer orderValue;

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
    * 测试库-组件
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "library", notes = "测试库-组件")
    private Library library;

    /**
    * 项目集-组件
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "portfolio", notes = "项目集-组件")
    private Portfolio portfolio;

    /**
    * 产品-组件
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "product", notes = "产品-组件")
    private Product product;

    /**
    * 项目-组件
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "项目-组件")
    private Project project;

    /**
    * 空间-组件
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "space", notes = "空间-组件")
    private Space space;

    /**
    * 组件-权限成员
    */
    @Transient
    @TableField(exist = false)
    @JSONField(name = "addon_role_members")
    @JsonProperty("addon_role_members")
    @ApiModelProperty(value = "addon_role_members", notes = "组件-权限成员")
    private List<AddonRoleMember> addonRoleMembers;

    /**
    * 设置 [组件类型]
    */
    public Addon setAddonType(String addonType) {
        this.addonType = addonType;
        this.modify("addon_type", addonType);
        return this;
    }

    /**
    * 设置 [所属子类型]
    */
    public Addon setOwnerSubtype(String ownerSubtype) {
        this.ownerSubtype = ownerSubtype;
        this.modify("owner_subtype", ownerSubtype);
        return this;
    }

    /**
    * 设置 [配置模型]
    */
    public Addon setSettingModel(String settingModel) {
        this.settingModel = settingModel;
        this.modify("setting_model", settingModel);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public Addon setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
        this.modify("is_enabled", isEnabled);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Addon setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Addon setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getAddonType(),"未设置组件类型");
        //Assert.notNull(getOwnerType(),"未设置所属类型");
        //Assert.notNull(getOwnerSubtype(),"未设置所属子类型");
        //Assert.notNull(getOwnerId(),"未设置所属标识");
        String key = String.format("%s||%s||%s||%s"
            ,getAddonType(),getOwnerType(),getOwnerSubtype(),getOwnerId());
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