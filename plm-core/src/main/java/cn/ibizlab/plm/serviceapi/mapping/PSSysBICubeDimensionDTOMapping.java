/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSSysBICubeDimension;
import cn.ibizlab.plm.serviceapi.dto.PSSysBICubeDimensionDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 智能报表立方体维度转换[PSSysBICubeDimensionDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSSysBICubeDimensionDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSSysBICubeDimensionDTOMapping extends MappingBase<PSSysBICubeDimensionDTO, PSSysBICubeDimension> {


}
