/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.SystemExtensionNotifySetting;
import cn.ibizlab.plm.serviceapi.dto.SystemExtensionNotifySettingDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 通知设置转换[SystemExtensionNotifySettingDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISystemExtensionNotifySettingDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SystemExtensionNotifySettingDTOMapping extends MappingBase<SystemExtensionNotifySettingDTO, SystemExtensionNotifySetting> {


}
