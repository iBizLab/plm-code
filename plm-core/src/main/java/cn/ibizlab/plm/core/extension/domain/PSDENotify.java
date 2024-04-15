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
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 结束时间属性
     */
    @DEField(name = "endpsdefname")
    @JsonProperty("endpsdefname")
    @JSONField(name = "endpsdefname")
    @ApiModelProperty(value = "endpsdefname", notes = "结束时间属性")
    private String endPsdefName;

    /**
     * 开始时间属性
     */
    @DEField(name = "beginpsdefid")
    @JsonProperty("beginpsdefid")
    @JSONField(name = "beginpsdefid")
    @ApiModelProperty(value = "beginpsdefid", notes = "开始时间属性")
    private String beginPsdefid;

    /**
     * 开始时间属性
     */
    @DEField(name = "beginpsdefname")
    @JsonProperty("beginpsdefname")
    @JSONField(name = "beginpsdefname")
    @ApiModelProperty(value = "beginpsdefname", notes = "开始时间属性")
    private String beginPsdefName;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 结束时间属性
     */
    @DEField(name = "endpsdefid")
    @JsonProperty("endpsdefid")
    @JSONField(name = "endpsdefid")
    @ApiModelProperty(value = "endpsdefid", notes = "结束时间属性")
    private String endPsdefid;

    /**
     * 附加任务模式
     */
    @DEField(name = "taskmode")
    @JsonProperty("taskmode")
    @JSONField(name = "taskmode")
    @ApiModelProperty(value = "taskmode", notes = "附加任务模式")
    private Integer taskMode;

    /**
     * 实体数据集
     */
    @DEField(name = "psdedsid")
    @JsonProperty("psdedsid")
    @JSONField(name = "psdedsid")
    @ApiModelProperty(value = "psdedsid", notes = "实体数据集")
    private String psdedsid;

    /**
     * 实体数据集
     */
    @DEField(name = "psdedsname")
    @JsonProperty("psdedsname")
    @JSONField(name = "psdedsname")
    @ApiModelProperty(value = "psdedsname", notes = "实体数据集")
    private String psdedsName;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 用户标识2
     */
    @DEField(name = "usertag2")
    @JsonProperty("usertag2")
    @JSONField(name = "usertag2")
    @ApiModelProperty(value = "usertag2", notes = "用户标识2")
    private String userTag2;

    /**
     * 用户标识
     */
    @DEField(name = "usertag")
    @JsonProperty("usertag")
    @JSONField(name = "usertag")
    @ApiModelProperty(value = "usertag", notes = "用户标识")
    private String userTag;

    /**
     * 通知消息类型
     */
    @DEField(name = "msgtype" , dict = "WFInfomMsgType")
    @JsonProperty("msgtype")
    @JSONField(name = "msgtype")
    @ApiModelProperty(value = "msgtype", notes = "通知消息类型")
    private Integer msgType;

    /**
     * 用户标识3
     */
    @DEField(name = "usertag3")
    @JsonProperty("usertag3")
    @JSONField(name = "usertag3")
    @ApiModelProperty(value = "usertag3", notes = "用户标识3")
    private String userTag3;

    /**
     * 通知标记2
     */
    @DEField(name = "notifytag2")
    @JsonProperty("notifytag2")
    @JSONField(name = "notifytag2")
    @ApiModelProperty(value = "notifytag2", notes = "通知标记2")
    private String notifyTag2;

    /**
     * 通知标记
     */
    @DEField(name = "notifytag")
    @JsonProperty("notifytag")
    @JSONField(name = "notifytag")
    @ApiModelProperty(value = "notifytag", notes = "通知标记")
    private String notifyTag;

    /**
     * 代码名称
     */
    @DEField(name = "codename" , defaultValue = "Notify" , defaultValueType = DEFieldDefaultValueType.USER)
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 启用
     */
    @DEField(name = "validflag" , defaultValue = "1" , dict = "YesNo")
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "validflag", notes = "启用")
    private Integer validFlag;

    /**
     * 定时触发模式
     */
    @DEField(name = "timermode" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("timermode")
    @JSONField(name = "timermode")
    @ApiModelProperty(value = "timermode", notes = "定时触发模式")
    private Integer timerMode;

    /**
     * 自定义条件
     */
    @DEField(name = "customcond")
    @JsonProperty("customcond")
    @JSONField(name = "customcond")
    @ApiModelProperty(value = "customcond", notes = "自定义条件")
    private String customCond;

    /**
     * 检查间隔
     */
    @DEField(name = "checktimer")
    @JsonProperty("checktimer")
    @JSONField(name = "checktimer")
    @ApiModelProperty(value = "checktimer", notes = "检查间隔")
    private Integer checkTimer;

    /**
     * 用户标识4
     */
    @DEField(name = "usertag4")
    @JsonProperty("usertag4")
    @JSONField(name = "usertag4")
    @ApiModelProperty(value = "usertag4", notes = "用户标识4")
    private String userTag4;

    /**
     * 延后通知间隔
     */
    @DEField(name = "notifyend")
    @JsonProperty("notifyend")
    @JSONField(name = "notifyend")
    @ApiModelProperty(value = "notifyend", notes = "延后通知间隔")
    private Integer notifyEnd;

    /**
     * 提前通知间隔
     */
    @DEField(name = "notifystart")
    @JsonProperty("notifystart")
    @JSONField(name = "notifystart")
    @ApiModelProperty(value = "notifystart", notes = "提前通知间隔")
    private Integer notifyStart;

    /**
     * 实体通知名称
     */
    @DEField(name = "psdenotifyname")
    @JsonProperty("psdenotifyname")
    @JSONField(name = "psdenotifyname")
    @ApiModelProperty(value = "psdenotifyname", notes = "实体通知名称")
    private String psdeNotifyName;

    /**
     * 实体通知标识
     */
    @Id
    @DEField(name = "psdenotifyid" , isKeyField = true)
    @JsonProperty("psdenotifyid")
    @JSONField(name = "psdenotifyid")
    @ApiModelProperty(value = "psdenotifyid", notes = "实体通知标识")
    private String psdeNotifyId;

    /**
     * 通知子类
     */
    @DEField(name = "notifysubtype" , dict = "DENotifySubType")
    @JsonProperty("notifysubtype")
    @JSONField(name = "notifysubtype")
    @ApiModelProperty(value = "notifysubtype", notes = "通知子类")
    private String notifySubType;

    /**
     * 系统消息模板
     */
    @DEField(name = "pssysmsgtemplid")
    @JsonProperty("pssysmsgtemplid")
    @JSONField(name = "pssysmsgtemplid")
    @ApiModelProperty(value = "pssysmsgtemplid", notes = "系统消息模板")
    private String psSysMsgTemplId;

    /**
     * 系统消息模板
     */
    @DEField(name = "pssysmsgtemplname")
    @JsonProperty("pssysmsgtemplname")
    @JSONField(name = "pssysmsgtemplname")
    @ApiModelProperty(value = "pssysmsgtemplname", notes = "系统消息模板")
    private String psSysMsgTemplName;

    /**
     * 系统消息队列
     */
    @DEField(name = "pssysmsgqueueid")
    @JsonProperty("pssysmsgqueueid")
    @JSONField(name = "pssysmsgqueueid")
    @ApiModelProperty(value = "pssysmsgqueueid", notes = "系统消息队列")
    private String psSysMsgQueueId;

    /**
     * 系统消息队列
     */
    @DEField(name = "pssysmsgqueuename")
    @JsonProperty("pssysmsgqueuename")
    @JSONField(name = "pssysmsgqueuename")
    @ApiModelProperty(value = "pssysmsgqueuename", notes = "系统消息队列")
    private String psSysMsgQueueName;

    /**
     * 监控事件集
     */
    @DEField(name = "events")
    @JsonProperty("events")
    @JSONField(name = "events")
    @ApiModelProperty(value = "events", notes = "监控事件集")
    private String events;

    /**
     * 监控变化属性集
     */
    @DEField(name = "fields")
    @JsonProperty("fields")
    @JSONField(name = "fields")
    @ApiModelProperty(value = "fields", notes = "监控变化属性集")
    private String fields;


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