/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Attention;
import cn.ibizlab.plm.serviceapi.dto.Attentionuser_idDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 关注转换[Attentionuser_idDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIAttentionuser_idDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface Attentionuser_idDTOMapping extends MappingBase<Attentionuser_idDTO, Attention> {


}
