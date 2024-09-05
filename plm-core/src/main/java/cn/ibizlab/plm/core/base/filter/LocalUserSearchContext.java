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
import cn.ibizlab.plm.core.base.domain.LocalUser;

/**
 * 关系型数据实体[LocalUser] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("企业用户查询条件对象")
public class LocalUserSearchContext extends QueryWrapperContext<LocalUser> {

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
     * 部门标识EQ
     */
    @JsonProperty("n_department_id_eq")
    @JSONField(name = "n_department_id_eq")
    @ApiModelProperty("部门标识EQ")
    private String departmentIdEQ;

    /**
     * 部门名称EQ
     */
    @JsonProperty("n_department_name_eq")
    @JSONField(name = "n_department_name_eq")
    @ApiModelProperty("部门名称EQ")
    private String departmentNameEQ;

    /**
     * 部门名称LIKE
     */
    @JsonProperty("n_department_name_like")
    @JSONField(name = "n_department_name_like")
    @ApiModelProperty("部门名称LIKE")
    private String departmentNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.LOCAL_DEPARTMENT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("department_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("name",query),QueryFilter.createQuery().like("display_name",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<LocalUser> getSelectCond() {
        QueryWrapper<LocalUser> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}