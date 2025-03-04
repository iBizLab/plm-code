/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.domain.SysEmployee;
import cn.ibizlab.plm.serviceapi.dto.SysEmployeeDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 人员转换[SysEmployeeDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISysEmployeeDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysEmployeeDTOMapping extends MappingBase<SysEmployeeDTO, SysEmployee> {


}
