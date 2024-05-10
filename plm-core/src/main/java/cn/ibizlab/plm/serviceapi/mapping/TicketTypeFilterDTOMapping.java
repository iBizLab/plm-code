/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.filter.TicketTypeSearchContext;
import cn.ibizlab.plm.serviceapi.dto.TicketTypeFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工单类型转换过滤[TicketTypeFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITicketTypeFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TicketTypeFilterDTOMapping extends MappingBase<TicketTypeFilterDTO, TicketTypeSearchContext> {

}
