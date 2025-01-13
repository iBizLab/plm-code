/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
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
import cn.ibizlab.plm.core.base.domain.LocalDepartment;

/**
 * 企业用户实体类[LocalUser]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "LOCAL_USER", resultMap = "LocalUserResultMap")
@ApiModel(value = "LOCAL_USER", description = "企业用户")
public class LocalUser extends EntityMP implements Serializable
{

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
    * 姓名
    */
    @TableField(value = "display_name")
    @DEField(name = "display_name")
    @JSONField(name = "display_name")
    @JsonProperty("display_name")
    @ApiModelProperty(value = "display_name", notes = "姓名")
    private String displayName;

    /**
    * 邮箱
    */
    @TableField(value = "email")
    @DEField(name = "email")
    @JSONField(name = "email")
    @JsonProperty("email")
    @ApiModelProperty(value = "email", notes = "邮箱")
    private String email;

    /**
    * 手机号
    */
    @TableField(value = "mobile")
    @DEField(name = "mobile")
    @JSONField(name = "mobile")
    @JsonProperty("mobile")
    @ApiModelProperty(value = "mobile", notes = "手机号")
    private String mobile;

    /**
    * 密码
    */
    @TableField(value = "password")
    @DEField(name = "password")
    @JSONField(name = "password")
    @JsonProperty("password")
    @ApiModelProperty(value = "password", notes = "密码")
    private String password;

    /**
    * 工号
    */
    @TableField(value = "employee_number")
    @DEField(name = "employee_number")
    @JSONField(name = "employee_number")
    @JsonProperty("employee_number")
    @ApiModelProperty(value = "employee_number", notes = "工号")
    private String employeeNumber;

    /**
    * 头像
    */
    @TableField(value = "avatar")
    @DEField(name = "avatar")
    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    @ApiModelProperty(value = "avatar", notes = "头像")
    private String avatar;

    /**
    * 状态
    */
    @TableField(value = "status")
    @DEField(name = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty(value = "status", notes = "状态")
    private String status;

    /**
    * 部门标识
    */
    @TableField(value = "department_id")
    @DEField(name = "department_id")
    @JSONField(name = "department_id")
    @JsonProperty("department_id")
    @ApiModelProperty(value = "department_id", notes = "部门标识")
    private String departmentId;

    /**
    * 部门名称
    */
    @TableField(value = "department_name" , exist = false)
    @DEField(name = "department_name")
    @JSONField(name = "department_name")
    @JsonProperty("department_name")
    @ApiModelProperty(value = "department_name", notes = "部门名称")
    private String departmentName;

    /**
    * 统计
    */
    @TableField(exist = false)
    @DEField(name = "report_flag" , dict = "user_report_flag")
    @JSONField(name = "report_flag")
    @JsonProperty("report_flag")
    @ApiModelProperty(value = "report_flag", notes = "统计")
    private Integer reportFlag;

    /**
    * 组织标识
    */
    @TableField(value = "organization_id")
    @DEField(name = "organization_id")
    @JSONField(name = "organization_id")
    @JsonProperty("organization_id")
    @ApiModelProperty(value = "organization_id", notes = "组织标识")
    private String organizationId;

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
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

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
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 企业部门-用户
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "local_department", notes = "企业部门-用户")
    private LocalDepartment localDepartment;

    /**
    * 设置 [名称]
    */
    public LocalUser setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [姓名]
    */
    public LocalUser setDisplayName(String displayName) {
        this.displayName = displayName;
        this.modify("display_name", displayName);
        return this;
    }

    /**
    * 设置 [邮箱]
    */
    public LocalUser setEmail(String email) {
        this.email = email;
        this.modify("email", email);
        return this;
    }

    /**
    * 设置 [手机号]
    */
    public LocalUser setMobile(String mobile) {
        this.mobile = mobile;
        this.modify("mobile", mobile);
        return this;
    }

    /**
    * 设置 [密码]
    */
    public LocalUser setPassword(String password) {
        this.password = password;
        this.modify("password", password);
        return this;
    }

    /**
    * 设置 [工号]
    */
    public LocalUser setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        this.modify("employee_number", employeeNumber);
        return this;
    }

    /**
    * 设置 [头像]
    */
    public LocalUser setAvatar(String avatar) {
        this.avatar = avatar;
        this.modify("avatar", avatar);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public LocalUser setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
    * 设置 [部门标识]
    */
    public LocalUser setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        this.modify("department_id", departmentId);
        return this;
    }

    /**
    * 设置 [部门名称]
    */
    public LocalUser setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        this.modify("department_name", departmentName);
        return this;
    }

    /**
    * 设置 [统计]
    */
    public LocalUser setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
        this.modify("report_flag", reportFlag);
        return this;
    }

    /**
    * 设置 [组织标识]
    */
    public LocalUser setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        this.modify("organization_id", organizationId);
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