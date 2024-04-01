/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 洞察力实体类[Insight]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "INSIGHT", resultMap = "InsightResultMap")
@ApiModel(value = "INSIGHT", description = "洞察力")
public class Insight extends EntityMP implements Serializable
{

    /**
     * 报表类型
     */
    @TableField(value = "type")
    @DEField(name = "type")
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "type", notes = "报表类型")
    private String type;

    /**
     * 描述
     */
    @TableField(value = "desc")
    @DEField(name = "desc")
    @JsonProperty("desc")
    @JSONField(name = "desc")
    @ApiModelProperty(value = "desc", notes = "描述")
    private String desc;

    /**
     * 组别
     */
    @TableField(value = "group")
    @DEField(name = "group" , dict = "Insight_group")
    @JsonProperty("group")
    @JSONField(name = "group")
    @ApiModelProperty(value = "group", notes = "组别")
    private String group;

    /**
     * 归属
     */
    @TableField(value = "belong")
    @DEField(name = "belong")
    @JsonProperty("belong")
    @JSONField(name = "belong")
    @ApiModelProperty(value = "belong", notes = "归属")
    private String belong;

    /**
     * 报表呈现视图
     */
    @TableField(value = "view_url")
    @DEField(name = "view_url")
    @JsonProperty("view_url")
    @JSONField(name = "view_url")
    @ApiModelProperty(value = "view_url", notes = "报表呈现视图")
    private String viewUrl;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 建立时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 标识
     */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 设置 [报表类型]
     */
    public Insight setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public Insight setDesc(String desc) {
        this.desc = desc;
        this.modify("desc", desc);
        return this;
    }

    /**
     * 设置 [组别]
     */
    public Insight setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
     * 设置 [归属]
     */
    public Insight setBelong(String belong) {
        this.belong = belong;
        this.modify("belong", belong);
        return this;
    }

    /**
     * 设置 [报表呈现视图]
     */
    public Insight setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
        this.modify("view_url", viewUrl);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public Insight setName(String name) {
        this.name = name;
        this.modify("name", name);
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