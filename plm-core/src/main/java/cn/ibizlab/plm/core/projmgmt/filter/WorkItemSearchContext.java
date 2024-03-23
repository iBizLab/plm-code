/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.annotation.JSONField;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;
import org.springframework.util.ObjectUtils;
import cn.ibizlab.util.filter.QueryWrapperContext;
import cn.ibizlab.util.filter.QueryFilter;
import cn.ibizlab.plm.util.enums.Entities;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 关系型数据实体[WorkItem] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项查询条件对象")
public class WorkItemSearchContext extends QueryWrapperContext<WorkItem> {

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String identifierLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty("是否已归档EQ")
    private Integer isArchivedEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty("标题LIKE")
    private String titleLIKE;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty("是否已删除EQ")
    private Integer isDeletedEQ;

    /**
     * 状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty("状态EQ")
    private String stateEQ;

    /**
     * 状态NOTEQ
     */
    @JsonProperty("n_state_noteq")
    @JSONField(name = "n_state_noteq")
    @ApiModelProperty("状态NOTEQ")
    private String stateNOTEQ;

    /**
     * 状态NOTIN
     */
    @JsonProperty("n_state_notin")
    @JSONField(name = "n_state_notin")
    @ApiModelProperty("状态NOTIN")
    private String stateNOTIN;

    /**
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty("优先级EQ")
    private String priorityEQ;

    /**
     * 需求类型EQ
     */
    @JsonProperty("n_backlog_type_eq")
    @JSONField(name = "n_backlog_type_eq")
    @ApiModelProperty("需求类型EQ")
    private String backlogTypeEQ;

    /**
     * 需求来源EQ
     */
    @JsonProperty("n_backlog_from_eq")
    @JSONField(name = "n_backlog_from_eq")
    @ApiModelProperty("需求来源EQ")
    private String backlogFromEQ;

    /**
     * 复现概率EQ
     */
    @JsonProperty("n_reappear_probability_eq")
    @JSONField(name = "n_reappear_probability_eq")
    @ApiModelProperty("复现概率EQ")
    private String reappearProbabilityEQ;

    /**
     * 负责人标识EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty("负责人标识EQ")
    private String assigneeIdEQ;

    /**
     * 严重程度EQ
     */
    @JsonProperty("n_severity_eq")
    @JSONField(name = "n_severity_eq")
    @ApiModelProperty("严重程度EQ")
    private String severityEQ;

    /**
     * 风险EQ
     */
    @JsonProperty("n_risk_eq")
    @JSONField(name = "n_risk_eq")
    @ApiModelProperty("风险EQ")
    private String riskEQ;

    /**
     * 工作项类型分组EQ
     */
    @JsonProperty("n_work_item_type_group_eq")
    @JSONField(name = "n_work_item_type_group_eq")
    @ApiModelProperty("工作项类型分组EQ")
    private String workItemTypeGroupEQ;

    /**
     * 任务类别EQ
     */
    @JsonProperty("n_job_type_eq")
    @JSONField(name = "n_job_type_eq")
    @ApiModelProperty("任务类别EQ")
    private String jobTypeEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String showIdentifierLIKE;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_owner_id_eq")
    @JSONField(name = "n_attentions_exists__n_owner_id_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTSOwner_idEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_type_eq")
    @JSONField(name = "n_attentions_exists__n_type_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTSTypeEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTSUser_idEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_type_eq")
    @JSONField(name = "n_attentions_notexists__n_type_eq")
    @ApiModelProperty("关注NOTEXISTS")
    private String attentionsNOTEXISTSTypeEQ;

