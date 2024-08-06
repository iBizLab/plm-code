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
 * 共享空间[SharedSpaceDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("共享空间DTO")
public class SharedSpaceDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否开启共享
     */
    @JsonProperty("is_shared")
    @JSONField(name = "is_shared")
    @ApiModelProperty(value = "是否开启共享", position = 0)
    private String isShared;

    /**
     * 共享页面标识
     */
    @JsonProperty("shared_pages")
    @JSONField(name = "shared_pages")
    @ApiModelProperty(value = "共享页面标识", position = 1)
    private String sharedPages;

    /**
     * 共享有效期
     */
    @JsonProperty("expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "expiration_date" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "共享有效期", position = 2)
    private Date expirationDate;

    /**
     * 访问密码
     */
    @JsonProperty("access_password")
    @JSONField(name = "access_password")
    @ApiModelProperty(value = "访问密码", position = 3)
    private String accessPassword;

    /**
     * 共享展示标题
     */
    @JsonProperty("show_title")
    @JSONField(name = "show_title")
    @ApiModelProperty(value = "共享展示标题", position = 4)
    private String showTitle;

    /**
     * 共享展示图标
     */
    @JsonProperty("show_logo")
    @JSONField(name = "show_logo")
    @ApiModelProperty(value = "共享展示图标", position = 5)
    private String showLogo;

    /**
     * 所属
     */
    @JsonProperty("scope_type")
    @JSONField(name = "scope_type")
    @ApiModelProperty(value = "所属", position = 6)
    private String scopeType;

    /**
     * 共享人
     */
    @JsonProperty("shared_by")
    @JSONField(name = "shared_by")
    @ApiModelProperty(value = "共享人", position = 7)
    private String sharedBy;

    /**
     * 共享时间
     */
    @JsonProperty("shared_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "shared_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "共享时间", position = 8)
    private Date sharedTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 9)
    private String id;

    /**
     * 空间名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "空间名称", position = 10)
    private String name;


    /**
     * 设置 [是否开启共享]
     */
    public SharedSpaceDTO setIsShared(String isShared) {
        this.isShared = isShared;
        this.modify("is_shared", isShared);
        return this;
    }

    /**
     * 设置 [共享页面标识]
     */
    public SharedSpaceDTO setSharedPages(String sharedPages) {
        this.sharedPages = sharedPages;
        this.modify("shared_pages", sharedPages);
        return this;
    }

    /**
     * 设置 [共享有效期]
     */
    public SharedSpaceDTO setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        this.modify("expiration_date", expirationDate);
        return this;
    }

    /**
     * 设置 [访问密码]
     */
    public SharedSpaceDTO setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
        this.modify("access_password", accessPassword);
        return this;
    }

    /**
     * 设置 [共享展示标题]
     */
    public SharedSpaceDTO setShowTitle(String showTitle) {
        this.showTitle = showTitle;
        this.modify("show_title", showTitle);
        return this;
    }

    /**
     * 设置 [共享展示图标]
     */
    public SharedSpaceDTO setShowLogo(String showLogo) {
        this.showLogo = showLogo;
        this.modify("show_logo", showLogo);
        return this;
    }

    /**
     * 设置 [所属]
     */
    public SharedSpaceDTO setScopeType(String scopeType) {
        this.scopeType = scopeType;
        this.modify("scope_type", scopeType);
        return this;
    }

    /**
     * 设置 [共享人]
     */
    public SharedSpaceDTO setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
        this.modify("shared_by", sharedBy);
        return this;
    }

    /**
     * 设置 [共享时间]
     */
    public SharedSpaceDTO setSharedTime(Date sharedTime) {
        this.sharedTime = sharedTime;
        this.modify("shared_time", sharedTime);
        return this;
    }

    /**
     * 设置 [空间名称]
     */
    public SharedSpaceDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
