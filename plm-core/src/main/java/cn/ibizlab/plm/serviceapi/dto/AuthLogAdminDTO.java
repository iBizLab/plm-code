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
 * 认证日志[AuthLogAdminDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("认证日志DTO")
public class AuthLogAdminDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @JsonProperty("logid")
    @JSONField(name = "logid")
    @ApiModelProperty(value = "标识", position = 0)
    private String logId;

    /**
     * 用户全局标识
     */
    @JsonProperty("userid")
    @JSONField(name = "userid")
    @ApiModelProperty(value = "用户全局标识", position = 1)
    private String userId;

    /**
     * 用户全局名
     */
    @JsonProperty("username")
    @JSONField(name = "username")
    @ApiModelProperty(value = "用户全局名", position = 2)
    private String userName;

    /**
     * 用户名称
     */
    @JsonProperty("personname")
    @JSONField(name = "personname")
    @ApiModelProperty(value = "用户名称", position = 3)
    private String personName;

    /**
     * 域
     */
    @JsonProperty("domain")
    @JSONField(name = "domain")
    @ApiModelProperty(value = "域", position = 4)
    private String domain;

    /**
     * 认证时间
     */
    @JsonProperty("authtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "authtime" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "认证时间", position = 5)
    private Date authTime;

    /**
     * IP地址
     */
    @JsonProperty("ipaddr")
    @JSONField(name = "ipaddr")
    @ApiModelProperty(value = "IP地址", position = 6)
    private String ipAddr;

    /**
     * MAC地址
     */
    @JsonProperty("macaddr")
    @JSONField(name = "macaddr")
    @ApiModelProperty(value = "MAC地址", position = 7)
    private String macAddr;

    /**
     * 客户端
     */
    @JsonProperty("useragent")
    @JSONField(name = "useragent")
    @ApiModelProperty(value = "客户端", position = 8)
    private String userAgent;

    /**
     * 认证方式
     */
    @JsonProperty("authagent")
    @JSONField(name = "authagent")
    @ApiModelProperty(value = "认证方式", position = 9)
    private String authAgent;

    /**
     * 认证结果
     */
    @JsonProperty("authcode")
    @JSONField(name = "authcode")
    @ApiModelProperty(value = "认证结果", position = 10)
    private String authCode;

    /**
     * 活跃成员数
     */
    @JsonProperty("active_members")
    @JSONField(name = "active_members")
    @ApiModelProperty(value = "活跃成员数", position = 11)
    private String activeMembers;


    /**
     * 设置 [用户全局标识]
     */
    public AuthLogAdminDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
     * 设置 [用户全局名]
     */
    public AuthLogAdminDTO setUserName(String userName) {
        this.userName = userName;
        this.modify("username", userName);
        return this;
    }

    /**
     * 设置 [用户名称]
     */
    public AuthLogAdminDTO setPersonName(String personName) {
        this.personName = personName;
        this.modify("personname", personName);
        return this;
    }

    /**
     * 设置 [域]
     */
    public AuthLogAdminDTO setDomain(String domain) {
        this.domain = domain;
        this.modify("domain", domain);
        return this;
    }

    /**
     * 设置 [IP地址]
     */
    public AuthLogAdminDTO setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        this.modify("ipaddr", ipAddr);
        return this;
    }

    /**
     * 设置 [MAC地址]
     */
    public AuthLogAdminDTO setMacAddr(String macAddr) {
        this.macAddr = macAddr;
        this.modify("macaddr", macAddr);
        return this;
    }

    /**
     * 设置 [客户端]
     */
    public AuthLogAdminDTO setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        this.modify("useragent", userAgent);
        return this;
    }

    /**
     * 设置 [认证方式]
     */
    public AuthLogAdminDTO setAuthAgent(String authAgent) {
        this.authAgent = authAgent;
        this.modify("authagent", authAgent);
        return this;
    }

    /**
     * 设置 [认证结果]
     */
    public AuthLogAdminDTO setAuthCode(String authCode) {
        this.authCode = authCode;
        this.modify("authcode", authCode);
        return this;
    }

    /**
     * 设置 [活跃成员数]
     */
    public AuthLogAdminDTO setActiveMembers(String activeMembers) {
        this.activeMembers = activeMembers;
        this.modify("active_members", activeMembers);
        return this;
    }


}
