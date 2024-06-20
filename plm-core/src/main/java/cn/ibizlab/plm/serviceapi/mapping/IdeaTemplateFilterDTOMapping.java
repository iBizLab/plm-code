/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.filter.IdeaTemplateSearchContext;
import cn.ibizlab.plm.serviceapi.dto.IdeaTemplateFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 需求模板转换过滤[IdeaTemplateFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIIdeaTemplateFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdeaTemplateFilterDTOMapping extends MappingBase<IdeaTemplateFilterDTO, IdeaTemplateSearchContext> {

}
