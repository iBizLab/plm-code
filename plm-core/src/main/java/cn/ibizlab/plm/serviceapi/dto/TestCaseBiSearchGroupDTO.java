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
 * 用例[TestCaseBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例DTO")
public class TestCaseBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 执行人
     */
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "执行人", position = 0)
    private String executorName;

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
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 2)
    private String showIdentifier;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 3)
    private String updateMan;

    /**
     * 目标测试库
     */
    @JsonProperty("target_library_id")
    @JSONField(name = "target_library_id")
    @ApiModelProperty(value = "目标测试库", position = 4)
    private String targetLibraryId;

    /**
     * 目标模板
     */
    @JsonProperty("target_template")
    @JSONField(name = "target_template")
    @ApiModelProperty(value = "目标模板", position = 5)
    private String targetTemplate;

    /**
     * 实际工时
     */
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "实际工时", position = 6)
    private BigDecimal actualWorkload;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 7)
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 8)
    private BigDecimal remainingWorkload;

    /**
     * 工时进度
     */
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "工时进度", position = 9)
    private BigDecimal workloadSchedule;

    /**
     * 测试库标识
     */
    @JsonProperty("library_identifier")
    @JSONField(name = "library_identifier")
    @ApiModelProperty(value = "测试库标识", position = 10)
    private String libraryIdentifier;

    /**
     * 所属测试库
     */
    @JsonProperty("test_library_name")
    @JSONField(name = "test_library_name")
    @ApiModelProperty(value = "所属测试库", position = 11)
    private String testLibraryName;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_name")
    @JSONField(name = "maintenance_name")
    @ApiModelProperty(value = "维护人", position = 12)
    private String maintenanceName;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_id")
    @JSONField(name = "maintenance_id")
    @ApiModelProperty(value = "维护人", position = 13)
    private String maintenanceId;

    /**
     * 测试库
     */
    @JsonProperty("test_library_id")
    @JSONField(name = "test_library_id")
    @ApiModelProperty(value = "测试库", position = 14)
    private String testLibraryId;

    /**
     * 用例模块标识
     */
    @JsonProperty("suite_id")
    @JSONField(name = "suite_id")
    @ApiModelProperty(value = "用例模块标识", position = 15)
    private String suiteId;

    /**
     * 执行结果
     */
    @JsonProperty("run_status")
    @JSONField(name = "run_status")
    @ApiModelProperty(value = "执行结果", position = 16)
    private String runStatus;

    /**
     * 用例类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "用例类型", position = 17)
    private String type;

    /**
     * 重要程度
     */
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "重要程度", position = 18)
    private String level;

    /**
     * 测试类型
     */
    @JsonProperty("test_type")
    @JSONField(name = "test_type")
    @ApiModelProperty(value = "测试类型", position = 19)
    private String testType;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 20)
    private String state;

    /**
     * 评审结果
     */
    @JsonProperty("review_result_state")
    @JSONField(name = "review_result_state")
    @ApiModelProperty(value = "评审结果", position = 21)
    private String reviewResultState;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 22)
    private String id;

    /**
     * 最新执行结果
     */
    @JsonProperty("latest_executed")
    @JSONField(name = "latest_executed")
    @ApiModelProperty(value = "最新执行结果", position = 23)
    private List<Map> latestExecuted;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 24)
    private Integer isDeleted;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 25)
    private Date createTime;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 26)
    private String createMan;


    /**
     * 设置 [执行人]
     */
    public TestCaseBiSearchGroupDTO setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public TestCaseBiSearchGroupDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public TestCaseBiSearchGroupDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [目标测试库]
     */
    public TestCaseBiSearchGroupDTO setTargetLibraryId(String targetLibraryId) {
        this.targetLibraryId = targetLibraryId;
        this.modify("target_library_id", targetLibraryId);
        return this;
    }

    /**
     * 设置 [目标模板]
     */
    public TestCaseBiSearchGroupDTO setTargetTemplate(String targetTemplate) {
        this.targetTemplate = targetTemplate;
        this.modify("target_template", targetTemplate);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public TestCaseBiSearchGroupDTO setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public TestCaseBiSearchGroupDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public TestCaseBiSearchGroupDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public TestCaseBiSearchGroupDTO setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public TestCaseBiSearchGroupDTO setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public TestCaseBiSearchGroupDTO setTestLibraryName(String testLibraryName) {
        this.testLibraryName = testLibraryName;
        this.modify("test_library_name", testLibraryName);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public TestCaseBiSearchGroupDTO setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public TestCaseBiSearchGroupDTO setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
        this.modify("maintenance_id", maintenanceId);
        return this;
    }

    /**
     * 设置 [测试库]
     */
    public TestCaseBiSearchGroupDTO setTestLibraryId(String testLibraryId) {
        this.testLibraryId = testLibraryId;
        this.modify("test_library_id", testLibraryId);
        return this;
    }

    /**
     * 设置 [用例模块标识]
     */
    public TestCaseBiSearchGroupDTO setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public TestCaseBiSearchGroupDTO setRunStatus(String runStatus) {
        this.runStatus = runStatus;
        this.modify("run_status", runStatus);
        return this;
    }

    /**
     * 设置 [用例类型]
     */
    public TestCaseBiSearchGroupDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [重要程度]
     */
    public TestCaseBiSearchGroupDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [测试类型]
     */
    public TestCaseBiSearchGroupDTO setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public TestCaseBiSearchGroupDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [评审结果]
     */
    public TestCaseBiSearchGroupDTO setReviewResultState(String reviewResultState) {
        this.reviewResultState = reviewResultState;
        this.modify("review_result_state", reviewResultState);
        return this;
    }

    /**
     * 设置 [最新执行结果]
     */
    public TestCaseBiSearchGroupDTO setLatestExecuted(List<Map> latestExecuted) {
        this.latestExecuted = latestExecuted;
        this.modify("latest_executed", latestExecuted);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public TestCaseBiSearchGroupDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }


}
