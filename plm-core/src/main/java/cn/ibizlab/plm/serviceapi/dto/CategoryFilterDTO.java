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
 * 类别过滤[CategoryFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("类别过滤DTO")
public class CategoryFilterDTO extends FilterBase implements Serializable {

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
    @ApiModelProperty(value = "所属数据对象EQ", position = 20)
	private String ownerTypeEQ;

    /**
     * 所属对象子类型EQ
     */
    @JsonProperty("n_owner_subtype_eq")
    @JSONField(name = "n_owner_subtype_eq")
    @ApiModelProperty(value = "所属对象子类型EQ", position = 30)
	private String ownerSubtypeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 80)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 90)
	private String nameLIKE;

    /**
     * 分组标识EQ
     */
    @JsonProperty("n_section_id_eq")
    @JSONField(name = "n_section_id_eq")
    @ApiModelProperty(value = "分组标识EQ", position = 120)
	private String sectionIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_section_name_eq")
    @JSONField(name = "n_section_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 130)
	private String sectionNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_section_name_like")
    @JSONField(name = "n_section_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 131)
	private String sectionNameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty(value = "父标识EQ", position = 140)
	private String pidEQ;

    /**
     * 父标识ISNOTNULL
     */
    @JsonProperty("n_pid_isnotnull")
    @JSONField(name = "n_pid_isnotnull")
    @ApiModelProperty(value = "父标识ISNOTNULL", position = 141)
	private String pidISNOTNULL;

    /**
     * 父标识ISNULL
     */
    @JsonProperty("n_pid_isnull")
    @JSONField(name = "n_pid_isnull")
    @ApiModelProperty(value = "父标识ISNULL", position = 142)
	private String pidISNULL;


}