/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewStage;
import cn.ibizlab.plm.serviceapi.dto.ReviewStageDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评审阶段转换[ReviewStageDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReviewStageDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewStageDTOMapping extends MappingBase<ReviewStageDTO, ReviewStage> {


}
