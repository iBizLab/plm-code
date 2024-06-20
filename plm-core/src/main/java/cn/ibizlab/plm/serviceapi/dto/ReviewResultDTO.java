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
 * 评审结果[ReviewResultDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审结果DTO")
public class ReviewResultDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态
     */
    @JsonProperty("result_state")
    @JSONField(name = "result_state")
    @ApiModelProperty(value = "状态", position = 0)
    private Integer resultState;

    /**
     * 评审意见
     */
    @JsonProperty("comment")
    @JSONField(name = "comment")
    @ApiModelProperty(value = "评审意见", position = 1)
    private String comment;

    /**
     * 是否可评审
     */
    @JsonProperty("whether_review")
    @JSONField(name = "whether_review")
    @ApiModelProperty(value = "是否可评审", position = 2)
    private String whetherReview;

    /**
     * 阶段标识
     */
    @JsonProperty("stage_id")
    @JSONField(name = "stage_id")
    @ApiModelProperty(value = "阶段标识", position = 3)
    private String stageId;

    /**
     * 顺序
     */
    @JsonProperty("sequences")
    @JSONField(name = "sequences")
    @ApiModelProperty(value = "顺序", position = 4)
    private Integer sequences;

    /**
     * 评审内容标识
     */
    @JsonProperty("content_id")
    @JSONField(name = "content_id")
    @ApiModelProperty(value = "评审内容标识", position = 5)
    private String contentId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 6)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 7)
    private Date createTime;

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
     * 设置 [状态]
     */
    public ReviewResultDTO setResultState(Integer resultState) {
        this.resultState = resultState;
        this.modify("result_state", resultState);
        return this;
    }

    /**
     * 设置 [评审意见]
     */
    public ReviewResultDTO setComment(String comment) {
        this.comment = comment;
        this.modify("comment", comment);
        return this;
    }

    /**
     * 设置 [是否可评审]
     */
    public ReviewResultDTO setWhetherReview(String whetherReview) {
        this.whetherReview = whetherReview;
        this.modify("whether_review", whetherReview);
        return this;
    }

    /**
     * 设置 [阶段标识]
     */
    public ReviewResultDTO setStageId(String stageId) {
        this.stageId = stageId;
        this.modify("stage_id", stageId);
        return this;
    }

    /**
     * 设置 [顺序]
     */
    public ReviewResultDTO setSequences(Integer sequences) {
        this.sequences = sequences;
        this.modify("sequences", sequences);
        return this;
    }

    /**
     * 设置 [评审内容标识]
     */
    public ReviewResultDTO setContentId(String contentId) {
        this.contentId = contentId;
        this.modify("content_id", contentId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewResultDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
