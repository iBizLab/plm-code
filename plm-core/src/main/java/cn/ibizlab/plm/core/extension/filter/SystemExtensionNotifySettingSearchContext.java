/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/filter/{{entities@ServiceAPI}}SearchContext.java.hbs
 */
package cn.ibizlab.plm.core.extension.filter;

import java.util.*;
import cn.ibizlab.util.filter.SearchContextBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import cn.ibizlab.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.plm.core.extension.domain.SystemExtensionNotifySetting;

/**
 * 关系型数据实体[SystemExtensionNotifySetting] 查询条件对象
 *
 * @author generator
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("通知设置查询条件对象")
public class SystemExtensionNotifySettingSearchContext extends SearchContextBase {

    /**
     * 所有者类型EQ
     */
    @JsonProperty("n_owner_type_eq")
    @JSONField(name = "n_owner_type_eq")
    @ApiModelProperty("所有者类型EQ")
    private String ownerTypeEQ;

    /**
     * 所有者标识EQ
     */
    @JsonProperty("n_owner_id_eq")
    @JSONField(name = "n_owner_id_eq")
    @ApiModelProperty("所有者标识EQ")
    private String ownerIdEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty("标识EQ")
    private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty("名称LIKE")
    private String nameLIKE;

    /**
     * 系统标记EQ
     */
    @JsonProperty("n_system_tag_eq")
    @JSONField(name = "n_system_tag_eq")
    @ApiModelProperty("系统标记EQ")
    private String systemTagEQ;


    @Override
    public void setQuery(String query) {
	this.query=query;
    }
}