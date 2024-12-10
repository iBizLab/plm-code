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
 * 评审[ReviewBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("评审DTO")
public class ReviewBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别", position = 0)
    private String categories;

    /**
     * 类别
     */
    @JsonProperty("categories_name")
    @JSONField(name = "categories_name")
    @ApiModelProperty(value = "类别", position = 1)
    private String categoriesName;

    /**
     * 提交时间
     */
    @JsonProperty("submitted_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "submitted_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间", position = 2)
    private Date submittedAt;

    /**
     * 完成时间
     */
    @JsonProperty("completed_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "completed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间", position = 3)
    private Date completedAt;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 4)
    private Date updateTime;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 5)
    private Date createTime;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 6)
    private String createMan;

    /**
     * 关注人
     */
    @JsonProperty("attentions_imp")
    @JSONField(name = "attentions_imp")
    @ApiModelProperty(value = "关注人", position = 7)
    private String attentionsImp;

    /**
     * 提交人
     */
    @JsonProperty("submitter_name")
    @JSONField(name = "submitter_name")
    @ApiModelProperty(value = "提交人", position = 8)
    private String submitterName;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 9)
    private String name;

    /**
     * 提交人标识
     */
    @JsonProperty("submitter_id")
    @JSONField(name = "submitter_id")
    @ApiModelProperty(value = "提交人标识", position = 10)
    private String submitterId;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 11)
    private String showIdentifier;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 12)
    private String identifier;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 13)
    private String updateMan;

    /**
     * 测试库名称
     */
    @JsonProperty("library_name")
    @JSONField(name = "library_name")
    @ApiModelProperty(value = "测试库名称", position = 14)
    private String libraryName;

    /**
     * 测试库标识
     */
    @JsonProperty("library_id")
    @JSONField(name = "library_id")
    @ApiModelProperty(value = "测试库标识", position = 15)
    private String libraryId;

    /**
     * 流程准则标识
     */
    @JsonProperty("guideline_id")
    @JSONField(name = "guideline_id")
    @ApiModelProperty(value = "流程准则标识", position = 16)
    private String guidelineId;

    /**
     * 评审状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "评审状态", position = 17)
    private String state;

    /**
     * 评审类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "评审类型", position = 18)
    private String type;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 19)
    private String id;

    /**
     * 测试库是否删除
     */
    @JsonProperty("library_is_deleted")
    @JSONField(name = "library_is_deleted")
    @ApiModelProperty(value = "测试库是否删除", position = 20)
    private Integer libraryIsDeleted;


    /**
     * 设置 [类别]
     */
    public ReviewBiSearchGroupDTO setCategories(String categories) {
        this.categories = categories;
        this.modify("categories", categories);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public ReviewBiSearchGroupDTO setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
        this.modify("categories_name", categoriesName);
        return this;
    }

    /**
     * 设置 [提交时间]
     */
    public ReviewBiSearchGroupDTO setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
        this.modify("submitted_at", submittedAt);
        return this;
    }

    /**
     * 设置 [完成时间]
     */
    public ReviewBiSearchGroupDTO setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
        this.modify("completed_at", completedAt);
        return this;
    }

    /**
     * 设置 [关注人]
     */
    public ReviewBiSearchGroupDTO setAttentionsImp(String attentionsImp) {
        this.attentionsImp = attentionsImp;
        this.modify("attentions_imp", attentionsImp);
        return this;
    }

    /**
     * 设置 [提交人]
     */
    public ReviewBiSearchGroupDTO setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
        this.modify("submitter_name", submitterName);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public ReviewBiSearchGroupDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [提交人标识]
     */
    public ReviewBiSearchGroupDTO setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
        this.modify("submitter_id", submitterId);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public ReviewBiSearchGroupDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public ReviewBiSearchGroupDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [测试库名称]
     */
    public ReviewBiSearchGroupDTO setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }

    /**
     * 设置 [测试库标识]
     */
    public ReviewBiSearchGroupDTO setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
     * 设置 [流程准则标识]
     */
    public ReviewBiSearchGroupDTO setGuidelineId(String guidelineId) {
        this.guidelineId = guidelineId;
        this.modify("guideline_id", guidelineId);
        return this;
    }

    /**
     * 设置 [评审状态]
     */
    public ReviewBiSearchGroupDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [评审类型]
     */
    public ReviewBiSearchGroupDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [测试库是否删除]
     */
    public ReviewBiSearchGroupDTO setLibraryIsDeleted(Integer libraryIsDeleted) {
        this.libraryIsDeleted = libraryIsDeleted;
        this.modify("library_is_deleted", libraryIsDeleted);
        return this;
    }


}
