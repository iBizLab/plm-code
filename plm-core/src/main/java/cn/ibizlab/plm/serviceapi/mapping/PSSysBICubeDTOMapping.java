/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSSysBICube;
import cn.ibizlab.plm.serviceapi.dto.PSSysBICubeDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 智能报表立方体转换[PSSysBICubeDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSSysBICubeDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSSysBICubeDTOMapping extends MappingBase<PSSysBICubeDTO, PSSysBICube> {


}
