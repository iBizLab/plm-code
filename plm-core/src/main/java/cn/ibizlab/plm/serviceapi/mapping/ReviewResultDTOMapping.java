/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.ReviewResult;
import cn.ibizlab.plm.serviceapi.dto.ReviewResultDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评审结果转换[ReviewResultDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReviewResultDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewResultDTOMapping extends MappingBase<ReviewResultDTO, ReviewResult> {


}
