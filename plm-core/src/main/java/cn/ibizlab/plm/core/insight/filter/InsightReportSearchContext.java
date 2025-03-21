/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.insight.filter;

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
import cn.ibizlab.plm.core.insight.domain.InsightReport;

/**
 * 关系型数据实体[InsightReport] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("效能报表查询条件对象")
public class InsightReportSearchContext extends QueryWrapperContext<InsightReport> {

    /**
     * 图表类型EQ
     */
    @JsonProperty("n_chart_type_eq")
    @JSONField(name = "n_chart_type_eq")
    @ApiModelProperty("图表类型EQ")
    private String chartTypeEQ;

    /**
     * 组别EQ
     */
    @JsonProperty("n_group_eq")
    @JSONField(name = "n_group_eq")
    @ApiModelProperty("组别EQ")
    private String groupEQ;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty("类别LIKE")
    private String categoriesLIKE;

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
     * 视图标识EQ
     */
    @JsonProperty("n_view_id_eq")
    @JSONField(name = "n_view_id_eq")
    @ApiModelProperty("视图标识EQ")
    private String viewIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_view_name_eq")
    @JSONField(name = "n_view_name_eq")
    @ApiModelProperty("名称EQ")
    private String viewNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_view_name_like")
    @JSONField(name = "n_view_name_like")
    @ApiModelProperty("名称LIKE")
    private String viewNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.INSIGHT_VIEW.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("view_id",contextParentKey);
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
    public QueryWrapper<InsightReport> getSelectCond() {
        QueryWrapper<InsightReport> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}