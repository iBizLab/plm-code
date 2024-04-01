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
 * 迭代过滤[SprintFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("迭代过滤DTO")
public class SprintFilterDTO extends FilterBase implements Serializable {

    /**
     * 状态EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "状态EQ", position = 30)
	private String statusEQ;

    /**
     * 父名称EQ
     */
    @JsonProperty("n_pname_eq")
    @JSONField(name = "n_pname_eq")
    @ApiModelProperty(value = "父名称EQ", position = 40)
	private String pnameEQ;

    /**
     * 父名称LIKE
     */
    @JsonProperty("n_pname_like")
    @JSONField(name = "n_pname_like")
    @ApiModelProperty(value = "父名称LIKE", position = 41)
	private String pnameLIKE;

    /**
     * 项目名称EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty(value = "项目名称EQ", position = 50)
	private String projectNameEQ;

    /**
     * 项目名称LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty(value = "项目名称LIKE", position = 51)
	private String projectNameLIKE;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty(value = "类别LIKE", position = 60)
	private String categoriesLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 90)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 100)
	private String nameLIKE;

    /**
     * 产品标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "产品标识EQ", position = 150)
	private String projectIdEQ;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty(value = "父标识EQ", position = 160)
	private String pidEQ;


}