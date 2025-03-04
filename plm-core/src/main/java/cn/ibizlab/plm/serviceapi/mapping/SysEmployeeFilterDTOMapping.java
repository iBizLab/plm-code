/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.filter.SysEmployeeSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SysEmployeeFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 人员转换过滤[SysEmployeeFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISysEmployeeFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysEmployeeFilterDTOMapping extends MappingBase<SysEmployeeFilterDTO, SysEmployeeSearchContext> {

}
