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
 * 实体处理逻辑节点[PSDELogicNodeDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体处理逻辑节点DTO")
public class PSDELogicNodeDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工作项类型
     */
    @JsonProperty("work_item_type_id")
    @JSONField(name = "work_item_type_id")
    @ApiModelProperty(value = "工作项类型", position = 0)
    private String workItemTypeId;

    /**
     * 工作项类型
     */
    @JsonProperty("work_item_type_name")
    @JSONField(name = "work_item_type_name")
    @ApiModelProperty(value = "工作项类型", position = 1)
    private String workItemTypeName;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 2)
    private String title;

    /**
     * 内容
     */
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "内容", position = 3)
    private String content;

    /**
     * 排序属性
     */
    @JsonProperty("ordervalue")
    @JSONField(name = "ordervalue")
    @ApiModelProperty(value = "排序属性", position = 4)
    private Integer orderValue;

    /**
     * 代码名称
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码名称", position = 5)
    private String codeName;

    /**
     * 逻辑节点类型
     */
    @JsonProperty("logicnodetype")
    @JSONField(name = "logicnodetype")
    @ApiModelProperty(value = "逻辑节点类型", position = 6)
    private String logicNodeType;

    /**
     * 实体处理逻辑
     */
    @JsonProperty("psdelogicid")
    @JSONField(name = "psdelogicid")
    @ApiModelProperty(value = "实体处理逻辑", position = 7)
    private String psdeLogicId;

    /**
     * 实体处理逻辑
     */
    @JsonProperty("psdelogicname")
    @JSONField(name = "psdelogicname")
    @ApiModelProperty(value = "实体处理逻辑", position = 8)
    private String psdeLogicName;

    /**
     * 实体处理逻辑节点标识
     */
    @JsonProperty("psdelogicnodeid")
    @JSONField(name = "psdelogicnodeid")
    @ApiModelProperty(value = "实体处理逻辑节点标识", position = 9)
    private String psdeLogicNodeId;

    /**
     * 逻辑处理名称
     */
    @JsonProperty("psdelogicnodename")
    @JSONField(name = "psdelogicnodename")
    @ApiModelProperty(value = "逻辑处理名称", position = 10)
    private String psdeLogicNodeName;

    /**
     * 循环后续处理
     */
    @JsonProperty("paralleloutput")
    @JSONField(name = "paralleloutput")
    @ApiModelProperty(value = "循环后续处理", position = 11)
    private Integer parallelOutput;

    /**
     * 参数1
     */
    @JsonProperty("param1")
    @JSONField(name = "param1")
    @ApiModelProperty(value = "参数1", position = 12)
    private String param1;

    /**
     * 参数10
     */
    @JsonProperty("param10")
    @JSONField(name = "param10")
    @ApiModelProperty(value = "参数10", position = 13)
    private Integer param10;

    /**
     * 参数11
     */
    @JsonProperty("param11")
    @JSONField(name = "param11")
    @ApiModelProperty(value = "参数11", position = 14)
    private String param11;

    /**
     * 参数12
     */
    @JsonProperty("param12")
    @JSONField(name = "param12")
    @ApiModelProperty(value = "参数12", position = 15)
    private String param12;

    /**
     * 参数13
     */
    @JsonProperty("param13")
    @JSONField(name = "param13")
    @ApiModelProperty(value = "参数13", position = 16)
    private String param13;

    /**
     * 参数7
     */
    @JsonProperty("param7")
    @JSONField(name = "param7")
    @ApiModelProperty(value = "参数7", position = 17)
    private Integer param7;

    /**
     * 参数8
     */
    @JsonProperty("param8")
    @JSONField(name = "param8")
    @ApiModelProperty(value = "参数8", position = 18)
    private Integer param8;

    /**
     * 参数9
     */
    @JsonProperty("param9")
    @JSONField(name = "param9")
    @ApiModelProperty(value = "参数9", position = 19)
    private Integer param9;

    /**
     * 项目标识
     */
    @JsonProperty("project_id")
    @JSONField(name = "project_id")
    @ApiModelProperty(value = "项目标识", position = 20)
    private String projectId;

    /**
     * 项目名称
     */
    @JsonProperty("project_name")
    @JSONField(name = "project_name")
    @ApiModelProperty(value = "项目名称", position = 21)
    private String projectName;


    /**
     * 设置 [工作项类型]
     */
    public PSDELogicNodeDTO setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
        return this;
    }

    /**
     * 设置 [工作项类型]
     */
    public PSDELogicNodeDTO setWorkItemTypeName(String workItemTypeName) {
        this.workItemTypeName = workItemTypeName;
        this.modify("work_item_type_name", workItemTypeName);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public PSDELogicNodeDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [内容]
     */
    public PSDELogicNodeDTO setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [代码名称]
     */
    public PSDELogicNodeDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [逻辑节点类型]
     */
    public PSDELogicNodeDTO setLogicNodeType(String logicNodeType) {
        this.logicNodeType = logicNodeType;
        this.modify("logicnodetype", logicNodeType);
        return this;
    }

    /**
     * 设置 [实体处理逻辑]
     */
    public PSDELogicNodeDTO setPsdeLogicId(String psdeLogicId) {
        this.psdeLogicId = psdeLogicId;
        this.modify("psdelogicid", psdeLogicId);
        return this;
    }

    /**
     * 设置 [实体处理逻辑]
     */
    public PSDELogicNodeDTO setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
     * 设置 [逻辑处理名称]
     */
    public PSDELogicNodeDTO setPsdeLogicNodeName(String psdeLogicNodeName) {
        this.psdeLogicNodeName = psdeLogicNodeName;
        this.modify("psdelogicnodename", psdeLogicNodeName);
        return this;
    }

    /**
     * 设置 [循环后续处理]
     */
    public PSDELogicNodeDTO setParallelOutput(Integer parallelOutput) {
        this.parallelOutput = parallelOutput;
        this.modify("paralleloutput", parallelOutput);
        return this;
    }

    /**
     * 设置 [参数1]
     */
    public PSDELogicNodeDTO setParam1(String param1) {
        this.param1 = param1;
        this.modify("param1", param1);
        return this;
    }

    /**
     * 设置 [参数10]
     */
    public PSDELogicNodeDTO setParam10(Integer param10) {
        this.param10 = param10;
        this.modify("param10", param10);
        return this;
    }

    /**
     * 设置 [参数11]
     */
    public PSDELogicNodeDTO setParam11(String param11) {
        this.param11 = param11;
        this.modify("param11", param11);
        return this;
    }

    /**
     * 设置 [参数12]
     */
    public PSDELogicNodeDTO setParam12(String param12) {
        this.param12 = param12;
        this.modify("param12", param12);
        return this;
    }

    /**
     * 设置 [参数13]
     */
    public PSDELogicNodeDTO setParam13(String param13) {
        this.param13 = param13;
        this.modify("param13", param13);
        return this;
    }

    /**
     * 设置 [参数7]
     */
    public PSDELogicNodeDTO setParam7(Integer param7) {
        this.param7 = param7;
        this.modify("param7", param7);
        return this;
    }

    /**
     * 设置 [参数8]
     */
    public PSDELogicNodeDTO setParam8(Integer param8) {
        this.param8 = param8;
        this.modify("param8", param8);
        return this;
    }

    /**
     * 设置 [参数9]
     */
    public PSDELogicNodeDTO setParam9(Integer param9) {
        this.param9 = param9;
        this.modify("param9", param9);
        return this;
    }

    /**
     * 设置 [项目标识]
     */
    public PSDELogicNodeDTO setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
     * 设置 [项目名称]
     */
    public PSDELogicNodeDTO setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }


}
