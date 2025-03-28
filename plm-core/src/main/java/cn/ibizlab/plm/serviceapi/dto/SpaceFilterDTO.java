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
 * 空间过滤[SpaceFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("空间过滤DTO")
public class SpaceFilterDTO extends FilterBase implements Serializable {

    /**
     * 可见范围EQ
     */
    @JsonProperty("n_visibility_eq")
    @JSONField(name = "n_visibility_eq")
    @ApiModelProperty(value = "可见范围EQ", position = 10)
	private String visibilityEQ;

    /**
     * 是否开启共享EQ
     */
    @JsonProperty("n_is_shared_eq")
    @JSONField(name = "n_is_shared_eq")
    @ApiModelProperty(value = "是否开启共享EQ", position = 20)
	private String isSharedEQ;

    /**
     * 所属EQ
     */
    @JsonProperty("n_scope_type_eq")
    @JSONField(name = "n_scope_type_eq")
    @ApiModelProperty(value = "所属EQ", position = 80)
	private String scopeTypeEQ;

    /**
     * 所属对象EQ
     */
    @JsonProperty("n_scope_id_eq")
    @JSONField(name = "n_scope_id_eq")
    @ApiModelProperty(value = "所属对象EQ", position = 90)
	private String scopeIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 110)
	private String idEQ;

    /**
     * 空间名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "空间名称LIKE", position = 120)
	private String nameLIKE;

    /**
     * 分类EQ
     */
    @JsonProperty("n_category_id_eq")
    @JSONField(name = "n_category_id_eq")
    @ApiModelProperty(value = "分类EQ", position = 170)
	private String categoryIdEQ;

    /**
     * 分类EQ
     */
    @JsonProperty("n_category_name_eq")
    @JSONField(name = "n_category_name_eq")
    @ApiModelProperty(value = "分类EQ", position = 180)
	private String categoryNameEQ;

    /**
     * 分类LIKE
     */
    @JsonProperty("n_category_name_like")
    @JSONField(name = "n_category_name_like")
    @ApiModelProperty(value = "分类LIKE", position = 181)
	private String categoryNameLIKE;

    /**
     * 用户标记EQ
     */
    @JsonProperty("n_user_tag_eq")
    @JSONField(name = "n_user_tag_eq")
    @ApiModelProperty(value = "用户标记EQ", position = 190)
	private String userTagEQ;

    /**
     * 用户标记LIKE
     */
    @JsonProperty("n_user_tag_like")
    @JSONField(name = "n_user_tag_like")
    @ApiModelProperty(value = "用户标记LIKE", position = 191)
	private String userTagLIKE;

    /**
     * 用户标记2EQ
     */
    @JsonProperty("n_user_tag2_eq")
    @JSONField(name = "n_user_tag2_eq")
    @ApiModelProperty(value = "用户标记2EQ", position = 200)
	private String userTag2EQ;

    /**
     * 用户标记2LIKE
     */
    @JsonProperty("n_user_tag2_like")
    @JSONField(name = "n_user_tag2_like")
    @ApiModelProperty(value = "用户标记2LIKE", position = 201)
	private String userTag2LIKE;


}