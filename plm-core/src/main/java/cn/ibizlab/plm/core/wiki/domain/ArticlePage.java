/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.wiki.domain;

import java.util.*;
import java.math.BigDecimal;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import cn.ibizlab.plm.core.wiki.domain.Space;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 页面实体类[ArticlePage]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "PAGE", resultMap = "ArticlePageResultMap")
@ApiModel(value = "PAGE", description = "页面")
public class ArticlePage extends EntityMP implements Serializable
{

    /**
    * 编号
    */
    @TableField(value = "identifier")
    @DEField(name = "identifier" , dupCheck = DupCheck.ALL , dupCheckField = "spaceId")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
    * 正文格式
    */
    @TableField(value = "format_type")
    @DEField(name = "format_type" , defaultValue = "HTML" , dict = "CodeList54")
    @JSONField(name = "format_type")
    @JsonProperty("format_type")
    @ApiModelProperty(value = "format_type", notes = "正文格式")
    private String formatType;

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , defaultValue = "1")
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 正文
    */
    @TableField(value = "content")
    @DEField(name = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    @ApiModelProperty(value = "content", notes = "正文")
    private String content;

    /**
    * 类型
    */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "page_type")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty(value = "type", notes = "类型")
    private String type;

    /**
    * 是否星标
    */
    @TableField(value = "is_favorite" , exist = false)
    @DEField(name = "is_favorite" , dict = "YesNo")
    @JSONField(name = "is_favorite")
    @JsonProperty("is_favorite")
    @ApiModelProperty(value = "is_favorite", notes = "是否星标")
    private String isFavorite;

    /**
    * 是否叶子节点
    */
    @TableField(value = "is_leaf")
    @DEField(name = "is_leaf" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "is_leaf")
    @JsonProperty("is_leaf")
    @ApiModelProperty(value = "is_leaf", notes = "是否叶子节点")
    private Integer isLeaf;

    /**
    * 空间编号
    */
    @TableField(value = "space_identifier" , exist = false)
    @DEField(name = "space_identifier")
    @JSONField(name = "space_identifier")
    @JsonProperty("space_identifier")
    @ApiModelProperty(value = "space_identifier", notes = "空间编号")
    private String spaceIdentifier;

    /**
    * 类别路径
    */
    @TableField(value = "categories")
    @DEField(name = "categories" , preType = DEPredefinedFieldType.PARENTIDPATH)
    @JSONField(name = "categories")
    @JsonProperty("categories")
    @ApiModelProperty(value = "categories", notes = "类别路径")
    private String categories;

    /**
    * 附件
    */
    @TableField(exist = false)
    @DEField(name = "attachments")
    @JSONField(name = "attachments")
    @JsonProperty("attachments")
    @ApiModelProperty(value = "attachments", notes = "附件")
    private List<Attachment> attachments;

    /**
    * 是否已归档
    */
    @TableField(value = "is_archived")
    @DEField(name = "is_archived" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_archived")
    @JsonProperty("is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private Integer isArchived;

    /**
    * 是否已删除
    */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_deleted")
    @JsonProperty("is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
    * 关注
    */
    @TableField(exist = false)
    @DEField(name = "attentions")
    @JSONField(name = "attentions")
    @JsonProperty("attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
    * 当前版本标识
    */
    @TableField(value = "cur_version_id")
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JSONField(name = "cur_version_id")
    @JsonProperty("cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
    * 当前版本名称
    */
    @TableField(value = "cur_version_name")
    @DEField(name = "cur_version_name" , preType = DEPredefinedFieldType.VERSION)
    @JSONField(name = "cur_version_name")
    @JsonProperty("cur_version_name")
    @ApiModelProperty(value = "cur_version_name", notes = "当前版本名称")
    private String curVersionName;

    /**
    * 发布时间
    */
    @TableField(value = "publish_time")
    @DEField(name = "publish_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "publish_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("publish_time")
    @ApiModelProperty(value = "publish_time", notes = "发布时间")
    private Date publishTime;

    /**
    * 是否发布
    */
    @TableField(value = "is_published")
    @DEField(name = "is_published" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_published")
    @JsonProperty("is_published")
    @ApiModelProperty(value = "is_published", notes = "是否发布")
    private Integer isPublished;

    /**
    * 发布人
    */
    @TableField(value = "publish_man")
    @DEField(name = "publish_man")
    @JSONField(name = "publish_man")
    @JsonProperty("publish_man")
    @ApiModelProperty(value = "publish_man", notes = "发布人")
    private String publishMan;

    /**
    * 发布正文
    */
    @TableField(value = "publish_content")
    @DEField(name = "publish_content")
    @JSONField(name = "publish_content")
    @JsonProperty("publish_content")
    @ApiModelProperty(value = "publish_content", notes = "发布正文")
    private String publishContent;

    /**
    * 编号
    */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JSONField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
    * 发布主题
    */
    @TableField(value = "publish_name")
    @DEField(name = "publish_name")
    @JSONField(name = "publish_name")
    @JsonProperty("publish_name")
    @ApiModelProperty(value = "publish_name", notes = "发布主题")
    private String publishName;

    /**
    * 发布状态
    */
    @TableField(value = "published")
    @DEField(name = "published" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "published")
    @JsonProperty("published")
    @ApiModelProperty(value = "published", notes = "发布状态")
    private Integer published;

    /**
    * 是否锁定
    */
    @TableField(value = "is_lock")
    @DEField(name = "is_lock" , defaultValue = "0" , dict = "YesNo")
    @JSONField(name = "is_lock")
    @JsonProperty("is_lock")
    @ApiModelProperty(value = "is_lock", notes = "是否锁定")
    private Integer isLock;

    /**
    * 选择版本标识
    */
    @TableField(value = "choose_version_id" , exist = false)
    @DEField(name = "choose_version_id")
    @JSONField(name = "choose_version_id")
    @JsonProperty("choose_version_id")
    @ApiModelProperty(value = "choose_version_id", notes = "选择版本标识")
    private String chooseVersionId;

    /**
    * 选择版本名称
    */
    @TableField(value = "choose_version_name" , exist = false)
    @DEField(name = "choose_version_name")
    @JSONField(name = "choose_version_name")
    @JsonProperty("choose_version_name")
    @ApiModelProperty(value = "choose_version_name", notes = "选择版本名称")
    private String chooseVersionName;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 主题
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "主题")
    private String name;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 空间标识
    */
    @TableField(value = "space_id")
    @DEField(name = "space_id")
    @JSONField(name = "space_id")
    @JsonProperty("space_id")
    @ApiModelProperty(value = "space_id", notes = "空间标识")
    private String spaceId;

    /**
    * 父页面标识
    */
    @TableField(value = "parent_id")
    @DEField(name = "parent_id")
    @JSONField(name = "parent_id")
    @JsonProperty("parent_id")
    @ApiModelProperty(value = "parent_id", notes = "父页面标识")
    private String parentId;

    /**
    * 空间名称
    */
    @TableField(value = "space_name" , exist = false)
    @DEField(name = "space_name")
    @JSONField(name = "space_name")
    @JsonProperty("space_name")
    @ApiModelProperty(value = "space_name", notes = "空间名称")
    private String spaceName;

    /**
    * 嵌套页面
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "page", notes = "嵌套页面")
    private ArticlePage page;

    /**
    * 空间-页面
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "space", notes = "空间-页面")
    private Space space;

    /**
    * 设置 [编号]
    */
    public ArticlePage setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
    * 设置 [正文格式]
    */
    public ArticlePage setFormatType(String formatType) {
        this.formatType = formatType;
        this.modify("format_type", formatType);
        return this;
    }

    /**
    * 设置 [序号]
    */
    public ArticlePage setSequence(BigDecimal sequence) {
        this.sequence = sequence;
        this.modify("sequence", sequence);
        return this;
    }

    /**
    * 设置 [正文]
    */
    public ArticlePage setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
    * 设置 [类型]
    */
    public ArticlePage setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
    * 设置 [是否星标]
    */
    public ArticlePage setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
        this.modify("is_favorite", isFavorite);
        return this;
    }

    /**
    * 设置 [是否叶子节点]
    */
    public ArticlePage setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
    * 设置 [空间编号]
    */
    public ArticlePage setSpaceIdentifier(String spaceIdentifier) {
        this.spaceIdentifier = spaceIdentifier;
        this.modify("space_identifier", spaceIdentifier);
        return this;
    }

    /**
    * 设置 [附件]
    */
    public ArticlePage setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        this.modify("attachments", attachments);
        return this;
    }

    /**
    * 设置 [是否已归档]
    */
    public ArticlePage setIsArchived(Integer isArchived) {
        this.isArchived = isArchived;
        this.modify("is_archived", isArchived);
        return this;
    }

    /**
    * 设置 [是否已删除]
    */
    public ArticlePage setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        this.modify("is_deleted", isDeleted);
        return this;
    }

    /**
    * 设置 [关注]
    */
    public ArticlePage setAttentions(List<Attention> attentions) {
        this.attentions = attentions;
        this.modify("attentions", attentions);
        return this;
    }

    /**
    * 设置 [发布时间]
    */
    public ArticlePage setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        this.modify("publish_time", publishTime);
        return this;
    }

    /**
    * 设置 [是否发布]
    */
    public ArticlePage setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
        this.modify("is_published", isPublished);
        return this;
    }

    /**
    * 设置 [发布人]
    */
    public ArticlePage setPublishMan(String publishMan) {
        this.publishMan = publishMan;
        this.modify("publish_man", publishMan);
        return this;
    }

    /**
    * 设置 [发布正文]
    */
    public ArticlePage setPublishContent(String publishContent) {
        this.publishContent = publishContent;
        this.modify("publish_content", publishContent);
        return this;
    }

    /**
    * 设置 [编号]
    */
    public ArticlePage setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
    * 设置 [发布主题]
    */
    public ArticlePage setPublishName(String publishName) {
        this.publishName = publishName;
        this.modify("publish_name", publishName);
        return this;
    }

    /**
    * 设置 [发布状态]
    */
    public ArticlePage setPublished(Integer published) {
        this.published = published;
        this.modify("published", published);
        return this;
    }

    /**
    * 设置 [是否锁定]
    */
    public ArticlePage setIsLock(Integer isLock) {
        this.isLock = isLock;
        this.modify("is_lock", isLock);
        return this;
    }

    /**
    * 设置 [选择版本标识]
    */
    public ArticlePage setChooseVersionId(String chooseVersionId) {
        this.chooseVersionId = chooseVersionId;
        this.modify("choose_version_id", chooseVersionId);
        return this;
    }

    /**
    * 设置 [选择版本名称]
    */
    public ArticlePage setChooseVersionName(String chooseVersionName) {
        this.chooseVersionName = chooseVersionName;
        this.modify("choose_version_name", chooseVersionName);
        return this;
    }

    /**
    * 设置 [主题]
    */
    public ArticlePage setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [空间标识]
    */
    public ArticlePage setSpaceId(String spaceId) {
        this.spaceId = spaceId;
        this.modify("space_id", spaceId);
        return this;
    }

    /**
    * 设置 [父页面标识]
    */
    public ArticlePage setParentId(String parentId) {
        this.parentId = parentId;
        this.modify("parent_id", parentId);
        return this;
    }

    /**
    * 设置 [空间名称]
    */
    public ArticlePage setSpaceName(String spaceName) {
        this.spaceName = spaceName;
        this.modify("space_name", spaceName);
        return this;
    }


    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param includeEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T pasteTo(T targetEntity, boolean includeEmpty) {
        super.pasteTo(targetEntity, includeEmpty);
        if(targetEntity instanceof IEntity) {
            IEntity entity = ((IEntity) targetEntity);
            entity.reset("id");
        }
        return targetEntity;
    }

}