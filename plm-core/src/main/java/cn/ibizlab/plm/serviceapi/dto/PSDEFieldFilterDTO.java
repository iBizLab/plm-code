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
 * 实体属性过滤[PSDEFieldFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体属性过滤DTO")
public class PSDEFieldFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体属性标识EQ
     */
    @JsonProperty("n_psdefieldid_eq")
    @JSONField(name = "n_psdefieldid_eq")
    @ApiModelProperty(value = "实体属性标识EQ", position = 10)
	private String psdeFieldIdEQ;

    /**
     * 实体属性名称LIKE
     */
    @JsonProperty("n_psdefieldname_like")
    @JSONField(name = "n_psdefieldname_like")
    @ApiModelProperty(value = "实体属性名称LIKE", position = 30)
	private String psdeFieldNameLIKE;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdeid_eq")
    @JSONField(name = "n_psdeid_eq")
    @ApiModelProperty(value = "实体EQ", position = 70)
	private String psdeidEQ;

    /**
     * 属性类型EQ
     */
    @JsonProperty("n_deftype_eq")
    @JSONField(name = "n_deftype_eq")
    @ApiModelProperty(value = "属性类型EQ", position = 90)
	private Integer defTypeEQ;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdename_eq")
    @JSONField(name = "n_psdename_eq")
    @ApiModelProperty(value = "实体EQ", position = 100)
	private String psdeNameEQ;

    /**
     * 实体LIKE
     */
    @JsonProperty("n_psdename_like")
    @JSONField(name = "n_psdename_like")
    @ApiModelProperty(value = "实体LIKE", position = 101)
	private String psdeNameLIKE;


}