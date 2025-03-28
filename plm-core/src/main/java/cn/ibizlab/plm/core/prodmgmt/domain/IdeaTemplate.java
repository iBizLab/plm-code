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
import cn.ibizlab.plm.core.base.domain.Category;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;

/**
 * 需求模板实体类[IdeaTemplate]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IDEA_TEMPLATE", resultMap = "IdeaTemplateResultMap")
@ApiModel(value = "IDEA_TEMPLATE", description = "需求模板")
public class IdeaTemplate extends EntityMP implements Serializable
{

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
    * 全局模板
    */
    @TableField(value = "is_global")
    @DEField(name = "is_global" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_global")
    @JsonProperty("is_global")
    @ApiModelProperty(value = "is_global", notes = "全局模板")
    private Integer isGlobal;

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
    * 描述
    */
    @TableField(value = "description")
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

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
    * 子产品标识
    */
    @TableField(value = "section_id" , exist = false)
    @DEField(name = "section_id")
    @JSONField(name = "section_id")
    @JsonProperty("section_id")
    @ApiModelProperty(value = "section_id", notes = "子产品标识")
    private String sectionId;

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
    * 产品名称
    */
    @TableField(value = "product_name" , exist = false)
    @DEField(name = "product_name")
    @JSONField(name = "product_name")
    @JsonProperty("product_name")
    @ApiModelProperty(value = "product_name", notes = "产品名称")
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
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "category", notes = "名称")
    private Category category;

    /**
    * 产品-需求模版
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "product", notes = "产品-需求模版")
    private Product product;

    /**
    * 设置 [标题]
    */
    public IdeaTemplate setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [全局模板]
    */
    public IdeaTemplate setIsGlobal(Integer isGlobal) {
        this.isGlobal = isGlobal;
        this.modify("is_global", isGlobal);
        return this;
    }

    /**
    * 设置 [产品标识]
    */
    public IdeaTemplate setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
        this.modify("product_identifier", productIdentifier);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public IdeaTemplate setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [子产品名称]
    */
    public IdeaTemplate setSectionName(String sectionName) {
        this.sectionName = sectionName;
        this.modify("section_name", sectionName);
        return this;
    }

    /**
    * 设置 [子产品标识]
    */
    public IdeaTemplate setSectionId(String sectionId) {
        this.sectionId = sectionId;
        this.modify("section_id", sectionId);
        return this;
    }

    /**
    * 设置 [类别路径]
    */
    public IdeaTemplate setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public IdeaTemplate setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [产品]
    */
    public IdeaTemplate setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
    * 设置 [产品名称]
    */
    public IdeaTemplate setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
        return this;
    }

    /**
    * 设置 [类别标识]
    */
    public IdeaTemplate setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        this.modify("category_id", categoryId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public IdeaTemplate setCategoryName(String categoryName) {
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