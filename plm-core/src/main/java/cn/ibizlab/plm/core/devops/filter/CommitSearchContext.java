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
import cn.ibizlab.plm.core.devops.domain.Commit;

/**
 * 关系型数据实体[Commit] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("代码提交查询条件对象")
public class CommitSearchContext extends QueryWrapperContext<Commit> {

    /**
     * SHA值EQ
     */
    @JsonProperty("n_sha_eq")
    @JSONField(name = "n_sha_eq")
    @ApiModelProperty("SHA值EQ")
    private String shaEQ;

    /**
     * 提交消息LIKE
     */
    @JsonProperty("n_message_like")
    @JSONField(name = "n_message_like")
    @ApiModelProperty("提交消息LIKE")
    private String messageLIKE;

    @Override
    public void setQuery(String query) {
        this.query=query;
        if(!ObjectUtils.isEmpty(query))
            this.getFilter().and(QueryFilter.createQuery().or(QueryFilter.createQuery().like("message",query)));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @Override
    public QueryWrapper<Commit> getSelectCond() {
        QueryWrapper<Commit> queryWrapper = super.getSelectCond();
        return queryWrapper;
    }
}