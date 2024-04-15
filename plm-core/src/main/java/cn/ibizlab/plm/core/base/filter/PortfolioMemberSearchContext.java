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
import cn.ibizlab.plm.core.base.domain.PortfolioMember;

/**
 * 关系型数据实体[PortfolioMember] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("文件夹成员查询条件对象")
public class PortfolioMemberSearchContext extends QueryWrapperContext<PortfolioMember> {

    /**
     * 登录名EQ
     */
    @JsonProperty("n_user_id_eq")
    @JSONField(name = "n_user_id_eq")
    @ApiModelProperty("登录名EQ")
    private String userIdEQ;

    /**
     * 角色EQ
     */
    @JsonProperty("n_role_id_eq")
    @JSONField(name = "n_role_id_eq")
    @ApiModelProperty("角色EQ")
    private String roleIdEQ;

    /**
     * 文件夹名称EQ
     */
    @JsonProperty("n_portfolio_name_eq")
    @JSONField(name = "n_portfolio_name_eq")
    @ApiModelProperty("文件夹名称EQ")
    private String portfolioNameEQ;

    /**
     * 文件夹名称LIKE
     */
    @JsonProperty("n_portfolio_name_like")
    @JSONField(name = "n_portfolio_name_like")
    @ApiModelProperty("文件夹名称LIKE")
    private String portfolioNameLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 姓名LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("姓名LIKE")
    private String nameLIKE;

    /**
     * 文件夹标识EQ
     */
    @JsonProperty("n_portfolio_id_eq")
    @JSONField(name = "n_portfolio_id_eq")
    @ApiModelProperty("文件夹标识EQ")
    private String portfolioIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.PORTFOLIO.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("portfolio_id",contextParentKey);
        if(Entities.USER.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("user_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("user_id",query),QueryFilter.createQuery().like("name",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<PortfolioMember> getSelectCond() {
        QueryWrapper<PortfolioMember> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}