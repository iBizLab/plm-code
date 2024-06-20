/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.AddonRoleMember;
import cn.ibizlab.plm.serviceapi.dto.AddonRoleMemberDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 组件权限成员转换[AddonRoleMemberDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAddonRoleMemberDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddonRoleMemberDTOMapping extends MappingBase<AddonRoleMemberDTO, AddonRoleMember> {


}
