/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.insight.domain;

import java.util.*;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import cn.ibizlab.plm.core.insight.domain.InsightView;

/**
 * 效能报表实体类[InsightReport]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "INSIGHT_REPORT", resultMap = "InsightReportResultMap")
@ApiModel(value = "INSIGHT_REPORT", description = "效能报表")
public class InsightReport extends EntityMP implements Serializable
{

    /**
    * 描述
    */
    @TableField(value = "desc")
    @DEField(name = "desc")
    @JSONField(name = "desc")
    @JsonProperty("desc")
    @ApiModelProperty(value = "desc", notes = "描述")
    private String desc;

    /**
    * 是否系统类型
    */
    @TableField(value = "is_system")
    @DEField(name = "is_system" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_system")
    @JsonProperty("is_system")
    @ApiModelProperty(value = "is_system", notes = "是否系统类型")
    private Integer isSystem;

    /**
    * 图表类型
    */
    @TableField(value = "chart_type")
    @DEField(name = "chart_type" , dict = "bi_chart_type2")
    @JSONField(name = "chart_type")
    @JsonProperty("chart_type")
    @ApiModelProperty(value = "chart_type", notes = "图表类型")
    private String chartType;

    /**
    * 组别
    */
    @TableField(value = "group")
    @DEField(name = "group" , dict = "report_group_bi")
    @JSONField(name = "group")
    @JsonProperty("group")
    @ApiModelProperty(value = "group", notes = "组别")
    private String group;

    /**
    * 类别
    */
    @TableField(value = "categories")
    @DEField(name = "categories" , dict = "category")
    @JSONField(name = "categories")
    @JsonProperty("categories")
    @ApiModelProperty(value = "categories", notes = "类别")
    private String categories;

    /**
    * 类别
    */
    @TableField(value = "categories_name" , exist = false)
    @DEField(name = "categories_name")
    @JSONField(name = "categories_name")
    @JsonProperty("categories_name")
    @ApiModelProperty(value = "categories_name", notes = "类别")
    private String categoriesName;

    /**
    * 模板模型
    */
    @TableField(value = "template_model")
    @DEField(name = "template_model")
    @JSONField(name = "template_model")
    @JsonProperty("template_model")
    @ApiModelProperty(value = "template_model", notes = "模板模型")
    private String templateModel;

    /**
    * 分组数据
    */
    @TableField(value = "group_data" , exist = false)
    @DEField(name = "group_data")
    @JSONField(name = "group_data")
    @JsonProperty("group_data")
    @ApiModelProperty(value = "group_data", notes = "分组数据")
    private Map groupData;

    /**
    * 报表部件标识
    */
    @TableField(value = "ctrl_id" , exist = false)
    @DEField(name = "ctrl_id")
    @JSONField(name = "ctrl_id")
    @JsonProperty("ctrl_id")
    @ApiModelProperty(value = "ctrl_id", notes = "报表部件标识")
    private String ctrlId;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 视图标识
    */
    @TableField(value = "view_id")
    @DEField(name = "view_id")
    @JSONField(name = "view_id")
    @JsonProperty("view_id")
    @ApiModelProperty(value = "view_id", notes = "视图标识")
    private String viewId;

    /**
    * 名称
    */
    @TableField(value = "view_name" , exist = false)
    @DEField(name = "view_name")
    @JSONField(name = "view_name")
    @JsonProperty("view_name")
    @ApiModelProperty(value = "view_name", notes = "名称")
    private String viewName;

    /**
    * 视图-报表
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "insight_view", notes = "视图-报表")
    private InsightView insightView;

    /**
    * 设置 [描述]
    */
    public InsightReport setDesc(String desc) {
        this.desc = desc;
        this.modify("desc", desc);
        return this;
    }

    /**
    * 设置 [是否系统类型]
    */
    public InsightReport setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
    * 设置 [图表类型]
    */
    public InsightReport setChartType(String chartType) {
        this.chartType = chartType;
        this.modify("chart_type", chartType);
        return this;
    }

    /**
    * 设置 [组别]
    */
    public InsightReport setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public InsightReport setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public InsightReport setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
    * 设置 [模板模型]
    */
    public InsightReport setTemplateModel(String templateModel) {
        this.templateModel = templateModel;
        this.modify("template_model", templateModel);
        return this;
    }

    /**
    * 设置 [分组数据]
    */
    public InsightReport setGroupData(Map groupData) {
        this.groupData = groupData;
        this.modify("group_data", groupData);
        return this;
    }

    /**
    * 设置 [报表部件标识]
    */
    public InsightReport setCtrlId(String ctrlId) {
        this.ctrlId = ctrlId;
        this.modify("ctrl_id", ctrlId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public InsightReport setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [视图标识]
    */
    public InsightReport setViewId(String viewId) {
        this.viewId = viewId;
        this.modify("view_id", viewId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public InsightReport setViewName(String viewName) {
        this.viewName = viewName;
        this.modify("view_name", viewName);
        return this;
    }


    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param includeEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T pasteTo(T targetEntity, boolean includeEmpty) {
        super.pasteTo(targetEntity, includeEmpty);
        if(targetEntity instanceof IEntity) {
            IEntity entity = ((IEntity) targetEntity);
            entity.reset("id");
        }
        return targetEntity;
    }

}