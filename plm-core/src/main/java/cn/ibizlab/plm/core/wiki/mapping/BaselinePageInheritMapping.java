/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities@MINHERIT}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.wiki.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.wiki.domain.BaselinePage;
import cn.ibizlab.plm.core.base.domain.Relation;
import java.util.List;

/**
 * 基线页面继承映射[BaselinePage]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselinePageInheritMapping {

    /**
     * 转换Relation
     * 
     * @param baselinePage
     * @return
     */
    @Mappings({
    })
    Relation toRelation(BaselinePage baselinePage);

    /**
     * 转换 BaselinePage
     * 
     * @param relation
     * @return
     */
    @Mappings({
    })
    BaselinePage toBaselinePage(Relation relation);

}