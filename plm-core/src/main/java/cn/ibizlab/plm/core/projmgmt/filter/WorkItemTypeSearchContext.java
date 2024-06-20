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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemType;

/**
 * 关系型数据实体[WorkItemType] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项类型查询条件对象")
public class WorkItemTypeSearchContext extends QueryWrapperContext<WorkItemType> {

    /**
     * 项目类型EQ
     */
    @JsonProperty("n_project_type_eq")
    @JSONField(name = "n_project_type_eq")
    @ApiModelProperty("项目类型EQ")
    private String projectTypeEQ;

    /**
     * 类型分组EQ
     */
    @JsonProperty("n_group_eq")
    @JSONField(name = "n_group_eq")
    @ApiModelProperty("类型分组EQ")
    private String groupEQ;

    /**
     * 编码IN
     */
    @JsonProperty("n_code_in")
    @JSONField(name = "n_code_in")
    @ApiModelProperty("编码IN")
    private String codeIN;

    /**
     * 标识LIKE
     */
    @JsonProperty("n_id_like")
    @JSONField(name = "n_id_like")
    @ApiModelProperty("标识LIKE")
    private String idLIKE;

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
     * 项目标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty("项目标识EQ")
    private String projectIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.PROJECT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("project_id",contextParentKey);
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
    public QueryWrapper<WorkItemType> getSelectCond() {
        QueryWrapper<WorkItemType> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}