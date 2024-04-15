/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.SearchComment;
import cn.ibizlab.plm.serviceapi.dto.SearchCommentDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评论搜索转换[SearchCommentDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPISearchCommentDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SearchCommentDTOMapping extends MappingBase<SearchCommentDTO, SearchComment> {


}
