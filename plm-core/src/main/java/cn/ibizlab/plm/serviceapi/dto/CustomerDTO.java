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
 * 客户[CustomerDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("客户DTO")
public class CustomerDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 规模
     */
    @JsonProperty("scale")
    @JSONField(name = "scale")
    @ApiModelProperty(value = "规模", position = 0)
    private Integer scale;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 1)
    private String description;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 2)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 3)
    private Integer isDeleted;

    /**
     * 品牌标识
     */
    @JsonProperty("logo")
    @JSONField(name = "logo")
    @ApiModelProperty(value = "品牌标识", position = 4)
    private String logo;

    /**
     * 等级
     */
    @JsonProperty("grade_id")
    @JSONField(name = "grade_id")
    @ApiModelProperty(value = "等级", position = 5)
    private String gradeId;

    /**
     * 行业
     */
    @JsonProperty("industry_id")
    @JSONField(name = "industry_id")
    @ApiModelProperty(value = "行业", position = 6)
    private String industryId;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 7)
    private String categories;

    /**
     * 类别
     */
    @JsonProperty("categories_name")
    @JSONField(name = "categories_name")
    @ApiModelProperty(value = "类别", position = 8)
    private String categoriesName;

    /**
     * 产品名称
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(value = "产品名称", position = 9)
    private String productName;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 10)
    private String assigneeName;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 11)
    private String assigneeId;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 12)
    private List<AttentionDTO> attentions;

    /**
     * 产品是否归档
     */
    @JsonProperty("product_is_archived")
    @JSONField(name = "product_is_archived")
    @ApiModelProperty(value = "产品是否归档", position = 13)
    private Integer productIsArchived;

    /**
     * 工单总数
     */
    @JsonProperty("ticket_total")
    @JSONField(name = "ticket_total")
    @ApiModelProperty(value = "工单总数", position = 14)
    private Integer ticketTotal;

    /**
     * 已完成工单数
     */
    @JsonProperty("ticket_finish")
    @JSONField(name = "ticket_finish")
    @ApiModelProperty(value = "已完成工单数", position = 15)
    private Integer ticketFinish;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 16)
    private String attentionsImp;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 17)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 18)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 19)
    private String id;

    /**
     * 客户名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "客户名称", position = 20)
    private String name;

    /**
     * 产品标识
     */
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(value = "产品标识", position = 21)
    private String productId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 22)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 23)
    private Date updateTime;


    /**
     * 设置 [规模]
     */
    public CustomerDTO setScale(Integer scale) {
        this.scale = scale;
        this.modify("scale", scale);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public CustomerDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public CustomerDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public CustomerDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [品牌标识]
     */
    public CustomerDTO setLogo(String logo) {
        this.logo = logo;
        this.modify("logo", logo);
        return this;
    }

    /**
     * 设置 [等级]
     */
    public CustomerDTO setGradeId(String gradeId) {
        this.gradeId = gradeId;
        this.modify("grade_id", gradeId);
        return this;
    }

    /**
     * 设置 [行业]
     */
    public CustomerDTO setIndustryId(String industryId) {
        this.industryId = industryId;
        this.modify("industry_id", industryId);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public CustomerDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public CustomerDTO setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
     * 设置 [产品名称]
     */
    public CustomerDTO setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public CustomerDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public CustomerDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public CustomerDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [产品是否归档]
     */
    public CustomerDTO setProductIsArchived(Integer productIsArchived) {
        this.productIsArchived = productIsArchived;
        this.modify("product_is_archived", productIsArchived);
        return this;
    }

    /**
     * 设置 [工单总数]
     */
    public CustomerDTO setTicketTotal(Integer ticketTotal) {
        this.ticketTotal = ticketTotal;
        this.modify("ticket_total", ticketTotal);
        return this;
    }

    /**
     * 设置 [已完成工单数]
     */
    public CustomerDTO setTicketFinish(Integer ticketFinish) {
        this.ticketFinish = ticketFinish;
        this.modify("ticket_finish", ticketFinish);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public CustomerDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [客户名称]
     */
    public CustomerDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [产品标识]
     */
    public CustomerDTO setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }


}
