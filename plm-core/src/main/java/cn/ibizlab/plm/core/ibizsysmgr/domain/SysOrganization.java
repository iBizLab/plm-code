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
 * 组织实体类[SysOrganization]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_ORGANIZATION", description = "组织")
public class SysOrganization extends EntityClient implements Serializable
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
    @DEField(name = "organization_name" , dupCheck = DupCheck.ALL)
    @JSONField(name = "organization_name")
    @JsonProperty("organization_name")
    @ApiModelProperty(value = "organization_name", notes = "名称")
    private String organizationName;

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
     * 上级名称
     */
    @DEField(name = "parent_name")
    @JSONField(name = "parent_name")
    @JsonProperty("parent_name")
    @ApiModelProperty(value = "parent_name", notes = "上级名称")
    private String parentName;

    /**
     * 机构编号
     */
    @DEField(name = "organization_number" , dupCheck = DupCheck.ALL)
    @JSONField(name = "organization_number")
    @JsonProperty("organization_number")
    @ApiModelProperty(value = "organization_number", notes = "机构编号")
    private String organizationNumber;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

    /**
     * 简称
     */
    @DEField(name = "short_name")
    @JSONField(name = "short_name")
    @JsonProperty("short_name")
    @ApiModelProperty(value = "short_name", notes = "简称")
    private String shortName;

    /**
     * 排序
     */
    @DEField(name = "sort")
    @JSONField(name = "sort")
    @JsonProperty("sort")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "sort", notes = "排序")
    private Long sort;

    /**
     * 父标识
     */
    @DEField(name = "parent_id")
    @JSONField(name = "parent_id")
    @JsonProperty("parent_id")
    @ApiModelProperty(value = "parent_id", notes = "父标识")
    private String parentId;

    /**
     * 名称
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "sys_organization", notes = "名称")
    private SysOrganization sysOrganization;

    /**
    * 设置 [名称]
    */
    public SysOrganization setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        this.modify("organization_name", organizationName);
        return this;
    }

    /**
    * 设置 [DC]
    */
    public SysOrganization setDc(String dc) {
        this.dc = dc;
        this.modify("dc", dc);
        return this;
    }

    /**
    * 设置 [上级名称]
    */
    public SysOrganization setParentName(String parentName) {
        this.parentName = parentName;
        this.modify("parent_name", parentName);
        return this;
    }

    /**
    * 设置 [机构编号]
    */
    public SysOrganization setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
        this.modify("organization_number", organizationNumber);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public SysOrganization setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [简称]
    */
    public SysOrganization setShortName(String shortName) {
        this.shortName = shortName;
        this.modify("short_name", shortName);
        return this;
    }

    /**
    * 设置 [排序]
    */
    public SysOrganization setSort(Long sort) {
        this.sort = sort;
        this.modify("sort", sort);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public SysOrganization setParentId(String parentId) {
        this.parentId = parentId;
        this.modify("parent_id", parentId);
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