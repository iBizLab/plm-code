/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.base.filter;

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
import cn.ibizlab.plm.core.base.domain.Workload;

/**
 * 关系型数据实体[Workload] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工时查询条件对象")
public class WorkloadSearchContext extends QueryWrapperContext<Workload> {

    /**
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String identifierLIKE;

    /**
     * 工时主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty("工时主体标识EQ")
    private String principalIdEQ;

    /**
     * 工作日期GTANDEQ
     */
    @JsonProperty("n_register_date_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_register_date_gtandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("工作日期GTANDEQ")
    private Date registerDateGTANDEQ;

    /**
     * 工作日期IN
     */
    @JsonProperty("n_register_date_in")
    @JSONField(name = "n_register_date_in")
    @ApiModelProperty("工作日期IN")
    private String registerDateIN;

    /**
     * 工作日期LTANDEQ
     */
    @JsonProperty("n_register_date_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_register_date_ltandeq" , format = "yyyy-MM-dd")
    @ApiModelProperty("工作日期LTANDEQ")
    private Date registerDateLTANDEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 事项LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("事项LIKE")
    private String nameLIKE;

    /**
     * 类别EQ
     */
    @JsonProperty("n_type_id_eq")
    @JSONField(name = "n_type_id_eq")
    @ApiModelProperty("类别EQ")
    private String typeIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_type_name_eq")
    @JSONField(name = "n_type_name_eq")
    @ApiModelProperty("名称EQ")
    private String typeNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_type_name_like")
    @JSONField(name = "n_type_name_like")
    @ApiModelProperty("名称LIKE")
    private String typeNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.WORKLOAD_TYPE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("type_id",contextParentKey);
        if(Entities.WORK_ITEM.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
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
    public QueryWrapper<Workload> getSelectCond() {
        QueryWrapper<Workload> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}