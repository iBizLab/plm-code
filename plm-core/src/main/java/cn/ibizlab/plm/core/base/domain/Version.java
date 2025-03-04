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
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;

/**
 * 版本实体类[Version]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "VERSION", resultMap = "VersionResultMap")
@ApiModel(value = "VERSION", description = "版本")
public class Version extends EntityMP implements Serializable
{

    /**
    * 描述
    */
    @TableField(value = "description")
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

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
    * 所属数据对象
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
    * 版本
    */
    @TableField(value = "identifier")
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "版本")
    private BigDecimal identifier;

    /**
    * 数据
    */
    @TableField(value = "data")
    @DEField(name = "data")
    @JSONField(name = "data")
    @JsonProperty("data")
    @ApiModelProperty(value = "data", notes = "数据")
    private String data;

    /**
    * 支持恢复
    */
    @TableField(value = "restorable")
    @DEField(name = "restorable")
    @JSONField(name = "restorable")
    @JsonProperty("restorable")
    @ApiModelProperty(value = "restorable", notes = "支持恢复")
    private String restorable;

    /**
    * 手动提交
    */
    @TableField(value = "manual")
    @DEField(name = "manual" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "manual")
    @JsonProperty("manual")
    @ApiModelProperty(value = "manual", notes = "手动提交")
    private Integer manual;

    /**
    * 是否命名
    */
    @TableField(value = "is_named")
    @DEField(name = "is_named" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_named")
    @JsonProperty("is_named")
    @ApiModelProperty(value = "is_named", notes = "是否命名")
    private Integer isNamed;

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
    * 需求-版本
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "idea", notes = "需求-版本")
    private Idea idea;

    /**
    * 页面-版本
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "page", notes = "页面-版本")
    private ArticlePage page;

    /**
    * 测试用例-版本
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "test_case", notes = "测试用例-版本")
    private TestCase testCase;

    /**
    * 工作项-版本
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "work_item", notes = "工作项-版本")
    private WorkItem workItem;

    /**
    * 设置 [描述]
    */
    public Version setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [版本]
    */
    public Version setIdentifier(BigDecimal identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [数据]
    */
    public Version setData(String data) {
        this.data = data;
        this.modify("data", data);
        return this;
    }

    /**
    * 设置 [支持恢复]
    */
    public Version setRestorable(String restorable) {
        this.restorable = restorable;
        this.modify("restorable", restorable);
        return this;
    }

    /**
    * 设置 [手动提交]
    */
    public Version setManual(Integer manual) {
        this.manual = manual;
        this.modify("manual", manual);
        return this;
    }

    /**
    * 设置 [是否命名]
    */
    public Version setIsNamed(Integer isNamed) {
        this.isNamed = isNamed;
        this.modify("is_named", isNamed);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Version setName(String name) {
        this.name = name;
        this.modify("name", name);
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