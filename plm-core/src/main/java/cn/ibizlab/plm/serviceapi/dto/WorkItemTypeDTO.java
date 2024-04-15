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
 * 工作项类型[WorkItemTypeDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工作项类型DTO")
public class WorkItemTypeDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @JsonProperty("sequence")
    @JSONField(name = "sequence")
    @ApiModelProperty(value = "序号", position = 0)
    private BigDecimal sequence;

    /**
     * 是否系统类型
     */
    @JsonProperty("is_system")
    @JSONField(name = "is_system")
    @ApiModelProperty(value = "是否系统类型", position = 1)
    private Integer isSystem;

    /**
     * 项目类型
     */
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "项目类型", position = 2)
    private String projectType;

    /**
     * 类型分组
     */
    @JsonProperty("group")
    @JSONField(name = "group")
    @ApiModelProperty(value = "类型分组", position = 3)
    private String group;

    /**
     * 编码
     */
    @JsonProperty("code")
    @JSONField(name = "code")
    @ApiModelProperty(value = "编码", position = 4)
    private String code;

    /**
     * 图标
     */
    @JsonProperty("icon")
    @JSONField(name = "icon")
    @ApiModelProperty(value = "图标", position = 5)
    private String icon;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 6)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 7)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 8)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 9)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 10)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 11)
    private Date updateTime;


    /**
     * 设置 [序号]
     */
    public WorkItemTypeDTO setSequence(BigDecimal sequence) {
        this.sequence = sequence;
        this.modify("sequence", sequence);
        return this;
    }

    /**
     * 设置 [是否系统类型]
     */
    public WorkItemTypeDTO setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public WorkItemTypeDTO setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [类型分组]
     */
    public WorkItemTypeDTO setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
     * 设置 [编码]
     */
    public WorkItemTypeDTO setCode(String code) {
        this.code = code;
        this.modify("code", code);
        return this;
    }

    /**
     * 设置 [图标]
     */
    public WorkItemTypeDTO setIcon(String icon) {
        this.icon = icon;
        this.modify("icon", icon);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public WorkItemTypeDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
