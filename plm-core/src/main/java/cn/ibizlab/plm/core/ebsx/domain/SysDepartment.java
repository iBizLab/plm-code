/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@ServiceAPI}}.java.hbs
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
 * 部门实体类[SysDepartment]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_DEPT", description = "部门")
public class SysDepartment extends EntityClient implements Serializable
{

    /**
     * 部门标识
     */
    @Id
    @DEField(name = "deptid" , isKeyField = true)
    @JSONField(name = "deptid")
    @JsonProperty("deptid")
    @ApiModelProperty(value = "deptid", notes = "部门标识")
    private String deptId;

    /**
     * 部门代码
     */
    @DEField(name = "deptcode")
    @JSONField(name = "deptcode")
    @JsonProperty("deptcode")
    @ApiModelProperty(value = "deptcode", notes = "部门代码")
    private String deptCode;

    /**
     * 部门名称
     */
    @DEField(name = "deptname")
    @JSONField(name = "deptname")
    @JsonProperty("deptname")
    @ApiModelProperty(value = "deptname", notes = "部门名称")
    private String deptName;

    /**
     * 上级部门
     */
    @DEField(name = "pdeptid")
    @JSONField(name = "parentdeptid")
    @JsonProperty("parentdeptid")
    @ApiModelProperty(value = "pdeptid", notes = "上级部门")
    private String parentDeptId;

    /**
     * 部门简称
     */
    @DEField(name = "shortname")
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    @ApiModelProperty(value = "shortname", notes = "部门简称")
    private String shortName;

    /**
     * 部门级别
     */
    @DEField(name = "deptlevel")
    @JSONField(name = "deptlevel")
    @JsonProperty("deptlevel")
    @ApiModelProperty(value = "deptlevel", notes = "部门级别")
    private Integer deptLevel;

    /**
     * 区属
     */
    @DEField(name = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    @ApiModelProperty(value = "domains", notes = "区属")
    private String domains;

    /**
     * 排序
     */
    @DEField(name = "showorder")
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    @ApiModelProperty(value = "showorder", notes = "排序")
    private Integer showOrder;

    /**
     * 业务编码
     */
    @DEField(name = "bcode")
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    @ApiModelProperty(value = "bcode", notes = "业务编码")
    private String bCode;

    /**
     * 分管领导标识
     */
    @DEField(name = "leaderid")
    @JSONField(name = "leaderid")
    @JsonProperty("leaderid")
    @ApiModelProperty(value = "leaderid", notes = "分管领导标识")
    private String leaderId;

    /**
     * 分管领导
     */
    @DEField(name = "leadername")
    @JSONField(name = "leadername")
    @JsonProperty("leadername")
    @ApiModelProperty(value = "leadername", notes = "分管领导")
    private String leaderName;

    /**
     * 单位
     */
    @DEField(name = "orgid" , preType = DEPredefinedFieldType.ORGID)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    @ApiModelProperty(value = "orgid", notes = "单位")
    private String orgId;

    /**
     * 逻辑有效
     */
    @DEField(name = "enable" , preType = DEPredefinedFieldType.LOGICVALID , logicval = "1" , logicdelval = "0")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    @ApiModelProperty(value = "enable", notes = "逻辑有效")
    private Integer enable;

    /**
     * 单位名称
     */
    @DEField(name = "orgname" , preType = DEPredefinedFieldType.ORGNAME)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    @ApiModelProperty(value = "orgname", notes = "单位名称")
    private String orgName;

    /**
     * 上级部门
     */
    @DEField(name = "pdeptname")
    @JSONField(name = "parentdeptname")
    @JsonProperty("parentdeptname")
    @ApiModelProperty(value = "pdeptname", notes = "上级部门")
    private String parentDeptName;

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
     * 更新时间
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "更新时间")
    private Date updateDate;

    /**
     * 保留18
     */
    @DEField(name = "reserver18")
    @JSONField(name = "reserver18")
    @JsonProperty("reserver18")
    @ApiModelProperty(value = "reserver18", notes = "保留18")
    private BigDecimal reserver18;

    /**
     * 保留17
     */
    @DEField(name = "reserver17")
    @JSONField(name = "reserver17")
    @JsonProperty("reserver17")
    @ApiModelProperty(value = "reserver17", notes = "保留17")
    private BigDecimal reserver17;

