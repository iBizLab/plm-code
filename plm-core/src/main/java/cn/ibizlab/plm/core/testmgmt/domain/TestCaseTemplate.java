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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.TestSuite;
import cn.ibizlab.plm.core.testmgmt.domain.Step;

/**
 * 用例模板实体类[TestCaseTemplate]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "TEST_CASE_TEMPLATE", resultMap = "TestCaseTemplateResultMap")
@ApiModel(value = "TEST_CASE_TEMPLATE", description = "用例模板")
public class TestCaseTemplate extends EntityMP implements Serializable
{

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
    * 重要程度
    */
    @TableField(value = "level")
    @DEField(name = "level" , dict = "test_case_level")
    @JSONField(name = "level")
    @JsonProperty("level")
    @ApiModelProperty(value = "level", notes = "重要程度")
    private String level;

    /**
    * 用例类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "test_case_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "用例类型")
    private String type;

    /**
    * 测试类型
    */
    @TableField(value = "test_type")
    @DEField(name = "test_type" , dict = "test_case_test_type")
    @JSONField(name = "test_type")
    @JsonProperty("test_type")
    @ApiModelProperty(value = "test_type", notes = "测试类型")
    private String testType;

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
    * 前置条件
    */
    @TableField(value = "precondition")
    @DEField(name = "precondition")
    @JSONField(name = "precondition")
    @JsonProperty("precondition")
    @ApiModelProperty(value = "precondition", notes = "前置条件")
    private String precondition;

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
    * 是否已删除
    */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
    * 评审状态
    */
    @TableField(value = "state")
    @DEField(name = "state" , defaultValue = "10" , dict = "test_case_state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "评审状态")
    private String state;

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
    * 步骤
    */
    @TableField(value = "steps", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler =cn.ibizlab.plm.core.testmgmt.domain.handlers.StepTypeHandler.class)
    @DEField(name = "steps")
    @JSONField(name = "steps")
    @JsonProperty("steps")
    @ApiModelProperty(value = "steps", notes = "步骤")
    private List<Step> steps;

    /**
    * 测试计划名称
    */
    @TableField(value = "test_plan_name" , exist = false)
    @DEField(name = "test_plan_name")
    @JSONField(name = "test_plan_name")
    @JsonProperty("test_plan_name")
    @ApiModelProperty(value = "test_plan_name", notes = "测试计划名称")
    private String testPlanName;

    /**
    * 执行时间
    */
    @TableField(value = "executed_at" , exist = false)
    @DEField(name = "executed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("executed_at")
    @ApiModelProperty(value = "executed_at", notes = "执行时间")
    private Date executedAt;

    /**
    * 执行人
    */
    @TableField(value = "executor_name" , exist = false)
    @DEField(name = "executor_name")
    @JSONField(name = "executor_name")
    @JsonProperty("executor_name")
    @ApiModelProperty(value = "executor_name", notes = "执行人")
    private String executorName;

    /**
    * 执行结果
    */
    @TableField(value = "run_status" , exist = false)
    @DEField(name = "run_status" , dict = "run_status")
    @JSONField(name = "run_status")
    @JsonProperty("run_status")
    @ApiModelProperty(value = "run_status", notes = "执行结果")
    private String runStatus;

    /**
    * 目标测试库
    */
    @TableField(value = "target_library_id" , exist = false)
    @DEField(name = "target_library_id")
    @JSONField(name = "target_library_id")
    @JsonProperty("target_library_id")
    @ApiModelProperty(value = "target_library_id", notes = "目标测试库")
    private String targetLibraryId;

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
    * 剩余工时
    */
    @TableField(exist = false)
    @DEField(name = "remaining_workload")
    @JSONField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

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
    * 测试库标识
    */
    @TableField(value = "test_library_id")
    @DEField(name = "test_library_id")
    @JSONField(name = "test_library_id")
    @JsonProperty("test_library_id")
    @ApiModelProperty(value = "test_library_id", notes = "测试库标识")
    private String testLibraryId;

    /**
    * 测试库名称
    */
    @TableField(value = "test_library_name" , exist = false)
    @DEField(name = "test_library_name")
    @JSONField(name = "test_library_name")
    @JsonProperty("test_library_name")
    @ApiModelProperty(value = "test_library_name", notes = "测试库名称")
    private String testLibraryName;

    /**
    * 用例模块标识
    */
    @TableField(value = "suite_id")
    @DEField(name = "suite_id")
    @JSONField(name = "suite_id")
    @JsonProperty("suite_id")
    @ApiModelProperty(value = "suite_id", notes = "用例模块标识")
    private String suiteId;

    /**
    * 模块名称
    */
    @TableField(value = "suite_name" , exist = false)
    @DEField(name = "suite_name")
    @JSONField(name = "suite_name")
    @JsonProperty("suite_name")
    @ApiModelProperty(value = "suite_name", notes = "模块名称")
    private String suiteName;

    /**
    * DER1N_TEST_CASE_TEMPLATE_LIBRARY_TEST_LIBRARY_ID
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "library", notes = "DER1N_TEST_CASE_TEMPLATE_LIBRARY_TEST_LIBRARY_ID")
    private Library library;

    /**
    * DER1N_TEST_CASE_TEMPLATE_TEST_SUITE_SUITE_ID
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "test_suite", notes = "DER1N_TEST_CASE_TEMPLATE_TEST_SUITE_SUITE_ID")
    private TestSuite testSuite;

    /**
    * 设置 [标题]
    */
    public TestCaseTemplate setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [重要程度]
    */
    public TestCaseTemplate setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
    * 设置 [用例类型]
    */
    public TestCaseTemplate setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [测试类型]
    */
    public TestCaseTemplate setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public TestCaseTemplate setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [前置条件]
    */
    public TestCaseTemplate setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public TestCaseTemplate setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public TestCaseTemplate setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [评审状态]
    */
    public TestCaseTemplate setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [模块路径]
    */
    public TestCaseTemplate setSuites(String suites) {
        this.suites = suites;
        this.modify("suites", suites);
        return this;
    }

    /**
    * 设置 [步骤]
    */
    public TestCaseTemplate setSteps(List<Step> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
    * 设置 [测试计划名称]
    */
    public TestCaseTemplate setTestPlanName(String testPlanName) {
        this.testPlanName = testPlanName;
        this.modify("test_plan_name", testPlanName);
        return this;
    }

    /**
    * 设置 [执行时间]
    */
    public TestCaseTemplate setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
    * 设置 [执行人]
    */
    public TestCaseTemplate setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
    * 设置 [执行结果]
    */
    public TestCaseTemplate setRunStatus(String runStatus) {
        this.runStatus = runStatus;
        this.modify("run_status", runStatus);
        return this;
    }

    /**
    * 设置 [目标测试库]
    */
    public TestCaseTemplate setTargetLibraryId(String targetLibraryId) {
        this.targetLibraryId = targetLibraryId;
        this.modify("target_library_id", targetLibraryId);
        return this;
    }

    /**
    * 设置 [工时进度]
    */
    public TestCaseTemplate setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
    * 设置 [预估工时]
    */
    public TestCaseTemplate setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
    * 设置 [剩余工时]
    */
    public TestCaseTemplate setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
    * 设置 [实际工时]
    */
    public TestCaseTemplate setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public TestCaseTemplate setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [测试库标识]
    */
    public TestCaseTemplate setTestLibraryId(String testLibraryId) {
        this.testLibraryId = testLibraryId;
        this.modify("test_library_id", testLibraryId);
        return this;
    }

    /**
    * 设置 [测试库名称]
    */
    public TestCaseTemplate setTestLibraryName(String testLibraryName) {
        this.testLibraryName = testLibraryName;
        this.modify("test_library_name", testLibraryName);
        return this;
    }

    /**
    * 设置 [用例模块标识]
    */
    public TestCaseTemplate setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
    * 设置 [模块名称]
    */
    public TestCaseTemplate setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        this.modify("suite_name", suiteName);
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