/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
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
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 工时实体类[Workload]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "WORKLOAD", resultMap = "WorkloadResultMap")
@ApiModel(value = "WORKLOAD", description = "工时")
public class Workload extends EntityMP implements Serializable
{

    /**
    * 编号
    */
    @TableField(value = "identifier")
    @DEField(name = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
    * 工时主体标识
    */
    @TableField(value = "principal_id")
    @DEField(name = "principal_id" , preType = DEPredefinedFieldType.PARENTID)
    @JSONField(name = "principal_id")
    @JsonProperty("principal_id")
    @ApiModelProperty(value = "principal_id", notes = "工时主体标识")
    private String principalId;

    /**
    * 工时主体类型
    */
    @TableField(value = "principal_type")
    @DEField(name = "principal_type" , preType = DEPredefinedFieldType.PARENTSUBTYPE)
    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    @ApiModelProperty(value = "principal_type", notes = "工时主体类型")
    private String principalType;

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
    * 时长
    */
    @TableField(value = "duration")
    @DEField(name = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    @ApiModelProperty(value = "duration", notes = "时长")
    private BigDecimal duration;

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
    * 工作日期
    */
    @TableField(value = "register_date")
    @DEField(name = "register_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "register_date" , format = "yyyy-MM-dd")
    @JsonProperty("register_date")
    @ApiModelProperty(value = "register_date", notes = "工作日期")
    private Date registerDate;

    /**
    * 访问父类名称
    */
    @TableField(value = "recent_parent_name")
    @DEField(name = "recent_parent_name")
    @JSONField(name = "recent_parent_name")
    @JsonProperty("recent_parent_name")
    @ApiModelProperty(value = "recent_parent_name", notes = "访问父类名称")
    private String recentParentName;

    /**
    * 访问父类
    */
    @TableField(value = "recent_parent")
    @DEField(name = "recent_parent")
    @JSONField(name = "recent_parent")
    @JsonProperty("recent_parent")
    @ApiModelProperty(value = "recent_parent", notes = "访问父类")
    private String recentParent;

    /**
    * 编号
    */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JSONField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
    * 访问父类编号
    */
    @TableField(value = "recent_parent_identifier")
    @DEField(name = "recent_parent_identifier")
    @JSONField(name = "recent_parent_identifier")
    @JsonProperty("recent_parent_identifier")
    @ApiModelProperty(value = "recent_parent_identifier", notes = "访问父类编号")
    private String recentParentIdentifier;

    /**
    * 工作项
    */
    @TableField(exist = false)
    @DEField(name = "work_item")
    @JSONField(name = "work_item")
    @JsonProperty("work_item")
    @ApiModelProperty(value = "work_item", notes = "工作项")
    private WorkItem workItem;

    /**
    * 需求
    */
    @TableField(exist = false)
    @DEField(name = "idea")
    @JSONField(name = "idea")
    @JsonProperty("idea")
    @ApiModelProperty(value = "idea", notes = "需求")
    private Idea idea;

    /**
    * 用例
    */
    @TableField(exist = false)
    @DEField(name = "test_case")
    @JSONField(name = "test_case")
    @JsonProperty("test_case")
    @ApiModelProperty(value = "test_case", notes = "用例")
    private TestCase testCase;

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
    * 事项
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "事项")
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
    * 类别
    */
    @TableField(value = "type_id")
    @DEField(name = "type_id")
    @JSONField(name = "type_id")
    @JsonProperty("type_id")
    @ApiModelProperty(value = "type_id", notes = "类别")
    private String typeId;

    /**
    * 名称
    */
    @TableField(value = "type_name" , exist = false)
    @DEField(name = "type_name")
    @JSONField(name = "type_name")
    @JsonProperty("type_name")
    @ApiModelProperty(value = "type_name", notes = "名称")
    private String typeName;

    /**
    * 工时
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "workload_type", notes = "工时")
    private WorkloadType workloadType;

    /**
    * 需求-工时
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "rel_idea", notes = "需求-工时")
    private Idea relIdea;

    /**
    * 用例-工时
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "rel_test_case", notes = "用例-工时")
    private TestCase relTestCase;

    /**
    * 工作项-工时
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "rel_work_item", notes = "工作项-工时")
    private WorkItem relWorkItem;

    /**
    * 设置 [编号]
    */
    public Workload setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [时长]
    */
    public Workload setDuration(BigDecimal duration) {
        this.duration = duration;
        this.modify("duration", duration);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public Workload setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [工作日期]
    */
    public Workload setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
        this.modify("register_date", registerDate);
        return this;
    }

    /**
    * 设置 [访问父类名称]
    */
    public Workload setRecentParentName(String recentParentName) {
        this.recentParentName = recentParentName;
        this.modify("recent_parent_name", recentParentName);
        return this;
    }

    /**
    * 设置 [访问父类]
    */
    public Workload setRecentParent(String recentParent) {
        this.recentParent = recentParent;
        this.modify("recent_parent", recentParent);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public Workload setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [访问父类编号]
    */
    public Workload setRecentParentIdentifier(String recentParentIdentifier) {
        this.recentParentIdentifier = recentParentIdentifier;
        this.modify("recent_parent_identifier", recentParentIdentifier);
        return this;
    }

    /**
    * 设置 [工作项]
    */
    public Workload setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
    * 设置 [需求]
    */
    public Workload setIdea(Idea idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
    * 设置 [用例]
    */
    public Workload setTestCase(TestCase testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
    * 设置 [事项]
    */
    public Workload setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public Workload setTypeId(String typeId) {
        this.typeId = typeId;
        this.modify("type_id", typeId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Workload setTypeName(String typeName) {
        this.typeName = typeName;
        this.modify("type_name", typeName);
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