    /**
     * 保留12
     */
    @DEField(name = "reserver12")
    @JSONField(name = "reserver12")
    @JsonProperty("reserver12")
    @ApiModelProperty(value = "reserver12", notes = "保留12")
    private Integer reserver12;

    /**
     * 保留16
     */
    @DEField(name = "reserver16")
    @JSONField(name = "reserver16")
    @JsonProperty("reserver16")
    @ApiModelProperty(value = "reserver16", notes = "保留16")
    private BigDecimal reserver16;

    /**
     * 保留15
     */
    @DEField(name = "reserver15")
    @JSONField(name = "reserver15")
    @JsonProperty("reserver15")
    @ApiModelProperty(value = "reserver15", notes = "保留15")
    private BigDecimal reserver15;

    /**
     * 保留14
     */
    @DEField(name = "reserver14")
    @JSONField(name = "reserver14")
    @JsonProperty("reserver14")
    @ApiModelProperty(value = "reserver14", notes = "保留14")
    private Integer reserver14;

    /**
     * 保留13
     */
    @DEField(name = "reserver13")
    @JSONField(name = "reserver13")
    @JsonProperty("reserver13")
    @ApiModelProperty(value = "reserver13", notes = "保留13")
    private Integer reserver13;

    /**
     * 保留6
     */
    @DEField(name = "reserver6")
    @JSONField(name = "reserver6")
    @JsonProperty("reserver6")
    @ApiModelProperty(value = "reserver6", notes = "保留6")
    private String reserver6;

    /**
     * 保留11
     */
    @DEField(name = "reserver11")
    @JSONField(name = "reserver11")
    @JsonProperty("reserver11")
    @ApiModelProperty(value = "reserver11", notes = "保留11")
    private Integer reserver11;

