/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.extension.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.extension.domain.PSDELogicLink;
import cn.ibizlab.plm.core.extension.domain.PSDELogicNode;

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
    @DEField(name = "applyflag" , dict = "extension_status")
    @JSONField(name = "applyflag")
    @JsonProperty("applyflag")
    @ApiModelProperty(value = "applyflag", notes = "扩展状态")
    private Integer applyflag;

    /**
     * 附加到指定行为
     */
    @DEField(name = "attachtopsdeactionname")
    @JSONField(name = "attachtopsdeactionname")
    @JsonProperty("attachtopsdeactionname")
    @ApiModelProperty(value = "attachtopsdeactionname", notes = "附加到指定行为")
    private String attachToPsdeActionName;

    /**
     * 附加到指定行为
     */
    @DEField(name = "attachtopsdeactionid")
    @JSONField(name = "attachtopsdeactionid")
    @JsonProperty("attachtopsdeactionid")
    @ApiModelProperty(value = "attachtopsdeactionid", notes = "附加到指定行为")
    private String attachToPsdeActionId;

    /**
     * 扩展模型
     */
    @DEField(name = "dynamodelflag" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "dynamodelflag")
    @JsonProperty("dynamodelflag")
    @ApiModelProperty(value = "dynamodelflag", notes = "扩展模型")
    private Integer dynaModelFlag;

    /**
     * 附加到指定数据集
     */
    @DEField(name = "attachtopsdedatasetid")
    @JSONField(name = "attachtopsdedatasetid")
    @JsonProperty("attachtopsdedatasetid")
    @ApiModelProperty(value = "attachtopsdedatasetid", notes = "附加到指定数据集")
    private String attachToPsdeDataSetId;

    /**
     * 附加到指定数据集
     */
    @DEField(name = "attachtopsdedatasetname")
    @JSONField(name = "attachtopsdedatasetname")
    @JsonProperty("attachtopsdedatasetname")
    @ApiModelProperty(value = "attachtopsdedatasetname", notes = "附加到指定数据集")
    private String attachToPsdeDataSetName;

    /**
     * 定时触发策略
     */
    @DEField(name = "timerpolicy")
    @JSONField(name = "timerpolicy")
    @JsonProperty("timerpolicy")
    @ApiModelProperty(value = "timerpolicy", notes = "定时触发策略")
    private String timerPolicy;

    /**
     * 最后运行状态
     */
    @DEField(name = "last_state" , dict = "log_state")
    @JSONField(name = "last_state")
    @JsonProperty("last_state")
    @ApiModelProperty(value = "last_state", notes = "最后运行状态")
    private String lastState;

    /**
     * 监控事件
     */
    @DEField(name = "events" , dict = "enable_action")
    @JSONField(name = "events")
    @JsonProperty("events")
    @ApiModelProperty(value = "events", notes = "监控事件")
    private String events;

    /**
     * 事件模型
     */
    @DEField(name = "eventmodel")
    @JSONField(name = "eventmodel")
    @JsonProperty("eventmodel")
    @ApiModelProperty(value = "eventmodel", notes = "事件模型")
    private String eventModel;

    /**
     * 忽略异常
     */
    @DEField(name = "ignoreexception" , dict = "YesNo")
    @JSONField(name = "ignoreexception")
    @JsonProperty("ignoreexception")
    @ApiModelProperty(value = "ignoreexception", notes = "忽略异常")
    private Integer ignoreException;

    /**
     * 线程模式
     */
    @DEField(name = "threadmode")
    @JSONField(name = "threadmode")
    @JsonProperty("threadmode")
    @ApiModelProperty(value = "threadmode", notes = "线程模式")
    private String threadMode;

    /**
     * 最后运行时间
     */
    @DEField(name = "last_start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "last_start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("last_start_at")
    @ApiModelProperty(value = "last_start_at", notes = "最后运行时间")
    private Date lastStartAt;

    /**
     * 逻辑参数
     */
    @DEField(name = "psdelogicparams")
    @JSONField(name = "psdelogicparams")
    @JsonProperty("psdelogicparams")
    @ApiModelProperty(value = "psdelogicparams", notes = "逻辑参数")
    private List<Map> psdelogicparams;

    /**
     * 逻辑节点
     */
    @DEField(name = "psdelogicnodes")
    @JSONField(name = "psdelogicnodes")
    @JsonProperty("psdelogicnodes")
    @ApiModelProperty(value = "psdelogicnodes", notes = "逻辑节点")
    private List<PSDELogicNode> psdeLogicNodes;

    /**
     * 逻辑连接
     */
    @DEField(name = "psdelogiclinks")
    @JSONField(name = "psdelogiclinks")
    @JsonProperty("psdelogiclinks")
    @ApiModelProperty(value = "psdelogiclinks", notes = "逻辑连接")
    private List<PSDELogicLink> psdeLogicLinks;

    /**
     * WebHook地址
     */
    @DEField(name = "webhookurl")
    @JSONField(name = "webhookurl")
    @JsonProperty("webhookurl")
    @ApiModelProperty(value = "webhookurl", notes = "WebHook地址")
    private String webHookUrl;

    /**
     * 成功率
     */
    @DEField(name = "success_rate")
    @JSONField(name = "success_rate")
    @JsonProperty("success_rate")
    @ApiModelProperty(value = "success_rate", notes = "成功率")
    private BigDecimal successRate;

    /**
     * 成功率
     */
    @DEField(name = "success_per")
    @JSONField(name = "success_per")
    @JsonProperty("success_per")
    @ApiModelProperty(value = "success_per", notes = "成功率")
    private BigDecimal successPer;

    /**
     * 失败率
     */
    @DEField(name = "failure_rate")
    @JSONField(name = "failure_rate")
    @JsonProperty("failure_rate")
    @ApiModelProperty(value = "failure_rate", notes = "失败率")
    private BigDecimal failureRate;

    /**
     * 失败率
     */
    @DEField(name = "failure_per")
    @JSONField(name = "failure_per")
    @JsonProperty("failure_per")
    @ApiModelProperty(value = "failure_per", notes = "失败率")
    private BigDecimal failurePer;

    /**
     * 实体处理逻辑标识
     */
    @Id
    @DEField(name = "psdelogicid" , isKeyField = true)
    @JSONField(name = "psdelogicid")
    @JsonProperty("psdelogicid")
    @ApiModelProperty(value = "psdelogicid", notes = "实体处理逻辑标识")
    private String psdeLogicId;

    /**
     * 规则名称
     */
    @DEField(name = "psdelogicname")
    @JSONField(name = "psdelogicname")
    @JsonProperty("psdelogicname")
    @ApiModelProperty(value = "psdelogicname", notes = "规则名称")
    private String psdeLogicName;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JSONField(name = "psdeid")
    @JsonProperty("psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JSONField(name = "psdename")
    @JsonProperty("psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 代码标识
     */
    @DEField(name = "codename")
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码标识")
    private String codeName;

    /**
     * 逻辑子类
     */
    @DEField(name = "logicsubtype" , dict = "DELogicSubType")
    @JSONField(name = "logicsubtype")
    @JsonProperty("logicsubtype")
    @ApiModelProperty(value = "logicsubtype", notes = "逻辑子类")
    private String logicSubType;

    /**
     * 启用
     */
    @DEField(name = "validflag" , dict = "YesNo")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 逻辑类型
     */
    @DEField(name = "logictype" , defaultValue = "DELOGIC")
    @JSONField(name = "logictype")
    @JsonProperty("logictype")
    @ApiModelProperty(value = "logictype", notes = "逻辑类型")
    private String logicType;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 用户标记4
     */
    @DEField(name = "usertag4")
    @JSONField(name = "usertag4")
    @JsonProperty("usertag4")
    @ApiModelProperty(value = "usertag4", notes = "用户标记4")
    private String userTag4;

    /**
     * 逻辑标记
     */
    @DEField(name = "logictag")
    @JSONField(name = "logictag")
    @JsonProperty("logictag")
    @ApiModelProperty(value = "logictag", notes = "逻辑标记")
    private String logicTag;

    /**
     * 用户标记2
     */
    @DEField(name = "usertag2")
    @JSONField(name = "usertag2")
    @JsonProperty("usertag2")
    @ApiModelProperty(value = "usertag2", notes = "用户标记2")
    private String userTag2;

    /**
     * 逻辑标记2
     */
    @DEField(name = "logictag2")
    @JSONField(name = "logictag2")
    @JsonProperty("logictag2")
    @ApiModelProperty(value = "logictag2", notes = "逻辑标记2")
    private String logicTag2;

    /**
     * 逻辑标记3
     */
    @DEField(name = "logictag3")
    @JSONField(name = "logictag3")
    @JsonProperty("logictag3")
    @ApiModelProperty(value = "logictag3", notes = "逻辑标记3")
    private String logicTag3;

    /**
     * 逻辑标记4
     */
    @DEField(name = "logictag4")
    @JSONField(name = "logictag4")
    @JsonProperty("logictag4")
    @ApiModelProperty(value = "logictag4", notes = "逻辑标记4")
    private String logicTag4;

    /**
     * 用户标记3
     */
    @DEField(name = "usertag3")
    @JSONField(name = "usertag3")
    @JsonProperty("usertag3")
    @ApiModelProperty(value = "usertag3", notes = "用户标记3")
    private String userTag3;

    /**
     * 用户标记
     */
    @DEField(name = "usertag")
    @JSONField(name = "usertag")
    @JsonProperty("usertag")
    @ApiModelProperty(value = "usertag", notes = "用户标记")
    private String userTag;

    /**
     * 附加次序
     */
    @DEField(name = "ordervalue" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    @ApiModelProperty(value = "ordervalue", notes = "附加次序")
    private Integer orderValue;

    /**
     * 扩展标记
     */
    @DEField(name = "extension_tag")
    @JSONField(name = "extension_tag")
    @JsonProperty("extension_tag")
    @ApiModelProperty(value = "extension_tag", notes = "扩展标记")
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @DEField(name = "extension_tag2")
    @JSONField(name = "extension_tag2")
    @JsonProperty("extension_tag2")
    @ApiModelProperty(value = "extension_tag2", notes = "扩展标记2")
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @DEField(name = "extension_tag3")
    @JSONField(name = "extension_tag3")
    @JsonProperty("extension_tag3")
    @ApiModelProperty(value = "extension_tag3", notes = "扩展标记3")
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @DEField(name = "extension_tag4")
    @JSONField(name = "extension_tag4")
    @JsonProperty("extension_tag4")
    @ApiModelProperty(value = "extension_tag4", notes = "扩展标记4")
    private String extensionTag4;

    /**
    * 设置 [扩展状态]
    */
    public PSDELogic setApplyflag(Integer applyflag) {
        this.applyflag = applyflag;
        this.modify("applyflag", applyflag);
        return this;
    }

    /**
    * 设置 [附加到指定行为]
    */
    public PSDELogic setAttachToPsdeActionName(String attachToPsdeActionName) {
        this.attachToPsdeActionName = attachToPsdeActionName;
        this.modify("attachtopsdeactionname", attachToPsdeActionName);
        return this;
    }

    /**
    * 设置 [附加到指定行为]
    */
    public PSDELogic setAttachToPsdeActionId(String attachToPsdeActionId) {
        this.attachToPsdeActionId = attachToPsdeActionId;
        this.modify("attachtopsdeactionid", attachToPsdeActionId);
        return this;
    }

    /**
    * 设置 [扩展模型]
    */
    public PSDELogic setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
    * 设置 [附加到指定数据集]
    */
    public PSDELogic setAttachToPsdeDataSetId(String attachToPsdeDataSetId) {
        this.attachToPsdeDataSetId = attachToPsdeDataSetId;
        this.modify("attachtopsdedatasetid", attachToPsdeDataSetId);
        return this;
    }

    /**
    * 设置 [附加到指定数据集]
    */
    public PSDELogic setAttachToPsdeDataSetName(String attachToPsdeDataSetName) {
        this.attachToPsdeDataSetName = attachToPsdeDataSetName;
        this.modify("attachtopsdedatasetname", attachToPsdeDataSetName);
        return this;
    }

    /**
    * 设置 [定时触发策略]
    */
    public PSDELogic setTimerPolicy(String timerPolicy) {
        this.timerPolicy = timerPolicy;
        this.modify("timerpolicy", timerPolicy);
        return this;
    }

    /**
    * 设置 [最后运行状态]
    */
    public PSDELogic setLastState(String lastState) {
        this.lastState = lastState;
        this.modify("last_state", lastState);
        return this;
    }

    /**
    * 设置 [监控事件]
    */
    public PSDELogic setEvents(String events) {
        this.events = events;
        this.modify("events", events);
        return this;
    }

    /**
    * 设置 [事件模型]
    */
    public PSDELogic setEventModel(String eventModel) {
        this.eventModel = eventModel;
        this.modify("eventmodel", eventModel);
        return this;
    }

    /**
    * 设置 [忽略异常]
    */
    public PSDELogic setIgnoreException(Integer ignoreException) {
        this.ignoreException = ignoreException;
        this.modify("ignoreexception", ignoreException);
        return this;
    }

    /**
    * 设置 [线程模式]
    */
    public PSDELogic setThreadMode(String threadMode) {
        this.threadMode = threadMode;
        this.modify("threadmode", threadMode);
        return this;
    }

    /**
    * 设置 [最后运行时间]
    */
    public PSDELogic setLastStartAt(Date lastStartAt) {
        this.lastStartAt = lastStartAt;
        this.modify("last_start_at", lastStartAt);
        return this;
    }

    /**
    * 设置 [逻辑参数]
    */
    public PSDELogic setPsdelogicparams(List<Map> psdelogicparams) {
        this.psdelogicparams = psdelogicparams;
        this.modify("psdelogicparams", psdelogicparams);
        return this;
    }

    /**
    * 设置 [逻辑节点]
    */
    public PSDELogic setPsdeLogicNodes(List<PSDELogicNode> psdeLogicNodes) {
        this.psdeLogicNodes = psdeLogicNodes;
        this.modify("psdelogicnodes", psdeLogicNodes);
        return this;
    }

    /**
    * 设置 [逻辑连接]
    */
    public PSDELogic setPsdeLogicLinks(List<PSDELogicLink> psdeLogicLinks) {
        this.psdeLogicLinks = psdeLogicLinks;
        this.modify("psdelogiclinks", psdeLogicLinks);
        return this;
    }

    /**
    * 设置 [WebHook地址]
    */
    public PSDELogic setWebHookUrl(String webHookUrl) {
        this.webHookUrl = webHookUrl;
        this.modify("webhookurl", webHookUrl);
        return this;
    }

    /**
    * 设置 [成功率]
    */
    public PSDELogic setSuccessRate(BigDecimal successRate) {
        this.successRate = successRate;
        this.modify("success_rate", successRate);
        return this;
    }

    /**
    * 设置 [成功率]
    */
    public PSDELogic setSuccessPer(BigDecimal successPer) {
        this.successPer = successPer;
        this.modify("success_per", successPer);
        return this;
    }

    /**
    * 设置 [失败率]
    */
    public PSDELogic setFailureRate(BigDecimal failureRate) {
        this.failureRate = failureRate;
        this.modify("failure_rate", failureRate);
        return this;
    }

    /**
    * 设置 [失败率]
    */
    public PSDELogic setFailurePer(BigDecimal failurePer) {
        this.failurePer = failurePer;
        this.modify("failure_per", failurePer);
        return this;
    }

    /**
    * 设置 [规则名称]
    */
    public PSDELogic setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDELogic setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDELogic setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
    * 设置 [代码标识]
    */
    public PSDELogic setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [逻辑子类]
    */
    public PSDELogic setLogicSubType(String logicSubType) {
        this.logicSubType = logicSubType;
        this.modify("logicsubtype", logicSubType);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public PSDELogic setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [逻辑类型]
    */
    public PSDELogic setLogicType(String logicType) {
        this.logicType = logicType;
        this.modify("logictype", logicType);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSDELogic setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [用户标记4]
    */
    public PSDELogic setUserTag4(String userTag4) {
        this.userTag4 = userTag4;
        this.modify("usertag4", userTag4);
        return this;
    }

    /**
    * 设置 [逻辑标记]
    */
    public PSDELogic setLogicTag(String logicTag) {
        this.logicTag = logicTag;
        this.modify("logictag", logicTag);
        return this;
    }

    /**
    * 设置 [用户标记2]
    */
    public PSDELogic setUserTag2(String userTag2) {
        this.userTag2 = userTag2;
        this.modify("usertag2", userTag2);
        return this;
    }

    /**
    * 设置 [逻辑标记2]
    */
    public PSDELogic setLogicTag2(String logicTag2) {
        this.logicTag2 = logicTag2;
        this.modify("logictag2", logicTag2);
        return this;
    }

    /**
    * 设置 [逻辑标记3]
    */
    public PSDELogic setLogicTag3(String logicTag3) {
        this.logicTag3 = logicTag3;
        this.modify("logictag3", logicTag3);
        return this;
    }

    /**
    * 设置 [逻辑标记4]
    */
    public PSDELogic setLogicTag4(String logicTag4) {
        this.logicTag4 = logicTag4;
        this.modify("logictag4", logicTag4);
        return this;
    }

    /**
    * 设置 [用户标记3]
    */
    public PSDELogic setUserTag3(String userTag3) {
        this.userTag3 = userTag3;
        this.modify("usertag3", userTag3);
        return this;
    }

    /**
    * 设置 [用户标记]
    */
    public PSDELogic setUserTag(String userTag) {
        this.userTag = userTag;
        this.modify("usertag", userTag);
        return this;
    }

    /**
    * 设置 [扩展标记]
    */
    public PSDELogic setExtensionTag(String extensionTag) {
        this.extensionTag = extensionTag;
        this.modify("extension_tag", extensionTag);
        return this;
    }

    /**
    * 设置 [扩展标记2]
    */
    public PSDELogic setExtensionTag2(String extensionTag2) {
        this.extensionTag2 = extensionTag2;
        this.modify("extension_tag2", extensionTag2);
        return this;
    }

    /**
    * 设置 [扩展标记3]
    */
    public PSDELogic setExtensionTag3(String extensionTag3) {
        this.extensionTag3 = extensionTag3;
        this.modify("extension_tag3", extensionTag3);
        return this;
    }

    /**
    * 设置 [扩展标记4]
    */
    public PSDELogic setExtensionTag4(String extensionTag4) {
        this.extensionTag4 = extensionTag4;
        this.modify("extension_tag4", extensionTag4);
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
            entity.reset("psdelogicid");
        }
        return targetEntity;
    }

}