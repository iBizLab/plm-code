/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@ServiceAPI}}.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.domain;

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
import cn.ibizlab.util.domain.EntityClient;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;

/**
 * 用户角色关系实体类[UserRole]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_USER_ROLE", description = "用户角色关系")
public class UserRole extends EntityClient implements Serializable
{

    /**
     * 用户角色关系标识
     */
    @Id
    @DEField(name = "sys_user_roleid" , isKeyField = true)
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    @ApiModelProperty(value = "sys_user_roleid", notes = "用户角色关系标识")
    private String userRoleId;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 用户标识
     */
    @DEField(name = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty(value = "userid", notes = "用户标识")
    private String userId;

    /**
     * 角色
     */
    @DEField(name = "sys_roleid")
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    @ApiModelProperty(value = "sys_roleid", notes = "角色")
    private String roleId;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 创建人
     */
    @DEField(name = "createmanname" , preType = DEPredefinedFieldType.CREATEMANNAME)
    @JSONField(name = "createmanname")
    @JsonProperty("createmanname")
    @ApiModelProperty(value = "createmanname", notes = "创建人")
    private String createManName;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 更新人
     */
    @DEField(name = "updatemanname" , preType = DEPredefinedFieldType.UPDATEMANNAME)
    @JSONField(name = "updatemanname")
    @JsonProperty("updatemanname")
    @ApiModelProperty(value = "updatemanname", notes = "更新人")
    private String updateManName;

    /**
     * 启用标志
     */
    @DEField(name = "isvalid" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "isvalid")
    @JsonProperty("isvalid")
    @ApiModelProperty(value = "isvalid", notes = "启用标志")
    private Integer isValid;

    /**
    * 设置 [用户标识]
    */
    public UserRole setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
    * 设置 [角色]
    */
    public UserRole setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("roleid", roleId);
        return this;
    }

    /**
    * 设置 [启用标志]
    */
    public UserRole setIsValid(Integer isValid) {
        this.isValid = isValid;
        this.modify("isvalid", isValid);
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
            entity.reset("sys_user_roleid");
        }
        return targetEntity;
    }

}