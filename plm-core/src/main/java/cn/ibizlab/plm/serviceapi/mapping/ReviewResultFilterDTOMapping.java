/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.ReviewResultSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ReviewResultFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 评审结果转换过滤[ReviewResultFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIReviewResultFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewResultFilterDTOMapping extends MappingBase<ReviewResultFilterDTO, ReviewResultSearchContext> {

}
