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
import cn.ibizlab.plm.core.ebsx.domain.UserRole;

/**
 * 关系型数据实体[UserRole] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用户角色关系查询条件对象")
public class UserRoleSearchContext extends SearchContextBase {

    /**
     * 用户角色关系标识EQ
     */
    @JsonProperty("n_sys_user_roleid_eq")
    @JSONField(name = "n_sys_user_roleid_eq")
    @ApiModelProperty("用户角色关系标识EQ")
    private String userRoleIdEQ;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}