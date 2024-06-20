/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.AddonRoleMemberSearchContext;
import cn.ibizlab.plm.serviceapi.dto.AddonRoleMemberFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 组件权限成员转换过滤[AddonRoleMemberFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAddonRoleMemberFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddonRoleMemberFilterDTOMapping extends MappingBase<AddonRoleMemberFilterDTO, AddonRoleMemberSearchContext> {

}
