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
 * 核心产品过滤[PSCorePrdFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("核心产品过滤DTO")
public class PSCorePrdFilterDTO extends FilterBase implements Serializable {

    /**
     * 核心产品标识EQ
     */
    @JsonProperty("n_pscoreprdid_eq")
    @JSONField(name = "n_pscoreprdid_eq")
    @ApiModelProperty(value = "核心产品标识EQ", position = 90)
	private String psCorePrdIdEQ;

    /**
     * 产品名称LIKE
     */
    @JsonProperty("n_pscoreprdname_like")
    @JSONField(name = "n_pscoreprdname_like")
    @ApiModelProperty(value = "产品名称LIKE", position = 100)
	private String psCorePrdNameLIKE;

    /**
     * 产品分类EQ
     */
    @JsonProperty("n_pscoreprdcatid_eq")
    @JSONField(name = "n_pscoreprdcatid_eq")
    @ApiModelProperty(value = "产品分类EQ", position = 190)
	private String psCorePrdCatIdEQ;

    /**
     * 产品分类IN
     */
    @JsonProperty("n_pscoreprdcatid_in")
    @JSONField(name = "n_pscoreprdcatid_in")
    @ApiModelProperty(value = "产品分类IN", position = 191)
	private String psCorePrdCatIdIN;


}