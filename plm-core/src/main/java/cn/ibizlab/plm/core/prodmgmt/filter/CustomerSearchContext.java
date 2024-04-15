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
    @JsonProperty("n_categorys_isnull")
    @JSONField(name = "n_categorys_isnull")
    @ApiModelProperty("类别ISNULL")
    private String categoriesISNULL;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categorys_like")
    @JSONField(name = "n_categorys_like")
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