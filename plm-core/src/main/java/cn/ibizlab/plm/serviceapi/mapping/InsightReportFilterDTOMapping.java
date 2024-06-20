/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.insight.filter.InsightReportSearchContext;
import cn.ibizlab.plm.serviceapi.dto.InsightReportFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 效能报表转换过滤[InsightReportFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIInsightReportFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InsightReportFilterDTOMapping extends MappingBase<InsightReportFilterDTO, InsightReportSearchContext> {

}
