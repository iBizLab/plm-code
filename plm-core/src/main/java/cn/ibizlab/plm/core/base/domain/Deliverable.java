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
 * 交付物实体类[Deliverable]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "ATTACHMENT", resultMap = "DeliverableResultMap")
@ApiModel(value = "DELIVERABLE", description = "交付物")
public class Deliverable extends EntityMP implements Serializable
{

    /**
    * 所属数据标识
    */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id" , preType = DEPredefinedFieldType.PARENTID)
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
    * 所属数据对象
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
    * 所属对象子类型
    */
    @TableField(value = "owner_subtype")
    @DEField(name = "owner_subtype" , preType = DEPredefinedFieldType.PARENTSUBTYPE)
    @JSONField(name = "owner_subtype")
    @JsonProperty("owner_subtype")
    @ApiModelProperty(value = "owner_subtype", notes = "所属对象子类型")
    private String ownerSubtype;

    /**
    * 文件标识
    */
    @TableField(value = "file_id")
    @DEField(name = "file_id")
    @JSONField(name = "file_id")
    @JsonProperty("file_id")
    @ApiModelProperty(value = "file_id", notes = "文件标识")
    private String fileId;

    /**
    * 工作项编号
    */
    @TableField(value = "work_item_identifier" , exist = false)
    @DEField(name = "work_item_identifier")
    @JSONField(name = "work_item_identifier")
    @JsonProperty("work_item_identifier")
    @ApiModelProperty(value = "work_item_identifier", notes = "工作项编号")
    private String workItemIdentifier;

    /**
    * 工作项标题
    */
    @TableField(value = "work_item_title" , exist = false)
    @DEField(name = "work_item_title")
    @JSONField(name = "work_item_title")
    @JsonProperty("work_item_title")
    @ApiModelProperty(value = "work_item_title", notes = "工作项标题")
    private String workItemTitle;

    /**
    * 工作项类型
    */
    @TableField(value = "work_item_type_id" , exist = false)
    @DEField(name = "work_item_type_id")
    @JSONField(name = "work_item_type_id")
    @JsonProperty("work_item_type_id")
    @ApiModelProperty(value = "work_item_type_id", notes = "工作项类型")
    private String workItemTypeId;

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
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item", notes = "名称")
    private WorkItem workItem;

    /**
    * 设置 [文件标识]
    */
    public Deliverable setFileId(String fileId) {
        this.fileId = fileId;
        this.modify("file_id", fileId);
        return this;
    }

    /**
    * 设置 [工作项编号]
    */
    public Deliverable setWorkItemIdentifier(String workItemIdentifier) {
        this.workItemIdentifier = workItemIdentifier;
        this.modify("work_item_identifier", workItemIdentifier);
        return this;
    }

    /**
    * 设置 [工作项标题]
    */
    public Deliverable setWorkItemTitle(String workItemTitle) {
        this.workItemTitle = workItemTitle;
        this.modify("work_item_title", workItemTitle);
        return this;
    }

    /**
    * 设置 [工作项类型]
    */
    public Deliverable setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public Deliverable setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Deliverable setName(String name) {
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