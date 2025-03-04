/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.RoleMember;
import cn.ibizlab.plm.serviceapi.dto.RoleMemberDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 系统角色成员转换[RoleMemberDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIRoleMemberDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RoleMemberDTOMapping extends MappingBase<RoleMemberDTO, RoleMember> {


}
