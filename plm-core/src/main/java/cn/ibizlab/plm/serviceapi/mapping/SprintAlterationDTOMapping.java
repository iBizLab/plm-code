/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration;
import cn.ibizlab.plm.serviceapi.dto.SprintAlterationDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 迭代变更转换[SprintAlterationDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISprintAlterationDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SprintAlterationDTOMapping extends MappingBase<SprintAlterationDTO, SprintAlteration> {


}
