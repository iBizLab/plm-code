/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.ReferencesIndexSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ReferencesIndexFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 引用索引转换过滤[ReferencesIndexFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReferencesIndexFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReferencesIndexFilterDTOMapping extends MappingBase<ReferencesIndexFilterDTO, ReferencesIndexSearchContext> {

}
