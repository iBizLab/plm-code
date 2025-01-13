/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.PositionSearchContext;
import cn.ibizlab.plm.serviceapi.dto.PositionFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 职位转换过滤[PositionFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPositionFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PositionFilterDTOMapping extends MappingBase<PositionFilterDTO, PositionSearchContext> {

}
