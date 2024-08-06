/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.extension.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;

/**
 * 应用门户部件实体类[PSAppPortlet]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSAPPPORTLET", description = "应用门户部件")
public class PSAppPortlet extends EntityBase implements Serializable
{
    /**
     * 扩展模型
     */
    @DEField(name = "dynamodelflag" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "dynamodelflag")
    @JsonProperty("dynamodelflag")
    @ApiModelProperty(value = "dynamodelflag", notes = "扩展模型")
    private Integer dynaModelFlag;

    /**
     * 应用门户部件标识
     */
    @Id
    @DEField(name = "psappportletid" , isKeyField = true)
    @JSONField(name = "psappportletid")
    @JsonProperty("psappportletid")
    @ApiModelProperty(value = "psappportletid", notes = "应用门户部件标识")
    private String psAppPortletId;

    /**
     * 应用门户部件名称
     */
    @DEField(name = "psappportletname")
    @JSONField(name = "psappportletname")
    @JsonProperty("psappportletname")
    @ApiModelProperty(value = "psappportletname", notes = "应用门户部件名称")
    private String psAppPortletName;

    /**
     * 代码名称
     */
    @DEField(name = "codename")
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 是否启用
     */
    @DEField(name = "validflag" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    @ApiModelProperty(value = "validflag", notes = "是否启用")
    private Integer validFlag;

    /**
     * 看板部件类型
     */
    @DEField(name = "portlettype" , dict = "PortletType")
    @JSONField(name = "portlettype")
    @JsonProperty("portlettype")
    @ApiModelProperty(value = "portlettype", notes = "看板部件类型")
    private String portletType;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JSONField(name = "psdename")
    @JsonProperty("psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 实体报表
     */
    @DEField(name = "psdereportid")
    @JSONField(name = "psdereportid")
    @JsonProperty("psdereportid")
    @ApiModelProperty(value = "psdereportid", notes = "实体报表")
    private String psdeReportId;

    /**
     * 实体报表
     */
    @DEField(name = "psdereportname")
    @JSONField(name = "psdereportname")
    @JsonProperty("psdereportname")
    @ApiModelProperty(value = "psdereportname", notes = "实体报表")
    private String psdeReportName;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JSONField(name = "psdeid")
    @JsonProperty("psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 实体列表
     */
    @DEField(name = "psdelistid")
    @JSONField(name = "psdelistid")
    @JsonProperty("psdelistid")
    @ApiModelProperty(value = "psdelistid", notes = "实体列表")
    private String psdeListId;

    /**
     * 实体列表
     */
    @DEField(name = "psdelistname")
    @JSONField(name = "psdelistname")
    @JsonProperty("psdelistname")
    @ApiModelProperty(value = "psdelistname", notes = "实体列表")
    private String psdeListName;

    /**
     * 工具栏
     */
    @DEField(name = "psdetoolbarname")
    @JSONField(name = "psdetoolbarname")
    @JsonProperty("psdetoolbarname")
    @ApiModelProperty(value = "psdetoolbarname", notes = "工具栏")
    private String psdeToolbarName;

    /**
     * 界面行为组
     */
    @DEField(name = "psdeuagroupid")
    @JSONField(name = "psdeuagroupid")
    @JsonProperty("psdeuagroupid")
    @ApiModelProperty(value = "psdeuagroupid", notes = "界面行为组")
    private String psdeuaGroupId;

    /**
     * 工具栏
     */
    @DEField(name = "psdetoolbarid")
    @JSONField(name = "psdetoolbarid")
    @JsonProperty("psdetoolbarid")
    @ApiModelProperty(value = "psdetoolbarid", notes = "工具栏")
    private String psdeToolbarId;

    /**
     * 界面行为组
     */
    @DEField(name = "psdeuagroupname")
    @JSONField(name = "psdeuagroupname")
    @JsonProperty("psdeuagroupname")
    @ApiModelProperty(value = "psdeuagroupname", notes = "界面行为组")
    private String psdeuaGroupName;

    /**
     * 日历部件
     */
    @DEField(name = "pssyscalendarname")
    @JSONField(name = "pssyscalendarname")
    @JsonProperty("pssyscalendarname")
    @ApiModelProperty(value = "pssyscalendarname", notes = "日历部件")
    private String psSysCalendarName;

    /**
     * 日历部件
     */
    @DEField(name = "pssyscalendarid")
    @JSONField(name = "pssyscalendarid")
    @JsonProperty("pssyscalendarid")
    @ApiModelProperty(value = "pssyscalendarid", notes = "日历部件")
    private String psSysCalendarId;

    /**
     * 显示标题栏
     */
    @DEField(name = "showtitlebar" , dict = "YesNo")
    @JSONField(name = "showtitlebar")
    @JsonProperty("showtitlebar")
    @ApiModelProperty(value = "showtitlebar", notes = "显示标题栏")
    private Integer showTitleBar;

    /**
     * 地图部件
     */
    @DEField(name = "pssysmapviewid")
    @JSONField(name = "pssysmapviewid")
    @JsonProperty("pssysmapviewid")
    @ApiModelProperty(value = "pssysmapviewid", notes = "地图部件")
    private String psSysMapViewId;

    /**
     * 地图部件
     */
    @DEField(name = "pssysmapviewname")
    @JSONField(name = "pssysmapviewname")
    @JsonProperty("pssysmapviewname")
    @ApiModelProperty(value = "pssysmapviewname", notes = "地图部件")
    private String psSysMapViewName;

    /**
     * 实体图表
     */
    @DEField(name = "psdechartid")
    @JSONField(name = "psdechartid")
    @JsonProperty("psdechartid")
    @ApiModelProperty(value = "psdechartid", notes = "实体图表")
    private String psdeChartId;

    /**
     * 实体数据视图
     */
    @DEField(name = "psdedataviewid")
    @JSONField(name = "psdedataviewid")
    @JsonProperty("psdedataviewid")
    @ApiModelProperty(value = "psdedataviewid", notes = "实体数据视图")
    private String psdeDataViewId;

    /**
     * 实体图表
     */
    @DEField(name = "psdechartname")
    @JSONField(name = "psdechartname")
    @JsonProperty("psdechartname")
    @ApiModelProperty(value = "psdechartname", notes = "实体图表")
    private String psdeChartName;

    /**
     * 实体数据视图
     */
    @DEField(name = "psdedataviewname")
    @JSONField(name = "psdedataviewname")
    @JsonProperty("psdedataviewname")
    @ApiModelProperty(value = "psdedataviewname", notes = "实体数据视图")
    private String psdeDataViewName;

    /**
     * 实体表单
     */
    @DEField(name = "psdeformid")
    @JSONField(name = "psdeformid")
    @JsonProperty("psdeformid")
    @ApiModelProperty(value = "psdeformid", notes = "实体表单")
    private String psdeFormId;

    /**
     * 系统视图
     */
    @DEField(name = "psdeviewid")
    @JSONField(name = "psdeviewid")
    @JsonProperty("psdeviewid")
    @ApiModelProperty(value = "psdeviewid", notes = "系统视图")
    private String psdeViewId;

    /**
     * 实体表单
     */
    @DEField(name = "psdeformname")
    @JSONField(name = "psdeformname")
    @JsonProperty("psdeformname")
    @ApiModelProperty(value = "psdeformname", notes = "实体表单")
    private String psdeFormName;

    /**
     * 系统视图
     */
    @DEField(name = "psdeviewname")
    @JSONField(name = "psdeviewname")
    @JsonProperty("psdeviewname")
    @ApiModelProperty(value = "psdeviewname", notes = "系统视图")
    private String psdeViewName;

    /**
     * 部件分类
     */
    @DEField(name = "pssysportletcatname")
    @JSONField(name = "pssysportletcatname")
    @JsonProperty("pssysportletcatname")
    @ApiModelProperty(value = "pssysportletcatname", notes = "部件分类")
    private String psSysPortletCatName;

    /**
     * 部件分类
     */
    @DEField(name = "pssysportletcatid")
    @JSONField(name = "pssysportletcatid")
    @JsonProperty("pssysportletcatid")
    @ApiModelProperty(value = "pssysportletcatid", notes = "部件分类")
    private String psSysPortletCatId;

    /**
     * 系统应用
     */
    @DEField(name = "pssysappname")
    @JSONField(name = "pssysappname")
    @JsonProperty("pssysappname")
    @ApiModelProperty(value = "pssysappname", notes = "系统应用")
    private String psSysAppName;

    /**
     * 系统应用
     */
    @DEField(name = "pssysappid")
    @JSONField(name = "pssysappid")
    @JsonProperty("pssysappid")
    @ApiModelProperty(value = "pssysappid", notes = "系统应用")
    private String psSysAppId;

    /**
    * 设置 [扩展模型]
    */
    public PSAppPortlet setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
    * 设置 [应用门户部件名称]
    */
    public PSAppPortlet setPsAppPortletName(String psAppPortletName) {
        this.psAppPortletName = psAppPortletName;
        this.modify("psappportletname", psAppPortletName);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSAppPortlet setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSAppPortlet setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [是否启用]
    */
    public PSAppPortlet setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
        this.modify("validflag", validFlag);
        return this;
    }

    /**
    * 设置 [看板部件类型]
    */
    public PSAppPortlet setPortletType(String portletType) {
        this.portletType = portletType;
        this.modify("portlettype", portletType);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSAppPortlet setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
    * 设置 [实体报表]
    */
    public PSAppPortlet setPsdeReportId(String psdeReportId) {
        this.psdeReportId = psdeReportId;
        this.modify("psdereportid", psdeReportId);
        return this;
    }

    /**
    * 设置 [实体报表]
    */
    public PSAppPortlet setPsdeReportName(String psdeReportName) {
        this.psdeReportName = psdeReportName;
        this.modify("psdereportname", psdeReportName);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSAppPortlet setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
    * 设置 [实体列表]
    */
    public PSAppPortlet setPsdeListId(String psdeListId) {
        this.psdeListId = psdeListId;
        this.modify("psdelistid", psdeListId);
        return this;
    }

    /**
    * 设置 [实体列表]
    */
    public PSAppPortlet setPsdeListName(String psdeListName) {
        this.psdeListName = psdeListName;
        this.modify("psdelistname", psdeListName);
        return this;
    }

    /**
    * 设置 [工具栏]
    */
    public PSAppPortlet setPsdeToolbarName(String psdeToolbarName) {
        this.psdeToolbarName = psdeToolbarName;
        this.modify("psdetoolbarname", psdeToolbarName);
        return this;
    }

    /**
    * 设置 [界面行为组]
    */
    public PSAppPortlet setPsdeuaGroupId(String psdeuaGroupId) {
        this.psdeuaGroupId = psdeuaGroupId;
        this.modify("psdeuagroupid", psdeuaGroupId);
        return this;
    }

    /**
    * 设置 [工具栏]
    */
    public PSAppPortlet setPsdeToolbarId(String psdeToolbarId) {
        this.psdeToolbarId = psdeToolbarId;
        this.modify("psdetoolbarid", psdeToolbarId);
        return this;
    }

    /**
    * 设置 [界面行为组]
    */
    public PSAppPortlet setPsdeuaGroupName(String psdeuaGroupName) {
        this.psdeuaGroupName = psdeuaGroupName;
        this.modify("psdeuagroupname", psdeuaGroupName);
        return this;
    }

    /**
    * 设置 [日历部件]
    */
    public PSAppPortlet setPsSysCalendarName(String psSysCalendarName) {
        this.psSysCalendarName = psSysCalendarName;
        this.modify("pssyscalendarname", psSysCalendarName);
        return this;
    }

    /**
    * 设置 [日历部件]
    */
    public PSAppPortlet setPsSysCalendarId(String psSysCalendarId) {
        this.psSysCalendarId = psSysCalendarId;
        this.modify("pssyscalendarid", psSysCalendarId);
        return this;
    }

    /**
    * 设置 [显示标题栏]
    */
    public PSAppPortlet setShowTitleBar(Integer showTitleBar) {
        this.showTitleBar = showTitleBar;
        this.modify("showtitlebar", showTitleBar);
        return this;
    }

    /**
    * 设置 [地图部件]
    */
    public PSAppPortlet setPsSysMapViewId(String psSysMapViewId) {
        this.psSysMapViewId = psSysMapViewId;
        this.modify("pssysmapviewid", psSysMapViewId);
        return this;
    }

    /**
    * 设置 [地图部件]
    */
    public PSAppPortlet setPsSysMapViewName(String psSysMapViewName) {
        this.psSysMapViewName = psSysMapViewName;
        this.modify("pssysmapviewname", psSysMapViewName);
        return this;
    }

    /**
    * 设置 [实体图表]
    */
    public PSAppPortlet setPsdeChartId(String psdeChartId) {
        this.psdeChartId = psdeChartId;
        this.modify("psdechartid", psdeChartId);
        return this;
    }

    /**
    * 设置 [实体数据视图]
    */
    public PSAppPortlet setPsdeDataViewId(String psdeDataViewId) {
        this.psdeDataViewId = psdeDataViewId;
        this.modify("psdedataviewid", psdeDataViewId);
        return this;
    }

    /**
    * 设置 [实体图表]
    */
    public PSAppPortlet setPsdeChartName(String psdeChartName) {
        this.psdeChartName = psdeChartName;
        this.modify("psdechartname", psdeChartName);
        return this;
    }

    /**
    * 设置 [实体数据视图]
    */
    public PSAppPortlet setPsdeDataViewName(String psdeDataViewName) {
        this.psdeDataViewName = psdeDataViewName;
        this.modify("psdedataviewname", psdeDataViewName);
        return this;
    }

    /**
    * 设置 [实体表单]
    */
    public PSAppPortlet setPsdeFormId(String psdeFormId) {
        this.psdeFormId = psdeFormId;
        this.modify("psdeformid", psdeFormId);
        return this;
    }

    /**
    * 设置 [系统视图]
    */
    public PSAppPortlet setPsdeViewId(String psdeViewId) {
        this.psdeViewId = psdeViewId;
        this.modify("psdeviewid", psdeViewId);
        return this;
    }

    /**
    * 设置 [实体表单]
    */
    public PSAppPortlet setPsdeFormName(String psdeFormName) {
        this.psdeFormName = psdeFormName;
        this.modify("psdeformname", psdeFormName);
        return this;
    }

    /**
    * 设置 [系统视图]
    */
    public PSAppPortlet setPsdeViewName(String psdeViewName) {
        this.psdeViewName = psdeViewName;
        this.modify("psdeviewname", psdeViewName);
        return this;
    }

    /**
    * 设置 [部件分类]
    */
    public PSAppPortlet setPsSysPortletCatName(String psSysPortletCatName) {
        this.psSysPortletCatName = psSysPortletCatName;
        this.modify("pssysportletcatname", psSysPortletCatName);
        return this;
    }

    /**
    * 设置 [部件分类]
    */
    public PSAppPortlet setPsSysPortletCatId(String psSysPortletCatId) {
        this.psSysPortletCatId = psSysPortletCatId;
        this.modify("pssysportletcatid", psSysPortletCatId);
        return this;
    }

    /**
    * 设置 [系统应用]
    */
    public PSAppPortlet setPsSysAppName(String psSysAppName) {
        this.psSysAppName = psSysAppName;
        this.modify("pssysappname", psSysAppName);
        return this;
    }

    /**
    * 设置 [系统应用]
    */
    public PSAppPortlet setPsSysAppId(String psSysAppId) {
        this.psSysAppId = psSysAppId;
        this.modify("pssysappid", psSysAppId);
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
            entity.reset("psappportletid");
        }
        return targetEntity;
    }

}