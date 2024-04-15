/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.SearchAttachment;
import cn.ibizlab.plm.serviceapi.dto.SearchAttachmentDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 附件搜索转换[SearchAttachmentDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISearchAttachmentDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SearchAttachmentDTOMapping extends MappingBase<SearchAttachmentDTO, SearchAttachment> {


}
