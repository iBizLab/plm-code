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
 * 部门[DepartmentDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("部门DTO")
public class DepartmentDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门标识/编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "部门标识/编号", position = 0)
    private String identifier;

    /**
     * 备注
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "备注", position = 1)
    private String description;

    /**
     * 是否叶子节点
     */
    @JsonProperty("is_leaf")
    @JSONField(name = "is_leaf")
    @ApiModelProperty(value = "是否叶子节点", position = 2)
    private Integer isLeaf;

    /**
     * 排序
     */
    @JsonProperty("sort")
    @JSONField(name = "sort")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "排序", position = 3)
    private Long sort;

    /**
     * 父名称
     */
    @JsonProperty("pname")
    @JSONField(name = "pname")
    @ApiModelProperty(value = "父名称", position = 4)
    private String pname;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 5)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 6)
    private Date createTime;

    /**
     * 部门负责人标识
     */
    @JsonProperty("head_id")
    @JSONField(name = "head_id")
    @ApiModelProperty(value = "部门负责人标识", position = 7)
    private String headId;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 8)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 9)
    private String name;

    /**
     * 组织标识
     */
    @JsonProperty("organization_id")
    @JSONField(name = "organization_id")
    @ApiModelProperty(value = "组织标识", position = 10)
    private String organizationId;

    /**
     * 父部门标识
     */
    @JsonProperty("parent_id")
    @JSONField(name = "parent_id")
    @ApiModelProperty(value = "父部门标识", position = 11)
    private String parentId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 12)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 13)
    private Date updateTime;


    /**
     * 设置 [部门标识/编号]
     */
    public DepartmentDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public DepartmentDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [是否叶子节点]
     */
    public DepartmentDTO setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
     * 设置 [排序]
     */
    public DepartmentDTO setSort(Long sort) {
        this.sort = sort;
        this.modify("sort", sort);
        return this;
    }

    /**
     * 设置 [父名称]
     */
    public DepartmentDTO setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
        return this;
    }

    /**
     * 设置 [部门负责人标识]
     */
    public DepartmentDTO setHeadId(String headId) {
        this.headId = headId;
        this.modify("head_id", headId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public DepartmentDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [组织标识]
     */
    public DepartmentDTO setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        this.modify("organization_id", organizationId);
        return this;
    }

    /**
     * 设置 [父部门标识]
     */
    public DepartmentDTO setParentId(String parentId) {
        this.parentId = parentId;
        this.modify("parent_id", parentId);
        return this;
    }


}
