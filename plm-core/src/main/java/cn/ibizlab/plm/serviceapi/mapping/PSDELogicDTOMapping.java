/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDELogic;
import cn.ibizlab.plm.serviceapi.dto.PSDELogicDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 实体处理逻辑转换[PSDELogicDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDELogicDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDELogicDTOMapping extends MappingBase<PSDELogicDTO, PSDELogic> {


}
