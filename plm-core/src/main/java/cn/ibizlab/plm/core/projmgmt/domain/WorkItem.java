/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.projmgmt.domain.Board;
import cn.ibizlab.plm.core.projmgmt.domain.Entry;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.domain.Swimlane;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Recent;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.projmgmt.domain.TransitionHistory;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Workload;

/**
 * 工作项实体类[WorkItem]
 *
 * @author generator
 */
@Audit
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "WORK_ITEM", resultMap = "WorkItemResultMap")
@ApiModel(value = "WORK_ITEM", description = "工作项")
public class WorkItem extends EntityMP implements Serializable
{

    /**
    * 编号
    */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JSONField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
    * 编号
    */
    @TableField(value = "identifier")
    @DEField(name = "identifier" , dupCheck = DupCheck.ALL , dupCheckField = "projectId")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
    * 是否已归档
    */
    @TableField(value = "is_archived")
    @DEField(name = "is_archived" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_archived")
    @JsonProperty("is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private Integer isArchived;

    /**
    * 标题
    */
    @TableField(value = "title")
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
    * 是否已删除
    */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
    * 开始时间
    */
    @TableField(value = "start_at")
    @DEField(name = "start_at" , fieldType = "DATE", format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @JsonProperty("start_at")
    @ApiModelProperty(value = "start_at", notes = "开始时间")
    private Date startAt;

    /**
    * 截止时间
    */
    @TableField(value = "end_at")
    @DEField(name = "end_at" , fieldType = "DATE", format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @JsonProperty("end_at")
    @ApiModelProperty(value = "end_at", notes = "截止时间")
    private Date endAt;

    /**
    * 状态
    */
    @TableField(value = "state")
    @DEField(name = "state" , defaultValue = "10" , dict = "work_item_state2")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "状态")
    private String state;

    /**
    * 优先级
    */
    @TableField(value = "priority")
    @DEField(name = "priority" , defaultValue = "20" , dict = "work_item_priority")
    @JSONField(name = "priority")
    @JsonProperty("priority")
    @ApiModelProperty(value = "priority", notes = "优先级")
    private String priority;

    /**
    * 是否叶子节点
    */
    @TableField(value = "is_leaf")
    @DEField(name = "is_leaf" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "is_leaf")
    @JsonProperty("is_leaf")
    @ApiModelProperty(value = "is_leaf", notes = "是否叶子节点")
    private Integer isLeaf;

    /**
    * 需求类型
    */
    @TableField(value = "backlog_type")
    @DEField(name = "backlog_type" , dict = "requirement_type")
    @JSONField(name = "backlog_type")
    @JsonProperty("backlog_type")
    @ApiModelProperty(value = "backlog_type", notes = "需求类型")
    private String backlogType;

    /**
    * 需求来源
    */
    @TableField(value = "backlog_from")
    @DEField(name = "backlog_from" , dict = "demand_sources")
    @JSONField(name = "backlog_from")
    @JsonProperty("backlog_from")
    @ApiModelProperty(value = "backlog_from", notes = "需求来源")
    private String backlogFrom;

    /**
    * 描述
    */
    @TableField(value = "description")
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
    * 负责人
    */
    @TableField(value = "assignee_name")
    @DEField(name = "assignee_name")
    @JSONField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
    * 复现概率
    */
    @TableField(value = "reappear_probability")
    @DEField(name = "reappear_probability" , dict = "reproduction_probability")
    @JSONField(name = "reappear_probability")
    @JsonProperty("reappear_probability")
    @ApiModelProperty(value = "reappear_probability", notes = "复现概率")
    private String reappearProbability;

    /**
    * 负责人
    */
    @TableField(value = "assignee_id")
    @DEField(name = "assignee_id")
    @JSONField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人")
    private String assigneeId;

    /**
    * 当前版本标识
    */
    @TableField(value = "cur_version_id")
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
    * 严重程度
    */
    @TableField(value = "severity")
    @DEField(name = "severity" , dict = "severity")
    @JSONField(name = "severity")
    @JsonProperty("severity")
    @ApiModelProperty(value = "severity", notes = "严重程度")
    private String severity;

    /**
    * 风险
    */
    @TableField(value = "risk")
    @DEField(name = "risk" , dict = "risk")
    @JSONField(name = "risk")
    @JsonProperty("risk")
    @ApiModelProperty(value = "risk", notes = "风险")
    private String risk;

    /**
    * 项目类型
    */
    @TableField(value = "project_type" , exist = false)
    @DEField(name = "project_type" , dict = "project_type")
    @JSONField(name = "project_type")
    @JsonProperty("project_type")
    @ApiModelProperty(value = "project_type", notes = "项目类型")
    private String projectType;

    /**
    * 工作项类型分组
    */
    @TableField(value = "work_item_type_group" , exist = false)
    @DEField(name = "work_item_type_group" , dict = "work_item_type_group")
    @JSONField(name = "work_item_type_group")
    @JsonProperty("work_item_type_group")
    @ApiModelProperty(value = "work_item_type_group", notes = "工作项类型分组")
    private String workItemTypeGroup;

    /**
    * 标签
    */
    @TableField(value = "tags")
    @DEField(name = "tags" , dict = "project_tag")
    @JSONField(name = "tags")
    @JsonProperty("tags")
    @ApiModelProperty(value = "tags", notes = "标签")
    private String tags;

    /**
    * 看板栏状态
    */
    @TableField(value = "entry_status")
    @DEField(name = "entry_status")
    @JSONField(name = "entry_status")
    @JsonProperty("entry_status")
    @ApiModelProperty(value = "entry_status", notes = "看板栏状态")
    private String entryStatus;

    /**
    * 所在看板栏位置
    */
    @TableField(value = "entry_position")
    @DEField(name = "entry_position")
    @JSONField(name = "entry_position")
    @JsonProperty("entry_position")
    @ApiModelProperty(value = "entry_position", notes = "所在看板栏位置")
    private Integer entryPosition;

    /**
    * 统计数
    */
    @TableField(value = "rep_num" , exist = false)
    @DEField(name = "rep_num")
    @JSONField(name = "rep_num")
    @JsonProperty("rep_num")
    @ApiModelProperty(value = "rep_num", notes = "统计数")
    private BigDecimal repNum;

    /**
    * 工作项类型序号
    */
    @TableField(value = "work_item_type_sequence" , exist = false)
    @DEField(name = "work_item_type_sequence")
    @JSONField(name = "work_item_type_sequence")
    @JsonProperty("work_item_type_sequence")
    @ApiModelProperty(value = "work_item_type_sequence", notes = "工作项类型序号")
    private BigDecimal workItemTypeSequence;

    /**
    * 完成时间
    */
    @TableField(value = "completed_at")
    @DEField(name = "completed_at" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("completed_at")
    @ApiModelProperty(value = "completed_at", notes = "完成时间")
    private Date completedAt;

    /**
    * 工时进度
    */
    @TableField(value = "workload_schedule" , exist = false)
    @DEField(name = "workload_schedule")
    @JSONField(name = "workload_schedule")
    @JsonProperty("workload_schedule")
    @ApiModelProperty(value = "workload_schedule", notes = "工时进度")
    private BigDecimal workloadSchedule;

    /**
    * 预估工时
    */
    @TableField(exist = false)
    @DEField(name = "estimated_workload")
    @JSONField(name = "estimated_workload")
    @JsonProperty("estimated_workload")
    @ApiModelProperty(value = "estimated_workload", notes = "预估工时")
    private BigDecimal estimatedWorkload;

    /**
    * 任务类别
    */
    @TableField(value = "job_type")
    @DEField(name = "job_type" , dict = "task_category")
    @JSONField(name = "job_type")
    @JsonProperty("job_type")
    @ApiModelProperty(value = "job_type", notes = "任务类别")
    private String jobType;

    /**
    * 测试计划ID
    */
    @TableField(value = "test_plan_id" , exist = false)
    @DEField(name = "test_plan_id")
    @JSONField(name = "test_plan_id")
    @JsonProperty("test_plan_id")
    @ApiModelProperty(value = "test_plan_id", notes = "测试计划ID")
    private String testPlanId;

    /**
    * 剩余工时
    */
    @TableField(exist = false)
    @DEField(name = "remaining_workload")
    @JSONField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

    /**
    * 附件
    */
    @TableField(exist = false)
    @DEField(name = "attachments")
    @JSONField(name = "attachments")
    @JsonProperty("attachments")
    @ApiModelProperty(value = "attachments", notes = "附件")
    private List<Attachment> attachments;

    /**
    * 实际工时
    */
    @TableField(exist = false)
    @DEField(name = "actual_workload")
    @JSONField(name = "actual_workload")
    @JsonProperty("actual_workload")
    @ApiModelProperty(value = "actual_workload", notes = "实际工时")
    private BigDecimal actualWorkload;

    /**
    * 交付物
    */
    @TableField(exist = false)
    @DEField(name = "deliverable")
    @JSONField(name = "deliverable")
    @JsonProperty("deliverable")
    @ApiModelProperty(value = "deliverable", notes = "交付物")
    private List<Deliverable> deliverable;

    /**
    * 项目标识
    */
    @TableField(value = "project_identifier" , exist = false)
    @DEField(name = "project_identifier")
    @JSONField(name = "project_identifier")
    @JsonProperty("project_identifier")
    @ApiModelProperty(value = "project_identifier", notes = "项目标识")
    private String projectIdentifier;

    /**
    * 关注
    */
    @TableField(exist = false)
    @DEField(name = "attentions" , dict = "SysOperator")
    @JSONField(name = "attentions")
    @JsonProperty("attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
    * 报表分组属性
    */
    @TableField(value = "rep_group_value" , exist = false)
    @DEField(name = "rep_group_value")
    @JSONField(name = "rep_group_value")
    @JsonProperty("rep_group_value")
    @ApiModelProperty(value = "rep_group_value", notes = "报表分组属性")
    private String repGroupValue;

    /**
    * 报表百分值
    */
    @TableField(value = "rep_percent_value" , exist = false)
    @DEField(name = "rep_percent_value")
    @JSONField(name = "rep_percent_value")
    @JsonProperty("rep_percent_value")
    @ApiModelProperty(value = "rep_percent_value", notes = "报表百分值")
    private BigDecimal repPercentValue;

    /**
    * 报表值1
    */
    @TableField(value = "rep_value_1" , exist = false)
    @DEField(name = "rep_value_1")
    @JSONField(name = "rep_value_1")
    @JsonProperty("rep_value_1")
    @ApiModelProperty(value = "rep_value_1", notes = "报表值1")
    private Integer repValue1;

    /**
    * 报表值3
    */
    @TableField(value = "rep_value_3" , exist = false)
    @DEField(name = "rep_value_3")
    @JSONField(name = "rep_value_3")
    @JsonProperty("rep_value_3")
    @ApiModelProperty(value = "rep_value_3", notes = "报表值3")
    private Integer repValue3;

    /**
    * 报表值2
    */
    @TableField(value = "rep_value_2" , exist = false)
    @DEField(name = "rep_value_2")
    @JSONField(name = "rep_value_2")
    @JsonProperty("rep_value_2")
    @ApiModelProperty(value = "rep_value_2", notes = "报表值2")
    private Integer repValue2;

    /**
    * 工作项状态类型
    */
    @TableField(value = "state_type" , exist = false)
    @DEField(name = "state_type" , dict = "state_type")
    @JSONField(name = "state_type")
    @JsonProperty("state_type")
    @ApiModelProperty(value = "state_type", notes = "工作项状态类型")
    private String stateType;

    /**
    * 当前版本名称
    */
    @TableField(value = "cur_version_name" , exist = false)
    @DEField(name = "cur_version_name")
    @JSONField(name = "cur_version_name")
    @JsonProperty("cur_version_name")
    @ApiModelProperty(value = "cur_version_name", notes = "当前版本名称")
    private String curVersionName;

    /**
    * 选择版本标识
    */
    @TableField(value = "choose_version_id" , exist = false)
    @DEField(name = "choose_version_id")
    @JSONField(name = "choose_version_id")
    @JsonProperty("choose_version_id")
    @ApiModelProperty(value = "choose_version_id", notes = "选择版本标识")
    private String chooseVersionId;

    /**
    * 选择版本名称
    */
    @TableField(value = "choose_version_name" , exist = false)
    @DEField(name = "choose_version_name")
    @JSONField(name = "choose_version_name")
    @JsonProperty("choose_version_name")
    @ApiModelProperty(value = "choose_version_name", notes = "选择版本名称")
    private String chooseVersionName;

    /**
    * 关注人
    */
    @TableField(value = "attentions_imp" , exist = false)
    @DEField(name = "attentions_imp")
    @JSONField(name = "attentions_imp")
    @JsonProperty("attentions_imp")
    @ApiModelProperty(value = "attentions_imp", notes = "关注人")
    private String attentionsImp;

    /**
    * 迭代状态
    */
    @TableField(value = "sprint_status" , exist = false)
    @DEField(name = "sprint_status" , dict = "sprint_status")
    @JSONField(name = "sprint_status")
    @JsonProperty("sprint_status")
    @ApiModelProperty(value = "sprint_status", notes = "迭代状态")
    private String sprintStatus;

    /**
    * 发布阶段
    */
    @TableField(value = "release_status" , exist = false)
    @DEField(name = "release_status" , dict = "cur_release_stage")
    @JSONField(name = "release_status")
    @JsonProperty("release_status")
    @ApiModelProperty(value = "release_status", notes = "发布阶段")
    private String releaseStatus;

    /**
    * 工作项下级类型
    */
    @TableField(value = "work_item_sub_type" , exist = false)
    @DEField(name = "work_item_sub_type")
    @JSONField(name = "work_item_sub_type")
    @JsonProperty("work_item_sub_type")
    @ApiModelProperty(value = "work_item_sub_type", notes = "工作项下级类型")
    private String workItemSubType;

    /**
    * 统计日期字段
    */
    @TableField(value = "rep_date" , exist = false)
    @DEField(name = "rep_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "rep_date" , format = "yyyy-MM-dd")
    @JsonProperty("rep_date")
    @ApiModelProperty(value = "rep_date", notes = "统计日期字段")
    private Date repDate;

    /**
    * 最近创建日期
    */
    @TableField(value = "recent_create_days" , exist = false)
    @DEField(name = "recent_create_days")
    @JSONField(name = "recent_create_days")
    @JsonProperty("recent_create_days")
    @ApiModelProperty(value = "recent_create_days", notes = "最近创建日期")
    private Integer recentCreateDays;

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 关联产品需求数
    */
    @TableField(value = "relation_total_idea" , exist = false)
    @DEField(name = "relation_total_idea")
    @JSONField(name = "relation_total_idea")
    @JsonProperty("relation_total_idea")
    @ApiModelProperty(value = "relation_total_idea", notes = "关联产品需求数")
    private BigDecimal relationTotalIdea;

    /**
    * 关联测试用例数
    */
    @TableField(value = "relation_total_test_case" , exist = false)
    @DEField(name = "relation_total_test_case")
    @JSONField(name = "relation_total_test_case")
    @JsonProperty("relation_total_test_case")
    @ApiModelProperty(value = "relation_total_test_case", notes = "关联测试用例数")
    private BigDecimal relationTotalTestCase;

    /**
    * 关联工单数
    */
    @TableField(value = "relation_total_ticket" , exist = false)
    @DEField(name = "relation_total_ticket")
    @JSONField(name = "relation_total_ticket")
    @JsonProperty("relation_total_ticket")
    @ApiModelProperty(value = "relation_total_ticket", notes = "关联工单数")
    private BigDecimal relationTotalTicket;

    /**
    * 关联工作项数
    */
    @TableField(value = "relation_total_work_item" , exist = false)
    @DEField(name = "relation_total_work_item")
    @JSONField(name = "relation_total_work_item")
    @JsonProperty("relation_total_work_item")
    @ApiModelProperty(value = "relation_total_work_item", notes = "关联工作项数")
    private BigDecimal relationTotalWorkItem;

    /**
    * 原始状态
    */
    @TableField(value = "work_item_origin_state" , exist = false)
    @DEField(name = "work_item_origin_state" , dict = "work_item_origin_state")
    @JSONField(name = "work_item_origin_state")
    @JsonProperty("work_item_origin_state")
    @ApiModelProperty(value = "work_item_origin_state", notes = "原始状态")
    private String workItemOriginState;

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
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

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
    * 项目
    */
    @TableField(value = "project_id")
    @DEField(name = "project_id")
    @JSONField(name = "project_id")
    @JsonProperty("project_id")
    @ApiModelProperty(value = "project_id", notes = "项目")
    private String projectId;

    /**
    * 工作项类型
    */
    @TableField(value = "work_item_type_id")
    @DEField(name = "work_item_type_id" , dict = "work_item_type")
    @JSONField(name = "work_item_type_id")
    @JsonProperty("work_item_type_id")
    @ApiModelProperty(value = "work_item_type_id", notes = "工作项类型")
    private String workItemTypeId;

    /**
    * 所属项目
    */
    @TableField(value = "project_name" , exist = false)
    @DEField(name = "project_name")
    @JSONField(name = "project_name")
    @JsonProperty("project_name")
    @ApiModelProperty(value = "project_name", notes = "所属项目")
    private String projectName;

    /**
    * 工作项类型
    */
    @TableField(value = "work_item_type_name" , exist = false)
    @DEField(name = "work_item_type_name")
    @JSONField(name = "work_item_type_name")
    @JsonProperty("work_item_type_name")
    @ApiModelProperty(value = "work_item_type_name", notes = "工作项类型")
    private String workItemTypeName;

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
    * 父工作项
    */
    @TableField(value = "ptitle" , exist = false)
    @DEField(name = "ptitle")
    @JSONField(name = "ptitle")
    @JsonProperty("ptitle")
    @ApiModelProperty(value = "ptitle", notes = "父工作项")
    private String ptitle;

    /**
    * 迭代标识
    */
    @TableField(value = "sprint_id")
    @DEField(name = "sprint_id")
    @JSONField(name = "sprint_id")
    @JsonProperty("sprint_id")
    @ApiModelProperty(value = "sprint_id", notes = "迭代标识")
    private String sprintId;

    /**
    * 看板标识
    */
    @TableField(value = "board_id")
    @DEField(name = "board_id" , dict = "project_board")
    @JSONField(name = "board_id")
    @JsonProperty("board_id")
    @ApiModelProperty(value = "board_id", notes = "看板标识")
    private String boardId;

    /**
    * 看板栏标识
    */
    @TableField(value = "entry_id")
    @DEField(name = "entry_id")
    @JSONField(name = "entry_id")
    @JsonProperty("entry_id")
    @ApiModelProperty(value = "entry_id", notes = "看板栏标识")
    private String entryId;

    /**
    * 泳道标识
    */
    @TableField(value = "swimlane_id")
    @DEField(name = "swimlane_id")
    @JSONField(name = "swimlane_id")
    @JsonProperty("swimlane_id")
    @ApiModelProperty(value = "swimlane_id", notes = "泳道标识")
    private String swimlaneId;

    /**
    * 看板栏名称
    */
    @TableField(value = "entry_name" , exist = false)
    @DEField(name = "entry_name")
    @JSONField(name = "entry_name")
    @JsonProperty("entry_name")
    @ApiModelProperty(value = "entry_name", notes = "看板栏名称")
    private String entryName;

    /**
    * 看板名称
    */
    @TableField(value = "board_name" , exist = false)
    @DEField(name = "board_name")
    @JSONField(name = "board_name")
    @JsonProperty("board_name")
    @ApiModelProperty(value = "board_name", notes = "看板名称")
    private String boardName;

    /**
    * 顶级工作项标识
    */
    @TableField(value = "top_id")
    @DEField(name = "top_id")
    @JSONField(name = "top_id")
    @JsonProperty("top_id")
    @ApiModelProperty(value = "top_id", notes = "顶级工作项标识")
    private String topId;

    /**
    * 顶级工作项标题
    */
    @TableField(value = "top_title" , exist = false)
    @DEField(name = "top_title")
    @JSONField(name = "top_title")
    @JsonProperty("top_title")
    @ApiModelProperty(value = "top_title", notes = "顶级工作项标题")
    private String topTitle;

    /**
    * 迭代名称
    */
    @TableField(value = "sprint_name" , exist = false)
    @DEField(name = "sprint_name")
    @JSONField(name = "sprint_name")
    @JsonProperty("sprint_name")
    @ApiModelProperty(value = "sprint_name", notes = "迭代名称")
    private String sprintName;

    /**
    * 项目发布标识
    */
    @TableField(value = "release_id")
    @DEField(name = "release_id")
    @JSONField(name = "release_id")
    @JsonProperty("release_id")
    @ApiModelProperty(value = "release_id", notes = "项目发布标识")
    private String releaseId;

    /**
    * 项目发布名称
    */
    @TableField(value = "release_name" , exist = false)
    @DEField(name = "release_name")
    @JSONField(name = "release_name")
    @JsonProperty("release_name")
    @ApiModelProperty(value = "release_name", notes = "项目发布名称")
    private String releaseName;

    /**
    * 看板
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "board", notes = "看板")
    private Board board;

    /**
    * 看板栏
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "entry", notes = "看板栏")
    private Entry entry;

    /**
    * 项目-工作项
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "项目-工作项")
    private Project project;

    /**
    * 项目发布
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "release", notes = "项目发布")
    private Release release;

    /**
    * 迭代
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "sprint", notes = "迭代")
    private Sprint sprint;

    /**
    * 泳道
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "swimlane", notes = "泳道")
    private Swimlane swimlane;

    /**
    * 负责人
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "user", notes = "负责人")
    private User user;

    /**
    * 父工作项
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item", notes = "父工作项")
    private WorkItem workItem;

    /**
    * 工作项状态
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item_state", notes = "工作项状态")
    private WorkItemState workItemState;

    /**
    * 顶级工作项
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item2", notes = "顶级工作项")
    private WorkItem workItem2;

    /**
    * 工作项类型
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item_type", notes = "工作项类型")
    private WorkItemType workItemType;

    /**
    * 工作项通用规则
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "common_flow", notes = "工作项通用规则")
    private CommonFlow commonFlow;

    /**
    * 设置 [编号]
    */
    public WorkItem setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public WorkItem setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public WorkItem setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public WorkItem setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public WorkItem setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [开始时间]
    */
    public WorkItem setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
    * 设置 [截止时间]
    */
    public WorkItem setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public WorkItem setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [优先级]
    */
    public WorkItem setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
    * 设置 [是否叶子节点]
    */
    public WorkItem setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
    * 设置 [需求类型]
    */
    public WorkItem setBacklogType(String backlogType) {
        this.backlogType = backlogType;
        this.modify("backlog_type", backlogType);
        return this;
    }

    /**
    * 设置 [需求来源]
    */
    public WorkItem setBacklogFrom(String backlogFrom) {
        this.backlogFrom = backlogFrom;
        this.modify("backlog_from", backlogFrom);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public WorkItem setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public WorkItem setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
    * 设置 [复现概率]
    */
    public WorkItem setReappearProbability(String reappearProbability) {
        this.reappearProbability = reappearProbability;
        this.modify("reappear_probability", reappearProbability);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public WorkItem setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
    * 设置 [严重程度]
    */
    public WorkItem setSeverity(String severity) {
        this.severity = severity;
        this.modify("severity", severity);
        return this;
    }

    /**
    * 设置 [风险]
    */
    public WorkItem setRisk(String risk) {
        this.risk = risk;
        this.modify("risk", risk);
        return this;
    }

    /**
    * 设置 [项目类型]
    */
    public WorkItem setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
    * 设置 [工作项类型分组]
    */
    public WorkItem setWorkItemTypeGroup(String workItemTypeGroup) {
        this.workItemTypeGroup = workItemTypeGroup;
        this.modify("work_item_type_group", workItemTypeGroup);
        return this;
    }

    /**
    * 设置 [标签]
    */
    public WorkItem setTags(String tags) {
        this.tags = tags;
        this.modify("tags", tags);
        return this;
    }

    /**
    * 设置 [看板栏状态]
    */
    public WorkItem setEntryStatus(String entryStatus) {
        this.entryStatus = entryStatus;
        this.modify("entry_status", entryStatus);
        return this;
    }

    /**
    * 设置 [所在看板栏位置]
    */
    public WorkItem setEntryPosition(Integer entryPosition) {
        this.entryPosition = entryPosition;
        this.modify("entry_position", entryPosition);
        return this;
    }

    /**
    * 设置 [统计数]
    */
    public WorkItem setRepNum(BigDecimal repNum) {
        this.repNum = repNum;
        this.modify("rep_num", repNum);
        return this;
    }

    /**
    * 设置 [工作项类型序号]
    */
    public WorkItem setWorkItemTypeSequence(BigDecimal workItemTypeSequence) {
        this.workItemTypeSequence = workItemTypeSequence;
        this.modify("work_item_type_sequence", workItemTypeSequence);
        return this;
    }

    /**
    * 设置 [完成时间]
    */
    public WorkItem setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
        this.modify("completed_at", completedAt);
        return this;
    }

    /**
    * 设置 [工时进度]
    */
    public WorkItem setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
    * 设置 [预估工时]
    */
    public WorkItem setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
    * 设置 [任务类别]
    */
    public WorkItem setJobType(String jobType) {
        this.jobType = jobType;
        this.modify("job_type", jobType);
        return this;
    }

    /**
    * 设置 [测试计划ID]
    */
    public WorkItem setTestPlanId(String testPlanId) {
        this.testPlanId = testPlanId;
        this.modify("test_plan_id", testPlanId);
        return this;
    }

    /**
    * 设置 [剩余工时]
    */
    public WorkItem setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
    * 设置 [附件]
    */
    public WorkItem setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
    * 设置 [实际工时]
    */
    public WorkItem setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
    * 设置 [交付物]
    */
    public WorkItem setDeliverable(List<Deliverable> deliverable) {
        this.deliverable = deliverable;
        this.modify("deliverable", deliverable);
        return this;
    }

    /**
    * 设置 [项目标识]
    */
    public WorkItem setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
        this.modify("project_identifier", projectIdentifier);
        return this;
    }

    /**
    * 设置 [关注]
    */
    public WorkItem setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
    * 设置 [报表分组属性]
    */
    public WorkItem setRepGroupValue(String repGroupValue) {
        this.repGroupValue = repGroupValue;
        this.modify("rep_group_value", repGroupValue);
        return this;
    }

    /**
    * 设置 [报表百分值]
    */
    public WorkItem setRepPercentValue(BigDecimal repPercentValue) {
        this.repPercentValue = repPercentValue;
        this.modify("rep_percent_value", repPercentValue);
        return this;
    }

    /**
    * 设置 [报表值1]
    */
    public WorkItem setRepValue1(Integer repValue1) {
        this.repValue1 = repValue1;
        this.modify("rep_value_1", repValue1);
        return this;
    }

    /**
    * 设置 [报表值3]
    */
    public WorkItem setRepValue3(Integer repValue3) {
        this.repValue3 = repValue3;
        this.modify("rep_value_3", repValue3);
        return this;
    }

    /**
    * 设置 [报表值2]
    */
    public WorkItem setRepValue2(Integer repValue2) {
        this.repValue2 = repValue2;
        this.modify("rep_value_2", repValue2);
        return this;
    }

    /**
    * 设置 [工作项状态类型]
    */
    public WorkItem setStateType(String stateType) {
        this.stateType = stateType;
        this.modify("state_type", stateType);
        return this;
    }

    /**
    * 设置 [当前版本名称]
    */
    public WorkItem setCurVersionName(String curVersionName) {
        this.curVersionName = curVersionName;
        this.modify("cur_version_name", curVersionName);
        return this;
    }

    /**
    * 设置 [选择版本标识]
    */
    public WorkItem setChooseVersionId(String chooseVersionId) {
        this.chooseVersionId = chooseVersionId;
        this.modify("choose_version_id", chooseVersionId);
        return this;
    }

    /**
    * 设置 [选择版本名称]
    */
    public WorkItem setChooseVersionName(String chooseVersionName) {
        this.chooseVersionName = chooseVersionName;
        this.modify("choose_version_name", chooseVersionName);
        return this;
    }

    /**
    * 设置 [关注人]
    */
    public WorkItem setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
    * 设置 [迭代状态]
    */
    public WorkItem setSprintStatus(String sprintStatus) {
        this.sprintStatus = sprintStatus;
        this.modify("sprint_status", sprintStatus);
        return this;
    }

    /**
    * 设置 [发布阶段]
    */
    public WorkItem setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
        this.modify("release_status", releaseStatus);
        return this;
    }

    /**
    * 设置 [工作项下级类型]
    */
    public WorkItem setWorkItemSubType(String workItemSubType) {
        this.workItemSubType = workItemSubType;
        this.modify("work_item_sub_type", workItemSubType);
        return this;
    }

    /**
    * 设置 [统计日期字段]
    */
    public WorkItem setRepDate(Date repDate) {
        this.repDate = repDate;
        this.modify("rep_date", repDate);
        return this;
    }

    /**
    * 设置 [最近创建日期]
    */
    public WorkItem setRecentCreateDays(Integer recentCreateDays) {
        this.recentCreateDays = recentCreateDays;
        this.modify("recent_create_days", recentCreateDays);
        return this;
    }

    /**
    * 设置 [关联产品需求数]
    */
    public WorkItem setRelationTotalIdea(BigDecimal relationTotalIdea) {
        this.relationTotalIdea = relationTotalIdea;
        this.modify("relation_total_idea", relationTotalIdea);
        return this;
    }

    /**
    * 设置 [关联测试用例数]
    */
    public WorkItem setRelationTotalTestCase(BigDecimal relationTotalTestCase) {
        this.relationTotalTestCase = relationTotalTestCase;
        this.modify("relation_total_test_case", relationTotalTestCase);
        return this;
    }

    /**
    * 设置 [关联工单数]
    */
    public WorkItem setRelationTotalTicket(BigDecimal relationTotalTicket) {
        this.relationTotalTicket = relationTotalTicket;
        this.modify("relation_total_ticket", relationTotalTicket);
        return this;
    }

    /**
    * 设置 [关联工作项数]
    */
    public WorkItem setRelationTotalWorkItem(BigDecimal relationTotalWorkItem) {
        this.relationTotalWorkItem = relationTotalWorkItem;
        this.modify("relation_total_work_item", relationTotalWorkItem);
        return this;
    }

    /**
    * 设置 [原始状态]
    */
    public WorkItem setWorkItemOriginState(String workItemOriginState) {
        this.workItemOriginState = workItemOriginState;
        this.modify("work_item_origin_state", workItemOriginState);
        return this;
    }

    /**
    * 设置 [项目]
    */
    public WorkItem setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
    * 设置 [工作项类型]
    */
    public WorkItem setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
        return this;
    }

    /**
    * 设置 [所属项目]
    */
    public WorkItem setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
    * 设置 [工作项类型]
    */
    public WorkItem setWorkItemTypeName(String workItemTypeName) {
        this.workItemTypeName = workItemTypeName;
        this.modify("work_item_type_name", workItemTypeName);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public WorkItem setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
    * 设置 [父工作项]
    */
    public WorkItem setPtitle(String ptitle) {
        this.ptitle = ptitle;
        this.modify("ptitle", ptitle);
        return this;
    }

    /**
    * 设置 [迭代标识]
    */
    public WorkItem setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
    * 设置 [看板标识]
    */
    public WorkItem setBoardId(String boardId) {
        this.boardId = boardId;
        this.modify("board_id", boardId);
        return this;
    }

    /**
    * 设置 [看板栏标识]
    */
    public WorkItem setEntryId(String entryId) {
        this.entryId = entryId;
        this.modify("entry_id", entryId);
        return this;
    }

    /**
    * 设置 [泳道标识]
    */
    public WorkItem setSwimlaneId(String swimlaneId) {
        this.swimlaneId = swimlaneId;
        this.modify("swimlane_id", swimlaneId);
        return this;
    }

    /**
    * 设置 [看板栏名称]
    */
    public WorkItem setEntryName(String entryName) {
        this.entryName = entryName;
        this.modify("entry_name", entryName);
        return this;
    }

    /**
    * 设置 [看板名称]
    */
    public WorkItem setBoardName(String boardName) {
        this.boardName = boardName;
        this.modify("board_name", boardName);
        return this;
    }

    /**
    * 设置 [顶级工作项标识]
    */
    public WorkItem setTopId(String topId) {
        this.topId = topId;
        this.modify("top_id", topId);
        return this;
    }

    /**
    * 设置 [顶级工作项标题]
    */
    public WorkItem setTopTitle(String topTitle) {
        this.topTitle = topTitle;
        this.modify("top_title", topTitle);
        return this;
    }

    /**
    * 设置 [迭代名称]
    */
    public WorkItem setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
    * 设置 [项目发布标识]
    */
    public WorkItem setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }

    /**
    * 设置 [项目发布名称]
    */
    public WorkItem setReleaseName(String releaseName) {
        this.releaseName = releaseName;
        this.modify("release_name", releaseName);
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