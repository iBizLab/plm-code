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
 * 实体主状态迁移逻辑[PSDEMSLogicDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("实体主状态迁移逻辑DTO")
public class PSDEMSLogicDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展模型
     */
    @JsonProperty("dynamodelflag")
    @JSONField(name = "dynamodelflag")
    @ApiModelProperty(value = "扩展模型", position = 0)
    private Integer dynaModelFlag;

    /**
     * 逻辑节点
     */
    @JsonProperty("psdelogicnodes")
    @JSONField(name = "psdelogicnodes")
    @ApiModelProperty(value = "逻辑节点", position = 1)
    private List<PSDELogicNodeDTO> psdeLogicNodes;

    /**
     * 逻辑连接
     */
    @JsonProperty("psdelogiclinks")
    @JSONField(name = "psdelogiclinks")
    @ApiModelProperty(value = "逻辑连接", position = 2)
    private List<PSDELogicLinkDTO> psdeLogicLinks;

    /**
     * 代码标识
     */
    @JsonProperty("codename")
    @JSONField(name = "codename")
    @ApiModelProperty(value = "代码标识", position = 3)
    private String codeName;

    /**
     * 建立时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 4)
    private Date createDate;

    /**
     * 建立人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "建立人", position = 5)
    private String createMan;

    /**
     * 逻辑类型
     */
    @JsonProperty("logictype")
    @JSONField(name = "logictype")
    @ApiModelProperty(value = "逻辑类型", position = 6)
    private String logicType;

    /**
     * 实体
     */
    @JsonProperty("psdeid")
    @JSONField(name = "psdeid")
    @ApiModelProperty(value = "实体", position = 7)
    private String psdeid;

    /**
     * 实体处理逻辑标识
     */
    @JsonProperty("psdelogicid")
    @JSONField(name = "psdelogicid")
    @ApiModelProperty(value = "实体处理逻辑标识", position = 8)
    private String psdeLogicId;

    /**
     * 实体处理逻辑名称
     */
    @JsonProperty("psdelogicname")
    @JSONField(name = "psdelogicname")
    @ApiModelProperty(value = "实体处理逻辑名称", position = 9)
    private String psdeLogicName;

    /**
     * 实体
     */
    @JsonProperty("psdename")
    @JSONField(name = "psdename")
    @ApiModelProperty(value = "实体", position = 10)
    private String psdeName;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 11)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 12)
    private String updateMan;

    /**
     * 扩展标记
     */
    @JsonProperty("extension_tag")
    @JSONField(name = "extension_tag")
    @ApiModelProperty(value = "扩展标记", position = 13)
    private String extensionTag;

    /**
     * 扩展标记2
     */
    @JsonProperty("extension_tag2")
    @JSONField(name = "extension_tag2")
    @ApiModelProperty(value = "扩展标记2", position = 14)
    private String extensionTag2;

    /**
     * 扩展标记3
     */
    @JsonProperty("extension_tag3")
    @JSONField(name = "extension_tag3")
    @ApiModelProperty(value = "扩展标记3", position = 15)
    private String extensionTag3;

    /**
     * 扩展标记4
     */
    @JsonProperty("extension_tag4")
    @JSONField(name = "extension_tag4")
    @ApiModelProperty(value = "扩展标记4", position = 16)
    private String extensionTag4;


    /**
     * 设置 [扩展模型]
     */
    public PSDEMSLogicDTO setDynaModelFlag(Integer dynaModelFlag) {
        this.dynaModelFlag = dynaModelFlag;
        this.modify("dynamodelflag", dynaModelFlag);
        return this;
    }

    /**
     * 设置 [逻辑节点]
     */
    public PSDEMSLogicDTO setPsdeLogicNodes(List<PSDELogicNodeDTO> psdeLogicNodes) {
        this.psdeLogicNodes = psdeLogicNodes;
        this.modify("psdelogicnodes", psdeLogicNodes);
        return this;
    }

    /**
     * 设置 [逻辑连接]
     */
    public PSDEMSLogicDTO setPsdeLogicLinks(List<PSDELogicLinkDTO> psdeLogicLinks) {
        this.psdeLogicLinks = psdeLogicLinks;
        this.modify("psdelogiclinks", psdeLogicLinks);
        return this;
    }

    /**
     * 设置 [代码标识]
     */
    public PSDEMSLogicDTO setCodeName(String codeName) {
        this.codeName = codeName;
        this.modify("codename", codeName);
        return this;
    }

    /**
     * 设置 [逻辑类型]
     */
    public PSDEMSLogicDTO setLogicType(String logicType) {
        this.logicType = logicType;
        this.modify("logictype", logicType);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDEMSLogicDTO setPsdeid(String psdeid) {
        this.psdeid = psdeid;
        this.modify("psdeid", psdeid);
        return this;
    }

    /**
     * 设置 [实体处理逻辑名称]
     */
    public PSDEMSLogicDTO setPsdeLogicName(String psdeLogicName) {
        this.psdeLogicName = psdeLogicName;
        this.modify("psdelogicname", psdeLogicName);
        return this;
    }

    /**
     * 设置 [实体]
     */
    public PSDEMSLogicDTO setPsdeName(String psdeName) {
        this.psdeName = psdeName;
        this.modify("psdename", psdeName);
        return this;
    }

    /**
     * 设置 [扩展标记]
     */
    public PSDEMSLogicDTO setExtensionTag(String extensionTag) {
        this.extensionTag = extensionTag;
        this.modify("extension_tag", extensionTag);
        return this;
    }

    /**
     * 设置 [扩展标记2]
     */
    public PSDEMSLogicDTO setExtensionTag2(String extensionTag2) {
        this.extensionTag2 = extensionTag2;
        this.modify("extension_tag2", extensionTag2);
        return this;
    }

    /**
     * 设置 [扩展标记3]
     */
    public PSDEMSLogicDTO setExtensionTag3(String extensionTag3) {
        this.extensionTag3 = extensionTag3;
        this.modify("extension_tag3", extensionTag3);
        return this;
    }

    /**
     * 设置 [扩展标记4]
     */
    public PSDEMSLogicDTO setExtensionTag4(String extensionTag4) {
        this.extensionTag4 = extensionTag4;
        this.modify("extension_tag4", extensionTag4);
        return this;
    }


}
