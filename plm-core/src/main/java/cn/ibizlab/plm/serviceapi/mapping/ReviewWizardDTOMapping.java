/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard;
import cn.ibizlab.plm.serviceapi.dto.ReviewWizardDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评审向导转换[ReviewWizardDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReviewWizardDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewWizardDTOMapping extends MappingBase<ReviewWizardDTO, ReviewWizard> {


}
