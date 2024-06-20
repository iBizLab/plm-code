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
 * 主状态值代理过滤[MSValueProxyFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("主状态值代理过滤DTO")
public class MSValueProxyFilterDTO extends FilterBase implements Serializable {

    /**
     * 主状态值代理标识EQ
     */
    @JsonProperty("n_msvalueproxyid_eq")
    @JSONField(name = "n_msvalueproxyid_eq")
    @ApiModelProperty(value = "主状态值代理标识EQ", position = 20)
	private String msValueProxyIdEQ;

    /**
     * 主状态值代理名称LIKE
     */
    @JsonProperty("n_msvalueproxyname_like")
    @JSONField(name = "n_msvalueproxyname_like")
    @ApiModelProperty(value = "主状态值代理名称LIKE", position = 30)
	private String msValueProxyNameLIKE;


}