/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.SprintSection;
import cn.ibizlab.plm.serviceapi.dto.SprintSectionDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 迭代分组转换[SprintSectionDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISprintSectionDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SprintSectionDTOMapping extends MappingBase<SprintSectionDTO, SprintSection> {


}
