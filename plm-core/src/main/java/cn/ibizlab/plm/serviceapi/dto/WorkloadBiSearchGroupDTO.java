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
 * 工时[WorkloadBiSearchGroupDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("工时DTO")
public class WorkloadBiSearchGroupDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 0)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 1)
    private Date updateTime;

    /**
     * 工作日期
     */
    @JsonProperty("register_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "register_date" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "工作日期", position = 2)
    private Date registerDate;

    /**
     * 编号
     */
    @JsonProperty("identifier")
    @JSONField(name = "identifier")
    @ApiModelProperty(value = "编号", position = 3)
    private String identifier;

    /**
     * 工时主体类型
     */
    @JsonProperty("principal_type")
    @JSONField(name = "principal_type")
    @ApiModelProperty(value = "工时主体类型", position = 4)
    private String principalType;

    /**
     * 所属数据对象
     */
    @JsonProperty("owner_type")
    @JSONField(name = "owner_type")
    @ApiModelProperty(value = "所属数据对象", position = 5)
    private String ownerType;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 6)
    private String updateMan;

    /**
     * 事项
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "事项", position = 7)
    private String name;

    /**
     * 工时主体标识
     */
    @JsonProperty("principal_id")
    @JSONField(name = "principal_id")
    @ApiModelProperty(value = "工时主体标识", position = 8)
    private String principalId;

    /**
     * 编号
     */
    @JsonProperty("show_identifier")
    @JSONField(name = "show_identifier")
    @ApiModelProperty(value = "编号", position = 9)
    private String showIdentifier;

    /**
     * 访问父类
     */
    @JsonProperty("recent_parent")
    @JSONField(name = "recent_parent")
    @ApiModelProperty(value = "访问父类", position = 10)
    private String recentParent;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 11)
    private String createMan;

    /**
     * 时长
     */
    @JsonProperty("duration")
    @JSONField(name = "duration")
    @ApiModelProperty(value = "时长", position = 12)
    private BigDecimal duration;

    /**
     * 名称
     */
    @JsonProperty("type_name")
    @JSONField(name = "type_name")
    @ApiModelProperty(value = "名称", position = 13)
    private String typeName;

    /**
     * 工作项
     */
    @JsonProperty("work_item")
    @JSONField(name = "work_item")
    @ApiModelProperty(value = "工作项", position = 14)
    private WorkItemDTO workItem;

    /**
     * 用例
     */
    @JsonProperty("test_case")
    @JSONField(name = "test_case")
    @ApiModelProperty(value = "用例", position = 15)
    private TestCaseDTO testCase;

    /**
     * 需求
     */
    @JsonProperty("idea")
    @JSONField(name = "idea")
    @ApiModelProperty(value = "需求", position = 16)
    private IdeaDTO idea;

    /**
     * 类别
     */
    @JsonProperty("type_id")
    @JSONField(name = "type_id")
    @ApiModelProperty(value = "类别", position = 17)
    private String typeId;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 18)
    private String id;


    /**
     * 设置 [工作日期]
     */
    public WorkloadBiSearchGroupDTO setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
        this.modify("register_date", registerDate);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public WorkloadBiSearchGroupDTO setIdentifier(String identifier) {
        this.identifier = identifier;
        this.modify("identifier", identifier);
        return this;
    }

    /**
     * 设置 [工时主体类型]
     */
    public WorkloadBiSearchGroupDTO setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
     * 设置 [所属数据对象]
     */
    public WorkloadBiSearchGroupDTO setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("owner_type", ownerType);
        return this;
    }

    /**
     * 设置 [事项]
     */
    public WorkloadBiSearchGroupDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [编号]
     */
    public WorkloadBiSearchGroupDTO setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
        this.modify("show_identifier", showIdentifier);
        return this;
    }

    /**
     * 设置 [访问父类]
     */
    public WorkloadBiSearchGroupDTO setRecentParent(String recentParent) {
        this.recentParent = recentParent;
        this.modify("recent_parent", recentParent);
        return this;
    }

    /**
     * 设置 [时长]
     */
    public WorkloadBiSearchGroupDTO setDuration(BigDecimal duration) {
        this.duration = duration;
        this.modify("duration", duration);
        return this;
    }

    /**
     * 设置 [名称]
     */
    public WorkloadBiSearchGroupDTO setTypeName(String typeName) {
        this.typeName = typeName;
        this.modify("type_name", typeName);
        return this;
    }

    /**
     * 设置 [工作项]
     */
    public WorkloadBiSearchGroupDTO setWorkItem(WorkItemDTO workItem) {
        this.workItem = workItem;
        this.modify("work_item", workItem);
        return this;
    }

    /**
     * 设置 [用例]
     */
    public WorkloadBiSearchGroupDTO setTestCase(TestCaseDTO testCase) {
        this.testCase = testCase;
        this.modify("test_case", testCase);
        return this;
    }

    /**
     * 设置 [需求]
     */
    public WorkloadBiSearchGroupDTO setIdea(IdeaDTO idea) {
        this.idea = idea;
        this.modify("idea", idea);
        return this;
    }

    /**
     * 设置 [类别]
     */
    public WorkloadBiSearchGroupDTO setTypeId(String typeId) {
        this.typeId = typeId;
        this.modify("type_id", typeId);
        return this;
    }


}
