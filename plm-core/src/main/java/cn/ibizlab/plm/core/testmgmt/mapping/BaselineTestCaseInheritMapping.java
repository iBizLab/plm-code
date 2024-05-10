/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities@MINHERIT}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.base.domain.Relation;
import java.util.List;

/**
 * 基线用例继承映射[BaselineTestCase]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaselineTestCaseInheritMapping {

    /**
     * 转换Relation
     * 
     * @param baselineTestCase
     * @return
     */
    @Mappings({
    })
    Relation toRelation(BaselineTestCase baselineTestCase);

    /**
     * 转换 BaselineTestCase
     * 
     * @param relation
     * @return
     */
    @Mappings({
    })
    BaselineTestCase toBaselineTestCase(Relation relation);

}