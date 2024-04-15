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
 * 用例模板[TestCaseTemplateDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例模板DTO")
public class TestCaseTemplateDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 0)
    private String title;

    /**
     * 重要程度
     */
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "重要程度", position = 1)
    private String level;

    /**
     * 用例类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "用例类型", position = 2)
    private String type;

    /**
     * 测试类型
     */
    @JsonProperty("test_type")
    @JSONField(name = "test_type")
    @ApiModelProperty(value = "测试类型", position = 3)
    private String testType;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 4)
    private String description;

    /**
     * 前置条件
     */
    @JsonProperty("precondition")
    @JSONField(name = "precondition")
    @ApiModelProperty(value = "前置条件", position = 5)
    private String precondition;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 6)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 7)
    private Integer isDeleted;

    /**
     * 评审状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "评审状态", position = 8)
    private String state;

    /**
     * 模块路径
     */
    @JsonProperty("suites")
    @JSONField(name = "suites")
    @ApiModelProperty(value = "模块路径", position = 9)
    private String suites;

    /**
     * 步骤
     */
    @JsonProperty("steps")
    @JSONField(name = "steps")
    @ApiModelProperty(value = "步骤", position = 10)
    private List<StepDTO> steps;

    /**
     * 测试计划名称
     */
    @JsonProperty("test_plan_name")
    @JSONField(name = "test_plan_name")
    @ApiModelProperty(value = "测试计划名称", position = 11)
    private String testPlanName;

    /**
     * 执行时间
     */
    @JsonProperty("executed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间", position = 12)
    private Date executedAt;

    /**
     * 执行人
     */
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "执行人", position = 13)
    private String executorName;

    /**
     * 执行结果
     */
    @JsonProperty("run_status")
    @JSONField(name = "run_status")
    @ApiModelProperty(value = "执行结果", position = 14)
    private String runStatus;

    /**
     * 目标测试库
     */
    @JsonProperty("target_library_id")
    @JSONField(name = "target_library_id")
    @ApiModelProperty(value = "目标测试库", position = 15)
    private String targetLibraryId;

    /**
     * 工时进度
     */
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "工时进度", position = 16)
    private BigDecimal workloadSchedule;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 17)
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 18)
    private BigDecimal remainingWorkload;

    /**
     * 实际工时
     */
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "实际工时", position = 19)
    private BigDecimal actualWorkload;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 20)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 21)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 22)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 23)
    private String name;

    /**
     * 用例模块标识
     */
    @JsonProperty("suite_id")
    @JSONField(name = "suite_id")
    @ApiModelProperty(value = "用例模块标识", position = 24)
    private String suiteId;

    /**
     * 模块名称
     */
    @JsonProperty("suite_name")
    @JSONField(name = "suite_name")
    @ApiModelProperty(value = "模块名称", position = 25)
    private String suiteName;

    /**
     * 测试库标识
     */
    @JsonProperty("test_library_id")
    @JSONField(name = "test_library_id")
    @ApiModelProperty(value = "测试库标识", position = 26)
    private String testLibraryId;

    /**
     * 测试库名称
     */
    @JsonProperty("test_library_name")
    @JSONField(name = "test_library_name")
    @ApiModelProperty(value = "测试库名称", position = 27)
    private String testLibraryName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 28)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 29)
    private Date updateTime;


    /**
     * 设置 [标题]
     */
    public TestCaseTemplateDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [重要程度]
     */
    public TestCaseTemplateDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [用例类型]
     */
    public TestCaseTemplateDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [测试类型]
     */
    public TestCaseTemplateDTO setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public TestCaseTemplateDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [前置条件]
     */
    public TestCaseTemplateDTO setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public TestCaseTemplateDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public TestCaseTemplateDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [评审状态]
     */
    public TestCaseTemplateDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [模块路径]
     */
    public TestCaseTemplateDTO setSuites(String suites) {
        this.suites = suites;
        this.modify("suites", suites);
        return this;
    }

    /**
     * 设置 [步骤]
     */
    public TestCaseTemplateDTO setSteps(List<StepDTO> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
     * 设置 [测试计划名称]
     */
    public TestCaseTemplateDTO setTestPlanName(String testPlanName) {
        this.testPlanName = testPlanName;
        this.modify("test_plan_name", testPlanName);
        return this;
    }

    /**
     * 设置 [执行时间]
     */
    public TestCaseTemplateDTO setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public TestCaseTemplateDTO setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public TestCaseTemplateDTO setRunStatus(String runStatus) {
        this.runStatus = runStatus;
        this.modify("run_status", runStatus);
        return this;
    }

    /**
     * 设置 [目标测试库]
     */
    public TestCaseTemplateDTO setTargetLibraryId(String targetLibraryId) {
        this.targetLibraryId = targetLibraryId;
        this.modify("target_library_id", targetLibraryId);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public TestCaseTemplateDTO setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public TestCaseTemplateDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public TestCaseTemplateDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public TestCaseTemplateDTO setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public TestCaseTemplateDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [用例模块标识]
     */
    public TestCaseTemplateDTO setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
     * 设置 [模块名称]
     */
    public TestCaseTemplateDTO setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        this.modify("suite_name", suiteName);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public TestCaseTemplateDTO setTestLibraryId(String testLibraryId) {
        this.testLibraryId = testLibraryId;
        this.modify("test_library_id", testLibraryId);
        return this;
    }

    /**
     * 设置 [测试库名称]
     */
    public TestCaseTemplateDTO setTestLibraryName(String testLibraryName) {
        this.testLibraryName = testLibraryName;
        this.modify("test_library_name", testLibraryName);
        return this;
    }


}
