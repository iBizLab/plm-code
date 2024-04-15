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
 * 活动[ActivityDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("活动DTO")
public class ActivityDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审计信息
     */
    @JsonProperty("audit_info")
    @JSONField(name = "audit_info")
    @ApiModelProperty(value = "审计信息", position = 0)
    private String auditInfo;

    /**
     * 审计类型
     */
    @JsonProperty("audit_type")
    @JSONField(name = "audit_type")
    @ApiModelProperty(value = "审计类型", position = 1)
    private String auditType;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 2)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 3)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 4)
    private String id;

    /**
     * 访问地址
     */
    @JsonProperty("ip_address")
    @JSONField(name = "ip_address")
    @ApiModelProperty(value = "访问地址", position = 5)
    private String ipAddress;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 6)
    private String name;

    /**
     * 对象标识
     */
    @JsonProperty("object_id")
    @JSONField(name = "object_id")
    @ApiModelProperty(value = "对象标识", position = 7)
    private String objectId;

    /**
     * 对象类型
     */
    @JsonProperty("object_type")
    @JSONField(name = "object_type")
    @ApiModelProperty(value = "对象类型", position = 8)
    private String objectType;

    /**
     * 操作人
     */
    @JsonProperty("op_person_id")
    @JSONField(name = "op_person_id")
    @ApiModelProperty(value = "操作人", position = 9)
    private String opPersonId;

    /**
     * 操作人
     */
    @JsonProperty("op_person_name")
    @JSONField(name = "op_person_name")
    @ApiModelProperty(value = "操作人", position = 10)
    private String opPersonName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 11)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 12)
    private Date updateTime;


    /**
     * 设置 [审计信息]
     */
    public ActivityDTO setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
        this.modify("audit_info", auditInfo);
        return this;
    }

    /**
     * 设置 [审计类型]
     */
    public ActivityDTO setAuditType(String auditType) {
        this.auditType = auditType;
        this.modify("audit_type", auditType);
        return this;
    }

    /**
     * 设置 [访问地址]
     */
    public ActivityDTO setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        this.modify("ip_address", ipAddress);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ActivityDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [对象标识]
     */
    public ActivityDTO setObjectId(String objectId) {
        this.objectId = objectId;
        this.modify("object_id", objectId);
        return this;
    }

    /**
     * 设置 [对象类型]
     */
    public ActivityDTO setObjectType(String objectType) {
        this.objectType = objectType;
        this.modify("object_type", objectType);
        return this;
    }

    /**
     * 设置 [操作人]
     */
    public ActivityDTO setOpPersonId(String opPersonId) {
        this.opPersonId = opPersonId;
        this.modify("op_person_id", opPersonId);
        return this;
    }

    /**
     * 设置 [操作人]
     */
    public ActivityDTO setOpPersonName(String opPersonName) {
        this.opPersonName = opPersonName;
        this.modify("op_person_name", opPersonName);
        return this;
    }


}
