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
import cn.ibizlab.plm.core.projmgmt.domain.Stage;

/**
 * 关系型数据实体[Stage] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("发布阶段查询条件对象")
public class StageSearchContext extends QueryWrapperContext<Stage> {

    /**
     * 背景样式EQ
     */
    @JsonProperty("n_style_eq")
    @JSONField(name = "n_style_eq")
    @ApiModelProperty("背景样式EQ")
    private String styleEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty("标识IN")
    private String idIN;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty("标识NOTEQ")
    private String idNOTEQ;

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
     * 项目发布标识EQ
     */
    @JsonProperty("n_release_id_eq")
    @JSONField(name = "n_release_id_eq")
    @ApiModelProperty("项目发布标识EQ")
    private String releaseIdEQ;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_pid_eq")
    @JSONField(name = "n_pid_eq")
    @ApiModelProperty("父标识EQ")
    private String pidEQ;

    /**
     * 父名称EQ
     */
    @JsonProperty("n_pname_eq")
    @JSONField(name = "n_pname_eq")
    @ApiModelProperty("父名称EQ")
    private String pnameEQ;

    /**
     * 父名称LIKE
     */
    @JsonProperty("n_pname_like")
    @JSONField(name = "n_pname_like")
    @ApiModelProperty("父名称LIKE")
    private String pnameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.RELEASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("release_id",contextParentKey);
        if(Entities.STAGE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("pid",contextParentKey);
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
    public QueryWrapper<Stage> getSelectCond() {
        QueryWrapper<Stage> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}