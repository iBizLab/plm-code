/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.devops.filter;

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
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;

/**
 * 关系型数据实体[BranchRefCommit] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("分支提交关联查询条件对象")
public class BranchRefCommitSearchContext extends QueryWrapperContext<BranchRefCommit> {

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
     * SHA值EQ
     */
    @JsonProperty("n_sha_eq")
    @JSONField(name = "n_sha_eq")
    @ApiModelProperty("SHA值EQ")
    private String shaEQ;

    /**
     * 仓库标识EQ
     */
    @JsonProperty("n_repository_id_eq")
    @JSONField(name = "n_repository_id_eq")
    @ApiModelProperty("仓库标识EQ")
    private String repositoryIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_meta_id_eq")
    @JSONField(name = "n_meta_id_eq")
    @ApiModelProperty("标识EQ")
    private String metaIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.BRANCH.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("meta_id",contextParentKey);
        if(Entities.COMMIT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("sha",contextParentKey);
        if(Entities.REPOSITORY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("repository_id",contextParentKey);
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
    public QueryWrapper<BranchRefCommit> getSelectCond() {
        QueryWrapper<BranchRefCommit> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}