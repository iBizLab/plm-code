/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.filter;

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
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;

/**
 * 关系型数据实体[Idea] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("需求查询条件对象")
public class IdeaSearchContext extends QueryWrapperContext<Idea> {

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
     * 优先级EQ
     */
    @JsonProperty("n_priority_eq")
    @JSONField(name = "n_priority_eq")
    @ApiModelProperty("优先级EQ")
    private String priorityEQ;

    /**
     * 模块EQ
     */
    @JsonProperty("n_suite_eq")
    @JSONField(name = "n_suite_eq")
    @ApiModelProperty("模块EQ")
    private String suiteEQ;

    /**
     * 计划时间周期单位EQ
     */
    @JsonProperty("n_plan_at_granularity_eq")
    @JSONField(name = "n_plan_at_granularity_eq")
    @ApiModelProperty("计划时间周期单位EQ")
    private String planAtGranularityEQ;

    /**
     * 计划时间周期单位EQ
     */
    @JsonProperty("n_real_at_granularity_eq")
    @JSONField(name = "n_real_at_granularity_eq")
    @ApiModelProperty("计划时间周期单位EQ")
    private String realAtGranularityEQ;

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
     * 负责人EQ
     */
    @JsonProperty("n_assignee_name_eq")
    @JSONField(name = "n_assignee_name_eq")
    @ApiModelProperty("负责人EQ")
    private String assigneeNameEQ;

    /**
     * 负责人LIKE
     */
    @JsonProperty("n_assignee_name_like")
    @JSONField(name = "n_assignee_name_like")
    @ApiModelProperty("负责人LIKE")
    private String assigneeNameLIKE;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty("负责人EQ")
    private String assigneeIdEQ;

    /**
     * 负责人IN
     */
    @JsonProperty("n_assignee_id_in")
    @JSONField(name = "n_assignee_id_in")
    @ApiModelProperty("负责人IN")
    private String assigneeIdIN;

    /**
     * 负责人ISNOTNULL
     */
    @JsonProperty("n_assignee_id_isnotnull")
    @JSONField(name = "n_assignee_id_isnotnull")
    @ApiModelProperty("负责人ISNOTNULL")
    private String assigneeIdISNOTNULL;

    /**
     * 负责人ISNULL
     */
    @JsonProperty("n_assignee_id_isnull")
    @JSONField(name = "n_assignee_id_isnull")
    @ApiModelProperty("负责人ISNULL")
    private String assigneeIdISNULL;

    /**
     * 负责人NOTEQ
     */
    @JsonProperty("n_assignee_id_noteq")
    @JSONField(name = "n_assignee_id_noteq")
    @ApiModelProperty("负责人NOTEQ")
    private String assigneeIdNOTEQ;

    /**
     * 负责人NOTIN
     */
    @JsonProperty("n_assignee_id_notin")
    @JSONField(name = "n_assignee_id_notin")
    @ApiModelProperty("负责人NOTIN")
    private String assigneeIdNOTIN;

    /**
     * 子产品标识EQ
     */
    @JsonProperty("n_section_id_eq")
    @JSONField(name = "n_section_id_eq")
    @ApiModelProperty("子产品标识EQ")
    private String sectionIdEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String showIdentifierLIKE;

    /**
     * 类别路径LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty("类别路径LIKE")
    private String categoriesLIKE;

    /**
     * 需求来源EQ
     */
    @JsonProperty("n_idea_from_eq")
    @JSONField(name = "n_idea_from_eq")
    @ApiModelProperty("需求来源EQ")
    private String ideaFromEQ;

    /**
     * 需求类型EQ
     */
    @JsonProperty("n_idea_type_eq")
    @JSONField(name = "n_idea_type_eq")
    @ApiModelProperty("需求类型EQ")
    private String ideaTypeEQ;

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
     * 建立人NOTEQ
     */
    @JsonProperty("n_create_man_noteq")
    @JSONField(name = "n_create_man_noteq")
    @ApiModelProperty("建立人NOTEQ")
    private String createManNOTEQ;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty("建立人NOTIN")
    private String createManNOTIN;

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
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("名称LIKE")
    private String nameLIKE;

    /**
     * 产品EQ
     */
    @JsonProperty("n_product_id_eq")
    @JSONField(name = "n_product_id_eq")
    @ApiModelProperty("产品EQ")
    private String productIdEQ;

    /**
     * 产品ISNULL
     */
    @JsonProperty("n_product_id_isnull")
    @JSONField(name = "n_product_id_isnull")
    @ApiModelProperty("产品ISNULL")
    private String productIdISNULL;

    /**
     * 所属产品EQ
     */
    @JsonProperty("n_product_name_eq")
    @JSONField(name = "n_product_name_eq")
    @ApiModelProperty("所属产品EQ")
    private String productNameEQ;

    /**
     * 所属产品LIKE
     */
    @JsonProperty("n_product_name_like")
    @JSONField(name = "n_product_name_like")
    @ApiModelProperty("所属产品LIKE")
    private String productNameLIKE;

    /**
     * 类别标识EQ
     */
    @JsonProperty("n_category_id_eq")
    @JSONField(name = "n_category_id_eq")
    @ApiModelProperty("类别标识EQ")
    private String categoryIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_category_name_eq")
    @JSONField(name = "n_category_name_eq")
    @ApiModelProperty("名称EQ")
    private String categoryNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_category_name_like")
    @JSONField(name = "n_category_name_like")
    @ApiModelProperty("名称LIKE")
    private String categoryNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.CATEGORY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("category_id",contextParentKey);
        if(Entities.PRODUCT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("product_id",contextParentKey);
        if(Entities.USER.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("assignee_id",contextParentKey);
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
    public QueryWrapper<Idea> getSelectCond() {
        QueryWrapper<Idea> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}