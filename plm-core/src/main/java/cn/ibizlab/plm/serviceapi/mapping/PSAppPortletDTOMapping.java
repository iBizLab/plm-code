/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSAppPortlet;
import cn.ibizlab.plm.serviceapi.dto.PSAppPortletDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 应用门户部件转换[PSAppPortletDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSAppPortletDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSAppPortletDTOMapping extends MappingBase<PSAppPortletDTO, PSAppPortlet> {


}
