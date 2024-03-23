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
import cn.ibizlab.plm.core.ebsx.domain.SysEmployee;

/**
 * 关系型数据实体[SysEmployee] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("人员查询条件对象")
public class SysEmployeeSearchContext extends SearchContextBase {

    /**
     * 用户标识EQ
     */
    @JsonProperty("n_userid_eq")
    @JSONField(name = "n_userid_eq")
    @ApiModelProperty("用户标识EQ")
    private String userIdEQ;

    /**
     * 姓名LIKE
     */
    @JsonProperty("n_personname_like")
    @JSONField(name = "n_personname_like")
    @ApiModelProperty("姓名LIKE")
    private String personNameLIKE;

    /**
     * 性别EQ
     */
    @JsonProperty("n_sex_eq")
    @JSONField(name = "n_sex_eq")
    @ApiModelProperty("性别EQ")
    private String sexEQ;

    /**
     * 人员状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty("人员状态EQ")
    private String stateEQ;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}