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
import cn.ibizlab.plm.core.ebsx.domain.SysOrganization;

/**
 * 关系型数据实体[SysOrganization] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("组织查询条件对象")
public class SysOrganizationSearchContext extends SearchContextBase {

    /**
     * 上级单位EQ
     */
    @JsonProperty("n_porgid_eq")
    @JSONField(name = "n_porgid_eq")
    @ApiModelProperty("上级单位EQ")
    private String parentOrgIdEQ;

    /**
     * 上级单位EQ
     */
    @JsonProperty("n_porgname_eq")
    @JSONField(name = "n_porgname_eq")
    @ApiModelProperty("上级单位EQ")
    private String parentOrgNameEQ;

    /**
     * 上级单位LIKE
     */
    @JsonProperty("n_porgname_like")
    @JSONField(name = "n_porgname_like")
    @ApiModelProperty("上级单位LIKE")
    private String parentOrgNameLIKE;

    /**
     * 单位标识EQ
     */
    @JsonProperty("n_orgid_eq")
    @JSONField(name = "n_orgid_eq")
    @ApiModelProperty("单位标识EQ")
    private String orgIdEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_orgname_like")
    @JSONField(name = "n_orgname_like")
    @ApiModelProperty("名称LIKE")
    private String orgNameLIKE;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}