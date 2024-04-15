/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.DeliverableSearchContext;
import cn.ibizlab.plm.serviceapi.dto.DeliverableFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 交付物转换过滤[DeliverableFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDeliverableFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DeliverableFilterDTOMapping extends MappingBase<DeliverableFilterDTO, DeliverableSearchContext> {

}
