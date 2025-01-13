/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.extension.domain;

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
import cn.ibizlab.plm.core.extension.domain.PSDENotify;

/**
 * 消息通知目标实体类[PSDENotifyTarget]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDENOTIFYTARGET", description = "消息通知目标")
public class PSDENotifyTarget extends EntityBase implements Serializable
{
    /**
     * 实体通知目标标识
     */
    @Id
    @DEField(name = "psdenotifytargetid" , isKeyField = true)
    @JSONField(name = "psdenotifytargetid")
    @JsonProperty("psdenotifytargetid")
    @ApiModelProperty(value = "psdenotifytargetid", notes = "实体通知目标标识")
    private String psdeNotifyTargetId;

    /**
     * 实体通知目标名称
     */
    @DEField(name = "psdenotifytargetname")
    @JSONField(name = "psdenotifytargetname")
    @JsonProperty("psdenotifytargetname")
    @ApiModelProperty(value = "psdenotifytargetname", notes = "实体通知目标名称")
    private String psdeNotifyTargetName;

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
     * 目标数据
     */
    @DEField(name = "data")
    @JSONField(name = "data")
    @JsonProperty("data")
    @ApiModelProperty(value = "data", notes = "目标数据")
    private String data;

    /**
     * 目标类型
     */
    @DEField(name = "targettype" , defaultValue = "DEFIELD" , dict = "DENotifyTargetType")
    @JSONField(name = "targettype")
    @JsonProperty("targettype")
    @ApiModelProperty(value = "targettype", notes = "目标类型")
    private String targetType;

    /**
     * 过滤项
     */
    @DEField(name = "filter")
    @JSONField(name = "filter")
    @JsonProperty("filter")
    @ApiModelProperty(value = "filter", notes = "过滤项")
    private String filter;

    /**
     * 实体通知
     */
    @DEField(name = "psdenotifyid")
    @JSONField(name = "psdenotifyid")
    @JsonProperty("psdenotifyid")
    @ApiModelProperty(value = "psdenotifyid", notes = "实体通知")
    private String psdeNotifyId;

    /**
     * 实体通知
     */
    @DEField(name = "psdenotifyname")
    @JSONField(name = "psdenotifyname")
    @JsonProperty("psdenotifyname")
    @ApiModelProperty(value = "psdenotifyname", notes = "实体通知")
    private String psdeNotifyName;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "psdenotify", notes = "")
    private PSDENotify psdeNotify;

    /**
    * 设置 [实体通知目标名称]
    */
    public PSDENotifyTarget setPsdeNotifyTargetName(String psdeNotifyTargetName) {
        this.psdeNotifyTargetName = psdeNotifyTargetName;
        this.modify("psdenotifytargetname", psdeNotifyTargetName);
        return this;
    }

    /**
    * 设置 [目标数据]
    */
    public PSDENotifyTarget setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
    * 设置 [目标类型]
    */
    public PSDENotifyTarget setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("targettype", targetType);
        return this;
    }

    /**
    * 设置 [过滤项]
    */
    public PSDENotifyTarget setFilter(String filter) {
        this.filter = filter;
        this.modify("filter", filter);
        return this;
    }

    /**
    * 设置 [实体通知]
    */
    public PSDENotifyTarget setPsdeNotifyId(String psdeNotifyId) {
        this.psdeNotifyId = psdeNotifyId;
        this.modify("psdenotifyid", psdeNotifyId);
        return this;
    }

    /**
    * 设置 [实体通知]
    */
    public PSDENotifyTarget setPsdeNotifyName(String psdeNotifyName) {
        this.psdeNotifyName = psdeNotifyName;
        this.modify("psdenotifyname", psdeNotifyName);
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
            entity.reset("psdenotifytargetid");
        }
        return targetEntity;
    }

}