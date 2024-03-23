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
 * 动态数据看板[DynadashboardDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("动态数据看板DTO")
public class DynadashboardDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 应用标识
     */
    @JsonProperty("appid")
    @JSONField(name = "appid")
    @ApiModelProperty(value = "应用标识", position = 0)
    private String appId;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 1)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 2)
    private String createMan;

    /**
     * 动态数据看板标识
     */
    @JsonProperty("dynadashboardid")
    @JSONField(name = "dynadashboardid")
    @ApiModelProperty(value = "动态数据看板标识", position = 3)
    private String dynaDashboardId;

    /**
     * 动态数据看板名称
     */
    @JsonProperty("dynadashboardname")
    @JSONField(name = "dynadashboardname")
    @ApiModelProperty(value = "动态数据看板名称", position = 4)
    private String dynaDashboardName;

    /**
     * 模型
     */
    @JsonProperty("model")
    @JSONField(name = "model")
    @ApiModelProperty(value = "模型", position = 5)
    private String model;

    /**
     * 模型标识
     */
    @JsonProperty("modelid")
    @JSONField(name = "modelid")
    @ApiModelProperty(value = "模型标识", position = 6)
    private String modelId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 7)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 8)
    private Date updateTime;

    /**
     * 用户标识
     */
    @JsonProperty("userid")
    @JSONField(name = "userid")
    @ApiModelProperty(value = "用户标识", position = 9)
    private String userId;


    /**
     * 设置 [应用标识]
     */
    public DynadashboardDTO setAppId(String appId) {
        this.appId = appId;
        this.modify("appid", appId);
        return this;
    }

    /**
     * 设置 [动态数据看板名称]
     */
    public DynadashboardDTO setDynaDashboardName(String dynaDashboardName) {
        this.dynaDashboardName = dynaDashboardName;
        this.modify("dynadashboardname", dynaDashboardName);
        return this;
    }

    /**
     * 设置 [模型]
     */
    public DynadashboardDTO setModel(String model) {
        this.model = model;
        this.modify("model", model);
        return this;
    }

    /**
     * 设置 [模型标识]
     */
    public DynadashboardDTO setModelId(String modelId) {
        this.modelId = modelId;
        this.modify("modelid", modelId);
        return this;
    }

    /**
     * 设置 [用户标识]
     */
    public DynadashboardDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }


}
