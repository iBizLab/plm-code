/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities@MINHERIT}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContent;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend;
import java.util.List;

/**
 * 评审内容继承映射[ReviewContent]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewContentInheritMapping {

    /**
     * 转换Relation
     * 
     * @param reviewContent
     * @return
     */
    @Mappings({
    })
    Relation toRelation(ReviewContent reviewContent);

    /**
     * 转换 ReviewContent
     * 
     * @param relation
     * @return
     */
    @Mappings({
    })
    ReviewContent toReviewContent(Relation relation);
    /**
     * 转换ReviewContentExtend
     * 
     * @param reviewContent
     * @return
     */
    @Mappings({
    })
    ReviewContentExtend toReviewContentExtend(ReviewContent reviewContent);

    /**
     * 转换 ReviewContent
     * 
     * @param reviewContentExtend
     * @return
     */
    @Mappings({
    })
    ReviewContent toReviewContent(ReviewContentExtend reviewContentExtend);

}