/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;
import cn.ibizlab.plm.serviceapi.dto.TestCaseMaintenanceDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 用例转换[TestCaseMaintenanceDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITestCaseMaintenanceDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestCaseMaintenanceDTOMapping extends MappingBase<TestCaseMaintenanceDTO, TestCase> {


}
