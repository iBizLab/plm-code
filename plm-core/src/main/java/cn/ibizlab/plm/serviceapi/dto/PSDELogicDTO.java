/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
     * 事件模型
     */
    @JsonProperty("eventmodel")
    @JSONField(name = "eventmodel")
    @ApiModelProperty(value = "事件模型", position = 8)
    private String eventModel;

    /**
     * 监控事件
     */
    @JsonProperty("events")
    @JSONField(name = "events")
    @ApiModelProperty(value = "监控事件", position = 9)
    private String events;

    /**
     * 忽略异常
     */
    @JsonProperty("ignoreexception")
    @JSONField(name = "ignoreexception")
    @ApiModelProperty(value = "忽略异常", position = 10)
    private Integer ignoreException;

    /**
     * 线程模式
     */
    @JsonProperty("threadmode")
    @JSONField(name = "threadmode")
    @ApiModelProperty(value = "线程模式", position = 11)
    private String threadMode;

    /**
     * 最后运行时间
     */
    @JsonProperty("last_start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "last_start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后运行时间", position = 12)
    private Date lastStartAt;

    /**
     * 逻辑参数
     */
    @JsonProperty("psdelogicparams")
    @JSONField(name = "psdelogicparams")
    @ApiModelProperty(value = "逻辑参数", position = 13)
    private List<Map> psdelogicparams;

    /**
     * 逻辑节点
     */
    @JsonProperty("psdelogicnodes")
    @JSONField(name = "psdelogicnodes")
    @ApiModelProperty(value = "逻辑节点", position = 14)
    private List<PSDELogicNodeDTO> psdeLogicNodes;

    /**
     * 逻辑连接
     */
    @JsonProperty("psdelogiclinks")
    @JSONField(name = "psdelogiclinks")
    @ApiModelProperty(value = "逻辑连接", position = 15)
    private List<PSDELogicLinkDTO> psdeLogicLinks;

    /**
     * WebHook地址
     */
    @JsonProperty("webhookurl")
    @JSONField(name = "webhookurl")
    @ApiModelProperty(value = "WebHook地址", position = 16)
    private String webHookUrl;

    /**
     * 成功率
     */
    @JsonProperty("success_per")
    @JSONField(name = "success_per")
    @ApiModelProperty(value = "成功率", position = 17)
    private BigDecimal successPer;

    /**
     * 成功率
     */
    @JsonProperty("success_rate")
    @JSONField(name = "success_rate")
    @ApiModelProperty(value = "成功率", position = 18)
    private BigDecimal successRate;

    /**
     * 失败率
     */
    @JsonProperty("failure_per")
    @JSONField(name = "failure_per")
    @ApiModelProperty(value = "失败率", position = 19)
    private BigDecimal failurePer;

    /**
     * 失败率
     */
    @JsonProperty("failure_rate")
    @JSONField(name = "failure_rate")
    @ApiModelProperty(value = "失败率", position = 20)
    private BigDecimal failureRate;

    /**
     * 代码标识
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码标识", position = 21)
    private String codeName;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 22)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 23)
    private String createMan;

    /**
     * 逻辑子类
     */
    @JsonProperty("logicsubtype")
    @JSONField(name = "logicsubtype")
    @ApiModelProperty(value = "逻辑子类", position = 24)
    private String logicSubType;

    /**
     * 逻辑标记
     */
    @JsonProperty("logictag")
    @JSONField(name = "logictag")
    @ApiModelProperty(value = "逻辑标记", position = 25)
    private String logicTag;

    /**
     * 逻辑标记2
     */
    @JsonProperty("logictag2")
    @JSONField(name = "logictag2")
    @ApiModelProperty(value = "逻辑标记2", position = 26)
    private String logicTag2;

    /**
     * 逻辑标记3
     */
    @JsonProperty("logictag3")
    @JSONField(name = "logictag3")
    @ApiModelProperty(value = "逻辑标记3", position = 27)
    private String logicTag3;

    /**
     * 逻辑标记4
     */
    @JsonProperty("logictag4")
    @JSONField(name = "logictag4")
    @ApiModelProperty(value = "逻辑标记4", position = 28)
    private String logicTag4;

    /**
     * 逻辑类型
     */
    @JsonProperty("logictype")
    @JSONField(name = "logictype")
    @ApiModelProperty(value = "逻辑类型", position = 29)
    private String logicType;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 30)
    private String memo;

    /**
     * 附加次序
     */
    @JsonProperty("ordervalue")
    @JSONField(name = "ordervalue")
    @ApiModelProperty(value = "附加次序", position = 31)
    private Integer orderValue;

    /**
     * 实体
     */
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "实体", position = 32)
    private String psdeid;

    /**
     * 实体处理逻辑标识
     */
    @JsonProperty("psdelogicid")
    @JSONField(name = "psdelogicid")
    @ApiModelProperty(value = "实体处理逻辑标识", position = 33)
    private String psdeLogicId;

    /**
     * 规则名称
     */
    @JsonProperty("psdelogicname")
    @JSONField(name = "psdelogicname")
    @ApiModelProperty(value = "规则名称", position = 34)
    private String psdeLogicName;

    /**
     * 实体
     */
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "实体", position = 35)
    private String psdeName;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 36)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 37)
    private String updateMan;

    /**
     * 用户标记
     */
    @JsonProperty("usertag")
    @JSONField(name = "usertag")
    @ApiModelProperty(value = "用户标记", position = 38)
    private String userTag;

    /**
     * 用户标记2
     */
    @JsonProperty("usertag2")
    @JSONField(name = "usertag2")
    @ApiModelProperty(value = "用户标记2", position = 39)
    private String userTag2;

    /**
     * 用户标记3
     */
    @JsonProperty("usertag3")
    @JSONField(name = "usertag3")
    @ApiModelProperty(value = "用户标记3", position = 40)
    private String userTag3;

    /**
     * 用户标记4
     */
    @JsonProperty("usertag4")
    @JSONField(name = "usertag4")
    @ApiModelProperty(value = "用户标记4", position = 41)
    private String userTag4;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 42)
    private Integer validFlag;

    /**
     * 扩展标记
     */
    @JsonProperty("extension_tag")
    @JSONField(name = "extension_tag")
    @ApiModelProperty(value = "扩展标记", position = 43)
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @JsonProperty("extension_tag2")
    @JSONField(name = "extension_tag2")
    @ApiModelProperty(value = "扩展标记2", position = 44)
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @JsonProperty("extension_tag3")
    @JSONField(name = "extension_tag3")
    @ApiModelProperty(value = "扩展标记3", position = 45)
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @JsonProperty("extension_tag4")
    @JSONField(name = "extension_tag4")
    @ApiModelProperty(value = "扩展标记4", position = 46)
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
     * 设置 [事件模型]
     */
    public PSDELogicDTO setEventModel(String eventModel) {
        this.eventModel = eventModel;
        this.modify("eventmodel", eventModel);
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
    public PSDELogicDTO setPsdeLogicNodes(List<PSDELogicNodeDTO> psdeLogicNodes) {
        this.psdeLogicNodes = psdeLogicNodes;
        this.modify("psdelogicnodes", psdeLogicNodes);
        return this;
    }

    /**
     * 设置 [逻辑连接]
     */
    public PSDELogicDTO setPsdeLogicLinks(List<PSDELogicLinkDTO> psdeLogicLinks) {
        this.psdeLogicLinks = psdeLogicLinks;
        this.modify("psdelogiclinks", psdeLogicLinks);
        return this;
    }

    /**
     * 设置 [WebHook地址]
     */
    public PSDELogicDTO setWebHookUrl(String webHookUrl) {
        this.webHookUrl = webHookUrl;
        this.modify("webhookurl", webHookUrl);
        return this;
    }

    /**
     * 设置 [成功率]
     */
    public PSDELogicDTO setSuccessPer(BigDecimal successPer) {
        this.successPer = successPer;
        this.modify("success_per", successPer);
        return this;
    }

    /**
     * 设置 [成功率]
     */
    public PSDELogicDTO setSuccessRate(BigDecimal successRate) {
        this.successRate = successRate;
        this.modify("success_rate", successRate);
        return this;
    }

    /**
     * 设置 [失败率]
     */
    public PSDELogicDTO setFailurePer(BigDecimal failurePer) {
        this.failurePer = failurePer;
        this.modify("failure_per", failurePer);
        return this;
    }

    /**
     * 设置 [失败率]
     */
    public PSDELogicDTO setFailureRate(BigDecimal failureRate) {
        this.failureRate = failureRate;
        this.modify("failure_rate", failureRate);
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
     * 设置 [逻辑标记]
     */
    public PSDELogicDTO setLogicTag(String logicTag) {
        this.logicTag = logicTag;
        this.modify("logictag", logicTag);
        return this;
    }

    /**
     * 设置 [逻辑标记2]
     */
    public PSDELogicDTO setLogicTag2(String logicTag2) {
        this.logicTag2 = logicTag2;
        this.modify("logictag2", logicTag2);
        return this;
    }

    /**
     * 设置 [逻辑标记3]
     */
    public PSDELogicDTO setLogicTag3(String logicTag3) {
        this.logicTag3 = logicTag3;
        this.modify("logictag3", logicTag3);
        return this;
    }

    /**
     * 设置 [逻辑标记4]
     */
    public PSDELogicDTO setLogicTag4(String logicTag4) {
        this.logicTag4 = logicTag4;
        this.modify("logictag4", logicTag4);
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
     * 设置 [规则名称]
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
     * 设置 [用户标记]
     */
    public PSDELogicDTO setUserTag(String userTag) {
        this.userTag = userTag;
        this.modify("usertag", userTag);
        return this;
    }

    /**
     * 设置 [用户标记2]
     */
    public PSDELogicDTO setUserTag2(String userTag2) {
        this.userTag2 = userTag2;
        this.modify("usertag2", userTag2);
        return this;
    }

    /**
     * 设置 [用户标记3]
     */
    public PSDELogicDTO setUserTag3(String userTag3) {
        this.userTag3 = userTag3;
        this.modify("usertag3", userTag3);
        return this;
    }

    /**
     * 设置 [用户标记4]
     */
    public PSDELogicDTO setUserTag4(String userTag4) {
        this.userTag4 = userTag4;
        this.modify("usertag4", userTag4);
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
