/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.domain.PageVersion;
import cn.ibizlab.plm.serviceapi.dto.PageVersionDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 页面版本转换[PageVersionDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPageVersionDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PageVersionDTOMapping extends MappingBase<PageVersionDTO, PageVersion> {


}
