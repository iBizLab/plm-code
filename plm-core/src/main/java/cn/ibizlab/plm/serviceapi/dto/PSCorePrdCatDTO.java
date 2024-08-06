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
 * 核心产品分类[PSCorePrdCatDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("核心产品分类DTO")
public class PSCorePrdCatDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 上级分类
     */
    @JsonProperty("ppscoreprdcatid")
    @JSONField(name = "ppscoreprdcatid")
    @ApiModelProperty(value = "上级分类", position = 0)
    private String ppsCorePrdCatId;

    /**
     * 图标路径
     */
    @JsonProperty("avatarurl")
    @JSONField(name = "avatarurl")
    @ApiModelProperty(value = "图标路径", position = 1)
    private String avatarUrl;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 2)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 3)
    private String createMan;

    /**
     * 完全名称
     */
    @JsonProperty("fullname")
    @JSONField(name = "fullname")
    @ApiModelProperty(value = "完全名称", position = 4)
    private String fullName;

    /**
     * 完全路径
     */
    @JsonProperty("fullpath")
    @JSONField(name = "fullpath")
    @ApiModelProperty(value = "完全路径", position = 5)
    private String fullPath;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 6)
    private String memo;

    /**
     * 上级分类
     */
    @JsonProperty("ppscoreprdcatname")
    @JSONField(name = "ppscoreprdcatname")
    @ApiModelProperty(value = "上级分类", position = 7)
    private String ppsCorePrdCatName;

    /**
     * 核心产品分类标识
     */
    @JsonProperty("pscoreprdcatid")
    @JSONField(name = "pscoreprdcatid")
    @ApiModelProperty(value = "核心产品分类标识", position = 8)
    private String psCorePrdCatId;

    /**
     * 核心产品分类名称
     */
    @JsonProperty("pscoreprdcatname")
    @JSONField(name = "pscoreprdcatname")
    @ApiModelProperty(value = "核心产品分类名称", position = 9)
    private String psCorePrdCatName;

    /**
     * 路径
     */
    @JsonProperty("path")
    @JSONField(name = "path")
    @ApiModelProperty(value = "路径", position = 10)
    private String path;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 11)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 12)
    private String updateMan;


    /**
     * 设置 [上级分类]
     */
    public PSCorePrdCatDTO setPpsCorePrdCatId(String ppsCorePrdCatId) {
        this.ppsCorePrdCatId = ppsCorePrdCatId;
        this.modify("ppscoreprdcatid", ppsCorePrdCatId);
        return this;
    }

    /**
     * 设置 [图标路径]
     */
    public PSCorePrdCatDTO setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.modify("avatarurl", avatarUrl);
        return this;
    }

    /**
     * 设置 [完全名称]
     */
    public PSCorePrdCatDTO setFullName(String fullName) {
        this.fullName = fullName;
        this.modify("fullname", fullName);
        return this;
    }

    /**
     * 设置 [完全路径]
     */
    public PSCorePrdCatDTO setFullPath(String fullPath) {
        this.fullPath = fullPath;
        this.modify("fullpath", fullPath);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public PSCorePrdCatDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [上级分类]
     */
    public PSCorePrdCatDTO setPpsCorePrdCatName(String ppsCorePrdCatName) {
        this.ppsCorePrdCatName = ppsCorePrdCatName;
        this.modify("ppscoreprdcatname", ppsCorePrdCatName);
        return this;
    }

    /**
     * 设置 [核心产品分类名称]
     */
    public PSCorePrdCatDTO setPsCorePrdCatName(String psCorePrdCatName) {
        this.psCorePrdCatName = psCorePrdCatName;
        this.modify("pscoreprdcatname", psCorePrdCatName);
        return this;
    }

    /**
     * 设置 [路径]
     */
    public PSCorePrdCatDTO setPath(String path) {
        this.path = path;
        this.modify("path", path);
        return this;
    }


}
