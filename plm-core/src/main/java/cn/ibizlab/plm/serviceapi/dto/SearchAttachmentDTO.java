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
 * 附件搜索[SearchAttachmentDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("附件搜索DTO")
public class SearchAttachmentDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属数据标识
     */
    @JsonProperty("owner_id")
    @JSONField(name = "owner_id")
    @ApiModelProperty(value = "所属数据标识", position = 0)
    private String ownerId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 1)
    private String ownerType;

    /**
     * 所属对象子类型
     */
    @JsonProperty("owner_subtype")
    @JSONField(name = "owner_subtype")
    @ApiModelProperty(value = "所属对象子类型", position = 2)
    private String ownerSubtype;

    /**
     * 文件标识
     */
    @JsonProperty("file_id")
    @JSONField(name = "file_id")
    @ApiModelProperty(value = "文件标识", position = 3)
    private String fileId;

    /**
     * 所属数据标题
     */
    @JsonProperty("owner_title")
    @JSONField(name = "owner_title")
    @ApiModelProperty(value = "所属数据标题", position = 4)
    private String ownerTitle;

    /**
     * 父对象版本标识
     */
    @JsonProperty("parent_version_id")
    @JSONField(name = "parent_version_id")
    @ApiModelProperty(value = "父对象版本标识", position = 5)
    private String parentVersionId;

    /**
     * 所属数据编号
     */
    @JsonProperty("owner_identifier")
    @JSONField(name = "owner_identifier")
    @ApiModelProperty(value = "所属数据编号", position = 6)
    private String ownerIdentifier;

    /**
     * 所属数据父标识
     */
    @JsonProperty("owner_parent_id")
    @JSONField(name = "owner_parent_id")
    @ApiModelProperty(value = "所属数据父标识", position = 7)
    private String ownerParentId;

    /**
     * 所属数据父名称
     */
    @JsonProperty("owner_parent_name")
    @JSONField(name = "owner_parent_name")
    @ApiModelProperty(value = "所属数据父名称", position = 8)
    private String ownerParentName;

    /**
     * 工作项
     */
    @JsonProperty("work_item")
    @JSONField(name = "work_item")
    @ApiModelProperty(value = "工作项", position = 9)
    private WorkItemDTO workItem;

    /**
     * 产品需求
     */
    @JsonProperty("idea")
    @JSONField(name = "idea")
    @ApiModelProperty(value = "产品需求", position = 10)
    private IdeaDTO idea;

    /**
     * 工单
     */
    @JsonProperty("ticket")
    @JSONField(name = "ticket")
    @ApiModelProperty(value = "工单", position = 11)
    private TicketDTO ticket;

    /**
     * 客户
     */
    @JsonProperty("customer")
    @JSONField(name = "customer")
    @ApiModelProperty(value = "客户", position = 12)
    private CustomerDTO customer;

    /**
     * 测试用例
     */
    @JsonProperty("test_case")
    @JSONField(name = "test_case")
    @ApiModelProperty(value = "测试用例", position = 13)
    private TestCaseDTO testCase;

    /**
     * 页面
     */
    @JsonProperty("page")
    @JSONField(name = "page")
    @ApiModelProperty(value = "页面", position = 14)
    private ArticlePageDTO page;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 15)
    private String title;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 16)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 17)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 18)
    private String id;

    /**
     * 文件名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "文件名称", position = 19)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 20)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 21)
    private Date updateTime;


    /**
     * 设置 [文件标识]
     */
    public SearchAttachmentDTO setFileId(String fileId) {
        this.fileId = fileId;
        this.modify("file_id", fileId);
        return this;
    }

    /**
     * 设置 [所属数据标题]
     */
    public SearchAttachmentDTO setOwnerTitle(String ownerTitle) {
        this.ownerTitle = ownerTitle;
        this.modify("owner_title", ownerTitle);
        return this;
    }

    /**
     * 设置 [所属数据编号]
     */
    public SearchAttachmentDTO setOwnerIdentifier(String ownerIdentifier) {
        this.ownerIdentifier = ownerIdentifier;
        this.modify("owner_identifier", ownerIdentifier);
        return this;
    }

    /**
     * 设置 [所属数据父标识]
     */
    public SearchAttachmentDTO setOwnerParentId(String ownerParentId) {
        this.ownerParentId = ownerParentId;
        this.modify("owner_parent_id", ownerParentId);
        return this;
    }

    /**
     * 设置 [所属数据父名称]
     */
    public SearchAttachmentDTO setOwnerParentName(String ownerParentName) {
        this.ownerParentName = ownerParentName;
        this.modify("owner_parent_name", ownerParentName);
        return this;
    }

    /**
     * 设置 [工作项]
     */
    public SearchAttachmentDTO setWorkItem(WorkItemDTO workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
     * 设置 [产品需求]
     */
    public SearchAttachmentDTO setIdea(IdeaDTO idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
     * 设置 [工单]
     */
    public SearchAttachmentDTO setTicket(TicketDTO ticket) {
        this.ticket = ticket;
        this.modify("ticket", ticket);
        return this;
    }

    /**
     * 设置 [客户]
     */
    public SearchAttachmentDTO setCustomer(CustomerDTO customer) {
        this.customer = customer;
        this.modify("customer", customer);
        return this;
    }

    /**
     * 设置 [测试用例]
     */
    public SearchAttachmentDTO setTestCase(TestCaseDTO testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
     * 设置 [页面]
     */
    public SearchAttachmentDTO setPage(ArticlePageDTO page) {
        this.page = page;
        this.modify("page", page);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public SearchAttachmentDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [文件名称]
     */
    public SearchAttachmentDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
