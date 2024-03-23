/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.VersionSearchContext;
import cn.ibizlab.plm.serviceapi.dto.VersionFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 版本（temp）转换过滤[VersionFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIVersionFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VersionFilterDTOMapping extends MappingBase<VersionFilterDTO, VersionSearchContext> {

}
