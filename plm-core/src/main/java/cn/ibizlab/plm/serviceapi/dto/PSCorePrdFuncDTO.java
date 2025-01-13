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
 * 核心产品功能[PSCorePrdFuncDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("核心产品功能DTO")
public class PSCorePrdFuncDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 功能类型
     */
    @JsonProperty("functype")
    @JSONField(name = "functype")
    @ApiModelProperty(value = "功能类型", position = 0)
    private String funcType;

    /**
     * 设置
     */
    @JsonProperty("settings")
    @JSONField(name = "settings")
    @ApiModelProperty(value = "设置", position = 1)
    private String settings;

    /**
     * 可用版本
     */
    @JsonProperty("vers")
    @JSONField(name = "vers")
    @ApiModelProperty(value = "可用版本", position = 2)
    private String vers;

    /**
     * 详细信息
     */
    @JsonProperty("info")
    @JSONField(name = "info")
    @ApiModelProperty(value = "详细信息", position = 3)
    private String info;

    /**
     * 产品分类
     */
    @JsonProperty("category")
    @JSONField(name = "category")
    @ApiModelProperty(value = "产品分类", position = 4)
    private String category;

    /**
     * 变更日志
     */
    @JsonProperty("changelog")
    @JSONField(name = "changelog")
    @ApiModelProperty(value = "变更日志", position = 5)
    private String changelog;

    /**
     * 图标路径
     */
    @JsonProperty("avatarurl")
    @JSONField(name = "avatarurl")
    @ApiModelProperty(value = "图标路径", position = 6)
    private String avatarUrl;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 7)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 8)
    private String createMan;

    /**
     * 当前版本
     */
    @JsonProperty("currentversion")
    @JSONField(name = "currentversion")
    @ApiModelProperty(value = "当前版本", position = 9)
    private String currentVersion;

    /**
     * 完全名称
     */
    @JsonProperty("fullname")
    @JSONField(name = "fullname")
    @ApiModelProperty(value = "完全名称", position = 10)
    private String fullName;

    /**
     * 完全路径
     */
    @JsonProperty("fullpath")
    @JSONField(name = "fullpath")
    @ApiModelProperty(value = "完全路径", position = 11)
    private String fullPath;

    /**
     * 功能编号
     */
    @JsonProperty("funcsn")
    @JSONField(name = "funcsn")
    @ApiModelProperty(value = "功能编号", position = 12)
    private String funcSn;

    /**
     * 功能状态
     */
    @JsonProperty("funcstate")
    @JSONField(name = "funcstate")
    @ApiModelProperty(value = "功能状态", position = 13)
    private String funcState;

    /**
     * 功能标记
     */
    @JsonProperty("functag")
    @JSONField(name = "functag")
    @ApiModelProperty(value = "功能标记", position = 14)
    private String funcTag;

    /**
     * 功能标记2
     */
    @JsonProperty("functag2")
    @JSONField(name = "functag2")
    @ApiModelProperty(value = "功能标记2", position = 15)
    private String funcTag2;

    /**
     * 功能描述链接
     */
    @JsonProperty("funcurl")
    @JSONField(name = "funcurl")
    @ApiModelProperty(value = "功能描述链接", position = 16)
    private String funcUrl;

    /**
     * Http仓库地址
     */
    @JsonProperty("httpurltorepo")
    @JSONField(name = "httpurltorepo")
    @ApiModelProperty(value = "Http仓库地址", position = 17)
    private String httpUrlToRepo;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 18)
    private String memo;

    /**
     * 排序值
     */
    @JsonProperty("ordervalue")
    @JSONField(name = "ordervalue")
    @ApiModelProperty(value = "排序值", position = 19)
    private Integer orderValue;

    /**
     * 核心产品功能标识
     */
    @JsonProperty("pscoreprdfuncid")
    @JSONField(name = "pscoreprdfuncid")
    @ApiModelProperty(value = "核心产品功能标识", position = 20)
    private String psCorePrdFuncId;

    /**
     * 应用名称
     */
    @JsonProperty("pscoreprdfuncname")
    @JSONField(name = "pscoreprdfuncname")
    @ApiModelProperty(value = "应用名称", position = 21)
    private String psCorePrdFuncName;

    /**
     * 核心产品
     */
    @JsonProperty("pscoreprdid")
    @JSONField(name = "pscoreprdid")
    @ApiModelProperty(value = "核心产品", position = 22)
    private String psCorePrdId;

    /**
     * 核心产品
     */
    @JsonProperty("pscoreprdname")
    @JSONField(name = "pscoreprdname")
    @ApiModelProperty(value = "核心产品", position = 23)
    private String psCorePrdName;

    /**
     * 路径
     */
    @JsonProperty("path")
    @JSONField(name = "path")
    @ApiModelProperty(value = "路径", position = 24)
    private String path;

    /**
     * 设置地址
     */
    @JsonProperty("settingurl")
    @JSONField(name = "settingurl")
    @ApiModelProperty(value = "设置地址", position = 25)
    private String settingUrl;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 26)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 27)
    private String updateMan;


    /**
     * 设置 [功能类型]
     */
    public PSCorePrdFuncDTO setFuncType(String funcType) {
        this.funcType = funcType;
        this.modify("functype", funcType);
        return this;
    }

    /**
     * 设置 [设置]
     */
    public PSCorePrdFuncDTO setSettings(String settings) {
        this.settings = settings;
        this.modify("settings", settings);
        return this;
    }

    /**
     * 设置 [可用版本]
     */
    public PSCorePrdFuncDTO setVers(String vers) {
        this.vers = vers;
        this.modify("vers", vers);
        return this;
    }

    /**
     * 设置 [详细信息]
     */
    public PSCorePrdFuncDTO setInfo(String info) {
        this.info = info;
        this.modify("info", info);
        return this;
    }

    /**
     * 设置 [产品分类]
     */
    public PSCorePrdFuncDTO setCategory(String category) {
        this.category = category;
        this.modify("category", category);
        return this;
    }

    /**
     * 设置 [变更日志]
     */
    public PSCorePrdFuncDTO setChangelog(String changelog) {
        this.changelog = changelog;
        this.modify("changelog", changelog);
        return this;
    }

    /**
     * 设置 [图标路径]
     */
    public PSCorePrdFuncDTO setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.modify("avatarurl", avatarUrl);
        return this;
    }

    /**
     * 设置 [当前版本]
     */
    public PSCorePrdFuncDTO setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
        this.modify("currentversion", currentVersion);
        return this;
    }

    /**
     * 设置 [完全名称]
     */
    public PSCorePrdFuncDTO setFullName(String fullName) {
        this.fullName = fullName;
        this.modify("fullname", fullName);
        return this;
    }

    /**
     * 设置 [完全路径]
     */
    public PSCorePrdFuncDTO setFullPath(String fullPath) {
        this.fullPath = fullPath;
        this.modify("fullpath", fullPath);
        return this;
    }

    /**
     * 设置 [功能编号]
     */
    public PSCorePrdFuncDTO setFuncSn(String funcSn) {
        this.funcSn = funcSn;
        this.modify("funcsn", funcSn);
        return this;
    }

    /**
     * 设置 [功能状态]
     */
    public PSCorePrdFuncDTO setFuncState(String funcState) {
        this.funcState = funcState;
        this.modify("funcstate", funcState);
        return this;
    }

    /**
     * 设置 [功能标记]
     */
    public PSCorePrdFuncDTO setFuncTag(String funcTag) {
        this.funcTag = funcTag;
        this.modify("functag", funcTag);
        return this;
    }

    /**
     * 设置 [功能标记2]
     */
    public PSCorePrdFuncDTO setFuncTag2(String funcTag2) {
        this.funcTag2 = funcTag2;
        this.modify("functag2", funcTag2);
        return this;
    }

    /**
     * 设置 [功能描述链接]
     */
    public PSCorePrdFuncDTO setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
        this.modify("funcurl", funcUrl);
        return this;
    }

    /**
     * 设置 [Http仓库地址]
     */
    public PSCorePrdFuncDTO setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
        this.modify("httpurltorepo", httpUrlToRepo);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSCorePrdFuncDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [应用名称]
     */
    public PSCorePrdFuncDTO setPsCorePrdFuncName(String psCorePrdFuncName) {
        this.psCorePrdFuncName = psCorePrdFuncName;
        this.modify("pscoreprdfuncname", psCorePrdFuncName);
        return this;
    }

    /**
     * 设置 [核心产品]
     */
    public PSCorePrdFuncDTO setPsCorePrdId(String psCorePrdId) {
        this.psCorePrdId = psCorePrdId;
        this.modify("pscoreprdid", psCorePrdId);
        return this;
    }

    /**
     * 设置 [核心产品]
     */
    public PSCorePrdFuncDTO setPsCorePrdName(String psCorePrdName) {
        this.psCorePrdName = psCorePrdName;
        this.modify("pscoreprdname", psCorePrdName);
        return this;
    }

    /**
     * 设置 [路径]
     */
    public PSCorePrdFuncDTO setPath(String path) {
        this.path = path;
        this.modify("path", path);
        return this;
    }

    /**
     * 设置 [设置地址]
     */
    public PSCorePrdFuncDTO setSettingUrl(String settingUrl) {
        this.settingUrl = settingUrl;
        this.modify("settingurl", settingUrl);
        return this;
    }


}
