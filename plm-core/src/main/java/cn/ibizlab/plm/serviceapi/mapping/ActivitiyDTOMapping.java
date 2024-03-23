/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Activitiy;
import cn.ibizlab.plm.serviceapi.dto.ActivitiyDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 活动转换[ActivitiyDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIActivitiyDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ActivitiyDTOMapping extends MappingBase<ActivitiyDTO, Activitiy> {


}
