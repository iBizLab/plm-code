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
    @ApiModelProperty(value = "实体处理逻辑节点标识EQ", position = 50)
	private String psdeLogicNodeIdEQ;

    /**
     * 逻辑处理名称LIKE
     */
    @JsonProperty("n_psdelogicnodename_like")
    @JSONField(name = "n_psdelogicnodename_like")
    @ApiModelProperty(value = "逻辑处理名称LIKE", position = 60)
	private String psdeLogicNodeNameLIKE;

    /**
     * 实体处理逻辑EQ
     */
    @JsonProperty("n_psdelogicid_eq")
    @JSONField(name = "n_psdelogicid_eq")
    @ApiModelProperty(value = "实体处理逻辑EQ", position = 70)
	private String psdeLogicIdEQ;

    /**
     * 实体处理逻辑EQ
     */
    @JsonProperty("n_psdelogicname_eq")
    @JSONField(name = "n_psdelogicname_eq")
    @ApiModelProperty(value = "实体处理逻辑EQ", position = 80)
	private String psdeLogicNameEQ;

    /**
     * 实体处理逻辑LIKE
     */
    @JsonProperty("n_psdelogicname_like")
    @JSONField(name = "n_psdelogicname_like")
    @ApiModelProperty(value = "实体处理逻辑LIKE", position = 81)
	private String psdeLogicNameLIKE;

    /**
     * 项目标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "项目标识EQ", position = 90)
	private String projectIdEQ;

    /**
     * 项目名称EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty(value = "项目名称EQ", position = 100)
	private String projectNameEQ;

    /**
     * 项目名称LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty(value = "项目名称LIKE", position = 101)
	private String projectNameLIKE;

    /**
     * 逻辑节点类型EQ
     */
    @JsonProperty("n_logicnodetype_eq")
    @JSONField(name = "n_logicnodetype_eq")
    @ApiModelProperty(value = "逻辑节点类型EQ", position = 110)
	private String logicNodeTypeEQ;


}