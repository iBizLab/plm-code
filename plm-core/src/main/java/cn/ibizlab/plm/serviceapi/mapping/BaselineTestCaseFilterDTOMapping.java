/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.BaselineTestCaseSearchContext;
import cn.ibizlab.plm.serviceapi.dto.BaselineTestCaseFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 基线用例转换过滤[BaselineTestCaseFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIBaselineTestCaseFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselineTestCaseFilterDTOMapping extends MappingBase<BaselineTestCaseFilterDTO, BaselineTestCaseSearchContext> {

}
