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
 * 人员过滤[SysEmployeeFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("人员过滤DTO")
public class SysEmployeeFilterDTO extends FilterBase implements Serializable {

    /**
     * 用户标识EQ
     */
    @JsonProperty("n_userid_eq")
    @JSONField(name = "n_userid_eq")
    @ApiModelProperty(value = "用户标识EQ", position = 0)
	private String userIdEQ;

    /**
     * 姓名LIKE
     */
    @JsonProperty("n_personname_like")
    @JSONField(name = "n_personname_like")
    @ApiModelProperty(value = "姓名LIKE", position = 20)
	private String personNameLIKE;

    /**
     * 性别EQ
     */
    @JsonProperty("n_sex_eq")
    @JSONField(name = "n_sex_eq")
    @ApiModelProperty(value = "性别EQ", position = 150)
	private String sexEQ;

    /**
     * 人员状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "人员状态EQ", position = 540)
	private String stateEQ;


}