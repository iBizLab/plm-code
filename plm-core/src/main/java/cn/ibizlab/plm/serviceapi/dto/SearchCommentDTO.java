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
 * 评论搜索[SearchCommentDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评论搜索DTO")
public class SearchCommentDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论主体标识
     */
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "评论主体标识", position = 0)
    private String principalId;

    /**
     * 评论主体名称
     */
    @JsonProperty("principal_name")
    @JSONField(name = "principal_name")
    @ApiModelProperty(value = "评论主体名称", position = 1)
    private String principalName;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 2)
    private String ownerType;

    /**
     * 评论主体类型
     */
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "评论主体类型", position = 3)
    private String principalType;

    /**
     * 内容
     */
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "内容", position = 4)
    private String content;

    /**
     * 评论主体标题
     */
    @JsonProperty("principal_title")
    @JSONField(name = "principal_title")
    @ApiModelProperty(value = "评论主体标题", position = 5)
    private String principalTitle;

    /**
     * 评论主体编号
     */
    @JsonProperty("principal_identifier")
    @JSONField(name = "principal_identifier")
    @ApiModelProperty(value = "评论主体编号", position = 6)
    private String principalIdentifier;

    /**
     * 评论主体父标识
     */
    @JsonProperty("principal_parent_id")
    @JSONField(name = "principal_parent_id")
    @ApiModelProperty(value = "评论主体父标识", position = 7)
    private String principalParentId;

    /**
     * 评论主体父名称
     */
    @JsonProperty("principal_parent_name")
    @JSONField(name = "principal_parent_name")
    @ApiModelProperty(value = "评论主体父名称", position = 8)
    private String principalParentName;

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
     * 执行用例
     */
    @JsonProperty("run")
    @JSONField(name = "run")
    @ApiModelProperty(value = "执行用例", position = 14)
    private RunDTO run;

    /**
     * 页面
     */
    @JsonProperty("page")
    @JSONField(name = "page")
    @ApiModelProperty(value = "页面", position = 15)
    private ArticlePageDTO page;

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
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 19)
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
     * 设置 [内容]
     */
    public SearchCommentDTO setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [评论主体标题]
     */
    public SearchCommentDTO setPrincipalTitle(String principalTitle) {
        this.principalTitle = principalTitle;
        this.modify("principal_title", principalTitle);
        return this;
    }

    /**
     * 设置 [评论主体编号]
     */
    public SearchCommentDTO setPrincipalIdentifier(String principalIdentifier) {
        this.principalIdentifier = principalIdentifier;
        this.modify("principal_identifier", principalIdentifier);
        return this;
    }

    /**
     * 设置 [评论主体父标识]
     */
    public SearchCommentDTO setPrincipalParentId(String principalParentId) {
        this.principalParentId = principalParentId;
        this.modify("principal_parent_id", principalParentId);
        return this;
    }

    /**
     * 设置 [评论主体父名称]
     */
    public SearchCommentDTO setPrincipalParentName(String principalParentName) {
        this.principalParentName = principalParentName;
        this.modify("principal_parent_name", principalParentName);
        return this;
    }

    /**
     * 设置 [工作项]
     */
    public SearchCommentDTO setWorkItem(WorkItemDTO workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
     * 设置 [产品需求]
     */
    public SearchCommentDTO setIdea(IdeaDTO idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
     * 设置 [工单]
     */
    public SearchCommentDTO setTicket(TicketDTO ticket) {
        this.ticket = ticket;
        this.modify("ticket", ticket);
        return this;
    }

    /**
     * 设置 [客户]
     */
    public SearchCommentDTO setCustomer(CustomerDTO customer) {
        this.customer = customer;
        this.modify("customer", customer);
        return this;
    }

    /**
     * 设置 [测试用例]
     */
    public SearchCommentDTO setTestCase(TestCaseDTO testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
     * 设置 [执行用例]
     */
    public SearchCommentDTO setRun(RunDTO run) {
        this.run = run;
        this.modify("run", run);
        return this;
    }

    /**
     * 设置 [页面]
     */
    public SearchCommentDTO setPage(ArticlePageDTO page) {
        this.page = page;
        this.modify("page", page);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public SearchCommentDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
