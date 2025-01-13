/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 工作项状态实体类[WorkItemState]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "WORK_ITEM_STATE", resultMap = "WorkItemStateResultMap")
@ApiModel(value = "WORK_ITEM_STATE", description = "工作项状态")
public class WorkItemState extends EntityMP implements Serializable
{

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence")
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 是否系统类型
    */
    @TableField(value = "is_system")
    @DEField(name = "is_system" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_system")
    @JsonProperty("is_system")
    @ApiModelProperty(value = "is_system", notes = "是否系统类型")
    private Integer isSystem;

    /**
    * 颜色
    */
    @TableField(value = "color")
    @DEField(name = "color")
    @JSONField(name = "color")
    @JsonProperty("color")
    @ApiModelProperty(value = "color", notes = "颜色")
    private String color;

    /**
    * 样式表
    */
    @TableField(value = "style")
    @DEField(name = "style")
    @JSONField(name = "style")
    @JsonProperty("style")
    @ApiModelProperty(value = "style", notes = "样式表")
    private String style;

    /**
    * 状态类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "state_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "状态类型")
    private String type;

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
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name" , dupCheck = DupCheck.ALL)
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
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
    * 工作项类型标识
    */
    @TableField(value = "work_item_type_id")
    @DEField(name = "work_item_type_id")
    @JSONField(name = "work_item_type_id")
    @JsonProperty("work_item_type_id")
    @ApiModelProperty(value = "work_item_type_id", notes = "工作项类型标识")
    private String workItemTypeId;

    /**
    * 工作项类型-状态
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item_type", notes = "工作项类型-状态")
    private WorkItemType workItemType;

    /**
    * 设置 [序号]
    */
    public WorkItemState setSequence(BigDecimal sequence) {
        this.sequence = sequence;
        this.modify("sequence", sequence);
        return this;
    }

    /**
    * 设置 [是否系统类型]
    */
    public WorkItemState setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
    * 设置 [颜色]
    */
    public WorkItemState setColor(String color) {
        this.color = color;
        this.modify("color", color);
        return this;
    }

    /**
    * 设置 [样式表]
    */
    public WorkItemState setStyle(String style) {
        this.style = style;
        this.modify("style", style);
        return this;
    }

    /**
    * 设置 [状态类型]
    */
    public WorkItemState setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public WorkItemState setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [工作项类型标识]
    */
    public WorkItemState setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
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