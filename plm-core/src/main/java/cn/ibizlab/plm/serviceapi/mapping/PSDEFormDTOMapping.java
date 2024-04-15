/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDEForm;
import cn.ibizlab.plm.serviceapi.dto.PSDEFormDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 实体表单转换[PSDEFormDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDEFormDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDEFormDTOMapping extends MappingBase<PSDEFormDTO, PSDEForm> {


}
