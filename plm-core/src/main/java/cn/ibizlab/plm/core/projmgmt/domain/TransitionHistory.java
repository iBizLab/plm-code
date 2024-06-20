/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

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
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 流转记录实体类[TransitionHistory]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "TRANSITION_HISTORY", resultMap = "TransitionHistoryResultMap")
@ApiModel(value = "TRANSITION_HISTORY", description = "流转记录")
public class TransitionHistory extends EntityMP implements Serializable
{

    /**
    * 所属数据标识
    */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id" , preType = DEPredefinedFieldType.PARENTID)
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
    * 所属数据对象
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
    * 所属对象子类型
    */
    @TableField(value = "owner_subtype")
    @DEField(name = "owner_subtype" , preType = DEPredefinedFieldType.PARENTSUBTYPE)
    @JSONField(name = "owner_subtype")
    @JsonProperty("owner_subtype")
    @ApiModelProperty(value = "owner_subtype", notes = "所属对象子类型")
    private String ownerSubtype;

    /**
    * 源状态
    */
    @TableField(value = "from_state")
    @DEField(name = "from_state" , defaultValue = "10")
    @JSONField(name = "from_state")
    @JsonProperty("from_state")
    @ApiModelProperty(value = "from_state", notes = "源状态")
    private String fromState;

    /**
    * 目标状态
    */
    @TableField(value = "to_state")
    @DEField(name = "to_state" , defaultValue = "10")
    @JSONField(name = "to_state")
    @JsonProperty("to_state")
    @ApiModelProperty(value = "to_state", notes = "目标状态")
    private String toState;

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
    @DEField(name = "name")
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
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item", notes = "名称")
    private WorkItem workItem;

    /**
    * 设置 [源状态]
    */
    public TransitionHistory setFromState(String fromState) {
        this.fromState = fromState;
        this.modify("from_state", fromState);
        return this;
    }

    /**
    * 设置 [目标状态]
    */
    public TransitionHistory setToState(String toState) {
        this.toState = toState;
        this.modify("to_state", toState);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public TransitionHistory setName(String name) {
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