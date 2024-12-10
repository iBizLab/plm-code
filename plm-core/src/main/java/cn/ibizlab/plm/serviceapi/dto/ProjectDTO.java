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
 * 项目[ProjectDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("项目DTO")
public class ProjectDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 可见范围
     */
    @JsonProperty("visibility")
    @JSONField(name = "visibility")
    @ApiModelProperty(value = "可见范围", position = 0)
    private String visibility;

    /**
     * 项目状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "项目状态", position = 1)
    private String state;

    /**
     * 开始时间
     */
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间", position = 2)
    private Date startAt;

    /**
     * 结束时间
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间", position = 3)
    private Date endAt;

    /**
     * 主题色
     */
    @JsonProperty("color")
    @JSONField(name = "color")
    @ApiModelProperty(value = "主题色", position = 4)
    private String color;

    /**
     * 类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "类型", position = 5)
    private String type;

    /**
     * 项目标识
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "项目标识", position = 6)
    private String identifier;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 7)
    private Integer isArchived;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 8)
    private String description;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 9)
    private Integer isDeleted;

    /**
     * 是否星标
     */
    @JsonProperty("is_favorite")
    @JSONField(name = "is_favorite")
    @ApiModelProperty(value = "是否星标", position = 10)
    private String isFavorite;

    /**
     * 所属
     */
    @JsonProperty("scope_type")
    @JSONField(name = "scope_type")
    @ApiModelProperty(value = "所属", position = 11)
    private String scopeType;

    /**
     * 所属对象
     */
    @JsonProperty("scope_id")
    @JSONField(name = "scope_id")
    @ApiModelProperty(value = "所属对象", position = 12)
    private String scopeId;

    /**
     * 是否本地配置
     */
    @JsonProperty("is_local_configure")
    @JSONField(name = "is_local_configure")
    @ApiModelProperty(value = "是否本地配置", position = 13)
    private Integer isLocalConfigure;

    /**
     * 成员
     */
    @JsonProperty("members")
    @JSONField(name = "members")
    @ApiModelProperty(value = "成员", position = 14)
    private List<ProjectMemberDTO> members;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 15)
    private String assigneeName;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 16)
    private String assigneeId;

    /**
     * 已完成工作项数
     */
    @JsonProperty("completed_work_items")
    @JSONField(name = "completed_work_items")
    @ApiModelProperty(value = "已完成工作项数", position = 17)
    private BigDecimal completedWorkItems;

    /**
     * 全部工作项数
     */
    @JsonProperty("all_work_items")
    @JSONField(name = "all_work_items")
    @ApiModelProperty(value = "全部工作项数", position = 18)
    private BigDecimal allWorkItems;

    /**
     * 临时
     */
    @JsonProperty("temp")
    @JSONField(name = "temp")
    @ApiModelProperty(value = "临时", position = 19)
    private String temp;

    /**
     * 公告
     */
    @JsonProperty("notice")
    @JSONField(name = "notice")
    @ApiModelProperty(value = "公告", position = 20)
    private String notice;

    /**
     * 进度
     */
    @JsonProperty("schedule")
    @JSONField(name = "schedule")
    @ApiModelProperty(value = "进度", position = 21)
    private BigDecimal schedule;

    /**
     * 实际开始时间
     */
    @JsonProperty("actual_start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "actual_start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "实际开始时间", position = 22)
    private Date actualStartAt;

    /**
     * 实际结束时间
     */
    @JsonProperty("actual_end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "actual_end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "实际结束时间", position = 23)
    private Date actualEndAt;

    /**
     * 预计工时
     */
    @JsonProperty("expected_time")
    @JSONField(name = "expected_time")
    @ApiModelProperty(value = "预计工时", position = 24)
    private String expectedTime;

    /**
     * 消耗工时
     */
    @JsonProperty("consume_time")
    @JSONField(name = "consume_time")
    @ApiModelProperty(value = "消耗工时", position = 25)
    private String consumeTime;

    /**
     * 状态类型
     */
    @JsonProperty("state_type")
    @JSONField(name = "state_type")
    @ApiModelProperty(value = "状态类型", position = 26)
    private String stateType;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 27)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 28)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 29)
    private String id;

    /**
     * 项目名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "项目名称", position = 30)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 31)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 32)
    private Date updateTime;


    /**
     * 设置 [可见范围]
     */
    public ProjectDTO setVisibility(String visibility) {
        this.visibility = visibility;
        this.modify("visibility", visibility);
        return this;
    }

    /**
     * 设置 [项目状态]
     */
    public ProjectDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [开始时间]
     */
    public ProjectDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [结束时间]
     */
    public ProjectDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [主题色]
     */
    public ProjectDTO setColor(String color) {
        this.color = color;
        this.modify("color", color);
        return this;
    }

    /**
     * 设置 [类型]
     */
    public ProjectDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public ProjectDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public ProjectDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public ProjectDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public ProjectDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [是否星标]
     */
    public ProjectDTO setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
        this.modify("is_favorite", isFavorite);
        return this;
    }

    /**
     * 设置 [所属]
     */
    public ProjectDTO setScopeType(String scopeType) {
        this.scopeType = scopeType;
        this.modify("scope_type", scopeType);
        return this;
    }

    /**
     * 设置 [所属对象]
     */
    public ProjectDTO setScopeId(String scopeId) {
        this.scopeId = scopeId;
        this.modify("scope_id", scopeId);
        return this;
    }

    /**
     * 设置 [是否本地配置]
     */
    public ProjectDTO setIsLocalConfigure(Integer isLocalConfigure) {
        this.isLocalConfigure = isLocalConfigure;
        this.modify("is_local_configure", isLocalConfigure);
        return this;
    }

    /**
     * 设置 [成员]
     */
    public ProjectDTO setMembers(List<ProjectMemberDTO> members) {
        this.members = members;
        this.modify("members", members);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public ProjectDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public ProjectDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [已完成工作项数]
     */
    public ProjectDTO setCompletedWorkItems(BigDecimal completedWorkItems) {
        this.completedWorkItems = completedWorkItems;
        this.modify("completed_work_items", completedWorkItems);
        return this;
    }

    /**
     * 设置 [全部工作项数]
     */
    public ProjectDTO setAllWorkItems(BigDecimal allWorkItems) {
        this.allWorkItems = allWorkItems;
        this.modify("all_work_items", allWorkItems);
        return this;
    }

    /**
     * 设置 [临时]
     */
    public ProjectDTO setTemp(String temp) {
        this.temp = temp;
        this.modify("temp", temp);
        return this;
    }

    /**
     * 设置 [公告]
     */
    public ProjectDTO setNotice(String notice) {
        this.notice = notice;
        this.modify("notice", notice);
        return this;
    }

    /**
     * 设置 [进度]
     */
    public ProjectDTO setSchedule(BigDecimal schedule) {
        this.schedule = schedule;
        this.modify("schedule", schedule);
        return this;
    }

    /**
     * 设置 [实际开始时间]
     */
    public ProjectDTO setActualStartAt(Date actualStartAt) {
        this.actualStartAt = actualStartAt;
        this.modify("actual_start_at", actualStartAt);
        return this;
    }

    /**
     * 设置 [实际结束时间]
     */
    public ProjectDTO setActualEndAt(Date actualEndAt) {
        this.actualEndAt = actualEndAt;
        this.modify("actual_end_at", actualEndAt);
        return this;
    }

    /**
     * 设置 [预计工时]
     */
    public ProjectDTO setExpectedTime(String expectedTime) {
        this.expectedTime = expectedTime;
        this.modify("expected_time", expectedTime);
        return this;
    }

    /**
     * 设置 [消耗工时]
     */
    public ProjectDTO setConsumeTime(String consumeTime) {
        this.consumeTime = consumeTime;
        this.modify("consume_time", consumeTime);
        return this;
    }

    /**
     * 设置 [状态类型]
     */
    public ProjectDTO setStateType(String stateType) {
        this.stateType = stateType;
        this.modify("state_type", stateType);
        return this;
    }

    /**
     * 设置 [项目名称]
     */
    public ProjectDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
