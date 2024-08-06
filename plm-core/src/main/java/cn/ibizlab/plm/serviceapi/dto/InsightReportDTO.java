/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
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
 * 效能报表[InsightReportDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("效能报表DTO")
public class InsightReportDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 描述
     */
    @JsonProperty("desc")
    @JSONField(name = "desc")
    @ApiModelProperty(value = "描述", position = 0)
    private String desc;

    /**
     * 是否系统类型
     */
    @JsonProperty("is_system")
    @JSONField(name = "is_system")
    @ApiModelProperty(value = "是否系统类型", position = 1)
    private Integer isSystem;

    /**
     * 图表类型
     */
    @JsonProperty("chart_type")
    @JSONField(name = "chart_type")
    @ApiModelProperty(value = "图表类型", position = 2)
    private String chartType;

    /**
     * 组别
     */
    @JsonProperty("group")
    @JSONField(name = "group")
    @ApiModelProperty(value = "组别", position = 3)
    private String group;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 4)
    private String categories;

    /**
     * 类别
     */
    @JsonProperty("categories_name")
    @JSONField(name = "categories_name")
    @ApiModelProperty(value = "类别", position = 5)
    private String categoriesName;

    /**
     * 模板模型
     */
    @JsonProperty("template_model")
    @JSONField(name = "template_model")
    @ApiModelProperty(value = "模板模型", position = 6)
    private String templateModel;

    /**
     * 分组数据
     */
    @JsonProperty("group_data")
    @JSONField(name = "group_data")
    @ApiModelProperty(value = "分组数据", position = 7)
    private Map groupData;

    /**
     * 报表部件标识
     */
    @JsonProperty("ctrl_id")
    @JSONField(name = "ctrl_id")
    @ApiModelProperty(value = "报表部件标识", position = 8)
    private String ctrlId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 9)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 10)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 11)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 12)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 13)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 14)
    private Date updateTime;

    /**
     * 视图标识
     */
    @JsonProperty("view_id")
    @JSONField(name = "view_id")
    @ApiModelProperty(value = "视图标识", position = 15)
    private String viewId;

    /**
     * 名称
     */
    @JsonProperty("view_name")
    @JSONField(name = "view_name")
    @ApiModelProperty(value = "名称", position = 16)
    private String viewName;


    /**
     * 设置 [描述]
     */
    public InsightReportDTO setDesc(String desc) {
        this.desc = desc;
        this.modify("desc", desc);
        return this;
    }

    /**
     * 设置 [是否系统类型]
     */
    public InsightReportDTO setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
     * 设置 [图表类型]
     */
    public InsightReportDTO setChartType(String chartType) {
        this.chartType = chartType;
        this.modify("chart_type", chartType);
        return this;
    }

    /**
     * 设置 [组别]
     */
    public InsightReportDTO setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public InsightReportDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public InsightReportDTO setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
     * 设置 [模板模型]
     */
    public InsightReportDTO setTemplateModel(String templateModel) {
        this.templateModel = templateModel;
        this.modify("template_model", templateModel);
        return this;
    }

    /**
     * 设置 [分组数据]
     */
    public InsightReportDTO setGroupData(Map groupData) {
        this.groupData = groupData;
        this.modify("group_data", groupData);
        return this;
    }

    /**
     * 设置 [报表部件标识]
     */
    public InsightReportDTO setCtrlId(String ctrlId) {
        this.ctrlId = ctrlId;
        this.modify("ctrl_id", ctrlId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public InsightReportDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [视图标识]
     */
    public InsightReportDTO setViewId(String viewId) {
        this.viewId = viewId;
        this.modify("view_id", viewId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public InsightReportDTO setViewName(String viewName) {
        this.viewName = viewName;
        this.modify("view_name", viewName);
        return this;
    }


}
