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
 * 通知事件过滤[NotifyEventFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("通知事件过滤DTO")
public class NotifyEventFilterDTO extends FilterBase implements Serializable {

    /**
     * 消息类型EQ
     */
    @JsonProperty("n_msg_type_eq")
    @JSONField(name = "n_msg_type_eq")
    @ApiModelProperty(value = "消息类型EQ", position = 0)
	private Integer msgTypeEQ;

    /**
     * 事件分类EQ
     */
    @JsonProperty("n_group_eq")
    @JSONField(name = "n_group_eq")
    @ApiModelProperty(value = "事件分类EQ", position = 10)
	private String groupEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 20)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 30)
	private String nameLIKE;


}