/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.SectionSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SectionFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 分组转换过滤[SectionFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISectionFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SectionFilterDTOMapping extends MappingBase<SectionFilterDTO, SectionSearchContext> {

}
