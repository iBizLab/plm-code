/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.AttachmentSearchContext;
import cn.ibizlab.plm.serviceapi.dto.AttachmentFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 附件转换过滤[AttachmentFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAttachmentFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AttachmentFilterDTOMapping extends MappingBase<AttachmentFilterDTO, AttachmentSearchContext> {

}
