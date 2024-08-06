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
 * 迭代变更过滤[SprintAlterationFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("迭代变更过滤DTO")
public class SprintAlterationFilterDTO extends FilterBase implements Serializable {

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
     * 迭代标识EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty(value = "迭代标识EQ", position = 140)
	private String sprintIdEQ;

    /**
     * 工作项标识EQ
     */
    @JsonProperty("n_work_item_id_eq")
    @JSONField(name = "n_work_item_id_eq")
    @ApiModelProperty(value = "工作项标识EQ", position = 150)
	private String workItemIdEQ;

    /**
     * 标题EQ
     */
    @JsonProperty("n_work_item_title_eq")
    @JSONField(name = "n_work_item_title_eq")
    @ApiModelProperty(value = "标题EQ", position = 160)
	private String workItemTitleEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_work_item_title_like")
    @JSONField(name = "n_work_item_title_like")
    @ApiModelProperty(value = "标题LIKE", position = 161)
	private String workItemTitleLIKE;

    /**
     * 名称EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 170)
	private String sprintNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 171)
	private String sprintNameLIKE;


}