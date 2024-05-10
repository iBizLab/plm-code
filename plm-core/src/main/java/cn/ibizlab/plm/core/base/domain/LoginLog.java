/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

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
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;

/**
 * 登录日志实体类[LoginLog]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "LOGIN_LOG", description = "登录日志")
public class LoginLog extends EntityBase implements Serializable
{

    /**
     * 登录时间
     */
    @DEField(name = "authtime")
    @JsonProperty("authtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "authtime" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "authtime", notes = "登录时间")
    private Date authTime;

    /**
     * 区/县
     */
    @DEField(name = "county")
    @JsonProperty("county")
    @JSONField(name = "county")
    @ApiModelProperty(value = "county", notes = "区/县")
    private String county;

    /**
     * 国家
     */
    @DEField(name = "country")
    @JsonProperty("country")
    @JSONField(name = "country")
    @ApiModelProperty(value = "country", notes = "国家")
    private String country;

    /**
     * 城市
     */
    @DEField(name = "city")
    @JsonProperty("city")
    @JSONField(name = "city")
    @ApiModelProperty(value = "city", notes = "城市")
    private String city;

    /**
     * IP地址
     */
    @DEField(name = "ip")
    @JsonProperty("ip")
    @JSONField(name = "ip")
    @ApiModelProperty(value = "ip", notes = "IP地址")
    private String ip;

    /**
     * 登录方式
     */
    @DEField(name = "login_method")
    @JsonProperty("login_method")
    @JSONField(name = "login_method")
    @ApiModelProperty(value = "login_method", notes = "登录方式")
    private String loginMethod;

    /**
     * 省
     */
    @DEField(name = "province")
    @JsonProperty("province")
    @JSONField(name = "province")
    @ApiModelProperty(value = "province", notes = "省")
    private String province;

    /**
     * 客户端
     */
    @DEField(name = "user_agent")
    @JsonProperty("user_agent")
    @JSONField(name = "user_agent")
    @ApiModelProperty(value = "user_agent", notes = "客户端")
    private String userAgent;

    /**
     * 用户标识
     */
    @DEField(name = "user_id")
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "user_id", notes = "用户标识")
    private String userId;

    /**
     * 用户名称
     */
    @DEField(name = "user_name")
    @JsonProperty("user_name")
    @JSONField(name = "user_name")
    @ApiModelProperty(value = "user_name", notes = "用户名称")
    private String userName;

    /**
     * 网络提供商
     */
    @DEField(name = "isp")
    @JsonProperty("isp")
    @JSONField(name = "isp")
    @ApiModelProperty(value = "isp", notes = "网络提供商")
    private String isp;

    /**
     * 认证结果
     */
    @DEField(name = "authcode" , dict = "AuthCode")
    @JsonProperty("authcode")
    @JSONField(name = "authcode")
    @ApiModelProperty(value = "authcode", notes = "认证结果")
    private String authCode;

    /**
     * 活跃成员数
     */
    @DEField(name = "active_members")
    @JsonProperty("active_members")
    @JSONField(name = "active_members")
    @ApiModelProperty(value = "active_members", notes = "活跃成员数")
    private String activeMembers;

    /**
     * 活跃率
     */
    @DEField(name = "active_rate")
    @JsonProperty("active_rate")
    @JSONField(name = "active_rate")
    @ApiModelProperty(value = "active_rate", notes = "活跃率")
    private String activeRate;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;


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