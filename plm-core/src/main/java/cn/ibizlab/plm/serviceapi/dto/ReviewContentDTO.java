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
 * 评审内容[ReviewContentDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审内容DTO")
public class ReviewContentDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 变更类型
     */
    @JsonProperty("change_type")
    @JSONField(name = "change_type")
    @ApiModelProperty(value = "变更类型", position = 0)
    private String changeType;

    /**
     * 关联主体标识
     */
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "关联主体标识", position = 1)
    private String principalId;

    /**
     * 变更版本
     */
    @JsonProperty("change_version")
    @JSONField(name = "change_version")
    @ApiModelProperty(value = "变更版本", position = 2)
    private Map<Object,Object> changeVersion;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 3)
    private String ownerType;

    /**
     * 关联主体类型
     */
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "关联主体类型", position = 4)
    private String principalType;

    /**
     * 评审结果
     */
    @JsonProperty("stage_results")
    @JSONField(name = "stage_results")
    @ApiModelProperty(value = "评审结果", position = 5)
    private List<ReviewResultDTO> stageResults;

    /**
     * 最终评审结果
     */
    @JsonProperty("final_stage_results")
    @JSONField(name = "final_stage_results")
    @ApiModelProperty(value = "最终评审结果", position = 6)
    private String finalStageResults;

    /**
     * 关联目标类型
     */
    @JsonProperty("target_type")
    @JSONField(name = "target_type")
    @ApiModelProperty(value = "关联目标类型", position = 7)
    private String targetType;

    /**
     * 关联目标标识
     */
    @JsonProperty("target_id")
    @JSONField(name = "target_id")
    @ApiModelProperty(value = "关联目标标识", position = 8)
    private String targetId;

    /**
     * 父对象版本标识
     */
    @JsonProperty("parent_version_id")
    @JSONField(name = "parent_version_id")
    @ApiModelProperty(value = "父对象版本标识", position = 9)
    private String parentVersionId;

    /**
     * 目标对象版本标识
     */
    @JsonProperty("target_version_id")
    @JSONField(name = "target_version_id")
    @ApiModelProperty(value = "目标对象版本标识", position = 10)
    private String targetVersionId;

    /**
     * 测试用例
     */
    @JsonProperty("test_case")
    @JSONField(name = "test_case")
    @ApiModelProperty(value = "测试用例", position = 11)
    private TestCaseDTO testCase;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 12)
    private String curVersionId;

    /**
     * 目标对象编号
     */
    @JsonProperty("target_identifier")
    @JSONField(name = "target_identifier")
    @ApiModelProperty(value = "目标对象编号", position = 13)
    private String targetIdentifier;

    /**
     * 目标对象标题
     */
    @JsonProperty("target_title")
    @JSONField(name = "target_title")
    @ApiModelProperty(value = "目标对象标题", position = 14)
    private String targetTitle;

    /**
     * 目标对象状态
     */
    @JsonProperty("target_state")
    @JSONField(name = "target_state")
    @ApiModelProperty(value = "目标对象状态", position = 15)
    private String targetState;

    /**
     * 目标对象负责人
     */
    @JsonProperty("target_assignee")
    @JSONField(name = "target_assignee")
    @ApiModelProperty(value = "目标对象负责人", position = 16)
    private String targetAssignee;

    /**
     * 关联目标版本
     */
    @JsonProperty("target_version")
    @JSONField(name = "target_version")
    @ApiModelProperty(value = "关联目标版本", position = 17)
    private VersionDTO targetVersion;

    /**
     * 目标对象优先级
     */
    @JsonProperty("target_priority")
    @JSONField(name = "target_priority")
    @ApiModelProperty(value = "目标对象优先级", position = 18)
    private String targetPriority;

    /**
     * 目标对象父标识
     */
    @JsonProperty("target_parent_id")
    @JSONField(name = "target_parent_id")
    @ApiModelProperty(value = "目标对象父标识", position = 19)
    private String targetParentId;

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
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 24)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 25)
    private Date updateTime;


    /**
     * 设置 [变更类型]
     */
    public ReviewContentDTO setChangeType(String changeType) {
        this.changeType = changeType;
        this.modify("change_type", changeType);
        return this;
    }

    /**
     * 设置 [关联主体标识]
     */
    public ReviewContentDTO setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
     * 设置 [变更版本]
     */
    public ReviewContentDTO setChangeVersion(Map<Object,Object> changeVersion) {
        this.changeVersion = changeVersion;
        this.modify("change_version", changeVersion);
        return this;
    }

    /**
     * 设置 [所属数据对象]
     */
    public ReviewContentDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [关联主体类型]
     */
    public ReviewContentDTO setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
     * 设置 [评审结果]
     */
    public ReviewContentDTO setStageResults(List<ReviewResultDTO> stageResults) {
        this.stageResults = stageResults;
        this.modify("stage_results", stageResults);
        return this;
    }

    /**
     * 设置 [最终评审结果]
     */
    public ReviewContentDTO setFinalStageResults(String finalStageResults) {
        this.finalStageResults = finalStageResults;
        this.modify("final_stage_results", finalStageResults);
        return this;
    }

    /**
     * 设置 [关联目标类型]
     */
    public ReviewContentDTO setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
     * 设置 [关联目标标识]
     */
    public ReviewContentDTO setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
     * 设置 [目标对象版本标识]
     */
    public ReviewContentDTO setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
     * 设置 [测试用例]
     */
    public ReviewContentDTO setTestCase(TestCaseDTO testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
     * 设置 [目标对象编号]
     */
    public ReviewContentDTO setTargetIdentifier(String targetIdentifier) {
        this.targetIdentifier = targetIdentifier;
        this.modify("target_identifier", targetIdentifier);
        return this;
    }

    /**
     * 设置 [目标对象标题]
     */
    public ReviewContentDTO setTargetTitle(String targetTitle) {
        this.targetTitle = targetTitle;
        this.modify("target_title", targetTitle);
        return this;
    }

    /**
     * 设置 [目标对象状态]
     */
    public ReviewContentDTO setTargetState(String targetState) {
        this.targetState = targetState;
        this.modify("target_state", targetState);
        return this;
    }

    /**
     * 设置 [目标对象负责人]
     */
    public ReviewContentDTO setTargetAssignee(String targetAssignee) {
        this.targetAssignee = targetAssignee;
        this.modify("target_assignee", targetAssignee);
        return this;
    }

    /**
     * 设置 [关联目标版本]
     */
    public ReviewContentDTO setTargetVersion(VersionDTO targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
     * 设置 [目标对象优先级]
     */
    public ReviewContentDTO setTargetPriority(String targetPriority) {
        this.targetPriority = targetPriority;
        this.modify("target_priority", targetPriority);
        return this;
    }

    /**
     * 设置 [目标对象父标识]
     */
    public ReviewContentDTO setTargetParentId(String targetParentId) {
        this.targetParentId = targetParentId;
        this.modify("target_parent_id", targetParentId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewContentDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
