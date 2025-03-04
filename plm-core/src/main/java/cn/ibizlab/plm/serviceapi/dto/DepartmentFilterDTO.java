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
 * 部门过滤[DepartmentFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("部门过滤DTO")
public class DepartmentFilterDTO extends FilterBase implements Serializable {

    /**
     * 父名称EQ
     */
    @JsonProperty("n_pname_eq")
    @JSONField(name = "n_pname_eq")
    @ApiModelProperty(value = "父名称EQ", position = 40)
	private String pnameEQ;

    /**
     * 父名称LIKE
     */
    @JsonProperty("n_pname_like")
    @JSONField(name = "n_pname_like")
    @ApiModelProperty(value = "父名称LIKE", position = 41)
	private String pnameLIKE;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 50)
	private String idNOTEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 51)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 60)
	private String nameLIKE;

    /**
     * 部门负责人标识EQ
     */
    @JsonProperty("n_head_id_eq")
    @JSONField(name = "n_head_id_eq")
    @ApiModelProperty(value = "部门负责人标识EQ", position = 110)
	private String headIdEQ;

    /**
     * 父部门标识EQ
     */
    @JsonProperty("n_parent_id_eq")
    @JSONField(name = "n_parent_id_eq")
    @ApiModelProperty(value = "父部门标识EQ", position = 120)
	private String parentIdEQ;

    /**
     * 组织标识EQ
     */
    @JsonProperty("n_organization_id_eq")
    @JSONField(name = "n_organization_id_eq")
    @ApiModelProperty(value = "组织标识EQ", position = 130)
	private String organizationIdEQ;


}