/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.domain.Ticket;
import cn.ibizlab.plm.serviceapi.dto.Ticketadvanced_searchDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工单转换[Ticketadvanced_searchDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITicketadvanced_searchDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface Ticketadvanced_searchDTOMapping extends MappingBase<Ticketadvanced_searchDTO, Ticket> {


}
