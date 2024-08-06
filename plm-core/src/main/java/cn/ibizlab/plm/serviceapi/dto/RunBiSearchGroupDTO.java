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
 * 执行用例[RunBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行用例DTO")
public class RunBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否最新
     */
    @JsonProperty("is_newest")
    @JSONField(name = "is_newest")
    @ApiModelProperty(value = "是否最新", position = 0)
    private Integer isNewest;

    /**
     * 执行时间
     */
    @JsonProperty("executed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间", position = 1)
    private Date executedAt;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 2)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 3)
    private Date updateTime;

    /**
     * 执行人
     */
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "执行人", position = 4)
    private String executorName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 5)
    private String updateMan;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 6)
    private String name;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 7)
    private String createMan;

    /**
     * 执行人标识
     */
    @JsonProperty("executor_id")
    @JSONField(name = "executor_id")
    @ApiModelProperty(value = "执行人标识", position = 8)
    private String executorId;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 9)
    private String curVersionId;

    /**
     * 工时进度
     */
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "工时进度", position = 10)
    private BigDecimal workloadSchedule;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 11)
    private BigDecimal remainingWorkload;

    /**
     * 关联执行结果数
     */
    @JsonProperty("relation_total_history")
    @JSONField(name = "relation_total_history")
    @ApiModelProperty(value = "关联执行结果数", position = 12)
    private BigDecimal relationTotalHistory;

    /**
     * 关联缺陷数
     */
    @JsonProperty("relation_total_bug")
    @JSONField(name = "relation_total_bug")
    @ApiModelProperty(value = "关联缺陷数", position = 13)
    private BigDecimal relationTotalBug;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 14)
    private BigDecimal estimatedWorkload;

    /**
     * 实际工时
     */
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "实际工时", position = 15)
    private BigDecimal actualWorkload;

    /**
     * 所属测试库
     */
    @JsonProperty("library_name")
    @JSONField(name = "library_name")
    @ApiModelProperty(value = "所属测试库", position = 16)
    private String libraryName;

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
     * 评审状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "评审状态", position = 19)
    private String state;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_name")
    @JSONField(name = "maintenance_name")
    @ApiModelProperty(value = "维护人", position = 20)
    private String maintenanceName;

    /**
     * 测试类型
     */
    @JsonProperty("test_type")
    @JSONField(name = "test_type")
    @ApiModelProperty(value = "测试类型", position = 21)
    private String testType;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 22)
    private String identifier;

    /**
     * 测试库标识
     */
    @JsonProperty("library_id")
    @JSONField(name = "library_id")
    @ApiModelProperty(value = "测试库标识", position = 23)
    private String libraryId;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 24)
    private String title;

    /**
     * 所属模块
     */
    @JsonProperty("suite_name")
    @JSONField(name = "suite_name")
    @ApiModelProperty(value = "所属模块", position = 25)
    private String suiteName;

    /**
     * 名称
     */
    @JsonProperty("case_name")
    @JSONField(name = "case_name")
    @ApiModelProperty(value = "名称", position = 26)
    private String caseName;

    /**
     * 测试计划
     */
    @JsonProperty("plan_name")
    @JSONField(name = "plan_name")
    @ApiModelProperty(value = "测试计划", position = 27)
    private String planName;

    /**
     * 测试计划标识
     */
    @JsonProperty("plan_id")
    @JSONField(name = "plan_id")
    @ApiModelProperty(value = "测试计划标识", position = 28)
    private String planId;

    /**
     * 测试用例标识
     */
    @JsonProperty("case_id")
    @JSONField(name = "case_id")
    @ApiModelProperty(value = "测试用例标识", position = 29)
    private String caseId;

    /**
     * 执行结果
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "执行结果", position = 30)
    private String status;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 31)
    private String priority;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 32)
    private String id;

    /**
     * bi测试计划名称
     */
    @JsonProperty("bi_plan_name")
    @JSONField(name = "bi_plan_name")
    @ApiModelProperty(value = "bi测试计划名称", position = 33)
    private String biPlanName;


    /**
     * 设置 [是否最新]
     */
    public RunBiSearchGroupDTO setIsNewest(Integer isNewest) {
        this.isNewest = isNewest;
        this.modify("is_newest", isNewest);
        return this;
    }

    /**
     * 设置 [执行时间]
     */
    public RunBiSearchGroupDTO setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public RunBiSearchGroupDTO setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public RunBiSearchGroupDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [执行人标识]
     */
    public RunBiSearchGroupDTO setExecutorId(String executorId) {
        this.executorId = executorId;
        this.modify("executor_id", executorId);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public RunBiSearchGroupDTO setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public RunBiSearchGroupDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [关联执行结果数]
     */
    public RunBiSearchGroupDTO setRelationTotalHistory(BigDecimal relationTotalHistory) {
        this.relationTotalHistory = relationTotalHistory;
        this.modify("relation_total_history", relationTotalHistory);
        return this;
    }

    /**
     * 设置 [关联缺陷数]
     */
    public RunBiSearchGroupDTO setRelationTotalBug(BigDecimal relationTotalBug) {
        this.relationTotalBug = relationTotalBug;
        this.modify("relation_total_bug", relationTotalBug);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public RunBiSearchGroupDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public RunBiSearchGroupDTO setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public RunBiSearchGroupDTO setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
     * 设置 [用例类型]
     */
    public RunBiSearchGroupDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [重要程度]
     */
    public RunBiSearchGroupDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [评审状态]
     */
    public RunBiSearchGroupDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public RunBiSearchGroupDTO setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
     * 设置 [测试类型]
     */
    public RunBiSearchGroupDTO setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public RunBiSearchGroupDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public RunBiSearchGroupDTO setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public RunBiSearchGroupDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [所属模块]
     */
    public RunBiSearchGroupDTO setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        this.modify("suite_name", suiteName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public RunBiSearchGroupDTO setCaseName(String caseName) {
        this.caseName = caseName;
        this.modify("case_name", caseName);
        return this;
    }

    /**
     * 设置 [测试计划]
     */
    public RunBiSearchGroupDTO setPlanName(String planName) {
        this.planName = planName;
        this.modify("plan_name", planName);
        return this;
    }

    /**
     * 设置 [测试计划标识]
     */
    public RunBiSearchGroupDTO setPlanId(String planId) {
        this.planId = planId;
        this.modify("plan_id", planId);
        return this;
    }

    /**
     * 设置 [测试用例标识]
     */
    public RunBiSearchGroupDTO setCaseId(String caseId) {
        this.caseId = caseId;
        this.modify("case_id", caseId);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public RunBiSearchGroupDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public RunBiSearchGroupDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [bi测试计划名称]
     */
    public RunBiSearchGroupDTO setBiPlanName(String biPlanName) {
        this.biPlanName = biPlanName;
        this.modify("bi_plan_name", biPlanName);
        return this;
    }


}
