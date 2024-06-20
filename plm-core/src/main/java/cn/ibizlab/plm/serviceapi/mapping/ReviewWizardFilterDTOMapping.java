/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewWizardSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ReviewWizardFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评审向导转换过滤[ReviewWizardFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReviewWizardFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewWizardFilterDTOMapping extends MappingBase<ReviewWizardFilterDTO, ReviewWizardSearchContext> {

}
