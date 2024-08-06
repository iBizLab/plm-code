/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSCorePrdFunc;
import cn.ibizlab.plm.serviceapi.dto.PSCorePrdFuncDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 核心产品功能转换[PSCorePrdFuncDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSCorePrdFuncDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSCorePrdFuncDTOMapping extends MappingBase<PSCorePrdFuncDTO, PSCorePrdFunc> {


}
