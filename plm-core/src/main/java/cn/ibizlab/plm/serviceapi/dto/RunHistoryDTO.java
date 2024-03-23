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
 * 执行结果[RunHistoryDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行结果DTO")
public class RunHistoryDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 测试用例
     */
    @JsonProperty("case_id")
    @JSONField(name = "case_id")
    @ApiModelProperty(value = "测试用例", position = 0)
    private String caseId;

    /**
     * 备注
     */
    @JsonProperty("remark")
    @JSONField(name = "remark")
    @ApiModelProperty(value = "备注", position = 1)
    private String remark;

    /**
     * 执行时间
     */
    @JsonProperty("executed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执行时间", position = 2)
    private Date executedAt;

    /**
     * 执行结果
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "执行结果", position = 3)
    private String status;

    /**
     * 步骤
     */
    @JsonProperty("steps")
    @JSONField(name = "steps")
    @ApiModelProperty(value = "步骤", position = 4)
    private List<StepDTO> steps;

    /**
     * 执行人标识
     */
    @JsonProperty("executor_id")
    @JSONField(name = "executor_id")
    @ApiModelProperty(value = "执行人标识", position = 5)
    private String executorId;

    /**
     * 执行人
     */
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "执行人", position = 6)
    private String executorName;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 7)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 8)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 9)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 10)
    private String name;

    /**
     * 执行用例标识
     */
    @JsonProperty("run_id")
    @JSONField(name = "run_id")
    @ApiModelProperty(value = "执行用例标识", position = 11)
    private String runId;

    /**
     * 标题
     */
    @JsonProperty("run_title")
    @JSONField(name = "run_title")
    @ApiModelProperty(value = "标题", position = 12)
    private String runTitle;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 13)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 14)
    private Date updateTime;


    /**
     * 设置 [测试用例]
     */
    public RunHistoryDTO setCaseId(String caseId) {
        this.caseId = caseId;
        this.modify("case_id", caseId);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public RunHistoryDTO setRemark(String remark) {
        this.remark = remark;
        this.modify("remark", remark);
        return this;
    }

    /**
     * 设置 [执行时间]
     */
    public RunHistoryDTO setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public RunHistoryDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [步骤]
     */
    public RunHistoryDTO setSteps(List<StepDTO> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
     * 设置 [执行人标识]
     */
    public RunHistoryDTO setExecutorId(String executorId) {
        this.executorId = executorId;
        this.modify("executor_id", executorId);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public RunHistoryDTO setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public RunHistoryDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [执行用例标识]
     */
    public RunHistoryDTO setRunId(String runId) {
        this.runId = runId;
        this.modify("run_id", runId);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public RunHistoryDTO setRunTitle(String runTitle) {
        this.runTitle = runTitle;
        this.modify("run_title", runTitle);
        return this;
    }


}
