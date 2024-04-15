/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.LoginLog;
import cn.ibizlab.plm.serviceapi.dto.LoginLogDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 登录日志转换[LoginLogDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPILoginLogDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LoginLogDTOMapping extends MappingBase<LoginLogDTO, LoginLog> {


}
