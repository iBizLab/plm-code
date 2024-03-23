/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDENotifyTarget;
import cn.ibizlab.plm.serviceapi.dto.PSDENotifyTargetDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 消息通知目标转换[PSDENotifyTargetDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDENotifyTargetDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDENotifyTargetDTOMapping extends MappingBase<PSDENotifyTargetDTO, PSDENotifyTarget> {


}
