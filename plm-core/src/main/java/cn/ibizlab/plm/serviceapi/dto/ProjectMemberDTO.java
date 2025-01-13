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
 * 项目成员[ProjectMemberDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("项目成员DTO")
public class ProjectMemberDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "登录名", position = 0)
    private String userId;

    /**
     * 角色
     */
    @JsonProperty("role_id")
    @JSONField(name = "role_id")
    @ApiModelProperty(value = "角色", position = 1)
    private String roleId;

    /**
     * 项目名称
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "项目名称", position = 2)
    private String projectName;

    /**
     * 项目标识（编号）
     */
    @JsonProperty("project_identifier")
    @JSONField(name = "project_identifier")
    @ApiModelProperty(value = "项目标识（编号）", position = 3)
    private String projectIdentifier;

    /**
     * 周工作日
     */
    @JsonProperty("weekday")
    @JSONField(name = "weekday")
    @ApiModelProperty(value = "周工作日", position = 4)
    private Integer weekday;

    /**
     * 日容量
     */
    @JsonProperty("day_capacities")
    @JSONField(name = "day_capacities")
    @ApiModelProperty(value = "日容量", position = 5)
    private DayCapacityDTO dayCapacities;

    /**
     * 项目类型
     */
    @JsonProperty("project_type")
    @JSONField(name = "project_type")
    @ApiModelProperty(value = "项目类型", position = 6)
    private String projectType;

    /**
     * 职位
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "职位", position = 7)
    private String title;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 8)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 9)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 10)
    private String id;

    /**
     * 姓名
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "姓名", position = 11)
    private String name;

    /**
     * 项目标识
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目标识", position = 12)
    private String projectId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 13)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 14)
    private Date updateTime;


    /**
     * 设置 [登录名]
     */
    public ProjectMemberDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
     * 设置 [角色]
     */
    public ProjectMemberDTO setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
     * 设置 [项目名称]
     */
    public ProjectMemberDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
     * 设置 [项目标识（编号）]
     */
    public ProjectMemberDTO setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
        this.modify("project_identifier", projectIdentifier);
        return this;
    }

    /**
     * 设置 [周工作日]
     */
    public ProjectMemberDTO setWeekday(Integer weekday) {
        this.weekday = weekday;
        this.modify("weekday", weekday);
        return this;
    }

    /**
     * 设置 [日容量]
     */
    public ProjectMemberDTO setDayCapacities(DayCapacityDTO dayCapacities) {
        this.dayCapacities = dayCapacities;
        this.modify("day_capacities", dayCapacities);
        return this;
    }

    /**
     * 设置 [项目类型]
     */
    public ProjectMemberDTO setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
     * 设置 [职位]
     */
    public ProjectMemberDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [姓名]
     */
    public ProjectMemberDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public ProjectMemberDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }


}
