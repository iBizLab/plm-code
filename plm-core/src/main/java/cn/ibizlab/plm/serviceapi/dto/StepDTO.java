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
 * 用例步骤[StepDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例步骤DTO")
public class StepDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 步骤描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "步骤描述", position = 0)
    private String description;

    /**
     * 预期结果
     */
    @JsonProperty("expected_value")
    @JSONField(name = "expected_value")
    @ApiModelProperty(value = "预期结果", position = 1)
    private String expectedValue;

    /**
     * 分组标识
     */
    @JsonProperty("group_id")
    @JSONField(name = "group_id")
    @ApiModelProperty(value = "分组标识", position = 2)
    private String groupId;

    /**
     * 实际
     */
    @JsonProperty("actual_value")
    @JSONField(name = "actual_value")
    @ApiModelProperty(value = "实际", position = 3)
    private String actualValue;

    /**
     * 是否分组
     */
    @JsonProperty("is_group")
    @JSONField(name = "is_group")
    @ApiModelProperty(value = "是否分组", position = 4)
    private Integer isGroup;

    /**
     * 执行结果
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "执行结果", position = 5)
    private String status;

    /**
     * 用例标识
     */
    @JsonProperty("case_id")
    @JSONField(name = "case_id")
    @ApiModelProperty(value = "用例标识", position = 6)
    private String caseId;

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
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 12)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 13)
    private Date updateTime;


    /**
     * 设置 [步骤描述]
     */
    public StepDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [预期结果]
     */
    public StepDTO setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
        this.modify("expected_value", expectedValue);
        return this;
    }

    /**
     * 设置 [分组标识]
     */
    public StepDTO setGroupId(String groupId) {
        this.groupId = groupId;
        this.modify("group_id", groupId);
        return this;
    }

    /**
     * 设置 [实际]
     */
    public StepDTO setActualValue(String actualValue) {
        this.actualValue = actualValue;
        this.modify("actual_value", actualValue);
        return this;
    }

    /**
     * 设置 [是否分组]
     */
    public StepDTO setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
        this.modify("is_group", isGroup);
        return this;
    }

    /**
     * 设置 [执行结果]
     */
    public StepDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [用例标识]
     */
    public StepDTO setCaseId(String caseId) {
        this.caseId = caseId;
        this.modify("case_id", caseId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public StepDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [执行用例标识]
     */
    public StepDTO setRunId(String runId) {
        this.runId = runId;
        this.modify("run_id", runId);
        return this;
    }


}
