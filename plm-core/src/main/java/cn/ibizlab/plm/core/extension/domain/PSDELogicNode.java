/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@NONE}}.java.hbs
 */
package cn.ibizlab.plm.core.extension.domain;

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
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.extension.domain.PSDELogic;
import cn.ibizlab.plm.core.extension.domain.PSDEMSLogic;
import cn.ibizlab.plm.core.extension.domain.PSDELogicLink;

/**
 * 实体处理逻辑节点实体类[PSDELogicNode]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDELOGICNODE", description = "实体处理逻辑节点")
public class PSDELogicNode extends EntityBase implements Serializable
{
    /**
     * 工作项类型
     */
    @DEField(name = "work_item_type_id")
    @JSONField(name = "work_item_type_id")
    @JsonProperty("work_item_type_id")
    @ApiModelProperty(value = "work_item_type_id", notes = "工作项类型")
    private String workItemTypeId;

    /**
     * 工作项类型
     */
    @DEField(name = "work_item_type_name")
    @JSONField(name = "work_item_type_name")
    @JsonProperty("work_item_type_name")
    @ApiModelProperty(value = "work_item_type_name", notes = "工作项类型")
    private String workItemTypeName;

    /**
     * 标题
     */
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
     * 内容
     */
    @DEField(name = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    @ApiModelProperty(value = "content", notes = "内容")
    private String content;

    /**
     * 排序属性
     */
    @DEField(name = "ordervalue" , preType = DEPredefinedFieldType.ORDERVALUE)
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    @ApiModelProperty(value = "ordervalue", notes = "排序属性")
    private Integer orderValue;

    /**
     * 实体处理逻辑节点标识
     */
    @Id
    @DEField(name = "psdelogicnodeid" , isKeyField = true)
    @JSONField(name = "psdelogicnodeid")
    @JsonProperty("psdelogicnodeid")
    @ApiModelProperty(value = "psdelogicnodeid", notes = "实体处理逻辑节点标识")
    private String psdeLogicNodeId;

    /**
     * 逻辑处理名称
     */
    @DEField(name = "psdelogicnodename")
    @JSONField(name = "psdelogicnodename")
    @JsonProperty("psdelogicnodename")
    @ApiModelProperty(value = "psdelogicnodename", notes = "逻辑处理名称")
    private String psdeLogicNodeName;

    /**
     * 实体处理逻辑
     */
    @DEField(name = "psdelogicid")
    @JSONField(name = "psdelogicid")
    @JsonProperty("psdelogicid")
    @ApiModelProperty(value = "psdelogicid", notes = "实体处理逻辑")
    private String psdeLogicId;

    /**
     * 实体处理逻辑
     */
    @DEField(name = "psdelogicname")
    @JSONField(name = "psdelogicname")
    @JsonProperty("psdelogicname")
    @ApiModelProperty(value = "psdelogicname", notes = "实体处理逻辑")
    private String psdeLogicName;

    /**
     * 项目标识
     */
    @DEField(name = "project_id")
    @JSONField(name = "project_id")
    @JsonProperty("project_id")
    @ApiModelProperty(value = "project_id", notes = "项目标识")
    private String projectId;

    /**
     * 项目名称
     */
    @DEField(name = "project_name")
    @JSONField(name = "project_name")
    @JsonProperty("project_name")
    @ApiModelProperty(value = "project_name", notes = "项目名称")
    private String projectName;

    /**
     * 逻辑节点类型
     */
    @DEField(name = "logicnodetype" , dict = "DELogicNodeType3")
    @JSONField(name = "logicnodetype")
    @JsonProperty("logicnodetype")
    @ApiModelProperty(value = "logicnodetype", notes = "逻辑节点类型")
    private String logicNodeType;

    /**
     * 循环后续处理
     */
    @DEField(name = "paralleloutput" , dict = "YesNo")
    @JSONField(name = "paralleloutput")
    @JsonProperty("paralleloutput")
    @ApiModelProperty(value = "paralleloutput", notes = "循环后续处理")
    private Integer parallelOutput;

    /**
     * 代码名称
     */
    @DEField(name = "codename")
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码名称")
    private String codeName;

    /**
     * 参数8
     */
    @DEField(name = "param8")
    @JSONField(name = "param8")
    @JsonProperty("param8")
    @ApiModelProperty(value = "param8", notes = "参数8")
    private Integer param8;

    /**
     * 参数7
     */
    @DEField(name = "param7")
    @JSONField(name = "param7")
    @JsonProperty("param7")
    @ApiModelProperty(value = "param7", notes = "参数7")
    private Integer param7;

    /**
     * 参数9
     */
    @DEField(name = "param9" , dict = "YesNo")
    @JSONField(name = "param9")
    @JsonProperty("param9")
    @ApiModelProperty(value = "param9", notes = "参数9")
    private Integer param9;

    /**
     * 参数10
     */
    @DEField(name = "param10" , dict = "YesNo")
    @JSONField(name = "param10")
    @JsonProperty("param10")
    @ApiModelProperty(value = "param10", notes = "参数10")
    private Integer param10;

    /**
     * 参数1
     */
    @DEField(name = "param1")
    @JSONField(name = "param1")
    @JsonProperty("param1")
    @ApiModelProperty(value = "param1", notes = "参数1")
    private String param1;

    /**
     * 参数12
     */
    @DEField(name = "param12")
    @JSONField(name = "param12")
    @JsonProperty("param12")
    @ApiModelProperty(value = "param12", notes = "参数12")
    private String param12;

    /**
     * 参数11
     */
    @DEField(name = "param11")
    @JSONField(name = "param11")
    @JsonProperty("param11")
    @ApiModelProperty(value = "param11", notes = "参数11")
    private String param11;

    /**
     * 参数13
     */
    @DEField(name = "param13")
    @JSONField(name = "param13")
    @JsonProperty("param13")
    @ApiModelProperty(value = "param13", notes = "参数13")
    private String param13;

    /**
     * 项目引用
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "项目引用")
    private Project project;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "psdelogic", notes = "")
    private PSDELogic psdeLogic;

    /**
     * 主状态逻辑节点
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "psdemslogic", notes = "主状态逻辑节点")
    private PSDEMSLogic psdemslogic;

    /**
    * 设置 [工作项类型]
    */
    public PSDELogicNode setWorkItemTypeId(String workItemTypeId) {
        this.workItemTypeId = workItemTypeId;
        this.modify("work_item_type_id", workItemTypeId);
        return this;
    }

    /**
    * 设置 [工作项类型]
    */
    public PSDELogicNode setWorkItemTypeName(String workItemTypeName) {
        this.workItemTypeName = workItemTypeName;
        this.modify("work_item_type_name", workItemTypeName);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public PSDELogicNode setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [内容]
    */
    public PSDELogicNode setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
    * 设置 [逻辑处理名称]
    */
    public PSDELogicNode setPsdeLogicNodeName(String psdeLogicNodeName) {
        this.psdeLogicNodeName = psdeLogicNodeName;
        this.modify("psdelogicnodename", psdeLogicNodeName);
        return this;
    }

    /**
    * 设置 [实体处理逻辑]
    */
    public PSDELogicNode setPsdeLogicId(String psdeLogicId) {
        this.psdeLogicId = psdeLogicId;
        this.modify("psdelogicid", psdeLogicId);
        return this;
    }

    /**
    * 设置 [实体处理逻辑]
    */
    public PSDELogicNode setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
    * 设置 [项目标识]
    */
    public PSDELogicNode setProjectId(String projectId) {
        this.projectId = projectId;
        this.modify("project_id", projectId);
        return this;
    }

    /**
    * 设置 [项目名称]
    */
    public PSDELogicNode setProjectName(String projectName) {
        this.projectName = projectName;
        this.modify("project_name", projectName);
        return this;
    }

    /**
    * 设置 [逻辑节点类型]
    */
    public PSDELogicNode setLogicNodeType(String logicNodeType) {
        this.logicNodeType = logicNodeType;
        this.modify("logicnodetype", logicNodeType);
        return this;
    }

    /**
    * 设置 [循环后续处理]
    */
    public PSDELogicNode setParallelOutput(Integer parallelOutput) {
        this.parallelOutput = parallelOutput;
        this.modify("paralleloutput", parallelOutput);
        return this;
    }

    /**
    * 设置 [代码名称]
    */
    public PSDELogicNode setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [参数8]
    */
    public PSDELogicNode setParam8(Integer param8) {
        this.param8 = param8;
        this.modify("param8", param8);
        return this;
    }

    /**
    * 设置 [参数7]
    */
    public PSDELogicNode setParam7(Integer param7) {
        this.param7 = param7;
        this.modify("param7", param7);
        return this;
    }

    /**
    * 设置 [参数9]
    */
    public PSDELogicNode setParam9(Integer param9) {
        this.param9 = param9;
        this.modify("param9", param9);
        return this;
    }

    /**
    * 设置 [参数10]
    */
    public PSDELogicNode setParam10(Integer param10) {
        this.param10 = param10;
        this.modify("param10", param10);
        return this;
    }

    /**
    * 设置 [参数1]
    */
    public PSDELogicNode setParam1(String param1) {
        this.param1 = param1;
        this.modify("param1", param1);
        return this;
    }

    /**
    * 设置 [参数12]
    */
    public PSDELogicNode setParam12(String param12) {
        this.param12 = param12;
        this.modify("param12", param12);
        return this;
    }

    /**
    * 设置 [参数11]
    */
    public PSDELogicNode setParam11(String param11) {
        this.param11 = param11;
        this.modify("param11", param11);
        return this;
    }

    /**
    * 设置 [参数13]
    */
    public PSDELogicNode setParam13(String param13) {
        this.param13 = param13;
        this.modify("param13", param13);
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
            entity.reset("psdelogicnodeid");
        }
        return targetEntity;
    }

}