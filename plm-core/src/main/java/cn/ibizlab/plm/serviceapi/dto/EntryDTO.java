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
 * 看板栏[EntryDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("看板栏DTO")
public class EntryDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排序
     */
    @JsonProperty("show_order")
    @JSONField(name = "show_order")
    @ApiModelProperty(value = "排序", position = 0)
    private Integer showOrder;

    /**
     * 是否系统标记
     */
    @JsonProperty("is_system")
    @JSONField(name = "is_system")
    @ApiModelProperty(value = "是否系统标记", position = 1)
    private Integer isSystem;

    /**
     * 是否将看板栏拆分为进行中和已完成
     */
    @JsonProperty("is_split")
    @JSONField(name = "is_split")
    @ApiModelProperty(value = "是否将看板栏拆分为进行中和已完成", position = 2)
    private Integer isSplit;

    /**
     * 看板标识
     */
    @JsonProperty("board_id")
    @JSONField(name = "board_id")
    @ApiModelProperty(value = "看板标识", position = 3)
    private String boardId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 4)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 5)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 6)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 7)
    private String name;

    /**
     * 项目标识
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目标识", position = 8)
    private String projectId;

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
     * 设置 [排序]
     */
    public EntryDTO setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
        this.modify("show_order", showOrder);
        return this;
    }

    /**
     * 设置 [是否系统标记]
     */
    public EntryDTO setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
     * 设置 [是否将看板栏拆分为进行中和已完成]
     */
    public EntryDTO setIsSplit(Integer isSplit) {
        this.isSplit = isSplit;
        this.modify("is_split", isSplit);
        return this;
    }

    /**
     * 设置 [看板标识]
     */
    public EntryDTO setBoardId(String boardId) {
        this.boardId = boardId;
        this.modify("board_id", boardId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public EntryDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public EntryDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }


}
