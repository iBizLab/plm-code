/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
 * 页面版本[PageVersionDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("页面版本DTO")
public class PageVersionDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据
     */
    @JsonProperty("data")
    @JSONField(name = "data")
    @ApiModelProperty(value = "数据", position = 0)
    private String data;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 1)
    private String ownerId;

    /**
     * 版本
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "版本", position = 2)
    private BigDecimal identifier;

    /**
     * 是否发布
     */
    @JsonProperty("is_published")
    @JSONField(name = "is_published")
    @ApiModelProperty(value = "是否发布", position = 3)
    private Integer isPublished;

    /**
     * 是否命名
     */
    @JsonProperty("is_named")
    @JSONField(name = "is_named")
    @ApiModelProperty(value = "是否命名", position = 4)
    private Integer isNamed;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 5)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 6)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 7)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 8)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 9)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 10)
    private Date updateTime;


    /**
     * 设置 [版本]
     */
    public PageVersionDTO setIdentifier(BigDecimal identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [是否发布]
     */
    public PageVersionDTO setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
        this.modify("is_published", isPublished);
        return this;
    }

    /**
     * 设置 [是否命名]
     */
    public PageVersionDTO setIsNamed(Integer isNamed) {
        this.isNamed = isNamed;
        this.modify("is_named", isNamed);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public PageVersionDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
