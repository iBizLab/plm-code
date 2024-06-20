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
 * 待办过滤[SysTodoFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("待办过滤DTO")
public class SysTodoFilterDTO extends FilterBase implements Serializable {

    /**
     * 待办标识EQ
     */
    @JsonProperty("n_todoid_eq")
    @JSONField(name = "n_todoid_eq")
    @ApiModelProperty(value = "待办标识EQ", position = 10)
	private String todoIdEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty(value = "标题LIKE", position = 20)
	private String titleLIKE;

    /**
     * 待办地址类型EQ
     */
    @JsonProperty("n_todourltype_eq")
    @JSONField(name = "n_todourltype_eq")
    @ApiModelProperty(value = "待办地址类型EQ", position = 320)
	private String todoUrlTypeEQ;

    /**
     * 待办状态EQ
     */
    @JsonProperty("n_todostate_eq")
    @JSONField(name = "n_todostate_eq")
    @ApiModelProperty(value = "待办状态EQ", position = 330)
	private String todoStateEQ;


}