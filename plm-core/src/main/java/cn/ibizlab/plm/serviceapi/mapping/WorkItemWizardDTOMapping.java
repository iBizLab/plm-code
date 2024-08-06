/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemWizard;
import cn.ibizlab.plm.serviceapi.dto.WorkItemWizardDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工作项操作向导转换[WorkItemWizardDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkItemWizardDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkItemWizardDTOMapping extends MappingBase<WorkItemWizardDTO, WorkItemWizard> {


}
