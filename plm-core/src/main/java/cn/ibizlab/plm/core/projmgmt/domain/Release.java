/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.Stage;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 项目发布实体类[Release]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "PROJECT_RELEASE", resultMap = "ReleaseResultMap")
@ApiModel(value = "RELEASE", description = "项目发布")
public class Release extends EntityMP implements Serializable
{

    /**
    * 开始时间
    */
    @TableField(value = "start_at")
    @DEField(name = "start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @JsonProperty("start_at")
    @ApiModelProperty(value = "start_at", notes = "开始时间")
    private Date startAt;

    /**
    * 发布时间
    */
    @TableField(value = "end_at")
    @DEField(name = "end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @JsonProperty("end_at")
    @ApiModelProperty(value = "end_at", notes = "发布时间")
    private Date endAt;

    /**
    * 描述
    */
    @TableField(value = "description")
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
    * 发布进度
    */
    @TableField(value = "progress")
    @DEField(name = "progress")
    @JSONField(name = "progress")
    @JsonProperty("progress")
    @ApiModelProperty(value = "progress", notes = "发布进度")
    private BigDecimal progress;

    /**
    * 阶段
    */
    @TableField(value = "status")
    @DEField(name = "status" , defaultValue = "10" , dict = "release_stage")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty(value = "status", notes = "阶段")
    private String status;

    /**
    * 类别
    */
    @TableField(value = "categories")
    @DEField(name = "categories" , dict = "category")
    @JSONField(name = "categories")
    @JsonProperty("categories")
    @ApiModelProperty(value = "categories", notes = "类别")
    private String categories;

    /**
    * 类别
    */
    @TableField(value = "categories_name" , exist = false)
    @DEField(name = "categories_name")
    @JSONField(name = "categories_name")
    @JsonProperty("categories_name")
    @ApiModelProperty(value = "categories_name", notes = "类别")
    private String categoriesName;

    /**
    * 负责人
    */
    @TableField(value = "assignee_name")
    @DEField(name = "assignee_name")
    @JSONField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
    * 负责人标识
    */
    @TableField(value = "assignee_id")
    @DEField(name = "assignee_id")
    @JSONField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人标识")
    private String assigneeId;

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
    * 项目标识
    */
    @TableField(value = "project_id")
    @DEField(name = "project_id")
    @JSONField(name = "project_id")
    @JsonProperty("project_id")
    @ApiModelProperty(value = "project_id", notes = "项目标识")
    private String projectId;

    /**
    * 项目名称
    */
    @TableField(value = "project_name" , exist = false)
    @DEField(name = "project_name")
    @JSONField(name = "project_name")
    @JsonProperty("project_name")
    @ApiModelProperty(value = "project_name", notes = "项目名称")
    private String projectName;

    /**
    * 项目
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "项目")
    private Project project;

    /**
    * 设置 [开始时间]
    */
    public Release setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
    * 设置 [发布时间]
    */
    public Release setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Release setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [发布进度]
    */
    public Release setProgress(BigDecimal progress) {
        this.progress = progress;
        this.modify("progress", progress);
        return this;
    }

    /**
    * 设置 [阶段]
    */
    public Release setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public Release setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public Release setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public Release setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
    * 设置 [负责人标识]
    */
    public Release setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Release setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [项目标识]
    */
    public Release setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
    * 设置 [项目名称]
    */
    public Release setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
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