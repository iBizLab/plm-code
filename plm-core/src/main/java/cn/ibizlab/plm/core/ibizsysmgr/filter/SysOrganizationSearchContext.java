/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@ServiceAPI}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.filter;

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
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysOrganization;

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
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_organization_name_like")
    @JSONField(name = "n_organization_name_like")
    @ApiModelProperty("名称LIKE")
    private String organizationNameLIKE;

    /**
     * 上级名称EQ
     */
    @JsonProperty("n_parent_name_eq")
    @JSONField(name = "n_parent_name_eq")
    @ApiModelProperty("上级名称EQ")
    private String parentNameEQ;

    /**
     * 上级名称LIKE
     */
    @JsonProperty("n_parent_name_like")
    @JSONField(name = "n_parent_name_like")
    @ApiModelProperty("上级名称LIKE")
    private String parentNameLIKE;

    /**
     * 父标识EQ
     */
    @JsonProperty("n_parent_id_eq")
    @JSONField(name = "n_parent_id_eq")
    @ApiModelProperty("父标识EQ")
    private String parentIdEQ;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}