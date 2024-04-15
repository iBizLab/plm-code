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
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;

/**
 * 评论搜索实体类[SearchComment]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "COMMENT", resultMap = "SearchCommentResultMap")
@ApiModel(value = "SEARCH_COMMENT", description = "评论搜索")
public class SearchComment extends EntityMP implements Serializable
{

    /**
     * 评论主体标识
     */
    @TableField(value = "principal_id")
    @DEField(name = "principal_id" , preType = DEPredefinedFieldType.PARENTID)
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "principal_id", notes = "评论主体标识")
    private String principalId;

    /**
     * 评论主体名称
     */
    @TableField(value = "principal_name")
    @DEField(name = "principal_name" , preType = DEPredefinedFieldType.PARENTNAME)
    @JsonProperty("principal_name")
    @JSONField(name = "principal_name")
    @ApiModelProperty(value = "principal_name", notes = "评论主体名称")
    private String principalName;

    /**
     * 评论主体类型
     */
    @TableField(value = "principal_type")
    @DEField(name = "principal_type" , preType = DEPredefinedFieldType.PARENTSUBTYPE , dict = "principal_type")
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "principal_type", notes = "评论主体类型")
    private String principalType;

    /**
     * 所属数据对象
     */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 内容
     */
    @TableField(value = "content")
    @DEField(name = "content")
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "content", notes = "内容")
    private String content;

    /**
     * 评论主体标题
     */
    @TableField(value = "principal_title" , exist = false)
    @DEField(name = "principal_title")
    @JsonProperty("principal_title")
    @JSONField(name = "principal_title")
    @ApiModelProperty(value = "principal_title", notes = "评论主体标题")
    private String principalTitle;

    /**
     * 评论主体编号
     */
    @TableField(value = "principal_identifier" , exist = false)
    @DEField(name = "principal_identifier")
    @JsonProperty("principal_identifier")
    @JSONField(name = "principal_identifier")
    @ApiModelProperty(value = "principal_identifier", notes = "评论主体编号")
    private String principalIdentifier;

    /**
     * 评论主体父标识
     */
    @TableField(value = "principal_parent_id" , exist = false)
    @DEField(name = "principal_parent_id")
    @JsonProperty("principal_parent_id")
    @JSONField(name = "principal_parent_id")
    @ApiModelProperty(value = "principal_parent_id", notes = "评论主体父标识")
    private String principalParentId;

    /**
     * 评论主体父名称
     */
    @TableField(value = "principal_parent_name" , exist = false)
    @DEField(name = "principal_parent_name")
    @JsonProperty("principal_parent_name")
    @JSONField(name = "principal_parent_name")
    @ApiModelProperty(value = "principal_parent_name", notes = "评论主体父名称")
    private String principalParentName;

    /**
     * 工作项
     */
    @TableField(exist = false)
    @DEField(name = "work_item")
    @JsonProperty("work_item")
    @JSONField(name = "work_item")
    @ApiModelProperty(value = "work_item", notes = "工作项")
    private WorkItem workItem;

    /**
     * 产品需求
     */
    @TableField(exist = false)
    @DEField(name = "idea")
    @JsonProperty("idea")
    @JSONField(name = "idea")
    @ApiModelProperty(value = "idea", notes = "产品需求")
    private Idea idea;

    /**
     * 工单
     */
    @TableField(exist = false)
    @DEField(name = "ticket")
    @JsonProperty("ticket")
    @JSONField(name = "ticket")
    @ApiModelProperty(value = "ticket", notes = "工单")
    private Ticket ticket;

    /**
     * 客户
     */
    @TableField(exist = false)
    @DEField(name = "customer")
    @JsonProperty("customer")
    @JSONField(name = "customer")
    @ApiModelProperty(value = "customer", notes = "客户")
    private Customer customer;

    /**
     * 测试用例
     */
    @TableField(exist = false)
    @DEField(name = "test_case")
    @JsonProperty("test_case")
    @JSONField(name = "test_case")
    @ApiModelProperty(value = "test_case", notes = "测试用例")
    private TestCase testCase;

    /**
     * 执行用例
     */
    @TableField(exist = false)
    @DEField(name = "run")
    @JsonProperty("run")
    @JSONField(name = "run")
    @ApiModelProperty(value = "run", notes = "执行用例")
    private Run run;

    /**
     * 页面
     */
    @TableField(exist = false)
    @DEField(name = "page")
    @JsonProperty("page")
    @JSONField(name = "page")
    @ApiModelProperty(value = "page", notes = "页面")
    private ArticlePage page;

    /**
     * 标识
     */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 建立时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 客户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "der_customer", notes = "名称")
    private Customer derCustomer;

    /**
     * 需求
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "der_idea", notes = "产品需求-评论")
    private Idea derIdea;

    /**
     * 页面
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "der_page", notes = "名称")
    private ArticlePage derPage;

    /**
     * 执行用例
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "der_run", notes = "名称")
    private Run derRun;

    /**
     * 用例
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "der_test_case", notes = "名称")
    private TestCase derTestCase;

    /**
     * 工单
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "der_ticket", notes = "工单-评论")
    private Ticket derTicket;

    /**
     * 工作项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "der_work_item", notes = "工作项-评论")
    private WorkItem derWorkItem;

    /**
     * 设置 [内容]
     */
    public SearchComment setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [评论主体标题]
     */
    public SearchComment setPrincipalTitle(String principalTitle) {
        this.principalTitle = principalTitle;
        this.modify("principal_title", principalTitle);
        return this;
    }

    /**
     * 设置 [评论主体编号]
     */
    public SearchComment setPrincipalIdentifier(String principalIdentifier) {
        this.principalIdentifier = principalIdentifier;
        this.modify("principal_identifier", principalIdentifier);
        return this;
    }

    /**
     * 设置 [评论主体父标识]
     */
    public SearchComment setPrincipalParentId(String principalParentId) {
        this.principalParentId = principalParentId;
        this.modify("principal_parent_id", principalParentId);
        return this;
    }

    /**
     * 设置 [评论主体父名称]
     */
    public SearchComment setPrincipalParentName(String principalParentName) {
        this.principalParentName = principalParentName;
        this.modify("principal_parent_name", principalParentName);
        return this;
    }

    /**
     * 设置 [工作项]
     */
    public SearchComment setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
     * 设置 [产品需求]
     */
    public SearchComment setIdea(Idea idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
     * 设置 [工单]
     */
    public SearchComment setTicket(Ticket ticket) {
        this.ticket = ticket;
        this.modify("ticket", ticket);
        return this;
    }

    /**
     * 设置 [客户]
     */
    public SearchComment setCustomer(Customer customer) {
        this.customer = customer;
        this.modify("customer", customer);
        return this;
    }

    /**
     * 设置 [测试用例]
     */
    public SearchComment setTestCase(TestCase testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
     * 设置 [执行用例]
     */
    public SearchComment setRun(Run run) {
        this.run = run;
        this.modify("run", run);
        return this;
    }

    /**
     * 设置 [页面]
     */
    public SearchComment setPage(ArticlePage page) {
        this.page = page;
        this.modify("page", page);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public SearchComment setName(String name) {
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