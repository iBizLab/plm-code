/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.SprintCategorySearchContext;
import cn.ibizlab.plm.serviceapi.dto.SprintCategoryFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 迭代类别转换过滤[SprintCategoryFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISprintCategoryFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SprintCategoryFilterDTOMapping extends MappingBase<SprintCategoryFilterDTO, SprintCategorySearchContext> {

}
