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
 * 版本过滤[VersionFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("版本过滤DTO")
public class VersionFilterDTO extends FilterBase implements Serializable {

    /**
     * 所属数据标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty(value = "所属数据标识EQ", position = 10)
	private String ownerIdEQ;

    /**
     * 所属数据标识IN
     */
    @JsonProperty("n_owner_id_in")
    @JSONField(name = "n_owner_id_in")
    @ApiModelProperty(value = "所属数据标识IN", position = 11)
	private String ownerIdIN;

    /**
     * 所属数据对象EQ
     */
    @JsonProperty("n_owner_type_eq")
    @JSONField(name = "n_owner_type_eq")
    @ApiModelProperty(value = "所属数据对象EQ", position = 20)
	private String ownerTypeEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty(value = "标识IN", position = 70)
	private String idIN;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 71)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 80)
	private String nameLIKE;


}