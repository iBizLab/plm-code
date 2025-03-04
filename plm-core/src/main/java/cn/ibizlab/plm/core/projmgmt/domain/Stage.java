/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

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
import cn.ibizlab.plm.core.projmgmt.domain.Release;

/**
 * 发布阶段实体类[Stage]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "STAGE", resultMap = "StageResultMap")
@ApiModel(value = "STAGE", description = "发布阶段")
public class Stage extends EntityMP implements Serializable
{

    /**
    * 颜色
    */
    @TableField(value = "color")
    @DEField(name = "color")
    @JSONField(name = "color")
    @JsonProperty("color")
    @ApiModelProperty(value = "color", notes = "颜色")
    private String color;

    /**
    * 背景样式
    */
    @TableField(value = "style")
    @DEField(name = "style" , dict = "background_style")
    @JSONField(name = "style")
    @JsonProperty("style")
    @ApiModelProperty(value = "style", notes = "背景样式")
    private String style;

    /**
    * 是否发布当前阶段
    */
    @TableField(value = "is_current")
    @DEField(name = "is_current" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_current")
    @JsonProperty("is_current")
    @ApiModelProperty(value = "is_current", notes = "是否发布当前阶段")
    private Integer isCurrent;

    /**
    * 操作时间
    */
    @TableField(value = "operated_time")
    @DEField(name = "operated_time")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "operated_time" , format = "yyyy-MM-dd")
    @JsonProperty("operated_time")
    @ApiModelProperty(value = "operated_time", notes = "操作时间")
    private Date operatedTime;

    /**
    * 阶段类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "stage_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "阶段类型")
    private String type;

    /**
    * 父颜色
    */
    @TableField(value = "p_color" , exist = false)
    @DEField(name = "p_color")
    @JSONField(name = "p_color")
    @JsonProperty("p_color")
    @ApiModelProperty(value = "p_color", notes = "父颜色")
    private String pColor;

    /**
    * 父阶段类型
    */
    @TableField(value = "p_type" , exist = false)
    @DEField(name = "p_type" , dict = "stage_type")
    @JSONField(name = "p_type")
    @JsonProperty("p_type")
    @ApiModelProperty(value = "p_type", notes = "父阶段类型")
    private String pType;

    /**
    * 父阶段排序
    */
    @TableField(value = "p_sequence" , exist = false)
    @DEField(name = "p_sequence")
    @JSONField(name = "p_sequence")
    @JsonProperty("p_sequence")
    @ApiModelProperty(value = "p_sequence", notes = "父阶段排序")
    private BigDecimal pSequence;

    /**
    * 排序
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "排序")
    private BigDecimal sequence;

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
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name" , dupCheck = DupCheck.ALL , dupCheckField = "releaseId")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
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
    * 项目发布标识
    */
    @TableField(value = "release_id")
    @DEField(name = "release_id")
    @JSONField(name = "release_id")
    @JsonProperty("release_id")
    @ApiModelProperty(value = "release_id", notes = "项目发布标识")
    private String releaseId;

    /**
    * 父标识
    */
    @TableField(value = "pid")
    @DEField(name = "pid")
    @JSONField(name = "pid")
    @JsonProperty("pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
    * 父名称
    */
    @TableField(value = "pname" , exist = false)
    @DEField(name = "pname")
    @JSONField(name = "pname")
    @JsonProperty("pname")
    @ApiModelProperty(value = "pname", notes = "父名称")
    private String pname;

    /**
    * 项目发布
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "release", notes = "项目发布")
    private Release release;

    /**
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "stage", notes = "名称")
    private Stage stage;

    /**
    * 设置 [颜色]
    */
    public Stage setColor(String color) {
        this.color = color;
        this.modify("color", color);
        return this;
    }

    /**
    * 设置 [背景样式]
    */
    public Stage setStyle(String style) {
        this.style = style;
        this.modify("style", style);
        return this;
    }

    /**
    * 设置 [是否发布当前阶段]
    */
    public Stage setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
        this.modify("is_current", isCurrent);
        return this;
    }

    /**
    * 设置 [操作时间]
    */
    public Stage setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
        this.modify("operated_time", operatedTime);
        return this;
    }

    /**
    * 设置 [阶段类型]
    */
    public Stage setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [父颜色]
    */
    public Stage setPColor(String pColor) {
        this.pColor = pColor;
        this.modify("p_color", pColor);
        return this;
    }

    /**
    * 设置 [父阶段类型]
    */
    public Stage setPType(String pType) {
        this.pType = pType;
        this.modify("p_type", pType);
        return this;
    }

    /**
    * 设置 [父阶段排序]
    */
    public Stage setPSequence(BigDecimal pSequence) {
        this.pSequence = pSequence;
        this.modify("p_sequence", pSequence);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Stage setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [项目发布标识]
    */
    public Stage setReleaseId(String releaseId) {
        this.releaseId = releaseId;
        this.modify("release_id", releaseId);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public Stage setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
    * 设置 [父名称]
    */
    public Stage setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
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