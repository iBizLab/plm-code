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

/**
 * 实体处理逻辑实体类[PSDELogic]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDELOGIC", description = "实体处理逻辑")
public class PSDELogic extends EntityBase implements Serializable
{

    /**
     * 扩展状态
     */
    @DEField(name = "applyflag" , dict = "Extension_status")
    @JsonProperty("applyflag")
    @JSONField(name = "applyflag")
    @ApiModelProperty(value = "applyflag", notes = "扩展状态")
    private Integer applyflag;

    /**
     * 附加到指定行为
     */
    @DEField(name = "attachtopsdeactionname")
    @JsonProperty("attachtopsdeactionname")
    @JSONField(name = "attachtopsdeactionname")
    @ApiModelProperty(value = "attachtopsdeactionname", notes = "附加到指定行为")
    private String attachToPsdeActionName;

    /**
     * 附加到指定行为
     */
    @DEField(name = "attachtopsdeactionid")
    @JsonProperty("attachtopsdeactionid")
    @JSONField(name = "attachtopsdeactionid")
    @ApiModelProperty(value = "attachtopsdeactionid", notes = "附加到指定行为")
    private String attachToPsdeActionId;

    /**
     * 扩展模型
     */
    @DEField(name = "dynamodelflag" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("dynamodelflag")
    @JSONField(name = "dynamodelflag")
    @ApiModelProperty(value = "dynamodelflag", notes = "扩展模型")
    private Integer dynaModelFlag;

    /**
     * 附加到指定数据集
     */
    @DEField(name = "attachtopsdedatasetid")
    @JsonProperty("attachtopsdedatasetid")
    @JSONField(name = "attachtopsdedatasetid")
    @ApiModelProperty(value = "attachtopsdedatasetid", notes = "附加到指定数据集")
    private String attachToPsdeDataSetId;

    /**
     * 附加到指定数据集
     */
    @DEField(name = "attachtopsdedatasetname")
    @JsonProperty("attachtopsdedatasetname")
    @JSONField(name = "attachtopsdedatasetname")
    @ApiModelProperty(value = "attachtopsdedatasetname", notes = "附加到指定数据集")
    private String attachToPsdeDataSetName;

    /**
     * 定时触发策略
     */
    @DEField(name = "timerpolicy")
    @JsonProperty("timerpolicy")
    @JSONField(name = "timerpolicy")
    @ApiModelProperty(value = "timerpolicy", notes = "定时触发策略")
    private String timerPolicy;

    /**
     * 最后运行状态
     */
    @DEField(name = "last_state" , dict = "Log_state")
    @JsonProperty("last_state")
    @JSONField(name = "last_state")
    @ApiModelProperty(value = "last_state", notes = "最后运行状态")
    private String lastState;

    /**
     * 监控事件
     */
    @DEField(name = "events" , dict = "Enable_action")
    @JsonProperty("events")
    @JSONField(name = "events")
    @ApiModelProperty(value = "events", notes = "监控事件")
    private String events;

    /**
     * 忽略异常
     */
    @DEField(name = "ignoreexception" , dict = "YesNo")
    @JsonProperty("ignoreexception")
    @JSONField(name = "ignoreexception")
    @ApiModelProperty(value = "ignoreexception", notes = "忽略异常")
    private Integer ignoreException;

    /**
     * 线程模式
     */
    @DEField(name = "threadmode")
    @JsonProperty("threadmode")
    @JSONField(name = "threadmode")
    @ApiModelProperty(value = "threadmode", notes = "线程模式")
    private String threadMode;

    /**
     * 最后运行时间
     */
    @DEField(name = "last_start_at")
    @JsonProperty("last_start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "last_start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "last_start_at", notes = "最后运行时间")
    private Date lastStartAt;

    /**
     * 逻辑参数
     */
    @DEField(name = "psdelogicparams")
    @JsonProperty("psdelogicparams")
    @JSONField(name = "psdelogicparams")
    @ApiModelProperty(value = "psdelogicparams", notes = "逻辑参数")
    private List<Map> psdelogicparams;

    /**
     * 逻辑节点
     */
    @DEField(name = "psdelogicnodes")
    @JsonProperty("psdelogicnodes")
    @JSONField(name = "psdelogicnodes")
    @ApiModelProperty(value = "psdelogicnodes", notes = "逻辑节点")
    private List<Map> psdelogicnodes;

    /**
     * 逻辑连接
     */
    @DEField(name = "psdelogiclinks")
    @JsonProperty("psdelogiclinks")
    @JSONField(name = "psdelogiclinks")
    @ApiModelProperty(value = "psdelogiclinks", notes = "逻辑连接")
    private List<Map> psdelogiclinks;

    /**
     * 实体处理逻辑标识
     */
    @Id
    @DEField(name = "psdelogicid" , isKeyField = true)
    @JsonProperty("psdelogicid")
    @JSONField(name = "psdelogicid")
    @ApiModelProperty(value = "psdelogicid", notes = "实体处理逻辑标识")
    private String psdeLogicId;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 实体处理逻辑名称
     */
    @DEField(name = "psdelogicname")
    @JsonProperty("psdelogicname")
    @JSONField(name = "psdelogicname")
    @ApiModelProperty(value = "psdelogicname", notes = "实体处理逻辑名称")
    private String psdeLogicName;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 代码标识
     */
    @DEField(name = "codename")
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "codename", notes = "代码标识")
    private String codeName;

    /**
     * 逻辑子类
     */
    @DEField(name = "logicsubtype" , dict = "DELogicSubType")
    @JsonProperty("logicsubtype")
    @JSONField(name = "logicsubtype")
    @ApiModelProperty(value = "logicsubtype", notes = "逻辑子类")
    private String logicSubType;

    /**
     * 启用
     */
    @DEField(name = "validflag" , dict = "YesNo")
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 逻辑类型
     */
    @DEField(name = "logictype" , defaultValue = "DELOGIC")
    @JsonProperty("logictype")
    @JSONField(name = "logictype")
    @ApiModelProperty(value = "logictype", notes = "逻辑类型")
    private String logicType;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 扩展标记
     */
    @DEField(name = "extension_tag")
    @JsonProperty("extension_tag")
    @JSONField(name = "extension_tag")
    @ApiModelProperty(value = "extension_tag", notes = "扩展标记")
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @DEField(name = "extension_tag2")
    @JsonProperty("extension_tag2")
    @JSONField(name = "extension_tag2")
    @ApiModelProperty(value = "extension_tag2", notes = "扩展标记2")
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @DEField(name = "extension_tag3")
    @JsonProperty("extension_tag3")
    @JSONField(name = "extension_tag3")
    @ApiModelProperty(value = "extension_tag3", notes = "扩展标记3")
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @DEField(name = "extension_tag4")
    @JsonProperty("extension_tag4")
    @JSONField(name = "extension_tag4")
    @ApiModelProperty(value = "extension_tag4", notes = "扩展标记4")
    private String extensionTag4;


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
            entity.reset("psdelogicid");
        }
        return targetEntity;
    }

}