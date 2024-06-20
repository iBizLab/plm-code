/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@ServiceAPI}}.java.hbs
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
 * 认证日志实体类[AuthLog]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_AUTHLOG", description = "认证日志")
public class AuthLog extends EntityClient implements Serializable
{

    /**
     * 标识
     */
    @Id
    @DEField(name = "logid" , isKeyField = true)
    @JSONField(name = "logid")
    @JsonProperty("logid")
    @ApiModelProperty(value = "logid", notes = "标识")
    private String logId;

    /**
     * 用户全局名
     */
    @DEField(name = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    @ApiModelProperty(value = "username", notes = "用户全局名")
    private String userName;

    /**
     * 用户全局标识
     */
    @DEField(name = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty(value = "userid", notes = "用户全局标识")
    private String userId;

    /**
     * 用户名称
     */
    @DEField(name = "personname")
    @JSONField(name = "personname")
    @JsonProperty("personname")
    @ApiModelProperty(value = "personname", notes = "用户名称")
    private String personName;

    /**
     * 域
     */
    @DEField(name = "domains")
    @JSONField(name = "domain")
    @JsonProperty("domain")
    @ApiModelProperty(value = "domains", notes = "域")
    private String domain;

    /**
     * 认证时间
     */
    @DEField(name = "authtime" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "authtime" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("authtime")
    @ApiModelProperty(value = "authtime", notes = "认证时间")
    private Date authTime;

    /**
     * IP地址
     */
    @DEField(name = "ipaddr")
    @JSONField(name = "ipaddr")
    @JsonProperty("ipaddr")
    @ApiModelProperty(value = "ipaddr", notes = "IP地址")
    private String ipAddr;

    /**
     * MAC地址
     */
    @DEField(name = "macaddr")
    @JSONField(name = "macaddr")
    @JsonProperty("macaddr")
    @ApiModelProperty(value = "macaddr", notes = "MAC地址")
    private String macAddr;

    /**
     * 客户端
     */
    @DEField(name = "useragent")
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    @ApiModelProperty(value = "useragent", notes = "客户端")
    private String userAgent;

    /**
     * 认证结果
     */
    @DEField(name = "authcode" , dict = "AuthCode")
    @JSONField(name = "authcode")
    @JsonProperty("authcode")
    @ApiModelProperty(value = "authcode", notes = "认证结果")
    private String authCode;

    /**
     * 认证方式
     */
    @DEField(name = "authagent")
    @JSONField(name = "authagent")
    @JsonProperty("authagent")
    @ApiModelProperty(value = "authagent", notes = "认证方式")
    private String authAgent;

    /**
    * 设置 [用户全局名]
    */
    public AuthLog setUserName(String userName) {
        this.userName = userName;
        this.modify("username", userName);
        return this;
    }

    /**
    * 设置 [用户全局标识]
    */
    public AuthLog setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
    * 设置 [用户名称]
    */
    public AuthLog setPersonName(String personName) {
        this.personName = personName;
        this.modify("personname", personName);
        return this;
    }

    /**
    * 设置 [域]
    */
    public AuthLog setDomain(String domain) {
        this.domain = domain;
        this.modify("domain", domain);
        return this;
    }

    /**
    * 设置 [IP地址]
    */
    public AuthLog setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        this.modify("ipaddr", ipAddr);
        return this;
    }

    /**
    * 设置 [MAC地址]
    */
    public AuthLog setMacAddr(String macAddr) {
        this.macAddr = macAddr;
        this.modify("macaddr", macAddr);
        return this;
    }

    /**
    * 设置 [客户端]
    */
    public AuthLog setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        this.modify("useragent", userAgent);
        return this;
    }

    /**
    * 设置 [认证结果]
    */
    public AuthLog setAuthCode(String authCode) {
        this.authCode = authCode;
        this.modify("authcode", authCode);
        return this;
    }

    /**
    * 设置 [认证方式]
    */
    public AuthLog setAuthAgent(String authAgent) {
        this.authAgent = authAgent;
        this.modify("authagent", authAgent);
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