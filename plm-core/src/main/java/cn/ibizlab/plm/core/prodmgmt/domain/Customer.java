/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
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
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 客户实体类[Customer]
 *
 * @author generator
 */
@Audit
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "CUSTOMER", resultMap = "CustomerResultMap")
@ApiModel(value = "CUSTOMER", description = "客户")
public class Customer extends EntityMP implements Serializable
{

    /**
    * 规模
    */
    @TableField(value = "scale")
    @DEField(name = "scale")
    @JSONField(name = "scale")
    @JsonProperty("scale")
    @ApiModelProperty(value = "scale", notes = "规模")
    private Integer scale;

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
    * 品牌标识
    */
    @TableField(value = "logo")
    @DEField(name = "logo")
    @JSONField(name = "logo")
    @JsonProperty("logo")
    @ApiModelProperty(value = "logo", notes = "品牌标识")
    private String logo;

    /**
    * 等级
    */
    @TableField(value = "grade_id")
    @DEField(name = "grade_id" , dict = "customer_level")
    @JSONField(name = "grade_id")
    @JsonProperty("grade_id")
    @ApiModelProperty(value = "grade_id", notes = "等级")
    private String gradeId;

    /**
    * 行业
    */
    @TableField(value = "industry_id")
    @DEField(name = "industry_id" , dict = "customer_sector")
    @JSONField(name = "industry_id")
    @JsonProperty("industry_id")
    @ApiModelProperty(value = "industry_id", notes = "行业")
    private String industryId;

    /**
    * 类别
    */
    @TableField(value = "categories")
    @DEField(name = "categories")
    @JSONField(name = "categories")
    @JsonProperty("categories")
    @ApiModelProperty(value = "categories", notes = "类别")
    private String categories;

    /**
    * 类别
    */
    @TableField(value = "categories_name" , exist = false)
    @DEField(name = "categories_name")
    @JSONField(name = "categories_name")
    @JsonProperty("categories_name")
    @ApiModelProperty(value = "categories_name", notes = "类别")
    private String categoriesName;

    /**
    * 产品名称
    */
    @TableField(value = "product_name" , exist = false)
    @DEField(name = "product_name")
    @JSONField(name = "product_name")
    @JsonProperty("product_name")
    @ApiModelProperty(value = "product_name", notes = "产品名称")
    private String productName;

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
    * 关注
    */
    @TableField(exist = false)
    @DEField(name = "attentions")
    @JSONField(name = "attentions")
    @JsonProperty("attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

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
    * 工单总数
    */
    @TableField(value = "ticket_total" , exist = false)
    @DEField(name = "ticket_total")
    @JSONField(name = "ticket_total")
    @JsonProperty("ticket_total")
    @ApiModelProperty(value = "ticket_total", notes = "工单总数")
    private Integer ticketTotal;

    /**
    * 已完成工单数
    */
    @TableField(value = "ticket_finish" , exist = false)
    @DEField(name = "ticket_finish")
    @JSONField(name = "ticket_finish")
    @JsonProperty("ticket_finish")
    @ApiModelProperty(value = "ticket_finish", notes = "已完成工单数")
    private Integer ticketFinish;

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
    * 客户名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "客户名称")
    private String name;

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
    * 产品标识
    */
    @TableField(value = "product_id")
    @DEField(name = "product_id")
    @JSONField(name = "product_id")
    @JsonProperty("product_id")
    @ApiModelProperty(value = "product_id", notes = "产品标识")
    private String productId;

    /**
    * 产品=客户
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "product", notes = "产品=客户")
    private Product product;

    /**
    * DER1N_CUSTOMER_USER_ASSIGNEE_ID
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "user", notes = "DER1N_CUSTOMER_USER_ASSIGNEE_ID")
    private User user;

    /**
    * 设置 [规模]
    */
    public Customer setScale(Integer scale) {
        this.scale = scale;
        this.modify("scale", scale);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Customer setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public Customer setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public Customer setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [品牌标识]
    */
    public Customer setLogo(String logo) {
        this.logo = logo;
        this.modify("logo", logo);
        return this;
    }

    /**
    * 设置 [等级]
    */
    public Customer setGradeId(String gradeId) {
        this.gradeId = gradeId;
        this.modify("grade_id", gradeId);
        return this;
    }

    /**
    * 设置 [行业]
    */
    public Customer setIndustryId(String industryId) {
        this.industryId = industryId;
        this.modify("industry_id", industryId);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public Customer setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public Customer setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
    * 设置 [产品名称]
    */
    public Customer setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public Customer setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
    * 设置 [负责人标识]
    */
    public Customer setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
    * 设置 [关注]
    */
    public Customer setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
    * 设置 [产品是否归档]
    */
    public Customer setProductIsArchived(Integer productIsArchived) {
        this.productIsArchived = productIsArchived;
        this.modify("product_is_archived", productIsArchived);
        return this;
    }

    /**
    * 设置 [工单总数]
    */
    public Customer setTicketTotal(Integer ticketTotal) {
        this.ticketTotal = ticketTotal;
        this.modify("ticket_total", ticketTotal);
        return this;
    }

    /**
    * 设置 [已完成工单数]
    */
    public Customer setTicketFinish(Integer ticketFinish) {
        this.ticketFinish = ticketFinish;
        this.modify("ticket_finish", ticketFinish);
        return this;
    }

    /**
    * 设置 [关注人]
    */
    public Customer setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
    * 设置 [客户名称]
    */
    public Customer setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [产品标识]
    */
    public Customer setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
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