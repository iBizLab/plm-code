/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.wiki.domain;

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
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 空间成员实体类[SpaceMember]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "SPACE_MEMBER", resultMap = "SpaceMemberResultMap")
@ApiModel(value = "SPACE_MEMBER", description = "空间成员")
public class SpaceMember extends EntityMP implements Serializable
{

    /**
    * 登录名
    */
    @TableField(value = "user_id")
    @DEField(name = "user_id")
    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @ApiModelProperty(value = "user_id", notes = "登录名")
    private String userId;

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
    * 空间编号
    */
    @TableField(value = "space_identifier" , exist = false)
    @DEField(name = "space_identifier")
    @JSONField(name = "space_identifier")
    @JsonProperty("space_identifier")
    @ApiModelProperty(value = "space_identifier", notes = "空间编号")
    private String spaceIdentifier;

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
    * 姓名
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "姓名")
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
    * 空间标识
    */
    @TableField(value = "space_id")
    @DEField(name = "space_id")
    @JSONField(name = "space_id")
    @JsonProperty("space_id")
    @ApiModelProperty(value = "space_id", notes = "空间标识")
    private String spaceId;

    /**
    * 名称
    */
    @TableField(value = "space_name" , exist = false)
    @DEField(name = "space_name")
    @JSONField(name = "space_name")
    @JsonProperty("space_name")
    @ApiModelProperty(value = "space_name", notes = "名称")
    private String spaceName;

    /**
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "space", notes = "名称")
    private Space space;

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
    * 设置 [登录名]
    */
    public SpaceMember setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
    * 设置 [角色]
    */
    public SpaceMember setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
    * 设置 [空间编号]
    */
    public SpaceMember setSpaceIdentifier(String spaceIdentifier) {
        this.spaceIdentifier = spaceIdentifier;
        this.modify("space_identifier", spaceIdentifier);
        return this;
    }

    /**
    * 设置 [姓名]
    */
    public SpaceMember setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [空间标识]
    */
    public SpaceMember setSpaceId(String spaceId) {
        this.spaceId = spaceId;
        this.modify("space_id", spaceId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public SpaceMember setSpaceName(String spaceName) {
        this.spaceName = spaceName;
        this.modify("space_name", spaceName);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getSpaceId(),"未设置空间标识");
        //Assert.notNull(getUserId(),"未设置登录名");
        String key = String.format("%s||%s"
            ,getSpaceId(),getUserId());
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