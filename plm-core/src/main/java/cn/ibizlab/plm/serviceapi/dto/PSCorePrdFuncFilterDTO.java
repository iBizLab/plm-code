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
 * 核心产品功能过滤[PSCorePrdFuncFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("核心产品功能过滤DTO")
public class PSCorePrdFuncFilterDTO extends FilterBase implements Serializable {

    /**
     * 核心产品功能标识EQ
     */
    @JsonProperty("n_pscoreprdfuncid_eq")
    @JSONField(name = "n_pscoreprdfuncid_eq")
    @ApiModelProperty(value = "核心产品功能标识EQ", position = 10)
	private String psCorePrdFuncIdEQ;

    /**
     * 核心产品功能名称LIKE
     */
    @JsonProperty("n_pscoreprdfuncname_like")
    @JSONField(name = "n_pscoreprdfuncname_like")
    @ApiModelProperty(value = "核心产品功能名称LIKE", position = 20)
	private String psCorePrdFuncNameLIKE;

    /**
     * 核心产品EQ
     */
    @JsonProperty("n_pscoreprdid_eq")
    @JSONField(name = "n_pscoreprdid_eq")
    @ApiModelProperty(value = "核心产品EQ", position = 190)
	private String psCorePrdIdEQ;

    /**
     * 功能状态EQ
     */
    @JsonProperty("n_funcstate_eq")
    @JSONField(name = "n_funcstate_eq")
    @ApiModelProperty(value = "功能状态EQ", position = 210)
	private String funcStateEQ;


}