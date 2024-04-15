/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext;
import cn.ibizlab.plm.serviceapi.dto.WorkItemTypeFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工作项类型转换过滤[WorkItemTypeFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkItemTypeFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkItemTypeFilterDTOMapping extends MappingBase<WorkItemTypeFilterDTO, WorkItemTypeSearchContext> {

}
