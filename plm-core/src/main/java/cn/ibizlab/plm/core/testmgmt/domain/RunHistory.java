/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

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
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.core.testmgmt.domain.Step;

/**
 * 执行结果实体类[RunHistory]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "RUN_HISTORY", resultMap = "RunHistoryResultMap")
@ApiModel(value = "RUN_HISTORY", description = "执行结果")
public class RunHistory extends EntityMP implements Serializable
{

    /**
    * 测试用例
    */
    @TableField(value = "case_id" , exist = false)
    @DEField(name = "case_id")
    @JSONField(name = "case_id")
    @JsonProperty("case_id")
    @ApiModelProperty(value = "case_id", notes = "测试用例")
    private String caseId;

    /**
    * 备注
    */
    @TableField(value = "remark")
    @DEField(name = "remark")
    @JSONField(name = "remark")
    @JsonProperty("remark")
    @ApiModelProperty(value = "remark", notes = "备注")
    private String remark;

    /**
    * 执行时间
    */
    @TableField(value = "executed_at")
    @DEField(name = "executed_at" , defaultValueType = DEFieldDefaultValueType.CURTIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "executed_at" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("executed_at")
    @ApiModelProperty(value = "executed_at", notes = "执行时间")
    private Date executedAt;

    /**
    * 执行结果
    */
    @TableField(value = "status")
    @DEField(name = "status" , dict = "run_status")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty(value = "status", notes = "执行结果")
    private String status;

    /**
    * 步骤
    */
    @TableField(value = "steps", jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR, typeHandler =cn.ibizlab.plm.core.testmgmt.domain.handlers.StepTypeHandler.class)
    @DEField(name = "steps")
    @JSONField(name = "steps")
    @JsonProperty("steps")
    @ApiModelProperty(value = "steps", notes = "步骤")
    private List<Step> steps;

    /**
    * 执行人标识
    */
    @TableField(value = "executor_id")
    @DEField(name = "executor_id")
    @JSONField(name = "executor_id")
    @JsonProperty("executor_id")
    @ApiModelProperty(value = "executor_id", notes = "执行人标识")
    private String executorId;

    /**
    * 执行人
    */
    @TableField(value = "executor_name")
    @DEField(name = "executor_name")
    @JSONField(name = "executor_name")
    @JsonProperty("executor_name")
    @ApiModelProperty(value = "executor_name", notes = "执行人")
    private String executorName;

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
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
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
    * 执行用例标识
    */
    @TableField(value = "run_id")
    @DEField(name = "run_id")
    @JSONField(name = "run_id")
    @JsonProperty("run_id")
    @ApiModelProperty(value = "run_id", notes = "执行用例标识")
    private String runId;

    /**
    * 标题
    */
    @TableField(value = "run_title" , exist = false)
    @DEField(name = "run_title")
    @JSONField(name = "run_title")
    @JsonProperty("run_title")
    @ApiModelProperty(value = "run_title", notes = "标题")
    private String runTitle;

    /**
    * 用例执行
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "run", notes = "用例执行")
    private Run run;

    /**
    * 设置 [测试用例]
    */
    public RunHistory setCaseId(String caseId) {
        this.caseId = caseId;
        this.modify("case_id", caseId);
        return this;
    }

    /**
    * 设置 [备注]
    */
    public RunHistory setRemark(String remark) {
        this.remark = remark;
        this.modify("remark", remark);
        return this;
    }

    /**
    * 设置 [执行时间]
    */
    public RunHistory setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
        this.modify("executed_at", executedAt);
        return this;
    }

    /**
    * 设置 [执行结果]
    */
    public RunHistory setStatus(String status) {
        this.status = status;
        this.modify("status", status);
        return this;
    }

    /**
    * 设置 [步骤]
    */
    public RunHistory setSteps(List<Step> steps) {
        this.steps = steps;
        this.modify("steps", steps);
        return this;
    }

    /**
    * 设置 [执行人标识]
    */
    public RunHistory setExecutorId(String executorId) {
        this.executorId = executorId;
        this.modify("executor_id", executorId);
        return this;
    }

    /**
    * 设置 [执行人]
    */
    public RunHistory setExecutorName(String executorName) {
        this.executorName = executorName;
        this.modify("executor_name", executorName);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public RunHistory setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [执行用例标识]
    */
    public RunHistory setRunId(String runId) {
        this.runId = runId;
        this.modify("run_id", runId);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public RunHistory setRunTitle(String runTitle) {
        this.runTitle = runTitle;
        this.modify("run_title", runTitle);
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