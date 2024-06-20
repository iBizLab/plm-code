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
import cn.ibizlab.plm.core.prodmgmt.domain.Channel;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTag;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.base.domain.Addon;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;

/**
 * 产品实体类[Product]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "PRODUCT", resultMap = "ProductResultMap")
@ApiModel(value = "PRODUCT", description = "产品")
public class Product extends EntityMP implements Serializable
{

    /**
    * 产品标识
    */
    @TableField(value = "identifier")
    @DEField(name = "identifier" , dupCheck = DupCheck.ALL)
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "产品标识")
    private String identifier;

    /**
    * 可见范围
    */
    @TableField(value = "visibility")
    @DEField(name = "visibility" , dict = "visibility")
    @JSONField(name = "visibility")
    @JsonProperty("visibility")
    @ApiModelProperty(value = "visibility", notes = "可见范围")
    private String visibility;

    /**
    * 主题色
    */
    @TableField(value = "color")
    @DEField(name = "color")
    @JSONField(name = "color")
    @JsonProperty("color")
    @ApiModelProperty(value = "color", notes = "主题色")
    private String color;

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
    * 是否星标
    */
    @TableField(value = "is_favorite" , exist = false)
    @DEField(name = "is_favorite" , dict = "YesNo")
    @JSONField(name = "is_favorite")
    @JsonProperty("is_favorite")
    @ApiModelProperty(value = "is_favorite", notes = "是否星标")
    private String isFavorite;

    /**
    * 产品成员
    */
    @Transient
    @TableField(exist = false)
    @DEField(name = "members")
    @JSONField(name = "members")
    @JsonProperty("members")
    @ApiModelProperty(value = "members", notes = "产品成员")
    private List<ProductMember> members;

    /**
    * 所属
    */
    @TableField(value = "scope_type")
    @DEField(name = "scope_type" , dict = "scope_type")
    @JSONField(name = "scope_type")
    @JsonProperty("scope_type")
    @ApiModelProperty(value = "scope_type", notes = "所属")
    private String scopeType;

    /**
    * 所属对象
    */
    @TableField(value = "scope_id")
    @DEField(name = "scope_id")
    @JSONField(name = "scope_id")
    @JsonProperty("scope_id")
    @ApiModelProperty(value = "scope_id", notes = "所属对象")
    private String scopeId;

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
    * 产品名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "产品名称")
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
    * 设置 [产品标识]
    */
    public Product setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [可见范围]
    */
    public Product setVisibility(String visibility) {
        this.visibility = visibility;
        this.modify("visibility", visibility);
        return this;
    }

    /**
    * 设置 [主题色]
    */
    public Product setColor(String color) {
        this.color = color;
        this.modify("color", color);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Product setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public Product setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public Product setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [是否星标]
    */
    public Product setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
        this.modify("is_favorite", isFavorite);
        return this;
    }

    /**
    * 设置 [产品成员]
    */
    public Product setMembers(List<ProductMember> members) {
        this.members = members;
        this.modify("members", members);
        return this;
    }

    /**
    * 设置 [所属]
    */
    public Product setScopeType(String scopeType) {
        this.scopeType = scopeType;
        this.modify("scope_type", scopeType);
        return this;
    }

    /**
    * 设置 [所属对象]
    */
    public Product setScopeId(String scopeId) {
        this.scopeId = scopeId;
        this.modify("scope_id", scopeId);
        return this;
    }

    /**
    * 设置 [产品名称]
    */
    public Product setName(String name) {
        this.name = name;
        this.modify("name", name);
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