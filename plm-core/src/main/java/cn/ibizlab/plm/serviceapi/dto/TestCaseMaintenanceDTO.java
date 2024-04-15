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
 * 用例[TestCaseMaintenanceDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例DTO")
public class TestCaseMaintenanceDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 0)
    private String id;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_id")
    @JSONField(name = "maintenance_id")
    @ApiModelProperty(value = "维护人", position = 1)
    private String maintenanceId;

    /**
     * 维护人
     */
    @JsonProperty("maintenance_name")
    @JSONField(name = "maintenance_name")
    @ApiModelProperty(value = "维护人", position = 2)
    private String maintenanceName;


    /**
     * 设置 [维护人]
     */
    public TestCaseMaintenanceDTO setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
        this.modify("maintenance_id", maintenanceId);
        return this;
    }

    /**
     * 设置 [维护人]
     */
    public TestCaseMaintenanceDTO setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
        this.modify("maintenance_name", maintenanceName);
        return this;
    }


}
