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
 * 资源组件[AddonResourceDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("资源组件DTO")
public class AddonResourceDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组件类型
     */
    @JsonProperty("addon_type")
    @JSONField(name = "addon_type")
    @ApiModelProperty(value = "组件类型", position = 0)
    private String addonType;

    /**
     * 所属类型
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属类型", position = 1)
    private String ownerType;

    /**
     * 所属标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属标识", position = 2)
    private String ownerId;

    /**
     * 配置模型
     */
    @JsonProperty("setting_model")
    @JSONField(name = "setting_model")
    @ApiModelProperty(value = "配置模型", position = 3)
    private String settingModel;

    /**
     * 启用
     */
    @JsonProperty("is_enabled")
    @JSONField(name = "is_enabled")
    @ApiModelProperty(value = "启用", position = 4)
    private Integer isEnabled;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 5)
    private String description;

    /**
     * 资源成员
     */
    @JsonProperty("members")
    @JSONField(name = "members")
    @ApiModelProperty(value = "资源成员", position = 6)
    private List<ResourceMemberDTO> members;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 7)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 8)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 9)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 10)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 11)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 12)
    private Date updateTime;


    /**
     * 设置 [组件类型]
     */
    public AddonResourceDTO setAddonType(String addonType) {
        this.addonType = addonType;
        this.modify("addon_type", addonType);
        return this;
    }

    /**
     * 设置 [所属类型]
     */
    public AddonResourceDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [所属标识]
     */
    public AddonResourceDTO setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("owner_id", ownerId);
        return this;
    }

    /**
     * 设置 [启用]
     */
    public AddonResourceDTO setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
        this.modify("is_enabled", isEnabled);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public AddonResourceDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [资源成员]
     */
    public AddonResourceDTO setMembers(List<ResourceMemberDTO> members) {
        this.members = members;
        this.modify("members", members);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public AddonResourceDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
