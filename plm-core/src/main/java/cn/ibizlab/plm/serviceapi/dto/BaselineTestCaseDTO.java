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
 * 基线用例[BaselineTestCaseDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("基线用例DTO")
public class BaselineTestCaseDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联主体标识
     */
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "关联主体标识", position = 0)
    private String principalId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 1)
    private String ownerType;

    /**
     * 关联主体类型
     */
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "关联主体类型", position = 2)
    private String principalType;

    /**
     * 关联目标类型
     */
    @JsonProperty("target_type")
    @JSONField(name = "target_type")
    @ApiModelProperty(value = "关联目标类型", position = 3)
    private String targetType;

    /**
     * 关联目标标识
     */
    @JsonProperty("target_id")
    @JSONField(name = "target_id")
    @ApiModelProperty(value = "关联目标标识", position = 4)
    private String targetId;

    /**
     * 目标对象版本标识
     */
    @JsonProperty("target_version_id")
    @JSONField(name = "target_version_id")
    @ApiModelProperty(value = "目标对象版本标识", position = 5)
    private String targetVersionId;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 6)
    private String showIdentifier;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_id")
    @JSONField(name = "maintenance_id")
    @ApiModelProperty(value = "维护人", position = 7)
    private String maintenanceId;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 8)
    private String title;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 9)
    private String state;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_name")
    @JSONField(name = "maintenance_name")
    @ApiModelProperty(value = "维护人", position = 10)
    private String maintenanceName;

    /**
     * 测试库
     */
    @JsonProperty("test_library_id")
    @JSONField(name = "test_library_id")
    @ApiModelProperty(value = "测试库", position = 11)
    private String testLibraryId;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 12)
    private String curVersionId;

    /**
     * 重要程度
     */
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "重要程度", position = 13)
    private String level;

    /**
     * 用例类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "用例类型", position = 14)
    private String type;

    /**
     * 关联目标版本
     */
    @JsonProperty("target_version")
    @JSONField(name = "target_version")
    @ApiModelProperty(value = "关联目标版本", position = 15)
    private VersionDTO targetVersion;

    /**
     * 前置条件
     */
    @JsonProperty("precondition")
    @JSONField(name = "precondition")
    @ApiModelProperty(value = "前置条件", position = 16)
    private String precondition;

    /**
     * 评审结果
     */
    @JsonProperty("review_result_state")
    @JSONField(name = "review_result_state")
    @ApiModelProperty(value = "评审结果", position = 17)
    private String reviewResultState;

    /**
     * 测试类型
     */
    @JsonProperty("test_type")
    @JSONField(name = "test_type")
    @ApiModelProperty(value = "测试类型", position = 18)
    private String testType;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 19)
    private String identifier;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 20)
    private String description;

    /**
     * 用例模块标识
     */
    @JsonProperty("suite_id")
    @JSONField(name = "suite_id")
    @ApiModelProperty(value = "用例模块标识", position = 21)
    private String suiteId;

    /**
     * 所属测试库
     */
    @JsonProperty("test_library_name")
    @JSONField(name = "test_library_name")
    @ApiModelProperty(value = "所属测试库", position = 22)
    private String testLibraryName;

    /**
     * 基线
     */
    @JsonProperty("baseline")
    @JSONField(name = "baseline")
    @ApiModelProperty(value = "基线", position = 23)
    private BaselineDTO baseline;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 24)
    private String isDeleted;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 25)
    private String isArchived;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 26)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 27)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 28)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 29)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 30)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 31)
    private Date updateTime;


    /**
     * 设置 [关联主体标识]
     */
    public BaselineTestCaseDTO setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
     * 设置 [所属数据对象]
     */
    public BaselineTestCaseDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [关联主体类型]
     */
    public BaselineTestCaseDTO setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
     * 设置 [关联目标类型]
     */
    public BaselineTestCaseDTO setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
     * 设置 [关联目标标识]
     */
    public BaselineTestCaseDTO setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
     * 设置 [目标对象版本标识]
     */
    public BaselineTestCaseDTO setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public BaselineTestCaseDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public BaselineTestCaseDTO setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
        this.modify("maintenance_id", maintenanceId);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public BaselineTestCaseDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public BaselineTestCaseDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public BaselineTestCaseDTO setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
     * 设置 [测试库]
     */
    public BaselineTestCaseDTO setTestLibraryId(String testLibraryId) {
        this.testLibraryId = testLibraryId;
        this.modify("test_library_id", testLibraryId);
        return this;
    }

    /**
     * 设置 [重要程度]
     */
    public BaselineTestCaseDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [用例类型]
     */
    public BaselineTestCaseDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [关联目标版本]
     */
    public BaselineTestCaseDTO setTargetVersion(VersionDTO targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
     * 设置 [前置条件]
     */
    public BaselineTestCaseDTO setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
     * 设置 [评审结果]
     */
    public BaselineTestCaseDTO setReviewResultState(String reviewResultState) {
        this.reviewResultState = reviewResultState;
        this.modify("review_result_state", reviewResultState);
        return this;
    }

    /**
     * 设置 [测试类型]
     */
    public BaselineTestCaseDTO setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public BaselineTestCaseDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public BaselineTestCaseDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [用例模块标识]
     */
    public BaselineTestCaseDTO setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public BaselineTestCaseDTO setTestLibraryName(String testLibraryName) {
        this.testLibraryName = testLibraryName;
        this.modify("test_library_name", testLibraryName);
        return this;
    }

    /**
     * 设置 [基线]
     */
    public BaselineTestCaseDTO setBaseline(BaselineDTO baseline) {
        this.baseline = baseline;
        this.modify("baseline", baseline);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public BaselineTestCaseDTO setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public BaselineTestCaseDTO setIsArchived(String isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public BaselineTestCaseDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
