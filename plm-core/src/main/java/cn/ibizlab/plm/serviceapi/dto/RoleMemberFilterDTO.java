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
 * 系统角色成员过滤[RoleMemberFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("系统角色成员过滤DTO")
public class RoleMemberFilterDTO extends FilterBase implements Serializable {

    /**
     * 用户组/人员标识EQ
     */
    @JsonProperty("n_member_uid_eq")
    @JSONField(name = "n_member_uid_eq")
    @ApiModelProperty(value = "用户组/人员标识EQ", position = 0)
	private String memberUidEQ;

    /**
     * 系统角色标识EQ
     */
    @JsonProperty("n_role_id_eq")
    @JSONField(name = "n_role_id_eq")
    @ApiModelProperty(value = "系统角色标识EQ", position = 10)
	private String roleIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 20)
	private String idEQ;

    /**
     * 姓名LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "姓名LIKE", position = 30)
	private String nameLIKE;


}