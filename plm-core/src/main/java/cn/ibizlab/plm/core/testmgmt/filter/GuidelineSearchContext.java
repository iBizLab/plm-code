/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.filter;

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
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;

/**
 * 关系型数据实体[Guideline] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("流程准则查询条件对象")
public class GuidelineSearchContext extends QueryWrapperContext<Guideline> {

    /**
     * 所属主体标识EQ
     */
    @JsonProperty("n_scope_id_eq")
    @JSONField(name = "n_scope_id_eq")
    @ApiModelProperty("所属主体标识EQ")
    private String scopeIdEQ;

    /**
     * 所属主体标识ISNULL
     */
    @JsonProperty("n_scope_id_isnull")
    @JSONField(name = "n_scope_id_isnull")
    @ApiModelProperty("所属主体标识ISNULL")
    private String scopeIdISNULL;

    /**
     * 对象类型EQ
     */
    @JsonProperty("n_object_type_eq")
    @JSONField(name = "n_object_type_eq")
    @ApiModelProperty("对象类型EQ")
    private String objectTypeEQ;

    /**
     * 主题类型EQ
     */
    @JsonProperty("n_subject_type_eq")
    @JSONField(name = "n_subject_type_eq")
    @ApiModelProperty("主题类型EQ")
    private String subjectTypeEQ;

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
        if(Entities.LIBRARY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("scope_id",contextParentKey);
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
    public QueryWrapper<Guideline> getSelectCond() {
        QueryWrapper<Guideline> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}