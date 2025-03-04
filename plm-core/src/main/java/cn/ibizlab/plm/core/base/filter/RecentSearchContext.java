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
import cn.ibizlab.plm.core.base.domain.Recent;

/**
 * 关系型数据实体[Recent] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("最近访问查询条件对象")
public class RecentSearchContext extends QueryWrapperContext<Recent> {

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
     * 访问父类EQ
     */
    @JsonProperty("n_recent_parent_eq")
    @JSONField(name = "n_recent_parent_eq")
    @ApiModelProperty("访问父类EQ")
    private String recentParentEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String showIdentifierLIKE;

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

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("owner_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("show_identifier",query),QueryFilter.createQuery().like("name",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<Recent> getSelectCond() {
        QueryWrapper<Recent> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}