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
 * 讨论回复过滤[DiscussReplyFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("讨论回复过滤DTO")
public class DiscussReplyFilterDTO extends FilterBase implements Serializable {

    /**
     * 话题标识EQ
     */
    @JsonProperty("n_topic_id_eq")
    @JSONField(name = "n_topic_id_eq")
    @ApiModelProperty(value = "话题标识EQ", position = 40)
	private String topicIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 60)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 70)
	private String nameLIKE;

    /**
     * 讨论标识EQ
     */
    @JsonProperty("n_post_id_eq")
    @JSONField(name = "n_post_id_eq")
    @ApiModelProperty(value = "讨论标识EQ", position = 120)
	private String postIdEQ;


}