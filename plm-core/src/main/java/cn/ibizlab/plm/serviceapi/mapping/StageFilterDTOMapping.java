/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext;
import cn.ibizlab.plm.serviceapi.dto.StageFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 发布阶段转换过滤[StageFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIStageFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StageFilterDTOMapping extends MappingBase<StageFilterDTO, StageSearchContext> {

}
