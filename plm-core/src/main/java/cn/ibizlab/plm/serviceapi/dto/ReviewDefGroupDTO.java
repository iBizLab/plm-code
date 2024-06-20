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
 * 评审[ReviewDefGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审DTO")
public class ReviewDefGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 附件
     */
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "附件", position = 0)
    private List<AttachmentDTO> attachments;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 1)
    private List<AttentionDTO> attentions;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 2)
    private String attentionsImp;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 3)
    private String categories;

    /**
     * 完成时间
     */
    @JsonProperty("completed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间", position = 4)
    private Date completedAt;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 5)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 6)
    private Date createTime;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 7)
    private String description;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 8)
    private String id;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 9)
    private String identifier;

    /**
     * 测试库标识
     */
    @JsonProperty("library_id")
    @JSONField(name = "library_id")
    @ApiModelProperty(value = "测试库标识", position = 10)
    private String libraryId;

    /**
     * 测试库标识
     */
    @JsonProperty("library_identifier")
    @JSONField(name = "library_identifier")
    @ApiModelProperty(value = "测试库标识", position = 11)
    private String libraryIdentifier;

    /**
     * 测试库名称
     */
    @JsonProperty("library_name")
    @JSONField(name = "library_name")
    @ApiModelProperty(value = "测试库名称", position = 12)
    private String libraryName;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 13)
    private Date updateTime;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 14)
    private String updateMan;

    /**
     * 评审类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "评审类型", position = 15)
    private String type;

    /**
     * 评审状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "评审状态", position = 16)
    private String state;

    /**
     * 提交人标识
     */
    @JsonProperty("submitter_id")
    @JSONField(name = "submitter_id")
    @ApiModelProperty(value = "提交人标识", position = 17)
    private String submitterId;

    /**
     * 提交时间
     */
    @JsonProperty("submitted_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "submitted_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间", position = 18)
    private Date submittedAt;

    /**
     * 提交人
     */
    @JsonProperty("submitter_name")
    @JSONField(name = "submitter_name")
    @ApiModelProperty(value = "提交人", position = 19)
    private String submitterName;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 20)
    private String name;

    /**
     * 后置动作
     */
    @JsonProperty("action_rule")
    @JSONField(name = "action_rule")
    @ApiModelProperty(value = "后置动作", position = 21)
    private List<ReviewActionRuleDTO> actionRule;

    /**
     * 规则
     */
    @JsonProperty("rule")
    @JSONField(name = "rule")
    @ApiModelProperty(value = "规则", position = 22)
    private List<ReviewRuleDTO> rule;

    /**
     * 阶段
     */
    @JsonProperty("stage")
    @JSONField(name = "stage")
    @ApiModelProperty(value = "阶段", position = 23)
    private List<ReviewStageDTO> stage;

    /**
     * 评审内容
     */
    @JsonProperty("contents")
    @JSONField(name = "contents")
    @ApiModelProperty(value = "评审内容", position = 24)
    private List<Map> contents;


    /**
     * 设置 [附件]
     */
    public ReviewDefGroupDTO setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public ReviewDefGroupDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public ReviewDefGroupDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public ReviewDefGroupDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [完成时间]
     */
    public ReviewDefGroupDTO setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
        this.modify("completed_at", completedAt);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public ReviewDefGroupDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public ReviewDefGroupDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public ReviewDefGroupDTO setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public ReviewDefGroupDTO setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
     * 设置 [测试库名称]
     */
    public ReviewDefGroupDTO setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
     * 设置 [评审类型]
     */
    public ReviewDefGroupDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [评审状态]
     */
    public ReviewDefGroupDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [提交人标识]
     */
    public ReviewDefGroupDTO setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
        this.modify("submitter_id", submitterId);
        return this;
    }

    /**
     * 设置 [提交时间]
     */
    public ReviewDefGroupDTO setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
        this.modify("submitted_at", submittedAt);
        return this;
    }

    /**
     * 设置 [提交人]
     */
    public ReviewDefGroupDTO setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
        this.modify("submitter_name", submitterName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewDefGroupDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [后置动作]
     */
    public ReviewDefGroupDTO setActionRule(List<ReviewActionRuleDTO> actionRule) {
        this.actionRule = actionRule;
        this.modify("action_rule", actionRule);
        return this;
    }

    /**
     * 设置 [规则]
     */
    public ReviewDefGroupDTO setRule(List<ReviewRuleDTO> rule) {
        this.rule = rule;
        this.modify("rule", rule);
        return this;
    }

    /**
     * 设置 [阶段]
     */
    public ReviewDefGroupDTO setStage(List<ReviewStageDTO> stage) {
        this.stage = stage;
        this.modify("stage", stage);
        return this;
    }

    /**
     * 设置 [评审内容]
     */
    public ReviewDefGroupDTO setContents(List<Map> contents) {
        this.contents = contents;
        this.modify("contents", contents);
        return this;
    }


}
