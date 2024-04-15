/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.SearchCommentSearchContext;
import cn.ibizlab.plm.serviceapi.dto.SearchCommentFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评论搜索转换过滤[SearchCommentFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISearchCommentFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SearchCommentFilterDTOMapping extends MappingBase<SearchCommentFilterDTO, SearchCommentSearchContext> {

}
