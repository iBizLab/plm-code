/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.WorkloadSearchContext;
import cn.ibizlab.plm.serviceapi.dto.WorkloadFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工时转换过滤[WorkloadFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkloadFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkloadFilterDTOMapping extends MappingBase<WorkloadFilterDTO, WorkloadSearchContext> {

}
