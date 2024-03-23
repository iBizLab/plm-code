/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.SprintCategory;
import cn.ibizlab.plm.serviceapi.dto.SprintCategoryDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 迭代类别转换[SprintCategoryDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISprintCategoryDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SprintCategoryDTOMapping extends MappingBase<SprintCategoryDTO, SprintCategory> {


}
