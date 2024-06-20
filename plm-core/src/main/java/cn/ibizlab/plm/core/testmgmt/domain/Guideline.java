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
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewActionRule;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewRule;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewStage;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;

/**
 * 流程准则实体类[Guideline]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "GUIDELINE", resultMap = "GuidelineResultMap")
@ApiModel(value = "GUIDELINE", description = "流程准则")
public class Guideline extends EntityMP implements Serializable
{

    /**
    * 所属主体标识
    */
    @TableField(value = "scope_id")
    @DEField(name = "scope_id" , preType = DEPredefinedFieldType.PARENTID)
    @JSONField(name = "scope_id")
    @JsonProperty("scope_id")
    @ApiModelProperty(value = "scope_id", notes = "所属主体标识")
    private String scopeId;

    /**
    * 对象类型
    */
    @TableField(value = "object_type")
    @DEField(name = "object_type")
    @JSONField(name = "object_type")
    @JsonProperty("object_type")
    @ApiModelProperty(value = "object_type", notes = "对象类型")
    private String objectType;

    /**
    * 主题类型
    */
    @TableField(value = "subject_type")
    @DEField(name = "subject_type")
    @JSONField(name = "subject_type")
    @JsonProperty("subject_type")
    @ApiModelProperty(value = "subject_type", notes = "主题类型")
    private String subjectType;

    /**
    * 评审阶段
    */
    @TableField(value = "review_stage", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler =cn.ibizlab.plm.core.testmgmt.domain.handlers.ReviewStageTypeHandler.class)
    @DEField(name = "review_stage")
    @JSONField(name = "review_stage")
    @JsonProperty("review_stage")
    @ApiModelProperty(value = "review_stage", notes = "评审阶段")
    private List<ReviewStage> reviewStage;

    /**
    * 评审规则
    */
    @TableField(value = "review_rule", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler =cn.ibizlab.plm.core.testmgmt.domain.handlers.ReviewRuleTypeHandler.class)
    @DEField(name = "review_rule")
    @JSONField(name = "review_rule")
    @JsonProperty("review_rule")
    @ApiModelProperty(value = "review_rule", notes = "评审规则")
    private List<ReviewRule> reviewRule;

    /**
    * 评审后置动作
    */
    @TableField(value = "review_action_rule", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler =cn.ibizlab.plm.core.testmgmt.domain.handlers.ReviewActionRuleTypeHandler.class)
    @DEField(name = "review_action_rule")
    @JSONField(name = "review_action_rule")
    @JsonProperty("review_action_rule")
    @ApiModelProperty(value = "review_action_rule", notes = "评审后置动作")
    private List<ReviewActionRule> reviewActionRule;

    /**
    * 是否启用
    */
    @TableField(value = "is_enabled")
    @DEField(name = "is_enabled" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_enabled")
    @JsonProperty("is_enabled")
    @ApiModelProperty(value = "is_enabled", notes = "是否启用")
    private Integer isEnabled;

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
    * 用例库-评审准则
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "library", notes = "用例库-评审准则")
    private Library library;

    /**
    * 设置 [对象类型]
    */
    public Guideline setObjectType(String objectType) {
        this.objectType = objectType;
        this.modify("object_type", objectType);
        return this;
    }

    /**
    * 设置 [主题类型]
    */
    public Guideline setSubjectType(String subjectType) {
        this.subjectType = subjectType;
        this.modify("subject_type", subjectType);
        return this;
    }

    /**
    * 设置 [评审阶段]
    */
    public Guideline setReviewStage(List<ReviewStage> reviewStage) {
        this.reviewStage = reviewStage;
        this.modify("review_stage", reviewStage);
        return this;
    }

    /**
    * 设置 [评审规则]
    */
    public Guideline setReviewRule(List<ReviewRule> reviewRule) {
        this.reviewRule = reviewRule;
        this.modify("review_rule", reviewRule);
        return this;
    }

    /**
    * 设置 [评审后置动作]
    */
    public Guideline setReviewActionRule(List<ReviewActionRule> reviewActionRule) {
        this.reviewActionRule = reviewActionRule;
        this.modify("review_action_rule", reviewActionRule);
        return this;
    }

    /**
    * 设置 [是否启用]
    */
    public Guideline setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
        this.modify("is_enabled", isEnabled);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Guideline setName(String name) {
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