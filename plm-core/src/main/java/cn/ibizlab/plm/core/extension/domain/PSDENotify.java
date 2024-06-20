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
import cn.ibizlab.plm.core.extension.domain.PSDENotifyTarget;

/**
 * 实体通知实体类[PSDENotify]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDENOTIFY", description = "实体通知")
public class PSDENotify extends EntityBase implements Serializable
{
    /**
     * 实体通知标识
     */
    @Id
    @DEField(name = "psdenotifyid" , isKeyField = true)
    @JSONField(name = "psdenotifyid")
    @JsonProperty("psdenotifyid")
    @ApiModelProperty(value = "psdenotifyid", notes = "实体通知标识")
    private String psdeNotifyId;

    /**
     * 实体通知名称
     */
    @DEField(name = "psdenotifyname")
    @JSONField(name = "psdenotifyname")
    @JsonProperty("psdenotifyname")
    @ApiModelProperty(value = "psdenotifyname", notes = "实体通知名称")
    private String psdeNotifyName;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 结束时间属性
     */
    @DEField(name = "endpsdefname")
    @JSONField(name = "endpsdefname")
    @JsonProperty("endpsdefname")
    @ApiModelProperty(value = "endpsdefname", notes = "结束时间属性")
    private String endPsdefName;

    /**
     * 开始时间属性
     */
    @DEField(name = "beginpsdefid")
    @JSONField(name = "beginpsdefid")
    @JsonProperty("beginpsdefid")
    @ApiModelProperty(value = "beginpsdefid", notes = "开始时间属性")
    private String beginPsdefid;

    /**
     * 开始时间属性
     */
    @DEField(name = "beginpsdefname")
    @JSONField(name = "beginpsdefname")
    @JsonProperty("beginpsdefname")
    @ApiModelProperty(value = "beginpsdefname", notes = "开始时间属性")
    private String beginPsdefName;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JSONField(name = "psdename")
    @JsonProperty("psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 结束时间属性
     */
    @DEField(name = "endpsdefid")
    @JSONField(name = "endpsdefid")
    @JsonProperty("endpsdefid")
    @ApiModelProperty(value = "endpsdefid", notes = "结束时间属性")
    private String endPsdefid;

    /**
     * 附加任务模式
     */
    @DEField(name = "taskmode")
    @JSONField(name = "taskmode")
    @JsonProperty("taskmode")
    @ApiModelProperty(value = "taskmode", notes = "附加任务模式")
    private Integer taskMode;

    /**
     * 实体数据集
     */
    @DEField(name = "psdedsid")
    @JSONField(name = "psdedsid")
    @JsonProperty("psdedsid")
    @ApiModelProperty(value = "psdedsid", notes = "实体数据集")
    private String psdedsid;

    /**
     * 实体数据集
     */
    @DEField(name = "psdedsname")
    @JSONField(name = "psdedsname")
    @JsonProperty("psdedsname")
    @ApiModelProperty(value = "psdedsname", notes = "实体数据集")
    private String psdedsName;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JSONField(name = "psdeid")
    @JsonProperty("psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 用户标识2
     */
    @DEField(name = "usertag2")
    @JSONField(name = "usertag2")
    @JsonProperty("usertag2")
    @ApiModelProperty(value = "usertag2", notes = "用户标识2")
    private String userTag2;

    /**
     * 用户标识
     */
    @DEField(name = "usertag")
    @JSONField(name = "usertag")
    @JsonProperty("usertag")
    @ApiModelProperty(value = "usertag", notes = "用户标识")
    private String userTag;

    /**
     * 通知消息类型
     */
    @DEField(name = "msgtype" , dict = "WFInfomMsgType")
    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    @ApiModelProperty(value = "msgtype", notes = "通知消息类型")
    private Integer msgType;

    /**
     * 用户标识3
     */
    @DEField(name = "usertag3")
    @JSONField(name = "usertag3")
    @JsonProperty("usertag3")
    @ApiModelProperty(value = "usertag3", notes = "用户标识3")
    private String userTag3;

    /**
     * 通知标记2
     */
    @DEField(name = "notifytag2")
    @JSONField(name = "notifytag2")
    @JsonProperty("notifytag2")
    @ApiModelProperty(value = "notifytag2", notes = "通知标记2")
    private String notifyTag2;

    /**
     * 通知标记
     */
    @DEField(name = "notifytag")
    @JSONField(name = "notifytag")
    @JsonProperty("notifytag")
    @ApiModelProperty(value = "notifytag", notes = "通知标记")
    private String notifyTag;

    /**
     * 代码名称
     */
    @DEField(name = "codename" , defaultValue = "Notify" , defaultValueType = DEFieldDefaultValueType.USER)
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 启用
     */
    @DEField(name = "validflag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 定时触发模式
     */
    @DEField(name = "timermode" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "timermode")
    @JsonProperty("timermode")
    @ApiModelProperty(value = "timermode", notes = "定时触发模式")
    private Integer timerMode;

    /**
     * 自定义条件
     */
    @DEField(name = "customcond")
    @JSONField(name = "customcond")
    @JsonProperty("customcond")
    @ApiModelProperty(value = "customcond", notes = "自定义条件")
    private String customCond;

    /**
     * 检查间隔
     */
    @DEField(name = "checktimer")
    @JSONField(name = "checktimer")
    @JsonProperty("checktimer")
    @ApiModelProperty(value = "checktimer", notes = "检查间隔")
    private Integer checkTimer;

    /**
     * 用户标识4
     */
    @DEField(name = "usertag4")
    @JSONField(name = "usertag4")
    @JsonProperty("usertag4")
    @ApiModelProperty(value = "usertag4", notes = "用户标识4")
    private String userTag4;

    /**
     * 延后通知间隔
     */
    @DEField(name = "notifyend")
    @JSONField(name = "notifyend")
    @JsonProperty("notifyend")
    @ApiModelProperty(value = "notifyend", notes = "延后通知间隔")
    private Integer notifyEnd;

    /**
     * 提前通知间隔
     */
    @DEField(name = "notifystart")
    @JSONField(name = "notifystart")
    @JsonProperty("notifystart")
    @ApiModelProperty(value = "notifystart", notes = "提前通知间隔")
    private Integer notifyStart;

    /**
     * 通知子类
     */
    @DEField(name = "notifysubtype" , dict = "DENotifySubType")
    @JSONField(name = "notifysubtype")
    @JsonProperty("notifysubtype")
    @ApiModelProperty(value = "notifysubtype", notes = "通知子类")
    private String notifySubType;

    /**
     * 系统消息模板
     */
    @DEField(name = "pssysmsgtemplid")
    @JSONField(name = "pssysmsgtemplid")
    @JsonProperty("pssysmsgtemplid")
    @ApiModelProperty(value = "pssysmsgtemplid", notes = "系统消息模板")
    private String psSysMsgTemplId;

    /**
     * 系统消息模板
     */
    @DEField(name = "pssysmsgtemplname")
    @JSONField(name = "pssysmsgtemplname")
    @JsonProperty("pssysmsgtemplname")
    @ApiModelProperty(value = "pssysmsgtemplname", notes = "系统消息模板")
    private String psSysMsgTemplName;

    /**
     * 系统消息队列
     */
    @DEField(name = "pssysmsgqueueid")
    @JSONField(name = "pssysmsgqueueid")
    @JsonProperty("pssysmsgqueueid")
    @ApiModelProperty(value = "pssysmsgqueueid", notes = "系统消息队列")
    private String psSysMsgQueueId;

    /**
     * 系统消息队列
     */
    @DEField(name = "pssysmsgqueuename")
    @JSONField(name = "pssysmsgqueuename")
    @JsonProperty("pssysmsgqueuename")
    @ApiModelProperty(value = "pssysmsgqueuename", notes = "系统消息队列")
    private String psSysMsgQueueName;

    /**
     * 监控事件集
     */
    @DEField(name = "events")
    @JSONField(name = "events")
    @JsonProperty("events")
    @ApiModelProperty(value = "events", notes = "监控事件集")
    private String events;

    /**
     * 监控变化属性集
     */
    @DEField(name = "fields")
    @JSONField(name = "fields")
    @JsonProperty("fields")
    @ApiModelProperty(value = "fields", notes = "监控变化属性集")
    private String fields;

    /**
    * 设置 [实体通知名称]
    */
    public PSDENotify setPsdeNotifyName(String psdeNotifyName) {
        this.psdeNotifyName = psdeNotifyName;
        this.modify("psdenotifyname", psdeNotifyName);
        return this;
    }

    /**
    * 设置 [结束时间属性]
    */
    public PSDENotify setEndPsdefName(String endPsdefName) {
        this.endPsdefName = endPsdefName;
        this.modify("endpsdefname", endPsdefName);
        return this;
    }

    /**
    * 设置 [开始时间属性]
    */
    public PSDENotify setBeginPsdefid(String beginPsdefid) {
        this.beginPsdefid = beginPsdefid;
        this.modify("beginpsdefid", beginPsdefid);
        return this;
    }

    /**
    * 设置 [开始时间属性]
    */
    public PSDENotify setBeginPsdefName(String beginPsdefName) {
        this.beginPsdefName = beginPsdefName;
        this.modify("beginpsdefname", beginPsdefName);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDENotify setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
    * 设置 [结束时间属性]
    */
    public PSDENotify setEndPsdefid(String endPsdefid) {
        this.endPsdefid = endPsdefid;
        this.modify("endpsdefid", endPsdefid);
        return this;
    }

    /**
    * 设置 [附加任务模式]
    */
    public PSDENotify setTaskMode(Integer taskMode) {
        this.taskMode = taskMode;
        this.modify("taskmode", taskMode);
        return this;
    }

    /**
    * 设置 [实体数据集]
    */
    public PSDENotify setPsdedsid(String psdedsid) {
        this.psdedsid = psdedsid;
        this.modify("psdedsid", psdedsid);
        return this;
    }

    /**
    * 设置 [实体数据集]
    */
    public PSDENotify setPsdedsName(String psdedsName) {
        this.psdedsName = psdedsName;
        this.modify("psdedsname", psdedsName);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDENotify setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
    * 设置 [用户标识2]
    */
    public PSDENotify setUserTag2(String userTag2) {
        this.userTag2 = userTag2;
        this.modify("usertag2", userTag2);
        return this;
    }

    /**
    * 设置 [用户标识]
    */
    public PSDENotify setUserTag(String userTag) {
        this.userTag = userTag;
        this.modify("usertag", userTag);
        return this;
    }

    /**
    * 设置 [通知消息类型]
    */
    public PSDENotify setMsgType(Integer msgType) {
        this.msgType = msgType;
        this.modify("msgtype", msgType);
        return this;
    }

    /**
    * 设置 [用户标识3]
    */
    public PSDENotify setUserTag3(String userTag3) {
        this.userTag3 = userTag3;
        this.modify("usertag3", userTag3);
        return this;
    }

    /**
    * 设置 [通知标记2]
    */
    public PSDENotify setNotifyTag2(String notifyTag2) {
        this.notifyTag2 = notifyTag2;
        this.modify("notifytag2", notifyTag2);
        return this;
    }

    /**
    * 设置 [通知标记]
    */
    public PSDENotify setNotifyTag(String notifyTag) {
        this.notifyTag = notifyTag;
        this.modify("notifytag", notifyTag);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSDENotify setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [启用]
    */
    public PSDENotify setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [定时触发模式]
    */
    public PSDENotify setTimerMode(Integer timerMode) {
        this.timerMode = timerMode;
        this.modify("timermode", timerMode);
        return this;
    }

    /**
    * 设置 [自定义条件]
    */
    public PSDENotify setCustomCond(String customCond) {
        this.customCond = customCond;
        this.modify("customcond", customCond);
        return this;
    }

    /**
    * 设置 [检查间隔]
    */
    public PSDENotify setCheckTimer(Integer checkTimer) {
        this.checkTimer = checkTimer;
        this.modify("checktimer", checkTimer);
        return this;
    }

    /**
    * 设置 [用户标识4]
    */
    public PSDENotify setUserTag4(String userTag4) {
        this.userTag4 = userTag4;
        this.modify("usertag4", userTag4);
        return this;
    }

    /**
    * 设置 [延后通知间隔]
    */
    public PSDENotify setNotifyEnd(Integer notifyEnd) {
        this.notifyEnd = notifyEnd;
        this.modify("notifyend", notifyEnd);
        return this;
    }

    /**
    * 设置 [提前通知间隔]
    */
    public PSDENotify setNotifyStart(Integer notifyStart) {
        this.notifyStart = notifyStart;
        this.modify("notifystart", notifyStart);
        return this;
    }

    /**
    * 设置 [通知子类]
    */
    public PSDENotify setNotifySubType(String notifySubType) {
        this.notifySubType = notifySubType;
        this.modify("notifysubtype", notifySubType);
        return this;
    }

    /**
    * 设置 [系统消息模板]
    */
    public PSDENotify setPsSysMsgTemplId(String psSysMsgTemplId) {
        this.psSysMsgTemplId = psSysMsgTemplId;
        this.modify("pssysmsgtemplid", psSysMsgTemplId);
        return this;
    }

    /**
    * 设置 [系统消息模板]
    */
    public PSDENotify setPsSysMsgTemplName(String psSysMsgTemplName) {
        this.psSysMsgTemplName = psSysMsgTemplName;
        this.modify("pssysmsgtemplname", psSysMsgTemplName);
        return this;
    }

    /**
    * 设置 [系统消息队列]
    */
    public PSDENotify setPsSysMsgQueueId(String psSysMsgQueueId) {
        this.psSysMsgQueueId = psSysMsgQueueId;
        this.modify("pssysmsgqueueid", psSysMsgQueueId);
        return this;
    }

    /**
    * 设置 [系统消息队列]
    */
    public PSDENotify setPsSysMsgQueueName(String psSysMsgQueueName) {
        this.psSysMsgQueueName = psSysMsgQueueName;
        this.modify("pssysmsgqueuename", psSysMsgQueueName);
        return this;
    }

    /**
    * 设置 [监控事件集]
    */
    public PSDENotify setEvents(String events) {
        this.events = events;
        this.modify("events", events);
        return this;
    }

    /**
    * 设置 [监控变化属性集]
    */
    public PSDENotify setFields(String fields) {
        this.fields = fields;
        this.modify("fields", fields);
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
            entity.reset("psdenotifyid");
        }
        return targetEntity;
    }

}