/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.RecentSearchContext;
import cn.ibizlab.plm.serviceapi.dto.RecentFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 最近访问转换过滤[RecentFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIRecentFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RecentFilterDTOMapping extends MappingBase<RecentFilterDTO, RecentSearchContext> {

}
