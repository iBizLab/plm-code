/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
 * 页面[ArticlePageDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("页面DTO")
public class ArticlePageDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 0)
    private String identifier;

    /**
     * 是否开启共享
     */
    @JsonProperty("is_shared")
    @JSONField(name = "is_shared")
    @ApiModelProperty(value = "是否开启共享", position = 1)
    private String isShared;

    /**
     * 共享有效期
     */
    @JsonProperty("expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "expiration_date" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "共享有效期", position = 2)
    private Date expirationDate;

    /**
     * 访问密码
     */
    @JsonProperty("access_password")
    @JSONField(name = "access_password")
    @ApiModelProperty(value = "访问密码", position = 3)
    private String accessPassword;

    /**
     * 正文格式
     */
    @JsonProperty("format_type")
    @JSONField(name = "format_type")
    @ApiModelProperty(value = "正文格式", position = 4)
    private String formatType;

    /**
     * 序号
     */
    @JsonProperty("sequence")
    @JSONField(name = "sequence")
    @ApiModelProperty(value = "序号", position = 5)
    private BigDecimal sequence;

    /**
     * 正文
     */
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "正文", position = 6)
    private String content;

    /**
     * 类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "类型", position = 7)
    private String type;

    /**
     * 是否星标
     */
    @JsonProperty("is_favorite")
    @JSONField(name = "is_favorite")
    @ApiModelProperty(value = "是否星标", position = 8)
    private String isFavorite;

    /**
     * 是否叶子节点
     */
    @JsonProperty("is_leaf")
    @JSONField(name = "is_leaf")
    @ApiModelProperty(value = "是否叶子节点", position = 9)
    private Integer isLeaf;

    /**
     * 类别路径
     */
    @JsonProperty("categories")
    @JSONField(name = "categories")
    @ApiModelProperty(value = "类别路径", position = 10)
    private String categories;

    /**
     * 空间编号
     */
    @JsonProperty("space_identifier")
    @JSONField(name = "space_identifier")
    @ApiModelProperty(value = "空间编号", position = 11)
    private String spaceIdentifier;

    /**
     * 附件
     */
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "附件", position = 12)
    private List<AttachmentDTO> attachments;

    /**
     * 是否已归档
     */
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "是否已归档", position = 13)
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "是否已删除", position = 14)
    private Integer isDeleted;

    /**
     * 关注
     */
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "关注", position = 15)
    private List<AttentionDTO> attentions;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 16)
    private String curVersionId;

    /**
     * 当前版本名称
     */
    @JsonProperty("cur_version_name")
    @JSONField(name = "cur_version_name")
    @ApiModelProperty(value = "当前版本名称", position = 17)
    private String curVersionName;

    /**
     * 发布时间
     */
    @JsonProperty("publish_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "publish_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间", position = 18)
    private Date publishTime;

    /**
     * 是否发布
     */
    @JsonProperty("is_published")
    @JSONField(name = "is_published")
    @ApiModelProperty(value = "是否发布", position = 19)
    private Integer isPublished;

    /**
     * 发布人
     */
    @JsonProperty("publish_man")
    @JSONField(name = "publish_man")
    @ApiModelProperty(value = "发布人", position = 20)
    private String publishMan;

    /**
     * 发布正文
     */
    @JsonProperty("publish_content")
    @JSONField(name = "publish_content")
    @ApiModelProperty(value = "发布正文", position = 21)
    private String publishContent;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 22)
    private String showIdentifier;

    /**
     * 发布主题
     */
    @JsonProperty("publish_name")
    @JSONField(name = "publish_name")
    @ApiModelProperty(value = "发布主题", position = 23)
    private String publishName;

    /**
     * 发布状态
     */
    @JsonProperty("published")
    @JSONField(name = "published")
    @ApiModelProperty(value = "发布状态", position = 24)
    private Integer published;

    /**
     * 是否锁定
     */
    @JsonProperty("is_lock")
    @JSONField(name = "is_lock")
    @ApiModelProperty(value = "是否锁定", position = 25)
    private Integer isLock;

    /**
     * 图标
     */
    @JsonProperty("icon")
    @JSONField(name = "icon")
    @ApiModelProperty(value = "图标", position = 26)
    private String icon;

    /**
     * 是否同时共享子页面
     */
    @JsonProperty("is_shared_subset")
    @JSONField(name = "is_shared_subset")
    @ApiModelProperty(value = "是否同时共享子页面", position = 27)
    private String isSharedSubset;

    /**
     * 共享只读能力
     */
    @JsonProperty("read_shared")
    @JSONField(name = "read_shared")
    @ApiModelProperty(value = "共享只读能力", position = 28)
    private String readShared;

    /**
     * 共享人
     */
    @JsonProperty("shared_by")
    @JSONField(name = "shared_by")
    @ApiModelProperty(value = "共享人", position = 29)
    private String sharedBy;

    /**
     * 共享时间
     */
    @JsonProperty("shared_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "shared_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "共享时间", position = 30)
    private Date sharedTime;

    /**
     * 选择版本标识
     */
    @JsonProperty("choose_version_id")
    @JSONField(name = "choose_version_id")
    @ApiModelProperty(value = "选择版本标识", position = 31)
    private String chooseVersionId;

    /**
     * 选择版本名称
     */
    @JsonProperty("choose_version_name")
    @JSONField(name = "choose_version_name")
    @ApiModelProperty(value = "选择版本名称", position = 32)
    private String chooseVersionName;

    /**
     * 最近创建日期
     */
    @JsonProperty("recent_create_days")
    @JSONField(name = "recent_create_days")
    @ApiModelProperty(value = "最近创建日期", position = 33)
    private Integer recentCreateDays;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 34)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 35)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 36)
    private String id;

    /**
     * 主题
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "主题", position = 37)
    private String name;

    /**
     * 父页面标识
     */
    @JsonProperty("parent_id")
    @JSONField(name = "parent_id")
    @ApiModelProperty(value = "父页面标识", position = 38)
    private String parentId;

    /**
     * 空间标识
     */
    @JsonProperty("space_id")
    @JSONField(name = "space_id")
    @ApiModelProperty(value = "空间标识", position = 39)
    private String spaceId;

    /**
     * 空间名称
     */
    @JsonProperty("space_name")
    @JSONField(name = "space_name")
    @ApiModelProperty(value = "空间名称", position = 40)
    private String spaceName;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 41)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 42)
    private Date updateTime;


    /**
     * 设置 [编号]
     */
    public ArticlePageDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [是否开启共享]
     */
    public ArticlePageDTO setIsShared(String isShared) {
        this.isShared = isShared;
        this.modify("is_shared", isShared);
        return this;
    }

    /**
     * 设置 [共享有效期]
     */
    public ArticlePageDTO setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        this.modify("expiration_date", expirationDate);
        return this;
    }

    /**
     * 设置 [访问密码]
     */
    public ArticlePageDTO setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
        this.modify("access_password", accessPassword);
        return this;
    }

    /**
     * 设置 [正文格式]
     */
    public ArticlePageDTO setFormatType(String formatType) {
        this.formatType = formatType;
        this.modify("format_type", formatType);
        return this;
    }

    /**
     * 设置 [正文]
     */
    public ArticlePageDTO setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [类型]
     */
    public ArticlePageDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [是否星标]
     */
    public ArticlePageDTO setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
        this.modify("is_favorite", isFavorite);
        return this;
    }

    /**
     * 设置 [是否叶子节点]
     */
    public ArticlePageDTO setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
     * 设置 [空间编号]
     */
    public ArticlePageDTO setSpaceIdentifier(String spaceIdentifier) {
        this.spaceIdentifier = spaceIdentifier;
        this.modify("space_identifier", spaceIdentifier);
        return this;
    }

    /**
     * 设置 [附件]
     */
    public ArticlePageDTO setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
     * 设置 [是否已归档]
     */
    public ArticlePageDTO setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
     * 设置 [是否已删除]
     */
    public ArticlePageDTO setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
     * 设置 [关注]
     */
    public ArticlePageDTO setAttentions(List<AttentionDTO> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
     * 设置 [发布时间]
     */
    public ArticlePageDTO setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        this.modify("publish_time", publishTime);
        return this;
    }

    /**
     * 设置 [是否发布]
     */
    public ArticlePageDTO setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
        this.modify("is_published", isPublished);
        return this;
    }

    /**
     * 设置 [发布人]
     */
    public ArticlePageDTO setPublishMan(String publishMan) {
        this.publishMan = publishMan;
        this.modify("publish_man", publishMan);
        return this;
    }

    /**
     * 设置 [发布正文]
     */
    public ArticlePageDTO setPublishContent(String publishContent) {
        this.publishContent = publishContent;
        this.modify("publish_content", publishContent);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public ArticlePageDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [发布主题]
     */
    public ArticlePageDTO setPublishName(String publishName) {
        this.publishName = publishName;
        this.modify("publish_name", publishName);
        return this;
    }

    /**
     * 设置 [发布状态]
     */
    public ArticlePageDTO setPublished(Integer published) {
        this.published = published;
        this.modify("published", published);
        return this;
    }

    /**
     * 设置 [是否锁定]
     */
    public ArticlePageDTO setIsLock(Integer isLock) {
        this.isLock = isLock;
        this.modify("is_lock", isLock);
        return this;
    }

    /**
     * 设置 [图标]
     */
    public ArticlePageDTO setIcon(String icon) {
        this.icon = icon;
        this.modify("icon", icon);
        return this;
    }

    /**
     * 设置 [是否同时共享子页面]
     */
    public ArticlePageDTO setIsSharedSubset(String isSharedSubset) {
        this.isSharedSubset = isSharedSubset;
        this.modify("is_shared_subset", isSharedSubset);
        return this;
    }

    /**
     * 设置 [共享只读能力]
     */
    public ArticlePageDTO setReadShared(String readShared) {
        this.readShared = readShared;
        this.modify("read_shared", readShared);
        return this;
    }

    /**
     * 设置 [共享人]
     */
    public ArticlePageDTO setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
        this.modify("shared_by", sharedBy);
        return this;
    }

    /**
     * 设置 [共享时间]
     */
    public ArticlePageDTO setSharedTime(Date sharedTime) {
        this.sharedTime = sharedTime;
        this.modify("shared_time", sharedTime);
        return this;
    }

    /**
     * 设置 [选择版本标识]
     */
    public ArticlePageDTO setChooseVersionId(String chooseVersionId) {
        this.chooseVersionId = chooseVersionId;
        this.modify("choose_version_id", chooseVersionId);
        return this;
    }

    /**
     * 设置 [选择版本名称]
     */
    public ArticlePageDTO setChooseVersionName(String chooseVersionName) {
        this.chooseVersionName = chooseVersionName;
        this.modify("choose_version_name", chooseVersionName);
        return this;
    }

    /**
     * 设置 [最近创建日期]
     */
    public ArticlePageDTO setRecentCreateDays(Integer recentCreateDays) {
        this.recentCreateDays = recentCreateDays;
        this.modify("recent_create_days", recentCreateDays);
        return this;
    }

    /**
     * 设置 [主题]
     */
    public ArticlePageDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [父页面标识]
     */
    public ArticlePageDTO setParentId(String parentId) {
        this.parentId = parentId;
        this.modify("parent_id", parentId);
        return this;
    }

    /**
     * 设置 [空间标识]
     */
    public ArticlePageDTO setSpaceId(String spaceId) {
        this.spaceId = spaceId;
        this.modify("space_id", spaceId);
        return this;
    }

    /**
     * 设置 [空间名称]
     */
    public ArticlePageDTO setSpaceName(String spaceName) {
        this.spaceName = spaceName;
        this.modify("space_name", spaceName);
        return this;
    }


}
