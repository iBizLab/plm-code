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
 * 消息通知目标过滤[PSDENotifyTargetFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("消息通知目标过滤DTO")
public class PSDENotifyTargetFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体通知目标名称LIKE
     */
    @JsonProperty("n_psdenotifytargetname_like")
    @JSONField(name = "n_psdenotifytargetname_like")
    @ApiModelProperty(value = "实体通知目标名称LIKE", position = 40)
	private String psdeNotifyTargetNameLIKE;

    /**
     * 实体通知目标标识EQ
     */
    @JsonProperty("n_psdenotifytargetid_eq")
    @JSONField(name = "n_psdenotifytargetid_eq")
    @ApiModelProperty(value = "实体通知目标标识EQ", position = 50)
	private String psdeNotifyTargetIdEQ;

    /**
     * 目标类型EQ
     */
    @JsonProperty("n_targettype_eq")
    @JSONField(name = "n_targettype_eq")
    @ApiModelProperty(value = "目标类型EQ", position = 70)
	private String targetTypeEQ;

    /**
     * 实体通知EQ
     */
    @JsonProperty("n_psdenotifyid_eq")
    @JSONField(name = "n_psdenotifyid_eq")
    @ApiModelProperty(value = "实体通知EQ", position = 90)
	private String psdeNotifyIdEQ;

    /**
     * 实体通知EQ
     */
    @JsonProperty("n_psdenotifyname_eq")
    @JSONField(name = "n_psdenotifyname_eq")
    @ApiModelProperty(value = "实体通知EQ", position = 100)
	private String psdeNotifyNameEQ;

    /**
     * 实体通知LIKE
     */
    @JsonProperty("n_psdenotifyname_like")
    @JSONField(name = "n_psdenotifyname_like")
    @ApiModelProperty(value = "实体通知LIKE", position = 101)
	private String psdeNotifyNameLIKE;


}