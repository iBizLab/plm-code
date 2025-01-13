/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@ServiceAPI}}.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.domain;

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
 * 系统角色成员实体类[SysRoleMember]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_ROLE_MEMBER", description = "系统角色成员")
public class SysRoleMember extends EntityClient implements Serializable
{

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
     * 创建人
     */
    @DEField(name = "creator" , preType = DEPredefinedFieldType.CREATEMAN)
    @JSONField(name = "creator")
    @JsonProperty("creator")
    @ApiModelProperty(value = "creator", notes = "创建人")
    private String creator;

    /**
     * 创建时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "创建时间")
    private Date createTime;

    /**
     * 最后更新人
     */
    @DEField(name = "updater" , preType = DEPredefinedFieldType.UPDATEMAN)
    @JSONField(name = "updater")
    @JsonProperty("updater")
    @ApiModelProperty(value = "updater", notes = "最后更新人")
    private String updater;

    /**
     * 最后更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "最后更新时间")
    private Date updateTime;

    /**
     * DC
     */
    @DEField(name = "dc")
    @JSONField(name = "dc")
    @JsonProperty("dc")
    @ApiModelProperty(value = "dc", notes = "DC")
    private String dc;

    /**
     * 用户组/人员标识
     */
    @DEField(name = "member_uid")
    @JSONField(name = "member_uid")
    @JsonProperty("member_uid")
    @ApiModelProperty(value = "member_uid", notes = "用户组/人员标识")
    private String memberUid;

    /**
     * 系统角色标识
     */
    @DEField(name = "role_id")
    @JSONField(name = "role_id")
    @JsonProperty("role_id")
    @ApiModelProperty(value = "role_id", notes = "系统角色标识")
    private String roleId;

    /**
     * 成员分组名称
     */
    @DEField(name = "member_group_name")
    @JSONField(name = "member_group_name")
    @JsonProperty("member_group_name")
    @ApiModelProperty(value = "member_group_name", notes = "成员分组名称")
    private String memberGroupName;

    /**
     * Mail
     */
    @DEField(name = "mail")
    @JSONField(name = "mail")
    @JsonProperty("mail")
    @ApiModelProperty(value = "mail", notes = "Mail")
    private String mail;

    /**
    * 设置 [DC]
    */
    public SysRoleMember setDc(String dc) {
        this.dc = dc;
        this.modify("dc", dc);
        return this;
    }

    /**
    * 设置 [用户组/人员标识]
    */
    public SysRoleMember setMemberUid(String memberUid) {
        this.memberUid = memberUid;
        this.modify("member_uid", memberUid);
        return this;
    }

    /**
    * 设置 [系统角色标识]
    */
    public SysRoleMember setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
    * 设置 [成员分组名称]
    */
    public SysRoleMember setMemberGroupName(String memberGroupName) {
        this.memberGroupName = memberGroupName;
        this.modify("member_group_name", memberGroupName);
        return this;
    }

    /**
    * 设置 [Mail]
    */
    public SysRoleMember setMail(String mail) {
        this.mail = mail;
        this.modify("mail", mail);
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