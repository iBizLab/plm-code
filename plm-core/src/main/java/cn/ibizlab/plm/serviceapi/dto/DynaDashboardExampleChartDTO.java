/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 动态数据看板[DynaDashboardExampleChartDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("动态数据看板DTO")
public class DynaDashboardExampleChartDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否系统类型
     */
    @JsonProperty("is_system")
    @JSONField(name = "is_system")
    @ApiModelProperty(value = "是否系统类型", position = 0)
    private Integer isSystem;

    /**
     * 示例图
     */
    @JsonProperty("example_chart")
    @JSONField(name = "example_chart")
    @ApiModelProperty(value = "示例图", position = 1)
    private String exampleChart;

    /**
     * 应用标识
     */
    @JsonProperty("app_id")
    @JSONField(name = "app_id")
    @ApiModelProperty(value = "应用标识", position = 2)
    private String appId;

    /**
     * 描述
     */
    @JsonProperty("desc")
    @JSONField(name = "desc")
    @ApiModelProperty(value = "描述", position = 3)
    private String desc;

    /**
     * 动态数据看板标识
     */
    @JsonProperty("dyna_dashboard_id")
    @JSONField(name = "dyna_dashboard_id")
    @ApiModelProperty(value = "动态数据看板标识", position = 4)
    private String dynaDashboardId;

    /**
     * 看板类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "看板类型", position = 5)
    private String type;

    /**
     * 模型标识
     */
    @JsonProperty("model_id")
    @JSONField(name = "model_id")
    @ApiModelProperty(value = "模型标识", position = 6)
    private String modelId;

    /**
     * 序号
     */
    @JsonProperty("sequences")
    @JSONField(name = "sequences")
    @ApiModelProperty(value = "序号", position = 7)
    private BigDecimal sequences;

    /**
     * 名称
     */
    @JsonProperty("dyna_dashboard_name")
    @JSONField(name = "dyna_dashboard_name")
    @ApiModelProperty(value = "名称", position = 8)
    private String dynaDashboardName;


    /**
     * 设置 [是否系统类型]
     */
    public DynaDashboardExampleChartDTO setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
     * 设置 [示例图]
     */
    public DynaDashboardExampleChartDTO setExampleChart(String exampleChart) {
        this.exampleChart = exampleChart;
        this.modify("example_chart", exampleChart);
        return this;
    }

    /**
     * 设置 [应用标识]
     */
    public DynaDashboardExampleChartDTO setAppId(String appId) {
        this.appId = appId;
        this.modify("app_id", appId);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public DynaDashboardExampleChartDTO setDesc(String desc) {
        this.desc = desc;
        this.modify("desc", desc);
        return this;
    }

    /**
     * 设置 [看板类型]
     */
    public DynaDashboardExampleChartDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [模型标识]
     */
    public DynaDashboardExampleChartDTO setModelId(String modelId) {
        this.modelId = modelId;
        this.modify("model_id", modelId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public DynaDashboardExampleChartDTO setDynaDashboardName(String dynaDashboardName) {
        this.dynaDashboardName = dynaDashboardName;
        this.modify("dyna_dashboard_name", dynaDashboardName);
        return this;
    }


}
