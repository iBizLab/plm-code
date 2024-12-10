/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectStateSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ProjectStateFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 项目状态转换过滤[ProjectStateFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProjectStateFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectStateFilterDTOMapping extends MappingBase<ProjectStateFilterDTO, ProjectStateSearchContext> {

}
