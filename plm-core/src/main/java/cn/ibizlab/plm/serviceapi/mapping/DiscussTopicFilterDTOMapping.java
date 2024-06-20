/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.filter.DiscussTopicSearchContext;
import cn.ibizlab.plm.serviceapi.dto.DiscussTopicFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 话题转换过滤[DiscussTopicFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussTopicFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussTopicFilterDTOMapping extends MappingBase<DiscussTopicFilterDTO, DiscussTopicSearchContext> {

}
