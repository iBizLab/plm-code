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
     * 职位EQ
     */
    @JsonProperty("n_title_eq")
    @JSONField(name = "n_title_eq")
    @ApiModelProperty(value = "职位EQ", position = 90)
	private String titleEQ;

    /**
     * 标识NOTIN
     */
    @JsonProperty("n_id_notin")
    @JSONField(name = "n_id_notin")
    @ApiModelProperty(value = "标识NOTIN", position = 100)
	private String idNOTIN;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 101)
	private String idEQ;

    /**
     * 登录名LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "登录名LIKE", position = 110)
	private String nameLIKE;

    /**
     * 部门标识EQ
     */
    @JsonProperty("n_department_id_eq")
    @JSONField(name = "n_department_id_eq")
    @ApiModelProperty(value = "部门标识EQ", position = 160)
	private String departmentIdEQ;

    /**
     * 部门标识ISNULL
     */
    @JsonProperty("n_department_id_isnull")
    @JSONField(name = "n_department_id_isnull")
    @ApiModelProperty(value = "部门标识ISNULL", position = 161)
	private String departmentIdISNULL;

    /**
     * 岗位标识EQ
     */
    @JsonProperty("n_job_id_eq")
    @JSONField(name = "n_job_id_eq")
    @ApiModelProperty(value = "岗位标识EQ", position = 170)
	private String jobIdEQ;

    /**
     * 职位名称EQ
     */
    @JsonProperty("n_job_name_eq")
    @JSONField(name = "n_job_name_eq")
    @ApiModelProperty(value = "职位名称EQ", position = 180)
	private String jobNameEQ;

    /**
     * 职位名称LIKE
     */
    @JsonProperty("n_job_name_like")
    @JSONField(name = "n_job_name_like")
    @ApiModelProperty(value = "职位名称LIKE", position = 181)
	private String jobNameLIKE;

    /**
     * 部门名称EQ
     */
    @JsonProperty("n_department_name_eq")
    @JSONField(name = "n_department_name_eq")
    @ApiModelProperty(value = "部门名称EQ", position = 190)
	private String departmentNameEQ;

    /**
     * 部门名称LIKE
     */
    @JsonProperty("n_department_name_like")
    @JSONField(name = "n_department_name_like")
    @ApiModelProperty(value = "部门名称LIKE", position = 191)
	private String departmentNameLIKE;

    /**
     * 组织标识EQ
     */
    @JsonProperty("n_organization_id_eq")
    @JSONField(name = "n_organization_id_eq")
    @ApiModelProperty(value = "组织标识EQ", position = 200)
	private String organizationIdEQ;

    /**
     * 组织名称EQ
     */
    @JsonProperty("n_organization_name_eq")
    @JSONField(name = "n_organization_name_eq")
    @ApiModelProperty(value = "组织名称EQ", position = 210)
	private String organizationNameEQ;

    /**
     * 组织名称LIKE
     */
    @JsonProperty("n_organization_name_like")
    @JSONField(name = "n_organization_name_like")
    @ApiModelProperty(value = "组织名称LIKE", position = 211)
	private String organizationNameLIKE;


}