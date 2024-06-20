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
import cn.ibizlab.plm.core.base.domain.Addon;

/**
 * 组件权限成员实体类[AddonRoleMember]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "ADDON_ROLE_MEMBER", resultMap = "AddonRoleMemberResultMap")
@ApiModel(value = "ADDON_ROLE_MEMBER", description = "组件权限成员")
public class AddonRoleMember extends EntityMP implements Serializable
{

    /**
    * 成员类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "member_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "成员类型")
    private Integer type;

    /**
    * 用户对象标识
    */
    @TableField(value = "user_obj_id")
    @DEField(name = "user_obj_id")
    @JSONField(name = "user_obj_id")
    @JsonProperty("user_obj_id")
    @ApiModelProperty(value = "user_obj_id", notes = "用户对象标识")
    private String userObjId;

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
    * 组件标识
    */
    @TableField(value = "addon_id")
    @DEField(name = "addon_id")
    @JSONField(name = "addon_id")
    @JsonProperty("addon_id")
    @ApiModelProperty(value = "addon_id", notes = "组件标识")
    private String addonId;

    /**
    * 组件-权限成员
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "addon", notes = "组件-权限成员")
    private Addon addon;

    /**
    * 设置 [成员类型]
    */
    public AddonRoleMember setType(Integer type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [用户对象标识]
    */
    public AddonRoleMember setUserObjId(String userObjId) {
        this.userObjId = userObjId;
        this.modify("user_obj_id", userObjId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public AddonRoleMember setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [组件标识]
    */
    public AddonRoleMember setAddonId(String addonId) {
        this.addonId = addonId;
        this.modify("addon_id", addonId);
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