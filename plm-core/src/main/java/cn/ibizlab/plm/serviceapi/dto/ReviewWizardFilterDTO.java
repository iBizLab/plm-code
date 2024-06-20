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
 * 评审向导过滤[ReviewWizardFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审向导过滤DTO")
public class ReviewWizardFilterDTO extends FilterBase implements Serializable {

    /**
     * 评审类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "评审类型EQ", position = 10)
	private String typeEQ;

    /**
     * 评审状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "评审状态EQ", position = 60)
	private String stateEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 150)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 160)
	private String nameLIKE;

    /**
     * 流程准则标识EQ
     */
    @JsonProperty("n_guideline_id_eq")
    @JSONField(name = "n_guideline_id_eq")
    @ApiModelProperty(value = "流程准则标识EQ", position = 210)
	private String guidelineIdEQ;

    /**
     * 测试库名称EQ
     */
    @JsonProperty("n_library_name_eq")
    @JSONField(name = "n_library_name_eq")
    @ApiModelProperty(value = "测试库名称EQ", position = 220)
	private String libraryNameEQ;

    /**
     * 测试库名称LIKE
     */
    @JsonProperty("n_library_name_like")
    @JSONField(name = "n_library_name_like")
    @ApiModelProperty(value = "测试库名称LIKE", position = 221)
	private String libraryNameLIKE;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty(value = "测试库标识EQ", position = 230)
	private String libraryIdEQ;


}