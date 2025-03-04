/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

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
import cn.ibizlab.plm.core.base.domain.Department;
import cn.ibizlab.plm.core.base.domain.Job;
import cn.ibizlab.plm.core.base.domain.Organization;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.team.domain.DiscussMember;
import cn.ibizlab.plm.core.base.domain.Executor;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.base.domain.ResourceMember;
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.base.domain.RoleMember;

/**
 * 企业用户实体类[User]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "USER", description = "企业用户")
public class User extends EntityBase implements Serializable
{
    /**
     * 姓名
     */
    @DEField(name = "display_name")
    @JSONField(name = "display_name")
    @JsonProperty("display_name")
    @ApiModelProperty(value = "display_name", notes = "姓名")
    private String displayName;

    /**
     * 邮箱
     */
    @DEField(name = "email")
    @JSONField(name = "email")
    @JsonProperty("email")
    @ApiModelProperty(value = "email", notes = "邮箱")
    private String email;

    /**
     * 手机号
     */
    @DEField(name = "mobile")
    @JSONField(name = "mobile")
    @JsonProperty("mobile")
    @ApiModelProperty(value = "mobile", notes = "手机号")
    private String mobile;

    /**
     * 密码
     */
    @DEField(name = "password")
    @JSONField(name = "password")
    @JsonProperty("password")
    @ApiModelProperty(value = "password", notes = "密码")
    private String password;

    /**
     * 工号
     */
    @DEField(name = "employee_number")
    @JSONField(name = "employee_number")
    @JsonProperty("employee_number")
    @ApiModelProperty(value = "employee_number", notes = "工号")
    private String employeeNumber;

    /**
     * 头像
     */
    @DEField(name = "avatar")
    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    @ApiModelProperty(value = "avatar", notes = "头像")
    private String avatar;

    /**
     * 状态
     */
    @DEField(name = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty(value = "status", notes = "状态")
    private String status;

    /**
     * 统计
     */
    @DEField(name = "report_flag" , dict = "user_report_flag")
    @JSONField(name = "report_flag")
    @JsonProperty("report_flag")
    @ApiModelProperty(value = "report_flag", notes = "统计")
    private Integer reportFlag;

    /**
     * 用户ID
     */
    @DEField(name = "user_id")
    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @ApiModelProperty(value = "user_id", notes = "用户ID")
    private String userId;

    /**
     * 职位
     */
    @DEField(name = "title" , dict = "position")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "职位")
    private String title;

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
     * 登录名
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "登录名")
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
     * 部门标识
     */
    @DEField(name = "department_id")
    @JSONField(name = "department_id")
    @JsonProperty("department_id")
    @ApiModelProperty(value = "department_id", notes = "部门标识")
    private String departmentId;

    /**
     * 岗位标识
     */
    @DEField(name = "job_id")
    @JSONField(name = "job_id")
    @JsonProperty("job_id")
    @ApiModelProperty(value = "job_id", notes = "岗位标识")
    private String jobId;

    /**
     * 职位名称
     */
    @DEField(name = "job_name")
    @JSONField(name = "job_name")
    @JsonProperty("job_name")
    @ApiModelProperty(value = "job_name", notes = "职位名称")
    private String jobName;

    /**
     * 部门
     */
    @DEField(name = "department_name")
    @JSONField(name = "department_name")
    @JsonProperty("department_name")
    @ApiModelProperty(value = "department_name", notes = "部门")
    private String departmentName;

    /**
     * 组织标识
     */
    @DEField(name = "organization_id")
    @JSONField(name = "organization_id")
    @JsonProperty("organization_id")
    @ApiModelProperty(value = "organization_id", notes = "组织标识")
    private String organizationId;

    /**
     * 组织名称
     */
    @DEField(name = "organization_name")
    @JSONField(name = "organization_name")
    @JsonProperty("organization_name")
    @ApiModelProperty(value = "organization_name", notes = "组织名称")
    private String organizationName;

    /**
     * 用户-部门
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "department", notes = "用户-部门")
    private Department department;

    /**
     * 用户-岗位
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "job", notes = "用户-岗位")
    private Job job;

    /**
     * 名称
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "organization", notes = "名称")
    private Organization organization;

    /**
    * 设置 [姓名]
    */
    public User setDisplayName(String displayName) {
        this.displayName = displayName;
        this.modify("display_name", displayName);
        return this;
    }

    /**
    * 设置 [邮箱]
    */
    public User setEmail(String email) {
        this.email = email;
        this.modify("email", email);
        return this;
    }

    /**
    * 设置 [手机号]
    */
    public User setMobile(String mobile) {
        this.mobile = mobile;
        this.modify("mobile", mobile);
        return this;
    }

    /**
    * 设置 [密码]
    */
    public User setPassword(String password) {
        this.password = password;
        this.modify("password", password);
        return this;
    }

    /**
    * 设置 [工号]
    */
    public User setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        this.modify("employee_number", employeeNumber);
        return this;
    }

    /**
    * 设置 [头像]
    */
    public User setAvatar(String avatar) {
        this.avatar = avatar;
        this.modify("avatar", avatar);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public User setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
    * 设置 [统计]
    */
    public User setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
        this.modify("report_flag", reportFlag);
        return this;
    }

    /**
    * 设置 [用户ID]
    */
    public User setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
    * 设置 [职位]
    */
    public User setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [登录名]
    */
    public User setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [部门标识]
    */
    public User setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        this.modify("department_id", departmentId);
        return this;
    }

    /**
    * 设置 [岗位标识]
    */
    public User setJobId(String jobId) {
        this.jobId = jobId;
        this.modify("job_id", jobId);
        return this;
    }

    /**
    * 设置 [职位名称]
    */
    public User setJobName(String jobName) {
        this.jobName = jobName;
        this.modify("job_name", jobName);
        return this;
    }

    /**
    * 设置 [部门]
    */
    public User setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        this.modify("department_name", departmentName);
        return this;
    }

    /**
    * 设置 [组织标识]
    */
    public User setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        this.modify("organization_id", organizationId);
        return this;
    }

    /**
    * 设置 [组织名称]
    */
    public User setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        this.modify("organization_name", organizationName);
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