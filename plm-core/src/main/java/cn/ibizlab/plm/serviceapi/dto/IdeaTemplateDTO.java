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
 * 需求模板[IdeaTemplateDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("需求模板DTO")
public class IdeaTemplateDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 0)
    private String title;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 1)
    private String description;

    /**
     * 类别标识
     */
    @JsonProperty("category_id")
    @JSONField(name = "category_id")
    @ApiModelProperty(value = "类别标识", position = 2)
    private String categoryId;

    /**
     * 名称
     */
    @JsonProperty("category_name")
    @JSONField(name = "category_name")
    @ApiModelProperty(value = "名称", position = 3)
    private String categoryName;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 4)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 5)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 6)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 7)
    private String name;

    /**
     * 产品
     */
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(value = "产品", position = 8)
    private String productId;

    /**
     * 产品名称
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(value = "产品名称", position = 9)
    private String productName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 10)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 11)
    private Date updateTime;


    /**
     * 设置 [标题]
     */
    public IdeaTemplateDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public IdeaTemplateDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [类别标识]
     */
    public IdeaTemplateDTO setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        this.modify("category_id", categoryId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public IdeaTemplateDTO setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        this.modify("category_name", categoryName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public IdeaTemplateDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [产品]
     */
    public IdeaTemplateDTO setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }

    /**
     * 设置 [产品名称]
     */
    public IdeaTemplateDTO setProductName(String productName) {
        this.productName = productName;
        this.modify("product_name", productName);
        return this;
    }


}
