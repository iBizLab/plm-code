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
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.domain.Baseline;

/**
 * 基线用例实体类[BaselineTestCase]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "BASELINE_TEST_CASE", description = "基线用例")
public class BaselineTestCase extends EntityBase implements Serializable
{
    /**
     * 关联主体标识
     */
    @DEField(name = "principal_id")
    @JSONField(name = "principal_id")
    @JsonProperty("principal_id")
    @ApiModelProperty(value = "principal_id", notes = "关联主体标识")
    private String principalId;

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
    @DEField(name = "principal_type")
    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    @ApiModelProperty(value = "principal_type", notes = "关联主体类型")
    private String principalType;

    /**
     * 关联目标类型
     */
    @DEField(name = "target_type")
    @JSONField(name = "target_type")
    @JsonProperty("target_type")
    @ApiModelProperty(value = "target_type", notes = "关联目标类型")
    private String targetType;

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
     * 编号
     */
    @DEField(name = "show_identifier")
    @JSONField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
     * 维护人
     */
    @DEField(name = "maintenance_id")
    @JSONField(name = "maintenance_id")
    @JsonProperty("maintenance_id")
    @ApiModelProperty(value = "maintenance_id", notes = "维护人")
    private String maintenanceId;

    /**
     * 标题
     */
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
     * 状态
     */
    @DEField(name = "state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "状态")
    private String state;

    /**
     * 维护人
     */
    @DEField(name = "maintenance_name")
    @JSONField(name = "maintenance_name")
    @JsonProperty("maintenance_name")
    @ApiModelProperty(value = "maintenance_name", notes = "维护人")
    private String maintenanceName;

    /**
     * 测试库
     */
    @DEField(name = "test_library_id")
    @JSONField(name = "test_library_id")
    @JsonProperty("test_library_id")
    @ApiModelProperty(value = "test_library_id", notes = "测试库")
    private String testLibraryId;

    /**
     * 当前版本标识
     */
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
     * 重要程度
     */
    @DEField(name = "level" , dict = "test_case_level")
    @JSONField(name = "level")
    @JsonProperty("level")
    @ApiModelProperty(value = "level", notes = "重要程度")
    private String level;

    /**
     * 用例类型
     */
    @DEField(name = "type" , dict = "test_case_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "用例类型")
    private String type;

    /**
     * 关联目标版本
     */
    @DEField(name = "target_version")
    @JSONField(name = "target_version")
    @JsonProperty("target_version")
    @ApiModelProperty(value = "target_version", notes = "关联目标版本")
    private Version targetVersion;

    /**
     * 前置条件
     */
    @DEField(name = "precondition")
    @JSONField(name = "precondition")
    @JsonProperty("precondition")
    @ApiModelProperty(value = "precondition", notes = "前置条件")
    private String precondition;

    /**
     * 评审结果
     */
    @DEField(name = "review_result_state")
    @JSONField(name = "review_result_state")
    @JsonProperty("review_result_state")
    @ApiModelProperty(value = "review_result_state", notes = "评审结果")
    private String reviewResultState;

    /**
     * 测试类型
     */
    @DEField(name = "test_type" , dict = "test_case_test_type")
    @JSONField(name = "test_type")
    @JsonProperty("test_type")
    @ApiModelProperty(value = "test_type", notes = "测试类型")
    private String testType;

    /**
     * 编号
     */
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 用例模块标识
     */
    @DEField(name = "suite_id")
    @JSONField(name = "suite_id")
    @JsonProperty("suite_id")
    @ApiModelProperty(value = "suite_id", notes = "用例模块标识")
    private String suiteId;

    /**
     * 所属测试库
     */
    @DEField(name = "test_library_name")
    @JSONField(name = "test_library_name")
    @JsonProperty("test_library_name")
    @ApiModelProperty(value = "test_library_name", notes = "所属测试库")
    private String testLibraryName;

    /**
     * 基线
     */
    @DEField(name = "baseline")
    @JSONField(name = "baseline")
    @JsonProperty("baseline")
    @ApiModelProperty(value = "baseline", notes = "基线")
    private Baseline baseline;

    /**
     * 是否已删除
     */
    @DEField(name = "is_deleted")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private String isDeleted;

    /**
     * 是否已归档
     */
    @DEField(name = "is_archived")
    @JSONField(name = "is_archived")
    @JsonProperty("is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private String isArchived;

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
     * 基线-关联用例
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "baseline_principal_test_case", notes = "基线-关联用例")
    private Baseline baselinePrincipalTestCase;

    /**
    * 设置 [关联主体标识]
    */
    public BaselineTestCase setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
    * 设置 [所属数据对象]
    */
    public BaselineTestCase setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [关联主体类型]
    */
    public BaselineTestCase setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
    * 设置 [关联目标类型]
    */
    public BaselineTestCase setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
    * 设置 [关联目标标识]
    */
    public BaselineTestCase setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
    * 设置 [目标对象版本标识]
    */
    public BaselineTestCase setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public BaselineTestCase setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [维护人]
    */
    public BaselineTestCase setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
        this.modify("maintenance_id", maintenanceId);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public BaselineTestCase setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public BaselineTestCase setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [维护人]
    */
    public BaselineTestCase setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }

    /**
    * 设置 [测试库]
    */
    public BaselineTestCase setTestLibraryId(String testLibraryId) {
        this.testLibraryId = testLibraryId;
        this.modify("test_library_id", testLibraryId);
        return this;
    }

    /**
    * 设置 [重要程度]
    */
    public BaselineTestCase setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
    * 设置 [用例类型]
    */
    public BaselineTestCase setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [关联目标版本]
    */
    public BaselineTestCase setTargetVersion(Version targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
    * 设置 [前置条件]
    */
    public BaselineTestCase setPrecondition(String precondition) {
        this.precondition = precondition;
        this.modify("precondition", precondition);
        return this;
    }

    /**
    * 设置 [评审结果]
    */
    public BaselineTestCase setReviewResultState(String reviewResultState) {
        this.reviewResultState = reviewResultState;
        this.modify("review_result_state", reviewResultState);
        return this;
    }

    /**
    * 设置 [测试类型]
    */
    public BaselineTestCase setTestType(String testType) {
        this.testType = testType;
        this.modify("test_type", testType);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public BaselineTestCase setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public BaselineTestCase setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [用例模块标识]
    */
    public BaselineTestCase setSuiteId(String suiteId) {
        this.suiteId = suiteId;
        this.modify("suite_id", suiteId);
        return this;
    }

    /**
    * 设置 [所属测试库]
    */
    public BaselineTestCase setTestLibraryName(String testLibraryName) {
        this.testLibraryName = testLibraryName;
        this.modify("test_library_name", testLibraryName);
        return this;
    }

    /**
    * 设置 [基线]
    */
    public BaselineTestCase setBaseline(Baseline baseline) {
        this.baseline = baseline;
        this.modify("baseline", baseline);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public BaselineTestCase setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public BaselineTestCase setIsArchived(String isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public BaselineTestCase setName(String name) {
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