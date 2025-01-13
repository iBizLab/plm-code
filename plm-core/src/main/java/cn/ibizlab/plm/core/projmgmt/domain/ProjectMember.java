/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.projmgmt.domain.DayCapacity;

/**
 * 项目成员实体类[ProjectMember]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "PROJECT_MEMBER", resultMap = "ProjectMemberResultMap")
@ApiModel(value = "PROJECT_MEMBER", description = "项目成员")
public class ProjectMember extends EntityMP implements Serializable
{

    /**
    * 登录名
    */
    @TableField(value = "user_id")
    @DEField(name = "user_id")
    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @ApiModelProperty(value = "user_id", notes = "登录名")
    private String userId;

    /**
    * 角色
    */
    @TableField(value = "role_id")
    @DEField(name = "role_id" , defaultValue = "user" , dict = "role_type")
    @JSONField(name = "role_id")
    @JsonProperty("role_id")
    @ApiModelProperty(value = "role_id", notes = "角色")
    private String roleId;

    /**
    * 项目名称
    */
    @TableField(value = "project_name" , exist = false)
    @DEField(name = "project_name")
    @JSONField(name = "project_name")
    @JsonProperty("project_name")
    @ApiModelProperty(value = "project_name", notes = "项目名称")
    private String projectName;

    /**
    * 项目标识（编号）
    */
    @TableField(value = "project_identifier" , exist = false)
    @DEField(name = "project_identifier")
    @JSONField(name = "project_identifier")
    @JsonProperty("project_identifier")
    @ApiModelProperty(value = "project_identifier", notes = "项目标识（编号）")
    private String projectIdentifier;

    /**
    * 周工作日
    */
    @TableField(value = "weekday")
    @DEField(name = "weekday" , dict = "weekday")
    @JSONField(name = "weekday")
    @JsonProperty("weekday")
    @ApiModelProperty(value = "weekday", notes = "周工作日")
    private Integer weekday;

    /**
    * 日容量
    */
    @TableField(value = "day_capacities", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler =com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler.class)
    @DEField(name = "day_capacities")
    @JSONField(name = "day_capacities")
    @JsonProperty("day_capacities")
    @ApiModelProperty(value = "day_capacities", notes = "日容量")
    private DayCapacity dayCapacities;

    /**
    * 项目类型
    */
    @TableField(value = "project_type" , exist = false)
    @DEField(name = "project_type" , dict = "project_type")
    @JSONField(name = "project_type")
    @JsonProperty("project_type")
    @ApiModelProperty(value = "project_type", notes = "项目类型")
    private String projectType;

    /**
    * 职位
    */
    @TableField(value = "title")
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "职位")
    private String title;

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
    * 姓名
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "姓名")
    private String name;

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
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

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
    * 项目标识
    */
    @TableField(value = "project_id")
    @DEField(name = "project_id")
    @JSONField(name = "project_id")
    @JsonProperty("project_id")
    @ApiModelProperty(value = "project_id", notes = "项目标识")
    private String projectId;

    /**
    * 项目成员
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "项目成员")
    private Project project;

    /**
    * 企业用户
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "user", notes = "企业用户")
    private User user;

    /**
    * 设置 [登录名]
    */
    public ProjectMember setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
    * 设置 [角色]
    */
    public ProjectMember setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
    * 设置 [项目名称]
    */
    public ProjectMember setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
    * 设置 [项目标识（编号）]
    */
    public ProjectMember setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
        this.modify("project_identifier", projectIdentifier);
        return this;
    }

    /**
    * 设置 [周工作日]
    */
    public ProjectMember setWeekday(Integer weekday) {
        this.weekday = weekday;
        this.modify("weekday", weekday);
        return this;
    }

    /**
    * 设置 [日容量]
    */
    public ProjectMember setDayCapacities(DayCapacity dayCapacities) {
        this.dayCapacities = dayCapacities;
        this.modify("day_capacities", dayCapacities);
        return this;
    }

    /**
    * 设置 [项目类型]
    */
    public ProjectMember setProjectType(String projectType) {
        this.projectType = projectType;
        this.modify("project_type", projectType);
        return this;
    }

    /**
    * 设置 [职位]
    */
    public ProjectMember setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [姓名]
    */
    public ProjectMember setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [项目标识]
    */
    public ProjectMember setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getProjectId(),"未设置项目标识");
        //Assert.notNull(getUserId(),"未设置登录名");
        String key = String.format("%s||%s"
            ,getProjectId(),getUserId());
        key = DigestUtils.md5DigestAsHex(key.getBytes());
        return key;
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