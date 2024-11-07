/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.ebsx.filter.AppViewThemeSearchContext;
import cn.ibizlab.plm.serviceapi.dto.AppViewThemeFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 应用视图主题转换过滤[AppViewThemeFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAppViewThemeFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AppViewThemeFilterDTOMapping extends MappingBase<AppViewThemeFilterDTO, AppViewThemeSearchContext> {

}
