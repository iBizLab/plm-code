/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.team.filter;

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
import cn.ibizlab.plm.core.team.domain.UpdateRecord;

/**
 * 关系型数据实体[UpdateRecord] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("进展查询条件对象")
public class UpdateRecordSearchContext extends QueryWrapperContext<UpdateRecord> {

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
     * 关键结果标识EQ
     */
    @JsonProperty("n_key_result_id_eq")
    @JSONField(name = "n_key_result_id_eq")
    @ApiModelProperty("关键结果标识EQ")
    private String keyResultIdEQ;

    /**
     * 目标标识EQ
     */
    @JsonProperty("n_objective_id_eq")
    @JSONField(name = "n_objective_id_eq")
    @ApiModelProperty("目标标识EQ")
    private String objectiveIdEQ;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.KEY_RESULT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("key_result_id",contextParentKey);
        if(Entities.OBJECTIVE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("objective_id",contextParentKey);
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
    public QueryWrapper<UpdateRecord> getSelectCond() {
        QueryWrapper<UpdateRecord> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}