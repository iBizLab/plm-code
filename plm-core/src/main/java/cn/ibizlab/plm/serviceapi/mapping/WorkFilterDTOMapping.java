/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.WorkSearchContext;
import cn.ibizlab.plm.serviceapi.dto.WorkFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工作转换过滤[WorkFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkFilterDTOMapping extends MappingBase<WorkFilterDTO, WorkSearchContext> {

}
