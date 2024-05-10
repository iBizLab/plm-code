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
 * 客户过滤[CustomerFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("客户过滤DTO")
public class CustomerFilterDTO extends FilterBase implements Serializable {

    /**
     * 等级EQ
     */
    @JsonProperty("n_grade_id_eq")
    @JSONField(name = "n_grade_id_eq")
    @ApiModelProperty(value = "等级EQ", position = 50)
	private String gradeIdEQ;

    /**
     * 行业EQ
     */
    @JsonProperty("n_industry_id_eq")
    @JSONField(name = "n_industry_id_eq")
    @ApiModelProperty(value = "行业EQ", position = 60)
	private String industryIdEQ;

    /**
     * 类别ISNULL
     */
    @JsonProperty("n_categorys_isnull")
    @JSONField(name = "n_categorys_isnull")
    @ApiModelProperty(value = "类别ISNULL", position = 70)
	private String categoriesISNULL;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categorys_like")
    @JSONField(name = "n_categorys_like")
    @ApiModelProperty(value = "类别LIKE", position = 71)
	private String categoriesLIKE;

    /**
     * 产品名称EQ
     */
    @JsonProperty("n_product_name_eq")
    @JSONField(name = "n_product_name_eq")
    @ApiModelProperty(value = "产品名称EQ", position = 90)
	private String productNameEQ;

    /**
     * 产品名称LIKE
     */
    @JsonProperty("n_product_name_like")
    @JSONField(name = "n_product_name_like")
    @ApiModelProperty(value = "产品名称LIKE", position = 91)
	private String productNameLIKE;

    /**
     * 负责人标识EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty(value = "负责人标识EQ", position = 110)
	private String assigneeIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 160)
	private String idEQ;

    /**
     * 客户名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "客户名称LIKE", position = 180)
	private String nameLIKE;

    /**
     * 产品标识EQ
     */
    @JsonProperty("n_product_id_eq")
    @JSONField(name = "n_product_id_eq")
    @ApiModelProperty(value = "产品标识EQ", position = 220)
	private String productIdEQ;


}