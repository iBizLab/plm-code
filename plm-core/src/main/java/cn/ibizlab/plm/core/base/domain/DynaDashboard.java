/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.insight.domain.InsightView;

/**
 * 动态数据看板实体类[DynaDashboard]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "DYNADASHBOARD", resultMap = "DynaDashboardResultMap")
@ApiModel(value = "DYNADASHBOARD", description = "动态数据看板")
public class DynaDashboard extends EntityMP implements Serializable
{

    /**
    * 是否系统类型
    */
    @TableField(value = "is_system")
    @DEField(name = "is_system" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_system")
    @JsonProperty("is_system")
    @ApiModelProperty(value = "is_system", notes = "是否系统类型")
    private Integer isSystem;

    /**
    * 看板类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , defaultValue = "personal" , dict = "UsrCodeList0424934582")
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
    * 描述
    */
    @TableField(value = "desc")
    @DEField(name = "desc")
    @JSONField(name = "desc")
    @JsonProperty("desc")
    @ApiModelProperty(value = "desc", notes = "描述")
    private String desc;

    /**
    * 示例图
    */
    @TableField(value = "example_chart")
    @DEField(name = "example_chart")
    @JSONField(name = "example_chart")
    @JsonProperty("example_chart")
    @ApiModelProperty(value = "example_chart", notes = "示例图")
    private String exampleChart;

    /**
    * 序号
    */
    @TableField(value = "sequences")
    @DEField(name = "sequences" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "sequences")
    @JsonProperty("sequences")
    @ApiModelProperty(value = "sequences", notes = "序号")
    private BigDecimal sequences;

    /**
    * 动态数据看板标识
    */
    @Id
    @TableId(value = "dynadashboardid" , type = IdType.ASSIGN_UUID)
    @DEField(name = "dynadashboardid" , isKeyField = true)
    @JSONField(name = "dynadashboardid")
    @JsonProperty("dynadashboardid")
    @ApiModelProperty(value = "dynadashboardid", notes = "动态数据看板标识")
    private String dynaDashboardId;

    /**
    * 名称
    */
    @TableField(value = "dynadashboardname")
    @DEField(name = "dynadashboardname")
    @JSONField(name = "dynadashboardname")
    @JsonProperty("dynadashboardname")
    @ApiModelProperty(value = "dynadashboardname", notes = "名称")
    private String dynaDashboardName;

    /**
    * 建立人
    */
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

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
    * 应用标识
    */
    @TableField(value = "appid")
    @DEField(name = "appid")
    @JSONField(name = "appid")
    @JsonProperty("appid")
    @ApiModelProperty(value = "appid", notes = "应用标识")
    private String appId;

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
    * 效能视图-动态报表
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "insight_view", notes = "效能视图-动态报表")
    private InsightView insightView;

    /**
    * 设置 [是否系统类型]
    */
    public DynaDashboard setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
    * 设置 [看板类型]
    */
    public DynaDashboard setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [所属数据类型]
    */
    public DynaDashboard setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [所属数据标识]
    */
    public DynaDashboard setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("owner_id", ownerId);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public DynaDashboard setDesc(String desc) {
        this.desc = desc;
        this.modify("desc", desc);
        return this;
    }

    /**
    * 设置 [示例图]
    */
    public DynaDashboard setExampleChart(String exampleChart) {
        this.exampleChart = exampleChart;
        this.modify("example_chart", exampleChart);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public DynaDashboard setDynaDashboardName(String dynaDashboardName) {
        this.dynaDashboardName = dynaDashboardName;
        this.modify("dynadashboardname", dynaDashboardName);
        return this;
    }

    /**
    * 设置 [用户标识]
    */
    public DynaDashboard setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
    * 设置 [模型标识]
    */
    public DynaDashboard setModelId(String modelId) {
        this.modelId = modelId;
        this.modify("modelid", modelId);
        return this;
    }

    /**
    * 设置 [应用标识]
    */
    public DynaDashboard setAppId(String appId) {
        this.appId = appId;
        this.modify("appid", appId);
        return this;
    }

    /**
    * 设置 [模型]
    */
    public DynaDashboard setModel(String model) {
        this.model = model;
        this.modify("model", model);
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