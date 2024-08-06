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
 * 应用门户部件过滤[PSAppPortletFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("应用门户部件过滤DTO")
public class PSAppPortletFilterDTO extends FilterBase implements Serializable {

    /**
     * 扩展模型EQ
     */
    @JsonProperty("n_dynamodelflag_eq")
    @JSONField(name = "n_dynamodelflag_eq")
    @ApiModelProperty(value = "扩展模型EQ", position = 0)
	private Integer dynaModelFlagEQ;

    /**
     * 扩展模型NOTEQ
     */
    @JsonProperty("n_dynamodelflag_noteq")
    @JSONField(name = "n_dynamodelflag_noteq")
    @ApiModelProperty(value = "扩展模型NOTEQ", position = 1)
	private Integer dynaModelFlagNOTEQ;

    /**
     * 应用门户部件标识IN
     */
    @JsonProperty("n_psappportletid_in")
    @JSONField(name = "n_psappportletid_in")
    @ApiModelProperty(value = "应用门户部件标识IN", position = 10)
	private String psAppPortletIdIN;

    /**
     * 应用门户部件标识EQ
     */
    @JsonProperty("n_psappportletid_eq")
    @JSONField(name = "n_psappportletid_eq")
    @ApiModelProperty(value = "应用门户部件标识EQ", position = 11)
	private String psAppPortletIdEQ;

    /**
     * 应用门户部件名称LIKE
     */
    @JsonProperty("n_psappportletname_like")
    @JSONField(name = "n_psappportletname_like")
    @ApiModelProperty(value = "应用门户部件名称LIKE", position = 20)
	private String psAppPortletNameLIKE;

    /**
     * 看板部件类型EQ
     */
    @JsonProperty("n_portlettype_eq")
    @JSONField(name = "n_portlettype_eq")
    @ApiModelProperty(value = "看板部件类型EQ", position = 60)
	private String portletTypeEQ;

    /**
     * 系统应用EQ
     */
    @JsonProperty("n_pssysappid_eq")
    @JSONField(name = "n_pssysappid_eq")
    @ApiModelProperty(value = "系统应用EQ", position = 330)
	private String psSysAppIdEQ;


}