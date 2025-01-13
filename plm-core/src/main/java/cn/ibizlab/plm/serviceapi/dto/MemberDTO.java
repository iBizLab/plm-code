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
 * 成员[MemberDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("成员DTO")
public class MemberDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 0)
    private String ownerId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 1)
    private String ownerType;

    /**
     * 登录名
     */
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "登录名", position = 2)
    private String userId;

    /**
     * 所属对象子类型
     */
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "所属对象子类型", position = 3)
    private String ownerSubtype;

    /**
     * 角色
     */
    @JsonProperty("role_id")
    @JSONField(name = "role_id")
    @ApiModelProperty(value = "角色", position = 4)
    private String roleId;

    /**
     * 部门
     */
    @JsonProperty("department_name")
    @JSONField(name = "department_name")
    @ApiModelProperty(value = "部门", position = 5)
    private String departmentName;

    /**
     * 工号
     */
    @JsonProperty("employee_number")
    @JSONField(name = "employee_number")
    @ApiModelProperty(value = "工号", position = 6)
    private String employeeNumber;

    /**
     * 职位
     */
    @JsonProperty("job_name")
    @JSONField(name = "job_name")
    @ApiModelProperty(value = "职位", position = 7)
    private String jobName;

    /**
     * 统计标识
     */
    @JsonProperty("report_flag")
    @JSONField(name = "report_flag")
    @ApiModelProperty(value = "统计标识", position = 8)
    private Integer reportFlag;

    /**
     * 职位名称
     */
    @JsonProperty("position_name")
    @JSONField(name = "position_name")
    @ApiModelProperty(value = "职位名称", position = 9)
    private String positionName;

    /**
     * 职位
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "职位", position = 10)
    private String title;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 11)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 12)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 13)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 14)
    private String name;

    /**
     * 职位标识
     */
    @JsonProperty("position_id")
    @JSONField(name = "position_id")
    @ApiModelProperty(value = "职位标识", position = 15)
    private String positionId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 16)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 17)
    private Date updateTime;


    /**
     * 设置 [登录名]
     */
    public MemberDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
     * 设置 [角色]
     */
    public MemberDTO setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
     * 设置 [部门]
     */
    public MemberDTO setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        this.modify("department_name", departmentName);
        return this;
    }

    /**
     * 设置 [工号]
     */
    public MemberDTO setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        this.modify("employee_number", employeeNumber);
        return this;
    }

    /**
     * 设置 [职位]
     */
    public MemberDTO setJobName(String jobName) {
        this.jobName = jobName;
        this.modify("job_name", jobName);
        return this;
    }

    /**
     * 设置 [统计标识]
     */
    public MemberDTO setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
        this.modify("report_flag", reportFlag);
        return this;
    }

    /**
     * 设置 [职位名称]
     */
    public MemberDTO setPositionName(String positionName) {
        this.positionName = positionName;
        this.modify("position_name", positionName);
        return this;
    }

    /**
     * 设置 [职位]
     */
    public MemberDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public MemberDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [职位标识]
     */
    public MemberDTO setPositionId(String positionId) {
        this.positionId = positionId;
        this.modify("position_id", positionId);
        return this;
    }


}
