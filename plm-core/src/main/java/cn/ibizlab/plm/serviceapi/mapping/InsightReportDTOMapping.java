/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.insight.domain.InsightReport;
import cn.ibizlab.plm.serviceapi.dto.InsightReportDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 效能报表转换[InsightReportDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIInsightReportDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InsightReportDTOMapping extends MappingBase<InsightReportDTO, InsightReport> {


}
