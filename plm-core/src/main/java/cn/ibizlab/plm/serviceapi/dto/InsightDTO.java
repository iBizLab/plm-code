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
 * 洞察力[InsightDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("洞察力DTO")
public class InsightDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报表类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "报表类型", position = 0)
    private String type;

    /**
     * 描述
     */
    @JsonProperty("desc")
    @JSONField(name = "desc")
    @ApiModelProperty(value = "描述", position = 1)
    private String desc;

    /**
     * 组别
     */
    @JsonProperty("group")
    @JSONField(name = "group")
    @ApiModelProperty(value = "组别", position = 2)
    private String group;

    /**
     * 归属
     */
    @JsonProperty("belong")
    @JSONField(name = "belong")
    @ApiModelProperty(value = "归属", position = 3)
    private String belong;

    /**
     * 报表呈现视图
     */
    @JsonProperty("view_url")
    @JSONField(name = "view_url")
    @ApiModelProperty(value = "报表呈现视图", position = 4)
    private String viewUrl;

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
     * 设置 [报表类型]
     */
    public InsightDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public InsightDTO setDesc(String desc) {
        this.desc = desc;
        this.modify("desc", desc);
        return this;
    }

    /**
     * 设置 [组别]
     */
    public InsightDTO setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
     * 设置 [归属]
     */
    public InsightDTO setBelong(String belong) {
        this.belong = belong;
        this.modify("belong", belong);
        return this;
    }

    /**
     * 设置 [报表呈现视图]
     */
    public InsightDTO setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
        this.modify("view_url", viewUrl);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public InsightDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
