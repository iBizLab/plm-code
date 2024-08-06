/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.SprintAlterationSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SprintAlterationFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 迭代变更转换过滤[SprintAlterationFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISprintAlterationFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SprintAlterationFilterDTOMapping extends MappingBase<SprintAlterationFilterDTO, SprintAlterationSearchContext> {

}
