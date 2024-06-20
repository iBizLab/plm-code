/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@MINHERIT}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 评审内容实体类[ReviewContent]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "REVIEW_CONTENT", description = "评审内容")
public class ReviewContent extends EntityBase implements Serializable
{
    /**
     * 变更类型
     */
    @DEField(name = "change_type" , dict = "review_change_type")
    @JSONField(name = "change_type")
    @JsonProperty("change_type")
    @ApiModelProperty(value = "change_type", notes = "变更类型")
    private String changeType;

    /**
     * 关联主体标识
     */
    @DEField(name = "principal_id")
    @JSONField(name = "principal_id")
    @JsonProperty("principal_id")
    @ApiModelProperty(value = "principal_id", notes = "关联主体标识")
    private String principalId;

    /**
     * 变更版本
     */
    @DEField(name = "change_version")
    @JSONField(name = "change_version")
    @JsonProperty("change_version")
    @ApiModelProperty(value = "change_version", notes = "变更版本")
    private Map changeVersion;

    /**
     * 所属数据对象
     */
    @DEField(name = "owner_type")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 关联主体类型
     */
    @DEField(name = "principal_type" , defaultValue = "REVIEW")
    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    @ApiModelProperty(value = "principal_type", notes = "关联主体类型")
    private String principalType;

    /**
     * 评审结果
     */
    @DEField(name = "stage_results")
    @JSONField(name = "stage_results")
    @JsonProperty("stage_results")
    @ApiModelProperty(value = "stage_results", notes = "评审结果")
    private List<ReviewResult> stageResults;

    /**
     * 关联目标类型
     */
    @DEField(name = "target_type" , defaultValue = "TEST_CASE")
    @JSONField(name = "target_type")
    @JsonProperty("target_type")
    @ApiModelProperty(value = "target_type", notes = "关联目标类型")
    private String targetType;

    /**
     * 最终评审结果
     */
    @DEField(name = "final_stage_results" , dict = "final_stage_results")
    @JSONField(name = "final_stage_results")
    @JsonProperty("final_stage_results")
    @ApiModelProperty(value = "final_stage_results", notes = "最终评审结果")
    private String finalStageResults;

    /**
     * 关联目标标识
     */
    @DEField(name = "target_id")
    @JSONField(name = "target_id")
    @JsonProperty("target_id")
    @ApiModelProperty(value = "target_id", notes = "关联目标标识")
    private String targetId;

    /**
     * 目标对象版本标识
     */
    @DEField(name = "target_version_id")
    @JSONField(name = "target_version_id")
    @JsonProperty("target_version_id")
    @ApiModelProperty(value = "target_version_id", notes = "目标对象版本标识")
    private String targetVersionId;

    /**
     * 父对象版本标识
     */
    @DEField(name = "parent_version_id" , preType = DEPredefinedFieldType.PARENTVERSIONID)
    @JSONField(name = "parent_version_id")
    @JsonProperty("parent_version_id")
    @ApiModelProperty(value = "parent_version_id", notes = "父对象版本标识")
    private String parentVersionId;

    /**
     * 测试用例
     */
    @DEField(name = "test_case")
    @JSONField(name = "test_case")
    @JsonProperty("test_case")
    @ApiModelProperty(value = "test_case", notes = "测试用例")
    private TestCase testCase;

    /**
     * 当前版本标识
     */
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
     * 目标对象编号
     */
    @DEField(name = "target_identifier")
    @JSONField(name = "target_identifier")
    @JsonProperty("target_identifier")
    @ApiModelProperty(value = "target_identifier", notes = "目标对象编号")
    private String targetIdentifier;

    /**
     * 目标对象标题
     */
    @DEField(name = "target_title")
    @JSONField(name = "target_title")
    @JsonProperty("target_title")
    @ApiModelProperty(value = "target_title", notes = "目标对象标题")
    private String targetTitle;

    /**
     * 目标对象状态
     */
    @DEField(name = "target_state")
    @JSONField(name = "target_state")
    @JsonProperty("target_state")
    @ApiModelProperty(value = "target_state", notes = "目标对象状态")
    private String targetState;

