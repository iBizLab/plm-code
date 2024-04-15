/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseSearchContext;
import cn.ibizlab.plm.serviceapi.dto.TestCaseFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 用例转换过滤[TestCaseFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITestCaseFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestCaseFilterDTOMapping extends MappingBase<TestCaseFilterDTO, TestCaseSearchContext> {

}
