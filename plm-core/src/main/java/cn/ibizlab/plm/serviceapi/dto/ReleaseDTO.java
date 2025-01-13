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
 * 项目发布[ReleaseDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("项目发布DTO")
public class ReleaseDTO extends DTOBase implements Serializable {

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
     * 发布时间
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "发布时间", position = 1)
    private Date endAt;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 2)
    private String description;

    /**
     * 阶段
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "阶段", position = 3)
    private String status;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 4)
    private String categories;

    /**
     * 类别
     */
    @JsonProperty("categories_name")
    @JSONField(name = "categories_name")
    @ApiModelProperty(value = "类别", position = 5)
    private String categoriesName;

    /**
     * 发布阶段
     */
    @JsonProperty("stage_transitions")
    @JSONField(name = "stage_transitions")
    @ApiModelProperty(value = "发布阶段", position = 6)
    private List<StageDTO> stageTransitions;

    /**
     * 进度
     */
    @JsonProperty("schedule")
    @JSONField(name = "schedule")
    @ApiModelProperty(value = "进度", position = 7)
    private BigDecimal schedule;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 8)
    private String assigneeName;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 9)
    private String assigneeId;

    /**
     * 已完成工作项数
     */
    @JsonProperty("completed_work_items")
    @JSONField(name = "completed_work_items")
    @ApiModelProperty(value = "已完成工作项数", position = 10)
    private BigDecimal completedWorkItems;

    /**
     * 全部工作项数
     */
    @JsonProperty("all_work_items")
    @JSONField(name = "all_work_items")
    @ApiModelProperty(value = "全部工作项数", position = 11)
    private BigDecimal allWorkItems;

    /**
     * 项目是否删除
     */
    @JsonProperty("project_is_deleted")
    @JSONField(name = "project_is_deleted")
    @ApiModelProperty(value = "项目是否删除", position = 12)
    private Integer projectIsDeleted;

    /**
     * 项目类型
     */
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "项目类型", position = 13)
    private String projectType;

    /**
     * 发布年份
     */
    @JsonProperty("end_year")
    @JSONField(name = "end_year")
    @ApiModelProperty(value = "发布年份", position = 14)
    private String endYear;

    /**
     * 发布日志
     */
    @JsonProperty("changelog")
    @JSONField(name = "changelog")
    @ApiModelProperty(value = "发布日志", position = 15)
    private String changelog;

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
     * 项目标识
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目标识", position = 20)
    private String projectId;

    /**
     * 项目名称
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "项目名称", position = 21)
    private String projectName;

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
    public ReleaseDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [发布时间]
     */
    public ReleaseDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public ReleaseDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [阶段]
     */
    public ReleaseDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public ReleaseDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public ReleaseDTO setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
     * 设置 [发布阶段]
     */
    public ReleaseDTO setStageTransitions(List<StageDTO> stageTransitions) {
        this.stageTransitions = stageTransitions;
        this.modify("stage_transitions", stageTransitions);
        return this;
    }

    /**
     * 设置 [进度]
     */
    public ReleaseDTO setSchedule(BigDecimal schedule) {
        this.schedule = schedule;
        this.modify("schedule", schedule);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public ReleaseDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public ReleaseDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [已完成工作项数]
     */
    public ReleaseDTO setCompletedWorkItems(BigDecimal completedWorkItems) {
        this.completedWorkItems = completedWorkItems;
        this.modify("completed_work_items", completedWorkItems);
        return this;
    }

    /**
     * 设置 [全部工作项数]
     */
    public ReleaseDTO setAllWorkItems(BigDecimal allWorkItems) {
        this.allWorkItems = allWorkItems;
        this.modify("all_work_items", allWorkItems);
        return this;
    }

    /**
     * 设置 [项目是否删除]
     */
    public ReleaseDTO setProjectIsDeleted(Integer projectIsDeleted) {
        this.projectIsDeleted = projectIsDeleted;
        this.modify("project_is_deleted", projectIsDeleted);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public ReleaseDTO setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [发布年份]
     */
    public ReleaseDTO setEndYear(String endYear) {
        this.endYear = endYear;
        this.modify("end_year", endYear);
        return this;
    }

    /**
     * 设置 [发布日志]
     */
    public ReleaseDTO setChangelog(String changelog) {
        this.changelog = changelog;
        this.modify("changelog", changelog);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReleaseDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public ReleaseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [项目名称]
     */
    public ReleaseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }


}
