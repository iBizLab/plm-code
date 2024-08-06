/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.Release;
import cn.ibizlab.plm.serviceapi.dto.ReleaseBiSearchGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 项目发布转换[ReleaseBiSearchGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReleaseBiSearchGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReleaseBiSearchGroupDTOMapping extends MappingBase<ReleaseBiSearchGroupDTO, Release> {


}
