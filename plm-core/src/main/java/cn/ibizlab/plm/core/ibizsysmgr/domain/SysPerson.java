/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@ServiceAPI}}.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.domain;

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
import cn.ibizlab.util.domain.EntityClient;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;

/**
 * 人员实体类[SysPerson]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_PERSON", description = "人员")
public class SysPerson extends EntityClient implements Serializable
{

    /**
     * 创建人
     */
    @DEField(name = "creator" , preType = DEPredefinedFieldType.CREATEMAN)
    @JsonProperty("creator")
    @JSONField(name = "creator")
    @ApiModelProperty(value = "creator", notes = "创建人")
    private String creator;

    /**
     * 最后更新人
     */
    @DEField(name = "updater" , preType = DEPredefinedFieldType.UPDATEMAN)
    @JsonProperty("updater")
    @JSONField(name = "updater")
    @ApiModelProperty(value = "updater", notes = "最后更新人")
    private String updater;

    /**
     * DC
     */
    @DEField(name = "dc" , defaultValue = "SRFDCID" , defaultValueType = DEFieldDefaultValueType.SESSION)
    @JsonProperty("dc")
    @JSONField(name = "dc")
    @ApiModelProperty(value = "dc", notes = "DC")
    private String dc;

    /**
     * 名称
     */
    @DEField(name = "display_name")
    @JsonProperty("display_name")
    @JSONField(name = "display_name")
    @ApiModelProperty(value = "display_name", notes = "名称")
    private String displayName;

    /**
     * 密码
     */
    @DEField(name = "user_password")
    @JsonProperty("user_password")
    @JSONField(name = "user_password")
    @ApiModelProperty(value = "user_password", notes = "密码")
    private String userPassword;

    /**
     * 人员编号
     */
    @DEField(name = "employee_number" , dupCheck = DupCheck.ALL)
    @JsonProperty("employee_number")
    @JSONField(name = "employee_number")
    @ApiModelProperty(value = "employee_number", notes = "人员编号")
    private String employeeNumber;

    /**
     * 类型
     */
    @DEField(name = "employee_type")
    @JsonProperty("employee_type")
    @JSONField(name = "employee_type")
    @ApiModelProperty(value = "employee_type", notes = "类型")
    private String employeeType;

    /**
     * 职位
     */
    @DEField(name = "title")
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "title", notes = "职位")
    private String title;

    /**
     * 电子邮箱
     */
    @DEField(name = "mail")
    @JsonProperty("mail")
    @JSONField(name = "mail")
    @ApiModelProperty(value = "mail", notes = "电子邮箱")
    private String mail;

    /**
     * 联系电话
     */
    @DEField(name = "telephone_number")
    @JsonProperty("telephone_number")
    @JSONField(name = "telephone_number")
    @ApiModelProperty(value = "telephone_number", notes = "联系电话")
    private String telephoneNumber;

    /**
     * 移动电话
     */
    @DEField(name = "mobile")
    @JsonProperty("mobile")
    @JSONField(name = "mobile")
    @ApiModelProperty(value = "mobile", notes = "移动电话")
    private String mobile;

    /**
     * 证件号
     */
    @DEField(name = "identification_number")
    @JsonProperty("identification_number")
    @JSONField(name = "identification_number")
    @ApiModelProperty(value = "identification_number", notes = "证件号")
    private String identificationNumber;

    /**
     * 地址
     */
    @DEField(name = "postal_address")
    @JsonProperty("postal_address")
    @JSONField(name = "postal_address")
    @ApiModelProperty(value = "postal_address", notes = "地址")
    private String postalAddress;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 主部门
     */
    @DEField(name = "mdepartment_name")
    @JsonProperty("mdepartment_name")
    @JSONField(name = "mdepartment_name")
    @ApiModelProperty(value = "mdepartment_name", notes = "主部门")
    private String mdepartmentName;

    /**
     * DN
     */
    @DEField(name = "dn")
    @JsonProperty("dn")
    @JSONField(name = "dn")
    @ApiModelProperty(value = "dn", notes = "DN")
    private String dn;

    /**
     * 主部门
     */
    @DEField(name = "mdepartment_id")
    @JsonProperty("mdepartment_id")
    @JSONField(name = "mdepartment_id")
    @ApiModelProperty(value = "mdepartment_id", notes = "主部门")
    private String mdepartmentId;

    /**
     * uid/loginname
     */
    @DEField(name = "uid")
    @JsonProperty("uid")
    @JSONField(name = "uid")
    @ApiModelProperty(value = "uid", notes = "uid/loginname")
    private String uid;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 逻辑有效标志
     */
    @DEField(name = "enable" , preType = DEPredefinedFieldType.LOGICVALID , logicval = "1" , logicdelval = "0")
    @JsonProperty("enable")
    @JSONField(name = "enable")
    @ApiModelProperty(value = "enable", notes = "逻辑有效标志")
    private Integer enable;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 设置 [DC]
     */
    public SysPerson setDc(String dc) {
        this.dc = dc;
        this.modify("dc", dc);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public SysPerson setDisplayName(String displayName) {
        this.displayName = displayName;
        this.modify("display_name", displayName);
        return this;
    }

    /**
     * 设置 [密码]
     */
    public SysPerson setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        this.modify("user_password", userPassword);
        return this;
    }

    /**
     * 设置 [人员编号]
     */
    public SysPerson setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        this.modify("employee_number", employeeNumber);
        return this;
    }

    /**
     * 设置 [类型]
     */
    public SysPerson setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
        this.modify("employee_type", employeeType);
        return this;
    }

    /**
     * 设置 [职位]
     */
    public SysPerson setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [电子邮箱]
     */
    public SysPerson setMail(String mail) {
        this.mail = mail;
        this.modify("mail", mail);
        return this;
    }

    /**
     * 设置 [联系电话]
     */
    public SysPerson setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        this.modify("telephone_number", telephoneNumber);
        return this;
    }

    /**
     * 设置 [移动电话]
     */
    public SysPerson setMobile(String mobile) {
        this.mobile = mobile;
        this.modify("mobile", mobile);
        return this;
    }

    /**
     * 设置 [证件号]
     */
    public SysPerson setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        this.modify("identification_number", identificationNumber);
        return this;
    }

    /**
     * 设置 [地址]
     */
    public SysPerson setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
        this.modify("postal_address", postalAddress);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public SysPerson setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [主部门]
     */
    public SysPerson setMdepartmentName(String mdepartmentName) {
        this.mdepartmentName = mdepartmentName;
        this.modify("mdepartment_name", mdepartmentName);
        return this;
    }

    /**
     * 设置 [DN]
     */
    public SysPerson setDn(String dn) {
        this.dn = dn;
        this.modify("dn", dn);
        return this;
    }

    /**
     * 设置 [主部门]
     */
    public SysPerson setMdepartmentId(String mdepartmentId) {
        this.mdepartmentId = mdepartmentId;
        this.modify("mdepartment_id", mdepartmentId);
        return this;
    }

    /**
     * 设置 [uid/loginname]
     */
    public SysPerson setUid(String uid) {
        this.uid = uid;
        this.modify("uid", uid);
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