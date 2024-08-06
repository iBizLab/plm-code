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
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 迭代变更实体类[SprintAlteration]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "SPRINT_ALTERATION", resultMap = "SprintAlterationResultMap")
@ApiModel(value = "SPRINT_ALTERATION", description = "迭代变更")
public class SprintAlteration extends EntityMP implements Serializable
{

    /**
    * 是否删除
    */
    @TableField(value = "is_deleted" , exist = false)
    @DEField(name = "is_deleted" , dict = "YesNo")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否删除")
    private Integer isDeleted;

    /**
    * 类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "sprint_alteration_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "类型")
    private String type;

    /**
    * 迭代状态
    */
    @TableField(value = "sprint_status")
    @DEField(name = "sprint_status" , dict = "sprint_status")
    @JSONField(name = "sprint_status")
    @JsonProperty("sprint_status")
    @ApiModelProperty(value = "sprint_status", notes = "迭代状态")
    private String sprintStatus;

    /**
    * 燃尽统计日期
    */
    @TableField(value = "rep_date" , exist = false)
    @DEField(name = "rep_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "rep_date" , format = "yyyy-MM-dd")
    @JsonProperty("rep_date")
    @ApiModelProperty(value = "rep_date", notes = "燃尽统计日期")
    private Date repDate;

    /**
    * 燃尽统计数值1
    */
    @TableField(value = "rep_value1" , exist = false)
    @DEField(name = "rep_value1")
    @JSONField(name = "rep_value1")
    @JsonProperty("rep_value1")
    @ApiModelProperty(value = "rep_value1", notes = "燃尽统计数值1")
    private BigDecimal repValue1;

    /**
    * 燃尽统计数值2
    */
    @TableField(value = "rep_value2" , exist = false)
    @DEField(name = "rep_value2")
    @JSONField(name = "rep_value2")
    @JsonProperty("rep_value2")
    @ApiModelProperty(value = "rep_value2", notes = "燃尽统计数值2")
    private BigDecimal repValue2;

    /**
    * 工作项完成时间
    */
    @TableField(value = "work_item_completed_at" , exist = false)
    @DEField(name = "work_item_completed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "work_item_completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("work_item_completed_at")
    @ApiModelProperty(value = "work_item_completed_at", notes = "工作项完成时间")
    private Date workItemCompletedAt;

    /**
    * 工作项优先级
    */
    @TableField(value = "work_item_priority" , exist = false)
    @DEField(name = "work_item_priority" , dict = "work_item_priority")
    @JSONField(name = "work_item_priority")
    @JsonProperty("work_item_priority")
    @ApiModelProperty(value = "work_item_priority", notes = "工作项优先级")
    private String workItemPriority;

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
    @DEField(name = "name")
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
    * 迭代标识
    */
    @TableField(value = "sprint_id")
    @DEField(name = "sprint_id")
    @JSONField(name = "sprint_id")
    @JsonProperty("sprint_id")
    @ApiModelProperty(value = "sprint_id", notes = "迭代标识")
    private String sprintId;

    /**
    * 工作项标识
    */
    @TableField(value = "work_item_id")
    @DEField(name = "work_item_id")
    @JSONField(name = "work_item_id")
    @JsonProperty("work_item_id")
    @ApiModelProperty(value = "work_item_id", notes = "工作项标识")
    private String workItemId;

    /**
    * 标题
    */
    @TableField(value = "work_item_title" , exist = false)
    @DEField(name = "work_item_title")
    @JSONField(name = "work_item_title")
    @JsonProperty("work_item_title")
    @ApiModelProperty(value = "work_item_title", notes = "标题")
    private String workItemTitle;

    /**
    * 名称
    */
    @TableField(value = "sprint_name" , exist = false)
    @DEField(name = "sprint_name")
    @JSONField(name = "sprint_name")
    @JsonProperty("sprint_name")
    @ApiModelProperty(value = "sprint_name", notes = "名称")
    private String sprintName;

    /**
    * 迭代-变更
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "sprint", notes = "迭代-变更")
    private Sprint sprint;

    /**
    * 工作项-迭代变更
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item", notes = "工作项-迭代变更")
    private WorkItem workItem;

    /**
    * 设置 [是否删除]
    */
    public SprintAlteration setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [类型]
    */
    public SprintAlteration setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [迭代状态]
    */
    public SprintAlteration setSprintStatus(String sprintStatus) {
        this.sprintStatus = sprintStatus;
        this.modify("sprint_status", sprintStatus);
        return this;
    }

    /**
    * 设置 [燃尽统计日期]
    */
    public SprintAlteration setRepDate(Date repDate) {
        this.repDate = repDate;
        this.modify("rep_date", repDate);
        return this;
    }

    /**
    * 设置 [燃尽统计数值1]
    */
    public SprintAlteration setRepValue1(BigDecimal repValue1) {
        this.repValue1 = repValue1;
        this.modify("rep_value1", repValue1);
        return this;
    }

    /**
    * 设置 [燃尽统计数值2]
    */
    public SprintAlteration setRepValue2(BigDecimal repValue2) {
        this.repValue2 = repValue2;
        this.modify("rep_value2", repValue2);
        return this;
    }

    /**
    * 设置 [工作项完成时间]
    */
    public SprintAlteration setWorkItemCompletedAt(Date workItemCompletedAt) {
        this.workItemCompletedAt = workItemCompletedAt;
        this.modify("work_item_completed_at", workItemCompletedAt);
        return this;
    }

    /**
    * 设置 [工作项优先级]
    */
    public SprintAlteration setWorkItemPriority(String workItemPriority) {
        this.workItemPriority = workItemPriority;
        this.modify("work_item_priority", workItemPriority);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public SprintAlteration setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [迭代标识]
    */
    public SprintAlteration setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
    * 设置 [工作项标识]
    */
    public SprintAlteration setWorkItemId(String workItemId) {
        this.workItemId = workItemId;
        this.modify("work_item_id", workItemId);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public SprintAlteration setWorkItemTitle(String workItemTitle) {
        this.workItemTitle = workItemTitle;
        this.modify("work_item_title", workItemTitle);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public SprintAlteration setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
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