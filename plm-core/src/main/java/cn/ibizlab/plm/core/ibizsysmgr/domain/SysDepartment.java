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
 * 部门实体类[SysDepartment]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_DEPARTMENT", description = "部门")
public class SysDepartment extends EntityClient implements Serializable
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
     * 部门名称
     */
    @DEField(name = "department_name")
    @JSONField(name = "department_name")
    @JsonProperty("department_name")
    @ApiModelProperty(value = "department_name", notes = "部门名称")
    private String departmentName;

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
     * 部门编号
     */
    @DEField(name = "department_number" , dupCheck = DupCheck.ALL)
    @JSONField(name = "department_number")
    @JsonProperty("department_number")
    @ApiModelProperty(value = "department_number", notes = "部门编号")
    private String departmentNumber;

    /**
     * 备注
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "备注")
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
     * 业务类别
     */
    @DEField(name = "business_category")
    @JSONField(name = "business_category")
    @JsonProperty("business_category")
    @ApiModelProperty(value = "business_category", notes = "业务类别")
    private List<String> businessCategory;

    /**
     * 上级标识
     */
    @DEField(name = "parent_unit_id")
    @JSONField(name = "parent_unit_id")
    @JsonProperty("parent_unit_id")
    @ApiModelProperty(value = "parent_unit_id", notes = "上级标识")
    private String parentUnitId;

    /**
     * 上级部门标识
     */
    @DEField(name = "parent_id")
    @JSONField(name = "parent_id")
    @JsonProperty("parent_id")
    @ApiModelProperty(value = "parent_id", notes = "上级部门标识")
    private String parentId;

    /**
     * 上级名称
     */
    @DEField(name = "parent_unit_name")
    @JSONField(name = "parent_unit_name")
    @JsonProperty("parent_unit_name")
    @ApiModelProperty(value = "parent_unit_name", notes = "上级名称")
    private String parentUnitName;

    /**
     * DN
     */
    @DEField(name = "dn")
    @JSONField(name = "dn")
    @JsonProperty("dn")
    @ApiModelProperty(value = "dn", notes = "DN")
    private String dn;

    /**
     * 上级部门名称
     */
    @DEField(name = "parent_name")
    @JSONField(name = "parent_name")
    @JsonProperty("parent_name")
    @ApiModelProperty(value = "parent_name", notes = "上级部门名称")
    private String parentName;

    /**
     * 组织机构标识
     */
    @DEField(name = "organization_id")
    @JSONField(name = "organization_id")
    @JsonProperty("organization_id")
    @ApiModelProperty(value = "organization_id", notes = "组织机构标识")
    private String organizationId;

    /**
     * 组织机构名称
     */
    @DEField(name = "organization_name")
    @JSONField(name = "organization_name")
    @JsonProperty("organization_name")
    @ApiModelProperty(value = "organization_name", notes = "组织机构名称")
    private String organizationName;

    /**
     * 机构编号
     */
    @DEField(name = "organization_number")
    @JSONField(name = "organization_number")
    @JsonProperty("organization_number")
    @ApiModelProperty(value = "organization_number", notes = "机构编号")
    private String organizationNumber;

    /**
    * 设置 [部门名称]
    */
    public SysDepartment setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        this.modify("department_name", departmentName);
        return this;
    }

    /**
    * 设置 [DC]
    */
    public SysDepartment setDc(String dc) {
        this.dc = dc;
        this.modify("dc", dc);
        return this;
    }

    /**
    * 设置 [部门编号]
    */
    public SysDepartment setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
        this.modify("department_number", departmentNumber);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public SysDepartment setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [简称]
    */
    public SysDepartment setShortName(String shortName) {
        this.shortName = shortName;
        this.modify("short_name", shortName);
        return this;
    }

    /**
    * 设置 [排序]
    */
    public SysDepartment setSort(Long sort) {
        this.sort = sort;
        this.modify("sort", sort);
        return this;
    }

    /**
    * 设置 [业务类别]
    */
    public SysDepartment setBusinessCategory(List<String> businessCategory) {
        this.businessCategory = businessCategory;
        this.modify("business_category", businessCategory);
        return this;
    }

    /**
    * 设置 [上级标识]
    */
    public SysDepartment setParentUnitId(String parentUnitId) {
        this.parentUnitId = parentUnitId;
        this.modify("parent_unit_id", parentUnitId);
        return this;
    }

    /**
    * 设置 [上级部门标识]
    */
    public SysDepartment setParentId(String parentId) {
        this.parentId = parentId;
        this.modify("parent_id", parentId);
        return this;
    }

    /**
    * 设置 [上级名称]
    */
    public SysDepartment setParentUnitName(String parentUnitName) {
        this.parentUnitName = parentUnitName;
        this.modify("parent_unit_name", parentUnitName);
        return this;
    }

    /**
    * 设置 [DN]
    */
    public SysDepartment setDn(String dn) {
        this.dn = dn;
        this.modify("dn", dn);
        return this;
    }

    /**
    * 设置 [上级部门名称]
    */
    public SysDepartment setParentName(String parentName) {
        this.parentName = parentName;
        this.modify("parent_name", parentName);
        return this;
    }

    /**
    * 设置 [组织机构标识]
    */
    public SysDepartment setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        this.modify("organization_id", organizationId);
        return this;
    }

    /**
    * 设置 [组织机构名称]
    */
    public SysDepartment setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        this.modify("organization_name", organizationName);
        return this;
    }

    /**
    * 设置 [机构编号]
    */
    public SysDepartment setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
        this.modify("organization_number", organizationNumber);
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