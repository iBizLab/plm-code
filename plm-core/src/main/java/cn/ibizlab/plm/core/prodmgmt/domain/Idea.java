/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.domain;

import java.util.*;
import java.math.BigDecimal;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.Attention;

/**
 * 需求实体类[Idea]
 *
 * @author generator
 */
@Audit
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IDEA", resultMap = "IdeaResultMap")
@ApiModel(value = "IDEA", description = "需求")
public class Idea extends EntityMP implements Serializable
{

    /**
     * 编号
     */
    @TableField(value = "identifier")
    @DEField(name = "identifier" , dupCheck = DupCheck.ALL , dupCheckField = "productId")
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 标题
     */
    @TableField(value = "title")
    @DEField(name = "title")
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
     * 状态
     */
    @TableField(value = "state")
    @DEField(name = "state" , defaultValue = "10" , dict = "Idea_state")
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "state", notes = "状态")
    private String state;

    /**
     * 优先级
     */
    @TableField(value = "priority")
    @DEField(name = "priority" , dict = "Idea_priority")
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "priority", notes = "优先级")
    private String priority;

    /**
     * 模块
     */
    @TableField(value = "suite")
    @DEField(name = "suite")
    @JsonProperty("suite")
    @JSONField(name = "suite")
    @ApiModelProperty(value = "suite", notes = "模块")
    private String suite;

    /**
     * 计划时间
     */
    @TableField(value = "plan_at")
    @DEField(name = "plan_at")
    @JsonProperty("plan_at")
    @JSONField(name = "plan_at")
    @ApiModelProperty(value = "plan_at", notes = "计划时间")
    private String planAt;

    /**
     * 计划开始时间
     */
    @TableField(value = "plan_at_from")
    @DEField(name = "plan_at_from" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("plan_at_from")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "plan_at_from", notes = "计划开始时间")
    private Date planAtFrom;

    /**
     * 计划结束时间
     */
    @TableField(value = "plan_at_to")
    @DEField(name = "plan_at_to" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("plan_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "plan_at_to", notes = "计划结束时间")
    private Date planAtTo;

    /**
     * 计划时间周期单位
     */
    @TableField(value = "plan_at_granularity")
    @DEField(name = "plan_at_granularity")
    @JsonProperty("plan_at_granularity")
    @JSONField(name = "plan_at_granularity")
    @ApiModelProperty(value = "plan_at_granularity", notes = "计划时间周期单位")
    private String planAtGranularity;

    /**
     * 实际时间
     */
    @TableField(value = "real_at")
    @DEField(name = "real_at")
    @JsonProperty("real_at")
    @JSONField(name = "real_at")
    @ApiModelProperty(value = "real_at", notes = "实际时间")
    private String realAt;

    /**
     * 实际开始时间
     */
    @TableField(value = "real_at_from")
    @DEField(name = "real_at_from" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("real_at_from")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "real_at_from", notes = "实际开始时间")
    private Date realAtFrom;

    /**
     * 实际结束时间
     */
    @TableField(value = "real_at_to")
    @DEField(name = "real_at_to" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("real_at_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "real_at_to", notes = "实际结束时间")
    private Date realAtTo;

    /**
     * 计划时间周期单位
     */
    @TableField(value = "real_at_granularity")
    @DEField(name = "real_at_granularity")
    @JsonProperty("real_at_granularity")
    @JSONField(name = "real_at_granularity")
    @ApiModelProperty(value = "real_at_granularity", notes = "计划时间周期单位")
    private String realAtGranularity;

    /**
     * 进度
     */
    @TableField(value = "progress")
    @DEField(name = "progress")
    @JsonProperty("progress")
    @JSONField(name = "progress")
    @ApiModelProperty(value = "progress", notes = "进度")
    private BigDecimal progress;

    /**
     * 描述
     */
    @TableField(value = "description")
    @DEField(name = "description")
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 是否已归档
     */
    @TableField(value = "is_archived")
    @DEField(name = "is_archived" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
     * 产品标识
     */
    @TableField(value = "product_identifier" , exist = false)
    @DEField(name = "product_identifier")
    @JsonProperty("product_identifier")
    @JSONField(name = "product_identifier")
    @ApiModelProperty(value = "product_identifier", notes = "产品标识")
    private String productIdentifier;

    /**
     * 负责人
     */
    @TableField(value = "assignee_name")
    @DEField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
     * 负责人标识
     */
    @TableField(value = "assignee_id")
    @DEField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人标识")
    private String assigneeId;

    /**
     * 子产品名称
     */
    @TableField(value = "section_name" , exist = false)
    @DEField(name = "section_name")
    @JsonProperty("section_name")
    @JSONField(name = "section_name")
    @ApiModelProperty(value = "section_name", notes = "子产品名称")
    private String sectionName;

    /**
     * 附件
     */
    @TableField(exist = false)
    @DEField(name = "attachments")
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "attachments", notes = "附件")
    private List<Attachment> attachments;

    /**
     * 子产品标识
     */
    @TableField(value = "section_id" , exist = false)
    @DEField(name = "section_id")
    @JsonProperty("section_id")
    @JSONField(name = "section_id")
    @ApiModelProperty(value = "section_id", notes = "子产品标识")
    private String sectionId;

    /**
     * 关注
     */
    @TableField(exist = false)
    @DEField(name = "attentions")
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
     * 编号
     */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
     * 类别路径
     */
    @TableField(value = "categories" , exist = false)
    @DEField(name = "categories")
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "categories", notes = "类别路径")
    private String categories;

    /**
     * 工时进度
     */
    @TableField(value = "workload_schedule" , exist = false)
    @DEField(name = "workload_schedule")
    @JsonProperty("workload_schedule")
    @JSONField(name = "workload_schedule")
    @ApiModelProperty(value = "workload_schedule", notes = "工时进度")
    private BigDecimal workloadSchedule;

    /**
     * 预估工时
     */
    @TableField(value = "estimated_workload")
    @DEField(name = "estimated_workload")
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "estimated_workload", notes = "预估工时")
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @TableField(value = "remaining_workload")
    @DEField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

    /**
     * 实际工时
     */
    @TableField(value = "actual_workload" , exist = false)
    @DEField(name = "actual_workload")
    @JsonProperty("actual_workload")
    @JSONField(name = "actual_workload")
    @ApiModelProperty(value = "actual_workload", notes = "实际工时")
    private BigDecimal actualWorkload;

    /**
     * 标识
     */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 建立时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 产品标识
     */
    @TableField(value = "product_id")
    @DEField(name = "product_id")
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(value = "product_id", notes = "产品标识")
    private String productId;

    /**
     * 所属产品
     */
    @TableField(value = "product_name" , exist = false)
    @DEField(name = "product_name")
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(value = "product_name", notes = "所属产品")
    private String productName;

    /**
     * 类别标识
     */
    @TableField(value = "category_id")
    @DEField(name = "category_id")
    @JsonProperty("category_id")
    @JSONField(name = "category_id")
    @ApiModelProperty(value = "category_id", notes = "类别标识")
    private String categoryId;

    /**
     * 名称
     */
    @TableField(value = "category_name" , exist = false)
    @DEField(name = "category_name")
    @JsonProperty("category_name")
    @JSONField(name = "category_name")
    @ApiModelProperty(value = "category_name", notes = "名称")
    private String categoryName;

    /**
     * 类别
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "category", notes = "类别")
    private Category category;

    /**
     * 产品
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "product", notes = "产品-需求")
    private Product product;

    /**
     * 企业用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "user", notes = "负责人")
    private User user;

    /**
     * 设置 [编号]
     */
    public Idea setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public Idea setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public Idea setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public Idea setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [模块]
     */
    public Idea setSuite(String suite) {
        this.suite = suite;
        this.modify("suite", suite);
        return this;
    }

    /**
     * 设置 [计划时间]
     */
    public Idea setPlanAt(String planAt) {
        this.planAt = planAt;
        this.modify("plan_at", planAt);
        return this;
    }

    /**
     * 设置 [计划开始时间]
     */
    public Idea setPlanAtFrom(Date planAtFrom) {
        this.planAtFrom = planAtFrom;
        this.modify("plan_at_from", planAtFrom);
        return this;
    }

    /**
     * 设置 [计划结束时间]
     */
    public Idea setPlanAtTo(Date planAtTo) {
        this.planAtTo = planAtTo;
        this.modify("plan_at_to", planAtTo);
        return this;
    }

    /**
     * 设置 [计划时间周期单位]
     */
    public Idea setPlanAtGranularity(String planAtGranularity) {
        this.planAtGranularity = planAtGranularity;
        this.modify("plan_at_granularity", planAtGranularity);
        return this;
    }

    /**
     * 设置 [实际时间]
     */
    public Idea setRealAt(String realAt) {
        this.realAt = realAt;
        this.modify("real_at", realAt);
        return this;
    }

    /**
     * 设置 [实际开始时间]
     */
    public Idea setRealAtFrom(Date realAtFrom) {
        this.realAtFrom = realAtFrom;
        this.modify("real_at_from", realAtFrom);
        return this;
    }

    /**
     * 设置 [实际结束时间]
     */
    public Idea setRealAtTo(Date realAtTo) {
        this.realAtTo = realAtTo;
        this.modify("real_at_to", realAtTo);
        return this;
    }

    /**
     * 设置 [计划时间周期单位]
     */
    public Idea setRealAtGranularity(String realAtGranularity) {
        this.realAtGranularity = realAtGranularity;
        this.modify("real_at_granularity", realAtGranularity);
        return this;
    }

    /**
     * 设置 [进度]
     */
    public Idea setProgress(BigDecimal progress) {
        this.progress = progress;
        this.modify("progress", progress);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public Idea setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public Idea setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public Idea setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [产品标识]
     */
    public Idea setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
        this.modify("product_identifier", productIdentifier);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public Idea setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public Idea setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [子产品名称]
     */
    public Idea setSectionName(String sectionName) {
        this.sectionName = sectionName;
        this.modify("section_name", sectionName);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public Idea setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [子产品标识]
     */
    public Idea setSectionId(String sectionId) {
        this.sectionId = sectionId;
        this.modify("section_id", sectionId);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public Idea setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public Idea setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [类别路径]
     */
    public Idea setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [工时进度]
     */
    public Idea setWorkloadSchedule(BigDecimal workloadSchedule) {
        this.workloadSchedule = workloadSchedule;
        this.modify("workload_schedule", workloadSchedule);
        return this;
    }

    /**
     * 设置 [预估工时]
     */
    public Idea setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public Idea setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [实际工时]
     */
    public Idea setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public Idea setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [产品标识]
     */
    public Idea setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
     * 设置 [所属产品]
     */
    public Idea setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
        return this;
    }

    /**
     * 设置 [类别标识]
     */
    public Idea setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        this.modify("category_id", categoryId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public Idea setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        this.modify("category_name", categoryName);
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