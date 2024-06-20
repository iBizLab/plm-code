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
 * 讨论回复[DiscussReplyDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("讨论回复DTO")
public class DiscussReplyDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论
     */
    @JsonProperty("comments")
    @JSONField(name = "comments")
    @ApiModelProperty(value = "评论", position = 0)
    private List<CommentDTO> comments;

    /**
     * 回复内容
     */
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "回复内容", position = 1)
    private String content;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 2)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 3)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 4)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 5)
    private String name;

    /**
     * 讨论标识
     */
    @JsonProperty("post_id")
    @JSONField(name = "post_id")
    @ApiModelProperty(value = "讨论标识", position = 6)
    private String postId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 7)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 8)
    private Date updateTime;


    /**
     * 设置 [评论]
     */
    public DiscussReplyDTO setComments(List<CommentDTO> comments) {
        this.comments = comments;
        this.modify("comments", comments);
        return this;
    }

    /**
     * 设置 [回复内容]
     */
    public DiscussReplyDTO setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public DiscussReplyDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [讨论标识]
     */
    public DiscussReplyDTO setPostId(String postId) {
        this.postId = postId;
        this.modify("post_id", postId);
        return this;
    }


}
