/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.DynaAppmenuSearchContext;
import cn.ibizlab.plm.serviceapi.dto.DynaAppmenuFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 动态应用菜单转换过滤[DynaAppmenuFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDynaAppmenuFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DynaAppmenuFilterDTOMapping extends MappingBase<DynaAppmenuFilterDTO, DynaAppmenuSearchContext> {

}
