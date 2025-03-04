/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Organization;
import cn.ibizlab.plm.serviceapi.dto.OrganizationDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 组织转换[OrganizationDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIOrganizationDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrganizationDTOMapping extends MappingBase<OrganizationDTO, Organization> {


}
