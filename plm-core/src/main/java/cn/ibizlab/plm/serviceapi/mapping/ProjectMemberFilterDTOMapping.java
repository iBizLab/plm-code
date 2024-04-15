/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ProjectMemberFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 项目成员转换过滤[ProjectMemberFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProjectMemberFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectMemberFilterDTOMapping extends MappingBase<ProjectMemberFilterDTO, ProjectMemberSearchContext> {

}
