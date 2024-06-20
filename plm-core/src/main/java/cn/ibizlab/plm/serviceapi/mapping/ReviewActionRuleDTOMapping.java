/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewActionRule;
import cn.ibizlab.plm.serviceapi.dto.ReviewActionRuleDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评审后置动作转换[ReviewActionRuleDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReviewActionRuleDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewActionRuleDTOMapping extends MappingBase<ReviewActionRuleDTO, ReviewActionRule> {


}
