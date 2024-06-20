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
import cn.ibizlab.plm.core.base.domain.ExtendStorage;

/**
 * 关系型数据实体[ExtendStorage] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("扩展存储查询条件对象")
public class ExtendStorageSearchContext extends QueryWrapperContext<ExtendStorage> {

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
     * 文本值EQ
     */
    @JsonProperty("n_string_value_eq")
    @JSONField(name = "n_string_value_eq")
    @ApiModelProperty("文本值EQ")
    private String stringValueEQ;

    /**
     * 文本值ISNULL
     */
    @JsonProperty("n_string_value_isnull")
    @JSONField(name = "n_string_value_isnull")
    @ApiModelProperty("文本值ISNULL")
    private String stringValueISNULL;

    /**
     * 文本值LIKE
     */
    @JsonProperty("n_string_value_like")
    @JSONField(name = "n_string_value_like")
    @ApiModelProperty("文本值LIKE")
    private String stringValueLIKE;

    /**
     * 长文本值ISNULL
     */
    @JsonProperty("n_longstring_value_isnull")
    @JSONField(name = "n_longstring_value_isnull")
    @ApiModelProperty("长文本值ISNULL")
    private String longstringValueISNULL;

    /**
     * 长文本值LIKE
     */
    @JsonProperty("n_longstring_value_like")
    @JSONField(name = "n_longstring_value_like")
    @ApiModelProperty("长文本值LIKE")
    private String longstringValueLIKE;

    /**
     * 浮点值EQ
     */
    @JsonProperty("n_double_value_eq")
    @JSONField(name = "n_double_value_eq")
    @ApiModelProperty("浮点值EQ")
    private BigDecimal doubleValueEQ;

    /**
     * 时间值EQ
     */
    @JsonProperty("n_datetime_value_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_datetime_value_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("时间值EQ")
    private Date datetimeValueEQ;

    /**
     * 数值值EQ
     */
    @JsonProperty("n_decimal_value_eq")
    @JSONField(name = "n_decimal_value_eq")
    @ApiModelProperty("数值值EQ")
    private BigDecimal decimalValueEQ;

    /**
     * 整形值EQ
     */
    @JsonProperty("n_int_value_eq")
    @JSONField(name = "n_int_value_eq")
    @ApiModelProperty("整形值EQ")
    private Integer intValueEQ;

    /**
     * 大整形值EQ
     */
    @JsonProperty("n_bigint_value_eq")
    @JSONField(name = "n_bigint_value_eq")
    @JsonSerialize(using = ToStringSerializer.class)            
    @ApiModelProperty("大整形值EQ")
    private Long bigintValueEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_name_eq")
    @JSONField(name = "n_name_eq")
    @ApiModelProperty("名称EQ")
    private String nameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("名称LIKE")
    private String nameLIKE;

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
    public QueryWrapper<ExtendStorage> getSelectCond() {
        QueryWrapper<ExtendStorage> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}