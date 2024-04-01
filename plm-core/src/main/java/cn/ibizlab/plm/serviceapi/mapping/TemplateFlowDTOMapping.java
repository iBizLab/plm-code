/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.TemplateFlow;
import cn.ibizlab.plm.serviceapi.dto.TemplateFlowDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 规则模板转换[TemplateFlowDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITemplateFlowDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TemplateFlowDTOMapping extends MappingBase<TemplateFlowDTO, TemplateFlow> {


}
