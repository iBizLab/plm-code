/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.SprintSectionSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SprintSectionFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 迭代分组转换过滤[SprintSectionFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISprintSectionFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SprintSectionFilterDTOMapping extends MappingBase<SprintSectionFilterDTO, SprintSectionSearchContext> {

}
