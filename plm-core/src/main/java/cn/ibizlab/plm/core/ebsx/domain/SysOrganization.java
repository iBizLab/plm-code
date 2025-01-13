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
 * 组织实体类[SysOrganization]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@ApiModel(value = "SYS_ORG", description = "组织")
public class SysOrganization extends EntityClient implements Serializable
{

    /**
     * 上级单位
     */
    @DEField(name = "porgid")
    @JSONField(name = "parentorgid")
    @JsonProperty("parentorgid")
    @ApiModelProperty(value = "porgid", notes = "上级单位")
    private String parentOrgId;

    /**
     * 上级单位
     */
    @DEField(name = "porgname")
    @JSONField(name = "parentorgname")
    @JsonProperty("parentorgname")
    @ApiModelProperty(value = "porgname", notes = "上级单位")
    private String parentOrgName;

    /**
     * 单位标识
     */
    @Id
    @DEField(name = "orgid" , isKeyField = true)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    @ApiModelProperty(value = "orgid", notes = "单位标识")
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
     * 属性
     */
    @DEField(name = "updatedate" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty(value = "updatedate", notes = "属性")
    private Date updateDate;

    /**
     * 排序
     */
    @DEField(name = "showorder")
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    @ApiModelProperty(value = "showorder", notes = "排序")
    private Integer showOrder;

    /**
     * 启用标识
     */
    @DEField(name = "isvalid" , dict = "YesNo")
    @JSONField(name = "isvalid")
    @JsonProperty("isvalid")
    @ApiModelProperty(value = "isvalid", notes = "启用标识")
    private Integer isValid;

    /**
     * 单位简称
     */
    @DEField(name = "shortname")
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    @ApiModelProperty(value = "shortname", notes = "单位简称")
    private String shortName;

    /**
     * 名称
     */
    @DEField(name = "orgname" , preType = DEPredefinedFieldType.ORGNAME)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    @ApiModelProperty(value = "orgname", notes = "名称")
    private String orgName;

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
     * 单位编码
     */
    @DEField(name = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    @ApiModelProperty(value = "orgcode", notes = "单位编码")
    private String orgCode;

    /**
     * 
     */
    @DEField()
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "parentorg", notes = "")
    private SysOrganization parentOrg;

    /**
    * 设置 [上级单位]
    */
    public SysOrganization setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
        this.modify("parentorgid", parentOrgId);
        return this;
    }

    /**
    * 设置 [上级单位]
    */
    public SysOrganization setParentOrgName(String parentOrgName) {
        this.parentOrgName = parentOrgName;
        this.modify("parentorgname", parentOrgName);
        return this;
    }

    /**
    * 设置 [排序]
    */
    public SysOrganization setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
        this.modify("showorder", showOrder);
        return this;
    }

    /**
    * 设置 [启用标识]
    */
    public SysOrganization setIsValid(Integer isValid) {
        this.isValid = isValid;
        this.modify("isvalid", isValid);
        return this;
    }

    /**
    * 设置 [单位简称]
    */
    public SysOrganization setShortName(String shortName) {
        this.shortName = shortName;
        this.modify("shortname", shortName);
        return this;
    }

    /**
    * 设置 [单位编码]
    */
    public SysOrganization setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        this.modify("orgcode", orgCode);
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
            entity.reset("orgid");
        }
        return targetEntity;
    }

}