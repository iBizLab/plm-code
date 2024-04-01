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
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.core.base.domain.Comment;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.projmgmt.domain.Version;
import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.base.domain.Attention;

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
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "identifier", notes = "编号")
    private String identifier;

    /**
     * 正文格式
     */
    @TableField(value = "format_type")
    @DEField(name = "format_type" , dict = "CodeList54")
    @JsonProperty("format_type")
    @JSONField(name = "format_type")
    @ApiModelProperty(value = "format_type", notes = "正文格式")
    private String formatType;

    /**
     * 序号
     */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , defaultValue = "1")
    @JsonProperty("sequence")
    @JSONField(name = "sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
     * 正文
     */
    @TableField(value = "content")
    @DEField(name = "content")
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "content", notes = "正文")
    private String content;

    /**
     * 类型
     */
    @TableField(value = "type")
    @DEField(name = "type" , dict = "Page_type")
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "type", notes = "类型")
    private String type;

    /**
     * 是否星标
     */
    @TableField(value = "is_favorite" , exist = false)
    @DEField(name = "is_favorite" , dict = "YesNo")
    @JsonProperty("is_favorite")
    @JSONField(name = "is_favorite")
    @ApiModelProperty(value = "is_favorite", notes = "是否星标")
    private String isFavorite;

    /**
     * 是否叶子节点
     */
    @TableField(value = "is_leaf")
    @DEField(name = "is_leaf" , defaultValue = "1" , dict = "YesNo")
    @JsonProperty("is_leaf")
    @JSONField(name = "is_leaf")
    @ApiModelProperty(value = "is_leaf", notes = "是否叶子节点")
    private Integer isLeaf;

    /**
     * 空间编号
     */
    @TableField(value = "space_identifier" , exist = false)
    @DEField(name = "space_identifier")
    @JsonProperty("space_identifier")
    @JSONField(name = "space_identifier")
    @ApiModelProperty(value = "space_identifier", notes = "空间编号")
    private String spaceIdentifier;

    /**
     * 附件
     */
    @TableField(exist = false)
    @DEField(name = "attachments")
    @JsonProperty("attachments")
    @JSONField(name = "attachments")
    @ApiModelProperty(value = "attachments", notes = "附件")
    private List<Attachment> attachments;

    /**
     * 是否已归档
     */
    @TableField(value = "is_archived")
    @DEField(name = "is_archived" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("is_archived")
    @JSONField(name = "is_archived")
    @ApiModelProperty(value = "is_archived", notes = "是否已归档")
    private Integer isArchived;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    @DEField(name = "is_deleted" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    @ApiModelProperty(value = "is_deleted", notes = "是否已删除")
    private Integer isDeleted;

    /**
     * 关注
     */
    @TableField(exist = false)
    @DEField(name = "attentions")
    @JsonProperty("attentions")
    @JSONField(name = "attentions")
    @ApiModelProperty(value = "attentions", notes = "关注")
    private List<Attention> attentions;

    /**
     * 当前版本标识
     */
    @TableField(value = "cur_version_id")
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
     * 当前版本名称
     */
    @TableField(value = "cur_version_name")
    @DEField(name = "cur_version_name" , preType = DEPredefinedFieldType.VERSION)
    @JsonProperty("cur_version_name")
    @JSONField(name = "cur_version_name")
    @ApiModelProperty(value = "cur_version_name", notes = "当前版本名称")
    private String curVersionName;

    /**
     * 编号
     */
    @TableField(value = "show_identifier" , exist = false)
    @DEField(name = "show_identifier")
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "show_identifier", notes = "编号")
    private String showIdentifier;

    /**
     * 标识
     */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 建立时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 主题
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "主题")
    private String name;

    /**
     * 建立人
     */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 空间标识
     */
    @TableField(value = "space_id")
    @DEField(name = "space_id")
    @JsonProperty("space_id")
    @JSONField(name = "space_id")
    @ApiModelProperty(value = "space_id", notes = "空间标识")
    private String spaceId;

    /**
     * 父页面标识
     */
    @TableField(value = "parent_id")
    @DEField(name = "parent_id")
    @JsonProperty("parent_id")
    @JSONField(name = "parent_id")
    @ApiModelProperty(value = "parent_id", notes = "父页面标识")
    private String parentId;

    /**
     * 空间名称
     */
    @TableField(value = "space_name" , exist = false)
    @DEField(name = "space_name")
    @JsonProperty("space_name")
    @JSONField(name = "space_name")
    @ApiModelProperty(value = "space_name", notes = "空间名称")
    private String spaceName;

    /**
     * 页面
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "page", notes = "嵌套页面")
    private ArticlePage page;

    /**
     * 空间
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
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
     * 设置 [编号]
     */
    public ArticlePage setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
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