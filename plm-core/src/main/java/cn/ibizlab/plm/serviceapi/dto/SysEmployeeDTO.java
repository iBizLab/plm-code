/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFAULT}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.math.BigDecimal;
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
 * 人员[SysEmployeeDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("人员DTO")
public class SysEmployeeDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户标识
     */
    @JsonProperty("userid")
    @JSONField(name = "userid")
    @ApiModelProperty(value = "用户标识", position = 0)
    private String userId;

    /**
     * 用户全局名
     */
    @JsonProperty("username")
    @JSONField(name = "username")
    @ApiModelProperty(value = "用户全局名", position = 1)
    private String userName;

    /**
     * 姓名
     */
    @JsonProperty("personname")
    @JSONField(name = "personname")
    @ApiModelProperty(value = "姓名", position = 2)
    private String personName;

    /**
     * 用户工号
     */
    @JsonProperty("usercode")
    @JSONField(name = "usercode")
    @ApiModelProperty(value = "用户工号", position = 3)
    private String userCode;

    /**
     * 登录名
     */
    @JsonProperty("loginname")
    @JSONField(name = "loginname")
    @ApiModelProperty(value = "登录名", position = 4)
    private String loginName;

    /**
     * 密码
     */
    @JsonProperty("password")
    @JSONField(name = "password")
    @ApiModelProperty(value = "密码", position = 5)
    private String password;

    /**
     * 区属
     */
    @JsonProperty("domains")
    @JSONField(name = "domains")
    @ApiModelProperty(value = "区属", position = 6)
    private String domains;

    /**
     * 主部门
     */
    @JsonProperty("mdeptid")
    @JSONField(name = "mdeptid")
    @ApiModelProperty(value = "主部门", position = 7)
    private String mDeptId;

    /**
     * 主部门名称
     */
    @JsonProperty("mdeptname")
    @JSONField(name = "mdeptname")
    @ApiModelProperty(value = "主部门名称", position = 8)
    private String mDeptName;

    /**
     * 业务编码
     */
    @JsonProperty("bcode")
    @JSONField(name = "bcode")
    @ApiModelProperty(value = "业务编码", position = 9)
    private String bCode;

    /**
     * 岗位标识
     */
    @JsonProperty("postid")
    @JSONField(name = "postid")
    @ApiModelProperty(value = "岗位标识", position = 10)
    private String postId;

    /**
     * 岗位名称
     */
    @JsonProperty("postname")
    @JSONField(name = "postname")
    @ApiModelProperty(value = "岗位名称", position = 11)
    private String postName;

    /**
     * 单位
     */
    @JsonProperty("orgid")
    @JSONField(name = "orgid")
    @ApiModelProperty(value = "单位", position = 12)
    private String orgId;

    /**
     * 单位名称
     */
    @JsonProperty("orgname")
    @JSONField(name = "orgname")
    @ApiModelProperty(value = "单位名称", position = 13)
    private String orgName;

    /**
     * 昵称别名
     */
    @JsonProperty("nickname")
    @JSONField(name = "nickname")
    @ApiModelProperty(value = "昵称别名", position = 14)
    private String nickName;

    /**
     * 证件号码
     */
    @JsonProperty("certcode")
    @JSONField(name = "certcode")
    @ApiModelProperty(value = "证件号码", position = 15)
    private String certCode;

    /**
     * 性别
     */
    @JsonProperty("sex")
    @JSONField(name = "sex")
    @ApiModelProperty(value = "性别", position = 16)
    private String sex;

    /**
     * 出生日期
     */
    @JsonProperty("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "birthday" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期", position = 17)
    private Date birthday;

    /**
     * 手机号
     */
    @JsonProperty("phone")
    @JSONField(name = "phone")
    @ApiModelProperty(value = "手机号", position = 18)
    private String phone;

    /**
     * 邮件
     */
    @JsonProperty("email")
    @JSONField(name = "email")
    @ApiModelProperty(value = "邮件", position = 19)
    private String email;

    /**
     * 社交账号
     */
    @JsonProperty("avatar")
    @JSONField(name = "avatar")
    @ApiModelProperty(value = "社交账号", position = 20)
    private String avatar;

    /**
     * 地址
     */
    @JsonProperty("addr")
    @JSONField(name = "addr")
    @ApiModelProperty(value = "地址", position = 21)
    private String addr;

    /**
     * 照片
     */
    @JsonProperty("usericon")
    @JSONField(name = "usericon")
    @ApiModelProperty(value = "照片", position = 22)
    private String userIcon;

    /**
     * ip地址
     */
    @JsonProperty("ipaddr")
    @JSONField(name = "ipaddr")
    @ApiModelProperty(value = "ip地址", position = 23)
    private String ipAddr;

    /**
     * 样式
     */
    @JsonProperty("theme")
    @JSONField(name = "theme")
    @ApiModelProperty(value = "样式", position = 24)
    private String theme;

    /**
     * 语言
     */
    @JsonProperty("lang")
    @JSONField(name = "lang")
    @ApiModelProperty(value = "语言", position = 25)
    private String lang;

    /**
     * 字号
     */
    @JsonProperty("fontsize")
    @JSONField(name = "fontsize")
    @ApiModelProperty(value = "字号", position = 26)
    private String fontSize;

    /**
     * 备注
     */
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "备注", position = 27)
    private String memo;

    /**
     * 保留
     */
    @JsonProperty("reserver")
    @JSONField(name = "reserver")
    @ApiModelProperty(value = "保留", position = 28)
    private String reserver;

    /**
     * 保留10
     */
    @JsonProperty("reserver10")
    @JSONField(name = "reserver10")
    @ApiModelProperty(value = "保留10", position = 29)
    private String reserver10;

    /**
     * 保留11
     */
    @JsonProperty("reserver11")
    @JSONField(name = "reserver11")
    @ApiModelProperty(value = "保留11", position = 30)
    private Integer reserver11;

    /**
     * 保留12
     */
    @JsonProperty("reserver12")
    @JSONField(name = "reserver12")
    @ApiModelProperty(value = "保留12", position = 31)
    private Integer reserver12;

    /**
     * 保留13
     */
    @JsonProperty("reserver13")
    @JSONField(name = "reserver13")
    @ApiModelProperty(value = "保留13", position = 32)
    private Integer reserver13;

    /**
     * 保留14
     */
    @JsonProperty("reserver14")
    @JSONField(name = "reserver14")
    @ApiModelProperty(value = "保留14", position = 33)
    private Integer reserver14;

    /**
     * 保留15
     */
    @JsonProperty("reserver15")
    @JSONField(name = "reserver15")
    @ApiModelProperty(value = "保留15", position = 34)
    private BigDecimal reserver15;

    /**
     * 保留16
     */
    @JsonProperty("reserver16")
    @JSONField(name = "reserver16")
    @ApiModelProperty(value = "保留16", position = 35)
    private BigDecimal reserver16;

    /**
     * 保留17
     */
    @JsonProperty("reserver17")
    @JSONField(name = "reserver17")
    @ApiModelProperty(value = "保留17", position = 36)
    private BigDecimal reserver17;

    /**
     * 保留18
     */
    @JsonProperty("reserver18")
    @JSONField(name = "reserver18")
    @ApiModelProperty(value = "保留18", position = 37)
    private BigDecimal reserver18;

    /**
     * 保留19
     */
    @JsonProperty("reserver19")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "reserver19" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "保留19", position = 38)
    private Date reserver19;

    /**
     * 保留2
     */
    @JsonProperty("reserver2")
    @JSONField(name = "reserver2")
    @ApiModelProperty(value = "保留2", position = 39)
    private String reserver2;

    /**
     * 保留20
     */
    @JsonProperty("reserver20")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "reserver20" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "保留20", position = 40)
    private Date reserver20;

    /**
     * 保留3
     */
    @JsonProperty("reserver3")
    @JSONField(name = "reserver3")
    @ApiModelProperty(value = "保留3", position = 41)
    private String reserver3;

    /**
     * 保留4
     */
    @JsonProperty("reserver4")
    @JSONField(name = "reserver4")
    @ApiModelProperty(value = "保留4", position = 42)
    private String reserver4;

    /**
     * 保留5
     */
    @JsonProperty("reserver5")
    @JSONField(name = "reserver5")
    @ApiModelProperty(value = "保留5", position = 43)
    private String reserver5;

    /**
     * 保留6
     */
    @JsonProperty("reserver6")
    @JSONField(name = "reserver6")
    @ApiModelProperty(value = "保留6", position = 44)
    private String reserver6;

    /**
     * 保留7
     */
    @JsonProperty("reserver7")
    @JSONField(name = "reserver7")
    @ApiModelProperty(value = "保留7", position = 45)
    private String reserver7;

    /**
     * 保留8
     */
    @JsonProperty("reserver8")
    @JSONField(name = "reserver8")
    @ApiModelProperty(value = "保留8", position = 46)
    private String reserver8;

    /**
     * 保留9
     */
    @JsonProperty("reserver9")
    @JSONField(name = "reserver9")
    @ApiModelProperty(value = "保留9", position = 47)
    private String reserver9;

    /**
     * 排序
     */
    @JsonProperty("showorder")
    @JSONField(name = "showorder")
    @ApiModelProperty(value = "排序", position = 48)
    private Integer showOrder;

    /**
     * 管理员
     */
    @JsonProperty("superuser")
    @JSONField(name = "superuser")
    @ApiModelProperty(value = "管理员", position = 49)
    private Integer superUser;

    /**
     * 创建时间
     */
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", position = 50)
    private Date createDate;

    /**
     * 最后修改时间
     */
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间", position = 51)
    private Date updateDate;

    /**
     * 统计
     */
    @JsonProperty("report_flag")
    @JSONField(name = "report_flag")
    @ApiModelProperty(value = "统计", position = 52)
    private Integer reportFlag;

    /**
     * 钉钉用户标识
     */
    @JsonProperty("ddunionid")
    @JSONField(name = "ddunionid")
    @ApiModelProperty(value = "钉钉用户标识", position = 53)
    private String ddUnionId;

    /**
     * 钉钉用户标识
     */
    @JsonProperty("dduserid")
    @JSONField(name = "dduserid")
    @ApiModelProperty(value = "钉钉用户标识", position = 54)
    private String ddUserId;

    /**
     * 消息类型
     */
    @JsonProperty("msgtype")
    @JSONField(name = "msgtype")
    @ApiModelProperty(value = "消息类型", position = 55)
    private Integer msgType;

    /**
     * 人员状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "人员状态", position = 56)
    private String state;

    /**
     * UAA用户标识
     */
    @JsonProperty("uaauserid")
    @JSONField(name = "uaauserid")
    @ApiModelProperty(value = "UAA用户标识", position = 57)
    private String uaaUserId;

    /**
     * 微信用户标识
     */
    @JsonProperty("wxworkunionid")
    @JSONField(name = "wxworkunionid")
    @ApiModelProperty(value = "微信用户标识", position = 58)
    private String wxWorkUnionId;

    /**
     * 企业微信用户标识
     */
    @JsonProperty("wxworkuserid")
    @JSONField(name = "wxworkuserid")
    @ApiModelProperty(value = "企业微信用户标识", position = 59)
    private String wxWorkUserId;


    /**
     * 设置 [用户全局名]
     */
    public SysEmployeeDTO setUserName(String userName) {
        this.userName = userName;
        this.modify("username", userName);
        return this;
    }

    /**
     * 设置 [姓名]
     */
    public SysEmployeeDTO setPersonName(String personName) {
        this.personName = personName;
        this.modify("personname", personName);
        return this;
    }

    /**
     * 设置 [用户工号]
     */
    public SysEmployeeDTO setUserCode(String userCode) {
        this.userCode = userCode;
        this.modify("usercode", userCode);
        return this;
    }

    /**
     * 设置 [登录名]
     */
    public SysEmployeeDTO setLoginName(String loginName) {
        this.loginName = loginName;
        this.modify("loginname", loginName);
        return this;
    }

    /**
     * 设置 [密码]
     */
    public SysEmployeeDTO setPassword(String password) {
        this.password = password;
        this.modify("password", password);
        return this;
    }

    /**
     * 设置 [区属]
     */
    public SysEmployeeDTO setDomains(String domains) {
        this.domains = domains;
        this.modify("domains", domains);
        return this;
    }

    /**
     * 设置 [主部门]
     */
    public SysEmployeeDTO setMDeptId(String mDeptId) {
        this.mDeptId = mDeptId;
        this.modify("mdeptid", mDeptId);
        return this;
    }

    /**
     * 设置 [主部门名称]
     */
    public SysEmployeeDTO setMDeptName(String mDeptName) {
        this.mDeptName = mDeptName;
        this.modify("mdeptname", mDeptName);
        return this;
    }

    /**
     * 设置 [业务编码]
     */
    public SysEmployeeDTO setBCode(String bCode) {
        this.bCode = bCode;
        this.modify("bcode", bCode);
        return this;
    }

    /**
     * 设置 [岗位标识]
     */
    public SysEmployeeDTO setPostId(String postId) {
        this.postId = postId;
        this.modify("postid", postId);
        return this;
    }

    /**
     * 设置 [岗位名称]
     */
    public SysEmployeeDTO setPostName(String postName) {
        this.postName = postName;
        this.modify("postname", postName);
        return this;
    }

    /**
     * 设置 [昵称别名]
     */
    public SysEmployeeDTO setNickName(String nickName) {
        this.nickName = nickName;
        this.modify("nickname", nickName);
        return this;
    }

    /**
     * 设置 [证件号码]
     */
    public SysEmployeeDTO setCertCode(String certCode) {
        this.certCode = certCode;
        this.modify("certcode", certCode);
        return this;
    }

    /**
     * 设置 [性别]
     */
    public SysEmployeeDTO setSex(String sex) {
        this.sex = sex;
        this.modify("sex", sex);
        return this;
    }

    /**
     * 设置 [出生日期]
     */
    public SysEmployeeDTO setBirthday(Date birthday) {
        this.birthday = birthday;
        this.modify("birthday", birthday);
        return this;
    }

    /**
     * 设置 [手机号]
     */
    public SysEmployeeDTO setPhone(String phone) {
        this.phone = phone;
        this.modify("phone", phone);
        return this;
    }

    /**
     * 设置 [邮件]
     */
    public SysEmployeeDTO setEmail(String email) {
        this.email = email;
        this.modify("email", email);
        return this;
    }

    /**
     * 设置 [社交账号]
     */
    public SysEmployeeDTO setAvatar(String avatar) {
        this.avatar = avatar;
        this.modify("avatar", avatar);
        return this;
    }

    /**
     * 设置 [地址]
     */
    public SysEmployeeDTO setAddr(String addr) {
        this.addr = addr;
        this.modify("addr", addr);
        return this;
    }

    /**
     * 设置 [照片]
     */
    public SysEmployeeDTO setUserIcon(String userIcon) {
        this.userIcon = userIcon;
        this.modify("usericon", userIcon);
        return this;
    }

    /**
     * 设置 [ip地址]
     */
    public SysEmployeeDTO setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        this.modify("ipaddr", ipAddr);
        return this;
    }

    /**
     * 设置 [样式]
     */
    public SysEmployeeDTO setTheme(String theme) {
        this.theme = theme;
        this.modify("theme", theme);
        return this;
    }

    /**
     * 设置 [语言]
     */
    public SysEmployeeDTO setLang(String lang) {
        this.lang = lang;
        this.modify("lang", lang);
        return this;
    }

    /**
     * 设置 [字号]
     */
    public SysEmployeeDTO setFontSize(String fontSize) {
        this.fontSize = fontSize;
        this.modify("fontsize", fontSize);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public SysEmployeeDTO setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [保留]
     */
    public SysEmployeeDTO setReserver(String reserver) {
        this.reserver = reserver;
        this.modify("reserver", reserver);
        return this;
    }

    /**
     * 设置 [保留10]
     */
    public SysEmployeeDTO setReserver10(String reserver10) {
        this.reserver10 = reserver10;
        this.modify("reserver10", reserver10);
        return this;
    }

    /**
     * 设置 [保留11]
     */
    public SysEmployeeDTO setReserver11(Integer reserver11) {
        this.reserver11 = reserver11;
        this.modify("reserver11", reserver11);
        return this;
    }

    /**
     * 设置 [保留12]
     */
    public SysEmployeeDTO setReserver12(Integer reserver12) {
        this.reserver12 = reserver12;
        this.modify("reserver12", reserver12);
        return this;
    }

    /**
     * 设置 [保留13]
     */
    public SysEmployeeDTO setReserver13(Integer reserver13) {
        this.reserver13 = reserver13;
        this.modify("reserver13", reserver13);
        return this;
    }

    /**
     * 设置 [保留14]
     */
    public SysEmployeeDTO setReserver14(Integer reserver14) {
        this.reserver14 = reserver14;
        this.modify("reserver14", reserver14);
        return this;
    }

    /**
     * 设置 [保留15]
     */
    public SysEmployeeDTO setReserver15(BigDecimal reserver15) {
        this.reserver15 = reserver15;
        this.modify("reserver15", reserver15);
        return this;
    }

    /**
     * 设置 [保留16]
     */
    public SysEmployeeDTO setReserver16(BigDecimal reserver16) {
        this.reserver16 = reserver16;
        this.modify("reserver16", reserver16);
        return this;
    }

    /**
     * 设置 [保留17]
     */
    public SysEmployeeDTO setReserver17(BigDecimal reserver17) {
        this.reserver17 = reserver17;
        this.modify("reserver17", reserver17);
        return this;
    }

    /**
     * 设置 [保留18]
     */
    public SysEmployeeDTO setReserver18(BigDecimal reserver18) {
        this.reserver18 = reserver18;
        this.modify("reserver18", reserver18);
        return this;
    }

    /**
     * 设置 [保留19]
     */
    public SysEmployeeDTO setReserver19(Date reserver19) {
        this.reserver19 = reserver19;
        this.modify("reserver19", reserver19);
        return this;
    }

    /**
     * 设置 [保留2]
     */
    public SysEmployeeDTO setReserver2(String reserver2) {
        this.reserver2 = reserver2;
        this.modify("reserver2", reserver2);
        return this;
    }

    /**
     * 设置 [保留20]
     */
    public SysEmployeeDTO setReserver20(Date reserver20) {
        this.reserver20 = reserver20;
        this.modify("reserver20", reserver20);
        return this;
    }

    /**
     * 设置 [保留3]
     */
    public SysEmployeeDTO setReserver3(String reserver3) {
        this.reserver3 = reserver3;
        this.modify("reserver3", reserver3);
        return this;
    }

    /**
     * 设置 [保留4]
     */
    public SysEmployeeDTO setReserver4(String reserver4) {
        this.reserver4 = reserver4;
        this.modify("reserver4", reserver4);
        return this;
    }

    /**
     * 设置 [保留5]
     */
    public SysEmployeeDTO setReserver5(String reserver5) {
        this.reserver5 = reserver5;
        this.modify("reserver5", reserver5);
        return this;
    }

    /**
     * 设置 [保留6]
     */
    public SysEmployeeDTO setReserver6(String reserver6) {
        this.reserver6 = reserver6;
        this.modify("reserver6", reserver6);
        return this;
    }

    /**
     * 设置 [保留7]
     */
    public SysEmployeeDTO setReserver7(String reserver7) {
        this.reserver7 = reserver7;
        this.modify("reserver7", reserver7);
        return this;
    }

    /**
     * 设置 [保留8]
     */
    public SysEmployeeDTO setReserver8(String reserver8) {
        this.reserver8 = reserver8;
        this.modify("reserver8", reserver8);
        return this;
    }

    /**
     * 设置 [保留9]
     */
    public SysEmployeeDTO setReserver9(String reserver9) {
        this.reserver9 = reserver9;
        this.modify("reserver9", reserver9);
        return this;
    }

    /**
     * 设置 [排序]
     */
    public SysEmployeeDTO setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
        this.modify("showorder", showOrder);
        return this;
    }

    /**
     * 设置 [管理员]
     */
    public SysEmployeeDTO setSuperUser(Integer superUser) {
        this.superUser = superUser;
        this.modify("superuser", superUser);
        return this;
    }

    /**
     * 设置 [统计]
     */
    public SysEmployeeDTO setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
        this.modify("report_flag", reportFlag);
        return this;
    }

    /**
     * 设置 [钉钉用户标识]
     */
    public SysEmployeeDTO setDdUnionId(String ddUnionId) {
        this.ddUnionId = ddUnionId;
        this.modify("ddunionid", ddUnionId);
        return this;
    }

    /**
     * 设置 [钉钉用户标识]
     */
    public SysEmployeeDTO setDdUserId(String ddUserId) {
        this.ddUserId = ddUserId;
        this.modify("dduserid", ddUserId);
        return this;
    }

    /**
     * 设置 [消息类型]
     */
    public SysEmployeeDTO setMsgType(Integer msgType) {
        this.msgType = msgType;
        this.modify("msgtype", msgType);
        return this;
    }

    /**
     * 设置 [人员状态]
     */
    public SysEmployeeDTO setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [UAA用户标识]
     */
    public SysEmployeeDTO setUaaUserId(String uaaUserId) {
        this.uaaUserId = uaaUserId;
        this.modify("uaauserid", uaaUserId);
        return this;
    }

    /**
     * 设置 [微信用户标识]
     */
    public SysEmployeeDTO setWxWorkUnionId(String wxWorkUnionId) {
        this.wxWorkUnionId = wxWorkUnionId;
        this.modify("wxworkunionid", wxWorkUnionId);
        return this;
    }

    /**
     * 设置 [企业微信用户标识]
     */
    public SysEmployeeDTO setWxWorkUserId(String wxWorkUserId) {
        this.wxWorkUserId = wxWorkUserId;
        this.modify("wxworkuserid", wxWorkUserId);
        return this;
    }


}
