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
 * 工作项[WorkItemUsuallyDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项DTO")
public class WorkItemUsuallyDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 0)
    private String id;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 1)
    private String title;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 2)
    private String identifier;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 3)
    private Integer isDeleted;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 4)
    private String state;

    /**
     * 工作项类型
     */
    @JsonProperty("work_item_type_id")
    @JSONField(name = "work_item_type_id")
    @ApiModelProperty(value = "工作项类型", position = 5)
    private String workItemTypeId;

    /**
     * 负责人
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人", position = 6)
    private String assigneeId;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 7)
    private String assigneeName;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 8)
    private String priority;

    /**
     * 父标识
     */
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "父标识", position = 9)
    private String pid;

    /**
     * 顶级工作项标识
     */
    @JsonProperty("top_id")
    @JSONField(name = "top_id")
    @ApiModelProperty(value = "顶级工作项标识", position = 10)
    private String topId;

    /**
     * 项目
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目", position = 11)
    private String projectId;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 12)
    private Integer isArchived;

    /**
     * 父工作项
     */
    @JsonProperty("ptitle")
    @JSONField(name = "ptitle")
    @ApiModelProperty(value = "父工作项", position = 13)
    private String ptitle;

    /**
     * 复现概率
     */
    @JsonProperty("reappear_probability")
    @JSONField(name = "reappear_probability")
    @ApiModelProperty(value = "复现概率", position = 14)
    private String reappearProbability;

    /**
     * 严重程度
     */
    @JsonProperty("severity")
    @JSONField(name = "severity")
    @ApiModelProperty(value = "严重程度", position = 15)
    private String severity;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 16)
    private Date createTime;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 17)
    private String showIdentifier;

    /**
     * 所属项目
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "所属项目", position = 18)
    private String projectName;

    /**
     * 迭代标识
     */
    @JsonProperty("sprint_id")
    @JSONField(name = "sprint_id")
    @ApiModelProperty(value = "迭代标识", position = 19)
    private String sprintId;

    /**
     * 需求类型
     */
    @JsonProperty("backlog_type")
    @JSONField(name = "backlog_type")
    @ApiModelProperty(value = "需求类型", position = 20)
    private String backlogType;

    /**
     * 需求来源
     */
    @JsonProperty("backlog_from")
    @JSONField(name = "backlog_from")
    @ApiModelProperty(value = "需求来源", position = 21)
    private String backlogFrom;

    /**
     * 风险
     */
    @JsonProperty("risk")
    @JSONField(name = "risk")
    @ApiModelProperty(value = "风险", position = 22)
    private String risk;

    /**
     * 迭代名称
     */
    @JsonProperty("sprint_name")
    @JSONField(name = "sprint_name")
    @ApiModelProperty(value = "迭代名称", position = 23)
    private String sprintName;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 24)
    private String curVersionId;

    /**
     * 截止时间
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "截止时间", position = 25)
    private Date endAt;

    /**
     * 开始时间
     */
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间", position = 26)
    private Date startAt;

    /**
     * 工作项状态类型
     */
    @JsonProperty("state_type")
    @JSONField(name = "state_type")
    @ApiModelProperty(value = "工作项状态类型", position = 27)
    private String stateType;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 28)
    private String createMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 29)
    private Date updateTime;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 30)
    private String updateMan;

    /**
     * 是否超时
     */
    @JsonProperty("is_overtime")
    @JSONField(name = "is_overtime")
    @ApiModelProperty(value = "是否超时", position = 31)
    private Integer isOvertime;

    /**
     * 多人任务
     */
    @JsonProperty("multiple_people")
    @JSONField(name = "multiple_people")
    @ApiModelProperty(value = "多人任务", position = 32)
    private Integer multiplePeople;

    /**
     * 逾期天数
     */
    @JsonProperty("overdue_time")
    @JSONField(name = "overdue_time")
    @ApiModelProperty(value = "逾期天数", position = 33)
    private String overdueTime;

    /**
     * 完成人
     */
    @JsonProperty("finisher")
    @JSONField(name = "finisher")
    @ApiModelProperty(value = "完成人", position = 34)
    private String finisher;

    /**
     * 实际结束时间
     */
    @JsonProperty("actual_end_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "actual_end_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际结束时间", position = 35)
    private Date actualEndAt;

    /**
     * 实际开始时间
     */
    @JsonProperty("actual_start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "actual_start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际开始时间", position = 36)
    private Date actualStartAt;


    /**
     * 设置 [标题]
     */
    public WorkItemUsuallyDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public WorkItemUsuallyDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public WorkItemUsuallyDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public WorkItemUsuallyDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [工作项类型]
     */
    public WorkItemUsuallyDTO setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public WorkItemUsuallyDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public WorkItemUsuallyDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public WorkItemUsuallyDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public WorkItemUsuallyDTO setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
     * 设置 [顶级工作项标识]
     */
    public WorkItemUsuallyDTO setTopId(String topId) {
        this.topId = topId;
        this.modify("top_id", topId);
        return this;
    }

    /**
     * 设置 [项目]
     */
    public WorkItemUsuallyDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public WorkItemUsuallyDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [父工作项]
     */
    public WorkItemUsuallyDTO setPtitle(String ptitle) {
        this.ptitle = ptitle;
        this.modify("ptitle", ptitle);
        return this;
    }

    /**
     * 设置 [复现概率]
     */
    public WorkItemUsuallyDTO setReappearProbability(String reappearProbability) {
        this.reappearProbability = reappearProbability;
        this.modify("reappear_probability", reappearProbability);
        return this;
    }

    /**
     * 设置 [严重程度]
     */
    public WorkItemUsuallyDTO setSeverity(String severity) {
        this.severity = severity;
        this.modify("severity", severity);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public WorkItemUsuallyDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [所属项目]
     */
    public WorkItemUsuallyDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [迭代标识]
     */
    public WorkItemUsuallyDTO setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
     * 设置 [需求类型]
     */
    public WorkItemUsuallyDTO setBacklogType(String backlogType) {
        this.backlogType = backlogType;
        this.modify("backlog_type", backlogType);
        return this;
    }

    /**
     * 设置 [需求来源]
     */
    public WorkItemUsuallyDTO setBacklogFrom(String backlogFrom) {
        this.backlogFrom = backlogFrom;
        this.modify("backlog_from", backlogFrom);
        return this;
    }

    /**
     * 设置 [风险]
     */
    public WorkItemUsuallyDTO setRisk(String risk) {
        this.risk = risk;
        this.modify("risk", risk);
        return this;
    }

    /**
     * 设置 [迭代名称]
     */
    public WorkItemUsuallyDTO setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
     * 设置 [截止时间]
     */
    public WorkItemUsuallyDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [开始时间]
     */
    public WorkItemUsuallyDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [工作项状态类型]
     */
    public WorkItemUsuallyDTO setStateType(String stateType) {
        this.stateType = stateType;
        this.modify("state_type", stateType);
        return this;
    }

    /**
     * 设置 [是否超时]
     */
    public WorkItemUsuallyDTO setIsOvertime(Integer isOvertime) {
        this.isOvertime = isOvertime;
        this.modify("is_overtime", isOvertime);
        return this;
    }

    /**
     * 设置 [多人任务]
     */
    public WorkItemUsuallyDTO setMultiplePeople(Integer multiplePeople) {
        this.multiplePeople = multiplePeople;
        this.modify("multiple_people", multiplePeople);
        return this;
    }

    /**
     * 设置 [逾期天数]
     */
    public WorkItemUsuallyDTO setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime;
        this.modify("overdue_time", overdueTime);
        return this;
    }

    /**
     * 设置 [完成人]
     */
    public WorkItemUsuallyDTO setFinisher(String finisher) {
        this.finisher = finisher;
        this.modify("finisher", finisher);
        return this;
    }

    /**
     * 设置 [实际结束时间]
     */
    public WorkItemUsuallyDTO setActualEndAt(Date actualEndAt) {
        this.actualEndAt = actualEndAt;
        this.modify("actual_end_at", actualEndAt);
        return this;
    }

    /**
     * 设置 [实际开始时间]
     */
    public WorkItemUsuallyDTO setActualStartAt(Date actualStartAt) {
        this.actualStartAt = actualStartAt;
        this.modify("actual_start_at", actualStartAt);
        return this;
    }


}
