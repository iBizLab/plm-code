/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.MSValueProxy;
import cn.ibizlab.plm.serviceapi.dto.MsValueProxyDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 主状态值代理转换[MsValueProxyDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIMsValueProxyDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MsValueProxyDTOMapping extends MappingBase<MsValueProxyDTO, MSValueProxy> {


}