    /**
     * 关注NOTEXISTS
     */
    @JsonProperty("n_attentions_notexists__n_user_id_eq")
    @JSONField(name = "n_attentions_notexists__n_user_id_eq")
    @ApiModelProperty("关注NOTEXISTS")
    private String attentionsNOTEXISTSUser_idEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 标识EXISTS
     */
    @JsonProperty("n_id_exists__n_id_eq")
    @JSONField(name = "n_id_exists__n_id_eq")
    @ApiModelProperty("标识EXISTS")
    private String idEXISTSIdEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty("标识IN")
    private String idIN;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty("标识NOTEQ")
    private String idNOTEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间GTANDEQ")
    private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间LTANDEQ")
    private Date createTimeLTANDEQ;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 项目标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty("项目标识EQ")
    private String projectIdEQ;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_id_eq")
    @JSONField(name = "n_work_item_type_id_eq")
    @ApiModelProperty("工作项类型EQ")
    private String workItemTypeIdEQ;

    /**
     * 工作项类型IN
     */
    @JsonProperty("n_work_item_type_id_in")
    @JSONField(name = "n_work_item_type_id_in")
    @ApiModelProperty("工作项类型IN")
    private String workItemTypeIdIN;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_id_like")
    @JSONField(name = "n_work_item_type_id_like")
    @ApiModelProperty("工作项类型LIKE")
    private String workItemTypeIdLIKE;

    /**
     * 所属项目EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty("所属项目EQ")
    private String projectNameEQ;

    /**
     * 所属项目LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty("所属项目LIKE")
    private String projectNameLIKE;

    /**
     * 工作项类型EQ
     */
    @JsonProperty("n_work_item_type_name_eq")
    @JSONField(name = "n_work_item_type_name_eq")
    @ApiModelProperty("工作项类型EQ")
    private String workItemTypeNameEQ;

    /**
     * 工作项类型LIKE
     */
    @JsonProperty("n_work_item_type_name_like")
    @JSONField(name = "n_work_item_type_name_like")
    @ApiModelProperty("工作项类型LIKE")
    private String workItemTypeNameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty("父标识EQ")
    private String pidEQ;

    /**
     * 父工作项EQ
     */
    @JsonProperty("n_ptitle_eq")
    @JSONField(name = "n_ptitle_eq")
    @ApiModelProperty("父工作项EQ")
    private String ptitleEQ;

    /**
     * 父工作项LIKE
     */
    @JsonProperty("n_ptitle_like")
    @JSONField(name = "n_ptitle_like")
    @ApiModelProperty("父工作项LIKE")
    private String ptitleLIKE;

    /**
     * 迭代标识EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty("迭代标识EQ")
    private String sprintIdEQ;

    /**
     * 迭代标识ISNULL
     */
    @JsonProperty("n_sprint_id_isnull")
    @JSONField(name = "n_sprint_id_isnull")
    @ApiModelProperty("迭代标识ISNULL")
    private String sprintIdISNULL;

    /**
     * 项目发布标识EQ
     */
    @JsonProperty("n_version_id_eq")
    @JSONField(name = "n_version_id_eq")
    @ApiModelProperty("项目发布标识EQ")
    private String versionIdEQ;

    /**
     * 看板标识EQ
     */
    @JsonProperty("n_board_id_eq")
    @JSONField(name = "n_board_id_eq")
    @ApiModelProperty("看板标识EQ")
    private String boardIdEQ;

    /**
     * 看板栏标识EQ
     */
    @JsonProperty("n_entry_id_eq")
    @JSONField(name = "n_entry_id_eq")
    @ApiModelProperty("看板栏标识EQ")
    private String entryIdEQ;

    /**
     * 泳道标识EQ
     */
    @JsonProperty("n_swimlane_id_eq")
    @JSONField(name = "n_swimlane_id_eq")
    @ApiModelProperty("泳道标识EQ")
    private String swimlaneIdEQ;

    /**
     * 看板栏名称EQ
     */
    @JsonProperty("n_entry_name_eq")
    @JSONField(name = "n_entry_name_eq")
    @ApiModelProperty("看板栏名称EQ")
    private String entryNameEQ;

    /**
     * 看板栏名称LIKE
     */
    @JsonProperty("n_entry_name_like")
    @JSONField(name = "n_entry_name_like")
    @ApiModelProperty("看板栏名称LIKE")
    private String entryNameLIKE;

