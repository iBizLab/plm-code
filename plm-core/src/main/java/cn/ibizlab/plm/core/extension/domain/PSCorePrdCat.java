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
 * 核心产品分类实体类[PSCorePrdCat]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSCOREPRDCAT", description = "核心产品分类")
public class PSCorePrdCat extends EntityBase implements Serializable
{
    /**
     * 上级分类
     */
    @DEField(name = "ppscoreprdcatid")
    @JSONField(name = "ppscoreprdcatid")
    @JsonProperty("ppscoreprdcatid")
    @ApiModelProperty(value = "ppscoreprdcatid", notes = "上级分类")
    private String ppsCorePrdCatId;

    /**
     * 核心产品分类标识
     */
    @Id
    @DEField(name = "pscoreprdcatid" , isKeyField = true)
    @JSONField(name = "pscoreprdcatid")
    @JsonProperty("pscoreprdcatid")
    @ApiModelProperty(value = "pscoreprdcatid", notes = "核心产品分类标识")
    private String psCorePrdCatId;

    /**
     * 核心产品分类名称
     */
    @DEField(name = "pscoreprdcatname")
    @JSONField(name = "pscoreprdcatname")
    @JsonProperty("pscoreprdcatname")
    @ApiModelProperty(value = "pscoreprdcatname", notes = "核心产品分类名称")
    private String psCorePrdCatName;

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
     * 完全路径
     */
    @DEField(name = "fullpath")
    @JSONField(name = "fullpath")
    @JsonProperty("fullpath")
    @ApiModelProperty(value = "fullpath", notes = "完全路径")
    private String fullPath;

    /**
     * 路径
     */
    @DEField(name = "path")
    @JSONField(name = "path")
    @JsonProperty("path")
    @ApiModelProperty(value = "path", notes = "路径")
    private String path;

    /**
     * 完全名称
     */
    @DEField(name = "fullname")
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    @ApiModelProperty(value = "fullname", notes = "完全名称")
    private String fullName;

    /**
     * 上级分类
     */
    @DEField(name = "ppscoreprdcatname")
    @JSONField(name = "ppscoreprdcatname")
    @JsonProperty("ppscoreprdcatname")
    @ApiModelProperty(value = "ppscoreprdcatname", notes = "上级分类")
    private String ppsCorePrdCatName;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 图标路径
     */
    @DEField(name = "avatarurl")
    @JSONField(name = "avatarurl")
    @JsonProperty("avatarurl")
    @ApiModelProperty(value = "avatarurl", notes = "图标路径")
    private String avatarUrl;

    /**
    * 设置 [上级分类]
    */
    public PSCorePrdCat setPpsCorePrdCatId(String ppsCorePrdCatId) {
        this.ppsCorePrdCatId = ppsCorePrdCatId;
        this.modify("ppscoreprdcatid", ppsCorePrdCatId);
        return this;
    }

    /**
    * 设置 [核心产品分类名称]
    */
    public PSCorePrdCat setPsCorePrdCatName(String psCorePrdCatName) {
        this.psCorePrdCatName = psCorePrdCatName;
        this.modify("pscoreprdcatname", psCorePrdCatName);
        return this;
    }

    /**
    * 设置 [完全路径]
    */
    public PSCorePrdCat setFullPath(String fullPath) {
        this.fullPath = fullPath;
        this.modify("fullpath", fullPath);
        return this;
    }

    /**
    * 设置 [路径]
    */
    public PSCorePrdCat setPath(String path) {
        this.path = path;
        this.modify("path", path);
        return this;
    }

    /**
    * 设置 [完全名称]
    */
    public PSCorePrdCat setFullName(String fullName) {
        this.fullName = fullName;
        this.modify("fullname", fullName);
        return this;
    }

    /**
    * 设置 [上级分类]
    */
    public PSCorePrdCat setPpsCorePrdCatName(String ppsCorePrdCatName) {
        this.ppsCorePrdCatName = ppsCorePrdCatName;
        this.modify("ppscoreprdcatname", ppsCorePrdCatName);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public PSCorePrdCat setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
    * 设置 [图标路径]
    */
    public PSCorePrdCat setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.modify("avatarurl", avatarUrl);
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
            entity.reset("pscoreprdcatid");
        }
        return targetEntity;
    }

}