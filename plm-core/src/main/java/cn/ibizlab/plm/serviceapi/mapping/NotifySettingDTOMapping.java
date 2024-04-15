/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.NotifySetting;
import cn.ibizlab.plm.serviceapi.dto.NotifySettingDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 通知设置转换[NotifySettingDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPINotifySettingDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface NotifySettingDTOMapping extends MappingBase<NotifySettingDTO, NotifySetting> {


}
