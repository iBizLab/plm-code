/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
 * 迭代变更[SprintAlterationDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("迭代变更DTO")
public class SprintAlterationDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否删除", position = 0)
    private Integer isDeleted;

    /**
     * 类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "类型", position = 1)
    private String type;

    /**
     * 迭代状态
     */
    @JsonProperty("sprint_status")
    @JSONField(name = "sprint_status")
    @ApiModelProperty(value = "迭代状态", position = 2)
    private String sprintStatus;

    /**
     * 燃尽统计日期
     */
    @JsonProperty("rep_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "rep_date" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "燃尽统计日期", position = 3)
    private Date repDate;

    /**
     * 燃尽统计数值1
     */
    @JsonProperty("rep_value1")
    @JSONField(name = "rep_value1")
    @ApiModelProperty(value = "燃尽统计数值1", position = 4)
    private BigDecimal repValue1;

    /**
     * 燃尽统计数值2
     */
    @JsonProperty("rep_value2")
    @JSONField(name = "rep_value2")
    @ApiModelProperty(value = "燃尽统计数值2", position = 5)
    private BigDecimal repValue2;

    /**
     * 工作项完成时间
     */
    @JsonProperty("work_item_completed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "work_item_completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "工作项完成时间", position = 6)
    private Date workItemCompletedAt;

    /**
     * 工作项优先级
     */
    @JsonProperty("work_item_priority")
    @JSONField(name = "work_item_priority")
    @ApiModelProperty(value = "工作项优先级", position = 7)
    private String workItemPriority;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 8)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 9)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 10)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 11)
    private String name;

    /**
     * 迭代标识
     */
    @JsonProperty("sprint_id")
    @JSONField(name = "sprint_id")
    @ApiModelProperty(value = "迭代标识", position = 12)
    private String sprintId;

    /**
     * 名称
     */
    @JsonProperty("sprint_name")
    @JSONField(name = "sprint_name")
    @ApiModelProperty(value = "名称", position = 13)
    private String sprintName;

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
     * 工作项标识
     */
    @JsonProperty("work_item_id")
    @JSONField(name = "work_item_id")
    @ApiModelProperty(value = "工作项标识", position = 16)
    private String workItemId;

    /**
     * 标题
     */
    @JsonProperty("work_item_title")
    @JSONField(name = "work_item_title")
    @ApiModelProperty(value = "标题", position = 17)
    private String workItemTitle;


    /**
     * 设置 [是否删除]
     */
    public SprintAlterationDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [类型]
     */
    public SprintAlterationDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [迭代状态]
     */
    public SprintAlterationDTO setSprintStatus(String sprintStatus) {
        this.sprintStatus = sprintStatus;
        this.modify("sprint_status", sprintStatus);
        return this;
    }

    /**
     * 设置 [燃尽统计日期]
     */
    public SprintAlterationDTO setRepDate(Date repDate) {
        this.repDate = repDate;
        this.modify("rep_date", repDate);
        return this;
    }

    /**
     * 设置 [燃尽统计数值1]
     */
    public SprintAlterationDTO setRepValue1(BigDecimal repValue1) {
        this.repValue1 = repValue1;
        this.modify("rep_value1", repValue1);
        return this;
    }

    /**
     * 设置 [燃尽统计数值2]
     */
    public SprintAlterationDTO setRepValue2(BigDecimal repValue2) {
        this.repValue2 = repValue2;
        this.modify("rep_value2", repValue2);
        return this;
    }

    /**
     * 设置 [工作项完成时间]
     */
    public SprintAlterationDTO setWorkItemCompletedAt(Date workItemCompletedAt) {
        this.workItemCompletedAt = workItemCompletedAt;
        this.modify("work_item_completed_at", workItemCompletedAt);
        return this;
    }

    /**
     * 设置 [工作项优先级]
     */
    public SprintAlterationDTO setWorkItemPriority(String workItemPriority) {
        this.workItemPriority = workItemPriority;
        this.modify("work_item_priority", workItemPriority);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public SprintAlterationDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [迭代标识]
     */
    public SprintAlterationDTO setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public SprintAlterationDTO setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
     * 设置 [工作项标识]
     */
    public SprintAlterationDTO setWorkItemId(String workItemId) {
        this.workItemId = workItemId;
        this.modify("work_item_id", workItemId);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public SprintAlterationDTO setWorkItemTitle(String workItemTitle) {
        this.workItemTitle = workItemTitle;
        this.modify("work_item_title", workItemTitle);
        return this;
    }


}
