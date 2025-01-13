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
 * 核心产品[PSCorePrdDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("核心产品DTO")
public class PSCorePrdDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部署应用名
     */
    @JsonProperty("deploy_system_code")
    @JSONField(name = "deploy_system_code")
    @ApiModelProperty(value = "部署应用名", position = 0)
    private String deploySystemCode;

    /**
     * 设置
     */
    @JsonProperty("settings")
    @JSONField(name = "settings")
    @ApiModelProperty(value = "设置", position = 1)
    private String settings;

    /**
     * 部署节点
     */
    @JsonProperty("deploy_service_hub_id")
    @JSONField(name = "deploy_service_hub_id")
    @ApiModelProperty(value = "部署节点", position = 2)
    private String deployServiceHubId;

    /**
     * 可用版本
     */
    @JsonProperty("vers")
    @JSONField(name = "vers")
    @ApiModelProperty(value = "可用版本", position = 3)
    private String vers;

    /**
     * 部署数据源
     */
    @JsonProperty("deploy_data_source_id")
    @JSONField(name = "deploy_data_source_id")
    @ApiModelProperty(value = "部署数据源", position = 4)
    private String deployDataSourceId;

    /**
     * 部署版本
     */
    @JsonProperty("deploy_prdver_id")
    @JSONField(name = "deploy_prdver_id")
    @ApiModelProperty(value = "部署版本", position = 5)
    private String deployPrdverId;

    /**
     * 详细信息
     */
    @JsonProperty("info")
    @JSONField(name = "info")
    @ApiModelProperty(value = "详细信息", position = 6)
    private String info;

    /**
     * 产品标签
     */
    @JsonProperty("category")
    @JSONField(name = "category")
    @ApiModelProperty(value = "产品标签", position = 7)
    private String category;

    /**
     * 变更日志
     */
    @JsonProperty("changelog")
    @JSONField(name = "changelog")
    @ApiModelProperty(value = "变更日志", position = 8)
    private String changelog;

    /**
     * 图标路径
     */
    @JsonProperty("avatarurl")
    @JSONField(name = "avatarurl")
    @ApiModelProperty(value = "图标路径", position = 9)
    private String avatarUrl;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 10)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 11)
    private String createMan;

    /**
     * 当前版本
     */
    @JsonProperty("currentversion")
    @JSONField(name = "currentversion")
    @ApiModelProperty(value = "当前版本", position = 12)
    private String currentVersion;

    /**
     * 完全名称
     */
    @JsonProperty("fullname")
    @JSONField(name = "fullname")
    @ApiModelProperty(value = "完全名称", position = 13)
    private String fullName;

    /**
     * 完全路径
     */
    @JsonProperty("fullpath")
    @JSONField(name = "fullpath")
    @ApiModelProperty(value = "完全路径", position = 14)
    private String fullPath;

    /**
     * Http仓库地址
     */
    @JsonProperty("httpurltorepo")
    @JSONField(name = "httpurltorepo")
    @ApiModelProperty(value = "Http仓库地址", position = 15)
    private String httpUrlToRepo;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 16)
    private String memo;

    /**
     * 产品分类
     */
    @JsonProperty("pscoreprdcatid")
    @JSONField(name = "pscoreprdcatid")
    @ApiModelProperty(value = "产品分类", position = 17)
    private String psCorePrdCatId;

    /**
     * 产品分类
     */
    @JsonProperty("pscoreprdcatname")
    @JSONField(name = "pscoreprdcatname")
    @ApiModelProperty(value = "产品分类", position = 18)
    private String psCorePrdCatName;

    /**
     * 产品分类路径
     */
    @JsonProperty("pscoreprdcatpath")
    @JSONField(name = "pscoreprdcatpath")
    @ApiModelProperty(value = "产品分类路径", position = 19)
    private String psCorePrdCatPath;

    /**
     * 核心产品标识
     */
    @JsonProperty("pscoreprdid")
    @JSONField(name = "pscoreprdid")
    @ApiModelProperty(value = "核心产品标识", position = 20)
    private String psCorePrdId;

    /**
     * 产品名称
     */
    @JsonProperty("pscoreprdname")
    @JSONField(name = "pscoreprdname")
    @ApiModelProperty(value = "产品名称", position = 21)
    private String psCorePrdName;

    /**
     * 路径
     */
    @JsonProperty("path")
    @JSONField(name = "path")
    @ApiModelProperty(value = "路径", position = 22)
    private String path;

    /**
     * 安装包路径
     */
    @JsonProperty("pkgfolder")
    @JSONField(name = "pkgfolder")
    @ApiModelProperty(value = "安装包路径", position = 23)
    private String pkgFolder;

    /**
     * 产品编号
     */
    @JsonProperty("prdsn")
    @JSONField(name = "prdsn")
    @ApiModelProperty(value = "产品编号", position = 24)
    private String prdSn;

    /**
     * 产品标记
     */
    @JsonProperty("prdtag")
    @JSONField(name = "prdtag")
    @ApiModelProperty(value = "产品标记", position = 25)
    private String prdTag;

    /**
     * 产品标记2
     */
    @JsonProperty("prdtag2")
    @JSONField(name = "prdtag2")
    @ApiModelProperty(value = "产品标记2", position = 26)
    private String prdTag2;

    /**
     * 设置地址
     */
    @JsonProperty("settingurl")
    @JSONField(name = "settingurl")
    @ApiModelProperty(value = "设置地址", position = 27)
    private String settingUrl;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 28)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 29)
    private String updateMan;


    /**
     * 设置 [部署应用名]
     */
    public PSCorePrdDTO setDeploySystemCode(String deploySystemCode) {
        this.deploySystemCode = deploySystemCode;
        this.modify("deploy_system_code", deploySystemCode);
        return this;
    }

    /**
     * 设置 [设置]
     */
    public PSCorePrdDTO setSettings(String settings) {
        this.settings = settings;
        this.modify("settings", settings);
        return this;
    }

    /**
     * 设置 [部署节点]
     */
    public PSCorePrdDTO setDeployServiceHubId(String deployServiceHubId) {
        this.deployServiceHubId = deployServiceHubId;
        this.modify("deploy_service_hub_id", deployServiceHubId);
        return this;
    }

    /**
     * 设置 [可用版本]
     */
    public PSCorePrdDTO setVers(String vers) {
        this.vers = vers;
        this.modify("vers", vers);
        return this;
    }

    /**
     * 设置 [部署数据源]
     */
    public PSCorePrdDTO setDeployDataSourceId(String deployDataSourceId) {
        this.deployDataSourceId = deployDataSourceId;
        this.modify("deploy_data_source_id", deployDataSourceId);
        return this;
    }

    /**
     * 设置 [部署版本]
     */
    public PSCorePrdDTO setDeployPrdverId(String deployPrdverId) {
        this.deployPrdverId = deployPrdverId;
        this.modify("deploy_prdver_id", deployPrdverId);
        return this;
    }

    /**
     * 设置 [详细信息]
     */
    public PSCorePrdDTO setInfo(String info) {
        this.info = info;
        this.modify("info", info);
        return this;
    }

    /**
     * 设置 [产品标签]
     */
    public PSCorePrdDTO setCategory(String category) {
        this.category = category;
        this.modify("category", category);
        return this;
    }

    /**
     * 设置 [变更日志]
     */
    public PSCorePrdDTO setChangelog(String changelog) {
        this.changelog = changelog;
        this.modify("changelog", changelog);
        return this;
    }

    /**
     * 设置 [图标路径]
     */
    public PSCorePrdDTO setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.modify("avatarurl", avatarUrl);
        return this;
    }

    /**
     * 设置 [当前版本]
     */
    public PSCorePrdDTO setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
        this.modify("currentversion", currentVersion);
        return this;
    }

    /**
     * 设置 [完全名称]
     */
    public PSCorePrdDTO setFullName(String fullName) {
        this.fullName = fullName;
        this.modify("fullname", fullName);
        return this;
    }

    /**
     * 设置 [完全路径]
     */
    public PSCorePrdDTO setFullPath(String fullPath) {
        this.fullPath = fullPath;
        this.modify("fullpath", fullPath);
        return this;
    }

    /**
     * 设置 [Http仓库地址]
     */
    public PSCorePrdDTO setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
        this.modify("httpurltorepo", httpUrlToRepo);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSCorePrdDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [产品分类]
     */
    public PSCorePrdDTO setPsCorePrdCatId(String psCorePrdCatId) {
        this.psCorePrdCatId = psCorePrdCatId;
        this.modify("pscoreprdcatid", psCorePrdCatId);
        return this;
    }

    /**
     * 设置 [产品分类]
     */
    public PSCorePrdDTO setPsCorePrdCatName(String psCorePrdCatName) {
        this.psCorePrdCatName = psCorePrdCatName;
        this.modify("pscoreprdcatname", psCorePrdCatName);
        return this;
    }

    /**
     * 设置 [产品分类路径]
     */
    public PSCorePrdDTO setPsCorePrdCatPath(String psCorePrdCatPath) {
        this.psCorePrdCatPath = psCorePrdCatPath;
        this.modify("pscoreprdcatpath", psCorePrdCatPath);
        return this;
    }

    /**
     * 设置 [产品名称]
     */
    public PSCorePrdDTO setPsCorePrdName(String psCorePrdName) {
        this.psCorePrdName = psCorePrdName;
        this.modify("pscoreprdname", psCorePrdName);
        return this;
    }

    /**
     * 设置 [路径]
     */
    public PSCorePrdDTO setPath(String path) {
        this.path = path;
        this.modify("path", path);
        return this;
    }

    /**
     * 设置 [安装包路径]
     */
    public PSCorePrdDTO setPkgFolder(String pkgFolder) {
        this.pkgFolder = pkgFolder;
        this.modify("pkgfolder", pkgFolder);
        return this;
    }

    /**
     * 设置 [产品编号]
     */
    public PSCorePrdDTO setPrdSn(String prdSn) {
        this.prdSn = prdSn;
        this.modify("prdsn", prdSn);
        return this;
    }

    /**
     * 设置 [产品标记]
     */
    public PSCorePrdDTO setPrdTag(String prdTag) {
        this.prdTag = prdTag;
        this.modify("prdtag", prdTag);
        return this;
    }

    /**
     * 设置 [产品标记2]
     */
    public PSCorePrdDTO setPrdTag2(String prdTag2) {
        this.prdTag2 = prdTag2;
        this.modify("prdtag2", prdTag2);
        return this;
    }

    /**
     * 设置 [设置地址]
     */
    public PSCorePrdDTO setSettingUrl(String settingUrl) {
        this.settingUrl = settingUrl;
        this.modify("settingurl", settingUrl);
        return this;
    }


}
