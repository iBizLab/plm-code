/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.filter.DiscussPostSearchContext;
import cn.ibizlab.plm.serviceapi.dto.DiscussPostFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 讨论转换过滤[DiscussPostFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussPostFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussPostFilterDTOMapping extends MappingBase<DiscussPostFilterDTO, DiscussPostSearchContext> {

}
