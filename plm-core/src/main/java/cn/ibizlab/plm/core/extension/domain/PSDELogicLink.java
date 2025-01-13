/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
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
import cn.ibizlab.plm.core.extension.domain.PSDELogicNode;
import cn.ibizlab.plm.core.extension.domain.PSDELogic;
import cn.ibizlab.plm.core.extension.domain.PSDEMSLogic;

/**
 * 实体处理逻辑链接实体类[PSDELogicLink]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDELOGICLINK", description = "实体处理逻辑链接")
public class PSDELogicLink extends EntityBase implements Serializable
{
    /**
     * 实体处理逻辑链接标识
     */
    @Id
    @DEField(name = "psdelogiclinkid" , isKeyField = true)
    @JSONField(name = "psdelogiclinkid")
    @JsonProperty("psdelogiclinkid")
    @ApiModelProperty(value = "psdelogiclinkid", notes = "实体处理逻辑链接标识")
    private String psdeLogicLinkId;

    /**
     * 连接名称
     */
    @DEField(name = "psdelogiclinkname")
    @JSONField(name = "psdelogiclinkname")
    @JsonProperty("psdelogiclinkname")
    @ApiModelProperty(value = "psdelogiclinkname", notes = "连接名称")
    private String psdeLogicLinkName;

    /**
     * 目标节点
     */
    @DEField(name = "dstpsdelogicnodename")
    @JSONField(name = "dstpsdelogicnodename")
    @JsonProperty("dstpsdelogicnodename")
    @ApiModelProperty(value = "dstpsdelogicnodename", notes = "目标节点")
    private String dstPsdeLogicNodeName;

    /**
     * 目标节点
     */
    @DEField(name = "dstpsdelogicnodeid")
    @JSONField(name = "dstpsdelogicnodeid")
    @JsonProperty("dstpsdelogicnodeid")
    @ApiModelProperty(value = "dstpsdelogicnodeid", notes = "目标节点")
    private String dstPsdeLogicNodeId;

    /**
     * 源节点
     */
    @DEField(name = "srcpsdelogicnodename")
    @JSONField(name = "srcpsdelogicnodename")
    @JsonProperty("srcpsdelogicnodename")
    @ApiModelProperty(value = "srcpsdelogicnodename", notes = "源节点")
    private String srcPsdeLogicNodeName;

    /**
     * 源节点
     */
    @DEField(name = "srcpsdelogicnodeid")
    @JSONField(name = "srcpsdelogicnodeid")
    @JsonProperty("srcpsdelogicnodeid")
    @ApiModelProperty(value = "srcpsdelogicnodeid", notes = "源节点")
    private String srcPsdeLogicNodeId;

    /**
     * 实体处理逻辑
     */
    @DEField(name = "psdelogicname")
    @JSONField(name = "psdelogicname")
    @JsonProperty("psdelogicname")
    @ApiModelProperty(value = "psdelogicname", notes = "实体处理逻辑")
    private String psdeLogicName;

    /**
     * 实体处理逻辑
     */
    @DEField(name = "psdelogicid")
    @JSONField(name = "psdelogicid")
    @JsonProperty("psdelogicid")
    @ApiModelProperty(value = "psdelogicid", notes = "实体处理逻辑")
    private String psdeLogicId;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "dstpsdelogicnode", notes = "")
    private PSDELogicNode dstPsdeLogicNode;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "srcpsdelogicnode", notes = "")
    private PSDELogicNode srcPsdeLogicNode;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "psdelogic", notes = "")
    private PSDELogic psdeLogic;

    /**
     * 主状态-连接
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "psdemslogic", notes = "主状态-连接")
    private PSDEMSLogic psdemslogic;

    /**
    * 设置 [连接名称]
    */
    public PSDELogicLink setPsdeLogicLinkName(String psdeLogicLinkName) {
        this.psdeLogicLinkName = psdeLogicLinkName;
        this.modify("psdelogiclinkname", psdeLogicLinkName);
        return this;
    }

    /**
    * 设置 [目标节点]
    */
    public PSDELogicLink setDstPsdeLogicNodeName(String dstPsdeLogicNodeName) {
        this.dstPsdeLogicNodeName = dstPsdeLogicNodeName;
        this.modify("dstpsdelogicnodename", dstPsdeLogicNodeName);
        return this;
    }

    /**
    * 设置 [目标节点]
    */
    public PSDELogicLink setDstPsdeLogicNodeId(String dstPsdeLogicNodeId) {
        this.dstPsdeLogicNodeId = dstPsdeLogicNodeId;
        this.modify("dstpsdelogicnodeid", dstPsdeLogicNodeId);
        return this;
    }

    /**
    * 设置 [源节点]
    */
    public PSDELogicLink setSrcPsdeLogicNodeName(String srcPsdeLogicNodeName) {
        this.srcPsdeLogicNodeName = srcPsdeLogicNodeName;
        this.modify("srcpsdelogicnodename", srcPsdeLogicNodeName);
        return this;
    }

    /**
    * 设置 [源节点]
    */
    public PSDELogicLink setSrcPsdeLogicNodeId(String srcPsdeLogicNodeId) {
        this.srcPsdeLogicNodeId = srcPsdeLogicNodeId;
        this.modify("srcpsdelogicnodeid", srcPsdeLogicNodeId);
        return this;
    }

    /**
    * 设置 [实体处理逻辑]
    */
    public PSDELogicLink setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
    * 设置 [实体处理逻辑]
    */
    public PSDELogicLink setPsdeLogicId(String psdeLogicId) {
        this.psdeLogicId = psdeLogicId;
        this.modify("psdelogicid", psdeLogicId);
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
            entity.reset("psdelogiclinkid");
        }
        return targetEntity;
    }

}