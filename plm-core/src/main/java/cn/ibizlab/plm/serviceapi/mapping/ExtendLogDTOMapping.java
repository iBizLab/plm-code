/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.ExtendLog;
import cn.ibizlab.plm.serviceapi.dto.ExtendLogDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 扩展日志转换[ExtendLogDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIExtendLogDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExtendLogDTOMapping extends MappingBase<ExtendLogDTO, ExtendLog> {


}
