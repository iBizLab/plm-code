/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.GroupSearchContext;
import cn.ibizlab.plm.serviceapi.dto.GroupFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 团队转换过滤[GroupFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIGroupFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GroupFilterDTOMapping extends MappingBase<GroupFilterDTO, GroupSearchContext> {

}
