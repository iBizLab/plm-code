/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.serviceapi.dto.TicketAdvancedSearchDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工单转换[TicketAdvancedSearchDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITicketAdvancedSearchDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TicketAdvancedSearchDTOMapping extends MappingBase<TicketAdvancedSearchDTO, Ticket> {


}
