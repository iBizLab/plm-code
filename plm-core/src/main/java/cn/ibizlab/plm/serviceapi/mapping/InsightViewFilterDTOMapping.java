/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.insight.filter.InsightViewSearchContext;
import cn.ibizlab.plm.serviceapi.dto.InsightViewFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 效能视图转换过滤[InsightViewFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIInsightViewFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InsightViewFilterDTOMapping extends MappingBase<InsightViewFilterDTO, InsightViewSearchContext> {

}
