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
 * 登录日志[LoginLogDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("登录日志DTO")
public class LoginLogDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录时间
     */
    @JsonProperty("auth_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "auth_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "登录时间", position = 0)
    private Date authTime;

    /**
     * 区/县
     */
    @JsonProperty("county")
    @JSONField(name = "county")
    @ApiModelProperty(value = "区/县", position = 1)
    private String county;

    /**
     * 国家
     */
    @JsonProperty("country")
    @JSONField(name = "country")
    @ApiModelProperty(value = "国家", position = 2)
    private String country;

    /**
     * 城市
     */
    @JsonProperty("city")
    @JSONField(name = "city")
    @ApiModelProperty(value = "城市", position = 3)
    private String city;

    /**
     * IP地址
     */
    @JsonProperty("ip")
    @JSONField(name = "ip")
    @ApiModelProperty(value = "IP地址", position = 4)
    private String ip;

    /**
     * 登录方式
     */
    @JsonProperty("login_method")
    @JSONField(name = "login_method")
    @ApiModelProperty(value = "登录方式", position = 5)
    private String loginMethod;

    /**
     * 省
     */
    @JsonProperty("province")
    @JSONField(name = "province")
    @ApiModelProperty(value = "省", position = 6)
    private String province;

    /**
     * 客户端
     */
    @JsonProperty("user_agent")
    @JSONField(name = "user_agent")
    @ApiModelProperty(value = "客户端", position = 7)
    private String userAgent;

    /**
     * 用户标识
     */
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "用户标识", position = 8)
    private String userId;

    /**
     * 用户名称
     */
    @JsonProperty("user_name")
    @JSONField(name = "user_name")
    @ApiModelProperty(value = "用户名称", position = 9)
    private String userName;

    /**
     * 网络提供商
     */
    @JsonProperty("isp")
    @JSONField(name = "isp")
    @ApiModelProperty(value = "网络提供商", position = 10)
    private String isp;

    /**
     * 认证结果
     */
    @JsonProperty("auth_code")
    @JSONField(name = "auth_code")
    @ApiModelProperty(value = "认证结果", position = 11)
    private String authCode;

    /**
     * 活跃成员数
     */
    @JsonProperty("active_members")
    @JSONField(name = "active_members")
    @ApiModelProperty(value = "活跃成员数", position = 12)
    private String activeMembers;

    /**
     * 活跃率
     */
    @JsonProperty("active_rate")
    @JSONField(name = "active_rate")
    @ApiModelProperty(value = "活跃率", position = 13)
    private String activeRate;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 14)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 15)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 16)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 17)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 18)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 19)
    private Date updateTime;


    /**
     * 设置 [登录时间]
     */
    public LoginLogDTO setAuthTime(Date authTime) {
        this.authTime = authTime;
        this.modify("auth_time", authTime);
        return this;
    }

    /**
     * 设置 [区/县]
     */
    public LoginLogDTO setCounty(String county) {
        this.county = county;
        this.modify("county", county);
        return this;
    }

    /**
     * 设置 [国家]
     */
    public LoginLogDTO setCountry(String country) {
        this.country = country;
        this.modify("country", country);
        return this;
    }

    /**
     * 设置 [城市]
     */
    public LoginLogDTO setCity(String city) {
        this.city = city;
        this.modify("city", city);
        return this;
    }

    /**
     * 设置 [IP地址]
     */
    public LoginLogDTO setIp(String ip) {
        this.ip = ip;
        this.modify("ip", ip);
        return this;
    }

    /**
     * 设置 [登录方式]
     */
    public LoginLogDTO setLoginMethod(String loginMethod) {
        this.loginMethod = loginMethod;
        this.modify("login_method", loginMethod);
        return this;
    }

    /**
     * 设置 [省]
     */
    public LoginLogDTO setProvince(String province) {
        this.province = province;
        this.modify("province", province);
        return this;
    }

    /**
     * 设置 [客户端]
     */
    public LoginLogDTO setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        this.modify("user_agent", userAgent);
        return this;
    }

    /**
     * 设置 [用户标识]
     */
    public LoginLogDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
     * 设置 [用户名称]
     */
    public LoginLogDTO setUserName(String userName) {
        this.userName = userName;
        this.modify("user_name", userName);
        return this;
    }

    /**
     * 设置 [网络提供商]
     */
    public LoginLogDTO setIsp(String isp) {
        this.isp = isp;
        this.modify("isp", isp);
        return this;
    }

    /**
     * 设置 [认证结果]
     */
    public LoginLogDTO setAuthCode(String authCode) {
        this.authCode = authCode;
        this.modify("auth_code", authCode);
        return this;
    }

    /**
     * 设置 [活跃成员数]
     */
    public LoginLogDTO setActiveMembers(String activeMembers) {
        this.activeMembers = activeMembers;
        this.modify("active_members", activeMembers);
        return this;
    }

    /**
     * 设置 [活跃率]
     */
    public LoginLogDTO setActiveRate(String activeRate) {
        this.activeRate = activeRate;
        this.modify("active_rate", activeRate);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public LoginLogDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
