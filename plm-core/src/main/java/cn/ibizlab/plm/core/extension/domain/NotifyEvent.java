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

/**
 * 通知事件实体类[NotifyEvent]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "NOTIFY_EVENT", description = "通知事件")
public class NotifyEvent extends EntityBase implements Serializable
{
    /**
     * 消息类型
     */
    @DEField(name = "msg_type" , dict = "WFInfomMsgType")
    @JSONField(name = "msg_type")
    @JsonProperty("msg_type")
    @ApiModelProperty(value = "msg_type", notes = "消息类型")
    private Integer msgType;

    /**
     * 事件分类
     */
    @DEField(name = "group")
    @JSONField(name = "group")
    @JsonProperty("group")
    @ApiModelProperty(value = "group", notes = "事件分类")
    private String group;

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
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 设置 [消息类型]
    */
    public NotifyEvent setMsgType(Integer msgType) {
        this.msgType = msgType;
        this.modify("msg_type", msgType);
        return this;
    }

    /**
    * 设置 [事件分类]
    */
    public NotifyEvent setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public NotifyEvent setName(String name) {
        this.name = name;
        this.modify("name", name);
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