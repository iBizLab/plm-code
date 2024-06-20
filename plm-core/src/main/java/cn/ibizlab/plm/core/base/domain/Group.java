/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.base.domain.Member;

/**
 * 团队实体类[Group]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "USER_GROUP", resultMap = "GroupResultMap")
@ApiModel(value = "GROUP", description = "团队")
public class Group extends EntityMP implements Serializable
{

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , defaultValue = "1")
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 描述
    */
    @TableField(value = "description")
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
    * 团队头像
    */
    @TableField(value = "avatar")
    @DEField(name = "avatar")
    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    @ApiModelProperty(value = "avatar", notes = "团队头像")
    private String avatar;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 团队名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "团队名称")
    private String name;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 分组标识
    */
    @TableField(value = "section_id")
    @DEField(name = "section_id")
    @JSONField(name = "section_id")
    @JsonProperty("section_id")
    @ApiModelProperty(value = "section_id", notes = "分组标识")
    private String sectionId;

    /**
    * 所属分组
    */
    @TableField(value = "section_name" , exist = false)
    @DEField(name = "section_name")
    @JSONField(name = "section_name")
    @JsonProperty("section_name")
    @ApiModelProperty(value = "section_name", notes = "所属分组")
    private String sectionName;

    /**
    * 分组
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "section", notes = "分组")
    private Section section;

    /**
    * 设置 [序号]
    */
    public Group setSequence(BigDecimal sequence) {
        this.sequence = sequence;
        this.modify("sequence", sequence);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Group setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [团队头像]
    */
    public Group setAvatar(String avatar) {
        this.avatar = avatar;
        this.modify("avatar", avatar);
        return this;
    }

    /**
    * 设置 [团队名称]
    */
    public Group setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [分组标识]
    */
    public Group setSectionId(String sectionId) {
        this.sectionId = sectionId;
        this.modify("section_id", sectionId);
        return this;
    }

    /**
    * 设置 [所属分组]
    */
    public Group setSectionName(String sectionName) {
        this.sectionName = sectionName;
        this.modify("section_name", sectionName);
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