/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 应用插件活动实体类[AddonApplicationActivity]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "ADDON_APPLICATION_ACTIVITY", resultMap = "AddonApplicationActivityResultMap")
@ApiModel(value = "ADDON_APPLICATION_ACTIVITY", description = "应用插件活动")
public class AddonApplicationActivity extends EntityMP implements Serializable
{

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 父标识
    */
    @TableField(value = "pid")
    @DEField(name = "pid")
    @JSONField(name = "pid")
    @JsonProperty("pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
    * 级别
    */
    @TableField(value = "level")
    @DEField(name = "level")
    @JSONField(name = "level")
    @JsonProperty("level")
    @ApiModelProperty(value = "level", notes = "级别")
    private String level;

    /**
    * 操作
    */
    @TableField(value = "action")
    @DEField(name = "action")
    @JSONField(name = "action")
    @JsonProperty("action")
    @ApiModelProperty(value = "action", notes = "操作")
    private String action;

    /**
    * 调试日志信息
    */
    @TableField(value = "debug_info")
    @DEField(name = "debug_info")
    @JSONField(name = "debug_info")
    @JsonProperty("debug_info")
    @ApiModelProperty(value = "debug_info", notes = "调试日志信息")
    private String debugInfo;

    /**
    * 日志信息
    */
    @TableField(value = "info")
    @DEField(name = "info")
    @JSONField(name = "info")
    @JsonProperty("info")
    @ApiModelProperty(value = "info", notes = "日志信息")
    private String info;

    /**
    * 系统标识
    */
    @TableField(value = "system_id")
    @DEField(name = "system_id")
    @JSONField(name = "system_id")
    @JsonProperty("system_id")
    @ApiModelProperty(value = "system_id", notes = "系统标识")
    private String systemId;

    /**
    * 起始时间
    */
    @TableField(value = "start_at")
    @DEField(name = "start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("start_at")
    @ApiModelProperty(value = "start_at", notes = "起始时间")
    private Date startAt;

    /**
    * 结束时间
    */
    @TableField(value = "end_at")
    @DEField(name = "end_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("end_at")
    @ApiModelProperty(value = "end_at", notes = "结束时间")
    private Date endAt;

    /**
    * 持续时间
    */
    @TableField(value = "elapsed_time")
    @DEField(name = "elapsed_time")
    @JSONField(name = "elapsed_time")
    @JsonProperty("elapsed_time")
    @ApiModelProperty(value = "elapsed_time", notes = "持续时间")
    private Integer elapsedTime;

    /**
    * 状态
    */
    @TableField(value = "state")
    @DEField(name = "state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "状态")
    private String state;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 应用插件活动
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "addon_application_activity", notes = "应用插件活动")
    private AddonApplicationActivity addonApplicationActivity;

    /**
    * 设置 [名称]
    */
    public AddonApplicationActivity setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public AddonApplicationActivity setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
    * 设置 [级别]
    */
    public AddonApplicationActivity setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
    * 设置 [操作]
    */
    public AddonApplicationActivity setAction(String action) {
        this.action = action;
        this.modify("action", action);
        return this;
    }

    /**
    * 设置 [调试日志信息]
    */
    public AddonApplicationActivity setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
        this.modify("debug_info", debugInfo);
        return this;
    }

    /**
    * 设置 [日志信息]
    */
    public AddonApplicationActivity setInfo(String info) {
        this.info = info;
        this.modify("info", info);
        return this;
    }

    /**
    * 设置 [系统标识]
    */
    public AddonApplicationActivity setSystemId(String systemId) {
        this.systemId = systemId;
        this.modify("system_id", systemId);
        return this;
    }

    /**
    * 设置 [起始时间]
    */
    public AddonApplicationActivity setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
    * 设置 [结束时间]
    */
    public AddonApplicationActivity setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
    * 设置 [持续时间]
    */
    public AddonApplicationActivity setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
        this.modify("elapsed_time", elapsedTime);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public AddonApplicationActivity setState(String state) {
        this.state = state;
        this.modify("state", state);
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
            entity.reset("id");
        }
        return targetEntity;
    }

}