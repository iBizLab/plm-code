/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.AttentionSearchContext;
import cn.ibizlab.plm.serviceapi.dto.AttentionFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 关注转换过滤[AttentionFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAttentionFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AttentionFilterDTOMapping extends MappingBase<AttentionFilterDTO, AttentionSearchContext> {

}
