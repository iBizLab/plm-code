/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItemWizardDetail;
import cn.ibizlab.plm.serviceapi.dto.WorkItemWizardDetailDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工作项操作向导明细转换[WorkItemWizardDetailDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkItemWizardDetailDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkItemWizardDetailDTOMapping extends MappingBase<WorkItemWizardDetailDTO, WorkItemWizardDetail> {


}
