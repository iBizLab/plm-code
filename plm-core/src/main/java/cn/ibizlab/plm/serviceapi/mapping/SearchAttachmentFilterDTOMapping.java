/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.SearchAttachmentSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SearchAttachmentFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 附件搜索转换过滤[SearchAttachmentFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISearchAttachmentFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SearchAttachmentFilterDTOMapping extends MappingBase<SearchAttachmentFilterDTO, SearchAttachmentSearchContext> {

}
