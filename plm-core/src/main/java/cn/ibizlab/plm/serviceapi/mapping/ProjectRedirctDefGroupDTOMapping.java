/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.serviceapi.dto.ProjectRedirctDefGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 项目转换[ProjectRedirctDefGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProjectRedirctDefGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectRedirctDefGroupDTOMapping extends MappingBase<ProjectRedirctDefGroupDTO, Project> {


}
