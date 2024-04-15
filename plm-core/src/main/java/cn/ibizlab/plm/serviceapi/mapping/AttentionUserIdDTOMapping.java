/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.serviceapi.dto.AttentionUserIdDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 关注转换[AttentionUserIdDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAttentionUserIdDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AttentionUserIdDTOMapping extends MappingBase<AttentionUserIdDTO, Attention> {


}
