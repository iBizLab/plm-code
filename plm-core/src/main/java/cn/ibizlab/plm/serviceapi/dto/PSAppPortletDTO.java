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
 * 应用门户部件[PSAppPortletDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("应用门户部件DTO")
public class PSAppPortletDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展模型
     */
    @JsonProperty("dynamodelflag")
    @JSONField(name = "dynamodelflag")
    @ApiModelProperty(value = "扩展模型", position = 0)
    private Integer dynaModelFlag;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 1)
    private String codeName;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 2)
    private String memo;

    /**
     * 应用门户部件标识
     */
    @JsonProperty("psappportletid")
    @JSONField(name = "psappportletid")
    @ApiModelProperty(value = "应用门户部件标识", position = 3)
    private String psAppPortletId;

    /**
     * 应用门户部件名称
     */
    @JsonProperty("psappportletname")
    @JSONField(name = "psappportletname")
    @ApiModelProperty(value = "应用门户部件名称", position = 4)
    private String psAppPortletName;

    /**
     * 实体图表
     */
    @JsonProperty("psdechartid")
    @JSONField(name = "psdechartid")
    @ApiModelProperty(value = "实体图表", position = 5)
    private String psdeChartId;

    /**
     * 实体图表
     */
    @JsonProperty("psdechartname")
    @JSONField(name = "psdechartname")
    @ApiModelProperty(value = "实体图表", position = 6)
    private String psdeChartName;

    /**
     * 实体数据视图
     */
    @JsonProperty("psdedataviewid")
    @JSONField(name = "psdedataviewid")
    @ApiModelProperty(value = "实体数据视图", position = 7)
    private String psdeDataViewId;

    /**
     * 实体数据视图
     */
    @JsonProperty("psdedataviewname")
    @JSONField(name = "psdedataviewname")
    @ApiModelProperty(value = "实体数据视图", position = 8)
    private String psdeDataViewName;

    /**
     * 实体表单
     */
    @JsonProperty("psdeformid")
    @JSONField(name = "psdeformid")
    @ApiModelProperty(value = "实体表单", position = 9)
    private String psdeFormId;

    /**
     * 实体表单
     */
    @JsonProperty("psdeformname")
    @JSONField(name = "psdeformname")
    @ApiModelProperty(value = "实体表单", position = 10)
    private String psdeFormName;

    /**
     * 实体
     */
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "实体", position = 11)
    private String psdeid;

    /**
     * 实体列表
     */
    @JsonProperty("psdelistid")
    @JSONField(name = "psdelistid")
    @ApiModelProperty(value = "实体列表", position = 12)
    private String psdeListId;

    /**
     * 实体列表
     */
    @JsonProperty("psdelistname")
    @JSONField(name = "psdelistname")
    @ApiModelProperty(value = "实体列表", position = 13)
    private String psdeListName;

    /**
     * 实体
     */
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "实体", position = 14)
    private String psdeName;

    /**
     * 实体报表
     */
    @JsonProperty("psdereportid")
    @JSONField(name = "psdereportid")
    @ApiModelProperty(value = "实体报表", position = 15)
    private String psdeReportId;

    /**
     * 实体报表
     */
    @JsonProperty("psdereportname")
    @JSONField(name = "psdereportname")
    @ApiModelProperty(value = "实体报表", position = 16)
    private String psdeReportName;

    /**
     * 工具栏
     */
    @JsonProperty("psdetoolbarid")
    @JSONField(name = "psdetoolbarid")
    @ApiModelProperty(value = "工具栏", position = 17)
    private String psdeToolbarId;

    /**
     * 工具栏
     */
    @JsonProperty("psdetoolbarname")
    @JSONField(name = "psdetoolbarname")
    @ApiModelProperty(value = "工具栏", position = 18)
    private String psdeToolbarName;

    /**
     * 界面行为组
     */
    @JsonProperty("psdeuagroupid")
    @JSONField(name = "psdeuagroupid")
    @ApiModelProperty(value = "界面行为组", position = 19)
    private String psdeuaGroupId;

    /**
     * 界面行为组
     */
    @JsonProperty("psdeuagroupname")
    @JSONField(name = "psdeuagroupname")
    @ApiModelProperty(value = "界面行为组", position = 20)
    private String psdeuaGroupName;

    /**
     * 系统视图
     */
    @JsonProperty("psdeviewid")
    @JSONField(name = "psdeviewid")
    @ApiModelProperty(value = "系统视图", position = 21)
    private String psdeViewId;

    /**
     * 系统视图
     */
    @JsonProperty("psdeviewname")
    @JSONField(name = "psdeviewname")
    @ApiModelProperty(value = "系统视图", position = 22)
    private String psdeViewName;

    /**
     * 系统应用
     */
    @JsonProperty("pssysappid")
    @JSONField(name = "pssysappid")
    @ApiModelProperty(value = "系统应用", position = 23)
    private String psSysAppId;

    /**
     * 系统应用
     */
    @JsonProperty("pssysappname")
    @JSONField(name = "pssysappname")
    @ApiModelProperty(value = "系统应用", position = 24)
    private String psSysAppName;

    /**
     * 日历部件
     */
    @JsonProperty("pssyscalendarid")
    @JSONField(name = "pssyscalendarid")
    @ApiModelProperty(value = "日历部件", position = 25)
    private String psSysCalendarId;

    /**
     * 日历部件
     */
    @JsonProperty("pssyscalendarname")
    @JSONField(name = "pssyscalendarname")
    @ApiModelProperty(value = "日历部件", position = 26)
    private String psSysCalendarName;

    /**
     * 地图部件
     */
    @JsonProperty("pssysmapviewid")
    @JSONField(name = "pssysmapviewid")
    @ApiModelProperty(value = "地图部件", position = 27)
    private String psSysMapViewId;

    /**
     * 地图部件
     */
    @JsonProperty("pssysmapviewname")
    @JSONField(name = "pssysmapviewname")
    @ApiModelProperty(value = "地图部件", position = 28)
    private String psSysMapViewName;

    /**
     * 部件分类
     */
    @JsonProperty("pssysportletcatid")
    @JSONField(name = "pssysportletcatid")
    @ApiModelProperty(value = "部件分类", position = 29)
    private String psSysPortletCatId;

    /**
     * 部件分类
     */
    @JsonProperty("pssysportletcatname")
    @JSONField(name = "pssysportletcatname")
    @ApiModelProperty(value = "部件分类", position = 30)
    private String psSysPortletCatName;

    /**
     * 看板部件类型
     */
    @JsonProperty("portlettype")
    @JSONField(name = "portlettype")
    @ApiModelProperty(value = "看板部件类型", position = 31)
    private String portletType;

    /**
     * 显示标题栏
     */
    @JsonProperty("showtitlebar")
    @JSONField(name = "showtitlebar")
    @ApiModelProperty(value = "显示标题栏", position = 32)
    private Integer showTitleBar;

    /**
     * 是否启用
     */
    @JsonProperty("validflag")
    @JSONField(name = "validflag")
    @ApiModelProperty(value = "是否启用", position = 33)
    private Integer validFlag;


    /**
     * 设置 [扩展模型]
     */
    public PSAppPortletDTO setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSAppPortletDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSAppPortletDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [应用门户部件名称]
     */
    public PSAppPortletDTO setPsAppPortletName(String psAppPortletName) {
        this.psAppPortletName = psAppPortletName;
        this.modify("psappportletname", psAppPortletName);
        return this;
    }

    /**
     * 设置 [实体图表]
     */
    public PSAppPortletDTO setPsdeChartId(String psdeChartId) {
        this.psdeChartId = psdeChartId;
        this.modify("psdechartid", psdeChartId);
        return this;
    }

    /**
     * 设置 [实体图表]
     */
    public PSAppPortletDTO setPsdeChartName(String psdeChartName) {
        this.psdeChartName = psdeChartName;
        this.modify("psdechartname", psdeChartName);
        return this;
    }

    /**
     * 设置 [实体数据视图]
     */
    public PSAppPortletDTO setPsdeDataViewId(String psdeDataViewId) {
        this.psdeDataViewId = psdeDataViewId;
        this.modify("psdedataviewid", psdeDataViewId);
        return this;
    }

    /**
     * 设置 [实体数据视图]
     */
    public PSAppPortletDTO setPsdeDataViewName(String psdeDataViewName) {
        this.psdeDataViewName = psdeDataViewName;
        this.modify("psdedataviewname", psdeDataViewName);
        return this;
    }

    /**
     * 设置 [实体表单]
     */
    public PSAppPortletDTO setPsdeFormId(String psdeFormId) {
        this.psdeFormId = psdeFormId;
        this.modify("psdeformid", psdeFormId);
        return this;
    }

    /**
     * 设置 [实体表单]
     */
    public PSAppPortletDTO setPsdeFormName(String psdeFormName) {
        this.psdeFormName = psdeFormName;
        this.modify("psdeformname", psdeFormName);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSAppPortletDTO setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
     * 设置 [实体列表]
     */
    public PSAppPortletDTO setPsdeListId(String psdeListId) {
        this.psdeListId = psdeListId;
        this.modify("psdelistid", psdeListId);
        return this;
    }

    /**
     * 设置 [实体列表]
     */
    public PSAppPortletDTO setPsdeListName(String psdeListName) {
        this.psdeListName = psdeListName;
        this.modify("psdelistname", psdeListName);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSAppPortletDTO setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
     * 设置 [实体报表]
     */
    public PSAppPortletDTO setPsdeReportId(String psdeReportId) {
        this.psdeReportId = psdeReportId;
        this.modify("psdereportid", psdeReportId);
        return this;
    }

    /**
     * 设置 [实体报表]
     */
    public PSAppPortletDTO setPsdeReportName(String psdeReportName) {
        this.psdeReportName = psdeReportName;
        this.modify("psdereportname", psdeReportName);
        return this;
    }

    /**
     * 设置 [工具栏]
     */
    public PSAppPortletDTO setPsdeToolbarId(String psdeToolbarId) {
        this.psdeToolbarId = psdeToolbarId;
        this.modify("psdetoolbarid", psdeToolbarId);
        return this;
    }

    /**
     * 设置 [工具栏]
     */
    public PSAppPortletDTO setPsdeToolbarName(String psdeToolbarName) {
        this.psdeToolbarName = psdeToolbarName;
        this.modify("psdetoolbarname", psdeToolbarName);
        return this;
    }

    /**
     * 设置 [界面行为组]
     */
    public PSAppPortletDTO setPsdeuaGroupId(String psdeuaGroupId) {
        this.psdeuaGroupId = psdeuaGroupId;
        this.modify("psdeuagroupid", psdeuaGroupId);
        return this;
    }

    /**
     * 设置 [界面行为组]
     */
    public PSAppPortletDTO setPsdeuaGroupName(String psdeuaGroupName) {
        this.psdeuaGroupName = psdeuaGroupName;
        this.modify("psdeuagroupname", psdeuaGroupName);
        return this;
    }

    /**
     * 设置 [系统视图]
     */
    public PSAppPortletDTO setPsdeViewId(String psdeViewId) {
        this.psdeViewId = psdeViewId;
        this.modify("psdeviewid", psdeViewId);
        return this;
    }

    /**
     * 设置 [系统视图]
     */
    public PSAppPortletDTO setPsdeViewName(String psdeViewName) {
        this.psdeViewName = psdeViewName;
        this.modify("psdeviewname", psdeViewName);
        return this;
    }

    /**
     * 设置 [系统应用]
     */
    public PSAppPortletDTO setPsSysAppId(String psSysAppId) {
        this.psSysAppId = psSysAppId;
        this.modify("pssysappid", psSysAppId);
        return this;
    }

    /**
     * 设置 [系统应用]
     */
    public PSAppPortletDTO setPsSysAppName(String psSysAppName) {
        this.psSysAppName = psSysAppName;
        this.modify("pssysappname", psSysAppName);
        return this;
    }

    /**
     * 设置 [日历部件]
     */
    public PSAppPortletDTO setPsSysCalendarId(String psSysCalendarId) {
        this.psSysCalendarId = psSysCalendarId;
        this.modify("pssyscalendarid", psSysCalendarId);
        return this;
    }

    /**
     * 设置 [日历部件]
     */
    public PSAppPortletDTO setPsSysCalendarName(String psSysCalendarName) {
        this.psSysCalendarName = psSysCalendarName;
        this.modify("pssyscalendarname", psSysCalendarName);
        return this;
    }

    /**
     * 设置 [地图部件]
     */
    public PSAppPortletDTO setPsSysMapViewId(String psSysMapViewId) {
        this.psSysMapViewId = psSysMapViewId;
        this.modify("pssysmapviewid", psSysMapViewId);
        return this;
    }

    /**
     * 设置 [地图部件]
     */
    public PSAppPortletDTO setPsSysMapViewName(String psSysMapViewName) {
        this.psSysMapViewName = psSysMapViewName;
        this.modify("pssysmapviewname", psSysMapViewName);
        return this;
    }

    /**
     * 设置 [部件分类]
     */
    public PSAppPortletDTO setPsSysPortletCatId(String psSysPortletCatId) {
        this.psSysPortletCatId = psSysPortletCatId;
        this.modify("pssysportletcatid", psSysPortletCatId);
        return this;
    }

    /**
     * 设置 [部件分类]
     */
    public PSAppPortletDTO setPsSysPortletCatName(String psSysPortletCatName) {
        this.psSysPortletCatName = psSysPortletCatName;
        this.modify("pssysportletcatname", psSysPortletCatName);
        return this;
    }

    /**
     * 设置 [看板部件类型]
     */
    public PSAppPortletDTO setPortletType(String portletType) {
        this.portletType = portletType;
        this.modify("portlettype", portletType);
        return this;
    }

    /**
     * 设置 [显示标题栏]
     */
    public PSAppPortletDTO setShowTitleBar(Integer showTitleBar) {
        this.showTitleBar = showTitleBar;
        this.modify("showtitlebar", showTitleBar);
        return this;
    }

    /**
     * 设置 [是否启用]
     */
    public PSAppPortletDTO setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }


}
