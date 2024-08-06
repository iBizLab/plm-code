/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.serviceapi.dto.TestCaseBiSearchGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 用例转换[TestCaseBiSearchGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITestCaseBiSearchGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestCaseBiSearchGroupDTOMapping extends MappingBase<TestCaseBiSearchGroupDTO, TestCase> {


}
