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
 * 迭代[SprintDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("迭代DTO")
public class SprintDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开始时间
     */
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间", position = 0)
    private Date startAt;

    /**
     * 结束时间
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间", position = 1)
    private Date endAt;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 2)
    private String description;

    /**
     * 状态
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "状态", position = 3)
    private String status;

    /**
     * 父名称
     */
    @JsonProperty("pname")
    @JSONField(name = "pname")
    @ApiModelProperty(value = "父名称", position = 4)
    private String pname;

    /**
     * 项目名称
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "项目名称", position = 5)
    private String projectName;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 6)
    private String categories;

    /**
     * 类别
     */
    @JsonProperty("categories_name")
    @JSONField(name = "categories_name")
    @ApiModelProperty(value = "类别", position = 7)
    private String categoriesName;

    /**
     * 进度
     */
    @JsonProperty("schedule")
    @JSONField(name = "schedule")
    @ApiModelProperty(value = "进度", position = 8)
    private BigDecimal schedule;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 9)
    private String assigneeName;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 10)
    private String assigneeId;

    /**
     * 已完成工作项数
     */
    @JsonProperty("completed_work_items")
    @JSONField(name = "completed_work_items")
    @ApiModelProperty(value = "已完成工作项数", position = 11)
    private BigDecimal completedWorkItems;

    /**
     * 全部工作项数
     */
    @JsonProperty("all_work_items")
    @JSONField(name = "all_work_items")
    @ApiModelProperty(value = "全部工作项数", position = 12)
    private BigDecimal allWorkItems;

    /**
     * 迭代已过天数
     */
    @JsonProperty("past_days")
    @JSONField(name = "past_days")
    @ApiModelProperty(value = "迭代已过天数", position = 13)
    private BigDecimal pastDays;

    /**
     * 项目是否删除
     */
    @JsonProperty("project_is_deleted")
    @JSONField(name = "project_is_deleted")
    @ApiModelProperty(value = "项目是否删除", position = 14)
    private Integer projectIsDeleted;

    /**
     * 项目类型
     */
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "项目类型", position = 15)
    private String projectType;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 16)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 17)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 18)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 19)
    private String name;

    /**
     * 父标识
     */
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "父标识", position = 20)
    private String pid;

    /**
     * 项目标识
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目标识", position = 21)
    private String projectId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 22)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 23)
    private Date updateTime;


    /**
     * 设置 [开始时间]
     */
    public SprintDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [结束时间]
     */
    public SprintDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public SprintDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public SprintDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [父名称]
     */
    public SprintDTO setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
        return this;
    }

    /**
     * 设置 [项目名称]
     */
    public SprintDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public SprintDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public SprintDTO setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
     * 设置 [进度]
     */
    public SprintDTO setSchedule(BigDecimal schedule) {
        this.schedule = schedule;
        this.modify("schedule", schedule);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public SprintDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public SprintDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [已完成工作项数]
     */
    public SprintDTO setCompletedWorkItems(BigDecimal completedWorkItems) {
        this.completedWorkItems = completedWorkItems;
        this.modify("completed_work_items", completedWorkItems);
        return this;
    }

    /**
     * 设置 [全部工作项数]
     */
    public SprintDTO setAllWorkItems(BigDecimal allWorkItems) {
        this.allWorkItems = allWorkItems;
        this.modify("all_work_items", allWorkItems);
        return this;
    }

    /**
     * 设置 [迭代已过天数]
     */
    public SprintDTO setPastDays(BigDecimal pastDays) {
        this.pastDays = pastDays;
        this.modify("past_days", pastDays);
        return this;
    }

    /**
     * 设置 [项目是否删除]
     */
    public SprintDTO setProjectIsDeleted(Integer projectIsDeleted) {
        this.projectIsDeleted = projectIsDeleted;
        this.modify("project_is_deleted", projectIsDeleted);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public SprintDTO setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public SprintDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public SprintDTO setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public SprintDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }


}
