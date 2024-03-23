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
 * 文件夹成员[PortfolioMemberDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("文件夹成员DTO")
public class PortfolioMemberDTO extends DTOBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    @ApiModelProperty(value = "登录名", position = 0)
    private String userId;

    /**
     * 角色
     */
    @JsonProperty("role_id")
    @JSONField(name = "role_id")
    @ApiModelProperty(value = "角色", position = 1)
    private String roleId;

    /**
     * 文件夹名称
     */
    @JsonProperty("portfolio_name")
    @JSONField(name = "portfolio_name")
    @ApiModelProperty(value = "文件夹名称", position = 2)
    private String portfolioName;

    /**
     * 文件夹标识
     */
    @JsonProperty("portfolio_identifier")
    @JSONField(name = "portfolio_identifier")
    @ApiModelProperty(value = "文件夹标识", position = 3)
    private String portfolioIdentifier;

    /**
     * 建立人
     */
    @JsonProperty("create_man")
    @JSONField(name = "create_man")
    @ApiModelProperty(value = "建立人", position = 4)
    private String createMan;

    /**
     * 建立时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "建立时间", position = 5)
    private Date createTime;

    /**
     * 标识
     */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(value = "标识", position = 6)
    private String id;

    /**
     * 姓名
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(value = "姓名", position = 7)
    private String name;

    /**
     * 文件夹标识
     */
    @JsonProperty("portfolio_id")
    @JSONField(name = "portfolio_id")
    @ApiModelProperty(value = "文件夹标识", position = 8)
    private String portfolioId;

    /**
     * 更新人
     */
    @JsonProperty("update_man")
    @JSONField(name = "update_man")
    @ApiModelProperty(value = "更新人", position = 9)
    private String updateMan;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", position = 10)
    private Date updateTime;


    /**
     * 设置 [登录名]
     */
    public PortfolioMemberDTO setUserId(String userId) {
        this.userId = userId;
        this.modify("user_id", userId);
        return this;
    }

    /**
     * 设置 [角色]
     */
    public PortfolioMemberDTO setRoleId(String roleId) {
        this.roleId = roleId;
        this.modify("role_id", roleId);
        return this;
    }

    /**
     * 设置 [文件夹名称]
     */
    public PortfolioMemberDTO setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
        this.modify("portfolio_name", portfolioName);
        return this;
    }

    /**
     * 设置 [文件夹标识]
     */
    public PortfolioMemberDTO setPortfolioIdentifier(String portfolioIdentifier) {
        this.portfolioIdentifier = portfolioIdentifier;
        this.modify("portfolio_identifier", portfolioIdentifier);
        return this;
    }

    /**
     * 设置 [姓名]
     */
    public PortfolioMemberDTO setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
     * 设置 [文件夹标识]
     */
    public PortfolioMemberDTO setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
        this.modify("portfolio_id", portfolioId);
        return this;
    }


}
