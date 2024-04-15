/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
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
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 实体通知目标名称
     */
    @DEField(name = "psdenotifytargetname")
    @JsonProperty("psdenotifytargetname")
    @JSONField(name = "psdenotifytargetname")
    @ApiModelProperty(value = "psdenotifytargetname", notes = "实体通知目标名称")
    private String psdeNotifyTargetName;

    /**
     * 实体通知目标标识
     */
    @Id
    @DEField(name = "psdenotifytargetid" , isKeyField = true)
    @JsonProperty("psdenotifytargetid")
    @JSONField(name = "psdenotifytargetid")
    @ApiModelProperty(value = "psdenotifytargetid", notes = "实体通知目标标识")
    private String psdeNotifyTargetId;

    /**
     * 目标数据
     */
    @DEField(name = "data")
    @JsonProperty("data")
    @JSONField(name = "data")
    @ApiModelProperty(value = "data", notes = "目标数据")
    private String data;

    /**
     * 目标类型
     */
    @DEField(name = "targettype" , defaultValue = "DEFIELD" , dict = "DENotifyTargetType")
    @JsonProperty("targettype")
    @JSONField(name = "targettype")
    @ApiModelProperty(value = "targettype", notes = "目标类型")
    private String targetType;

    /**
     * 过滤项
     */
    @DEField(name = "filter")
    @JsonProperty("filter")
    @JSONField(name = "filter")
    @ApiModelProperty(value = "filter", notes = "过滤项")
    private String filter;

    /**
     * 实体通知
     */
    @DEField(name = "psdenotifyid")
    @JsonProperty("psdenotifyid")
    @JSONField(name = "psdenotifyid")
    @ApiModelProperty(value = "psdenotifyid", notes = "实体通知")
    private String psdeNotifyId;

    /**
     * 实体通知
     */
    @DEField(name = "psdenotifyname")
    @JsonProperty("psdenotifyname")
    @JSONField(name = "psdenotifyname")
    @ApiModelProperty(value = "psdenotifyname", notes = "实体通知")
    private String psdeNotifyName;

    /**
     * 实体通知
     */
    @JSONField(name = "psdenotify")
    @JsonProperty("psdenotify")
    @ApiModelProperty(value = "psdenotify", notes = "")
    private PSDENotify psdeNotify;


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