/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.TransitionHistorySearchContext;
import cn.ibizlab.plm.serviceapi.dto.TransitionHistoryFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 流转记录转换过滤[TransitionHistoryFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITransitionHistoryFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TransitionHistoryFilterDTOMapping extends MappingBase<TransitionHistoryFilterDTO, TransitionHistorySearchContext> {

}
