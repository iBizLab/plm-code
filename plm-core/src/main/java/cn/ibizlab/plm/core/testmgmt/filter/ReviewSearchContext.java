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
import cn.ibizlab.plm.core.testmgmt.domain.Review;

/**
 * 关系型数据实体[Review] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审查询条件对象")
public class ReviewSearchContext extends QueryWrapperContext<Review> {

    /**
     * 评审类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty("评审类型EQ")
    private String typeEQ;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty("类别LIKE")
    private String categoriesLIKE;

    /**
     * 评审状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty("评审状态EQ")
    private String stateEQ;

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
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty("测试库标识EQ")
    private String libraryIdEQ;

    /**
     * 测试库名称EQ
     */
    @JsonProperty("n_library_name_eq")
    @JSONField(name = "n_library_name_eq")
    @ApiModelProperty("测试库名称EQ")
    private String libraryNameEQ;

    /**
     * 测试库名称LIKE
     */
    @JsonProperty("n_library_name_like")
    @JSONField(name = "n_library_name_like")
    @ApiModelProperty("测试库名称LIKE")
    private String libraryNameLIKE;

    /**
     * 流程准则标识EQ
     */
    @JsonProperty("n_guideline_id_eq")
    @JSONField(name = "n_guideline_id_eq")
    @ApiModelProperty("流程准则标识EQ")
    private String guidelineIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.GUIDELINE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("guideline_id",contextParentKey);
        if(Entities.LIBRARY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("library_id",contextParentKey);
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
    public QueryWrapper<Review> getSelectCond() {
        QueryWrapper<Review> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}