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
 * 成员过滤[MemberFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("成员过滤DTO")
public class MemberFilterDTO extends FilterBase implements Serializable {

    /**
     * 所属数据标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty(value = "所属数据标识EQ", position = 0)
	private String ownerIdEQ;

    /**
     * 所属数据对象EQ
     */
    @JsonProperty("n_owner_type_eq")
    @JSONField(name = "n_owner_type_eq")
    @ApiModelProperty(value = "所属数据对象EQ", position = 10)
	private String ownerTypeEQ;

    /**
     * 登录名EQ
     */
    @JsonProperty("n_user_id_eq")
    @JSONField(name = "n_user_id_eq")
    @ApiModelProperty(value = "登录名EQ", position = 20)
	private String userIdEQ;

    /**
     * 登录名NOTIN
     */
    @JsonProperty("n_user_id_notin")
    @JSONField(name = "n_user_id_notin")
    @ApiModelProperty(value = "登录名NOTIN", position = 21)
	private String userIdNOTIN;

    /**
     * 角色EQ
     */
    @JsonProperty("n_role_id_eq")
    @JSONField(name = "n_role_id_eq")
    @ApiModelProperty(value = "角色EQ", position = 40)
	private String roleIdEQ;

    /**
     * 职位名称EQ
     */
    @JsonProperty("n_position_name_eq")
    @JSONField(name = "n_position_name_eq")
    @ApiModelProperty(value = "职位名称EQ", position = 90)
	private String positionNameEQ;

    /**
     * 职位名称LIKE
     */
    @JsonProperty("n_position_name_like")
    @JSONField(name = "n_position_name_like")
    @ApiModelProperty(value = "职位名称LIKE", position = 91)
	private String positionNameLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 110)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 120)
	private String nameLIKE;

    /**
     * 职位标识EQ
     */
    @JsonProperty("n_position_id_eq")
    @JSONField(name = "n_position_id_eq")
    @ApiModelProperty(value = "职位标识EQ", position = 170)
	private String positionIdEQ;


}