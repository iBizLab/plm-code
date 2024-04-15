/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ftr.filter.SearchHubSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SearchHubFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 检索中心转换过滤[SearchHubFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISearchHubFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SearchHubFilterDTOMapping extends MappingBase<SearchHubFilterDTO, SearchHubSearchContext> {

}
