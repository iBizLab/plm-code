/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
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
 * 测试计划[TestPlanBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("测试计划DTO")
public class TestPlanBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别
     */
    @JsonProperty("categories_name")
    @JSONField(name = "categories_name")
    @ApiModelProperty(value = "类别", position = 0)
    private String categoriesName;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 1)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 2)
    private Date updateTime;

    /**
     * 计划开始
     */
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "计划开始", position = 3)
    private Date startAt;

    /**
     * 计划结束
     */
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "计划结束", position = 4)
    private Date endAt;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 5)
    private String assigneeName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 6)
    private String updateMan;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 7)
    private String createMan;

    /**
     * 负责人标识
     */
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "负责人标识", position = 8)
    private String assigneeId;

    /**
     * 计划名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "计划名称", position = 9)
    private String name;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 10)
    private String categories;

    /**
     * 测试库名称
     */
    @JsonProperty("library_identifier")
    @JSONField(name = "library_identifier")
    @ApiModelProperty(value = "测试库名称", position = 11)
    private String libraryIdentifier;

    /**
     * 项目类型
     */
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "项目类型", position = 12)
    private String projectType;

    /**
     * 关联项目
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "关联项目", position = 13)
    private String projectName;

    /**
     * 关联迭代
     */
    @JsonProperty("sprint_name")
    @JSONField(name = "sprint_name")
    @ApiModelProperty(value = "关联迭代", position = 14)
    private String sprintName;

    /**
     * 名称
     */
    @JsonProperty("release_name")
    @JSONField(name = "release_name")
    @ApiModelProperty(value = "名称", position = 15)
    private String releaseName;

    /**
     * 所属测试库
     */
    @JsonProperty("library_name")
    @JSONField(name = "library_name")
    @ApiModelProperty(value = "所属测试库", position = 16)
    private String libraryName;

    /**
     * 关联项目
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "关联项目", position = 17)
    private String projectId;

    /**
     * 测试库标识
     */
    @JsonProperty("library_id")
    @JSONField(name = "library_id")
    @ApiModelProperty(value = "测试库标识", position = 18)
    private String libraryId;

    /**
     * 项目发布标识
     */
    @JsonProperty("release_id")
    @JSONField(name = "release_id")
    @ApiModelProperty(value = "项目发布标识", position = 19)
    private String releaseId;

    /**
     * 关联迭代
     */
    @JsonProperty("sprint_id")
    @JSONField(name = "sprint_id")
    @ApiModelProperty(value = "关联迭代", position = 20)
    private String sprintId;

    /**
     * 测试分类
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "测试分类", position = 21)
    private String type;

    /**
     * 状态
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "状态", position = 22)
    private String status;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 23)
    private String id;

    /**
     * 测试库是否删除
     */
    @JsonProperty("library_is_deleted")
    @JSONField(name = "library_is_deleted")
    @ApiModelProperty(value = "测试库是否删除", position = 24)
    private Integer libraryIsDeleted;


    /**
     * 设置 [类别]
     */
    public TestPlanBiSearchGroupDTO setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
     * 设置 [计划开始]
     */
    public TestPlanBiSearchGroupDTO setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [计划结束]
     */
    public TestPlanBiSearchGroupDTO setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public TestPlanBiSearchGroupDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public TestPlanBiSearchGroupDTO setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [计划名称]
     */
    public TestPlanBiSearchGroupDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public TestPlanBiSearchGroupDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [测试库名称]
     */
    public TestPlanBiSearchGroupDTO setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public TestPlanBiSearchGroupDTO setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [关联项目]
     */
    public TestPlanBiSearchGroupDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [关联迭代]
     */
    public TestPlanBiSearchGroupDTO setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public TestPlanBiSearchGroupDTO setReleaseName(String releaseName) {
        this.releaseName = releaseName;
        this.modify("release_name", releaseName);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public TestPlanBiSearchGroupDTO setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
     * 设置 [关联项目]
     */
    public TestPlanBiSearchGroupDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public TestPlanBiSearchGroupDTO setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
     * 设置 [项目发布标识]
     */
    public TestPlanBiSearchGroupDTO setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }

    /**
     * 设置 [关联迭代]
     */
    public TestPlanBiSearchGroupDTO setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
     * 设置 [测试分类]
     */
    public TestPlanBiSearchGroupDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public TestPlanBiSearchGroupDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [测试库是否删除]
     */
    public TestPlanBiSearchGroupDTO setLibraryIsDeleted(Integer libraryIsDeleted) {
        this.libraryIsDeleted = libraryIsDeleted;
        this.modify("library_is_deleted", libraryIsDeleted);
        return this;
    }


}
