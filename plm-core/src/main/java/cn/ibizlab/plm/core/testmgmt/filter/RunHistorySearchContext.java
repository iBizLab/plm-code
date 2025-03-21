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
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;

/**
 * 关系型数据实体[RunHistory] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行结果查询条件对象")
public class RunHistorySearchContext extends QueryWrapperContext<RunHistory> {

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty("执行结果EQ")
    private String statusEQ;

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
     * 执行用例标识EQ
     */
    @JsonProperty("n_run_id_eq")
    @JSONField(name = "n_run_id_eq")
    @ApiModelProperty("执行用例标识EQ")
    private String runIdEQ;

    /**
     * 标题EQ
     */
    @JsonProperty("n_run_title_eq")
    @JSONField(name = "n_run_title_eq")
    @ApiModelProperty("标题EQ")
    private String runTitleEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_run_title_like")
    @JSONField(name = "n_run_title_like")
    @ApiModelProperty("标题LIKE")
    private String runTitleLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.RUN.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("run_id",contextParentKey);
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
    public QueryWrapper<RunHistory> getSelectCond() {
        QueryWrapper<RunHistory> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}