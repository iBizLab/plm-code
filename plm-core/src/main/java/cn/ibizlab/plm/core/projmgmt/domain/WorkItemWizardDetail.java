/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemWizard;

/**
 * 工作项操作向导明细实体类[WorkItemWizardDetail]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "WORK_ITEM_WIZARD_DETAIL", description = "工作项操作向导明细")
public class WorkItemWizardDetail extends EntityBase implements Serializable
{
    /**
     * 原工作项类型
     */
    @DEField(name = "origin_type" , dict = "work_item_type")
    @JSONField(name = "origin_type")
    @JsonProperty("origin_type")
    @ApiModelProperty(value = "origin_type", notes = "原工作项类型")
    private String originType;

    /**
     * 目标类型
     */
    @DEField(name = "target_type" , dict = "work_item_type")
    @JSONField(name = "target_type")
    @JsonProperty("target_type")
    @ApiModelProperty(value = "target_type", notes = "目标类型")
    private String targetType;

    /**
     * 状态变更
     */
    @DEField(name = "states")
    @JSONField(name = "states")
    @JsonProperty("states")
    @ApiModelProperty(value = "states", notes = "状态变更")
    private List<Map> states;

    /**
     * 子工作项类型
     */
    @DEField(name = "child_work_item_types")
    @JSONField(name = "child_work_item_types")
    @JsonProperty("child_work_item_types")
    @ApiModelProperty(value = "child_work_item_types", notes = "子工作项类型")
    private List<Map> childWorkItemTypes;

    /**
     * 属性补充集合
     */
    @DEField(name = "properties")
    @JSONField(name = "properties")
    @JsonProperty("properties")
    @ApiModelProperty(value = "properties", notes = "属性补充集合")
    private List<Map> properties;

    /**
     * 影响工作项数量
     */
    @DEField(name = "influence")
    @JSONField(name = "influence")
    @JsonProperty("influence")
    @ApiModelProperty(value = "influence", notes = "影响工作项数量")
    private Integer influence;

    /**
     * 目标工作项状态
     */
    @DEField(name = "target_state" , dict = "scrum_state")
    @JSONField(name = "target_state")
    @JsonProperty("target_state")
    @ApiModelProperty(value = "target_state", notes = "目标工作项状态")
    private String targetState;

    /**
     * 原工作项状态
     */
    @DEField(name = "origin_state" , dict = "scrum_state")
    @JSONField(name = "origin_state")
    @JsonProperty("origin_state")
    @ApiModelProperty(value = "origin_state", notes = "原工作项状态")
    private String originState;

    /**
     * 项目标识
     */
    @DEField(name = "project_id")
    @JSONField(name = "project_id")
    @JsonProperty("project_id")
    @ApiModelProperty(value = "project_id", notes = "项目标识")
    private String projectId;

    /**
     * 工作项标题
     */
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "工作项标题")
    private String title;

    /**
     * 负责人
     */
    @DEField(name = "assignee_name")
    @JSONField(name = "assigee_name")
    @JsonProperty("assigee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigeeName;

    /**
     * 优先级
     */
    @DEField(name = "priority" , dict = "work_item_priority")
    @JSONField(name = "priority")
    @JsonProperty("priority")
    @ApiModelProperty(value = "priority", notes = "优先级")
    private String priority;

    /**
     * 目标父工作项
     */
    @DEField(name = "target_parent")
    @JSONField(name = "target_parent")
    @JsonProperty("target_parent")
    @ApiModelProperty(value = "target_parent", notes = "目标父工作项")
    private String targetParent;

    /**
     * 原父工作项
     */
    @DEField(name = "origin_parent")
    @JSONField(name = "origin_parent")
    @JsonProperty("origin_parent")
    @ApiModelProperty(value = "origin_parent", notes = "原父工作项")
    private String originParent;

    /**
     * 子工作项类型
     */
    @DEField(name = "child_type" , dict = "work_item_type")
    @JSONField(name = "child_type")
    @JsonProperty("child_type")
    @ApiModelProperty(value = "child_type", notes = "子工作项类型")
    private String childType;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 向导标识
     */
    @DEField(name = "wizard_id")
    @JSONField(name = "wizard_id")
    @JsonProperty("wizard_id")
    @ApiModelProperty(value = "wizard_id", notes = "向导标识")
    private String wizardId;

    /**
     * 工作项操作向导-明细
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item_wizard", notes = "工作项操作向导-明细")
    private WorkItemWizard workItemWizard;

    /**
    * 设置 [原工作项类型]
    */
    public WorkItemWizardDetail setOriginType(String originType) {
        this.originType = originType;
        this.modify("origin_type", originType);
        return this;
    }

    /**
    * 设置 [目标类型]
    */
    public WorkItemWizardDetail setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
    * 设置 [状态变更]
    */
    public WorkItemWizardDetail setStates(List<Map> states) {
        this.states = states;
        this.modify("states", states);
        return this;
    }

    /**
    * 设置 [子工作项类型]
    */
    public WorkItemWizardDetail setChildWorkItemTypes(List<Map> childWorkItemTypes) {
        this.childWorkItemTypes = childWorkItemTypes;
        this.modify("child_work_item_types", childWorkItemTypes);
        return this;
    }

    /**
    * 设置 [属性补充集合]
    */
    public WorkItemWizardDetail setProperties(List<Map> properties) {
        this.properties = properties;
        this.modify("properties", properties);
        return this;
    }

    /**
    * 设置 [影响工作项数量]
    */
    public WorkItemWizardDetail setInfluence(Integer influence) {
        this.influence = influence;
        this.modify("influence", influence);
        return this;
    }

    /**
    * 设置 [目标工作项状态]
    */
    public WorkItemWizardDetail setTargetState(String targetState) {
        this.targetState = targetState;
        this.modify("target_state", targetState);
        return this;
    }

    /**
    * 设置 [原工作项状态]
    */
    public WorkItemWizardDetail setOriginState(String originState) {
        this.originState = originState;
        this.modify("origin_state", originState);
        return this;
    }

    /**
    * 设置 [项目标识]
    */
    public WorkItemWizardDetail setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
    * 设置 [工作项标题]
    */
    public WorkItemWizardDetail setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public WorkItemWizardDetail setAssigeeName(String assigeeName) {
        this.assigeeName = assigeeName;
        this.modify("assigee_name", assigeeName);
        return this;
    }

    /**
    * 设置 [优先级]
    */
    public WorkItemWizardDetail setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
    * 设置 [目标父工作项]
    */
    public WorkItemWizardDetail setTargetParent(String targetParent) {
        this.targetParent = targetParent;
        this.modify("target_parent", targetParent);
        return this;
    }

    /**
    * 设置 [原父工作项]
    */
    public WorkItemWizardDetail setOriginParent(String originParent) {
        this.originParent = originParent;
        this.modify("origin_parent", originParent);
        return this;
    }

    /**
    * 设置 [子工作项类型]
    */
    public WorkItemWizardDetail setChildType(String childType) {
        this.childType = childType;
        this.modify("child_type", childType);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public WorkItemWizardDetail setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [向导标识]
    */
    public WorkItemWizardDetail setWizardId(String wizardId) {
        this.wizardId = wizardId;
        this.modify("wizard_id", wizardId);
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