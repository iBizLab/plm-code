/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.base.domain;

import java.util.*;
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
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.prodmgmt.domain.Customer;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;

/**
 * 评论实体类[Comment]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "COMMENT", resultMap = "CommentResultMap")
@ApiModel(value = "COMMENT", description = "评论")
public class Comment extends EntityMP implements Serializable
{

    /**
     * 评论主体标识
     */
    @TableField(value = "principal_id")
    @DEField(name = "principal_id" , preType = DEPredefinedFieldType.PARENTID)
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "principal_id", notes = "评论主体标识")
    private String principalId;

    /**
     * 评论主体名称
     */
    @TableField(value = "principal_name")
    @DEField(name = "principal_name" , preType = DEPredefinedFieldType.PARENTNAME)
    @JsonProperty("principal_name")
    @JSONField(name = "principal_name")
    @ApiModelProperty(value = "principal_name", notes = "评论主体名称")
    private String principalName;

    /**
     * 所属数据对象
     */
    @TableField(value = "owner_type")
    @DEField(name = "owner_type" , preType = DEPredefinedFieldType.PARENTTYPE)
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 评论主体类型
     */
    @TableField(value = "principal_type")
    @DEField(name = "principal_type" , preType = DEPredefinedFieldType.PARENTSUBTYPE , dict = "principal_type")
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "principal_type", notes = "评论主体类型")
    private String principalType;

    /**
     * 内容
     */
    @TableField(value = "content")
    @DEField(name = "content")
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "content", notes = "内容")
    private String content;

    /**
     * 父内容
     */
    @TableField(value = "pcontent" , exist = false)
    @DEField(name = "pcontent")
    @JsonProperty("pcontent")
    @JSONField(name = "pcontent")
    @ApiModelProperty(value = "pcontent", notes = "父内容")
    private String pcontent;

    /**
     * 父建立人
     */
    @TableField(value = "pcreate_man" , exist = false)
    @DEField(name = "pcreate_man" , dict = "SysOperator")
    @JsonProperty("pcreate_man")
    @JSONField(name = "pcreate_man")
    @ApiModelProperty(value = "pcreate_man", notes = "父建立人")
    private String pcreateMan;

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
     * 名称
     */
    @TableField(value = "name")
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
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
     * 更新人
     */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 父标识
     */
    @TableField(value = "pid")
    @DEField(name = "pid")
    @JsonProperty("pid")
    @JSONField(name = "pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
     * 评论
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "comment", notes = "父评论")
    private Comment comment;

    /**
     * 页面
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "page", notes = "页面-评论")
    private ArticlePage page;

    /**
     * 执行用例
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "run", notes = "执行用例-评论")
    private Run run;

    /**
     * 客户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "customer", notes = "客户-评论")
    private Customer customer;

    /**
     * 需求
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "idea", notes = "需求-评论")
    private Idea idea;

    /**
     * 用例
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "test_case", notes = "测试用例-评论")
    private TestCase testCase;

    /**
     * 工单
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "ticket", notes = "工单-评论")
    private Ticket ticket;

    /**
     * 工作项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    @ApiModelProperty(value = "work_item", notes = "工作项-评论")
    private WorkItem workItem;

    /**
     * 设置 [内容]
     */
    public Comment setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [父内容]
     */
    public Comment setPcontent(String pcontent) {
        this.pcontent = pcontent;
        this.modify("pcontent", pcontent);
        return this;
    }

    /**
     * 设置 [父建立人]
     */
    public Comment setPcreateMan(String pcreateMan) {
        this.pcreateMan = pcreateMan;
        this.modify("pcreate_man", pcreateMan);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public Comment setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [父标识]
     */
    public Comment setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
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