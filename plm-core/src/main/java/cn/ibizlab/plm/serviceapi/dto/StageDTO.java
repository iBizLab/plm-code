/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
 * 发布阶段[StageDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("发布阶段DTO")
public class StageDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 颜色
     */
    @JsonProperty("color")
    @JSONField(name = "color")
    @ApiModelProperty(value = "颜色", position = 0)
    private String color;

    /**
     * 是否发布当前阶段
     */
    @JsonProperty("is_current")
    @JSONField(name = "is_current")
    @ApiModelProperty(value = "是否发布当前阶段", position = 1)
    private Integer isCurrent;

    /**
     * 操作时间
     */
    @JsonProperty("operated_time")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "operated_time" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "操作时间", position = 2)
    private Date operatedTime;

    /**
     * 阶段类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "阶段类型", position = 3)
    private String type;

    /**
     * 父颜色
     */
    @JsonProperty("p_color")
    @JSONField(name = "p_color")
    @ApiModelProperty(value = "父颜色", position = 4)
    private String pColor;

    /**
     * 父阶段类型
     */
    @JsonProperty("p_type")
    @JSONField(name = "p_type")
    @ApiModelProperty(value = "父阶段类型", position = 5)
    private String pType;

    /**
     * 父阶段排序
     */
    @JsonProperty("p_sequence")
    @JSONField(name = "p_sequence")
    @ApiModelProperty(value = "父阶段排序", position = 6)
    private BigDecimal pSequence;

    /**
     * 排序
     */
    @JsonProperty("sequence")
    @JSONField(name = "sequence")
    @ApiModelProperty(value = "排序", position = 7)
    private BigDecimal sequence;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 8)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 9)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 10)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 11)
    private String name;

    /**
     * 父标识
     */
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "父标识", position = 12)
    private String pid;

    /**
     * 父名称
     */
    @JsonProperty("pname")
    @JSONField(name = "pname")
    @ApiModelProperty(value = "父名称", position = 13)
    private String pname;

    /**
     * 项目发布标识
     */
    @JsonProperty("release_id")
    @JSONField(name = "release_id")
    @ApiModelProperty(value = "项目发布标识", position = 14)
    private String releaseId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 15)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 16)
    private Date updateTime;


    /**
     * 设置 [颜色]
     */
    public StageDTO setColor(String color) {
        this.color = color;
        this.modify("color", color);
        return this;
    }

    /**
     * 设置 [是否发布当前阶段]
     */
    public StageDTO setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
        this.modify("is_current", isCurrent);
        return this;
    }

    /**
     * 设置 [操作时间]
     */
    public StageDTO setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
        this.modify("operated_time", operatedTime);
        return this;
    }

    /**
     * 设置 [阶段类型]
     */
    public StageDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [父颜色]
     */
    public StageDTO setPColor(String pColor) {
        this.pColor = pColor;
        this.modify("p_color", pColor);
        return this;
    }

    /**
     * 设置 [父阶段类型]
     */
    public StageDTO setPType(String pType) {
        this.pType = pType;
        this.modify("p_type", pType);
        return this;
    }

    /**
     * 设置 [父阶段排序]
     */
    public StageDTO setPSequence(BigDecimal pSequence) {
        this.pSequence = pSequence;
        this.modify("p_sequence", pSequence);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public StageDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public StageDTO setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
     * 设置 [父名称]
     */
    public StageDTO setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
        return this;
    }

    /**
     * 设置 [项目发布标识]
     */
    public StageDTO setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }


}
