/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.domain;

import java.util.*;
import java.math.BigDecimal;
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
import cn.ibizlab.plm.core.projmgmt.domain.ProjectMember;

/**
 * 日容量实体类[DayCapacity]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "DAY_CAPACITY", description = "日容量")
public class DayCapacity extends EntityBase implements Serializable
{
    /**
     * 预估工时
     */
    @DEField(name = "estimated_workload")
    @JSONField(name = "estimated_workload")
    @JsonProperty("estimated_workload")
    @ApiModelProperty(value = "estimated_workload", notes = "预估工时")
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @DEField(name = "remaining_workload")
    @JSONField(name = "remaining_workload")
    @JsonProperty("remaining_workload")
    @ApiModelProperty(value = "remaining_workload", notes = "剩余工时")
    private BigDecimal remainingWorkload;

    /**
     * 故事点
     */
    @DEField(name = "story_points")
    @JSONField(name = "story_points")
    @JsonProperty("story_points")
    @ApiModelProperty(value = "story_points", notes = "故事点")
    private BigDecimal storyPoints;

    /**
     * 工作项数量
     */
    @DEField(name = "work_item_count")
    @JSONField(name = "work_item_count")
    @JsonProperty("work_item_count")
    @ApiModelProperty(value = "work_item_count", notes = "工作项数量")
    private BigDecimal workItemCount;

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
     * 名称
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "名称")
    private ProjectMember project;

    /**
    * 设置 [预估工时]
    */
    public DayCapacity setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
    * 设置 [剩余工时]
    */
    public DayCapacity setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
    * 设置 [故事点]
    */
    public DayCapacity setStoryPoints(BigDecimal storyPoints) {
        this.storyPoints = storyPoints;
        this.modify("story_points", storyPoints);
        return this;
    }

    /**
    * 设置 [工作项数量]
    */
    public DayCapacity setWorkItemCount(BigDecimal workItemCount) {
        this.workItemCount = workItemCount;
        this.modify("work_item_count", workItemCount);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public DayCapacity setName(String name) {
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