/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.serviceapi.dto.DynaDashboardDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 动态数据看板转换[DynaDashboardDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDynaDashboardDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DynaDashboardDTOMapping extends MappingBase<DynaDashboardDTO, DynaDashboard> {


}
