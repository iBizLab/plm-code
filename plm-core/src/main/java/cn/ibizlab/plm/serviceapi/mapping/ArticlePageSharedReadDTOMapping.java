/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.serviceapi.dto.ArticlePageSharedReadDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 页面转换[ArticlePageSharedReadDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIArticlePageSharedReadDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ArticlePageSharedReadDTOMapping extends MappingBase<ArticlePageSharedReadDTO, ArticlePage> {


}
