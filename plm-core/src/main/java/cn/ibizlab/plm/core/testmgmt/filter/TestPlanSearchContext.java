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
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;

/**
 * 关系型数据实体[TestPlan] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("测试计划查询条件对象")
public class TestPlanSearchContext extends QueryWrapperContext<TestPlan> {

    /**
     * 状态EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty("状态EQ")
    private String statusEQ;

    /**
     * 测试分类EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty("测试分类EQ")
    private String typeEQ;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty("类别LIKE")
    private String categoriesLIKE;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_name_eq")
    @JSONField(name = "n_assignee_name_eq")
    @ApiModelProperty("负责人EQ")
    private String assigneeNameEQ;

    /**
     * 负责人标识EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty("负责人标识EQ")
    private String assigneeIdEQ;

    /**
     * 计划名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("计划名称LIKE")
    private String nameLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty("测试库标识EQ")
    private String libraryIdEQ;

    /**
     * 关联项目EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty("关联项目EQ")
    private String projectIdEQ;

    /**
     * 关联迭代EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty("关联迭代EQ")
    private String sprintIdEQ;

    /**
     * 关联项目EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty("关联项目EQ")
    private String projectNameEQ;

    /**
     * 关联项目LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty("关联项目LIKE")
    private String projectNameLIKE;

    /**
     * 关联迭代EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty("关联迭代EQ")
    private String sprintNameEQ;

    /**
     * 关联迭代LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty("关联迭代LIKE")
    private String sprintNameLIKE;

    /**
     * 所属测试库EQ
     */
    @JsonProperty("n_library_name_eq")
    @JSONField(name = "n_library_name_eq")
    @ApiModelProperty("所属测试库EQ")
    private String libraryNameEQ;

    /**
     * 所属测试库LIKE
     */
    @JsonProperty("n_library_name_like")
    @JSONField(name = "n_library_name_like")
    @ApiModelProperty("所属测试库LIKE")
    private String libraryNameLIKE;

    /**
     * 项目发布标识EQ
     */
    @JsonProperty("n_release_id_eq")
    @JSONField(name = "n_release_id_eq")
    @ApiModelProperty("项目发布标识EQ")
    private String releaseIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_release_name_eq")
    @JSONField(name = "n_release_name_eq")
    @ApiModelProperty("名称EQ")
    private String releaseNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_release_name_like")
    @JSONField(name = "n_release_name_like")
    @ApiModelProperty("名称LIKE")
    private String releaseNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.LIBRARY.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("library_id",contextParentKey);
        if(Entities.PROJECT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("project_id",contextParentKey);
        if(Entities.RELEASE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("release_id",contextParentKey);
        if(Entities.SPRINT.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("sprint_id",contextParentKey);
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
    public QueryWrapper<TestPlan> getSelectCond() {
        QueryWrapper<TestPlan> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}