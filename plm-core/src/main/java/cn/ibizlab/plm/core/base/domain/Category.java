/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.base.domain.Section;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate;
import cn.ibizlab.plm.core.base.domain.Position;
import cn.ibizlab.plm.core.wiki.domain.Space;

/**
 * 类别实体类[Category]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "CATEGORY", resultMap = "CategoryResultMap")
@ApiModel(value = "CATEGORY", description = "类别")
public class Category extends EntityMP implements Serializable
{

    /**
    * 所属数据标识
    */
    @TableField(value = "owner_id")
    @DEField(name = "owner_id" , preType = DEPredefinedFieldType.PARENTID)
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty(value = "owner_id", notes = "所属数据标识")
    private String ownerId;

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , defaultValue = "1" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 所属数据对象
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
    * 所属对象子类型
    */
    @TableField(value = "owner_subtype")
    @DEField(name = "owner_subtype" , preType = DEPredefinedFieldType.PARENTSUBTYPE)
    @JSONField(name = "owner_subtype")
    @JsonProperty("owner_subtype")
    @ApiModelProperty(value = "owner_subtype", notes = "所属对象子类型")
    private String ownerSubtype;

    /**
    * 是否叶子节点
    */
    @TableField(value = "is_leaf")
    @DEField(name = "is_leaf" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "is_leaf")
    @JsonProperty("is_leaf")
    @ApiModelProperty(value = "is_leaf", notes = "是否叶子节点")
    private Integer isLeaf;

    /**
    * 是否叶子节点2
    */
    @TableField(value = "is_leaf2")
    @DEField(name = "is_leaf2" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "is_leaf2")
    @JsonProperty("is_leaf2")
    @ApiModelProperty(value = "is_leaf2", notes = "是否叶子节点2")
    private Integer isLeaf2;

    /**
    * 类别路径
    */
    @TableField(value = "categories")
    @DEField(name = "categories" , preType = DEPredefinedFieldType.PARENTIDPATH)
    @JSONField(name = "categories")
    @JsonProperty("categories")
    @ApiModelProperty(value = "categories", notes = "类别路径")
    private String categories;

    /**
    * 叶子节点标识
    */
    @TableField(value = "leaf_flag" , exist = false)
    @DEField(name = "leaf_flag")
    @JSONField(name = "leaf_flag")
    @JsonProperty("leaf_flag")
    @ApiModelProperty(value = "leaf_flag", notes = "叶子节点标识")
    private Integer leafFlag;

    /**
    * 是否叶子节点3
    */
    @TableField(value = "is_leaf3")
    @DEField(name = "is_leaf3" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "is_leaf3")
    @JsonProperty("is_leaf3")
    @ApiModelProperty(value = "is_leaf3", notes = "是否叶子节点3")
    private Integer isLeaf3;

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
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
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
    * 分组标识
    */
    @TableField(value = "section_id")
    @DEField(name = "section_id")
    @JSONField(name = "section_id")
    @JsonProperty("section_id")
    @ApiModelProperty(value = "section_id", notes = "分组标识")
    private String sectionId;

    /**
    * 名称
    */
    @TableField(value = "section_name" , exist = false)
    @DEField(name = "section_name")
    @JSONField(name = "section_name")
    @JsonProperty("section_name")
    @ApiModelProperty(value = "section_name", notes = "名称")
    private String sectionName;

    /**
    * 父标识
    */
    @TableField(value = "pid")
    @DEField(name = "pid")
    @JSONField(name = "pid")
    @JsonProperty("pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
    * 父类别
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "category", notes = "父类别")
    private Category category;

    /**
    * 分组-类别
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "section", notes = "分组-类别")
    private Section section;

    /**
    * 设置 [是否叶子节点]
    */
    public Category setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
    * 设置 [是否叶子节点2]
    */
    public Category setIsLeaf2(Integer isLeaf2) {
        this.isLeaf2 = isLeaf2;
        this.modify("is_leaf2", isLeaf2);
        return this;
    }

    /**
    * 设置 [叶子节点标识]
    */
    public Category setLeafFlag(Integer leafFlag) {
        this.leafFlag = leafFlag;
        this.modify("leaf_flag", leafFlag);
        return this;
    }

    /**
    * 设置 [是否叶子节点3]
    */
    public Category setIsLeaf3(Integer isLeaf3) {
        this.isLeaf3 = isLeaf3;
        this.modify("is_leaf3", isLeaf3);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Category setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [分组标识]
    */
    public Category setSectionId(String sectionId) {
        this.sectionId = sectionId;
        this.modify("section_id", sectionId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Category setSectionName(String sectionName) {
        this.sectionName = sectionName;
        this.modify("section_name", sectionName);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public Category setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
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