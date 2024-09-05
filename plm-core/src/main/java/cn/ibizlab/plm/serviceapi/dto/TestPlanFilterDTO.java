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
 * 测试计划过滤[TestPlanFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("测试计划过滤DTO")
public class TestPlanFilterDTO extends FilterBase implements Serializable {

    /**
     * 状态EQ
     */
    @JsonProperty("n_status_eq")
    @JSONField(name = "n_status_eq")
    @ApiModelProperty(value = "状态EQ", position = 0)
	private String statusEQ;

    /**
     * 测试分类EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "测试分类EQ", position = 10)
	private String typeEQ;

    /**
     * 类别LIKE
     */
    @JsonProperty("n_categories_like")
    @JSONField(name = "n_categories_like")
    @ApiModelProperty(value = "类别LIKE", position = 50)
	private String categoriesLIKE;

    /**
     * 负责人EQ
     */
    @JsonProperty("n_assignee_name_eq")
    @JSONField(name = "n_assignee_name_eq")
    @ApiModelProperty(value = "负责人EQ", position = 80)
	private String assigneeNameEQ;

    /**
     * 负责人标识EQ
     */
    @JsonProperty("n_assignee_id_eq")
    @JSONField(name = "n_assignee_id_eq")
    @ApiModelProperty(value = "负责人标识EQ", position = 90)
	private String assigneeIdEQ;

    /**
     * 负责人标识IN
     */
    @JsonProperty("n_assignee_id_in")
    @JSONField(name = "n_assignee_id_in")
    @ApiModelProperty(value = "负责人标识IN", position = 91)
	private String assigneeIdIN;

    /**
     * 负责人标识ISNOTNULL
     */
    @JsonProperty("n_assignee_id_isnotnull")
    @JSONField(name = "n_assignee_id_isnotnull")
    @ApiModelProperty(value = "负责人标识ISNOTNULL", position = 92)
	private String assigneeIdISNOTNULL;

    /**
     * 负责人标识ISNULL
     */
    @JsonProperty("n_assignee_id_isnull")
    @JSONField(name = "n_assignee_id_isnull")
    @ApiModelProperty(value = "负责人标识ISNULL", position = 93)
	private String assigneeIdISNULL;

    /**
     * 负责人标识NOTIN
     */
    @JsonProperty("n_assignee_id_notin")
    @JSONField(name = "n_assignee_id_notin")
    @ApiModelProperty(value = "负责人标识NOTIN", position = 94)
	private String assigneeIdNOTIN;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 120)
	private String idEQ;

    /**
     * 计划名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "计划名称LIKE", position = 130)
	private String nameLIKE;

    /**
     * 建立人EQ
     */
    @JsonProperty("n_create_man_eq")
    @JSONField(name = "n_create_man_eq")
    @ApiModelProperty(value = "建立人EQ", position = 140)
	private String createManEQ;

    /**
     * 建立人IN
     */
    @JsonProperty("n_create_man_in")
    @JSONField(name = "n_create_man_in")
    @ApiModelProperty(value = "建立人IN", position = 141)
	private String createManIN;

    /**
     * 建立人ISNOTNULL
     */
    @JsonProperty("n_create_man_isnotnull")
    @JSONField(name = "n_create_man_isnotnull")
    @ApiModelProperty(value = "建立人ISNOTNULL", position = 142)
	private String createManISNOTNULL;

    /**
     * 建立人ISNULL
     */
    @JsonProperty("n_create_man_isnull")
    @JSONField(name = "n_create_man_isnull")
    @ApiModelProperty(value = "建立人ISNULL", position = 143)
	private String createManISNULL;

    /**
     * 建立人NOTIN
     */
    @JsonProperty("n_create_man_notin")
    @JSONField(name = "n_create_man_notin")
    @ApiModelProperty(value = "建立人NOTIN", position = 144)
	private String createManNOTIN;

    /**
     * 建立时间GTANDEQ
     */
    @JsonProperty("n_create_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间GTANDEQ", position = 150)
	private Date createTimeGTANDEQ;

    /**
     * 建立时间LTANDEQ
     */
    @JsonProperty("n_create_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_create_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间LTANDEQ", position = 151)
	private Date createTimeLTANDEQ;

    /**
     * 更新时间GTANDEQ
     */
    @JsonProperty("n_update_time_gtandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_gtandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间GTANDEQ", position = 170)
	private Date updateTimeGTANDEQ;

    /**
     * 更新时间LTANDEQ
     */
    @JsonProperty("n_update_time_ltandeq")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "n_update_time_ltandeq" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间LTANDEQ", position = 171)
	private Date updateTimeLTANDEQ;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_library_id_eq")
    @JSONField(name = "n_library_id_eq")
    @ApiModelProperty(value = "测试库标识EQ", position = 180)
	private String libraryIdEQ;

    /**
     * 关联项目EQ
     */
    @JsonProperty("n_project_id_eq")
    @JSONField(name = "n_project_id_eq")
    @ApiModelProperty(value = "关联项目EQ", position = 190)
	private String projectIdEQ;

    /**
     * 关联迭代EQ
     */
    @JsonProperty("n_sprint_id_eq")
    @JSONField(name = "n_sprint_id_eq")
    @ApiModelProperty(value = "关联迭代EQ", position = 200)
	private String sprintIdEQ;

    /**
     * 关联项目EQ
     */
    @JsonProperty("n_project_name_eq")
    @JSONField(name = "n_project_name_eq")
    @ApiModelProperty(value = "关联项目EQ", position = 210)
	private String projectNameEQ;

    /**
     * 关联项目LIKE
     */
    @JsonProperty("n_project_name_like")
    @JSONField(name = "n_project_name_like")
    @ApiModelProperty(value = "关联项目LIKE", position = 211)
	private String projectNameLIKE;

    /**
     * 关联迭代EQ
     */
    @JsonProperty("n_sprint_name_eq")
    @JSONField(name = "n_sprint_name_eq")
    @ApiModelProperty(value = "关联迭代EQ", position = 220)
	private String sprintNameEQ;

    /**
     * 关联迭代LIKE
     */
    @JsonProperty("n_sprint_name_like")
    @JSONField(name = "n_sprint_name_like")
    @ApiModelProperty(value = "关联迭代LIKE", position = 221)
	private String sprintNameLIKE;

    /**
     * 所属测试库EQ
     */
    @JsonProperty("n_library_name_eq")
    @JSONField(name = "n_library_name_eq")
    @ApiModelProperty(value = "所属测试库EQ", position = 230)
	private String libraryNameEQ;

    /**
     * 所属测试库LIKE
     */
    @JsonProperty("n_library_name_like")
    @JSONField(name = "n_library_name_like")
    @ApiModelProperty(value = "所属测试库LIKE", position = 231)
	private String libraryNameLIKE;

    /**
     * 项目发布标识EQ
     */
    @JsonProperty("n_release_id_eq")
    @JSONField(name = "n_release_id_eq")
    @ApiModelProperty(value = "项目发布标识EQ", position = 240)
	private String releaseIdEQ;

    /**
     * 名称EQ
     */
    @JsonProperty("n_release_name_eq")
    @JSONField(name = "n_release_name_eq")
    @ApiModelProperty(value = "名称EQ", position = 250)
	private String releaseNameEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_release_name_like")
    @JSONField(name = "n_release_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 251)
	private String releaseNameLIKE;


}