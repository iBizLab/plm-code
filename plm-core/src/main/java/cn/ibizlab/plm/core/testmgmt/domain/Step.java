/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
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
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.domain.RunHistory;

/**
 * 用例步骤实体类[Step]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "STEP", description = "用例步骤")
public class Step extends EntityBase implements Serializable
{
    /**
     * 步骤描述
     */
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "步骤描述")
    private String description;

    /**
     * 预期结果
     */
    @DEField(name = "expected_value")
    @JSONField(name = "expected_value")
    @JsonProperty("expected_value")
    @ApiModelProperty(value = "expected_value", notes = "预期结果")
    private String expectedValue;

    /**
     * 分组标识
     */
    @DEField(name = "group_id")
    @JSONField(name = "group_id")
    @JsonProperty("group_id")
    @ApiModelProperty(value = "group_id", notes = "分组标识")
    private String groupId;

    /**
     * 实际
     */
    @DEField(name = "actual_value")
    @JSONField(name = "actual_value")
    @JsonProperty("actual_value")
    @ApiModelProperty(value = "actual_value", notes = "实际")
    private String actualValue;

    /**
     * 是否分组
     */
    @DEField(name = "is_group" , dict = "YesNo")
    @JSONField(name = "is_group")
    @JsonProperty("is_group")
    @ApiModelProperty(value = "is_group", notes = "是否分组")
    private Integer isGroup;

    /**
     * 执行结果
     */
    @DEField(name = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty(value = "status", notes = "执行结果")
    private String status;

    /**
     * 标识
     */
    @Id
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
     * 建立人
     */
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
     * 更新人
     */
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
     * 用例标识
     */
    @DEField(name = "case_id")
    @JSONField(name = "case_id")
    @JsonProperty("case_id")
    @ApiModelProperty(value = "case_id", notes = "用例标识")
    private String caseId;

    /**
     * 执行用例标识
     */
    @DEField(name = "run_id")
    @JSONField(name = "run_id")
    @JsonProperty("run_id")
    @ApiModelProperty(value = "run_id", notes = "执行用例标识")
    private String runId;

    /**
     * 用例模板标识
     */
    @DEField(name = "case_template_id")
    @JSONField(name = "case_template_id")
    @JsonProperty("case_template_id")
    @ApiModelProperty(value = "case_template_id", notes = "用例模板标识")
    private String caseTemplateId;

    /**
     * 执行用例-步骤
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "run", notes = "执行用例-步骤")
    private Run run;

    /**
     * 用例-步骤
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "test_case", notes = "用例-步骤")
    private TestCase testCase;

    /**
     * 用例模板-步骤
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "test_case_template", notes = "用例模板-步骤")
    private TestCaseTemplate testCaseTemplate;

    /**
     * 名称
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "run_history_re_step", notes = "名称")
    private RunHistory runHistoryReStep;

    /**
    * 设置 [步骤描述]
    */
    public Step setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [预期结果]
    */
    public Step setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
        this.modify("expected_value", expectedValue);
        return this;
    }

    /**
    * 设置 [分组标识]
    */
    public Step setGroupId(String groupId) {
        this.groupId = groupId;
        this.modify("group_id", groupId);
        return this;
    }

    /**
    * 设置 [实际]
    */
    public Step setActualValue(String actualValue) {
        this.actualValue = actualValue;
        this.modify("actual_value", actualValue);
        return this;
    }

    /**
    * 设置 [是否分组]
    */
    public Step setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
        this.modify("is_group", isGroup);
        return this;
    }

    /**
    * 设置 [执行结果]
    */
    public Step setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Step setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [用例标识]
    */
    public Step setCaseId(String caseId) {
        this.caseId = caseId;
        this.modify("case_id", caseId);
        return this;
    }

    /**
    * 设置 [执行用例标识]
    */
    public Step setRunId(String runId) {
        this.runId = runId;
        this.modify("run_id", runId);
        return this;
    }

    /**
    * 设置 [用例模板标识]
    */
    public Step setCaseTemplateId(String caseTemplateId) {
        this.caseTemplateId = caseTemplateId;
        this.modify("case_template_id", caseTemplateId);
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