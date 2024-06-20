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
 * 资源组件成员[ResourceMemberDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("资源组件成员DTO")
public class ResourceMemberDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 天容量
     */
    @JsonProperty("day_capacity")
    @JSONField(name = "day_capacity")
    @ApiModelProperty(value = "天容量", position = 0)
    private Map dayCapacity;

    /**
     * 登录名
     */
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "登录名", position = 1)
    private String userId;

    /**
     * 周工作日
     */
    @JsonProperty("weekday")
    @JSONField(name = "weekday")
    @ApiModelProperty(value = "周工作日", position = 2)
    private String weekday;

    /**
     * 组件标识
     */
    @JsonProperty("addon_id")
    @JSONField(name = "addon_id")
    @ApiModelProperty(value = "组件标识", position = 3)
    private String addonId;

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
     * 姓名
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "姓名", position = 7)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 8)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 9)
    private Date updateTime;


    /**
     * 设置 [天容量]
     */
    public ResourceMemberDTO setDayCapacity(Map dayCapacity) {
        this.dayCapacity = dayCapacity;
        this.modify("day_capacity", dayCapacity);
        return this;
    }

    /**
     * 设置 [登录名]
     */
    public ResourceMemberDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
     * 设置 [周工作日]
     */
    public ResourceMemberDTO setWeekday(String weekday) {
        this.weekday = weekday;
        this.modify("weekday", weekday);
        return this;
    }

    /**
     * 设置 [组件标识]
     */
    public ResourceMemberDTO setAddonId(String addonId) {
        this.addonId = addonId;
        this.modify("addon_id", addonId);
        return this;
    }

    /**
     * 设置 [姓名]
     */
    public ResourceMemberDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
