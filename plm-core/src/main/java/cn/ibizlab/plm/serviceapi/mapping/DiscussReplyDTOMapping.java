/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.domain.DiscussReply;
import cn.ibizlab.plm.serviceapi.dto.DiscussReplyDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 讨论回复转换[DiscussReplyDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussReplyDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussReplyDTOMapping extends MappingBase<DiscussReplyDTO, DiscussReply> {


}
