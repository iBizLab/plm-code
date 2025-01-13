/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@ServiceAPI}}.java.hbs
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
 * 系统角色实体类[SysRole]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_ROLE_UAA", description = "系统角色")
public class SysRole extends EntityClient implements Serializable
{

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
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 逻辑有效标记
     */
    @DEField(name = "enabled" , preType = DEPredefinedFieldType.LOGICVALID , logicval = "1" , logicdelval = "0" , dict = "YesNo")
    @JSONField(name = "enabled")
    @JsonProperty("enabled")
    @ApiModelProperty(value = "enabled", notes = "逻辑有效标记")
    private Integer enabled;

    /**
     * 创建人
     */
    @DEField(name = "creator" , preType = DEPredefinedFieldType.CREATEMAN)
    @JSONField(name = "creator")
    @JsonProperty("creator")
    @ApiModelProperty(value = "creator", notes = "创建人")
    private String creator;

    /**
     * 创建时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "创建时间")
    private Date createTime;

    /**
     * 最后更新人
     */
    @DEField(name = "updater" , preType = DEPredefinedFieldType.UPDATEMAN)
    @JSONField(name = "updater")
    @JsonProperty("updater")
    @ApiModelProperty(value = "updater", notes = "最后更新人")
    private String updater;

    /**
     * 最后更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "最后更新时间")
    private Date updateTime;

    /**
     * DC
     */
    @DEField(name = "dc")
    @JSONField(name = "dc")
    @JsonProperty("dc")
    @ApiModelProperty(value = "dc", notes = "DC")
    private String dc;

    /**
     * 角色代码标记
     */
    @DEField(name = "authority")
    @JSONField(name = "authority")
    @JsonProperty("authority")
    @ApiModelProperty(value = "authority", notes = "角色代码标记")
    private String authority;

    /**
     * 是否是工作流用户组
     */
    @DEField(name = "workflow_group" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "workflow_group")
    @JsonProperty("workflow_group")
    @ApiModelProperty(value = "workflow_group", notes = "是否是工作流用户组")
    private Integer workflowGroup;

    /**
     * 范围
     */
    @DEField(name = "group_scope")
    @JSONField(name = "group_scope")
    @JsonProperty("group_scope")
    @ApiModelProperty(value = "group_scope", notes = "范围")
    private String groupScope;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 部署系统标识
     */
    @DEField(name = "deploy_system_id")
    @JSONField(name = "deploy_system_id")
    @JsonProperty("deploy_system_id")
    @ApiModelProperty(value = "deploy_system_id", notes = "部署系统标识")
    private String deploySystemId;

    /**
    * 设置 [名称]
    */
    public SysRole setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [DC]
    */
    public SysRole setDc(String dc) {
        this.dc = dc;
        this.modify("dc", dc);
        return this;
    }

    /**
    * 设置 [角色代码标记]
    */
    public SysRole setAuthority(String authority) {
        this.authority = authority;
        this.modify("authority", authority);
        return this;
    }

    /**
    * 设置 [是否是工作流用户组]
    */
    public SysRole setWorkflowGroup(Integer workflowGroup) {
        this.workflowGroup = workflowGroup;
        this.modify("workflow_group", workflowGroup);
        return this;
    }

    /**
    * 设置 [范围]
    */
    public SysRole setGroupScope(String groupScope) {
        this.groupScope = groupScope;
        this.modify("group_scope", groupScope);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public SysRole setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [部署系统标识]
    */
    public SysRole setDeploySystemId(String deploySystemId) {
        this.deploySystemId = deploySystemId;
        this.modify("deploy_system_id", deploySystemId);
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