/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.serviceapi.dto.WorkItemCreatePlanSnapshotDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工作项转换[WorkItemCreatePlanSnapshotDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkItemCreatePlanSnapshotDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkItemCreatePlanSnapshotDTOMapping extends MappingBase<WorkItemCreatePlanSnapshotDTO, WorkItem> {


}
