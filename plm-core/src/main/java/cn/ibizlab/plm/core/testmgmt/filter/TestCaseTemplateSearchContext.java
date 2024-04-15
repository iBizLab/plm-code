/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.filter;

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
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;

/**
 * 关系型数据实体[TestCaseTemplate] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例模板查询条件对象")
public class TestCaseTemplateSearchContext extends QueryWrapperContext<TestCaseTemplate> {

    /**
     * 重要程度EQ
     */
    @JsonProperty("n_level_eq")
    @JSONField(name = "n_level_eq")
    @ApiModelProperty("重要程度EQ")
    private String levelEQ;

    /**
     * 用例类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty("用例类型EQ")
    private String typeEQ;

    /**
     * 测试类型EQ
     */
    @JsonProperty("n_test_type_eq")
    @JSONField(name = "n_test_type_eq")
    @ApiModelProperty("测试类型EQ")
    private String testTypeEQ;

    /**
     * 评审状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty("评审状态EQ")
    private String stateEQ;

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_run_status_eq")
    @JSONField(name = "n_run_status_eq")
    @ApiModelProperty("执行结果EQ")
    private String runStatusEQ;

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
     * 测试库标识EQ
     */
    @JsonProperty("n_test_library_id_eq")
    @JSONField(name = "n_test_library_id_eq")
    @ApiModelProperty("测试库标识EQ")
    private String testLibraryIdEQ;

    /**
     * 测试库名称EQ
     */
    @JsonProperty("n_test_library_name_eq")
    @JSONField(name = "n_test_library_name_eq")
    @ApiModelProperty("测试库名称EQ")
    private String testLibraryNameEQ;

    /**
     * 测试库名称LIKE
     */
    @JsonProperty("n_test_library_name_like")
    @JSONField(name = "n_test_library_name_like")
    @ApiModelProperty("测试库名称LIKE")
    private String testLibraryNameLIKE;

    /**
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty("用例模块标识EQ")
    private String suiteIdEQ;

    /**
     * 模块名称EQ
     */
    @JsonProperty("n_suite_name_eq")
    @JSONField(name = "n_suite_name_eq")
    @ApiModelProperty("模块名称EQ")
    private String suiteNameEQ;

    /**
     * 模块名称LIKE
     */
    @JsonProperty("n_suite_name_like")
    @JSONField(name = "n_suite_name_like")
    @ApiModelProperty("模块名称LIKE")
    private String suiteNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.LIBRARY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("test_library_id",contextParentKey);
        if(Entities.TEST_SUITE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("suite_id",contextParentKey);
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
    public QueryWrapper<TestCaseTemplate> getSelectCond() {
        QueryWrapper<TestCaseTemplate> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}