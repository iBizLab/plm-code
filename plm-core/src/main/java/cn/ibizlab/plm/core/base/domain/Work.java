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
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.core.projmgmt.domain.Project;

/**
 * 工作实体类[Work]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "WORK", resultMap = "WorkResultMap")
@ApiModel(value = "WORK", description = "工作")
public class Work extends EntityMP implements Serializable
{

    /**
    * 关联主体标识
    */
    @TableField(value = "principal_id")
    @DEField(name = "principal_id")
    @JSONField(name = "principal_id")
    @JsonProperty("principal_id")
    @ApiModelProperty(value = "principal_id", notes = "关联主体标识")
    private String principalId;

    /**
    * 关联主体标识
    */
    @TableField(value = "pilot_id")
    @DEField(name = "pilot_id")
    @JSONField(name = "pilot_id")
    @JsonProperty("pilot_id")
    @ApiModelProperty(value = "pilot_id", notes = "关联主体标识")
    private String pilotId;

    /**
    * 关联主体类型
    */
    @TableField(value = "principal_type")
    @DEField(name = "principal_type")
    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    @ApiModelProperty(value = "principal_type", notes = "关联主体类型")
    private String principalType;

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
    * 文件夹标识
    */
    @TableField(value = "portfolio_id")
    @DEField(name = "portfolio_id")
    @JSONField(name = "portfolio_id")
    @JsonProperty("portfolio_id")
    @ApiModelProperty(value = "portfolio_id", notes = "文件夹标识")
    private String portfolioId;

    /**
    * 文件夹-工作
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "portfolio", notes = "文件夹-工作")
    private Portfolio portfolio;

    /**
    * 项目
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "project", notes = "项目")
    private Project project;

    /**
    * 设置 [关联主体标识]
    */
    public Work setPrincipalId(String principalId) {
        this.principalId = principalId;
        this.modify("principal_id", principalId);
        return this;
    }

    /**
    * 设置 [关联主体标识]
    */
    public Work setPilotId(String pilotId) {
        this.pilotId = pilotId;
        this.modify("pilot_id", pilotId);
        return this;
    }

    /**
    * 设置 [关联主体类型]
    */
    public Work setPrincipalType(String principalType) {
        this.principalType = principalType;
        this.modify("principal_type", principalType);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public Work setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [文件夹标识]
    */
    public Work setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
        this.modify("portfolio_id", portfolioId);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getPortfolioId(),"未设置文件夹标识");
        //Assert.notNull(getPrincipalId(),"未设置关联主体标识");
        String key = String.format("%s||%s"
            ,getPortfolioId(),getPrincipalId());
        key = DigestUtils.md5DigestAsHex(key.getBytes());
        return key;
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