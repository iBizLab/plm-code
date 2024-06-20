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
 * 流程准则过滤[GuidelineFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("流程准则过滤DTO")
public class GuidelineFilterDTO extends FilterBase implements Serializable {

    /**
     * 所属主体标识EQ
     */
    @JsonProperty("n_scope_id_eq")
    @JSONField(name = "n_scope_id_eq")
    @ApiModelProperty(value = "所属主体标识EQ", position = 0)
	private String scopeIdEQ;

    /**
     * 所属主体标识ISNULL
     */
    @JsonProperty("n_scope_id_isnull")
    @JSONField(name = "n_scope_id_isnull")
    @ApiModelProperty(value = "所属主体标识ISNULL", position = 1)
	private String scopeIdISNULL;

    /**
     * 对象类型EQ
     */
    @JsonProperty("n_object_type_eq")
    @JSONField(name = "n_object_type_eq")
    @ApiModelProperty(value = "对象类型EQ", position = 10)
	private String objectTypeEQ;

    /**
     * 主题类型EQ
     */
    @JsonProperty("n_subject_type_eq")
    @JSONField(name = "n_subject_type_eq")
    @ApiModelProperty(value = "主题类型EQ", position = 20)
	private String subjectTypeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 70)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 80)
	private String nameLIKE;


}