/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.ExecutorSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ExecutorFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 执行人转换过滤[ExecutorFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIExecutorFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExecutorFilterDTOMapping extends MappingBase<ExecutorFilterDTO, ExecutorSearchContext> {

}
