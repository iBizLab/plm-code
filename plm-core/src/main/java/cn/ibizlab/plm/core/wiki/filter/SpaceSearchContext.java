/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.wiki.filter;

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
import cn.ibizlab.plm.core.wiki.domain.Space;

/**
 * 关系型数据实体[Space] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("空间查询条件对象")
public class SpaceSearchContext extends QueryWrapperContext<Space> {

    /**
     * 可见范围EQ
     */
    @JsonProperty("n_visibility_eq")
    @JSONField(name = "n_visibility_eq")
    @ApiModelProperty("可见范围EQ")
    private String visibilityEQ;

    /**
     * 是否开启共享EQ
     */
    @JsonProperty("n_is_shared_eq")
    @JSONField(name = "n_is_shared_eq")
    @ApiModelProperty("是否开启共享EQ")
    private String isSharedEQ;

    /**
     * 所属EQ
     */
    @JsonProperty("n_scope_type_eq")
    @JSONField(name = "n_scope_type_eq")
    @ApiModelProperty("所属EQ")
    private String scopeTypeEQ;

    /**
     * 所属对象EQ
     */
    @JsonProperty("n_scope_id_eq")
    @JSONField(name = "n_scope_id_eq")
    @ApiModelProperty("所属对象EQ")
    private String scopeIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 空间名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("空间名称LIKE")
    private String nameLIKE;

    /**
     * 分类EQ
     */
    @JsonProperty("n_category_id_eq")
    @JSONField(name = "n_category_id_eq")
    @ApiModelProperty("分类EQ")
    private String categoryIdEQ;

    /**
     * 分类EQ
     */
    @JsonProperty("n_category_name_eq")
    @JSONField(name = "n_category_name_eq")
    @ApiModelProperty("分类EQ")
    private String categoryNameEQ;

    /**
     * 分类LIKE
     */
    @JsonProperty("n_category_name_like")
    @JSONField(name = "n_category_name_like")
    @ApiModelProperty("分类LIKE")
    private String categoryNameLIKE;

    /**
     * 用户标记EQ
     */
    @JsonProperty("n_user_tag_eq")
    @JSONField(name = "n_user_tag_eq")
    @ApiModelProperty("用户标记EQ")
    private String userTagEQ;

    /**
     * 用户标记LIKE
     */
    @JsonProperty("n_user_tag_like")
    @JSONField(name = "n_user_tag_like")
    @ApiModelProperty("用户标记LIKE")
    private String userTagLIKE;

    /**
     * 用户标记2EQ
     */
    @JsonProperty("n_user_tag2_eq")
    @JSONField(name = "n_user_tag2_eq")
    @ApiModelProperty("用户标记2EQ")
    private String userTag2EQ;

    /**
     * 用户标记2LIKE
     */
    @JsonProperty("n_user_tag2_like")
    @JSONField(name = "n_user_tag2_like")
    @ApiModelProperty("用户标记2LIKE")
    private String userTag2LIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.CATEGORY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("category_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("identifier",query),QueryFilter.createQuery().like("name",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<Space> getSelectCond() {
        QueryWrapper<Space> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}