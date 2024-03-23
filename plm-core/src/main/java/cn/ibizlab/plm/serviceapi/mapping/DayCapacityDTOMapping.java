/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.DayCapacity;
import cn.ibizlab.plm.serviceapi.dto.DayCapacityDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 日容量转换[DayCapacityDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDayCapacityDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DayCapacityDTOMapping extends MappingBase<DayCapacityDTO, DayCapacity> {


}
