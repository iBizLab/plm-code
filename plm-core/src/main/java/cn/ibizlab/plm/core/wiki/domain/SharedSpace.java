/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{domains@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.wiki.domain;

import java.util.*;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;

/**
 * 共享空间实体类[SharedSpace]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "SPACE", resultMap = "SharedSpaceResultMap")
@ApiModel(value = "SHARED_SPACE", description = "共享空间")
public class SharedSpace extends EntityMP implements Serializable
{

    /**
    * 是否开启共享
    */
    @TableField(value = "is_shared")
    @DEField(name = "is_shared" , defaultValue = "0" , dict = "space_shared_status")
    @JSONField(name = "is_shared")
    @JsonProperty("is_shared")
    @ApiModelProperty(value = "is_shared", notes = "是否开启共享")
    private String isShared;

    /**
    * 共享页面标识
    */
    @TableField(value = "shared_pages")
    @DEField(name = "shared_pages" , dict = "shared_pages")
    @JSONField(name = "shared_pages")
    @JsonProperty("shared_pages")
    @ApiModelProperty(value = "shared_pages", notes = "共享页面标识")
    private String sharedPages;

    /**
    * 共享有效期
    */
    @TableField(value = "expiration_date")
    @DEField(name = "expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "expiration_date" , format = "yyyy-MM-dd")
    @JsonProperty("expiration_date")
    @ApiModelProperty(value = "expiration_date", notes = "共享有效期")
    private Date expirationDate;

    /**
    * 访问密码
    */
    @TableField(value = "access_password")
    @DEField(name = "access_password")
    @JSONField(name = "access_password")
    @JsonProperty("access_password")
    @ApiModelProperty(value = "access_password", notes = "访问密码")
    private String accessPassword;

    /**
    * 共享展示标题
    */
    @TableField(value = "show_title")
    @DEField(name = "show_title")
    @JSONField(name = "show_title")
    @JsonProperty("show_title")
    @ApiModelProperty(value = "show_title", notes = "共享展示标题")
    private String showTitle;

    /**
    * 共享展示图标
    */
    @TableField(value = "show_logo")
    @DEField(name = "show_logo")
    @JSONField(name = "show_logo")
    @JsonProperty("show_logo")
    @ApiModelProperty(value = "show_logo", notes = "共享展示图标")
    private String showLogo;

    /**
    * 所属
    */
    @TableField(value = "scope_type")
    @DEField(name = "scope_type" , dict = "user_scope_type")
    @JSONField(name = "scope_type")
    @JsonProperty("scope_type")
    @ApiModelProperty(value = "scope_type", notes = "所属")
    private String scopeType;

    /**
    * 共享人
    */
    @TableField(value = "shared_by")
    @DEField(name = "shared_by")
    @JSONField(name = "shared_by")
    @JsonProperty("shared_by")
    @ApiModelProperty(value = "shared_by", notes = "共享人")
    private String sharedBy;

    /**
    * 共享时间
    */
    @TableField(value = "shared_time")
    @DEField(name = "shared_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "shared_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("shared_time")
    @ApiModelProperty(value = "shared_time", notes = "共享时间")
    private Date sharedTime;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 空间名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "空间名称")
    private String name;

    /**
    * 设置 [是否开启共享]
    */
    public SharedSpace setIsShared(String isShared) {
        this.isShared = isShared;
        this.modify("is_shared", isShared);
        return this;
    }

    /**
    * 设置 [共享页面标识]
    */
    public SharedSpace setSharedPages(String sharedPages) {
        this.sharedPages = sharedPages;
        this.modify("shared_pages", sharedPages);
        return this;
    }

    /**
    * 设置 [共享有效期]
    */
    public SharedSpace setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        this.modify("expiration_date", expirationDate);
        return this;
    }

    /**
    * 设置 [访问密码]
    */
    public SharedSpace setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
        this.modify("access_password", accessPassword);
        return this;
    }

    /**
    * 设置 [共享展示标题]
    */
    public SharedSpace setShowTitle(String showTitle) {
        this.showTitle = showTitle;
        this.modify("show_title", showTitle);
        return this;
    }

    /**
    * 设置 [共享展示图标]
    */
    public SharedSpace setShowLogo(String showLogo) {
        this.showLogo = showLogo;
        this.modify("show_logo", showLogo);
        return this;
    }

    /**
    * 设置 [所属]
    */
    public SharedSpace setScopeType(String scopeType) {
        this.scopeType = scopeType;
        this.modify("scope_type", scopeType);
        return this;
    }

    /**
    * 设置 [共享人]
    */
    public SharedSpace setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
        this.modify("shared_by", sharedBy);
        return this;
    }

    /**
    * 设置 [共享时间]
    */
    public SharedSpace setSharedTime(Date sharedTime) {
        this.sharedTime = sharedTime;
        this.modify("shared_time", sharedTime);
        return this;
    }

    /**
    * 设置 [空间名称]
    */
    public SharedSpace setName(String name) {
        this.name = name;
        this.modify("name", name);
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
            entity.reset("id");
        }
        return targetEntity;
    }

}