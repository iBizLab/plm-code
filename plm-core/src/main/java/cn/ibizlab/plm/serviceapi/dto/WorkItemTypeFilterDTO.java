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
 * 工作项类型过滤[WorkItemTypeFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项类型过滤DTO")
public class WorkItemTypeFilterDTO extends FilterBase implements Serializable {

    /**
     * 项目类型EQ
     */
    @JsonProperty("n_project_type_eq")
    @JSONField(name = "n_project_type_eq")
    @ApiModelProperty(value = "项目类型EQ", position = 20)
	private String projectTypeEQ;

    /**
     * 类型分组EQ
     */
    @JsonProperty("n_group_eq")
    @JSONField(name = "n_group_eq")
    @ApiModelProperty(value = "类型分组EQ", position = 30)
	private String groupEQ;

    /**
     * 编码IN
     */
    @JsonProperty("n_code_in")
    @JSONField(name = "n_code_in")
    @ApiModelProperty(value = "编码IN", position = 40)
	private String codeIN;

    /**
     * 标识LIKE
     */
    @JsonProperty("n_id_like")
    @JSONField(name = "n_id_like")
    @ApiModelProperty(value = "标识LIKE", position = 70)
	private String idLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 71)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 80)
	private String nameLIKE;

    /**
     * 项目标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "项目标识EQ", position = 130)
	private String projectIdEQ;


}