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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemState;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 工作项类型实体类[WorkItemType]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "WORK_ITEM_TYPE", resultMap = "WorkItemTypeResultMap")
@ApiModel(value = "WORK_ITEM_TYPE", description = "工作项类型")
public class WorkItemType extends EntityMP implements Serializable
{

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence")
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 是否系统类型
    */
    @TableField(value = "is_system")
    @DEField(name = "is_system" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_system")
    @JsonProperty("is_system")
    @ApiModelProperty(value = "is_system", notes = "是否系统类型")
    private Integer isSystem;

    /**
    * 项目类型
    */
    @TableField(value = "project_type")
    @DEField(name = "project_type" , dict = "project_type")
    @JSONField(name = "project_type")
    @JsonProperty("project_type")
    @ApiModelProperty(value = "project_type", notes = "项目类型")
    private String projectType;

    /**
    * 类型分组
    */
    @TableField(value = "group")
    @DEField(name = "group" , dict = "work_item_type_group")
    @JSONField(name = "group")
    @JsonProperty("group")
    @ApiModelProperty(value = "group", notes = "类型分组")
    private String group;

    /**
    * 编码
    */
    @TableField(value = "code")
    @DEField(name = "code")
    @JSONField(name = "code")
    @JsonProperty("code")
    @ApiModelProperty(value = "code", notes = "编码")
    private String code;

    /**
    * 图标
    */
    @TableField(value = "icon")
    @DEField(name = "icon")
    @JSONField(name = "icon")
    @JsonProperty("icon")
    @ApiModelProperty(value = "icon", notes = "图标")
    private String icon;

    /**
    * 下级类型
    */
    @TableField(value = "sub_type")
    @DEField(name = "sub_type")
    @JSONField(name = "sub_type")
    @JsonProperty("sub_type")
    @ApiModelProperty(value = "sub_type", notes = "下级类型")
    private String subType;

    /**
    * 原始状态
    */
    @TableField(value = "orgin_state")
    @DEField(name = "orgin_state")
    @JSONField(name = "orgin_state")
    @JsonProperty("orgin_state")
    @ApiModelProperty(value = "orgin_state", notes = "原始状态")
    private String orginState;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , defaultValue = "code" , defaultValueType = DEFieldDefaultValueType.PARAM , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name" , dupCheck = DupCheck.ALL , dupCheckField = "projectType")
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
    * 项目标识
    */
    @TableField(value = "project_id")
    @DEField(name = "project_id")
    @JSONField(name = "project_id")
    @JsonProperty("project_id")
    @ApiModelProperty(value = "project_id", notes = "项目标识")
    private String projectId;

    /**
    * 项目-工作项类型
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "项目-工作项类型")
    private Project project;

    /**
    * 设置 [序号]
    */
    public WorkItemType setSequence(BigDecimal sequence) {
        this.sequence = sequence;
        this.modify("sequence", sequence);
        return this;
    }

    /**
    * 设置 [是否系统类型]
    */
    public WorkItemType setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
        this.modify("is_system", isSystem);
        return this;
    }

    /**
    * 设置 [项目类型]
    */
    public WorkItemType setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
    * 设置 [类型分组]
    */
    public WorkItemType setGroup(String group) {
        this.group = group;
        this.modify("group", group);
        return this;
    }

    /**
    * 设置 [编码]
    */
    public WorkItemType setCode(String code) {
        this.code = code;
        this.modify("code", code);
        return this;
    }

    /**
    * 设置 [图标]
    */
    public WorkItemType setIcon(String icon) {
        this.icon = icon;
        this.modify("icon", icon);
        return this;
    }

    /**
    * 设置 [下级类型]
    */
    public WorkItemType setSubType(String subType) {
        this.subType = subType;
        this.modify("sub_type", subType);
        return this;
    }

    /**
    * 设置 [原始状态]
    */
    public WorkItemType setOrginState(String orginState) {
        this.orginState = orginState;
        this.modify("orgin_state", orginState);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public WorkItemType setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [项目标识]
    */
    public WorkItemType setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
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