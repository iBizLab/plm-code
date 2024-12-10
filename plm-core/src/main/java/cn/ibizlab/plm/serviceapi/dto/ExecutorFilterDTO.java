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
 * 执行人过滤[ExecutorFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行人过滤DTO")
public class ExecutorFilterDTO extends FilterBase implements Serializable {

    /**
     * 所属数据标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty(value = "所属数据标识EQ", position = 0)
	private String ownerIdEQ;

    /**
     * 执行人标识EQ
     */
    @JsonProperty("n_user_id_eq")
    @JSONField(name = "n_user_id_eq")
    @ApiModelProperty(value = "执行人标识EQ", position = 30)
	private String userIdEQ;

    /**
     * 执行人名称EQ
     */
    @JsonProperty("n_user_name_eq")
    @JSONField(name = "n_user_name_eq")
    @ApiModelProperty(value = "执行人名称EQ", position = 50)
	private String userNameEQ;

    /**
     * 执行人名称LIKE
     */
    @JsonProperty("n_user_name_like")
    @JSONField(name = "n_user_name_like")
    @ApiModelProperty(value = "执行人名称LIKE", position = 51)
	private String userNameLIKE;

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


}