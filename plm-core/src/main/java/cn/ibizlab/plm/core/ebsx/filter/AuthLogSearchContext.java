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
import cn.ibizlab.plm.core.ebsx.domain.AuthLog;

/**
 * 关系型数据实体[AuthLog] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("认证日志查询条件对象")
public class AuthLogSearchContext extends SearchContextBase {

    /**
     * 标识EQ
     */
    @JsonProperty("n_logid_eq")
    @JSONField(name = "n_logid_eq")
    @ApiModelProperty("标识EQ")
    private String logIdEQ;

    /**
     * 用户全局名LIKE
     */
    @JsonProperty("n_username_like")
    @JSONField(name = "n_username_like")
    @ApiModelProperty("用户全局名LIKE")
    private String userNameLIKE;

    /**
     * 认证结果EQ
     */
    @JsonProperty("n_authcode_eq")
    @JSONField(name = "n_authcode_eq")
    @ApiModelProperty("认证结果EQ")
    private String authCodeEQ;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}