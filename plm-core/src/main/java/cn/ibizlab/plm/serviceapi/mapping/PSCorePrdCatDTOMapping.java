/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSCorePrdCat;
import cn.ibizlab.plm.serviceapi.dto.PSCorePrdCatDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 核心产品分类转换[PSCorePrdCatDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSCorePrdCatDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSCorePrdCatDTOMapping extends MappingBase<PSCorePrdCatDTO, PSCorePrdCat> {


}
