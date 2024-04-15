/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemStateSearchContext;
import cn.ibizlab.plm.serviceapi.dto.WorkItemStateFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工作项状态转换过滤[WorkItemStateFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkItemStateFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkItemStateFilterDTOMapping extends MappingBase<WorkItemStateFilterDTO, WorkItemStateSearchContext> {

}
