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
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;

/**
 * 评审内容扩展实体类[ReviewContentExtend]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "REVIEW_CONTENT_EXTEND", resultMap = "ReviewContentExtendResultMap")
@ApiModel(value = "REVIEW_CONTENT_EXTEND", description = "评审内容扩展")
public class ReviewContentExtend extends EntityMP implements Serializable
{

    /**
     * 变更类型
     */
    @TableField(value = "change_type")
    @DEField(name = "change_type" , defaultValue = "0" , dict = "review_change_type")
    @JsonProperty("change_type")
    @JSONField(name = "change_type")
    @ApiModelProperty(value = "change_type", notes = "变更类型")
    private String changeType;

    /**
     * 变更版本
     */
    @TableField(value = "change_version")
    @DEField(name = "change_version")
    @JsonProperty("change_version")
    @JSONField(name = "change_version")
    @ApiModelProperty(value = "change_version", notes = "变更版本")
    private Map changeVersion;

    /**
     * 评审结果
     */
    @TableField(exist = false)
    @DEField(name = "stage_results")
    @JsonProperty("stage_results")
    @JSONField(name = "stage_results")
    @ApiModelProperty(value = "stage_results", notes = "评审结果")
    private List<ReviewResult> stageResults;

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
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

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
     * 设置 [变更类型]
     */
    public ReviewContentExtend setChangeType(String changeType) {
        this.changeType = changeType;
        this.modify("change_type", changeType);
        return this;
    }

    /**
     * 设置 [变更版本]
     */
    public ReviewContentExtend setChangeVersion(Map changeVersion) {
        this.changeVersion = changeVersion;
        this.modify("change_version", changeVersion);
        return this;
    }

    /**
     * 设置 [评审结果]
     */
    public ReviewContentExtend setStageResults(List<ReviewResult> stageResults) {
        this.stageResults = stageResults;
        this.modify("stage_results", stageResults);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewContentExtend setName(String name) {
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