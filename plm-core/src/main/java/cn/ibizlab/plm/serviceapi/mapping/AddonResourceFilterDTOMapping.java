/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.AddonResourceSearchContext;
import cn.ibizlab.plm.serviceapi.dto.AddonResourceFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 资源组件转换过滤[AddonResourceFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAddonResourceFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddonResourceFilterDTOMapping extends MappingBase<AddonResourceFilterDTO, AddonResourceSearchContext> {

}
