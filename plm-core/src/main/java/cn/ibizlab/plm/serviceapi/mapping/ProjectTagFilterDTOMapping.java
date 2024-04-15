/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectTagSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ProjectTagFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 项目标签转换过滤[ProjectTagFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProjectTagFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectTagFilterDTOMapping extends MappingBase<ProjectTagFilterDTO, ProjectTagSearchContext> {

}
