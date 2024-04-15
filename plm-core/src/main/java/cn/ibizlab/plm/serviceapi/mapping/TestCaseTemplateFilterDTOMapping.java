/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.TestCaseTemplateSearchContext;
import cn.ibizlab.plm.serviceapi.dto.TestCaseTemplateFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 用例模板转换过滤[TestCaseTemplateFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITestCaseTemplateFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestCaseTemplateFilterDTOMapping extends MappingBase<TestCaseTemplateFilterDTO, TestCaseTemplateSearchContext> {

}
