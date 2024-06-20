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
 * 效能报表过滤[InsightReportFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("效能报表过滤DTO")
public class InsightReportFilterDTO extends FilterBase implements Serializable {

    /**
     * 图表类型EQ
     */
    @JsonProperty("n_chart_type_eq")
    @JSONField(name = "n_chart_type_eq")
    @ApiModelProperty(value = "图表类型EQ", position = 10)
	private String chartTypeEQ;

    /**
     * 组别EQ
     */
    @JsonProperty("n_group_eq")
    @JSONField(name = "n_group_eq")
    @ApiModelProperty(value = "组别EQ", position = 20)
	private String groupEQ;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty(value = "类别LIKE", position = 30)
	private String categoriesLIKE;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 50)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 60)
	private String nameLIKE;

    /**
     * 视图标识EQ
     */
    @JsonProperty("n_view_id_eq")
    @JSONField(name = "n_view_id_eq")
    @ApiModelProperty(value = "视图标识EQ", position = 110)
	private String viewIdEQ;


}