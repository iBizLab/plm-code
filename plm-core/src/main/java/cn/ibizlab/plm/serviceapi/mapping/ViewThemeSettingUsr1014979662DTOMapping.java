/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.ViewThemeSetting;
import cn.ibizlab.plm.serviceapi.dto.ViewThemeSettingUsr1014979662DTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 视图主题设置转换[ViewThemeSettingUsr1014979662DTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIViewThemeSettingUsr1014979662DTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ViewThemeSettingUsr1014979662DTOMapping extends MappingBase<ViewThemeSettingUsr1014979662DTO, ViewThemeSetting> {


}
