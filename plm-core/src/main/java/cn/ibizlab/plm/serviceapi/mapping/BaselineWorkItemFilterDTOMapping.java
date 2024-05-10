/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.BaselineWorkItemSearchContext;
import cn.ibizlab.plm.serviceapi.dto.BaselineWorkItemFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 基线工作项转换过滤[BaselineWorkItemFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIBaselineWorkItemFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselineWorkItemFilterDTOMapping extends MappingBase<BaselineWorkItemFilterDTO, BaselineWorkItemSearchContext> {

}
