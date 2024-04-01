/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@ServiceAPI}}.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.domain;

import java.util.*;
import java.math.BigDecimal;
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
 * 人员实体类[SysEmployee]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_EMP", description = "人员")
public class SysEmployee extends EntityClient implements Serializable
{

    /**
     * 用户标识
     */
    @Id
    @DEField(name = "userid" , isKeyField = true)
    @JsonProperty("userid")
    @JSONField(name = "userid")
    @ApiModelProperty(value = "userid", notes = "用户标识")
    private String userId;

    /**
     * 用户全局名
     */
    @DEField(name = "username")
    @JsonProperty("username")
    @JSONField(name = "username")
    @ApiModelProperty(value = "username", notes = "用户全局名")
    private String userName;

    /**
     * 姓名
     */
    @DEField(name = "personname")
    @JsonProperty("personname")
    @JSONField(name = "personname")
    @ApiModelProperty(value = "personname", notes = "姓名")
    private String personName;

    /**
     * 用户工号
     */
    @DEField(name = "usercode")
    @JsonProperty("usercode")
    @JSONField(name = "usercode")
    @ApiModelProperty(value = "usercode", notes = "用户工号")
    private String userCode;

    /**
     * 登录名
     */
    @DEField(name = "loginname")
    @JsonProperty("loginname")
    @JSONField(name = "loginname")
    @ApiModelProperty(value = "loginname", notes = "登录名")
    private String loginName;

    /**
     * 密码
     */
    @DEField(name = "password")
    @JsonProperty("password")
    @JSONField(name = "password")
    @ApiModelProperty(value = "password", notes = "密码")
    private String password;

    /**
     * 区属
     */
    @DEField(name = "domains")
    @JsonProperty("domains")
    @JSONField(name = "domains")
    @ApiModelProperty(value = "domains", notes = "区属")
    private String domains;

    /**
     * 主部门
     */
    @DEField(name = "mdeptid")
    @JsonProperty("mdeptid")
    @JSONField(name = "mdeptid")
    @ApiModelProperty(value = "mdeptid", notes = "主部门")
    private String mDeptId;

    /**
     * 主部门名称
     */
    @DEField(name = "mdeptname")
    @JsonProperty("mdeptname")
    @JSONField(name = "mdeptname")
    @ApiModelProperty(value = "mdeptname", notes = "主部门名称")
    private String mDeptName;

    /**
     * 业务编码
     */
    @DEField(name = "bcode")
    @JsonProperty("bcode")
    @JSONField(name = "bcode")
    @ApiModelProperty(value = "bcode", notes = "业务编码")
    private String bCode;

    /**
     * 岗位标识
     */
    @DEField(name = "postid")
    @JsonProperty("postid")
    @JSONField(name = "postid")
    @ApiModelProperty(value = "postid", notes = "岗位标识")
    private String postId;

    /**
     * 岗位名称
     */
    @DEField(name = "postname")
    @JsonProperty("postname")
    @JSONField(name = "postname")
    @ApiModelProperty(value = "postname", notes = "岗位名称")
    private String postName;

    /**
     * 单位
     */
    @DEField(name = "orgid" , preType = DEPredefinedFieldType.ORGID)
    @JsonProperty("orgid")
    @JSONField(name = "orgid")
    @ApiModelProperty(value = "orgid", notes = "单位")
    private String orgId;

    /**
     * 单位名称
     */
    @DEField(name = "orgname" , preType = DEPredefinedFieldType.ORGNAME)
    @JsonProperty("orgname")
    @JSONField(name = "orgname")
    @ApiModelProperty(value = "orgname", notes = "单位名称")
    private String orgName;

    /**
     * 昵称别名
     */
    @DEField(name = "nickname")
    @JsonProperty("nickname")
    @JSONField(name = "nickname")
    @ApiModelProperty(value = "nickname", notes = "昵称别名")
    private String nickName;

    /**
     * 性别
     */
    @DEField(name = "sex")
    @JsonProperty("sex")
    @JSONField(name = "sex")
    @ApiModelProperty(value = "sex", notes = "性别")
    private String sex;

