/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.domain;

import java.util.*;
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
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;

/**
 * 工单实体类[Ticket]
 *
 * @author generator
 */
@Audit
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "TICKET", resultMap = "TicketResultMap")
@ApiModel(value = "TICKET", description = "工单")
public class Ticket extends EntityMP implements Serializable
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
    @DEField(name = "state" , defaultValue = "10" , dict = "ticket_state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "状态")
    private String state;

    /**
    * 类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "base_ticket_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "类型")
    private String type;

    /**
    * 解决方案
    */
    @TableField(value = "solution")
    @DEField(name = "solution" , dict = "solutions")
    @JSONField(name = "solution")
    @JsonProperty("solution")
    @ApiModelProperty(value = "solution", notes = "解决方案")
    private String solution;

    /**
    * 优先级
    */
    @TableField(value = "priority")
    @DEField(name = "priority" , dict = "ticket_priority")
    @JSONField(name = "priority")
    @JsonProperty("priority")
    @ApiModelProperty(value = "priority", notes = "优先级")
    private String priority;

    /**
    * 渠道
    */
    @TableField(value = "channel")
    @DEField(name = "channel")
    @JSONField(name = "channel")
    @JsonProperty("channel")
    @ApiModelProperty(value = "channel", notes = "渠道")
    private String channel;

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
    * 提交时间
    */
    @TableField(value = "submitted_at")
    @DEField(name = "submitted_at" , fieldType = "DATETIME", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "submitted_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("submitted_at")
    @ApiModelProperty(value = "submitted_at", notes = "提交时间")
    private Date submittedAt;

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
    * 预计时间
    */
    @TableField(value = "estimated_at")
    @DEField(name = "estimated_at")
    @JSONField(name = "estimated_at")
    @JsonProperty("estimated_at")
    @ApiModelProperty(value = "estimated_at", notes = "预计时间")
    private String estimatedAt;

    /**
    * 标签
    */
    @TableField(value = "tags")
    @DEField(name = "tags" , dict = "product_tag")
    @JSONField(name = "tags")
    @JsonProperty("tags")
    @ApiModelProperty(value = "tags", notes = "标签")
    private String tags;

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
    * 负责人标识
    */
    @TableField(value = "assignee_id")
    @DEField(name = "assignee_id")
    @JSONField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人标识")
    private String assigneeId;

    /**
    * 提交人标识
    */
    @TableField(value = "submitter_id")
    @DEField(name = "submitter_id" , dict = "SysOperator")
    @JSONField(name = "submitter_id")
    @JsonProperty("submitter_id")
    @ApiModelProperty(value = "submitter_id", notes = "提交人标识")
    private String submitterId;

    /**
    * 提交人
    */
    @TableField(value = "submitter_name")
    @DEField(name = "submitter_name")
    @JSONField(name = "submitter_name")
    @JsonProperty("submitter_name")
    @ApiModelProperty(value = "submitter_name", notes = "提交人")
    private String submitterName;

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
    * 编号
    */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JSONField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

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
    * 关注
    */
    @TableField(exist = false)
    @DEField(name = "attentions")
    @JSONField(name = "attentions")
    @JsonProperty("attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
    * 工单数
    */
    @TableField(value = "rep_num" , exist = false)
    @DEField(name = "rep_num")
    @JSONField(name = "rep_num")
    @JsonProperty("rep_num")
    @ApiModelProperty(value = "rep_num", notes = "工单数")
    private String repNum;

    /**
    * 解决办法
    */
    @TableField(value = "solution_way")
    @DEField(name = "solution_way")
    @JSONField(name = "solution_way")
    @JsonProperty("solution_way")
    @ApiModelProperty(value = "solution_way", notes = "解决办法")
    private String solutionWay;

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
    * 产品标识
    */
    @TableField(value = "product_id")
    @DEField(name = "product_id")
    @JSONField(name = "product_id")
    @JsonProperty("product_id")
    @ApiModelProperty(value = "product_id", notes = "产品标识")
    private String productId;

    /**
    * 客户标识
    */
    @TableField(value = "customer_id")
    @DEField(name = "customer_id")
    @JSONField(name = "customer_id")
    @JsonProperty("customer_id")
    @ApiModelProperty(value = "customer_id", notes = "客户标识")
    private String customerId;

    /**
    * 客户
    */
    @TableField(value = "customer_name" , exist = false)
    @DEField(name = "customer_name")
    @JSONField(name = "customer_name")
    @JsonProperty("customer_name")
    @ApiModelProperty(value = "customer_name", notes = "客户")
    private String customerName;

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
    * 客户
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "customer", notes = "客户")
    private Customer customer;

    /**
    * 产品-工单
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "product", notes = "产品-工单")
    private Product product;

    /**
    * DER1N_TICKET_USER_ASSIGNEE_ID
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "user", notes = "DER1N_TICKET_USER_ASSIGNEE_ID")
    private User user;

    /**
    * 设置 [编号]
    */
    public Ticket setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public Ticket setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public Ticket setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [类型]
    */
    public Ticket setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [解决方案]
    */
    public Ticket setSolution(String solution) {
        this.solution = solution;
        this.modify("solution", solution);
        return this;
    }

    /**
    * 设置 [优先级]
    */
    public Ticket setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
    * 设置 [渠道]
    */
    public Ticket setChannel(String channel) {
        this.channel = channel;
        this.modify("channel", channel);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Ticket setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [提交时间]
    */
    public Ticket setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
        this.modify("submitted_at", submittedAt);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public Ticket setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public Ticket setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [预计时间]
    */
    public Ticket setEstimatedAt(String estimatedAt) {
        this.estimatedAt = estimatedAt;
        this.modify("estimated_at", estimatedAt);
        return this;
    }

    /**
    * 设置 [标签]
    */
    public Ticket setTags(String tags) {
        this.tags = tags;
        this.modify("tags", tags);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public Ticket setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
    * 设置 [负责人标识]
    */
    public Ticket setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
    * 设置 [提交人标识]
    */
    public Ticket setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
        this.modify("submitter_id", submitterId);
        return this;
    }

    /**
    * 设置 [提交人]
    */
    public Ticket setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
        this.modify("submitter_name", submitterName);
        return this;
    }

    /**
    * 设置 [附件]
    */
    public Ticket setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public Ticket setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [产品标识]
    */
    public Ticket setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
        this.modify("product_identifier", productIdentifier);
        return this;
    }

    /**
    * 设置 [关注]
    */
    public Ticket setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
    * 设置 [工单数]
    */
    public Ticket setRepNum(String repNum) {
        this.repNum = repNum;
        this.modify("rep_num", repNum);
        return this;
    }

    /**
    * 设置 [解决办法]
    */
    public Ticket setSolutionWay(String solutionWay) {
        this.solutionWay = solutionWay;
        this.modify("solution_way", solutionWay);
        return this;
    }

    /**
    * 设置 [关注数]
    */
    public Ticket setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
        this.modify("attention_count", attentionCount);
        return this;
    }

    /**
    * 设置 [评论数]
    */
    public Ticket setCommentCount(String commentCount) {
        this.commentCount = commentCount;
        this.modify("comment_count", commentCount);
        return this;
    }

    /**
    * 设置 [关注人]
    */
    public Ticket setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
    * 设置 [最近创建日期]
    */
    public Ticket setRecentCreateDays(Integer recentCreateDays) {
        this.recentCreateDays = recentCreateDays;
        this.modify("recent_create_days", recentCreateDays);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Ticket setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [产品标识]
    */
    public Ticket setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
    * 设置 [客户标识]
    */
    public Ticket setCustomerId(String customerId) {
        this.customerId = customerId;
        this.modify("customer_id", customerId);
        return this;
    }

    /**
    * 设置 [客户]
    */
    public Ticket setCustomerName(String customerName) {
        this.customerName = customerName;
        this.modify("customer_name", customerName);
        return this;
    }

    /**
    * 设置 [所属产品]
    */
    public Ticket setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
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