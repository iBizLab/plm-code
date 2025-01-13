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
 * 系统角色实体类[Role]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_ROLE", description = "系统角色")
public class Role extends EntityClient implements Serializable
{

    /**
     * 角色标识
     */
    @Id
    @DEField(name = "sys_roleid" , isKeyField = true)
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    @ApiModelProperty(value = "sys_roleid", notes = "角色标识")
    private String roleId;

    /**
     * 角色名称
     */
    @DEField(name = "sys_rolename")
    @JSONField(name = "rolename")
    @JsonProperty("rolename")
    @ApiModelProperty(value = "sys_rolename", notes = "角色名称")
    private String roleName;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 父角色标识
     */
    @DEField(name = "proleid")
    @JSONField(name = "proleid")
    @JsonProperty("proleid")
    @ApiModelProperty(value = "proleid", notes = "父角色标识")
    private String pRoleId;

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
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 授权全部用户
     */
    @DEField(name = "authorizeall" , dict = "YesNo")
    @JSONField(name = "authorizeall")
    @JsonProperty("authorizeall")
    @ApiModelProperty(value = "authorizeall", notes = "授权全部用户")
    private Integer authorizeAll;

    /**
     * 用户模式
     */
    @DEField(name = "usermode" , defaultValue = "NONE")
    @JSONField(name = "usermode")
    @JsonProperty("usermode")
    @ApiModelProperty(value = "usermode", notes = "用户模式")
    private String userMode;

    /**
     * 租户系统标识
     */
    @DEField(name = "dcsystemid")
    @JSONField(name = "dcsystemid")
    @JsonProperty("dcsystemid")
    @ApiModelProperty(value = "dcsystemid", notes = "租户系统标识")
    private String dcSystemId;

    /**
     * 角色标识
     */
    @DEField(name = "roletag")
    @JSONField(name = "roletag")
    @JsonProperty("roletag")
    @ApiModelProperty(value = "roletag", notes = "角色标识")
    private String roleTag;

    /**
     * 系统标记
     */
    @DEField(name = "systemflag" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "systemflag")
    @JsonProperty("systemflag")
    @ApiModelProperty(value = "systemflag", notes = "系统标记")
    private Integer systemFlag;

    /**
     * 全局标记
     */
    @DEField(name = "globalflag" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "globalflag")
    @JsonProperty("globalflag")
    @ApiModelProperty(value = "globalflag", notes = "全局标记")
    private Integer globalFlag;

    /**
    * 设置 [角色名称]
    */
    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        this.modify("rolename", roleName);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public Role setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [父角色标识]
    */
    public Role setPRoleId(String pRoleId) {
        this.pRoleId = pRoleId;
        this.modify("proleid", pRoleId);
        return this;
    }

    /**
    * 设置 [授权全部用户]
    */
    public Role setAuthorizeAll(Integer authorizeAll) {
        this.authorizeAll = authorizeAll;
        this.modify("authorizeall", authorizeAll);
        return this;
    }

    /**
    * 设置 [用户模式]
    */
    public Role setUserMode(String userMode) {
        this.userMode = userMode;
        this.modify("usermode", userMode);
        return this;
    }

    /**
    * 设置 [租户系统标识]
    */
    public Role setDcSystemId(String dcSystemId) {
        this.dcSystemId = dcSystemId;
        this.modify("dcsystemid", dcSystemId);
        return this;
    }

    /**
    * 设置 [角色标识]
    */
    public Role setRoleTag(String roleTag) {
        this.roleTag = roleTag;
        this.modify("roletag", roleTag);
        return this;
    }

    /**
    * 设置 [系统标记]
    */
    public Role setSystemFlag(Integer systemFlag) {
        this.systemFlag = systemFlag;
        this.modify("systemflag", systemFlag);
        return this;
    }

    /**
    * 设置 [全局标记]
    */
    public Role setGlobalFlag(Integer globalFlag) {
        this.globalFlag = globalFlag;
        this.modify("globalflag", globalFlag);
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
            entity.reset("sys_roleid");
        }
        return targetEntity;
    }

}