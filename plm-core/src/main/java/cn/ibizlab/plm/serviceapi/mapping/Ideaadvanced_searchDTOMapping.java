/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.domain.Idea;
import cn.ibizlab.plm.serviceapi.dto.Ideaadvanced_searchDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 需求转换[Ideaadvanced_searchDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIIdeaadvanced_searchDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface Ideaadvanced_searchDTOMapping extends MappingBase<Ideaadvanced_searchDTO, Idea> {


}
