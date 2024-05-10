/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.ParameterSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ParameterFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 系统参数转换过滤[ParameterFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIParameterFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParameterFilterDTOMapping extends MappingBase<ParameterFilterDTO, ParameterSearchContext> {

}
