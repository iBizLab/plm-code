/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext;
import cn.ibizlab.plm.serviceapi.dto.RunFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 执行用例转换过滤[RunFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIRunFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RunFilterDTOMapping extends MappingBase<RunFilterDTO, RunSearchContext> {

}
