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
 * 实体属性过滤[PSDEFieldFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体属性过滤DTO")
public class PSDEFieldFilterDTO extends FilterBase implements Serializable {

    /**
     * 实体属性标识EQ
     */
    @JsonProperty("n_psdefieldid_eq")
    @JSONField(name = "n_psdefieldid_eq")
    @ApiModelProperty(value = "实体属性标识EQ", position = 10)
	private String psdeFieldIdEQ;

    /**
     * 实体属性名称LIKE
     */
    @JsonProperty("n_psdefieldname_like")
    @JSONField(name = "n_psdefieldname_like")
    @ApiModelProperty(value = "实体属性名称LIKE", position = 20)
	private String psdeFieldNameLIKE;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdeid_eq")
    @JSONField(name = "n_psdeid_eq")
    @ApiModelProperty(value = "实体EQ", position = 80)
	private String psdeidEQ;

    /**
     * 属性类型EQ
     */
    @JsonProperty("n_deftype_eq")
    @JSONField(name = "n_deftype_eq")
    @ApiModelProperty(value = "属性类型EQ", position = 100)
	private Integer defTypeEQ;

    /**
     * 实体EQ
     */
    @JsonProperty("n_psdename_eq")
    @JSONField(name = "n_psdename_eq")
    @ApiModelProperty(value = "实体EQ", position = 110)
	private String psdeNameEQ;

    /**
     * 实体LIKE
     */
    @JsonProperty("n_psdename_like")
    @JSONField(name = "n_psdename_like")
    @ApiModelProperty(value = "实体LIKE", position = 111)
	private String psdeNameLIKE;

    /**
     * 中文名称LIKE
     */
    @JsonProperty("n_logicname_like")
    @JSONField(name = "n_logicname_like")
    @ApiModelProperty(value = "中文名称LIKE", position = 160)
	private String logicNameLIKE;

    /**
     * 属性标记2EQ
     */
    @JsonProperty("n_fieldtag2_eq")
    @JSONField(name = "n_fieldtag2_eq")
    @ApiModelProperty(value = "属性标记2EQ", position = 170)
	private String fieldTag2EQ;

    /**
     * 属性标记EQ
     */
    @JsonProperty("n_fieldtag_eq")
    @JSONField(name = "n_fieldtag_eq")
    @ApiModelProperty(value = "属性标记EQ", position = 180)
	private String fieldTagEQ;

    /**
     * 用户标记2EQ
     */
    @JsonProperty("n_usertag2_eq")
    @JSONField(name = "n_usertag2_eq")
    @ApiModelProperty(value = "用户标记2EQ", position = 190)
	private String userTag2EQ;

    /**
     * 用户标记2NOTEQ
     */
    @JsonProperty("n_usertag2_noteq")
    @JSONField(name = "n_usertag2_noteq")
    @ApiModelProperty(value = "用户标记2NOTEQ", position = 191)
	private String userTag2NOTEQ;

    /**
     * 用户标记3EQ
     */
    @JsonProperty("n_usertag3_eq")
    @JSONField(name = "n_usertag3_eq")
    @ApiModelProperty(value = "用户标记3EQ", position = 200)
	private String userTag3EQ;

    /**
     * 用户标记3NOTEQ
     */
    @JsonProperty("n_usertag3_noteq")
    @JSONField(name = "n_usertag3_noteq")
    @ApiModelProperty(value = "用户标记3NOTEQ", position = 201)
	private String userTag3NOTEQ;

    /**
     * 用户标记EQ
     */
    @JsonProperty("n_usertag_eq")
    @JSONField(name = "n_usertag_eq")
    @ApiModelProperty(value = "用户标记EQ", position = 210)
	private String userTagEQ;

    /**
     * 用户标记NOTEQ
     */
    @JsonProperty("n_usertag_noteq")
    @JSONField(name = "n_usertag_noteq")
    @ApiModelProperty(value = "用户标记NOTEQ", position = 211)
	private String userTagNOTEQ;

    /**
     * 用户标记4EQ
     */
    @JsonProperty("n_usertag4_eq")
    @JSONField(name = "n_usertag4_eq")
    @ApiModelProperty(value = "用户标记4EQ", position = 220)
	private String userTag4EQ;

    /**
     * 用户标记4NOTEQ
     */
    @JsonProperty("n_usertag4_noteq")
    @JSONField(name = "n_usertag4_noteq")
    @ApiModelProperty(value = "用户标记4NOTEQ", position = 221)
	private String userTag4NOTEQ;


}