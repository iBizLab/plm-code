/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.insight.domain;

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
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 效能成员实体类[InsightMember]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "MEMBER", resultMap = "InsightMemberResultMap")
@ApiModel(value = "INSIGHT_MEMBER", description = "效能成员")
public class InsightMember extends EntityMP implements Serializable
{

    /**
    * 所属数据对象
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , defaultValue = "INSIGHT")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
    * 所属对象子类型
    */
    @TableField(value = "owner_subtype")
    @DEField(name = "owner_subtype" , defaultValue = "INSIGHT")
    @JSONField(name = "owner_subtype")
    @JsonProperty("owner_subtype")
    @ApiModelProperty(value = "owner_subtype", notes = "所属对象子类型")
    private String ownerSubtype;

    /**
    * 角色
    */
    @TableField(value = "role_id")
    @DEField(name = "role_id" , defaultValue = "user" , dict = "role_type")
    @JSONField(name = "role_id")
    @JsonProperty("role_id")
    @ApiModelProperty(value = "role_id", notes = "角色")
    private String roleId;

    /**
    * 职位
    */
    @TableField(value = "title")
    @DEField(name = "title" , dict = "position")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "职位")
    private String title;

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
    * 用户标识
    */
    @TableField(value = "user_id")
    @DEField(name = "user_id")
    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @ApiModelProperty(value = "user_id", notes = "用户标识")
    private String userId;

    /**
    * 效能标识
    */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id")
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty(value = "owner_id", notes = "效能标识")
    private String ownerId;

    /**
    * 效能管理
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "insight_view", notes = "效能管理")
    private InsightView insightView;

    /**
    * 用户
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "user", notes = "用户")
    private User user;

    /**
    * 设置 [所属数据对象]
    */
    public InsightMember setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [所属对象子类型]
    */
    public InsightMember setOwnerSubtype(String ownerSubtype) {
        this.ownerSubtype = ownerSubtype;
        this.modify("owner_subtype", ownerSubtype);
        return this;
    }

    /**
    * 设置 [角色]
    */
    public InsightMember setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
    * 设置 [职位]
    */
    public InsightMember setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public InsightMember setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [用户标识]
    */
    public InsightMember setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
    * 设置 [效能标识]
    */
    public InsightMember setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("owner_id", ownerId);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getOwnerId(),"未设置效能标识");
        //Assert.notNull(getUserId(),"未设置用户标识");
        //Assert.notNull(getOwnerType(),"未设置所属数据对象");
        String key = String.format("%s||%s||%s"
            ,getOwnerId(),getUserId(),getOwnerType());
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