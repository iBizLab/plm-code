/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Workload;
import cn.ibizlab.plm.serviceapi.dto.WorkloadBiSearchGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 工时转换[WorkloadBiSearchGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIWorkloadBiSearchGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorkloadBiSearchGroupDTOMapping extends MappingBase<WorkloadBiSearchGroupDTO, Workload> {


}
