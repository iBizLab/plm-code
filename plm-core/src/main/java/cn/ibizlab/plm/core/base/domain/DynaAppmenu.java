/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 动态应用菜单实体类[DynaAppmenu]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "DYNA_APPMENU", resultMap = "DynaAppmenuResultMap")
@ApiModel(value = "DYNA_APPMENU", description = "动态应用菜单")
public class DynaAppmenu extends EntityMP implements Serializable
{

    /**
    * 看板类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , defaultValue = "personal")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "看板类型")
    private String type;

    /**
    * 所属数据类型
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据类型")
    private String ownerType;

    /**
    * 所属数据标识
    */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id")
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 用户标识
    */
    @TableField(value = "userid")
    @DEField(name = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty(value = "userid", notes = "用户标识")
    private String userId;

    /**
    * 模型标识
    */
    @TableField(value = "modelid")
    @DEField(name = "modelid")
    @JSONField(name = "modelid")
    @JsonProperty("modelid")
    @ApiModelProperty(value = "modelid", notes = "模型标识")
    private String modelId;

    /**
    * 模型
    */
    @TableField(value = "model")
    @DEField(name = "model")
    @JSONField(name = "model")
    @JsonProperty("model")
    @ApiModelProperty(value = "model", notes = "模型")
    private String model;

    /**
    * 应用标识
    */
    @TableField(value = "appid")
    @DEField(name = "appid")
    @JSONField(name = "appid")
    @JsonProperty("appid")
    @ApiModelProperty(value = "appid", notes = "应用标识")
    private String appId;

    /**
    * 设置 [看板类型]
    */
    public DynaAppmenu setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [所属数据类型]
    */
    public DynaAppmenu setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [所属数据标识]
    */
    public DynaAppmenu setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("owner_id", ownerId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public DynaAppmenu setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [用户标识]
    */
    public DynaAppmenu setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
    * 设置 [模型标识]
    */
    public DynaAppmenu setModelId(String modelId) {
        this.modelId = modelId;
        this.modify("modelid", modelId);
        return this;
    }

    /**
    * 设置 [模型]
    */
    public DynaAppmenu setModel(String model) {
        this.model = model;
        this.modify("model", model);
        return this;
    }

    /**
    * 设置 [应用标识]
    */
    public DynaAppmenu setAppId(String appId) {
        this.appId = appId;
        this.modify("appid", appId);
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