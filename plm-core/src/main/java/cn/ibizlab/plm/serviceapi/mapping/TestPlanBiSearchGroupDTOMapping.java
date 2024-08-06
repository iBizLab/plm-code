/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.TestPlan;
import cn.ibizlab.plm.serviceapi.dto.TestPlanBiSearchGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 测试计划转换[TestPlanBiSearchGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPITestPlanBiSearchGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestPlanBiSearchGroupDTOMapping extends MappingBase<TestPlanBiSearchGroupDTO, TestPlan> {


}
