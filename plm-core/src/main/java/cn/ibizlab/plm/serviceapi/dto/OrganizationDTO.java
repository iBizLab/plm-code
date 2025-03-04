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
 * 组织[OrganizationDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("组织DTO")
public class OrganizationDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构编号
     */
    @JsonProperty("organization_number")
    @JSONField(name = "organization_number")
    @ApiModelProperty(value = "机构编号", position = 0)
    private String organizationNumber;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 1)
    private String description;

    /**
     * 简称
     */
    @JsonProperty("short_name")
    @JSONField(name = "short_name")
    @ApiModelProperty(value = "简称", position = 2)
    private String shortName;

    /**
     * 排序
     */
    @JsonProperty("sort")
    @JSONField(name = "sort")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "排序", position = 3)
    private Long sort;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 4)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 5)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 6)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 7)
    private String name;

    /**
     * 父标识
     */
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "父标识", position = 8)
    private String pid;

    /**
     * 名称
     */
    @JsonProperty("pname")
    @JSONField(name = "pname")
    @ApiModelProperty(value = "名称", position = 9)
    private String pname;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 10)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 11)
    private Date updateTime;


    /**
     * 设置 [机构编号]
     */
    public OrganizationDTO setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
        this.modify("organization_number", organizationNumber);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public OrganizationDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [简称]
     */
    public OrganizationDTO setShortName(String shortName) {
        this.shortName = shortName;
        this.modify("short_name", shortName);
        return this;
    }

    /**
     * 设置 [排序]
     */
    public OrganizationDTO setSort(Long sort) {
        this.sort = sort;
        this.modify("sort", sort);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public OrganizationDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public OrganizationDTO setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public OrganizationDTO setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
        return this;
    }


}
