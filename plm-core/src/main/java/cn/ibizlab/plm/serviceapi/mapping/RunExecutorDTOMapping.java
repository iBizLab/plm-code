/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.Run;
import cn.ibizlab.plm.serviceapi.dto.RunExecutorDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 执行用例转换[RunExecutorDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIRunExecutorDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RunExecutorDTOMapping extends MappingBase<RunExecutorDTO, Run> {


}
