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
import cn.ibizlab.plm.core.testmgmt.domain.Run;

/**
 * 关系型数据实体[Run] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行用例查询条件对象")
public class RunSearchContext extends QueryWrapperContext<Run> {

    /**
     * 执行时间EQ
     */
    @JsonProperty("n_executed_at_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("执行时间EQ")
    private Date executedAtEQ;

    /**
     * 执行时间GTANDEQ
     */
    @JsonProperty("n_executed_at_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("执行时间GTANDEQ")
    private Date executedAtGTANDEQ;

    /**
     * 执行时间LTANDEQ
     */
    @JsonProperty("n_executed_at_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_executed_at_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("执行时间LTANDEQ")
    private Date executedAtLTANDEQ;

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty("执行结果EQ")
    private String statusEQ;

    /**
     * 执行结果ISNOTNULL
     */
    @JsonProperty("n_status_isnotnull")
    @JSONField(name = "n_status_isnotnull")
    @ApiModelProperty("执行结果ISNOTNULL")
    private String statusISNOTNULL;

    /**
     * 测试计划EQ
     */
    @JsonProperty("n_plan_name_eq")
    @JSONField(name = "n_plan_name_eq")
    @ApiModelProperty("测试计划EQ")
    private String planNameEQ;

    /**
     * 测试计划LIKE
     */
    @JsonProperty("n_plan_name_like")
    @JSONField(name = "n_plan_name_like")
    @ApiModelProperty("测试计划LIKE")
    private String planNameLIKE;

    /**
     * 执行人标识EQ
     */
    @JsonProperty("n_executor_id_eq")
    @JSONField(name = "n_executor_id_eq")
    @ApiModelProperty("执行人标识EQ")
    private String executorIdEQ;

    /**
     * 执行人标识IN
     */
    @JsonProperty("n_executor_id_in")
    @JSONField(name = "n_executor_id_in")
    @ApiModelProperty("执行人标识IN")
    private String executorIdIN;

    /**
     * 执行人标识ISNOTNULL
     */
    @JsonProperty("n_executor_id_isnotnull")
    @JSONField(name = "n_executor_id_isnotnull")
    @ApiModelProperty("执行人标识ISNOTNULL")
    private String executorIdISNOTNULL;

    /**
     * 执行人标识ISNULL
     */
    @JsonProperty("n_executor_id_isnull")
    @JSONField(name = "n_executor_id_isnull")
    @ApiModelProperty("执行人标识ISNULL")
    private String executorIdISNULL;

    /**
     * 执行人标识NOTEQ
     */
    @JsonProperty("n_executor_id_noteq")
    @JSONField(name = "n_executor_id_noteq")
    @ApiModelProperty("执行人标识NOTEQ")
    private String executorIdNOTEQ;

    /**
     * 执行人标识NOTIN
     */
    @JsonProperty("n_executor_id_notin")
    @JSONField(name = "n_executor_id_notin")
    @ApiModelProperty("执行人标识NOTIN")
    private String executorIdNOTIN;

    /**
     * 执行人EQ
     */
    @JsonProperty("n_executor_name_eq")
    @JSONField(name = "n_executor_name_eq")
    @ApiModelProperty("执行人EQ")
    private String executorNameEQ;

    /**
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty("用例模块标识EQ")
    private String suiteIdEQ;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty("测试库标识EQ")
    private String libraryIdEQ;

    /**
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty("优先级EQ")
    private String priorityEQ;

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
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty("建立人IN")
    private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty("建立人ISNOTNULL")
    private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty("建立人ISNULL")
    private String createManISNULL;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty("建立人NOTIN")
    private String createManNOTIN;

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
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("名称LIKE")
    private String nameLIKE;

    /**
     * 测试计划标识EQ
     */
    @JsonProperty("n_plan_id_eq")
    @JSONField(name = "n_plan_id_eq")
    @ApiModelProperty("测试计划标识EQ")
    private String planIdEQ;

    /**
     * 测试用例标识EQ
     */
    @JsonProperty("n_case_id_eq")
    @JSONField(name = "n_case_id_eq")
    @ApiModelProperty("测试用例标识EQ")
    private String caseIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_case_name_eq")
    @JSONField(name = "n_case_name_eq")
    @ApiModelProperty("名称EQ")
    private String caseNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_case_name_like")
    @JSONField(name = "n_case_name_like")
    @ApiModelProperty("名称LIKE")
    private String caseNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.TEST_CASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("case_id",contextParentKey);
        if(Entities.TEST_PLAN.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("plan_id",contextParentKey);
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
    public QueryWrapper<Run> getSelectCond() {
        QueryWrapper<Run> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}