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
 * 看板栏过滤[EntryFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("看板栏过滤DTO")
public class EntryFilterDTO extends FilterBase implements Serializable {

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 30)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 40)
	private String nameLIKE;

    /**
     * 看板标识EQ
     */
    @JsonProperty("n_board_id_eq")
    @JSONField(name = "n_board_id_eq")
    @ApiModelProperty(value = "看板标识EQ", position = 90)
	private String boardIdEQ;

    /**
     * 项目标识EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "项目标识EQ", position = 100)
	private String projectIdEQ;


}