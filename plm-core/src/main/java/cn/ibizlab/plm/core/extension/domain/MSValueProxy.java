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

/**
 * 主状态值代理实体类[MSValueProxy]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "MSVALUEPROXY", description = "主状态值代理")
public class MSValueProxy extends EntityBase implements Serializable
{
    /**
     * 颜色
     */
    @DEField(name = "color")
    @JSONField(name = "color")
    @JsonProperty("color")
    @ApiModelProperty(value = "color", notes = "颜色")
    private String color;

    /**
     * 背景颜色
     */
    @DEField(name = "bkcolor")
    @JSONField(name = "bkcolor")
    @JsonProperty("bkcolor")
    @ApiModelProperty(value = "bkcolor", notes = "背景颜色")
    private String bkColor;

    /**
     * 主状态值代理标识
     */
    @Id
    @DEField(name = "msvalueproxyid" , isKeyField = true)
    @JSONField(name = "msvalueproxyid")
    @JsonProperty("msvalueproxyid")
    @ApiModelProperty(value = "msvalueproxyid", notes = "主状态值代理标识")
    private String msValueProxyId;

    /**
     * 主状态值代理名称
     */
    @DEField(name = "msvalueproxyname")
    @JSONField(name = "msvalueproxyname")
    @JsonProperty("msvalueproxyname")
    @ApiModelProperty(value = "msvalueproxyname", notes = "主状态值代理名称")
    private String msValueProxyName;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
    * 设置 [颜色]
    */
    public MSValueProxy setColor(String color) {
        this.color = color;
        this.modify("color", color);
        return this;
    }

    /**
    * 设置 [背景颜色]
    */
    public MSValueProxy setBkColor(String bkColor) {
        this.bkColor = bkColor;
        this.modify("bkcolor", bkColor);
        return this;
    }

    /**
    * 设置 [主状态值代理名称]
    */
    public MSValueProxy setMsValueProxyName(String msValueProxyName) {
        this.msValueProxyName = msValueProxyName;
        this.modify("msvalueproxyname", msValueProxyName);
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
            entity.reset("msvalueproxyid");
        }
        return targetEntity;
    }

}