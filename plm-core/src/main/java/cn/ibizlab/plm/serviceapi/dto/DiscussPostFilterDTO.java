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
 * 讨论过滤[DiscussPostFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("讨论过滤DTO")
public class DiscussPostFilterDTO extends FilterBase implements Serializable {

    /**
     * 状态EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "状态EQ", position = 30)
	private String statusEQ;

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

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 90)
	private String createManEQ;

    /**
     * 话题标识EQ
     */
    @JsonProperty("n_topic_id_eq")
    @JSONField(name = "n_topic_id_eq")
    @ApiModelProperty(value = "话题标识EQ", position = 130)
	private String topicIdEQ;

    /**
     * 话题EQ
     */
    @JsonProperty("n_topic_name_eq")
    @JSONField(name = "n_topic_name_eq")
    @ApiModelProperty(value = "话题EQ", position = 140)
	private String topicNameEQ;

    /**
     * 话题LIKE
     */
    @JsonProperty("n_topic_name_like")
    @JSONField(name = "n_topic_name_like")
    @ApiModelProperty(value = "话题LIKE", position = 141)
	private String topicNameLIKE;


}