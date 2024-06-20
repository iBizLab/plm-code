/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.extension.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import cn.ibizlab.plm.core.extension.domain.PSDELogic;
import cn.ibizlab.plm.core.extension.domain.PSDELogicLink;

/**
 * 实体处理逻辑节点实体类[PSDELogicNode]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDELOGICNODE", description = "实体处理逻辑节点")
public class PSDELogicNode extends EntityBase implements Serializable
{
    /**
     * 实体处理逻辑节点标识
     */
    @Id
    @DEField(name = "psdelogicnodeid" , isKeyField = true)
    @JSONField(name = "psdelogicnodeid")
    @JsonProperty("psdelogicnodeid")
    @ApiModelProperty(value = "psdelogicnodeid", notes = "实体处理逻辑节点标识")
    private String psdeLogicNodeId;

    /**
     * 逻辑处理名称
     */
    @DEField(name = "psdelogicnodename")
    @JSONField(name = "psdelogicnodename")
    @JsonProperty("psdelogicnodename")
    @ApiModelProperty(value = "psdelogicnodename", notes = "逻辑处理名称")
    private String psdeLogicNodeName;

    /**
     * 实体处理逻辑
     */
    @DEField(name = "psdelogicid")
    @JSONField(name = "psdelogicid")
    @JsonProperty("psdelogicid")
    @ApiModelProperty(value = "psdelogicid", notes = "实体处理逻辑")
    private String psdeLogicId;

    /**
     * 实体处理逻辑
     */
    @DEField(name = "psdelogicname")
    @JSONField(name = "psdelogicname")
    @JsonProperty("psdelogicname")
    @ApiModelProperty(value = "psdelogicname", notes = "实体处理逻辑")
    private String psdeLogicName;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "psdelogic", notes = "")
    private PSDELogic psdeLogic;

    /**
    * 设置 [逻辑处理名称]
    */
    public PSDELogicNode setPsdeLogicNodeName(String psdeLogicNodeName) {
        this.psdeLogicNodeName = psdeLogicNodeName;
        this.modify("psdelogicnodename", psdeLogicNodeName);
        return this;
    }

    /**
    * 设置 [实体处理逻辑]
    */
    public PSDELogicNode setPsdeLogicId(String psdeLogicId) {
        this.psdeLogicId = psdeLogicId;
        this.modify("psdelogicid", psdeLogicId);
        return this;
    }

    /**
    * 设置 [实体处理逻辑]
    */
    public PSDELogicNode setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }


    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param includeEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T pasteTo(T targetEntity, boolean includeEmpty) {
        super.pasteTo(targetEntity, includeEmpty);
        if(targetEntity instanceof IEntity) {
            IEntity entity = ((IEntity) targetEntity);
            entity.reset("psdelogicnodeid");
        }
        return targetEntity;
    }

}