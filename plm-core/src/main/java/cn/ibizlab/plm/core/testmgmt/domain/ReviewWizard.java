/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

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
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.base.domain.Attention;

/**
 * 评审向导实体类[ReviewWizard]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "REVIEW", resultMap = "ReviewWizardResultMap")
@ApiModel(value = "REVIEW_WIZARD", description = "评审向导")
public class ReviewWizard extends EntityMP implements Serializable
{

    /**
    * 编号
    */
    @TableField(value = "identifier")
    @DEField(name = "identifier" , dupCheck = DupCheck.ALL , dupCheckField = "libraryId")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
    * 评审类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "review_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "评审类型")
    private String type;

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
    * 类别
    */
    @TableField(value = "categories")
    @DEField(name = "categories")
    @JSONField(name = "categories")
    @JsonProperty("categories")
    @ApiModelProperty(value = "categories", notes = "类别")
    private String categories;

    /**
    * 测试库标识
    */
    @TableField(value = "library_identifier" , exist = false)
    @DEField(name = "library_identifier")
    @JSONField(name = "library_identifier")
    @JsonProperty("library_identifier")
    @ApiModelProperty(value = "library_identifier", notes = "测试库标识")
    private String libraryIdentifier;

    /**
    * 关注
    */
    @TableField(exist = false)
    @DEField(name = "attentions")
    @JSONField(name = "attentions")
    @JsonProperty("attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
    * 评审状态
    */
    @TableField(value = "state")
    @DEField(name = "state" , defaultValue = "10" , dict = "test_case_state")
    @JSONField(name = "state")
    @JsonProperty("state")
    @ApiModelProperty(value = "state", notes = "评审状态")
    private String state;

    /**
    * 评审内容
    */
    @TableField(exist = false)
    @DEField(name = "contents")
    @JSONField(name = "contents")
    @JsonProperty("contents")
    @ApiModelProperty(value = "contents", notes = "评审内容")
    private List<ReviewContent> contents;

    /**
    * 提交人标识
    */
    @TableField(value = "submitter_id")
    @DEField(name = "submitter_id")
    @JSONField(name = "submitter_id")
    @JsonProperty("submitter_id")
    @ApiModelProperty(value = "submitter_id", notes = "提交人标识")
    private String submitterId;

    /**
    * 提交人
    */
    @TableField(value = "submitter_name")
    @DEField(name = "submitter_name")
    @JSONField(name = "submitter_name")
    @JsonProperty("submitter_name")
    @ApiModelProperty(value = "submitter_name", notes = "提交人")
    private String submitterName;

    /**
    * 规则
    */
    @TableField(value = "rule")
    @DEField(name = "rule")
    @JSONField(name = "rule")
    @JsonProperty("rule")
    @ApiModelProperty(value = "rule", notes = "规则")
    private List<Map> rule;

    /**
    * 阶段
    */
    @TableField(value = "stage")
    @DEField(name = "stage")
    @JSONField(name = "stage")
    @JsonProperty("stage")
    @ApiModelProperty(value = "stage", notes = "阶段")
    private List<Map> stage;

    /**
    * 后置动作
    */
    @TableField(value = "action_rule")
    @DEField(name = "action_rule")
    @JSONField(name = "action_rule")
    @JsonProperty("action_rule")
    @ApiModelProperty(value = "action_rule", notes = "后置动作")
    private List<Map> actionRule;

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
    * 关注人
    */
    @TableField(value = "attentions_imp" , exist = false)
    @DEField(name = "attentions_imp")
    @JSONField(name = "attentions_imp")
    @JsonProperty("attentions_imp")
    @ApiModelProperty(value = "attentions_imp", notes = "关注人")
    private String attentionsImp;

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
    * 流程准则标识
    */
    @TableField(value = "guideline_id")
    @DEField(name = "guideline_id")
    @JSONField(name = "guideline_id")
    @JsonProperty("guideline_id")
    @ApiModelProperty(value = "guideline_id", notes = "流程准则标识")
    private String guidelineId;

    /**
    * 测试库名称
    */
    @TableField(value = "library_name" , exist = false)
    @DEField(name = "library_name")
    @JSONField(name = "library_name")
    @JsonProperty("library_name")
    @ApiModelProperty(value = "library_name", notes = "测试库名称")
    private String libraryName;

    /**
    * 测试库标识
    */
    @TableField(value = "library_id")
    @DEField(name = "library_id")
    @JSONField(name = "library_id")
    @JsonProperty("library_id")
    @ApiModelProperty(value = "library_id", notes = "测试库标识")
    private String libraryId;

    /**
    * 流程准则-评审
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "guideline", notes = "流程准则-评审")
    private Guideline guideline;

    /**
    * 测试库
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "library", notes = "测试库")
    private Library library;

    /**
    * 设置 [编号]
    */
    public ReviewWizard setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [评审类型]
    */
    public ReviewWizard setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [描述]
    */
    public ReviewWizard setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [类别]
    */
    public ReviewWizard setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
    * 设置 [测试库标识]
    */
    public ReviewWizard setLibraryIdentifier(String libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
        this.modify("library_identifier", libraryIdentifier);
        return this;
    }

    /**
    * 设置 [关注]
    */
    public ReviewWizard setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
    * 设置 [评审状态]
    */
    public ReviewWizard setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
    * 设置 [评审内容]
    */
    public ReviewWizard setContents(List<ReviewContent> contents) {
        this.contents = contents;
        this.modify("contents", contents);
        return this;
    }

    /**
    * 设置 [提交人标识]
    */
    public ReviewWizard setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
        this.modify("submitter_id", submitterId);
        return this;
    }

    /**
    * 设置 [提交人]
    */
    public ReviewWizard setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
        this.modify("submitter_name", submitterName);
        return this;
    }

    /**
    * 设置 [规则]
    */
    public ReviewWizard setRule(List<Map> rule) {
        this.rule = rule;
        this.modify("rule", rule);
        return this;
    }

    /**
    * 设置 [阶段]
    */
    public ReviewWizard setStage(List<Map> stage) {
        this.stage = stage;
        this.modify("stage", stage);
        return this;
    }

    /**
    * 设置 [后置动作]
    */
    public ReviewWizard setActionRule(List<Map> actionRule) {
        this.actionRule = actionRule;
        this.modify("action_rule", actionRule);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public ReviewWizard setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [关注人]
    */
    public ReviewWizard setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public ReviewWizard setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [流程准则标识]
    */
    public ReviewWizard setGuidelineId(String guidelineId) {
        this.guidelineId = guidelineId;
        this.modify("guideline_id", guidelineId);
        return this;
    }

    /**
    * 设置 [测试库名称]
    */
    public ReviewWizard setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
    * 设置 [测试库标识]
    */
    public ReviewWizard setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
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