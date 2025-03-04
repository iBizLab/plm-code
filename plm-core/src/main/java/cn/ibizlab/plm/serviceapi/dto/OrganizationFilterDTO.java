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
 * 组织过滤[OrganizationFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("组织过滤DTO")
public class OrganizationFilterDTO extends FilterBase implements Serializable {

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 40)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 50)
	private String nameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty(value = "父标识EQ", position = 110)
	private String pidEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_pname_eq")
    @JSONField(name = "n_pname_eq")
    @ApiModelProperty(value = "名称EQ", position = 120)
	private String pnameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_pname_like")
    @JSONField(name = "n_pname_like")
    @ApiModelProperty(value = "名称LIKE", position = 121)
	private String pnameLIKE;


}