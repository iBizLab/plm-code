/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
 * 日容量[DayCapacityDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("日容量DTO")
public class DayCapacityDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预估工时
     */
    @JsonProperty("estimated_workload")
    @JSONField(name = "estimated_workload")
    @ApiModelProperty(value = "预估工时", position = 0)
    private BigDecimal estimatedWorkload;

    /**
     * 剩余工时
     */
    @JsonProperty("remaining_workload")
    @JSONField(name = "remaining_workload")
    @ApiModelProperty(value = "剩余工时", position = 1)
    private BigDecimal remainingWorkload;

    /**
     * 故事点
     */
    @JsonProperty("story_points")
    @JSONField(name = "story_points")
    @ApiModelProperty(value = "故事点", position = 2)
    private BigDecimal storyPoints;

    /**
     * 工作项数量
     */
    @JsonProperty("work_item_count")
    @JSONField(name = "work_item_count")
    @ApiModelProperty(value = "工作项数量", position = 3)
    private BigDecimal workItemCount;

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
     * 设置 [预估工时]
     */
    public DayCapacityDTO setEstimatedWorkload(BigDecimal estimatedWorkload) {
        this.estimatedWorkload = estimatedWorkload;
        this.modify("estimated_workload", estimatedWorkload);
        return this;
    }

    /**
     * 设置 [剩余工时]
     */
    public DayCapacityDTO setRemainingWorkload(BigDecimal remainingWorkload) {
        this.remainingWorkload = remainingWorkload;
        this.modify("remaining_workload", remainingWorkload);
        return this;
    }

    /**
     * 设置 [故事点]
     */
    public DayCapacityDTO setStoryPoints(BigDecimal storyPoints) {
        this.storyPoints = storyPoints;
        this.modify("story_points", storyPoints);
        return this;
    }

    /**
     * 设置 [工作项数量]
     */
    public DayCapacityDTO setWorkItemCount(BigDecimal workItemCount) {
        this.workItemCount = workItemCount;
        this.modify("work_item_count", workItemCount);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public DayCapacityDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
