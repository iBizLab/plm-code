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
 * 企业用户过滤[UserFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("企业用户过滤DTO")
public class UserFilterDTO extends FilterBase implements Serializable {

    /**
     * 显示名称LIKE
     */
    @JsonProperty("n_display_name_like")
    @JSONField(name = "n_display_name_like")
    @ApiModelProperty(value = "显示名称LIKE", position = 0)
	private String displayNameLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 70)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 80)
	private String nameLIKE;

    /**
     * 部门标识EQ
     */
    @JsonProperty("n_department_id_eq")
    @JSONField(name = "n_department_id_eq")
    @ApiModelProperty(value = "部门标识EQ", position = 130)
	private String departmentIdEQ;

    /**
     * 岗位标识EQ
     */
    @JsonProperty("n_job_id_eq")
    @JSONField(name = "n_job_id_eq")
    @ApiModelProperty(value = "岗位标识EQ", position = 140)
	private String jobIdEQ;

    /**
     * 职位名称EQ
     */
    @JsonProperty("n_job_name_eq")
    @JSONField(name = "n_job_name_eq")
    @ApiModelProperty(value = "职位名称EQ", position = 150)
	private String jobNameEQ;

    /**
     * 职位名称LIKE
     */
    @JsonProperty("n_job_name_like")
    @JSONField(name = "n_job_name_like")
    @ApiModelProperty(value = "职位名称LIKE", position = 151)
	private String jobNameLIKE;

    /**
     * 部门名称EQ
     */
    @JsonProperty("n_department_name_eq")
    @JSONField(name = "n_department_name_eq")
    @ApiModelProperty(value = "部门名称EQ", position = 160)
	private String departmentNameEQ;

    /**
     * 部门名称LIKE
     */
    @JsonProperty("n_department_name_like")
    @JSONField(name = "n_department_name_like")
    @ApiModelProperty(value = "部门名称LIKE", position = 161)
	private String departmentNameLIKE;


}