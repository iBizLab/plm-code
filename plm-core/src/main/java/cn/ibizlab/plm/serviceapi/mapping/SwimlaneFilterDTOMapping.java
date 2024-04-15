/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.SwimlaneSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SwimlaneFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 泳道转换过滤[SwimlaneFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISwimlaneFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SwimlaneFilterDTOMapping extends MappingBase<SwimlaneFilterDTO, SwimlaneSearchContext> {

}
