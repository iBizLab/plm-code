/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.TestSuiteSearchContext;
import cn.ibizlab.plm.serviceapi.dto.TestSuiteFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 用例模块转换过滤[TestSuiteFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITestSuiteFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestSuiteFilterDTOMapping extends MappingBase<TestSuiteFilterDTO, TestSuiteSearchContext> {

}
