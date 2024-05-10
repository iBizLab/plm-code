/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.serviceapi.dto.MemberDefGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 成员转换[MemberDefGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIMemberDefGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MemberDefGroupDTOMapping extends MappingBase<MemberDefGroupDTO, Member> {


}
