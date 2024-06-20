/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@MINHERIT}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.filter;

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

import org.springframework.util.ObjectUtils;
import cn.ibizlab.util.filter.QueryWrapperContext;
import cn.ibizlab.util.filter.QueryFilter;
import cn.ibizlab.plm.util.enums.Entities;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;

/**
 * 关系型数据实体[BaselineTestCase] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("基线用例查询条件对象")
public class BaselineTestCaseSearchContext extends QueryWrapperContext<BaselineTestCase> {

    /**
     * 关联主体标识EQ
     */
    @JsonProperty("n_principal_id_eq")
    @JSONField(name = "n_principal_id_eq")
    @ApiModelProperty("关联主体标识EQ")
    private String principalIdEQ;

    /**
     * 关联目标标识EQ
     */
    @JsonProperty("n_target_id_eq")
    @JSONField(name = "n_target_id_eq")
    @ApiModelProperty("关联目标标识EQ")
    private String targetIdEQ;

    /**
     * 目标对象版本标识EQ
     */
    @JsonProperty("n_target_version_id_eq")
    @JSONField(name = "n_target_version_id_eq")
    @ApiModelProperty("目标对象版本标识EQ")
    private String targetVersionIdEQ;

    /**
     * 测试类型EQ
     */
    @JsonProperty("n_test_type_eq")
    @JSONField(name = "n_test_type_eq")
    @ApiModelProperty("测试类型EQ")
    private String testTypeEQ;

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

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.BASELINE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("principal_id",contextParentKey);
        if(Entities.VERSION.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("target_version_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("name",query)));
    }
}