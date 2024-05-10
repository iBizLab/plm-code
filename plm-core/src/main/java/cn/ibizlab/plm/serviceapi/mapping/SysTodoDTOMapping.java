/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.domain.SysTodo;
import cn.ibizlab.plm.serviceapi.dto.SysTodoDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 待办转换[SysTodoDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISysTodoDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysTodoDTOMapping extends MappingBase<SysTodoDTO, SysTodo> {


}
