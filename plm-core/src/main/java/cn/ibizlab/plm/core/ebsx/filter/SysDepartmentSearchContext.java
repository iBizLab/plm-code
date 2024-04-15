/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@ServiceAPI}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.filter;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.ebsx.domain.SysDepartment;

/**
 * 关系型数据实体[SysDepartment] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("部门查询条件对象")
public class SysDepartmentSearchContext extends SearchContextBase {

    /**
     * 部门标识EQ
     */
    @JsonProperty("n_deptid_eq")
    @JSONField(name = "n_deptid_eq")
    @ApiModelProperty("部门标识EQ")
    private String deptIdEQ;

    /**
     * 部门名称LIKE
     */
    @JsonProperty("n_deptname_like")
    @JSONField(name = "n_deptname_like")
    @ApiModelProperty("部门名称LIKE")
    private String deptNameLIKE;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}