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
 * 关注过滤[AttentionFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("关注过滤DTO")
public class AttentionFilterDTO extends FilterBase implements Serializable {

    /**
     * 所属数据标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty(value = "所属数据标识EQ", position = 0)
	private String ownerIdEQ;

    /**
     * 所属数据标识EXISTS
     */
    @JsonProperty("n_owner_id_exists__n_owner_id_eq")
    @JSONField(name = "n_owner_id_exists__n_owner_id_eq")
    @ApiModelProperty(value = "所属数据标识EXISTS所属数据标识EQ", position = 1)
	private String ownerIdEXISTSOwner_idEQ;

    /**
     * 所属数据对象EQ
     */
    @JsonProperty("n_owner_type_eq")
    @JSONField(name = "n_owner_type_eq")
    @ApiModelProperty(value = "所属数据对象EQ", position = 10)
	private String ownerTypeEQ;

    /**
     * 所属对象子类型EQ
     */
    @JsonProperty("n_owner_subtype_eq")
    @JSONField(name = "n_owner_subtype_eq")
    @ApiModelProperty(value = "所属对象子类型EQ", position = 20)
	private String ownerSubtypeEQ;

    /**
     * 关注人EQ
     */
    @JsonProperty("n_user_id_eq")
    @JSONField(name = "n_user_id_eq")
    @ApiModelProperty(value = "关注人EQ", position = 30)
	private String userIdEQ;

    /**
     * 关注类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "关注类型EQ", position = 40)
	private String typeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 50)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 60)
	private String nameLIKE;


}