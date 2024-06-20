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
 * 基线需求[BaselineIdeaDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("基线需求DTO")
public class BaselineIdeaDTO extends DTOBase implements Serializable {

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
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 7)
    private String title;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 8)
    private String state;

    /**
     * 负责人
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人", position = 9)
    private String assigneeId;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 10)
    private String assigneeName;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 11)
    private String curVersionId;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 12)
    private String priority;

    /**
     * 产品
     */
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(value = "产品", position = 13)
    private String productId;

    /**
     * 关联目标版本
     */
    @JsonProperty("target_version")
    @JSONField(name = "target_version")
    @ApiModelProperty(value = "关联目标版本", position = 14)
    private VersionDTO targetVersion;

    /**
     * 需求类型
     */
    @JsonProperty("idea_type")
    @JSONField(name = "idea_type")
    @ApiModelProperty(value = "需求类型", position = 15)
    private String ideaType;

    /**
     * 需求来源
     */
    @JsonProperty("idea_from")
    @JSONField(name = "idea_from")
    @ApiModelProperty(value = "需求来源", position = 16)
    private String ideaFrom;

    /**
     * 实际开始时间
     */
    @JsonProperty("real_at_from")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际开始时间", position = 17)
    private Date realAtFrom;

    /**
     * 进度
     */
    @JsonProperty("progress")
    @JSONField(name = "progress")
    @ApiModelProperty(value = "进度", position = 18)
    private BigDecimal progress;

    /**
     * 计划时间周期单位
     */
    @JsonProperty("plan_at_granularity")
    @JSONField(name = "plan_at_granularity")
    @ApiModelProperty(value = "计划时间周期单位", position = 19)
    private String planAtGranularity;

    /**
     * 计划时间
     */
    @JsonProperty("plan_at")
    @JSONField(name = "plan_at")
    @ApiModelProperty(value = "计划时间", position = 20)
    private String planAt;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 21)
    private String identifier;

    /**
     * 实际时间
     */
    @JsonProperty("real_at")
    @JSONField(name = "real_at")
    @ApiModelProperty(value = "实际时间", position = 22)
    private String realAt;

    /**
     * 类别标识
     */
    @JsonProperty("category_id")
    @JSONField(name = "category_id")
    @ApiModelProperty(value = "类别标识", position = 23)
    private String categoryId;

    /**
     * 实际结束时间
     */
    @JsonProperty("real_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际结束时间", position = 24)
    private Date realAtTo;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 25)
    private String description;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 26)
    private String isDeleted;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 27)
    private String isArchived;

    /**
     * 计划结束时间
     */
    @JsonProperty("plan_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划结束时间", position = 28)
    private Date planAtTo;

    /**
     * 基线
     */
    @JsonProperty("baseline")
    @JSONField(name = "baseline")
    @ApiModelProperty(value = "基线", position = 29)
    private BaselineDTO baseline;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 30)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 31)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 32)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 33)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 34)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 35)
    private Date updateTime;


    /**
     * 设置 [关联主体标识]
     */
    public BaselineIdeaDTO setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
     * 设置 [所属数据对象]
     */
    public BaselineIdeaDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [关联主体类型]
     */
    public BaselineIdeaDTO setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
     * 设置 [关联目标类型]
     */
    public BaselineIdeaDTO setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
     * 设置 [关联目标标识]
     */
    public BaselineIdeaDTO setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
     * 设置 [目标对象版本标识]
     */
    public BaselineIdeaDTO setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public BaselineIdeaDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public BaselineIdeaDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public BaselineIdeaDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public BaselineIdeaDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public BaselineIdeaDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public BaselineIdeaDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [产品]
     */
    public BaselineIdeaDTO setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
     * 设置 [关联目标版本]
     */
    public BaselineIdeaDTO setTargetVersion(VersionDTO targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
     * 设置 [需求类型]
     */
    public BaselineIdeaDTO setIdeaType(String ideaType) {
        this.ideaType = ideaType;
        this.modify("idea_type", ideaType);
        return this;
    }

    /**
     * 设置 [需求来源]
     */
    public BaselineIdeaDTO setIdeaFrom(String ideaFrom) {
        this.ideaFrom = ideaFrom;
        this.modify("idea_from", ideaFrom);
        return this;
    }

    /**
     * 设置 [实际开始时间]
     */
    public BaselineIdeaDTO setRealAtFrom(Date realAtFrom) {
        this.realAtFrom = realAtFrom;
        this.modify("real_at_from", realAtFrom);
        return this;
    }

    /**
     * 设置 [进度]
     */
    public BaselineIdeaDTO setProgress(BigDecimal progress) {
        this.progress = progress;
        this.modify("progress", progress);
        return this;
    }

    /**
     * 设置 [计划时间周期单位]
     */
    public BaselineIdeaDTO setPlanAtGranularity(String planAtGranularity) {
        this.planAtGranularity = planAtGranularity;
        this.modify("plan_at_granularity", planAtGranularity);
        return this;
    }

    /**
     * 设置 [计划时间]
     */
    public BaselineIdeaDTO setPlanAt(String planAt) {
        this.planAt = planAt;
        this.modify("plan_at", planAt);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public BaselineIdeaDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [实际时间]
     */
    public BaselineIdeaDTO setRealAt(String realAt) {
        this.realAt = realAt;
        this.modify("real_at", realAt);
        return this;
    }

    /**
     * 设置 [类别标识]
     */
    public BaselineIdeaDTO setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        this.modify("category_id", categoryId);
        return this;
    }

    /**
     * 设置 [实际结束时间]
     */
    public BaselineIdeaDTO setRealAtTo(Date realAtTo) {
        this.realAtTo = realAtTo;
        this.modify("real_at_to", realAtTo);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public BaselineIdeaDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public BaselineIdeaDTO setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public BaselineIdeaDTO setIsArchived(String isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [计划结束时间]
     */
    public BaselineIdeaDTO setPlanAtTo(Date planAtTo) {
        this.planAtTo = planAtTo;
        this.modify("plan_at_to", planAtTo);
        return this;
    }

    /**
     * 设置 [基线]
     */
    public BaselineIdeaDTO setBaseline(BaselineDTO baseline) {
        this.baseline = baseline;
        this.modify("baseline", baseline);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public BaselineIdeaDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
