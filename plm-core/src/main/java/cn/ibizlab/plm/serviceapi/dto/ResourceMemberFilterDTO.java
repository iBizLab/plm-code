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
 * 资源组件成员过滤[ResourceMemberFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("资源组件成员过滤DTO")
public class ResourceMemberFilterDTO extends FilterBase implements Serializable {

    /**
     * 登录名EQ
     */
    @JsonProperty("n_user_id_eq")
    @JSONField(name = "n_user_id_eq")
    @ApiModelProperty(value = "登录名EQ", position = 10)
	private String userIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 30)
	private String idEQ;

    /**
     * 姓名EQ
     */
    @JsonProperty("n_name_eq")
    @JSONField(name = "n_name_eq")
    @ApiModelProperty(value = "姓名EQ", position = 40)
	private String nameEQ;

    /**
     * 姓名LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "姓名LIKE", position = 41)
	private String nameLIKE;

    /**
     * 组件标识EQ
     */
    @JsonProperty("n_addon_id_eq")
    @JSONField(name = "n_addon_id_eq")
    @ApiModelProperty(value = "组件标识EQ", position = 90)
	private String addonIdEQ;


}