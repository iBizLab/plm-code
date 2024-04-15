/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import cn.ibizlab.plm.serviceapi.dto.BaselineFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 基线转换过滤[BaselineFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIBaselineFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselineFilterDTOMapping extends MappingBase<BaselineFilterDTO, BaselineSearchContext> {

}
