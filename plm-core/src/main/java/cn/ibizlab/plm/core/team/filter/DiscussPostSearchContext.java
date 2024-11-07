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
import cn.ibizlab.plm.core.team.domain.DiscussPost;

/**
 * 关系型数据实体[DiscussPost] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("讨论查询条件对象")
public class DiscussPostSearchContext extends QueryWrapperContext<DiscussPost> {

    /**
     * 状态EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty("状态EQ")
    private String statusEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 讨论名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("讨论名称LIKE")
    private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty("建立人EQ")
    private String createManEQ;

    /**
     * 话题标识EQ
     */
    @JsonProperty("n_topic_id_eq")
    @JSONField(name = "n_topic_id_eq")
    @ApiModelProperty("话题标识EQ")
    private String topicIdEQ;

    /**
     * 话题EQ
     */
    @JsonProperty("n_topic_name_eq")
    @JSONField(name = "n_topic_name_eq")
    @ApiModelProperty("话题EQ")
    private String topicNameEQ;

    /**
     * 话题LIKE
     */
    @JsonProperty("n_topic_name_like")
    @JSONField(name = "n_topic_name_like")
    @ApiModelProperty("话题LIKE")
    private String topicNameLIKE;

    @Override
    public void setContextParentKey(Serializable contextParentKey) {
        super.setContextParentKey(contextParentKey);
        if(Entities.DISCUSS_TOPIC.equals(this.getContextParentEntity())&&contextParentKey!=null)
            this.getFilter().eq("topic_id",contextParentKey);
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
    public QueryWrapper<DiscussPost> getSelectCond() {
        QueryWrapper<DiscussPost> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}