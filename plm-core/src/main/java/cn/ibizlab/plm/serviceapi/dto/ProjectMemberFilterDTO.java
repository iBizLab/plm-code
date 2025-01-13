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
 * 项目成员过滤[ProjectMemberFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("项目成员过滤DTO")
public class ProjectMemberFilterDTO extends FilterBase implements Serializable {

    /**
     * 登录名EQ
     */
    @JsonProperty("n_user_id_eq")
    @JSONField(name = "n_user_id_eq")
    @ApiModelProperty(value = "登录名EQ", position = 0)
	private String userIdEQ;

    /**
     * 登录名NOTIN
     */
    @JsonProperty("n_user_id_notin")
    @JSONField(name = "n_user_id_notin")
    @ApiModelProperty(value = "登录名NOTIN", position = 1)
	private String userIdNOTIN;

    /**
     * 角色EQ
     */
    @JsonProperty("n_role_id_eq")
    @JSONField(name = "n_role_id_eq")
    @ApiModelProperty(value = "角色EQ", position = 10)
	private String roleIdEQ;

    /**
     * 项目名称EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty(value = "项目名称EQ", position = 20)
	private String projectNameEQ;

    /**
     * 项目名称LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty(value = "项目名称LIKE", position = 21)
	private String projectNameLIKE;

    /**
     * 周工作日EQ
     */
    @JsonProperty("n_weekday_eq")
    @JSONField(name = "n_weekday_eq")
    @ApiModelProperty(value = "周工作日EQ", position = 40)
	private Integer weekdayEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 80)
	private String idEQ;

    /**
     * 姓名LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "姓名LIKE", position = 90)
	private String nameLIKE;

    /**
     * 项目标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "项目标识EQ", position = 140)
	private String projectIdEQ;


}