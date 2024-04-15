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
 * 页面过滤[ArticlePageFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("页面过滤DTO")
public class ArticlePageFilterDTO extends FilterBase implements Serializable {

    /**
     * 编号EQ
     */
    @JsonProperty("n_identifier_eq")
    @JSONField(name = "n_identifier_eq")
    @ApiModelProperty(value = "编号EQ", position = 0)
	private String identifierEQ;

    /**
     * 正文格式EQ
     */
    @JsonProperty("n_format_type_eq")
    @JSONField(name = "n_format_type_eq")
    @ApiModelProperty(value = "正文格式EQ", position = 10)
	private String formatTypeEQ;

    /**
     * 正文LIKE
     */
    @JsonProperty("n_content_like")
    @JSONField(name = "n_content_like")
    @ApiModelProperty(value = "正文LIKE", position = 30)
	private String contentLIKE;

    /**
     * 类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "类型EQ", position = 40)
	private String typeEQ;

    /**
     * 是否星标EQ
     */
    @JsonProperty("n_is_favorite_eq")
    @JSONField(name = "n_is_favorite_eq")
    @ApiModelProperty(value = "是否星标EQ", position = 50)
	private String isFavoriteEQ;

    /**
     * 发布时间GTANDEQ
     */
    @JsonProperty("n_publish_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_publish_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间GTANDEQ", position = 140)
	private Date publishTimeGTANDEQ;

    /**
     * 发布时间LTANDEQ
     */
    @JsonProperty("n_publish_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_publish_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间LTANDEQ", position = 141)
	private Date publishTimeLTANDEQ;

    /**
     * 发布人EQ
     */
    @JsonProperty("n_publish_man_eq")
    @JSONField(name = "n_publish_man_eq")
    @ApiModelProperty(value = "发布人EQ", position = 160)
	private String publishManEQ;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 210)
	private String idNOTEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 211)
	private String idEQ;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间EQ", position = 240)
	private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 241)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 242)
	private Date createTimeLTANDEQ;

    /**
     * 主题LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "主题LIKE", position = 250)
	private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 260)
	private String createManEQ;

    /**
     * 空间标识EQ
     */
    @JsonProperty("n_space_id_eq")
    @JSONField(name = "n_space_id_eq")
    @ApiModelProperty(value = "空间标识EQ", position = 270)
	private String spaceIdEQ;

    /**
     * 父页面标识EQ
     */
    @JsonProperty("n_parent_id_eq")
    @JSONField(name = "n_parent_id_eq")
    @ApiModelProperty(value = "父页面标识EQ", position = 280)
	private String parentIdEQ;

    /**
     * 父页面标识ISNULL
     */
    @JsonProperty("n_parent_id_isnull")
    @JSONField(name = "n_parent_id_isnull")
    @ApiModelProperty(value = "父页面标识ISNULL", position = 281)
	private String parentIdISNULL;

    /**
     * 空间名称EQ
     */
    @JsonProperty("n_space_name_eq")
    @JSONField(name = "n_space_name_eq")
    @ApiModelProperty(value = "空间名称EQ", position = 290)
	private String spaceNameEQ;

    /**
     * 空间名称LIKE
     */
    @JsonProperty("n_space_name_like")
    @JSONField(name = "n_space_name_like")
    @ApiModelProperty(value = "空间名称LIKE", position = 291)
	private String spaceNameLIKE;


}