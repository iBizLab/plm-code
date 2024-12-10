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
 * 工单[TicketBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工单DTO")
public class TicketBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 0)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 1)
    private Integer isDeleted;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 2)
    private Date createTime;

    /**
     * 提交时间
     */
    @JsonProperty("submitted_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "submitted_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间", position = 3)
    private Date submittedAt;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 4)
    private Date updateTime;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 5)
    private String name;

    /**
     * 预计时间
     */
    @JsonProperty("estimated_at")
    @JSONField(name = "estimated_at")
    @ApiModelProperty(value = "预计时间", position = 6)
    private String estimatedAt;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 7)
    private String updateMan;

    /**
     * 渠道
     */
    @JsonProperty("channel")
    @JSONField(name = "channel")
    @ApiModelProperty(value = "渠道", position = 8)
    private String channel;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 9)
    private String identifier;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 10)
    private String title;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 11)
    private String createMan;

    /**
     * 提交人
     */
    @JsonProperty("submitter_name")
    @JSONField(name = "submitter_name")
    @ApiModelProperty(value = "提交人", position = 12)
    private String submitterName;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 13)
    private String attentionsImp;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 14)
    private String assigneeName;

    /**
     * 客户
     */
    @JsonProperty("customer_name")
    @JSONField(name = "customer_name")
    @ApiModelProperty(value = "客户", position = 15)
    private String customerName;

    /**
     * 客户标识
     */
    @JsonProperty("customer_id")
    @JSONField(name = "customer_id")
    @ApiModelProperty(value = "客户标识", position = 16)
    private String customerId;

    /**
     * 产品标识
     */
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(value = "产品标识", position = 17)
    private String productId;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 18)
    private String assigneeId;

    /**
     * 类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "类型", position = 19)
    private String type;

    /**
     * 解决方案
     */
    @JsonProperty("solution")
    @JSONField(name = "solution")
    @ApiModelProperty(value = "解决方案", position = 20)
    private String solution;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 21)
    private String priority;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "状态", position = 22)
    private String state;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 23)
    private String id;

    /**
     * 所属产品
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(value = "所属产品", position = 24)
    private String productName;

    /**
     * 提交人标识
     */
    @JsonProperty("submitter_id")
    @JSONField(name = "submitter_id")
    @ApiModelProperty(value = "提交人标识", position = 25)
    private String submitterId;

    /**
     * 标签
     */
    @JsonProperty("tags")
    @JSONField(name = "tags")
    @ApiModelProperty(value = "标签", position = 26)
    private String tags;

    /**
     * 产品是否删除
     */
    @JsonProperty("product_is_deleted")
    @JSONField(name = "product_is_deleted")
    @ApiModelProperty(value = "产品是否删除", position = 27)
    private Integer productIsDeleted;


    /**
     * 设置 [是否已归档]
     */
    public TicketBiSearchGroupDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public TicketBiSearchGroupDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [提交时间]
     */
    public TicketBiSearchGroupDTO setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
        this.modify("submitted_at", submittedAt);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public TicketBiSearchGroupDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [预计时间]
     */
    public TicketBiSearchGroupDTO setEstimatedAt(String estimatedAt) {
        this.estimatedAt = estimatedAt;
        this.modify("estimated_at", estimatedAt);
        return this;
    }

    /**
     * 设置 [渠道]
     */
    public TicketBiSearchGroupDTO setChannel(String channel) {
        this.channel = channel;
        this.modify("channel", channel);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public TicketBiSearchGroupDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public TicketBiSearchGroupDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [提交人]
     */
    public TicketBiSearchGroupDTO setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
        this.modify("submitter_name", submitterName);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public TicketBiSearchGroupDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public TicketBiSearchGroupDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [客户]
     */
    public TicketBiSearchGroupDTO setCustomerName(String customerName) {
        this.customerName = customerName;
        this.modify("customer_name", customerName);
        return this;
    }

    /**
     * 设置 [客户标识]
     */
    public TicketBiSearchGroupDTO setCustomerId(String customerId) {
        this.customerId = customerId;
        this.modify("customer_id", customerId);
        return this;
    }

    /**
     * 设置 [产品标识]
     */
    public TicketBiSearchGroupDTO setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public TicketBiSearchGroupDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [类型]
     */
    public TicketBiSearchGroupDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [解决方案]
     */
    public TicketBiSearchGroupDTO setSolution(String solution) {
        this.solution = solution;
        this.modify("solution", solution);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public TicketBiSearchGroupDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public TicketBiSearchGroupDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [所属产品]
     */
    public TicketBiSearchGroupDTO setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
        return this;
    }

    /**
     * 设置 [提交人标识]
     */
    public TicketBiSearchGroupDTO setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
        this.modify("submitter_id", submitterId);
        return this;
    }

    /**
     * 设置 [标签]
     */
    public TicketBiSearchGroupDTO setTags(String tags) {
        this.tags = tags;
        this.modify("tags", tags);
        return this;
    }

    /**
     * 设置 [产品是否删除]
     */
    public TicketBiSearchGroupDTO setProductIsDeleted(Integer productIsDeleted) {
        this.productIsDeleted = productIsDeleted;
        this.modify("product_is_deleted", productIsDeleted);
        return this;
    }


}
