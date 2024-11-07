/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.team.domain;

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
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attachment;

/**
 * 讨论实体类[DiscussPost]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "DISCUSS_POST", resultMap = "DiscussPostResultMap")
@ApiModel(value = "DISCUSS_POST", description = "讨论")
public class DiscussPost extends EntityMP implements Serializable
{

    /**
    * 是否已删除
    */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

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
    * 附件
    */
    @TableField(exist = false)
    @DEField(name = "attachments")
    @JSONField(name = "attachments")
    @JsonProperty("attachments")
    @ApiModelProperty(value = "attachments", notes = "附件")
    private List<Attachment> attachments;

    /**
    * 状态
    */
    @TableField(value = "status")
    @DEField(name = "status" , defaultValue = "1" , dict = "discuss_status")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty(value = "status", notes = "状态")
    private String status;

    /**
    * 评论
    */
    @TableField(exist = false)
    @DEField(name = "comments")
    @JSONField(name = "comments")
    @JsonProperty("comments")
    @ApiModelProperty(value = "comments", notes = "评论")
    private List<Comment> comments;

    /**
    * 热度
    */
    @TableField(value = "heat")
    @DEField(name = "heat" , defaultValue = "0")
    @JSONField(name = "heat")
    @JsonProperty("heat")
    @ApiModelProperty(value = "heat", notes = "热度")
    private Integer heat;

    /**
    * 讨论回复数
    */
    @TableField(value = "replies" , exist = false)
    @DEField(name = "replies")
    @JSONField(name = "replies")
    @JsonProperty("replies")
    @ApiModelProperty(value = "replies", notes = "讨论回复数")
    private String replies;

    /**
    * 关注数
    */
    @TableField(value = "attention_count" , exist = false)
    @DEField(name = "attention_count")
    @JSONField(name = "attention_count")
    @JsonProperty("attention_count")
    @ApiModelProperty(value = "attention_count", notes = "关注数")
    private String attentionCount;

    /**
    * 评论数
    */
    @TableField(value = "comment_count" , exist = false)
    @DEField(name = "comment_count")
    @JSONField(name = "comment_count")
    @JsonProperty("comment_count")
    @ApiModelProperty(value = "comment_count", notes = "评论数")
    private String commentCount;

    /**
    * 讨论内容
    */
    @TableField(value = "content")
    @DEField(name = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    @ApiModelProperty(value = "content", notes = "讨论内容")
    private String content;

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
    * 讨论名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "讨论名称")
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
    * 话题标识
    */
    @TableField(value = "topic_id")
    @DEField(name = "topic_id")
    @JSONField(name = "topic_id")
    @JsonProperty("topic_id")
    @ApiModelProperty(value = "topic_id", notes = "话题标识")
    private String topicId;

    /**
    * 话题
    */
    @TableField(value = "topic_name" , exist = false)
    @DEField(name = "topic_name")
    @JSONField(name = "topic_name")
    @JsonProperty("topic_name")
    @ApiModelProperty(value = "topic_name", notes = "话题")
    private String topicName;

    /**
    * 话题-讨论
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "discuss_topic", notes = "话题-讨论")
    private DiscussTopic discussTopic;

    /**
    * 设置 [是否已删除]
    */
    public DiscussPost setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [关注]
    */
    public DiscussPost setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
    * 设置 [附件]
    */
    public DiscussPost setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
    * 设置 [状态]
    */
    public DiscussPost setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
    * 设置 [评论]
    */
    public DiscussPost setComments(List<Comment> comments) {
        this.comments = comments;
        this.modify("comments", comments);
        return this;
    }

    /**
    * 设置 [热度]
    */
    public DiscussPost setHeat(Integer heat) {
        this.heat = heat;
        this.modify("heat", heat);
        return this;
    }

    /**
    * 设置 [讨论回复数]
    */
    public DiscussPost setReplies(String replies) {
        this.replies = replies;
        this.modify("replies", replies);
        return this;
    }

    /**
    * 设置 [关注数]
    */
    public DiscussPost setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
        this.modify("attention_count", attentionCount);
        return this;
    }

    /**
    * 设置 [评论数]
    */
    public DiscussPost setCommentCount(String commentCount) {
        this.commentCount = commentCount;
        this.modify("comment_count", commentCount);
        return this;
    }

    /**
    * 设置 [讨论内容]
    */
    public DiscussPost setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
    * 设置 [讨论名称]
    */
    public DiscussPost setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [话题标识]
    */
    public DiscussPost setTopicId(String topicId) {
        this.topicId = topicId;
        this.modify("topic_id", topicId);
        return this;
    }

    /**
    * 设置 [话题]
    */
    public DiscussPost setTopicName(String topicName) {
        this.topicName = topicName;
        this.modify("topic_name", topicName);
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