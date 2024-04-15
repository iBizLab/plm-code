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
 * 版本[VersionDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("版本DTO")
public class VersionDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 0)
    private String description;

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
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 3)
    private String ownerType;

    /**
     * 所属对象版本标识
     */
    @JsonProperty("owner_version_id")
    @JSONField(name = "owner_version_id")
    @ApiModelProperty(value = "所属对象版本标识", position = 4)
    private String ownerVersionId;

    /**
     * 数据
     */
    @JsonProperty("data")
    @JSONField(name = "data")
    @ApiModelProperty(value = "数据", position = 5)
    private String data;

    /**
     * 支持恢复
     */
    @JsonProperty("restorable")
    @JSONField(name = "restorable")
    @ApiModelProperty(value = "支持恢复", position = 6)
    private String restorable;

    /**
     * 手动提交
     */
    @JsonProperty("manual")
    @JSONField(name = "manual")
    @ApiModelProperty(value = "手动提交", position = 7)
    private Integer manual;

    /**
     * 过滤属性
     */
    @JsonProperty("filter")
    @JSONField(name = "filter")
    @ApiModelProperty(value = "过滤属性", position = 8)
    private String filter;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 9)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 10)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 11)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 12)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 13)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 14)
    private Date updateTime;


    /**
     * 设置 [描述]
     */
    public VersionDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [版本]
     */
    public VersionDTO setIdentifier(BigDecimal identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [数据]
     */
    public VersionDTO setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
     * 设置 [支持恢复]
     */
    public VersionDTO setRestorable(String restorable) {
        this.restorable = restorable;
        this.modify("restorable", restorable);
        return this;
    }

    /**
     * 设置 [手动提交]
     */
    public VersionDTO setManual(Integer manual) {
        this.manual = manual;
        this.modify("manual", manual);
        return this;
    }

    /**
     * 设置 [过滤属性]
     */
    public VersionDTO setFilter(String filter) {
        this.filter = filter;
        this.modify("filter", filter);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public VersionDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
