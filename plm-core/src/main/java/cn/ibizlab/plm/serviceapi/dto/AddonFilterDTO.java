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
 * 组件过滤[AddonFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("组件过滤DTO")
public class AddonFilterDTO extends FilterBase implements Serializable {

    /**
     * 组件类型EQ
     */
    @JsonProperty("n_addon_type_eq")
    @JSONField(name = "n_addon_type_eq")
    @ApiModelProperty(value = "组件类型EQ", position = 0)
	private String addonTypeEQ;

    /**
     * 所属类型EQ
     */
    @JsonProperty("n_owner_type_eq")
    @JSONField(name = "n_owner_type_eq")
    @ApiModelProperty(value = "所属类型EQ", position = 10)
	private String ownerTypeEQ;

    /**
     * 所属子类型EQ
     */
    @JsonProperty("n_owner_subtype_eq")
    @JSONField(name = "n_owner_subtype_eq")
    @ApiModelProperty(value = "所属子类型EQ", position = 20)
	private String ownerSubtypeEQ;

    /**
     * 所属标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty(value = "所属标识EQ", position = 30)
	private String ownerIdEQ;

    /**
     * 所属标识ISNULL
     */
    @JsonProperty("n_owner_id_isnull")
    @JSONField(name = "n_owner_id_isnull")
    @ApiModelProperty(value = "所属标识ISNULL", position = 31)
	private String ownerIdISNULL;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 80)
	private String idNOTEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 81)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 90)
	private String nameLIKE;


}