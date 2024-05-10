/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities@MINHERIT}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.base.domain.Relation;
import java.util.List;

/**
 * 基线工作项继承映射[BaselineWorkItem]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselineWorkItemInheritMapping {

    /**
     * 转换Relation
     * 
     * @param baselineWorkItem
     * @return
     */
    @Mappings({
    })
    Relation toRelation(BaselineWorkItem baselineWorkItem);

    /**
     * 转换 BaselineWorkItem
     * 
     * @param relation
     * @return
     */
    @Mappings({
    })
    BaselineWorkItem toBaselineWorkItem(Relation relation);

}