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
import cn.ibizlab.plm.core.ebsx.domain.Role;

/**
 * 关系型数据实体[Role] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("系统角色查询条件对象")
public class RoleSearchContext extends SearchContextBase {

    /**
     * 角色标识EQ
     */
    @JsonProperty("n_sys_roleid_eq")
    @JSONField(name = "n_sys_roleid_eq")
    @ApiModelProperty("角色标识EQ")
    private String roleIdEQ;

    /**
     * 角色名称LIKE
     */
    @JsonProperty("n_sys_rolename_like")
    @JSONField(name = "n_sys_rolename_like")
    @ApiModelProperty("角色名称LIKE")
    private String roleNameLIKE;

    /**
     * 用户模式EQ
     */
    @JsonProperty("n_usermode_eq")
    @JSONField(name = "n_usermode_eq")
    @ApiModelProperty("用户模式EQ")
    private String userModeEQ;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}