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
 * 基线页面[BaselinePageDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("基线页面DTO")
public class BaselinePageDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联主体标识
     */
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "关联主体标识", position = 0)
    private String principalId;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 1)
    private String ownerType;

    /**
     * 关联主体类型
     */
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "关联主体类型", position = 2)
    private String principalType;

    /**
     * 关联目标类型
     */
    @JsonProperty("target_type")
    @JSONField(name = "target_type")
    @ApiModelProperty(value = "关联目标类型", position = 3)
    private String targetType;

    /**
     * 关联目标标识
     */
    @JsonProperty("target_id")
    @JSONField(name = "target_id")
    @ApiModelProperty(value = "关联目标标识", position = 4)
    private String targetId;

    /**
     * 目标对象版本标识
     */
    @JsonProperty("target_version_id")
    @JSONField(name = "target_version_id")
    @ApiModelProperty(value = "目标对象版本标识", position = 5)
    private String targetVersionId;

    /**
     * 页面类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    @ApiModelProperty(value = "页面类型", position = 6)
    private String type;

    /**
     * 关联目标版本
     */
    @JsonProperty("target_version")
    @JSONField(name = "target_version")
    @ApiModelProperty(value = "关联目标版本", position = 7)
    private VersionDTO targetVersion;

    /**
     * 基线
     */
    @JsonProperty("baseline")
    @JSONField(name = "baseline")
    @ApiModelProperty(value = "基线", position = 8)
    private BaselineDTO baseline;

    /**
     * 空间标识
     */
    @JsonProperty("space_id")
    @JSONField(name = "space_id")
    @ApiModelProperty(value = "空间标识", position = 9)
    private String spaceId;

    /**
     * 当前版本标识
     */
    @JsonProperty("cur_version_id")
    @JSONField(name = "cur_version_id")
    @ApiModelProperty(value = "当前版本标识", position = 10)
    private String curVersionId;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 11)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 12)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 13)
    private String id;

    /**
     * 名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "名称", position = 14)
    private String name;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 15)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 16)
    private Date updateTime;


    /**
     * 设置 [关联主体标识]
     */
    public BaselinePageDTO setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
     * 设置 [所属数据对象]
     */
    public BaselinePageDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [关联主体类型]
     */
    public BaselinePageDTO setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
     * 设置 [关联目标类型]
     */
    public BaselinePageDTO setTargetType(String targetType) {
        this.targetType = targetType;
        this.modify("target_type", targetType);
        return this;
    }

    /**
     * 设置 [关联目标标识]
     */
    public BaselinePageDTO setTargetId(String targetId) {
        this.targetId = targetId;
        this.modify("target_id", targetId);
        return this;
    }

    /**
     * 设置 [目标对象版本标识]
     */
    public BaselinePageDTO setTargetVersionId(String targetVersionId) {
        this.targetVersionId = targetVersionId;
        this.modify("target_version_id", targetVersionId);
        return this;
    }

    /**
     * 设置 [页面类型]
     */
    public BaselinePageDTO setType(String type) {
        this.type = type;
        this.modify("type", type);
        return this;
    }

    /**
     * 设置 [关联目标版本]
     */
    public BaselinePageDTO setTargetVersion(VersionDTO targetVersion) {
        this.targetVersion = targetVersion;
        this.modify("target_version", targetVersion);
        return this;
    }

    /**
     * 设置 [基线]
     */
    public BaselinePageDTO setBaseline(BaselineDTO baseline) {
        this.baseline = baseline;
        this.modify("baseline", baseline);
        return this;
    }

    /**
     * 设置 [空间标识]
     */
    public BaselinePageDTO setSpaceId(String spaceId) {
        this.spaceId = spaceId;
        this.modify("space_id", spaceId);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public BaselinePageDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }


}
