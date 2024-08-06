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
 * 页面[ArticlePageSharedFieldsDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("页面DTO")
public class ArticlePageSharedFieldsDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 0)
    private String id;

    /**
     * 主题
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "主题", position = 1)
    private String name;

    /**
     * 是否开启共享
     */
    @JsonProperty("is_shared")
    @JSONField(name = "is_shared")
    @ApiModelProperty(value = "是否开启共享", position = 2)
    private String isShared;

    /**
     * 是否同时共享子页面
     */
    @JsonProperty("is_shared_subset")
    @JSONField(name = "is_shared_subset")
    @ApiModelProperty(value = "是否同时共享子页面", position = 3)
    private String isSharedSubset;

    /**
     * 共享有效期
     */
    @JsonProperty("expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "expiration_date" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "共享有效期", position = 4)
    private Date expirationDate;

    /**
     * 发布主题
     */
    @JsonProperty("publish_name")
    @JSONField(name = "publish_name")
    @ApiModelProperty(value = "发布主题", position = 5)
    private String publishName;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 6)
    private Date updateTime;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 7)
    private String updateMan;

    /**
     * 共享人
     */
    @JsonProperty("shared_by")
    @JSONField(name = "shared_by")
    @ApiModelProperty(value = "共享人", position = 8)
    private String sharedBy;

    /**
     * 共享时间
     */
    @JsonProperty("shared_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "shared_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "共享时间", position = 9)
    private Date sharedTime;

    /**
     * 空间标识
     */
    @JsonProperty("space_id")
    @JSONField(name = "space_id")
    @ApiModelProperty(value = "空间标识", position = 10)
    private String spaceId;


    /**
     * 设置 [主题]
     */
    public ArticlePageSharedFieldsDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [是否开启共享]
     */
    public ArticlePageSharedFieldsDTO setIsShared(String isShared) {
        this.isShared = isShared;
        this.modify("is_shared", isShared);
        return this;
    }

    /**
     * 设置 [是否同时共享子页面]
     */
    public ArticlePageSharedFieldsDTO setIsSharedSubset(String isSharedSubset) {
        this.isSharedSubset = isSharedSubset;
        this.modify("is_shared_subset", isSharedSubset);
        return this;
    }

    /**
     * 设置 [共享有效期]
     */
    public ArticlePageSharedFieldsDTO setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        this.modify("expiration_date", expirationDate);
        return this;
    }

    /**
     * 设置 [发布主题]
     */
    public ArticlePageSharedFieldsDTO setPublishName(String publishName) {
        this.publishName = publishName;
        this.modify("publish_name", publishName);
        return this;
    }

    /**
     * 设置 [共享人]
     */
    public ArticlePageSharedFieldsDTO setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
        this.modify("shared_by", sharedBy);
        return this;
    }

    /**
     * 设置 [共享时间]
     */
    public ArticlePageSharedFieldsDTO setSharedTime(Date sharedTime) {
        this.sharedTime = sharedTime;
        this.modify("shared_time", sharedTime);
        return this;
    }

    /**
     * 设置 [空间标识]
     */
    public ArticlePageSharedFieldsDTO setSpaceId(String spaceId) {
        this.spaceId = spaceId;
        this.modify("space_id", spaceId);
        return this;
    }


}
