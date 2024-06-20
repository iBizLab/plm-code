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
 * 实体处理逻辑过滤[PSDELogicFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体处理逻辑过滤DTO")
public class PSDELogicFilterDTO extends FilterBase implements Serializable {

    /**
     * 扩展状态EQ
     */
    @JsonProperty("n_applyflag_eq")
    @JSONField(name = "n_applyflag_eq")
    @ApiModelProperty(value = "扩展状态EQ", position = 0)
	private Integer applyflagEQ;

    /**
     * 扩展模型EQ
     */
    @JsonProperty("n_dynamodelflag_eq")
    @JSONField(name = "n_dynamodelflag_eq")
    @ApiModelProperty(value = "扩展模型EQ", position = 30)
	private Integer dynaModelFlagEQ;

    /**
     * 实体处理逻辑标识EQ
     */
    @JsonProperty("n_psdelogicid_eq")
    @JSONField(name = "n_psdelogicid_eq")
    @ApiModelProperty(value = "实体处理逻辑标识EQ", position = 160)
	private String psdeLogicIdEQ;

    /**
     * 规则名称LIKE
     */
    @JsonProperty("n_psdelogicname_like")
    @JSONField(name = "n_psdelogicname_like")
    @ApiModelProperty(value = "规则名称LIKE", position = 170)
	private String psdeLogicNameLIKE;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdeid_eq")
    @JSONField(name = "n_psdeid_eq")
    @ApiModelProperty(value = "实体EQ", position = 220)
	private String psdeidEQ;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdename_eq")
    @JSONField(name = "n_psdename_eq")
    @ApiModelProperty(value = "实体EQ", position = 230)
	private String psdeNameEQ;

    /**
     * 实体LIKE
     */
    @JsonProperty("n_psdename_like")
    @JSONField(name = "n_psdename_like")
    @ApiModelProperty(value = "实体LIKE", position = 231)
	private String psdeNameLIKE;

    /**
     * 逻辑子类EQ
     */
    @JsonProperty("n_logicsubtype_eq")
    @JSONField(name = "n_logicsubtype_eq")
    @ApiModelProperty(value = "逻辑子类EQ", position = 250)
	private String logicSubTypeEQ;

    /**
     * 逻辑子类IN
     */
    @JsonProperty("n_logicsubtype_in")
    @JSONField(name = "n_logicsubtype_in")
    @ApiModelProperty(value = "逻辑子类IN", position = 251)
	private String logicSubTypeIN;

    /**
     * 逻辑子类NOTEQ
     */
    @JsonProperty("n_logicsubtype_noteq")
    @JSONField(name = "n_logicsubtype_noteq")
    @ApiModelProperty(value = "逻辑子类NOTEQ", position = 252)
	private String logicSubTypeNOTEQ;


}