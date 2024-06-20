/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.domain;

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

/**
 * 认证日志实体类[AuthLogAdmin]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZAUTHLOG", resultMap = "AuthLogAdminResultMap")
@ApiModel(value = "AUTH_LOG_ADMIN", description = "认证日志")
public class AuthLogAdmin extends EntityMP implements Serializable
{

    /**
    * 标识
    */
    @Id
    @TableId(value = "logid" , type = IdType.ASSIGN_UUID)
    @DEField(name = "logid" , isKeyField = true)
    @JSONField(name = "logid")
    @JsonProperty("logid")
    @ApiModelProperty(value = "logid", notes = "标识")
    private String logId;

    /**
    * 用户全局名
    */
    @TableField(value = "username")
    @DEField(name = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    @ApiModelProperty(value = "username", notes = "用户全局名")
    private String userName;

    /**
    * 用户全局标识
    */
    @TableField(value = "userid")
    @DEField(name = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty(value = "userid", notes = "用户全局标识")
    private String userId;

    /**
    * 用户名称
    */
    @TableField(value = "personname")
    @DEField(name = "personname")
    @JSONField(name = "personname")
    @JsonProperty("personname")
    @ApiModelProperty(value = "personname", notes = "用户名称")
    private String personName;

    /**
    * 域
    */
    @TableField(value = "domains")
    @DEField(name = "domains")
    @JSONField(name = "domain")
    @JsonProperty("domain")
    @ApiModelProperty(value = "domains", notes = "域")
    private String domain;

    /**
    * 认证时间
    */
    @TableField(value = "authtime" , fill = FieldFill.INSERT)
    @DEField(name = "authtime" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "authtime" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("authtime")
    @ApiModelProperty(value = "authtime", notes = "认证时间")
    private Date authTime;

    /**
    * IP地址
    */
    @TableField(value = "ipaddr")
    @DEField(name = "ipaddr")
    @JSONField(name = "ipaddr")
    @JsonProperty("ipaddr")
    @ApiModelProperty(value = "ipaddr", notes = "IP地址")
    private String ipAddr;

    /**
    * MAC地址
    */
    @TableField(value = "macaddr")
    @DEField(name = "macaddr")
    @JSONField(name = "macaddr")
    @JsonProperty("macaddr")
    @ApiModelProperty(value = "macaddr", notes = "MAC地址")
    private String macAddr;

    /**
    * 客户端
    */
    @TableField(value = "useragent")
    @DEField(name = "useragent")
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    @ApiModelProperty(value = "useragent", notes = "客户端")
    private String userAgent;

    /**
    * 认证结果
    */
    @TableField(value = "authcode")
    @DEField(name = "authcode" , dict = "AuthCode")
    @JSONField(name = "authcode")
    @JsonProperty("authcode")
    @ApiModelProperty(value = "authcode", notes = "认证结果")
    private String authCode;

    /**
    * 认证方式
    */
    @TableField(value = "authagent")
    @DEField(name = "authagent")
    @JSONField(name = "authagent")
    @JsonProperty("authagent")
    @ApiModelProperty(value = "authagent", notes = "认证方式")
    private String authAgent;

    /**
    * 活跃成员数
    */
    @TableField(value = "active_members" , exist = false)
    @DEField(name = "active_members")
    @JSONField(name = "active_members")
    @JsonProperty("active_members")
    @ApiModelProperty(value = "active_members", notes = "活跃成员数")
    private String activeMembers;

    /**
    * 设置 [用户全局名]
    */
    public AuthLogAdmin setUserName(String userName) {
        this.userName = userName;
        this.modify("username", userName);
        return this;
    }

    /**
    * 设置 [用户全局标识]
    */
    public AuthLogAdmin setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
    * 设置 [用户名称]
    */
    public AuthLogAdmin setPersonName(String personName) {
        this.personName = personName;
        this.modify("personname", personName);
        return this;
    }

    /**
    * 设置 [域]
    */
    public AuthLogAdmin setDomain(String domain) {
        this.domain = domain;
        this.modify("domain", domain);
        return this;
    }

    /**
    * 设置 [IP地址]
    */
    public AuthLogAdmin setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        this.modify("ipaddr", ipAddr);
        return this;
    }

    /**
    * 设置 [MAC地址]
    */
    public AuthLogAdmin setMacAddr(String macAddr) {
        this.macAddr = macAddr;
        this.modify("macaddr", macAddr);
        return this;
    }

    /**
    * 设置 [客户端]
    */
    public AuthLogAdmin setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        this.modify("useragent", userAgent);
        return this;
    }

    /**
    * 设置 [认证结果]
    */
    public AuthLogAdmin setAuthCode(String authCode) {
        this.authCode = authCode;
        this.modify("authcode", authCode);
        return this;
    }

    /**
    * 设置 [认证方式]
    */
    public AuthLogAdmin setAuthAgent(String authAgent) {
        this.authAgent = authAgent;
        this.modify("authagent", authAgent);
        return this;
    }

    /**
    * 设置 [活跃成员数]
    */
    public AuthLogAdmin setActiveMembers(String activeMembers) {
        this.activeMembers = activeMembers;
        this.modify("active_members", activeMembers);
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
            entity.reset("logid");
        }
        return targetEntity;
    }

}