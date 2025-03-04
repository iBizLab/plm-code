/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import cn.ibizlab.plm.core.base.domain.Organization;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 部门实体类[Department]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "DEPARTMENT", description = "部门")
public class Department extends EntityBase implements Serializable
{
    /**
     * 部门标识/编号
     */
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "部门标识/编号")
    private String identifier;

    /**
     * 备注
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "备注")
    private String description;

    /**
     * 是否叶子节点
     */
    @DEField(name = "is_leaf" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "is_leaf")
    @JsonProperty("is_leaf")
    @ApiModelProperty(value = "is_leaf", notes = "是否叶子节点")
    private Integer isLeaf;

    /**
     * 排序
     */
    @DEField(name = "sort")
    @JSONField(name = "sort")
    @JsonProperty("sort")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "sort", notes = "排序")
    private Long sort;

    /**
     * 父名称
     */
    @DEField(name = "pname")
    @JSONField(name = "pname")
    @JsonProperty("pname")
    @ApiModelProperty(value = "pname", notes = "父名称")
    private String pname;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 部门负责人标识
     */
    @DEField(name = "head_id")
    @JSONField(name = "head_id")
    @JsonProperty("head_id")
    @ApiModelProperty(value = "head_id", notes = "部门负责人标识")
    private String headId;

    /**
     * 父部门标识
     */
    @DEField(name = "parent_id")
    @JSONField(name = "parent_id")
    @JsonProperty("parent_id")
    @ApiModelProperty(value = "parent_id", notes = "父部门标识")
    private String parentId;

    /**
     * 组织标识
     */
    @DEField(name = "organization_id")
    @JSONField(name = "organization_id")
    @JsonProperty("organization_id")
    @ApiModelProperty(value = "organization_id", notes = "组织标识")
    private String organizationId;

    /**
     * 父部门
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "department", notes = "父部门")
    private Department department;

    /**
     * 名称
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "organization", notes = "名称")
    private Organization organization;

    /**
     * 部门负责人
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "user", notes = "部门负责人")
    private User user;

    /**
    * 设置 [部门标识/编号]
    */
    public Department setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public Department setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [是否叶子节点]
    */
    public Department setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
    * 设置 [排序]
    */
    public Department setSort(Long sort) {
        this.sort = sort;
        this.modify("sort", sort);
        return this;
    }

    /**
    * 设置 [父名称]
    */
    public Department setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Department setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [部门负责人标识]
    */
    public Department setHeadId(String headId) {
        this.headId = headId;
        this.modify("head_id", headId);
        return this;
    }

    /**
    * 设置 [父部门标识]
    */
    public Department setParentId(String parentId) {
        this.parentId = parentId;
        this.modify("parent_id", parentId);
        return this;
    }

    /**
    * 设置 [组织标识]
    */
    public Department setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        this.modify("organization_id", organizationId);
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