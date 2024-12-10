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
 * 工作项[WorkItemBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项DTO")
public class WorkItemBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 0)
    private Integer isDeleted;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 1)
    private Integer isArchived;

    /**
     * 完成时间
     */
    @JsonProperty("completed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间", position = 2)
    private Date completedAt;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 3)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 4)
    private Date updateTime;

    /**
     * 开始时间
     */
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间", position = 5)
    private Date startAt;

    /**
     * 截止时间
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "截止时间", position = 6)
    private Date endAt;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 7)
    private String title;

    /**
     * 报表分组属性
     */
    @JsonProperty("rep_group_value")
    @JSONField(name = "rep_group_value")
    @ApiModelProperty(value = "报表分组属性", position = 8)
    private String repGroupValue;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 9)
    private String updateMan;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 10)
    private String attentionsImp;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 11)
    private String createMan;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 12)
    private String identifier;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 13)
    private String showIdentifier;

    /**
     * 关联工单数
     */
    @JsonProperty("relation_total_ticket")
    @JSONField(name = "relation_total_ticket")
    @ApiModelProperty(value = "关联工单数", position = 14)
    private BigDecimal relationTotalTicket;

    /**
     * 关联工作项数
     */
    @JsonProperty("relation_total_work_item")
    @JSONField(name = "relation_total_work_item")
    @ApiModelProperty(value = "关联工作项数", position = 15)
    private BigDecimal relationTotalWorkItem;

    /**
     * 工时进度
     */
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "工时进度", position = 16)
    private BigDecimal workloadSchedule;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 17)
    private BigDecimal remainingWorkload;

    /**
     * 关联测试用例数
     */
    @JsonProperty("relation_total_test_case")
    @JSONField(name = "relation_total_test_case")
    @ApiModelProperty(value = "关联测试用例数", position = 18)
    private BigDecimal relationTotalTestCase;

    /**
     * 关联产品需求数
     */
    @JsonProperty("relation_total_idea")
    @JSONField(name = "relation_total_idea")
    @ApiModelProperty(value = "关联产品需求数", position = 19)
    private BigDecimal relationTotalIdea;

    /**
     * 项目类型
     */
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "项目类型", position = 20)
    private String projectType;

    /**
     * 所属项目
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "所属项目", position = 21)
    private String projectName;

    /**
     * 工作项类型
     */
    @JsonProperty("work_item_type_name")
    @JSONField(name = "work_item_type_name")
    @ApiModelProperty(value = "工作项类型", position = 22)
    private String workItemTypeName;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 23)
    private String assigneeName;

    /**
     * 工作项类型
     */
    @JsonProperty("work_item_type_id")
    @JSONField(name = "work_item_type_id")
    @ApiModelProperty(value = "工作项类型", position = 24)
    private String workItemTypeId;

    /**
     * 负责人
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人", position = 25)
    private String assigneeId;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 26)
    private String state;

    /**
     * 项目
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目", position = 27)
    private String projectId;

    /**
     * 任务类别
     */
    @JsonProperty("job_type")
    @JSONField(name = "job_type")
    @ApiModelProperty(value = "任务类别", position = 28)
    private String jobType;

    /**
     * 需求来源
     */
    @JsonProperty("backlog_from")
    @JSONField(name = "backlog_from")
    @ApiModelProperty(value = "需求来源", position = 29)
    private String backlogFrom;

    /**
     * 复现概率
     */
    @JsonProperty("reappear_probability")
    @JSONField(name = "reappear_probability")
    @ApiModelProperty(value = "复现概率", position = 30)
    private String reappearProbability;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 31)
    private String priority;

    /**
     * 需求类型
     */
    @JsonProperty("backlog_type")
    @JSONField(name = "backlog_type")
    @ApiModelProperty(value = "需求类型", position = 32)
    private String backlogType;

    /**
     * 严重程度
     */
    @JsonProperty("severity")
    @JSONField(name = "severity")
    @ApiModelProperty(value = "严重程度", position = 33)
    private String severity;

    /**
     * 风险
     */
    @JsonProperty("risk")
    @JSONField(name = "risk")
    @ApiModelProperty(value = "风险", position = 34)
    private String risk;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 35)
    private String id;

    /**
     * 工作项状态类型
     */
    @JsonProperty("state_type")
    @JSONField(name = "state_type")
    @ApiModelProperty(value = "工作项状态类型", position = 36)
    private String stateType;

    /**
     * 迭代标识
     */
    @JsonProperty("sprint_id")
    @JSONField(name = "sprint_id")
    @ApiModelProperty(value = "迭代标识", position = 37)
    private String sprintId;

    /**
     * 工作项类型分组
     */
    @JsonProperty("work_item_type_group")
    @JSONField(name = "work_item_type_group")
    @ApiModelProperty(value = "工作项类型分组", position = 38)
    private String workItemTypeGroup;

    /**
     * 迭代名称
     */
    @JsonProperty("sprint_name")
    @JSONField(name = "sprint_name")
    @ApiModelProperty(value = "迭代名称", position = 39)
    private String sprintName;

    /**
     * 实际工时
     */
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "实际工时", position = 40)
    private BigDecimal actualWorkload;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 41)
    private BigDecimal estimatedWorkload;

    /**
     * 项目发布名称
     */
    @JsonProperty("release_name")
    @JSONField(name = "release_name")
    @ApiModelProperty(value = "项目发布名称", position = 42)
    private String releaseName;

    /**
     * 项目发布标识
     */
    @JsonProperty("release_id")
    @JSONField(name = "release_id")
    @ApiModelProperty(value = "项目发布标识", position = 43)
    private String releaseId;

    /**
     * 标签
     */
    @JsonProperty("tags")
    @JSONField(name = "tags")
    @ApiModelProperty(value = "标签", position = 44)
    private String tags;

    /**
     * 看板栏名称
     */
    @JsonProperty("entry_name")
    @JSONField(name = "entry_name")
    @ApiModelProperty(value = "看板栏名称", position = 45)
    private String entryName;

    /**
     * 看板栏标识
     */
    @JsonProperty("entry_id")
    @JSONField(name = "entry_id")
    @ApiModelProperty(value = "看板栏标识", position = 46)
    private String entryId;

    /**
     * 原始状态
     */
    @JsonProperty("work_item_origin_state")
    @JSONField(name = "work_item_origin_state")
    @ApiModelProperty(value = "原始状态", position = 47)
    private String workItemOriginState;

    /**
     * 看板名称
     */
    @JsonProperty("board_name")
    @JSONField(name = "board_name")
    @ApiModelProperty(value = "看板名称", position = 48)
    private String boardName;

    /**
     * 看板标识
     */
    @JsonProperty("board_id")
    @JSONField(name = "board_id")
    @ApiModelProperty(value = "看板标识", position = 49)
    private String boardId;

    /**
     * 项目是否删除
     */
    @JsonProperty("project_is_deleted")
    @JSONField(name = "project_is_deleted")
    @ApiModelProperty(value = "项目是否删除", position = 50)
    private Integer projectIsDeleted;


    /**
     * 设置 [是否已删除]
     */
    public WorkItemBiSearchGroupDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public WorkItemBiSearchGroupDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [完成时间]
     */
    public WorkItemBiSearchGroupDTO setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
        this.modify("completed_at", completedAt);
        return this;
    }

    /**
     * 设置 [开始时间]
     */
    public WorkItemBiSearchGroupDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [截止时间]
     */
    public WorkItemBiSearchGroupDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public WorkItemBiSearchGroupDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [报表分组属性]
     */
    public WorkItemBiSearchGroupDTO setRepGroupValue(String repGroupValue) {
        this.repGroupValue = repGroupValue;
        this.modify("rep_group_value", repGroupValue);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public WorkItemBiSearchGroupDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public WorkItemBiSearchGroupDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public WorkItemBiSearchGroupDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [关联工单数]
     */
    public WorkItemBiSearchGroupDTO setRelationTotalTicket(BigDecimal relationTotalTicket) {
        this.relationTotalTicket = relationTotalTicket;
        this.modify("relation_total_ticket", relationTotalTicket);
        return this;
    }

    /**
     * 设置 [关联工作项数]
     */
    public WorkItemBiSearchGroupDTO setRelationTotalWorkItem(BigDecimal relationTotalWorkItem) {
        this.relationTotalWorkItem = relationTotalWorkItem;
        this.modify("relation_total_work_item", relationTotalWorkItem);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public WorkItemBiSearchGroupDTO setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public WorkItemBiSearchGroupDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [关联测试用例数]
     */
    public WorkItemBiSearchGroupDTO setRelationTotalTestCase(BigDecimal relationTotalTestCase) {
        this.relationTotalTestCase = relationTotalTestCase;
        this.modify("relation_total_test_case", relationTotalTestCase);
        return this;
    }

    /**
     * 设置 [关联产品需求数]
     */
    public WorkItemBiSearchGroupDTO setRelationTotalIdea(BigDecimal relationTotalIdea) {
        this.relationTotalIdea = relationTotalIdea;
        this.modify("relation_total_idea", relationTotalIdea);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public WorkItemBiSearchGroupDTO setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [所属项目]
     */
    public WorkItemBiSearchGroupDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [工作项类型]
     */
    public WorkItemBiSearchGroupDTO setWorkItemTypeName(String workItemTypeName) {
        this.workItemTypeName = workItemTypeName;
        this.modify("work_item_type_name", workItemTypeName);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public WorkItemBiSearchGroupDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [工作项类型]
     */
    public WorkItemBiSearchGroupDTO setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public WorkItemBiSearchGroupDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public WorkItemBiSearchGroupDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [项目]
     */
    public WorkItemBiSearchGroupDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [任务类别]
     */
    public WorkItemBiSearchGroupDTO setJobType(String jobType) {
        this.jobType = jobType;
        this.modify("job_type", jobType);
        return this;
    }

    /**
     * 设置 [需求来源]
     */
    public WorkItemBiSearchGroupDTO setBacklogFrom(String backlogFrom) {
        this.backlogFrom = backlogFrom;
        this.modify("backlog_from", backlogFrom);
        return this;
    }

    /**
     * 设置 [复现概率]
     */
    public WorkItemBiSearchGroupDTO setReappearProbability(String reappearProbability) {
        this.reappearProbability = reappearProbability;
        this.modify("reappear_probability", reappearProbability);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public WorkItemBiSearchGroupDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [需求类型]
     */
    public WorkItemBiSearchGroupDTO setBacklogType(String backlogType) {
        this.backlogType = backlogType;
        this.modify("backlog_type", backlogType);
        return this;
    }

    /**
     * 设置 [严重程度]
     */
    public WorkItemBiSearchGroupDTO setSeverity(String severity) {
        this.severity = severity;
        this.modify("severity", severity);
        return this;
    }

    /**
     * 设置 [风险]
     */
    public WorkItemBiSearchGroupDTO setRisk(String risk) {
        this.risk = risk;
        this.modify("risk", risk);
        return this;
    }

    /**
     * 设置 [工作项状态类型]
     */
    public WorkItemBiSearchGroupDTO setStateType(String stateType) {
        this.stateType = stateType;
        this.modify("state_type", stateType);
        return this;
    }

    /**
     * 设置 [迭代标识]
     */
    public WorkItemBiSearchGroupDTO setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
     * 设置 [工作项类型分组]
     */
    public WorkItemBiSearchGroupDTO setWorkItemTypeGroup(String workItemTypeGroup) {
        this.workItemTypeGroup = workItemTypeGroup;
        this.modify("work_item_type_group", workItemTypeGroup);
        return this;
    }

    /**
     * 设置 [迭代名称]
     */
    public WorkItemBiSearchGroupDTO setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public WorkItemBiSearchGroupDTO setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public WorkItemBiSearchGroupDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [项目发布名称]
     */
    public WorkItemBiSearchGroupDTO setReleaseName(String releaseName) {
        this.releaseName = releaseName;
        this.modify("release_name", releaseName);
        return this;
    }

    /**
     * 设置 [项目发布标识]
     */
    public WorkItemBiSearchGroupDTO setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }

    /**
     * 设置 [标签]
     */
    public WorkItemBiSearchGroupDTO setTags(String tags) {
        this.tags = tags;
        this.modify("tags", tags);
        return this;
    }

    /**
     * 设置 [看板栏名称]
     */
    public WorkItemBiSearchGroupDTO setEntryName(String entryName) {
        this.entryName = entryName;
        this.modify("entry_name", entryName);
        return this;
    }

    /**
     * 设置 [看板栏标识]
     */
    public WorkItemBiSearchGroupDTO setEntryId(String entryId) {
        this.entryId = entryId;
        this.modify("entry_id", entryId);
        return this;
    }

    /**
     * 设置 [原始状态]
     */
    public WorkItemBiSearchGroupDTO setWorkItemOriginState(String workItemOriginState) {
        this.workItemOriginState = workItemOriginState;
        this.modify("work_item_origin_state", workItemOriginState);
        return this;
    }

    /**
     * 设置 [看板名称]
     */
    public WorkItemBiSearchGroupDTO setBoardName(String boardName) {
        this.boardName = boardName;
        this.modify("board_name", boardName);
        return this;
    }

    /**
     * 设置 [看板标识]
     */
    public WorkItemBiSearchGroupDTO setBoardId(String boardId) {
        this.boardId = boardId;
        this.modify("board_id", boardId);
        return this;
    }

    /**
     * 设置 [项目是否删除]
     */
    public WorkItemBiSearchGroupDTO setProjectIsDeleted(Integer projectIsDeleted) {
        this.projectIsDeleted = projectIsDeleted;
        this.modify("project_is_deleted", projectIsDeleted);
        return this;
    }


}
