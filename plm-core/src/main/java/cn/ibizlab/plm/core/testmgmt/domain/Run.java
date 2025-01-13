/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

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
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.testmgmt.domain.RunAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;

/**
 * 执行用例实体类[Run]
 *
 * @author generator
 */
@Audit
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "RUN", resultMap = "RunResultMap")
@ApiModel(value = "RUN", description = "执行用例")
public class Run extends EntityMP implements Serializable
{

    /**
    * 编号
    */
    @TableField(value = "identifier" , exist = false)
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
    * 标题
    */
    @TableField(value = "title" , exist = false)
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
    * 评审状态
    */
    @TableField(value = "state" , exist = false)
    @DEField(name = "state" , dict = "case_state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "评审状态")
    private String state;

    /**
    * 父对象版本标识
    */
    @TableField(value = "parent_version_id")
    @DEField(name = "parent_version_id" , preType = DEPredefinedFieldType.PARENTVERSIONID)
    @JSONField(name = "parent_version_id")
    @JsonProperty("parent_version_id")
    @ApiModelProperty(value = "parent_version_id", notes = "父对象版本标识")
    private String parentVersionId;

    /**
    * 重要程度
    */
    @TableField(value = "level" , exist = false)
    @DEField(name = "level" , dict = "test_case_level")
    @JSONField(name = "level")
    @JsonProperty("level")
    @ApiModelProperty(value = "level", notes = "重要程度")
    private String level;

    /**
    * 用例类型
    */
    @TableField(value = "type" , exist = false)
    @DEField(name = "type" , dict = "test_case_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "用例类型")
    private String type;

    /**
    * 执行时间
    */
    @TableField(value = "executed_at")
    @DEField(name = "executed_at" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("executed_at")
    @ApiModelProperty(value = "executed_at", notes = "执行时间")
    private Date executedAt;

    /**
    * 执行结果
    */
    @TableField(value = "status")
    @DEField(name = "status" , dict = "run_status")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty(value = "status", notes = "执行结果")
    private String status;

    /**
    * 备注
    */
    @TableField(value = "remark")
    @DEField(name = "remark")
    @JSONField(name = "remark")
    @JsonProperty("remark")
    @ApiModelProperty(value = "remark", notes = "备注")
    private String remark;

    /**
    * 步骤
    */
    @TableField(value = "steps", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler =cn.ibizlab.plm.core.testmgmt.domain.handlers.StepTypeHandler.class)
    @DEField(name = "steps")
    @JSONField(name = "steps")
    @JsonProperty("steps")
    @ApiModelProperty(value = "steps", notes = "步骤")
    private List<Step> steps;

    /**
    * 测试计划
    */
    @TableField(value = "plan_name" , exist = false)
    @DEField(name = "plan_name")
    @JSONField(name = "plan_name")
    @JsonProperty("plan_name")
    @ApiModelProperty(value = "plan_name", notes = "测试计划")
    private String planName;

    /**
    * 测试类型
    */
    @TableField(value = "test_type" , exist = false)
    @DEField(name = "test_type" , dict = "test_case_test_type")
    @JSONField(name = "test_type")
    @JsonProperty("test_type")
    @ApiModelProperty(value = "test_type", notes = "测试类型")
    private String testType;

    /**
    * 维护人
    */
    @TableField(value = "maintenance_name" , exist = false)
    @DEField(name = "maintenance_name")
    @JSONField(name = "maintenance_name")
    @JsonProperty("maintenance_name")
    @ApiModelProperty(value = "maintenance_name", notes = "维护人")
    private String maintenanceName;

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
    * 执行人标识
    */
    @TableField(value = "executor_id")
    @DEField(name = "executor_id")
    @JSONField(name = "executor_id")
    @JsonProperty("executor_id")
    @ApiModelProperty(value = "executor_id", notes = "执行人标识")
    private String executorId;

    /**
    * 执行人
    */
    @TableField(value = "executor_name")
    @DEField(name = "executor_name")
    @JSONField(name = "executor_name")
    @JsonProperty("executor_name")
    @ApiModelProperty(value = "executor_name", notes = "执行人")
    private String executorName;

    /**
    * 用例模块标识
    */
    @TableField(value = "suite_id" , exist = false)
    @DEField(name = "suite_id")
    @JSONField(name = "suite_id")
    @JsonProperty("suite_id")
    @ApiModelProperty(value = "suite_id", notes = "用例模块标识")
    private String suiteId;

    /**
    * 所属模块
    */
    @TableField(value = "suite_name" , exist = false)
    @DEField(name = "suite_name")
    @JSONField(name = "suite_name")
    @JsonProperty("suite_name")
    @ApiModelProperty(value = "suite_name", notes = "所属模块")
    private String suiteName;

    /**
    * 前置条件
    */
    @TableField(value = "precondition" , exist = false)
    @DEField(name = "precondition")
    @JSONField(name = "precondition")
    @JsonProperty("precondition")
    @ApiModelProperty(value = "precondition", notes = "前置条件")
    private String precondition;

    /**
    * 模块路径
    */
    @TableField(value = "suites" , exist = false)
    @DEField(name = "suites")
    @JSONField(name = "suites")
    @JsonProperty("suites")
    @ApiModelProperty(value = "suites", notes = "模块路径")
    private String suites;

    /**
    * 关联缺陷数
    */
    @TableField(value = "relation_total_bug" , exist = false)
    @DEField(name = "relation_total_bug")
    @JSONField(name = "relation_total_bug")
    @JsonProperty("relation_total_bug")
    @ApiModelProperty(value = "relation_total_bug", notes = "关联缺陷数")
    private BigDecimal relationTotalBug;

    /**
    * 所属测试库
    */
    @TableField(value = "library_name" , exist = false)
    @DEField(name = "library_name")
    @JSONField(name = "library_name")
    @JsonProperty("library_name")
    @ApiModelProperty(value = "library_name", notes = "所属测试库")
    private String libraryName;

    /**
    * 测试库标识
    */
    @TableField(value = "library_id" , exist = false)
    @DEField(name = "library_id" , dict = "all_library")
    @JSONField(name = "library_id")
    @JsonProperty("library_id")
    @ApiModelProperty(value = "library_id", notes = "测试库标识")
    private String libraryId;

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
    * 关注
    */
    @TableField(exist = false)
    @DEField(name = "attentions" , dict = "SysOperator")
    @JSONField(name = "attentions")
    @JsonProperty("attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
    * 预估工时
    */
    @TableField(value = "estimated_workload" , exist = false)
    @DEField(name = "estimated_workload")
    @JSONField(name = "estimated_workload")
    @JsonProperty("estimated_workload")
    @ApiModelProperty(value = "estimated_workload", notes = "预估工时")
    private BigDecimal estimatedWorkload;

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
    * 剩余工时
    */
    @TableField(value = "remaining_workload" , exist = false)
    @DEField(name = "remaining_workload")
    @JSONField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

    /**
    * 实际工时
    */
    @TableField(value = "actual_workload" , exist = false)
    @DEField(name = "actual_workload")
    @JSONField(name = "actual_workload")
    @JsonProperty("actual_workload")
    @ApiModelProperty(value = "actual_workload", notes = "实际工时")
    private BigDecimal actualWorkload;

    /**
    * 结果附件
    */
    @TableField(exist = false)
    @DEField(name = "run_attachment")
    @JSONField(name = "run_attachment")
    @JsonProperty("run_attachment")
    @ApiModelProperty(value = "run_attachment", notes = "结果附件")
    private List<RunAttachment> runAttachment;

    /**
    * 关联执行结果数
    */
    @TableField(value = "relation_total_history" , exist = false)
    @DEField(name = "relation_total_history")
    @JSONField(name = "relation_total_history")
    @JsonProperty("relation_total_history")
    @ApiModelProperty(value = "relation_total_history", notes = "关联执行结果数")
    private BigDecimal relationTotalHistory;

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
    * 是否最新
    */
    @TableField(value = "is_newest")
    @DEField(name = "is_newest" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_newest")
    @JsonProperty("is_newest")
    @ApiModelProperty(value = "is_newest", notes = "是否最新")
    private Integer isNewest;

    /**
    * 测试库编号
    */
    @TableField(value = "library_identifier" , exist = false)
    @DEField(name = "library_identifier")
    @JSONField(name = "library_identifier")
    @JsonProperty("library_identifier")
    @ApiModelProperty(value = "library_identifier", notes = "测试库编号")
    private String libraryIdentifier;

    /**
    * bi测试计划名称
    */
    @TableField(value = "bi_plan_name" , exist = false)
    @DEField(name = "bi_plan_name")
    @JSONField(name = "bi_plan_name")
    @JsonProperty("bi_plan_name")
    @ApiModelProperty(value = "bi_plan_name", notes = "bi测试计划名称")
    private String biPlanName;

    /**
    * 关注数
    */
    @TableField(value = "attention_count" , exist = false)
    @DEField(name = "attention_count")
    @JSONField(name = "attention_count")
    @JsonProperty("attention_count")
    @ApiModelProperty(value = "attention_count", notes = "关注数")
    private String attentionCount;

    /**
    * 评论数
    */
    @TableField(value = "comment_count" , exist = false)
    @DEField(name = "comment_count")
    @JSONField(name = "comment_count")
    @JsonProperty("comment_count")
    @ApiModelProperty(value = "comment_count", notes = "评论数")
    private String commentCount;

    /**
    * 测试库是否删除
    */
    @TableField(value = "library_is_deleted" , exist = false)
    @DEField(name = "library_is_deleted" , dict = "YesNo")
    @JSONField(name = "library_is_deleted")
    @JsonProperty("library_is_deleted")
    @ApiModelProperty(value = "library_is_deleted", notes = "测试库是否删除")
    private Integer libraryIsDeleted;

    /**
    * 测试库是否归档
    */
    @TableField(value = "library_is_archived" , exist = false)
    @DEField(name = "library_is_archived" , dict = "YesNo")
    @JSONField(name = "library_is_archived")
    @JsonProperty("library_is_archived")
    @ApiModelProperty(value = "library_is_archived", notes = "测试库是否归档")
    private Integer libraryIsArchived;

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
    * 最近创建日期
    */
    @TableField(value = "recent_create_days" , exist = false)
    @DEField(name = "recent_create_days")
    @JSONField(name = "recent_create_days")
    @JsonProperty("recent_create_days")
    @ApiModelProperty(value = "recent_create_days", notes = "最近创建日期")
    private Integer recentCreateDays;

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
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 测试计划标识
    */
    @TableField(value = "plan_id")
    @DEField(name = "plan_id")
    @JSONField(name = "plan_id")
    @JsonProperty("plan_id")
    @ApiModelProperty(value = "plan_id", notes = "测试计划标识")
    private String planId;

    /**
    * 测试用例标识
    */
    @TableField(value = "case_id")
    @DEField(name = "case_id")
    @JSONField(name = "case_id")
    @JsonProperty("case_id")
    @ApiModelProperty(value = "case_id", notes = "测试用例标识")
    private String caseId;

    /**
    * 名称
    */
    @TableField(value = "case_name" , exist = false)
    @DEField(name = "case_name")
    @JSONField(name = "case_name")
    @JsonProperty("case_name")
    @ApiModelProperty(value = "case_name", notes = "名称")
    private String caseName;

    /**
    * 测试用例
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "test_case", notes = "测试用例")
    private TestCase testCase;

    /**
    * 计划-执行用例
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "test_plan", notes = "计划-执行用例")
    private TestPlan testPlan;

    /**
    * 设置 [编号]
    */
    public Run setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public Run setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [评审状态]
    */
    public Run setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [重要程度]
    */
    public Run setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
    * 设置 [用例类型]
    */
    public Run setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [执行时间]
    */
    public Run setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
    * 设置 [执行结果]
    */
    public Run setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public Run setRemark(String remark) {
        this.remark = remark;
        this.modify("remark", remark);
        return this;
    }

    /**
    * 设置 [步骤]
    */
    public Run setSteps(List<Step> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
    * 设置 [测试计划]
    */
    public Run setPlanName(String planName) {
        this.planName = planName;
        this.modify("plan_name", planName);
        return this;
    }

    /**
    * 设置 [测试类型]
    */
    public Run setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
    * 设置 [维护人]
    */
    public Run setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
    * 设置 [执行人标识]
    */
    public Run setExecutorId(String executorId) {
        this.executorId = executorId;
        this.modify("executor_id", executorId);
        return this;
    }

    /**
    * 设置 [执行人]
    */
    public Run setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
    * 设置 [用例模块标识]
    */
    public Run setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
    * 设置 [所属模块]
    */
    public Run setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        this.modify("suite_name", suiteName);
        return this;
    }

    /**
    * 设置 [前置条件]
    */
    public Run setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
    * 设置 [模块路径]
    */
    public Run setSuites(String suites) {
        this.suites = suites;
        this.modify("suites", suites);
        return this;
    }

    /**
    * 设置 [关联缺陷数]
    */
    public Run setRelationTotalBug(BigDecimal relationTotalBug) {
        this.relationTotalBug = relationTotalBug;
        this.modify("relation_total_bug", relationTotalBug);
        return this;
    }

    /**
    * 设置 [所属测试库]
    */
    public Run setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
    * 设置 [测试库标识]
    */
    public Run setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public Run setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [关注]
    */
    public Run setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
    * 设置 [预估工时]
    */
    public Run setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
    * 设置 [工时进度]
    */
    public Run setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
    * 设置 [剩余工时]
    */
    public Run setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
    * 设置 [实际工时]
    */
    public Run setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
    * 设置 [结果附件]
    */
    public Run setRunAttachment(List<RunAttachment> runAttachment) {
        this.runAttachment = runAttachment;
        this.modify("run_attachment", runAttachment);
        return this;
    }

    /**
    * 设置 [关联执行结果数]
    */
    public Run setRelationTotalHistory(BigDecimal relationTotalHistory) {
        this.relationTotalHistory = relationTotalHistory;
        this.modify("relation_total_history", relationTotalHistory);
        return this;
    }

    /**
    * 设置 [优先级]
    */
    public Run setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
    * 设置 [是否最新]
    */
    public Run setIsNewest(Integer isNewest) {
        this.isNewest = isNewest;
        this.modify("is_newest", isNewest);
        return this;
    }

    /**
    * 设置 [测试库编号]
    */
    public Run setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
    * 设置 [bi测试计划名称]
    */
    public Run setBiPlanName(String biPlanName) {
        this.biPlanName = biPlanName;
        this.modify("bi_plan_name", biPlanName);
        return this;
    }

    /**
    * 设置 [关注数]
    */
    public Run setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
        this.modify("attention_count", attentionCount);
        return this;
    }

    /**
    * 设置 [评论数]
    */
    public Run setCommentCount(String commentCount) {
        this.commentCount = commentCount;
        this.modify("comment_count", commentCount);
        return this;
    }

    /**
    * 设置 [测试库是否删除]
    */
    public Run setLibraryIsDeleted(Integer libraryIsDeleted) {
        this.libraryIsDeleted = libraryIsDeleted;
        this.modify("library_is_deleted", libraryIsDeleted);
        return this;
    }

    /**
    * 设置 [测试库是否归档]
    */
    public Run setLibraryIsArchived(Integer libraryIsArchived) {
        this.libraryIsArchived = libraryIsArchived;
        this.modify("library_is_archived", libraryIsArchived);
        return this;
    }

    /**
    * 设置 [关注人]
    */
    public Run setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
    * 设置 [最近创建日期]
    */
    public Run setRecentCreateDays(Integer recentCreateDays) {
        this.recentCreateDays = recentCreateDays;
        this.modify("recent_create_days", recentCreateDays);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Run setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [测试计划标识]
    */
    public Run setPlanId(String planId) {
        this.planId = planId;
        this.modify("plan_id", planId);
        return this;
    }

    /**
    * 设置 [测试用例标识]
    */
    public Run setCaseId(String caseId) {
        this.caseId = caseId;
        this.modify("case_id", caseId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Run setCaseName(String caseName) {
        this.caseName = caseName;
        this.modify("case_name", caseName);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getPlanId(),"未设置测试计划标识");
        //Assert.notNull(getCaseId(),"未设置测试用例标识");
        String key = String.format("%s||%s"
            ,getPlanId(),getCaseId());
        key = DigestUtils.md5DigestAsHex(key.getBytes());
        return key;
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