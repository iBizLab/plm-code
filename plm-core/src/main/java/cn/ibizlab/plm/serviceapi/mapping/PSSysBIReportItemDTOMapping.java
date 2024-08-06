/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSSysBIReportItem;
import cn.ibizlab.plm.serviceapi.dto.PSSysBIReportItemDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 智能报表项转换[PSSysBIReportItemDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSSysBIReportItemDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSSysBIReportItemDTOMapping extends MappingBase<PSSysBIReportItemDTO, PSSysBIReportItem> {


}
