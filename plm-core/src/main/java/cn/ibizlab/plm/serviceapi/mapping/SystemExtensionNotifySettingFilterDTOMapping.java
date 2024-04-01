/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.filter.SystemExtensionNotifySettingSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SystemExtensionNotifySettingFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 通知设置转换过滤[SystemExtensionNotifySettingFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISystemExtensionNotifySettingFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SystemExtensionNotifySettingFilterDTOMapping extends MappingBase<SystemExtensionNotifySettingFilterDTO, SystemExtensionNotifySettingSearchContext> {

}
