/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities@MINHERIT}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.base.domain.Relation;
import java.util.List;

/**
 * 基线需求继承映射[BaselineIdea]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselineIdeaInheritMapping {

    /**
     * 转换Relation
     * 
     * @param baselineIdea
     * @return
     */
    @Mappings({
    })
    Relation toRelation(BaselineIdea baselineIdea);

    /**
     * 转换 BaselineIdea
     * 
     * @param relation
     * @return
     */
    @Mappings({
    })
    BaselineIdea toBaselineIdea(Relation relation);

}