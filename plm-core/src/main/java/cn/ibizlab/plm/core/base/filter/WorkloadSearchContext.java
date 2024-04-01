/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.base.filter;

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
import cn.ibizlab.plm.core.base.domain.Workload;

/**
 * 关系型数据实体[Workload] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工时查询条件对象")
public class WorkloadSearchContext extends QueryWrapperContext<Workload> {

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String identifierLIKE;

    /**
     * 工时主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty("工时主体标识EQ")
    private String principalIdEQ;

    /**
     * 工作日期GTANDEQ
     */
    @JsonProperty("n_register_date_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_register_date_gtandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("工作日期GTANDEQ")
    private Date registerDateGTANDEQ;

    /**
     * 工作日期IN
     */
    @JsonProperty("n_register_date_in")
    @JSONField(name = "n_register_date_in")
    @ApiModelProperty("工作日期IN")
    private String registerDateIN;

    /**
     * 工作日期LTANDEQ
     */
    @JsonProperty("n_register_date_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_register_date_ltandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("工作日期LTANDEQ")
    private Date registerDateLTANDEQ;

    /**
     * 访问父类EQ
     */
    @JsonProperty("n_recent_parent_eq")
    @JSONField(name = "n_recent_parent_eq")
    @ApiModelProperty("访问父类EQ")
    private String recentParentEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_assignee_id_eq")
    @JSONField(name = "n_work_item_exists__n_assignee_id_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSAssignee_idEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_create_man_eq")
    @JSONField(name = "n_work_item_exists__n_create_man_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSCreate_manEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_description_like")
    @JSONField(name = "n_work_item_exists__n_description_like")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSDescriptionLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_is_archived_eq")
    @JSONField(name = "n_work_item_exists__n_is_archived_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSIs_archivedEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_priority_eq")
    @JSONField(name = "n_work_item_exists__n_priority_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSPriorityEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_project_id_eq")
    @JSONField(name = "n_work_item_exists__n_project_id_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSProject_idEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_risk_eq")
    @JSONField(name = "n_work_item_exists__n_risk_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSRiskEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_state_eq")
    @JSONField(name = "n_work_item_exists__n_state_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSStateEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_title_like")
    @JSONField(name = "n_work_item_exists__n_title_like")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSTitleLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_work_item_type_id_eq")
    @JSONField(name = "n_work_item_exists__n_work_item_type_id_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSWork_item_type_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_assignee_id_eq")
    @JSONField(name = "n_idea_exists__n_assignee_id_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSAssignee_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_create_man_eq")
    @JSONField(name = "n_idea_exists__n_create_man_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSCreate_manEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_description_like")
    @JSONField(name = "n_idea_exists__n_description_like")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSDescriptionLIKE;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_identifier_like")
    @JSONField(name = "n_idea_exists__n_identifier_like")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSIdentifierLIKE;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_is_archived_eq")
    @JSONField(name = "n_idea_exists__n_is_archived_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSIs_archivedEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_priority_eq")
    @JSONField(name = "n_idea_exists__n_priority_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSPriorityEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_product_id_eq")
    @JSONField(name = "n_idea_exists__n_product_id_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSProduct_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_state_eq")
    @JSONField(name = "n_idea_exists__n_state_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSStateEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_title_like")
    @JSONField(name = "n_idea_exists__n_title_like")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSTitleLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_create_man_eq")
    @JSONField(name = "n_test_case_exists__n_create_man_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSCreate_manEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_description_like")
    @JSONField(name = "n_test_case_exists__n_description_like")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSDescriptionLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_identifier_eq")
    @JSONField(name = "n_test_case_exists__n_identifier_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSIdentifierEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_is_archived_eq")
    @JSONField(name = "n_test_case_exists__n_is_archived_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSIs_archivedEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_level_eq")
    @JSONField(name = "n_test_case_exists__n_level_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSLevelEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_maintenance_id_eq")
    @JSONField(name = "n_test_case_exists__n_maintenance_id_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSMaintenance_idEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_state_eq")
    @JSONField(name = "n_test_case_exists__n_state_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSStateEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_title_like")
    @JSONField(name = "n_test_case_exists__n_title_like")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSTitleLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_type_eq")
    @JSONField(name = "n_test_case_exists__n_type_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSTypeEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 事项LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("事项LIKE")
    private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 类别EQ
     */
    @JsonProperty("n_type_id_eq")
    @JSONField(name = "n_type_id_eq")
    @ApiModelProperty("类别EQ")
    private String typeIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_type_name_eq")
    @JSONField(name = "n_type_name_eq")
    @ApiModelProperty("名称EQ")
    private String typeNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_type_name_like")
    @JSONField(name = "n_type_name_like")
    @ApiModelProperty("名称LIKE")
    private String typeNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.WORKLOAD_TYPE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("type_id",contextParentKey);
        if(Entities.IDEA.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.TEST_CASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("show_identifier",query),QueryFilter.createQuery().like("name",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<Workload> getSelectCond() {
        QueryWrapper<Workload> queryWrapper = super.getSelectCond();
        if (!ObjectUtils.isEmpty(this.workItemEXISTSAssignee_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .ASSIGNEE_ID "
                + " = "
                + "'" + this.workItemEXISTSAssignee_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSCreate_manEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .CREATE_MAN "
                + " = "
                + "'" + this.workItemEXISTSCreate_manEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSDescriptionLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .DESCRIPTION "
                + " LIKE "
                + "'%" + this.workItemEXISTSDescriptionLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSIs_archivedEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IS_ARCHIVED "
                + " = "
                + "'" + this.workItemEXISTSIs_archivedEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSPriorityEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PRIORITY "
                + " = "
                + "'" + this.workItemEXISTSPriorityEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSProject_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PROJECT_ID "
                + " = "
                + "'" + this.workItemEXISTSProject_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSRiskEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .RISK "
                + " = "
                + "'" + this.workItemEXISTSRiskEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSStateEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .STATE "
                + " = "
                + "'" + this.workItemEXISTSStateEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSTitleLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TITLE "
                + " LIKE "
                + "'%" + this.workItemEXISTSTitleLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSWork_item_type_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .WORK_ITEM_TYPE_ID "
                + " = "
                + "'" + this.workItemEXISTSWork_item_type_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSAssignee_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .ASSIGNEE_ID "
                + " = "
                + "'" + this.ideaEXISTSAssignee_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSCreate_manEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .CREATE_MAN "
                + " = "
                + "'" + this.ideaEXISTSCreate_manEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSDescriptionLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .DESCRIPTION "
                + " LIKE "
                + "'%" + this.ideaEXISTSDescriptionLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSIdentifierLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IDENTIFIER "
                + " LIKE "
                + "'%" + this.ideaEXISTSIdentifierLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSIs_archivedEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IS_ARCHIVED "
                + " = "
                + "'" + this.ideaEXISTSIs_archivedEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSPriorityEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PRIORITY "
                + " = "
                + "'" + this.ideaEXISTSPriorityEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSProduct_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PRODUCT_ID "
                + " = "
                + "'" + this.ideaEXISTSProduct_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSStateEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .STATE "
                + " = "
                + "'" + this.ideaEXISTSStateEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSTitleLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TITLE "
                + " LIKE "
                + "'%" + this.ideaEXISTSTitleLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSCreate_manEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .CREATE_MAN "
                + " = "
                + "'" + this.testCaseEXISTSCreate_manEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSDescriptionLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .DESCRIPTION "
                + " LIKE "
                + "'%" + this.testCaseEXISTSDescriptionLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSIdentifierEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IDENTIFIER "
                + " = "
                + "'" + this.testCaseEXISTSIdentifierEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSIs_archivedEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IS_ARCHIVED "
                + " = "
                + "'" + this.testCaseEXISTSIs_archivedEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSLevelEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .LEVEL "
                + " = "
                + "'" + this.testCaseEXISTSLevelEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSMaintenance_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .MAINTENANCE_ID "
                + " = "
                + "'" + this.testCaseEXISTSMaintenance_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSStateEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .STATE "
                + " = "
                + "'" + this.testCaseEXISTSStateEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSTitleLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TITLE "
                + " LIKE "
                + "'%" + this.testCaseEXISTSTitleLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSTypeEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TYPE "
                + " = "
                + "'" + this.testCaseEXISTSTypeEQ + "'"
            );
        }
        return queryWrapper;
    }
}