    /**
     * 证件号码
     */
    @DEField(name = "certcode")
    @JsonProperty("certcode")
    @JSONField(name = "certcode")
    @ApiModelProperty(value = "certcode", notes = "证件号码")
    private String certCode;

    /**
     * 手机号
     */
    @DEField(name = "phone")
    @JsonProperty("phone")
    @JSONField(name = "phone")
    @ApiModelProperty(value = "phone", notes = "手机号")
    private String phone;

    /**
     * 出生日期
     */
    @DEField(name = "birthday")
    @JsonProperty("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "birthday" , format = "yyyy-MM-dd")
    @ApiModelProperty(value = "birthday", notes = "出生日期")
    private Date birthday;

    /**
     * 邮件
     */
    @DEField(name = "email")
    @JsonProperty("email")
    @JSONField(name = "email")
    @ApiModelProperty(value = "email", notes = "邮件")
    private String email;

    /**
     * 社交账号
     */
    @DEField(name = "avatar")
    @JsonProperty("avatar")
    @JSONField(name = "avatar")
    @ApiModelProperty(value = "avatar", notes = "社交账号")
    private String avatar;

    /**
     * 地址
     */
    @DEField(name = "addr")
    @JsonProperty("addr")
    @JSONField(name = "addr")
    @ApiModelProperty(value = "addr", notes = "地址")
    private String addr;

    /**
     * 照片
     */
    @DEField(name = "usericon")
    @JsonProperty("usericon")
    @JSONField(name = "usericon")
    @ApiModelProperty(value = "usericon", notes = "照片")
    private String userIcon;

    /**
     * ip地址
     */
    @DEField(name = "ipaddr")
    @JsonProperty("ipaddr")
    @JSONField(name = "ipaddr")
    @ApiModelProperty(value = "ipaddr", notes = "ip地址")
    private String ipAddr;

    /**
     * 样式
     */
    @DEField(name = "theme")
    @JsonProperty("theme")
    @JSONField(name = "theme")
    @ApiModelProperty(value = "theme", notes = "样式")
    private String theme;

    /**
     * 语言
     */
    @DEField(name = "lang")
    @JsonProperty("lang")
    @JSONField(name = "lang")
    @ApiModelProperty(value = "lang", notes = "语言")
    private String lang;

    /**
     * 字号
     */
    @DEField(name = "fontsize")
    @JsonProperty("fontsize")
    @JSONField(name = "fontsize")
    @ApiModelProperty(value = "fontsize", notes = "字号")
    private String fontSize;

    /**
     * 备注
     */
    @DEField(name = "memo")
    @JsonProperty("memo")
    @JSONField(name = "memo")
    @ApiModelProperty(value = "memo", notes = "备注")
    private String memo;

    /**
     * 保留18
     */
    @DEField(name = "reserver18")
    @JsonProperty("reserver18")
    @JSONField(name = "reserver18")
    @ApiModelProperty(value = "reserver18", notes = "保留18")
    private BigDecimal reserver18;

    /**
     * 保留17
     */
    @DEField(name = "reserver17")
    @JsonProperty("reserver17")
    @JSONField(name = "reserver17")
    @ApiModelProperty(value = "reserver17", notes = "保留17")
    private BigDecimal reserver17;

    /**
     * 保留12
     */
    @DEField(name = "reserver12")
    @JsonProperty("reserver12")
    @JSONField(name = "reserver12")
    @ApiModelProperty(value = "reserver12", notes = "保留12")
    private Integer reserver12;

    /**
     * 保留15
     */
    @DEField(name = "reserver15")
    @JsonProperty("reserver15")
    @JSONField(name = "reserver15")
    @ApiModelProperty(value = "reserver15", notes = "保留15")
    private BigDecimal reserver15;

    /**
     * 保留16
     */
    @DEField(name = "reserver16")
    @JsonProperty("reserver16")
    @JSONField(name = "reserver16")
    @ApiModelProperty(value = "reserver16", notes = "保留16")
    private BigDecimal reserver16;

    /**
     * 保留13
     */
    @DEField(name = "reserver13")
    @JsonProperty("reserver13")
    @JSONField(name = "reserver13")
    @ApiModelProperty(value = "reserver13", notes = "保留13")
    private Integer reserver13;

    /**
     * 保留11
     */
    @DEField(name = "reserver11")
    @JsonProperty("reserver11")
    @JSONField(name = "reserver11")
    @ApiModelProperty(value = "reserver11", notes = "保留11")
    private Integer reserver11;

    /**
     * 保留14
     */
    @DEField(name = "reserver14")
    @JsonProperty("reserver14")
    @JSONField(name = "reserver14")
    @ApiModelProperty(value = "reserver14", notes = "保留14")
    private Integer reserver14;

    /**
     * 保留7
     */
    @DEField(name = "reserver7")
    @JsonProperty("reserver7")
    @JSONField(name = "reserver7")
    @ApiModelProperty(value = "reserver7", notes = "保留7")
    private String reserver7;

    /**
     * 保留4
     */
    @DEField(name = "reserver4")
    @JsonProperty("reserver4")
    @JSONField(name = "reserver4")
    @ApiModelProperty(value = "reserver4", notes = "保留4")
    private String reserver4;

    /**
     * 保留2
     */
    @DEField(name = "reserver2")
    @JsonProperty("reserver2")
    @JSONField(name = "reserver2")
    @ApiModelProperty(value = "reserver2", notes = "保留2")
    private String reserver2;

    /**
     * 保留5
     */
    @DEField(name = "reserver5")
    @JsonProperty("reserver5")
    @JSONField(name = "reserver5")
    @ApiModelProperty(value = "reserver5", notes = "保留5")
    private String reserver5;

    /**
     * 保留6
     */
    @DEField(name = "reserver6")
    @JsonProperty("reserver6")
    @JSONField(name = "reserver6")
    @ApiModelProperty(value = "reserver6", notes = "保留6")
    private String reserver6;

    /**
     * 保留3
     */
    @DEField(name = "reserver3")
    @JsonProperty("reserver3")
    @JSONField(name = "reserver3")
    @ApiModelProperty(value = "reserver3", notes = "保留3")
    private String reserver3;

    /**
     * 保留8
     */
    @DEField(name = "reserver8")
    @JsonProperty("reserver8")
    @JSONField(name = "reserver8")
    @ApiModelProperty(value = "reserver8", notes = "保留8")
    private String reserver8;

    /**
     * 保留
     */
    @DEField(name = "reserver")
    @JsonProperty("reserver")
    @JSONField(name = "reserver")
    @ApiModelProperty(value = "reserver", notes = "保留")
    private String reserver;

    /**
     * 保留19
     */
    @DEField(name = "reserver19")
    @JsonProperty("reserver19")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "reserver19" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "reserver19", notes = "保留19")
    private Date reserver19;

