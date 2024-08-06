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
 * 扩展日志[ExtendLogDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("扩展日志DTO")
public class ExtendLogDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 0)
    private String ownerId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 1)
    private String ownerType;

    /**
     * 所属对象子类型
     */
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "所属对象子类型", position = 2)
    private String ownerSubtype;

    /**
     * 类别
     */
    @JsonProperty("category")
    @JSONField(name = "category")
    @ApiModelProperty(value = "类别", position = 3)
    private String category;

    /**
     * 级别
     */
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "级别", position = 4)
    private String level;

    /**
     * 调试日志信息
     */
    @JsonProperty("debug_info")
    @JSONField(name = "debug_info")
    @ApiModelProperty(value = "调试日志信息", position = 5)
    private String debugInfo;

    /**
     * 日志信息
     */
    @JsonProperty("info")
    @JSONField(name = "info")
    @ApiModelProperty(value = "日志信息", position = 6)
    private String info;

    /**
     * 起始时间
     */
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "起始时间", position = 7)
    private Date startAt;

    /**
     * 结束时间
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间", position = 8)
    private Date endAt;

    /**
     * 持续时间
     */
    @JsonProperty("elapsed_time")
    @JSONField(name = "elapsed_time")
    @ApiModelProperty(value = "持续时间", position = 9)
    private Integer elapsedTime;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 10)
    private String state;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 11)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 12)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 13)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 14)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 15)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 16)
    private Date updateTime;


    /**
     * 设置 [类别]
     */
    public ExtendLogDTO setCategory(String category) {
        this.category = category;
        this.modify("category", category);
        return this;
    }

    /**
     * 设置 [级别]
     */
    public ExtendLogDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [调试日志信息]
     */
    public ExtendLogDTO setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
        this.modify("debug_info", debugInfo);
        return this;
    }

    /**
     * 设置 [日志信息]
     */
    public ExtendLogDTO setInfo(String info) {
        this.info = info;
        this.modify("info", info);
        return this;
    }

    /**
     * 设置 [起始时间]
     */
    public ExtendLogDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [结束时间]
     */
    public ExtendLogDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [持续时间]
     */
    public ExtendLogDTO setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
        this.modify("elapsed_time", elapsedTime);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public ExtendLogDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ExtendLogDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
