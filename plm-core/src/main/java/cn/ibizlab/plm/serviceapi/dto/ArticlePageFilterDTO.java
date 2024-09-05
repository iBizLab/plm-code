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
     * 编号LIKE
     */
    @JsonProperty("n_identifier_like")
    @JSONField(name = "n_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 1)
	private String identifierLIKE;

    /**
     * 是否开启共享EQ
     */
    @JsonProperty("n_is_shared_eq")
    @JSONField(name = "n_is_shared_eq")
    @ApiModelProperty(value = "是否开启共享EQ", position = 10)
	private String isSharedEQ;

    /**
     * 正文格式EQ
     */
    @JsonProperty("n_format_type_eq")
    @JSONField(name = "n_format_type_eq")
    @ApiModelProperty(value = "正文格式EQ", position = 40)
	private String formatTypeEQ;

    /**
     * 正文LIKE
     */
    @JsonProperty("n_content_like")
    @JSONField(name = "n_content_like")
    @ApiModelProperty(value = "正文LIKE", position = 60)
	private String contentLIKE;

    /**
     * 类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "类型EQ", position = 70)
	private String typeEQ;

    /**
     * 类别路径LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty(value = "类别路径LIKE", position = 110)
	private String categoriesLIKE;

    /**
     * 是否已归档EQ
     */
    @JsonProperty("n_is_archived_eq")
    @JSONField(name = "n_is_archived_eq")
    @ApiModelProperty(value = "是否已归档EQ", position = 130)
	private Integer isArchivedEQ;

    /**
     * 是否已删除EQ
     */
    @JsonProperty("n_is_deleted_eq")
    @JSONField(name = "n_is_deleted_eq")
    @ApiModelProperty(value = "是否已删除EQ", position = 140)
	private Integer isDeletedEQ;

    /**
     * 关注EXISTS
     */
    @JsonProperty("n_attentions_exists__n_user_id_eq")
    @JSONField(name = "n_attentions_exists__n_user_id_eq")
    @ApiModelProperty(value = "关注EXISTS关注人EQ", position = 150)
	private String attentionsEXISTSuser_idEQ;

    /**
     * 发布时间GTANDEQ
     */
    @JsonProperty("n_publish_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_publish_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间GTANDEQ", position = 180)
	private Date publishTimeGTANDEQ;

    /**
     * 发布时间LTANDEQ
     */
    @JsonProperty("n_publish_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_publish_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间LTANDEQ", position = 181)
	private Date publishTimeLTANDEQ;

    /**
     * 发布人EQ
     */
    @JsonProperty("n_publish_man_eq")
    @JSONField(name = "n_publish_man_eq")
    @ApiModelProperty(value = "发布人EQ", position = 200)
	private String publishManEQ;

    /**
     * 编号EQ
     */
    @JsonProperty("n_show_identifier_eq")
    @JSONField(name = "n_show_identifier_eq")
    @ApiModelProperty(value = "编号EQ", position = 220)
	private String showIdentifierEQ;

    /**
     * 编号LIKE
     */
    @JsonProperty("n_show_identifier_like")
    @JSONField(name = "n_show_identifier_like")
    @ApiModelProperty(value = "编号LIKE", position = 221)
	private String showIdentifierLIKE;

    /**
     * 是否同时共享子页面EQ
     */
    @JsonProperty("n_is_shared_subset_eq")
    @JSONField(name = "n_is_shared_subset_eq")
    @ApiModelProperty(value = "是否同时共享子页面EQ", position = 270)
	private String isSharedSubsetEQ;

    /**
     * 最近创建日期LTANDEQ
     */
    @JsonProperty("n_recent_create_days_ltandeq")
    @JSONField(name = "n_recent_create_days_ltandeq")
    @ApiModelProperty(value = "最近创建日期LTANDEQ", position = 330)
	private Integer recentCreateDaysLTANDEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 340)
	private String idEQ;

    /**
     * 标识IN
     */
    @JsonProperty("n_id_in")
    @JSONField(name = "n_id_in")
    @ApiModelProperty(value = "标识IN", position = 341)
	private String idIN;

    /**
     * 标识NOTEQ
     */
    @JsonProperty("n_id_noteq")
    @JSONField(name = "n_id_noteq")
    @ApiModelProperty(value = "标识NOTEQ", position = 342)
	private String idNOTEQ;

    /**
     * 主题LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "主题LIKE", position = 350)
	private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 360)
	private String createManEQ;

    /**
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty(value = "建立人IN", position = 361)
	private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty(value = "建立人ISNOTNULL", position = 362)
	private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty(value = "建立人ISNULL", position = 363)
	private String createManISNULL;

    /**
     * 建立人NOTEQ
     */
    @JsonProperty("n_create_man_noteq")
    @JSONField(name = "n_create_man_noteq")
    @ApiModelProperty(value = "建立人NOTEQ", position = 364)
	private String createManNOTEQ;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty(value = "建立人NOTIN", position = 365)
	private String createManNOTIN;

    /**
     * 建立时间EQ
     */
    @JsonProperty("n_create_time_eq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_eq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间EQ", position = 370)
	private Date createTimeEQ;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 371)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 372)
	private Date createTimeLTANDEQ;

    /**
     * 更新时间GTANDEQ
     */
    @JsonProperty("n_update_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间GTANDEQ", position = 390)
	private Date updateTimeGTANDEQ;

    /**
     * 更新时间LTANDEQ
     */
    @JsonProperty("n_update_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间LTANDEQ", position = 391)
	private Date updateTimeLTANDEQ;

    /**
     * 空间标识EQ
     */
    @JsonProperty("n_space_id_eq")
    @JSONField(name = "n_space_id_eq")
    @ApiModelProperty(value = "空间标识EQ", position = 400)
	private String spaceIdEQ;

    /**
     * 父页面标识EQ
     */
    @JsonProperty("n_parent_id_eq")
    @JSONField(name = "n_parent_id_eq")
    @ApiModelProperty(value = "父页面标识EQ", position = 410)
	private String parentIdEQ;

    /**
     * 父页面标识ISNOTNULL
     */
    @JsonProperty("n_parent_id_isnotnull")
    @JSONField(name = "n_parent_id_isnotnull")
    @ApiModelProperty(value = "父页面标识ISNOTNULL", position = 411)
	private String parentIdISNOTNULL;

    /**
     * 父页面标识ISNULL
     */
    @JsonProperty("n_parent_id_isnull")
    @JSONField(name = "n_parent_id_isnull")
    @ApiModelProperty(value = "父页面标识ISNULL", position = 412)
	private String parentIdISNULL;

    /**
     * 空间名称EQ
     */
    @JsonProperty("n_space_name_eq")
    @JSONField(name = "n_space_name_eq")
    @ApiModelProperty(value = "空间名称EQ", position = 420)
	private String spaceNameEQ;

    /**
     * 空间名称LIKE
     */
    @JsonProperty("n_space_name_like")
    @JSONField(name = "n_space_name_like")
    @ApiModelProperty(value = "空间名称LIKE", position = 421)
	private String spaceNameLIKE;


}