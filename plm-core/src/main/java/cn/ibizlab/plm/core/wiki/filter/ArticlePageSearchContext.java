/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@SQL}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.wiki.filter;

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
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;

/**
 * 关系型数据实体[ArticlePage] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("页面查询条件对象")
public class ArticlePageSearchContext extends QueryWrapperContext<ArticlePage> {

    /**
     * 编号EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty("编号EQ")
    private String identifierEQ;

    /**
     * 正文格式EQ
     */
    @JsonProperty("n_format_type_eq")
    @JSONField(name = "n_format_type_eq")
    @ApiModelProperty("正文格式EQ")
    private String formatTypeEQ;

    /**
     * 正文LIKE
     */
    @JsonProperty("n_content_like")
    @JSONField(name = "n_content_like")
    @ApiModelProperty("正文LIKE")
    private String contentLIKE;

    /**
     * 类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty("类型EQ")
    private String typeEQ;

    /**
     * 是否星标EQ
     */
    @JsonProperty("n_is_favorite_eq")
    @JSONField(name = "n_is_favorite_eq")
    @ApiModelProperty("是否星标EQ")
    private String isFavoriteEQ;

    /**
     * 发布时间GTANDEQ
     */
    @JsonProperty("n_publish_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_publish_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("发布时间GTANDEQ")
    private Date publishTimeGTANDEQ;

    /**
     * 发布时间LTANDEQ
     */
    @JsonProperty("n_publish_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_publish_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("发布时间LTANDEQ")
    private Date publishTimeLTANDEQ;

    /**
     * 发布人EQ
     */
    @JsonProperty("n_publish_man_eq")
    @JSONField(name = "n_publish_man_eq")
    @ApiModelProperty("发布人EQ")
    private String publishManEQ;

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
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间EQ")
    private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间GTANDEQ")
    private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("建立时间LTANDEQ")
    private Date createTimeLTANDEQ;

    /**
     * 主题LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("主题LIKE")
    private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 空间标识EQ
     */
    @JsonProperty("n_space_id_eq")
    @JSONField(name = "n_space_id_eq")
    @ApiModelProperty("空间标识EQ")
    private String spaceIdEQ;

    /**
     * 父页面标识EQ
     */
    @JsonProperty("n_parent_id_eq")
    @JSONField(name = "n_parent_id_eq")
    @ApiModelProperty("父页面标识EQ")
    private String parentIdEQ;

    /**
     * 父页面标识ISNULL
     */
    @JsonProperty("n_parent_id_isnull")
    @JSONField(name = "n_parent_id_isnull")
    @ApiModelProperty("父页面标识ISNULL")
    private String parentIdISNULL;

    /**
     * 空间名称EQ
     */
    @JsonProperty("n_space_name_eq")
    @JSONField(name = "n_space_name_eq")
    @ApiModelProperty("空间名称EQ")
    private String spaceNameEQ;

    /**
     * 空间名称LIKE
     */
    @JsonProperty("n_space_name_like")
    @JSONField(name = "n_space_name_like")
    @ApiModelProperty("空间名称LIKE")
    private String spaceNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.ARTICLE_PAGE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("parent_id",contextParentKey);
        if(Entities.SPACE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("space_id",contextParentKey);
    }

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("identifier",query),QueryFilter.createQuery().like("name",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<ArticlePage> getSelectCond() {
        QueryWrapper<ArticlePage> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}