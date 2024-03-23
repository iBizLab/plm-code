/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.filter.StencilSearchContext;
import cn.ibizlab.plm.serviceapi.dto.StencilFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 页面模板转换过滤[StencilFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIStencilFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StencilFilterDTOMapping extends MappingBase<StencilFilterDTO, StencilSearchContext> {

}
