/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.WorkloadTypeSearchContext;
import cn.ibizlab.plm.serviceapi.dto.WorkloadTypeFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工时类别转换过滤[WorkloadTypeFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkloadTypeFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkloadTypeFilterDTOMapping extends MappingBase<WorkloadTypeFilterDTO, WorkloadTypeSearchContext> {

}
