/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemWizard;

/**
 * 工作项操作向导明细实体类[WorkItemWizardDetail]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "WORK_ITEM_WIZARD_DETAIL", description = "工作项操作向导明细")
public class WorkItemWizardDetail extends EntityBase implements Serializable
{
    /**
     * 源类型
     */
    @DEField(name = "origin_type" , dict = "work_item_type")
    @JSONField(name = "origin_type")
    @JsonProperty("origin_type")
    @ApiModelProperty(value = "origin_type", notes = "源类型")
    private String originType;

    /**
     * 目标类型
     */
    @DEField(name = "target_type" , dict = "work_item_type")
    @JSONField(name = "target_type")
    @JsonProperty("target_type")
    @ApiModelProperty(value = "target_type", notes = "目标类型")
    private String targetType;

    /**
     * 状态变更
     */
    @DEField(name = "states")
    @JSONField(name = "states")
    @JsonProperty("states")
    @ApiModelProperty(value = "states", notes = "状态变更")
    private List<Map> states;

    /**
     * 子工作项类型
     */
    @DEField(name = "child_work_item_types")
    @JSONField(name = "child_work_item_types")
    @JsonProperty("child_work_item_types")
    @ApiModelProperty(value = "child_work_item_types", notes = "子工作项类型")
    private List<Map> childWorkItemTypes;

    /**
     * 属性补充集合
     */
    @DEField(name = "properties")
    @JSONField(name = "properties")
    @JsonProperty("properties")
    @ApiModelProperty(value = "properties", notes = "属性补充集合")
    private List<Map> properties;

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
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 向导标识
     */
    @DEField(name = "wizard_id")
    @JSONField(name = "wizard_id")
    @JsonProperty("wizard_id")
    @ApiModelProperty(value = "wizard_id", notes = "向导标识")
    private String wizardId;

    /**
     * 工作项操作向导-明细
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item_wizard", notes = "工作项操作向导-明细")
    private WorkItemWizard workItemWizard;

    /**
    * 设置 [源类型]
    */
    public WorkItemWizardDetail setOriginType(String originType) {
        this.originType = originType;
        this.modify("origin_type", originType);
        return this;
    }

    /**
    * 设置 [目标类型]
    */
    public WorkItemWizardDetail setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
    * 设置 [状态变更]
    */
    public WorkItemWizardDetail setStates(List<Map> states) {
        this.states = states;
        this.modify("states", states);
        return this;
    }

    /**
    * 设置 [子工作项类型]
    */
    public WorkItemWizardDetail setChildWorkItemTypes(List<Map> childWorkItemTypes) {
        this.childWorkItemTypes = childWorkItemTypes;
        this.modify("child_work_item_types", childWorkItemTypes);
        return this;
    }

    /**
    * 设置 [属性补充集合]
    */
    public WorkItemWizardDetail setProperties(List<Map> properties) {
        this.properties = properties;
        this.modify("properties", properties);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public WorkItemWizardDetail setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [向导标识]
    */
    public WorkItemWizardDetail setWizardId(String wizardId) {
        this.wizardId = wizardId;
        this.modify("wizard_id", wizardId);
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