    /**
     * 目标对象负责人
     */
    @DEField(name = "target_assignee")
    @JSONField(name = "target_assignee")
    @JsonProperty("target_assignee")
    @ApiModelProperty(value = "target_assignee", notes = "目标对象负责人")
    private String targetAssignee;

    /**
     * 关联目标版本
     */
    @DEField(name = "target_version")
    @JSONField(name = "target_version")
    @JsonProperty("target_version")
    @ApiModelProperty(value = "target_version", notes = "关联目标版本")
    private Version targetVersion;

    /**
     * 目标对象优先级
     */
    @DEField(name = "target_priority")
    @JSONField(name = "target_priority")
    @JsonProperty("target_priority")
    @ApiModelProperty(value = "target_priority", notes = "目标对象优先级")
    private String targetPriority;

    /**
     * 目标对象父标识
     */
    @DEField(name = "target_parent_id")
    @JSONField(name = "target_parent_id")
    @JsonProperty("target_parent_id")
    @ApiModelProperty(value = "target_parent_id", notes = "目标对象父标识")
    private String targetParentId;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 评审-评审内容
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "review", notes = "评审-评审内容")
    private Review review;

    /**
     * 评审-评审内容
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "review_wizard", notes = "评审-评审内容")
    private ReviewWizard reviewWizard;

    /**
    * 设置 [变更类型]
    */
    public ReviewContent setChangeType(String changeType) {
        this.changeType = changeType;
        this.modify("change_type", changeType);
        return this;
    }

    /**
    * 设置 [关联主体标识]
    */
    public ReviewContent setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
    * 设置 [变更版本]
    */
    public ReviewContent setChangeVersion(Map changeVersion) {
        this.changeVersion = changeVersion;
        this.modify("change_version", changeVersion);
        return this;
    }

    /**
    * 设置 [所属数据对象]
    */
    public ReviewContent setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [关联主体类型]
    */
    public ReviewContent setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
    * 设置 [评审结果]
    */
    public ReviewContent setStageResults(List<ReviewResult> stageResults) {
        this.stageResults = stageResults;
        this.modify("stage_results", stageResults);
        return this;
    }

    /**
    * 设置 [关联目标类型]
    */
    public ReviewContent setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
    * 设置 [最终评审结果]
    */
    public ReviewContent setFinalStageResults(String finalStageResults) {
        this.finalStageResults = finalStageResults;
        this.modify("final_stage_results", finalStageResults);
        return this;
    }

    /**
    * 设置 [关联目标标识]
    */
    public ReviewContent setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
    * 设置 [目标对象版本标识]
    */
    public ReviewContent setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
    * 设置 [测试用例]
    */
    public ReviewContent setTestCase(TestCase testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
    * 设置 [目标对象编号]
    */
    public ReviewContent setTargetIdentifier(String targetIdentifier) {
        this.targetIdentifier = targetIdentifier;
        this.modify("target_identifier", targetIdentifier);
        return this;
    }

    /**
    * 设置 [目标对象标题]
    */
    public ReviewContent setTargetTitle(String targetTitle) {
        this.targetTitle = targetTitle;
        this.modify("target_title", targetTitle);
        return this;
    }

    /**
    * 设置 [目标对象状态]
    */
    public ReviewContent setTargetState(String targetState) {
        this.targetState = targetState;
        this.modify("target_state", targetState);
        return this;
    }

    /**
    * 设置 [目标对象负责人]
    */
    public ReviewContent setTargetAssignee(String targetAssignee) {
        this.targetAssignee = targetAssignee;
        this.modify("target_assignee", targetAssignee);
        return this;
    }

    /**
    * 设置 [关联目标版本]
    */
    public ReviewContent setTargetVersion(Version targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
    * 设置 [目标对象优先级]
    */
    public ReviewContent setTargetPriority(String targetPriority) {
        this.targetPriority = targetPriority;
        this.modify("target_priority", targetPriority);
        return this;
    }

    /**
    * 设置 [目标对象父标识]
    */
    public ReviewContent setTargetParentId(String targetParentId) {
        this.targetParentId = targetParentId;
        this.modify("target_parent_id", targetParentId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public ReviewContent setName(String name) {
        this.name = name;
        this.modify("name", name);
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