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
 * 讨论[DiscussPostDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("讨论DTO")
public class DiscussPostDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 0)
    private Integer isDeleted;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 1)
    private List<AttentionDTO> attentions;

    /**
     * 附件
     */
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "附件", position = 2)
    private List<AttachmentDTO> attachments;

    /**
     * 状态
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(value = "状态", position = 3)
    private String status;

    /**
     * 评论
     */
    @JsonProperty("comments")
    @JSONField(name = "comments")
    @ApiModelProperty(value = "评论", position = 4)
    private List<CommentDTO> comments;

    /**
     * 热度
     */
    @JsonProperty("heat")
    @JSONField(name = "heat")
    @ApiModelProperty(value = "热度", position = 5)
    private Integer heat;

    /**
     * 讨论内容
     */
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "讨论内容", position = 6)
    private String content;

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
     * 话题标识
     */
    @JsonProperty("topic_id")
    @JSONField(name = "topic_id")
    @ApiModelProperty(value = "话题标识", position = 11)
    private String topicId;

    /**
     * 话题
     */
    @JsonProperty("topic_name")
    @JSONField(name = "topic_name")
    @ApiModelProperty(value = "话题", position = 12)
    private String topicName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 13)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 14)
    private Date updateTime;


    /**
     * 设置 [是否已删除]
     */
    public DiscussPostDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public DiscussPostDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public DiscussPostDTO setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [状态]
     */
    public DiscussPostDTO setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
     * 设置 [评论]
     */
    public DiscussPostDTO setComments(List<CommentDTO> comments) {
        this.comments = comments;
        this.modify("comments", comments);
        return this;
    }

    /**
     * 设置 [热度]
     */
    public DiscussPostDTO setHeat(Integer heat) {
        this.heat = heat;
        this.modify("heat", heat);
        return this;
    }

    /**
     * 设置 [讨论内容]
     */
    public DiscussPostDTO setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public DiscussPostDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [话题标识]
     */
    public DiscussPostDTO setTopicId(String topicId) {
        this.topicId = topicId;
        this.modify("topic_id", topicId);
        return this;
    }

    /**
     * 设置 [话题]
     */
    public DiscussPostDTO setTopicName(String topicName) {
        this.topicName = topicName;
        this.modify("topic_name", topicName);
        return this;
    }


}
