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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;

/**
 * 关系型数据实体[ReviewResult] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审结果查询条件对象")
public class ReviewResultSearchContext extends QueryWrapperContext<ReviewResult> {

    /**
     * 状态EQ
     */
    @JsonProperty("n_result_state_eq")
    @JSONField(name = "n_result_state_eq")
    @ApiModelProperty("状态EQ")
    private Integer resultStateEQ;

    /**
     * 阶段标识EQ
     */
    @JsonProperty("n_stage_id_eq")
    @JSONField(name = "n_stage_id_eq")
    @ApiModelProperty("阶段标识EQ")
    private String stageIdEQ;

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
     * 评审内容标识EQ
     */
    @JsonProperty("n_content_id_eq")
    @JSONField(name = "n_content_id_eq")
    @ApiModelProperty("评审内容标识EQ")
    private String contentIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.REVIEW_CONTENT_EXTEND.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("content_id",contextParentKey);
        if(Entities.REVIEW_CONTENT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("content_id",contextParentKey);
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
    public QueryWrapper<ReviewResult> getSelectCond() {
        QueryWrapper<ReviewResult> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}