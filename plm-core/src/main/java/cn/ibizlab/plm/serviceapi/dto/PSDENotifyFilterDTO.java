/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFILTER}}.java.hbs
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
import cn.ibizlab.util.filter.FilterBase;

import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体通知过滤[PSDENotifyFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体通知过滤DTO")
public class PSDENotifyFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体通知标识EQ
     */
    @JsonProperty("n_psdenotifyid_eq")
    @JSONField(name = "n_psdenotifyid_eq")
    @ApiModelProperty(value = "实体通知标识EQ", position = 0)
	private String psdeNotifyIdEQ;

    /**
     * 实体通知名称LIKE
     */
    @JsonProperty("n_psdenotifyname_like")
    @JSONField(name = "n_psdenotifyname_like")
    @ApiModelProperty(value = "实体通知名称LIKE", position = 10)
	private String psdeNotifyNameLIKE;

    /**
     * 附加任务模式EQ
     */
    @JsonProperty("n_taskmode_eq")
    @JSONField(name = "n_taskmode_eq")
    @ApiModelProperty(value = "附加任务模式EQ", position = 110)
	private Integer taskModeEQ;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdeid_eq")
    @JSONField(name = "n_psdeid_eq")
    @ApiModelProperty(value = "实体EQ", position = 140)
	private String psdeidEQ;

    /**
     * 通知子类EQ
     */
    @JsonProperty("n_notifysubtype_eq")
    @JSONField(name = "n_notifysubtype_eq")
    @ApiModelProperty(value = "通知子类EQ", position = 290)
	private String notifySubTypeEQ;


}