/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDEField;
import cn.ibizlab.plm.serviceapi.dto.PSDEFieldDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 实体属性转换[PSDEFieldDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDEFieldDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDEFieldDTOMapping extends MappingBase<PSDEFieldDTO, PSDEField> {


}
