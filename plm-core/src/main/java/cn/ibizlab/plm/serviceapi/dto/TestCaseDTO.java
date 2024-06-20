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
 * 用例[TestCaseDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例DTO")
public class TestCaseDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 0)
    private String identifier;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 1)
    private String title;

    /**
     * 重要程度
     */
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "重要程度", position = 2)
    private String level;

    /**
     * 用例类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "用例类型", position = 3)
    private String type;

    /**
     * 测试类型
     */
    @JsonProperty("test_type")
    @JSONField(name = "test_type")
    @ApiModelProperty(value = "测试类型", position = 4)
    private String testType;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 5)
    private String description;

    /**
     * 前置条件
     */
    @JsonProperty("precondition")
    @JSONField(name = "precondition")
    @ApiModelProperty(value = "前置条件", position = 6)
    private String precondition;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 7)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 8)
    private Integer isDeleted;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 9)
    private String state;

    /**
     * 步骤
     */
    @JsonProperty("steps")
    @JSONField(name = "steps")
    @ApiModelProperty(value = "步骤", position = 10)
    private List<StepDTO> steps;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 11)
    private String curVersionId;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_id")
    @JSONField(name = "maintenance_id")
    @ApiModelProperty(value = "维护人", position = 12)
    private String maintenanceId;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_name")
    @JSONField(name = "maintenance_name")
    @ApiModelProperty(value = "维护人", position = 13)
    private String maintenanceName;

    /**
     * 测试计划名称
     */
    @JsonProperty("test_plan_name")
    @JSONField(name = "test_plan_name")
    @ApiModelProperty(value = "测试计划名称", position = 14)
    private String testPlanName;

    /**
     * 执行时间
     */
    @JsonProperty("executed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间", position = 15)
    private Date executedAt;

    /**
     * 执行人
     */
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "执行人", position = 16)
    private String executorName;

    /**
     * 执行结果
     */
    @JsonProperty("run_status")
    @JSONField(name = "run_status")
    @ApiModelProperty(value = "执行结果", position = 17)
    private String runStatus;

    /**
     * 附件
     */
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "附件", position = 18)
    private List<AttachmentDTO> attachments;

    /**
     * 模块路径
     */
    @JsonProperty("suites")
    @JSONField(name = "suites")
    @ApiModelProperty(value = "模块路径", position = 19)
    private String suites;

    /**
     * 目标测试库
     */
    @JsonProperty("target_library_id")
    @JSONField(name = "target_library_id")
    @ApiModelProperty(value = "目标测试库", position = 20)
    private String targetLibraryId;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 21)
    private String showIdentifier;

    /**
     * 测试库标识
     */
    @JsonProperty("library_identifier")
    @JSONField(name = "library_identifier")
    @ApiModelProperty(value = "测试库标识", position = 22)
    private String libraryIdentifier;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 23)
    private List<AttentionDTO> attentions;

    /**
     * 工时进度
     */
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "工时进度", position = 24)
    private BigDecimal workloadSchedule;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 25)
    private BigDecimal estimatedWorkload;

    /**
     * 目标模板
     */
    @JsonProperty("target_template")
    @JSONField(name = "target_template")
    @ApiModelProperty(value = "目标模板", position = 26)
    private String targetTemplate;

    /**
     * 评审结果
     */
    @JsonProperty("review_result_state")
    @JSONField(name = "review_result_state")
    @ApiModelProperty(value = "评审结果", position = 27)
    private String reviewResultState;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 28)
    private BigDecimal remainingWorkload;

    /**
     * 最新执行结果
     */
    @JsonProperty("latest_executed")
    @JSONField(name = "latest_executed")
    @ApiModelProperty(value = "最新执行结果", position = 29)
    private List<Map> latestExecuted;

    /**
     * 实际工时
     */
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "实际工时", position = 30)
    private BigDecimal actualWorkload;

    /**
     * 步骤
     */
    @JsonProperty("steps_imp")
    @JSONField(name = "steps_imp")
    @ApiModelProperty(value = "步骤", position = 31)
    private String stepsImp;

    /**
     * 当前版本名称
     */
    @JsonProperty("cur_version_name")
    @JSONField(name = "cur_version_name")
    @ApiModelProperty(value = "当前版本名称", position = 32)
    private String curVersionName;

    /**
     * 选择版本标识
     */
    @JsonProperty("choose_version_id")
    @JSONField(name = "choose_version_id")
    @ApiModelProperty(value = "选择版本标识", position = 33)
    private String chooseVersionId;

    /**
     * 选择版本名称
     */
    @JsonProperty("choose_version_name")
    @JSONField(name = "choose_version_name")
    @ApiModelProperty(value = "选择版本名称", position = 34)
    private String chooseVersionName;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 35)
    private String attentionsImp;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 36)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 37)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 38)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 39)
    private String name;

    /**
     * 用例模块标识
     */
    @JsonProperty("suite_id")
    @JSONField(name = "suite_id")
    @ApiModelProperty(value = "用例模块标识", position = 40)
    private String suiteId;

    /**
     * 所属模块
     */
    @JsonProperty("suite_name")
    @JSONField(name = "suite_name")
    @ApiModelProperty(value = "所属模块", position = 41)
    private String suiteName;

    /**
     * 测试库
     */
    @JsonProperty("test_library_id")
    @JSONField(name = "test_library_id")
    @ApiModelProperty(value = "测试库", position = 42)
    private String testLibraryId;

    /**
     * 所属测试库
     */
    @JsonProperty("test_library_name")
    @JSONField(name = "test_library_name")
    @ApiModelProperty(value = "所属测试库", position = 43)
    private String testLibraryName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 44)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 45)
    private Date updateTime;


    /**
     * 设置 [编号]
     */
    public TestCaseDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public TestCaseDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [重要程度]
     */
    public TestCaseDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [用例类型]
     */
    public TestCaseDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [测试类型]
     */
    public TestCaseDTO setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public TestCaseDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [前置条件]
     */
    public TestCaseDTO setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public TestCaseDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public TestCaseDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public TestCaseDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [步骤]
     */
    public TestCaseDTO setSteps(List<StepDTO> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public TestCaseDTO setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
        this.modify("maintenance_id", maintenanceId);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public TestCaseDTO setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
     * 设置 [测试计划名称]
     */
    public TestCaseDTO setTestPlanName(String testPlanName) {
        this.testPlanName = testPlanName;
        this.modify("test_plan_name", testPlanName);
        return this;
    }

    /**
     * 设置 [执行时间]
     */
    public TestCaseDTO setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public TestCaseDTO setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public TestCaseDTO setRunStatus(String runStatus) {
        this.runStatus = runStatus;
        this.modify("run_status", runStatus);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public TestCaseDTO setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [模块路径]
     */
    public TestCaseDTO setSuites(String suites) {
        this.suites = suites;
        this.modify("suites", suites);
        return this;
    }

    /**
     * 设置 [目标测试库]
     */
    public TestCaseDTO setTargetLibraryId(String targetLibraryId) {
        this.targetLibraryId = targetLibraryId;
        this.modify("target_library_id", targetLibraryId);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public TestCaseDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public TestCaseDTO setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public TestCaseDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public TestCaseDTO setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public TestCaseDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [目标模板]
     */
    public TestCaseDTO setTargetTemplate(String targetTemplate) {
        this.targetTemplate = targetTemplate;
        this.modify("target_template", targetTemplate);
        return this;
    }

    /**
     * 设置 [评审结果]
     */
    public TestCaseDTO setReviewResultState(String reviewResultState) {
        this.reviewResultState = reviewResultState;
        this.modify("review_result_state", reviewResultState);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public TestCaseDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [最新执行结果]
     */
    public TestCaseDTO setLatestExecuted(List<Map> latestExecuted) {
        this.latestExecuted = latestExecuted;
        this.modify("latest_executed", latestExecuted);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public TestCaseDTO setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [步骤]
     */
    public TestCaseDTO setStepsImp(String stepsImp) {
        this.stepsImp = stepsImp;
        this.modify("steps_imp", stepsImp);
        return this;
    }

    /**
     * 设置 [当前版本名称]
     */
    public TestCaseDTO setCurVersionName(String curVersionName) {
        this.curVersionName = curVersionName;
        this.modify("cur_version_name", curVersionName);
        return this;
    }

    /**
     * 设置 [选择版本标识]
     */
    public TestCaseDTO setChooseVersionId(String chooseVersionId) {
        this.chooseVersionId = chooseVersionId;
        this.modify("choose_version_id", chooseVersionId);
        return this;
    }

    /**
     * 设置 [选择版本名称]
     */
    public TestCaseDTO setChooseVersionName(String chooseVersionName) {
        this.chooseVersionName = chooseVersionName;
        this.modify("choose_version_name", chooseVersionName);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public TestCaseDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public TestCaseDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [用例模块标识]
     */
    public TestCaseDTO setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
     * 设置 [所属模块]
     */
    public TestCaseDTO setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        this.modify("suite_name", suiteName);
        return this;
    }

    /**
     * 设置 [测试库]
     */
    public TestCaseDTO setTestLibraryId(String testLibraryId) {
        this.testLibraryId = testLibraryId;
        this.modify("test_library_id", testLibraryId);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public TestCaseDTO setTestLibraryName(String testLibraryName) {
        this.testLibraryName = testLibraryName;
        this.modify("test_library_name", testLibraryName);
        return this;
    }


}
