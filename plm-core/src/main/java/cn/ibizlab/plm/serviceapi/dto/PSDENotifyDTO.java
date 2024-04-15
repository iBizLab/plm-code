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
 * 实体通知[PSDENotifyDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体通知DTO")
public class PSDENotifyDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开始时间属性
     */
    @JsonProperty("beginpsdefid")
    @JSONField(name = "beginpsdefid")
    @ApiModelProperty(value = "开始时间属性", position = 0)
    private String beginPsdefid;

    /**
     * 开始时间属性
     */
    @JsonProperty("beginpsdefname")
    @JSONField(name = "beginpsdefname")
    @ApiModelProperty(value = "开始时间属性", position = 1)
    private String beginPsdefName;

    /**
     * 检查间隔
     */
    @JsonProperty("checktimer")
    @JSONField(name = "checktimer")
    @ApiModelProperty(value = "检查间隔", position = 2)
    private Integer checkTimer;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 3)
    private String codeName;

    /**
     * 自定义条件
     */
    @JsonProperty("customcond")
    @JSONField(name = "customcond")
    @ApiModelProperty(value = "自定义条件", position = 4)
    private String customCond;

    /**
     * 结束时间属性
     */
    @JsonProperty("endpsdefid")
    @JSONField(name = "endpsdefid")
    @ApiModelProperty(value = "结束时间属性", position = 5)
    private String endPsdefid;

    /**
     * 结束时间属性
     */
    @JsonProperty("endpsdefname")
    @JSONField(name = "endpsdefname")
    @ApiModelProperty(value = "结束时间属性", position = 6)
    private String endPsdefName;

    /**
     * 监控事件集
     */
    @JsonProperty("events")
    @JSONField(name = "events")
    @ApiModelProperty(value = "监控事件集", position = 7)
    private String events;

    /**
     * 监控变化属性集
     */
    @JsonProperty("fields")
    @JSONField(name = "fields")
    @ApiModelProperty(value = "监控变化属性集", position = 8)
    private String fields;

    /**
     * 通知消息类型
     */
    @JsonProperty("msgtype")
    @JSONField(name = "msgtype")
    @ApiModelProperty(value = "通知消息类型", position = 9)
    private Integer msgType;

    /**
     * 延后通知间隔
     */
    @JsonProperty("notifyend")
    @JSONField(name = "notifyend")
    @ApiModelProperty(value = "延后通知间隔", position = 10)
    private Integer notifyEnd;

    /**
     * 提前通知间隔
     */
    @JsonProperty("notifystart")
    @JSONField(name = "notifystart")
    @ApiModelProperty(value = "提前通知间隔", position = 11)
    private Integer notifyStart;

    /**
     * 通知子类
     */
    @JsonProperty("notifysubtype")
    @JSONField(name = "notifysubtype")
    @ApiModelProperty(value = "通知子类", position = 12)
    private String notifySubType;

    /**
     * 通知标记
     */
    @JsonProperty("notifytag")
    @JSONField(name = "notifytag")
    @ApiModelProperty(value = "通知标记", position = 13)
    private String notifyTag;

    /**
     * 通知标记2
     */
    @JsonProperty("notifytag2")
    @JSONField(name = "notifytag2")
    @ApiModelProperty(value = "通知标记2", position = 14)
    private String notifyTag2;

    /**
     * 实体数据集
     */
    @JsonProperty("psdedsid")
    @JSONField(name = "psdedsid")
    @ApiModelProperty(value = "实体数据集", position = 15)
    private String psdedsid;

    /**
     * 实体数据集
     */
    @JsonProperty("psdedsname")
    @JSONField(name = "psdedsname")
    @ApiModelProperty(value = "实体数据集", position = 16)
    private String psdedsName;

    /**
     * 实体
     */
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "实体", position = 17)
    private String psdeid;

    /**
     * 实体
     */
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "实体", position = 18)
    private String psdeName;

    /**
     * 实体通知标识
     */
    @JsonProperty("psdenotifyid")
    @JSONField(name = "psdenotifyid")
    @ApiModelProperty(value = "实体通知标识", position = 19)
    private String psdeNotifyId;

    /**
     * 实体通知名称
     */
    @JsonProperty("psdenotifyname")
    @JSONField(name = "psdenotifyname")
    @ApiModelProperty(value = "实体通知名称", position = 20)
    private String psdeNotifyName;

    /**
     * 系统消息队列
     */
    @JsonProperty("pssysmsgqueueid")
    @JSONField(name = "pssysmsgqueueid")
    @ApiModelProperty(value = "系统消息队列", position = 21)
    private String psSysMsgQueueId;

    /**
     * 系统消息队列
     */
    @JsonProperty("pssysmsgqueuename")
    @JSONField(name = "pssysmsgqueuename")
    @ApiModelProperty(value = "系统消息队列", position = 22)
    private String psSysMsgQueueName;

    /**
     * 系统消息模板
     */
    @JsonProperty("pssysmsgtemplid")
    @JSONField(name = "pssysmsgtemplid")
    @ApiModelProperty(value = "系统消息模板", position = 23)
    private String psSysMsgTemplId;

    /**
     * 系统消息模板
     */
    @JsonProperty("pssysmsgtemplname")
    @JSONField(name = "pssysmsgtemplname")
    @ApiModelProperty(value = "系统消息模板", position = 24)
    private String psSysMsgTemplName;

    /**
     * 附加任务模式
     */
    @JsonProperty("taskmode")
    @JSONField(name = "taskmode")
    @ApiModelProperty(value = "附加任务模式", position = 25)
    private Integer taskMode;

    /**
     * 定时触发模式
     */
    @JsonProperty("timermode")
    @JSONField(name = "timermode")
    @ApiModelProperty(value = "定时触发模式", position = 26)
    private Integer timerMode;

    /**
     * 用户标识
     */
    @JsonProperty("usertag")
    @JSONField(name = "usertag")
    @ApiModelProperty(value = "用户标识", position = 27)
    private String userTag;

    /**
     * 用户标识2
     */
    @JsonProperty("usertag2")
    @JSONField(name = "usertag2")
    @ApiModelProperty(value = "用户标识2", position = 28)
    private String userTag2;

    /**
     * 用户标识3
     */
    @JsonProperty("usertag3")
    @JSONField(name = "usertag3")
    @ApiModelProperty(value = "用户标识3", position = 29)
    private String userTag3;

    /**
     * 用户标识4
     */
    @JsonProperty("usertag4")
    @JSONField(name = "usertag4")
    @ApiModelProperty(value = "用户标识4", position = 30)
    private String userTag4;

    /**
     * 启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "启用", position = 31)
    private Integer validFlag;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 32)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 33)
    private Date createTime;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 34)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 35)
    private Date updateTime;

    /**
     * 消息通知目标
     */
    @JsonProperty("psdenotifytargets")
    @JSONField(name = "psdenotifytargets")
    @ApiModelProperty(value = "消息通知目标", position = 36)
    private List<PSDENotifyTargetDTO> psdeNotifyTargets;


    /**
     * 设置 [开始时间属性]
     */
    public PSDENotifyDTO setBeginPsdefid(String beginPsdefid) {
        this.beginPsdefid = beginPsdefid;
        this.modify("beginpsdefid", beginPsdefid);
        return this;
    }

    /**
     * 设置 [开始时间属性]
     */
    public PSDENotifyDTO setBeginPsdefName(String beginPsdefName) {
        this.beginPsdefName = beginPsdefName;
        this.modify("beginpsdefname", beginPsdefName);
        return this;
    }

    /**
     * 设置 [检查间隔]
     */
    public PSDENotifyDTO setCheckTimer(Integer checkTimer) {
        this.checkTimer = checkTimer;
        this.modify("checktimer", checkTimer);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSDENotifyDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [自定义条件]
     */
    public PSDENotifyDTO setCustomCond(String customCond) {
        this.customCond = customCond;
        this.modify("customcond", customCond);
        return this;
    }

    /**
     * 设置 [结束时间属性]
     */
    public PSDENotifyDTO setEndPsdefid(String endPsdefid) {
        this.endPsdefid = endPsdefid;
        this.modify("endpsdefid", endPsdefid);
        return this;
    }

    /**
     * 设置 [结束时间属性]
     */
    public PSDENotifyDTO setEndPsdefName(String endPsdefName) {
        this.endPsdefName = endPsdefName;
        this.modify("endpsdefname", endPsdefName);
        return this;
    }

    /**
     * 设置 [监控事件集]
     */
    public PSDENotifyDTO setEvents(String events) {
        this.events = events;
        this.modify("events", events);
        return this;
    }

    /**
     * 设置 [监控变化属性集]
     */
    public PSDENotifyDTO setFields(String fields) {
        this.fields = fields;
        this.modify("fields", fields);
        return this;
    }

    /**
     * 设置 [通知消息类型]
     */
    public PSDENotifyDTO setMsgType(Integer msgType) {
        this.msgType = msgType;
        this.modify("msgtype", msgType);
        return this;
    }

    /**
     * 设置 [延后通知间隔]
     */
    public PSDENotifyDTO setNotifyEnd(Integer notifyEnd) {
        this.notifyEnd = notifyEnd;
        this.modify("notifyend", notifyEnd);
        return this;
    }

    /**
     * 设置 [提前通知间隔]
     */
    public PSDENotifyDTO setNotifyStart(Integer notifyStart) {
        this.notifyStart = notifyStart;
        this.modify("notifystart", notifyStart);
        return this;
    }

    /**
     * 设置 [通知子类]
     */
    public PSDENotifyDTO setNotifySubType(String notifySubType) {
        this.notifySubType = notifySubType;
        this.modify("notifysubtype", notifySubType);
        return this;
    }

    /**
     * 设置 [通知标记]
     */
    public PSDENotifyDTO setNotifyTag(String notifyTag) {
        this.notifyTag = notifyTag;
        this.modify("notifytag", notifyTag);
        return this;
    }

    /**
     * 设置 [通知标记2]
     */
    public PSDENotifyDTO setNotifyTag2(String notifyTag2) {
        this.notifyTag2 = notifyTag2;
        this.modify("notifytag2", notifyTag2);
        return this;
    }

    /**
     * 设置 [实体数据集]
     */
    public PSDENotifyDTO setPsdedsid(String psdedsid) {
        this.psdedsid = psdedsid;
        this.modify("psdedsid", psdedsid);
        return this;
    }

    /**
     * 设置 [实体数据集]
     */
    public PSDENotifyDTO setPsdedsName(String psdedsName) {
        this.psdedsName = psdedsName;
        this.modify("psdedsname", psdedsName);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDENotifyDTO setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDENotifyDTO setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
     * 设置 [实体通知名称]
     */
    public PSDENotifyDTO setPsdeNotifyName(String psdeNotifyName) {
        this.psdeNotifyName = psdeNotifyName;
        this.modify("psdenotifyname", psdeNotifyName);
        return this;
    }

    /**
     * 设置 [系统消息队列]
     */
    public PSDENotifyDTO setPsSysMsgQueueId(String psSysMsgQueueId) {
        this.psSysMsgQueueId = psSysMsgQueueId;
        this.modify("pssysmsgqueueid", psSysMsgQueueId);
        return this;
    }

    /**
     * 设置 [系统消息队列]
     */
    public PSDENotifyDTO setPsSysMsgQueueName(String psSysMsgQueueName) {
        this.psSysMsgQueueName = psSysMsgQueueName;
        this.modify("pssysmsgqueuename", psSysMsgQueueName);
        return this;
    }

    /**
     * 设置 [系统消息模板]
     */
    public PSDENotifyDTO setPsSysMsgTemplId(String psSysMsgTemplId) {
        this.psSysMsgTemplId = psSysMsgTemplId;
        this.modify("pssysmsgtemplid", psSysMsgTemplId);
        return this;
    }

    /**
     * 设置 [系统消息模板]
     */
    public PSDENotifyDTO setPsSysMsgTemplName(String psSysMsgTemplName) {
        this.psSysMsgTemplName = psSysMsgTemplName;
        this.modify("pssysmsgtemplname", psSysMsgTemplName);
        return this;
    }

    /**
     * 设置 [附加任务模式]
     */
    public PSDENotifyDTO setTaskMode(Integer taskMode) {
        this.taskMode = taskMode;
        this.modify("taskmode", taskMode);
        return this;
    }

    /**
     * 设置 [定时触发模式]
     */
    public PSDENotifyDTO setTimerMode(Integer timerMode) {
        this.timerMode = timerMode;
        this.modify("timermode", timerMode);
        return this;
    }

    /**
     * 设置 [用户标识]
     */
    public PSDENotifyDTO setUserTag(String userTag) {
        this.userTag = userTag;
        this.modify("usertag", userTag);
        return this;
    }

    /**
     * 设置 [用户标识2]
     */
    public PSDENotifyDTO setUserTag2(String userTag2) {
        this.userTag2 = userTag2;
        this.modify("usertag2", userTag2);
        return this;
    }

    /**
     * 设置 [用户标识3]
     */
    public PSDENotifyDTO setUserTag3(String userTag3) {
        this.userTag3 = userTag3;
        this.modify("usertag3", userTag3);
        return this;
    }

    /**
     * 设置 [用户标识4]
     */
    public PSDENotifyDTO setUserTag4(String userTag4) {
        this.userTag4 = userTag4;
        this.modify("usertag4", userTag4);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public PSDENotifyDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
     * 设置 [消息通知目标]
     */
    public PSDENotifyDTO setPsdeNotifyTargets(List<PSDENotifyTargetDTO> psdeNotifyTargets) {
        this.psdeNotifyTargets = psdeNotifyTargets;
        this.modify("psdenotifytargets", psdeNotifyTargets);
        return this;
    }


}
