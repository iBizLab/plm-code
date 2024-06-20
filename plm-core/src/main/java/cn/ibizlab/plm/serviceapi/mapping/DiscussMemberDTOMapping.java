/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.domain.DiscussMember;
import cn.ibizlab.plm.serviceapi.dto.DiscussMemberDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 协作成员转换[DiscussMemberDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussMemberDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussMemberDTOMapping extends MappingBase<DiscussMemberDTO, DiscussMember> {


}
