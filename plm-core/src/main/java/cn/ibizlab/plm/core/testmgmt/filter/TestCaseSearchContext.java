/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.filter;

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
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;

/**
 * 关系型数据实体[TestCase] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例查询条件对象")
public class TestCaseSearchContext extends QueryWrapperContext<TestCase> {

    /**
     * 编号EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty("编号EQ")
    private String identifierEQ;

    /**
     * 编号ISNULL
     */
    @JsonProperty("n_identifier_isnull")
    @JSONField(name = "n_identifier_isnull")
    @ApiModelProperty("编号ISNULL")
    private String identifierISNULL;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String identifierLIKE;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty("标题LIKE")
    private String titleLIKE;

    /**
     * 重要程度EQ
     */
    @JsonProperty("n_level_eq")
    @JSONField(name = "n_level_eq")
    @ApiModelProperty("重要程度EQ")
    private String levelEQ;

    /**
     * 用例类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty("用例类型EQ")
    private String typeEQ;

    /**
     * 测试类型EQ
     */
    @JsonProperty("n_test_type_eq")
    @JSONField(name = "n_test_type_eq")
    @ApiModelProperty("测试类型EQ")
    private String testTypeEQ;

    /**
     * 描述LIKE
     */
    @JsonProperty("n_description_like")
    @JSONField(name = "n_description_like")
    @ApiModelProperty("描述LIKE")
    private String descriptionLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty("是否已归档EQ")
    private Integer isArchivedEQ;

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
     * 状态NOTIN
     */
    @JsonProperty("n_state_notin")
    @JSONField(name = "n_state_notin")
    @ApiModelProperty("状态NOTIN")
    private String stateNOTIN;

    /**
     * 维护人EQ
     */
    @JsonProperty("n_maintenance_id_eq")
    @JSONField(name = "n_maintenance_id_eq")
    @ApiModelProperty("维护人EQ")
    private String maintenanceIdEQ;

    /**
     * 维护人IN
     */
    @JsonProperty("n_maintenance_id_in")
    @JSONField(name = "n_maintenance_id_in")
    @ApiModelProperty("维护人IN")
    private String maintenanceIdIN;

    /**
     * 维护人NOTEQ
     */
    @JsonProperty("n_maintenance_id_noteq")
    @JSONField(name = "n_maintenance_id_noteq")
    @ApiModelProperty("维护人NOTEQ")
    private String maintenanceIdNOTEQ;

    /**
     * 维护人NOTIN
     */
    @JsonProperty("n_maintenance_id_notin")
    @JSONField(name = "n_maintenance_id_notin")
    @ApiModelProperty("维护人NOTIN")
    private String maintenanceIdNOTIN;

    /**
     * 维护人EQ
     */
    @JsonProperty("n_maintenance_name_eq")
    @JSONField(name = "n_maintenance_name_eq")
    @ApiModelProperty("维护人EQ")
    private String maintenanceNameEQ;

    /**
     * 测试计划名称EQ
     */
    @JsonProperty("n_test_plan_name_eq")
    @JSONField(name = "n_test_plan_name_eq")
    @ApiModelProperty("测试计划名称EQ")
    private String testPlanNameEQ;

    /**
     * 执行人EQ
     */
    @JsonProperty("n_executor_name_eq")
    @JSONField(name = "n_executor_name_eq")
    @ApiModelProperty("执行人EQ")
    private String executorNameEQ;

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_run_status_eq")
    @JSONField(name = "n_run_status_eq")
    @ApiModelProperty("执行结果EQ")
    private String runStatusEQ;

    /**
     * 模块路径LIKE
     */
    @JsonProperty("n_suites_like")
    @JSONField(name = "n_suites_like")
    @ApiModelProperty("模块路径LIKE")
    private String suitesLIKE;

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
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTSuser_idEQ;

    /**
     * 评审结果EQ
     */
    @JsonProperty("n_review_result_state_eq")
    @JSONField(name = "n_review_result_state_eq")
    @ApiModelProperty("评审结果EQ")
    private String reviewResultStateEQ;

    /**
     * 最近创建日期LTANDEQ
     */
    @JsonProperty("n_recent_create_days_ltandeq")
    @JSONField(name = "n_recent_create_days_ltandeq")
    @ApiModelProperty("最近创建日期LTANDEQ")
    private Integer recentCreateDaysLTANDEQ;

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
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间EQ")
    private Date createTimeEQ;

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
     * 更新时间GTANDEQ
     */
    @JsonProperty("n_update_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间GTANDEQ")
    private Date updateTimeGTANDEQ;

    /**
     * 更新时间LTANDEQ
     */
    @JsonProperty("n_update_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间LTANDEQ")
    private Date updateTimeLTANDEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("名称LIKE")
    private String nameLIKE;

    /**
     * 测试库EQ
     */
    @JsonProperty("n_test_library_id_eq")
    @JSONField(name = "n_test_library_id_eq")
    @ApiModelProperty("测试库EQ")
    private String testLibraryIdEQ;

    /**
     * 测试库ISNULL
     */
    @JsonProperty("n_test_library_id_isnull")
    @JSONField(name = "n_test_library_id_isnull")
    @ApiModelProperty("测试库ISNULL")
    private String testLibraryIdISNULL;

    /**
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty("用例模块标识EQ")
    private String suiteIdEQ;

    /**
     * 用例模块标识ISNOTNULL
     */
    @JsonProperty("n_suite_id_isnotnull")
    @JSONField(name = "n_suite_id_isnotnull")
    @ApiModelProperty("用例模块标识ISNOTNULL")
    private String suiteIdISNOTNULL;

    /**
     * 用例模块标识ISNULL
     */
    @JsonProperty("n_suite_id_isnull")
    @JSONField(name = "n_suite_id_isnull")
    @ApiModelProperty("用例模块标识ISNULL")
    private String suiteIdISNULL;

    /**
     * 所属模块EQ
     */
    @JsonProperty("n_suite_name_eq")
    @JSONField(name = "n_suite_name_eq")
    @ApiModelProperty("所属模块EQ")
    private String suiteNameEQ;

    /**
     * 所属模块LIKE
     */
    @JsonProperty("n_suite_name_like")
    @JSONField(name = "n_suite_name_like")
    @ApiModelProperty("所属模块LIKE")
    private String suiteNameLIKE;

    /**
     * 所属测试库EQ
     */
    @JsonProperty("n_test_library_name_eq")
    @JSONField(name = "n_test_library_name_eq")
    @ApiModelProperty("所属测试库EQ")
    private String testLibraryNameEQ;

    /**
     * 所属测试库LIKE
     */
    @JsonProperty("n_test_library_name_like")
    @JSONField(name = "n_test_library_name_like")
    @ApiModelProperty("所属测试库LIKE")
    private String testLibraryNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.LIBRARY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("test_library_id",contextParentKey);
        if(Entities.TEST_SUITE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("suite_id",contextParentKey);
        if(Entities.USER.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("maintenance_id",contextParentKey);
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
    public QueryWrapper<TestCase> getSelectCond() {
        QueryWrapper<TestCase> queryWrapper = super.getSelectCond();
        if (!ObjectUtils.isEmpty(this.attentionsEXISTSuser_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.USER_ID "
                + " = "
                + "'" + this.attentionsEXISTSuser_idEQ + "'"
            );
        }
        return queryWrapper;
    }
}