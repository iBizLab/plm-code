/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.serviceapi.dto.DiscussTopicDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 话题转换[DiscussTopicDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussTopicDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussTopicDTOMapping extends MappingBase<DiscussTopicDTO, DiscussTopic> {


}
