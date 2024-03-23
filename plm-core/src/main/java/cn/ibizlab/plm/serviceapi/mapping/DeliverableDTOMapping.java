/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.serviceapi.dto.DeliverableDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 交付物转换[DeliverableDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDeliverableDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DeliverableDTOMapping extends MappingBase<DeliverableDTO, Deliverable> {


}
