/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.domain.AuthLogAdmin;
import cn.ibizlab.plm.serviceapi.dto.AuthLogAdminDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 认证日志转换[AuthLogAdminDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAuthLogAdminDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AuthLogAdminDTOMapping extends MappingBase<AuthLogAdminDTO, AuthLogAdmin> {


}
