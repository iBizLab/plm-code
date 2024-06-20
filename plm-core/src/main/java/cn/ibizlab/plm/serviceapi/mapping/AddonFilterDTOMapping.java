/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.AddonSearchContext;
import cn.ibizlab.plm.serviceapi.dto.AddonFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 组件转换过滤[AddonFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAddonFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddonFilterDTOMapping extends MappingBase<AddonFilterDTO, AddonSearchContext> {

}
