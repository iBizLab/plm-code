/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSCorePrd;
import cn.ibizlab.plm.serviceapi.dto.PSCorePrdDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 核心产品转换[PSCorePrdDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSCorePrdDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSCorePrdDTOMapping extends MappingBase<PSCorePrdDTO, PSCorePrd> {


}
