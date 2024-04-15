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
 * 执行用例[RunExecutorDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("执行用例DTO")
public class RunExecutorDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 执行人标识
     */
    @JsonProperty("executor_id")
    @JSONField(name = "executor_id")
    @ApiModelProperty(value = "执行人标识", position = 0)
    private String executorId;

    /**
     * 执行人
     */
    @JsonProperty("executor_name")
    @JSONField(name = "executor_name")
    @ApiModelProperty(value = "执行人", position = 1)
    private String executorName;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 2)
    private String id;


    /**
     * 设置 [执行人标识]
     */
    public RunExecutorDTO setExecutorId(String executorId) {
        this.executorId = executorId;
        this.modify("executor_id", executorId);
        return this;
    }

    /**
     * 设置 [执行人]
     */
    public RunExecutorDTO setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }


}
