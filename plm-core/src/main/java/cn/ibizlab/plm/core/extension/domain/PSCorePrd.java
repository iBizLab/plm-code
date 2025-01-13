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
 * 核心产品实体类[PSCorePrd]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSCOREPRD", description = "核心产品")
public class PSCorePrd extends EntityBase implements Serializable
{
    /**
     * 部署应用名
     */
    @DEField(name = "deploy_system_code")
    @JSONField(name = "deploy_system_code")
    @JsonProperty("deploy_system_code")
    @ApiModelProperty(value = "deploy_system_code", notes = "部署应用名")
    private String deploySystemCode;

    /**
     * 设置
     */
    @DEField(name = "settings")
    @JSONField(name = "settings")
    @JsonProperty("settings")
    @ApiModelProperty(value = "settings", notes = "设置")
    private String settings;

    /**
     * 部署节点
     */
    @DEField(name = "deploy_service_hub_id")
    @JSONField(name = "deploy_service_hub_id")
    @JsonProperty("deploy_service_hub_id")
    @ApiModelProperty(value = "deploy_service_hub_id", notes = "部署节点")
    private String deployServiceHubId;

    /**
     * 可用版本
     */
    @DEField(name = "vers")
    @JSONField(name = "vers")
    @JsonProperty("vers")
    @ApiModelProperty(value = "vers", notes = "可用版本")
    private String vers;

    /**
     * 部署数据源
     */
    @DEField(name = "deploy_data_source_id")
    @JSONField(name = "deploy_data_source_id")
    @JsonProperty("deploy_data_source_id")
    @ApiModelProperty(value = "deploy_data_source_id", notes = "部署数据源")
    private String deployDataSourceId;

    /**
     * 部署版本
     */
    @DEField(name = "deploy_prdver_id")
    @JSONField(name = "deploy_prdver_id")
    @JsonProperty("deploy_prdver_id")
    @ApiModelProperty(value = "deploy_prdver_id", notes = "部署版本")
    private String deployPrdverId;

    /**
     * 详细信息
     */
    @DEField(name = "info")
    @JSONField(name = "info")
    @JsonProperty("info")
    @ApiModelProperty(value = "info", notes = "详细信息")
    private String info;

    /**
     * 产品标签
     */
    @DEField(name = "category")
    @JSONField(name = "category")
    @JsonProperty("category")
    @ApiModelProperty(value = "category", notes = "产品标签")
    private String category;

    /**
     * 变更日志
     */
    @DEField(name = "changelog")
    @JSONField(name = "changelog")
    @JsonProperty("changelog")
    @ApiModelProperty(value = "changelog", notes = "变更日志")
    private String changelog;

    /**
     * 核心产品标识
     */
    @Id
    @DEField(name = "pscoreprdid" , isKeyField = true)
    @JSONField(name = "pscoreprdid")
    @JsonProperty("pscoreprdid")
    @ApiModelProperty(value = "pscoreprdid", notes = "核心产品标识")
    private String psCorePrdId;

    /**
     * 产品名称
     */
    @DEField(name = "pscoreprdname")
    @JSONField(name = "pscoreprdname")
    @JsonProperty("pscoreprdname")
    @ApiModelProperty(value = "pscoreprdname", notes = "产品名称")
    private String psCorePrdName;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 安装包路径
     */
    @DEField(name = "pkgfolder")
    @JSONField(name = "pkgfolder")
    @JsonProperty("pkgfolder")
    @ApiModelProperty(value = "pkgfolder", notes = "安装包路径")
    private String pkgFolder;

    /**
     * 产品标记2
     */
    @DEField(name = "prdtag2")
    @JSONField(name = "prdtag2")
    @JsonProperty("prdtag2")
    @ApiModelProperty(value = "prdtag2", notes = "产品标记2")
    private String prdTag2;

    /**
     * 产品编号
     */
    @DEField(name = "prdsn")
    @JSONField(name = "prdsn")
    @JsonProperty("prdsn")
    @ApiModelProperty(value = "prdsn", notes = "产品编号")
    private String prdSn;

