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
 * 实体处理逻辑链接过滤[PSDELogicLinkFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体处理逻辑链接过滤DTO")
public class PSDELogicLinkFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体处理逻辑链接标识EQ
     */
    @JsonProperty("n_psdelogiclinkid_eq")
    @JSONField(name = "n_psdelogiclinkid_eq")
    @ApiModelProperty(value = "实体处理逻辑链接标识EQ", position = 0)
	private String psdeLogicLinkIdEQ;

    /**
     * 连接名称LIKE
     */
    @JsonProperty("n_psdelogiclinkname_like")
    @JSONField(name = "n_psdelogiclinkname_like")
    @ApiModelProperty(value = "连接名称LIKE", position = 10)
	private String psdeLogicLinkNameLIKE;

    /**
     * 目标节点EQ
     */
    @JsonProperty("n_dstpsdelogicnodename_eq")
    @JSONField(name = "n_dstpsdelogicnodename_eq")
    @ApiModelProperty(value = "目标节点EQ", position = 20)
	private String dstPsdeLogicNodeNameEQ;

    /**
     * 目标节点LIKE
     */
    @JsonProperty("n_dstpsdelogicnodename_like")
    @JSONField(name = "n_dstpsdelogicnodename_like")
    @ApiModelProperty(value = "目标节点LIKE", position = 21)
	private String dstPsdeLogicNodeNameLIKE;

    /**
     * 目标节点EQ
     */
    @JsonProperty("n_dstpsdelogicnodeid_eq")
    @JSONField(name = "n_dstpsdelogicnodeid_eq")
    @ApiModelProperty(value = "目标节点EQ", position = 30)
	private String dstPsdeLogicNodeIdEQ;

    /**
     * 源节点EQ
     */
    @JsonProperty("n_srcpsdelogicnodename_eq")
    @JSONField(name = "n_srcpsdelogicnodename_eq")
    @ApiModelProperty(value = "源节点EQ", position = 40)
	private String srcPsdeLogicNodeNameEQ;

    /**
     * 源节点LIKE
     */
    @JsonProperty("n_srcpsdelogicnodename_like")
    @JSONField(name = "n_srcpsdelogicnodename_like")
    @ApiModelProperty(value = "源节点LIKE", position = 41)
	private String srcPsdeLogicNodeNameLIKE;

    /**
     * 源节点EQ
     */
    @JsonProperty("n_srcpsdelogicnodeid_eq")
    @JSONField(name = "n_srcpsdelogicnodeid_eq")
    @ApiModelProperty(value = "源节点EQ", position = 50)
	private String srcPsdeLogicNodeIdEQ;

    /**
     * 实体处理逻辑EQ
     */
    @JsonProperty("n_psdelogicname_eq")
    @JSONField(name = "n_psdelogicname_eq")
    @ApiModelProperty(value = "实体处理逻辑EQ", position = 60)
	private String psdeLogicNameEQ;

    /**
     * 实体处理逻辑LIKE
     */
    @JsonProperty("n_psdelogicname_like")
    @JSONField(name = "n_psdelogicname_like")
    @ApiModelProperty(value = "实体处理逻辑LIKE", position = 61)
	private String psdeLogicNameLIKE;

    /**
     * 实体处理逻辑EQ
     */
    @JsonProperty("n_psdelogicid_eq")
    @JSONField(name = "n_psdelogicid_eq")
    @ApiModelProperty(value = "实体处理逻辑EQ", position = 70)
	private String psdeLogicIdEQ;


}