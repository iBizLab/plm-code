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
 * 活动[ActivitiyDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("活动DTO")
public class ActivitiyDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审计信息
     */
    @JsonProperty("auditinfo")
    @JSONField(name = "auditinfo")
    @ApiModelProperty(value = "审计信息", position = 0)
    private String auditInfo;

    /**
     * 审计类型
     */
    @JsonProperty("audittype")
    @JSONField(name = "audittype")
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
     * 访问地址
     */
    @JsonProperty("ipaddress")
    @JSONField(name = "ipaddress")
    @ApiModelProperty(value = "访问地址", position = 4)
    private String ipAddress;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 5)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 6)
    private String name;

    /**
     * 操作人
     */
    @JsonProperty("oppersonid")
    @JSONField(name = "oppersonid")
    @ApiModelProperty(value = "操作人", position = 7)
    private String opPersonId;

    /**
     * 操作人
     */
    @JsonProperty("oppersonname")
    @JSONField(name = "oppersonname")
    @ApiModelProperty(value = "操作人", position = 8)
    private String opPersonName;

    /**
     * 对象标识
     */
    @JsonProperty("objectid")
    @JSONField(name = "objectid")
    @ApiModelProperty(value = "对象标识", position = 9)
    private String objectId;

    /**
     * 对象类型
     */
    @JsonProperty("objecttype")
    @JSONField(name = "objecttype")
    @ApiModelProperty(value = "对象类型", position = 10)
    private String objectType;

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
    public ActivitiyDTO setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
        this.modify("auditinfo", auditInfo);
        return this;
    }

    /**
     * 设置 [审计类型]
     */
    public ActivitiyDTO setAuditType(String auditType) {
        this.auditType = auditType;
        this.modify("audittype", auditType);
        return this;
    }

    /**
     * 设置 [访问地址]
     */
    public ActivitiyDTO setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        this.modify("ipaddress", ipAddress);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ActivitiyDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [操作人]
     */
    public ActivitiyDTO setOpPersonId(String opPersonId) {
        this.opPersonId = opPersonId;
        this.modify("oppersonid", opPersonId);
        return this;
    }

    /**
     * 设置 [操作人]
     */
    public ActivitiyDTO setOpPersonName(String opPersonName) {
        this.opPersonName = opPersonName;
        this.modify("oppersonname", opPersonName);
        return this;
    }

    /**
     * 设置 [对象标识]
     */
    public ActivitiyDTO setObjectId(String objectId) {
        this.objectId = objectId;
        this.modify("objectid", objectId);
        return this;
    }

    /**
     * 设置 [对象类型]
     */
    public ActivitiyDTO setObjectType(String objectType) {
        this.objectType = objectType;
        this.modify("objecttype", objectType);
        return this;
    }


}
