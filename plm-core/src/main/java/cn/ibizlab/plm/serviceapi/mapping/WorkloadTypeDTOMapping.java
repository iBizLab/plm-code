/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.WorkloadType;
import cn.ibizlab.plm.serviceapi.dto.WorkloadTypeDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工时类别转换[WorkloadTypeDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkloadTypeDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkloadTypeDTOMapping extends MappingBase<WorkloadTypeDTO, WorkloadType> {


}
