/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

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
import cn.ibizlab.plm.core.base.domain.AddonResource;
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 资源组件成员实体类[ResourceMember]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "RESOURCE_MEMBER", description = "资源组件成员")
public class ResourceMember extends EntityBase implements Serializable
{
    /**
     * 天容量
     */
    @DEField(name = "day_capacity")
    @JSONField(name = "day_capacity")
    @JsonProperty("day_capacity")
    @ApiModelProperty(value = "day_capacity", notes = "天容量")
    private Map dayCapacity;

    /**
     * 登录名
     */
    @DEField(name = "user_id")
    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @ApiModelProperty(value = "user_id", notes = "登录名")
    private String userId;

    /**
     * 周工作日
     */
    @DEField(name = "weekday" , dict = "weekday")
    @JSONField(name = "weekday")
    @JsonProperty("weekday")
    @ApiModelProperty(value = "weekday", notes = "周工作日")
    private String weekday;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 姓名
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "姓名")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 组件标识
     */
    @DEField(name = "addon_id")
    @JSONField(name = "addon_id")
    @JsonProperty("addon_id")
    @ApiModelProperty(value = "addon_id", notes = "组件标识")
    private String addonId;

    /**
     * 资源-成员
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "addon_resource", notes = "资源-成员")
    private AddonResource addonResource;

    /**
     * 用户
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "user", notes = "用户")
    private User user;

    /**
    * 设置 [天容量]
    */
    public ResourceMember setDayCapacity(Map dayCapacity) {
        this.dayCapacity = dayCapacity;
        this.modify("day_capacity", dayCapacity);
        return this;
    }

    /**
    * 设置 [登录名]
    */
    public ResourceMember setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
    * 设置 [周工作日]
    */
    public ResourceMember setWeekday(String weekday) {
        this.weekday = weekday;
        this.modify("weekday", weekday);
        return this;
    }

    /**
    * 设置 [姓名]
    */
    public ResourceMember setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [组件标识]
    */
    public ResourceMember setAddonId(String addonId) {
        this.addonId = addonId;
        this.modify("addon_id", addonId);
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
            entity.reset("id");
        }
        return targetEntity;
    }

}