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
 * 关联[RelationDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("关联DTO")
public class RelationDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 重要程度
     */
    @JsonProperty("level")
    @JSONField(name = "level")
    @ApiModelProperty(value = "重要程度", position = 0)
    private String level;

    /**
     * 关联主体标识
     */
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "关联主体标识", position = 1)
    private String principalId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 2)
    private String ownerType;

    /**
     * 关联主体类型
     */
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "关联主体类型", position = 3)
    private String principalType;

    /**
     * 关联目标类型
     */
    @JsonProperty("target_type")
    @JSONField(name = "target_type")
    @ApiModelProperty(value = "关联目标类型", position = 4)
    private String targetType;

    /**
     * 目标主体标识
     */
    @JsonProperty("target_id")
    @JSONField(name = "target_id")
    @ApiModelProperty(value = "目标主体标识", position = 5)
    private String targetId;

    /**
     * 父对象版本标识
     */
    @JsonProperty("parent_version_id")
    @JSONField(name = "parent_version_id")
    @ApiModelProperty(value = "父对象版本标识", position = 6)
    private String parentVersionId;

    /**
     * 目标对象版本标识
     */
    @JsonProperty("target_version_id")
    @JSONField(name = "target_version_id")
    @ApiModelProperty(value = "目标对象版本标识", position = 7)
    private String targetVersionId;

    /**
     * 工作项
     */
    @JsonProperty("work_item")
    @JSONField(name = "work_item")
    @ApiModelProperty(value = "工作项", position = 8)
    private WorkItemDTO workItem;

    /**
     * 产品需求
     */
    @JsonProperty("idea")
    @JSONField(name = "idea")
    @ApiModelProperty(value = "产品需求", position = 9)
    private IdeaDTO idea;

    /**
     * 工单
     */
    @JsonProperty("ticket")
    @JSONField(name = "ticket")
    @ApiModelProperty(value = "工单", position = 10)
    private TicketDTO ticket;

    /**
     * 客户
     */
    @JsonProperty("customer")
    @JSONField(name = "customer")
    @ApiModelProperty(value = "客户", position = 11)
    private CustomerDTO customer;

    /**
     * 测试用例
     */
    @JsonProperty("test_case")
    @JSONField(name = "test_case")
    @ApiModelProperty(value = "测试用例", position = 12)
    private TestCaseDTO testCase;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 13)
    private String curVersionId;

    /**
     * 目标对象编号
     */
    @JsonProperty("target_identifier")
    @JSONField(name = "target_identifier")
    @ApiModelProperty(value = "目标对象编号", position = 14)
    private String targetIdentifier;

    /**
     * 目标对象标题
     */
    @JsonProperty("target_title")
    @JSONField(name = "target_title")
    @ApiModelProperty(value = "目标对象标题", position = 15)
    private String targetTitle;

    /**
     * 目标对象状态
     */
    @JsonProperty("target_state")
    @JSONField(name = "target_state")
    @ApiModelProperty(value = "目标对象状态", position = 16)
    private String targetState;

    /**
     * 目标对象负责人
     */
    @JsonProperty("target_assignee")
    @JSONField(name = "target_assignee")
    @ApiModelProperty(value = "目标对象负责人", position = 17)
    private String targetAssignee;

    /**
     * 关联类型
     */
    @JsonProperty("relation_type")
    @JSONField(name = "relation_type")
    @ApiModelProperty(value = "关联类型", position = 18)
    private String relationType;

    /**
     * 目标对象优先级
     */
    @JsonProperty("target_priority")
    @JSONField(name = "target_priority")
    @ApiModelProperty(value = "目标对象优先级", position = 19)
    private String targetPriority;

    /**
     * 目标对象父标识
     */
    @JsonProperty("target_parent_id")
    @JSONField(name = "target_parent_id")
    @ApiModelProperty(value = "目标对象父标识", position = 20)
    private String targetParentId;

    /**
     * 源工作项
     */
    @JsonProperty("principal_work_item")
    @JSONField(name = "principal_work_item")
    @ApiModelProperty(value = "源工作项", position = 21)
    private WorkItemDTO principalWorkItem;

    /**
     * 前后置任务
     */
    @JsonProperty("job_type")
    @JSONField(name = "job_type")
    @ApiModelProperty(value = "前后置任务", position = 22)
    private String jobType;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 23)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 24)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 25)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 26)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 27)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 28)
    private Date updateTime;


    /**
     * 设置 [重要程度]
     */
    public RelationDTO setLevel(String level) {
        this.level = level;
        this.modify("level", level);
        return this;
    }

    /**
     * 设置 [关联主体标识]
     */
    public RelationDTO setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
     * 设置 [所属数据对象]
     */
    public RelationDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [关联主体类型]
     */
    public RelationDTO setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
     * 设置 [关联目标类型]
     */
    public RelationDTO setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
     * 设置 [目标主体标识]
     */
    public RelationDTO setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
     * 设置 [目标对象版本标识]
     */
    public RelationDTO setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
     * 设置 [工作项]
     */
    public RelationDTO setWorkItem(WorkItemDTO workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
     * 设置 [产品需求]
     */
    public RelationDTO setIdea(IdeaDTO idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
     * 设置 [工单]
     */
    public RelationDTO setTicket(TicketDTO ticket) {
        this.ticket = ticket;
        this.modify("ticket", ticket);
        return this;
    }

    /**
     * 设置 [客户]
     */
    public RelationDTO setCustomer(CustomerDTO customer) {
        this.customer = customer;
        this.modify("customer", customer);
        return this;
    }

    /**
     * 设置 [测试用例]
     */
    public RelationDTO setTestCase(TestCaseDTO testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
     * 设置 [目标对象编号]
     */
    public RelationDTO setTargetIdentifier(String targetIdentifier) {
        this.targetIdentifier = targetIdentifier;
        this.modify("target_identifier", targetIdentifier);
        return this;
    }

    /**
     * 设置 [目标对象标题]
     */
    public RelationDTO setTargetTitle(String targetTitle) {
        this.targetTitle = targetTitle;
        this.modify("target_title", targetTitle);
        return this;
    }

    /**
     * 设置 [目标对象状态]
     */
    public RelationDTO setTargetState(String targetState) {
        this.targetState = targetState;
        this.modify("target_state", targetState);
        return this;
    }

    /**
     * 设置 [目标对象负责人]
     */
    public RelationDTO setTargetAssignee(String targetAssignee) {
        this.targetAssignee = targetAssignee;
        this.modify("target_assignee", targetAssignee);
        return this;
    }

    /**
     * 设置 [关联类型]
     */
    public RelationDTO setRelationType(String relationType) {
        this.relationType = relationType;
        this.modify("relation_type", relationType);
        return this;
    }

    /**
     * 设置 [目标对象优先级]
     */
    public RelationDTO setTargetPriority(String targetPriority) {
        this.targetPriority = targetPriority;
        this.modify("target_priority", targetPriority);
        return this;
    }

    /**
     * 设置 [目标对象父标识]
     */
    public RelationDTO setTargetParentId(String targetParentId) {
        this.targetParentId = targetParentId;
        this.modify("target_parent_id", targetParentId);
        return this;
    }

    /**
     * 设置 [源工作项]
     */
    public RelationDTO setPrincipalWorkItem(WorkItemDTO principalWorkItem) {
        this.principalWorkItem = principalWorkItem;
        this.modify("principal_work_item", principalWorkItem);
        return this;
    }

    /**
     * 设置 [前后置任务]
     */
    public RelationDTO setJobType(String jobType) {
        this.jobType = jobType;
        this.modify("job_type", jobType);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public RelationDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
