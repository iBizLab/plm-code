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
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String identifierLIKE;

    /**
     * 是否开启共享EQ
     */
    @JsonProperty("n_is_shared_eq")
    @JSONField(name = "n_is_shared_eq")
    @ApiModelProperty("是否开启共享EQ")
    private String isSharedEQ;

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
     * 类别路径LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty("类别路径LIKE")
    private String categoriesLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty("是否已归档EQ")
    private Integer isArchivedEQ;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty("是否已删除EQ")
    private Integer isDeletedEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty("关注EXISTS")
    private String attentionsEXISTSuser_idEQ;

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
     * 编号EQ
     */
    @JsonProperty("n_show_identifier_eq")
    @JSONField(name = "n_show_identifier_eq")
    @ApiModelProperty("编号EQ")
    private String showIdentifierEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty("编号LIKE")
    private String showIdentifierLIKE;

    /**
     * 是否同时共享子页面EQ
     */
    @JsonProperty("n_is_shared_subset_eq")
    @JSONField(name = "n_is_shared_subset_eq")
    @ApiModelProperty("是否同时共享子页面EQ")
    private String isSharedSubsetEQ;

    /**
     * 最近创建日期LTANDEQ
     */
    @JsonProperty("n_recent_create_days_ltandeq")
    @JSONField(name = "n_recent_create_days_ltandeq")
    @ApiModelProperty("最近创建日期LTANDEQ")
    private Integer recentCreateDaysLTANDEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

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
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty("建立人IN")
    private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty("建立人ISNOTNULL")
    private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty("建立人ISNULL")
    private String createManISNULL;

    /**
     * 建立人NOTEQ
     */
    @JsonProperty("n_create_man_noteq")
    @JSONField(name = "n_create_man_noteq")
    @ApiModelProperty("建立人NOTEQ")
    private String createManNOTEQ;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty("建立人NOTIN")
    private String createManNOTIN;

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
     * 更新时间GTANDEQ
     */
    @JsonProperty("n_update_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间GTANDEQ")
    private Date updateTimeGTANDEQ;

    /**
     * 更新时间LTANDEQ
     */
    @JsonProperty("n_update_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间LTANDEQ")
    private Date updateTimeLTANDEQ;

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
     * 父页面标识ISNOTNULL
     */
    @JsonProperty("n_parent_id_isnotnull")
    @JSONField(name = "n_parent_id_isnotnull")
    @ApiModelProperty("父页面标识ISNOTNULL")
    private String parentIdISNOTNULL;

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

    /**
     * 用户标记EQ
     */
    @JsonProperty("n_user_tag_eq")
    @JSONField(name = "n_user_tag_eq")
    @ApiModelProperty("用户标记EQ")
    private String userTagEQ;

    /**
     * 用户标记LIKE
     */
    @JsonProperty("n_user_tag_like")
    @JSONField(name = "n_user_tag_like")
    @ApiModelProperty("用户标记LIKE")
    private String userTagLIKE;

    /**
     * 用户标记2EQ
     */
    @JsonProperty("n_user_tag2_eq")
    @JSONField(name = "n_user_tag2_eq")
    @ApiModelProperty("用户标记2EQ")
    private String userTag2EQ;

    /**
     * 用户标记2LIKE
     */
    @JsonProperty("n_user_tag2_like")
    @JSONField(name = "n_user_tag2_like")
    @ApiModelProperty("用户标记2LIKE")
    private String userTag2LIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.ARTICLE_PAGE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("parent_id",contextParentKey);
        if(Entities.SPACE.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("space_id",contextParentKey);
        if(Entities.SHARED_SPACE.equals(this.getContextParentEntity())&&contextParentKey!=null)
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
        if (!ObjectUtils.isEmpty(this.attentionsEXISTSuser_idEQ)) {
            queryWrapper.exists("SELECT 1 FROM ATTENTION WHERE ATTENTION. = T1. "
                + " AND ATTENTION.USER_ID "
                + " = "
                + "'" + this.attentionsEXISTSuser_idEQ + "'"
            );
        }
        return queryWrapper;
    }
}