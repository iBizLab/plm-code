/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.ftr.domain;

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
 * 检索中心实体类[SearchHub]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SEARCH_HUB", description = "检索中心")
public class SearchHub extends EntityBase implements Serializable
{
    /**
     * 编号
     */
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 类型
     */
    @DEField(name = "type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "类型")
    private String type;

    /**
     * 所属
     */
    @DEField(name = "belong_to")
    @JSONField(name = "belong_to")
    @JsonProperty("belong_to")
    @ApiModelProperty(value = "belong_to", notes = "所属")
    private String belongTo;

    /**
     * 负责人
     */
    @DEField(name = "assignee_name")
    @JSONField(name = "assignee_name")
    @JsonProperty("assignee_name")
    @ApiModelProperty(value = "assignee_name", notes = "负责人")
    private String assigneeName;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 标签
     */
    @DEField(name = "tags")
    @JSONField(name = "tags")
    @JsonProperty("tags")
    @ApiModelProperty(value = "tags", notes = "标签")
    private String tags;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "名称")
    private String title;

    /**
    * 设置 [编号]
    */
    public SearchHub setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [类型]
    */
    public SearchHub setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [所属]
    */
    public SearchHub setBelongTo(String belongTo) {
        this.belongTo = belongTo;
        this.modify("belong_to", belongTo);
        return this;
    }

    /**
    * 设置 [负责人]
    */
    public SearchHub setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
        this.modify("assignee_name", assigneeName);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public SearchHub setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [标签]
    */
    public SearchHub setTags(String tags) {
        this.tags = tags;
        this.modify("tags", tags);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public SearchHub setTitle(String title) {
        this.title = title;
        this.modify("title", title);
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
            entity.reset("id");
        }
        return targetEntity;
    }

}