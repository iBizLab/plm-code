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
 * 实体表单过滤[PSDEFormFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体表单过滤DTO")
public class PSDEFormFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体表单标识EQ
     */
    @JsonProperty("n_psdeformid_eq")
    @JSONField(name = "n_psdeformid_eq")
    @ApiModelProperty(value = "实体表单标识EQ", position = 10)
	private String psdeFormIdEQ;

    /**
     * 实体表单名称LIKE
     */
    @JsonProperty("n_psdeformname_like")
    @JSONField(name = "n_psdeformname_like")
    @ApiModelProperty(value = "实体表单名称LIKE", position = 20)
	private String psdeFormNameLIKE;

    /**
     * 表单类型EQ
     */
    @JsonProperty("n_formtype_eq")
    @JSONField(name = "n_formtype_eq")
    @ApiModelProperty(value = "表单类型EQ", position = 80)
	private String formTypeEQ;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdeid_eq")
    @JSONField(name = "n_psdeid_eq")
    @ApiModelProperty(value = "实体EQ", position = 90)
	private String psdeidEQ;

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