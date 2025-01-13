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
 * 效能成员过滤[InsightMemberFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("效能成员过滤DTO")
public class InsightMemberFilterDTO extends FilterBase implements Serializable {

    /**
     * 所属数据对象EQ
     */
    @JsonProperty("n_owner_type_eq")
    @JSONField(name = "n_owner_type_eq")
    @ApiModelProperty(value = "所属数据对象EQ", position = 0)
	private String ownerTypeEQ;

    /**
     * 角色EQ
     */
    @JsonProperty("n_role_id_eq")
    @JSONField(name = "n_role_id_eq")
    @ApiModelProperty(value = "角色EQ", position = 20)
	private String roleIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 40)
	private String idEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_name_eq")
    @JSONField(name = "n_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 50)
	private String nameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 51)
	private String nameLIKE;

    /**
     * 用户标识EQ
     */
    @JsonProperty("n_user_id_eq")
    @JSONField(name = "n_user_id_eq")
    @ApiModelProperty(value = "用户标识EQ", position = 100)
	private String userIdEQ;

    /**
     * 效能标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty(value = "效能标识EQ", position = 110)
	private String ownerIdEQ;


}