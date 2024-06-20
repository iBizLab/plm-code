/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.DynaAppmenu;
import cn.ibizlab.plm.serviceapi.dto.DynaAppmenuDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 动态应用菜单转换[DynaAppmenuDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDynaAppmenuDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DynaAppmenuDTOMapping extends MappingBase<DynaAppmenuDTO, DynaAppmenu> {


}
