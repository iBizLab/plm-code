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
 * 核心产品分类过滤[PSCorePrdCatFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("核心产品分类过滤DTO")
public class PSCorePrdCatFilterDTO extends FilterBase implements Serializable {

    /**
     * 上级分类EQ
     */
    @JsonProperty("n_ppscoreprdcatid_eq")
    @JSONField(name = "n_ppscoreprdcatid_eq")
    @ApiModelProperty(value = "上级分类EQ", position = 0)
	private String ppsCorePrdCatIdEQ;

    /**
     * 上级分类ISNOTNULL
     */
    @JsonProperty("n_ppscoreprdcatid_isnotnull")
    @JSONField(name = "n_ppscoreprdcatid_isnotnull")
    @ApiModelProperty(value = "上级分类ISNOTNULL", position = 1)
	private String ppsCorePrdCatIdISNOTNULL;

    /**
     * 上级分类ISNULL
     */
    @JsonProperty("n_ppscoreprdcatid_isnull")
    @JSONField(name = "n_ppscoreprdcatid_isnull")
    @ApiModelProperty(value = "上级分类ISNULL", position = 2)
	private String ppsCorePrdCatIdISNULL;

    /**
     * 核心产品分类标识EQ
     */
    @JsonProperty("n_pscoreprdcatid_eq")
    @JSONField(name = "n_pscoreprdcatid_eq")
    @ApiModelProperty(value = "核心产品分类标识EQ", position = 10)
	private String psCorePrdCatIdEQ;

    /**
     * 核心产品分类名称LIKE
     */
    @JsonProperty("n_pscoreprdcatname_like")
    @JSONField(name = "n_pscoreprdcatname_like")
    @ApiModelProperty(value = "核心产品分类名称LIKE", position = 20)
	private String psCorePrdCatNameLIKE;


}