/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.insight.filter.InsightMemberSearchContext;
import cn.ibizlab.plm.serviceapi.dto.InsightMemberFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 效能成员转换过滤[InsightMemberFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIInsightMemberFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InsightMemberFilterDTOMapping extends MappingBase<InsightMemberFilterDTO, InsightMemberSearchContext> {

}
