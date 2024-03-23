/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.ActivitiySearchContext;
import cn.ibizlab.plm.serviceapi.dto.ActivitiyFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 活动转换过滤[ActivitiyFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIActivitiyFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ActivitiyFilterDTOMapping extends MappingBase<ActivitiyFilterDTO, ActivitiySearchContext> {

}
