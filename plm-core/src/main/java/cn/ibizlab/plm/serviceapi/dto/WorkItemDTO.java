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
 * 工作项[WorkItemDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项DTO")
public class WorkItemDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 0)
    private String showIdentifier;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 1)
    private String identifier;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 2)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 3)
    private Integer isDeleted;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 4)
    private String title;

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
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 7)
    private String state;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 8)
    private String priority;

    /**
     * 是否叶子节点
     */
    @JsonProperty("is_leaf")
    @JSONField(name = "is_leaf")
    @ApiModelProperty(value = "是否叶子节点", position = 9)
    private Integer isLeaf;

    /**
     * 需求类型
     */
    @JsonProperty("backlog_type")
    @JSONField(name = "backlog_type")
    @ApiModelProperty(value = "需求类型", position = 10)
    private String backlogType;

    /**
     * 需求来源
     */
    @JsonProperty("backlog_from")
    @JSONField(name = "backlog_from")
    @ApiModelProperty(value = "需求来源", position = 11)
    private String backlogFrom;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 12)
    private String assigneeName;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 13)
    private String description;

    /**
     * 负责人
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人", position = 14)
    private String assigneeId;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 15)
    private String curVersionId;

    /**
     * 复现概率
     */
    @JsonProperty("reappear_probability")
    @JSONField(name = "reappear_probability")
    @ApiModelProperty(value = "复现概率", position = 16)
    private String reappearProbability;

    /**
     * 严重程度
     */
    @JsonProperty("severity")
    @JSONField(name = "severity")
    @ApiModelProperty(value = "严重程度", position = 17)
    private String severity;

    /**
     * 风险
     */
    @JsonProperty("risk")
    @JSONField(name = "risk")
    @ApiModelProperty(value = "风险", position = 18)
    private String risk;

    /**
     * 项目类型
     */
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "项目类型", position = 19)
    private String projectType;

    /**
     * 工作项类型分组
     */
    @JsonProperty("work_item_type_group")
    @JSONField(name = "work_item_type_group")
    @ApiModelProperty(value = "工作项类型分组", position = 20)
    private String workItemTypeGroup;

    /**
     * 标签
     */
    @JsonProperty("tags")
    @JSONField(name = "tags")
    @ApiModelProperty(value = "标签", position = 21)
    private String tags;

    /**
     * 看板栏状态
     */
    @JsonProperty("entry_status")
    @JSONField(name = "entry_status")
    @ApiModelProperty(value = "看板栏状态", position = 22)
    private String entryStatus;

    /**
     * 所在看板栏位置
     */
    @JsonProperty("entry_position")
    @JSONField(name = "entry_position")
    @ApiModelProperty(value = "所在看板栏位置", position = 23)
    private Integer entryPosition;

    /**
     * 统计数
     */
    @JsonProperty("rep_num")
    @JSONField(name = "rep_num")
    @ApiModelProperty(value = "统计数", position = 24)
    private BigDecimal repNum;

    /**
     * 解决办法
     */
    @JsonProperty("solution_way")
    @JSONField(name = "solution_way")
    @ApiModelProperty(value = "解决办法", position = 25)
    private String solutionWay;

    /**
     * 工作项类型序号
     */
    @JsonProperty("work_item_type_sequence")
    @JSONField(name = "work_item_type_sequence")
    @ApiModelProperty(value = "工作项类型序号", position = 26)
    private BigDecimal workItemTypeSequence;

    /**
     * 完成时间
     */
    @JsonProperty("completed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间", position = 27)
    private Date completedAt;

    /**
     * 工时进度
     */
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "工时进度", position = 28)
    private BigDecimal workloadSchedule;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 29)
    private BigDecimal estimatedWorkload;

    /**
     * 任务类别
     */
    @JsonProperty("job_type")
    @JSONField(name = "job_type")
    @ApiModelProperty(value = "任务类别", position = 30)
    private String jobType;

    /**
     * 测试计划ID
     */
    @JsonProperty("test_plan_id")
    @JSONField(name = "test_plan_id")
    @ApiModelProperty(value = "测试计划ID", position = 31)
    private String testPlanId;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 32)
    private BigDecimal remainingWorkload;

    /**
     * 附件
     */
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "附件", position = 33)
    private List<AttachmentDTO> attachments;

    /**
     * 实际工时
     */
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "实际工时", position = 34)
    private BigDecimal actualWorkload;

    /**
     * 交付物
     */
    @JsonProperty("deliverable")
    @JSONField(name = "deliverable")
    @ApiModelProperty(value = "交付物", position = 35)
    private List<DeliverableDTO> deliverable;

    /**
     * 关注数
     */
    @JsonProperty("attention_count")
    @JSONField(name = "attention_count")
    @ApiModelProperty(value = "关注数", position = 36)
    private String attentionCount;

    /**
     * 父工作项类型
     */
    @JsonProperty("p_work_item_type_id")
    @JSONField(name = "p_work_item_type_id")
    @ApiModelProperty(value = "父工作项类型", position = 37)
    private String pWorkItemTypeId;

    /**
     * 评论数
     */
    @JsonProperty("comment_count")
    @JSONField(name = "comment_count")
    @ApiModelProperty(value = "评论数", position = 38)
    private String commentCount;

    /**
     * 项目标识
     */
    @JsonProperty("project_identifier")
    @JSONField(name = "project_identifier")
    @ApiModelProperty(value = "项目标识", position = 39)
    private String projectIdentifier;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 40)
    private List<AttentionDTO> attentions;

    /**
     * 报表分组属性
     */
    @JsonProperty("rep_group_value")
    @JSONField(name = "rep_group_value")
    @ApiModelProperty(value = "报表分组属性", position = 41)
    private String repGroupValue;

    /**
     * 报表百分值
     */
    @JsonProperty("rep_percent_value")
    @JSONField(name = "rep_percent_value")
    @ApiModelProperty(value = "报表百分值", position = 42)
    private BigDecimal repPercentValue;

    /**
     * 报表值1
     */
    @JsonProperty("rep_value1")
    @JSONField(name = "rep_value1")
    @ApiModelProperty(value = "报表值1", position = 43)
    private Integer repValue1;

    /**
     * 报表值3
     */
    @JsonProperty("rep_value3")
    @JSONField(name = "rep_value3")
    @ApiModelProperty(value = "报表值3", position = 44)
    private Integer repValue3;

    /**
     * 报表值2
     */
    @JsonProperty("rep_value2")
    @JSONField(name = "rep_value2")
    @ApiModelProperty(value = "报表值2", position = 45)
    private Integer repValue2;

    /**
     * 工作项状态类型
     */
    @JsonProperty("state_type")
    @JSONField(name = "state_type")
    @ApiModelProperty(value = "工作项状态类型", position = 46)
    private String stateType;

    /**
     * 当前版本名称
     */
    @JsonProperty("cur_version_name")
    @JSONField(name = "cur_version_name")
    @ApiModelProperty(value = "当前版本名称", position = 47)
    private String curVersionName;

    /**
     * 选择版本标识
     */
    @JsonProperty("choose_version_id")
    @JSONField(name = "choose_version_id")
    @ApiModelProperty(value = "选择版本标识", position = 48)
    private String chooseVersionId;

    /**
     * 选择版本名称
     */
    @JsonProperty("choose_version_name")
    @JSONField(name = "choose_version_name")
    @ApiModelProperty(value = "选择版本名称", position = 49)
    private String chooseVersionName;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 50)
    private String attentionsImp;

    /**
     * 迭代状态
     */
    @JsonProperty("sprint_status")
    @JSONField(name = "sprint_status")
    @ApiModelProperty(value = "迭代状态", position = 51)
    private String sprintStatus;

    /**
     * 发布阶段
     */
    @JsonProperty("release_status")
    @JSONField(name = "release_status")
    @ApiModelProperty(value = "发布阶段", position = 52)
    private String releaseStatus;

    /**
     * 工作项下级类型
     */
    @JsonProperty("work_item_sub_type")
    @JSONField(name = "work_item_sub_type")
    @ApiModelProperty(value = "工作项下级类型", position = 53)
    private String workItemSubType;

    /**
     * 统计日期字段
     */
    @JsonProperty("rep_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "rep_date" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "统计日期字段", position = 54)
    private Date repDate;

    /**
     * 最近创建日期
     */
    @JsonProperty("recent_create_days")
    @JSONField(name = "recent_create_days")
    @ApiModelProperty(value = "最近创建日期", position = 55)
    private Integer recentCreateDays;

    /**
     * 序号
     */
    @JsonProperty("sequence")
    @JSONField(name = "sequence")
    @ApiModelProperty(value = "序号", position = 56)
    private BigDecimal sequence;

    /**
     * 关联产品需求数
     */
    @JsonProperty("relation_total_idea")
    @JSONField(name = "relation_total_idea")
    @ApiModelProperty(value = "关联产品需求数", position = 57)
    private BigDecimal relationTotalIdea;

    /**
     * 关联测试用例数
     */
    @JsonProperty("relation_total_test_case")
    @JSONField(name = "relation_total_test_case")
    @ApiModelProperty(value = "关联测试用例数", position = 58)
    private BigDecimal relationTotalTestCase;

    /**
     * 关联工单数
     */
    @JsonProperty("relation_total_ticket")
    @JSONField(name = "relation_total_ticket")
    @ApiModelProperty(value = "关联工单数", position = 59)
    private BigDecimal relationTotalTicket;

    /**
     * 关联工作项数
     */
    @JsonProperty("relation_total_work_item")
    @JSONField(name = "relation_total_work_item")
    @ApiModelProperty(value = "关联工作项数", position = 60)
    private BigDecimal relationTotalWorkItem;

    /**
     * 原始状态
     */
    @JsonProperty("work_item_origin_state")
    @JSONField(name = "work_item_origin_state")
    @ApiModelProperty(value = "原始状态", position = 61)
    private String workItemOriginState;

    /**
     * 是否超时
     */
    @JsonProperty("is_overtime")
    @JSONField(name = "is_overtime")
    @ApiModelProperty(value = "是否超时", position = 62)
    private Integer isOvertime;

    /**
     * 执行人
     */
    @JsonProperty("executors")
    @JSONField(name = "executors")
    @ApiModelProperty(value = "执行人", position = 63)
    private List<ExecutorDTO> executors;

    /**
     * 多人任务
     */
    @JsonProperty("multiple_people")
    @JSONField(name = "multiple_people")
    @ApiModelProperty(value = "多人任务", position = 64)
    private Integer multiplePeople;

    /**
     * 实际开始时间
     */
    @JsonProperty("actual_start_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "actual_start_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际开始时间", position = 65)
    private Date actualStartAt;

    /**
     * 实际结束时间
     */
    @JsonProperty("actual_end_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "actual_end_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际结束时间", position = 66)
    private Date actualEndAt;

    /**
     * 完成人
     */
    @JsonProperty("finisher")
    @JSONField(name = "finisher")
    @ApiModelProperty(value = "完成人", position = 67)
    private String finisher;

    /**
     * 逾期天数
     */
    @JsonProperty("overdue_time")
    @JSONField(name = "overdue_time")
    @ApiModelProperty(value = "逾期天数", position = 68)
    private String overdueTime;

    /**
     * 交付物
     */
    @JsonProperty("deliverable_imp")
    @JSONField(name = "deliverable_imp")
    @ApiModelProperty(value = "交付物", position = 69)
    private String deliverableImp;

    /**
     * 项目是否删除
     */
    @JsonProperty("project_is_deleted")
    @JSONField(name = "project_is_deleted")
    @ApiModelProperty(value = "项目是否删除", position = 70)
    private Integer projectIsDeleted;

    /**
     * 项目是否归档
     */
    @JsonProperty("project_is_archived")
    @JSONField(name = "project_is_archived")
    @ApiModelProperty(value = "项目是否归档", position = 71)
    private Integer projectIsArchived;

    /**
     * 看板标识
     */
    @JsonProperty("board_id")
    @JSONField(name = "board_id")
    @ApiModelProperty(value = "看板标识", position = 72)
    private String boardId;

    /**
     * 看板名称
     */
    @JsonProperty("board_name")
    @JSONField(name = "board_name")
    @ApiModelProperty(value = "看板名称", position = 73)
    private String boardName;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 74)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 75)
    private Date createTime;

    /**
     * 看板栏标识
     */
    @JsonProperty("entry_id")
    @JSONField(name = "entry_id")
    @ApiModelProperty(value = "看板栏标识", position = 76)
    private String entryId;

    /**
     * 看板栏名称
     */
    @JsonProperty("entry_name")
    @JSONField(name = "entry_name")
    @ApiModelProperty(value = "看板栏名称", position = 77)
    private String entryName;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 78)
    private String id;

    /**
     * 父标识
     */
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "父标识", position = 79)
    private String pid;

    /**
     * 项目
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目", position = 80)
    private String projectId;

    /**
     * 所属项目
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "所属项目", position = 81)
    private String projectName;

    /**
     * 父工作项
     */
    @JsonProperty("ptitle")
    @JSONField(name = "ptitle")
    @ApiModelProperty(value = "父工作项", position = 82)
    private String ptitle;

    /**
     * 项目发布标识
     */
    @JsonProperty("release_id")
    @JSONField(name = "release_id")
    @ApiModelProperty(value = "项目发布标识", position = 83)
    private String releaseId;

    /**
     * 项目发布名称
     */
    @JsonProperty("release_name")
    @JSONField(name = "release_name")
    @ApiModelProperty(value = "项目发布名称", position = 84)
    private String releaseName;

    /**
     * 迭代标识
     */
    @JsonProperty("sprint_id")
    @JSONField(name = "sprint_id")
    @ApiModelProperty(value = "迭代标识", position = 85)
    private String sprintId;

    /**
     * 迭代名称
     */
    @JsonProperty("sprint_name")
    @JSONField(name = "sprint_name")
    @ApiModelProperty(value = "迭代名称", position = 86)
    private String sprintName;

    /**
     * 泳道标识
     */
    @JsonProperty("swimlane_id")
    @JSONField(name = "swimlane_id")
    @ApiModelProperty(value = "泳道标识", position = 87)
    private String swimlaneId;

    /**
     * 顶级工作项标识
     */
    @JsonProperty("top_id")
    @JSONField(name = "top_id")
    @ApiModelProperty(value = "顶级工作项标识", position = 88)
    private String topId;

    /**
     * 顶级工作项标题
     */
    @JsonProperty("top_title")
    @JSONField(name = "top_title")
    @ApiModelProperty(value = "顶级工作项标题", position = 89)
    private String topTitle;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 90)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 91)
    private Date updateTime;

    /**
     * 工作项类型
     */
    @JsonProperty("work_item_type_id")
    @JSONField(name = "work_item_type_id")
    @ApiModelProperty(value = "工作项类型", position = 92)
    private String workItemTypeId;

    /**
     * 工作项类型
     */
    @JsonProperty("work_item_type_name")
    @JSONField(name = "work_item_type_name")
    @ApiModelProperty(value = "工作项类型", position = 93)
    private String workItemTypeName;


    /**
     * 设置 [编号]
     */
    public WorkItemDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public WorkItemDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public WorkItemDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public WorkItemDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public WorkItemDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [开始时间]
     */
    public WorkItemDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [截止时间]
     */
    public WorkItemDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public WorkItemDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public WorkItemDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [是否叶子节点]
     */
    public WorkItemDTO setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
     * 设置 [需求类型]
     */
    public WorkItemDTO setBacklogType(String backlogType) {
        this.backlogType = backlogType;
        this.modify("backlog_type", backlogType);
        return this;
    }

    /**
     * 设置 [需求来源]
     */
    public WorkItemDTO setBacklogFrom(String backlogFrom) {
        this.backlogFrom = backlogFrom;
        this.modify("backlog_from", backlogFrom);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public WorkItemDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public WorkItemDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public WorkItemDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [复现概率]
     */
    public WorkItemDTO setReappearProbability(String reappearProbability) {
        this.reappearProbability = reappearProbability;
        this.modify("reappear_probability", reappearProbability);
        return this;
    }

    /**
     * 设置 [严重程度]
     */
    public WorkItemDTO setSeverity(String severity) {
        this.severity = severity;
        this.modify("severity", severity);
        return this;
    }

    /**
     * 设置 [风险]
     */
    public WorkItemDTO setRisk(String risk) {
        this.risk = risk;
        this.modify("risk", risk);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public WorkItemDTO setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [工作项类型分组]
     */
    public WorkItemDTO setWorkItemTypeGroup(String workItemTypeGroup) {
        this.workItemTypeGroup = workItemTypeGroup;
        this.modify("work_item_type_group", workItemTypeGroup);
        return this;
    }

    /**
     * 设置 [标签]
     */
    public WorkItemDTO setTags(String tags) {
        this.tags = tags;
        this.modify("tags", tags);
        return this;
    }

    /**
     * 设置 [看板栏状态]
     */
    public WorkItemDTO setEntryStatus(String entryStatus) {
        this.entryStatus = entryStatus;
        this.modify("entry_status", entryStatus);
        return this;
    }

    /**
     * 设置 [所在看板栏位置]
     */
    public WorkItemDTO setEntryPosition(Integer entryPosition) {
        this.entryPosition = entryPosition;
        this.modify("entry_position", entryPosition);
        return this;
    }

    /**
     * 设置 [统计数]
     */
    public WorkItemDTO setRepNum(BigDecimal repNum) {
        this.repNum = repNum;
        this.modify("rep_num", repNum);
        return this;
    }

    /**
     * 设置 [解决办法]
     */
    public WorkItemDTO setSolutionWay(String solutionWay) {
        this.solutionWay = solutionWay;
        this.modify("solution_way", solutionWay);
        return this;
    }

    /**
     * 设置 [工作项类型序号]
     */
    public WorkItemDTO setWorkItemTypeSequence(BigDecimal workItemTypeSequence) {
        this.workItemTypeSequence = workItemTypeSequence;
        this.modify("work_item_type_sequence", workItemTypeSequence);
        return this;
    }

    /**
     * 设置 [完成时间]
     */
    public WorkItemDTO setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
        this.modify("completed_at", completedAt);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public WorkItemDTO setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public WorkItemDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [任务类别]
     */
    public WorkItemDTO setJobType(String jobType) {
        this.jobType = jobType;
        this.modify("job_type", jobType);
        return this;
    }

    /**
     * 设置 [测试计划ID]
     */
    public WorkItemDTO setTestPlanId(String testPlanId) {
        this.testPlanId = testPlanId;
        this.modify("test_plan_id", testPlanId);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public WorkItemDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public WorkItemDTO setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public WorkItemDTO setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [交付物]
     */
    public WorkItemDTO setDeliverable(List<DeliverableDTO> deliverable) {
        this.deliverable = deliverable;
        this.modify("deliverable", deliverable);
        return this;
    }

    /**
     * 设置 [关注数]
     */
    public WorkItemDTO setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
        this.modify("attention_count", attentionCount);
        return this;
    }

    /**
     * 设置 [父工作项类型]
     */
    public WorkItemDTO setPWorkItemTypeId(String pWorkItemTypeId) {
        this.pWorkItemTypeId = pWorkItemTypeId;
        this.modify("p_work_item_type_id", pWorkItemTypeId);
        return this;
    }

    /**
     * 设置 [评论数]
     */
    public WorkItemDTO setCommentCount(String commentCount) {
        this.commentCount = commentCount;
        this.modify("comment_count", commentCount);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public WorkItemDTO setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
        this.modify("project_identifier", projectIdentifier);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public WorkItemDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [报表分组属性]
     */
    public WorkItemDTO setRepGroupValue(String repGroupValue) {
        this.repGroupValue = repGroupValue;
        this.modify("rep_group_value", repGroupValue);
        return this;
    }

    /**
     * 设置 [报表百分值]
     */
    public WorkItemDTO setRepPercentValue(BigDecimal repPercentValue) {
        this.repPercentValue = repPercentValue;
        this.modify("rep_percent_value", repPercentValue);
        return this;
    }

    /**
     * 设置 [报表值1]
     */
    public WorkItemDTO setRepValue1(Integer repValue1) {
        this.repValue1 = repValue1;
        this.modify("rep_value1", repValue1);
        return this;
    }

    /**
     * 设置 [报表值3]
     */
    public WorkItemDTO setRepValue3(Integer repValue3) {
        this.repValue3 = repValue3;
        this.modify("rep_value3", repValue3);
        return this;
    }

    /**
     * 设置 [报表值2]
     */
    public WorkItemDTO setRepValue2(Integer repValue2) {
        this.repValue2 = repValue2;
        this.modify("rep_value2", repValue2);
        return this;
    }

    /**
     * 设置 [工作项状态类型]
     */
    public WorkItemDTO setStateType(String stateType) {
        this.stateType = stateType;
        this.modify("state_type", stateType);
        return this;
    }

    /**
     * 设置 [当前版本名称]
     */
    public WorkItemDTO setCurVersionName(String curVersionName) {
        this.curVersionName = curVersionName;
        this.modify("cur_version_name", curVersionName);
        return this;
    }

    /**
     * 设置 [选择版本标识]
     */
    public WorkItemDTO setChooseVersionId(String chooseVersionId) {
        this.chooseVersionId = chooseVersionId;
        this.modify("choose_version_id", chooseVersionId);
        return this;
    }

    /**
     * 设置 [选择版本名称]
     */
    public WorkItemDTO setChooseVersionName(String chooseVersionName) {
        this.chooseVersionName = chooseVersionName;
        this.modify("choose_version_name", chooseVersionName);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public WorkItemDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [迭代状态]
     */
    public WorkItemDTO setSprintStatus(String sprintStatus) {
        this.sprintStatus = sprintStatus;
        this.modify("sprint_status", sprintStatus);
        return this;
    }

    /**
     * 设置 [发布阶段]
     */
    public WorkItemDTO setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
        this.modify("release_status", releaseStatus);
        return this;
    }

    /**
     * 设置 [工作项下级类型]
     */
    public WorkItemDTO setWorkItemSubType(String workItemSubType) {
        this.workItemSubType = workItemSubType;
        this.modify("work_item_sub_type", workItemSubType);
        return this;
    }

    /**
     * 设置 [统计日期字段]
     */
    public WorkItemDTO setRepDate(Date repDate) {
        this.repDate = repDate;
        this.modify("rep_date", repDate);
        return this;
    }

    /**
     * 设置 [最近创建日期]
     */
    public WorkItemDTO setRecentCreateDays(Integer recentCreateDays) {
        this.recentCreateDays = recentCreateDays;
        this.modify("recent_create_days", recentCreateDays);
        return this;
    }

    /**
     * 设置 [关联产品需求数]
     */
    public WorkItemDTO setRelationTotalIdea(BigDecimal relationTotalIdea) {
        this.relationTotalIdea = relationTotalIdea;
        this.modify("relation_total_idea", relationTotalIdea);
        return this;
    }

    /**
     * 设置 [关联测试用例数]
     */
    public WorkItemDTO setRelationTotalTestCase(BigDecimal relationTotalTestCase) {
        this.relationTotalTestCase = relationTotalTestCase;
        this.modify("relation_total_test_case", relationTotalTestCase);
        return this;
    }

    /**
     * 设置 [关联工单数]
     */
    public WorkItemDTO setRelationTotalTicket(BigDecimal relationTotalTicket) {
        this.relationTotalTicket = relationTotalTicket;
        this.modify("relation_total_ticket", relationTotalTicket);
        return this;
    }

    /**
     * 设置 [关联工作项数]
     */
    public WorkItemDTO setRelationTotalWorkItem(BigDecimal relationTotalWorkItem) {
        this.relationTotalWorkItem = relationTotalWorkItem;
        this.modify("relation_total_work_item", relationTotalWorkItem);
        return this;
    }

    /**
     * 设置 [原始状态]
     */
    public WorkItemDTO setWorkItemOriginState(String workItemOriginState) {
        this.workItemOriginState = workItemOriginState;
        this.modify("work_item_origin_state", workItemOriginState);
        return this;
    }

    /**
     * 设置 [是否超时]
     */
    public WorkItemDTO setIsOvertime(Integer isOvertime) {
        this.isOvertime = isOvertime;
        this.modify("is_overtime", isOvertime);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public WorkItemDTO setExecutors(List<ExecutorDTO> executors) {
        this.executors = executors;
        this.modify("executors", executors);
        return this;
    }

    /**
     * 设置 [多人任务]
     */
    public WorkItemDTO setMultiplePeople(Integer multiplePeople) {
        this.multiplePeople = multiplePeople;
        this.modify("multiple_people", multiplePeople);
        return this;
    }

    /**
     * 设置 [实际开始时间]
     */
    public WorkItemDTO setActualStartAt(Date actualStartAt) {
        this.actualStartAt = actualStartAt;
        this.modify("actual_start_at", actualStartAt);
        return this;
    }

    /**
     * 设置 [实际结束时间]
     */
    public WorkItemDTO setActualEndAt(Date actualEndAt) {
        this.actualEndAt = actualEndAt;
        this.modify("actual_end_at", actualEndAt);
        return this;
    }

    /**
     * 设置 [完成人]
     */
    public WorkItemDTO setFinisher(String finisher) {
        this.finisher = finisher;
        this.modify("finisher", finisher);
        return this;
    }

    /**
     * 设置 [逾期天数]
     */
    public WorkItemDTO setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime;
        this.modify("overdue_time", overdueTime);
        return this;
    }

    /**
     * 设置 [交付物]
     */
    public WorkItemDTO setDeliverableImp(String deliverableImp) {
        this.deliverableImp = deliverableImp;
        this.modify("deliverable_imp", deliverableImp);
        return this;
    }

    /**
     * 设置 [项目是否删除]
     */
    public WorkItemDTO setProjectIsDeleted(Integer projectIsDeleted) {
        this.projectIsDeleted = projectIsDeleted;
        this.modify("project_is_deleted", projectIsDeleted);
        return this;
    }

    /**
     * 设置 [项目是否归档]
     */
    public WorkItemDTO setProjectIsArchived(Integer projectIsArchived) {
        this.projectIsArchived = projectIsArchived;
        this.modify("project_is_archived", projectIsArchived);
        return this;
    }

    /**
     * 设置 [看板标识]
     */
    public WorkItemDTO setBoardId(String boardId) {
        this.boardId = boardId;
        this.modify("board_id", boardId);
        return this;
    }

    /**
     * 设置 [看板名称]
     */
    public WorkItemDTO setBoardName(String boardName) {
        this.boardName = boardName;
        this.modify("board_name", boardName);
        return this;
    }

    /**
     * 设置 [看板栏标识]
     */
    public WorkItemDTO setEntryId(String entryId) {
        this.entryId = entryId;
        this.modify("entry_id", entryId);
        return this;
    }

    /**
     * 设置 [看板栏名称]
     */
    public WorkItemDTO setEntryName(String entryName) {
        this.entryName = entryName;
        this.modify("entry_name", entryName);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public WorkItemDTO setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
     * 设置 [项目]
     */
    public WorkItemDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [所属项目]
     */
    public WorkItemDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [父工作项]
     */
    public WorkItemDTO setPtitle(String ptitle) {
        this.ptitle = ptitle;
        this.modify("ptitle", ptitle);
        return this;
    }

    /**
     * 设置 [项目发布标识]
     */
    public WorkItemDTO setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }

    /**
     * 设置 [项目发布名称]
     */
    public WorkItemDTO setReleaseName(String releaseName) {
        this.releaseName = releaseName;
        this.modify("release_name", releaseName);
        return this;
    }

    /**
     * 设置 [迭代标识]
     */
    public WorkItemDTO setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
     * 设置 [迭代名称]
     */
    public WorkItemDTO setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
     * 设置 [泳道标识]
     */
    public WorkItemDTO setSwimlaneId(String swimlaneId) {
        this.swimlaneId = swimlaneId;
        this.modify("swimlane_id", swimlaneId);
        return this;
    }

    /**
     * 设置 [顶级工作项标识]
     */
    public WorkItemDTO setTopId(String topId) {
        this.topId = topId;
        this.modify("top_id", topId);
        return this;
    }

    /**
     * 设置 [顶级工作项标题]
     */
    public WorkItemDTO setTopTitle(String topTitle) {
        this.topTitle = topTitle;
        this.modify("top_title", topTitle);
        return this;
    }

    /**
     * 设置 [工作项类型]
     */
    public WorkItemDTO setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
        return this;
    }

    /**
     * 设置 [工作项类型]
     */
    public WorkItemDTO setWorkItemTypeName(String workItemTypeName) {
        this.workItemTypeName = workItemTypeName;
        this.modify("work_item_type_name", workItemTypeName);
        return this;
    }


}
