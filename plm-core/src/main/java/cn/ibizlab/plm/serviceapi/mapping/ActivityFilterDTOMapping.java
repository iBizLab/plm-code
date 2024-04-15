/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.ActivitySearchContext;
import cn.ibizlab.plm.serviceapi.dto.ActivityFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 活动转换过滤[ActivityFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIActivityFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ActivityFilterDTOMapping extends MappingBase<ActivityFilterDTO, ActivitySearchContext> {

}
