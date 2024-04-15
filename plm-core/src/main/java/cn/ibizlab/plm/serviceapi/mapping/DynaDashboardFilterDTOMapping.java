/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext;
import cn.ibizlab.plm.serviceapi.dto.DynaDashboardFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 动态数据看板转换过滤[DynaDashboardFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDynaDashboardFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DynaDashboardFilterDTOMapping extends MappingBase<DynaDashboardFilterDTO, DynaDashboardSearchContext> {

}
