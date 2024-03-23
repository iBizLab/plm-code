/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
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
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.LibraryMember;
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductMember;
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;
import cn.ibizlab.plm.core.wiki.domain.SpaceMember;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

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
     * 显示名称
     */
    @DEField(name = "display_name")
    @JsonProperty("display_name")
    @JSONField(name = "display_name")
    @ApiModelProperty(value = "display_name", notes = "显示名称")
    private String displayName;

    /**
     * 邮箱
     */
    @DEField(name = "email")
    @JsonProperty("email")
    @JSONField(name = "email")
    @ApiModelProperty(value = "email", notes = "邮箱")
    private String email;

    /**
     * 手机号
     */
    @DEField(name = "mobile")
    @JsonProperty("mobile")
    @JSONField(name = "mobile")
    @ApiModelProperty(value = "mobile", notes = "手机号")
    private String mobile;

    /**
     * 密码
     */
    @DEField(name = "password")
    @JsonProperty("password")
    @JSONField(name = "password")
    @ApiModelProperty(value = "password", notes = "密码")
    private String password;

    /**
     * 工号
     */
    @DEField(name = "employee_number")
    @JsonProperty("employee_number")
    @JSONField(name = "employee_number")
    @ApiModelProperty(value = "employee_number", notes = "工号")
    private String employeeNumber;

    /**
     * 头像
     */
    @DEField(name = "avatar")
    @JsonProperty("avatar")
    @JSONField(name = "avatar")
    @ApiModelProperty(value = "avatar", notes = "头像")
    private String avatar;

    /**
     * 状态
     */
    @DEField(name = "status")
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "status", notes = "状态")
    private String status;

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
     * 名称
     */
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

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
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

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
     * 部门标识
     */
    @DEField(name = "department_id")
    @JsonProperty("department_id")
    @JSONField(name = "department_id")
    @ApiModelProperty(value = "department_id", notes = "部门标识")
    private String departmentId;

    /**
     * 岗位标识
     */
    @DEField(name = "job_id")
    @JsonProperty("job_id")
    @JSONField(name = "job_id")
    @ApiModelProperty(value = "job_id", notes = "岗位标识")
    private String jobId;

    /**
     * 职位名称
     */
    @DEField(name = "job_name")
    @JsonProperty("job_name")
    @JSONField(name = "job_name")
    @ApiModelProperty(value = "job_name", notes = "职位名称")
    private String jobName;

    /**
     * 部门名称
     */
    @DEField(name = "department_name")
    @JsonProperty("department_name")
    @JSONField(name = "department_name")
    @ApiModelProperty(value = "department_name", notes = "部门名称")
    private String departmentName;

    /**
     * 部门
     */
    @JSONField(name = "department")
    @JsonProperty("department")
    @ApiModelProperty(value = "department", notes = "用户-部门")
    private Department department;

    /**
     * 岗位
     */
    @JSONField(name = "job")
    @JsonProperty("job")
    @ApiModelProperty(value = "job", notes = "用户-岗位")
    private Job job;


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