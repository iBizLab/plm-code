/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.insight.domain.InsightView;
import cn.ibizlab.plm.serviceapi.dto.InsightViewDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 效能视图转换[InsightViewDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIInsightViewDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InsightViewDTOMapping extends MappingBase<InsightViewDTO, InsightView> {


}
