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

/**
 * 附加数据版本实体类[VersionData]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "VERSION_DATA", resultMap = "VersionDataResultMap")
@ApiModel(value = "VERSION_DATA", description = "附加数据版本")
public class VersionData extends EntityMP implements Serializable
{

    /**
     * 描述
     */
    @TableField(value = "description")
    @DEField(name = "description")
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 所属父数据标识
     */
    @TableField(value = "parent_id")
    @DEField(name = "parent_id" , preType = DEPredefinedFieldType.PARENTID)
    @JsonProperty("parent_id")
    @JSONField(name = "parent_id")
    @ApiModelProperty(value = "parent_id", notes = "所属父数据标识")
    private String parentId;

    /**
     * 所属数据标识
     */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id")
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
     * 所属父数据对象
     */
    @TableField(value = "parent_type")
    @DEField(name = "parent_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JsonProperty("parent_type")
    @JSONField(name = "parent_type")
    @ApiModelProperty(value = "parent_type", notes = "所属父数据对象")
    private String parentType;

    /**
     * 所属数据对象
     */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type")
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 父对象版本标识
     */
    @TableField(value = "parent_version_id")
    @DEField(name = "parent_version_id" , preType = DEPredefinedFieldType.PARENTVERSIONID)
    @JsonProperty("parent_version_id")
    @JSONField(name = "parent_version_id")
    @ApiModelProperty(value = "parent_version_id", notes = "父对象版本标识")
    private String parentVersionId;

    /**
     * 数据
     */
    @TableField(value = "data")
    @DEField(name = "data")
    @JsonProperty("data")
    @JSONField(name = "data")
    @ApiModelProperty(value = "data", notes = "数据")
    private String data;

    /**
     * 过滤属性
     */
    @TableField(value = "filter")
    @DEField(name = "filter")
    @JsonProperty("filter")
    @JSONField(name = "filter")
    @ApiModelProperty(value = "filter", notes = "过滤属性")
    private String filter;

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
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

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
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

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
     * 设置 [描述]
     */
    public VersionData setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [所属数据标识]
     */
    public VersionData setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("owner_id", ownerId);
        return this;
    }

    /**
     * 设置 [所属数据对象]
     */
    public VersionData setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [数据]
     */
    public VersionData setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
     * 设置 [过滤属性]
     */
    public VersionData setFilter(String filter) {
        this.filter = filter;
        this.modify("filter", filter);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public VersionData setName(String name) {
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