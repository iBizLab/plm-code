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
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 版本实体类[Version]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "VERSION", resultMap = "VersionResultMap")
@ApiModel(value = "VERSION", description = "版本")
public class Version extends EntityMP implements Serializable
{

    /**
     * 描述
     */
    @TableField(value = "description")
    @DEField(name = "description")
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 所属数据标识
     */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id" , preType = DEPredefinedFieldType.PARENTID)
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
     * 所属数据对象
     */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 版本
     */
    @TableField(value = "identifier")
    @DEField(name = "identifier")
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "identifier", notes = "版本")
    private BigDecimal identifier;

    /**
     * 所属对象版本标识
     */
    @TableField(value = "owner_version_id")
    @DEField(name = "owner_version_id" , preType = DEPredefinedFieldType.PARENTVERSIONID)
    @JsonProperty("owner_version_id")
    @JSONField(name = "owner_version_id")
    @ApiModelProperty(value = "owner_version_id", notes = "所属对象版本标识")
    private String ownerVersionId;

    /**
     * 数据
     */
    @TableField(value = "data")
    @DEField(name = "data")
    @JsonProperty("data")
    @JSONField(name = "data")
    @ApiModelProperty(value = "data", notes = "数据")
    private String data;

    /**
     * 支持恢复
     */
    @TableField(value = "restorable")
    @DEField(name = "restorable")
    @JsonProperty("restorable")
    @JSONField(name = "restorable")
    @ApiModelProperty(value = "restorable", notes = "支持恢复")
    private String restorable;

    /**
     * 手动提交
     */
    @TableField(value = "manual")
    @DEField(name = "manual" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("manual")
    @JSONField(name = "manual")
    @ApiModelProperty(value = "manual", notes = "手动提交")
    private Integer manual;

    /**
     * 过滤属性
     */
    @TableField(value = "filter")
    @DEField(name = "filter")
    @JsonProperty("filter")
    @JSONField(name = "filter")
    @ApiModelProperty(value = "filter", notes = "过滤属性")
    private String filter;

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
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

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
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 页面
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "page", notes = "页面-版本")
    private ArticlePage page;

    /**
     * 工作项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "work_item", notes = "工作项-版本")
    private WorkItem workItem;

    /**
     * 设置 [描述]
     */
    public Version setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [版本]
     */
    public Version setIdentifier(BigDecimal identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [数据]
     */
    public Version setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
     * 设置 [支持恢复]
     */
    public Version setRestorable(String restorable) {
        this.restorable = restorable;
        this.modify("restorable", restorable);
        return this;
    }

    /**
     * 设置 [手动提交]
     */
    public Version setManual(Integer manual) {
        this.manual = manual;
        this.modify("manual", manual);
        return this;
    }

    /**
     * 设置 [过滤属性]
     */
    public Version setFilter(String filter) {
        this.filter = filter;
        this.modify("filter", filter);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public Version setName(String name) {
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