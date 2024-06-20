/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.ResourceMember;
import cn.ibizlab.plm.serviceapi.dto.ResourceMemberDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 资源组件成员转换[ResourceMemberDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIResourceMemberDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResourceMemberDTOMapping extends MappingBase<ResourceMemberDTO, ResourceMember> {


}
