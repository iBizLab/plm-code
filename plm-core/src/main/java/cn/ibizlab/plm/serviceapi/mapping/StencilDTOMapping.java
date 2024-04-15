/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.domain.Stencil;
import cn.ibizlab.plm.serviceapi.dto.StencilDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 页面模板转换[StencilDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIStencilDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StencilDTOMapping extends MappingBase<StencilDTO, Stencil> {


}
