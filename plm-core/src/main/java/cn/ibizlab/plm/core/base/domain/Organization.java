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
import cn.ibizlab.plm.core.base.domain.User;

/**
 * 组织实体类[Organization]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "ORGANIZATION", description = "组织")
public class Organization extends EntityBase implements Serializable
{
    /**
     * 机构编号
     */
    @DEField(name = "organization_number" , dupCheck = DupCheck.ALL)
    @JSONField(name = "organization_number")
    @JsonProperty("organization_number")
    @ApiModelProperty(value = "organization_number", notes = "机构编号")
    private String organizationNumber;

    /**
     * 简称
     */
    @DEField(name = "short_name")
    @JSONField(name = "short_name")
    @JsonProperty("short_name")
    @ApiModelProperty(value = "short_name", notes = "简称")
    private String shortName;

    /**
     * 描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

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
     * 逻辑有效标志
     */
    @DEField(name = "enable" , preType = DEPredefinedFieldType.LOGICVALID , logicval = "1" , logicdelval = "0")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    @ApiModelProperty(value = "enable", notes = "逻辑有效标志")
    private Integer enable;

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
     * 父标识
     */
    @DEField(name = "pid")
    @JSONField(name = "pid")
    @JsonProperty("pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
     * 名称
     */
    @DEField(name = "pname")
    @JSONField(name = "pname")
    @JsonProperty("pname")
    @ApiModelProperty(value = "pname", notes = "名称")
    private String pname;

    /**
     * 名称
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "organization", notes = "名称")
    private Organization organization;

    /**
    * 设置 [机构编号]
    */
    public Organization setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
        this.modify("organization_number", organizationNumber);
        return this;
    }

    /**
    * 设置 [简称]
    */
    public Organization setShortName(String shortName) {
        this.shortName = shortName;
        this.modify("short_name", shortName);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Organization setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [排序]
    */
    public Organization setSort(Long sort) {
        this.sort = sort;
        this.modify("sort", sort);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Organization setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public Organization setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Organization setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
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