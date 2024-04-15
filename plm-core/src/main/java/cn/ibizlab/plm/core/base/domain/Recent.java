/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 最近访问实体类[Recent]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "RECENT", resultMap = "RecentResultMap")
@ApiModel(value = "RECENT", description = "最近访问")
public class Recent extends EntityMP implements Serializable
{

    /**
     * 编号
     */
    @TableField(value = "identifier")
    @DEField(name = "identifier")
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 所属数据标识
     */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id" , preType = DEPredefinedFieldType.PARENTID)
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
     * 所属数据对象
     */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE , dict = "recent_type")
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 所属对象子类型
     */
    @TableField(value = "owner_subtype")
    @DEField(name = "owner_subtype" , preType = DEPredefinedFieldType.PARENTSUBTYPE , dict = "recent_visite")
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "owner_subtype", notes = "所属对象子类型")
    private String ownerSubtype;

    /**
     * 访问类型
     */
    @TableField(value = "type")
    @DEField(name = "type")
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "type", notes = "访问类型")
    private String type;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
     * 访问父类名称
     */
    @TableField(value = "recent_parent_name")
    @DEField(name = "recent_parent_name")
    @JsonProperty("recent_parent_name")
    @JSONField(name = "recent_parent_name")
    @ApiModelProperty(value = "recent_parent_name", notes = "访问父类名称")
    private String recentParentName;

    /**
     * 访问父类
     */
    @TableField(value = "recent_parent")
    @DEField(name = "recent_parent")
    @JsonProperty("recent_parent")
    @JSONField(name = "recent_parent")
    @ApiModelProperty(value = "recent_parent", notes = "访问父类")
    private String recentParent;

    /**
     * 编号
     */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
     * 访问父类编号
     */
    @TableField(value = "recent_parent_identifier")
    @DEField(name = "recent_parent_identifier")
    @JsonProperty("recent_parent_identifier")
    @JSONField(name = "recent_parent_identifier")
    @ApiModelProperty(value = "recent_parent_identifier", notes = "访问父类编号")
    private String recentParentIdentifier;

    /**
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 建立时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 标识
     */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 工作项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "dercustom_recent_work_item", notes = "最近浏览")
    private WorkItem dercustomRecentWorkItem;

    /**
     * 设置 [编号]
     */
    public Recent setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [访问类型]
     */
    public Recent setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public Recent setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [访问父类名称]
     */
    public Recent setRecentParentName(String recentParentName) {
        this.recentParentName = recentParentName;
        this.modify("recent_parent_name", recentParentName);
        return this;
    }

    /**
     * 设置 [访问父类]
     */
    public Recent setRecentParent(String recentParent) {
        this.recentParent = recentParent;
        this.modify("recent_parent", recentParent);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public Recent setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [访问父类编号]
     */
    public Recent setRecentParentIdentifier(String recentParentIdentifier) {
        this.recentParentIdentifier = recentParentIdentifier;
        this.modify("recent_parent_identifier", recentParentIdentifier);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public Recent setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getCreateMan(),"未设置建立人");
        //Assert.notNull(getOwnerSubtype(),"未设置所属对象子类型");
        //Assert.notNull(getOwnerId(),"未设置所属数据标识");
        String key = String.format("%s||%s||%s"
            ,getCreateMan(),getOwnerSubtype(),getOwnerId());
        key = DigestUtils.md5DigestAsHex(key.getBytes());    
        return key;
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