/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@MINHERIT}}.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 基线需求实体类[BaselineIdea]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "BASELINE_IDEA", description = "基线需求")
public class BaselineIdea extends EntityBase implements Serializable
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
     * 关联主体类型
     */
    @DEField(name = "principal_type")
    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    @ApiModelProperty(value = "principal_type", notes = "关联主体类型")
    private String principalType;

    /**
     * 所属数据对象
     */
    @DEField(name = "owner_type")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

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
     * 负责人
     */
    @DEField(name = "assignee_id")
    @JSONField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人")
    private String assigneeId;

    /**
     * 负责人
     */
    @DEField(name = "assignee_name")
    @JSONField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
     * 当前版本标识
     */
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
     * 优先级
     */
    @DEField(name = "priority")
    @JSONField(name = "priority")
    @JsonProperty("priority")
    @ApiModelProperty(value = "priority", notes = "优先级")
    private String priority;

    /**
     * 产品
     */
    @DEField(name = "product_id")
    @JSONField(name = "product_id")
    @JsonProperty("product_id")
    @ApiModelProperty(value = "product_id", notes = "产品")
    private String productId;

    /**
     * 关联目标版本
     */
    @DEField(name = "target_version")
    @JSONField(name = "target_version")
    @JsonProperty("target_version")
    @ApiModelProperty(value = "target_version", notes = "关联目标版本")
    private Version targetVersion;

    /**
     * 需求类型
     */
    @DEField(name = "idea_type" , dict = "requirement_type")
    @JSONField(name = "idea_type")
    @JsonProperty("idea_type")
    @ApiModelProperty(value = "idea_type", notes = "需求类型")
    private String ideaType;

    /**
     * 需求来源
     */
    @DEField(name = "idea_from")
    @JSONField(name = "idea_from")
    @JsonProperty("idea_from")
    @ApiModelProperty(value = "idea_from", notes = "需求来源")
    private String ideaFrom;

    /**
     * 实际开始时间
     */
    @DEField(name = "real_at_from")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("real_at_from")
    @ApiModelProperty(value = "real_at_from", notes = "实际开始时间")
    private Date realAtFrom;

    /**
     * 进度
     */
    @DEField(name = "progress")
    @JSONField(name = "progress")
    @JsonProperty("progress")
    @ApiModelProperty(value = "progress", notes = "进度")
    private BigDecimal progress;

    /**
     * 计划时间周期单位
     */
    @DEField(name = "plan_at_granularity")
    @JSONField(name = "plan_at_granularity")
    @JsonProperty("plan_at_granularity")
    @ApiModelProperty(value = "plan_at_granularity", notes = "计划时间周期单位")
    private String planAtGranularity;

    /**
     * 计划时间
     */
    @DEField(name = "plan_at")
    @JSONField(name = "plan_at")
    @JsonProperty("plan_at")
    @ApiModelProperty(value = "plan_at", notes = "计划时间")
    private String planAt;

    /**
     * 编号
     */
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 实际时间
     */
    @DEField(name = "real_at")
    @JSONField(name = "real_at")
    @JsonProperty("real_at")
    @ApiModelProperty(value = "real_at", notes = "实际时间")
    private String realAt;

    /**
     * 类别标识
     */
    @DEField(name = "category_id")
    @JSONField(name = "category_id")
    @JsonProperty("category_id")
    @ApiModelProperty(value = "category_id", notes = "类别标识")
    private String categoryId;

    /**
     * 实际结束时间
     */
    @DEField(name = "real_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("real_at_to")
    @ApiModelProperty(value = "real_at_to", notes = "实际结束时间")
    private Date realAtTo;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

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
     * 计划结束时间
     */
    @DEField(name = "plan_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("plan_at_to")
    @ApiModelProperty(value = "plan_at_to", notes = "计划结束时间")
    private Date planAtTo;

    /**
     * 基线
     */
    @DEField(name = "baseline")
    @JSONField(name = "baseline")
    @JsonProperty("baseline")
    @ApiModelProperty(value = "baseline", notes = "基线")
    private Baseline baseline;

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
     * 基线-关联需求
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "baseline_principal_idea", notes = "基线-关联需求")
    private Baseline baselinePrincipalIdea;

    /**
    * 设置 [关联主体标识]
    */
    public BaselineIdea setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
    * 设置 [关联主体类型]
    */
    public BaselineIdea setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
    * 设置 [所属数据对象]
    */
    public BaselineIdea setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [关联目标类型]
    */
    public BaselineIdea setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
    * 设置 [关联目标标识]
    */
    public BaselineIdea setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
    * 设置 [目标对象版本标识]
    */
    public BaselineIdea setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public BaselineIdea setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public BaselineIdea setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public BaselineIdea setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public BaselineIdea setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public BaselineIdea setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
    * 设置 [优先级]
    */
    public BaselineIdea setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
    * 设置 [产品]
    */
    public BaselineIdea setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
    * 设置 [关联目标版本]
    */
    public BaselineIdea setTargetVersion(Version targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
    * 设置 [需求类型]
    */
    public BaselineIdea setIdeaType(String ideaType) {
        this.ideaType = ideaType;
        this.modify("idea_type", ideaType);
        return this;
    }

    /**
    * 设置 [需求来源]
    */
    public BaselineIdea setIdeaFrom(String ideaFrom) {
        this.ideaFrom = ideaFrom;
        this.modify("idea_from", ideaFrom);
        return this;
    }

    /**
    * 设置 [实际开始时间]
    */
    public BaselineIdea setRealAtFrom(Date realAtFrom) {
        this.realAtFrom = realAtFrom;
        this.modify("real_at_from", realAtFrom);
        return this;
    }

    /**
    * 设置 [进度]
    */
    public BaselineIdea setProgress(BigDecimal progress) {
        this.progress = progress;
        this.modify("progress", progress);
        return this;
    }

    /**
    * 设置 [计划时间周期单位]
    */
    public BaselineIdea setPlanAtGranularity(String planAtGranularity) {
        this.planAtGranularity = planAtGranularity;
        this.modify("plan_at_granularity", planAtGranularity);
        return this;
    }

    /**
    * 设置 [计划时间]
    */
    public BaselineIdea setPlanAt(String planAt) {
        this.planAt = planAt;
        this.modify("plan_at", planAt);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public BaselineIdea setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [实际时间]
    */
    public BaselineIdea setRealAt(String realAt) {
        this.realAt = realAt;
        this.modify("real_at", realAt);
        return this;
    }

    /**
    * 设置 [类别标识]
    */
    public BaselineIdea setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        this.modify("category_id", categoryId);
        return this;
    }

    /**
    * 设置 [实际结束时间]
    */
    public BaselineIdea setRealAtTo(Date realAtTo) {
        this.realAtTo = realAtTo;
        this.modify("real_at_to", realAtTo);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public BaselineIdea setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public BaselineIdea setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public BaselineIdea setIsArchived(String isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [计划结束时间]
    */
    public BaselineIdea setPlanAtTo(Date planAtTo) {
        this.planAtTo = planAtTo;
        this.modify("plan_at_to", planAtTo);
        return this;
    }

    /**
    * 设置 [基线]
    */
    public BaselineIdea setBaseline(Baseline baseline) {
        this.baseline = baseline;
        this.modify("baseline", baseline);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public BaselineIdea setName(String name) {
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