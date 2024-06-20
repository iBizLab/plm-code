/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.domain;

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
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.domain.TicketType;

/**
 * 产品工单类型实体类[ProductTicketType]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "PRODUCT_TICKET_TYPE", resultMap = "ProductTicketTypeResultMap")
@ApiModel(value = "PRODUCT_TICKET_TYPE", description = "产品工单类型")
public class ProductTicketType extends EntityMP implements Serializable
{

    /**
    * 描述
    */
    @TableField(value = "description" , exist = false)
    @DEField(name = "description")
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty(value = "description", notes = "描述")
    private String description;

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
    * 名称
    */
    @TableField(value = "ticket_type_name" , exist = false)
    @DEField(name = "ticket_type_name")
    @JSONField(name = "ticket_type_name")
    @JsonProperty("ticket_type_name")
    @ApiModelProperty(value = "ticket_type_name", notes = "名称")
    private String ticketTypeName;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 工单类型标识
    */
    @TableField(value = "ticket_type_id")
    @DEField(name = "ticket_type_id")
    @JSONField(name = "ticket_type_id")
    @JsonProperty("ticket_type_id")
    @ApiModelProperty(value = "ticket_type_id", notes = "工单类型标识")
    private String ticketTypeId;

    /**
    * 产品标识
    */
    @TableField(value = "product_id")
    @DEField(name = "product_id")
    @JSONField(name = "product_id")
    @JsonProperty("product_id")
    @ApiModelProperty(value = "product_id", notes = "产品标识")
    private String productId;

    /**
    * 产品
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "product", notes = "产品")
    private Product product;

    /**
    * 工单类型
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "ticket_type", notes = "工单类型")
    private TicketType ticketType;

    /**
    * 设置 [描述]
    */
    public ProductTicketType setDescription(String description) {
        this.description = description;
        this.modify("description", description);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public ProductTicketType setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
        this.modify("ticket_type_name", ticketTypeName);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public ProductTicketType setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [工单类型标识]
    */
    public ProductTicketType setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
        this.modify("ticket_type_id", ticketTypeId);
        return this;
    }

    /**
    * 设置 [产品标识]
    */
    public ProductTicketType setProductId(String productId) {
        this.productId = productId;
        this.modify("product_id", productId);
        return this;
    }


    @Override
    public Serializable getDefaultKey(boolean gen) {
        //Assert.notNull(getProductId(),"未设置产品标识");
        //Assert.notNull(getTicketTypeId(),"未设置工单类型标识");
        String key = String.format("%s||%s"
            ,getProductId(),getTicketTypeId());
        key = DigestUtils.md5DigestAsHex(key.getBytes());
        return key;
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