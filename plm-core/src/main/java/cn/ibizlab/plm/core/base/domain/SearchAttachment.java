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
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 附件搜索实体类[SearchAttachment]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "ATTACHMENT", resultMap = "SearchAttachmentResultMap")
@ApiModel(value = "SEARCH_ATTACHMENT", description = "附件搜索")
public class SearchAttachment extends EntityMP implements Serializable
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
    * 文件标识
    */
    @TableField(value = "file_id")
    @DEField(name = "file_id")
    @JSONField(name = "file_id")
    @JsonProperty("file_id")
    @ApiModelProperty(value = "file_id", notes = "文件标识")
    private String fileId;

    /**
    * 所属数据标题
    */
    @TableField(value = "owner_title" , exist = false)
    @DEField(name = "owner_title")
    @JSONField(name = "owner_title")
    @JsonProperty("owner_title")
    @ApiModelProperty(value = "owner_title", notes = "所属数据标题")
    private String ownerTitle;

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
    * 所属数据编号
    */
    @TableField(value = "owner_identifier" , exist = false)
    @DEField(name = "owner_identifier")
    @JSONField(name = "owner_identifier")
    @JsonProperty("owner_identifier")
    @ApiModelProperty(value = "owner_identifier", notes = "所属数据编号")
    private String ownerIdentifier;

    /**
    * 所属数据父标识
    */
    @TableField(value = "owner_parent_id" , exist = false)
    @DEField(name = "owner_parent_id")
    @JSONField(name = "owner_parent_id")
    @JsonProperty("owner_parent_id")
    @ApiModelProperty(value = "owner_parent_id", notes = "所属数据父标识")
    private String ownerParentId;

    /**
    * 所属数据父名称
    */
    @TableField(value = "owner_parent_name" , exist = false)
    @DEField(name = "owner_parent_name")
    @JSONField(name = "owner_parent_name")
    @JsonProperty("owner_parent_name")
    @ApiModelProperty(value = "owner_parent_name", notes = "所属数据父名称")
    private String ownerParentName;

    /**
    * 工作项
    */
    @Transient
    @TableField(exist = false)
    @DEField(name = "work_item")
    @JSONField(name = "work_item")
    @JsonProperty("work_item")
    @ApiModelProperty(value = "work_item", notes = "工作项")
    private WorkItem workItem;

    /**
    * 产品需求
    */
    @Transient
    @TableField(exist = false)
    @DEField(name = "idea")
    @JSONField(name = "idea")
    @JsonProperty("idea")
    @ApiModelProperty(value = "idea", notes = "产品需求")
    private Idea idea;

    /**
    * 工单
    */
    @Transient
    @TableField(exist = false)
    @DEField(name = "ticket")
    @JSONField(name = "ticket")
    @JsonProperty("ticket")
    @ApiModelProperty(value = "ticket", notes = "工单")
    private Ticket ticket;

    /**
    * 客户
    */
    @Transient
    @TableField(exist = false)
    @DEField(name = "customer")
    @JSONField(name = "customer")
    @JsonProperty("customer")
    @ApiModelProperty(value = "customer", notes = "客户")
    private Customer customer;

    /**
    * 测试用例
    */
    @Transient
    @TableField(exist = false)
    @DEField(name = "test_case")
    @JSONField(name = "test_case")
    @JsonProperty("test_case")
    @ApiModelProperty(value = "test_case", notes = "测试用例")
    private TestCase testCase;

    /**
    * 页面
    */
    @Transient
    @TableField(exist = false)
    @DEField(name = "page")
    @JSONField(name = "page")
    @JsonProperty("page")
    @ApiModelProperty(value = "page", notes = "页面")
    private ArticlePage page;

    /**
    * 标题
    */
    @TableField(value = "title")
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

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
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "der_customer", notes = "名称")
    private Customer derCustomer;

    /**
    * 需求-附件
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "der_idea", notes = "需求-附件")
    private Idea derIdea;

    /**
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "der_page", notes = "名称")
    private ArticlePage derPage;

    /**
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "der_test_case", notes = "名称")
    private TestCase derTestCase;

    /**
    * 名称
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "der_ticket", notes = "名称")
    private Ticket derTicket;

    /**
    * 工作项-附件
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "der_work_item", notes = "工作项-附件")
    private WorkItem derWorkItem;

    /**
    * 设置 [文件标识]
    */
    public SearchAttachment setFileId(String fileId) {
        this.fileId = fileId;
        this.modify("file_id", fileId);
        return this;
    }

    /**
    * 设置 [所属数据标题]
    */
    public SearchAttachment setOwnerTitle(String ownerTitle) {
        this.ownerTitle = ownerTitle;
        this.modify("owner_title", ownerTitle);
        return this;
    }

    /**
    * 设置 [所属数据编号]
    */
    public SearchAttachment setOwnerIdentifier(String ownerIdentifier) {
        this.ownerIdentifier = ownerIdentifier;
        this.modify("owner_identifier", ownerIdentifier);
        return this;
    }

    /**
    * 设置 [所属数据父标识]
    */
    public SearchAttachment setOwnerParentId(String ownerParentId) {
        this.ownerParentId = ownerParentId;
        this.modify("owner_parent_id", ownerParentId);
        return this;
    }

    /**
    * 设置 [所属数据父名称]
    */
    public SearchAttachment setOwnerParentName(String ownerParentName) {
        this.ownerParentName = ownerParentName;
        this.modify("owner_parent_name", ownerParentName);
        return this;
    }

    /**
    * 设置 [工作项]
    */
    public SearchAttachment setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
    * 设置 [产品需求]
    */
    public SearchAttachment setIdea(Idea idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
    * 设置 [工单]
    */
    public SearchAttachment setTicket(Ticket ticket) {
        this.ticket = ticket;
        this.modify("ticket", ticket);
        return this;
    }

    /**
    * 设置 [客户]
    */
    public SearchAttachment setCustomer(Customer customer) {
        this.customer = customer;
        this.modify("customer", customer);
        return this;
    }

    /**
    * 设置 [测试用例]
    */
    public SearchAttachment setTestCase(TestCase testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
    * 设置 [页面]
    */
    public SearchAttachment setPage(ArticlePage page) {
        this.page = page;
        this.modify("page", page);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public SearchAttachment setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public SearchAttachment setName(String name) {
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