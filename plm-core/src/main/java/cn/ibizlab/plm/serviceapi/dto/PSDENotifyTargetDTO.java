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
 * 消息通知目标[PSDENotifyTargetDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("消息通知目标DTO")
public class PSDENotifyTargetDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 0)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 1)
    private Date createTime;

    /**
     * 目标数据
     */
    @JsonProperty("data")
    @JSONField(name = "data")
    @ApiModelProperty(value = "目标数据", position = 2)
    private String data;

    /**
     * 过滤项
     */
    @JsonProperty("filter")
    @JSONField(name = "filter")
    @ApiModelProperty(value = "过滤项", position = 3)
    private String filter;

    /**
     * 实体通知
     */
    @JsonProperty("psdenotifyid")
    @JSONField(name = "psdenotifyid")
    @ApiModelProperty(value = "实体通知", position = 4)
    private String psdeNotifyId;

    /**
     * 实体通知
     */
    @JsonProperty("psdenotifyname")
    @JSONField(name = "psdenotifyname")
    @ApiModelProperty(value = "实体通知", position = 5)
    private String psdeNotifyName;

    /**
     * 实体通知目标标识
     */
    @JsonProperty("psdenotifytargetid")
    @JSONField(name = "psdenotifytargetid")
    @ApiModelProperty(value = "实体通知目标标识", position = 6)
    private String psdeNotifyTargetId;

    /**
     * 实体通知目标名称
     */
    @JsonProperty("psdenotifytargetname")
    @JSONField(name = "psdenotifytargetname")
    @ApiModelProperty(value = "实体通知目标名称", position = 7)
    private String psdeNotifyTargetName;

    /**
     * 目标类型
     */
    @JsonProperty("targettype")
    @JSONField(name = "targettype")
    @ApiModelProperty(value = "目标类型", position = 8)
    private String targetType;

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
     * 设置 [目标数据]
     */
    public PSDENotifyTargetDTO setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
     * 设置 [过滤项]
     */
    public PSDENotifyTargetDTO setFilter(String filter) {
        this.filter = filter;
        this.modify("filter", filter);
        return this;
    }

    /**
     * 设置 [实体通知]
     */
    public PSDENotifyTargetDTO setPsdeNotifyId(String psdeNotifyId) {
        this.psdeNotifyId = psdeNotifyId;
        this.modify("psdenotifyid", psdeNotifyId);
        return this;
    }

    /**
     * 设置 [实体通知]
     */
    public PSDENotifyTargetDTO setPsdeNotifyName(String psdeNotifyName) {
        this.psdeNotifyName = psdeNotifyName;
        this.modify("psdenotifyname", psdeNotifyName);
        return this;
    }

    /**
     * 设置 [实体通知目标名称]
     */
    public PSDENotifyTargetDTO setPsdeNotifyTargetName(String psdeNotifyTargetName) {
        this.psdeNotifyTargetName = psdeNotifyTargetName;
        this.modify("psdenotifytargetname", psdeNotifyTargetName);
        return this;
    }

    /**
     * 设置 [目标类型]
     */
    public PSDENotifyTargetDTO setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("targettype", targetType);
        return this;
    }


}
