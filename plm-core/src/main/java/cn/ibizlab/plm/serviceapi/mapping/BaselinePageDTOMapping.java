/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.serviceapi.dto.BaselinePageDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 基线页面转换[BaselinePageDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIBaselinePageDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselinePageDTOMapping extends MappingBase<BaselinePageDTO, BaselinePage> {


}
