/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.InsightSearchContext;
import cn.ibizlab.plm.serviceapi.dto.InsightFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 洞察力转换过滤[InsightFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIInsightFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InsightFilterDTOMapping extends MappingBase<InsightFilterDTO, InsightSearchContext> {

}
