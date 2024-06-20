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
 * 实体处理逻辑节点过滤[PSDELogicNodeFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体处理逻辑节点过滤DTO")
public class PSDELogicNodeFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体处理逻辑节点标识EQ
     */
    @JsonProperty("n_psdelogicnodeid_eq")
    @JSONField(name = "n_psdelogicnodeid_eq")
    @ApiModelProperty(value = "实体处理逻辑节点标识EQ", position = 0)
	private String psdeLogicNodeIdEQ;

    /**
     * 逻辑处理名称LIKE
     */
    @JsonProperty("n_psdelogicnodename_like")
    @JSONField(name = "n_psdelogicnodename_like")
    @ApiModelProperty(value = "逻辑处理名称LIKE", position = 10)
	private String psdeLogicNodeNameLIKE;

    /**
     * 实体处理逻辑EQ
     */
    @JsonProperty("n_psdelogicid_eq")
    @JSONField(name = "n_psdelogicid_eq")
    @ApiModelProperty(value = "实体处理逻辑EQ", position = 20)
	private String psdeLogicIdEQ;

    /**
     * 实体处理逻辑EQ
     */
    @JsonProperty("n_psdelogicname_eq")
    @JSONField(name = "n_psdelogicname_eq")
    @ApiModelProperty(value = "实体处理逻辑EQ", position = 30)
	private String psdeLogicNameEQ;

    /**
     * 实体处理逻辑LIKE
     */
    @JsonProperty("n_psdelogicname_like")
    @JSONField(name = "n_psdelogicname_like")
    @ApiModelProperty(value = "实体处理逻辑LIKE", position = 31)
	private String psdeLogicNameLIKE;


}