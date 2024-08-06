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
 * 页面[ArticlePageNameDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("页面DTO")
public class ArticlePageNameDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发布主题
     */
    @JsonProperty("publish_name")
    @JSONField(name = "publish_name")
    @ApiModelProperty(value = "发布主题", position = 0)
    private String publishName;

    /**
     * 主题
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "主题", position = 1)
    private String name;

    /**
     * 空间标识
     */
    @JsonProperty("space_id")
    @JSONField(name = "space_id")
    @ApiModelProperty(value = "空间标识", position = 2)
    private String spaceId;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 3)
    private String id;

    /**
     * 父页面标识
     */
    @JsonProperty("parent_id")
    @JSONField(name = "parent_id")
    @ApiModelProperty(value = "父页面标识", position = 4)
    private String parentId;

    /**
     * 图标
     */
    @JsonProperty("icon")
    @JSONField(name = "icon")
    @ApiModelProperty(value = "图标", position = 5)
    private String icon;


    /**
     * 设置 [发布主题]
     */
    public ArticlePageNameDTO setPublishName(String publishName) {
        this.publishName = publishName;
        this.modify("publish_name", publishName);
        return this;
    }

    /**
     * 设置 [主题]
     */
    public ArticlePageNameDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [空间标识]
     */
    public ArticlePageNameDTO setSpaceId(String spaceId) {
        this.spaceId = spaceId;
        this.modify("space_id", spaceId);
        return this;
    }

    /**
     * 设置 [父页面标识]
     */
    public ArticlePageNameDTO setParentId(String parentId) {
        this.parentId = parentId;
        this.modify("parent_id", parentId);
        return this;
    }

    /**
     * 设置 [图标]
     */
    public ArticlePageNameDTO setIcon(String icon) {
        this.icon = icon;
        this.modify("icon", icon);
        return this;
    }


}
