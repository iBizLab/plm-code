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
 * 评审过滤[ReviewFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审过滤DTO")
public class ReviewFilterDTO extends FilterBase implements Serializable {

    /**
     * 评审类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "评审类型EQ", position = 10)
	private String typeEQ;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty(value = "类别LIKE", position = 50)
	private String categoriesLIKE;

    /**
     * 评审状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "评审状态EQ", position = 90)
	private String stateEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 190)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 200)
	private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 210)
	private String createManEQ;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty(value = "测试库标识EQ", position = 250)
	private String libraryIdEQ;

    /**
     * 测试库名称EQ
     */
    @JsonProperty("n_library_name_eq")
    @JSONField(name = "n_library_name_eq")
    @ApiModelProperty(value = "测试库名称EQ", position = 260)
	private String libraryNameEQ;

    /**
     * 测试库名称LIKE
     */
    @JsonProperty("n_library_name_like")
    @JSONField(name = "n_library_name_like")
    @ApiModelProperty(value = "测试库名称LIKE", position = 261)
	private String libraryNameLIKE;

    /**
     * 流程准则标识EQ
     */
    @JsonProperty("n_guideline_id_eq")
    @JSONField(name = "n_guideline_id_eq")
    @ApiModelProperty(value = "流程准则标识EQ", position = 270)
	private String guidelineIdEQ;


}