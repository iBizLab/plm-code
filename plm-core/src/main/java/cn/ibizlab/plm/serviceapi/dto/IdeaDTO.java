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
 * 需求[IdeaDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("需求DTO")
public class IdeaDTO extends DTOBase implements Serializable {

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
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 2)
    private String state;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 3)
    private String priority;

    /**
     * 模块
     */
    @JsonProperty("suite")
    @JSONField(name = "suite")
    @ApiModelProperty(value = "模块", position = 4)
    private String suite;

    /**
     * 计划时间
     */
    @JsonProperty("plan_at")
    @JSONField(name = "plan_at")
    @ApiModelProperty(value = "计划时间", position = 5)
    private String planAt;

    /**
     * 计划开始时间
     */
    @JsonProperty("plan_at_from")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划开始时间", position = 6)
    private Date planAtFrom;

    /**
     * 计划结束时间
     */
    @JsonProperty("plan_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划结束时间", position = 7)
    private Date planAtTo;

    /**
     * 计划时间周期单位
     */
    @JsonProperty("plan_at_granularity")
    @JSONField(name = "plan_at_granularity")
    @ApiModelProperty(value = "计划时间周期单位", position = 8)
    private String planAtGranularity;

    /**
     * 实际时间
     */
    @JsonProperty("real_at")
    @JSONField(name = "real_at")
    @ApiModelProperty(value = "实际时间", position = 9)
    private String realAt;

    /**
     * 实际开始时间
     */
    @JsonProperty("real_at_from")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际开始时间", position = 10)
    private Date realAtFrom;

    /**
     * 实际结束时间
     */
    @JsonProperty("real_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际结束时间", position = 11)
    private Date realAtTo;

    /**
     * 计划时间周期单位
     */
    @JsonProperty("real_at_granularity")
    @JSONField(name = "real_at_granularity")
    @ApiModelProperty(value = "计划时间周期单位", position = 12)
    private String realAtGranularity;

    /**
     * 进度
     */
    @JsonProperty("progress")
    @JSONField(name = "progress")
    @ApiModelProperty(value = "进度", position = 13)
    private BigDecimal progress;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 14)
    private String description;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 15)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 16)
    private Integer isDeleted;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 17)
    private String assigneeName;

    /**
     * 产品标识
     */
    @JsonProperty("product_identifier")
    @JSONField(name = "product_identifier")
    @ApiModelProperty(value = "产品标识", position = 18)
    private String productIdentifier;

    /**
     * 负责人
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人", position = 19)
    private String assigneeId;

    /**
     * 子产品名称
     */
    @JsonProperty("section_name")
    @JSONField(name = "section_name")
    @ApiModelProperty(value = "子产品名称", position = 20)
    private String sectionName;

    /**
     * 附件
     */
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "附件", position = 21)
    private List<AttachmentDTO> attachments;

    /**
     * 子产品标识
     */
    @JsonProperty("section_id")
    @JSONField(name = "section_id")
    @ApiModelProperty(value = "子产品标识", position = 22)
    private String sectionId;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 23)
    private List<AttentionDTO> attentions;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 24)
    private String showIdentifier;

    /**
     * 类别路径
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别路径", position = 25)
    private String categories;

    /**
     * 工时进度
     */
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "工时进度", position = 26)
    private BigDecimal workloadSchedule;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 27)
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 28)
    private BigDecimal remainingWorkload;

    /**
     * 实际工时
     */
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "实际工时", position = 29)
    private BigDecimal actualWorkload;

    /**
     * 类别标识
     */
    @JsonProperty("category_id")
    @JSONField(name = "category_id")
    @ApiModelProperty(value = "类别标识", position = 30)
    private String categoryId;

    /**
     * 名称
     */
    @JsonProperty("category_name")
    @JSONField(name = "category_name")
    @ApiModelProperty(value = "名称", position = 31)
    private String categoryName;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 32)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 33)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 34)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 35)
    private String name;

    /**
     * 产品
     */
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(value = "产品", position = 36)
    private String productId;

    /**
     * 所属产品
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(value = "所属产品", position = 37)
    private String productName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 38)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 39)
    private Date updateTime;


    /**
     * 设置 [编号]
     */
    public IdeaDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public IdeaDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public IdeaDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public IdeaDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [模块]
     */
    public IdeaDTO setSuite(String suite) {
        this.suite = suite;
        this.modify("suite", suite);
        return this;
    }

    /**
     * 设置 [计划时间]
     */
    public IdeaDTO setPlanAt(String planAt) {
        this.planAt = planAt;
        this.modify("plan_at", planAt);
        return this;
    }

    /**
     * 设置 [计划开始时间]
     */
    public IdeaDTO setPlanAtFrom(Date planAtFrom) {
        this.planAtFrom = planAtFrom;
        this.modify("plan_at_from", planAtFrom);
        return this;
    }

    /**
     * 设置 [计划结束时间]
     */
    public IdeaDTO setPlanAtTo(Date planAtTo) {
        this.planAtTo = planAtTo;
        this.modify("plan_at_to", planAtTo);
        return this;
    }

    /**
     * 设置 [计划时间周期单位]
     */
    public IdeaDTO setPlanAtGranularity(String planAtGranularity) {
        this.planAtGranularity = planAtGranularity;
        this.modify("plan_at_granularity", planAtGranularity);
        return this;
    }

    /**
     * 设置 [实际时间]
     */
    public IdeaDTO setRealAt(String realAt) {
        this.realAt = realAt;
        this.modify("real_at", realAt);
        return this;
    }

    /**
     * 设置 [实际开始时间]
     */
    public IdeaDTO setRealAtFrom(Date realAtFrom) {
        this.realAtFrom = realAtFrom;
        this.modify("real_at_from", realAtFrom);
        return this;
    }

    /**
     * 设置 [实际结束时间]
     */
    public IdeaDTO setRealAtTo(Date realAtTo) {
        this.realAtTo = realAtTo;
        this.modify("real_at_to", realAtTo);
        return this;
    }

    /**
     * 设置 [计划时间周期单位]
     */
    public IdeaDTO setRealAtGranularity(String realAtGranularity) {
        this.realAtGranularity = realAtGranularity;
        this.modify("real_at_granularity", realAtGranularity);
        return this;
    }

    /**
     * 设置 [进度]
     */
    public IdeaDTO setProgress(BigDecimal progress) {
        this.progress = progress;
        this.modify("progress", progress);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public IdeaDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public IdeaDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public IdeaDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public IdeaDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [产品标识]
     */
    public IdeaDTO setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
        this.modify("product_identifier", productIdentifier);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public IdeaDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [子产品名称]
     */
    public IdeaDTO setSectionName(String sectionName) {
        this.sectionName = sectionName;
        this.modify("section_name", sectionName);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public IdeaDTO setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [子产品标识]
     */
    public IdeaDTO setSectionId(String sectionId) {
        this.sectionId = sectionId;
        this.modify("section_id", sectionId);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public IdeaDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public IdeaDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [类别路径]
     */
    public IdeaDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public IdeaDTO setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public IdeaDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public IdeaDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public IdeaDTO setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [类别标识]
     */
    public IdeaDTO setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        this.modify("category_id", categoryId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public IdeaDTO setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        this.modify("category_name", categoryName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public IdeaDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [产品]
     */
    public IdeaDTO setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
     * 设置 [所属产品]
     */
    public IdeaDTO setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
        return this;
    }


}