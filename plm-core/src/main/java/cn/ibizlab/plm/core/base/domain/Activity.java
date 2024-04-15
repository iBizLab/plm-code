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
 * 活动实体类[Activity]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "ACTIVITY", resultMap = "ActivityResultMap")
@ApiModel(value = "ACTIVITY", description = "活动")
public class Activity extends EntityMP implements Serializable
{

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
     * 审计信息
     */
    @TableField(value = "auditinfo")
    @DEField(name = "auditinfo")
    @JsonProperty("auditinfo")
    @JSONField(name = "auditinfo")
    @ApiModelProperty(value = "auditinfo", notes = "审计信息")
    private String auditInfo;

    /**
     * 对象标识
     */
    @TableField(value = "objectid")
    @DEField(name = "objectid")
    @JsonProperty("objectid")
    @JSONField(name = "objectid")
    @ApiModelProperty(value = "objectid", notes = "对象标识")
    private String objectId;

    /**
     * 操作人
     */
    @TableField(value = "oppersonid")
    @DEField(name = "oppersonid")
    @JsonProperty("oppersonid")
    @JSONField(name = "oppersonid")
    @ApiModelProperty(value = "oppersonid", notes = "操作人")
    private String opPersonId;

    /**
     * 操作人
     */
    @TableField(value = "oppersonname")
    @DEField(name = "oppersonname")
    @JsonProperty("oppersonname")
    @JSONField(name = "oppersonname")
    @ApiModelProperty(value = "oppersonname", notes = "操作人")
    private String opPersonName;

    /**
     * 访问地址
     */
    @TableField(value = "ipaddress")
    @DEField(name = "ipaddress")
    @JsonProperty("ipaddress")
    @JSONField(name = "ipaddress")
    @ApiModelProperty(value = "ipaddress", notes = "访问地址")
    private String ipAddress;

    /**
     * 审计类型
     */
    @TableField(value = "audittype")
    @DEField(name = "audittype")
    @JsonProperty("audittype")
    @JSONField(name = "audittype")
    @ApiModelProperty(value = "audittype", notes = "审计类型")
    private String auditType;

    /**
     * 对象类型
     */
    @TableField(value = "objecttype")
    @DEField(name = "objecttype")
    @JsonProperty("objecttype")
    @JSONField(name = "objecttype")
    @ApiModelProperty(value = "objecttype", notes = "对象类型")
    private String objectType;

    /**
     * 设置 [名称]
     */
    public Activity setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [审计信息]
     */
    public Activity setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
        this.modify("auditinfo", auditInfo);
        return this;
    }

    /**
     * 设置 [对象标识]
     */
    public Activity setObjectId(String objectId) {
        this.objectId = objectId;
        this.modify("objectid", objectId);
        return this;
    }

    /**
     * 设置 [操作人]
     */
    public Activity setOpPersonId(String opPersonId) {
        this.opPersonId = opPersonId;
        this.modify("oppersonid", opPersonId);
        return this;
    }

    /**
     * 设置 [操作人]
     */
    public Activity setOpPersonName(String opPersonName) {
        this.opPersonName = opPersonName;
        this.modify("oppersonname", opPersonName);
        return this;
    }

    /**
     * 设置 [访问地址]
     */
    public Activity setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        this.modify("ipaddress", ipAddress);
        return this;
    }

    /**
     * 设置 [审计类型]
     */
    public Activity setAuditType(String auditType) {
        this.auditType = auditType;
        this.modify("audittype", auditType);
        return this;
    }

    /**
     * 设置 [对象类型]
     */
    public Activity setObjectType(String objectType) {
        this.objectType = objectType;
        this.modify("objecttype", objectType);
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