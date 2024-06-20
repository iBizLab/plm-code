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
 * 流程准则[GuidelineDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("流程准则DTO")
public class GuidelineDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属主体标识
     */
    @JsonProperty("scope_id")
    @JSONField(name = "scope_id")
    @ApiModelProperty(value = "所属主体标识", position = 0)
    private String scopeId;

    /**
     * 对象类型
     */
    @JsonProperty("object_type")
    @JSONField(name = "object_type")
    @ApiModelProperty(value = "对象类型", position = 1)
    private String objectType;

    /**
     * 主题类型
     */
    @JsonProperty("subject_type")
    @JSONField(name = "subject_type")
    @ApiModelProperty(value = "主题类型", position = 2)
    private String subjectType;

    /**
     * 评审阶段
     */
    @JsonProperty("review_stage")
    @JSONField(name = "review_stage")
    @ApiModelProperty(value = "评审阶段", position = 3)
    private List<ReviewStageDTO> reviewStage;

    /**
     * 评审规则
     */
    @JsonProperty("review_rule")
    @JSONField(name = "review_rule")
    @ApiModelProperty(value = "评审规则", position = 4)
    private List<ReviewRuleDTO> reviewRule;

    /**
     * 评审后置动作
     */
    @JsonProperty("review_action_rule")
    @JSONField(name = "review_action_rule")
    @ApiModelProperty(value = "评审后置动作", position = 5)
    private List<ReviewActionRuleDTO> reviewActionRule;

    /**
     * 是否启用
     */
    @JsonProperty("is_enabled")
    @JSONField(name = "is_enabled")
    @ApiModelProperty(value = "是否启用", position = 6)
    private Integer isEnabled;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 7)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 8)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 9)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 10)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 11)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 12)
    private Date updateTime;


    /**
     * 设置 [对象类型]
     */
    public GuidelineDTO setObjectType(String objectType) {
        this.objectType = objectType;
        this.modify("object_type", objectType);
        return this;
    }

    /**
     * 设置 [主题类型]
     */
    public GuidelineDTO setSubjectType(String subjectType) {
        this.subjectType = subjectType;
        this.modify("subject_type", subjectType);
        return this;
    }

    /**
     * 设置 [评审阶段]
     */
    public GuidelineDTO setReviewStage(List<ReviewStageDTO> reviewStage) {
        this.reviewStage = reviewStage;
        this.modify("review_stage", reviewStage);
        return this;
    }

    /**
     * 设置 [评审规则]
     */
    public GuidelineDTO setReviewRule(List<ReviewRuleDTO> reviewRule) {
        this.reviewRule = reviewRule;
        this.modify("review_rule", reviewRule);
        return this;
    }

    /**
     * 设置 [评审后置动作]
     */
    public GuidelineDTO setReviewActionRule(List<ReviewActionRuleDTO> reviewActionRule) {
        this.reviewActionRule = reviewActionRule;
        this.modify("review_action_rule", reviewActionRule);
        return this;
    }

    /**
     * 设置 [是否启用]
     */
    public GuidelineDTO setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
        this.modify("is_enabled", isEnabled);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public GuidelineDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
