/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@MINHERIT}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

import java.util.*;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.domain.EntityBase;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import cn.ibizlab.plm.core.testmgmt.domain.Review;
import cn.ibizlab.plm.core.base.domain.Version;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.base.domain.Version;

/**
 * 评审内容实体类[ReviewContent]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "REVIEW_CONTENT", description = "评审内容")
public class ReviewContent extends EntityBase implements Serializable
{

    /**
     * 变更类型
     */
    @DEField(name = "change_type" , defaultValue = "0" , dict = "review_change_type")
    @JsonProperty("change_type")
    @JSONField(name = "change_type")
    @ApiModelProperty(value = "change_type", notes = "变更类型")
    private String changeType;

    /**
     * 关联主体标识
     */
    @DEField(name = "principal_id")
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "principal_id", notes = "关联主体标识")
    private String principalId;



    /**
     * 所属数据对象
     */
    @DEField(name = "owner_type")
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "owner_type", notes = "所属数据对象")
    private String ownerType;

    /**
     * 关联主体类型
     */
    @DEField(name = "principal_type" , defaultValue = "REVIEW")
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "principal_type", notes = "关联主体类型")
    private String principalType;



    /**
     * 关联目标类型
     */
    @DEField(name = "target_type" , defaultValue = "TEST_CASE")
    @JsonProperty("target_type")
    @JSONField(name = "target_type")
    @ApiModelProperty(value = "target_type", notes = "关联目标类型")
    private String targetType;

    /**
     * 关联目标标识
     */
    @DEField(name = "target_id")
    @JsonProperty("target_id")
    @JSONField(name = "target_id")
    @ApiModelProperty(value = "target_id", notes = "关联目标标识")
    private String targetId;

    /**
     * 目标对象版本标识
     */
    @DEField(name = "target_version_id")
    @JsonProperty("target_version_id")
    @JSONField(name = "target_version_id")
    @ApiModelProperty(value = "target_version_id", notes = "目标对象版本标识")
    private String targetVersionId;

    /**
     * 父对象版本标识
     */
    @DEField(name = "parent_version_id" , preType = DEPredefinedFieldType.PARENTVERSIONID)
    @JsonProperty("parent_version_id")
    @JSONField(name = "parent_version_id")
    @ApiModelProperty(value = "parent_version_id", notes = "父对象版本标识")
    private String parentVersionId;


    /**
     * 测试用例
     */
    @DEField(name = "test_case")
    @JsonProperty("test_case")
    @JSONField(name = "test_case")
    @ApiModelProperty(value = "test_case", notes = "测试用例")
    private TestCase testCase;

    /**
     * 当前版本标识
     */
    @DEField(name = "cur_version_id" , preType = DEPredefinedFieldType.VERSIONID)
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "cur_version_id", notes = "当前版本标识")
    private String curVersionId;

    /**
     * 目标对象编号
     */
    @DEField(name = "target_identifier")
    @JsonProperty("target_identifier")
    @JSONField(name = "target_identifier")
    @ApiModelProperty(value = "target_identifier", notes = "目标对象编号")
    private String targetIdentifier;

    /**
     * 目标对象标题
     */
    @DEField(name = "target_title")
    @JsonProperty("target_title")
    @JSONField(name = "target_title")
    @ApiModelProperty(value = "target_title", notes = "目标对象标题")
    private String targetTitle;

    /**
     * 目标对象状态
     */
    @DEField(name = "target_state")
    @JsonProperty("target_state")
    @JSONField(name = "target_state")
    @ApiModelProperty(value = "target_state", notes = "目标对象状态")
    private String targetState;

    /**
     * 目标对象负责人
     */
    @DEField(name = "target_assignee")
    @JsonProperty("target_assignee")
    @JSONField(name = "target_assignee")
    @ApiModelProperty(value = "target_assignee", notes = "目标对象负责人")
    private String targetAssignee;

    /**
     * 关联目标版本
     */
    @DEField(name = "target_version")
    @JsonProperty("target_version")
    @JSONField(name = "target_version")
    @ApiModelProperty(value = "target_version", notes = "关联目标版本")
    private Version targetVersion;

    /**
     * 目标对象优先级
     */
    @DEField(name = "target_priority")
    @JsonProperty("target_priority")
    @JSONField(name = "target_priority")
    @ApiModelProperty(value = "target_priority", notes = "目标对象优先级")
    private String targetPriority;

    /**
     * 目标对象父标识
     */
    @DEField(name = "target_parent_id")
    @JsonProperty("target_parent_id")
    @JSONField(name = "target_parent_id")
    @ApiModelProperty(value = "target_parent_id", notes = "目标对象父标识")
    private String targetParentId;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 评审
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(value = "review", notes = "评审-评审内容")
    private Review review;


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