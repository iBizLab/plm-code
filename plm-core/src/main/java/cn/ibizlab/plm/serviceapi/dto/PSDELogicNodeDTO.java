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
 * 实体处理逻辑节点[PSDELogicNodeDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体处理逻辑节点DTO")
public class PSDELogicNodeDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体处理逻辑
     */
    @JsonProperty("psdelogicid")
    @JSONField(name = "psdelogicid")
    @ApiModelProperty(value = "实体处理逻辑", position = 0)
    private String psdeLogicId;

    /**
     * 实体处理逻辑
     */
    @JsonProperty("psdelogicname")
    @JSONField(name = "psdelogicname")
    @ApiModelProperty(value = "实体处理逻辑", position = 1)
    private String psdeLogicName;

    /**
     * 实体处理逻辑节点标识
     */
    @JsonProperty("psdelogicnodeid")
    @JSONField(name = "psdelogicnodeid")
    @ApiModelProperty(value = "实体处理逻辑节点标识", position = 2)
    private String psdeLogicNodeId;

    /**
     * 逻辑处理名称
     */
    @JsonProperty("psdelogicnodename")
    @JSONField(name = "psdelogicnodename")
    @ApiModelProperty(value = "逻辑处理名称", position = 3)
    private String psdeLogicNodeName;


    /**
     * 设置 [实体处理逻辑]
     */
    public PSDELogicNodeDTO setPsdeLogicId(String psdeLogicId) {
        this.psdeLogicId = psdeLogicId;
        this.modify("psdelogicid", psdeLogicId);
        return this;
    }

    /**
     * 设置 [实体处理逻辑]
     */
    public PSDELogicNodeDTO setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
     * 设置 [逻辑处理名称]
     */
    public PSDELogicNodeDTO setPsdeLogicNodeName(String psdeLogicNodeName) {
        this.psdeLogicNodeName = psdeLogicNodeName;
        this.modify("psdelogicnodename", psdeLogicNodeName);
        return this;
    }


}
