/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.filter.DiscussReplySearchContext;
import cn.ibizlab.plm.serviceapi.dto.DiscussReplyFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 讨论回复转换过滤[DiscussReplyFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussReplyFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussReplyFilterDTOMapping extends MappingBase<DiscussReplyFilterDTO, DiscussReplySearchContext> {

}
