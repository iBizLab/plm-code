/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.NotifyEvent;
import cn.ibizlab.plm.serviceapi.dto.NotifyEventDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 通知事件转换[NotifyEventDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPINotifyEventDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface NotifyEventDTOMapping extends MappingBase<NotifyEventDTO, NotifyEvent> {


}
