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
 * 智能报表项过滤[PSSysBIReportItemFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表项过滤DTO")
public class PSSysBIReportItemFilterDTO extends FilterBase implements Serializable {

    /**
     * 智能报表项标识EQ
     */
    @JsonProperty("n_pssysbireportitemid_eq")
    @JSONField(name = "n_pssysbireportitemid_eq")
    @ApiModelProperty(value = "智能报表项标识EQ", position = 0)
	private String psSysBiReportItemIdEQ;

    /**
     * 智能报表项名称LIKE
     */
    @JsonProperty("n_pssysbireportitemname_like")
    @JSONField(name = "n_pssysbireportitemname_like")
    @ApiModelProperty(value = "智能报表项名称LIKE", position = 10)
	private String psSysBiReportItemNameLIKE;

    /**
     * 智能报表报表EQ
     */
    @JsonProperty("n_pssysbireportid_eq")
    @JSONField(name = "n_pssysbireportid_eq")
    @ApiModelProperty(value = "智能报表报表EQ", position = 100)
	private String psSysBiReportIdEQ;

    /**
     * 智能报表报表EQ
     */
    @JsonProperty("n_pssysbireportname_eq")
    @JSONField(name = "n_pssysbireportname_eq")
    @ApiModelProperty(value = "智能报表报表EQ", position = 110)
	private String psSysBiReportNameEQ;

    /**
     * 智能报表报表LIKE
     */
    @JsonProperty("n_pssysbireportname_like")
    @JSONField(name = "n_pssysbireportname_like")
    @ApiModelProperty(value = "智能报表报表LIKE", position = 111)
	private String psSysBiReportNameLIKE;

    /**
     * 报表项类型EQ
     */
    @JsonProperty("n_birepitemtype_eq")
    @JSONField(name = "n_birepitemtype_eq")
    @ApiModelProperty(value = "报表项类型EQ", position = 130)
	private String biRepItemTypeEQ;

    /**
     * 指标引用类型EQ
     */
    @JsonProperty("n_reftype_eq")
    @JSONField(name = "n_reftype_eq")
    @ApiModelProperty(value = "指标引用类型EQ", position = 200)
	private String refTypeEQ;

    /**
     * 聚合类型EQ
     */
    @JsonProperty("n_aggtype_eq")
    @JSONField(name = "n_aggtype_eq")
    @ApiModelProperty(value = "聚合类型EQ", position = 210)
	private String aggTypeEQ;

    /**
     * 标准数据类型EQ
     */
    @JsonProperty("n_stddatatype_eq")
    @JSONField(name = "n_stddatatype_eq")
    @ApiModelProperty(value = "标准数据类型EQ", position = 220)
	private Integer stdDataTypeEQ;


}