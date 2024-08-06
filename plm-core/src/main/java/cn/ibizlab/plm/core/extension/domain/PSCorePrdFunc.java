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
 * 核心产品功能实体类[PSCorePrdFunc]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSCOREPRDFUNC", description = "核心产品功能")
public class PSCorePrdFunc extends EntityBase implements Serializable
{
    /**
     * 功能类型
     */
    @DEField(name = "functype")
    @JSONField(name = "functype")
    @JsonProperty("functype")
    @ApiModelProperty(value = "functype", notes = "功能类型")
    private String funcType;

    /**
     * 核心产品功能标识
     */
    @Id
    @DEField(name = "pscoreprdfuncid" , isKeyField = true)
    @JSONField(name = "pscoreprdfuncid")
    @JsonProperty("pscoreprdfuncid")
    @ApiModelProperty(value = "pscoreprdfuncid", notes = "核心产品功能标识")
    private String psCorePrdFuncId;

    /**
     * 核心产品功能名称
     */
    @DEField(name = "pscoreprdfuncname")
    @JSONField(name = "pscoreprdfuncname")
    @JsonProperty("pscoreprdfuncname")
    @ApiModelProperty(value = "pscoreprdfuncname", notes = "核心产品功能名称")
    private String psCorePrdFuncName;

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
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 完全名称
     */
    @DEField(name = "fullname")
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    @ApiModelProperty(value = "fullname", notes = "完全名称")
    private String fullName;

    /**
     * 功能标记
     */
    @DEField(name = "functag")
    @JSONField(name = "functag")
    @JsonProperty("functag")
    @ApiModelProperty(value = "functag", notes = "功能标记")
    private String funcTag;

    /**
     * 排序值
     */
    @DEField(name = "ordervalue" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    @ApiModelProperty(value = "ordervalue", notes = "排序值")
    private Integer orderValue;

    /**
     * 功能描述链接
     */
    @DEField(name = "funcurl")
    @JSONField(name = "funcurl")
    @JsonProperty("funcurl")
    @ApiModelProperty(value = "funcurl", notes = "功能描述链接")
    private String funcUrl;

    /**
     * 图标路径
     */
    @DEField(name = "avatarurl")
    @JSONField(name = "avatarurl")
    @JsonProperty("avatarurl")
    @ApiModelProperty(value = "avatarurl", notes = "图标路径")
    private String avatarUrl;

    /**
     * Http仓库地址
     */
    @DEField(name = "httpurltorepo")
    @JSONField(name = "httpurltorepo")
    @JsonProperty("httpurltorepo")
    @ApiModelProperty(value = "httpurltorepo", notes = "Http仓库地址")
    private String httpUrlToRepo;

    /**
     * 完全路径
     */
    @DEField(name = "fullpath")
    @JSONField(name = "fullpath")
    @JsonProperty("fullpath")
    @ApiModelProperty(value = "fullpath", notes = "完全路径")
    private String fullPath;

    /**
     * 核心产品
     */
    @DEField(name = "pscoreprdname")
    @JSONField(name = "pscoreprdname")
    @JsonProperty("pscoreprdname")
    @ApiModelProperty(value = "pscoreprdname", notes = "核心产品")
    private String psCorePrdName;

    /**
     * 路径
     */
    @DEField(name = "path")
    @JSONField(name = "path")
    @JsonProperty("path")
    @ApiModelProperty(value = "path", notes = "路径")
    private String path;

    /**
     * 功能编号
     */
    @DEField(name = "funcsn")
    @JSONField(name = "funcsn")
    @JsonProperty("funcsn")
    @ApiModelProperty(value = "funcsn", notes = "功能编号")
    private String funcSn;

    /**
     * 功能标记2
     */
    @DEField(name = "functag2")
    @JSONField(name = "functag2")
    @JsonProperty("functag2")
    @ApiModelProperty(value = "functag2", notes = "功能标记2")
    private String funcTag2;

    /**
     * 核心产品
     */
    @DEField(name = "pscoreprdid")
    @JSONField(name = "pscoreprdid")
    @JsonProperty("pscoreprdid")
    @ApiModelProperty(value = "pscoreprdid", notes = "核心产品")
    private String psCorePrdId;

    /**
     * 当前版本
     */
    @DEField(name = "currentversion")
    @JSONField(name = "currentversion")
    @JsonProperty("currentversion")
    @ApiModelProperty(value = "currentversion", notes = "当前版本")
    private String currentVersion;

    /**
     * 功能状态
     */
    @DEField(name = "funcstate" , dict = "product_func_state")
    @JSONField(name = "funcstate")
    @JsonProperty("funcstate")
    @ApiModelProperty(value = "funcstate", notes = "功能状态")
    private String funcState;

    /**
    * 设置 [功能类型]
    */
    public PSCorePrdFunc setFuncType(String funcType) {
        this.funcType = funcType;
        this.modify("functype", funcType);
        return this;
    }

    /**
    * 设置 [核心产品功能名称]
    */
    public PSCorePrdFunc setPsCorePrdFuncName(String psCorePrdFuncName) {
        this.psCorePrdFuncName = psCorePrdFuncName;
        this.modify("pscoreprdfuncname", psCorePrdFuncName);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSCorePrdFunc setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [完全名称]
    */
    public PSCorePrdFunc setFullName(String fullName) {
        this.fullName = fullName;
        this.modify("fullname", fullName);
        return this;
    }

    /**
    * 设置 [功能标记]
    */
    public PSCorePrdFunc setFuncTag(String funcTag) {
        this.funcTag = funcTag;
        this.modify("functag", funcTag);
        return this;
    }

    /**
    * 设置 [功能描述链接]
    */
    public PSCorePrdFunc setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
        this.modify("funcurl", funcUrl);
        return this;
    }

    /**
    * 设置 [图标路径]
    */
    public PSCorePrdFunc setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.modify("avatarurl", avatarUrl);
        return this;
    }

