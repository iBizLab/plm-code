/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.FavoriteSearchContext;
import cn.ibizlab.plm.serviceapi.dto.FavoriteFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 收藏转换过滤[FavoriteFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIFavoriteFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FavoriteFilterDTOMapping extends MappingBase<FavoriteFilterDTO, FavoriteSearchContext> {

}
