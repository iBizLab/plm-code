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
 * 产品过滤[ProductFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("产品过滤DTO")
public class ProductFilterDTO extends FilterBase implements Serializable {

    /**
     * 产品标识EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty(value = "产品标识EQ", position = 0)
	private String identifierEQ;

    /**
     * 可见范围EQ
     */
    @JsonProperty("n_visibility_eq")
    @JSONField(name = "n_visibility_eq")
    @ApiModelProperty(value = "可见范围EQ", position = 10)
	private String visibilityEQ;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty(value = "是否已归档EQ", position = 40)
	private Integer isArchivedEQ;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty(value = "是否已删除EQ", position = 50)
	private Integer isDeletedEQ;

    /**
     * 所属EQ
     */
    @JsonProperty("n_scope_type_eq")
    @JSONField(name = "n_scope_type_eq")
    @ApiModelProperty(value = "所属EQ", position = 80)
	private String scopeTypeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 100)
	private String idEQ;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 101)
	private String idNOTEQ;

    /**
     * 产品名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "产品名称LIKE", position = 110)
	private String nameLIKE;


}