    /**
    * 设置 [Http仓库地址]
    */
    public PSCorePrdFunc setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
        this.modify("httpurltorepo", httpUrlToRepo);
        return this;
    }

    /**
    * 设置 [完全路径]
    */
    public PSCorePrdFunc setFullPath(String fullPath) {
        this.fullPath = fullPath;
        this.modify("fullpath", fullPath);
        return this;
    }

    /**
    * 设置 [核心产品]
    */
    public PSCorePrdFunc setPsCorePrdName(String psCorePrdName) {
        this.psCorePrdName = psCorePrdName;
        this.modify("pscoreprdname", psCorePrdName);
        return this;
    }

    /**
    * 设置 [路径]
    */
    public PSCorePrdFunc setPath(String path) {
        this.path = path;
        this.modify("path", path);
        return this;
    }

    /**
    * 设置 [功能编号]
    */
    public PSCorePrdFunc setFuncSn(String funcSn) {
        this.funcSn = funcSn;
        this.modify("funcsn", funcSn);
        return this;
    }

    /**
    * 设置 [功能标记2]
    */
    public PSCorePrdFunc setFuncTag2(String funcTag2) {
        this.funcTag2 = funcTag2;
        this.modify("functag2", funcTag2);
        return this;
    }

    /**
    * 设置 [核心产品]
    */
    public PSCorePrdFunc setPsCorePrdId(String psCorePrdId) {
        this.psCorePrdId = psCorePrdId;
        this.modify("pscoreprdid", psCorePrdId);
        return this;
    }

    /**
    * 设置 [当前版本]
    */
    public PSCorePrdFunc setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
        this.modify("currentversion", currentVersion);
        return this;
    }

    /**
    * 设置 [功能状态]
    */
    public PSCorePrdFunc setFuncState(String funcState) {
        this.funcState = funcState;
        this.modify("funcstate", funcState);
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
            entity.reset("pscoreprdfuncid");
        }
        return targetEntity;
    }

}