/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.BoardSearchContext;
import cn.ibizlab.plm.serviceapi.dto.BoardFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 看板转换过滤[BoardFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIBoardFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BoardFilterDTOMapping extends MappingBase<BoardFilterDTO, BoardSearchContext> {

}
