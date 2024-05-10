/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFILTER}}.java.hbs
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
import cn.ibizlab.util.filter.FilterBase;

import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 认证日志过滤[AuthLogAdminFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("认证日志过滤DTO")
public class AuthLogAdminFilterDTO extends FilterBase implements Serializable {

    /**
     * 标识EQ
     */
    @JsonProperty("n_logid_eq")
    @JSONField(name = "n_logid_eq")
    @ApiModelProperty(value = "标识EQ", position = 0)
	private String logIdEQ;

    /**
     * 用户全局名LIKE
     */
    @JsonProperty("n_username_like")
    @JSONField(name = "n_username_like")
    @ApiModelProperty(value = "用户全局名LIKE", position = 20)
	private String userNameLIKE;

    /**
     * 认证结果EQ
     */
    @JsonProperty("n_authcode_eq")
    @JSONField(name = "n_authcode_eq")
    @ApiModelProperty(value = "认证结果EQ", position = 90)
	private String authCodeEQ;


}