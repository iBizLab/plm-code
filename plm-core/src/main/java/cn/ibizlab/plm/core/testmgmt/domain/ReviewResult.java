/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;

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
    @DEField(name = "result_state" , defaultValue = "1" , dict = "review_result")
    @JSONField(name = "result_state")
    @JsonProperty("result_state")
    @ApiModelProperty(value = "result_state", notes = "状态")
    private Integer resultState;

    /**
    * 评审意见
    */
    @TableField(value = "comment")
    @DEField(name = "comment")
    @JSONField(name = "comment")
    @JsonProperty("comment")
    @ApiModelProperty(value = "comment", notes = "评审意见")
    private String comment;

    /**
    * 是否可评审
    */
    @TableField(value = "whether_review" , exist = false)
    @DEField(name = "whether_review" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "whether_review")
    @JsonProperty("whether_review")
    @ApiModelProperty(value = "whether_review", notes = "是否可评审")
    private String whetherReview;

    /**
    * 阶段标识
    */
    @TableField(value = "stage_id")
    @DEField(name = "stage_id")
    @JSONField(name = "stage_id")
    @JsonProperty("stage_id")
    @ApiModelProperty(value = "stage_id", notes = "阶段标识")
    private String stageId;

    /**
    * 顺序
    */
    @TableField(value = "sequences")
    @DEField(name = "sequences")
    @JSONField(name = "sequences")
    @JsonProperty("sequences")
    @ApiModelProperty(value = "sequences", notes = "顺序")
    private Integer sequences;

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
    * 评审内容标识
    */
    @TableField(value = "content_id")
    @DEField(name = "content_id")
    @JSONField(name = "content_id")
    @JsonProperty("content_id")
    @ApiModelProperty(value = "content_id", notes = "评审内容标识")
    private String contentId;

    /**
    * 评审内容-评审结果
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "review_content_extend", notes = "评审内容-评审结果")
    private ReviewContentExtend reviewContentExtend;

    /**
    * 评审内容-结果
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "review_content", notes = "评审内容-结果")
    private ReviewContent reviewContent;

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
    * 设置 [是否可评审]
    */
    public ReviewResult setWhetherReview(String whetherReview) {
        this.whetherReview = whetherReview;
        this.modify("whether_review", whetherReview);
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
    * 设置 [顺序]
    */
    public ReviewResult setSequences(Integer sequences) {
        this.sequences = sequences;
        this.modify("sequences", sequences);
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