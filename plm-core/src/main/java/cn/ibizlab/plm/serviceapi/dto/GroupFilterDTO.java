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
 * 团队过滤[GroupFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("团队过滤DTO")
public class GroupFilterDTO extends FilterBase implements Serializable {

    /**
     * 可见范围EQ
     */
    @JsonProperty("n_visibility_eq")
    @JSONField(name = "n_visibility_eq")
    @ApiModelProperty(value = "可见范围EQ", position = 0)
	private String visibilityEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 40)
	private String idEQ;

    /**
     * 团队名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "团队名称LIKE", position = 50)
	private String nameLIKE;

    /**
     * 分组标识EQ
     */
    @JsonProperty("n_section_id_eq")
    @JSONField(name = "n_section_id_eq")
    @ApiModelProperty(value = "分组标识EQ", position = 100)
	private String sectionIdEQ;

    /**
     * 所属分组EQ
     */
    @JsonProperty("n_section_name_eq")
    @JSONField(name = "n_section_name_eq")
    @ApiModelProperty(value = "所属分组EQ", position = 110)
	private String sectionNameEQ;

    /**
     * 所属分组LIKE
     */
    @JsonProperty("n_section_name_like")
    @JSONField(name = "n_section_name_like")
    @ApiModelProperty(value = "所属分组LIKE", position = 111)
	private String sectionNameLIKE;


}