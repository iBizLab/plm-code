/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

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
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;

/**
 * 关联实体类[Relation]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "RELATION", resultMap = "RelationResultMap")
@ApiModel(value = "RELATION", description = "关联")
public class Relation extends EntityMP implements Serializable
{

    /**
    * 关联主体标识
    */
    @TableField(value = "principal_id")
    @DEField(name = "principal_id")
    @JSONField(name = "principal_id")
    @JsonProperty("principal_id")
    @ApiModelProperty(value = "principal_id", notes = "关联主体标识")
    private String principalId;

    /**
    * 关联主体类型
    */
    @TableField(value = "principal_type")
    @DEField(name = "principal_type")
    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    @ApiModelProperty(value = "principal_type", notes = "关联主体类型")
    private String principalType;

    /**
    * 所属数据对象
    */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
    * 关联目标类型
    */
    @TableField(value = "target_type")
    @DEField(name = "target_type")
    @JSONField(name = "target_type")
    @JsonProperty("target_type")
    @ApiModelProperty(value = "target_type", notes = "关联目标类型")
    private String targetType;

    /**
    * 关联目标标识
    */
    @TableField(value = "target_id")
    @DEField(name = "target_id")
    @JSONField(name = "target_id")
    @JsonProperty("target_id")
    @ApiModelProperty(value = "target_id", notes = "关联目标标识")
    private String targetId;

    /**
    * 父对象版本标识
    */
    @TableField(value = "parent_version_id")
    @DEField(name = "parent_version_id" , preType = DEPredefinedFieldType.PARENTVERSIONID)
    @JSONField(name = "parent_version_id")
    @JsonProperty("parent_version_id")
    @ApiModelProperty(value = "parent_version_id", notes = "父对象版本标识")
    private String parentVersionId;

    /**
    * 目标对象版本标识
    */
    @TableField(value = "target_version_id")
    @DEField(name = "target_version_id")
    @JSONField(name = "target_version_id")
    @JsonProperty("target_version_id")
    @ApiModelProperty(value = "target_version_id", notes = "目标对象版本标识")
    private String targetVersionId;

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
    * 产品需求
    */
    @TableField(exist = false)
    @DEField(name = "idea")
    @JSONField(name = "idea")
    @JsonProperty("idea")
    @ApiModelProperty(value = "idea", notes = "产品需求")
    private Idea idea;

    /**
    * 工单
    */
    @TableField(exist = false)
    @DEField(name = "ticket")
    @JSONField(name = "ticket")
    @JsonProperty("ticket")
    @ApiModelProperty(value = "ticket", notes = "工单")
    private Ticket ticket;

    /**
    * 客户
    */
    @TableField(exist = false)
    @DEField(name = "customer")
    @JSONField(name = "customer")
    @JsonProperty("customer")
    @ApiModelProperty(value = "customer", notes = "客户")
    private Customer customer;

    /**
    * 测试用例
    */
    @TableField(exist = false)
    @DEField(name = "test_case")
    @JSONField(name = "test_case")
    @JsonProperty("test_case")
    @ApiModelProperty(value = "test_case", notes = "测试用例")
    private TestCase testCase;

    /**
    * 当前版本标识
    */
    @TableField(value = "cur_version_id")
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
    * 目标对象编号
    */
    @TableField(value = "target_identifier" , exist = false)
    @DEField(name = "target_identifier")
    @JSONField(name = "target_identifier")
    @JsonProperty("target_identifier")
    @ApiModelProperty(value = "target_identifier", notes = "目标对象编号")
    private String targetIdentifier;

    /**
    * 目标对象标题
    */
    @TableField(value = "target_title" , exist = false)
    @DEField(name = "target_title")
    @JSONField(name = "target_title")
    @JsonProperty("target_title")
    @ApiModelProperty(value = "target_title", notes = "目标对象标题")
    private String targetTitle;

    /**
    * 目标对象状态
    */
    @TableField(value = "target_state" , exist = false)
    @DEField(name = "target_state")
    @JSONField(name = "target_state")
    @JsonProperty("target_state")
    @ApiModelProperty(value = "target_state", notes = "目标对象状态")
    private String targetState;

    /**
    * 目标对象负责人
    */
    @TableField(value = "target_assignee" , exist = false)
    @DEField(name = "target_assignee")
    @JSONField(name = "target_assignee")
    @JsonProperty("target_assignee")
    @ApiModelProperty(value = "target_assignee", notes = "目标对象负责人")
    private String targetAssignee;

    /**
    * 关联类型
    */
    @TableField(value = "relation_type")
    @DEField(name = "relation_type")
    @JSONField(name = "relation_type")
    @JsonProperty("relation_type")
    @ApiModelProperty(value = "relation_type", notes = "关联类型")
    private String relationType;

    /**
    * 目标对象优先级
    */
    @TableField(value = "target_priority" , exist = false)
    @DEField(name = "target_priority")
    @JSONField(name = "target_priority")
    @JsonProperty("target_priority")
    @ApiModelProperty(value = "target_priority", notes = "目标对象优先级")
    private String targetPriority;

    /**
    * 目标对象父标识
    */
    @TableField(value = "target_parent_id" , exist = false)
    @DEField(name = "target_parent_id")
    @JSONField(name = "target_parent_id")
    @JsonProperty("target_parent_id")
    @ApiModelProperty(value = "target_parent_id", notes = "目标对象父标识")
    private String targetParentId;

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
    * 基线-关联
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "principal_baseline", notes = "基线-关联")
    private Baseline principalBaseline;

    /**
    * 产品需求-关联源
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "principal_idea", notes = "产品需求-关联源")
    private Idea principalIdea;

    /**
    * 评审-关联
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "principal_review", notes = "评审-关联")
    private Review principalReview;

    /**
    * 评审内容扩展-关联
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "review_content_extend", notes = "评审内容扩展-关联")
    private ReviewContentExtend reviewContentExtend;

    /**
    * 客户-关联目标
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "target_customer", notes = "客户-关联目标")
    private Customer targetCustomer;

    /**
    * 需求-关联目标
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "target_idea", notes = "需求-关联目标")
    private Idea targetIdea;

    /**
    * 页面-关联目标
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "target_page", notes = "页面-关联目标")
    private ArticlePage targetPage;

    /**
    * 排期-关联目标
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "target_product_plan_category", notes = "排期-关联目标")
    private ProductPlan targetProductPlanCategory;

    /**
    * 用例-关联目标
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "target_test_case", notes = "用例-关联目标")
    private TestCase targetTestCase;

    /**
    * 工单-关联目标
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "target_ticket", notes = "工单-关联目标")
    private Ticket targetTicket;

    /**
    * 工作项-关联目标
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "target_work_item", notes = "工作项-关联目标")
    private WorkItem targetWorkItem;

    /**
    * 测试用例-关联源
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "principal_test_case", notes = "测试用例-关联源")
    private TestCase principalTestCase;

    /**
    * 测试计划-关联
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "principal_test_plan", notes = "测试计划-关联")
    private TestPlan principalTestPlan;

    /**
    * 工作项-关联源
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "principal_work_item", notes = "工作项-关联源")
    private WorkItem principalWorkItem;

    /**
    * 设置 [关联主体标识]
    */
    public Relation setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
    * 设置 [关联主体类型]
    */
    public Relation setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
    * 设置 [所属数据对象]
    */
    public Relation setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
    * 设置 [关联目标类型]
    */
    public Relation setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
    * 设置 [关联目标标识]
    */
    public Relation setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
    * 设置 [目标对象版本标识]
    */
    public Relation setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
    * 设置 [工作项]
    */
    public Relation setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
    * 设置 [产品需求]
    */
    public Relation setIdea(Idea idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
    * 设置 [工单]
    */
    public Relation setTicket(Ticket ticket) {
        this.ticket = ticket;
        this.modify("ticket", ticket);
        return this;
    }

    /**
    * 设置 [客户]
    */
    public Relation setCustomer(Customer customer) {
        this.customer = customer;
        this.modify("customer", customer);
        return this;
    }

    /**
    * 设置 [测试用例]
    */
    public Relation setTestCase(TestCase testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
    * 设置 [目标对象编号]
    */
    public Relation setTargetIdentifier(String targetIdentifier) {
        this.targetIdentifier = targetIdentifier;
        this.modify("target_identifier", targetIdentifier);
        return this;
    }

    /**
    * 设置 [目标对象标题]
    */
    public Relation setTargetTitle(String targetTitle) {
        this.targetTitle = targetTitle;
        this.modify("target_title", targetTitle);
        return this;
    }

    /**
    * 设置 [目标对象状态]
    */
    public Relation setTargetState(String targetState) {
        this.targetState = targetState;
        this.modify("target_state", targetState);
        return this;
    }

    /**
    * 设置 [目标对象负责人]
    */
    public Relation setTargetAssignee(String targetAssignee) {
        this.targetAssignee = targetAssignee;
        this.modify("target_assignee", targetAssignee);
        return this;
    }

    /**
    * 设置 [关联类型]
    */
    public Relation setRelationType(String relationType) {
        this.relationType = relationType;
        this.modify("relation_type", relationType);
        return this;
    }

    /**
    * 设置 [目标对象优先级]
    */
    public Relation setTargetPriority(String targetPriority) {
        this.targetPriority = targetPriority;
        this.modify("target_priority", targetPriority);
        return this;
    }

    /**
    * 设置 [目标对象父标识]
    */
    public Relation setTargetParentId(String targetParentId) {
        this.targetParentId = targetParentId;
        this.modify("target_parent_id", targetParentId);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Relation setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getPrincipalId(),"未设置关联主体标识");
        //Assert.notNull(getTargetId(),"未设置关联目标标识");
        String key = String.format("%s||%s"
            ,getPrincipalId(),getTargetId());
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