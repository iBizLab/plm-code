/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.ExtendLogSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ExtendLogFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 扩展日志转换过滤[ExtendLogFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIExtendLogFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExtendLogFilterDTOMapping extends MappingBase<ExtendLogFilterDTO, ExtendLogSearchContext> {

}
