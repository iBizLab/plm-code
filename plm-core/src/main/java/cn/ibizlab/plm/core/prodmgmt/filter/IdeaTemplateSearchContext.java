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
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;

/**
 * 关系型数据实体[IdeaTemplate] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("需求模板查询条件对象")
public class IdeaTemplateSearchContext extends QueryWrapperContext<IdeaTemplate> {

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

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
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("title",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<IdeaTemplate> getSelectCond() {
        QueryWrapper<IdeaTemplate> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}