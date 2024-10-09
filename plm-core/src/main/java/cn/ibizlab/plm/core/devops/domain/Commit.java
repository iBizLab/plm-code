/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.devops.domain;

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
import cn.ibizlab.plm.core.devops.domain.BranchRefCommit;

/**
 * 代码提交实体类[Commit]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "scm_commit", resultMap = "CommitResultMap")
@ApiModel(value = "COMMIT", description = "代码提交")
public class Commit extends EntityMP implements Serializable
{

    /**
    * SHA值
    */
    @Id
    @TableId(value = "sha" , type = IdType.ASSIGN_UUID)
    @DEField(name = "sha" , isKeyField = true)
    @JSONField(name = "sha")
    @JsonProperty("sha")
    @ApiModelProperty(value = "sha", notes = "SHA值")
    private String sha;

    /**
    * 提交消息
    */
    @TableField(value = "message")
    @DEField(name = "message")
    @JSONField(name = "message")
    @JsonProperty("message")
    @ApiModelProperty(value = "message", notes = "提交消息")
    private String message;

    /**
    * 设置 [提交消息]
    */
    public Commit setMessage(String message) {
        this.message = message;
        this.modify("message", message);
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
            entity.reset("sha");
        }
        return targetEntity;
    }

}