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
 * 项目发布过滤[ReleaseFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("项目发布过滤DTO")
public class ReleaseFilterDTO extends FilterBase implements Serializable {

    /**
     * 阶段EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "阶段EQ", position = 30)
	private String statusEQ;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty(value = "类别LIKE", position = 40)
	private String categoriesLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 140)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 150)
	private String nameLIKE;

    /**
     * 项目标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "项目标识EQ", position = 200)
	private String projectIdEQ;

    /**
     * 项目名称EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty(value = "项目名称EQ", position = 210)
	private String projectNameEQ;

    /**
     * 项目名称LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty(value = "项目名称LIKE", position = 211)
	private String projectNameLIKE;


}