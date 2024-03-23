/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.EntrySearchContext;
import cn.ibizlab.plm.serviceapi.dto.EntryFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 看板栏转换过滤[EntryFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIEntryFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EntryFilterDTOMapping extends MappingBase<EntryFilterDTO, EntrySearchContext> {

}
