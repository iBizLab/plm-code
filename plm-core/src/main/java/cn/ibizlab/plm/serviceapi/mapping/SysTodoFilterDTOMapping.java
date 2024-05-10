/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.filter.SysTodoSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SysTodoFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 待办转换过滤[SysTodoFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISysTodoFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysTodoFilterDTOMapping extends MappingBase<SysTodoFilterDTO, SysTodoSearchContext> {

}
