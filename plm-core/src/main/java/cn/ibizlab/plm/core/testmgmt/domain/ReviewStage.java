/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;

/**
 * 评审阶段实体类[ReviewStage]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "REVIEW_STAGE", description = "评审阶段")
public class ReviewStage extends EntityBase implements Serializable
{
    /**
     * 评审人类型
     */
    @DEField(name = "reviewer_type" , dict = "reviewer_type")
    @JSONField(name = "reviewer_type")
    @JsonProperty("reviewer_type")
    @ApiModelProperty(value = "reviewer_type", notes = "评审人类型")
    private String reviewerType;

    /**
     * 评审人
     */
    @DEField(name = "reviewer")
    @JSONField(name = "reviewer")
    @JsonProperty("reviewer")
    @ApiModelProperty(value = "reviewer", notes = "评审人")
    private String reviewer;

    /**
     * 评审人名称
     */
    @DEField(name = "reviewer_name")
    @JSONField(name = "reviewer_name")
    @JsonProperty("reviewer_name")
    @ApiModelProperty(value = "reviewer_name", notes = "评审人名称")
    private String reviewerName;

    /**
     * 评审阶段状态
     */
    @DEField(name = "stage_state" , defaultValue = "10" , dict = "stage_state")
    @JSONField(name = "stage_state")
    @JsonProperty("stage_state")
    @ApiModelProperty(value = "stage_state", notes = "评审阶段状态")
    private String stageState;

    /**
     * 顺序
     */
    @DEField(name = "order")
    @JSONField(name = "order")
    @JsonProperty("order")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "order", notes = "顺序")
    private Long order;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 准则标识
     */
    @DEField(name = "guideline_id")
    @JSONField(name = "guideline_id")
    @JsonProperty("guideline_id")
    @ApiModelProperty(value = "guideline_id", notes = "准则标识")
    private String guidelineId;

    /**
     * 规则-阶段
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "guideline", notes = "规则-阶段")
    private Guideline guideline;

    /**
    * 设置 [评审人类型]
    */
    public ReviewStage setReviewerType(String reviewerType) {
        this.reviewerType = reviewerType;
        this.modify("reviewer_type", reviewerType);
        return this;
    }

    /**
    * 设置 [评审人]
    */
    public ReviewStage setReviewer(String reviewer) {
        this.reviewer = reviewer;
        this.modify("reviewer", reviewer);
        return this;
    }

    /**
    * 设置 [评审人名称]
    */
    public ReviewStage setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
        this.modify("reviewer_name", reviewerName);
        return this;
    }

    /**
    * 设置 [评审阶段状态]
    */
    public ReviewStage setStageState(String stageState) {
        this.stageState = stageState;
        this.modify("stage_state", stageState);
        return this;
    }

    /**
    * 设置 [顺序]
    */
    public ReviewStage setOrder(Long order) {
        this.order = order;
        this.modify("order", order);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public ReviewStage setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [准则标识]
    */
    public ReviewStage setGuidelineId(String guidelineId) {
        this.guidelineId = guidelineId;
        this.modify("guideline_id", guidelineId);
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