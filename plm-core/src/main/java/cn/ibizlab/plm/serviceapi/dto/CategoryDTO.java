/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
 * 类别[CategoryDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("类别DTO")
public class CategoryDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 0)
    private String ownerId;

    /**
     * 序号
     */
    @JsonProperty("sequence")
    @JSONField(name = "sequence")
    @ApiModelProperty(value = "序号", position = 1)
    private BigDecimal sequence;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 2)
    private String ownerType;

    /**
     * 所属对象子类型
     */
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "所属对象子类型", position = 3)
    private String ownerSubtype;

    /**
     * 是否叶子节点
     */
    @JsonProperty("is_leaf")
    @JSONField(name = "is_leaf")
    @ApiModelProperty(value = "是否叶子节点", position = 4)
    private Integer isLeaf;

    /**
     * 是否叶子节点2
     */
    @JsonProperty("is_leaf2")
    @JSONField(name = "is_leaf2")
    @ApiModelProperty(value = "是否叶子节点2", position = 5)
    private Integer isLeaf2;

    /**
     * 类别路径
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别路径", position = 6)
    private String categories;

    /**
     * 叶子节点标识
     */
    @JsonProperty("leaf_flag")
    @JSONField(name = "leaf_flag")
    @ApiModelProperty(value = "叶子节点标识", position = 7)
    private Integer leafFlag;

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
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 11)
    private String name;

    /**
     * 父标识
     */
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "父标识", position = 12)
    private String pid;

    /**
     * 分组标识
     */
    @JsonProperty("section_id")
    @JSONField(name = "section_id")
    @ApiModelProperty(value = "分组标识", position = 13)
    private String sectionId;

    /**
     * 名称
     */
    @JsonProperty("section_name")
    @JSONField(name = "section_name")
    @ApiModelProperty(value = "名称", position = 14)
    private String sectionName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 15)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 16)
    private Date updateTime;


    /**
     * 设置 [序号]
     */
    public CategoryDTO setSequence(BigDecimal sequence) {
        this.sequence = sequence;
        this.modify("sequence", sequence);
        return this;
    }

    /**
     * 设置 [是否叶子节点]
     */
    public CategoryDTO setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
     * 设置 [是否叶子节点2]
     */
    public CategoryDTO setIsLeaf2(Integer isLeaf2) {
        this.isLeaf2 = isLeaf2;
        this.modify("is_leaf2", isLeaf2);
        return this;
    }

    /**
     * 设置 [叶子节点标识]
     */
    public CategoryDTO setLeafFlag(Integer leafFlag) {
        this.leafFlag = leafFlag;
        this.modify("leaf_flag", leafFlag);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public CategoryDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public CategoryDTO setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
     * 设置 [分组标识]
     */
    public CategoryDTO setSectionId(String sectionId) {
        this.sectionId = sectionId;
        this.modify("section_id", sectionId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public CategoryDTO setSectionName(String sectionName) {
        this.sectionName = sectionName;
        this.modify("section_name", sectionName);
        return this;
    }


}
