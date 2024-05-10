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
 * 实体处理逻辑[PSDELogicDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体处理逻辑DTO")
public class PSDELogicDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展状态
     */
    @JsonProperty("applyflag")
    @JSONField(name = "applyflag")
    @ApiModelProperty(value = "扩展状态", position = 0)
    private Integer applyflag;

    /**
     * 附加到指定行为
     */
    @JsonProperty("attachtopsdeactionid")
    @JSONField(name = "attachtopsdeactionid")
    @ApiModelProperty(value = "附加到指定行为", position = 1)
    private String attachToPsdeActionId;

    /**
     * 附加到指定行为
     */
    @JsonProperty("attachtopsdeactionname")
    @JSONField(name = "attachtopsdeactionname")
    @ApiModelProperty(value = "附加到指定行为", position = 2)
    private String attachToPsdeActionName;

    /**
     * 扩展模型
     */
    @JsonProperty("dynamodelflag")
    @JSONField(name = "dynamodelflag")
    @ApiModelProperty(value = "扩展模型", position = 3)
    private Integer dynaModelFlag;

    /**
     * 附加到指定数据集
     */
    @JsonProperty("attachtopsdedatasetid")
    @JSONField(name = "attachtopsdedatasetid")
    @ApiModelProperty(value = "附加到指定数据集", position = 4)
    private String attachToPsdeDataSetId;

    /**
     * 附加到指定数据集
     */
    @JsonProperty("attachtopsdedatasetname")
    @JSONField(name = "attachtopsdedatasetname")
    @ApiModelProperty(value = "附加到指定数据集", position = 5)
    private String attachToPsdeDataSetName;

    /**
     * 定时触发策略
     */
    @JsonProperty("timerpolicy")
    @JSONField(name = "timerpolicy")
    @ApiModelProperty(value = "定时触发策略", position = 6)
    private String timerPolicy;

    /**
     * 最后运行状态
     */
    @JsonProperty("last_state")
    @JSONField(name = "last_state")
    @ApiModelProperty(value = "最后运行状态", position = 7)
    private String lastState;

    /**
     * 监控事件
     */
    @JsonProperty("events")
    @JSONField(name = "events")
    @ApiModelProperty(value = "监控事件", position = 8)
    private String events;

    /**
     * 忽略异常
     */
    @JsonProperty("ignoreexception")
    @JSONField(name = "ignoreexception")
    @ApiModelProperty(value = "忽略异常", position = 9)
    private Integer ignoreException;

    /**
     * 线程模式
     */
    @JsonProperty("threadmode")
    @JSONField(name = "threadmode")
    @ApiModelProperty(value = "线程模式", position = 10)
    private String threadMode;

    /**
     * 最后运行时间
     */
    @JsonProperty("last_start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "last_start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后运行时间", position = 11)
    private Date lastStartAt;

    /**
     * 逻辑参数
     */
    @JsonProperty("psdelogicparams")
    @JSONField(name = "psdelogicparams")
    @ApiModelProperty(value = "逻辑参数", position = 12)
    private List<Map> psdelogicparams;

    /**
     * 逻辑节点
     */
    @JsonProperty("psdelogicnodes")
    @JSONField(name = "psdelogicnodes")
    @ApiModelProperty(value = "逻辑节点", position = 13)
    private List<Map> psdelogicnodes;

    /**
     * 逻辑连接
     */
    @JsonProperty("psdelogiclinks")
    @JSONField(name = "psdelogiclinks")
    @ApiModelProperty(value = "逻辑连接", position = 14)
    private List<Map> psdelogiclinks;

    /**
     * 代码标识
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码标识", position = 15)
    private String codeName;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 16)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 17)
    private String createMan;

    /**
     * 逻辑子类
     */
    @JsonProperty("logicsubtype")
    @JSONField(name = "logicsubtype")
    @ApiModelProperty(value = "逻辑子类", position = 18)
    private String logicSubType;

    /**
     * 逻辑类型
     */
    @JsonProperty("logictype")
    @JSONField(name = "logictype")
    @ApiModelProperty(value = "逻辑类型", position = 19)
    private String logicType;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 20)
    private String memo;

    /**
     * 实体
     */
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "实体", position = 21)
    private String psdeid;

    /**
     * 实体处理逻辑标识
     */
    @JsonProperty("psdelogicid")
    @JSONField(name = "psdelogicid")
    @ApiModelProperty(value = "实体处理逻辑标识", position = 22)
    private String psdeLogicId;

    /**
     * 名称
     */
    @JsonProperty("psdelogicname")
    @JSONField(name = "psdelogicname")
    @ApiModelProperty(value = "名称", position = 23)
    private String psdeLogicName;

    /**
     * 实体
     */
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "实体", position = 24)
    private String psdeName;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 25)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 26)
    private String updateMan;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 27)
    private Integer validFlag;

    /**
     * 扩展标记
     */
    @JsonProperty("extension_tag")
    @JSONField(name = "extension_tag")
    @ApiModelProperty(value = "扩展标记", position = 28)
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @JsonProperty("extension_tag2")
    @JSONField(name = "extension_tag2")
    @ApiModelProperty(value = "扩展标记2", position = 29)
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @JsonProperty("extension_tag3")
    @JSONField(name = "extension_tag3")
    @ApiModelProperty(value = "扩展标记3", position = 30)
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @JsonProperty("extension_tag4")
    @JSONField(name = "extension_tag4")
    @ApiModelProperty(value = "扩展标记4", position = 31)
    private String extensionTag4;


    /**
     * 设置 [扩展状态]
     */
    public PSDELogicDTO setApplyflag(Integer applyflag) {
        this.applyflag = applyflag;
        this.modify("applyflag", applyflag);
        return this;
    }

    /**
     * 设置 [附加到指定行为]
     */
    public PSDELogicDTO setAttachToPsdeActionId(String attachToPsdeActionId) {
        this.attachToPsdeActionId = attachToPsdeActionId;
        this.modify("attachtopsdeactionid", attachToPsdeActionId);
        return this;
    }

    /**
     * 设置 [附加到指定行为]
     */
    public PSDELogicDTO setAttachToPsdeActionName(String attachToPsdeActionName) {
        this.attachToPsdeActionName = attachToPsdeActionName;
        this.modify("attachtopsdeactionname", attachToPsdeActionName);
        return this;
    }

    /**
     * 设置 [扩展模型]
     */
    public PSDELogicDTO setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
     * 设置 [附加到指定数据集]
     */
    public PSDELogicDTO setAttachToPsdeDataSetId(String attachToPsdeDataSetId) {
        this.attachToPsdeDataSetId = attachToPsdeDataSetId;
        this.modify("attachtopsdedatasetid", attachToPsdeDataSetId);
        return this;
    }

    /**
     * 设置 [附加到指定数据集]
     */
    public PSDELogicDTO setAttachToPsdeDataSetName(String attachToPsdeDataSetName) {
        this.attachToPsdeDataSetName = attachToPsdeDataSetName;
        this.modify("attachtopsdedatasetname", attachToPsdeDataSetName);
        return this;
    }

    /**
     * 设置 [定时触发策略]
     */
    public PSDELogicDTO setTimerPolicy(String timerPolicy) {
        this.timerPolicy = timerPolicy;
        this.modify("timerpolicy", timerPolicy);
        return this;
    }

    /**
     * 设置 [最后运行状态]
     */
    public PSDELogicDTO setLastState(String lastState) {
        this.lastState = lastState;
        this.modify("last_state", lastState);
        return this;
    }

    /**
     * 设置 [监控事件]
     */
    public PSDELogicDTO setEvents(String events) {
        this.events = events;
        this.modify("events", events);
        return this;
    }

    /**
     * 设置 [忽略异常]
     */
    public PSDELogicDTO setIgnoreException(Integer ignoreException) {
        this.ignoreException = ignoreException;
        this.modify("ignoreexception", ignoreException);
        return this;
    }

    /**
     * 设置 [线程模式]
     */
    public PSDELogicDTO setThreadMode(String threadMode) {
        this.threadMode = threadMode;
        this.modify("threadmode", threadMode);
        return this;
    }

    /**
     * 设置 [最后运行时间]
     */
    public PSDELogicDTO setLastStartAt(Date lastStartAt) {
        this.lastStartAt = lastStartAt;
        this.modify("last_start_at", lastStartAt);
        return this;
    }

    /**
     * 设置 [逻辑参数]
     */
    public PSDELogicDTO setPsdelogicparams(List<Map> psdelogicparams) {
        this.psdelogicparams = psdelogicparams;
        this.modify("psdelogicparams", psdelogicparams);
        return this;
    }

    /**
     * 设置 [逻辑节点]
     */
    public PSDELogicDTO setPsdelogicnodes(List<Map> psdelogicnodes) {
        this.psdelogicnodes = psdelogicnodes;
        this.modify("psdelogicnodes", psdelogicnodes);
        return this;
    }

    /**
     * 设置 [逻辑连接]
     */
    public PSDELogicDTO setPsdelogiclinks(List<Map> psdelogiclinks) {
        this.psdelogiclinks = psdelogiclinks;
        this.modify("psdelogiclinks", psdelogiclinks);
        return this;
    }

    /**
     * 设置 [代码标识]
     */
    public PSDELogicDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [逻辑子类]
     */
    public PSDELogicDTO setLogicSubType(String logicSubType) {
        this.logicSubType = logicSubType;
        this.modify("logicsubtype", logicSubType);
        return this;
    }

    /**
     * 设置 [逻辑类型]
     */
    public PSDELogicDTO setLogicType(String logicType) {
        this.logicType = logicType;
        this.modify("logictype", logicType);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSDELogicDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDELogicDTO setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public PSDELogicDTO setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDELogicDTO setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public PSDELogicDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
     * 设置 [扩展标记]
     */
    public PSDELogicDTO setExtensionTag(String extensionTag) {
        this.extensionTag = extensionTag;
        this.modify("extension_tag", extensionTag);
        return this;
    }

    /**
     * 设置 [扩展标记2]
     */
    public PSDELogicDTO setExtensionTag2(String extensionTag2) {
        this.extensionTag2 = extensionTag2;
        this.modify("extension_tag2", extensionTag2);
        return this;
    }

    /**
     * 设置 [扩展标记3]
     */
    public PSDELogicDTO setExtensionTag3(String extensionTag3) {
        this.extensionTag3 = extensionTag3;
        this.modify("extension_tag3", extensionTag3);
        return this;
    }

    /**
     * 设置 [扩展标记4]
     */
    public PSDELogicDTO setExtensionTag4(String extensionTag4) {
        this.extensionTag4 = extensionTag4;
        this.modify("extension_tag4", extensionTag4);
        return this;
    }


}
