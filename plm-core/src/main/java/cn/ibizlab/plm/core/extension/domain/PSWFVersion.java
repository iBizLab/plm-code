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
 * 工作流版本实体类[PSWFVersion]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "PSWFVERSION", description = "工作流版本")
public class PSWFVersion extends EntityBase implements Serializable
{
    /**
     * 工作流版本标识
     */
    @Id
    @DEField(name = "pswfversionid" , isKeyField = true)
    @JSONField(name = "pswfversionid")
    @JsonProperty("pswfversionid")
    @ApiModelProperty(value = "pswfversionid", notes = "工作流版本标识")
    private String pswfVersionId;

    /**
     * 工作流版本名称
     */
    @DEField(name = "pswfversionname")
    @JSONField(name = "pswfversionname")
    @JsonProperty("pswfversionname")
    @ApiModelProperty(value = "pswfversionname", notes = "工作流版本名称")
    private String pswfVersionName;

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
     * 工作流
     */
    @DEField(name = "pswfid")
    @JSONField(name = "pswfid")
    @JsonProperty("pswfid")
    @ApiModelProperty(value = "pswfid", notes = "工作流")
    private String pswfid;

    /**
     * 工作流
     */
    @DEField(name = "pswfname")
    @JSONField(name = "pswfname")
    @JsonProperty("pswfname")
    @ApiModelProperty(value = "pswfname", notes = "工作流")
    private String pswfName;

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
    * 设置 [工作流版本名称]
    */
    public PSWFVersion setPswfVersionName(String pswfVersionName) {
        this.pswfVersionName = pswfVersionName;
        this.modify("pswfversionname", pswfVersionName);
        return this;
    }

    /**
    * 设置 [工作流]
    */
    public PSWFVersion setPswfid(String pswfid) {
        this.pswfid = pswfid;
        this.modify("pswfid", pswfid);
        return this;
    }

    /**
    * 设置 [工作流]
    */
    public PSWFVersion setPswfName(String pswfName) {
        this.pswfName = pswfName;
        this.modify("pswfname", pswfName);
        return this;
    }

    /**
    * 设置 [扩展标记]
    */
    public PSWFVersion setExtensionTag(String extensionTag) {
        this.extensionTag = extensionTag;
        this.modify("extension_tag", extensionTag);
        return this;
    }

    /**
    * 设置 [扩展标记2]
    */
    public PSWFVersion setExtensionTag2(String extensionTag2) {
        this.extensionTag2 = extensionTag2;
        this.modify("extension_tag2", extensionTag2);
        return this;
    }

    /**
    * 设置 [扩展标记3]
    */
    public PSWFVersion setExtensionTag3(String extensionTag3) {
        this.extensionTag3 = extensionTag3;
        this.modify("extension_tag3", extensionTag3);
        return this;
    }

    /**
    * 设置 [扩展标记4]
    */
    public PSWFVersion setExtensionTag4(String extensionTag4) {
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
            entity.reset("pswfversionid");
        }
        return targetEntity;
    }

}