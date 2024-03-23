/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Dynadashboard;
import cn.ibizlab.plm.serviceapi.dto.DynadashboardDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 动态数据看板转换[DynadashboardDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDynadashboardDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DynadashboardDTOMapping extends MappingBase<DynadashboardDTO, Dynadashboard> {


}
