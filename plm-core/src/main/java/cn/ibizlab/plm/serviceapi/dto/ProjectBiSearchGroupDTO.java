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
 * 项目[ProjectBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("项目DTO")
public class ProjectBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 0)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 1)
    private Integer isDeleted;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 2)
    private Date updateTime;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 3)
    private Date createTime;

    /**
     * 开始时间
     */
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间", position = 4)
    private Date startAt;

    /**
     * 结束时间
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间", position = 5)
    private Date endAt;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 6)
    private String assigneeName;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 7)
    private String assigneeId;

    /**
     * 所属对象
     */
    @JsonProperty("scope_id")
    @JSONField(name = "scope_id")
    @ApiModelProperty(value = "所属对象", position = 8)
    private String scopeId;

    /**
     * 项目名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "项目名称", position = 9)
    private String name;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 10)
    private String createMan;

    /**
     * 项目标识
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "项目标识", position = 11)
    private String identifier;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 12)
    private String updateMan;

    /**
     * 已完成工作项数
     */
    @JsonProperty("completed_work_items")
    @JSONField(name = "completed_work_items")
    @ApiModelProperty(value = "已完成工作项数", position = 13)
    private BigDecimal completedWorkItems;

    /**
     * 全部工作项数
     */
    @JsonProperty("all_work_items")
    @JSONField(name = "all_work_items")
    @ApiModelProperty(value = "全部工作项数", position = 14)
    private BigDecimal allWorkItems;

    /**
     * 进度
     */
    @JsonProperty("schedule")
    @JSONField(name = "schedule")
    @ApiModelProperty(value = "进度", position = 15)
    private BigDecimal schedule;

    /**
     * 可见范围
     */
    @JsonProperty("visibility")
    @JSONField(name = "visibility")
    @ApiModelProperty(value = "可见范围", position = 16)
    private String visibility;

    /**
     * 所属
     */
    @JsonProperty("scope_type")
    @JSONField(name = "scope_type")
    @ApiModelProperty(value = "所属", position = 17)
    private String scopeType;

    /**
     * 类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "类型", position = 18)
    private String type;

    /**
     * 项目状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "项目状态", position = 19)
    private String state;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 20)
    private String id;


    /**
     * 设置 [是否已归档]
     */
    public ProjectBiSearchGroupDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public ProjectBiSearchGroupDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [开始时间]
     */
    public ProjectBiSearchGroupDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [结束时间]
     */
    public ProjectBiSearchGroupDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public ProjectBiSearchGroupDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public ProjectBiSearchGroupDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [所属对象]
     */
    public ProjectBiSearchGroupDTO setScopeId(String scopeId) {
        this.scopeId = scopeId;
        this.modify("scope_id", scopeId);
        return this;
    }

    /**
     * 设置 [项目名称]
     */
    public ProjectBiSearchGroupDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public ProjectBiSearchGroupDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [已完成工作项数]
     */
    public ProjectBiSearchGroupDTO setCompletedWorkItems(BigDecimal completedWorkItems) {
        this.completedWorkItems = completedWorkItems;
        this.modify("completed_work_items", completedWorkItems);
        return this;
    }

    /**
     * 设置 [全部工作项数]
     */
    public ProjectBiSearchGroupDTO setAllWorkItems(BigDecimal allWorkItems) {
        this.allWorkItems = allWorkItems;
        this.modify("all_work_items", allWorkItems);
        return this;
    }

    /**
     * 设置 [进度]
     */
    public ProjectBiSearchGroupDTO setSchedule(BigDecimal schedule) {
        this.schedule = schedule;
        this.modify("schedule", schedule);
        return this;
    }

    /**
     * 设置 [可见范围]
     */
    public ProjectBiSearchGroupDTO setVisibility(String visibility) {
        this.visibility = visibility;
        this.modify("visibility", visibility);
        return this;
    }

    /**
     * 设置 [所属]
     */
    public ProjectBiSearchGroupDTO setScopeType(String scopeType) {
        this.scopeType = scopeType;
        this.modify("scope_type", scopeType);
        return this;
    }

    /**
     * 设置 [类型]
     */
    public ProjectBiSearchGroupDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [项目状态]
     */
    public ProjectBiSearchGroupDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }


}
