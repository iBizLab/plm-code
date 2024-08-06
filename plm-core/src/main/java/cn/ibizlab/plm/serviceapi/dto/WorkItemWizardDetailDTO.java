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
 * 工作项操作向导明细[WorkItemWizardDetailDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项操作向导明细DTO")
public class WorkItemWizardDetailDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 原工作项类型
     */
    @JsonProperty("origin_type")
    @JSONField(name = "origin_type")
    @ApiModelProperty(value = "原工作项类型", position = 0)
    private String originType;

    /**
     * 目标类型
     */
    @JsonProperty("target_type")
    @JSONField(name = "target_type")
    @ApiModelProperty(value = "目标类型", position = 1)
    private String targetType;

    /**
     * 状态变更
     */
    @JsonProperty("states")
    @JSONField(name = "states")
    @ApiModelProperty(value = "状态变更", position = 2)
    private List<Map> states;

    /**
     * 子工作项类型
     */
    @JsonProperty("child_work_item_types")
    @JSONField(name = "child_work_item_types")
    @ApiModelProperty(value = "子工作项类型", position = 3)
    private List<Map> childWorkItemTypes;

    /**
     * 属性补充集合
     */
    @JsonProperty("properties")
    @JSONField(name = "properties")
    @ApiModelProperty(value = "属性补充集合", position = 4)
    private List<Map> properties;

    /**
     * 影响工作项数量
     */
    @JsonProperty("influence")
    @JSONField(name = "influence")
    @ApiModelProperty(value = "影响工作项数量", position = 5)
    private Integer influence;

    /**
     * 目标工作项状态
     */
    @JsonProperty("target_state")
    @JSONField(name = "target_state")
    @ApiModelProperty(value = "目标工作项状态", position = 6)
    private String targetState;

    /**
     * 原工作项状态
     */
    @JsonProperty("origin_state")
    @JSONField(name = "origin_state")
    @ApiModelProperty(value = "原工作项状态", position = 7)
    private String originState;

    /**
     * 项目标识
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目标识", position = 8)
    private String projectId;

    /**
     * 工作项标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "工作项标题", position = 9)
    private String title;

    /**
     * 负责人
     */
    @JsonProperty("assigee_name")
    @JSONField(name = "assigee_name")
    @ApiModelProperty(value = "负责人", position = 10)
    private String assigeeName;

    /**
     * 优先级
     */
    @JsonProperty("priority")
    @JSONField(name = "priority")
    @ApiModelProperty(value = "优先级", position = 11)
    private String priority;

    /**
     * 目标父工作项
     */
    @JsonProperty("target_parent")
    @JSONField(name = "target_parent")
    @ApiModelProperty(value = "目标父工作项", position = 12)
    private String targetParent;

    /**
     * 原父工作项
     */
    @JsonProperty("origin_parent")
    @JSONField(name = "origin_parent")
    @ApiModelProperty(value = "原父工作项", position = 13)
    private String originParent;

    /**
     * 子工作项类型
     */
    @JsonProperty("child_type")
    @JSONField(name = "child_type")
    @ApiModelProperty(value = "子工作项类型", position = 14)
    private String childType;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 15)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 16)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 17)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 18)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 19)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 20)
    private Date updateTime;

    /**
     * 向导标识
     */
    @JsonProperty("wizard_id")
    @JSONField(name = "wizard_id")
    @ApiModelProperty(value = "向导标识", position = 21)
    private String wizardId;


    /**
     * 设置 [原工作项类型]
     */
    public WorkItemWizardDetailDTO setOriginType(String originType) {
        this.originType = originType;
        this.modify("origin_type", originType);
        return this;
    }

    /**
     * 设置 [目标类型]
     */
    public WorkItemWizardDetailDTO setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
     * 设置 [状态变更]
     */
    public WorkItemWizardDetailDTO setStates(List<Map> states) {
        this.states = states;
        this.modify("states", states);
        return this;
    }

    /**
     * 设置 [子工作项类型]
     */
    public WorkItemWizardDetailDTO setChildWorkItemTypes(List<Map> childWorkItemTypes) {
        this.childWorkItemTypes = childWorkItemTypes;
        this.modify("child_work_item_types", childWorkItemTypes);
        return this;
    }

    /**
     * 设置 [属性补充集合]
     */
    public WorkItemWizardDetailDTO setProperties(List<Map> properties) {
        this.properties = properties;
        this.modify("properties", properties);
        return this;
    }

    /**
     * 设置 [影响工作项数量]
     */
    public WorkItemWizardDetailDTO setInfluence(Integer influence) {
        this.influence = influence;
        this.modify("influence", influence);
        return this;
    }

    /**
     * 设置 [目标工作项状态]
     */
    public WorkItemWizardDetailDTO setTargetState(String targetState) {
        this.targetState = targetState;
        this.modify("target_state", targetState);
        return this;
    }

    /**
     * 设置 [原工作项状态]
     */
    public WorkItemWizardDetailDTO setOriginState(String originState) {
        this.originState = originState;
        this.modify("origin_state", originState);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public WorkItemWizardDetailDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [工作项标题]
     */
    public WorkItemWizardDetailDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public WorkItemWizardDetailDTO setAssigeeName(String assigeeName) {
        this.assigeeName = assigeeName;
        this.modify("assigee_name", assigeeName);
        return this;
    }

    /**
     * 设置 [优先级]
     */
    public WorkItemWizardDetailDTO setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
     * 设置 [目标父工作项]
     */
    public WorkItemWizardDetailDTO setTargetParent(String targetParent) {
        this.targetParent = targetParent;
        this.modify("target_parent", targetParent);
        return this;
    }

    /**
     * 设置 [原父工作项]
     */
    public WorkItemWizardDetailDTO setOriginParent(String originParent) {
        this.originParent = originParent;
        this.modify("origin_parent", originParent);
        return this;
    }

    /**
     * 设置 [子工作项类型]
     */
    public WorkItemWizardDetailDTO setChildType(String childType) {
        this.childType = childType;
        this.modify("child_type", childType);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public WorkItemWizardDetailDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [向导标识]
     */
    public WorkItemWizardDetailDTO setWizardId(String wizardId) {
        this.wizardId = wizardId;
        this.modify("wizard_id", wizardId);
        return this;
    }


}
