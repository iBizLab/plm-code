/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.serviceapi.dto.IdeaAdvancedSearchDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 需求转换[IdeaAdvancedSearchDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIIdeaAdvancedSearchDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdeaAdvancedSearchDTOMapping extends MappingBase<IdeaAdvancedSearchDTO, Idea> {


}
