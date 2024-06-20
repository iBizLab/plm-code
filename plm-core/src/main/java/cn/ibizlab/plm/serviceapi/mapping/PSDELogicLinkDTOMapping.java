/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDELogicLink;
import cn.ibizlab.plm.serviceapi.dto.PSDELogicLinkDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 实体处理逻辑链接转换[PSDELogicLinkDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDELogicLinkDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDELogicLinkDTOMapping extends MappingBase<PSDELogicLinkDTO, PSDELogicLink> {


}
