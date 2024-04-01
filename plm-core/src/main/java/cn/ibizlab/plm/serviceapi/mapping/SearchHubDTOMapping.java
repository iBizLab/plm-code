/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ftr.domain.SearchHub;
import cn.ibizlab.plm.serviceapi.dto.SearchHubDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 检索中心转换[SearchHubDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISearchHubDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SearchHubDTOMapping extends MappingBase<SearchHubDTO, SearchHub> {


}
