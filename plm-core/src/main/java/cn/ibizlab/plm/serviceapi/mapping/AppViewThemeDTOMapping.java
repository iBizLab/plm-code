/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.domain.AppViewTheme;
import cn.ibizlab.plm.serviceapi.dto.AppViewThemeDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 应用视图主题转换[AppViewThemeDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAppViewThemeDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AppViewThemeDTOMapping extends MappingBase<AppViewThemeDTO, AppViewTheme> {


}
