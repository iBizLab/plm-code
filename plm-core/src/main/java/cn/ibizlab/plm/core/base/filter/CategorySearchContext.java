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
import cn.ibizlab.plm.core.base.domain.Category;

/**
 * 关系型数据实体[Category] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("类别查询条件对象")
public class CategorySearchContext extends QueryWrapperContext<Category> {

    /**
     * 所属数据标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty("所属数据标识EQ")
    private String ownerIdEQ;

    /**
     * 所属数据对象EQ
     */
    @JsonProperty("n_owner_type_eq")
    @JSONField(name = "n_owner_type_eq")
    @ApiModelProperty("所属数据对象EQ")
    private String ownerTypeEQ;

    /**
     * 所属对象子类型EQ
     */
    @JsonProperty("n_owner_subtype_eq")
    @JSONField(name = "n_owner_subtype_eq")
    @ApiModelProperty("所属对象子类型EQ")
    private String ownerSubtypeEQ;

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
     * 分组标识EQ
     */
    @JsonProperty("n_section_id_eq")
    @JSONField(name = "n_section_id_eq")
    @ApiModelProperty("分组标识EQ")
    private String sectionIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_section_name_eq")
    @JSONField(name = "n_section_name_eq")
    @ApiModelProperty("名称EQ")
    private String sectionNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_section_name_like")
    @JSONField(name = "n_section_name_like")
    @ApiModelProperty("名称LIKE")
    private String sectionNameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty("父标识EQ")
    private String pidEQ;

    /**
     * 父标识ISNOTNULL
     */
    @JsonProperty("n_pid_isnotnull")
    @JSONField(name = "n_pid_isnotnull")
    @ApiModelProperty("父标识ISNOTNULL")
    private String pidISNOTNULL;

    /**
     * 父标识ISNULL
     */
    @JsonProperty("n_pid_isnull")
    @JSONField(name = "n_pid_isnull")
    @ApiModelProperty("父标识ISNULL")
    private String pidISNULL;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.CATEGORY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("pid",contextParentKey);
        if(Entities.SECTION.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("section_id",contextParentKey);
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
    public QueryWrapper<Category> getSelectCond() {
        QueryWrapper<Category> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}