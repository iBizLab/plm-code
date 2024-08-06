/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.serviceapi.dto.DynaDashboardExampleChartDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 动态数据看板转换[DynaDashboardExampleChartDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDynaDashboardExampleChartDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DynaDashboardExampleChartDTOMapping extends MappingBase<DynaDashboardExampleChartDTO, DynaDashboard> {


}
