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
 * 需求模板过滤[IdeaTemplateFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("需求模板过滤DTO")
public class IdeaTemplateFilterDTO extends FilterBase implements Serializable {

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 20)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 70)
	private String nameLIKE;

    /**
     * 产品EQ
     */
    @JsonProperty("n_product_id_eq")
    @JSONField(name = "n_product_id_eq")
    @ApiModelProperty(value = "产品EQ", position = 80)
	private String productIdEQ;

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
     * 类别标识EQ
     */
    @JsonProperty("n_category_id_eq")
    @JSONField(name = "n_category_id_eq")
    @ApiModelProperty(value = "类别标识EQ", position = 100)
	private String categoryIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_category_name_eq")
    @JSONField(name = "n_category_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 110)
	private String categoryNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_category_name_like")
    @JSONField(name = "n_category_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 111)
	private String categoryNameLIKE;


}