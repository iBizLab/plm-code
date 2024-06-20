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
 * 效能成员[InsightMemberDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("效能成员DTO")
public class InsightMemberDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 0)
    private String ownerType;

    /**
     * 所属对象子类型
     */
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "所属对象子类型", position = 1)
    private String ownerSubtype;

    /**
     * 角色
     */
    @JsonProperty("role_id")
    @JSONField(name = "role_id")
    @ApiModelProperty(value = "角色", position = 2)
    private String roleId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 3)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 4)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 5)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 6)
    private String name;

    /**
     * 效能标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "效能标识", position = 7)
    private String ownerId;

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
     * 用户标识
     */
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "用户标识", position = 10)
    private String userId;


    /**
     * 设置 [所属数据对象]
     */
    public InsightMemberDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [所属对象子类型]
     */
    public InsightMemberDTO setOwnerSubtype(String ownerSubtype) {
        this.ownerSubtype = ownerSubtype;
        this.modify("owner_subtype", ownerSubtype);
        return this;
    }

    /**
     * 设置 [角色]
     */
    public InsightMemberDTO setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public InsightMemberDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [效能标识]
     */
    public InsightMemberDTO setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("owner_id", ownerId);
        return this;
    }

    /**
     * 设置 [用户标识]
     */
    public InsightMemberDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }


}
