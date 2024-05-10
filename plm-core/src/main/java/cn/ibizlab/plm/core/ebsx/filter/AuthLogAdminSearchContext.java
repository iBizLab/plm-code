/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.filter;

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
import cn.ibizlab.plm.core.ebsx.domain.AuthLogAdmin;

/**
 * 关系型数据实体[AuthLogAdmin] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("认证日志查询条件对象")
public class AuthLogAdminSearchContext extends QueryWrapperContext<AuthLogAdmin> {

    /**
     * 标识EQ
     */
    @JsonProperty("n_logid_eq")
    @JSONField(name = "n_logid_eq")
    @ApiModelProperty("标识EQ")
    private String logIdEQ;

    /**
     * 用户全局名LIKE
     */
    @JsonProperty("n_username_like")
    @JSONField(name = "n_username_like")
    @ApiModelProperty("用户全局名LIKE")
    private String userNameLIKE;

    /**
     * 认证结果EQ
     */
    @JsonProperty("n_authcode_eq")
    @JSONField(name = "n_authcode_eq")
    @ApiModelProperty("认证结果EQ")
    private String authCodeEQ;

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("username",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<AuthLogAdmin> getSelectCond() {
        QueryWrapper<AuthLogAdmin> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}