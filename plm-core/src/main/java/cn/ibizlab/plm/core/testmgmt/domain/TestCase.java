/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.testmgmt.domain.CaseHistory;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.testmgmt.domain.Step;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.Attention;

/**
 * 用例实体类[TestCase]
 *
 * @author generator
 */
@Audit
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "TEST_CASE", resultMap = "TestCaseResultMap")
@ApiModel(value = "TEST_CASE", description = "用例")
public class TestCase extends EntityMP implements Serializable
{

    /**
     * 编号
     */
    @TableField(value = "identifier")
    @DEField(name = "identifier" , dupCheck = DupCheck.ALL , dupCheckField = "testLibraryId")
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 标题
     */
    @TableField(value = "title")
    @DEField(name = "title")
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
     * 重要程度
     */
    @TableField(value = "level")
    @DEField(name = "level" , dict = "Test_case_level")
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "level", notes = "重要程度")
    private String level;

    /**
     * 用例类型
     */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "Test_case_type")
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "type", notes = "用例类型")
    private String type;

    /**
     * 测试类型
     */
    @TableField(value = "test_type")
    @DEField(name = "test_type" , dict = "Test_case_test_type")
    @JsonProperty("test_type")
    @JSONField(name = "test_type")
    @ApiModelProperty(value = "test_type", notes = "测试类型")
    private String testType;

    /**
     * 描述
     */
    @TableField(value = "description")
    @DEField(name = "description")
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 前置条件
     */
    @TableField(value = "precondition")
    @DEField(name = "precondition")
    @JsonProperty("precondition")
    @JSONField(name = "precondition")
    @ApiModelProperty(value = "precondition", notes = "前置条件")
    private String precondition;

    /**
     * 是否已归档
     */
    @TableField(value = "is_archived")
    @DEField(name = "is_archived" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
     * 评审状态
     */
    @TableField(value = "state")
    @DEField(name = "state" , defaultValue = "10" , dict = "Test_case_state")
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "state", notes = "评审状态")
    private String state;

    /**
     * 步骤
     */
    @TableField(value = "steps", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler = cn.ibizlab.plm.core.testmgmt.domain.handlers.StepTypeHandler.class)
    @DEField(name = "steps")
    @JsonProperty("steps")
    @JSONField(name = "steps")
    @ApiModelProperty(value = "steps", notes = "步骤")
    private List<Step> steps;

    /**
     * 维护人
     */
    @TableField(value = "maintenance_id")
    @DEField(name = "maintenance_id")
    @JsonProperty("maintenance_id")
    @JSONField(name = "maintenance_id")
    @ApiModelProperty(value = "maintenance_id", notes = "维护人")
    private String maintenanceId;

    /**
     * 维护人
     */
    @TableField(value = "maintenance_name")
    @DEField(name = "maintenance_name")
    @JsonProperty("maintenance_name")
    @JSONField(name = "maintenance_name")
    @ApiModelProperty(value = "maintenance_name", notes = "维护人")
    private String maintenanceName;

    /**
     * 测试计划名称
     */
    @TableField(value = "test_plan_name" , exist = false)
    @DEField(name = "test_plan_name")
    @JsonProperty("test_plan_name")
    @JSONField(name = "test_plan_name")
    @ApiModelProperty(value = "test_plan_name", notes = "测试计划名称")
    private String testPlanName;

    /**
     * 执行时间
     */
    @TableField(value = "executed_at" , exist = false)
    @DEField(name = "executed_at")
    @JsonProperty("executed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "executed_at", notes = "执行时间")
    private Date executedAt;

    /**
     * 执行人
     */
    @TableField(value = "executor_name" , exist = false)
    @DEField(name = "executor_name")
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "executor_name", notes = "执行人")
    private String executorName;

    /**
     * 执行结果
     */
    @TableField(value = "run_status" , exist = false)
    @DEField(name = "run_status" , dict = "Run_status")
    @JsonProperty("run_status")
    @JSONField(name = "run_status")
    @ApiModelProperty(value = "run_status", notes = "执行结果")
    private String runStatus;

    /**
     * 附件
     */
    @TableField(exist = false)
    @DEField(name = "attachments")
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "attachments", notes = "附件")
    private List<Attachment> attachments;

    /**
     * 模块路径
     */
    @TableField(value = "suites" , exist = false)
    @DEField(name = "suites")
    @JsonProperty("suites")
    @JSONField(name = "suites")
    @ApiModelProperty(value = "suites", notes = "模块路径")
    private String suites;

    /**
     * 目标测试库
     */
    @TableField(value = "target_library_id" , exist = false)
    @DEField(name = "target_library_id")
    @JsonProperty("target_library_id")
    @JSONField(name = "target_library_id")
    @ApiModelProperty(value = "target_library_id", notes = "目标测试库")
    private String targetLibraryId;

    /**
     * 编号
     */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
     * 测试库标识
     */
    @TableField(value = "library_identifier" , exist = false)
    @DEField(name = "library_identifier")
    @JsonProperty("library_identifier")
    @JSONField(name = "library_identifier")
    @ApiModelProperty(value = "library_identifier", notes = "测试库标识")
    private String libraryIdentifier;

    /**
     * 关注
     */
    @TableField(exist = false)
    @DEField(name = "attentions")
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
     * 工时进度
     */
    @TableField(value = "workload_schedule" , exist = false)
    @DEField(name = "workload_schedule")
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "workload_schedule", notes = "工时进度")
    private BigDecimal workloadSchedule;

    /**
     * 预估工时
     */
    @TableField(value = "estimated_workload")
    @DEField(name = "estimated_workload")
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "estimated_workload", notes = "预估工时")
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @TableField(value = "remaining_workload")
    @DEField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

    /**
     * 实际工时
     */
    @TableField(value = "actual_workload")
    @DEField(name = "actual_workload")
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "actual_workload", notes = "实际工时")
    private BigDecimal actualWorkload;

    /**
     * 标识
     */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 建立时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 测试库
     */
    @TableField(value = "test_library_id")
    @DEField(name = "test_library_id")
    @JsonProperty("test_library_id")
    @JSONField(name = "test_library_id")
    @ApiModelProperty(value = "test_library_id", notes = "测试库")
    private String testLibraryId;

    /**
     * 用例模块标识
     */
    @TableField(value = "suite_id")
    @DEField(name = "suite_id")
    @JsonProperty("suite_id")
    @JSONField(name = "suite_id")
    @ApiModelProperty(value = "suite_id", notes = "用例模块标识")
    private String suiteId;

    /**
     * 所属模块
     */
    @TableField(value = "suite_name" , exist = false)
    @DEField(name = "suite_name")
    @JsonProperty("suite_name")
    @JSONField(name = "suite_name")
    @ApiModelProperty(value = "suite_name", notes = "所属模块")
    private String suiteName;

    /**
     * 所属测试库
     */
    @TableField(value = "test_library_name" , exist = false)
    @DEField(name = "test_library_name")
    @JsonProperty("test_library_name")
    @JSONField(name = "test_library_name")
    @ApiModelProperty(value = "test_library_name", notes = "所属测试库")
    private String testLibraryName;

    /**
     * 测试库
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "library", notes = "测试库-用例")
    private Library library;

    /**
     * 用例模块
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "test_suite", notes = "用例模块-用例")
    private TestSuite testSuite;

    /**
     * 企业用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "user", notes = "DER1N_TEST_CASE_USER_ASSIGNEE_ID")
    private User user;

    /**
     * 设置 [编号]
     */
    public TestCase setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public TestCase setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [重要程度]
     */
    public TestCase setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [用例类型]
     */
    public TestCase setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [测试类型]
     */
    public TestCase setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public TestCase setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [前置条件]
     */
    public TestCase setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public TestCase setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public TestCase setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [评审状态]
     */
    public TestCase setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [步骤]
     */
    public TestCase setSteps(List<Step> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public TestCase setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
        this.modify("maintenance_id", maintenanceId);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public TestCase setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
     * 设置 [测试计划名称]
     */
    public TestCase setTestPlanName(String testPlanName) {
        this.testPlanName = testPlanName;
        this.modify("test_plan_name", testPlanName);
        return this;
    }

    /**
     * 设置 [执行时间]
     */
    public TestCase setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public TestCase setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public TestCase setRunStatus(String runStatus) {
        this.runStatus = runStatus;
        this.modify("run_status", runStatus);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public TestCase setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [模块路径]
     */
    public TestCase setSuites(String suites) {
        this.suites = suites;
        this.modify("suites", suites);
        return this;
    }

    /**
     * 设置 [目标测试库]
     */
    public TestCase setTargetLibraryId(String targetLibraryId) {
        this.targetLibraryId = targetLibraryId;
        this.modify("target_library_id", targetLibraryId);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public TestCase setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public TestCase setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public TestCase setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public TestCase setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public TestCase setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public TestCase setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public TestCase setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public TestCase setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [测试库]
     */
    public TestCase setTestLibraryId(String testLibraryId) {
        this.testLibraryId = testLibraryId;
        this.modify("test_library_id", testLibraryId);
        return this;
    }

    /**
     * 设置 [用例模块标识]
     */
    public TestCase setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
     * 设置 [所属模块]
     */
    public TestCase setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        this.modify("suite_name", suiteName);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public TestCase setTestLibraryName(String testLibraryName) {
        this.testLibraryName = testLibraryName;
        this.modify("test_library_name", testLibraryName);
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