    /**
     * 看板名称EQ
     */
    @JsonProperty("n_board_name_eq")
    @JSONField(name = "n_board_name_eq")
    @ApiModelProperty("看板名称EQ")
    private String boardNameEQ;

    /**
     * 看板名称LIKE
     */
    @JsonProperty("n_board_name_like")
    @JSONField(name = "n_board_name_like")
    @ApiModelProperty("看板名称LIKE")
    private String boardNameLIKE;

    /**
     * 顶级工作项标识EQ
     */
    @JsonProperty("n_top_id_eq")
    @JSONField(name = "n_top_id_eq")
    @ApiModelProperty("顶级工作项标识EQ")
    private String topIdEQ;

    /**
     * 顶级工作项标识IN
     */
    @JsonProperty("n_top_id_in")
    @JSONField(name = "n_top_id_in")
    @ApiModelProperty("顶级工作项标识IN")
    private String topIdIN;

    /**
     * 顶级工作项标题EQ
     */
    @JsonProperty("n_top_title_eq")
    @JSONField(name = "n_top_title_eq")
    @ApiModelProperty("顶级工作项标题EQ")
    private String topTitleEQ;

    /**
     * 顶级工作项标题LIKE
     */
    @JsonProperty("n_top_title_like")
    @JSONField(name = "n_top_title_like")
    @ApiModelProperty("顶级工作项标题LIKE")
    private String topTitleLIKE;

    /**
     * 发布名称EQ
     */
    @JsonProperty("n_version_name_eq")
    @JSONField(name = "n_version_name_eq")
    @ApiModelProperty("发布名称EQ")
    private String versionNameEQ;

    /**
     * 发布名称LIKE
     */
    @JsonProperty("n_version_name_like")
    @JSONField(name = "n_version_name_like")
    @ApiModelProperty("发布名称LIKE")
    private String versionNameLIKE;

    /**
     * 迭代名称EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty("迭代名称EQ")
    private String sprintNameEQ;

    /**
     * 迭代名称LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty("迭代名称LIKE")
    private String sprintNameLIKE;

    /**
     * 项目发布标识EQ
     */
    @JsonProperty("n_release_id_eq")
    @JSONField(name = "n_release_id_eq")
    @ApiModelProperty("项目发布标识EQ")
    private String releaseIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.BOARD.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("board_id",contextParentKey);
        if(Entities.ENTRY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("entry_id",contextParentKey);
        if(Entities.PROJECT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("project_id",contextParentKey);
        if(Entities.RELEASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("release_id",contextParentKey);
        if(Entities.SPRINT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("sprint_id",contextParentKey);
        if(Entities.SWIMLANE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("swimlane_id",contextParentKey);
        if(Entities.USER.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("assignee_id",contextParentKey);
        if(Entities.VERSION.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("version_id",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("pid",contextParentKey);
        if(Entities.WORK_ITEM_STATE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("state",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("top_id",contextParentKey);
        if(Entities.WORK_ITEM_TYPE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("work_item_type_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("identifier",query),QueryFilter.createQuery().like("title",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<WorkItem> getSelectCond() {
        QueryWrapper<WorkItem> queryWrapper = super.getSelectCond();
        if (!ObjectUtils.isEmpty(this.attentionsEXISTSOwner_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.OWNER_ID "
                + " = "
                + "'" + this.attentionsEXISTSOwner_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsEXISTSTypeEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.TYPE "
                + " = "
                + "'" + this.attentionsEXISTSTypeEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsEXISTSUser_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.USER_ID "
                + " = "
                + "'" + this.attentionsEXISTSUser_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsNOTEXISTSTypeEQ)) {
            queryWrapper.notExists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.TYPE "
                + " = "
                + "'" + this.attentionsNOTEXISTSTypeEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.attentionsNOTEXISTSUser_idEQ)) {
            queryWrapper.notExists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.USER_ID "
                + " = "
                + "'" + this.attentionsNOTEXISTSUser_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.idEXISTSIdEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .ID "
                + " = "
                + "'" + this.idEXISTSIdEQ + "'"
            );
        }
        return queryWrapper;
    }
}