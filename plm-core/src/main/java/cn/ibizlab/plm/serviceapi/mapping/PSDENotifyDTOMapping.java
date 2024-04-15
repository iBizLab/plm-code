/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDENotify;
import cn.ibizlab.plm.serviceapi.dto.PSDENotifyDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 实体通知转换[PSDENotifyDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDENotifyDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDENotifyDTOMapping extends MappingBase<PSDENotifyDTO, PSDENotify> {


}
