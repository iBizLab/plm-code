/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.filter;

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
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;

/**
 * 关系型数据实体[SprintAlteration] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("迭代变更查询条件对象")
public class SprintAlterationSearchContext extends QueryWrapperContext<SprintAlteration> {

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
     * 迭代标识EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty("迭代标识EQ")
    private String sprintIdEQ;

    /**
     * 工作项标识EQ
     */
    @JsonProperty("n_work_item_id_eq")
    @JSONField(name = "n_work_item_id_eq")
    @ApiModelProperty("工作项标识EQ")
    private String workItemIdEQ;

    /**
     * 标题EQ
     */
    @JsonProperty("n_work_item_title_eq")
    @JSONField(name = "n_work_item_title_eq")
    @ApiModelProperty("标题EQ")
    private String workItemTitleEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_work_item_title_like")
    @JSONField(name = "n_work_item_title_like")
    @ApiModelProperty("标题LIKE")
    private String workItemTitleLIKE;

    /**
     * 名称EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty("名称EQ")
    private String sprintNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty("名称LIKE")
    private String sprintNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.SPRINT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("sprint_id",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("work_item_id",contextParentKey);
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
    public QueryWrapper<SprintAlteration> getSelectCond() {
        QueryWrapper<SprintAlteration> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}