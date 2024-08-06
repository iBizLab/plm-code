/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.filter.SharedSpaceSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SharedSpaceFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 共享空间转换过滤[SharedSpaceFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISharedSpaceFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SharedSpaceFilterDTOMapping extends MappingBase<SharedSpaceFilterDTO, SharedSpaceSearchContext> {

}
