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
 * 基线[BaselineDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("基线DTO")
public class BaselineDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 0)
    private String description;

    /**
     * 状态
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "状态", position = 1)
    private String status;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 2)
    private String ownerId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 3)
    private String ownerType;

    /**
     * 所属对象子类型
     */
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "所属对象子类型", position = 4)
    private String ownerSubtype;

    /**
     * 基线类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "基线类型", position = 5)
    private String type;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 6)
    private String categories;

    /**
     * 类别
     */
    @JsonProperty("categories_name")
    @JSONField(name = "categories_name")
    @ApiModelProperty(value = "类别", position = 7)
    private String categoriesName;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 8)
    private String assigneeName;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 9)
    private String assigneeId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 10)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 11)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 12)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 13)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 14)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 15)
    private Date updateTime;


    /**
     * 设置 [描述]
     */
    public BaselineDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public BaselineDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [基线类型]
     */
    public BaselineDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public BaselineDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public BaselineDTO setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public BaselineDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public BaselineDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public BaselineDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
