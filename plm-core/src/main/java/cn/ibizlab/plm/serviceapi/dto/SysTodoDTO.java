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
 * 待办[SysTodoDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("待办DTO")
public class SysTodoDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务单号
     */
    @JsonProperty("num")
    @JSONField(name = "num")
    @ApiModelProperty(value = "业务单号", position = 0)
    private String num;

    /**
     * 业务数据标识
     */
    @JsonProperty("bizkey")
    @JSONField(name = "bizkey")
    @ApiModelProperty(value = "业务数据标识", position = 1)
    private String bizKey;

    /**
     * 业务对象
     */
    @JsonProperty("biztype")
    @JSONField(name = "biztype")
    @ApiModelProperty(value = "业务对象", position = 2)
    private String bizType;

    /**
     * 长文本参数01
     */
    @JsonProperty("clobparam01")
    @JSONField(name = "clobparam01")
    @ApiModelProperty(value = "长文本参数01", position = 3)
    private String clobParam01;

    /**
     * 长文本参数02
     */
    @JsonProperty("clobparam02")
    @JSONField(name = "clobparam02")
    @ApiModelProperty(value = "长文本参数02", position = 4)
    private String clobParam02;

    /**
     * 内容
     */
    @JsonProperty("content")
    @JSONField(name = "content")
    @ApiModelProperty(value = "内容", position = 5)
    private String content;

    /**
     * 创建时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", position = 6)
    private Date createDate;

    /**
     * 创建人
     */
    @JsonProperty("createman")
    @JSONField(name = "createman")
    @ApiModelProperty(value = "创建人", position = 7)
    private String createMan;

    /**
     * 上一环节处理人
     */
    @JsonProperty("createmanname")
    @JSONField(name = "createmanname")
    @ApiModelProperty(value = "上一环节处理人", position = 8)
    private String createManName;

    /**
     * 租户系统标识
     */
    @JsonProperty("dcsystemid")
    @JSONField(name = "dcsystemid")
    @ApiModelProperty(value = "租户系统标识", position = 9)
    private String dcSystemId;

    /**
     * 租户系统名称
     */
    @JsonProperty("dcsystemname")
    @JSONField(name = "dcsystemname")
    @ApiModelProperty(value = "租户系统名称", position = 10)
    private String dcSystemName;

    /**
     * 过期时间
     */
    @JsonProperty("duedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "duedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "过期时间", position = 11)
    private Date dueDate;

    /**
     * 是否已读
     */
    @JsonProperty("isread")
    @JSONField(name = "isread")
    @ApiModelProperty(value = "是否已读", position = 12)
    private Integer isRead;

    /**
     * 连接地址
     */
    @JsonProperty("linkurl")
    @JSONField(name = "linkurl")
    @ApiModelProperty(value = "连接地址", position = 13)
    private String linkUrl;

    /**
     * 组织机构标识
     */
    @JsonProperty("orgid")
    @JSONField(name = "orgid")
    @ApiModelProperty(value = "组织机构标识", position = 14)
    private String orgId;

    /**
     * 参数01
     */
    @JsonProperty("param01")
    @JSONField(name = "param01")
    @ApiModelProperty(value = "参数01", position = 15)
    private String param01;

    /**
     * 参数02
     */
    @JsonProperty("param02")
    @JSONField(name = "param02")
    @ApiModelProperty(value = "参数02", position = 16)
    private String param02;

    /**
     * 参数03
     */
    @JsonProperty("param03")
    @JSONField(name = "param03")
    @ApiModelProperty(value = "参数03", position = 17)
    private String param03;

    /**
     * 参数04
     */
    @JsonProperty("param04")
    @JSONField(name = "param04")
    @ApiModelProperty(value = "参数04", position = 18)
    private String param04;

    /**
     * 参数05
     */
    @JsonProperty("param05")
    @JSONField(name = "param05")
    @ApiModelProperty(value = "参数05", position = 19)
    private String param05;

    /**
     * 参数06
     */
    @JsonProperty("param06")
    @JSONField(name = "param06")
    @ApiModelProperty(value = "参数06", position = 20)
    private String param06;

    /**
     * 参数07
     */
    @JsonProperty("param07")
    @JSONField(name = "param07")
    @ApiModelProperty(value = "参数07", position = 21)
    private String param07;

    /**
     * 参数08
     */
    @JsonProperty("param08")
    @JSONField(name = "param08")
    @ApiModelProperty(value = "参数08", position = 22)
    private String param08;

    /**
     * 参数09
     */
    @JsonProperty("param09")
    @JSONField(name = "param09")
    @ApiModelProperty(value = "参数09", position = 23)
    private String param09;

    /**
     * 处理时间
     */
    @JsonProperty("processdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "processdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "处理时间", position = 24)
    private Date processDate;

    /**
     * 标题
     */
    @JsonProperty("title")
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", position = 25)
    private String title;

    /**
     * 待办标识
     */
    @JsonProperty("todoid")
    @JSONField(name = "todoid")
    @ApiModelProperty(value = "待办标识", position = 26)
    private String todoId;

    /**
     * 待办状态
     */
    @JsonProperty("todostate")
    @JSONField(name = "todostate")
    @ApiModelProperty(value = "待办状态", position = 27)
    private String todoState;

    /**
     * 待办子类
     */
    @JsonProperty("todosubtype")
    @JSONField(name = "todosubtype")
    @ApiModelProperty(value = "待办子类", position = 28)
    private String todoSubType;

    /**
     * 待办类型
     */
    @JsonProperty("todotype")
    @JSONField(name = "todotype")
    @ApiModelProperty(value = "待办类型", position = 29)
    private String todoType;

    /**
     * 待办地址类型
     */
    @JsonProperty("todourltype")
    @JSONField(name = "todourltype")
    @ApiModelProperty(value = "待办地址类型", position = 30)
    private String todoUrlType;

    /**
     * 更新时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 31)
    private Date updateDate;

    /**
     * 更新人
     */
    @JsonProperty("updateman")
    @JSONField(name = "updateman")
    @ApiModelProperty(value = "更新人", position = 32)
    private String updateMan;

    /**
     * 更新人
     */
    @JsonProperty("updatemanname")
    @JSONField(name = "updatemanname")
    @ApiModelProperty(value = "更新人", position = 33)
    private String updateManName;

    /**
     * 待办用户标识
     */
    @JsonProperty("userid")
    @JSONField(name = "userid")
    @ApiModelProperty(value = "待办用户标识", position = 34)
    private String userId;


    /**
     * 设置 [业务单号]
     */
    public SysTodoDTO setNum(String num) {
        this.num = num;
        this.modify("num", num);
        return this;
    }

    /**
     * 设置 [业务数据标识]
     */
    public SysTodoDTO setBizKey(String bizKey) {
        this.bizKey = bizKey;
        this.modify("bizkey", bizKey);
        return this;
    }

    /**
     * 设置 [业务对象]
     */
    public SysTodoDTO setBizType(String bizType) {
        this.bizType = bizType;
        this.modify("biztype", bizType);
        return this;
    }

    /**
     * 设置 [长文本参数01]
     */
    public SysTodoDTO setClobParam01(String clobParam01) {
        this.clobParam01 = clobParam01;
        this.modify("clobparam01", clobParam01);
        return this;
    }

    /**
     * 设置 [长文本参数02]
     */
    public SysTodoDTO setClobParam02(String clobParam02) {
        this.clobParam02 = clobParam02;
        this.modify("clobparam02", clobParam02);
        return this;
    }

    /**
     * 设置 [内容]
     */
    public SysTodoDTO setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
     * 设置 [租户系统标识]
     */
    public SysTodoDTO setDcSystemId(String dcSystemId) {
        this.dcSystemId = dcSystemId;
        this.modify("dcsystemid", dcSystemId);
        return this;
    }

    /**
     * 设置 [租户系统名称]
     */
    public SysTodoDTO setDcSystemName(String dcSystemName) {
        this.dcSystemName = dcSystemName;
        this.modify("dcsystemname", dcSystemName);
        return this;
    }

    /**
     * 设置 [过期时间]
     */
    public SysTodoDTO setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        this.modify("duedate", dueDate);
        return this;
    }

    /**
     * 设置 [是否已读]
     */
    public SysTodoDTO setIsRead(Integer isRead) {
        this.isRead = isRead;
        this.modify("isread", isRead);
        return this;
    }

    /**
     * 设置 [连接地址]
     */
    public SysTodoDTO setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        this.modify("linkurl", linkUrl);
        return this;
    }

    /**
     * 设置 [参数01]
     */
    public SysTodoDTO setParam01(String param01) {
        this.param01 = param01;
        this.modify("param01", param01);
        return this;
    }

    /**
     * 设置 [参数02]
     */
    public SysTodoDTO setParam02(String param02) {
        this.param02 = param02;
        this.modify("param02", param02);
        return this;
    }

    /**
     * 设置 [参数03]
     */
    public SysTodoDTO setParam03(String param03) {
        this.param03 = param03;
        this.modify("param03", param03);
        return this;
    }

    /**
     * 设置 [参数04]
     */
    public SysTodoDTO setParam04(String param04) {
        this.param04 = param04;
        this.modify("param04", param04);
        return this;
    }

    /**
     * 设置 [参数05]
     */
    public SysTodoDTO setParam05(String param05) {
        this.param05 = param05;
        this.modify("param05", param05);
        return this;
    }

    /**
     * 设置 [参数06]
     */
    public SysTodoDTO setParam06(String param06) {
        this.param06 = param06;
        this.modify("param06", param06);
        return this;
    }

    /**
     * 设置 [参数07]
     */
    public SysTodoDTO setParam07(String param07) {
        this.param07 = param07;
        this.modify("param07", param07);
        return this;
    }

    /**
     * 设置 [参数08]
     */
    public SysTodoDTO setParam08(String param08) {
        this.param08 = param08;
        this.modify("param08", param08);
        return this;
    }

    /**
     * 设置 [参数09]
     */
    public SysTodoDTO setParam09(String param09) {
        this.param09 = param09;
        this.modify("param09", param09);
        return this;
    }

    /**
     * 设置 [处理时间]
     */
    public SysTodoDTO setProcessDate(Date processDate) {
        this.processDate = processDate;
        this.modify("processdate", processDate);
        return this;
    }

    /**
     * 设置 [标题]
     */
    public SysTodoDTO setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
     * 设置 [待办状态]
     */
    public SysTodoDTO setTodoState(String todoState) {
        this.todoState = todoState;
        this.modify("todostate", todoState);
        return this;
    }

    /**
     * 设置 [待办子类]
     */
    public SysTodoDTO setTodoSubType(String todoSubType) {
        this.todoSubType = todoSubType;
        this.modify("todosubtype", todoSubType);
        return this;
    }

    /**
     * 设置 [待办类型]
     */
    public SysTodoDTO setTodoType(String todoType) {
        this.todoType = todoType;
        this.modify("todotype", todoType);
        return this;
    }

    /**
     * 设置 [待办地址类型]
     */
    public SysTodoDTO setTodoUrlType(String todoUrlType) {
        this.todoUrlType = todoUrlType;
        this.modify("todourltype", todoUrlType);
        return this;
    }

    /**
     * 设置 [待办用户标识]
     */
    public SysTodoDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }


}
