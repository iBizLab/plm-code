/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@MINHERIT}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.base.domain.Baseline;

/**
 * 基线工作项实体类[BaselineWorkItem]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "BASELINE_WORK_ITEM", description = "基线工作项")
public class BaselineWorkItem extends EntityBase implements Serializable
{
    /**
     * 关联主体标识
     */
    @DEField(name = "principal_id")
    @JSONField(name = "principal_id")
    @JsonProperty("principal_id")
    @ApiModelProperty(value = "principal_id", notes = "关联主体标识")
    private String principalId;

    /**
     * 所属数据对象
     */
    @DEField(name = "owner_type")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 关联主体类型
     */
    @DEField(name = "principal_type")
    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    @ApiModelProperty(value = "principal_type", notes = "关联主体类型")
    private String principalType;

    /**
     * 关联目标类型
     */
    @DEField(name = "target_type")
    @JSONField(name = "target_type")
    @JsonProperty("target_type")
    @ApiModelProperty(value = "target_type", notes = "关联目标类型")
    private String targetType;

    /**
     * 关联目标标识
     */
    @DEField(name = "target_id")
    @JSONField(name = "target_id")
    @JsonProperty("target_id")
    @ApiModelProperty(value = "target_id", notes = "关联目标标识")
    private String targetId;

    /**
     * 目标对象版本标识
     */
    @DEField(name = "target_version_id")
    @JSONField(name = "target_version_id")
    @JsonProperty("target_version_id")
    @ApiModelProperty(value = "target_version_id", notes = "目标对象版本标识")
    private String targetVersionId;

    /**
     * 项目
     */
    @DEField(name = "project_id")
    @JSONField(name = "project_id")
    @JsonProperty("project_id")
    @ApiModelProperty(value = "project_id", notes = "项目")
    private String projectId;

    /**
     * 编号
     */
    @DEField(name = "show_identifier")
    @JSONField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
     * 父工作项
     */
    @DEField(name = "ptitle")
    @JSONField(name = "ptitle")
    @JsonProperty("ptitle")
    @ApiModelProperty(value = "ptitle", notes = "父工作项")
    private String ptitle;

    /**
     * 标题
     */
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
     * 状态
     */
    @DEField(name = "state" , dict = "work_item_state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "状态")
    private String state;

    /**
     * 负责人
     */
    @DEField(name = "assignee_id")
    @JSONField(name = "assignee_id")
    @JsonProperty("assignee_id")
    @ApiModelProperty(value = "assignee_id", notes = "负责人")
    private String assigneeId;

    /**
     * 负责人
     */
    @DEField(name = "assignee_name")
    @JSONField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
     * 当前版本标识
     */
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
     * 优先级
     */
    @DEField(name = "priority")
    @JSONField(name = "priority")
    @JsonProperty("priority")
    @ApiModelProperty(value = "priority", notes = "优先级")
    private String priority;

    /**
     * 关联目标版本
     */
    @DEField(name = "target_version")
    @JSONField(name = "target_version")
    @JsonProperty("target_version")
    @ApiModelProperty(value = "target_version", notes = "关联目标版本")
    private Version targetVersion;

    /**
     * 预估工时
     */
    @DEField(name = "estimated_workload")
    @JSONField(name = "estimated_workload")
    @JsonProperty("estimated_workload")
    @ApiModelProperty(value = "estimated_workload", notes = "预估工时")
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @DEField(name = "remaining_workload")
    @JSONField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

    /**
     * 实际工时
     */
    @DEField(name = "actual_workload")
    @JSONField(name = "actual_workload")
    @JsonProperty("actual_workload")
    @ApiModelProperty(value = "actual_workload", notes = "实际工时")
    private BigDecimal actualWorkload;

    /**
     * 项目发布标识
     */
    @DEField(name = "release_id")
    @JSONField(name = "release_id")
    @JsonProperty("release_id")
    @ApiModelProperty(value = "release_id", notes = "项目发布标识")
    private String releaseId;

    /**
     * 项目发布名称
     */
    @DEField(name = "release_name")
    @JSONField(name = "release_name")
    @JsonProperty("release_name")
    @ApiModelProperty(value = "release_name", notes = "项目发布名称")
    private String releaseName;

    /**
     * 迭代名称
     */
    @DEField(name = "sprint_name")
    @JSONField(name = "sprint_name")
    @JsonProperty("sprint_name")
    @ApiModelProperty(value = "sprint_name", notes = "迭代名称")
    private String sprintName;

    /**
     * 迭代标识
     */
    @DEField(name = "sprint_id")
    @JSONField(name = "sprint_id")
    @JsonProperty("sprint_id")
    @ApiModelProperty(value = "sprint_id", notes = "迭代标识")
    private String sprintId;

    /**
     * 看板名称
     */
    @DEField(name = "board_name")
    @JSONField(name = "board_name")
    @JsonProperty("board_name")
    @ApiModelProperty(value = "board_name", notes = "看板名称")
    private String boardName;

    /**
     * 看板标识
     */
    @DEField(name = "board_id")
    @JSONField(name = "board_id")
    @JsonProperty("board_id")
    @ApiModelProperty(value = "board_id", notes = "看板标识")
    private String boardId;

    /**
     * 看板栏名称
     */
    @DEField(name = "entry_name")
    @JSONField(name = "entry_name")
    @JsonProperty("entry_name")
    @ApiModelProperty(value = "entry_name", notes = "看板栏名称")
    private String entryName;

    /**
     * 看板栏标识
     */
    @DEField(name = "entry_id")
    @JSONField(name = "entry_id")
    @JsonProperty("entry_id")
    @ApiModelProperty(value = "entry_id", notes = "看板栏标识")
    private String entryId;

    /**
     * 父标识
     */
    @DEField(name = "pid")
    @JSONField(name = "pid")
    @JsonProperty("pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
     * 是否已删除
     */
    @DEField(name = "is_deleted")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private String isDeleted;

    /**
     * 是否已归档
     */
    @DEField(name = "is_archived")
    @JSONField(name = "is_archived")
    @JsonProperty("is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private String isArchived;

    /**
     * 编号
     */
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 完成时间
     */
    @DEField(name = "completed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("completed_at")
    @ApiModelProperty(value = "completed_at", notes = "完成时间")
    private Date completedAt;

    /**
     * 风险
     */
    @DEField(name = "risk" , dict = "risk")
    @JSONField(name = "risk")
    @JsonProperty("risk")
    @ApiModelProperty(value = "risk", notes = "风险")
    private String risk;

    /**
     * 需求来源
     */
    @DEField(name = "backlog_from" , dict = "demand_sources")
    @JSONField(name = "backlog_from")
    @JsonProperty("backlog_from")
    @ApiModelProperty(value = "backlog_from", notes = "需求来源")
    private String backlogFrom;

    /**
     * 需求类型
     */
    @DEField(name = "backlog_type")
    @JSONField(name = "backlog_type")
    @JsonProperty("backlog_type")
    @ApiModelProperty(value = "backlog_type", notes = "需求类型")
    private String backlogType;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 基线
     */
    @DEField(name = "baseline")
    @JSONField(name = "baseline")
    @JsonProperty("baseline")
    @ApiModelProperty(value = "baseline", notes = "基线")
    private Baseline baseline;

    /**
     * 开始时间
     */
    @DEField(name = "start_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "start_at" , format = "yyyy-MM-dd")
    @JsonProperty("start_at")
    @ApiModelProperty(value = "start_at", notes = "开始时间")
    private Date startAt;

    /**
     * 结束时间
     */
    @DEField(name = "end_at")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "end_at" , format = "yyyy-MM-dd")
    @JsonProperty("end_at")
    @ApiModelProperty(value = "end_at", notes = "结束时间")
    private Date endAt;

    /**
     * 是否叶子节点
     */
    @DEField(name = "is_leaf" , dict = "YesNo")
    @JSONField(name = "is_leaf")
    @JsonProperty("is_leaf")
    @ApiModelProperty(value = "is_leaf", notes = "是否叶子节点")
    private Integer isLeaf;

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
     * 基线-关联工作项
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "principal_baseline", notes = "基线-关联工作项")
    private Baseline principalBaseline;

    /**
    * 设置 [关联主体标识]
    */
    public BaselineWorkItem setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
    * 设置 [所属数据对象]
    */
    public BaselineWorkItem setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [关联主体类型]
    */
    public BaselineWorkItem setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
    * 设置 [关联目标类型]
    */
    public BaselineWorkItem setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
    * 设置 [关联目标标识]
    */
    public BaselineWorkItem setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
    * 设置 [目标对象版本标识]
    */
    public BaselineWorkItem setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
    * 设置 [项目]
    */
    public BaselineWorkItem setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public BaselineWorkItem setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [父工作项]
    */
    public BaselineWorkItem setPtitle(String ptitle) {
        this.ptitle = ptitle;
        this.modify("ptitle", ptitle);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public BaselineWorkItem setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public BaselineWorkItem setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public BaselineWorkItem setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
        this.modify("assignee_id", assigneeId);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public BaselineWorkItem setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
    * 设置 [优先级]
    */
    public BaselineWorkItem setPriority(String priority) {
        this.priority = priority;
        this.modify("priority", priority);
        return this;
    }

    /**
    * 设置 [关联目标版本]
    */
    public BaselineWorkItem setTargetVersion(Version targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
    * 设置 [预估工时]
    */
    public BaselineWorkItem setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
    * 设置 [剩余工时]
    */
    public BaselineWorkItem setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
    * 设置 [实际工时]
    */
    public BaselineWorkItem setActualWorkload(BigDecimal actualWorkload) {
        this.actualWorkload = actualWorkload;
        this.modify("actual_workload", actualWorkload);
        return this;
    }

    /**
    * 设置 [项目发布标识]
    */
    public BaselineWorkItem setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }

    /**
    * 设置 [项目发布名称]
    */
    public BaselineWorkItem setReleaseName(String releaseName) {
        this.releaseName = releaseName;
        this.modify("release_name", releaseName);
        return this;
    }

    /**
    * 设置 [迭代名称]
    */
    public BaselineWorkItem setSprintName(String sprintName) {
        this.sprintName = sprintName;
        this.modify("sprint_name", sprintName);
        return this;
    }

    /**
    * 设置 [迭代标识]
    */
    public BaselineWorkItem setSprintId(String sprintId) {
        this.sprintId = sprintId;
        this.modify("sprint_id", sprintId);
        return this;
    }

    /**
    * 设置 [看板名称]
    */
    public BaselineWorkItem setBoardName(String boardName) {
        this.boardName = boardName;
        this.modify("board_name", boardName);
        return this;
    }

    /**
    * 设置 [看板标识]
    */
    public BaselineWorkItem setBoardId(String boardId) {
        this.boardId = boardId;
        this.modify("board_id", boardId);
        return this;
    }

    /**
    * 设置 [看板栏名称]
    */
    public BaselineWorkItem setEntryName(String entryName) {
        this.entryName = entryName;
        this.modify("entry_name", entryName);
        return this;
    }

    /**
    * 设置 [看板栏标识]
    */
    public BaselineWorkItem setEntryId(String entryId) {
        this.entryId = entryId;
        this.modify("entry_id", entryId);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public BaselineWorkItem setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public BaselineWorkItem setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public BaselineWorkItem setIsArchived(String isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public BaselineWorkItem setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [完成时间]
    */
    public BaselineWorkItem setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
        this.modify("completed_at", completedAt);
        return this;
    }

    /**
    * 设置 [风险]
    */
    public BaselineWorkItem setRisk(String risk) {
        this.risk = risk;
        this.modify("risk", risk);
        return this;
    }

    /**
    * 设置 [需求来源]
    */
    public BaselineWorkItem setBacklogFrom(String backlogFrom) {
        this.backlogFrom = backlogFrom;
        this.modify("backlog_from", backlogFrom);
        return this;
    }

    /**
    * 设置 [需求类型]
    */
    public BaselineWorkItem setBacklogType(String backlogType) {
        this.backlogType = backlogType;
        this.modify("backlog_type", backlogType);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public BaselineWorkItem setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [基线]
    */
    public BaselineWorkItem setBaseline(Baseline baseline) {
        this.baseline = baseline;
        this.modify("baseline", baseline);
        return this;
    }

    /**
    * 设置 [开始时间]
    */
    public BaselineWorkItem setStartAt(Date startAt) {
        this.startAt = startAt;
        this.modify("start_at", startAt);
        return this;
    }

    /**
    * 设置 [结束时间]
    */
    public BaselineWorkItem setEndAt(Date endAt) {
        this.endAt = endAt;
        this.modify("end_at", endAt);
        return this;
    }

    /**
    * 设置 [是否叶子节点]
    */
    public BaselineWorkItem setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public BaselineWorkItem setName(String name) {
        this.name = name;
        this.modify("name", name);
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