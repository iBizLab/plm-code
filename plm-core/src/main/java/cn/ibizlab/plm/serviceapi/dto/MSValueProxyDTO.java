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
 * 主状态值代理[MSValueProxyDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("主状态值代理DTO")
public class MSValueProxyDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 颜色
     */
    @JsonProperty("color")
    @JSONField(name = "color")
    @ApiModelProperty(value = "颜色", position = 0)
    private String color;

    /**
     * 背景颜色
     */
    @JsonProperty("bkcolor")
    @JSONField(name = "bkcolor")
    @ApiModelProperty(value = "背景颜色", position = 1)
    private String bkColor;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 2)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 3)
    private String createMan;

    /**
     * 主状态值代理标识
     */
    @JsonProperty("msvalueproxyid")
    @JSONField(name = "msvalueproxyid")
    @ApiModelProperty(value = "主状态值代理标识", position = 4)
    private String msValueProxyId;

    /**
     * 主状态值代理名称
     */
    @JsonProperty("msvalueproxyname")
    @JSONField(name = "msvalueproxyname")
    @ApiModelProperty(value = "主状态值代理名称", position = 5)
    private String msValueProxyName;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 6)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 7)
    private String updateMan;


    /**
     * 设置 [颜色]
     */
    public MSValueProxyDTO setColor(String color) {
        this.color = color;
        this.modify("color", color);
        return this;
    }

    /**
     * 设置 [背景颜色]
     */
    public MSValueProxyDTO setBkColor(String bkColor) {
        this.bkColor = bkColor;
        this.modify("bkcolor", bkColor);
        return this;
    }

    /**
     * 设置 [主状态值代理名称]
     */
    public MSValueProxyDTO setMsValueProxyName(String msValueProxyName) {
        this.msValueProxyName = msValueProxyName;
        this.modify("msvalueproxyname", msValueProxyName);
        return this;
    }


}
