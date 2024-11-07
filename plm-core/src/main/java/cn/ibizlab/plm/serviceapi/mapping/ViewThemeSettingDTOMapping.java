/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.ViewThemeSetting;
import cn.ibizlab.plm.serviceapi.dto.ViewThemeSettingDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 视图主题设置转换[ViewThemeSettingDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIViewThemeSettingDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ViewThemeSettingDTOMapping extends MappingBase<ViewThemeSettingDTO, ViewThemeSetting> {


}
