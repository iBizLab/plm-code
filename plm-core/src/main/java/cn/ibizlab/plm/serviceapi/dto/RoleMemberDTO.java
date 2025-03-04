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
 * 系统角色成员[RoleMemberDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("系统角色成员DTO")
public class RoleMemberDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户组/人员标识
     */
    @JsonProperty("member_uid")
    @JSONField(name = "member_uid")
    @ApiModelProperty(value = "用户组/人员标识", position = 0)
    private String memberUid;

    /**
     * 系统角色标识
     */
    @JsonProperty("role_id")
    @JSONField(name = "role_id")
    @ApiModelProperty(value = "系统角色标识", position = 1)
    private String roleId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 2)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 3)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 4)
    private String id;

    /**
     * 姓名
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "姓名", position = 5)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 6)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 7)
    private Date updateTime;


    /**
     * 设置 [用户组/人员标识]
     */
    public RoleMemberDTO setMemberUid(String memberUid) {
        this.memberUid = memberUid;
        this.modify("member_uid", memberUid);
        return this;
    }

    /**
     * 设置 [系统角色标识]
     */
    public RoleMemberDTO setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
     * 设置 [姓名]
     */
    public RoleMemberDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
