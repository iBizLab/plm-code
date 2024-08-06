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
 * 智能报表立方体过滤[PSSysBICubeFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("智能报表立方体过滤DTO")
public class PSSysBICubeFilterDTO extends FilterBase implements Serializable {

    /**
     * 智能报表立方体标识EQ
     */
    @JsonProperty("n_pssysbicubeid_eq")
    @JSONField(name = "n_pssysbicubeid_eq")
    @ApiModelProperty(value = "智能报表立方体标识EQ", position = 0)
	private String psSysBiCubeIdEQ;

    /**
     * 立方体名称LIKE
     */
    @JsonProperty("n_pssysbicubename_like")
    @JSONField(name = "n_pssysbicubename_like")
    @ApiModelProperty(value = "立方体名称LIKE", position = 10)
	private String psSysBiCubeNameLIKE;


}