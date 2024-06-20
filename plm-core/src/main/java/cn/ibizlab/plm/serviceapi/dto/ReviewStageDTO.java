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
 * 评审阶段[ReviewStageDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审阶段DTO")
public class ReviewStageDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评审人类型
     */
    @JsonProperty("reviewer_type")
    @JSONField(name = "reviewer_type")
    @ApiModelProperty(value = "评审人类型", position = 0)
    private String reviewerType;

    /**
     * 评审人
     */
    @JsonProperty("reviewer")
    @JSONField(name = "reviewer")
    @ApiModelProperty(value = "评审人", position = 1)
    private String reviewer;

    /**
     * 评审人名称
     */
    @JsonProperty("reviewer_name")
    @JSONField(name = "reviewer_name")
    @ApiModelProperty(value = "评审人名称", position = 2)
    private String reviewerName;

    /**
     * 评审阶段状态
     */
    @JsonProperty("stage_state")
    @JSONField(name = "stage_state")
    @ApiModelProperty(value = "评审阶段状态", position = 3)
    private String stageState;

    /**
     * 顺序
     */
    @JsonProperty("order")
    @JSONField(name = "order")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "顺序", position = 4)
    private Long order;

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
     * 准则标识
     */
    @JsonProperty("guideline_id")
    @JSONField(name = "guideline_id")
    @ApiModelProperty(value = "准则标识", position = 7)
    private String guidelineId;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 8)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 9)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 10)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 11)
    private Date updateTime;


    /**
     * 设置 [评审人类型]
     */
    public ReviewStageDTO setReviewerType(String reviewerType) {
        this.reviewerType = reviewerType;
        this.modify("reviewer_type", reviewerType);
        return this;
    }

    /**
     * 设置 [评审人]
     */
    public ReviewStageDTO setReviewer(String reviewer) {
        this.reviewer = reviewer;
        this.modify("reviewer", reviewer);
        return this;
    }

    /**
     * 设置 [评审人名称]
     */
    public ReviewStageDTO setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
        this.modify("reviewer_name", reviewerName);
        return this;
    }

    /**
     * 设置 [评审阶段状态]
     */
    public ReviewStageDTO setStageState(String stageState) {
        this.stageState = stageState;
        this.modify("stage_state", stageState);
        return this;
    }

    /**
     * 设置 [顺序]
     */
    public ReviewStageDTO setOrder(Long order) {
        this.order = order;
        this.modify("order", order);
        return this;
    }

    /**
     * 设置 [准则标识]
     */
    public ReviewStageDTO setGuidelineId(String guidelineId) {
        this.guidelineId = guidelineId;
        this.modify("guideline_id", guidelineId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewStageDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
