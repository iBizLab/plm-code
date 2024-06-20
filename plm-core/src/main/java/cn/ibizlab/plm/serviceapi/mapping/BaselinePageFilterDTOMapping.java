/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.filter.BaselinePageSearchContext;
import cn.ibizlab.plm.serviceapi.dto.BaselinePageFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 基线页面转换过滤[BaselinePageFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIBaselinePageFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselinePageFilterDTOMapping extends MappingBase<BaselinePageFilterDTO, BaselinePageSearchContext> {

}