    /**
     * 产品标记
     */
    @DEField(name = "prdtag")
    @JSONField(name = "prdtag")
    @JsonProperty("prdtag")
    @ApiModelProperty(value = "prdtag", notes = "产品标记")
    private String prdTag;

    /**
     * 产品分类
     */
    @DEField(name = "pscoreprdcatid")
    @JSONField(name = "pscoreprdcatid")
    @JsonProperty("pscoreprdcatid")
    @ApiModelProperty(value = "pscoreprdcatid", notes = "产品分类")
    private String psCorePrdCatId;

    /**
     * 产品分类
     */
    @DEField(name = "pscoreprdcatname")
    @JSONField(name = "pscoreprdcatname")
    @JsonProperty("pscoreprdcatname")
    @ApiModelProperty(value = "pscoreprdcatname", notes = "产品分类")
    private String psCorePrdCatName;

    /**
     * 产品分类路径
     */
    @DEField(name = "pscoreprdcatpath")
    @JSONField(name = "pscoreprdcatpath")
    @JsonProperty("pscoreprdcatpath")
    @ApiModelProperty(value = "pscoreprdcatpath", notes = "产品分类路径")
    private String psCorePrdCatPath;

    /**
     * Http仓库地址
     */
    @DEField(name = "httpurltorepo")
    @JSONField(name = "httpurltorepo")
    @JsonProperty("httpurltorepo")
    @ApiModelProperty(value = "httpurltorepo", notes = "Http仓库地址")
    private String httpUrlToRepo;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 完全路径
     */
    @DEField(name = "fullpath")
    @JSONField(name = "fullpath")
    @JsonProperty("fullpath")
    @ApiModelProperty(value = "fullpath", notes = "完全路径")
    private String fullPath;

    /**
     * 当前版本
     */
    @DEField(name = "currentversion")
    @JSONField(name = "currentversion")
    @JsonProperty("currentversion")
    @ApiModelProperty(value = "currentversion", notes = "当前版本")
    private String currentVersion;

    /**
     * 路径
     */
    @DEField(name = "path")
    @JSONField(name = "path")
    @JsonProperty("path")
    @ApiModelProperty(value = "path", notes = "路径")
    private String path;

    /**
     * 图标路径
     */
    @DEField(name = "avatarurl")
    @JSONField(name = "avatarurl")
    @JsonProperty("avatarurl")
    @ApiModelProperty(value = "avatarurl", notes = "图标路径")
    private String avatarUrl;

    /**
     * 完全名称
     */
    @DEField(name = "fullname")
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    @ApiModelProperty(value = "fullname", notes = "完全名称")
    private String fullName;

    /**
     * 设置地址
     */
    @DEField(name = "settingurl")
    @JSONField(name = "settingurl")
    @JsonProperty("settingurl")
    @ApiModelProperty(value = "settingurl", notes = "设置地址")
    private String settingUrl;

    /**
    * 设置 [部署应用名]
    */
    public PSCorePrd setDeploySystemCode(String deploySystemCode) {
        this.deploySystemCode = deploySystemCode;
        this.modify("deploy_system_code", deploySystemCode);
        return this;
    }

    /**
    * 设置 [设置]
    */
    public PSCorePrd setSettings(String settings) {
        this.settings = settings;
        this.modify("settings", settings);
        return this;
    }

    /**
    * 设置 [部署节点]
    */
    public PSCorePrd setDeployServiceHubId(String deployServiceHubId) {
        this.deployServiceHubId = deployServiceHubId;
        this.modify("deploy_service_hub_id", deployServiceHubId);
        return this;
    }

    /**
    * 设置 [可用版本]
    */
    public PSCorePrd setVers(String vers) {
        this.vers = vers;
        this.modify("vers", vers);
        return this;
    }

    /**
    * 设置 [部署数据源]
    */
    public PSCorePrd setDeployDataSourceId(String deployDataSourceId) {
        this.deployDataSourceId = deployDataSourceId;
        this.modify("deploy_data_source_id", deployDataSourceId);
        return this;
    }

