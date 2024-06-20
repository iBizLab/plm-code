/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.serviceapi.dto.DiscussPostDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 讨论转换[DiscussPostDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussPostDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussPostDTOMapping extends MappingBase<DiscussPostDTO, DiscussPost> {


}
