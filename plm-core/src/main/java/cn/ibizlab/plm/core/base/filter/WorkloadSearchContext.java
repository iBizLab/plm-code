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
     * 工作日期EQ
     */
    @JsonProperty("n_register_date_eq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_register_date_eq" , format = "yyyy-MM-dd")
    @ApiModelProperty("工作日期EQ")
    private Date registerDateEQ;

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
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String showIdentifierLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_assignee_id_eq")
    @JSONField(name = "n_work_item_exists__n_assignee_id_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSassignee_idEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_create_man_eq")
    @JSONField(name = "n_work_item_exists__n_create_man_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTScreate_manEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_description_like")
    @JSONField(name = "n_work_item_exists__n_description_like")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSdescriptionLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_identifier_like")
    @JSONField(name = "n_work_item_exists__n_identifier_like")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSidentifierLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_is_archived_eq")
    @JSONField(name = "n_work_item_exists__n_is_archived_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSis_archivedEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_priority_eq")
    @JSONField(name = "n_work_item_exists__n_priority_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSpriorityEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_project_id_eq")
    @JSONField(name = "n_work_item_exists__n_project_id_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSproject_idEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_risk_eq")
    @JSONField(name = "n_work_item_exists__n_risk_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSriskEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_state_eq")
    @JSONField(name = "n_work_item_exists__n_state_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSstateEQ;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_title_like")
    @JSONField(name = "n_work_item_exists__n_title_like")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTStitleLIKE;

    /**
     * 工作项EXISTS
     */
    @JsonProperty("n_work_item_exists__n_work_item_type_id_eq")
    @JSONField(name = "n_work_item_exists__n_work_item_type_id_eq")
    @ApiModelProperty("工作项EXISTS")
    private String workItemEXISTSwork_item_type_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_assignee_id_eq")
    @JSONField(name = "n_idea_exists__n_assignee_id_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSassignee_idEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_create_man_eq")
    @JSONField(name = "n_idea_exists__n_create_man_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTScreate_manEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_description_like")
    @JSONField(name = "n_idea_exists__n_description_like")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSdescriptionLIKE;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_identifier_like")
    @JSONField(name = "n_idea_exists__n_identifier_like")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSidentifierLIKE;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_is_archived_eq")
    @JSONField(name = "n_idea_exists__n_is_archived_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSis_archivedEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_priority_eq")
    @JSONField(name = "n_idea_exists__n_priority_eq")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTSpriorityEQ;

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
    private String ideaEXISTSstateEQ;

    /**
     * 需求EXISTS
     */
    @JsonProperty("n_idea_exists__n_title_like")
    @JSONField(name = "n_idea_exists__n_title_like")
    @ApiModelProperty("需求EXISTS")
    private String ideaEXISTStitleLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_create_man_eq")
    @JSONField(name = "n_test_case_exists__n_create_man_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTScreate_manEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_description_like")
    @JSONField(name = "n_test_case_exists__n_description_like")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSdescriptionLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_identifier_eq")
    @JSONField(name = "n_test_case_exists__n_identifier_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSidentifierEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_is_archived_eq")
    @JSONField(name = "n_test_case_exists__n_is_archived_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSis_archivedEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_level_eq")
    @JSONField(name = "n_test_case_exists__n_level_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSlevelEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_maintenance_id_eq")
    @JSONField(name = "n_test_case_exists__n_maintenance_id_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSmaintenance_idEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_state_eq")
    @JSONField(name = "n_test_case_exists__n_state_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTSstateEQ;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_title_like")
    @JSONField(name = "n_test_case_exists__n_title_like")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTStitleLIKE;

    /**
     * 用例EXISTS
     */
    @JsonProperty("n_test_case_exists__n_type_eq")
    @JSONField(name = "n_test_case_exists__n_type_eq")
    @ApiModelProperty("用例EXISTS")
    private String testCaseEXISTStypeEQ;

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
        if (!ObjectUtils.isEmpty(this.workItemEXISTSassignee_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .ASSIGNEE_ID "
                + " = "
                + "'" + this.workItemEXISTSassignee_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTScreate_manEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .CREATE_MAN "
                + " = "
                + "'" + this.workItemEXISTScreate_manEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSdescriptionLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .DESCRIPTION "
                + " LIKE "
                + "'%" + this.workItemEXISTSdescriptionLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSidentifierLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IDENTIFIER "
                + " LIKE "
                + "'%" + this.workItemEXISTSidentifierLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSis_archivedEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IS_ARCHIVED "
                + " = "
                + "'" + this.workItemEXISTSis_archivedEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSpriorityEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PRIORITY "
                + " = "
                + "'" + this.workItemEXISTSpriorityEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSproject_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PROJECT_ID "
                + " = "
                + "'" + this.workItemEXISTSproject_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSriskEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .RISK "
                + " = "
                + "'" + this.workItemEXISTSriskEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSstateEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .STATE "
                + " = "
                + "'" + this.workItemEXISTSstateEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTStitleLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TITLE "
                + " LIKE "
                + "'%" + this.workItemEXISTStitleLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.workItemEXISTSwork_item_type_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .WORK_ITEM_TYPE_ID "
                + " = "
                + "'" + this.workItemEXISTSwork_item_type_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSassignee_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .ASSIGNEE_ID "
                + " = "
                + "'" + this.ideaEXISTSassignee_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTScreate_manEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .CREATE_MAN "
                + " = "
                + "'" + this.ideaEXISTScreate_manEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSdescriptionLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .DESCRIPTION "
                + " LIKE "
                + "'%" + this.ideaEXISTSdescriptionLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSidentifierLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IDENTIFIER "
                + " LIKE "
                + "'%" + this.ideaEXISTSidentifierLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSis_archivedEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IS_ARCHIVED "
                + " = "
                + "'" + this.ideaEXISTSis_archivedEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSpriorityEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PRIORITY "
                + " = "
                + "'" + this.ideaEXISTSpriorityEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSProduct_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .PRODUCT_ID "
                + " = "
                + "'" + this.ideaEXISTSProduct_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTSstateEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .STATE "
                + " = "
                + "'" + this.ideaEXISTSstateEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.ideaEXISTStitleLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TITLE "
                + " LIKE "
                + "'%" + this.ideaEXISTStitleLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTScreate_manEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .CREATE_MAN "
                + " = "
                + "'" + this.testCaseEXISTScreate_manEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSdescriptionLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .DESCRIPTION "
                + " LIKE "
                + "'%" + this.testCaseEXISTSdescriptionLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSidentifierEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IDENTIFIER "
                + " = "
                + "'" + this.testCaseEXISTSidentifierEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSis_archivedEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .IS_ARCHIVED "
                + " = "
                + "'" + this.testCaseEXISTSis_archivedEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSlevelEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .LEVEL "
                + " = "
                + "'" + this.testCaseEXISTSlevelEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSmaintenance_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .MAINTENANCE_ID "
                + " = "
                + "'" + this.testCaseEXISTSmaintenance_idEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTSstateEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .STATE "
                + " = "
                + "'" + this.testCaseEXISTSstateEQ + "'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTStitleLIKE)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TITLE "
                + " LIKE "
                + "'%" + this.testCaseEXISTStitleLIKE + "%'"
            );
        }
        if (!ObjectUtils.isEmpty(this.testCaseEXISTStypeEQ)) {
            queryWrapper.exists("SELECT 1 FROM  WHERE . = T1. "
                + " AND .TYPE "
                + " = "
                + "'" + this.testCaseEXISTStypeEQ + "'"
            );
        }
        return queryWrapper;
    }
}