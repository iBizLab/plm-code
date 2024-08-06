/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.base.filter;

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
import cn.ibizlab.plm.core.base.domain.Relation;

/**
 * 关系型数据实体[Relation] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("关联查询条件对象")
public class RelationSearchContext extends QueryWrapperContext<Relation> {

    /**
     * 重要程度EQ
     */
    @JsonProperty("n_level_eq")
    @JSONField(name = "n_level_eq")
    @ApiModelProperty("重要程度EQ")
    private String levelEQ;

    /**
     * 关联主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty("关联主体标识EQ")
    private String principalIdEQ;

    /**
     * 关联主体类型EQ
     */
    @JsonProperty("n_principal_type_eq")
    @JSONField(name = "n_principal_type_eq")
    @ApiModelProperty("关联主体类型EQ")
    private String principalTypeEQ;

    /**
     * 关联目标类型EQ
     */
    @JsonProperty("n_target_type_eq")
    @JSONField(name = "n_target_type_eq")
    @ApiModelProperty("关联目标类型EQ")
    private String targetTypeEQ;

    /**
     * 关联目标标识EQ
     */
    @JsonProperty("n_target_id_eq")
    @JSONField(name = "n_target_id_eq")
    @ApiModelProperty("关联目标标识EQ")
    private String targetIdEQ;

    /**
     * 目标对象版本标识EQ
     */
    @JsonProperty("n_target_version_id_eq")
    @JSONField(name = "n_target_version_id_eq")
    @ApiModelProperty("目标对象版本标识EQ")
    private String targetVersionIdEQ;

    /**
     * 前后置任务EQ
     */
    @JsonProperty("n_job_type_eq")
    @JSONField(name = "n_job_type_eq")
    @ApiModelProperty("前后置任务EQ")
    private String jobTypeEQ;

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

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.BASELINE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.IDEA.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.RELEASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.REVIEW.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.REVIEW_CONTENT_EXTEND.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("id",contextParentKey);
        if(Entities.SPRINT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.CUSTOMER.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_id",contextParentKey);
        if(Entities.IDEA.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_id",contextParentKey);
        if(Entities.ARTICLE_PAGE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_id",contextParentKey);
        if(Entities.PRODUCT_PLAN.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_id",contextParentKey);
        if(Entities.TEST_CASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_id",contextParentKey);
        if(Entities.TICKET.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_id",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_id",contextParentKey);
        if(Entities.TEST_CASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.TEST_PLAN.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
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
    public QueryWrapper<Relation> getSelectCond() {
        QueryWrapper<Relation> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}