    /**
     * 保留20
     */
    @DEField(name = "reserver20")
    @JsonProperty("reserver20")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "reserver20" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "reserver20", notes = "保留20")
    private Date reserver20;

    /**
     * 保留10
     */
    @DEField(name = "reserver10")
    @JsonProperty("reserver10")
    @JSONField(name = "reserver10")
    @ApiModelProperty(value = "reserver10", notes = "保留10")
    private String reserver10;

    /**
     * 保留9
     */
    @DEField(name = "reserver9")
    @JsonProperty("reserver9")
    @JSONField(name = "reserver9")
    @ApiModelProperty(value = "reserver9", notes = "保留9")
    private String reserver9;

    /**
     * 排序
     */
    @DEField(name = "showorder")
    @JsonProperty("showorder")
    @JSONField(name = "showorder")
    @ApiModelProperty(value = "showorder", notes = "排序")
    private Integer showOrder;

    /**
     * 管理员
     */
    @DEField(name = "superuser" , defaultValue = "0" , dict = "YesNo")
    @JsonProperty("superuser")
    @JSONField(name = "superuser")
    @ApiModelProperty(value = "superuser", notes = "管理员")
    private Integer superUser;

    /**
     * 逻辑有效
     */
    @DEField(name = "enable" , preType = DEPredefinedFieldType.LOGICVALID , logicval = "1" , logicdelval = "0")
    @JsonProperty("enable")
    @JSONField(name = "enable")
    @ApiModelProperty(value = "enable", notes = "逻辑有效")
    private Integer enable;

    /**
     * 创建时间
     */
    @DEField(name = "createdate" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonProperty("createdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "createdate", notes = "创建时间")
    private Date createDate;

    /**
     * 最后修改时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonProperty("updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "updatedate", notes = "最后修改时间")
    private Date updateDate;

    /**
     * 人员状态
     */
    @DEField(name = "state" , defaultValue = "1")
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(value = "state", notes = "人员状态")
    private String state;

    /**
     * 消息类型
     */
    @DEField(name = "msgtype" , defaultValue = "0")
    @JsonProperty("msgtype")
    @JSONField(name = "msgtype")
    @ApiModelProperty(value = "msgtype", notes = "消息类型")
    private Integer msgType;

    /**
     * 钉钉用户标识
     */
    @DEField(name = "ddunionid")
    @JsonProperty("ddunionid")
    @JSONField(name = "ddunionid")
    @ApiModelProperty(value = "ddunionid", notes = "钉钉用户标识")
    private String ddUnionId;

    /**
     * UAA用户标识
     */
    @DEField(name = "uaauserid")
    @JsonProperty("uaauserid")
    @JSONField(name = "uaauserid")
    @ApiModelProperty(value = "uaauserid", notes = "UAA用户标识")
    private String uaaUserId;

    /**
     * 微信用户标识
     */
    @DEField(name = "wxworkunionid")
    @JsonProperty("wxworkunionid")
    @JSONField(name = "wxworkunionid")
    @ApiModelProperty(value = "wxworkunionid", notes = "微信用户标识")
    private String wxWorkUnionId;

    /**
     * 企业微信用户标识
     */
    @DEField(name = "wxworkuserid")
    @JsonProperty("wxworkuserid")
    @JSONField(name = "wxworkuserid")
    @ApiModelProperty(value = "wxworkuserid", notes = "企业微信用户标识")
    private String wxWorkUserId;

    /**
     * 钉钉用户标识
     */
    @DEField(name = "dduserid")
    @JsonProperty("dduserid")
    @JSONField(name = "dduserid")
    @ApiModelProperty(value = "dduserid", notes = "钉钉用户标识")
    private String ddUserId;

    /**
     * 设置 [用户全局名]
     */
    public SysEmployee setUserName(String userName) {
        this.userName = userName;
        this.modify("username", userName);
        return this;
    }

    /**
     * 设置 [姓名]
     */
    public SysEmployee setPersonName(String personName) {
        this.personName = personName;
        this.modify("personname", personName);
        return this;
    }

    /**
     * 设置 [用户工号]
     */
    public SysEmployee setUserCode(String userCode) {
        this.userCode = userCode;
        this.modify("usercode", userCode);
        return this;
    }

    /**
     * 设置 [登录名]
     */
    public SysEmployee setLoginName(String loginName) {
        this.loginName = loginName;
        this.modify("loginname", loginName);
        return this;
    }

    /**
     * 设置 [密码]
     */
    public SysEmployee setPassword(String password) {
        this.password = password;
        this.modify("password", password);
        return this;
    }

    /**
     * 设置 [区属]
     */
    public SysEmployee setDomains(String domains) {
        this.domains = domains;
        this.modify("domains", domains);
        return this;
    }

    /**
     * 设置 [主部门]
     */
    public SysEmployee setMDeptId(String mDeptId) {
        this.mDeptId = mDeptId;
        this.modify("mdeptid", mDeptId);
        return this;
    }

    /**
     * 设置 [主部门名称]
     */
    public SysEmployee setMDeptName(String mDeptName) {
        this.mDeptName = mDeptName;
        this.modify("mdeptname", mDeptName);
        return this;
    }

    /**
     * 设置 [业务编码]
     */
    public SysEmployee setBCode(String bCode) {
        this.bCode = bCode;
        this.modify("bcode", bCode);
        return this;
    }

    /**
     * 设置 [岗位标识]
     */
    public SysEmployee setPostId(String postId) {
        this.postId = postId;
        this.modify("postid", postId);
        return this;
    }

    /**
     * 设置 [岗位名称]
     */
    public SysEmployee setPostName(String postName) {
        this.postName = postName;
        this.modify("postname", postName);
        return this;
    }

    /**
     * 设置 [昵称别名]
     */
    public SysEmployee setNickName(String nickName) {
        this.nickName = nickName;
        this.modify("nickname", nickName);
        return this;
    }

    /**
     * 设置 [性别]
     */
    public SysEmployee setSex(String sex) {
        this.sex = sex;
        this.modify("sex", sex);
        return this;
    }

    /**
     * 设置 [证件号码]
     */
    public SysEmployee setCertCode(String certCode) {
        this.certCode = certCode;
        this.modify("certcode", certCode);
        return this;
    }

    /**
     * 设置 [手机号]
     */
    public SysEmployee setPhone(String phone) {
        this.phone = phone;
        this.modify("phone", phone);
        return this;
    }

    /**
     * 设置 [出生日期]
     */
    public SysEmployee setBirthday(Date birthday) {
        this.birthday = birthday;
        this.modify("birthday", birthday);
        return this;
    }

    /**
     * 设置 [邮件]
     */
    public SysEmployee setEmail(String email) {
        this.email = email;
        this.modify("email", email);
        return this;
    }

    /**
     * 设置 [社交账号]
     */
    public SysEmployee setAvatar(String avatar) {
        this.avatar = avatar;
        this.modify("avatar", avatar);
        return this;
    }

    /**
     * 设置 [地址]
     */
    public SysEmployee setAddr(String addr) {
        this.addr = addr;
        this.modify("addr", addr);
        return this;
    }

    /**
     * 设置 [照片]
     */
    public SysEmployee setUserIcon(String userIcon) {
        this.userIcon = userIcon;
        this.modify("usericon", userIcon);
        return this;
    }

    /**
     * 设置 [ip地址]
     */
    public SysEmployee setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        this.modify("ipaddr", ipAddr);
        return this;
    }

    /**
     * 设置 [样式]
     */
    public SysEmployee setTheme(String theme) {
        this.theme = theme;
        this.modify("theme", theme);
        return this;
    }

    /**
     * 设置 [语言]
     */
    public SysEmployee setLang(String lang) {
        this.lang = lang;
        this.modify("lang", lang);
        return this;
    }

    /**
     * 设置 [字号]
     */
    public SysEmployee setFontSize(String fontSize) {
        this.fontSize = fontSize;
        this.modify("fontsize", fontSize);
        return this;
    }

    /**
     * 设置 [备注]
     */
    public SysEmployee setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
        return this;
    }

    /**
     * 设置 [保留18]
     */
    public SysEmployee setReserver18(BigDecimal reserver18) {
        this.reserver18 = reserver18;
        this.modify("reserver18", reserver18);
        return this;
    }

    /**
     * 设置 [保留17]
     */
    public SysEmployee setReserver17(BigDecimal reserver17) {
        this.reserver17 = reserver17;
        this.modify("reserver17", reserver17);
        return this;
    }

    /**
     * 设置 [保留12]
     */
    public SysEmployee setReserver12(Integer reserver12) {
        this.reserver12 = reserver12;
        this.modify("reserver12", reserver12);
        return this;
    }

    /**
     * 设置 [保留15]
     */
    public SysEmployee setReserver15(BigDecimal reserver15) {
        this.reserver15 = reserver15;
        this.modify("reserver15", reserver15);
        return this;
    }

    /**
     * 设置 [保留16]
     */
    public SysEmployee setReserver16(BigDecimal reserver16) {
        this.reserver16 = reserver16;
        this.modify("reserver16", reserver16);
        return this;
    }

    /**
     * 设置 [保留13]
     */
    public SysEmployee setReserver13(Integer reserver13) {
        this.reserver13 = reserver13;
        this.modify("reserver13", reserver13);
        return this;
    }

    /**
     * 设置 [保留11]
     */
    public SysEmployee setReserver11(Integer reserver11) {
        this.reserver11 = reserver11;
        this.modify("reserver11", reserver11);
        return this;
    }

    /**
     * 设置 [保留14]
     */
    public SysEmployee setReserver14(Integer reserver14) {
        this.reserver14 = reserver14;
        this.modify("reserver14", reserver14);
        return this;
    }

    /**
     * 设置 [保留7]
     */
    public SysEmployee setReserver7(String reserver7) {
        this.reserver7 = reserver7;
        this.modify("reserver7", reserver7);
        return this;
    }

    /**
     * 设置 [保留4]
     */
    public SysEmployee setReserver4(String reserver4) {
        this.reserver4 = reserver4;
        this.modify("reserver4", reserver4);
        return this;
    }

    /**
     * 设置 [保留2]
     */
    public SysEmployee setReserver2(String reserver2) {
        this.reserver2 = reserver2;
        this.modify("reserver2", reserver2);
        return this;
    }

    /**
     * 设置 [保留5]
     */
    public SysEmployee setReserver5(String reserver5) {
        this.reserver5 = reserver5;
        this.modify("reserver5", reserver5);
        return this;
    }

    /**
     * 设置 [保留6]
     */
    public SysEmployee setReserver6(String reserver6) {
        this.reserver6 = reserver6;
        this.modify("reserver6", reserver6);
        return this;
    }

    /**
     * 设置 [保留3]
     */
    public SysEmployee setReserver3(String reserver3) {
        this.reserver3 = reserver3;
        this.modify("reserver3", reserver3);
        return this;
    }

    /**
     * 设置 [保留8]
     */
    public SysEmployee setReserver8(String reserver8) {
        this.reserver8 = reserver8;
        this.modify("reserver8", reserver8);
        return this;
    }

    /**
     * 设置 [保留]
     */
    public SysEmployee setReserver(String reserver) {
        this.reserver = reserver;
        this.modify("reserver", reserver);
        return this;
    }

    /**
     * 设置 [保留19]
     */
    public SysEmployee setReserver19(Date reserver19) {
        this.reserver19 = reserver19;
        this.modify("reserver19", reserver19);
        return this;
    }

    /**
     * 设置 [保留20]
     */
    public SysEmployee setReserver20(Date reserver20) {
        this.reserver20 = reserver20;
        this.modify("reserver20", reserver20);
        return this;
    }

    /**
     * 设置 [保留10]
     */
    public SysEmployee setReserver10(String reserver10) {
        this.reserver10 = reserver10;
        this.modify("reserver10", reserver10);
        return this;
    }

    /**
     * 设置 [保留9]
     */
    public SysEmployee setReserver9(String reserver9) {
        this.reserver9 = reserver9;
        this.modify("reserver9", reserver9);
        return this;
    }

    /**
     * 设置 [排序]
     */
    public SysEmployee setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
        this.modify("showorder", showOrder);
        return this;
    }

    /**
     * 设置 [管理员]
     */
    public SysEmployee setSuperUser(Integer superUser) {
        this.superUser = superUser;
        this.modify("superuser", superUser);
        return this;
    }

    /**
     * 设置 [人员状态]
     */
    public SysEmployee setState(String state) {
        this.state = state;
        this.modify("state", state);
        return this;
    }

    /**
     * 设置 [消息类型]
     */
    public SysEmployee setMsgType(Integer msgType) {
        this.msgType = msgType;
        this.modify("msgtype", msgType);
        return this;
    }

    /**
     * 设置 [钉钉用户标识]
     */
    public SysEmployee setDdUnionId(String ddUnionId) {
        this.ddUnionId = ddUnionId;
        this.modify("ddunionid", ddUnionId);
        return this;
    }

    /**
     * 设置 [UAA用户标识]
     */
    public SysEmployee setUaaUserId(String uaaUserId) {
        this.uaaUserId = uaaUserId;
        this.modify("uaauserid", uaaUserId);
        return this;
    }

    /**
     * 设置 [微信用户标识]
     */
    public SysEmployee setWxWorkUnionId(String wxWorkUnionId) {
        this.wxWorkUnionId = wxWorkUnionId;
        this.modify("wxworkunionid", wxWorkUnionId);
        return this;
    }

    /**
     * 设置 [企业微信用户标识]
     */
    public SysEmployee setWxWorkUserId(String wxWorkUserId) {
        this.wxWorkUserId = wxWorkUserId;
        this.modify("wxworkuserid", wxWorkUserId);
        return this;
    }

    /**
     * 设置 [钉钉用户标识]
     */
    public SysEmployee setDdUserId(String ddUserId) {
        this.ddUserId = ddUserId;
        this.modify("dduserid", ddUserId);
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
            entity.reset("userid");
        }
        return targetEntity;
    }

}