/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体处理逻辑链接[PSDELogicLinkDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体处理逻辑链接DTO")
public class PSDELogicLinkDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 目标节点
     */
    @JsonProperty("dstpsdelogicnodeid")
    @JSONField(name = "dstpsdelogicnodeid")
    @ApiModelProperty(value = "目标节点", position = 0)
    private String dstPsdeLogicNodeId;

    /**
     * 目标节点
     */
    @JsonProperty("dstpsdelogicnodename")
    @JSONField(name = "dstpsdelogicnodename")
    @ApiModelProperty(value = "目标节点", position = 1)
    private String dstPsdeLogicNodeName;

    /**
     * 实体处理逻辑
     */
    @JsonProperty("psdelogicid")
    @JSONField(name = "psdelogicid")
    @ApiModelProperty(value = "实体处理逻辑", position = 2)
    private String psdeLogicId;

    /**
     * 实体处理逻辑链接标识
     */
    @JsonProperty("psdelogiclinkid")
    @JSONField(name = "psdelogiclinkid")
    @ApiModelProperty(value = "实体处理逻辑链接标识", position = 3)
    private String psdeLogicLinkId;

    /**
     * 连接名称
     */
    @JsonProperty("psdelogiclinkname")
    @JSONField(name = "psdelogiclinkname")
    @ApiModelProperty(value = "连接名称", position = 4)
    private String psdeLogicLinkName;

    /**
     * 实体处理逻辑
     */
    @JsonProperty("psdelogicname")
    @JSONField(name = "psdelogicname")
    @ApiModelProperty(value = "实体处理逻辑", position = 5)
    private String psdeLogicName;

    /**
     * 源节点
     */
    @JsonProperty("srcpsdelogicnodeid")
    @JSONField(name = "srcpsdelogicnodeid")
    @ApiModelProperty(value = "源节点", position = 6)
    private String srcPsdeLogicNodeId;

    /**
     * 源节点
     */
    @JsonProperty("srcpsdelogicnodename")
    @JSONField(name = "srcpsdelogicnodename")
    @ApiModelProperty(value = "源节点", position = 7)
    private String srcPsdeLogicNodeName;


    /**
     * 设置 [目标节点]
     */
    public PSDELogicLinkDTO setDstPsdeLogicNodeId(String dstPsdeLogicNodeId) {
        this.dstPsdeLogicNodeId = dstPsdeLogicNodeId;
        this.modify("dstpsdelogicnodeid", dstPsdeLogicNodeId);
        return this;
    }

    /**
     * 设置 [目标节点]
     */
    public PSDELogicLinkDTO setDstPsdeLogicNodeName(String dstPsdeLogicNodeName) {
        this.dstPsdeLogicNodeName = dstPsdeLogicNodeName;
        this.modify("dstpsdelogicnodename", dstPsdeLogicNodeName);
        return this;
    }

    /**
     * 设置 [实体处理逻辑]
     */
    public PSDELogicLinkDTO setPsdeLogicId(String psdeLogicId) {
        this.psdeLogicId = psdeLogicId;
        this.modify("psdelogicid", psdeLogicId);
        return this;
    }

    /**
     * 设置 [连接名称]
     */
    public PSDELogicLinkDTO setPsdeLogicLinkName(String psdeLogicLinkName) {
        this.psdeLogicLinkName = psdeLogicLinkName;
        this.modify("psdelogiclinkname", psdeLogicLinkName);
        return this;
    }

    /**
     * 设置 [实体处理逻辑]
     */
    public PSDELogicLinkDTO setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
     * 设置 [源节点]
     */
    public PSDELogicLinkDTO setSrcPsdeLogicNodeId(String srcPsdeLogicNodeId) {
        this.srcPsdeLogicNodeId = srcPsdeLogicNodeId;
        this.modify("srcpsdelogicnodeid", srcPsdeLogicNodeId);
        return this;
    }

    /**
     * 设置 [源节点]
     */
    public PSDELogicLinkDTO setSrcPsdeLogicNodeName(String srcPsdeLogicNodeName) {
        this.srcPsdeLogicNodeName = srcPsdeLogicNodeName;
        this.modify("srcpsdelogicnodename", srcPsdeLogicNodeName);
        return this;
    }


}
