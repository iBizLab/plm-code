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
 * 评审向导[ReviewWizardDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审向导DTO")
public class ReviewWizardDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 0)
    private String identifier;

    /**
     * 评审类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "评审类型", position = 1)
    private String type;

    /**
     * 描述
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(value = "描述", position = 2)
    private String description;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 3)
    private String categories;

    /**
     * 测试库标识
     */
    @JsonProperty("library_identifier")
    @JSONField(name = "library_identifier")
    @ApiModelProperty(value = "测试库标识", position = 4)
    private String libraryIdentifier;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 5)
    private List<AttentionDTO> attentions;

    /**
     * 评审状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "评审状态", position = 6)
    private String state;

    /**
     * 评审内容
     */
    @JsonProperty("contents")
    @JSONField(name = "contents")
    @ApiModelProperty(value = "评审内容", position = 7)
    private List<ReviewContentDTO> contents;

    /**
     * 提交人标识
     */
    @JsonProperty("submitter_id")
    @JSONField(name = "submitter_id")
    @ApiModelProperty(value = "提交人标识", position = 8)
    private String submitterId;

    /**
     * 提交人
     */
    @JsonProperty("submitter_name")
    @JSONField(name = "submitter_name")
    @ApiModelProperty(value = "提交人", position = 9)
    private String submitterName;

    /**
     * 规则
     */
    @JsonProperty("rule")
    @JSONField(name = "rule")
    @ApiModelProperty(value = "规则", position = 10)
    private List<Map> rule;

    /**
     * 阶段
     */
    @JsonProperty("stage")
    @JSONField(name = "stage")
    @ApiModelProperty(value = "阶段", position = 11)
    private List<Map> stage;

    /**
     * 后置动作
     */
    @JsonProperty("action_rule")
    @JSONField(name = "action_rule")
    @ApiModelProperty(value = "后置动作", position = 12)
    private List<Map> actionRule;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 13)
    private String showIdentifier;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 14)
    private String attentionsImp;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 15)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 16)
    private Date createTime;

    /**
     * 流程准则标识
     */
    @JsonProperty("guideline_id")
    @JSONField(name = "guideline_id")
    @ApiModelProperty(value = "流程准则标识", position = 17)
    private String guidelineId;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 18)
    private String id;

    /**
     * 测试库标识
     */
    @JsonProperty("library_id")
    @JSONField(name = "library_id")
    @ApiModelProperty(value = "测试库标识", position = 19)
    private String libraryId;

    /**
     * 测试库名称
     */
    @JsonProperty("library_name")
    @JSONField(name = "library_name")
    @ApiModelProperty(value = "测试库名称", position = 20)
    private String libraryName;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 21)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 22)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 23)
    private Date updateTime;


    /**
     * 设置 [编号]
     */
    public ReviewWizardDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [评审类型]
     */
    public ReviewWizardDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [描述]
     */
    public ReviewWizardDTO setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public ReviewWizardDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public ReviewWizardDTO setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public ReviewWizardDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [评审状态]
     */
    public ReviewWizardDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [评审内容]
     */
    public ReviewWizardDTO setContents(List<ReviewContentDTO> contents) {
        this.contents = contents;
        this.modify("contents", contents);
        return this;
    }

    /**
     * 设置 [提交人标识]
     */
    public ReviewWizardDTO setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
        this.modify("submitter_id", submitterId);
        return this;
    }

    /**
     * 设置 [提交人]
     */
    public ReviewWizardDTO setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
        this.modify("submitter_name", submitterName);
        return this;
    }

    /**
     * 设置 [规则]
     */
    public ReviewWizardDTO setRule(List<Map> rule) {
        this.rule = rule;
        this.modify("rule", rule);
        return this;
    }

    /**
     * 设置 [阶段]
     */
    public ReviewWizardDTO setStage(List<Map> stage) {
        this.stage = stage;
        this.modify("stage", stage);
        return this;
    }

    /**
     * 设置 [后置动作]
     */
    public ReviewWizardDTO setActionRule(List<Map> actionRule) {
        this.actionRule = actionRule;
        this.modify("action_rule", actionRule);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public ReviewWizardDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public ReviewWizardDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [流程准则标识]
     */
    public ReviewWizardDTO setGuidelineId(String guidelineId) {
        this.guidelineId = guidelineId;
        this.modify("guideline_id", guidelineId);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public ReviewWizardDTO setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
     * 设置 [测试库名称]
     */
    public ReviewWizardDTO setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewWizardDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
