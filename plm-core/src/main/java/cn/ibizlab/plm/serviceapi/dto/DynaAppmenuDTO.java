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
 * 动态应用菜单[DynaAppmenuDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("动态应用菜单DTO")
public class DynaAppmenuDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 看板类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "看板类型", position = 0)
    private String type;

    /**
     * 所属数据类型
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据类型", position = 1)
    private String ownerType;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 2)
    private String ownerId;

    /**
     * 应用标识
     */
    @JsonProperty("app_id")
    @JSONField(name = "app_id")
    @ApiModelProperty(value = "应用标识", position = 3)
    private String appId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 4)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 5)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 6)
    private String id;

    /**
     * 模型
     */
    @JsonProperty("model")
    @JSONField(name = "model")
    @ApiModelProperty(value = "模型", position = 7)
    private String model;

    /**
     * 模型标识
     */
    @JsonProperty("model_id")
    @JSONField(name = "model_id")
    @ApiModelProperty(value = "模型标识", position = 8)
    private String modelId;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 9)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 10)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 11)
    private Date updateTime;

    /**
     * 用户标识
     */
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "用户标识", position = 12)
    private String userId;


    /**
     * 设置 [看板类型]
     */
    public DynaAppmenuDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [所属数据类型]
     */
    public DynaAppmenuDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [所属数据标识]
     */
    public DynaAppmenuDTO setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("owner_id", ownerId);
        return this;
    }

    /**
     * 设置 [应用标识]
     */
    public DynaAppmenuDTO setAppId(String appId) {
        this.appId = appId;
        this.modify("app_id", appId);
        return this;
    }

    /**
     * 设置 [模型]
     */
    public DynaAppmenuDTO setModel(String model) {
        this.model = model;
        this.modify("model", model);
        return this;
    }

    /**
     * 设置 [模型标识]
     */
    public DynaAppmenuDTO setModelId(String modelId) {
        this.modelId = modelId;
        this.modify("model_id", modelId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public DynaAppmenuDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [用户标识]
     */
    public DynaAppmenuDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }


}
