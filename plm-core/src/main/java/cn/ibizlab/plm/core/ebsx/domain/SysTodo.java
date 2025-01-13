/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@ServiceAPI}}.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.domain;

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
import cn.ibizlab.util.domain.EntityClient;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;

/**
 * 待办实体类[SysTodo]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_TODO", description = "待办")
public class SysTodo extends EntityClient implements Serializable
{

    /**
     * 业务单号
     */
    @DEField(name = "num")
    @JSONField(name = "num")
    @JsonProperty("num")
    @ApiModelProperty(value = "num", notes = "业务单号")
    private String num;

    /**
     * 待办标识
     */
    @Id
    @DEField(name = "todoid" , isKeyField = true)
    @JSONField(name = "todoid")
    @JsonProperty("todoid")
    @ApiModelProperty(value = "todoid", notes = "待办标识")
    private String todoId;

    /**
     * 标题
     */
    @DEField(name = "title")
    @JSONField(name = "title")
    @JsonProperty("title")
    @ApiModelProperty(value = "title", notes = "标题")
    private String title;

    /**
     * 创建人
     */
    @DEField(name = "createman" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty(value = "createman", notes = "创建人")
    private String createMan;

    /**
     * 上一环节处理人
     */
    @DEField(name = "createmanname" , preType = DEPredefinedFieldType.CREATEMANNAME)
    @JSONField(name = "createmanname")
    @JsonProperty("createmanname")
    @ApiModelProperty(value = "createmanname", notes = "上一环节处理人")
    private String createManName;

    /**
     * 创建时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty(value = "createdate", notes = "创建时间")
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
     * 更新人
     */
    @DEField(name = "updatemanname" , preType = DEPredefinedFieldType.UPDATEMANNAME)
    @JSONField(name = "updatemanname")
    @JsonProperty("updatemanname")
    @ApiModelProperty(value = "updatemanname", notes = "更新人")
    private String updateManName;

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
     * 参数04
     */
    @DEField(name = "param04")
    @JSONField(name = "param04")
    @JsonProperty("param04")
    @ApiModelProperty(value = "param04", notes = "参数04")
    private String param04;

    /**
     * 长文本参数01
     */
    @DEField(name = "clobparam01")
    @JSONField(name = "clobparam01")
    @JsonProperty("clobparam01")
    @ApiModelProperty(value = "clobparam01", notes = "长文本参数01")
    private String clobParam01;

    /**
     * 业务对象
     */
    @DEField(name = "biztype")
    @JSONField(name = "biztype")
    @JsonProperty("biztype")
    @ApiModelProperty(value = "biztype", notes = "业务对象")
    private String bizType;

    /**
     * 处理时间
     */
    @DEField(name = "processdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "processdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("processdate")
    @ApiModelProperty(value = "processdate", notes = "处理时间")
    private Date processDate;

    /**
     * 参数07
     */
    @DEField(name = "param07")
    @JSONField(name = "param07")
    @JsonProperty("param07")
    @ApiModelProperty(value = "param07", notes = "参数07")
    private String param07;

    /**
     * 参数09
     */
    @DEField(name = "param09")
    @JSONField(name = "param09")
    @JsonProperty("param09")
    @ApiModelProperty(value = "param09", notes = "参数09")
    private String param09;

    /**
     * 租户系统标识
     */
    @DEField(name = "dcsystemid")
    @JSONField(name = "dcsystemid")
    @JsonProperty("dcsystemid")
    @ApiModelProperty(value = "dcsystemid", notes = "租户系统标识")
    private String dcSystemId;

    /**
     * 参数08
     */
    @DEField(name = "param08")
    @JSONField(name = "param08")
    @JsonProperty("param08")
    @ApiModelProperty(value = "param08", notes = "参数08")
    private String param08;

    /**
     * 业务数据标识
     */
    @DEField(name = "bizkey")
    @JSONField(name = "bizkey")
    @JsonProperty("bizkey")
    @ApiModelProperty(value = "bizkey", notes = "业务数据标识")
    private String bizKey;

    /**
     * 租户系统名称
     */
    @DEField(name = "dcsystemname")
    @JSONField(name = "dcsystemname")
    @JsonProperty("dcsystemname")
    @ApiModelProperty(value = "dcsystemname", notes = "租户系统名称")
    private String dcSystemName;

    /**
     * 参数06
     */
    @DEField(name = "param06")
    @JSONField(name = "param06")
    @JsonProperty("param06")
    @ApiModelProperty(value = "param06", notes = "参数06")
    private String param06;

    /**
     * 长文本参数02
     */
    @DEField(name = "clobparam02")
    @JSONField(name = "clobparam02")
    @JsonProperty("clobparam02")
    @ApiModelProperty(value = "clobparam02", notes = "长文本参数02")
    private String clobParam02;

    /**
     * 参数02
     */
    @DEField(name = "param02")
    @JSONField(name = "param02")
    @JsonProperty("param02")
    @ApiModelProperty(value = "param02", notes = "参数02")
    private String param02;

    /**
     * 过期时间
     */
    @DEField(name = "duedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "duedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("duedate")
    @ApiModelProperty(value = "duedate", notes = "过期时间")
    private Date dueDate;

    /**
     * 连接地址
     */
    @DEField(name = "linkurl")
    @JSONField(name = "linkurl")
    @JsonProperty("linkurl")
    @ApiModelProperty(value = "linkurl", notes = "连接地址")
    private String linkUrl;

    /**
     * 待办子类
     */
    @DEField(name = "todosubtype")
    @JSONField(name = "todosubtype")
    @JsonProperty("todosubtype")
    @ApiModelProperty(value = "todosubtype", notes = "待办子类")
    private String todoSubType;

    /**
     * 参数01
     */
    @DEField(name = "param01")
    @JSONField(name = "param01")
    @JsonProperty("param01")
    @ApiModelProperty(value = "param01", notes = "参数01")
    private String param01;

    /**
     * 待办用户标识
     */
    @DEField(name = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty(value = "userid", notes = "待办用户标识")
    private String userId;

    /**
     * 参数05
     */
    @DEField(name = "param05")
    @JSONField(name = "param05")
    @JsonProperty("param05")
    @ApiModelProperty(value = "param05", notes = "参数05")
    private String param05;

    /**
     * 组织机构标识
     */
    @DEField(name = "orgid" , preType = DEPredefinedFieldType.ORGID)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    @ApiModelProperty(value = "orgid", notes = "组织机构标识")
    private String orgId;

    /**
     * 待办类型
     */
    @DEField(name = "todotype")
    @JSONField(name = "todotype")
    @JsonProperty("todotype")
    @ApiModelProperty(value = "todotype", notes = "待办类型")
    private String todoType;

    /**
     * 内容
     */
    @DEField(name = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    @ApiModelProperty(value = "content", notes = "内容")
    private String content;

    /**
     * 参数03
     */
    @DEField(name = "param03")
    @JSONField(name = "param03")
    @JsonProperty("param03")
    @ApiModelProperty(value = "param03", notes = "参数03")
    private String param03;

    /**
     * 待办地址类型
     */
    @DEField(name = "todourltype")
    @JSONField(name = "todourltype")
    @JsonProperty("todourltype")
    @ApiModelProperty(value = "todourltype", notes = "待办地址类型")
    private String todoUrlType;

    /**
     * 待办状态
     */
    @DEField(name = "todostate" , dict = "CodeListTodoState")
    @JSONField(name = "todostate")
    @JsonProperty("todostate")
    @ApiModelProperty(value = "todostate", notes = "待办状态")
    private String todoState;

    /**
     * 是否已读
     */
    @DEField(name = "isread" , dict = "YesNo")
    @JSONField(name = "isread")
    @JsonProperty("isread")
    @ApiModelProperty(value = "isread", notes = "是否已读")
    private Integer isRead;

    /**
    * 设置 [业务单号]
    */
    public SysTodo setNum(String num) {
        this.num = num;
        this.modify("num", num);
        return this;
    }

    /**
    * 设置 [标题]
    */
    public SysTodo setTitle(String title) {
        this.title = title;
        this.modify("title", title);
        return this;
    }

    /**
    * 设置 [参数04]
    */
    public SysTodo setParam04(String param04) {
        this.param04 = param04;
        this.modify("param04", param04);
        return this;
    }

    /**
    * 设置 [长文本参数01]
    */
    public SysTodo setClobParam01(String clobParam01) {
        this.clobParam01 = clobParam01;
        this.modify("clobparam01", clobParam01);
        return this;
    }

    /**
    * 设置 [业务对象]
    */
    public SysTodo setBizType(String bizType) {
        this.bizType = bizType;
        this.modify("biztype", bizType);
        return this;
    }

    /**
    * 设置 [处理时间]
    */
    public SysTodo setProcessDate(Date processDate) {
        this.processDate = processDate;
        this.modify("processdate", processDate);
        return this;
    }

    /**
    * 设置 [参数07]
    */
    public SysTodo setParam07(String param07) {
        this.param07 = param07;
        this.modify("param07", param07);
        return this;
    }

    /**
    * 设置 [参数09]
    */
    public SysTodo setParam09(String param09) {
        this.param09 = param09;
        this.modify("param09", param09);
        return this;
    }

    /**
    * 设置 [租户系统标识]
    */
    public SysTodo setDcSystemId(String dcSystemId) {
        this.dcSystemId = dcSystemId;
        this.modify("dcsystemid", dcSystemId);
        return this;
    }

    /**
    * 设置 [参数08]
    */
    public SysTodo setParam08(String param08) {
        this.param08 = param08;
        this.modify("param08", param08);
        return this;
    }

    /**
    * 设置 [业务数据标识]
    */
    public SysTodo setBizKey(String bizKey) {
        this.bizKey = bizKey;
        this.modify("bizkey", bizKey);
        return this;
    }

    /**
    * 设置 [租户系统名称]
    */
    public SysTodo setDcSystemName(String dcSystemName) {
        this.dcSystemName = dcSystemName;
        this.modify("dcsystemname", dcSystemName);
        return this;
    }

    /**
    * 设置 [参数06]
    */
    public SysTodo setParam06(String param06) {
        this.param06 = param06;
        this.modify("param06", param06);
        return this;
    }

    /**
    * 设置 [长文本参数02]
    */
    public SysTodo setClobParam02(String clobParam02) {
        this.clobParam02 = clobParam02;
        this.modify("clobparam02", clobParam02);
        return this;
    }

    /**
    * 设置 [参数02]
    */
    public SysTodo setParam02(String param02) {
        this.param02 = param02;
        this.modify("param02", param02);
        return this;
    }

    /**
    * 设置 [过期时间]
    */
    public SysTodo setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        this.modify("duedate", dueDate);
        return this;
    }

    /**
    * 设置 [连接地址]
    */
    public SysTodo setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        this.modify("linkurl", linkUrl);
        return this;
    }

    /**
    * 设置 [待办子类]
    */
    public SysTodo setTodoSubType(String todoSubType) {
        this.todoSubType = todoSubType;
        this.modify("todosubtype", todoSubType);
        return this;
    }

    /**
    * 设置 [参数01]
    */
    public SysTodo setParam01(String param01) {
        this.param01 = param01;
        this.modify("param01", param01);
        return this;
    }

    /**
    * 设置 [待办用户标识]
    */
    public SysTodo setUserId(String userId) {
        this.userId = userId;
        this.modify("userid", userId);
        return this;
    }

    /**
    * 设置 [参数05]
    */
    public SysTodo setParam05(String param05) {
        this.param05 = param05;
        this.modify("param05", param05);
        return this;
    }

    /**
    * 设置 [待办类型]
    */
    public SysTodo setTodoType(String todoType) {
        this.todoType = todoType;
        this.modify("todotype", todoType);
        return this;
    }

    /**
    * 设置 [内容]
    */
    public SysTodo setContent(String content) {
        this.content = content;
        this.modify("content", content);
        return this;
    }

    /**
    * 设置 [参数03]
    */
    public SysTodo setParam03(String param03) {
        this.param03 = param03;
        this.modify("param03", param03);
        return this;
    }

    /**
    * 设置 [待办地址类型]
    */
    public SysTodo setTodoUrlType(String todoUrlType) {
        this.todoUrlType = todoUrlType;
        this.modify("todourltype", todoUrlType);
        return this;
    }

    /**
    * 设置 [待办状态]
    */
    public SysTodo setTodoState(String todoState) {
        this.todoState = todoState;
        this.modify("todostate", todoState);
        return this;
    }

    /**
    * 设置 [是否已读]
    */
    public SysTodo setIsRead(Integer isRead) {
        this.isRead = isRead;
        this.modify("isread", isRead);
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
            entity.reset("todoid");
        }
        return targetEntity;
    }

}