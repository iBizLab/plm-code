/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import cn.ibizlab.plm.serviceapi.dto.WorkItemusuallyDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工作项转换[WorkItemusuallyDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkItemusuallyDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkItemusuallyDTOMapping extends MappingBase<WorkItemusuallyDTO, WorkItem> {

    @Override
    @Mappings({
            @Mapping(source="reappearProbability", target="reappearProbability"),
            @Mapping(source="severity", target="severity"),
    })
    WorkItem toDomain(WorkItemusuallyDTO dto);

    @Override
    @Mappings({
            @Mapping(source="reappearProbability", target="reappearProbability"),
            @Mapping(source="severity", target="severity"),
    })
    WorkItemusuallyDTO toDto(WorkItem entity);

}
