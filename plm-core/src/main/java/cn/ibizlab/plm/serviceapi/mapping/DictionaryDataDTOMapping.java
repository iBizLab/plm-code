/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.DictionaryData;
import cn.ibizlab.plm.serviceapi.dto.DictionaryDataDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 数据字典转换[DictionaryDataDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDictionaryDataDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DictionaryDataDTOMapping extends MappingBase<DictionaryDataDTO, DictionaryData> {


}
