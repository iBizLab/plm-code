/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.CommentSearchContext;
import cn.ibizlab.plm.serviceapi.dto.CommentFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评论转换过滤[CommentFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPICommentFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CommentFilterDTOMapping extends MappingBase<CommentFilterDTO, CommentSearchContext> {

}
