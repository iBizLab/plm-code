/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.DictionaryDataSearchContext;
import cn.ibizlab.plm.serviceapi.dto.DictionaryDataFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 数据字典转换过滤[DictionaryDataFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDictionaryDataFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DictionaryDataFilterDTOMapping extends MappingBase<DictionaryDataFilterDTO, DictionaryDataSearchContext> {

}
