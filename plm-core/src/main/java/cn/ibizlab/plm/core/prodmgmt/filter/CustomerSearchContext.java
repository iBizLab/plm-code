/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;
import java.io.Serializable;
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
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;

/**
 * 关系型数据实体[Customer] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("客户查询条件对象")
public class CustomerSearchContext extends QueryWrapperContext<Customer> {

    /**
     * 等级EQ
     */
    @JsonProperty("n_grade_id_eq")
    @JSONField(name = "n_grade_id_eq")
    @ApiModelProperty("等级EQ")
    private String gradeIdEQ;

    /**
     * 行业EQ
     */
    @JsonProperty("n_industry_id_eq")
    @JSONField(name = "n_industry_id_eq")
    @ApiModelProperty("行业EQ")
    private String industryIdEQ;

    /**
     * 类别ISNULL
     */
    @JsonProperty("n_categories_isnull")
    @JSONField(name = "n_categories_isnull")
    @ApiModelProperty("类别ISNULL")
    private String categoriesISNULL;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty("类别LIKE")
    private String categoriesLIKE;

    /**
     * 产品名称EQ
     */
    @JsonProperty("n_product_name_eq")
    @JSONField(name = "n_product_name_eq")
    @ApiModelProperty("产品名称EQ")
    private String productNameEQ;

    /**
     * 产品名称LIKE
     */
    @JsonProperty("n_product_name_like")
    @JSONField(name = "n_product_name_like")
    @ApiModelProperty("产品名称LIKE")
    private String productNameLIKE;

    /**
     * 负责人标识EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty("负责人标识EQ")
    private String assigneeIdEQ;

    /**
     * 负责人标识IN
     */
    @JsonProperty("n_assignee_id_in")
    @JSONField(name = "n_assignee_id_in")
    @ApiModelProperty("负责人标识IN")
    private String assigneeIdIN;

    /**
     * 负责人标识ISNOTNULL
     */
    @JsonProperty("n_assignee_id_isnotnull")
    @JSONField(name = "n_assignee_id_isnotnull")
    @ApiModelProperty("负责人标识ISNOTNULL")
    private String assigneeIdISNOTNULL;

    /**
     * 负责人标识ISNULL
     */
    @JsonProperty("n_assignee_id_isnull")
    @JSONField(name = "n_assignee_id_isnull")
    @ApiModelProperty("负责人标识ISNULL")
    private String assigneeIdISNULL;

    /**
     * 负责人标识NOTIN
     */
    @JsonProperty("n_assignee_id_notin")
    @JSONField(name = "n_assignee_id_notin")
    @ApiModelProperty("负责人标识NOTIN")
    private String assigneeIdNOTIN;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 客户名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("客户名称LIKE")
    private String nameLIKE;

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
     * 产品标识EQ
     */
    @JsonProperty("n_product_id_eq")
    @JSONField(name = "n_product_id_eq")
    @ApiModelProperty("产品标识EQ")
    private String productIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.PRODUCT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("product_id",contextParentKey);
        if(Entities.USER.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("assignee_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("name",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<Customer> getSelectCond() {
        QueryWrapper<Customer> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}