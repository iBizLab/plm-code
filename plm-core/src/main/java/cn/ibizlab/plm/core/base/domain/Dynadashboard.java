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
 * 动态数据看板实体类[Dynadashboard]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "DYNADASHBOARD", resultMap = "DynadashboardResultMap")
@ApiModel(value = "DYNADASHBOARD", description = "动态数据看板")
public class Dynadashboard extends EntityMP implements Serializable
{

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 用户标识
     */
    @TableField(value = "userid")
    @DEField(name = "userid")
    @JsonProperty("userid")
    @JSONField(name = "userid")
    @ApiModelProperty(value = "userid", notes = "用户标识")
    private String userId;

    /**
     * 模型标识
     */
    @TableField(value = "modelid")
    @DEField(name = "modelid")
    @JsonProperty("modelid")
    @JSONField(name = "modelid")
    @ApiModelProperty(value = "modelid", notes = "模型标识")
    private String modelId;

    /**
     * 应用标识
     */
    @TableField(value = "appid")
    @DEField(name = "appid")
    @JsonProperty("appid")
    @JSONField(name = "appid")
    @ApiModelProperty(value = "appid", notes = "应用标识")
    private String appId;

    /**
     * 模型
     */
    @TableField(value = "model")
    @DEField(name = "model")
    @JsonProperty("model")
    @JSONField(name = "model")
    @ApiModelProperty(value = "model", notes = "模型")
    private String model;

    /**
     * 动态数据看板标识
     */
    @Id
    @TableId(value = "dynadashboardid" , type = IdType.ASSIGN_UUID)
    @DEField(name = "dynadashboardid" , isKeyField = true)
    @JsonProperty("dynadashboardid")
    @JSONField(name = "dynadashboardid")
    @ApiModelProperty(value = "dynadashboardid", notes = "动态数据看板标识")
    private String dynaDashboardId;

    /**
     * 建立人
     */
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 动态数据看板名称
     */
    @TableField(value = "dynadashboardname")
    @DEField(name = "dynadashboardname")
    @JsonProperty("dynadashboardname")
    @JSONField(name = "dynadashboardname")
    @ApiModelProperty(value = "dynadashboardname", notes = "动态数据看板名称")
    private String dynaDashboardName;

    /**
     * 建立时间
     */
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 设置 [用户标识]
     */
    public Dynadashboard setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
     * 设置 [模型标识]
     */
    public Dynadashboard setModelId(String modelId) {
        this.modelId = modelId;
        this.modify("modelid", modelId);
        return this;
    }

    /**
     * 设置 [应用标识]
     */
    public Dynadashboard setAppId(String appId) {
        this.appId = appId;
        this.modify("appid", appId);
        return this;
    }

    /**
     * 设置 [模型]
     */
    public Dynadashboard setModel(String model) {
        this.model = model;
        this.modify("model", model);
        return this;
    }

    /**
     * 设置 [动态数据看板名称]
     */
    public Dynadashboard setDynaDashboardName(String dynaDashboardName) {
        this.dynaDashboardName = dynaDashboardName;
        this.modify("dynadashboardname", dynaDashboardName);
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
            entity.reset("dynadashboardid");
        }
        return targetEntity;
    }

}