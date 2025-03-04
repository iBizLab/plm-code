/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFILTER}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.filter.FilterBase;

import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 动态数据看板过滤[DynaDashboardFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("动态数据看板过滤DTO")
public class DynaDashboardFilterDTO extends FilterBase implements Serializable {

    /**
     * 所属数据标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty(value = "所属数据标识EQ", position = 30)
	private String ownerIdEQ;

    /**
     * 动态数据看板标识EQ
     */
    @JsonProperty("n_dynadashboardid_eq")
    @JSONField(name = "n_dynadashboardid_eq")
    @ApiModelProperty(value = "动态数据看板标识EQ", position = 70)
	private String dynaDashboardIdEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_dynadashboardname_like")
    @JSONField(name = "n_dynadashboardname_like")
    @ApiModelProperty(value = "名称LIKE", position = 80)
	private String dynaDashboardNameLIKE;


}