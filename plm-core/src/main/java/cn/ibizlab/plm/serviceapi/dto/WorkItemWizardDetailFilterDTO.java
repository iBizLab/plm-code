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
 * 工作项操作向导明细过滤[WorkItemWizardDetailFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项操作向导明细过滤DTO")
public class WorkItemWizardDetailFilterDTO extends FilterBase implements Serializable {

    /**
     * 原工作项类型EQ
     */
    @JsonProperty("n_origin_type_eq")
    @JSONField(name = "n_origin_type_eq")
    @ApiModelProperty(value = "原工作项类型EQ", position = 0)
	private String originTypeEQ;

    /**
     * 目标类型EQ
     */
    @JsonProperty("n_target_type_eq")
    @JSONField(name = "n_target_type_eq")
    @ApiModelProperty(value = "目标类型EQ", position = 10)
	private String targetTypeEQ;

    /**
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty(value = "优先级EQ", position = 110)
	private String priorityEQ;

    /**
     * 子工作项类型EQ
     */
    @JsonProperty("n_child_type_eq")
    @JSONField(name = "n_child_type_eq")
    @ApiModelProperty(value = "子工作项类型EQ", position = 140)
	private String childTypeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 150)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 160)
	private String nameLIKE;

    /**
     * 向导标识EQ
     */
    @JsonProperty("n_wizard_id_eq")
    @JSONField(name = "n_wizard_id_eq")
    @ApiModelProperty(value = "向导标识EQ", position = 210)
	private String wizardIdEQ;


}