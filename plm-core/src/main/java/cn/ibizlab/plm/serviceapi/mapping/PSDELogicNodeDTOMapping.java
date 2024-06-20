/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDELogicNode;
import cn.ibizlab.plm.serviceapi.dto.PSDELogicNodeDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 实体处理逻辑节点转换[PSDELogicNodeDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDELogicNodeDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDELogicNodeDTOMapping extends MappingBase<PSDELogicNodeDTO, PSDELogicNode> {


}
