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
 * 通知事件[NotifyEventDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("通知事件DTO")
public class NotifyEventDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息类型
     */
    @JsonProperty("msg_type")
    @JSONField(name = "msg_type")
    @ApiModelProperty(value = "消息类型", position = 0)
    private Integer msgType;

    /**
     * 事件分类
     */
    @JsonProperty("group")
    @JSONField(name = "group")
    @ApiModelProperty(value = "事件分类", position = 1)
    private String group;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 2)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 3)
    private String name;


    /**
     * 设置 [消息类型]
     */
    public NotifyEventDTO setMsgType(Integer msgType) {
        this.msgType = msgType;
        this.modify("msg_type", msgType);
        return this;
    }

    /**
     * 设置 [事件分类]
     */
    public NotifyEventDTO setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public NotifyEventDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
