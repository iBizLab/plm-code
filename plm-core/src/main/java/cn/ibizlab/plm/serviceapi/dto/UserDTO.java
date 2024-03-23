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
 * 企业用户[UserDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("企业用户DTO")
public class UserDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 显示名称
     */
    @JsonProperty("display_name")
    @JSONField(name = "display_name")
    @ApiModelProperty(value = "显示名称", position = 0)
    private String displayName;

    /**
     * 邮箱
     */
    @JsonProperty("email")
    @JSONField(name = "email")
    @ApiModelProperty(value = "邮箱", position = 1)
    private String email;

    /**
     * 手机号
     */
    @JsonProperty("mobile")
    @JSONField(name = "mobile")
    @ApiModelProperty(value = "手机号", position = 2)
    private String mobile;

    /**
     * 密码
     */
    @JsonProperty("password")
    @JSONField(name = "password")
    @ApiModelProperty(value = "密码", position = 3)
    private String password;

    /**
     * 工号
     */
    @JsonProperty("employee_number")
    @JSONField(name = "employee_number")
    @ApiModelProperty(value = "工号", position = 4)
    private String employeeNumber;

    /**
     * 头像
     */
    @JsonProperty("avatar")
    @JSONField(name = "avatar")
    @ApiModelProperty(value = "头像", position = 5)
    private String avatar;

    /**
     * 状态
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "状态", position = 6)
    private String status;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 7)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 8)
    private Date createTime;

    /**
     * 部门标识
     */
    @JsonProperty("department_id")
    @JSONField(name = "department_id")
    @ApiModelProperty(value = "部门标识", position = 9)
    private String departmentId;

    /**
     * 部门名称
     */
    @JsonProperty("department_name")
    @JSONField(name = "department_name")
    @ApiModelProperty(value = "部门名称", position = 10)
    private String departmentName;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 11)
    private String id;

    /**
     * 岗位标识
     */
    @JsonProperty("job_id")
    @JSONField(name = "job_id")
    @ApiModelProperty(value = "岗位标识", position = 12)
    private String jobId;

    /**
     * 职位名称
     */
    @JsonProperty("job_name")
    @JSONField(name = "job_name")
    @ApiModelProperty(value = "职位名称", position = 13)
    private String jobName;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 14)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 15)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 16)
    private Date updateTime;


    /**
     * 设置 [显示名称]
     */
    public UserDTO setDisplayName(String displayName) {
        this.displayName = displayName;
        this.modify("display_name", displayName);
        return this;
    }

    /**
     * 设置 [邮箱]
     */
    public UserDTO setEmail(String email) {
        this.email = email;
        this.modify("email", email);
        return this;
    }

    /**
     * 设置 [手机号]
     */
    public UserDTO setMobile(String mobile) {
        this.mobile = mobile;
        this.modify("mobile", mobile);
        return this;
    }

    /**
     * 设置 [密码]
     */
    public UserDTO setPassword(String password) {
        this.password = password;
        this.modify("password", password);
        return this;
    }

    /**
     * 设置 [工号]
     */
    public UserDTO setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        this.modify("employee_number", employeeNumber);
        return this;
    }

    /**
     * 设置 [头像]
     */
    public UserDTO setAvatar(String avatar) {
        this.avatar = avatar;
        this.modify("avatar", avatar);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public UserDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [部门标识]
     */
    public UserDTO setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        this.modify("department_id", departmentId);
        return this;
    }

    /**
     * 设置 [部门名称]
     */
    public UserDTO setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        this.modify("department_name", departmentName);
        return this;
    }

    /**
     * 设置 [岗位标识]
     */
    public UserDTO setJobId(String jobId) {
        this.jobId = jobId;
        this.modify("job_id", jobId);
        return this;
    }

    /**
     * 设置 [职位名称]
     */
    public UserDTO setJobName(String jobName) {
        this.jobName = jobName;
        this.modify("job_name", jobName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public UserDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
