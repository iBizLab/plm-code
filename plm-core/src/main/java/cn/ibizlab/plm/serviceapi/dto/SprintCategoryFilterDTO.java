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
 * 迭代类别过滤[SprintCategoryFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("迭代类别过滤DTO")
public class SprintCategoryFilterDTO extends FilterBase implements Serializable {

    /**
     * 迭代分组名称EQ
     */
    @JsonProperty("n_section_name_eq")
    @JSONField(name = "n_section_name_eq")
    @ApiModelProperty(value = "迭代分组名称EQ", position = 0)
	private String sectionNameEQ;

    /**
     * 迭代分组名称LIKE
     */
    @JsonProperty("n_section_name_like")
    @JSONField(name = "n_section_name_like")
    @ApiModelProperty(value = "迭代分组名称LIKE", position = 1)
	private String sectionNameLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 10)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 60)
	private String nameLIKE;

    /**
     * 产品标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "产品标识EQ", position = 70)
	private String projectIdEQ;

    /**
     * 迭代分组标识EQ
     */
    @JsonProperty("n_sprint_section_id_eq")
    @JSONField(name = "n_sprint_section_id_eq")
    @ApiModelProperty(value = "迭代分组标识EQ", position = 80)
	private String sprintSectionIdEQ;


}