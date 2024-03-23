/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
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
 * 执行用例[RunDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行用例DTO")
public class RunDTO extends DTOBase implements Serializable {

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
     * 评审状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "评审状态", position = 2)
    private String state;

    /**
     * 重要程度
     */
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "重要程度", position = 3)
    private String level;

    /**
     * 用例类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "用例类型", position = 4)
    private String type;

    /**
     * 执行时间
     */
    @JsonProperty("executed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间", position = 5)
    private Date executedAt;

    /**
     * 执行结果
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "执行结果", position = 6)
    private String status;

    /**
     * 备注
     */
    @JsonProperty("remark")
    @JSONField(name = "remark")
    @ApiModelProperty(value = "备注", position = 7)
    private String remark;

    /**
     * 步骤
     */
    @JsonProperty("steps")
    @JSONField(name = "steps")
    @ApiModelProperty(value = "步骤", position = 8)
    private List<StepDTO> steps;

    /**
     * 测试计划
     */
    @JsonProperty("plan_name")
    @JSONField(name = "plan_name")
    @ApiModelProperty(value = "测试计划", position = 9)
    private String planName;

    /**
     * 测试类型
     */
    @JsonProperty("test_type")
    @JSONField(name = "test_type")
    @ApiModelProperty(value = "测试类型", position = 10)
    private String testType;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_name")
    @JSONField(name = "maintenance_name")
    @ApiModelProperty(value = "维护人", position = 11)
    private String maintenanceName;

    /**
     * 执行人标识
     */
    @JsonProperty("executor_id")
    @JSONField(name = "executor_id")
    @ApiModelProperty(value = "执行人标识", position = 12)
    private String executorId;

    /**
     * 执行人
     */
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "执行人", position = 13)
    private String executorName;

    /**
     * 用例模块标识
     */
    @JsonProperty("suite_id")
    @JSONField(name = "suite_id")
    @ApiModelProperty(value = "用例模块标识", position = 14)
    private String suiteId;

    /**
     * 所属模块
     */
    @JsonProperty("suite_name")
    @JSONField(name = "suite_name")
    @ApiModelProperty(value = "所属模块", position = 15)
    private String suiteName;

    /**
     * 前置条件
     */
    @JsonProperty("precondition")
    @JSONField(name = "precondition")
    @ApiModelProperty(value = "前置条件", position = 16)
    private String precondition;

    /**
     * 模块路径
     */
    @JsonProperty("suites")
    @JSONField(name = "suites")
    @ApiModelProperty(value = "模块路径", position = 17)
    private String suites;

    /**
     * 附件
     */
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "附件", position = 18)
    private List<AttachmentDTO> attachments;

    /**
     * 所属测试库
     */
    @JsonProperty("library_name")
    @JSONField(name = "library_name")
    @ApiModelProperty(value = "所属测试库", position = 19)
    private String libraryName;

    /**
     * 测试库标识
     */
    @JsonProperty("library_id")
    @JSONField(name = "library_id")
    @ApiModelProperty(value = "测试库标识", position = 20)
    private String libraryId;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 21)
    private List<AttentionDTO> attentions;

    /**
     * 测试用例标识
     */
    @JsonProperty("case_id")
    @JSONField(name = "case_id")
    @ApiModelProperty(value = "测试用例标识", position = 22)
    private String caseId;

    /**
     * 名称
     */
    @JsonProperty("case_name")
    @JSONField(name = "case_name")
    @ApiModelProperty(value = "名称", position = 23)
    private String caseName;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 24)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 25)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 26)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 27)
    private String name;

    /**
     * 测试计划标识
     */
    @JsonProperty("plan_id")
    @JSONField(name = "plan_id")
    @ApiModelProperty(value = "测试计划标识", position = 28)
    private String planId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 29)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 30)
    private Date updateTime;

    /**
     * 执行结果
     */
    @JsonProperty("run_histories")
    @JSONField(name = "run_histories")
    @ApiModelProperty(value = "执行结果", position = 31)
    private List<RunHistoryDTO> runHistories;


    /**
     * 设置 [编号]
     */
    public RunDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public RunDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [评审状态]
     */
    public RunDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [重要程度]
     */
    public RunDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [用例类型]
     */
    public RunDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [执行时间]
     */
    public RunDTO setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public RunDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public RunDTO setRemark(String remark) {
        this.remark = remark;
        this.modify("remark", remark);
        return this;
    }

    /**
     * 设置 [步骤]
     */
    public RunDTO setSteps(List<StepDTO> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
     * 设置 [测试计划]
     */
    public RunDTO setPlanName(String planName) {
        this.planName = planName;
        this.modify("plan_name", planName);
        return this;
    }

    /**
     * 设置 [测试类型]
     */
    public RunDTO setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public RunDTO setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
     * 设置 [执行人标识]
     */
    public RunDTO setExecutorId(String executorId) {
        this.executorId = executorId;
        this.modify("executor_id", executorId);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public RunDTO setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
     * 设置 [用例模块标识]
     */
    public RunDTO setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
     * 设置 [所属模块]
     */
    public RunDTO setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        this.modify("suite_name", suiteName);
        return this;
    }

    /**
     * 设置 [前置条件]
     */
    public RunDTO setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
     * 设置 [模块路径]
     */
    public RunDTO setSuites(String suites) {
        this.suites = suites;
        this.modify("suites", suites);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public RunDTO setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public RunDTO setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public RunDTO setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public RunDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [测试用例标识]
     */
    public RunDTO setCaseId(String caseId) {
        this.caseId = caseId;
        this.modify("case_id", caseId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public RunDTO setCaseName(String caseName) {
        this.caseName = caseName;
        this.modify("case_name", caseName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public RunDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [测试计划标识]
     */
    public RunDTO setPlanId(String planId) {
        this.planId = planId;
        this.modify("plan_id", planId);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public RunDTO setRunHistories(List<RunHistoryDTO> runHistories) {
        this.runHistories = runHistories;
        this.modify("run_histories", runHistories);
        return this;
    }


}
