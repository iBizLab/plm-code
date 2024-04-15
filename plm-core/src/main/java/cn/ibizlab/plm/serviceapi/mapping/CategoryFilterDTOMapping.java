/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.CategorySearchContext;
import cn.ibizlab.plm.serviceapi.dto.CategoryFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 类别转换过滤[CategoryFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPICategoryFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoryFilterDTOMapping extends MappingBase<CategoryFilterDTO, CategorySearchContext> {

}
