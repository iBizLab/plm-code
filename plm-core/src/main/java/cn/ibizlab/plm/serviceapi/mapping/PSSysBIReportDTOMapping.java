/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSSysBIReport;
import cn.ibizlab.plm.serviceapi.dto.PSSysBIReportDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 智能报表转换[PSSysBIReportDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSSysBIReportDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSSysBIReportDTOMapping extends MappingBase<PSSysBIReportDTO, PSSysBIReport> {


}
