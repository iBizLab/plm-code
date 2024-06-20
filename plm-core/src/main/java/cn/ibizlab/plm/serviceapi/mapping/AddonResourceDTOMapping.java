/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.AddonResource;
import cn.ibizlab.plm.serviceapi.dto.AddonResourceDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 资源组件转换[AddonResourceDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAddonResourceDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddonResourceDTOMapping extends MappingBase<AddonResourceDTO, AddonResource> {


}
