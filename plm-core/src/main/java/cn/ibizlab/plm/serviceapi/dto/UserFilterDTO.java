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
     * 姓名LIKE
     */
    @JsonProperty("n_display_name_like")
    @JSONField(name = "n_display_name_like")
    @ApiModelProperty(value = "姓名LIKE", position = 0)
	private String displayNameLIKE;

    /**
     * 状态EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "状态EQ", position = 60)
	private String statusEQ;

    /**
     * 标识NOTIN
     */
    @JsonProperty("n_id_notin")
    @JSONField(name = "n_id_notin")
    @ApiModelProperty(value = "标识NOTIN", position = 90)
	private String idNOTIN;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 91)
	private String idEQ;

    /**
     * 登录名LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "登录名LIKE", position = 100)
	private String nameLIKE;

    /**
     * 部门标识EQ
     */
    @JsonProperty("n_department_id_eq")
    @JSONField(name = "n_department_id_eq")
    @ApiModelProperty(value = "部门标识EQ", position = 150)
	private String departmentIdEQ;

    /**
     * 部门标识ISNULL
     */
    @JsonProperty("n_department_id_isnull")
    @JSONField(name = "n_department_id_isnull")
    @ApiModelProperty(value = "部门标识ISNULL", position = 151)
	private String departmentIdISNULL;

    /**
     * 岗位标识EQ
     */
    @JsonProperty("n_job_id_eq")
    @JSONField(name = "n_job_id_eq")
    @ApiModelProperty(value = "岗位标识EQ", position = 160)
	private String jobIdEQ;

    /**
     * 职位名称EQ
     */
    @JsonProperty("n_job_name_eq")
    @JSONField(name = "n_job_name_eq")
    @ApiModelProperty(value = "职位名称EQ", position = 170)
	private String jobNameEQ;

    /**
     * 职位名称LIKE
     */
    @JsonProperty("n_job_name_like")
    @JSONField(name = "n_job_name_like")
    @ApiModelProperty(value = "职位名称LIKE", position = 171)
	private String jobNameLIKE;

    /**
     * 部门名称EQ
     */
    @JsonProperty("n_department_name_eq")
    @JSONField(name = "n_department_name_eq")
    @ApiModelProperty(value = "部门名称EQ", position = 180)
	private String departmentNameEQ;

    /**
     * 部门名称LIKE
     */
    @JsonProperty("n_department_name_like")
    @JSONField(name = "n_department_name_like")
    @ApiModelProperty(value = "部门名称LIKE", position = 181)
	private String departmentNameLIKE;


}