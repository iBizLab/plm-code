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
 * 流转记录[TransitionHistoryDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("流转记录DTO")
public class TransitionHistoryDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 0)
    private String ownerId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 1)
    private String ownerType;

    /**
     * 所属对象子类型
     */
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "所属对象子类型", position = 2)
    private String ownerSubtype;

    /**
     * 源状态
     */
    @JsonProperty("from_state")
    @JSONField(name = "from_state")
    @ApiModelProperty(value = "源状态", position = 3)
    private String fromState;

    /**
     * 目标状态
     */
    @JsonProperty("to_state")
    @JSONField(name = "to_state")
    @ApiModelProperty(value = "目标状态", position = 4)
    private String toState;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 5)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 6)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 7)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 8)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 9)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 10)
    private Date updateTime;


    /**
     * 设置 [源状态]
     */
    public TransitionHistoryDTO setFromState(String fromState) {
        this.fromState = fromState;
        this.modify("from_state", fromState);
        return this;
    }

    /**
     * 设置 [目标状态]
     */
    public TransitionHistoryDTO setToState(String toState) {
        this.toState = toState;
        this.modify("to_state", toState);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public TransitionHistoryDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
