/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.core.projmgmt.domain.Sprint;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 测试计划实体类[TestPlan]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "TEST_PLAN", resultMap = "TestPlanResultMap")
@ApiModel(value = "TEST_PLAN", description = "测试计划")
public class TestPlan extends EntityMP implements Serializable
{

    /**
     * 状态
     */
    @TableField(value = "status")
    @DEField(name = "status" , defaultValue = "pending" , dict = "test_plan_status")
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "status", notes = "状态")
    private String status;

    /**
     * 测试分类
     */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "test_plan_type")
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "type", notes = "测试分类")
    private String type;

    /**
     * 计划开始
     */
    @TableField(value = "start_at")
    @DEField(name = "start_at")
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "start_at", notes = "计划开始")
    private Date startAt;

    /**
     * 计划结束
     */
    @TableField(value = "end_at")
    @DEField(name = "end_at")
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "end_at", notes = "计划结束")
    private Date endAt;

    /**
     * 测试报告概要
     */
    @TableField(value = "summary")
    @DEField(name = "summary")
    @JsonProperty("summary")
    @JSONField(name = "summary")
    @ApiModelProperty(value = "summary", notes = "测试报告概要")
    private String summary;

    /**
     * 类别
     */
    @TableField(value = "categories")
    @DEField(name = "categories")
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "categories", notes = "类别")
    private String categories;

    /**
     * 关联缺陷
     */
    @TableField(exist = false)
    @DEField(name = "work_item_relations")
    @JsonProperty("work_item_relations")
    @JSONField(name = "work_item_relations")
    @ApiModelProperty(value = "work_item_relations", notes = "关联缺陷")
    private List<Relation> workItemRelations;

    /**
     * 负责人
     */
    @TableField(value = "assignee_name")
    @DEField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
     * 负责人标识
     */
    @TableField(value = "assignee_id")
    @DEField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @JSONField(name = "assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人标识")
    private String assigneeId;

    /**
     * 项目类型
     */
    @TableField(value = "project_type" , exist = false)
    @DEField(name = "project_type" , dict = "project_type")
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "project_type", notes = "项目类型")
    private String projectType;

    /**
     * 测试库名称
     */
    @TableField(value = "library_identifier" , exist = false)
    @DEField(name = "library_identifier")
    @JsonProperty("library_identifier")
    @JSONField(name = "library_identifier")
    @ApiModelProperty(value = "library_identifier", notes = "测试库名称")
    private String libraryIdentifier;

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
     * 计划名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "计划名称")
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
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 测试库标识
     */
    @TableField(value = "library_id")
    @DEField(name = "library_id")
    @JsonProperty("library_id")
    @JSONField(name = "library_id")
    @ApiModelProperty(value = "library_id", notes = "测试库标识")
    private String libraryId;

    /**
     * 关联项目
     */
    @TableField(value = "project_id")
    @DEField(name = "project_id")
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "project_id", notes = "关联项目")
    private String projectId;

    /**
     * 关联迭代
     */
    @TableField(value = "sprint_id")
    @DEField(name = "sprint_id")
    @JsonProperty("sprint_id")
    @JSONField(name = "sprint_id")
    @ApiModelProperty(value = "sprint_id", notes = "关联迭代")
    private String sprintId;

    /**
     * 关联项目
     */
    @TableField(value = "project_name" , exist = false)
    @DEField(name = "project_name")
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "project_name", notes = "关联项目")
    private String projectName;

    /**
     * 关联迭代
     */
    @TableField(value = "sprint_name" , exist = false)
    @DEField(name = "sprint_name")
    @JsonProperty("sprint_name")
    @JSONField(name = "sprint_name")
    @ApiModelProperty(value = "sprint_name", notes = "关联迭代")
    private String sprintName;

    /**
     * 所属测试库
     */
    @TableField(value = "library_name" , exist = false)
    @DEField(name = "library_name")
    @JsonProperty("library_name")
    @JSONField(name = "library_name")
    @ApiModelProperty(value = "library_name", notes = "所属测试库")
    private String libraryName;

    /**
     * 项目发布标识
     */
    @TableField(value = "release_id")
    @DEField(name = "release_id")
    @JsonProperty("release_id")
    @JSONField(name = "release_id")
    @ApiModelProperty(value = "release_id", notes = "项目发布标识")
    private String releaseId;

    /**
     * 名称
     */
    @TableField(value = "release_name" , exist = false)
    @DEField(name = "release_name")
    @JsonProperty("release_name")
    @JSONField(name = "release_name")
    @ApiModelProperty(value = "release_name", notes = "名称")
    private String releaseName;

    /**
     * 测试库
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "library", notes = "测试库-计划")
    private Library library;

    /**
     * 项目
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "project", notes = "项目")
    private Project project;

    /**
     * 项目发布
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "release", notes = "项目发布")
    private Release release;

    /**
     * 迭代
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "sprint", notes = "迭代")
    private Sprint sprint;

    /**
     * 设置 [状态]
     */
    public TestPlan setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [测试分类]
     */
    public TestPlan setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [计划开始]
     */
    public TestPlan setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [计划结束]
     */
    public TestPlan setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [测试报告概要]
     */
    public TestPlan setSummary(String summary) {
        this.summary = summary;
        this.modify("summary", summary);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public TestPlan setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [关联缺陷]
     */
    public TestPlan setWorkItemRelations(List<Relation> workItemRelations) {
        this.workItemRelations = workItemRelations;
        this.modify("work_item_relations", workItemRelations);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public TestPlan setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public TestPlan setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public TestPlan setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [测试库名称]
     */
    public TestPlan setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
     * 设置 [计划名称]
     */
    public TestPlan setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public TestPlan setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
     * 设置 [关联项目]
     */
    public TestPlan setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [关联迭代]
     */
    public TestPlan setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
     * 设置 [关联项目]
     */
    public TestPlan setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [关联迭代]
     */
    public TestPlan setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
     * 设置 [所属测试库]
     */
    public TestPlan setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
     * 设置 [项目发布标识]
     */
    public TestPlan setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public TestPlan setReleaseName(String releaseName) {
        this.releaseName = releaseName;
        this.modify("release_name", releaseName);
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