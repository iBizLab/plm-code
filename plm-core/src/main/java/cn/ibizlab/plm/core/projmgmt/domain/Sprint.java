/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 迭代实体类[Sprint]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "SPRINT", resultMap = "SprintResultMap")
@ApiModel(value = "SPRINT", description = "迭代")
public class Sprint extends EntityMP implements Serializable
{

    /**
     * 开始时间
     */
    @TableField(value = "start_at")
    @DEField(name = "start_at")
    @JsonProperty("start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "start_at", notes = "开始时间")
    private Date startAt;

    /**
     * 结束时间
     */
    @TableField(value = "end_at")
    @DEField(name = "end_at")
    @JsonProperty("end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "end_at", notes = "结束时间")
    private Date endAt;

    /**
     * 描述
     */
    @TableField(value = "description")
    @DEField(name = "description")
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 状态
     */
    @TableField(value = "status")
    @DEField(name = "status" , defaultValue = "1" , dict = "Sprint_status")
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "status", notes = "状态")
    private String status;

    /**
     * 父名称
     */
    @TableField(value = "pname" , exist = false)
    @DEField(name = "pname")
    @JsonProperty("pname")
    @JSONField(name = "pname")
    @ApiModelProperty(value = "pname", notes = "父名称")
    private String pname;

    /**
     * 项目名称
     */
    @TableField(value = "project_name" , exist = false)
    @DEField(name = "project_name")
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "project_name", notes = "项目名称")
    private String projectName;

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
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

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
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

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
     * 产品标识
     */
    @TableField(value = "project_id")
    @DEField(name = "project_id")
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "project_id", notes = "产品标识")
    private String projectId;

    /**
     * 父标识
     */
    @TableField(value = "pid")
    @DEField(name = "pid")
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
     * 项目
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "project", notes = "项目-迭代")
    private Project project;

    /**
     * 迭代
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "sprint", notes = "名称")
    private Sprint sprint;

    /**
     * 设置 [开始时间]
     */
    public Sprint setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
     * 设置 [结束时间]
     */
    public Sprint setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public Sprint setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public Sprint setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [父名称]
     */
    public Sprint setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
        return this;
    }

    /**
     * 设置 [项目名称]
     */
    public Sprint setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public Sprint setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public Sprint setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [负责人标识]
     */
    public Sprint setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public Sprint setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [产品标识]
     */
    public Sprint setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public Sprint setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
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