/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@NONE}}.java.hbs
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

/**
 * 实体数据流逻辑实体类[PSDEDataflow]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSDEDATAFLOW", description = "实体数据流逻辑")
public class PSDEDataflow extends EntityBase implements Serializable
{
    /**
     * 实体处理逻辑标识
     */
    @Id
    @DEField(name = "psdelogicid" , isKeyField = true)
    @JSONField(name = "psdelogicid")
    @JsonProperty("psdelogicid")
    @ApiModelProperty(value = "psdelogicid", notes = "实体处理逻辑标识")
    private String psdeLogicId;

    /**
     * 实体处理逻辑名称
     */
    @DEField(name = "psdelogicname")
    @JSONField(name = "psdelogicname")
    @JsonProperty("psdelogicname")
    @ApiModelProperty(value = "psdelogicname", notes = "实体处理逻辑名称")
    private String psdeLogicName;

    /**
     * 建立人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "建立人")
    private String createMan;

    /**
     * 建立时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "建立时间")
    private Date createDate;

    /**
     * 更新人
     */
    @DEField(name = "updateman" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty(value = "updateman", notes = "更新人")
    private String updateMan;

    /**
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 实体
     */
    @DEField(name = "psdeid")
    @JSONField(name = "psdeid")
    @JsonProperty("psdeid")
    @ApiModelProperty(value = "psdeid", notes = "实体")
    private String psdeid;

    /**
     * 实体
     */
    @DEField(name = "psdename")
    @JSONField(name = "psdename")
    @JsonProperty("psdename")
    @ApiModelProperty(value = "psdename", notes = "实体")
    private String psdeName;

    /**
     * 代码标识
     */
    @DEField(name = "codename")
    @JSONField(name = "codename")
    @JsonProperty("codename")
    @ApiModelProperty(value = "codename", notes = "代码标识")
    private String codeName;

    /**
     * 扩展标记
     */
    @DEField(name = "extension_tag")
    @JSONField(name = "extension_tag")
    @JsonProperty("extension_tag")
    @ApiModelProperty(value = "extension_tag", notes = "扩展标记")
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @DEField(name = "extension_tag2")
    @JSONField(name = "extension_tag2")
    @JsonProperty("extension_tag2")
    @ApiModelProperty(value = "extension_tag2", notes = "扩展标记2")
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @DEField(name = "extension_tag3")
    @JSONField(name = "extension_tag3")
    @JsonProperty("extension_tag3")
    @ApiModelProperty(value = "extension_tag3", notes = "扩展标记3")
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @DEField(name = "extension_tag4")
    @JSONField(name = "extension_tag4")
    @JsonProperty("extension_tag4")
    @ApiModelProperty(value = "extension_tag4", notes = "扩展标记4")
    private String extensionTag4;

    /**
    * 设置 [实体处理逻辑名称]
    */
    public PSDEDataflow setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDEDataflow setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
    * 设置 [实体]
    */
    public PSDEDataflow setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
    * 设置 [代码标识]
    */
    public PSDEDataflow setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
    * 设置 [扩展标记]
    */
    public PSDEDataflow setExtensionTag(String extensionTag) {
        this.extensionTag = extensionTag;
        this.modify("extension_tag", extensionTag);
        return this;
    }

    /**
    * 设置 [扩展标记2]
    */
    public PSDEDataflow setExtensionTag2(String extensionTag2) {
        this.extensionTag2 = extensionTag2;
        this.modify("extension_tag2", extensionTag2);
        return this;
    }

    /**
    * 设置 [扩展标记3]
    */
    public PSDEDataflow setExtensionTag3(String extensionTag3) {
        this.extensionTag3 = extensionTag3;
        this.modify("extension_tag3", extensionTag3);
        return this;
    }

    /**
    * 设置 [扩展标记4]
    */
    public PSDEDataflow setExtensionTag4(String extensionTag4) {
        this.extensionTag4 = extensionTag4;
        this.modify("extension_tag4", extensionTag4);
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
            entity.reset("psdelogicid");
        }
        return targetEntity;
    }

}