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
import cn.ibizlab.plm.core.projmgmt.domain.Project;

/**
 * 关系型数据实体[Project] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("项目查询条件对象")
public class ProjectSearchContext extends QueryWrapperContext<Project> {

    /**
     * 可见范围EQ
     */
    @JsonProperty("n_visibility_eq")
    @JSONField(name = "n_visibility_eq")
    @ApiModelProperty("可见范围EQ")
    private String visibilityEQ;

    /**
     * 项目状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty("项目状态EQ")
    private String stateEQ;

    /**
     * 类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty("类型EQ")
    private String typeEQ;

    /**
     * 项目标识EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty("项目标识EQ")
    private String identifierEQ;

    /**
     * 项目标识LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty("项目标识LIKE")
    private String identifierLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty("是否已归档EQ")
    private Integer isArchivedEQ;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty("是否已删除EQ")
    private Integer isDeletedEQ;

    /**
     * 所属EQ
     */
    @JsonProperty("n_scope_type_eq")
    @JSONField(name = "n_scope_type_eq")
    @ApiModelProperty("所属EQ")
    private String scopeTypeEQ;

    /**
     * 状态类型NOTEQ
     */
    @JsonProperty("n_state_type_noteq")
    @JSONField(name = "n_state_type_noteq")
    @ApiModelProperty("状态类型NOTEQ")
    private String stateTypeNOTEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty("标识NOTEQ")
    private String idNOTEQ;

    /**
     * 项目名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("项目名称LIKE")
    private String nameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.PROJECT_STATE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("state",contextParentKey);
        if(Entities.COMMON_FLOW.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("id",contextParentKey);
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
    public QueryWrapper<Project> getSelectCond() {
        QueryWrapper<Project> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}