/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSSysBICubeMeasure;
import cn.ibizlab.plm.serviceapi.dto.PSSysBICubeMeasureDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 智能报表立方体指标转换[PSSysBICubeMeasureDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSSysBICubeMeasureDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSSysBICubeMeasureDTOMapping extends MappingBase<PSSysBICubeMeasureDTO, PSSysBICubeMeasure> {


}
