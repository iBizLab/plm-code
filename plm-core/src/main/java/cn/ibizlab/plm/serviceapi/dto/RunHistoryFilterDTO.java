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
 * 执行结果过滤[RunHistoryFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行结果过滤DTO")
public class RunHistoryFilterDTO extends FilterBase implements Serializable {

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "执行结果EQ", position = 30)
	private String statusEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 70)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 100)
	private String nameLIKE;

    /**
     * 执行用例标识EQ
     */
    @JsonProperty("n_run_id_eq")
    @JSONField(name = "n_run_id_eq")
    @ApiModelProperty(value = "执行用例标识EQ", position = 130)
	private String runIdEQ;

    /**
     * 标题EQ
     */
    @JsonProperty("n_run_title_eq")
    @JSONField(name = "n_run_title_eq")
    @ApiModelProperty(value = "标题EQ", position = 140)
	private String runTitleEQ;

    /**
     * 标题LIKE
     */
    @JsonProperty("n_run_title_like")
    @JSONField(name = "n_run_title_like")
    @ApiModelProperty(value = "标题LIKE", position = 141)
	private String runTitleLIKE;


}