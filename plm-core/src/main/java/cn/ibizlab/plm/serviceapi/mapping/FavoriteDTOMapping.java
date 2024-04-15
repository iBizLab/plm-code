/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Favorite;
import cn.ibizlab.plm.serviceapi.dto.FavoriteDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 收藏转换[FavoriteDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIFavoriteDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FavoriteDTOMapping extends MappingBase<FavoriteDTO, Favorite> {


}
