/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.serviceapi.dto.IdeaDefGroupCommonDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 需求转换[IdeaDefGroupCommonDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIIdeaDefGroupCommonDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdeaDefGroupCommonDTOMapping extends MappingBase<IdeaDefGroupCommonDTO, Idea> {


}
