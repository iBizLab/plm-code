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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;

/**
 * 评审结果实体类[ReviewResult]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "REVIEW_RESULT", resultMap = "ReviewResultResultMap")
@ApiModel(value = "REVIEW_RESULT", description = "评审结果")
public class ReviewResult extends EntityMP implements Serializable
{

    /**
     * 状态
     */
    @TableField(value = "result_state")
    @DEField(name = "result_state" , dict = "review_result")
    @JsonProperty("result_state")
    @JSONField(name = "result_state")
    @ApiModelProperty(value = "result_state", notes = "状态")
    private Integer resultState;

    /**
     * 评审意见
     */
    @TableField(value = "comment")
    @DEField(name = "comment")
    @JsonProperty("comment")
    @JSONField(name = "comment")
    @ApiModelProperty(value = "comment", notes = "评审意见")
    private String comment;

    /**
     * 阶段标识
     */
    @TableField(value = "stage_id")
    @DEField(name = "stage_id")
    @JsonProperty("stage_id")
    @JSONField(name = "stage_id")
    @ApiModelProperty(value = "stage_id", notes = "阶段标识")
    private String stageId;

    /**
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 标识
     */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 建立时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 评审内容标识
     */
    @TableField(value = "content_id")
    @DEField(name = "content_id")
    @JsonProperty("content_id")
    @JSONField(name = "content_id")
    @ApiModelProperty(value = "content_id", notes = "评审内容标识")
    private String contentId;

    /**
     * 评审内容扩展
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "review_content_extend", notes = "评审内容-评审结果")
    private ReviewContentExtend reviewContentExtend;

    /**
     * 设置 [状态]
     */
    public ReviewResult setResultState(Integer resultState) {
        this.resultState = resultState;
        this.modify("result_state", resultState);
        return this;
    }

    /**
     * 设置 [评审意见]
     */
    public ReviewResult setComment(String comment) {
        this.comment = comment;
        this.modify("comment", comment);
        return this;
    }

    /**
     * 设置 [阶段标识]
     */
    public ReviewResult setStageId(String stageId) {
        this.stageId = stageId;
        this.modify("stage_id", stageId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewResult setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [评审内容标识]
     */
    public ReviewResult setContentId(String contentId) {
        this.contentId = contentId;
        this.modify("content_id", contentId);
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