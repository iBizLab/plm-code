/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
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
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Version;

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
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
    * 标题
    */
    @TableField(value = "title")
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
    * 状态
    */
    @TableField(value = "state")
    @DEField(name = "state" , defaultValue = "10" , dict = "idea_state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "状态")
    private String state;

    /**
    * 优先级
    */
    @TableField(value = "priority")
    @DEField(name = "priority" , dict = "idea_priority")
    @JSONField(name = "priority")
    @JsonProperty("priority")
    @ApiModelProperty(value = "priority", notes = "优先级")
    private String priority;

    /**
    * 模块
    */
    @TableField(value = "suite")
    @DEField(name = "suite")
    @JSONField(name = "suite")
    @JsonProperty("suite")
    @ApiModelProperty(value = "suite", notes = "模块")
    private String suite;

    /**
    * 计划时间
    */
    @TableField(value = "plan_at")
    @DEField(name = "plan_at")
    @JSONField(name = "plan_at")
    @JsonProperty("plan_at")
    @ApiModelProperty(value = "plan_at", notes = "计划时间")
    private String planAt;

    /**
    * 计划开始时间
    */
    @TableField(value = "plan_at_from")
    @DEField(name = "plan_at_from" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("plan_at_from")
    @ApiModelProperty(value = "plan_at_from", notes = "计划开始时间")
    private Date planAtFrom;

    /**
    * 计划结束时间
    */
    @TableField(value = "plan_at_to")
    @DEField(name = "plan_at_to" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "plan_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("plan_at_to")
    @ApiModelProperty(value = "plan_at_to", notes = "计划结束时间")
    private Date planAtTo;

    /**
    * 计划时间周期单位
    */
    @TableField(value = "plan_at_granularity")
    @DEField(name = "plan_at_granularity")
    @JSONField(name = "plan_at_granularity")
    @JsonProperty("plan_at_granularity")
    @ApiModelProperty(value = "plan_at_granularity", notes = "计划时间周期单位")
    private String planAtGranularity;

    /**
    * 实际时间
    */
    @TableField(value = "real_at")
    @DEField(name = "real_at")
    @JSONField(name = "real_at")
    @JsonProperty("real_at")
    @ApiModelProperty(value = "real_at", notes = "实际时间")
    private String realAt;

    /**
    * 实际开始时间
    */
    @TableField(value = "real_at_from")
    @DEField(name = "real_at_from" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_from" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("real_at_from")
    @ApiModelProperty(value = "real_at_from", notes = "实际开始时间")
    private Date realAtFrom;

    /**
    * 实际结束时间
    */
    @TableField(value = "real_at_to")
    @DEField(name = "real_at_to" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "real_at_to" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("real_at_to")
    @ApiModelProperty(value = "real_at_to", notes = "实际结束时间")
    private Date realAtTo;

    /**
    * 计划时间周期单位
    */
    @TableField(value = "real_at_granularity")
    @DEField(name = "real_at_granularity")
    @JSONField(name = "real_at_granularity")
    @JsonProperty("real_at_granularity")
    @ApiModelProperty(value = "real_at_granularity", notes = "计划时间周期单位")
    private String realAtGranularity;

    /**
    * 进度
    */
    @TableField(value = "progress")
    @DEField(name = "progress")
    @JSONField(name = "progress")
    @JsonProperty("progress")
    @ApiModelProperty(value = "progress", notes = "进度")
    private BigDecimal progress;

    /**
    * 描述
    */
    @TableField(value = "description")
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
    * 是否已归档
    */
    @TableField(value = "is_archived")
    @DEField(name = "is_archived" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_archived")
    @JsonProperty("is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private Integer isArchived;

    /**
    * 是否已删除
    */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
    * 产品标识
    */
    @TableField(value = "product_identifier" , exist = false)
    @DEField(name = "product_identifier")
    @JSONField(name = "product_identifier")
    @JsonProperty("product_identifier")
    @ApiModelProperty(value = "product_identifier", notes = "产品标识")
    private String productIdentifier;

    /**
    * 负责人
    */
    @TableField(value = "assignee_name")
    @DEField(name = "assignee_name")
    @JSONField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
    * 负责人
    */
    @TableField(value = "assignee_id")
    @DEField(name = "assignee_id")
    @JSONField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人")
    private String assigneeId;

    /**
    * 当前版本标识
    */
    @TableField(value = "cur_version_id")
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
    * 子产品名称
    */
    @TableField(value = "section_name" , exist = false)
    @DEField(name = "section_name")
    @JSONField(name = "section_name")
    @JsonProperty("section_name")
    @ApiModelProperty(value = "section_name", notes = "子产品名称")
    private String sectionName;

    /**
    * 附件
    */
    @TableField(exist = false)
    @DEField(name = "attachments")
    @JSONField(name = "attachments")
    @JsonProperty("attachments")
    @ApiModelProperty(value = "attachments", notes = "附件")
    private List<Attachment> attachments;

    /**
    * 子产品标识
    */
    @TableField(value = "section_id" , exist = false)
    @DEField(name = "section_id" , dict = "idea_section2")
    @JSONField(name = "section_id")
    @JsonProperty("section_id")
    @ApiModelProperty(value = "section_id", notes = "子产品标识")
    private String sectionId;

    /**
    * 关注
    */
    @TableField(exist = false)
    @DEField(name = "attentions" , dict = "SysOperator")
    @JSONField(name = "attentions")
    @JsonProperty("attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
    * 编号
    */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JSONField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
    * 类别路径
    */
    @TableField(value = "categories" , exist = false)
    @DEField(name = "categories")
    @JSONField(name = "categories")
    @JsonProperty("categories")
    @ApiModelProperty(value = "categories", notes = "类别路径")
    private String categories;

    /**
    * 需求来源
    */
    @TableField(value = "idea_from")
    @DEField(name = "idea_from" , dict = "demand_sources")
    @JSONField(name = "idea_from")
    @JsonProperty("idea_from")
    @ApiModelProperty(value = "idea_from", notes = "需求来源")
    private String ideaFrom;

    /**
    * 需求类型
    */
    @TableField(value = "idea_type")
    @DEField(name = "idea_type" , dict = "requirement_type")
    @JSONField(name = "idea_type")
    @JsonProperty("idea_type")
    @ApiModelProperty(value = "idea_type", notes = "需求类型")
    private String ideaType;

    /**
    * 关联产品需求数
    */
    @TableField(value = "relation_total_idea" , exist = false)
    @DEField(name = "relation_total_idea")
    @JSONField(name = "relation_total_idea")
    @JsonProperty("relation_total_idea")
    @ApiModelProperty(value = "relation_total_idea", notes = "关联产品需求数")
    private BigDecimal relationTotalIdea;

    /**
    * 关联工单数
    */
    @TableField(value = "relation_total_ticket" , exist = false)
    @DEField(name = "relation_total_ticket")
    @JSONField(name = "relation_total_ticket")
    @JsonProperty("relation_total_ticket")
    @ApiModelProperty(value = "relation_total_ticket", notes = "关联工单数")
    private BigDecimal relationTotalTicket;

    /**
    * 工时进度
    */
    @TableField(value = "workload_schedule" , exist = false)
    @DEField(name = "workload_schedule")
    @JSONField(name = "workload_schedule")
    @JsonProperty("workload_schedule")
    @ApiModelProperty(value = "workload_schedule", notes = "工时进度")
    private BigDecimal workloadSchedule;

    /**
    * 预估工时
    */
    @TableField(exist = false)
    @DEField(name = "estimated_workload")
    @JSONField(name = "estimated_workload")
    @JsonProperty("estimated_workload")
    @ApiModelProperty(value = "estimated_workload", notes = "预估工时")
    private BigDecimal estimatedWorkload;

    /**
    * 关联工作项数
    */
    @TableField(value = "relation_total_work_item" , exist = false)
    @DEField(name = "relation_total_work_item")
    @JSONField(name = "relation_total_work_item")
    @JsonProperty("relation_total_work_item")
    @ApiModelProperty(value = "relation_total_work_item", notes = "关联工作项数")
    private BigDecimal relationTotalWorkItem;

    /**
    * 关联测试用例数
    */
    @TableField(value = "relation_total_test_case" , exist = false)
    @DEField(name = "relation_total_test_case")
    @JSONField(name = "relation_total_test_case")
    @JsonProperty("relation_total_test_case")
    @ApiModelProperty(value = "relation_total_test_case", notes = "关联测试用例数")
    private BigDecimal relationTotalTestCase;

    /**
    * 剩余工时
    */
    @TableField(exist = false)
    @DEField(name = "remaining_workload")
    @JSONField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

    /**
    * 关联客户数
    */
    @TableField(value = "relation_total_customer" , exist = false)
    @DEField(name = "relation_total_customer")
    @JSONField(name = "relation_total_customer")
    @JsonProperty("relation_total_customer")
    @ApiModelProperty(value = "relation_total_customer", notes = "关联客户数")
    private BigDecimal relationTotalCustomer;

    /**
    * 实际工时
    */
    @TableField(exist = false)
    @DEField(name = "actual_workload")
    @JSONField(name = "actual_workload")
    @JsonProperty("actual_workload")
    @ApiModelProperty(value = "actual_workload", notes = "实际工时")
    private BigDecimal actualWorkload;

    /**
    * 关注数
    */
    @TableField(value = "attention_count" , exist = false)
    @DEField(name = "attention_count")
    @JSONField(name = "attention_count")
    @JsonProperty("attention_count")
    @ApiModelProperty(value = "attention_count", notes = "关注数")
    private String attentionCount;

    /**
    * 评论数
    */
    @TableField(value = "comment_count" , exist = false)
    @DEField(name = "comment_count")
    @JSONField(name = "comment_count")
    @JsonProperty("comment_count")
    @ApiModelProperty(value = "comment_count", notes = "评论数")
    private String commentCount;

    /**
    * 产品是否删除
    */
    @TableField(value = "product_is_deleted" , exist = false)
    @DEField(name = "product_is_deleted" , dict = "YesNo")
    @JSONField(name = "product_is_deleted")
    @JsonProperty("product_is_deleted")
    @ApiModelProperty(value = "product_is_deleted", notes = "产品是否删除")
    private Integer productIsDeleted;

    /**
    * 产品是否归档
    */
    @TableField(value = "product_is_archived" , exist = false)
    @DEField(name = "product_is_archived" , dict = "YesNo")
    @JSONField(name = "product_is_archived")
    @JsonProperty("product_is_archived")
    @ApiModelProperty(value = "product_is_archived", notes = "产品是否归档")
    private Integer productIsArchived;

    /**
    * 当前版本名称
    */
    @TableField(value = "cur_version_name" , exist = false)
    @DEField(name = "cur_version_name")
    @JSONField(name = "cur_version_name")
    @JsonProperty("cur_version_name")
    @ApiModelProperty(value = "cur_version_name", notes = "当前版本名称")
    private String curVersionName;

    /**
    * 选择版本标识
    */
    @TableField(value = "choose_version_id" , exist = false)
    @DEField(name = "choose_version_id")
    @JSONField(name = "choose_version_id")
    @JsonProperty("choose_version_id")
    @ApiModelProperty(value = "choose_version_id", notes = "选择版本标识")
    private String chooseVersionId;

    /**
    * 选择版本名称
    */
    @TableField(value = "choose_version_name" , exist = false)
    @DEField(name = "choose_version_name")
    @JSONField(name = "choose_version_name")
    @JsonProperty("choose_version_name")
    @ApiModelProperty(value = "choose_version_name", notes = "选择版本名称")
    private String chooseVersionName;

    /**
    * 关注人
    */
    @TableField(value = "attentions_imp" , exist = false)
    @DEField(name = "attentions_imp")
    @JSONField(name = "attentions_imp")
    @JsonProperty("attentions_imp")
    @ApiModelProperty(value = "attentions_imp", notes = "关注人")
    private String attentionsImp;

    /**
    * 最近创建日期
    */
    @TableField(value = "recent_create_days" , exist = false)
    @DEField(name = "recent_create_days")
    @JSONField(name = "recent_create_days")
    @JsonProperty("recent_create_days")
    @ApiModelProperty(value = "recent_create_days", notes = "最近创建日期")
    private Integer recentCreateDays;

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 产品
    */
    @TableField(value = "product_id")
    @DEField(name = "product_id")
    @JSONField(name = "product_id")
    @JsonProperty("product_id")
    @ApiModelProperty(value = "product_id", notes = "产品")
    private String productId;

    /**
    * 所属产品
    */
    @TableField(value = "product_name" , exist = false)
    @DEField(name = "product_name")
    @JSONField(name = "product_name")
    @JsonProperty("product_name")
    @ApiModelProperty(value = "product_name", notes = "所属产品")
    private String productName;

    /**
    * 类别标识
    */
    @TableField(value = "category_id")
    @DEField(name = "category_id")
    @JSONField(name = "category_id")
    @JsonProperty("category_id")
    @ApiModelProperty(value = "category_id", notes = "类别标识")
    private String categoryId;

    /**
    * 名称
    */
    @TableField(value = "category_name" , exist = false)
    @DEField(name = "category_name")
    @JSONField(name = "category_name")
    @JsonProperty("category_name")
    @ApiModelProperty(value = "category_name", notes = "名称")
    private String categoryName;

    /**
    * 类别
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "category", notes = "类别")
    private Category category;

    /**
    * 产品-需求
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "product", notes = "产品-需求")
    private Product product;

    /**
    * 负责人
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
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
    * 设置 [负责人]
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
    * 设置 [需求来源]
    */
    public Idea setIdeaFrom(String ideaFrom) {
        this.ideaFrom = ideaFrom;
        this.modify("idea_from", ideaFrom);
        return this;
    }

    /**
    * 设置 [需求类型]
    */
    public Idea setIdeaType(String ideaType) {
        this.ideaType = ideaType;
        this.modify("idea_type", ideaType);
        return this;
    }

    /**
    * 设置 [关联产品需求数]
    */
    public Idea setRelationTotalIdea(BigDecimal relationTotalIdea) {
        this.relationTotalIdea = relationTotalIdea;
        this.modify("relation_total_idea", relationTotalIdea);
        return this;
    }

    /**
    * 设置 [关联工单数]
    */
    public Idea setRelationTotalTicket(BigDecimal relationTotalTicket) {
        this.relationTotalTicket = relationTotalTicket;
        this.modify("relation_total_ticket", relationTotalTicket);
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
    * 设置 [关联工作项数]
    */
    public Idea setRelationTotalWorkItem(BigDecimal relationTotalWorkItem) {
        this.relationTotalWorkItem = relationTotalWorkItem;
        this.modify("relation_total_work_item", relationTotalWorkItem);
        return this;
    }

    /**
    * 设置 [关联测试用例数]
    */
    public Idea setRelationTotalTestCase(BigDecimal relationTotalTestCase) {
        this.relationTotalTestCase = relationTotalTestCase;
        this.modify("relation_total_test_case", relationTotalTestCase);
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
    * 设置 [关联客户数]
    */
    public Idea setRelationTotalCustomer(BigDecimal relationTotalCustomer) {
        this.relationTotalCustomer = relationTotalCustomer;
        this.modify("relation_total_customer", relationTotalCustomer);
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
    * 设置 [关注数]
    */
    public Idea setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
        this.modify("attention_count", attentionCount);
        return this;
    }

    /**
    * 设置 [评论数]
    */
    public Idea setCommentCount(String commentCount) {
        this.commentCount = commentCount;
        this.modify("comment_count", commentCount);
        return this;
    }

    /**
    * 设置 [产品是否删除]
    */
    public Idea setProductIsDeleted(Integer productIsDeleted) {
        this.productIsDeleted = productIsDeleted;
        this.modify("product_is_deleted", productIsDeleted);
        return this;
    }

    /**
    * 设置 [产品是否归档]
    */
    public Idea setProductIsArchived(Integer productIsArchived) {
        this.productIsArchived = productIsArchived;
        this.modify("product_is_archived", productIsArchived);
        return this;
    }

    /**
    * 设置 [当前版本名称]
    */
    public Idea setCurVersionName(String curVersionName) {
        this.curVersionName = curVersionName;
        this.modify("cur_version_name", curVersionName);
        return this;
    }

    /**
    * 设置 [选择版本标识]
    */
    public Idea setChooseVersionId(String chooseVersionId) {
        this.chooseVersionId = chooseVersionId;
        this.modify("choose_version_id", chooseVersionId);
        return this;
    }

    /**
    * 设置 [选择版本名称]
    */
    public Idea setChooseVersionName(String chooseVersionName) {
        this.chooseVersionName = chooseVersionName;
        this.modify("choose_version_name", chooseVersionName);
        return this;
    }

    /**
    * 设置 [关注人]
    */
    public Idea setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
    * 设置 [最近创建日期]
    */
    public Idea setRecentCreateDays(Integer recentCreateDays) {
        this.recentCreateDays = recentCreateDays;
        this.modify("recent_create_days", recentCreateDays);
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
    * 设置 [产品]
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