    /**
    * 设置 [部署版本]
    */
    public PSCorePrd setDeployPrdverId(String deployPrdverId) {
        this.deployPrdverId = deployPrdverId;
        this.modify("deploy_prdver_id", deployPrdverId);
        return this;
    }

    /**
    * 设置 [详细信息]
    */
    public PSCorePrd setInfo(String info) {
        this.info = info;
        this.modify("info", info);
        return this;
    }

    /**
    * 设置 [产品标签]
    */
    public PSCorePrd setCategory(String category) {
        this.category = category;
        this.modify("category", category);
        return this;
    }

    /**
    * 设置 [变更日志]
    */
    public PSCorePrd setChangelog(String changelog) {
        this.changelog = changelog;
        this.modify("changelog", changelog);
        return this;
    }

    /**
    * 设置 [产品名称]
    */
    public PSCorePrd setPsCorePrdName(String psCorePrdName) {
        this.psCorePrdName = psCorePrdName;
        this.modify("pscoreprdname", psCorePrdName);
        return this;
    }

    /**
    * 设置 [安装包路径]
    */
    public PSCorePrd setPkgFolder(String pkgFolder) {
        this.pkgFolder = pkgFolder;
        this.modify("pkgfolder", pkgFolder);
        return this;
    }

    /**
    * 设置 [产品标记2]
    */
    public PSCorePrd setPrdTag2(String prdTag2) {
        this.prdTag2 = prdTag2;
        this.modify("prdtag2", prdTag2);
        return this;
    }

    /**
    * 设置 [产品编号]
    */
    public PSCorePrd setPrdSn(String prdSn) {
        this.prdSn = prdSn;
        this.modify("prdsn", prdSn);
        return this;
    }

    /**
    * 设置 [产品标记]
    */
    public PSCorePrd setPrdTag(String prdTag) {
        this.prdTag = prdTag;
        this.modify("prdtag", prdTag);
        return this;
    }

    /**
    * 设置 [产品分类]
    */
    public PSCorePrd setPsCorePrdCatId(String psCorePrdCatId) {
        this.psCorePrdCatId = psCorePrdCatId;
        this.modify("pscoreprdcatid", psCorePrdCatId);
        return this;
    }

    /**
    * 设置 [产品分类]
    */
    public PSCorePrd setPsCorePrdCatName(String psCorePrdCatName) {
        this.psCorePrdCatName = psCorePrdCatName;
        this.modify("pscoreprdcatname", psCorePrdCatName);
        return this;
    }

    /**
    * 设置 [产品分类路径]
    */
    public PSCorePrd setPsCorePrdCatPath(String psCorePrdCatPath) {
        this.psCorePrdCatPath = psCorePrdCatPath;
        this.modify("pscoreprdcatpath", psCorePrdCatPath);
        return this;
    }

    /**
    * 设置 [Http仓库地址]
    */
    public PSCorePrd setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
        this.modify("httpurltorepo", httpUrlToRepo);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSCorePrd setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [完全路径]
    */
    public PSCorePrd setFullPath(String fullPath) {
        this.fullPath = fullPath;
        this.modify("fullpath", fullPath);
        return this;
    }

    /**
    * 设置 [当前版本]
    */
    public PSCorePrd setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
        this.modify("currentversion", currentVersion);
        return this;
    }

    /**
    * 设置 [路径]
    */
    public PSCorePrd setPath(String path) {
        this.path = path;
        this.modify("path", path);
        return this;
    }

    /**
    * 设置 [图标路径]
    */
    public PSCorePrd setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.modify("avatarurl", avatarUrl);
        return this;
    }

    /**
    * 设置 [完全名称]
    */
    public PSCorePrd setFullName(String fullName) {
        this.fullName = fullName;
        this.modify("fullname", fullName);
        return this;
    }

    /**
    * 设置 [设置地址]
    */
    public PSCorePrd setSettingUrl(String settingUrl) {
        this.settingUrl = settingUrl;
        this.modify("settingurl", settingUrl);
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
            entity.reset("pscoreprdid");
        }
        return targetEntity;
    }

}