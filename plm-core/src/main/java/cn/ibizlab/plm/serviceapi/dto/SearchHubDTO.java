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
 * 检索中心[SearchHubDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("检索中心DTO")
public class SearchHubDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 0)
    private String identifier;

    /**
     * 类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "类型", position = 1)
    private String type;

    /**
     * 所属
     */
    @JsonProperty("belong_to")
    @JSONField(name = "belong_to")
    @ApiModelProperty(value = "所属", position = 2)
    private String belongTo;

    /**
     * 负责人
     */
    @JsonProperty("assignee_name")
    @JSONField(name = "assignee_name")
    @ApiModelProperty(value = "负责人", position = 3)
    private String assigneeName;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 4)
    private String description;

    /**
     * 标签
     */
    @JsonProperty("tags")
    @JSONField(name = "tags")
    @ApiModelProperty(value = "标签", position = 5)
    private String tags;

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
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "名称", position = 7)
    private String title;


    /**
     * 设置 [编号]
     */
    public SearchHubDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [类型]
     */
    public SearchHubDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [所属]
     */
    public SearchHubDTO setBelongTo(String belongTo) {
        this.belongTo = belongTo;
        this.modify("belong_to", belongTo);
        return this;
    }

    /**
     * 设置 [负责人]
     */
    public SearchHubDTO setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public SearchHubDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [标签]
     */
    public SearchHubDTO setTags(String tags) {
        this.tags = tags;
        this.modify("tags", tags);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public SearchHubDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }


}
