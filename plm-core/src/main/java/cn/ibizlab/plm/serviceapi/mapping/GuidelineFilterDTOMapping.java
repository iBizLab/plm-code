/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.GuidelineSearchContext;
import cn.ibizlab.plm.serviceapi.dto.GuidelineFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 流程准则转换过滤[GuidelineFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIGuidelineFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GuidelineFilterDTOMapping extends MappingBase<GuidelineFilterDTO, GuidelineSearchContext> {

}
