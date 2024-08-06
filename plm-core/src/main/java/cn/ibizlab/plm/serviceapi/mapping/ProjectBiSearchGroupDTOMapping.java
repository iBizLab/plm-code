/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.serviceapi.dto.ProjectBiSearchGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 项目转换[ProjectBiSearchGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProjectBiSearchGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectBiSearchGroupDTOMapping extends MappingBase<ProjectBiSearchGroupDTO, Project> {


}
