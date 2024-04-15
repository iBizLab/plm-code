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
 * 实体主状态迁移逻辑过滤[PSDEMSLogicFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体主状态迁移逻辑过滤DTO")
public class PSDEMSLogicFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体处理逻辑名称LIKE
     */
    @JsonProperty("n_psdelogicname_like")
    @JSONField(name = "n_psdelogicname_like")
    @ApiModelProperty(value = "实体处理逻辑名称LIKE", position = 50)
	private String psdeLogicNameLIKE;

    /**
     * 实体处理逻辑标识EQ
     */
    @JsonProperty("n_psdelogicid_eq")
    @JSONField(name = "n_psdelogicid_eq")
    @ApiModelProperty(value = "实体处理逻辑标识EQ", position = 60)
	private String psdeLogicIdEQ;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdeid_eq")
    @JSONField(name = "n_psdeid_eq")
    @ApiModelProperty(value = "实体EQ", position = 70)
	private String psdeidEQ;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdename_eq")
    @JSONField(name = "n_psdename_eq")
    @ApiModelProperty(value = "实体EQ", position = 80)
	private String psdeNameEQ;

    /**
     * 实体LIKE
     */
    @JsonProperty("n_psdename_like")
    @JSONField(name = "n_psdename_like")
    @ApiModelProperty(value = "实体LIKE", position = 81)
	private String psdeNameLIKE;


}