    /**
     * 保留3
     */
    @DEField(name = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    @ApiModelProperty(value = "reserver3", notes = "保留3")
    private String reserver3;

    /**
     * 保留7
     */
    @DEField(name = "reserver7")
    @JSONField(name = "reserver7")
    @JsonProperty("reserver7")
    @ApiModelProperty(value = "reserver7", notes = "保留7")
    private String reserver7;

    /**
     * 保留4
     */
    @DEField(name = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    @ApiModelProperty(value = "reserver4", notes = "保留4")
    private String reserver4;

    /**
     * 保留
     */
    @DEField(name = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    @ApiModelProperty(value = "reserver", notes = "保留")
    private String reserver;

    /**
     * 保留8
     */
    @DEField(name = "reserver8")
    @JSONField(name = "reserver8")
    @JsonProperty("reserver8")
    @ApiModelProperty(value = "reserver8", notes = "保留8")
    private String reserver8;

    /**
     * 保留5
     */
    @DEField(name = "reserver5")
    @JSONField(name = "reserver5")
    @JsonProperty("reserver5")
    @ApiModelProperty(value = "reserver5", notes = "保留5")
    private String reserver5;

    /**
     * 保留2
     */
    @DEField(name = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    @ApiModelProperty(value = "reserver2", notes = "保留2")
    private String reserver2;

    /**
     * 保留20
     */
    @DEField(name = "reserver20")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "reserver20" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver20")
    @ApiModelProperty(value = "reserver20", notes = "保留20")
    private Date reserver20;

    /**
     * 保留19
     */
    @DEField(name = "reserver19")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "reserver19" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver19")
    @ApiModelProperty(value = "reserver19", notes = "保留19")
    private Date reserver19;

    /**
     * 保留10
     */
    @DEField(name = "reserver10")
    @JSONField(name = "reserver10")
    @JsonProperty("reserver10")
    @ApiModelProperty(value = "reserver10", notes = "保留10")
    private String reserver10;

    /**
     * 保留9
     */
    @DEField(name = "reserver9")
    @JSONField(name = "reserver9")
    @JsonProperty("reserver9")
    @ApiModelProperty(value = "reserver9", notes = "保留9")
    private String reserver9;

    /**
     * 企业微信部门标识
     */
    @DEField(name = "wxworkdeptid")
    @JSONField(name = "wxworkdeptid")
    @JsonProperty("wxworkdeptid")
    @ApiModelProperty(value = "wxworkdeptid", notes = "企业微信部门标识")
    private String wxWorkDeptId;

    /**
     * 部门全称
     */
    @DEField(name = "deptfullname")
    @JSONField(name = "deptfullname")
    @JsonProperty("deptfullname")
    @ApiModelProperty(value = "deptfullname", notes = "部门全称")
    private String deptFullName;

    /**
     * 部门领导
     */
    @DEField(name = "deptleader")
    @JSONField(name = "deptleader")
    @JsonProperty("deptleader")
    @ApiModelProperty(value = "deptleader", notes = "部门领导")
    private String deptLeader;

    /**
     * 部门领导标识
     */
    @DEField(name = "deptleaderid")
    @JSONField(name = "deptleaderid")
    @JsonProperty("deptleaderid")
    @ApiModelProperty(value = "deptleaderid", notes = "部门领导标识")
    private String deptLeaderId;

    /**
     * 钉钉部门标识
     */
    @DEField(name = "dddeptid")
    @JSONField(name = "dddeptid")
    @JsonProperty("dddeptid")
    @ApiModelProperty(value = "dddeptid", notes = "钉钉部门标识")
    private String ddDeptId;

    /**
     * 启用标志
     */
    @DEField(name = "isvalid" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "isvalid")
    @JsonProperty("isvalid")
    @ApiModelProperty(value = "isvalid", notes = "启用标志")
    private Integer isValid;

    /**
    * 设置 [部门代码]
    */
    public SysDepartment setDeptCode(String deptCode) {
        this.deptCode = deptCode;
        this.modify("deptcode", deptCode);
        return this;
    }

    /**
    * 设置 [部门名称]
    */
    public SysDepartment setDeptName(String deptName) {
        this.deptName = deptName;
        this.modify("deptname", deptName);
        return this;
    }

    /**
    * 设置 [上级部门]
    */
    public SysDepartment setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
        this.modify("parentdeptid", parentDeptId);
        return this;
    }

    /**
    * 设置 [部门简称]
    */
    public SysDepartment setShortName(String shortName) {
        this.shortName = shortName;
        this.modify("shortname", shortName);
        return this;
    }

    /**
    * 设置 [部门级别]
    */
    public SysDepartment setDeptLevel(Integer deptLevel) {
        this.deptLevel = deptLevel;
        this.modify("deptlevel", deptLevel);
        return this;
    }

    /**
    * 设置 [区属]
    */
    public SysDepartment setDomains(String domains) {
        this.domains = domains;
        this.modify("domains", domains);
        return this;
    }

    /**
    * 设置 [排序]
    */
    public SysDepartment setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
        this.modify("showorder", showOrder);
        return this;
    }

    /**
    * 设置 [业务编码]
    */
    public SysDepartment setBCode(String bCode) {
        this.bCode = bCode;
        this.modify("bcode", bCode);
        return this;
    }

    /**
    * 设置 [分管领导标识]
    */
    public SysDepartment setLeaderId(String leaderId) {
        this.leaderId = leaderId;
        this.modify("leaderid", leaderId);
        return this;
    }

    /**
    * 设置 [分管领导]
    */
    public SysDepartment setLeaderName(String leaderName) {
        this.leaderName = leaderName;
        this.modify("leadername", leaderName);
        return this;
    }

    /**
    * 设置 [上级部门]
    */
    public SysDepartment setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
        this.modify("parentdeptname", parentDeptName);
        return this;
    }

    /**
    * 设置 [保留18]
    */
    public SysDepartment setReserver18(BigDecimal reserver18) {
        this.reserver18 = reserver18;
        this.modify("reserver18", reserver18);
        return this;
    }

    /**
    * 设置 [保留17]
    */
    public SysDepartment setReserver17(BigDecimal reserver17) {
        this.reserver17 = reserver17;
        this.modify("reserver17", reserver17);
        return this;
    }

    /**
    * 设置 [保留12]
    */
    public SysDepartment setReserver12(Integer reserver12) {
        this.reserver12 = reserver12;
        this.modify("reserver12", reserver12);
        return this;
    }

    /**
    * 设置 [保留16]
    */
    public SysDepartment setReserver16(BigDecimal reserver16) {
        this.reserver16 = reserver16;
        this.modify("reserver16", reserver16);
        return this;
    }

    /**
    * 设置 [保留15]
    */
    public SysDepartment setReserver15(BigDecimal reserver15) {
        this.reserver15 = reserver15;
        this.modify("reserver15", reserver15);
        return this;
    }

    /**
    * 设置 [保留14]
    */
    public SysDepartment setReserver14(Integer reserver14) {
        this.reserver14 = reserver14;
        this.modify("reserver14", reserver14);
        return this;
    }

    /**
    * 设置 [保留13]
    */
    public SysDepartment setReserver13(Integer reserver13) {
        this.reserver13 = reserver13;
        this.modify("reserver13", reserver13);
        return this;
    }

    /**
    * 设置 [保留6]
    */
    public SysDepartment setReserver6(String reserver6) {
        this.reserver6 = reserver6;
        this.modify("reserver6", reserver6);
        return this;
    }

    /**
    * 设置 [保留11]
    */
    public SysDepartment setReserver11(Integer reserver11) {
        this.reserver11 = reserver11;
        this.modify("reserver11", reserver11);
        return this;
    }

    /**
    * 设置 [保留3]
    */
    public SysDepartment setReserver3(String reserver3) {
        this.reserver3 = reserver3;
        this.modify("reserver3", reserver3);
        return this;
    }

    /**
    * 设置 [保留7]
    */
    public SysDepartment setReserver7(String reserver7) {
        this.reserver7 = reserver7;
        this.modify("reserver7", reserver7);
        return this;
    }

    /**
    * 设置 [保留4]
    */
    public SysDepartment setReserver4(String reserver4) {
        this.reserver4 = reserver4;
        this.modify("reserver4", reserver4);
        return this;
    }

    /**
    * 设置 [保留]
    */
    public SysDepartment setReserver(String reserver) {
        this.reserver = reserver;
        this.modify("reserver", reserver);
        return this;
    }

    /**
    * 设置 [保留8]
    */
    public SysDepartment setReserver8(String reserver8) {
        this.reserver8 = reserver8;
        this.modify("reserver8", reserver8);
        return this;
    }

    /**
    * 设置 [保留5]
    */
    public SysDepartment setReserver5(String reserver5) {
        this.reserver5 = reserver5;
        this.modify("reserver5", reserver5);
        return this;
    }

    /**
    * 设置 [保留2]
    */
    public SysDepartment setReserver2(String reserver2) {
        this.reserver2 = reserver2;
        this.modify("reserver2", reserver2);
        return this;
    }

    /**
    * 设置 [保留20]
    */
    public SysDepartment setReserver20(Date reserver20) {
        this.reserver20 = reserver20;
        this.modify("reserver20", reserver20);
        return this;
    }

    /**
    * 设置 [保留19]
    */
    public SysDepartment setReserver19(Date reserver19) {
        this.reserver19 = reserver19;
        this.modify("reserver19", reserver19);
        return this;
    }

    /**
    * 设置 [保留10]
    */
    public SysDepartment setReserver10(String reserver10) {
        this.reserver10 = reserver10;
        this.modify("reserver10", reserver10);
        return this;
    }

    /**
    * 设置 [保留9]
    */
    public SysDepartment setReserver9(String reserver9) {
        this.reserver9 = reserver9;
        this.modify("reserver9", reserver9);
        return this;
    }

    /**
    * 设置 [企业微信部门标识]
    */
    public SysDepartment setWxWorkDeptId(String wxWorkDeptId) {
        this.wxWorkDeptId = wxWorkDeptId;
        this.modify("wxworkdeptid", wxWorkDeptId);
        return this;
    }

    /**
    * 设置 [部门全称]
    */
    public SysDepartment setDeptFullName(String deptFullName) {
        this.deptFullName = deptFullName;
        this.modify("deptfullname", deptFullName);
        return this;
    }

    /**
    * 设置 [部门领导]
    */
    public SysDepartment setDeptLeader(String deptLeader) {
        this.deptLeader = deptLeader;
        this.modify("deptleader", deptLeader);
        return this;
    }

    /**
    * 设置 [部门领导标识]
    */
    public SysDepartment setDeptLeaderId(String deptLeaderId) {
        this.deptLeaderId = deptLeaderId;
        this.modify("deptleaderid", deptLeaderId);
        return this;
    }

    /**
    * 设置 [钉钉部门标识]
    */
    public SysDepartment setDdDeptId(String ddDeptId) {
        this.ddDeptId = ddDeptId;
        this.modify("dddeptid", ddDeptId);
        return this;
    }

    /**
    * 设置 [启用标志]
    */
    public SysDepartment setIsValid(Integer isValid) {
        this.isValid = isValid;
        this.modify("isvalid", isValid);
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
            entity.reset("deptid");
        }
        return targetEntity;
    }

}