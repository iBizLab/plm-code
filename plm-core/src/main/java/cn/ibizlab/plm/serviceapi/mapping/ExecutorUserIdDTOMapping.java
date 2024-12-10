/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Executor;
import cn.ibizlab.plm.serviceapi.dto.ExecutorUserIdDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 执行人转换[ExecutorUserIdDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIExecutorUserIdDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExecutorUserIdDTOMapping extends MappingBase<ExecutorUserIdDTO, Executor> {


}
