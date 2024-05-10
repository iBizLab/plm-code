/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogAdminSearchContext;
import cn.ibizlab.plm.serviceapi.dto.AuthLogAdminFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 认证日志转换过滤[AuthLogAdminFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAuthLogAdminFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AuthLogAdminFilterDTOMapping extends MappingBase<AuthLogAdminFilterDTO, AuthLogAdminSearchContext> {

}
