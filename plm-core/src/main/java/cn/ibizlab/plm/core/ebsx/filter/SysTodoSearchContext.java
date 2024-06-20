/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@ServiceAPI}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.filter;

import java.util.*;
import cn.ibizlab.util.filter.SearchContextBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import cn.ibizlab.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.plm.core.ebsx.domain.SysTodo;

/**
 * 关系型数据实体[SysTodo] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("待办查询条件对象")
public class SysTodoSearchContext extends SearchContextBase {

    /**
     * 待办标识EQ
     */
    @JsonProperty("n_todoid_eq")
    @JSONField(name = "n_todoid_eq")
    @ApiModelProperty("待办标识EQ")
    private String todoIdEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_title_like")
    @JSONField(name = "n_title_like")
    @ApiModelProperty("标题LIKE")
    private String titleLIKE;

    /**
     * 待办地址类型EQ
     */
    @JsonProperty("n_todourltype_eq")
    @JSONField(name = "n_todourltype_eq")
    @ApiModelProperty("待办地址类型EQ")
    private String todoUrlTypeEQ;

    /**
     * 待办状态EQ
     */
    @JsonProperty("n_todostate_eq")
    @JSONField(name = "n_todostate_eq")
    @ApiModelProperty("待办状态EQ")
    private String todoStateEQ;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}